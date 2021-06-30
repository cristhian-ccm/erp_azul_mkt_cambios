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
@TableDB(name="ecommerce.cupones")
public class Cupones implements Serializable{
    @FieldDB(value = "id")
    public Integer id;

    @FieldDB(value = "creado_por")
    public Integer creado_por;

    @FieldDB(value = "activo")
    public Boolean activo;

    @FieldDB(value = "creacion")
    public Date creacion;

    @FieldDB(value = "nombre_cupon")
    public String nombreCupon;

    @FieldDB(value = "monto")
    public Integer monto;

    @FieldDB(value = "precio_min_prod")
    public Integer precioMinProd;
    
    @FieldDB(value = "fecha_ini_vigencia")
    public Date fecha_ini_vigencia;
    
    @FieldDB(value = "fecha_fin_vigencia")
    public Date fecha_fin_vigencia;

    @FieldDB(value = "cantidad")
    public Integer cantidad;

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

    public String getNombreCupon() {
        return nombreCupon;
    }

    public void setNombreCupon(String nombreCupon) {
        this.nombreCupon = nombreCupon;
    }

    public Integer getMonto() {
        return monto;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;
    }

    public Integer getPrecioMinProd() {
        return precioMinProd;
    }

    public void setPrecioMinProd(Integer precioMinProd) {
        this.precioMinProd = precioMinProd;
    }
    
    public Date getFechaIniVigencia() {
        return fecha_ini_vigencia;
    }

    public void setFechaIniVigencia(Date fecha_ini_vigencia) {
        this.fecha_ini_vigencia = fecha_ini_vigencia;
    }

    public Date getFecha_fin_vigencia() {
        return fecha_fin_vigencia;
    }

    public void setFecha_fin_vigencia(Date fecha_fin_vigencia) {
        this.fecha_fin_vigencia = fecha_fin_vigencia;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechaFinVigencia() {
        return fecha_fin_vigencia;
    }

    public void setFechaFinVigencia(Date fecha_fin_vigencia) {
        this.fecha_fin_vigencia = fecha_fin_vigencia;
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
                ", nombreCupon='" + nombreCupon + '\'' +
                ", monto=" + monto +
                ", precioMinProd=" + precioMinProd +
                ", fechaIniVigencia=" + fecha_ini_vigencia +
                ", fechaFinVigencia=" + fecha_fin_vigencia +
                '}';
    }
}
