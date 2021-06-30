/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.tcros;

import ts.com.service.util.db.client.FieldDB;
import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Evander
 */
@TableDB(name="tcros.direcciones", sequence="tcros.direcciones_id_seq")
public class Direccion implements Serializable {

    @FieldDB(value = "creado_por")
    public Persona creadoPor;
    @FieldDB(value = "editado")
    public Date editado;

    @FieldDB(value = "editado_por")
    public Persona editadoPor;

    @FieldDB(value = "id")
    public Integer id;

    @FieldDB(value = "inactivo")
    public Boolean inactivo;

    @FieldDB(value = "persona_id")
    public Persona persona;

    @FieldDB(value = "nombre")
    public String nombre;
    
    @FieldDB(value = "descripcion")
    public String descripcion;
    
    @FieldDB(value = "ubigeo")
    public String ubigeoCodigo;
    
    @FieldDB(value = "principal")
    public Boolean principal;
    
    @FieldDB(value = "vendedor_id")
    public Persona vendedor;
    
    @FieldDB(value = "telefono")
    public String telefono;
    
    @FieldDB(value = "email")
    public String email;
    
    @FieldDB(value = "vendedor_id_seguimiento")
    public Persona seguimiento;

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

    public Boolean getInactivo() {
        return inactivo;
    }

    public void setInactivo(Boolean inactivo) {
        this.inactivo = inactivo;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUbigeoCodigo() {
        return ubigeoCodigo;
    }

    public void setUbigeoCodigo(String ubigeoCodigo) {
        this.ubigeoCodigo = ubigeoCodigo;
    }

    public Boolean getPrincipal() {
        return principal;
    }

    public void setPrincipal(Boolean principal) {
        this.principal = principal;
    }

    public Persona getVendedor() {
        return vendedor;
    }

    public void setVendedor(Persona vendedor) {
        this.vendedor = vendedor;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Persona getSeguimiento() {
        return seguimiento;
    }

    public void setSeguimiento(Persona seguimiento) {
        this.seguimiento = seguimiento;
    }
    
    public String getNombrePersona()
    {
        return this.persona.getNombre();
    }

   

    @Override
    public String toString() {
        return descripcion;
    }    
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Direccion other = (Direccion) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
