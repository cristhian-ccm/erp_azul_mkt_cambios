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
 * @author JCARLOS
 */
@TableDB(name="fnnzs.cierre_caja", sequence="fnnzs.cierre_caja_id_seq")
public class CierreCaja implements Serializable{
    
    @FieldDB(value = "creado_por")
    public Persona creadoPor;
    
    @FieldDB(value = "editado_por")
    public Persona editadoPor;
    
    @FieldDB(value = "id")
    public Integer id;
    
    @FieldDB(value = "anulada")
    public Boolean anulada;
    
    @FieldDB(value = "cierre_aprobado")
    public Boolean cierreAprobado;
    
    @FieldDB(value = "almacen_id")
    public Almacen almacen;
    
    @FieldDB(value = "caja_id")
    public Caja caja;
    
    @FieldDB(value = "fecha")
    public Date fecha;
    
    @FieldDB(value = "numero")
    public Integer numero;
    
    @FieldDB(value = "concepto_tipo_id")
    public RecibosDetTipos conceptoTipo;
    
    @FieldDB(value = "monto_entrada")
    public BigDecimal montoEntrada;
    
    @FieldDB(value = "monto_cierre")
    public BigDecimal montoCierre;
    
    @FieldDB(value = "saldo")
    public BigDecimal saldo;
    
    @FieldDB(value = "observaciones")
    public String observaciones;
    
    @FieldDB(value = "aprobado_por")
    public Persona aprobadoPor;

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

    public Boolean getCierreAprobado() {
        return cierreAprobado;
    }

    public void setCierreAprobado(Boolean cierreAprobado) {
        this.cierreAprobado = cierreAprobado;
    }

    public Almacen getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }

    public Caja getCaja() {
        return caja;
    }

    public void setCaja(Caja caja) {
        this.caja = caja;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public RecibosDetTipos getConceptoTipo() {
        return conceptoTipo;
    }

    public void setConceptoTipo(RecibosDetTipos conceptoTipo) {
        this.conceptoTipo = conceptoTipo;
    }

    public BigDecimal getMontoEntrada() {
        return montoEntrada;
    }

    public void setMontoEntrada(BigDecimal montoEntrada) {
        this.montoEntrada = montoEntrada;
    }

    public BigDecimal getMontoCierre() {
        return montoCierre;
    }

    public void setMontoCierre(BigDecimal montoCierre) {
        this.montoCierre = montoCierre;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Persona getAprobadoPor() {
        return aprobadoPor;
    }

    public void setAprobadoPor(Persona aprobadoPor) {
        this.aprobadoPor = aprobadoPor;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
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
        final CierreCaja other = (CierreCaja) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    

}
