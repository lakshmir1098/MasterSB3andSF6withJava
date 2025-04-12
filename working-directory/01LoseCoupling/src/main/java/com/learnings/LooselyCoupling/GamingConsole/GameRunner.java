package com.learnings.LooselyCoupling.GamingConsole;

public class GameRunner {
     private final GameConsole gc;

     public GameRunner(GameConsole gc){
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
