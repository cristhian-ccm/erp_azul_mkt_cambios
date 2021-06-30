package com.upgrade.persistence.model.encuesta;

import com.upgrade.persistence.model.tcros.Persona;
import com.upgrade.persistence.model.usros.Usuario;
import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
*
* @author evanl
*/
@TableDB(name="encuesta.encuesta", sequence="encuesta.encuesta_id_seq")
public class Encuesta implements Serializable {
   
   public Integer id;
   public Usuario usuarioCreador;
   public Character estado;
   public Integer numero;
   public Date fecha;
   public Persona cliente;
   public Boolean atencionATiempo;
   public Boolean calificacionBuena;
   public Boolean recomendariaAOtros;
   public String observaciones;
   
   public Encuesta() {
	// TODO Auto-generated constructor stub
}

   @Override
   public int hashCode() {
       int hash = 3;
       hash = 79 * hash + Objects.hashCode(this.id);
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
       final Encuesta other = (Encuesta) obj;
       if (!Objects.equals(this.id, other.id)) {
           return false;
       }
       return true;
   }
   
   
   
}
