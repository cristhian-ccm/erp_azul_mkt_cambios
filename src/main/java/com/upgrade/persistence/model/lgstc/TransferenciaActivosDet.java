/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.lgstc;

import com.upgrade.persistence.model.extcs.Producto;
import ts.com.service.util.db.client.FieldDB;
import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author USER
 */
@TableDB(name="lgstc.transferencia_activos_det", sequence= "lgstc.transferencia_activos_det_id_seq")
public class TransferenciaActivosDet implements Serializable{
    public TransferenciaActivosDet(){
    }
    
    @FieldDB(value = "id")
    public Integer id;
    
    @FieldDB(value = "transferencia_activo_id")
    public TransferenciaActivosCab transferenciaActivo;
    
    @FieldDB(value = "producto_id")
    public Producto producto;
    
    @FieldDB(value = "cantidad")
    public BigDecimal cantidad;
    
    @FieldDB(value = "cantidad_entregada")
    public BigDecimal cantidadEntregada;
       
    @FieldDB(value = "precio_unitario")
    public BigDecimal precioUnitario;
    
    @FieldDB(value = "precio_unitario_nota")
    public BigDecimal precioUnitarioNota;
    
    @FieldDB(value = "recepcion_completa")
    public Boolean recepcionCompleta;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TransferenciaActivosCab getTransferenciaActivo() {
        return transferenciaActivo;
    }

    public void setTransferenciaActivo(TransferenciaActivosCab transferenciaActivo) {
        this.transferenciaActivo = transferenciaActivo;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getCantidadEntregada() {
        return cantidadEntregada;
    }

    public void setCantidadEntregada(BigDecimal cantidadEntregada) {
        this.cantidadEntregada = cantidadEntregada;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public BigDecimal getPrecioUnitarioNota() {
        return precioUnitarioNota;
    }

    public void setPrecioUnitarioNota(BigDecimal precioUnitarioNota) {
        this.precioUnitarioNota = precioUnitarioNota;
    }

    public Boolean getRecepcionCompleta() {
        return recepcionCompleta;
    }

    public void setRecepcionCompleta(Boolean recepcionCompleta) {
        this.recepcionCompleta = recepcionCompleta;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.id);
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
        final TransferenciaActivosDet other = (TransferenciaActivosDet) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
 
    
}
