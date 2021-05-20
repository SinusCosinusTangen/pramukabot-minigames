package com.mythden.mythdenbot.miniGames.Parser;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;

class Reply {

    private String ret = null;

    public Reply(String ret) {
        this.ret = ret;
    }

    public String get() {
        return ret;
    }
}