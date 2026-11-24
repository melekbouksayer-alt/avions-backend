package com.melek.avions.service;

import java.util.List;

import com.melek.avions.entities.Avion;
import com.melek.avions.entities.Compagnie;

public interface AvionService {

    Avion saveAvion(Avion a);

    Avion updateAvion(Avion a);

    void deleteAvion(Avion a);

    void deleteAvionById(Long id);

    Avion getAvion(Long id);

    List<Avion> getAllAvions();

    List<Avion> findByModele(String modele);

    List<Avion> findByModeleContains(String modele);

    List<Avion> findByModeleCapacite(String modele, Integer capacite);

    List<Avion> findByCompagnie(Compagnie compagnie);

    List<Avion> findByCompagnieIdCompagnie(Long id);

    List<Avion> findByOrderByModeleAsc();

    List<Avion> trierAvionsModelesCapacite();
}