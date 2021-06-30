/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.cmrlz;

import com.upgrade.persistence.model.DocumentoTipo;
import com.upgrade.persistence.model.tcros.Persona;
import ts.com.service.util.db.client.FieldDB;
import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author darko
 */
@TableDB(name = "cmrlz.comunicacion_baja", sequence = "cmrlz.comunicacion_baja_id_seq")
public class ComunicacionBaja implements Serializable {

    @FieldDB(value = "creado_por")
    public Persona creadoPor;

    @FieldDB(value = "editado")
    public Date editado;

    @FieldDB(value = "creado")
    public Date creado;

    @FieldDB(value = "editado_por")
    public Persona editadoPor;
   
    @FieldDB(value = "id")
    public Integer id;

    @FieldDB(value = "numero")
    public Integer numero;

    @FieldDB(value = "anulada")
    public Boolean anulada;

    @FieldDB(value = "fecha_generacion")
    public Date fechaGeneracion;

    @FieldDB(value = "fecha_comunicacion")
    public Date fechaComunicacion;

    @FieldDB(value = "documento_tipo_id")
    public DocumentoTipo documentoTipo;

    @FieldDB(value = "venta_id")
    public VentaCab venta;

    @FieldDB(value = "num_doc_baja")
    public String numDocBaja;

    @FieldDB(value = "des_motivo_baja")
    public String desMotivoBaja;

    @Override
    public int hashCode() {
        int hash = 7;
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
        final ComunicacionBaja other = (ComunicacionBaja) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    

}
