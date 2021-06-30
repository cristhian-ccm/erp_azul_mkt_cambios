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
@TableDB(name="ecommerce.catalogo_puntos")
public class CatalogoPuntosUp implements Serializable {
    
    //--------------------------------------------------------------------------
    //ATRIBUTOS
    //--------------------------------------------------------------------------
    @FieldDB(value = "id")
    public Integer id;

    @FieldDB(value = "creado_por")
    public Integer creado_por;

    @FieldDB(value = "creacion")
    public Date creacion;
    
    @FieldDB(value = "activo")
    public Boolean activo;
    
    @FieldDB(value = "url_pdf")
    public String url_pdf;
    
    //--------------------------------------------------------------------------
    //GET'S AND SET'S
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
    
    
    public String getUrl_pdf() {
        return url_pdf;
    }
    public void setUrl_pdf(String url_pdf) {
        this.url_pdf = url_pdf;
    }
    
    //--------------------------------------------------------------------------
    //OTHERS
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
        final PuntosUp other = (PuntosUp) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    //--------------------------------------------------------------------------
}
