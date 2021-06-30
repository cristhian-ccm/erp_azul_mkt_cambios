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
 * @author Luis Aleman
 */
@TableDB(name="ecommerce.sliders")
public class Sliders implements Serializable{
    //--------------------------------------------------------------------------
    //Campos
    //--------------------------------------------------------------------------
    @FieldDB(value = "id")
    public Integer id;

    @FieldDB(value = "creado_por")
    public Integer creado_por;

    @FieldDB(value = "creacion")
    public Date creacion;
    
    @FieldDB(value = "activo")
    public Boolean activo;
    
    @FieldDB(value = "url_imagen")
    public String url_imagen;
    
    @FieldDB(value = "url_link")
    public String url_link;
    
    //--------------------------------------------------------------------------
    //Gets and Sets
    //--------------------------------------------------------------------------
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

    public Date getCreacion() {
        return creacion;
    }
    public void setCreacion(Date creacion) {
        this.creacion = creacion;
    }
    
    public Boolean getActivo() {
        return activo;
    }
    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
    
    public String getUrl_imagen() {
        return url_imagen;
    }
    public void setUrl_imagen(String url_imagen) {
        this.url_imagen = url_imagen;
    }
    
    public String getUrl_link() {
        return url_link;
    }
    public void setUrl_link(String url_link) {
        this.url_link = url_link;
    }
    
    //--------------------------------------------------------------------------
    //Others
    //--------------------------------------------------------------------------
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
        final Banners other = (Banners) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
