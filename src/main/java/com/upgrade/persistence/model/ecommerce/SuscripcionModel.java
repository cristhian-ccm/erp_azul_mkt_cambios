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
public class SuscripcionModel implements Serializable{

    public Integer id;
    public Integer creado_por;
    public Boolean activo;
    public Date creacion;
    public UsuarioWeb usuariow;
    public String email;
    public String telefono;
    public String fecha_nacimiento;
    public String nombre;
    public Cupones cupon;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Cupones getCupon() {
        return cupon;
    }
    
    public String getCuponNombre() {
        if(this.cupon != null)
        {    return cupon.getNombreCupon(); }
        else
        { return "";}
    }

    public void setCupon(Cupones cupon) {
        this.cupon = cupon;
    }

    @Override
    public String toString() {
        return "Suscripcion{" +
                "id=" + id +
                ", creado_por=" + creado_por +
                ", activo=" + activo +
                ", creacion=" + creacion +
                ", usuariow=" + usuariow +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", fecha_nacimiento=" + fecha_nacimiento +
                ", nombre='" + nombre + '\'' +
                ", cupon=" + cupon +
                '}';
    }
}
