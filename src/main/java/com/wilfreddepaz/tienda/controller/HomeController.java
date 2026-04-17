package com.wilfreddepaz.tienda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/Home")
    public String mostrarHome() {
        return "Home";
    }

    @GetMapping("/usuario")
    public String mostrarUsuario() {
        return "usuario";
    }
}