package com.wilfreddepaz.tienda.controller;

import com.wilfreddepaz.tienda.entity.DetalleVenta;
import com.wilfreddepaz.tienda.service.DetalleVentaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class DetalleVentaController {

    private final DetalleVentaService detalleVentaService;

    public DetalleVentaController(DetalleVentaService detalleVentaService) {
        this.detalleVentaService = detalleVentaService;
    }

    @GetMapping("/detalles")
    public String verDetalles(Model model) {
        model.addAttribute("listaDetalles", detalleVentaService.getAllDetalleVenta());
        model.addAttribute("detalle", new DetalleVenta());
        return "detalles";
    }

    @PostMapping("/detalles/guardar")
    public String guardar(@ModelAttribute("detalle") DetalleVenta detalle) {
        if (detalle.getCantidad() != null && detalle.getPrecioUnitario() != null) {
            detalle.setSubtotal(detalle.getCantidad() * detalle.getPrecioUnitario());
        }
        detalleVentaService.saveDetalleVenta(detalle);
        return "redirect:/detalles";
    }

    @GetMapping("/detalles/buscar")
    public String buscarDetalles(@RequestParam("id") Integer id, Model model) {
        DetalleVenta resultado = detalleVentaService.getDetalleVentaById(id);
        if (resultado != null) {
            model.addAttribute("listaDetalles", List.of(resultado));
        } else {
            model.addAttribute("listaDetalles", detalleVentaService.getAllDetalleVenta());
            model.addAttribute("error", "No se encontró el detalle con ID: " + id);
        }
        model.addAttribute("detalle", new DetalleVenta());
        return "detalles";
    }

    @GetMapping("/detalles/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        detalleVentaService.deleteDetalleVenta(id);
        return "redirect:/detalles";
    }

    @GetMapping("/detalles/api/{id}")
    @ResponseBody
    public DetalleVenta obtenerDetalleApi(@PathVariable Integer id) {
        return detalleVentaService.getDetalleVentaById(id);
    }
}