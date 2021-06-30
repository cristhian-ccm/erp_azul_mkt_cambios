/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.fnnzs;

import com.upgrade.persistence.model.tcros.Persona;
import ts.com.service.util.db.client.FieldDB;
import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author evander
 */
@TableDB(name="fnnzs.tarjetas", sequence="fnnzs.tarjetas_id_seq")
public class Tarjeta implements Serializable {

    public Tarjeta() {
        //super.tableName  = "fnnzs.tarjetas";
        //super.sequenceName = "fnnzs.tarjetas_id_seq";
    }
    
    @FieldDB(value = "id")
    public Integer id;
    
    @FieldDB(value = "inactivo")
    public Boolean inactivo;
    
    @FieldDB(value = "proveedor_id")
    public Persona proveedor;
    
    @FieldDB(value = "cuenta_bancaria_id")
    public CuentaBancaria cuentasBancarias;
    
    @FieldDB(value = "nombre")
    public String nombre;
    
    @FieldDB(value = "comision")
    public BigDecimal comision;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.id);
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
        final Tarjeta other = (Tarjeta) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    
    
}
