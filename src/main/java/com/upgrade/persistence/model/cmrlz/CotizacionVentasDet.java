/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.cmrlz;

import com.upgrade.persistence.model.Moneda;
import com.upgrade.persistence.model.extcs.Producto;
import ts.com.service.util.db.client.FieldDB;
import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author JCARLOS TIPO
 */
@TableDB(name = "cmrlz.cotizacion_ventas_det" , sequence = "cmrlz.cotizacion_ventas_det_id_seq")
public class CotizacionVentasDet implements Serializable {
    @FieldDB(value = "id")
    public Integer id;
    
    @FieldDB(value = "cotizacion_id")
    public CotizacionVentasCab cotizacion;
    
    @FieldDB(value = "producto_id")
    public Producto producto;
    
    @FieldDB(value = "cantidad")
    public Integer cantidad;
    
    @FieldDB(value = "precio_unitario")
    public BigDecimal precioUnitario;
    
    @FieldDB(value = "total")
    public BigDecimal total;
    
    @FieldDB(value = "regalo")
    public Boolean regalo;

    @FieldDB(value = "precio_producto")
    public BigDecimal precioProducto;
    
    @FieldDB(value = "moneda_id")
    public Moneda monedaId;
    
    @FieldDB(value = "precio_unitario_real")
    public BigDecimal precioUnitarioReal;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CotizacionVentasCab getCotizacion() {
        return cotizacion;
    }

    public void setCotizacion(CotizacionVentasCab cotizacion) {
        this.cotizacion = cotizacion;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Boolean getRegalo() {
        return regalo;
    }

    public void setRegalo(Boolean regalo) {
        this.regalo = regalo;
    }

    public BigDecimal getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(BigDecimal precioProducto) {
        this.precioProducto = precioProducto;
    }

    public Moneda getMonedaId() {
        return monedaId;
    }

    public void setMonedaId(Moneda monedaId) {
        this.monedaId = monedaId;
    }

    public BigDecimal getPrecioUnitarioReal() {
        return precioUnitarioReal;
    }

    public void setPrecioUnitarioReal(BigDecimal precioUnitarioReal) {
        this.precioUnitarioReal = precioUnitarioReal;
    }
    
    
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.id);
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
        final CotizacionVentasDet other = (CotizacionVentasDet) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
}
