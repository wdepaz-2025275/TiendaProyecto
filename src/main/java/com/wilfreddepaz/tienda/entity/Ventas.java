package com.wilfreddepaz.tienda.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Ventas")
public class Ventas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_venta")
    private Integer codigoVenta;

    @Column(name = "fecha_venta")
    private LocalDate fechaVenta;

    @Column(name = "total")
    private BigDecimal total;

    @Column(name = "estado")
    private Integer estado;

    @Column(name = "clientes_dpi_cliente")
    private Integer clienteDpiCliente;

    @Column(name = "usuarios_codigo_usuario")
    private Integer usuarioCodigoUsuario;

    public Integer getCodigoVenta() {
        return codigoVenta;
    }

    public void setCodigoVenta(Integer codigoVenta) {
        this.codigoVenta = codigoVenta;
    }

    public LocalDate getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDate fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Integer getClienteDpiCliente() {
        return clienteDpiCliente;
    }

    public void setClienteDpiCliente(Integer clienteDpiCliente) {
        this.clienteDpiCliente = clienteDpiCliente;
    }

    public Integer getUsuarioCodigoUsuario() {
        return usuarioCodigoUsuario;
    }

    public void setUsuarioCodigoUsuario(Integer usuarioCodigoUsuario) {
        this.usuarioCodigoUsuario = usuarioCodigoUsuario;
    }
}