/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.ecommerce;

import ts.com.service.util.db.client.FieldDB;
import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Sistemas
 */
@TableDB(name="ecommerce.usuario_web")
public class UsuarioWeb implements Serializable{
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

    @FieldDB(value = "password")
    public String password;

    @FieldDB(value = "email")
    public String email;

    @FieldDB(value = "telefono")
    public String telefono;

    @FieldDB(value = "verificado")
    public Boolean verificado;

    @FieldDB(value = "key_verificar")
    public String key_verificar;

    @FieldDB(value = "tipo")
    public String tipo;

    @FieldDB(value = "url_foto")
    public String urlFoto;

    @FieldDB(value = "key_reset_passw")
    public String key_reset_passw;

    @FieldDB(value = "key_reset_caduca")
    public Date key_reset_caduca;

    @FieldDB(value = "fecha_nacimiento")
    public Date fecha_nacimiento;


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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Boolean getVerificado() {
        return verificado;
    }

    public void setVerificado(Boolean verificado) {
        this.verificado = verificado;
    }

    public String getKey_verificar() {
        return key_verificar;
    }

    public void setKey_verificar(String key_verificar) {
        this.key_verificar = key_verificar;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public String getKey_reset_passw() {
        return key_reset_passw;
    }

    public void setKey_reset_passw(String key_reset_passw) {
        this.key_reset_passw = key_reset_passw;
    }

    public Date getKey_reset_caduca() {
        return key_reset_caduca;
    }

    public void setKey_reset_caduca(Date key_reset_caduca) {
        this.key_reset_caduca = key_reset_caduca;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
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
        final UsuarioWeb other = (UsuarioWeb) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UsuarioWeb{" +
                "id=" + id +
                ", creado_por=" + creado_por +
                ", activo=" + activo +
                ", creacion=" + creacion +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", verificado=" + verificado +
                ", key_verificar='" + key_verificar + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
