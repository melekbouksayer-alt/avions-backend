
package com.melek.avions.restcontrollers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.melek.avions.entities.Avion;
import com.melek.avions.service.AvionService;

@RestController
@RequestMapping("/api/avions")
@CrossOrigin(origins = "http://localhost:4200")
public class AvionRESTController {

    private final AvionService avionService;

    public AvionRESTController(AvionService avionService) {
        this.avionService = avionService;
    }

    // GET : afficher tous les avions
    @GetMapping
    public List<Avion> getAllAvions() {
        return avionService.getAllAvions();
    }

    // GET : afficher un avion
    @GetMapping("/{id}")
    public Avion getAvionById(@PathVariable Long id) {
        return avionService.getAvion(id);
    }

    // POST : ajouter un avion
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Avion createAvion(@RequestBody Avion avion) {
        return avionService.saveAvion(avion);
    }

    // PUT : modifier un avion
    @PutMapping("/{id}")
    public Avion updateAvion(
            @PathVariable Long id,
            @RequestBody Avion avion) {

        avion.setIdAvion(id);
        return avionService.updateAvion(avion);
    }

    // DELETE : supprimer un avion
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAvion(@PathVariable Long id) {
        avionService.deleteAvionById(id);
    }

    // GET : avions d'une compagnie
    @GetMapping("/compagnie/{idCompagnie}")
    public List<Avion> getAvionsByCompagnieId(
            @PathVariable Long idCompagnie) {

        return avionService.findByCompagnieIdCompagnie(idCompagnie);
    }

    // GET : rechercher par modèle
    @GetMapping("/recherche")
    public List<Avion> rechercherParModele(
            @RequestParam String modele) {

        return avionService.findByModeleContains(modele);
    }

    // GET : trier par modèle
    @GetMapping("/tri")
    public List<Avion> trierAvions() {
        return avionService.findByOrderByModeleAsc();
    }
}
