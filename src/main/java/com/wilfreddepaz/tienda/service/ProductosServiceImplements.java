package com.wilfreddepaz.tienda.service;

import com.wilfreddepaz.tienda.entity.Productos;
import com.wilfreddepaz.tienda.repository.ProductosRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductosServiceImplements implements ProductosService {

    private final ProductosRepository productosRepository;

    public ProductosServiceImplements(ProductosRepository productosRepository) {
        this.productosRepository = productosRepository;
    }

    @Override
    public List<Productos> getAllProductos() {
        return productosRepository.findAll();
    }

    @Override
    public Productos getProductosById(Integer id) {
        return productosRepository.findById(id).orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    @Override
    public Productos saveProductos(Productos producto) throws RuntimeException {
        try {
            if (productosRepository.existsByNombreProductoAndPrecioAndStockAndEstado(
                    producto.getNombreProducto(),
                    producto.getPrecio(),
                    producto.getStock(),
                    producto.getEstado())) {
                throw new RuntimeException("Ya existe un producto con estos datos exactos");
            }
            return productosRepository.save(producto);
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Productos updateProductos(Integer id, Productos producto) {

        Productos existingProducto = productosRepository.findById(id) .orElseThrow(() -> new RuntimeException("El producto no existe"));

        if (productosRepository.existsByNombreProductoAndPrecioAndStockAndEstado(
                producto.getNombreProducto(),
                producto.getPrecio(),
                producto.getStock(),
                producto.getEstado())) {
            throw new RuntimeException("Ya existe un producto con estos datos");
        }

        existingProducto.setNombreProducto(producto.getNombreProducto());
        existingProducto.setPrecio(producto.getPrecio());
        existingProducto.setStock(producto.getStock());
        existingProducto.setEstado(producto.getEstado());

        return productosRepository.save(existingProducto);
    }

    @Override
    public void deleteProductos(Integer id) {
        if (!productosRepository.existsById(id)) {
            throw new RuntimeException("Este id de producto no existe");
        }
        productosRepository.deleteById(id);
    }
}