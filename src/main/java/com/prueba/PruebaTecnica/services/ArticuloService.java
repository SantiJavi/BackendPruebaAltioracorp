package com.prueba.PruebaTecnica.services;

import com.prueba.PruebaTecnica.entities.Articulo;

import java.util.List;
import java.util.Optional;

public interface ArticuloService{
    List<Articulo> findAll();
    Optional<Articulo> findById(Long id);
    Articulo save(Articulo articulo);
    Optional<Articulo>update(Long id,Articulo articulo);
    Optional<Articulo>delete(Long id);
}
