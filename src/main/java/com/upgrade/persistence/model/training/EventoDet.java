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

@TableDB(name = "training.evento_det", sequence = "training.evento_det_id_seq")
public class EventoDet implements Serializable{
     @FieldDB(value = "id")
     public Integer id;
     
     @FieldDB(value = "evento_id")
     public EventoCab eventoID;
     
     @FieldDB(value = "inicio")
     public Date inicio;
     
     @FieldDB(value = "fin")
     public Date fin;
     
     @FieldDB(value = "descripcion")
     public String descripcion;
}
