package com.learnings.SpringIntro.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


@Configuration
public class HelloWorldConfiguration {
    @Bean
    public String name() {
        return "Lakshmi";
    }

    @Bean
    public int age(){
        return 26;
    }

    @Bean(name = "person1")
    @Primary
    public Person person1() {
        return new Person("Person1", 52, new Address("Block A", "New Mumbai"));
    }

    @Bean
    @Primary
    public Address address1(){
        return new Address ("Block A1", "New Delhi");
    }

    @Bean
    public Address address2(){
        return new Address ("Block B", "New Delhi");
    }

    @Bean
    public Person person2ndway(){
        return new Person(name(), age(), address2() );
    }


    @Bean (name = "address3")  // Bean name is address3 and Java method name is address3()
    public Address address3(){
        return new Address ("Block C", "Kolkata");
    }

    @Bean
    public Person person3rdway(String name, int age,  Address address3){
        return new Person(name ,  age, address3);
    }
}
