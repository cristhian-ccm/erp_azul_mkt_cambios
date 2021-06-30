/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.cmrlz;

import com.upgrade.persistence.model.extcs.Producto;
import ts.com.service.util.db.client.FieldDB;
import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author Evander
 */
@TableDB(name	="cmrlz.ventas_det",
sequence="cmrlz.ventas_det_id_seq")
public class VentaDet implements Serializable {

    public VentaDet() {
        
    }
    
    @FieldDB(value = "id")
    public Integer id;
    
    @FieldDB(value = "creado_por")
    public Integer creado;
    
    @FieldDB(value = "venta_id")
    public VentaCab venta;
    
    @FieldDB(value = "producto_id")
    public Producto producto;
    
    @FieldDB(value = "cantidad")
    public BigDecimal cantidad;
    
    @FieldDB(value = "precio_unitario_producto")
    public BigDecimal precioUnitarioProducto;
    
    @FieldDB(value = "utilidad")
    public BigDecimal utilidad;
    
    @FieldDB(value = "precio_unitario_venta")
    public BigDecimal precioUnitarioVenta;
    
    @FieldDB(value = "exonerado")
    public Boolean exonerado;
    
    @FieldDB(value = "regalo")
    public Boolean regalo;
    
    //Valor Unitario con IGV
    @FieldDB(value = "precio_venta")
    public BigDecimal precioVenta;
    
    @FieldDB(value = "cod_sunat")
    public String cod_sunat;

    @FieldDB(value = "subtotal")
    public BigDecimal subtotal;

    @FieldDB(value = "tipo_de_igv")
    public Integer tipo_de_igv;

    @FieldDB(value = "igv")
    public BigDecimal igv;
    
    @FieldDB(value = "unidad_de_medida")
    public String unidad_de_medida;

    @FieldDB(value = "descripcion")
    public String descripcion; 
    
    @FieldDB(value = "total")
    public BigDecimal total;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCreado() {
        return creado;
    }

    public void setCreado(Integer creado) {
        this.creado = creado;
    }

    public VentaCab getVenta() {
        return venta;
    }

    public void setVenta(VentaCab venta) {
        this.venta = venta;
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

    public BigDecimal getPrecioUnitarioProducto() {
        return precioUnitarioProducto;
    }

    public void setPrecioUnitarioProducto(BigDecimal precioUnitarioProducto) {
        this.precioUnitarioProducto = precioUnitarioProducto;
    }

    public BigDecimal getUtilidad() {
        return utilidad;
    }

    public void setUtilidad(BigDecimal utilidad) {
        this.utilidad = utilidad;
    }

    public BigDecimal getPrecioUnitarioVenta() {
        return precioUnitarioVenta;
    }

    public void setPrecioUnitarioVenta(BigDecimal precioUnitarioVenta) {
        this.precioUnitarioVenta = precioUnitarioVenta;
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

    public BigDecimal getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(BigDecimal precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getCod_sunat() {
        return cod_sunat;
    }

    public void setCod_sunat(String cod_sunat) {
        this.cod_sunat = cod_sunat;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public Integer getTipo_de_igv() {
        return tipo_de_igv;
    }

    public void setTipo_de_igv(Integer tipo_de_igv) {
        this.tipo_de_igv = tipo_de_igv;
    }

    public BigDecimal getIgv() {
        return igv;
    }

    public void setIgv(BigDecimal igv) {
        this.igv = igv;
    }

    public String getUnidad_de_medida() {
        return unidad_de_medida;
    }

    public void setUnidad_de_medida(String unidad_de_medida) {
        this.unidad_de_medida = unidad_de_medida;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getNombreProducto()
    {
        return this.producto.getNombre();
    }        
       
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final VentaDet other = (VentaDet) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
    
}
