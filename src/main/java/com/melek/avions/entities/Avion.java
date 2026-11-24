
package com.melek.avions.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Avion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAvion;

    private String matricule;

    private String modele;

    private Integer capacite;

    @Temporal(TemporalType.DATE)
    private Date dateMiseEnService;

    @ManyToOne
    @JoinColumn(name = "id_compagnie")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Compagnie compagnie;
}
