/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.produccion;

  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
@TableDB(name="produccion.plantilla_transformacion", sequence="produccion.plantilla_transformacion_id_seq")
public class PlantillaTransformacion implements Serializable {
    
    @FieldDB(value = "id")
    public Integer id;
    
    @FieldDB(value = "producto_id")
    public Producto productoId;
    
    @FieldDB(value = "creadoPor")
    public Persona creador;
    
    @FieldDB(value = "numero")
    public String numero;
    
    @FieldDB(value = "observacion")
    public String observacion;
    
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

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Date getCreacion() {
        return creacion;
    }

    public void setCreacion(Date creacion) {
        this.creacion = creacion;
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
        final PlantillaTransformacion other = (PlantillaTransformacion) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return numero + " - " + productoId.nombre;
    }
    
}

