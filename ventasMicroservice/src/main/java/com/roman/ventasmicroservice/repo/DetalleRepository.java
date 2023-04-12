/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.roman.ventasmicroservice.repo;

import com.roman.ventasmicroservice.dto.Detalle;
import com.roman.ventasmicroservice.dto.Venta;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author roman
 */
@Repository
public interface DetalleRepository extends JpaRepository<Detalle, Long> {
    List<Detalle> findByVenta(Venta venta);
}