package com.prueba.PruebaTecnica.entities;

import jakarta.persistence.*;
import org.aspectj.weaver.ast.Or;

import java.util.List;

@Entity
@Table(name = "articulos")
public class Articulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigo;
    private String nombre;
    @Column(name = "precio_unitario")
    private double precioUnitario;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "articuloId")
    private List<Orden>ordenes;




    public Articulo() {
    }

    public Articulo(Long id) {
        this.id = id;
    }

    public Articulo(Long id, String codigo, String nombre, double precioUnitario) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

}
