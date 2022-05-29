package com.example.study;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j//lombok提供的日志注解
@SpringBootApplication//springboot启动类
public class StudyApplication {

	public static void main(String[] args) throws ClassNotFoundException {
		Student s1 = new Student();
		Student s2 = new Student();
		Class s3 = Student.class;
		Class s4 = Class.forName("com.example.study.Student");
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		System.out.println(s3.hashCode());
		System.out.println(s4.hashCode());



//		SpringApplication.run(StudyApplication.class, args);
//		log.info("项目启动成功");
	}

}
