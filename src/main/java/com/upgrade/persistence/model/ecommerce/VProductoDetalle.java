/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.ecommerce;

import ts.com.service.util.db.client.FieldDB;
import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;


@TableDB(name = "ecommerce.v_producto_detalle")
public class VProductoDetalle implements Serializable {

    @FieldDB(value = "search_field")
    public String search_field;

    public Integer id;
    
    @FieldDB(value = "codigo")
    public String codigo;
    
    @FieldDB(value = "nombre")
    public String nombre;
  
    @FieldDB(value = "descripcion")
    public String descripcion;

    @FieldDB(value = "linea_id")
    public Integer linea_id;

    @FieldDB(value = "linea")
    public String linea;

    @FieldDB(value = "marca_id")
    public Integer marca_id;

    @FieldDB(value = "marca")
    public String marca;

    @FieldDB(value = "iddet")
    public Integer iddet;

    @FieldDB(value = "costo")
    public BigDecimal costo;

    @FieldDB(value = "utilidad")
    public BigDecimal utilidad;

    @FieldDB(value = "img1")
    public String img1;

    @FieldDB(value = "img2")
    public String img2;

    @FieldDB(value = "img3")
    public String img3;

    @FieldDB(value = "simbolo")
    public String simbolo;

    @FieldDB(value = "pventa")
    public BigDecimal pventa;

    @FieldDB(value = "pventa_old")
    public BigDecimal pventa_old;

    @FieldDB(value = "stock")
    public Integer stock;

    @FieldDB(value = "cartcount")
    public Integer cartCount;

    @FieldDB(value = "stockprev")
    public Integer stockprev;

    @FieldDB(value = "stockreal")
    public Integer stockreal;

    @FieldDB(value = "limitcompra")
    public Integer limitcompra;

    @FieldDB(value = "fecha_llegada")
    public Date fecha_llegada;

    @FieldDB(value = "promocion")
    public Boolean promocion;

    @FieldDB(value = "nuevo")
    public Boolean nuevo;

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }

    public String getImg3() {
        return img3;
    }

    public void setImg3(String img3) {
        this.img3 = img3;
    }

    public BigDecimal getPventa_old() {
        return pventa_old;
    }

    public void setPventa_old(BigDecimal pventa_old) {
        this.pventa_old = pventa_old;
    }

    public Integer getCartCount() {
        return cartCount;
    }

    public void setCartCount(Integer cartCount) {
        this.cartCount = cartCount;
    }

    public BigDecimal getPventa() {
        return pventa;
    }

    public void setPventa(BigDecimal pventa) {
        this.pventa = pventa;
    }

    public Integer getMarca_id() {
        return marca_id;
    }

    public void setMarca_id(Integer marca_id) {
        this.marca_id = marca_id;
    }

    public Integer getLinea_id() {
        return linea_id;
    }

    public void setLinea_id(Integer linea_id) {
        this.linea_id = linea_id;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getIddet() {
        return iddet;
    }

    public void setIddet(Integer iddet) {
        this.iddet = iddet;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public BigDecimal getUtilidad() {
        return utilidad;
    }

    public void setUtilidad(BigDecimal utilidad) {
        this.utilidad = utilidad;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getSearch_field() {
        return search_field;
    }

    public void setSearch_field(String search_field) {
        this.search_field = search_field;
    }

    public Integer getStockprev() {
        return stockprev;
    }

    public void setStockprev(Integer stockprev) {
        this.stockprev = stockprev;
    }

    public Date getFecha_llegada() {
        return fecha_llegada;
    }

    public void setFecha_llegada(Date fecha_llegada) {
        this.fecha_llegada = fecha_llegada;
    }

    public Integer getStockreal() {
        return stockreal;
    }

    public void setStockreal(Integer stockreal) {
        this.stockreal = stockreal;
    }

    public Integer getLimitcompra() {
        return limitcompra;
    }

    public void setLimitcompra(Integer limitcompra) {
        this.limitcompra = limitcompra;
    }

    public Boolean getPromocion() {
        return promocion;
    }

    public void setPromocion(Boolean promocion) {
        this.promocion = promocion;
    }

    public Boolean getNuevo() {
        return nuevo;
    }

    public void setNuevo(Boolean nuevo) {
        this.nuevo = nuevo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final VProductoDetalle other = (VProductoDetalle) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    


}
