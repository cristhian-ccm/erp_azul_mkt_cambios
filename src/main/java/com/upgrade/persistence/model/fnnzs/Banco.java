/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.fnnzs;

import ts.com.service.util.db.client.FieldDB;
import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author USER
 */
@TableDB(name = "fnnzs.bancos", sequence = "fnnzs.bancos_id_seq")
public class Banco implements Serializable{
    @FieldDB(value = "id")
    public Integer id;
    
    @FieldDB(value = "inactivo")
    public Boolean inactivo;
    
    @FieldDB(value = "nombre")
    public String nombre;
    
    @FieldDB(value = "codigo_legal")
    public Character codigoLegal;
    
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

    public Character getCodigoLegal() {
        return codigoLegal;
    }

    public void setCodigoLegal(Character codigoLegal) {
        this.codigoLegal = codigoLegal;
    }

    public Boolean getPredefinido() {
        return predefinido;
    }

    public void setPredefinido(Boolean predefinido) {
        this.predefinido = predefinido;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    public Banco() {
        //super.tableName = "fnnzs.bancos";
        //super.sequenceName = "fnnz.bancos_id_seq";
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Banco other = (Banco) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
