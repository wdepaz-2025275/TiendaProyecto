package com.wilfreddepaz.tienda.service;

import com.wilfreddepaz.tienda.entity.Productos;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductosService {
    List<Productos> getAllProductos();
    Productos getProductosById(Integer id);
    Productos saveProductos(Productos productos) throws RuntimeException;
    Productos updateProductos(Integer id, Productos productos);
    void deleteProductos(Integer id);
}