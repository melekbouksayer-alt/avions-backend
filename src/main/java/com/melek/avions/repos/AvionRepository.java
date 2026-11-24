
package com.melek.avions.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.melek.avions.entities.Avion;
import com.melek.avions.entities.Compagnie;

public interface AvionRepository
        extends JpaRepository<Avion, Long> {

    // Recherche exacte selon le modèle
    List<Avion> findByModele(String modele);

    // Recherche contenant une partie du modèle
    List<Avion> findByModeleContains(String modele);

    // Recherche selon le modèle et la capacité
    @Query("SELECT a FROM Avion a WHERE a.modele LIKE CONCAT('%', :modele, '%') AND a.capacite > :capacite")
    List<Avion> findByModeleCapacite(
        @Param("modele") String modele,
        @Param("capacite") Integer capacite
    );

    // Recherche selon une compagnie
    List<Avion> findByCompagnie(Compagnie compagnie);

    // Recherche selon l'identifiant de la compagnie
    List<Avion> findByCompagnieIdCompagnie(Long id);

    // Tri selon le modèle
    List<Avion> findByOrderByModeleAsc();

    // Tri selon le modèle puis la capacité
    @Query("SELECT a FROM Avion a ORDER BY a.modele ASC, a.capacite DESC")
    List<Avion> trierAvionsModelesCapacite();
}
