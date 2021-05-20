package com.mythden.mythdenbot.miniGames.Parser;

import java.util.ArrayList;

public class ReplyList {
    private ArrayList<String> ret = null;

    public ReplyList(ArrayList<String> ret) {
        this.ret = ret;
    }

    public ArrayList<String> get() {
        return ret;
    }
}
