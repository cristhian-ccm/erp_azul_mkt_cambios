/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.auxiliar.sunat;

import java.io.Serializable;

/**
 *
 * @author darko
 */
public class FacturaBoletaGtr implements Serializable{

    public String codMotivoTraslado;
    public String codUbigeoPtoPartida;
    public String desDireccionPtoPatida;
    public String codUbigeoPtoLlegada;
    public String desDireccionPtoLlegada;
    public String tipDocDestinatario;
    public String numDocDestinatario;
    public String rznSocialDestinatario;
    public String indSubcontratacion;
    public String numRUCContratante;
    public String rznSocialContratante;

    public String getCodMotivoTraslado() {
        return codMotivoTraslado;
    }

    public void setCodMotivoTraslado(String codMotivoTraslado) {
        this.codMotivoTraslado = codMotivoTraslado;
    }

    public String getCodUbigeoPtoPartida() {
        return codUbigeoPtoPartida;
    }

    public void setCodUbigeoPtoPartida(String codUbigeoPtoPartida) {
        this.codUbigeoPtoPartida = codUbigeoPtoPartida;
    }

    public String getDesDireccionPtoPatida() {
        return desDireccionPtoPatida;
    }

    public void setDesDireccionPtoPatida(String desDireccionPtoPatida) {
        this.desDireccionPtoPatida = desDireccionPtoPatida;
    }

    public String getCodUbigeoPtoLlegada() {
        return codUbigeoPtoLlegada;
    }

    public void setCodUbigeoPtoLlegada(String codUbigeoPtoLlegada) {
        this.codUbigeoPtoLlegada = codUbigeoPtoLlegada;
    }

    public String getDesDireccionPtoLlegada() {
        return desDireccionPtoLlegada;
    }

    public void setDesDireccionPtoLlegada(String desDireccionPtoLlegada) {
        this.desDireccionPtoLlegada = desDireccionPtoLlegada;
    }

    public String getTipDocDestinatario() {
        return tipDocDestinatario;
    }

    public void setTipDocDestinatario(String tipDocDestinatario) {
        this.tipDocDestinatario = tipDocDestinatario;
    }

    public String getNumDocDestinatario() {
        return numDocDestinatario;
    }

    public void setNumDocDestinatario(String numDocDestinatario) {
        this.numDocDestinatario = numDocDestinatario;
    }

    public String getRznSocialDestinatario() {
        return rznSocialDestinatario;
    }

    public void setRznSocialDestinatario(String rznSocialDestinatario) {
        this.rznSocialDestinatario = rznSocialDestinatario;
    }

    public String getIndSubcontratacion() {
        return indSubcontratacion;
    }

    public void setIndSubcontratacion(String indSubcontratacion) {
        this.indSubcontratacion = indSubcontratacion;
    }

    public String getNumRUCContratante() {
        return numRUCContratante;
    }

    public void setNumRUCContratante(String numRUCContratante) {
        this.numRUCContratante = numRUCContratante;
    }

    public String getRznSocialContratante() {
        return rznSocialContratante;
    }

    public void setRznSocialContratante(String rznSocialContratante) {
        this.rznSocialContratante = rznSocialContratante;
    }
    
    

}
