package com.wilfreddepaz.tienda.repository;

import com.wilfreddepaz.tienda.entity.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientesRepository extends JpaRepository<Clientes, Integer> {

    boolean existsByNombreClienteAndApellidoClienteAndDireccionAndEstado(
            String nombreCliente,
            String apellidoCliente,
            String direccion,
            Integer estado);
}