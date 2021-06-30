/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.tcros;

import com.upgrade.persistence.model.emprs.Empresa;
import ts.com.service.util.db.client.FieldDB;
import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author evander
 */
@TableDB(name	="tcros.personas_personas_tipo", sequence="tcros.personas_personas_tipo_id_seq")
public class PersonaPersonaTipo implements Serializable{
    
    @FieldDB(value = "id")
    public Integer id;
    
    @FieldDB(value = "persona_id")
    public Persona persona;
    
    @FieldDB(value = "persona_tipo_id")
    public PersonaTipo personaTipo;
    
    @FieldDB(value = "inactivo")
    public Boolean inactivo;
    
    @FieldDB(value = "empresa_id")
    public Empresa empresa;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public PersonaTipo getPersonaTipo() {
        return personaTipo;
    }

    public void setPersonaTipo(PersonaTipo personaTipo) {
        this.personaTipo = personaTipo;
    }

    public Boolean getInactivo() {
        return inactivo;
    }

    public void setInactivo(Boolean inactivo) {
        this.inactivo = inactivo;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final PersonaPersonaTipo other = (PersonaPersonaTipo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    

}
