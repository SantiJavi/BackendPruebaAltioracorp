package com.prueba.PruebaTecnica.services;


import com.prueba.PruebaTecnica.entities.Cliente;
import com.prueba.PruebaTecnica.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteRepository repository;
    @Transactional(readOnly = true)
    @Override
    public List<Cliente> findAll() {
        return (List<Cliente>) repository.findAll();
    }
    @Transactional(readOnly = true)
    @Override
    public Optional<Cliente> findById(Long id) {
        return repository.findById(id);
    }
    @Transactional
    @Override
    public Cliente save(Cliente cliente) {
        return repository.save(cliente);
    }
    @Transactional
    @Override
    public Optional<Cliente> update(Long id, Cliente cliente) {
        Optional<Cliente> clienteOptional = repository.findById(id);
        if(clienteOptional.isPresent()){
            Cliente clienteDb =clienteOptional.orElseThrow();
            clienteDb.setNombre(cliente.getNombre());
            clienteDb.setApellido(cliente.getApellido());
            return Optional.of(repository.save(clienteDb));
        }
        return clienteOptional;
    }

    @Transactional
    @Override
    public Optional<Cliente> delete(Long id) {
        Optional<Cliente>clienteOptional = repository.findById(id);
        clienteOptional.ifPresent(clienteDb ->{
            repository.delete(clienteDb);
        });
        return clienteOptional;
    }
}
