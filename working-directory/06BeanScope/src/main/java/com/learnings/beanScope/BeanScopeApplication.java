package com.learnings.beanScope;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//Singleton scope
@Component
class NormalClass{

}

//Prototype scope
@Component
@Scope("prototype")
class prototypeClass{

}

@Configuration
@ComponentScan
public class BeanScopeApplication {

	public static void main(String[] args) {

		var context = new AnnotationConfigApplicationContext(BeanScopeApplication.class);
		System.out.println(context.getBean(NormalClass.class));
		System.out.println(context.getBean(NormalClass.class));
		System.out.println(context.getBean(NormalClass.class));
		System.out.println(context.getBean(NormalClass.class));
		/* OUTPUT:
			com.learnings.beanScope.NormalClass@22555ebf
			com.learnings.beanScope.NormalClass@22555ebf
			com.learnings.beanScope.NormalClass@22555ebf
			com.learnings.beanScope.NormalClass@22555ebf
		 */

		System.out.println(context.getBean(prototypeClass.class));
		System.out.println(context.getBean(prototypeClass.class));
		System.out.println(context.getBean(prototypeClass.class));
		System.out.println(context.getBean(prototypeClass.class));
		/* OUTPUT:
			com.learnings.beanScope.prototypeClass@36ebc363
			com.learnings.beanScope.prototypeClass@34e9fd99
			com.learnings.beanScope.prototypeClass@45752059
			com.learnings.beanScope.prototypeClass@3c41ed1d
		 */
	}

}
