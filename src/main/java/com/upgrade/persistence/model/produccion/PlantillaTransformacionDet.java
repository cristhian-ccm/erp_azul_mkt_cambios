/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.produccion;

import com.upgrade.persistence.model.extcs.Producto;
import com.upgrade.persistence.model.tcros.Persona;
import ts.com.service.util.db.client.FieldDB;
import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Diego-Javier
 */
@TableDB(name	="produccion.plantilla_transformacion_det", sequence="produccion.plantilla_transformacion_det_id_seq")
public class PlantillaTransformacionDet implements Serializable {
    
    @FieldDB(value = "id")
    public Integer id;
    
    @FieldDB(value = "plantilla_transformacion_id")
    public PlantillaTransformacion plantillaTransformacionId;
    
    @FieldDB(value = "producto_id")
    public Producto productoId;
    
    @FieldDB(value = "creadoPor")
    public Persona creador;
    
    @FieldDB(value = "cantidad")
    public Integer cantidad;
    
    @FieldDB(value = "activo")
    public Boolean activo;
    
    @FieldDB(value = "creacion")
    public Date creacion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PlantillaTransformacion getPlantillaTransformacionId() {
        return plantillaTransformacionId;
    }

    public void setPlantillaTransformacionId(PlantillaTransformacion plantillaTransformacionId) {
        this.plantillaTransformacionId = plantillaTransformacionId;
    }

    public Producto getProductoId() {
        return productoId;
    }

    public void setProductoId(Producto productoId) {
        this.productoId = productoId;
    }
    
     public Persona getCreador() {
        return creador;
    }

    public void setCreador(Persona creador) {
        this.creador = creador;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.id);
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
        final Producto other = (Producto) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
    
    
    
    /*@Override
    public String toString() {
        return numero;
    }*/