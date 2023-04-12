/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.roman.ventasmicroservice.repo;

import com.roman.ventasmicroservice.dto.Cliente;
import com.roman.ventasmicroservice.dto.Venta;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author roman
 */
@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {
    List<Venta> findByFolio(String folio);
    List<Venta> findByFecha(LocalDateTime fecha);
    List<Venta> findByCliente_Id(Long idCliente);
}