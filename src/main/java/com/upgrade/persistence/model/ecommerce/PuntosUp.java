/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.ecommerce;

import com.upgrade.persistence.model.cmrlz.NotaPedidoCab;
import ts.com.service.util.db.client.FieldDB;
import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Sistemas
 */
@TableDB(name="ecommerce.puntos_up")
public class PuntosUp implements Serializable{
    @FieldDB(value = "id")
    public Integer id;

    @FieldDB(value = "creado_por")
    public Integer creado_por;

    @FieldDB(value = "activo")
    public Boolean activo;

    @FieldDB(value = "creacion")
    public Date creacion;

    @FieldDB(value = "usuariow_id")
    public UsuarioWeb usuariow;

    @FieldDB(value = "nota_id")
    public NotaPedidoCab notaped_cab;

    @FieldDB(value = "pts_inc")
    public Integer pts_inc;

    @FieldDB(value = "pts_dec")
    public Integer pts_dec;

    @FieldDB(value = "pts_restantes")
    public Integer pts_restantes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCreado_por() {
        return creado_por;
    }

    public void setCreado_por(Integer creado_por) {
        this.creado_por = creado_por;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Date getCreacion() {
        return creacion;
    }

    public void setCreacion(Date creacion) {
        this.creacion = creacion;
    }

    public UsuarioWeb getUsuariow() {
        return usuariow;
    }

    public void setUsuariow(UsuarioWeb usuariow) {
        this.usuariow = usuariow;
    }
    
    public String getNombre_Usuweb(){
        if(usuariow != null && usuariow.getNombres() != null && usuariow.getApellidos() != null) 
        {return usuariow.getNombres() + " " + usuariow.getApellidos();}
        else {return "";}
    }
    
    public String getApellidos_Usuweb(){
        if(usuariow != null && usuariow.getApellidos() != null) {return usuariow.getApellidos();}
        else {return "";}
    }
    
    public String getEmail_Usuweb(){
        if(usuariow != null && usuariow.getEmail() != null) {return usuariow.getEmail();}
        else {return "";}
    }
    
    public String getTelf_Usuweb(){
        if(usuariow != null && usuariow.getTelefono() != null) {return usuariow.getTelefono();}
        else {return "";}
    }

    public NotaPedidoCab getNotaped_Cab() {
        return notaped_cab;
    }

    public void setNotaped_Cab(NotaPedidoCab notaped_cab) {
        this.notaped_cab = notaped_cab;
    }

    public Integer getPts_inc() {
        return pts_inc;
    }

    public void setPts_inc(Integer pts_inc) {
        this.pts_inc = pts_inc;
    }

    public Integer getPts_dec() {
        return pts_dec;
    }

    public void setPts_dec(Integer pts_dec) {
        this.pts_dec = pts_dec;
    }

    public Integer getPts_restantes() {
        return pts_restantes;
    }

    public void setPts_restantes(Integer pts_restantes) {
        this.pts_restantes = pts_restantes;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.id);
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
        final PuntosUp other = (PuntosUp) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
