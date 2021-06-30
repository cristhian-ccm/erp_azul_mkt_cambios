/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.lgstc;

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
@TableDB(name="lgstc.transferencia_activos_cab", sequence= "lgstc.transferencia_activos_cab_id_seq")
public class TransferenciaActivosCab implements Serializable{
    public TransferenciaActivosCab(){
    }
    
    @FieldDB(value = "id")
    public Integer id;
    
    @FieldDB(value = "anulada")
    public Boolean anulada;
    
    @FieldDB(value = "serie")
    public Integer serie;
    
    @FieldDB(value = "numero")
    public BigDecimal numero;
    
    @FieldDB(value = "moneda_id")
    public Moneda moneda;
       
    @FieldDB(value = "almacen_id")
    public Almacen almacen;
    
    @FieldDB(value = "almacen_transferencia_id")
    public Integer almacenTransferencia;
    
    @FieldDB(value = "fecha")
    public Date fecha;
    
    @FieldDB(value = "total")
    public BigDecimal total;  
    
    @FieldDB(value = "descargada")
    public Boolean descargada;
    
    @FieldDB(value = "recibido_por")
    public Integer recibido;

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

    public Integer getSerie() {
        return serie;
    }

    public void setSerie(Integer serie) {
        this.serie = serie;
    }

    public BigDecimal getNumero() {
        return numero;
    }

    public void setNumero(BigDecimal numero) {
        this.numero = numero;
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

    public Integer getAlmacenTransferencia() {
        return almacenTransferencia;
    }

    public void setAlmacenTransferencia(Integer almacenTransferencia) {
        this.almacenTransferencia = almacenTransferencia;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Boolean getDescargada() {
        return descargada;
    }

    public void setDescargada(Boolean descargada) {
        this.descargada = descargada;
    }

    public Integer getRecibido() {
        return recibido;
    }

    public void setRecibido(Integer recibido) {
        this.recibido = recibido;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final TransferenciaActivosCab other = (TransferenciaActivosCab) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
     
   
    
        
}
