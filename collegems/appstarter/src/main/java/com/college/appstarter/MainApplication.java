package com.college.appstarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages="com.college.*")
@SpringBootApplication
public class MainApplication  {

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

}
