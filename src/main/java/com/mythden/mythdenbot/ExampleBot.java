package com.mythden.mythdenbot;

import com.github.ygimenez.exception.InvalidHandlerException;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import com.jagrosh.jdautilities.examples.command.AboutCommand;
import com.jagrosh.jdautilities.examples.command.PingCommand;
import com.jagrosh.jdautilities.examples.command.ShutdownCommand;
import com.mythden.mythdenbot.commands.EndCommand;
import com.mythden.mythdenbot.commands.JawabCommand;
import com.mythden.mythdenbot.commands.MiniGamesCommand;
import com.mythden.mythdenbot.commands.PertanyaanCommand;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.exceptions.RateLimitedException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import javax.security.auth.login.LoginException;
import java.awt.*;
import java.io.IOException;


@SpringBootApplication
public class ExampleBot {

    public static void main(String[] args) throws IllegalArgumentException {
        SpringApplication app = new SpringApplication(ExampleBot.class);
        app.run();
    }

    @PostConstruct
    public void run() throws IOException, LoginException,
            IllegalArgumentException, RateLimitedException, InvalidHandlerException {

        EventWaiter waiter = new EventWaiter();
        CommandClientBuilder client = new CommandClientBuilder();
        client.addCommands(
                // command to show information about the bot
                new AboutCommand(Color.BLUE, "an example bot",
                        new String[]{"Cool commands","Nice examples","Lots of fun!"},
                        Permission.ADMINISTRATOR),

                new MiniGamesCommand(waiter),

                new PertanyaanCommand(),

                new JawabCommand(),

                new EndCommand()
        );

    }
}
