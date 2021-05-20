package com.mythden.mythdenbot.parsetranslator.translator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

class FacadeTranslatorTest {

    String message;

    String alpha;

    String morse;


    @BeforeEach
    void setUp() throws Exception{
        message = "kenta";
        alpha = "alpha";
        morse = "morse";
    }

    @Test
    void translate() {
        String result1 = FacadeTranslator.translate(alpha, morse, message);
        assertEquals("-.- . -. - .- ", result1);
        String result2 = FacadeTranslator.translate(morse, alpha, result1);
        assertEquals(message, result2);
    }
}