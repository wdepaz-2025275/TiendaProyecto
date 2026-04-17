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
        return detalleVentaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Detalle de venta no encontrado"));
    }

    @Override
    public DetalleVenta saveDetalleVenta(DetalleVenta detalleVenta) throws RuntimeException {
        try {
            if (detalleVentaRepository.existsByCantidadAndPrecioUnitarioAndSubtotalAndProductosCodigoProductoAndVentasCodigoVenta(
                    detalleVenta.getCantidad(),
                    detalleVenta.getPrecioUnitario(),
                    detalleVenta.getSubtotal(),
                    detalleVenta.getProductosCodigoProducto(),
                    detalleVenta.getVentasCodigoVenta())) {
                throw new RuntimeException("Ya existe un detalle de venta con estos datos");
            }
            return detalleVentaRepository.save(detalleVenta);
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public DetalleVenta updateDetalleVenta(Integer id, DetalleVenta detalleVenta) {
        DetalleVenta existingDetalle = detalleVentaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("El detalle de venta no existe"));

        if (detalleVentaRepository.existsByCantidadAndPrecioUnitarioAndSubtotalAndProductosCodigoProductoAndVentasCodigoVenta(
                detalleVenta.getCantidad(),
                detalleVenta.getPrecioUnitario(),
                detalleVenta.getSubtotal(),
                detalleVenta.getProductosCodigoProducto(),
                detalleVenta.getVentasCodigoVenta())) {
            throw new RuntimeException("Ya existe un detalle de venta con estos datos");
        }

        existingDetalle.setCantidad(detalleVenta.getCantidad());
        existingDetalle.setPrecioUnitario(detalleVenta.getPrecioUnitario());
        existingDetalle.setSubtotal(detalleVenta.getSubtotal());
        existingDetalle.setProductosCodigoProducto(detalleVenta.getProductosCodigoProducto());
        existingDetalle.setVentasCodigoVenta(detalleVenta.getVentasCodigoVenta());

        return detalleVentaRepository.save(existingDetalle);
    }

    @Override
    public void deleteDetalleVenta(Integer id) {
        if (!detalleVentaRepository.existsById(id)) {
            throw new RuntimeException("Este id no existe");
        }
        detalleVentaRepository.deleteById(id);
    }
}