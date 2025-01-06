package com.learnings.SpringIntro.Gamer;

public class Game02 implements  GameConsole {
    public void up() {
        System.out.println("G02 up");
    }
    public void down() {
        System.out.println("G02 down");
    }
    public void left() {
        System.out.println("G02 left");
    }
    public void right() {
        System.out.println("G02 right");
    }

    public  void jump(){
        System.out.println("G02 jump");
    }

}
