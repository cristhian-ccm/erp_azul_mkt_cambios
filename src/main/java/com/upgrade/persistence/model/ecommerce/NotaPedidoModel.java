/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.ecommerce;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Luis Aleman
 */
public class NotaPedidoModel {
    
    public Integer nota_pedido_id;
    public Integer num_orden;
    public Date fecha_ingreso;
    public Date fecha_entrega;
    public String estado_final;
    public String tipo_entrega;
    public BigDecimal totalVenta;
    public Cupones cupon;
    
    public Integer getNota_pedido_id() {
        return nota_pedido_id;
    }
    public void setNota_pedido_id(Integer nota_pedido_id) {
        this.nota_pedido_id = nota_pedido_id;
    }
    
    public Integer getNum_orden() {
        return num_orden;
    }
    public void setNum_orden(Integer num_orden) {
        this.num_orden = num_orden;
    }
    
    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }
    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }
    
    public Date getFecha_entrega() {
        return fecha_entrega;
    }
    public void setFecha_entrega(Date fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }
    
    public String getTipo_entrega() {
        return tipo_entrega;
    }
    public void setTipo_entrega(String tipo_entrega) {
        this.tipo_entrega = tipo_entrega;
    }
    
    public String getEstado() {
        return estado_final;
    }
    public void setEstado(String estado_input) {
        String estado_convert = estado_input;
        switch (estado_convert) {
          case "P":
            this.estado_final = "Pedido";
            break;
          case "L":
            this.estado_final = "En Almacén";
            break;
          case "D":
            this.estado_final = "Despachado";
            break;
          case "E":
            this.estado_final = "Entregado";
            break;
          case "A":
            this.estado_final = "Anulado";
            break;
          default:
            this.estado_final = "";
            break;  
        }
    }
    
    public BigDecimal getTotalVenta() {
        return totalVenta;
    }
    public void setTotalVenta(BigDecimal totalVenta) {
        this.totalVenta = totalVenta;
    }
    
    public Cupones getCupon() {
        return cupon;
    }

    public void setCupon(Cupones cupon) {
        this.cupon = cupon;
    }
    
}
