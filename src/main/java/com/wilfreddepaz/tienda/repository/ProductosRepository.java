package com.wilfreddepaz.tienda.repository;

import com.wilfreddepaz.tienda.entity.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;

@Repository
public interface ProductosRepository extends JpaRepository<Productos, Integer> {

    boolean existsByNombreProductoAndPrecioAndStockAndEstado(
            String nombreProducto,
            BigDecimal precio,
            Integer stock,
            Integer estado);
}