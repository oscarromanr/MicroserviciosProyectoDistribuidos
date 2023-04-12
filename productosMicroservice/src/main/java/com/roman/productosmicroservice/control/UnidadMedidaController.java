/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.roman.productosmicroservice.control;

import com.roman.productosmicroservice.dto.UnidadMedida;
import com.roman.productosmicroservice.repo.UnidadMedidaRepository;
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
@RequestMapping("/unidad-medida")
public class UnidadMedidaController {

    @Autowired
    private UnidadMedidaRepository unidadMedidaRepository;

    @GetMapping
    public ResponseEntity<List<UnidadMedida>> getAllUnidadesMedida() {
        List<UnidadMedida> unidadesMedida = unidadMedidaRepository.findAll();
        return ResponseEntity.ok(unidadesMedida);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UnidadMedida> getUnidadMedidaPorId(@PathVariable Integer id) {
        Optional<UnidadMedida> unidadMedida = unidadMedidaRepository.findById(id);
        if (unidadMedida.isPresent()) {
            return ResponseEntity.ok(unidadMedida.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(params = "nombre")
    public ResponseEntity<List<UnidadMedida>> getUnidadesMedidaPorNombre(@RequestParam String nombre) {
        List<UnidadMedida> unidadesMedida = unidadMedidaRepository.findByNombre(nombre);
        return ResponseEntity.ok(unidadesMedida);
    }

    @GetMapping(params = "codigo")
    public ResponseEntity<UnidadMedida> getUnidadMedidaPorCodigo(@RequestParam String codigo) {
        UnidadMedida unidadMedida = unidadMedidaRepository.findByCodigo(codigo);
        if (unidadMedida != null) {
            return ResponseEntity.ok(unidadMedida);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<UnidadMedida> crearUnidadMedida(@RequestBody UnidadMedida unidadMedida) {
        UnidadMedida nuevaUnidadMedida = unidadMedidaRepository.save(unidadMedida);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaUnidadMedida);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UnidadMedida> actualizarUnidadMedida(@PathVariable Integer id, @RequestBody UnidadMedida unidadMedida) {
        Optional<UnidadMedida> unidadMedidaExistente = unidadMedidaRepository.findById(id);
        if (unidadMedidaExistente.isPresent()) {
            UnidadMedida unidadMedidaActualizada = unidadMedidaRepository.save(unidadMedida);
            return ResponseEntity.ok(unidadMedidaActualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrarUnidadMedida(@PathVariable Integer id) {
        Optional<UnidadMedida> unidadMedidaExistente = unidadMedidaRepository.findById(id);
        if (unidadMedidaExistente.isPresent()) {
            unidadMedidaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
