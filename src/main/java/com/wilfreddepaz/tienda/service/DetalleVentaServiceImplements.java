package com.wilfreddepaz.tienda.service;

import com.wilfreddepaz.tienda.entity.DetalleVenta;
import com.wilfreddepaz.tienda.repository.DetalleVentaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DetalleVentaServiceImplements implements DetalleVentaService {

    private final DetalleVentaRepository detalleVentaRepository;

    public DetalleVentaServiceImplements(DetalleVentaRepository detalleVentaRepository) {
        this.detalleVentaRepository = detalleVentaRepository;
    }

    @Override
    public List<DetalleVenta> getAllDetalleVenta() {
        return detalleVentaRepository.findAll();
    }

    @Override
    public DetalleVenta getDetalleVentaById(Integer id) {
        // Cambiamos el Throw por un orElse(null) para que el modal no explote si no encuentra el ID
        return detalleVentaRepository.findById(id).orElse(null);
    }

    @Override
    public DetalleVenta saveDetalleVenta(DetalleVenta detalleVenta) {
        // Eliminamos la validación 'existsBy' por ahora para facilitar las pruebas.
        // MySQL ya se encarga de validar las Llaves Foráneas.
        try {
            return detalleVentaRepository.save(detalleVenta);
        } catch (Exception e) {
            // Re-lanzamos la excepción para que el Controller la capture
            throw new RuntimeException("Error al guardar: Verifique que ID Venta y Producto existan.");
        }
    }

    @Override
    public DetalleVenta updateDetalleVenta(Integer id, DetalleVenta detalleVenta) {
        DetalleVenta existingDetalle = detalleVentaRepository.findById(id).orElse(null);

        if (existingDetalle != null) {
            existingDetalle.setCantidad(detalleVenta.getCantidad());
            existingDetalle.setPrecioUnitario(detalleVenta.getPrecioUnitario());
            existingDetalle.setSubtotal(detalleVenta.getSubtotal());
            existingDetalle.setProductosCodigoProducto(detalleVenta.getProductosCodigoProducto());
            existingDetalle.setVentasCodigoVenta(detalleVenta.getVentasCodigoVenta());
            return detalleVentaRepository.save(existingDetalle);
        }
        return null;
    }

    @Override
    public void deleteDetalleVenta(Integer id) {
        if (detalleVentaRepository.existsById(id)) {
            detalleVentaRepository.deleteById(id);
        }
    }
}