package com.prueba.PruebaTecnica.services;

import com.prueba.PruebaTecnica.entities.Articulo;
import com.prueba.PruebaTecnica.repositories.ArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ArticuloServiceImpl implements ArticuloService{

    @Autowired
    private ArticuloRepository repository;

    @Transactional
    @Override
    public List<Articulo> findAll() {
        return (List<Articulo>) repository.findAll();
    }
    @Transactional(readOnly = true)
    @Override
    public Optional<Articulo> findById(Long id) {
        return repository.findById(id);
    }
    @Transactional
    @Override
    public Articulo save(Articulo articulo) {

        return repository.save(articulo);
    }

    @Transactional
    @Override
    public Optional<Articulo> update(Long id, Articulo articulo) {
        Optional<Articulo> articuloOptional = repository.findById(id);
        if(articuloOptional.isPresent()){
            Articulo articuloDb = articuloOptional.orElseThrow();
            articuloDb.setCodigo(articulo.getCodigo());
            articuloDb.setNombre(articulo.getNombre());
            articuloDb.setPrecioUnitario(articulo.getPrecioUnitario());
            articuloDb.setStock(articulo.getStock());
            return Optional.of(repository.save(articuloDb));
        }
        return articuloOptional;
    }
    @Transactional
    @Override
    public Optional<Articulo> delete(Long id) {
        Optional<Articulo>articuloOptional = repository.findById(id);
        articuloOptional.ifPresent(articuloDb->{
            repository.delete(articuloDb);
        });
        return articuloOptional;
    }
}
