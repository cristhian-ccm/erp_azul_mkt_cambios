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
public class NombreArchivo implements Serializable {

    public Integer tipoDocumento;
    public Character docuemnto;
    public Integer serieDocuemnto;
    public Integer numeroDocuemnto;

    public Integer getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(Integer tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Character getDocuemnto() {
        return docuemnto;
    }

    public void setDocuemnto(Character docuemnto) {
        this.docuemnto = docuemnto;
    }

    public Integer getSerieDocuemnto() {
        return serieDocuemnto;
    }

    public void setSerieDocuemnto(Integer serieDocuemnto) {
        this.serieDocuemnto = serieDocuemnto;
    }

    public Integer getNumeroDocuemnto() {
        return numeroDocuemnto;
    }

    public void setNumeroDocuemnto(Integer numeroDocuemnto) {
        this.numeroDocuemnto = numeroDocuemnto;
    }
    
    

}
