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
@TableDB(name="produccion.transformacion", sequence="produccion.transformacion_id_seq")
public class Transformacion implements Serializable {
    @FieldDB(value = "id")
    public Integer id;
    
    @FieldDB(value = "plantilla_transformacion_id")
    public PlantillaTransformacion plantillaTransformacion;
    
    @FieldDB(value = "numero_transformaciones")
    public Integer numeroTransformaciones;
    
    @FieldDB(value = "transformaciones_realizadas")
    public Integer transformacionesRealizadas;
    
    @FieldDB(value = "cantidad_individual")
    public Integer cantidadIndividual;
    
    @FieldDB(value = "producto_id")
    public Producto producto;
    
    @FieldDB(value = "estado")
    public Integer estado;
    
    @FieldDB(value = "creadoPor")
    public Persona creador;
    
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

    public PlantillaTransformacion getPlantillaTransformacion() {
        return plantillaTransformacion;
    }

    public void setPlantillaTransformacion(PlantillaTransformacion plantillaTransformacion) {
        this.plantillaTransformacion = plantillaTransformacion;
    }

    public Integer getNumeroTransformaciones() {
        return numeroTransformaciones;
    }

    public Integer getCantidadIndividual() {
        return cantidadIndividual;
    }

    public void setCantidadIndividual(Integer cantidadIndividual) {
        this.cantidadIndividual = cantidadIndividual;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    

    public void setNumeroTransformaciones(Integer numeroTransformaciones) {
        this.numeroTransformaciones = numeroTransformaciones;
    }

    public Integer getTransformacionesRealizadas() {
        return transformacionesRealizadas;
    }

    public void setTransformacionesRealizadas(Integer transformacionesRealizadas) {
        this.transformacionesRealizadas = transformacionesRealizadas;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Persona getCreador() {
        return creador;
    }

    public void setCreador(Persona creador) {
        this.creador = creador;
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
    
    public String getNumeroPlantillaTransformacion()
    {
        return this.plantillaTransformacion.getNumero();
    }
    
    public String getNombreProducto()
    {
        return this.producto.getNombre();
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
        final Transformacion other = (Transformacion) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
       
    /*@Override
    public String toString() {
        return numero;
    }*/
    
}
