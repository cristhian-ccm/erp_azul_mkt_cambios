/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.ecommerce;

import com.upgrade.persistence.model.extcs.Producto;
import com.upgrade.persistence.model.tcros.Persona;
import ts.com.service.util.db.client.FieldDB;
import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
/**
 *
 * @author Luis Aleman
 */
@TableDB(name="ecommerce.imagenes_producto")
public class ImagenesProducto implements Serializable{
    //Campos
    //-----------------------------------------------------------------------------------
    @FieldDB(value = "id")
    public Integer id;
    
    @FieldDB(value = "creado_por")
    public Persona creadoPor;
    
    @FieldDB(value = "creacion")
    public Date creacion;
    
    @FieldDB(value = "producto_id")
    public Producto producto;
    
    @FieldDB(value = "url_imagen")
    public String url_imagen;
    //-----------------------------------------------------------------------------------
    
    //Funciones
    //-----------------------------------------------------------------------------------
    public Persona getCreadoPor() {
        return creadoPor;
    }
    public void setCreadoPor(Persona creadoPor) {
        this.creadoPor = creadoPor;
    }
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Date getCreacion() {
        return creacion;
    }
    public void setCreacion(Date creacion) {
        this.creacion = creacion;
    }
    
    public Producto getProducto() {
        return producto;
    }
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    public String getUrl_Imagen() {
        return url_imagen;
    }
    public void setUrl_Imagen(String url_imagen) {
        this.url_imagen = url_imagen;
    }
    //-----------------------------------------------------------------------------------
    
    //FUNCTION
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.id);
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
        final ImagenesProducto other = (ImagenesProducto) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return url_imagen;
    }
}
