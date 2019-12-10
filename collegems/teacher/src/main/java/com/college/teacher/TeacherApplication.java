package com.college.teacher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages="com.college.*")
@SpringBootApplication
public class TeacherApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(TeacherApplication.class, args);
	}

}
