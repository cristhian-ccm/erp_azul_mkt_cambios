/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.planestrategico;

import com.upgrade.persistence.model.extcs.Almacen;
import ts.com.service.util.db.client.FieldDB;
import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author JUAN CARLOS
 */
@TableDB(name = "plan_estrategico.seg_venta", sequence = "plan_estrategico.seg_venta_id_seq")

public class SegmentoVenta implements Serializable {

    @FieldDB(value = "id")
    public Integer id;
    
    @FieldDB(value = "nombre")
    public String nombre;
    
    @FieldDB(value = "mes")
    public Integer mes;
    
    @FieldDB(value = "cuota_mensual")
    public BigDecimal cuotaMensual;
    
    @FieldDB(value = "cuota_anual")
    public CuotaAnual cuotaAnual;
    
    @FieldDB(value = "estado")
    public Boolean estado;
    
    @FieldDB(value = "almacen")
    public Almacen almacen;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public BigDecimal getCuotaMensual() {
        return cuotaMensual;
    }

    public void setCuotaMensual(BigDecimal cuotaMensual) {
        this.cuotaMensual = cuotaMensual;
    }

    public CuotaAnual getCuotaAnual() {
        return cuotaAnual;
    }   

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Almacen getAlmacen() {
        return almacen;
    }   
    
    
    @Override
    public String toString() {
        return nombre;
    }
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.id);
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
        final SegmentoVenta other = (SegmentoVenta) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}


