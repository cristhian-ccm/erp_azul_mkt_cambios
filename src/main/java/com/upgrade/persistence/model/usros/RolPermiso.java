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
@TableDB(name="usros.roles_permisos", sequence= "usros.roles_permisos_id_seq")
public class RolPermiso  implements Serializable {
    
    public RolPermiso(){
    }
    @FieldDB(value = "id")
    public Integer id;
    
    @FieldDB(value = "rol_id")
    public Rol rol;
    
    @FieldDB(value = "permiso_id")
    public Permiso permiso;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Permiso getPermiso() {
        return permiso;
    }

    public void setPermiso(Permiso permiso) {
        this.permiso = permiso;
    }
    
    public String getNombrePermiso()
    {
        return this.permiso.getAccion();
    }        
    
    public int getPermisoId()
    {
        return this.permiso.getId();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final RolPermiso other = (RolPermiso) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
}
