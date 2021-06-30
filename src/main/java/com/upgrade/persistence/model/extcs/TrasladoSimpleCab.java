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
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author JCARLOS
 */

@TableDB(name="extcs.traslados_simple_cab", sequence = "extcs.traslados_simple_cab_id_seq")
public class TrasladoSimpleCab implements Serializable{
    
    @FieldDB(value = "creado_por")
    public Persona creadoPor;
    
    @FieldDB(value = "editado_por")
    public Persona editadoPor;
    
    @FieldDB(value = "id")
    public Integer id;
    
    @FieldDB(value = "numero")
    public Integer numero;
    
    @FieldDB(value = "anulada")
    public Boolean anulada;
    
    @FieldDB(value = "fecha")
    public Date fecha;
    
    @FieldDB(value = "almacen_partida_id")
    public Almacen almacenPartida;
    
    @FieldDB(value = "almacen_llegada_id")
    public Almacen almacenLlegada;
    
    @FieldDB(value = "fecha_recepcion")
    public Date fechaRecepcion;
    
    @FieldDB(value = "recepcionada")
    public Boolean recepcionada;
    
    @FieldDB(value = "recepcionada_por")
    public Persona recepcionadaPor;
    
    @FieldDB(value = "observacion")
    public String observacion;

    public Persona getCreadoPor() {
        return creadoPor;
    }

    public void setCreadoPor(Persona creadoPor) {
        this.creadoPor = creadoPor;
    }

    public Persona getEditadoPor() {
        return editadoPor;
    }

    public void setEditadoPor(Persona editadoPor) {
        this.editadoPor = editadoPor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Boolean getAnulada() {
        return anulada;
    }

    public void setAnulada(Boolean anulada) {
        this.anulada = anulada;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Almacen getAlmacenPartida() {
        return almacenPartida;
    }

    public void setAlmacenPartida(Almacen almacenPartida) {
        this.almacenPartida = almacenPartida;
    }

    public Almacen getAlmacenLlegada() {
        return almacenLlegada;
    }

    public void setAlmacenLlegada(Almacen almacenLlegada) {
        this.almacenLlegada = almacenLlegada;
    }

    public Date getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(Date fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public Boolean getRecepcionada() {
        return recepcionada;
    }

    public void setRecepcionada(Boolean recepcionada) {
        this.recepcionada = recepcionada;
    }

    public Persona getRecepcionadaPor() {
        return recepcionadaPor;
    }

    public void setRecepcionadaPor(Persona recepcionadaPor) {
        this.recepcionadaPor = recepcionadaPor;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }    
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
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
        final TrasladoSimpleCab other = (TrasladoSimpleCab) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
       
    
}
