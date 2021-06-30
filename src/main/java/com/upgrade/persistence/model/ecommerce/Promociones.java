/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.ecommerce;

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

@TableDB(name="ecommerce.promociones", sequence="ecommerce.promociones_id_seq")
public class Promociones implements Serializable{
    
    //--------------------------------------------------------------------------
    //VARIABLES
    //--------------------------------------------------------------------------
    @FieldDB(value = "id")
    public Integer id;

    @FieldDB(value = "creado_por")
    public Persona creado_por;
    
    @FieldDB(value = "creacion")
    public Date creacion;
    
    @FieldDB(value = "activo")
    public Boolean activo;
    
    @FieldDB(value = "prefijo")
    public String prefijo;
    
    @FieldDB(value = "titulo")
    public String titulo;
    
    @FieldDB(value = "url_img")
    public String url_img;
    
    @FieldDB(value = "cupon_id")
    public Cupones cupon;
    
    @FieldDB(value = "monto_min")
    public Integer monto_min;
    
    @FieldDB(value = "cupon_monto")
    public Integer cupon_monto;
    
    @FieldDB(value = "vigencia_cupon")
    public Integer vigencia_cupon;
    
     @FieldDB(value = "fecha_limite")
    public Date fecha_limite;
    
    
    //--------------------------------------------------------------------------
    //GET'S && SET'S 
    //--------------------------------------------------------------------------
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    
    public Persona getCreado_por() {
        return creado_por;
    }
    public void setCreado_por(Persona creado_por) {
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
    
    
    public String getPrefijo() {
        return prefijo;
    }
    public void setPrefijo(String prefijo) {
        this.prefijo = prefijo;
    }
    
    
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    
    public String getUrl_img() {
        return url_img;
    }
    public void setUrl_img(String url_img) {
        this.url_img = url_img;
    }
    
    
    public Cupones getCupon() {
        return cupon;
    }
    public void setCupon(Cupones cupon) {
        this.cupon = cupon;
    }
    
    
    public Integer getMonto_min() {
        return monto_min;
    }
    public void setMonto_min(Integer monto_min) {
        this.monto_min = monto_min;
    }
    
    
    public Integer getCupon_monto() {
        return cupon_monto;
    }
    public void setCupon_monto(Integer cupon_monto) {
        this.cupon_monto = cupon_monto;
    }
    
    
    public Integer getVigencia_cupon() {
        return vigencia_cupon;
    }
    public void setVigencia_cupon(Integer vigencia_cupon) {
        this.vigencia_cupon = vigencia_cupon;
    }
    
    
    public Date getFecha_limite() {
        return fecha_limite;
    }
    public void setFecha_limite(Date fecha_limite) {
        this.fecha_limite = fecha_limite;
    }
    //--------------------------------------------------------------------------
    //OTROS 
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
        final Cupones other = (Cupones) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cupones{" +
                "id=" + id +
                ", creado_por=" + creado_por +
                ", activo=" + activo +
                ", creacion=" + creacion +
                ", titulo='" + titulo +
                ", url_img='" + url_img + '\'' +
                ", cupon=" + cupon +
                ", monto_min=" + monto_min +
                ", cupon_monto=" + cupon_monto +
                ", vigencia_cupon=" + vigencia_cupon +
                ", fecha_limite=" + fecha_limite +
                '}';
    }
}
