package com.learnings.SpringNextStep.Gamer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {
    @Autowired
    public  final GameConsole gc;

    public GameRunner(GameConsole gc) {
        this.gc = gc;
    }


    public void run (){
            System.out.println(" Running  Game .......");
            gc.up();
            gc.down();
            gc.right();
            gc.left();
        }
}

