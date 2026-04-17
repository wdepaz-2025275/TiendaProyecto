package com.wilfreddepaz.tienda.controller;

import com.wilfreddepaz.tienda.entity.DetalleVenta;
import com.wilfreddepaz.tienda.service.DetalleVentaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DetalleVentaController {

    private final DetalleVentaService detalleVentaService;

    public DetalleVentaController(DetalleVentaService detalleVentaService) {
        this.detalleVentaService = detalleVentaService;
    }

    @GetMapping("/detalles")
    public String verDetalles(Model model) {
        model.addAttribute("listaDetalles", detalleVentaService.getAllDetalleVenta());
        return "detalles";
    }

    @GetMapping("/detalles/{id}")
    @ResponseBody
    public DetalleVenta obtenerDetalle(@PathVariable Integer id) {
        return detalleVentaService.getDetalleVentaById(id);
    }

    @PostMapping("/detalles/api")
    @ResponseBody
    public DetalleVenta guardarApi(@RequestBody DetalleVenta detalle) {
        return detalleVentaService.saveDetalleVenta(detalle);
    }

    @PutMapping("/detalles/api/{id}")
    @ResponseBody
    public DetalleVenta actualizarApi(@PathVariable Integer id, @RequestBody DetalleVenta detalle) {
        detalle.setCodigoDetalleVenta(id);
        return detalleVentaService.saveDetalleVenta(detalle);
    }

    @DeleteMapping("/detalles/{id}")
    @ResponseBody
    public void eliminar(@PathVariable Integer id) {
        detalleVentaService.deleteDetalleVenta(id);
    }
}