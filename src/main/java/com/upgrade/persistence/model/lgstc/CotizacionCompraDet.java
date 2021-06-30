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

//import com.upgrade.persistence.model.Moneda;
//import java.math.BigDecimal;


/**
 *
 * @author upgrade
 */
@TableDB(name = "lgstc.cotizacion_compra_det", sequence = "lgstc.cotizacion_compra_det_id_seq")
public class CotizacionCompraDet implements Serializable {
    
    @FieldDB(value = "id")
    public Integer id;
    
    @FieldDB(value = "usuario_creador")
    public Persona usuarioCreador;
    
    @FieldDB(value = "editado_por")
    public Persona editadoPor;
    
    @FieldDB(value = "cotizacion_compra_id")
    public CotizacionCompraCab cotizacionCompra;
    
    @FieldDB(value = "solicitud_compra_id")
    public SolicitudCompra solicitudCompra;

    @FieldDB(value = "cantidad")
    public Integer cantidad;

//    @FieldDB(value = "precio_unitario")
//    public BigDecimal precioUnitario;
//
//    @FieldDB(value = "precio_total")
//    public BigDecimal precioTotal;

//    @FieldDB(value = "moneda")
//    public Moneda moneda;

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

    public SolicitudCompra getSolicitudCompra() {
        return solicitudCompra;
    }

    public void setSolicitudCompra(SolicitudCompra solicitudCompra) {
        this.solicitudCompra = solicitudCompra;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
//
//    public BigDecimal getPrecioUnitario() {
//        return precioUnitario;
//    }
//
//    public void setPrecioUnitario(BigDecimal precioUnitario) {
//        this.precioUnitario = precioUnitario;
//    }
//
//    public BigDecimal getPrecioTotal() {
//        return precioTotal;
//    }
//
//    public void setPrecioTotal(BigDecimal precioTotal) {
//        this.precioTotal = precioTotal;
//    }

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

//    public Moneda getMoneda() {
//        return moneda;
//    }
//
//    public void setMoneda(Moneda moneda) {
//        this.moneda = moneda;
//    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
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
        final CotizacionCompraDet other = (CotizacionCompraDet) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    
    
}
