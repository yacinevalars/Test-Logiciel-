package com.example.demo.service;

import com.example.demo.data.Voiture;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StatistiqueImplTests {

    @Autowired
    StatistiqueImpl statistiqueImpl;

    @Test
    void testAjouterEtPrixMoyen() {
        Voiture voiture1 = new Voiture();
        voiture1.setPrix(10000);

        Voiture voiture2 = new Voiture();
        voiture2.setPrix(20000);

        statistiqueImpl.ajouter(voiture1);
        statistiqueImpl.ajouter(voiture2);

        Echantillon resultat = statistiqueImpl.prixMoyen();

        assertEquals(2, resultat.getNombreDeVoitures());
        assertEquals(15000, resultat.getPrixMoyen());
        System.out.println("Nombre de voitures : " + resultat.getNombreDeVoitures());
        System.out.println("Prix moyen : " + resultat.getPrixMoyen());
        System.out.println("Le Test est OK");
    }

    @Test
    void testPrixMoyenSansVoitureLanceArithmeticException() {
        assertThrows(ArithmeticException.class, () -> {
            statistiqueImpl.prixMoyen();
        });
    }
}