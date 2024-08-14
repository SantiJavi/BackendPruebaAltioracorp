package com.prueba.PruebaTecnica.services;

import com.prueba.PruebaTecnica.entities.Orden;
import com.prueba.PruebaTecnica.repositories.OrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OrdenServiceImpl implements OrdenService{

    @Autowired
    private OrdenRepository repository;
    @Transactional(readOnly = true)
    @Override
    public List<Orden> findAll() {
        return (List<Orden>) repository.findAll();
    }
    @Transactional(readOnly = true)
    @Override
    public Optional<Orden> findById(Long id) {
        return repository.findById(id);
    }
    @Transactional
    @Override
    public Orden save(Orden orden) {
        return repository.save(orden);
    }
    @Transactional
    @Override
    public Optional<Orden> update(Long id, Orden orden) {
        Optional<Orden> ordenOptional = repository.findById(id);
        if(ordenOptional.isPresent()){
            Orden ordenDb = ordenOptional.orElseThrow();
            ordenDb.setCodigoOrdenes(orden.getCodigoOrdenes());
            ordenDb.setFecha(orden.getFecha());
            ordenDb.setArticulo(orden.getArticulo());
            ordenDb.setCliente(orden.getCliente());
            return Optional.of(repository.save(ordenDb));
        }
        return ordenOptional;
    }

    @Transactional
    @Override
    public Optional<Orden> delete(Long id) {
        Optional<Orden> ordenOptional = repository.findById(id);
        ordenOptional.ifPresent(ordenDb->{
            repository.delete(ordenDb);
        });
        return ordenOptional;
    }
}
