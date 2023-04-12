/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.roman.inventariomicroservice.control;

import com.roman.inventariomicroservice.dto.Inventario;
import com.roman.inventariomicroservice.repo.InventarioRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
/**
 *
 * @author roman
 */
@RestController
@RequestMapping("/inventario")
public class InventarioController {
    @Autowired
    private InventarioRepository inventarioRepository;

    @GetMapping
    public ResponseEntity<List<Inventario>> getAllInventarios() {
        List<Inventario> inventario = inventarioRepository.findAll();
        return ResponseEntity.ok(inventario);
    }
    
    @GetMapping("/{idProducto}")
    public ResponseEntity<List<Inventario>> getInventarioPorProducto(@PathVariable Long idProducto) {
        List<Inventario> inventario = inventarioRepository.findByProductoId(idProducto);
        return ResponseEntity.ok(inventario);
    }

    @PostMapping
    public ResponseEntity<Inventario> crearInventario(@RequestBody Inventario inventario) {
        Inventario nuevoInventario = inventarioRepository.save(inventario);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoInventario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inventario> actualizarInventario(@PathVariable Long id, @RequestBody Inventario inventario) {
        Optional<Inventario> inventarioExistente = inventarioRepository.findById(id);
        if (inventarioExistente.isPresent()) {
            Inventario inventarioActualizado = inventarioExistente.get();
            inventarioActualizado.setCantidad(inventario.getCantidad());
            inventarioActualizado.setProducto(inventario.getProducto());
            inventarioRepository.save(inventarioActualizado);
            return ResponseEntity.ok(inventarioActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrarInventario(@PathVariable Long id) {
        Optional<Inventario> inventarioExistente = inventarioRepository.findById(id);
        if (inventarioExistente.isPresent()) {
            inventarioRepository.delete(inventarioExistente.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}