/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.usros;

import ts.com.service.util.db.client.FieldDB;
import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author USER
 */
@TableDB(name = "usros.usuarios_roles", sequence = "usros.usuarios_roles_id_seq")
public class UsuarioRol implements Serializable {

    public UsuarioRol() {
    }

    @FieldDB(value = "id")
    public Integer id;
    
    @FieldDB(value = "usuario_id")
    public Usuario usuario;
    
    @FieldDB(value = "rol_id")
    public Rol rol;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
    public String getNombreRol()
    {
        return this.rol.getNombre();
    }        
    
    public int getRolId()
    {
        return this.rol.getId();
    } 

    @Override
    public int hashCode() {
        int hash = 7;
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
        final UsuarioRol other = (UsuarioRol) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
}
