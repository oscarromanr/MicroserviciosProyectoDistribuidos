/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.roman.ventasmicroservice.dto;

import jakarta.persistence.*;
import java.math.BigDecimal;

/**
 *
 * @author roman
 */
@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(length = 50)
    private String nombre;

    @Column(length = 50)
    private String marca;

    @Column(precision = 10, scale = 2)
    private BigDecimal precio;

    @Column(length = 10)
    private String codigo;

    @ManyToOne
    @JoinColumn(name = "unidadMedida", referencedColumnName = "id")
    private UnidadMedida unidadMedida;

    public Producto() {
    }

    public Producto(String nombre, String marca, BigDecimal precio, String codigo, UnidadMedida unidadMedida) {
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
        this.codigo = codigo;
        this.unidadMedida = unidadMedida;
    }

    public Producto(Long id, String nombre, String marca, BigDecimal precio, String codigo, UnidadMedida unidadMedida) {
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
        this.codigo = codigo;
        this.unidadMedida = unidadMedida;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public UnidadMedida getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(UnidadMedida unidadMedida) {
        this.unidadMedida = unidadMedida;
    }
   
}