/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.reportes;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author evander
 */
public class Grupo implements Serializable {
    
    public Integer id;
    public String nombre;
    public Character estado;
    
    public Grupo() {
        //super.tableName = "reportes.grupo";
        //super.sequenceName = "reportes.grupo_id_seq";
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final Grupo other = (Grupo) obj;
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
