/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.ecommerce;

import com.upgrade.persistence.model.cmrlz.NotaPedidoCab;
import com.upgrade.persistence.model.extcs.Producto;
import com.upgrade.persistence.model.tcros.Persona;
import ts.com.service.util.db.client.FieldDB;
import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
/**
 *
 * @author Luis Aleman
 */
@TableDB(name="ecommerce.estados_orden_venta")
public class EstadosOrdenVenta implements Serializable{
    
    //Campos
    @FieldDB(value = "id")
    public Integer id;

    @FieldDB(value = "creado_por")
    public Integer creado_por;
    
    @FieldDB(value = "creacion")
    public Date creacion;
    
    @FieldDB(value = "fecha_registro")
    public Date fecha_registro;
    
    @FieldDB(value = "fecha_entrega")
    public Date fecha_entrega;
    
    @FieldDB(value = "dir_entrega_id")
    public DirEntrega dir_entrega;
    
    @FieldDB(value = "estado")
    public String estado;
    
    @FieldDB(value = "nota_pedido_id")
    public NotaPedidoCab nota_pedido;
    
    //Gets nd sets
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCreado_por() {
        return creado_por;
    }
    public void setCreado_por(Integer creado_por) {
        this.creado_por = creado_por;
    }

    public Date getCreacion() {
        return creacion;
    }
    public void setCreacion(Date creacion) {
        this.creacion = creacion;
    }
    
    public Date getFecha_registro() {
        return fecha_registro;
    }
    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }
    
    public Date getFecha_entrega() {
        return fecha_entrega;
    }
    public void setFecha_entrega(Date fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }
    
    public DirEntrega getDirEntrega() {
        return dir_entrega;
    }
    public void setDirEntrega(DirEntrega dir_entrega) {
        this.dir_entrega = dir_entrega;
    }
    
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public NotaPedidoCab getNota_pedido() {
        return nota_pedido;
    }
    public void setNota_pedido(NotaPedidoCab nota_pedido) {
        this.nota_pedido = nota_pedido;
    }
    
     @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EstadosOrdenVenta other = (EstadosOrdenVenta) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
}
