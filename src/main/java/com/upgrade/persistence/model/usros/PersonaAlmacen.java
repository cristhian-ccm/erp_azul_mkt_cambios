/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.usros;

import com.upgrade.persistence.model.extcs.Almacen;
import com.upgrade.persistence.model.tcros.Persona;
import ts.com.service.util.db.client.FieldDB;

import java.io.Serializable;

/**
 *
 * @author Evander
 */
public class PersonaAlmacen implements Serializable {
    
    @FieldDB(value = "id")
    public Integer id;
    
    @FieldDB(value = "usuario_id")
    public Persona persona;
    
    @FieldDB(value = "almacen_id")
    public Almacen almacen;
    
    
    public PersonaAlmacen() {
        //super.tableName = "usros.usuarios_almacenes";
        //super.sequenceName = "usros.usuarios_almacenes_id_seq";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    

    public Almacen getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }
    
    
    
}
