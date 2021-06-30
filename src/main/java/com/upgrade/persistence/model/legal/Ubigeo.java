/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.legal;

import ts.com.service.util.db.client.FieldDB;
import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author Evander
 */

@TableDB(name="legal.ubigeo", sequence= "legal.ubigeo_id_Seq")
public class Ubigeo implements Serializable{
    
    public Ubigeo() {
        //super.tableName = "legal.ubigeo";
        //super.sequenceName = "legal.ubigeo_id_seq";
    }

    @FieldDB(value = "id")
    public Integer id;
    
    @FieldDB(value = "codigo")
    public String codigo;
    
    @FieldDB(value = "coddpto")
    public String departamento;
    
    @FieldDB(value = "codprov")
    public String provincia;
    
    @FieldDB(value = "coddist")
    public String distrito;
    
    @FieldDB(value = "nombre")
    public String nombre;

    @FieldDB(value = "precio_delivery")
    public BigDecimal precio_delivery;

    @FieldDB(value = "activo_delivery")
    public Boolean activo_delivery;

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

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getPrecio_delivery() {
        return precio_delivery;
    }

    public void setPrecio_delivery(BigDecimal precio_delivery) {
        this.precio_delivery = precio_delivery;
    }

    public Boolean getActivo_delivery() {
        return activo_delivery;
    }

    public void setActivo_delivery(Boolean activo_delivery) {
        this.activo_delivery = activo_delivery;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.id);
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
        final Ubigeo other = (Ubigeo) obj;
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
