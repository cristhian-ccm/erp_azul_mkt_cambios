/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.soptc;

import com.upgrade.persistence.model.extcs.Almacen;
import com.upgrade.persistence.model.extcs.Articulo;
import com.upgrade.persistence.model.tcros.Persona;
import ts.com.service.util.db.client.FieldDB;
import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author USER
 */
@TableDB(name = "soptc.garantias",sequence = "soptc.garantias_id_seq")
public class Garantia implements Serializable{
     public Garantia() {
    }
    @FieldDB(value = "id")
    public Integer id;
    
    @FieldDB(value = "cliente_id")
    public Persona cliente;
    
    @FieldDB(value = "encargado_id")
    public Persona encargado;
    
    @FieldDB(value = "proveedor_id")
    public Persona proveedor;
    
    @FieldDB(value = "articulo_id")
    public Articulo articulo;
       
    @FieldDB(value = "detalles")
    public String detalles;
    
    @FieldDB(value = "fecha_apertura")
    public Date fechaApertura;
    
    @FieldDB(value = "fecha_envio")
    public Date fechaEnvio;
    
    @FieldDB(value = "fecha_retorno")
    public Date fechaRetorno;
    
    @FieldDB(value = "fecha_entrega")
    public Date fechaEntrega;
    
    @FieldDB(value = "telefono")
    public String telefono;
       
    @FieldDB(value = "email")
    public String email;
    
    @FieldDB(value = "password_equipo")
    public String passwordEquipo;
    
    @FieldDB(value = "password_bios")
    public String passwordBios;
    
    @FieldDB(value = "estado")
    public String estado;
    
    @FieldDB(value = "detalles_retorno")
    public String detallesRetorno;
    
    @FieldDB(value = "detalles_entrega_cliente")
    public String detallesEntregaCliente;
    
    @FieldDB(value = "numero_recibo")
    public String numeroRecibo;

    @FieldDB(value = "encargado_envio")
    public Persona encargadoEnvio;
    
    @FieldDB(value = "encargado_retorno")
    public Persona encargadoRetorno;
    
    @FieldDB(value = "encargado_entrega_cliente")
    public Persona encargadoEntregaCliente;
    
    @FieldDB(value = "id_almacen_garantia")
    public Almacen idAlmacenGarantia;
    
    @FieldDB(value = "articulos_dejados")
    public String articulosDejados;
    
    @FieldDB(value = "tiene_nota_credito")
    public Boolean tieneNotaCredito;
    
    @FieldDB(value = "notacredito")
    public String notaCredito;
    
    @FieldDB(value = "num_parte")
    public String numerParte;
    
    @FieldDB(value = "articulo_id_cambio")
    public Articulo articuloCambio;
    
    @FieldDB(value = "pendiente_nota_credito")
    public Boolean pendienteNotaCredito;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Persona getCliente() {
        return cliente;
    }

    public void setCliente(Persona cliente) {
        this.cliente = cliente;
    }

    public Persona getEncargado() {
        return encargado;
    }

    public void setEncargado(Persona encargado) {
        this.encargado = encargado;
    }

    public Persona getProveedor() {
        return proveedor;
    }

    public void setProveedor(Persona proveedor) {
        this.proveedor = proveedor;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public Date getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public Date getFechaRetorno() {
        return fechaRetorno;
    }

    public void setFechaRetorno(Date fechaRetorno) {
        this.fechaRetorno = fechaRetorno;
    }    

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
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

    public String getPasswordEquipo() {
        return passwordEquipo;
    }

    public void setPasswordEquipo(String passwordEquipo) {
        this.passwordEquipo = passwordEquipo;
    }

    public String getPasswordBios() {
        return passwordBios;
    }

    public void setPasswordBios(String passwordBios) {
        this.passwordBios = passwordBios;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDetallesRetorno() {
        return detallesRetorno;
    }

    public void setDetallesRetorno(String detallesRetorno) {
        this.detallesRetorno = detallesRetorno;
    }

    public String getDetallesEntregaCliente() {
        return detallesEntregaCliente;
    }

    public void setDetallesEntregaCliente(String detallesEntregaCliente) {
        this.detallesEntregaCliente = detallesEntregaCliente;
    }
    
    public String getNumeroRecibo() {
        return numeroRecibo;
    }

    public void setNumeroRecibo(String numeroRecibo) {
        this.numeroRecibo = numeroRecibo;
    }

    public Persona getEncargadoEnvio() {
        return encargadoEnvio;
    }

    public void setEncargadoEnvio(Persona encargadoEnvio) {
        this.encargadoEnvio = encargadoEnvio;
    }

    public Persona getEncargadoRetorno() {
        return encargadoRetorno;
    }

    public void setEncargadoRetorno(Persona encargadoRetorno) {
        this.encargadoRetorno = encargadoRetorno;
    }

    public Persona getEncargadoEntregaCliente() {
        return encargadoEntregaCliente;
    }

    public void setEncargadoEntregaCliente(Persona encargadoEntregaCliente) {
        this.encargadoEntregaCliente = encargadoEntregaCliente;
    }

    public Almacen getIdAlmacenGarantia() {
        return idAlmacenGarantia;
    }

    public void setIdAlmacenGarantia(Almacen idAlmacenGarantia) {
        this.idAlmacenGarantia = idAlmacenGarantia;
    }

    public String getArticulosDejados() {
        return articulosDejados;
    }

    public void setArticulosDejados(String articulosDejados) {
        this.articulosDejados = articulosDejados;
    }

    public Boolean getTieneNotaCredito() {
        return tieneNotaCredito;
    }

    public void setTieneNotaCredito(Boolean tieneNotaCredito) {
        this.tieneNotaCredito = tieneNotaCredito;
    }

    public String getNotaCredito() {
        return notaCredito;
    }

    public void setNotaCredito(String notaCredito) {
        this.notaCredito = notaCredito;
    }

    public Articulo getArticuloCambio() {
        return articuloCambio;
    }

    public void setArticuloCambio(Articulo articuloCambio) {
        this.articuloCambio = articuloCambio;
    }

    public Boolean getPendienteNotaCredito() {
        return pendienteNotaCredito;
    }

    public void setPendienteNotaCredito(Boolean pendienteNotaCredito) {
        this.pendienteNotaCredito = pendienteNotaCredito;
    }

    public String getNumerParte() {
        return numerParte;
    }

    public void setNumerParte(String numerParte) {
        this.numerParte = numerParte;
    }
    

    
    @Override
    public int hashCode() {
        int hash = 5;
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
        final Garantia other = (Garantia) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
      
}
