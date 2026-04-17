package com.wilfreddepaz.tienda.controller;

import com.wilfreddepaz.tienda.entity.Usuarios;
import com.wilfreddepaz.tienda.service.UsuariosService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UsuariosController {

    private final UsuariosService usuariosService;

    public UsuariosController(UsuariosService usuariosService) {
        this.usuariosService = usuariosService;
    }

    @GetMapping("/usuarios")
    public String verUsuarios(Model model) {
        model.addAttribute("listaUsuarios", usuariosService.getAllUsuarios());
        return "usuarios";
    }

    @GetMapping("/usuarios/{id}")
    @ResponseBody
    public Usuarios obtenerUsuario(@PathVariable Integer id) {
        return usuariosService.getUsuarioById(id);
    }

    @PostMapping("/usuarios/api")
    @ResponseBody
    public Usuarios guardarApi(@RequestBody Usuarios usuarios) {
        if (usuarios.getEstado() == null) usuarios.setEstado(1);
        return usuariosService.saveUsuario(usuarios);
    }

    @PutMapping("/usuarios/api/{id}")
    @ResponseBody
    public Usuarios actualizarApi(@PathVariable Integer id, @RequestBody Usuarios usuarios) {
        usuarios.setCodigoUsuario(id);
        return usuariosService.saveUsuario(usuarios);
    }

    @DeleteMapping("/usuarios/{id}")
    @ResponseBody
    public void eliminar(@PathVariable Integer id) {
        usuariosService.deleteUsuario(id);
    }
}