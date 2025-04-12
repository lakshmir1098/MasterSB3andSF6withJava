package com.learnings.copyapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class CopyapplicationApplication {

	public static void main(String[] args) {

		var context = new AnnotationConfigApplicationContext(CopyapplicationApplication.class);

	}

}
