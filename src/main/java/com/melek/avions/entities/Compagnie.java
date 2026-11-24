
package com.melek.avions.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Compagnie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCompagnie;

    private String nomCompagnie;

    private String descriptionCompagnie;

    @JsonIgnore
    @OneToMany(mappedBy = "compagnie")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Avion> avions;
}
