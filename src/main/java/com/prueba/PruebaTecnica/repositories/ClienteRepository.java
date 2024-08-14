package com.prueba.PruebaTecnica.repositories;

import com.prueba.PruebaTecnica.entities.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
