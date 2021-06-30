/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model;

import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;
import java.util.Objects;


/**
 *
 * @author Evander
 */
@TableDB(name="public.documentos_identidad", sequence="public.documentos_identidad_id_seq")
public class DocumentoIdentidad implements Serializable {
    
    public DocumentoIdentidad() { 
    }
    public Integer id;
    public Boolean inactivo;
    public String nombre;
    public String abreviatura;
    public Character additional_account;

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

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public Character getAdditional_account() {
        return additional_account;
    }

    public void setAdditional_account(Character additional_account) {
        this.additional_account = additional_account;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 7;
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
        final DocumentoIdentidad other = (DocumentoIdentidad) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return abreviatura;
    }
    
    
    
    
}
