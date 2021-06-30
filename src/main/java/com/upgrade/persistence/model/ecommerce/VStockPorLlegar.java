/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.ecommerce;

import java.util.Date;

/**
 *
 * @author Diego Javier Quispe
 */
public class VStockPorLlegar {
    public Date fecha_llegada;
    public Integer cantidad_por_llegar;
    
    
    public Date getFecha_llegada() {
        return fecha_llegada;
    }
    public void setFecha_llegada(Date fecha_llegada) {
        this.fecha_llegada = fecha_llegada;
    }
    
    public Integer getCantidad_por_llegar() {
        return cantidad_por_llegar;
    }
    public void setCantidad_por_llegar(Integer cantidad_por_llegar) {
        this.cantidad_por_llegar = cantidad_por_llegar;
    }
}
