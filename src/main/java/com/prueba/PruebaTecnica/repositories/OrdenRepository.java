package com.prueba.PruebaTecnica.repositories;

import com.prueba.PruebaTecnica.entities.Orden;
import org.springframework.data.repository.CrudRepository;

public interface OrdenRepository extends CrudRepository<Orden,Long> {
}
