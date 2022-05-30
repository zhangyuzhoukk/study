package com.example.study.entity.employee;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
* @description: 账号实体类
* @author zyz
* @date 2022/5/30 0:15
* @version 1.0
*/
@Data/*原来是这个类加了@Data注解，所有Java代码中不需要⽣成getter and setter，⽽在编译的时候会⾃动⽣成getter and setter。
        加了@Data注解的类，编译后会⾃动给我们加上下列⽅法：
        所有属性的get和set⽅法
        toString ⽅法
        hashCode⽅法
        equals⽅法*/
@EqualsAndHashCode(callSuper = false) /*首先 @EqualsAndHashCode 标在子类上
                                            1.true的话当两个子类对象比较时,子类和继承的父类的字段的值都相同,equals返回的true
                                            2.false的话当两个子类对象比较时,子类值相同,equals返回的true*/
@Accessors(chain = true)    /*用来配置lombok如何产生和显示getters和setters的方法
                            1.fluent为一个布尔值，如果为true生成的get/set方法则没有set/get前缀,num生成的get方法为num()，而不是getNum()
                            2.chain为一个布尔值，如果为true生成的set方法返回this，为false生成的set方法是void类型。默认为false，除非当fluent为true时，chain默认则为true。可以实现链式编程,例如user.setName("张三").setAge(12).setHeight(175)
                            3.prefix为一系列string类型，可以指定前缀，生成get/set方法时会去掉指定的前缀如@Accessors(prefix = "m") mnum 生成的get方法为getNum()，而不是getMNum()*/
@TableName("account") /*该注解主要是现实实体类型和数据库中的表实现映射。*/
public class Account extends Model<Account> {
    //用来序列的标识符/反序列化的对象序列化类。
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;//默认为null ,所以没有值的时候也不会报错

    /**
     * 姓名
     */
    @TableField("name")
    private String name;
    /**
     * 公司
     */
    @TableField("company")
    private String company;
    /**
     * 工号
     */
    @TableField("code")
    private String code;
    /**
     * 职位
     */
    @TableField("position")
    private String position;
    /**
     * 职级
     */
    @TableField("rank")
    private String rank;
    /**
     * 账号
     */
    @TableField("account_str")
    private String account_str;
    /**
     * 密码
     */
    @TableField("password_str")
    private String password_str;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}