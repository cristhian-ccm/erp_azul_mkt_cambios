/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.fnnzs;

import com.upgrade.persistence.model.cmrlz.VentaCab;
import com.upgrade.persistence.model.tcros.Persona;
import ts.com.service.util.db.client.FieldDB;
import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author Admin
 */
@TableDB(name = "fnnzs.retenciones_cliente_det", sequence = "fnnzs.retenciones_cliente_det_id_seq")
public class RetencionesDet implements Serializable {

    @FieldDB(value = "creado_por")
    public Persona creadoPor;

    @FieldDB(value = "editado_por")
    public Persona editadoPor;

    @FieldDB(value = "id")
    public Integer id;

    @FieldDB(value = "retencion_cliente_id")
    public RetencionesCab retencion;

    @FieldDB(value = "monto_retencion")
    public BigDecimal montoRetencion;

    @FieldDB(value = "monto_venta")
    public BigDecimal montoVenta;

    @FieldDB(value = "venta_id")
    public VentaCab venta;

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

    public RetencionesCab getRetencion() {
        return retencion;
    }

    public void setRetencion(RetencionesCab retencion) {
        this.retencion = retencion;
    }

    public BigDecimal getMontoRetencion() {
        return montoRetencion;
    }

    public void setMontoRetencion(BigDecimal montoRetencion) {
        this.montoRetencion = montoRetencion;
    }

    public BigDecimal getMontoVenta() {
        return montoVenta;
    }

    public void setMontoVenta(BigDecimal montoVenta) {
        this.montoVenta = montoVenta;
    }

    public VentaCab getVenta() {
        return venta;
    }

    public void setVenta(VentaCab venta) {
        this.venta = venta;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.id);
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
        final RetencionesDet other = (RetencionesDet) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
