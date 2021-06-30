/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.tcros;

import ts.com.service.util.db.client.FieldDB;
import ts.com.service.util.db.client.TableDB;
import com.upgrade.persistence.model.DocumentoIdentidad;
import com.upgrade.persistence.model.ecommerce.UsuarioWeb;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Evander
 */
@TableDB(name	="tcros.personas", sequence="tcros.personas_id_seq")
public class Persona implements Serializable{
    
    @FieldDB(value="creado_por")
    public Persona creadoPor;
    
    @FieldDB(value="editado_por")
    public Persona editado_por;
    
    @FieldDB(value="editado")
    public Date editado;
    
    @FieldDB(value="id")
    public Integer id;
    
    @FieldDB(value="inactivo")
    public Boolean inactivo;
    
    @FieldDB(value="nombre")
    public String nombre;
    
    @FieldDB(value="identificador")
    public String identificador;
    
    @FieldDB(value="documento_identidad_id")
    public DocumentoIdentidad documentoIdentidad;
    
    @FieldDB(value="tratamiento_id")
    public Tratamiento tratamiento;

    @FieldDB(value="brevette")
    public String brevette;
    
    @FieldDB(value="agente_retencion")
    public Boolean agenteRetencion;
    
    @FieldDB(value = "usu_web_id")
    public UsuarioWeb usuario_web;
    
    public String cargo;
    
    public Persona empresa;
    
    public String telefono;
    
    public String email;

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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public Tratamiento getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(Tratamiento tratamiento) {
        this.tratamiento = tratamiento;
    }

    public Persona getEditado_por() {
        return editado_por;
    }

    public void setEditado_por(Persona editado_por) {
        this.editado_por = editado_por;
    }

    public Date getEditado() {
        return editado;
    }

    public void setEditado(Date editado) {
        this.editado = editado;
    }

    public DocumentoIdentidad getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setDocumentoIdentidad(DocumentoIdentidad documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    public String getBrevette() {
        return brevette;
    }

    public void setBrevette(String brevette) {
        this.brevette = brevette;
    }

    public Boolean getAgenteRetencion() {
        return agenteRetencion;
    }

    public void setAgenteRetencion(Boolean agenteRetencion) {
        this.agenteRetencion = agenteRetencion;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Persona getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Persona empresa) {
        this.empresa = empresa;
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
    
    public UsuarioWeb getUsuario_web() {
        return usuario_web;
    }

    public void setUsuario_web(UsuarioWeb usuario_web) {
        this.usuario_web = usuario_web;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Persona other = (Persona) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    

    
  /*  @Override
    public String toString() {
        return nombre;
    }*/

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
