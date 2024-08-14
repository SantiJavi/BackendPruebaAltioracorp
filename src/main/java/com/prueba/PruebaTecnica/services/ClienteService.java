package com.prueba.PruebaTecnica.services;

import com.prueba.PruebaTecnica.entities.Cliente;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface ClienteService {
    List<Cliente> findAll();

    Optional<Cliente> findById(Long id);

    Cliente save(Cliente cliente);

    Optional<Cliente> update(Long id, Cliente cliente);

    Optional<Cliente> delete(Long id);
}