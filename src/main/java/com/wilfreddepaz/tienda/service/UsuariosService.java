package com.wilfreddepaz.tienda.service;

import com.wilfreddepaz.tienda.entity.Usuarios;
import java.util.List;

public interface UsuariosService {
    List<Usuarios> getAllUsuarios();
    Usuarios getUsuarioById(Integer id);
    Usuarios saveUsuario(Usuarios usuario) throws RuntimeException;
    Usuarios updateUsuario(Integer id, Usuarios usuario);
    void deleteUsuario(Integer id);

    Usuarios validarCredenciales(String username, String password);
}