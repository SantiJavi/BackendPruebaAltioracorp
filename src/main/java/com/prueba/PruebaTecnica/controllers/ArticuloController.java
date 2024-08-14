package com.prueba.PruebaTecnica.controllers;

import com.prueba.PruebaTecnica.entities.Articulo;
import com.prueba.PruebaTecnica.services.ArticuloService;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/articulos")
public class ArticuloController {

    @Autowired
    private ArticuloService service;
    @GetMapping
    public List<Articulo> listar() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable Long id){
        Optional<Articulo> articuloOptional = service.findById(id);
        if(articuloOptional.isPresent()){
            return ResponseEntity.ok(articuloOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }


    @PostMapping
    public ResponseEntity<?>save(@RequestBody Articulo articulo){
        Articulo articuloNew = service.save(articulo);
        return ResponseEntity.status(HttpStatus.CREATED).body(articuloNew);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?>update(@PathVariable Long id,@RequestBody Articulo articulo){
        Optional<Articulo> articuloOptional = service.update(id,articulo);
        if(articuloOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(articuloOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>delete(@PathVariable Long id){
        Optional<Articulo> articuloOptional = service.delete(id);
        if(articuloOptional.isPresent()){
            return  ResponseEntity.status(HttpStatus.OK).body(articuloOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }







}
