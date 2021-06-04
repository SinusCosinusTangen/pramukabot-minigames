package com.mythden.mythdenbot.controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mythden.mythdenbot.model.Pemain;
import com.mythden.mythdenbot.model.Pertanyaan;
import com.mythden.mythdenbot.repository.PemainRepository;
import com.mythden.mythdenbot.service.MiniGamesService;
import com.mythden.mythdenbot.service.MiniGamesServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)

public class MiniGamesControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private MiniGamesServiceImpl miniGamesService;

    @Mock
    private PemainRepository pemainRepository;

    private Pemain pemain;

    @BeforeEach
    public void setUp() {
        pemain = new Pemain("pemain1", 0);
    }


    private String toJson() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        Map<String, Object> mapData = new HashMap<>();
        mapData.put("Pemain", "pemain1");
        mapData.put("Skor", 0);

        /*String jsonifiedMailArgs = objectMapper.writeValueAsString(mailArgs);
        mapData.put("mailArgs", jsonifiedMailArgs);*/

        return objectMapper.writeValueAsString(mapData);
    }


    @Test
    public void testGetPertanyaan() throws Exception {
        mvc.perform(get("/get-question")
                .contentType(MediaType.ALL))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetPertanyaanKini() throws Exception {
        mvc.perform(get("/get-exist-question")
                .contentType(MediaType.ALL))
                .andExpect(status().isOk());
    }

    @Test
    public void testMain() throws Exception {
        String content = toJson();
        mvc.perform(post("/play")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content))
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    @Test
    public void testGetPemain() throws Exception {
        mvc.perform(get("/get-player")
                .contentType(MediaType.ALL))
                .andExpect(status().isOk());
    }

    @Test
    public void testJawab() throws Exception {
        String content = toJson();
        mvc.perform(post("/answer/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content))
                .andExpect(status().isOk());
    }

    @Test
    public void testEnd() throws Exception {
        mvc.perform(get("/end-game")
                .contentType(MediaType.ALL))
                .andExpect(status().isOk());
    }

//    @MockBean
//    private MiniGamesService miniGamesService;
//
//    private Pertanyaan pertanyaan;
//
//    private Pemain pemain;

//    @BeforeEach
//    public void setUp(){
//        pertanyaan = new Pertanyaan("pertanyaan1", "jawaban1");
//        pemain = new Pemain("pemain1", 0);
//    }
//
//    private String mapToJson(Object obj) throws JsonProcessingException {
//        ObjectMapper objectMapper = new ObjectMapper();
//        return objectMapper.writeValueAsString(obj);
//    }

//    @Test
//    public void testControllerCreatePertanyaan() throws Exception{
//
//        miniGamesService.createPertanyaan();
//
//        mvc.perform(post("/init-bot-admin")
//                .contentType(MediaType.APPLICATION_JSON_VALUE).content(mapToJson(mahasiswa)))
//                .andExpect(jsonPath("$.npm").value("1906192052"));
//    }

//    @Test
//    public void testControllerGetPertanyaan() throws Exception{
//
//        when(miniGamesService.getAllPertanyaan()).thenReturn(Arrays.asList(
//                pertanyaan
//        ));
//
//        mvc.perform(get("/get-question").contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk()).andExpect(content()
//                .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("pertanyaan").value("pertanyaan1"));
//    }

//    @Test
//    public void testControllerGetMahasiswaByNpm() throws Exception{
//
//        when(mahasiswaService.getMahasiswaByNPM("1906192052")).thenReturn(mahasiswa);
//        mvc.perform(get("/mahasiswa/1906192052").contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk()).andExpect(content()
//                .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.nama").value("Maung Meong"));
//    }
//
//    @Test
//    public void testControllerGetNonExistMahasiswa() throws Exception{
//        mvc.perform(get("/mahasiswa/1906192052").contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isNotFound());
//    }
//
//    @Test
//    public void testControllerUpdateMahasiswa() throws Exception{
//
//        mahasiswaService.createMahasiswa(mahasiswa);
//
//        //Update mahasiswa object nama
//        mahasiswa.setNama("Quanta Quantul");
//
//        when(mahasiswaService.updateMahasiswa(mahasiswa.getNpm(), mahasiswa)).thenReturn(mahasiswa);
//
//        mvc.perform(put("/mahasiswa/1906192052").contentType(MediaType.APPLICATION_JSON)
//                .content(mapToJson(mahasiswa)))
//                .andExpect(status().isOk()).andExpect(content()
//                .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.nama").value("Quanta Quantul"));
//    }
//
//    @Test
//    public void testControllerDeleteMahasiswa() throws Exception{
//        mahasiswaService.createMahasiswa(mahasiswa);
//        mvc.perform(delete("/mahasiswa/1906192052").contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isNoContent());
//    }



}
