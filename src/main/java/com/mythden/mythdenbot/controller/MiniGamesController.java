package com.mythden.mythdenbot.controller;

import com.mythden.mythdenbot.model.Jawaban;
import com.mythden.mythdenbot.model.Pemain;
import com.mythden.mythdenbot.service.MiniGamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "")
public class MiniGamesController {

    @Autowired
    private MiniGamesService miniGamesService;

//    @GetMapping(path = "/init-bot-admin")
//    @ResponseBody
//    public void createQuestion() {
//        miniGamesService.createPertanyaan();
//    }

    @GetMapping(path = "/get-question", produces = {"application/json"})
    @ResponseBody
    public ResponseEntity getQuestion() {
        return ResponseEntity.ok(miniGamesService.getPertanyaan());
    }

    @GetMapping(path = "/get-exist-question", produces = {"application/json"})
    @ResponseBody
    public ResponseEntity getExistQuestion() {
        return ResponseEntity.ok(miniGamesService.getPertanyaanKini());
    }

    @PostMapping(path = "/play", produces = {"application/json"})
    @ResponseBody
    public ResponseEntity addPlayer(@RequestBody Pemain json) {
        return ResponseEntity.ok(miniGamesService.addPemain(json.getPemain()));
    }

    @GetMapping(path = "/get-player", produces = {"application/json"})
    @ResponseBody
    public ResponseEntity getPlayer() {
        return ResponseEntity.ok(miniGamesService.getPemain());
    }

    @PostMapping(path = "/answer/{user}", produces = {"application/json"})
    @ResponseBody
    public ResponseEntity answer(@PathVariable(value = "user") String user,
                                 @RequestBody Jawaban answer) {
        System.out.println(miniGamesService.getPemain());
        System.out.println(answer);
        return ResponseEntity.ok(miniGamesService.jawab(answer.getJawaban(), user));
    }

    @GetMapping(path = "end-game")
    @ResponseBody
    public void end() {
        miniGamesService.end();
    }

}
