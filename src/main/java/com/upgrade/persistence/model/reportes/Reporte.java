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
public class Reporte implements Serializable {
    public Integer id;
    public String nombre;
    public String jasper;
    public Character estado;
    
    public Reporte() {
        //super.tableName = "reportes.reporte";
        //super.sequenceName = "reportes.reporte_id_seq";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
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
        final Reporte other = (Reporte) obj;
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
