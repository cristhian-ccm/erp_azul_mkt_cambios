/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.auxiliar;

import com.upgrade.persistence.model.fnnzs.DepositosCliente;
import com.upgrade.persistence.model.fnnzs.Recibo;

import java.io.Serializable;

/**
 *
 * @author darko
 */
public class DepositoClienteVisa implements Serializable {

    public Recibo recibo;
    public DepositosCliente depositosCliente;


     public Recibo getRecibo() {
        return recibo;
    }

    public void setRecibo(Recibo recibo) {
        this.recibo = recibo;
    }

    public DepositosCliente getDepositosCliente() {
        return depositosCliente;
    }

    public void setDepositosCliente(DepositosCliente depositosCliente) {
        this.depositosCliente = depositosCliente;
    }

 
}
