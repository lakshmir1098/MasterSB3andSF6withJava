package com.learnings.DependencyInj.DependencyInj;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component("Engine1")
class EngineC {
        public void start() {
                System.out.println("Engine1 started!");
        }
}

@Component("Car1")
class CarC {
        private final EngineC engine;

        // Dependency injected via constructor
        @Autowired
        public CarC(EngineC engine) {
                this.engine = engine;
        }

        public void drive() {
                engine.start();
                System.out.println("Car1 is moving!");
        }
}

@Configuration
@ComponentScan
public class ConstructorDI {
        public static void main(String[] args) {
                var context = new AnnotationConfigApplicationContext(ConstructorDI.class);
                CarC car = context.getBean(CarC.class);
                car.drive();
                context.close();
        }
}

