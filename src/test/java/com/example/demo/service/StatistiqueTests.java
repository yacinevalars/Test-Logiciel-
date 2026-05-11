package com.example.demo.service;

import com.example.demo.data.Voiture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StatistiqueTests {

    private Statistique statistique;

    @BeforeEach
    void setUp() {
        statistique = new StatistiqueImpl();
    }

    @Test
    void testAjouterEtPrixMoyen() {
        Voiture voiture1 = new Voiture();
        voiture1.setPrix(10000);

        Voiture voiture2 = new Voiture();
        voiture2.setPrix(20000);

        statistique.ajouter(voiture1);
        statistique.ajouter(voiture2);

        Echantillon resultat = statistique.prixMoyen();

        assertEquals(2, resultat.getNombreDeVoitures());
        assertEquals(15000, resultat.getPrixMoyen());
    }

    @Test
    void testPrixMoyenAvecUneSeuleVoiture() {
        Voiture voiture = new Voiture();
        voiture.setPrix(12000);

        statistique.ajouter(voiture);

        Echantillon resultat = statistique.prixMoyen();

        assertEquals(1, resultat.getNombreDeVoitures());
        assertEquals(12000, resultat.getPrixMoyen());
    }

    @Test
    void testPrixMoyenSansVoitureLanceArithmeticException() {
        assertThrows(ArithmeticException.class, () -> {
            statistique.prixMoyen();
        });
    }
}