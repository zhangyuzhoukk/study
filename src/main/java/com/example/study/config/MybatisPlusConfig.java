package com.example.study.config;


import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.example.study.config.datasource.DynamicDataSource;
import com.example.study.enums.DBTypeEnum;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.util.HashMap;
import java.util.Map;

@Configuration
@MapperScan("com.example.study.mapper*")
public class MybatisPlusConfig implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    @Value("${mybatis-plus.mapper-locations}")
    private String mapperLocations;

    /**
     * mybatis-plus分页插件<br>
     * 文档：http://mp.baomidou.com<br>
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    @Bean(name = "business")
    @ConfigurationProperties(prefix = "spring.datasource.druid.business")
    public DataSource business(){
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "employee")
    @ConfigurationProperties(prefix = "spring.datasource.druid.employee")
    public DataSource employee(){
        return DruidDataSourceBuilder.create().build();
    }
    /**
     * 动态配置数据源
     */
    @Bean
    @Primary //设置更高的优先级             @Qualifier 按名称装配
    public DataSource mutipleDataSource(@Qualifier("business") DataSource business,@Qualifier("employee") DataSource employee){
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        Map<Object, Object> targetDataSources = new HashMap<>(16);
        targetDataSources.put(DBTypeEnum.business.getValue(), business);
        targetDataSources.put(DBTypeEnum.employee.getValue(), employee);

        return  dynamicDataSource;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }
}
