package com.wilfreddepaz.tienda.repository;

import com.wilfreddepaz.tienda.entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuariosRepository extends JpaRepository<Usuarios, Integer> {

    @Query(value = "SELECT * FROM Usuarios WHERE username = :u AND password = :p AND estado = 1", nativeQuery = true)
    Usuarios findByUsernameAndPassword(@Param("u") String username, @Param("p") String password);
}