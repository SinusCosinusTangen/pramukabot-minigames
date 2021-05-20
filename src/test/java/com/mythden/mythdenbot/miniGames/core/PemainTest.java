package com.mythden.mythdenbot.miniGames.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class PemainTest {

    private Class<?> pemainClass;

    @BeforeEach
    public void setup() throws Exception {
        pemainClass = Class.forName("com.mythden.mythdenbot.miniGames.core.Pemain");

    }

    @Test
    public void testPertanyaanClassIsPublic() {
        int classModifiers = pemainClass.getModifiers();

        assertTrue(Modifier.isPublic(classModifiers));
    }

    @Test
    public void testAtributPemain() throws Exception {
        Pemain pemain = new Pemain("pemain1", 100);
        assertEquals("pemain1", pemain.getPemain());
        assertEquals(100, pemain.getSkor());
    }
}
