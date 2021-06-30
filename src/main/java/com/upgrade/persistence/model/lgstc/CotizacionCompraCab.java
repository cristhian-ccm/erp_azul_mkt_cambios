/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.lgstc;


import com.upgrade.persistence.model.tcros.Persona;
import ts.com.service.util.db.client.FieldDB;
import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author upgrade
 */
@TableDB(name="lgstc.cotizacion_compra_cab",sequence="lgstc.cotizacion_compra_cab_id_seq")
public class CotizacionCompraCab implements Serializable{
  
    @FieldDB(value = "id")
    public Integer id;
 
    @FieldDB(value = "usuario_creador")
    public Persona usuarioCreador;

    @FieldDB(value = "editado_por")
    public Persona editadoPor;

    @FieldDB(value = "numero")
    public Integer numero;

    @FieldDB(value = "fecha")
    public Date fecha;

    @FieldDB(value = "anulada")
    public Boolean anulada;

    @FieldDB(value = "observacion")
    public String observacion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Persona getUsuarioCreador() {
        return usuarioCreador;
    }

    public void setUsuarioCreador(Persona usuarioCreador) {
        this.usuarioCreador = usuarioCreador;
    }

    public Persona getEditadoPor() {
        return editadoPor;
    }

    public void setEditadoPor(Persona editadoPor) {
        this.editadoPor = editadoPor;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Boolean getAnulada() {
        return anulada;
    }

    public void setAnulada(Boolean anulada) {
        this.anulada = anulada;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    } 
  
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final CotizacionCompraCab other = (CotizacionCompraCab) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}