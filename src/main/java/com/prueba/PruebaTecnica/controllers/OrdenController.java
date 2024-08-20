package com.prueba.PruebaTecnica.controllers;


import com.prueba.PruebaTecnica.entities.Orden;
import com.prueba.PruebaTecnica.services.OrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.OpAnd;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ordenes")
public class OrdenController {

    @Autowired
    private OrdenService service;

    @GetMapping 
    public List<Orden> listar(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view (@PathVariable Long id){
        Optional<Orden> optionalDb = service.findById(id);
        if(optionalDb.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(optionalDb.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Orden orden){
        Optional<?> ordenNew = service.save(orden);
        return ResponseEntity.status(HttpStatus.CREATED).body(ordenNew);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?>update(@PathVariable Long id,@RequestBody Orden orden){
        Optional ordenDb = service.update(id,orden);
        if(ordenDb.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(ordenDb.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>delete(@PathVariable Long id){
        Optional ordenDb = service.delete(id);
        if(ordenDb.isPresent()){
            return  ResponseEntity.ok(ordenDb.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

}
