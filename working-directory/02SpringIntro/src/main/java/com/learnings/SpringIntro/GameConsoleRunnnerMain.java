package com.learnings.SpringIntro;


import com.learnings.SpringIntro.Gamer.GameConsole;
import com.learnings.SpringIntro.GamerConfiguration.GameConsoleConfiguration;
import com.learnings.SpringIntro.Gamer.GameRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class GameConsoleRunnnerMain {
    public static  void main (String args[]){
        var context =  new AnnotationConfigApplicationContext(GameConsoleConfiguration.class);
        System.out.println("List of Beans :" + String.join("\n ", context.getBeanDefinitionNames()));
        try(context){
            context.getBean(GameConsole.class).up();
            context.getBean(GameRunner.class).run();
        }
    }
}
