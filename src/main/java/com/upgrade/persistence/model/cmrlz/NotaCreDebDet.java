/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.cmrlz;

import com.upgrade.persistence.model.extcs.Producto;
import com.upgrade.persistence.model.tcros.Persona;
import ts.com.service.util.db.client.FieldDB;
import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author darko
 */
@TableDB(name = "cmrlz.nota_credeb_det", sequence = "cmrlz.nota_credeb_det_id_seq")
public class NotaCreDebDet implements Serializable {

    @FieldDB(value = "creado_por")
    public Persona creadoPor;
    
    @FieldDB(value = "creado")
    public Date creado;

    @FieldDB(value = "id")
    public Integer id;

    @FieldDB(value = "editado")
    public Date editado;

    @FieldDB(value = "editado_por")
    public Persona editadoPor;

    @FieldDB(value = "nota_credeb_id")
    public NotaCreDebCap notaCreDeb;

    @FieldDB(value = "regalo")
    public Boolean regalo;
    
    @FieldDB(value = "producto_id")
    public Producto producto;

    @FieldDB(value = "cantidad")
    public BigDecimal cantidad;

    @FieldDB(value = "precio_unitario_producto")
    public BigDecimal precioUnitario;

    @FieldDB(value = "precio_unitario_venta")
    public BigDecimal precioUnitarioVenta;

    @FieldDB(value = "precio_venta")
    public BigDecimal precioVenta;

    public Persona getCreadoPor() {
        return creadoPor;
    }

    public void setCreadoPor(Persona creadoPor) {
        this.creadoPor = creadoPor;
    }

    public Date getCreado() {
        return creado;
    }

    public void setCreado(Date creado) {
        this.creado = creado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getEditado() {
        return editado;
    }

    public void setEditado(Date editado) {
        this.editado = editado;
    }

    public Persona getEditadoPor() {
        return editadoPor;
    }

    public void setEditadoPor(Persona editadoPor) {
        this.editadoPor = editadoPor;
    }

    public NotaCreDebCap getNotaCreDeb() {
        return notaCreDeb;
    }

    public void setNotaCreDeb(NotaCreDebCap notaCreDeb) {
        this.notaCreDeb = notaCreDeb;
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

    public BigDecimal getPrecioUnitarioVenta() {
        return precioUnitarioVenta;
    }

    public void setPrecioUnitarioVenta(BigDecimal precioUnitarioVenta) {
        this.precioUnitarioVenta = precioUnitarioVenta;
    }

    public BigDecimal getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(BigDecimal precioVenta) {
        this.precioVenta = precioVenta;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
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
        final NotaCreDebDet other = (NotaCreDebDet) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    

}
