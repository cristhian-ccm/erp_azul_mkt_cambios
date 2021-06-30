/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.fnnzs;

import ts.com.service.util.db.client.FieldDB;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author USER
 */
public class CuentaBancariaTipo implements Serializable {
    @FieldDB(value = "id")
    public Integer id;
    
    @FieldDB(value = "inactivo")
    public Boolean inactivo;
    
    @FieldDB(value = "nombre")
    public String nombre;
    
    @FieldDB(value = "predefinido")
    public Boolean predefinido;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Boolean getPredefinido() {
        return predefinido;
    }

    public void setPredefinido(Boolean predefinido) {
        this.predefinido = predefinido;
    }

    public CuentaBancariaTipo() {
        
        //super.tableName = "fnnzs.cuentas_bancarias_tipos";
        //super.sequenceName = "fnnz.cuentas_bancarias_tipos_id_seq";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.id);
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
        final CuentaBancariaTipo other = (CuentaBancariaTipo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
