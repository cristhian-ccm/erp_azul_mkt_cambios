/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model;


import ts.com.service.util.db.client.FieldDB;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author USER
 */
public class PreventaTipo implements Serializable {
    
    @FieldDB(value = "id")
    public Integer id;
    
    @FieldDB(value = "inactivo")
    public Boolean inactivo;
    
    @FieldDB(value = "nombre")
    public String nombre;

    public PreventaTipo() {
        //super.tableName = "cmrlz.preventas_tipo";
        //super.sequenceName = "cmrlz.preventas_tipo_id_seq";
    }

    public Integer getId() {
        return id;
    }

   

    public Boolean getInactivo() {
        return inactivo;
    }

    public void setInactivo(Boolean inactivo) {
        this.inactivo = inactivo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        final PreventaTipo other = (PreventaTipo) obj;
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
