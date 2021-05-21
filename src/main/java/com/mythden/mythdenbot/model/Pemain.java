package com.mythden.mythdenbot.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "pemain")
@Data
@NoArgsConstructor
public class Pemain {

    @Id
    @Column(name = "pemain", updatable = false)
    private String pemain;

    @Column(name = "skor", columnDefinition = "Text")
    private int skor;

    public Pemain(String pemain, int skor) {
        this.pemain = pemain;
        this.skor = skor;
    }
}