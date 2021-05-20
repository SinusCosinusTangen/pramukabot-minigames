package com.mythden.mythdenbot.parsetranslator.translator;

import com.mythden.mythdenbot.parsetranslator.codex.AlphaCodex;
import com.mythden.mythdenbot.parsetranslator.codex.CodexInterface;
import com.mythden.mythdenbot.parsetranslator.codex.MorseCodex;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class GeneralTranslatorTest {

    @Mock
    GeneralTranslator translator;

    @Mock
    GeneralTranslator translator1;

    @Mock
    CodexInterface alpha;

    @Mock
    CodexInterface morse;


    @BeforeEach
    void setUp() {
        alpha = new AlphaCodex();
        morse = new MorseCodex();
        translator = new GeneralTranslator(alpha, morse);
        translator1 = new GeneralTranslator(morse, alpha);
    }

    @Test
    void translate() {
        String message = "auki";
        String message_parsed = translator.translate(message);
        assertEquals(".- ..- -.- .. ", message_parsed);
        String message_parsed_back = translator1.translate(message_parsed);
        assertEquals(message, message_parsed_back);
    }
}