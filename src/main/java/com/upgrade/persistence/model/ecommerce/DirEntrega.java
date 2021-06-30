/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.ecommerce;

import com.upgrade.persistence.model.tcros.Persona;
import ts.com.service.util.db.client.FieldDB;
import ts.com.service.util.db.client.TableDB;
import com.upgrade.persistence.model.ecommerce.UsuarioWeb;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Sistemas
 */
@TableDB(name="ecommerce.dir_entrega")
public class DirEntrega implements Serializable{
    @FieldDB(value = "id")
    public Integer id;

    @FieldDB(value = "creado_por")
    public Integer creado_por;

    @FieldDB(value = "activo")
    public Boolean activo;

    @FieldDB(value = "creacion")
    public Date creacion;

    @FieldDB(value = "nombres")
    public String nombres;

    @FieldDB(value = "apellidos")
    public String apellidos;

    @FieldDB(value = "telefono")
    public String telefono;

    @FieldDB(value = "direccion")
    public String direccion;

    @FieldDB(value = "nro_lote")
    public String nro_lote;

    @FieldDB(value = "dpto_interior")
    public String dpto_interior;

    @FieldDB(value = "urbanizacion")
    public String urbanizacion;

    @FieldDB(value = "referencia")
    public String referencia;

    @FieldDB(value = "lat")
    public Double lat;

    @FieldDB(value = "lon")
    public Double lon;

    @FieldDB(value = "ubigeo")
    public String ubigeo;

    @FieldDB(value = "email")
    public String email;

    @FieldDB(value = "usuariow_id")
    public UsuarioWeb usuario_web;

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

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNro_lote() {
        return nro_lote;
    }

    public void setNro_lote(String nro_lote) {
        this.nro_lote = nro_lote;
    }

    public String getDpto_interior() {
        return dpto_interior;
    }

    public void setDpto_interior(String dpto_interior) {
        this.dpto_interior = dpto_interior;
    }

    public String getUrbanizacion() {
        return urbanizacion;
    }

    public void setUrbanizacion(String urbanizacion) {
        this.urbanizacion = urbanizacion;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public String getUbigeo() {
        return ubigeo;
    }

    public void setUbigeo(String ubigeo) {
        this.ubigeo = ubigeo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UsuarioWeb getUsuario_web() {
        return usuario_web;
    }

    public void setUsuario_web(UsuarioWeb usuario_web) {
        this.usuario_web = usuario_web;
    }

    @Override
    public String toString() {
        return "DirEntrega{" +
                "id=" + id +
                ", creado_por=" + creado_por +
                ", activo=" + activo +
                ", creacion=" + creacion +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                ", nro_lote='" + nro_lote + '\'' +
                ", dtpo_interior='" + dpto_interior + '\'' +
                ", urbanizacion='" + urbanizacion + '\'' +
                ", referencia='" + referencia + '\'' +
                ", lat=" + lat +
                ", lon=" + lon +
                ", ubigeo='" + ubigeo + '\'' +
                ", email='" + email + '\'' +
                //", usuariow_id=" + usuariow_id +
                '}';
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
        final DirEntrega other = (DirEntrega) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
