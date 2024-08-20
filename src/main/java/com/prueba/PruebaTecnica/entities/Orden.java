package com.prueba.PruebaTecnica.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ordenes")
public class Orden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "codigo_ordenes")
    private String codigoOrdenes;
    private Date fecha;

    private Integer cantidad;
    @ManyToOne
    @JoinColumn(name = "clienteId")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "articuloId")
    private Articulo articulo;


    public Orden() {
    }

    public Orden(Long id) {
        this.id = id;
    }

    public Orden(Long id, String codigoOrdenes, Date fecha, Integer cantidad) {
        this.id = id;
        this.codigoOrdenes = codigoOrdenes;
        this.fecha = fecha;
        this.cantidad = cantidad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoOrdenes() {
        return codigoOrdenes;
    }

    public void setCodigoOrdenes(String codigoOrdenes) {
        this.codigoOrdenes = codigoOrdenes;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
