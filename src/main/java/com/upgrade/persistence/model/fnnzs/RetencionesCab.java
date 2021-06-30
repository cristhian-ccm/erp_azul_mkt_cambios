//RetencionCab
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.fnnzs;

import com.upgrade.persistence.model.Moneda;
import com.upgrade.persistence.model.extcs.Almacen;
import com.upgrade.persistence.model.tcros.Persona;
import ts.com.service.util.db.client.FieldDB;
import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Admin
 */
@TableDB(name = "fnnzs.retenciones_cliente_cab", sequence = "fnnzs.retenciones_cliente_cab_id_seq")
public class RetencionesCab implements Serializable {

    @FieldDB(value = "creado_por")
    public Persona creadoPor;

    @FieldDB(value = "editado_por")
    public Persona editadoPor;

    @FieldDB(value = "id")
    public Integer id;

    @FieldDB(value = "serie_completa")
    public String serieCompleta;    

    @FieldDB(value = "numero")
    public Integer numero;

    @FieldDB(value = "cliente_id")
    public Persona cliente;

    @FieldDB(value = "fecha")
    public Date fecha;

    @FieldDB(value = "almacen_id")
    public Almacen almacen;

    @FieldDB(value = "moneda_id")
    public Moneda moneda;

    @FieldDB(value = "total")
    public BigDecimal total;
    
  

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

    public Persona getCliente() {
        return cliente;
    }

    public void setCliente(Persona cliente) {
        this.cliente = cliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Almacen getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }

    public Moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getSerieCompleta() {
        return serieCompleta;
    }

    public void setSerieCompleta(String serieCompleta) {
        this.serieCompleta = serieCompleta;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.id);
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
        final RetencionesCab other = (RetencionesCab) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    


    
}
