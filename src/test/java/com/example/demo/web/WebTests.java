package com.example.demo.web;

import com.example.demo.data.Voiture;
import com.example.demo.service.Echantillon;
import com.example.demo.service.Statistique;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class WebTests {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    Statistique statistique;

    @Test
    void testGetStatistique() throws Exception {
        when(statistique.prixMoyen())
                .thenReturn(new Echantillon(2, 15000));

        mockMvc.perform(get("/statistique"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombreDeVoitures").value(2))
                .andExpect(jsonPath("$.prixMoyen").value(15000));
    }

    @Test
    void testPostVoiture() throws Exception {
        mockMvc.perform(post("/voiture")
                .contentType("application/json")
                .content("{\"marque\":\"Renault\",\"prix\":10000}"))
                .andExpect(status().isOk());

        verify(statistique).ajouter(any(Voiture.class));
    }
}