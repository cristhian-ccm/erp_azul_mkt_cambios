/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.lgstc;

import com.upgrade.persistence.model.tcros.Direccion;
import com.upgrade.persistence.model.tcros.Persona;
import ts.com.service.util.db.client.FieldDB;
import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;
import java.util.Objects;


/**
 *
 * @author Upgrade
 */
@TableDB(name = "lgstc.proveedor", sequence = "lgstc.proveedor_id_seq")
public class Proveedor implements Serializable {

   @FieldDB(value = "id")
    public Integer id;

    @FieldDB(value = "usuario_creador")
    public Persona usuarioCreador;

    @FieldDB(value = "editado_por")
    public Persona editadoPor;

    @FieldDB(value = "cotizacion_compra_id")
    public CotizacionCompraCab cotizacionCompra;

    @FieldDB(value = "proveedor_id")
    public Direccion proveedor;

    @FieldDB(value = "aprobada_por")
    public Persona aprobadaPor;

    @FieldDB(value = "observacion")
    public String observacion;

    @FieldDB(value = "aprobada")
    public Boolean aprobada;

    @FieldDB(value = "anulada")
    public Boolean anulada;
    
    @FieldDB(value = "cotizacion_anulada")
    public Boolean cotizacionAnulada;

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

    public CotizacionCompraCab getCotizacionCompra() {
        return cotizacionCompra;
    }

    public void setCotizacionCompra(CotizacionCompraCab cotizacionCompra) {
        this.cotizacionCompra = cotizacionCompra;
    }

    public Direccion getProveedor() {
        return proveedor;
    }

    public void setProveedor(Direccion proveedor) {
        this.proveedor = proveedor;
    }

    public Persona getAprobadaPor() {
        return aprobadaPor;
    }

    public void setAprobadaPor(Persona aprobadaPor) {
        this.aprobadaPor = aprobadaPor;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Boolean getAprobada() {
        return aprobada;
    }

    public void setAprobada(Boolean aprobada) {
        this.aprobada = aprobada;
    }

    public Boolean getAnulada() {
        return anulada;
    }

    public void setAnulada(Boolean anulada) {
        this.anulada = anulada;
    }

    public Boolean getCotizacionAnulada() {
        return cotizacionAnulada;
    }

    public void setCotizacionAnulada(Boolean cotizacionAnulada) {
        this.cotizacionAnulada = cotizacionAnulada;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        final Proveedor other = (Proveedor) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    
    
}
