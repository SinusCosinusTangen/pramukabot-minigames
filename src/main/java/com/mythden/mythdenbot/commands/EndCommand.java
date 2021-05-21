package com.mythden.mythdenbot.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.mythden.mythdenbot.parser.CommandParser;

import java.util.ArrayList;

public class EndCommand extends Command {

    public EndCommand() {
        this.name = "end";
        this.help = "End mini games";
    }

    @Override
    protected void execute(CommandEvent event) {
        ArrayList<String> result = CommandParser.getSkor();
        String end = CommandParser.end();

        event.reply(end);
        for (String skor:result) {
            event.reply(skor);
        }
    }
}
