/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.auxiliar.sunat;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author darko
 */
public class FacturaBoletaRel implements Serializable {

    public String indDocRelacionado;
    public String tipDocRelacionado;
    public String numDocRelacionado;
    public String tipDocEmisor;
    public String numDocEmisor;
    public BigDecimal mtoDocRelacionado;

    public String getIndDocRelacionado() {
        return indDocRelacionado;
    }

    public void setIndDocRelacionado(String indDocRelacionado) {
        this.indDocRelacionado = indDocRelacionado;
    }

    public String getTipDocRelacionado() {
        return tipDocRelacionado;
    }

    public void setTipDocRelacionado(String tipDocRelacionado) {
        this.tipDocRelacionado = tipDocRelacionado;
    }

    public String getNumDocRelacionado() {
        return numDocRelacionado;
    }

    public void setNumDocRelacionado(String numDocRelacionado) {
        this.numDocRelacionado = numDocRelacionado;
    }

    public String getTipDocEmisor() {
        return tipDocEmisor;
    }

    public void setTipDocEmisor(String tipDocEmisor) {
        this.tipDocEmisor = tipDocEmisor;
    }

    public String getNumDocEmisor() {
        return numDocEmisor;
    }

    public void setNumDocEmisor(String numDocEmisor) {
        this.numDocEmisor = numDocEmisor;
    }

    public BigDecimal getMtoDocRelacionado() {
        return mtoDocRelacionado;
    }

    public void setMtoDocRelacionado(BigDecimal mtoDocRelacionado) {
        this.mtoDocRelacionado = mtoDocRelacionado;
    }

 
    

}
