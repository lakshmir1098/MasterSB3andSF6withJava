package com.learnings.SpringIntro.Gamer;


import com.learnings.SpringIntro.Gamer.GameConsole;

public class GameRunner {
     private GameConsole gc;

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
