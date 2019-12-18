package com.college.servicediscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@ComponentScan(basePackages = "com.college.servicediscovery.*")
@SpringBootApplication
@EnableEurekaServer
@EnableAdminServer
public class SpringEurekaServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringEurekaServerApplication.class, args);
	}
}
