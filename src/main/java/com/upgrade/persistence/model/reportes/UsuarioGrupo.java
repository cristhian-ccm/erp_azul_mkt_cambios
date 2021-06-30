/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.reportes;

import com.upgrade.persistence.model.usros.Usuario;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author evander
 */
public class UsuarioGrupo implements Serializable {
    
    public Integer id;
    public Usuario usuario;
    public Grupo grupo;
    
    public UsuarioGrupo() {
        //super.tableName = "reportes.usuario_grupo";
        //super.sequenceName = "reportes.usuario_grupo_id_seq";
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
        final UsuarioGrupo other = (UsuarioGrupo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return usuario.usuario + " - " + grupo.nombre;
    }
    
    
    
    
}
