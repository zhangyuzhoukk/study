package com.example.study;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j//lombok提供的日志注解
@SpringBootApplication//springboot启动类
public class StudyApplication {

	public static void main(String[] args)  {
		SpringApplication.run(StudyApplication.class, args);
		log.info("项目启动成功");
	}

}
