/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.extcs;

import com.upgrade.persistence.model.emprs.Sucursal;
import ts.com.service.util.db.client.FieldDB;
import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Evander
 */
@TableDB(name="extcs.almacenes", sequence="extcs.almacenes_id_seq")
public class Almacen implements Serializable{
    
    @FieldDB(value = "id")
    public Integer id;
    
    @FieldDB(value = "inactivo")
    public Boolean inactivo;
    
    @FieldDB(value = "sucursal_id")
    public Sucursal sucursal;
    
    @FieldDB(value = "nombre")
    public String nombre;
    
    @FieldDB(value = "direccion")
    public String direccion;
    
    @FieldDB(value = "ubigeo")
    public String codigoUbigeo;
    
    @FieldDB(value = "telefono")
    public String telefono;
    
    @FieldDB(value = "fecha_cierre")
    public Date fechaCierre;
    
    @FieldDB(value = "codigo")
    public String codigo;
    
    @FieldDB(value = "traslado_simple")
    public Boolean traslad_simple;
    
    @FieldDB(value = "abreviatura")
    public String abreviatura;
    
    @FieldDB(value = "esventa")
    public Boolean esventa;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getInactivo() {
        return inactivo;
    }

    public void setInactivo(Boolean inactivo) {
        this.inactivo = inactivo;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCodigoUbigeo() {
        return codigoUbigeo;
    }

    public void setCodigoUbigeo(String codigoUbigeo) {
        this.codigoUbigeo = codigoUbigeo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Boolean getTraslad_simple() {
        return traslad_simple;
    }

    public void setTraslad_simple(Boolean traslad_simple) {
        this.traslad_simple = traslad_simple;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public Boolean getEsventa() {
        return esventa;
    }

    public void setEsventa(Boolean esventa) {
        this.esventa = esventa;
    }    
    
    @Override
    public String toString() {
        return nombre;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Almacen other = (Almacen) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
