package com.learnings.MasteringSpring.LooselyCoupling01.GamingConsole;


public class Game01 implements GameConsole {

    public void up() {
        System.out.println("G01 up");
    }
    public void down() {
        System.out.println("G01 down");
    }
    public void left() {
        System.out.println("G01 left");
    }
    public void right() {
        System.out.println("G01 right");
    }

}
