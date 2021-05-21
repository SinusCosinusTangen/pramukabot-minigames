package com.mythden.mythdenbot.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mythden.mythdenbot.model.Pemain;
import com.mythden.mythdenbot.model.Pertanyaan;
import com.mythden.mythdenbot.service.MiniGamesService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Arrays;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(controllers = MiniGamesController.class)
public class MiniGamesControllerTest {

//    @Autowired
//    private MockMvc mvc;
//
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
