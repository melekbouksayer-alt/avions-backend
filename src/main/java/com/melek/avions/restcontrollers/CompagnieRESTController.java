
package com.melek.avions.restcontrollers;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.melek.avions.entities.Compagnie;
import com.melek.avions.repos.CompagnieRepository;

@RestController
@RequestMapping("/api/compagnies")
@CrossOrigin(origins = "http://localhost:4200")
public class CompagnieRESTController {

    private final CompagnieRepository compagnieRepository;

    public CompagnieRESTController(
            CompagnieRepository compagnieRepository) {
        this.compagnieRepository = compagnieRepository;
    }

    @GetMapping
    public List<Compagnie> getAllCompagnies() {
        return compagnieRepository.findAll();
    }

    @GetMapping("/{id}")
    public Compagnie getCompagnieById(@PathVariable Long id) {
        return compagnieRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Compagnie createCompagnie(
            @RequestBody Compagnie compagnie) {
        compagnie.setIdCompagnie(null);
        return compagnieRepository.save(compagnie);
    }

    @PutMapping("/{id}")
    public Compagnie updateCompagnie(
            @PathVariable Long id,
            @RequestBody Compagnie compagnie) {

        compagnie.setIdCompagnie(id);
        return compagnieRepository.save(compagnie);
    }

    @DeleteMapping("/{id}")
    public void deleteCompagnie(@PathVariable Long id) {
        compagnieRepository.deleteById(id);
    }
}
