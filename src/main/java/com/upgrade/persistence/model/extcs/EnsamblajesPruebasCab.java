/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.extcs;

import com.upgrade.persistence.model.cmrlz.NotaPedidoCab;
import com.upgrade.persistence.model.tcros.Persona;
import com.upgrade.persistence.model.usros.Usuario;
import ts.com.service.util.db.client.FieldDB;
import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Evander
 */
@TableDB(name="extcs.ensamblajes_pruebas_cab", sequence="extcs.ensamblajes_pruebas_cab_id_seq")
public class EnsamblajesPruebasCab implements Serializable{

    @FieldDB(value = "creado_por")
    public Persona creadoPor;
    
    @FieldDB(value = "editado_por")
    public Persona editadoPor;
    
    public Integer id;
    
    public Boolean anulada;
    
    public Integer numero;
    
    @FieldDB(value = "almacen_id")
    public Almacen almacen;
    
    public Date fecha;
    
    @FieldDB(value = "fecha_cumplimiento")
    public Date fechaCumplimiento;
    
    @FieldDB(value="usuario_id")
    public Usuario usuario;
    
    @FieldDB(value="nota_pedido_id")
    public NotaPedidoCab notaPedido;
    
    @FieldDB(value="orden_id")
    public OrdenCab orden;
    
    @FieldDB(value="guia_id")
    public Guia guia;

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

    public Boolean getAnulada() {
        return anulada;
    }

    public void setAnulada(Boolean anulada) {
        this.anulada = anulada;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Almacen getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFechaCumplimiento() {
        return fechaCumplimiento;
    }

    public void setFechaCumplimiento(Date fechaCumplimiento) {
        this.fechaCumplimiento = fechaCumplimiento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public NotaPedidoCab getNotaPedido() {
        return notaPedido;
    }

    public void setNotaPedido(NotaPedidoCab notaPedido) {
        this.notaPedido = notaPedido;
    }

    public OrdenCab getOrden() {
        return orden;
    }

    public void setOrden(OrdenCab orden) {
        this.orden = orden;
    }

    public Guia getGuia() {
        return guia;
    }

    public void setGuia(Guia guia) {
        this.guia = guia;
    }    
    
    public EnsamblajesPruebasCab() {
        //super.tableName = "extcs.ensamblajes_pruebas_cab";
        //super.sequenceName = "extcs.ensamblajes_pruebas_cab_id_seq";
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.id);
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
        final EnsamblajesPruebasCab other = (EnsamblajesPruebasCab) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
}
