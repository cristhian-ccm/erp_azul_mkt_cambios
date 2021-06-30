package com.upgrade.persistence.model.entrenamiento;

import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;

@TableDB(name="entrenamiento.entrenamiento_bloque",sequence="entrenamiento.entrenamiento_bloque_id_seq")
public class EntrenamientoBloque implements Serializable {
	
	public EntrenamientoBloque() {
		// TODO Auto-generated constructor stub
	}
	
	public Integer id;
	public Entrenamiento entrenamiento;
	public Bloque bloque;
	public Integer inscritos;
	
	

}
