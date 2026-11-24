package com.melek.avions.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "modeleAvion", types = { Avion.class })
public interface AvionProjection {

    public String getModele();
}