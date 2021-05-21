package com.mythden.mythdenbot.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.mythden.mythdenbot.parser.CommandParser;

public class PertanyaanCommand extends Command {

    public PertanyaanCommand() {
        this.name = "mulai";
        this.aliases = new String[]{"lanjut"};
        this.help = "Play a mini games";
    }

    @Override
    protected void execute(CommandEvent event) {
        if (CommandParser.getPemain().contains(event.getAuthor().getName())) {
            String pertanyaan = CommandParser.getPertanyaan();
            if (!pertanyaan.equals("end")) {
                event.reply(pertanyaan);
            } else {
                event.reply("Pertanyaan telah habis");
                EndCommand endCommand = new EndCommand();
                endCommand.execute(event);
            }

        } else {
            event.reply("Maaf, kamu belum masuk ke permainan!");
        }
    }
}
