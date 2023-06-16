package com.example.demo.Configuration;

import org.springframework.context.annotation.Bean;

import com.example.demo.model.Objects.Game;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public Game game(){
        return new Game();
    }
    
}
