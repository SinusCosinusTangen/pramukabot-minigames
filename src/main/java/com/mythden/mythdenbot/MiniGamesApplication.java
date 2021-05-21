package com.mythden.mythdenbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
public class MiniGamesApplication {

    public static void main(String[] args) throws IllegalArgumentException {
        SpringApplication.run(MiniGamesApplication.class, args);
    }
}
