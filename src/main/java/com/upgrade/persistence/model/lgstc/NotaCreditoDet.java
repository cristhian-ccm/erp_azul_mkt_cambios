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
@TableDB(name="lgstc.nota_credito_det", sequence= "lgstc.nota_credito_det_id_seq")
public class NotaCreditoDet implements Serializable{
    
   public NotaCreditoDet(){
    } 
   
   
    @FieldDB(value = "id")
    public Integer id;
    
    @FieldDB(value = "nota_credito_id")
    public NotaCreditoCab notaCredito;
    
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public NotaCreditoCab getNotaCredito() {
        return notaCredito;
    }

    public void setNotaCredito(NotaCreditoCab notaCredito) {
        this.notaCredito = notaCredito;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        final NotaCreditoDet other = (NotaCreditoDet) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
}
