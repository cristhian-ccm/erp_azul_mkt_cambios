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
@TableDB(name="ecommerce.promociones")
public class Promocion implements Serializable{
    @FieldDB(value = "id")
    public Integer id;

    @FieldDB(value = "creado_por")
    public Integer creado_por;

    @FieldDB(value = "activo")
    public Boolean activo;

    @FieldDB(value = "creacion")
    public Date creacion;

    @FieldDB(value = "url_img")
    public String urlImg;

    @FieldDB(value = "cupon_id")
    public Integer cuponId;

    @FieldDB(value = "monto_min")
    public Integer monto_min;

    @FieldDB(value = "cupon_monto")
    public Integer cupon_monto;

    @FieldDB(value = "vigencia_cupon")
    public Integer vigencia_cupon;

    @FieldDB(value = "fecha_limite")
    public Date fecha_limite;

    @FieldDB(value = "prefijo")
    public String prefijo;

    @FieldDB(value = "titulo")
    public String titulo;

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

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public Integer getCuponId() {
        return cuponId;
    }

    public void setCuponId(Integer cuponId) {
        this.cuponId = cuponId;
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
        final Promocion other = (Promocion) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
