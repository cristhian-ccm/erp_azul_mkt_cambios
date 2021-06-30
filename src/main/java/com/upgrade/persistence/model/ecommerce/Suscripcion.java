/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.ecommerce;

import com.fasterxml.jackson.annotation.JsonFormat;
import ts.com.service.util.db.client.FieldDB;
import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Sistemas
 */
@TableDB(name="ecommerce.suscripciones")
public class Suscripcion implements Serializable{
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

    @FieldDB(value = "email")
    public String email;

    @FieldDB(value = "telefono")
    public String telefono;

    @FieldDB(value = "fecha_nacimiento")
    public String fecha_nacimiento;

    @FieldDB(value = "nombre")
    public String nombre;

    @FieldDB(value = "cupon_id")
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
        final Suscripcion other = (Suscripcion) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
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
