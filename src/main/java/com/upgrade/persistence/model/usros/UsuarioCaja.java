/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.usros;

import com.upgrade.persistence.model.fnnzs.Caja;
import ts.com.service.util.db.client.FieldDB;
import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;

/**
 *
 * @author Evander
 */
@TableDB(name="usros.usuarios_cajas", sequence="usros.usuarios_cajas_id_seq")
public class UsuarioCaja implements Serializable {

    public UsuarioCaja() {
    
        //super.tableName = "usros.usuarios_cajas";
        //super.sequenceName = "usros.usuarios_cajas_id_seq";
        
    }
    
    @FieldDB(value = "id")
    public Integer id;
    
    @FieldDB(value = "usuario_id")
    public Usuario usuario;
    
    @FieldDB(value = "caja_id")
    public Caja caja;
    
    
}
