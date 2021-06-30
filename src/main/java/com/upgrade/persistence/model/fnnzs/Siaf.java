/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.fnnzs;

import com.upgrade.persistence.model.tcros.Persona;
import ts.com.service.util.db.client.FieldDB;
import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
@TableDB(name = "fnnzs.siaf", sequence = "fnnzs.siaf_id_seq")
public class Siaf implements Serializable{
    
    @FieldDB(value = "creado_por")
    public Persona creado;
    
    @FieldDB(value = "editado_por")
    public Persona editado;
    
    @FieldDB(value = "id")
    public Integer id;
}
