/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.extcs;

import com.upgrade.persistence.model.cmrlz.NotaPedidoCab;
import com.upgrade.persistence.model.lgstc.OrdenCompraCab;
import com.upgrade.persistence.model.produccion.Transformacion;
import com.upgrade.persistence.model.tcros.Persona;
import ts.com.service.util.db.client.FieldDB;
import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author evander
 */
@TableDB(name="extcs.ordenes_cab", sequence="extcs.ordenes_cab_id_seq")
public class OrdenCab implements Serializable {
    /*public OrdenCab() {
        //super.tableName = "extcs.ordenes_cab";
        //super.sequenceName = "extcs.ordenes_cab_id_seq";
    }*/
    @FieldDB(value = "creado_por")
    public Persona creadoPor;
    
    @FieldDB(value = "editado_por")
    public Persona editadoPor;
    
    @FieldDB(value = "id")
    public Integer id;
    
    @FieldDB(value = "anulada")
    public Boolean anulada;
    
    @FieldDB(value = "numero")
    public Integer numero;
    
    @FieldDB(value = "almacen_id")
    public Almacen almacen;
    
    @FieldDB(value = "tipo")
    public Character tipo;
    
    @FieldDB(value = "fecha")
    public Date fecha;
    
    @FieldDB(value = "nota_pedido_id")
    public NotaPedidoCab notaPedido;
    
    @FieldDB(value = "orden_compra_id")
    public OrdenCompraCab ordenCompra;
    
    @FieldDB(value = "observacion")
    public String observacion;
    
    @FieldDB(value = "regalo_id")
    public Integer regalo;
    
    @FieldDB(value = "transformacion_id")
    public Transformacion transformacion;
    
    @FieldDB(value = "nota_credito_id")
    public Integer notaCreditoId;
    
    @FieldDB(value = "transferencia_activo_id")
    public Integer transferenciaActivoId;

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

    public Character getTipo() {
        return tipo;
    }

    public void setTipo(Character tipo) {
        this.tipo = tipo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public NotaPedidoCab getNotaPedido() {
        return notaPedido;
    }

    public void setNotaPedido(NotaPedidoCab notaPedido) {
        this.notaPedido = notaPedido;
    }

    public OrdenCompraCab getOrdenCompra() {
        return ordenCompra;
    }

    public void setOrdenCompra(OrdenCompraCab ordenCompra) {
        this.ordenCompra = ordenCompra;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Integer getRegalo() {
        return regalo;
    }

    public void setRegalo(Integer regalo) {
        this.regalo = regalo;
    }

    public Transformacion getTransformacion() {
        return transformacion;
    }

    public void setTransformacion(Transformacion transformacion) {
        this.transformacion = transformacion;
    }
    
    

    public Integer getNotaCreditoId() {
        return notaCreditoId;
    }

    public void setNotaCreditoId(Integer notaCreditoId) {
        this.notaCreditoId = notaCreditoId;
    }

    public Integer getTransferenciaActivoId() {
        return transferenciaActivoId;
    }

    public void setTransferenciaActivoId(Integer transferenciaActivoId) {
        this.transferenciaActivoId = transferenciaActivoId;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final OrdenCab other = (OrdenCab) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
