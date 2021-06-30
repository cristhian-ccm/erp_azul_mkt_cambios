/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.lgstc;

import com.upgrade.persistence.model.Impuesto;
import com.upgrade.persistence.model.Moneda;
import com.upgrade.persistence.model.extcs.Almacen;
import ts.com.service.util.db.client.FieldDB;
import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author USER
 */
@TableDB(name="lgstc.nota_credito_cab", sequence= "lgstc.nota_credito_cab_id_seq")
public class NotaCreditoCab implements Serializable{
    
    public NotaCreditoCab(){
    }
    
    @FieldDB(value = "id")
    public Integer id;
    
    @FieldDB(value = "serie")
    public String serie;
    
    @FieldDB(value = "numero")
    public String numero;
    
    @FieldDB(value = "moneda_id")
    public Moneda moneda;
    
    @FieldDB(value = "orden_compra_id")
    public OrdenCompraCab ordenCompra;
       
    @FieldDB(value = "almacen_id")
    public Almacen almacen;
    
    @FieldDB(value = "fecha")
    public Date fecha;
    
    @FieldDB(value = "impuesto_incluido")
    public Boolean impuestoIncluido;    
   
    @FieldDB(value = "impuesto_id")
    public Impuesto impuestoId;
    
    @FieldDB(value = "total")
    public BigDecimal total;
    
    @FieldDB(value = "impuesto")
    public Impuesto impuesto;
    
    @FieldDB(value = "subtotal")
    public BigDecimal subtotal;
    
    @FieldDB(value = "canjeada")
    public Boolean canjeada;
    
    @FieldDB(value = "descargada")
    public Boolean descargada;
        
    @FieldDB(value = "total_pagar")
    public BigDecimal totalPagar;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }

    public OrdenCompraCab getOrdenCompra() {
        return ordenCompra;
    }

    public void setOrdenCompra(OrdenCompraCab ordenCompra) {
        this.ordenCompra = ordenCompra;
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

    public Boolean getImpuestoIncluido() {
        return impuestoIncluido;
    }

    public void setImpuestoIncluido(Boolean impuestoIncluido) {
        this.impuestoIncluido = impuestoIncluido;
    }

    public Impuesto getImpuestoId() {
        return impuestoId;
    }

    public void setImpuestoId(Impuesto impuestoId) {
        this.impuestoId = impuestoId;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Impuesto getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(Impuesto impuesto) {
        this.impuesto = impuesto;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public Boolean getCanjeada() {
        return canjeada;
    }

    public void setCanjeada(Boolean canjeada) {
        this.canjeada = canjeada;
    }

    public Boolean getDescargada() {
        return descargada;
    }

    public void setDescargada(Boolean descargada) {
        this.descargada = descargada;
    }

    public BigDecimal getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(BigDecimal totalPagar) {
        this.totalPagar = totalPagar;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final NotaCreditoCab other = (NotaCreditoCab) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
