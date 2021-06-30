/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model;

import com.upgrade.persistence.model.extcs.Almacen;
import ts.com.service.util.db.client.FieldDB;
import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Evander
 */
@TableDB(name	="public.numeracion_almacenes", sequence="public.numeracion_almacenes_id_seq")
public class NumeracionAlmacen implements Serializable {
    
    @FieldDB(value = "id")
    public Integer id;
    
    @FieldDB(value = "inactivo")
    public Boolean inactivo;
    
    @FieldDB(value = "almacen_id")
    public Almacen almacen;
    
    @FieldDB(value = "documento_tipo_id")
    public DocumentoTipo documentoPagoTipo;
    
    @FieldDB(value = "serie")
    public Integer serie;
    
    @FieldDB(value = "inicio")
    public Integer inicio;
    
    @FieldDB(value = "final")
    public Integer fin;
    
    @FieldDB(value = "actual")
    public Integer actual;
    
    @FieldDB(value = "cantidad_por_talonario")
    public Integer cantidadPorTalonario;
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.id);
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
        final NumeracionAlmacen other = (NumeracionAlmacen) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
    	return serie+"";
        //return String.format("%03d", serie);
        
    }
    
    
    
}
