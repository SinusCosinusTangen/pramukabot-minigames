package com.mythden.mythdenbot.service;

import com.mythden.mythdenbot.model.Pemain;
import com.mythden.mythdenbot.model.Pertanyaan;
import com.mythden.mythdenbot.repository.MiniGamesRepository;
import com.mythden.mythdenbot.repository.PemainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Random;
import java.util.regex.*;

@Service
public class MiniGamesServiceImpl implements MiniGamesService {

    @Autowired
    private MiniGamesRepository miniGamesRepository;

    @Autowired
    private PemainRepository pemainRepository;

    private ArrayList<String> listPemain = new ArrayList<>();

    private ArrayList<Integer> idPertanyaanSudahKeluar = new ArrayList<>();

    private Random rand = new Random();

    private int randomNum = 0;

    @Override
    public String createPertanyaan() {
        if (!miniGamesRepository.existsById(1)) {
            miniGamesRepository.save(new Pertanyaan("Sepuluh janji pramuka disebut dengan?",
                    "Dasa Dharma"));
            miniGamesRepository.save(new Pertanyaan("Kenapa tunas kelapa dipilih sebagai " +
                    "lambang dari pramuka?", "Serbaguna"));
            miniGamesRepository.save(new Pertanyaan("Bunyi dari Dasa Dharma ke-5 adalah",
                    "Rela menolong dan tabah"));
            return "Create";
        }
        return "Create";
    }

    @Override
    public Iterable<Pertanyaan> getAllPertanyaan() {
        return miniGamesRepository.findAll();
    }

    @Override
    public Iterable<Pemain> getAllPemain() {
        return pemainRepository.findAll();
    }

    @Override
    public String getPertanyaan() {
        int max = 0;
        for (Pertanyaan pertanyaan:getAllPertanyaan()) {
            max++;
        }
        System.out.println(max);
        randomNum = rand.nextInt(max - 1 + 1) + 1;
        System.out.println(randomNum);
        System.out.println(miniGamesRepository.findById(randomNum));
        if (!idPertanyaanSudahKeluar.contains(randomNum)) {
            idPertanyaanSudahKeluar.add(randomNum);
            return miniGamesRepository.findById(randomNum).getPertanyaan();
        } else if (idPertanyaanSudahKeluar.size() == max) {
            return "end";
        } else {
            return getPertanyaan();
        }
    }

    @Override
    public String jawab(String jawaban, String pemain) {
        if (Pattern.compile(jawaban.toLowerCase()).matcher(miniGamesRepository.findById(randomNum)
                .getJawaban().toLowerCase()).matches()) {
            Pemain oldPemain = pemainRepository.findByPemain(pemain);
            if (oldPemain != null) {
                oldPemain.setSkor(oldPemain.getSkor() + 1);
                pemainRepository.save(oldPemain);
                return "Jawaban Benar";
            }
            return "Kamu tidak masuk ke permainan ini!";
        }
        return "Jawaban Salah!";
    }

    @Override
    public String addPemain(String pemain) {
        pemainRepository.save(new Pemain(pemain, 0));
        return pemain;
    }

    @Override
    public ArrayList<String> getPemain() {
        for (Pemain pemain:getAllPemain()) {
            listPemain.add(pemain.getPemain());
        }
        return listPemain;
    }

    @Override
    public int getJumlahPemain() {
        int jumlahPemain = 0;
        for (Pemain pemain:getAllPemain()) {
            jumlahPemain++;
        }
        return jumlahPemain;
    }

    @Override
    public ArrayList<String> getSkor() {
        ArrayList<String> listPemain = new ArrayList<>();
        for (Pemain pemain:getAllPemain()) {
            listPemain.add(pemain.getPemain() + ": " + pemain.getSkor());
        }
        return listPemain;
    }

    @Override
    public String end() {
        idPertanyaanSudahKeluar.clear();
        pemainRepository.deleteAll();
        listPemain.clear();
        return "Permainan berakhir!";
    }

    @Override
    public String getPertanyaanKini() {
        return miniGamesRepository.findById(randomNum).getPertanyaan();
    }
}
