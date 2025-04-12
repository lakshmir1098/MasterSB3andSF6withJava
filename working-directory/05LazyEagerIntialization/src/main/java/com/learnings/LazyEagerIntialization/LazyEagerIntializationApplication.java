package com.learnings.LazyEagerIntialization;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;


/** Eager Intialization **/
@Component
class A{
	public A() {
		System.out.println("I'm in class A");
	}
}

/** Lazy Intialization **/
@Component
@Lazy
class B{
	private A classA;
	public B( A classA) {
		this.classA =classA;
		System.out.println("I'm in class B");
	}
}

@Configuration
@ComponentScan
public class LazyEagerIntializationApplication {

	public static void main(String[] args) {
		var context = new AnnotationConfigApplicationContext(LazyEagerIntializationApplication.class);
		//System.out.println(context.getBean(B.class));
	}

}
