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

    @GetMapping("/registro")
    public String mostrarFormularioRegistro() {
        return "registro";
    }

    @PostMapping("/registro")
    public String registrarNuevoUsuario(@ModelAttribute Usuarios usuarios, Model model) {
        try {
            usuarios.setEstado(1); // 1 = Activo
            usuarios.setRol("USER"); // Rol por defecto

            if (usuarios.getEmail() == null || usuarios.getEmail().isEmpty()) {
                usuarios.setEmail(usuarios.getUsername() + "@tienda.com");
            }

            usuariosService.saveUsuario(usuarios);
            model.addAttribute("success", "¡Cuenta creada con éxito! Ahora puedes iniciar sesión.");

        } catch (Exception e) {
            model.addAttribute("error", "Error al registrar el usuario: " + e.getMessage());
        }
        return "registro";
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

    @DeleteMapping("/usuarios/{id}")
    @ResponseBody
    public void eliminar(@PathVariable Integer id) {
        usuariosService.deleteUsuario(id);
    }
}