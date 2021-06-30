/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.fnnzs;

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
@TableDB(name = "fnnzs.letras_cliente_det", sequence = "fnnzs.letras_cliente_det_id_seq")

public class LetrasClienteDet implements Serializable {
    @FieldDB(value = "id")
    public Integer id;
       
    @FieldDB(value = "anulada")
    public Boolean anulada;
    
    @FieldDB(value = "letra_id")
    public LetrasClienteCab letra;      //
    
    @FieldDB(value = "numero")
    public Integer numero;
    
    @FieldDB(value = "fecha_vencimiento")
    public Date fechaVencimiento;
    
    @FieldDB(value = "fecha_cobro")
    public Date fechaCobro;
    
    @FieldDB(value = "capital")
    public BigDecimal capital;
    
    @FieldDB(value = "total_cobrar")
    public BigDecimal totalCobrar;
    
    @FieldDB(value = "total_cobrado")
    public BigDecimal totalCobrado;
    
    @FieldDB(value = "capital_inicial")
    public BigDecimal capitalInicial;
    
    @FieldDB(value = "a_cobrar")
    public BigDecimal aCobrar;
    
    public BigDecimal interes;

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

    public LetrasClienteCab getLetra() {
        return letra;
    }

    public void setLetra(LetrasClienteCab letra) {
        this.letra = letra;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Date getFechaCobro() {
        return fechaCobro;
    }

    public void setFechaCobro(Date fechaCobro) {
        this.fechaCobro = fechaCobro;
    }

    public BigDecimal getCapital() {
        return capital;
    }

    public void setCapital(BigDecimal capital) {
        this.capital = capital;
    }

    public BigDecimal getTotalCobrar() {
        return totalCobrar;
    }

    public void setTotalCobrar(BigDecimal totalCobrar) {
        this.totalCobrar = totalCobrar;
    }

    public BigDecimal getTotalCobrado() {
        return totalCobrado;
    }

    public void setTotalCobrado(BigDecimal totalCobrado) {
        this.totalCobrado = totalCobrado;
    }

    public BigDecimal getCapitalInicial() {
        return capitalInicial;
    }

    public void setCapitalInicial(BigDecimal capitalInicial) {
        this.capitalInicial = capitalInicial;
    }

    public BigDecimal getaCobrar() {
        return aCobrar;
    }

    public void setaCobrar(BigDecimal aCobrar) {
        this.aCobrar = aCobrar;
    }

    public LetrasClienteDet() {
        //super.tableName = "fnnzs.letras_cliente_det";
        //super.sequenceName = "fnnz.letras_cliente_det_id_seq";
        
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LetrasClienteDet other = (LetrasClienteDet) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    //
}
