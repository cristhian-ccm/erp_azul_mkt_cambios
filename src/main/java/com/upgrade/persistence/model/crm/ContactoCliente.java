/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.crm;

import com.upgrade.persistence.model.tcros.Direccion;
import com.upgrade.persistence.model.tcros.Persona;
import ts.com.service.util.db.client.FieldDB;
import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author darko
 */
@TableDB(name = "crm.contacto_cliente", sequence = "crm.contacto_cliente_id_seq")
public class ContactoCliente implements Serializable {

    @FieldDB(value = "id")
    public Integer id;

    @FieldDB(value = "creado_por")
    public Persona creadoPor;

    @FieldDB(value = "creado")
    public Date creado;

    @FieldDB(value = "editado_por")
    public Persona editadoPor;

    @FieldDB(value = "editado")
    public Date editado;

    @FieldDB(value = "direccion_cliente_id")
    public Direccion direccionCliente;

    @FieldDB(value = "nombre")
    public String nombre;
    
    @FieldDB(value = "direccion")
    public String direccion;

    @FieldDB(value = "telefono")
    public String telefono;

    @FieldDB(value = "correo")
    public String correo;

    @FieldDB(value = "cargo")
    public String cargo;

    @FieldDB(value = "observacion")
    public String observacion;

    @FieldDB(value = "anulado")
    public Boolean anulado;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Persona getCreadoPor() {
        return creadoPor;
    }

    public void setCreadoPor(Persona creadoPor) {
        this.creadoPor = creadoPor;
    }

    public Date getCreado() {
        return creado;
    }

    public void setCreado(Date creado) {
        this.creado = creado;
    }

    public Persona getEditadoPor() {
        return editadoPor;
    }

    public void setEditadoPor(Persona editadoPor) {
        this.editadoPor = editadoPor;
    }

    public Date getEditado() {
        return editado;
    }

    public void setEditado(Date editado) {
        this.editado = editado;
    }

    public Direccion getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(Direccion direccionCliente) {
        this.direccionCliente = direccionCliente;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Boolean getAnulado() {
        return anulado;
    }

    public void setAnulado(Boolean anulado) {
        this.anulado = anulado;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.id);
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
        final ContactoCliente other = (ContactoCliente) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    

}
