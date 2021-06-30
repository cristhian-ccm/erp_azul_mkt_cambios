/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.ecommerce;

import java.math.BigDecimal;

/**
 *
 * @author Luis Aleman
 */
public class NotaPedidoDetModel {
    
    public String url_img;
    public String prod_nombre;
    public BigDecimal precio_unitario;
    public BigDecimal cantidad;
    public BigDecimal total;
    public String codigo;
    
    public String getUrl_img() {
        return url_img;
    }
    public void setUrl_img(String url_img) {
        this.url_img = url_img;
    }
    
    public String getProd_nombre() {
        return prod_nombre;
    }
    public void setProd_nombre(String prod_nombre) {
        this.prod_nombre = prod_nombre;
    }
    
    public BigDecimal getPrecio_unitario() {
        return precio_unitario;
    }
    public void setPrecio_unitario(BigDecimal precio_unitario) {
        this.precio_unitario = precio_unitario;
    }
    
    public BigDecimal getCantidad() {
        return cantidad;
    }
    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }
    
    public BigDecimal getTotal() {
        return total;
    }
    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
