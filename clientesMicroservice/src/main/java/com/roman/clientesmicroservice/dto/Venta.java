/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.roman.clientesmicroservice.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author roman
 */
@Entity
@Table(name = "venta")
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(precision = 10, scale = 2)
    private BigDecimal total;

    @Column(length = 20)
    private String folio;

    @Column
    private LocalDateTime fecha;

    @ManyToOne
    @JoinColumn(name = "idCliente", referencedColumnName = "id")
    private Cliente cliente;

    public Venta() {
    }

    public Venta(Long id, BigDecimal total, String folio, LocalDateTime fecha, Cliente cliente) {
        this.id = id;
        this.total = total;
        this.folio = folio;
        this.fecha = fecha;
        this.cliente = cliente;
    }

    public Venta(BigDecimal total, String folio, LocalDateTime fecha, Cliente cliente) {
        this.total = total;
        this.folio = folio;
        this.fecha = fecha;
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
}
