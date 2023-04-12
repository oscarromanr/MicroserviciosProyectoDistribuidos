/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.roman.ventasmicroservice.dto;

import jakarta.persistence.*;

/**
 *
 * @author roman
 */
@Entity
@Table(name = "Cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String RFC;

    @Column(nullable = false)
    private String correo;

    @Column(nullable = false)
    private String telefono;

    @Column(nullable = false)
    private String contraseña;

    public Cliente() {
    }

    public Cliente(String nombre, String RFC, String correo, String telefono, String contraseña) {
        this.nombre = nombre;
        this.RFC = RFC;
        this.correo = correo;
        this.telefono = telefono;
        this.contraseña = contraseña;
    }

    public Cliente(Long id, String nombre, String RFC, String correo, String telefono, String contraseña) {
        this.id = id;
        this.nombre = nombre;
        this.RFC = RFC;
        this.correo = correo;
        this.telefono = telefono;
        this.contraseña = contraseña;
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

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}