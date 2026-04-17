package com.wilfreddepaz.tienda.repository;

import com.wilfreddepaz.tienda.entity.Ventas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;

@Repository
public interface VentasRepository extends JpaRepository<Ventas, Integer> {

    boolean existsByFechaVentaAndTotalAndEstadoAndClienteDpiClienteAndUsuarioCodigoUsuario(
            LocalDate fechaVenta,
            BigDecimal total,
            Integer estado,
            Integer clienteDpiCliente,
            Integer usuarioCodigoUsuario);
}