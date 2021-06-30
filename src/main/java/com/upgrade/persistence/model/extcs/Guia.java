/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.extcs;

import com.upgrade.persistence.model.tcros.Direccion;
import com.upgrade.persistence.model.tcros.Persona;
import com.upgrade.persistence.model.tcros.Vehiculo;
import ts.com.service.util.db.client.FieldDB;
import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Evander
 */
@TableDB(name="extcs.guias_cab", sequence = "extcs.guias_cab_id_seq")
public class Guia implements Serializable {

    @FieldDB(value = "creado_por")
    public Persona creadoPor;
    
    @FieldDB(value = "editado_por")
    public Persona editadoPor;
    
    @FieldDB(value = "id")
    public Integer id;
    
    @FieldDB(value = "anulada")
    public Boolean anulada;
    
    @FieldDB(value = "serie")
    public Integer serie;
    
    @FieldDB(value = "numero")
    public Integer numero;
    
    @FieldDB(value = "almacen_origen_id")
    public Almacen almacenOrigen;
    
    @FieldDB(value = "almacen_destino_id")
    public Almacen almacenDestino;
    
    @FieldDB(value = "direccion_cliente_id")
    public Direccion direccionCliente;
    
    @FieldDB(value = "fecha_emision")
    public Date fecha_emision;
    
    @FieldDB(value = "fecha_traslado")
    public Date fecha_traslado;
    
    @FieldDB(value = "motivo_traslado_id")
    public MotivoTraslado motivoTraslado;
    
    @FieldDB(value = "transportista_id")
    public Persona transportista;
    
    @FieldDB(value = "vehiculo_id")
    public Vehiculo vehiculo;
    
    @FieldDB(value = "chofer_id")
    public Persona chofer;
    
    @FieldDB(value = "recepcionada")
    public Boolean recepcionada;
    
    @FieldDB(value = "recepcionada_por")
    public Persona recepcionadaPor;
    
    @FieldDB(value = "observacion")
    public String observacion;

    public Persona getCreadoPor() {
        return creadoPor;
    }

    public void setCreadoPor(Persona creadoPor) {
        this.creadoPor = creadoPor;
    }

    public Persona getEditadoPor() {
        return editadoPor;
    }

    public void setEditadoPor(Persona editadoPor) {
        this.editadoPor = editadoPor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getAnulada() {
        return anulada;
    }

    public void setAnulada(Boolean anulada) {
        this.anulada = anulada;
    }

    public Integer getSerie() {
        return serie;
    }

    public void setSerie(Integer serie) {
        this.serie = serie;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Almacen getAlmacenOrigen() {
        return almacenOrigen;
    }

    public void setAlmacenOrigen(Almacen almacenOrigen) {
        this.almacenOrigen = almacenOrigen;
    }

    public Almacen getAlmacenDestino() {
        return almacenDestino;
    }

    public void setAlmacenDestino(Almacen almacenDestino) {
        this.almacenDestino = almacenDestino;
    }

    public Direccion getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(Direccion direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public Date getFecha_emision() {
        return fecha_emision;
    }

    public void setFecha_emision(Date fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    public Date getFecha_traslado() {
        return fecha_traslado;
    }

    public void setFecha_traslado(Date fecha_traslado) {
        this.fecha_traslado = fecha_traslado;
    }

    public MotivoTraslado getMotivoTraslado() {
        return motivoTraslado;
    }

    public void setMotivoTraslado(MotivoTraslado motivoTraslado) {
        this.motivoTraslado = motivoTraslado;
    }

    public Persona getTransportista() {
        return transportista;
    }

    public void setTransportista(Persona transportista) {
        this.transportista = transportista;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Persona getChofer() {
        return chofer;
    }

    public void setChofer(Persona chofer) {
        this.chofer = chofer;
    }

    public Boolean getRecepcionada() {
        return recepcionada;
    }

    public void setRecepcionada(Boolean recepcionada) {
        this.recepcionada = recepcionada;
    }

    public Persona getRecepcionadaPor() {
        return recepcionadaPor;
    }

    public void setRecepcionadaPor(Persona recepcionadaPor) {
        this.recepcionadaPor = recepcionadaPor;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    
    
    public Guia() {
        //super.tableName = "extcs.guias_cab";
        //super.sequenceName = "extcs.guias_cab_id_seq";
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final Guia other = (Guia) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
}
