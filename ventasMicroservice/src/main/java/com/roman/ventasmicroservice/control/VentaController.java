/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.roman.ventasmicroservice.control;

import com.roman.ventasmicroservice.dto.Venta;
import com.roman.ventasmicroservice.repo.VentaRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author roman
 */
@RestController
@RequestMapping("/ventas")
public class VentaController {
    @Autowired
    private VentaRepository ventaRepository;

    @GetMapping
    public ResponseEntity<List<Venta>> getAllVentas() {
        List<Venta> ventas = ventaRepository.findAll();
        return ResponseEntity.ok(ventas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venta> getVentaPorId(@PathVariable Long id) {
        Optional<Venta> venta = ventaRepository.findById(id);
        if (venta.isPresent()) {
            return ResponseEntity.ok(venta.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(params = "folio")
    public ResponseEntity<List<Venta>> getVentasPorFolio(@RequestParam String folio) {
        List<Venta> ventas = ventaRepository.findByFolio(folio);
        return ResponseEntity.ok(ventas);
    }

    @GetMapping(params = "fecha")
    public ResponseEntity<List<Venta>> getVentasPorFecha(@RequestParam LocalDateTime fecha) {
        List<Venta> ventas = ventaRepository.findByFecha(fecha);
        return ResponseEntity.ok(ventas);
    }

    @GetMapping(params = "idCliente")
    public ResponseEntity<List<Venta>> getVentasPorIdCliente(@RequestParam Long idCliente) {
        List<Venta> ventas = ventaRepository.findByCliente_Id(idCliente);
        return ResponseEntity.ok(ventas);
    }

    @PostMapping
    public ResponseEntity<Venta> crearVenta(@RequestBody Venta venta) {
        Venta nuevaVenta = ventaRepository.save(venta);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaVenta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Venta> actualizarVenta(@PathVariable Long id, @RequestBody Venta venta) {
        Optional<Venta> ventaExistente = ventaRepository.findById(id);
        if (ventaExistente.isPresent()) {
            Venta ventaActualizada = ventaRepository.save(venta);
            return ResponseEntity.ok(ventaActualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrarVenta(@PathVariable Long id) {
        Optional<Venta> ventaExistente = ventaRepository.findById(id);
        if (ventaExistente.isPresent()) {
            ventaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}