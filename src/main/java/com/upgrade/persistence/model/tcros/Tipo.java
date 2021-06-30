/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.tcros;

import ts.com.service.util.db.client.FieldDB;
import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author evander
 */
@TableDB(name	="tcros.tipos", sequence="tcros.tipos_id_seq")
public class Tipo implements Serializable {

    @FieldDB(value = "id")
    public Integer id;
    
    @FieldDB(value = "inactivo")
    public Boolean inactivo;
    
    @FieldDB(value = "nombre")
    public String nombre;

    @Override
    public String toString() {
        return nombre;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.id);
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
        final Tipo other = (Tipo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
    public Tipo() {
        //super.tableName = "tcros.tipos";
        //super.sequenceName = "tcros.tipos_id_seq";
    }
    
    
    
   
    
}
