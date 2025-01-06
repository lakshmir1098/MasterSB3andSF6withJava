package com.learnings.SpringNextStep.DependencyInj;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component("Engine2")
class EngineS {
        public void start() {
                System.out.println("Engine2 started!");
        }
}

@Component("Car2")
class CarS {
        private EngineS engine;

        // Dependency injected via setter
        @Autowired
        public void setEngine(EngineS engine) {
                this.engine = engine;
        }

        public void drive() {
                engine.start();
                System.out.println("Car2 is moving!");
        }
}

@Configuration
@ComponentScan
public class SetterDI {
        public static void main(String[] args) {
                var context = new AnnotationConfigApplicationContext(SetterDI.class);

                CarS car = context.getBean(CarS.class);
                car.drive();

                context.close();
        }
}

