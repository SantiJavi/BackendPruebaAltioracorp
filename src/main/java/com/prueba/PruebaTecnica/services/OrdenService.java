package com.prueba.PruebaTecnica.services;
import com.prueba.PruebaTecnica.entities.Orden;

import java.util.List;
import java.util.Optional;

public interface OrdenService {
    List<Orden> findAll();
    Optional<Orden> findById(Long id);
    Orden save(Orden orden);
    Optional<Orden>update(Long id,Orden orden);
    Optional<Orden>delete(Long id);
}
