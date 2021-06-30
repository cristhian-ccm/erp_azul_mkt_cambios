/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.extcs;

import com.upgrade.persistence.model.tcros.Persona;
import ts.com.service.util.db.client.FieldDB;
import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author Evander
 */

@TableDB(name="extcs.articulos", sequence="extcs.articulos_id_seq")
public class Articulo implements Serializable {
    
    @FieldDB(value = "id")
    public Integer id;
    
    @FieldDB(value = "producto_id")
    public Producto producto;
    
    @FieldDB(value = "creado_por")
    public Persona creado;
    
    @FieldDB(value = "inactivo")
    public Boolean inactivo;
    
    @FieldDB(value = "serie")
    public String serie;
    
    @FieldDB(value = "serie_compra")
    public String serieCompra;
    
    @FieldDB(value = "almacen_id")
    public Almacen almacen;
    
    @FieldDB(value = "articulo_origen_id")
    public Articulo articuloOrigen;
    
    @FieldDB(value = "volumen")
    public BigDecimal volumen;
    
    @FieldDB(value = "estado")
    public String estado;
    
    @FieldDB(value = "observaciones")
    public String observaciones;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Persona getCreado() {
        return creado;
    }

    public void setCreado(Persona creado) {
        this.creado = creado;
    }

    public Boolean getInactivo() {
        return inactivo;
    }

    public void setInactivo(Boolean inactivo) {
        this.inactivo = inactivo;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getSerieCompra() {
        return serieCompra;
    }

    public void setSerieCompra(String serieCompra) {
        this.serieCompra = serieCompra;
    }

    public Almacen getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }

    public Articulo getArticuloOrigen() {
        return articuloOrigen;
    }

    public void setArticuloOrigen(Articulo articuloOrigen) {
        this.articuloOrigen = articuloOrigen;
    }

    public BigDecimal getVolumen() {
        return volumen;
    }

    public void setVolumen(BigDecimal volumen) {
        this.volumen = volumen;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Override
    public String toString() {
        return serie;
    }
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
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
        final Articulo other = (Articulo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
}
