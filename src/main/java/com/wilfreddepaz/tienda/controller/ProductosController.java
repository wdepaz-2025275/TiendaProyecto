package com.wilfreddepaz.tienda.controller;

import com.wilfreddepaz.tienda.entity.Productos;
import com.wilfreddepaz.tienda.service.ProductosService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductosController {

    private final ProductosService productoService;

    public ProductosController(ProductosService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/productos")
    public String verProductos(Model model) {
        model.addAttribute("listaProductos", productoService.getAllProductos());
        return "productos";
    }

    @GetMapping("/productos/{id}")
    @ResponseBody
    public Productos obtenerProducto(@PathVariable Integer id) {
        return productoService.getProductosById(id);
    }

    @PostMapping("/productos")
    @ResponseBody
    public Productos guardar(@RequestBody Productos productos) {
        return productoService.saveProductos(productos);
    }

    @DeleteMapping("/productos/{id}")
    @ResponseBody
    public void eliminar(@PathVariable Integer id) {
        productoService.deleteProductos(id);
    }
}