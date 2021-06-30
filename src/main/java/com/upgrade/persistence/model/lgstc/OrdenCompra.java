/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.lgstc;

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
 * @author UpGrade Sistemas
 */
@TableDB(name = "lgstc.orden_compra", sequence = "lgstc.orden_compra_id_seq")
public class OrdenCompra implements Serializable {

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

    @FieldDB(value = "direccion_proveedor_id")
    public Direccion direccionProveedor;

    @FieldDB(value = "moneda_id")
    public Moneda moneda;

    @FieldDB(value = "almacen_id")
    public Almacen almacen;

    @FieldDB(value = "fecha")
    public Date fecha;

    @FieldDB(value = "fecha_llegada")
    public Date fechaLlegada;

    @FieldDB(value = "forma_pago_id")
    public FormaPago formaPago;

    @FieldDB(value = "impuesto_incluido")
    public Boolean impuestoIncluido;

    @FieldDB(value = "impuesto_id")
    public Impuesto impuesto_id;

    @FieldDB(value = "total")
    public BigDecimal total;

    @FieldDB(value = "total_facturas")
    public BigDecimal totalFacturas;

    @FieldDB(value = "impuesto")
    public BigDecimal impuesto;

    @FieldDB(value = "subtotal")
    public BigDecimal subtotal;

    @FieldDB(value = "dias_credito")
    public Integer diasCredito;

    @FieldDB(value = "descuento")
    public BigDecimal descuento;

    @FieldDB(value = "aprobado_por")
    public Persona aprobadoPor;

    @FieldDB(value = "aprobada")
    public Boolean aprobada;
    
    @FieldDB(value = "numero_facturas")
    public String numeroFacturas;
    
//    @FieldDB(value = "factura_compra_id")
//    public OrdenCompraCab facturaCompra;

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

    public Direccion getDireccionProveedor() {
        return direccionProveedor;
    }

    public void setDireccionProveedor(Direccion direccionProveedor) {
        this.direccionProveedor = direccionProveedor;
    }

    public Moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
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

    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    public Boolean getImpuestoIncluido() {
        return impuestoIncluido;
    }

    public void setImpuestoIncluido(Boolean impuestoIncluido) {
        this.impuestoIncluido = impuestoIncluido;
    }

    public Impuesto getImpuesto_id() {
        return impuesto_id;
    }

    public void setImpuesto_id(Impuesto impuesto_id) {
        this.impuesto_id = impuesto_id;
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

    public Integer getDiasCredito() {
        return diasCredito;
    }

    public void setDiasCredito(Integer diasCredito) {
        this.diasCredito = diasCredito;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    public Persona getAprobadoPor() {
        return aprobadoPor;
    }

    public void setAprobadoPor(Persona aprobadoPor) {
        this.aprobadoPor = aprobadoPor;
    }

    public Boolean getAprobada() {
        return aprobada;
    }

    public void setAprobada(Boolean aprobada) {
        this.aprobada = aprobada;
    }



    @Override
    public int hashCode() {
        int hash = 7;
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
        final OrdenCompra other = (OrdenCompra) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
