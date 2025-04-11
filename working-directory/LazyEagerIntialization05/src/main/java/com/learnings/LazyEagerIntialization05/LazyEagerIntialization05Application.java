package com.learnings.LazyEagerIntialization05;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
/** Eager Intialization **/
class A{
	public A() {
		System.out.println("I'm in class A");
	}
}

@Component
@Lazy
/** Lazy Intialization **/
class B{
	private A classA;
	public B( A classA) {
		this.classA =classA;
		System.out.println("I'm in class B");
	}
}

@Configuration
@ComponentScan
public class LazyEagerIntialization05Application {

	public static void main(String[] args) {
		var context = new AnnotationConfigApplicationContext(LazyEagerIntialization05Application.class);
		System.out.println(context.getBean(B));
	}

}
