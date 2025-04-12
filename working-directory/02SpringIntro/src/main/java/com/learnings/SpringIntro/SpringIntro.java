package com.learnings.SpringIntro;


import com.learnings.SpringIntro.Configuration.Address;
import com.learnings.SpringIntro.Configuration.HelloWorldConfiguration;
import com.learnings.SpringIntro.Configuration.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import java.util.Arrays;

public class SpringIntro {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
        System.out.println(context.getBean("name"));
        System.out.println("Person1: " + context.getBean("person1"));
        System.out.println("Person2: " +context.getBean("person2ndway"));
        System.out.println("Person3: " +context.getBean("person3rdway"));
        System.out.println(context.getBean("address1"));
        System.out.println(context.getBean("address3"));
        System.out.println("Address class : " +context.getBean(Address.class));
        System.out.println("Person class: " +context.getBean(Person.class));
        // cant use this as we have more than one Person Bean person1, person2, person3 being used. This we can overcome by making one of them Primary
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

    }

}
