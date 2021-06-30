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
public class FacturaBoletaVeh implements Serializable{

    public String numPlaca;

    public String getNumPlaca() {
        return numPlaca;
    }

    public void setNumPlaca(String numPlaca) {
        this.numPlaca = numPlaca;
    }

}
