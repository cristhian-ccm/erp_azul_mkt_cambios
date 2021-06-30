/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.emprs;

import ts.com.service.util.db.client.FieldDB;
import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author etorres
 */
@TableDB(name="emprs.empresas", sequence="emprs.empresas_id_seq")
public class Empresa implements Serializable {
    

    @FieldDB(value = "id")
    public Integer id;                 

    @FieldDB(value = "inactivo")
    public Boolean inactivo;                  

    @FieldDB(value = "nombre")
    public String nombre;                     

    @FieldDB(value = "ruc")
    public String ruc;

    @FieldDB(value = "direccion")
    public String direccion;

    @FieldDB(value = "telefono")
    public String telefono;
    
    @FieldDB(value = "logo")
    public String logo;
    
    @FieldDB(value = "agente_retencion")
    public Boolean agenteRetencion;

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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Boolean getAgenteRetencion() {
        return agenteRetencion;
    }

    public void setAgenteRetencion(Boolean agenteRetencion) {
        this.agenteRetencion = agenteRetencion;
    }

    @Override
    public String toString() {
        return nombre;
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
        final Empresa other = (Empresa) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}

