/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.training;

import ts.com.service.util.db.client.FieldDB;
import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Sistemas
 */

@TableDB(name = "training.asistentes", sequence = "training.asistentes_id_seq")
public class Asistente implements Serializable{
    
    @FieldDB(value = "id")
    public Integer id;
    
    @FieldDB(value = "numero")
    public Integer numero;
    
    @FieldDB(value = "evento_id")
    public EventoCab eventoID;
    
    @FieldDB(value = "nombres")
    public String nombres;
    
    @FieldDB(value = "email")
    public String email;
    
    @FieldDB(value = "empresa")
    public String empresa;
    
    @FieldDB(value = "telefono")
    public String telefono;
    
    @FieldDB(value = "posicion")
    public String posicion;
    
    @FieldDB(value = "asistencia")
    public Boolean asistencia;
    
    @FieldDB(value = "relacion")
    public String relacion;
    
    @FieldDB(value = "dia_asistencia")
    public Date diaAsistencia;
    
    @FieldDB(value = "maquinas")
    public String maquinas;
}
