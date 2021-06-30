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
import java.util.Objects;

/**
 *
 * @author UpGrade Sistemas
 */
@TableDB(name = "lgstc.orden_compra_facturas_proveedor", sequence = "lgstc.orden_compra_facturas_proveedor_id_seq")
public class OrdenCompraFacturaProveedor implements Serializable {

    @FieldDB(value = "creado_por")
    public Persona creadoPor;

    @FieldDB(value = "editado_por")
    public Persona editadoPor;

    @FieldDB(value = "id")
    public Integer id;

    @FieldDB(value = "orden_compra_id")
    public OrdenCompra ordenCompra;

    @FieldDB(value = "ordenes_compra_cab_id")
    public OrdenCompraCab ordenesCompraCab;

    @FieldDB(value = "anulada")
    public Boolean anulada;

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

    public OrdenCompra getOrdenCompra() {
        return ordenCompra;
    }

    public void setOrdenCompra(OrdenCompra ordenCompra) {
        this.ordenCompra = ordenCompra;
    }

    public OrdenCompraCab getOrdenesCompraCab() {
        return ordenesCompraCab;
    }

    public void setOrdenesCompraCab(OrdenCompraCab ordenesCompraCab) {
        this.ordenesCompraCab = ordenesCompraCab;
    }

    public Boolean getAnulada() {
        return anulada;
    }

    public void setAnulada(Boolean anulada) {
        this.anulada = anulada;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.id);
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
        final OrdenCompraFacturaProveedor other = (OrdenCompraFacturaProveedor) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
