package com.mythden.mythdenbot.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.mythden.mythdenbot.parser.CommandParser;

import java.util.ArrayList;

public class JawabCommand extends Command {

    public JawabCommand() {
        this.name = "jawab";
        this.help = "Jawab mini games";
    }

    @Override
    protected void execute(CommandEvent event) {
        String args = event.getArgs();
        String jawaban = CommandParser.jawab(args.toLowerCase(), event.getAuthor().getName());
        ArrayList<String> listSkor = CommandParser.getSkor();
        event.reply(jawaban + "\n\nSkor\n");
        for (String skor:listSkor) {
            event.reply(skor);
        }

        if (jawaban.contains("Benar")) {
            PertanyaanCommand pertanyaanCommand = new PertanyaanCommand();
            pertanyaanCommand.execute(event);
        } else if (jawaban.contains("Salah")) {
            event.reply(CommandParser.getPertanyaanKini());
        }
    }
}
