/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.auxiliar.sunat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author darko
 */
public class NotaCreditoDebitoNot implements Serializable {

    public Date fecEmision;
    public Integer codMotivo;
    public String desMotivo;
    public Integer tipDocAfectado;
    public String numDocAfectado;
    public String tipDocUsuario;
    public String numDocUsuario;
    public String rznSocialUsuario;
    public String tipMoneda;
    public BigDecimal sumOtrosCargos;
    public BigDecimal mtoOperGravadas;
    public BigDecimal mtoOperInafectas;
    public BigDecimal mtoOperExoneradas;
    public BigDecimal mtoIGV;
    public BigDecimal mtoISC;
    public BigDecimal mtoOtrosTributos;
    public BigDecimal mtoImpVenta;

    public Date getFecEmision() {
        return fecEmision;
    }

    public void setFecEmision(Date fecEmision) {
        this.fecEmision = fecEmision;
    }

    public Integer getCodMotivo() {
        return codMotivo;
    }

    public void setCodMotivo(Integer codMotivo) {
        this.codMotivo = codMotivo;
    }

    public String getDesMotivo() {
        return desMotivo;
    }

    public void setDesMotivo(String desMotivo) {
        this.desMotivo = desMotivo;
    }

    public Integer getTipDocAfectado() {
        return tipDocAfectado;
    }

    public void setTipDocAfectado(Integer tipDocAfectado) {
        this.tipDocAfectado = tipDocAfectado;
    }

    public String getNumDocAfectado() {
        return numDocAfectado;
    }

    public void setNumDocAfectado(String numDocAfectado) {
        this.numDocAfectado = numDocAfectado;
    }

    public String getTipDocUsuario() {
        return tipDocUsuario;
    }

    public void setTipDocUsuario(String tipDocUsuario) {
        this.tipDocUsuario = tipDocUsuario;
    }

    public String getNumDocUsuario() {
        return numDocUsuario;
    }

    public void setNumDocUsuario(String numDocUsuario) {
        this.numDocUsuario = numDocUsuario;
    }

    public String getRznSocialUsuario() {
        return rznSocialUsuario;
    }

    public void setRznSocialUsuario(String rznSocialUsuario) {
        this.rznSocialUsuario = rznSocialUsuario;
    }

    public String getTipMoneda() {
        return tipMoneda;
    }

    public void setTipMoneda(String tipMoneda) {
        this.tipMoneda = tipMoneda;
    }

    public BigDecimal getSumOtrosCargos() {
        return sumOtrosCargos;
    }

    public void setSumOtrosCargos(BigDecimal sumOtrosCargos) {
        this.sumOtrosCargos = sumOtrosCargos;
    }

    public BigDecimal getMtoOperGravadas() {
        return mtoOperGravadas;
    }

    public void setMtoOperGravadas(BigDecimal mtoOperGravadas) {
        this.mtoOperGravadas = mtoOperGravadas;
    }

    public BigDecimal getMtoOperInafectas() {
        return mtoOperInafectas;
    }

    public void setMtoOperInafectas(BigDecimal mtoOperInafectas) {
        this.mtoOperInafectas = mtoOperInafectas;
    }

    public BigDecimal getMtoOperExoneradas() {
        return mtoOperExoneradas;
    }

    public void setMtoOperExoneradas(BigDecimal mtoOperExoneradas) {
        this.mtoOperExoneradas = mtoOperExoneradas;
    }

    public BigDecimal getMtoIGV() {
        return mtoIGV;
    }

    public void setMtoIGV(BigDecimal mtoIGV) {
        this.mtoIGV = mtoIGV;
    }

    public BigDecimal getMtoISC() {
        return mtoISC;
    }

    public void setMtoISC(BigDecimal mtoISC) {
        this.mtoISC = mtoISC;
    }

    public BigDecimal getMtoOtrosTributos() {
        return mtoOtrosTributos;
    }

    public void setMtoOtrosTributos(BigDecimal mtoOtrosTributos) {
        this.mtoOtrosTributos = mtoOtrosTributos;
    }

    public BigDecimal getMtoImpVenta() {
        return mtoImpVenta;
    }

    public void setMtoImpVenta(BigDecimal mtoImpVenta) {
        this.mtoImpVenta = mtoImpVenta;
    }
    

}
