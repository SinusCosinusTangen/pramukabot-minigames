package com.mythden.mythdenbot.miniGames.service;

import com.mythden.mythdenbot.miniGames.core.Pemain;
import com.mythden.mythdenbot.miniGames.core.Pertanyaan;

import java.util.ArrayList;

public interface MiniGamesService {

    String createPertanyaan();
    Iterable<Pertanyaan> getAllPertanyaan();
    Iterable<Pemain> getAllPemain();
    String getPertanyaan();
    String jawab(String jawaban, String pemain);
    String addPemain(String pemain);
    ArrayList<String> getPemain();
    int getJumlahPemain();
    ArrayList<String> getSkor();
    String end();
    String getPertanyaanKini();
}
