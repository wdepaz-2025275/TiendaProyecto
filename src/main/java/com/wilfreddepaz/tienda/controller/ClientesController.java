package com.wilfreddepaz.tienda.controller;

import com.wilfreddepaz.tienda.entity.Clientes;
import com.wilfreddepaz.tienda.service.ClientesService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clientes")
public class ClientesController {

    private final ClientesService clientesService;

    public ClientesController(ClientesService clientesService) {
        this.clientesService = clientesService;
    }

    @GetMapping
    public String getAllClientes(Model model) {
        model.addAttribute("clientes", clientesService.getAllClientes());
        return "clientes"; // clientes.html en templates
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Clientes getClientesById(@PathVariable Integer id) {
        return clientesService.getClientesById(id);
    }

    @PostMapping
    @ResponseBody
    public Clientes createClientes(@Valid @RequestBody Clientes cliente) {
        return clientesService.saveClientes(cliente);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public Clientes updateClientes(@PathVariable Integer id,
                                   @Valid @RequestBody Clientes cliente) {
        return clientesService.updateClientes(id, cliente);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void deleteClientes(@PathVariable Integer id) {
        clientesService.deleteClientes(id);
    }
}