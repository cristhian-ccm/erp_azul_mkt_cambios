/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.premiacion;

import ts.com.service.util.db.client.FieldDB;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author evander
 */
public class Empresa implements Serializable {

    public Empresa() {
        //super.tableName = "premiacion.empresa";
        //super.sequenceName = "premiacion.empresa_id_seq";
    }
    
    @FieldDB(value = "id")
    public Integer id;

    @FieldDB(value = "nombre")
    public String nombre;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        final Empresa other = (Empresa) obj;
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
