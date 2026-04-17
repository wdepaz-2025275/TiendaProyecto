package com.wilfreddepaz.tienda.repository;

import com.wilfreddepaz.tienda.entity.DetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, Integer> {

    boolean existsByCantidadAndPrecioUnitarioAndSubtotalAndProductosCodigoProductoAndVentasCodigoVenta(
            Integer cantidad,
            Double precioUnitario,
            Double subtotal,
            Integer productosCodigoProducto,
            Integer ventasCodigoVenta);
}