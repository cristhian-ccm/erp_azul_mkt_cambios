/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.tcros;

import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;
import java.util.Objects;


/**
 *
 * @author Evander
 */

@TableDB(name="tcros.tratamientos", sequence="tcros.tratamientos_id_seq")
public class Tratamiento implements Serializable {

    public Tratamiento() {
    	
    }
    public Integer id;
    public Boolean inactivo;
    public String nombre;

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
        final Tratamiento other = (Tratamiento) obj;
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
