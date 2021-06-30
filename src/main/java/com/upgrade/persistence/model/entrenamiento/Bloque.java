package com.upgrade.persistence.model.entrenamiento;

import com.upgrade.persistence.model.usros.Usuario;
import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;
import java.util.Date;

@TableDB(name="entrenamiento.bloque",sequence="entrenamiento.bloque_id_seq")
public class Bloque implements Serializable{
	
	public Integer id;
	public Usuario usuarioCreador;
	public Character estado;
	public Date inicio;
	public Date fin;
	public Boolean cerrado;
        
	
	
	public Bloque() {
		// TODO Auto-generated constructor stub
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bloque other = (Bloque) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
