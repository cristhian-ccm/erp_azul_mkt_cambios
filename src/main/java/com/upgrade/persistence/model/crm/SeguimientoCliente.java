/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.crm;

import com.upgrade.persistence.model.tcros.Direccion;
import com.upgrade.persistence.model.tcros.Persona;
import com.upgrade.persistence.model.unidad_negocio.UnidadNegocio;
import ts.com.service.util.db.client.FieldDB;
import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Upgrade
 */
@TableDB(name = "crm.seguimiento_cliente", sequence = "crm.seguimiento_cliente_id_seq")
public class SeguimientoCliente implements Serializable{

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
    public Direccion direccion;

    @FieldDB(value = "hora_inicial")
    public Date horaInicial;

    @FieldDB(value = "hora_final")
    public Date horaFinal;

    @FieldDB(value = "telefono")
    public String telefono;

    @FieldDB(value = "correo")
    public String correo;

    @FieldDB(value = "lugar")
    public String lugar;

    @FieldDB(value = "observacion")
    public String observacion;

    @FieldDB(value = "tipo")
    public Character tipo;

    @FieldDB(value = "anulado")
    public Boolean anulado;

    @FieldDB(value = "seguimiento")
    public String seguimiento;
    
    @FieldDB(value = "unidad_negocio_id")
    public UnidadNegocio UniddNegocio;

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

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Date getHoraInicial() {
        return horaInicial;
    }

    public void setHoraInicial(Date horaInicial) {
        this.horaInicial = horaInicial;
    }

    public Date getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(Date horaFinal) {
        this.horaFinal = horaFinal;
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

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Character getTipo() {
        return tipo;
    }

    public void setTipo(Character tipo) {
        this.tipo = tipo;
    }

    public Boolean getAnulado() {
        return anulado;
    }

    public void setAnulado(Boolean anulado) {
        this.anulado = anulado;
    }

    public String getSeguimiento() {
        return seguimiento;
    }

    public void setSeguimiento(String seguimiento) {
        this.seguimiento = seguimiento;
    }

    public UnidadNegocio getUniddNegocio() {
        return UniddNegocio;
    }

    public void setUniddNegocio(UnidadNegocio UniddNegocio) {
        this.UniddNegocio = UniddNegocio;
    }
    
    



    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + Objects.hashCode(this.id);
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
        final SeguimientoCliente other = (SeguimientoCliente) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    

   

}
