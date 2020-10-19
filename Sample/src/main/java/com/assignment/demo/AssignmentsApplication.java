package com.assignment.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication(scanBasePackages={
"com.assignment.demo"})

public class AssignmentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssignmentsApplication.class, args);
	}

}
