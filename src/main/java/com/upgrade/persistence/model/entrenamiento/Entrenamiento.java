package com.upgrade.persistence.model.entrenamiento;

import com.upgrade.persistence.model.tcros.Persona;
import com.upgrade.persistence.model.usros.Usuario;
import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;

@TableDB(name="entrenamiento.entrenamiento",sequence="entrenamiento.entrenamiento_id_seq")
public class Entrenamiento implements Serializable {

	public Integer id;
	public Usuario usuarioCreador;
	public Character estado;
	public Persona empresa;
	public String tema;
	public String descripcion;

	public Entrenamiento() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return tema;
	}

}
