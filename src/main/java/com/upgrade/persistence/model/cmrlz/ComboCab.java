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
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author darko
 */
@TableDB(name = "cmrlz.combo_cab", sequence = "cmrlz.combo_cab_id_seq")
public class ComboCab implements Serializable {

    public Integer id;
    
    @FieldDB(value = "creado_por")
    public Persona creadoPor;    

    public Date editado;
    
    @FieldDB(value = "editado_por")
    public Persona editadoPor;    
  
    @FieldDB(value = "fecha_inicio")
    public Date fechaInicio;
    
    @FieldDB(value = "fecha_fin")
    public Date fechaFin;

    @FieldDB(value = "producto_id")
    public Producto producto;

    @FieldDB(value = "cant_max_regalo")
    public Integer cantMaxRegalo;

    public String observacion;

    public Boolean activo;

    public Boolean anulada;    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Persona getCreadoPor() {
        return creadoPor;
    }

    public void setCreadoPor(Persona creadoPor) {
        this.creadoPor = creadoPor;
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

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getCantMaxRegalo() {
        return cantMaxRegalo;
    }

    public void setCantMaxRegalo(Integer cantMaxRegalo) {
        this.cantMaxRegalo = cantMaxRegalo;
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

    public Boolean getAnulada() {
        return anulada;
    }

    public void setAnulada(Boolean anulada) {
        this.anulada = anulada;
    }   

    @Override
    public int hashCode() {
        int hash = 3;
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
        final ComboCab other = (ComboCab) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    


}
