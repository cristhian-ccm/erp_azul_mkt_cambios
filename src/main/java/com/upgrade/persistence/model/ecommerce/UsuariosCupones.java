/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.ecommerce;

import ts.com.service.util.db.client.FieldDB;
import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Sistemas
 */
@TableDB(name="ecommerce.usuario_cupones")
public class UsuariosCupones implements Serializable{
    //--------------------------------------------------------------------------------------------
    @FieldDB(value = "id")
    public Integer id;
    
    @FieldDB(value = "usuariow_id")
    public UsuarioWeb usuariow;

    @FieldDB(value = "cupon_id")
    public Cupones cupon;
    
    @FieldDB(value = "utilizado")
    public Boolean utilizado;
    //--------------------------------------------------------------------------------------------
    public Integer getId() {
        return id;
    }

    public void setId(Integer Id){
        this.id = id;
    }
    //--------------------------------------------------------------------------------------------
    public UsuarioWeb getUsuariow() {
        return usuariow;
    }

    public void setUsuariow(UsuarioWeb usuariow) {
        this.usuariow = usuariow;
    }
    //--------------------------------------------------------------------------------------------
    public Cupones getCupon() {
        return cupon;
    }

    public void setCupon(Cupones cupon) {
        this.cupon = cupon;
    }
    //--------------------------------------------------------------------------------------------
    public Boolean getUtilizado() {
        return utilizado;
    }

    public void setUtilizado(Boolean utilizado) {
        this.utilizado = utilizado;
    }
    //--------------------------------------------------------------------------------------------
}
