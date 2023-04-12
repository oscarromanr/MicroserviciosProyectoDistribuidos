/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.roman.productosmicroservice.repo;

import com.roman.productosmicroservice.dto.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author roman
 */
@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    List<Producto> findByMarca(String marca);
    List<Producto> findByCodigo(String codigo);
}
