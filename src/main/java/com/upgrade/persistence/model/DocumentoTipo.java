/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model;

import ts.com.service.util.db.client.FieldDB;
import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Evander
 */
@TableDB(name = "public.documentos_tipo" , sequence = "public.documentos_tipo_id_seq" )
public class DocumentoTipo implements Serializable {

    public DocumentoTipo() {
        //super.tableName = "public.documentos_tipo";
        //super.sequenceName = "public.documentos_tipo_id_seq";
        
    }
    
    @FieldDB(value = "id")
    public Integer id;
    
    @FieldDB(value = "inactivo")
    public Boolean inactivo;
    
    @FieldDB(value = "nombre")
    public String nombre;
    
    @FieldDB(value = "nombre_corto")
    public String nombreCorto;
    
    @FieldDB(value = "ingreso")
    public Boolean ingreso;
    
    @FieldDB(value = "salida")
    public Boolean salida;
    
    @FieldDB(value = "afecto_impuesto")
    public Boolean afectoImpuesto;
    
    @FieldDB(value = "tipo_ose")
    public Integer tipoOse;

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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreCorto() {
        return nombreCorto;
    }

    public void setNombreCorto(String nombreCorto) {
        this.nombreCorto = nombreCorto;
    }

    public Boolean getIngreso() {
        return ingreso;
    }

    public void setIngreso(Boolean ingreso) {
        this.ingreso = ingreso;
    }

    public Boolean getSalida() {
        return salida;
    }

    public void setSalida(Boolean salida) {
        this.salida = salida;
    }

    public Boolean getAfectoImpuesto() {
        return afectoImpuesto;
    }

    public void setAfectoImpuesto(Boolean afectoImpuesto) {
        this.afectoImpuesto = afectoImpuesto;
    }

    public Integer getTipoOse() {
        return tipoOse;
    }

    public void setTipoOse(Integer tipoOse) {
        this.tipoOse = tipoOse;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + Objects.hashCode(this.id);
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
        final DocumentoTipo other = (DocumentoTipo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre.toUpperCase();
    }
    
    
    
    
    
}
