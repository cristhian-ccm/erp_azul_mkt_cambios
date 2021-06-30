/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.cmrlz;

import com.upgrade.persistence.model.extcs.Producto;
import com.upgrade.persistence.model.lgstc.SolicitudCompra;
import com.upgrade.persistence.model.tcros.Persona;
import ts.com.service.util.db.client.FieldDB;
import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author USER
 */
@TableDB(name = "cmrlz.notas_pedido_det", sequence = "cmrlz.notas_pedido_det_id_seq")
public class NotaPedidoDet implements Serializable {

    @FieldDB(value = "editado_por")
    public Persona editadoPor;

    @FieldDB(value = "id")
    public Integer id;

    @FieldDB(value = "nota_pedido_id")   //cabecera
    public NotaPedidoCab notaPedido;

    @FieldDB(value = "exonerado")
    public Boolean exonerado;

    @FieldDB(value = "regalo")
    public Boolean regalo;

    @FieldDB(value = "producto_id")
    public Producto producto;

    @FieldDB(value = "producto_cambio_id")
    public Producto productoCambio;

    @FieldDB(value = "cantidad")
    public BigDecimal cantidad;

    @FieldDB(value = "precio_unitario_producto")
    public BigDecimal precioUnitarioProducto;

    @FieldDB(value = "precio_unitario_nota")
    public BigDecimal precioUnitarioNota;

    @FieldDB(value = "cantidad_entregada")
    public BigDecimal cantidadEntregada;

    @FieldDB(value = "entrega_completa")
    public Boolean entregaCompleta;

    @FieldDB(value = "precio_unitario_venta_real")
    public BigDecimal precioUnitarioVentaReal;

    @FieldDB(value = "precio_unitario_venta")
    public BigDecimal precioUnitarioVenta;

    @FieldDB(value = "solicitud_compra_id")
    public SolicitudCompra solicitudCompra;
      
    public Persona getEditadoPor() {
        return editadoPor;
    }

    public void setEditadoPor(Persona editadoPor) {
        this.editadoPor = editadoPor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public NotaPedidoCab getNotaPedido() {
        return notaPedido;
    }

    public void setNotaPedido(NotaPedidoCab notaPedido) {
        this.notaPedido = notaPedido;
    }

    public Boolean getExonerado() {
        return exonerado;
    }

    public void setExonerado(Boolean exonerado) {
        this.exonerado = exonerado;
    }

    public Boolean getRegalo() {
        return regalo;
    }

    public void setRegalo(Boolean regalo) {
        this.regalo = regalo;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Producto getProductoCambio() {
        return productoCambio;
    }

    public void setProductoCambio(Producto productoCambio) {
        this.productoCambio = productoCambio;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecioUnitarioProducto() {
        return precioUnitarioProducto;
    }

    public void setPrecioUnitarioProducto(BigDecimal precioUnitarioProducto) {
        this.precioUnitarioProducto = precioUnitarioProducto;
    }

    public BigDecimal getPrecioUnitarioNota() {
        return precioUnitarioNota;
    }

    public void setPrecioUnitarioNota(BigDecimal precioUnitarioNota) {
        this.precioUnitarioNota = precioUnitarioNota;
    }

    public BigDecimal getCantidadEntregada() {
        return cantidadEntregada;
    }

    public void setCantidadEntregada(BigDecimal cantidadEntregada) {
        this.cantidadEntregada = cantidadEntregada;
    }

    public Boolean getEntregaCompleta() {
        return entregaCompleta;
    }

    public void setEntregaCompleta(Boolean entregaCompleta) {
        this.entregaCompleta = entregaCompleta;
    }

    public BigDecimal getPrecioUnitarioVentaReal() {
        return precioUnitarioVentaReal;
    }

    public void setPrecioUnitarioVentaReal(BigDecimal precioUnitarioVentaReal) {
        this.precioUnitarioVentaReal = precioUnitarioVentaReal;
    }

    public BigDecimal getPrecioUnitarioVenta() {
        return precioUnitarioVenta;
    }

    public void setPrecioUnitarioVenta(BigDecimal precioUnitarioVenta) {
        this.precioUnitarioVenta = precioUnitarioVenta;
    }

    public SolicitudCompra getSolicitudCompra() {
        return solicitudCompra;
    }

    public void setSolicitudCompra(SolicitudCompra solicitudCompra) {
        this.solicitudCompra = solicitudCompra;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final NotaPedidoDet other = (NotaPedidoDet) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
