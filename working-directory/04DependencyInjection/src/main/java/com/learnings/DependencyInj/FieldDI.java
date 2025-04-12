package com.learnings.DependencyInj.DependencyInj;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component("Engine3")
class EngineF {
        public void start() {
                System.out.println("Engine3 started!");
        }
}

@Component("Car3")
class CarF {
        @Autowired // Dependency injected directly into the field
        private EngineF engine;

        public void drive() {
                engine.start();
                System.out.println("Car3 is moving!");
        }
}

@Configuration
@ComponentScan
public class FieldDI {
        public static void main(String[] args) {
                var context = new AnnotationConfigApplicationContext(FieldDI.class);

                CarF car = context.getBean(CarF.class);
                car.drive();
                
                context.close();
        }
}

