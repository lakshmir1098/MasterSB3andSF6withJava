package com.learnings.prepost;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
class A{
	public A() {
		System.out.println("I'm in class A");
	}

	public void run()
	{
		System.out.println("Running class A");
	}

	public void clean(){
		System.out.println("Final clean up");
	}
}


@Component
class B{
	private A classA;
	public B( A classA) {
		this.classA =classA;
		System.out.println("I'm in class B");
	}

	@PostConstruct
	public void intial(){
		classA.run();
	}

	@PreDestroy
	public void complete(){
		classA.clean();
	}
}

@Configuration
@ComponentScan
public class PrePostInstanceApplication {

	public static void main(String[] args) {

		new AnnotationConfigApplicationContext(PrePostInstanceApplication.class);


	}

}
