/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.lgstc;

import com.upgrade.persistence.model.DocumentoTipo;
import com.upgrade.persistence.model.FormaPago;
import com.upgrade.persistence.model.Impuesto;
import com.upgrade.persistence.model.Moneda;
import com.upgrade.persistence.model.extcs.Almacen;
import com.upgrade.persistence.model.tcros.Direccion;
import com.upgrade.persistence.model.tcros.Persona;
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
@TableDB(name="lgstc.ordenes_compra_cab", sequence= "lgstc.ordenes_compra_cab_id_seq")
public class OrdenCompraCab implements Serializable{
   public OrdenCompraCab()
   {
   }
   
   @FieldDB(value = "creado_por")
    public Persona creadoPor;
   
   @FieldDB(value = "editado_por")
    public Persona editadoPor;
   
    @FieldDB(value = "id")
    public Integer id;
    
    @FieldDB(value = "anulada")
    public Boolean anulada;
    
    @FieldDB(value = "moneda_id")
    public Moneda moneda;
    
    @FieldDB(value = "direccion_proveedor_id")
    public Direccion direccionProveedor;
    
    @FieldDB(value = "almacen_id")
    public Almacen almacen;
       
    @FieldDB(value = "fecha")
    public Date fecha;
    
    @FieldDB(value = "fecha_llegada")
    public Date fechaLLegada;
    
    @FieldDB(value = "forma_pago_id")
    public FormaPago formaPago;
    
    @FieldDB(value = "impuesto_incluido")
    public Boolean impuestoInculido;    
    
    @FieldDB(value = "impuesto_id")
    public Impuesto impuestoId;
    
    @FieldDB(value = "total")
    public BigDecimal total;
    
    @FieldDB(value = "impuesto")
    public BigDecimal impuesto;
    
    @FieldDB(value = "subtotal")
    public BigDecimal subtotal;
    
    @FieldDB(value = "cerrada")
    public Boolean cerrada;
    
    @FieldDB(value = "dias_credito")
    public Integer diasCredito;
        
    @FieldDB(value = "documento_tipo_id")
    public DocumentoTipo documentoTipo;
    
    @FieldDB(value = "numero")
    public String numero;
    
    @FieldDB(value = "monto_pagado")
    public BigDecimal montoPagado;
    
    @FieldDB(value = "total_pagar")
    public BigDecimal totalPagar;
    
    @FieldDB(value = "descuento")
    public BigDecimal descuento;  
    
    @FieldDB(value = "num_cheque")
    public String numCheque;    
    
    @FieldDB(value="fecha_caducidad")
    public Date fechaCaducidad;

    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

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

    public Moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }

    public Direccion getDireccionProveedor() {
        return direccionProveedor;
    }

    public void setDireccionProveedor(Direccion direccionProveedor) {
        this.direccionProveedor = direccionProveedor;
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

    public Date getFechaLLegada() {
        return fechaLLegada;
    }

    public void setFechaLLegada(Date fechaLLegada) {
        this.fechaLLegada = fechaLLegada;
    }

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    public Boolean getImpuestoInculido() {
        return impuestoInculido;
    }

    public void setImpuestoInculido(Boolean impuestoInculido) {
        this.impuestoInculido = impuestoInculido;
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

    public BigDecimal getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(BigDecimal impuesto) {
        this.impuesto = impuesto;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public Boolean getCerrada() {
        return cerrada;
    }

    public void setCerrada(Boolean cerrada) {
        this.cerrada = cerrada;
    }

    public Integer getDiasCredito() {
        return diasCredito;
    }

    public void setDiasCredito(Integer diasCredito) {
        this.diasCredito = diasCredito;
    }

    public DocumentoTipo getDocumentoTipo() {
        return documentoTipo;
    }

    public void setDocumentoTipo(DocumentoTipo documentoTipo) {
        this.documentoTipo = documentoTipo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public BigDecimal getMontoPagado() {
        return montoPagado;
    }

    public void setMontoPagado(BigDecimal montoPagado) {
        this.montoPagado = montoPagado;
    }

    public BigDecimal getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(BigDecimal totalPagar) {
        this.totalPagar = totalPagar;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    public String getNumCheque() {
        return numCheque;
    }

    public void setNumCheque(String numCheque) {
        this.numCheque = numCheque;
    }
    
    
        
    @Override
    public int hashCode() {
        int hash = 5;
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
        final OrdenCompraCab other = (OrdenCompraCab) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    
    
}
