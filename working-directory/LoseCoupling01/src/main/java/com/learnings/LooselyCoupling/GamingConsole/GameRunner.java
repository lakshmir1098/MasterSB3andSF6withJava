package com.learnings.MasteringSpring.LooselyCoupling.GamingConsole;

public class GameRunner {
     private com.learnings.MasteringSpring.LooselyCoupling01.GamingConsole.GameConsole gc;

     public GameRunner(com.learnings.MasteringSpring.LooselyCoupling01.GamingConsole.GameConsole gc){
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
