/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.fnnzs;

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
 * @author USER
 */
@TableDB(name = "fnnzs.depositos_cliente", sequence = "fnnzs.depositos_cliente_id_seq")
public class DepositosCliente implements Serializable{
   
    @FieldDB(value = "creado_por")
    public Persona creadoPor;
    
    @FieldDB(value = "editado_por")
    public Persona editadoPor;
    
    @FieldDB(value = "id")
    public Integer id;
    
    @FieldDB(value = "inactivo")
    public Boolean inactivo;
    
    @FieldDB(value = "cuenta_bancaria_id")
    public CuentaBancaria cuentaBancaria;
    
    @FieldDB(value = "cliente_id")
    public Persona cliente;
    
    @FieldDB(value = "monto")
    public BigDecimal monto;
    
    @FieldDB(value = "monto_usado")
    public BigDecimal montoUsado;
    
    @FieldDB(value = "observacion")
    public String observacion;
    
    @FieldDB(value = "oficina")
    public String oficina;
    
    @FieldDB(value = "operacion")
    public String operacion;
    
    @FieldDB(value = "fecha")
    public Date fecha;
    
    @FieldDB(value = "fecha_aprobacion")
    public Date fechaAprobacion;
    
    @FieldDB(value = "aprobado_por_id")
    public Persona aprobadoPor;
    
    @FieldDB(value = "operacion_ingresada")
    public String operacion_ingresada;
    
    @FieldDB(value = "almacen_id")
    public Almacen almacen;
    
    @FieldDB(value = "siaf_id")
    public Siaf siaf;
    
    @FieldDB(value = "visa")
    public Boolean visa;

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

    public Boolean getInactivo() {
        return inactivo;
    }

    public void setInactivo(Boolean inactivo) {
        this.inactivo = inactivo;
    }

    public CuentaBancaria getCuentaBancaria() {
        return cuentaBancaria;
    }

    public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

    public Persona getCliente() {
        return cliente;
    }

    public void setCliente(Persona cliente) {
        this.cliente = cliente;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public BigDecimal getMontoUsado() {
        return montoUsado;
    }

    public void setMontoUsado(BigDecimal montoUsado) {
        this.montoUsado = montoUsado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getOficina() {
        return oficina;
    }

    public void setOficina(String oficina) {
        this.oficina = oficina;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFechaAprobacion() {
        return fechaAprobacion;
    }

    public void setFechaAprobacion(Date fechaAprobacion) {
        this.fechaAprobacion = fechaAprobacion;
    }

    public Persona getAprobadoPor() {
        return aprobadoPor;
    }

    public void setAprobadoPor(Persona aprobadoPor) {
        this.aprobadoPor = aprobadoPor;
    }

    public String getOperacion_ingresada() {
        return operacion_ingresada;
    }

    public void setOperacion_ingresada(String operacion_ingresada) {
        this.operacion_ingresada = operacion_ingresada;
    }

    public Almacen getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }

    public Siaf getSiaf() {
        return siaf;
    }

    public void setSiaf(Siaf siaf) {
        this.siaf = siaf;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final DepositosCliente other = (DepositosCliente) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
}
