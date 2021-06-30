/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model;

import com.upgrade.persistence.factory.Numbers;
import ts.com.service.util.db.client.FieldDB;
import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author Evander
 */
@TableDB(name	="public.percepciones", sequence="public.percepciones_id_seq")
public class Percepcion implements Serializable{
    
    @FieldDB(value = "id")
    public Integer id;
    
    @FieldDB(value = "inactivo")
    public Boolean inactivo;
    
    @FieldDB(value = "nombre")
    public String nombre;
    
    @FieldDB(value = "valor")
    public BigDecimal valor;
    
    @Override
    public String toString() {
        return Numbers.getBigDecimal(valor, 2) + "%";
    }
}
