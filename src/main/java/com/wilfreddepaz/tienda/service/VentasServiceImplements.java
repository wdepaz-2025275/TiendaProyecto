package com.wilfreddepaz.tienda.service;

import com.wilfreddepaz.tienda.entity.Ventas;
import com.wilfreddepaz.tienda.repository.VentasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentasServiceImplements implements VentasService {

    private final VentasRepository ventasRepository;

    public VentasServiceImplements(VentasRepository ventasRepository) {
        this.ventasRepository = ventasRepository;
    }

    @Override
    public List<Ventas> getAllVentas() {
        return ventasRepository.findAll();
    }

    @Override
    public Ventas getVentasById(Integer id) {
        return ventasRepository.findById(id).orElseThrow(() -> new RuntimeException("Venta no encontrada"));
    }

    @Override
    public Ventas saveVentas(Ventas venta) throws RuntimeException {
        try {
            if (ventasRepository.existsByFechaVentaAndTotalAndEstadoAndClienteDpiClienteAndUsuarioCodigoUsuario(
                    venta.getFechaVenta(),
                    venta.getTotal(),
                    venta.getEstado(),
                    venta.getClienteDpiCliente(),
                    venta.getUsuarioCodigoUsuario())) {
                throw new RuntimeException("Esta venta ya ha sido registrada");
            }
            return ventasRepository.save(venta);
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Ventas updateVentas(Integer id, Ventas venta) {
        Ventas existingVenta = ventasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("La venta no existe"));

        if (ventasRepository.existsByFechaVentaAndTotalAndEstadoAndClienteDpiClienteAndUsuarioCodigoUsuario(
                venta.getFechaVenta(),
                venta.getTotal(),
                venta.getEstado(),
                venta.getClienteDpiCliente(),
                venta.getUsuarioCodigoUsuario())) {
            throw new RuntimeException("Ya existe una venta con estos datos.");
        }

        existingVenta.setFechaVenta(venta.getFechaVenta());
        existingVenta.setTotal(venta.getTotal());
        existingVenta.setEstado(venta.getEstado());
        existingVenta.setClienteDpiCliente(venta.getClienteDpiCliente());
        existingVenta.setUsuarioCodigoUsuario(venta.getUsuarioCodigoUsuario());

        return ventasRepository.save(existingVenta);
    }

    @Override
    public void deleteVentas(Integer id) {
        if (!ventasRepository.existsById(id)) {
            throw new RuntimeException("El ID de la venta no existe");
        }
        ventasRepository.deleteById(id);
    }
}