package com.mythden.mythdenbot.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import com.mythden.mythdenbot.parser.CommandParser;

import java.util.ArrayList;

public class MiniGamesCommand extends Command {

    private final EventWaiter waiter;

    public MiniGamesCommand(EventWaiter waiter) {
        this.waiter = waiter;
        this.name = "main";
        this.help = "Mulai permainan";
    }

    @Override
    protected void execute(CommandEvent event) {
        CommandParser.createPertanyaan();
        if (CommandParser.getJumlahPemain() < 4) {
            CommandParser.addPemain(event.getAuthor().getName());
            ArrayList<String> listPemain = CommandParser.getPemain();
            event.reply(String.valueOf("Jumlah pemain = " + CommandParser.getJumlahPemain()));
            for (int i = 0; i < listPemain.size(); i++) {
                event.reply(i + 1 + ". " + listPemain.get(i));
            }
        } else {
            PertanyaanCommand pertanyaanCommand = new PertanyaanCommand();
            pertanyaanCommand.execute(event);
        }
    }
}
