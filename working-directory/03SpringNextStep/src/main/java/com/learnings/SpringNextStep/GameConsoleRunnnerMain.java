package com.learnings.SpringNextStep;


import com.learnings.SpringNextStep.Gamer.Game02;
import com.learnings.SpringNextStep.Gamer.GameRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.learnings.SpringNextStep.Gamer")
public class GameConsoleRunnnerMain {

    public static  void main (String args[]){
        var context =  new AnnotationConfigApplicationContext(GameConsoleRunnnerMain.class);
        try(context){
            context.getBean(GameRunner.class).run();
            context.getBean(Game02.class).jump();
        }
    }
}
