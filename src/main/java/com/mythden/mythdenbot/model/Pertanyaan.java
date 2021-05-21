package com.mythden.mythdenbot.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "pertanyaan")
@Data
@NoArgsConstructor
public class Pertanyaan {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idPertanyaan;

    @Column(name = "pertanyaan", columnDefinition = "Text")
    private String pertanyaan;

    @Column(name = "jawaban", columnDefinition = "Text")
    private String jawaban;

    public Pertanyaan(String pertanyaan, String jawaban) {
        this.pertanyaan = pertanyaan;
        this.jawaban = jawaban;
    }
}
