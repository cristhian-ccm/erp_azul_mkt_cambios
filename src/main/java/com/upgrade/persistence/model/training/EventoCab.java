/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.training;

import com.upgrade.persistence.model.tcros.Persona;
import ts.com.service.util.db.client.FieldDB;
import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Sistemas
 */

@TableDB(name = "training.evento_cab", sequence = "training.evento_cab_id_seq")
public class EventoCab implements Serializable{
    @FieldDB(value = "id")
    public Integer id;
    
    @FieldDB(value = "creador")
    public Persona creador;
    
    @FieldDB(value = "titulo")
    public String titulo;
    
    @FieldDB(value = "fecha")
    public Date fecha;
    
    @FieldDB(value = "Direccion")
    public String direccion;
    
    @FieldDB(value = "activo")
    public Boolean activo;
    
    @FieldDB(value = "tema_hora")
    public Boolean temaHora;
    
     @FieldDB(value = "dias")
    public Integer dias;
    
}
