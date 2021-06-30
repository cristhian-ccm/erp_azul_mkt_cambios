package com.upgrade.persistence.model.entrenamiento;

import com.upgrade.persistence.model.tcros.Persona;
import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;

@TableDB(name="entrenamiento.participante_entrenamiento_bloque",sequence="entrenamiento.participante_entrenamiento_bloque_id_seq")
public class ParticipanteEntrenamientoBloque implements Serializable {
	
	public ParticipanteEntrenamientoBloque() {
		// TODO Auto-generated constructor stub
	}
	
	public Integer id;
	public Persona participante;
	public EntrenamientoBloque entrenamientoBloque;
	
}