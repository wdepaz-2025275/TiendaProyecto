package com.wilfreddepaz.tienda.service;

import com.wilfreddepaz.tienda.entity.Ventas;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VentasService {
    List<Ventas> getAllVentas();
    Ventas getVentasById(Integer id);
    Ventas saveVentas (Ventas ventas) throws RuntimeException;
    Ventas updateVentas(Integer id, Ventas ventas);
    void deleteVentas(Integer id);
}