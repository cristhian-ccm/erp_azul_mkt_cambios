/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.ecommerce;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author Luis Aleman
 */
public class PedidoEcommerce {
    //Campos
    public Integer pedido_ecom_id;
    public Integer numero;
    public String usuario_web;
    public Date fecha_creacion;
    public Date fecha_actual_proceso;
    public Date fecha_entrega;
    public String direccion_ecommerce;
    public String tipo_entrega;
    public String estado;
    public Boolean aprobada;
    public String tipo_pago;
    
    //--------------------------------------------------------------------------
    
    //Get's nd Set's
    public Integer getPedido_ecom_id() {
        return pedido_ecom_id;
    }
    public void setPedido_ecom_id(Integer pedido_ecom_id) {
        this.pedido_ecom_id = pedido_ecom_id;
    }
    
    public Integer getNumero() {
        return numero;
    }
    public void setNumero(Integer numero) {
        this.numero = numero;
    }
    
    public String getUsuario_web() {
        return usuario_web;
    }
    public void setUsuario_web(String usuario_web) {
        this.usuario_web = usuario_web;
    }
    
    public Date getFecha_creacion() {
        return fecha_creacion;
    }
    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }
    
    public Date getFecha_actual_proceso() {
        return fecha_actual_proceso;
    }
    public void setFecha_actual_proceso(Date fecha_actual_proceso) {
        this.fecha_actual_proceso = fecha_actual_proceso;
    }
    
    public Date getFecha_entrega() {
        return fecha_entrega;
    }
    public void setFecha_entrega(Date fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }
    
    public String getDireccion_Ecommerce() {
        return direccion_ecommerce;
    }
    public void setDireccion_Ecommerce(String direccion_ecommerce) {
        this.direccion_ecommerce = direccion_ecommerce;
    }
    
    public String getTipo_entrega() {
        return tipo_entrega;
    }
    public void setTipo_entrega(String tipo_entrega) {
        this.tipo_entrega = tipo_entrega;
    }
    
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public Boolean getAprobada() {
        return aprobada;
    }
    public void setAprobada(Boolean aprobada) {
        this.aprobada = aprobada;
    }
    
    public String getTipo_pago() {
        return tipo_pago;
    }
    public void setTipo_pago(String tipo_pago) {
        this.tipo_pago = tipo_pago;
    }
    
    //--------------------------------------------------------------------------
}
