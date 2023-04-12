/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.roman.ventasmicroservice.control;

import com.roman.ventasmicroservice.dto.Detalle;
import com.roman.ventasmicroservice.repo.DetalleRepository;
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
@RequestMapping("/detalles")
public class DetalleController {

    @Autowired
    private DetalleRepository detalleRepository;

    @GetMapping
    public ResponseEntity<List<Detalle>> getAllDetalles() {
        List<Detalle> detalles = detalleRepository.findAll();
        return ResponseEntity.ok(detalles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Detalle> getDetallePorId(@PathVariable Long id) {
        Optional<Detalle> detalle = detalleRepository.findById(id);
        if (detalle.isPresent()) {
            return ResponseEntity.ok(detalle.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Detalle> crearDetalle(@RequestBody Detalle detalle) {
        Detalle nuevoDetalle = detalleRepository.save(detalle);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoDetalle);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Detalle> actualizarDetalle(@PathVariable Long id, @RequestBody Detalle detalle) {
        Optional<Detalle> detalleExistente = detalleRepository.findById(id);
        if (detalleExistente.isPresent()) {
            Detalle detalleActualizado = detalleRepository.save(detalle);
            return ResponseEntity.ok(detalleActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrarDetalle(@PathVariable Long id) {
        Optional<Detalle> detalleExistente = detalleRepository.findById(id);
        if (detalleExistente.isPresent()) {
            detalleRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}