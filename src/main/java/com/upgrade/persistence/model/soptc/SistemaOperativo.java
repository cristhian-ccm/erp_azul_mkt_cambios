/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.soptc;

import com.upgrade.persistence.model.usros.Usuario;
import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author evander
 */
@TableDB(name = "soptc.sistema_operativo",sequence = "soptc.sistema_operativo_id_seq")
public class SistemaOperativo implements Serializable {
    
    public Integer id;
    public Usuario usuarioCreador;
    public Character estado;
    public String descripcion;
    
    public SistemaOperativo() {
    }

    @Override
    public String toString() {
        return descripcion;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.id);
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
        final SistemaOperativo other = (SistemaOperativo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
}
