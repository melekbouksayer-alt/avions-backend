
package com.melek.avions.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.melek.avions.entities.Avion;
import com.melek.avions.entities.Compagnie;
import com.melek.avions.repos.AvionRepository;

@Service
public class AvionServiceImpl implements AvionService {

    private final AvionRepository avionRepository;

    public AvionServiceImpl(AvionRepository avionRepository) {
        this.avionRepository = avionRepository;
    }

    @Override
    public Avion saveAvion(Avion a) {
        return avionRepository.save(a);
    }

    @Override
    public Avion updateAvion(Avion a) {
        return avionRepository.save(a);
    }

    @Override
    public void deleteAvion(Avion a) {
        avionRepository.delete(a);
    }

    @Override
    public void deleteAvionById(Long id) {
        avionRepository.deleteById(id);
    }

    @Override
    public Avion getAvion(Long id) {
        return avionRepository.findById(id).orElse(null);
    }

    @Override
    public List<Avion> getAllAvions() {
        return avionRepository.findAll();
    }

    @Override
    public List<Avion> findByModele(String modele) {
        return avionRepository.findByModele(modele);
    }

    @Override
    public List<Avion> findByModeleContains(String modele) {
        return avionRepository.findByModeleContains(modele);
    }

    @Override
    public List<Avion> findByModeleCapacite(
            String modele, Integer capacite) {
        return avionRepository.findByModeleCapacite(
            modele, capacite
        );
    }

    @Override
    public List<Avion> findByCompagnie(Compagnie compagnie) {
        return avionRepository.findByCompagnie(compagnie);
    }

    @Override
    public List<Avion> findByCompagnieIdCompagnie(Long id) {
        return avionRepository.findByCompagnieIdCompagnie(id);
    }

    @Override
    public List<Avion> findByOrderByModeleAsc() {
        return avionRepository.findByOrderByModeleAsc();
    }

    @Override
    public List<Avion> trierAvionsModelesCapacite() {
        return avionRepository.trierAvionsModelesCapacite();
    }
}
