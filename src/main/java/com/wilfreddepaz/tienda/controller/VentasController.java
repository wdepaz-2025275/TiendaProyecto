package com.wilfreddepaz.tienda.controller;

import com.wilfreddepaz.tienda.entity.Ventas;
import com.wilfreddepaz.tienda.service.VentasService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
public class VentasController {

    private final VentasService ventasService;

    public VentasController(VentasService ventaService) {
        this.ventasService = ventaService;
    }

    @GetMapping("/ventas")
    public String verVentas(Model model) {
        model.addAttribute("listaVentas", ventasService.getAllVentas());
        return "ventas";
    }

    @GetMapping("/ventas/{id}")
    @ResponseBody
    public Ventas obtenerVenta(@PathVariable Integer id) {
        return ventasService.getVentasById(id);
    }

    @PostMapping("/ventas")
    @ResponseBody
    public Ventas guardar(@RequestBody Ventas venta) {
        if (venta.getFechaVenta() == null) {
            venta.setFechaVenta(LocalDate.now());
        }
        return ventasService.saveVentas(venta);
    }

    @DeleteMapping("/ventas/{id}")
    @ResponseBody
    public void eliminar(@PathVariable Integer id) {
        ventasService.deleteVentas(id);
    }
}