package com.wilfreddepaz.tienda.controller;

import com.wilfreddepaz.tienda.entity.Usuarios;
import com.wilfreddepaz.tienda.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistroController {

    @Autowired
    private UsuariosService usuariosService;

    @GetMapping("/registro")
    public String vistaRegistro() {
        return "registro";
    }

    @PostMapping("/registro")
    public String registrarNuevoUsuario(@RequestParam("usuario") String username,
                                        @RequestParam("password") String password,
                                        Model model) {
        try {
            Usuarios nuevo = new Usuarios();
            nuevo.setUsername(username);
            nuevo.setPassword(password);
            nuevo.setEstado(1);

            usuariosService.saveUsuario(nuevo);

            model.addAttribute("success", "Usuario '" + username + "' creado exitosamente. Ya puedes ingresar.");
            return "registro";
        } catch (Exception e) {
            model.addAttribute("error", "Error: El nombre de usuario ya existe o los datos son inválidos.");
            return "registro";
        }
    }
}