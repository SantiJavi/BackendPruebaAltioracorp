package com.prueba.PruebaTecnica.controllers;

import com.prueba.PruebaTecnica.entities.Cliente;
import com.prueba.PruebaTecnica.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping
    public List<Cliente> listar(){
        return service.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable Long id){
        Optional<Cliente>clienteOptional =service.findById(id);
        if(clienteOptional.isPresent()){
            return ResponseEntity.ok(clienteOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Cliente cliente){
        Cliente clienteNew =service.save(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteNew);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?>update(@PathVariable Long id, @RequestBody Cliente cliente){
        Optional<Cliente> clienteOptional = service.update(id,cliente);
        if(clienteOptional.isPresent()){
            return ResponseEntity.ok(clienteOptional.orElseThrow());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<Cliente> clienteDb = service.delete(id);
        if(clienteDb.isPresent()){
            return ResponseEntity.ok(clienteDb.orElseThrow());
        }else{
            return ResponseEntity.notFound().build();
        }
    }


}
