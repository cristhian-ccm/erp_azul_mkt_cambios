/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.ecommerce;

import java.util.Date;

/**
 *
 * @author Luis Aleman
 */
public class EstadoOrdenVentaModel {
    
    public Date fecha_actualizacion;
    public String estado;
    
    public Date getFecha_actualizacion() {
        return fecha_actualizacion;
    }
    public void setFecha_actualizacion(Date fecha_actualizacion) {
        this.fecha_actualizacion = fecha_actualizacion;
    }
    
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado_input) {
        this.estado = estado_input;
    }
    
}
