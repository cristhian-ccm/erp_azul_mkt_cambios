/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.lgstc;

import com.upgrade.persistence.model.cmrlz.NotaPedidoDet;
import com.upgrade.persistence.model.extcs.Almacen;
import com.upgrade.persistence.model.extcs.Producto;
import com.upgrade.persistence.model.tcros.Persona;
import ts.com.service.util.db.client.FieldDB;
import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author UpGrade Sistemas
 */
@TableDB(name = "lgstc.solicitud_compra", sequence = "lgstc.solicitud_compra_id_seq")
public class SolicitudCompra implements Serializable {
    
    @FieldDB("persona_solicitud")
    public Persona personaSolicitud;
    
    @FieldDB("editado_por")
    public Persona editadoPor;
    
    @FieldDB("id")
    public Integer id;    

    @FieldDB("anulado")
    public Boolean anulado;    
    
    @FieldDB("almacen_id")
    public Almacen almacen;
    
    @FieldDB("fecha")
    public Date fecha;    
    
    @FieldDB("nota_pedido_det_id")
    public NotaPedidoDet notaPedidoDet;
    
    @FieldDB("producto_id")
    public Producto producto;
    
    @FieldDB("cantidad_venta")
    public Integer cantidadVenta;
    
    @FieldDB("cantidad_stock")
    public Integer cantidadStock;
    
    @FieldDB("cantidad_total")
    public Integer cantidadTotal;

    @FieldDB("cantidad_atendida")
    public Integer cantidadAtendida;

    @FieldDB("cerrado")
    public Boolean cerrado;
    
    @FieldDB("orden_compra_det_id")
    public OrdenCDet ordenCompraDet;

    @FieldDB("cotizar")
    public Integer cotizar;

    @FieldDB("cotizando")
    public Integer cotizando;

    public Persona getPersonaSolicitud() {
        return personaSolicitud;
    }

    public void setPersonaSolicitud(Persona personaSolicitud) {
        this.personaSolicitud = personaSolicitud;
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

    public Boolean getAnulado() {
        return anulado;
    }

    public void setAnulado(Boolean anulado) {
        this.anulado = anulado;
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

    public NotaPedidoDet getNotaPedidoDet() {
        return notaPedidoDet;
    }

    public void setNotaPedidoDet(NotaPedidoDet notaPedidoDet) {
        this.notaPedidoDet = notaPedidoDet;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getCantidadVenta() {
        return cantidadVenta;
    }

    public void setCantidadVenta(Integer cantidadVenta) {
        this.cantidadVenta = cantidadVenta;
    }

    public Integer getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(Integer cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public Integer getCantidadTotal() {
        return cantidadTotal;
    }

    public void setCantidadTotal(Integer cantidadTotal) {
        this.cantidadTotal = cantidadTotal;
    }

    public Integer getCantidadAtendida() {
        return cantidadAtendida;
    }

    public void setCantidadAtendida(Integer cantidadAtendida) {
        this.cantidadAtendida = cantidadAtendida;
    }

    public Boolean getCerrado() {
        return cerrado;
    }

    public void setCerrado(Boolean cerrado) {
        this.cerrado = cerrado;
    }

    public OrdenCDet getOrdenCompraDet() {
        return ordenCompraDet;
    }

    public void setOrdenCompraDet(OrdenCDet ordenCompraDet) {
        this.ordenCompraDet = ordenCompraDet;
    }

    
    public Integer getCotizar() {
        return cotizar;
    }

    public void setCotizar(Integer cotizar) {
        this.cotizar = cotizar;
    }

    public Integer getCotizando() {
        return cotizando;
    }

    public void setCotizando(Integer cotizando) {
        this.cotizando = cotizando;
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
        final SolicitudCompra other = (SolicitudCompra) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    
}
