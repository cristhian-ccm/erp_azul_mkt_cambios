/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.extcs;

import com.upgrade.persistence.model.Moneda;
import com.upgrade.persistence.model.emprs.Empresa;
import ts.com.service.util.db.client.FieldDB;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Evander
 */
public class ProductoPromocion implements Serializable {

    @FieldDB(value="id")
    public Integer id;
    
    @FieldDB(value="inactivo")
    public Boolean inactivo;
    
    @FieldDB(value="producto_id")
    public Producto producto;
    
    @FieldDB(value="empresa_id")
    public Empresa empresa;
    
    @FieldDB(value="moneda_id")
    public Moneda moneda;
    
    @FieldDB(value="promocion")
    public BigDecimal promocion;
    
    @FieldDB(value="producto_det_id")
    public ProductoDet productoDet;
    
    @FieldDB(value="almacen_id")
    public Almacen almacen;
    
    @FieldDB(value="fecha_inicio")
    public Date fechaInicio;
    
    @FieldDB(value="fecha_fin")
    public Date fechaFin;
    
    @FieldDB(value="aprobado")
    public Boolean aprobado;
    
    @FieldDB(value="aprobado_por")
    public Integer aprobadoPor;
    
    @FieldDB(value="regalo")
    public Boolean regalo;
            
    
    
    
    
    public ProductoPromocion() {
        //super.tableName = "extcs.productos_promocion";
        //super.sequenceName = "extcs.productos_promocion_id_seq";
        
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

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }

    public BigDecimal getPromocion() {
        return promocion;
    }

    public void setPromocion(BigDecimal promocion) {
        this.promocion = promocion;
    }

    public ProductoDet getProductoDet() {
        return productoDet;
    }

    public void setProductoDet(ProductoDet productoDet) {
        this.productoDet = productoDet;
    }

    public Almacen getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Boolean getAprobado() {
        return aprobado;
    }

    public void setAprobado(Boolean aprobado) {
        this.aprobado = aprobado;
    }

    public Integer getAprobadoPor() {
        return aprobadoPor;
    }

    public void setAprobadoPor(Integer aprobadoPor) {
        this.aprobadoPor = aprobadoPor;
    }

    public Boolean getRegalo() {
        return regalo;
    }

    public void setRegalo(Boolean regalo) {
        this.regalo = regalo;
    }
    
    
    
    
    
}
