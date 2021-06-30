/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.extcs;

import ts.com.service.util.db.client.FieldDB;
import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author evander
 */
@TableDB(name = "extcs.ordenes_det", sequence= "extcs.ordenes_det_id_seq")
public class OrdenDet implements Serializable {

    public OrdenDet() {
        //super.tableName = "extcs.ordenes_det";
        //super.sequenceName = "extcs.ordenes_det_id_seq";
    }
    
    @FieldDB(value = "id")
    public Integer id;
    
    @FieldDB(value = "orden_id")
    public OrdenCab ordenCab;
    
    @FieldDB(value = "articulo_id")
    public Articulo articulo;
    
    @FieldDB(value = "cantidad")
    public BigDecimal cantidad;
    
    @FieldDB(value = "articulo_padre_id")
    public Articulo articulo_padre;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public OrdenCab getOrdenCab() {
        return ordenCab;
    }

    public void setOrdenCab(OrdenCab ordenCab) {
        this.ordenCab = ordenCab;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }
    
    public String getSerieArticulo()
    {
        return this.articulo.getSerie();
    }
    
    public String getSerieArticuloPadre()
    {
        if (this.articulo_padre != null)
            return this.articulo_padre.getSerie();
        else
            return "VACIO";
    }
    
    public int getArticuloId()
    {
        return this.articulo.getId();
    }
    
    public String getAlmacenId()
    {
        return this.articulo.getAlmacen()==null?"NO ESTA EN ALMACEN":"ESTA EN ALMACEN";
    }

    public Articulo getArticulo_padre() {
        return articulo_padre;
    }

    public void setArticulo_padre(Articulo articulo_padre) {
        this.articulo_padre = articulo_padre;
    }
    
    public String getNombreProductoFinal(){
        return this.ordenCab.getTransformacion().getProducto().getNombre();
    }
    
    public String getNombreProductoItem(){
        return this.articulo.getProducto().getNombre();
    }
    
    
    public int getIdTransformacion(){
        return this.ordenCab.getTransformacion().getId();
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
        final OrdenDet other = (OrdenDet) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
