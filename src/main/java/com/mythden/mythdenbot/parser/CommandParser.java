package com.mythden.mythdenbot.parser;

import static com.mythden.mythdenbot.parser.MiniGamesModuleLibrary.*;

import java.util.ArrayList;
import java.util.Map;

public class CommandParser {

    private static final Map<String, Module> MAP = Map.of(
            "createPertanyaan", CREATE_PERTANYAAN,
            "getPertanyaan", GET_PERTANYAAN,
            "getJumlahPemain", GET_JUMLAH_PEMAIN,
            "addPemain", ADD_PEMAIN,
            "getPemain", GET_PEMAIN,
            "jawab", JAWAB,
            "getSkor", GET_SKOR,
            "end", END,
            "getPertanyaanKini", GET_PERTANYAAN_KINI
    );

    public static String createPertanyaan() {
        Module module = MAP.get("createPertanyaan").create();
        Object result = module.invoke();
        return consume(result);
    }

    public static String getPertanyaan() {
        Module module = MAP.get("getPertanyaan").create();
        Object result = module.invoke();
        return consume(result);
    }

    public static int getJumlahPemain() {
        Module module = MAP.get("getJumlahPemain").create();
        Object result = module.invoke();
        return consume3(result);
    }

    public static String addPemain(String pemain) {
        Module module = MAP.get("addPemain").create();
        try {
            module.addArgs2(pemain);
        } catch (Exception e) {

        }
        Object result = module.invoke();
        return consume(result);
    }

    public static ArrayList<String> getPemain() {
        Module module = MAP.get("getPemain").create();
        Object result = module.invoke();
        return consume2(result);
    }

    public static String jawab(String jawaban, String pemain) {
        Module module = MAP.get("jawab").create();
        try {
            module.addArgs(jawaban);
            module.addArgs(pemain);
        } catch (Exception e) {
            return "gagal";
        }
        Object result = module.invoke();
        return consume(result);
    }

    public static ArrayList<String> getSkor() {
        Module module = MAP.get("getSkor").create();
        Object result = module.invoke();
        return consume2(result);
    }

    public static String end() {
        Module module = MAP.get("end").create();
        Object result = module.invoke();
        return consume(result);
    }

    public static String getPertanyaanKini() {
        Module module = MAP.get("getPertanyaanKini").create();
        Object result = module.invoke();
        return consume(result);
    }

    private static String consume(Object ret) {
        Reply reply = new Reply((String) ret);
        return reply.get();
    }

    private static ArrayList<String> consume2(Object ret) {
        ReplyList reply = new ReplyList((ArrayList<String>) ret);
        return reply.get();
    }

    private static int consume3(Object ret) {
        ReplyInt reply = new ReplyInt((int) ret);
        return reply.get();
    }
}
