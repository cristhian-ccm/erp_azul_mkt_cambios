/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.training;

import ts.com.service.util.db.client.FieldDB;
import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;

/**
 *
 * @author Sistemas
 */

@TableDB(name = "training.sesiones", sequence = "training.sesiones_id_seq")
public class Sesiones implements Serializable{
    @FieldDB(value = "id")
    public Integer id;
    
    @FieldDB(value = "visitas")
    public Integer visitas;
}
