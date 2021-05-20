package com.mythden.mythdenbot.parsetranslator.codex;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class CodexInterfaceTest {

    @Mock
    CodexInterface alpha;

    @Mock
    CodexInterface morse;

    @BeforeEach
    void setUp() {
        alpha = new AlphaCodex();
        morse = new MorseCodex();
    }

    @Test
    void getIndex() {
        String a = "a";
        String a_morse = ".-";
        assertEquals(0, alpha.getIndex(a));
        assertEquals(0, morse.getIndex(a_morse));
    }

    @Test
    void getCodex() {
        int alphacode = 1;
        int morsecode = 2;
        assertEquals("b", alpha.getCodex(alphacode));
        assertEquals("-.-.", morse.getCodex(morsecode));
    }

    @Test
    void getDelimiter() {
        assertEquals("", alpha.getDelimiter());
        assertEquals(" ", morse.getDelimiter());
    }
}