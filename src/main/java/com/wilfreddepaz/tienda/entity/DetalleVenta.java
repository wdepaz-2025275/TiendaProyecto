package com.wilfreddepaz.tienda.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "DetalleVenta")
public class DetalleVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_detalle_venta")
    private Integer codigoDetalleVenta;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "precio_unitario")
    private Double precioUnitario;

    @Column(name = "subtotal")
    private Double subtotal;

    @Column(name = "productos_codigo_producto")
    private Integer productosCodigoProducto;

    @Column(name = "ventas_codigo_venta")
    private Integer ventasCodigoVenta;

    public DetalleVenta() {
    }

    public Integer getCodigoDetalleVenta() {
        return codigoDetalleVenta;
    }

    public void setCodigoDetalleVenta(Integer codigoDetalleVenta) {
        this.codigoDetalleVenta = codigoDetalleVenta;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Integer getProductosCodigoProducto() {
        return productosCodigoProducto;
    }

    public void setProductosCodigoProducto(Integer productosCodigoProducto) {
        this.productosCodigoProducto = productosCodigoProducto;
    }

    public Integer getVentasCodigoVenta() {
        return ventasCodigoVenta;
    }

    public void setVentasCodigoVenta(Integer ventasCodigoVenta) {
        this.ventasCodigoVenta = ventasCodigoVenta;
    }
}