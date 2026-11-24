
package com.melek.avions;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.melek.avions.entities.Avion;
import com.melek.avions.entities.Compagnie;
import com.melek.avions.repos.AvionRepository;

@SpringBootTest
class AvionsApplicationTests {

    @Autowired
    private AvionRepository avionRepository;

    // Ajouter un avion
    @Test
    public void testCreateAvion() {
        Avion a = new Avion(null, "TS-001", "Airbus A320", 180, null,null);
        avionRepository.save(a);
    }
    // Rechercher un avion par ID
    @Test
    public void testFindAvion() {
        Avion a = avionRepository.findById(1L).orElse(null);
        System.out.println(a);
    }

    // Modifier un avion
    @Test
    public void testUpdateAvion() {
        Avion a = avionRepository.findById(1L).orElse(null);

        if (a != null) {
            a.setCapacite(200);
            avionRepository.save(a);
        }
    }

    // Supprimer un avion
    @Test
    public void testDeleteAvion() {
        avionRepository.deleteById(1L);
    }

    // Lister tous les avions
    @Test
    public void testListerTousAvions() {
        List<Avion> avions = avionRepository.findAll();

        for (Avion a : avions) {
            System.out.println(a);
        }
    }

    // Recherche selon le modèle
    @Test
    public void testFindAvionByModele() {
        List<Avion> avions =
                avionRepository.findByModele("Airbus A320");

        for (Avion a : avions) {
            System.out.println(a);
        }
    }

    // Recherche selon une partie du modèle
    @Test
    public void testFindByModeleContains() {
        List<Avion> avions =
                avionRepository.findByModeleContains("Airbus");

        for (Avion a : avions) {
            System.out.println(a);
        }
    }

    // Recherche selon le modèle et la capacité
    @Test
    public void testFindByModeleCapacite() {
        List<Avion> avions =
                avionRepository.findByModeleCapacite("Airbus", 150);

        for (Avion a : avions) {
            System.out.println(a);
        }
    }

    // Recherche selon une compagnie
    @Test
    public void testFindByCompagnie() {
        Compagnie c = new Compagnie();
        c.setIdCompagnie(1L);

        List<Avion> avions =
                avionRepository.findByCompagnie(c);

        for (Avion a : avions) {
            System.out.println(a);
        }
    }

    // Recherche selon l'identifiant de la compagnie
    @Test
    public void testFindByCompagnieIdCompagnie() {
        List<Avion> avions =
                avionRepository.findByCompagnieIdCompagnie(1L);

        for (Avion a : avions) {
            System.out.println(a);
        }
    }
    @Test
    public void testFindByOrderByModeleAsc() {
        List<Avion> avions = avionRepository.findByOrderByModeleAsc();

        for (Avion a : avions) {
            System.out.println(a);
        }
    }
    @Test
    public void testTrierAvionsModelesCapacite() {
        List<Avion> avions = avionRepository.trierAvionsModelesCapacite();

        for (Avion a : avions) {
            System.out.println(a);
        }
    }

    
    
}
