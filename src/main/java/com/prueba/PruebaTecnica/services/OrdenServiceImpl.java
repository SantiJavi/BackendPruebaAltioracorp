package com.prueba.PruebaTecnica.services;

import com.prueba.PruebaTecnica.entities.Articulo;
import com.prueba.PruebaTecnica.entities.Orden;
import com.prueba.PruebaTecnica.repositories.ArticuloRepository;
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
    @Autowired
    private ArticuloRepository repositoryArticulo;
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
    public Optional<?> save(Orden orden) {
        Optional<?> optional = null;
        if(orden.getCantidad() > orden.getArticulo().getStock()){
            optional = Optional.of("No hay Stock suficiente");
        }else{
            Optional<Articulo> articuloOpt = repositoryArticulo.findById(orden.getArticulo().getId());
            if(articuloOpt.isPresent()){
                Articulo articuloDb = articuloOpt.orElseThrow();
                Integer stockActualizado = articuloDb.getStock() - orden.getCantidad();
                articuloDb.setStock(stockActualizado);
                repositoryArticulo.save(articuloDb);
                optional= Optional.of(repository.save(orden));
            }
        }
        return optional;
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
            ordenDb.setCantidad(orden.getCantidad());
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
