/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.extcs;

import com.upgrade.persistence.model.ecommerce.LineaEcommerce;
import com.upgrade.persistence.model.tcros.Persona;
import ts.com.service.util.db.client.FieldDB;
import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author Evander
 */
@TableDB(name	="extcs.productos", sequence="extcs.productos_id_seq")
public class Producto implements Serializable {

    @FieldDB(value = "creado_por")
    public Persona creadoPor;
    
    @FieldDB(value = "editado_por")
    public Persona editadoPor;
    
    @FieldDB(value = "id")
    public Integer id;//public int id 0
    
    @FieldDB(value = "inactivo")
    public Boolean inactivo;// false
    
    @FieldDB(value = "codigo")
    public String codigo;
    
    @FieldDB(value = "nombre")
    public String nombre;
    
    @FieldDB(value = "descripcion")
    public String descripcion;
    
    @FieldDB(value = "regalo")
    public Boolean regalo;//si un producto puede regalarse o no
    
    @FieldDB(value = "producto_tipo_id")
    public ProductoTipo productoTipo;// que tipo de producto es
    
    @FieldDB(value = "unidad_id")
    public Unidad unidad;
    
    @FieldDB(value = "marca_id")
    public Marca marca;
    
    @FieldDB(value = "linea_id")
    public Linea linea;
    
    @FieldDB(value = "modelo")
    public String modelo;
    
    @FieldDB(value = "servicio")
    public Boolean servicio;
    
    @FieldDB(value = "peso")
    public BigDecimal peso;
    
    @FieldDB(value = "divisible")
    public Boolean divisible;
    
    @FieldDB(value = "divisible_unidad_id")
    public Integer divisibleUnidadId;
    
    @FieldDB(value = "divisible_cantidad")
    public BigDecimal divisibleCantidad;
    
    @FieldDB(value = "producto_origen_id")
    public Producto productoOrigen;
    
    @FieldDB(value = "rotativo")
    public Boolean rotativo;
    
    @FieldDB(value = "cod_sunat")
    public String cod_sunat;
    
    @FieldDB(value = "ecommerce")
    public Boolean ecommerce;
    
    @FieldDB(value = "ecommerce_descrip")
    public String ecommerce_descrip;
    
    @FieldDB(value = "ecommerce_nombre")
    public String ecommerce_nombre;
    
    @FieldDB(value = "ecom_img1_nombre")
    public String ecom_img1_nombre;
    
    @FieldDB(value = "ecom_img2_nombre")
    public String ecom_img2_nombre;
    
    @FieldDB(value = "ecom_img3_nombre")
    public String ecom_img3_nombre;
    
    @FieldDB(value = "ecom_precio")
    public BigDecimal ecom_precio;
    
    @FieldDB(value = "ecom_limite")
    public Integer ecom_limite;
    
    @FieldDB(value = "stock_ecom")
    public Integer stock_ecom;
    
    @FieldDB(value = "linea_ecom_id")
    public LineaEcommerce linea_ecom;
    
    @FieldDB(value = "promocion")
    public Boolean promocion;
    
    @FieldDB(value = "nuevo")
    public Boolean nuevo;
    
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

    public Boolean getInactivo() {
        return inactivo;
    }

    public void setInactivo(Boolean inactivo) {
        this.inactivo = inactivo;
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

    public Boolean getRegalo() {
        return regalo;
    }

    public void setRegalo(Boolean regalo) {
        this.regalo = regalo;
    }

    public ProductoTipo getProductoTipo() {
        return productoTipo;
    }

    public void setProductoTipo(ProductoTipo productoTipo) {
        this.productoTipo = productoTipo;
    }

    public Unidad getUnidad() {
        return unidad;
    }

    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
    
    public String getMarca_nombre() {
        return marca.getNombre();
    }
    
    public Linea getLinea() {
        return linea;
    }
    
    public String getLinea_nombre() {
        return linea.getNombre();
    }

    public void setLinea(Linea linea) {
        this.linea = linea;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Boolean getServicio() {
        return servicio;
    }

    public void setServicio(Boolean servicio) {
        this.servicio = servicio;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public Boolean getDivisible() {
        return divisible;
    }

    public void setDivisible(Boolean divisible) {
        this.divisible = divisible;
    }

    public Integer getDivisibleUnidadId() {
        return divisibleUnidadId;
    }

    public void setDivisibleUnidadId(Integer divisibleUnidadId) {
        this.divisibleUnidadId = divisibleUnidadId;
    }

    public BigDecimal getDivisibleCantidad() {
        return divisibleCantidad;
    }

    public void setDivisibleCantidad(BigDecimal divisibleCantidad) {
        this.divisibleCantidad = divisibleCantidad;
    }

    public Producto getProductoOrigen() {
        return productoOrigen;
    }

    public void setProductoOrigen(Producto productoOrigen) {
        this.productoOrigen = productoOrigen;
    }

    public Boolean getRotativo() {
        return rotativo;
    }

    public void setRotativo(Boolean rotativo) {
        this.rotativo = rotativo;
    }
    
     public String getCod_sunat() {
        return cod_sunat;
    }

    public void setCod_sunat(String cod_sunat) {
        this.cod_sunat = cod_sunat;
    }
    
    public Boolean getEcommerce() {
        return ecommerce;
    }

    public void setEcommerce(Boolean ecommerce) {
        this.ecommerce = ecommerce;
    }
    
    public String getEcommerce_descrip() {
        return ecommerce_descrip;
    }

    public void setEcommerce_descrip(String ecommerce_descrip) {
        this.ecommerce_descrip = ecommerce_descrip;
    }
    
    public String getEcommerce_nombre() {
        return ecommerce_nombre;
    }

    public void setEcommerce_nombre(String ecommerce_nombre) {
        this.ecommerce_nombre = ecommerce_nombre;
    }
    
    public String getEcom_img1_nombre() {
        return ecom_img1_nombre;
    }

    public void setEcom_img1_nombre(String ecom_img1_nombre) {
        this.ecom_img1_nombre = ecom_img1_nombre;
    }
    
    public String getEcom_img2_nombre() {
        return ecom_img2_nombre;
    }

    public void setEcom_img2_nombre(String ecom_img2_nombre) {
        this.ecom_img2_nombre = ecom_img2_nombre;
    }
    
    public String getEcom_img3_nombre() {
        return ecom_img3_nombre;
    }

    public void setEcom_img3_nombre(String ecom_img3_nombre) {
        this.ecom_img3_nombre = ecom_img3_nombre;
    }
    
    public BigDecimal getEcom_precio() {
        return ecom_precio;
    }

    public void setEcom_precio(BigDecimal ecom_precio) {
        this.ecom_precio = ecom_precio;
    }
    
    public Integer getEcom_limite() {
        return ecom_limite;
    }
    public void setEcom_limite(Integer ecom_limite) {
        this.ecom_limite = ecom_limite;
    }
    
    public Integer getStock_ecom() {
        return stock_ecom;
    }
    public void setStock_ecom(Integer stock_ecom) {
        this.stock_ecom = stock_ecom;
    }
    
    public LineaEcommerce getLinea_ecom() {
        return linea_ecom;
    }
    public void setLinea_ecom(LineaEcommerce linea_ecom) {
        this.linea_ecom = linea_ecom;
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
    
    
    public Boolean hasPromo(){
        if (this.ecom_precio != null){
            return Boolean.TRUE;
        }
        else {
            return Boolean.FALSE;
        }
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.id);
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
        final Producto other = (Producto) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
    @Override
    public String toString() {
        return nombre;
    }
    
}
