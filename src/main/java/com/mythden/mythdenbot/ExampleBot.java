package com.mythden.mythdenbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ExampleBot {

    public static void main(String[] args) throws IllegalArgumentException {
        SpringApplication app = new SpringApplication(ExampleBot.class);
        app.run();
    }
}
