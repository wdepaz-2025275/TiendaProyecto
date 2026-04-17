package com.wilfreddepaz.tienda.service;

import com.wilfreddepaz.tienda.entity.Usuarios;
import com.wilfreddepaz.tienda.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuariosServiceImplements implements UsuariosService {

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Override
    public List<Usuarios> getAllUsuarios() {
        return usuariosRepository.findAll();
    }

    @Override
    public Usuarios getUsuarioById(Integer id) {
        return usuariosRepository.findById(id).orElse(null);
    }

    @Override
    public Usuarios saveUsuario(Usuarios usuario) {
        return usuariosRepository.save(usuario);
    }

    @Override
    public Usuarios updateUsuario(Integer id, Usuarios usuario) {
        Usuarios existente = usuariosRepository.findById(id).orElse(null);
        if (existente != null) {
            existente.setUsername(usuario.getUsername());
            existente.setPassword(usuario.getPassword());
            existente.setEmail(usuario.getEmail());
            existente.setRol(usuario.getRol());
            existente.setEstado(usuario.getEstado());
            return usuariosRepository.save(existente);
        }
        return null;
    }

    @Override
    public void deleteUsuario(Integer id) {
        usuariosRepository.deleteById(id);
    }

    @Override
    public Usuarios validarCredenciales(String username, String password) {
        return usuariosRepository.findByUsernameAndPassword(username, password);
    }
}