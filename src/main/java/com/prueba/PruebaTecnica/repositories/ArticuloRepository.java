package com.prueba.PruebaTecnica.repositories;

import com.prueba.PruebaTecnica.entities.Articulo;
import org.springframework.data.repository.CrudRepository;

public interface ArticuloRepository extends CrudRepository<Articulo, Long> {
}
