/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.lgstc;

import com.upgrade.persistence.model.extcs.Producto;
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

@TableDB(name = "lgstc.ordenes_compra_det", sequence = "lgstc.ordenes_compra_det_id_seq")
public class OrdenCompraDet implements Serializable{
    
    public OrdenCompraDet()
    {
    }
    
    @FieldDB(value = "creado_por")
    public Persona creadoPor;
    
    @FieldDB(value = "editado_por")
    public Persona editadoPor;
    
    @FieldDB(value = "id")
    public Integer id;
      
    @FieldDB(value = "orden_compra_id")
    public OrdenCompraCab ordenCompra;
    
    @FieldDB(value = "producto_id")
    public Producto producto;
    
    @FieldDB(value = "cantidad")
    public BigDecimal cantidad;
    
    @FieldDB(value = "precio_unitario")
    public BigDecimal precioUnitario;
    
    @FieldDB(value = "cantidad_recepcionada")
    public BigDecimal cantidadRecepcionada;
    
    @FieldDB(value = "recepcion_completa")
    public Boolean recepcionCompleta;
    
    @FieldDB(value = "cantidad_recepcionar")
    public BigDecimal cantidadRecepcionar;        
    
    @FieldDB(value = "cantidad_regalos")
    public BigDecimal cantidadRegalos;        

    public Persona getCreadoPor() {
        return creadoPor;
    }

    public void setCreadoPor(Persona creadoPor) {
        this.creadoPor = creadoPor;
    }

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

    public OrdenCompraCab getOrdenCompra() {
        return ordenCompra;
    }

    public void setOrdenCompra(OrdenCompraCab ordenCompra) {
        this.ordenCompra = ordenCompra;
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

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public BigDecimal getCantidadRecepcionada() {
        return cantidadRecepcionada;
    }

    public void setCantidadRecepcionada(BigDecimal cantidadRecepcionada) {
        this.cantidadRecepcionada = cantidadRecepcionada;
    }

    public Boolean getRecepcionCompleta() {
        return recepcionCompleta;
    }

    public void setRecepcionCompleta(Boolean recepcionCompleta) {
        this.recepcionCompleta = recepcionCompleta;
    }

    public BigDecimal getCantidadRecepcionar() {
        return cantidadRecepcionar;
    }

    public void setCantidadRecepcionar(BigDecimal cantidadRecepcionar) {
        this.cantidadRecepcionar = cantidadRecepcionar;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final OrdenCompraDet other = (OrdenCompraDet) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    
}
