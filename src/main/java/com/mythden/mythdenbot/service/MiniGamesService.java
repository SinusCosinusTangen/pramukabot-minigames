package com.mythden.mythdenbot.service;

import com.mythden.mythdenbot.model.Pemain;
import com.mythden.mythdenbot.model.Pertanyaan;

import java.util.ArrayList;

public interface MiniGamesService {

//    void createPertanyaan();
    Iterable<Pertanyaan> getAllPertanyaan();
    Iterable<Pemain> getAllPemain();
    Pertanyaan getPertanyaan();
    String jawab(String jawaban, String pemain);
    String addPemain(String pemain);
    ArrayList<Pemain> getPemain();
    int getJumlahPemain();
    ArrayList<String> getSkor();
    void end();
    Pertanyaan getPertanyaanKini();
}
