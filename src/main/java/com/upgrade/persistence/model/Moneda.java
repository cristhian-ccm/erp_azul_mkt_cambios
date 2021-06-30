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
@TableDB(name = "public.monedas",sequence = "public.monedas_id_seq")
public class Moneda implements Serializable {

    @FieldDB(value = "id")
    public Integer id;

    @FieldDB(value = "inactivo")
    public Boolean inactivo;

    @FieldDB(value = "nombre")
    public String nombre;

    @FieldDB(value = "simbolo")
    public String simbolo;

    @FieldDB(value = "nacional")
    public Boolean nacional;

    @FieldDB(value = "iso4217")
    public String iso4217;

    @FieldDB(value = "inicial")
    public String inicial;

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

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public Boolean getNacional() {
        return nacional;
    }

    public void setNacional(Boolean nacional) {
        this.nacional = nacional;
    }

    public String getIso4217() {
        return iso4217;
    }

    public void setIso4217(String iso4217) {
        this.iso4217 = iso4217;
    }

    public String getInicial() {
        return inicial;
    }

    public void setInicial(String inicial) {
        this.inicial = inicial;
    }
    
    

    public Moneda() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.id);
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
        final Moneda other = (Moneda) obj;
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
