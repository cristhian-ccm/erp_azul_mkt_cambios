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
public class Invitado implements Serializable {

    public Invitado() {
    
        //super.tableName = "premiacion.invitado";
        //super.sequenceName = "premiacion.invitado_id_seq";
        
    }
    
    @FieldDB(value = "id")
    public Integer id;
    
    @FieldDB(value = "apellidos")
    public String apellidos;
    
    @FieldDB(value = "nombres")
    public String nombres;
    
    @FieldDB(value = "empresa")
    public Empresa empresa;
    
    @FieldDB(value = "representante")
    public String representante;
    
    @FieldDB(value = "registrado")
    public Boolean registrado;

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
        final Invitado other = (Invitado) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return apellidos + " " + nombres;
    }
    
    
    
}
