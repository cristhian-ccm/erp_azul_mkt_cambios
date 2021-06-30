/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.planestrategico;

import ts.com.service.util.db.client.FieldDB;
import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author JUAN CARLOS
 */
@TableDB(name="plan_estrategico.cuota_anual", sequence="plan_estrategico.cuota_anual_id_seq")
public class CuotaAnual implements Serializable{
    @FieldDB(value = "id")
    public Integer id;
    
    @FieldDB(value = "anio")
    public Integer anio;
    
    @FieldDB(value = "monto")
    public BigDecimal monto;
    
    @FieldDB(value = "estado")
    public Boolean estado;  

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
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
        final CuotaAnual other = (CuotaAnual) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }    
    
}
