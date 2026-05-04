package com.example.demo.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class VoitureTest {

    @Test
    void creerVoitureAvecConstructeurVide() {
        Voiture voiture = new Voiture();

        assertNotNull(voiture);
    }

    @Test
    void creerVoitureAvecMarqueEtPrix() {
        Voiture voiture = new Voiture("Renault", 15000);

        assertEquals("Renault", voiture.getMarque());
        assertEquals(15000, voiture.getPrix());
    }

    @Test
    void modifierMarque() {
        Voiture voiture = new Voiture();

        voiture.setMarque("Peugeot");

        assertEquals("Peugeot", voiture.getMarque());
    }

    @Test
    void modifierPrix() {
        Voiture voiture = new Voiture();

        voiture.setPrix(20000);

        assertEquals(20000, voiture.getPrix());
    }

    @Test
    void modifierId() {
        Voiture voiture = new Voiture();

        voiture.setId(1);

        assertEquals(1, voiture.getId());
    }

    @Test
    void verifierToString() {
        Voiture voiture = new Voiture("BMW", 30000);
        voiture.setId(5);

        String resultat = voiture.toString();

        assertEquals("Car{marque='BMW', prix=30000, id=5}", resultat);
    }
}