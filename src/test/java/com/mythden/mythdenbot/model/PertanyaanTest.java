package com.mythden.mythdenbot.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class PertanyaanTest {

    private Class<?> pertanyaanClass;

    @BeforeEach
    public void setup() throws Exception {
        pertanyaanClass = Class.forName("com.mythden.mythdenbot.model.Pertanyaan");
    }

    @Test
    public void testPertanyaanClassIsPublic() {
        int classModifiers = pertanyaanClass.getModifiers();

        assertTrue(Modifier.isPublic(classModifiers));
    }

    @Test
    public void testConstructorPertanyaan() throws Exception {
        Pertanyaan pertanyaan = new Pertanyaan("pertanyaan1", "jawaban1");
        assertEquals("pertanyaan1", pertanyaan.getPertanyaan());
        assertEquals("jawaban1", pertanyaan.getJawaban());
    }
}
