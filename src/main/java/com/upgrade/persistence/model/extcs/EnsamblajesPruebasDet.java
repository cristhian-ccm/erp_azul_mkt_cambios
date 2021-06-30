/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.extcs;

import ts.com.service.util.db.client.FieldDB;
import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author Evander
 */
@TableDB(name="extcs.ensamblajes_pruebas_det", sequence="extcs.ensamblajes_pruebas_det_id_seq")
public class EnsamblajesPruebasDet implements Serializable {

    public Integer id;
    
    @FieldDB(value="ensamblaje_prueba_id")
    public EnsamblajesPruebasCab ensamblajePrueba;
    
    @FieldDB(value = "estado")
    public Character estado;
    
    @FieldDB(value = "articulo_id")
    public Articulo articulo;
    
    @FieldDB(value = "cantidad")
    public BigDecimal cantidad;  
    
    public EnsamblajesPruebasDet() {
        //super.tableName = "extcs.ensamblajes_pruebas_det";
        //super.sequenceName = "extcs.ensamblajes_pruebas_det_id_seq";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EnsamblajesPruebasCab getEnsamblajePrueba() {
        return ensamblajePrueba;
    }

    public void setEnsamblajePrueba(EnsamblajesPruebasCab ensamblajePrueba) {
        this.ensamblajePrueba = ensamblajePrueba;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final EnsamblajesPruebasDet other = (EnsamblajesPruebasDet) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
