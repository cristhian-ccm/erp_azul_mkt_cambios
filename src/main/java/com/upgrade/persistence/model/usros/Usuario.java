/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.usros;

import com.upgrade.persistence.model.tcros.Persona;
import ts.com.service.util.db.client.FieldDB;
import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Evander
 */
@TableDB(name="usros.usuarios", sequence="usros.usuarios_id_seq")
public class Usuario implements Serializable {
    
    @FieldDB(value = "id")
    public Persona id;
    
    @FieldDB(value = "inactivo")
    public Boolean inactivo;
    
    @FieldDB(value = "usuario_id")
    public String usuario;
    
    @FieldDB(value = "clave")
    public String clave;

    public Persona getId() {
        return id;
    }

    public void setId(Persona id) {
        this.id = id;
    }

    public Boolean getInactivo() {
        return inactivo;
    }

    public void setInactivo(Boolean inactivo) {
        this.inactivo = inactivo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    public String getNombrePersona()
    {
        return this.getId().getNombre();
    }
    
    public String getIdentificadorPersona()
    {
        return this.getId().getIdentificador();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
    	//return this.usuario;
        return this.id.getNombre();
    }
    
   
    
    
}
