/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.fnnzs;

import ts.com.service.util.db.client.FieldDB;
import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author USER
 */
@TableDB(name="fnnzs.recibos_det_tipos", sequence="fnnzs.recibos_det_tipos_id_seq")
public class RecibosDetTipos  implements Serializable{
    @FieldDB(value = "id")
    public Integer id;
    
    @FieldDB(value = "nombre")
    public String nombre;
    
    @FieldDB(value = "ingreso")
    public Boolean ingreso;
    
   @FieldDB(value = "predefinido")
    public Boolean predefinido;
   
   @FieldDB(value = "caja")
    public Boolean caja;
   
   @FieldDB(value = "banco")
    public Boolean banco;

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

    public Boolean getIngreso() {
        return ingreso;
    }

    public void setIngreso(Boolean ingreso) {
        this.ingreso = ingreso;
    }

    public Boolean getPredefinido() {
        return predefinido;
    }

    public void setPredefinido(Boolean predefinido) {
        this.predefinido = predefinido;
    }

    public Boolean getCaja() {
        return caja;
    }

    public void setCaja(Boolean caja) {
        this.caja = caja;
    }

    public Boolean getBanco() {
        return banco;
    }

    public void setBanco(Boolean banco) {
        this.banco = banco;
    }

    public RecibosDetTipos() {
        //super.tableName = "fnnzs._det_tipos";
        //super.sequenceName = "fnnz._det_tipos_id_seq";
        
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
        final RecibosDetTipos other = (RecibosDetTipos) obj;
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
