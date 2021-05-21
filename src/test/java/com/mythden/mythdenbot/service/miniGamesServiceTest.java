package com.mythden.mythdenbot.service;

import com.mythden.mythdenbot.model.Pemain;
import com.mythden.mythdenbot.model.Pertanyaan;
import com.mythden.mythdenbot.repository.MiniGamesRepository;
import com.mythden.mythdenbot.repository.PemainRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class miniGamesServiceTest {

    @Mock
    private MiniGamesRepository miniGamesRepository;

    @Mock
    private PemainRepository pemainRepository;

    @InjectMocks
    private MiniGamesServiceImpl miniGamesService;

    private Pertanyaan pertanyaan1;
    private Pertanyaan pertanyaan2;
    private Pemain pemain1;
    private Pemain pemain2;

    @BeforeEach
    public void setUp() {
        pertanyaan1 = new Pertanyaan("pertanyaan1", "jawaban1");
        pertanyaan2 = new Pertanyaan("pertanyaan2", "jawaban2");
        pemain1 = new Pemain("pemain1", 5);
        pemain2 = new Pemain("pemain2", 7);
    }

    @Test
    public void testCreatePertanyaan() {
        miniGamesService.createPertanyaan();
        if (!miniGamesRepository.existsById(1)) {
            verify(miniGamesRepository).save(new Pertanyaan("Sepuluh janji pramuka disebut dengan?",
                    "Dasa Dharma"));
        }
    }

    @Test
    public void findAllPertanyaanTest() {
        when(miniGamesRepository.findAll()).thenReturn(Arrays.asList(
                pertanyaan1,
                pertanyaan2
        ));

        List<Pertanyaan> listPertanyaan = new ArrayList<>();
        Iterable<Pertanyaan> allPertanyaan = miniGamesService.getAllPertanyaan();
        for (Pertanyaan pertanyaan:allPertanyaan) {
            listPertanyaan.add(pertanyaan);
        }

        assertEquals("pertanyaan1", listPertanyaan.get(0).getPertanyaan());
        assertEquals("pertanyaan2", listPertanyaan.get(1).getPertanyaan());
    }

    @Test
    public void testGetPertanyaan() {
        when(miniGamesRepository.findAll()).thenReturn(Arrays.asList(
                pertanyaan1
        ));
        when(miniGamesRepository.findById(1)).thenReturn(pertanyaan1);

        String pertanyaan = miniGamesService.getPertanyaan().getPertanyaan();
        assertEquals("pertanyaan1", pertanyaan);
    }

    @Test
    public void testGetPertanyaanHabis() {
        when(miniGamesRepository.findAll()).thenReturn(Arrays.asList(
                pertanyaan1
        ));
        when(miniGamesRepository.findById(1)).thenReturn(pertanyaan1);

        miniGamesService.getPertanyaan();
        String pertanyaan = miniGamesService.getPertanyaan().getPertanyaan();
        assertEquals("Permainan sudah berakhir", pertanyaan);
    }

    @Test
    public void testGetPertanyaanSudahKeluar() {
        when(miniGamesRepository.findAll()).thenReturn(Arrays.asList(
                pertanyaan1,
                pertanyaan2
        ));
        when(miniGamesRepository.findById(1)).thenReturn(pertanyaan1);
        when(miniGamesRepository.findById(2)).thenReturn(pertanyaan2);

        ArrayList<String> pertanyaanList = new ArrayList<>();
        String pertanyaan1 = miniGamesService.getPertanyaan().getPertanyaan();
        String pertanyaan2 = miniGamesService.getPertanyaan().getPertanyaan();
        pertanyaanList.add(pertanyaan1);
        pertanyaanList.add(pertanyaan2);

        if (pertanyaanList.get(0).equals("pertanyaan1")) {
            assertEquals("pertanyaan1", pertanyaanList.get(0));
            assertEquals("pertanyaan2", pertanyaanList.get(1));
        } else {
            assertEquals("pertanyaan2", pertanyaanList.get(0));
            assertEquals("pertanyaan1", pertanyaanList.get(1));
        }
    }

    @Test
    public void testJawab() {
        lenient().when(miniGamesRepository.findAll()).thenReturn(Arrays.asList(
                pertanyaan1
        ));
        lenient().when(miniGamesRepository.findById(1)).thenReturn(pertanyaan1);

        lenient().when(pemainRepository.findAll()).thenReturn(Arrays.asList(
                pemain1
        ));
        lenient().when(pemainRepository.findByPemain("pemain1")).thenReturn(pemain1);

        miniGamesService.getPertanyaan();
        String jawaban = miniGamesService.jawab("jawaban1", "pemain1");
        assertEquals("Jawaban Benar", jawaban);
    }

    @Test
    public void testJawabTidakMain() {
        lenient().when(miniGamesRepository.findAll()).thenReturn(Arrays.asList(
                pertanyaan1
        ));
        lenient().when(miniGamesRepository.findById(1)).thenReturn(pertanyaan1);

        lenient().when(pemainRepository.findAll()).thenReturn(Arrays.asList(
                pemain1
        ));
        lenient().when(pemainRepository.findByPemain("pemain1")).thenReturn(pemain1);

        miniGamesService.getPertanyaan();
        String jawaban = miniGamesService.jawab("jawaban1", "pemain2");
        assertEquals("Kamu tidak masuk ke permainan ini!", jawaban);
    }

    @Test
    public void testJawabSalah() {
        lenient().when(miniGamesRepository.findAll()).thenReturn(Arrays.asList(
                pertanyaan1
        ));
        lenient().when(miniGamesRepository.findById(1)).thenReturn(pertanyaan1);

        lenient().when(pemainRepository.findAll()).thenReturn(Arrays.asList(
                pemain1
        ));
        lenient().when(pemainRepository.findByPemain("pemain1")).thenReturn(pemain1);

        miniGamesService.getPertanyaan();
        String jawaban = miniGamesService.jawab("jawaban2", "pemain1");
        assertEquals("Jawaban Salah!", jawaban);
    }

    @Test
    public void testGetPertanyaanKini() {
        when(miniGamesRepository.findAll()).thenReturn(Arrays.asList(
                pertanyaan1
        ));
        when(miniGamesRepository.findById(1)).thenReturn(pertanyaan1);

        miniGamesService.getPertanyaan();
        String pertanyaan = miniGamesService.getPertanyaanKini().getPertanyaan();
        assertEquals("pertanyaan1", pertanyaan);
    }

    @Test
    public void testServiceAddPemain(){
        lenient().when(miniGamesService.addPemain(pemain1.getPemain())).thenReturn(pemain1.getPemain());
    }

    @Test
    public void findAllPemainTest() {
        when(pemainRepository.findAll()).thenReturn(Arrays.asList(
                pemain1,
                pemain2
        ));

        List<Pemain> listPemain = new ArrayList<>();
        Iterable<Pemain> allPemain = miniGamesService.getAllPemain();
        for (Pemain pemain:allPemain) {
            listPemain.add(pemain);
        }

        assertEquals("pemain1", listPemain.get(0).getPemain());
        assertEquals("pemain2", listPemain.get(1).getPemain());
    }

    @Test
    public void testGetPemain() {
        lenient().when(pemainRepository.findAll()).thenReturn(Arrays.asList(
                pemain1,
                pemain2
        ));
        lenient().when(pemainRepository.findByPemain("pemain1")).thenReturn(pemain1);
        lenient().when(pemainRepository.findByPemain("pemain2")).thenReturn(pemain2);

        ArrayList<String> pemainList = new ArrayList<>();
        for (Pemain pemain:miniGamesService.getPemain()) {
            pemainList.add(pemain.getPemain());
        }
        ArrayList<String> expectedOutput = new ArrayList<>();
        expectedOutput.add(pemain1.getPemain());
        expectedOutput.add(pemain2.getPemain());
        assertEquals(expectedOutput, pemainList);
    }

    @Test
    public void testGetJumlahPemain() {
        lenient().when(pemainRepository.findAll()).thenReturn(Arrays.asList(
                pemain1,
                pemain2
        ));
        lenient().when(pemainRepository.findByPemain("pemain1")).thenReturn(pemain1);
        lenient().when(pemainRepository.findByPemain("pemain2")).thenReturn(pemain2);

        int jumlahPemain = miniGamesService.getJumlahPemain();
        assertEquals(2, jumlahPemain);
    }

    @Test
    public void testGetSkor() {
        lenient().when(pemainRepository.findAll()).thenReturn(Arrays.asList(
                pemain1,
                pemain2
        ));
        lenient().when(pemainRepository.findByPemain("pemain1")).thenReturn(pemain1);
        lenient().when(pemainRepository.findByPemain("pemain2")).thenReturn(pemain2);

        ArrayList<String> pemainList = miniGamesService.getSkor();
        ArrayList<String> expectedOutput = new ArrayList<>();
        expectedOutput.add(pemain1.getPemain() + ": " + pemain1.getSkor());
        expectedOutput.add(pemain2.getPemain() + ": " + pemain2.getSkor());
        assertEquals(expectedOutput, pemainList);
    }
}