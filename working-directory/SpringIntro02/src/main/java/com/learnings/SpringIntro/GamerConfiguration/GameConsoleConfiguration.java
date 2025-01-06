package com.learnings.SpringIntro.GamerConfiguration;

import com.learnings.SpringIntro.Gamer.Game01;
import com.learnings.SpringIntro.Gamer.GameConsole;
import com.learnings.SpringIntro.Gamer.GameRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameConsoleConfiguration {

@Bean
   public GameConsole game(){
       var game = new Game01();
       return  game;
   }

@Bean
    public GameRunner gameRunner(){
        var gameRunner = new GameRunner(game());
        return gameRunner;
    }
}
