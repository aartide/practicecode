package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableJpaRepositories
@ComponentScan(basePackages = "com.example.demo")
public class MyFirstDbProject1Application {

	public static void main(String[] args) {
		SpringApplication.run(MyFirstDbProject1Application.class, args);
	}

}
