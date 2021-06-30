/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.extcs;

import ts.com.service.util.db.client.FieldDB;
import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Evander
 */
@TableDB(name="extcs.motivos_traslado", sequence = "extcs.motivos_traslado_id_seq")
public class MotivoTraslado implements Serializable {

    @FieldDB(value = "id")
    public Integer id;
    
    @FieldDB(value = "inactivo")
    public Boolean inactivo;
    
    @FieldDB(value = "motivo")
    public String motivo;
    
    @FieldDB(value = "predefinido")
    public Boolean predefinido;
    
    @FieldDB(value = "tipo")
    public Character tipo;
    
    public MotivoTraslado() {
        //super.tableName = "extcs.motivos_traslado";
        //super.sequenceName = "extcs.motivos_traslado_id_seq";
    
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
        final MotivoTraslado other = (MotivoTraslado) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }   
    
    @Override
    public String toString() {
        return motivo;
    }    
}
   
