package com.upgrade.persistence.model.ecommerce;

import ts.com.service.util.db.client.FieldDB;
import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


@TableDB(name="ecommerce.programBanner")
public class ProgramOB implements Serializable {


    @FieldDB(value = "id")
    public Integer id;

    @FieldDB(value = "creado_por")
    public String  creado_por;

    @FieldDB(value = "creacion")
    public Date creacion;

    @FieldDB(value = "activo")
    public Boolean activo;


    @FieldDB(value = "fecha_ini")
    public Date fecha_ini;

    @FieldDB(value = "fecha_fin")
    public Date fecha_fin;

    @FieldDB(value = "id_banner")
    public Integer id_banner;

    @FieldDB(value = "id_linea")
    public Integer id_linea;

    @FieldDB(value = "nom_linea")
    public String nom_linea;





 




    


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public String getcreado_por() {
        return creado_por;
    }

    public void setcreado_por(String creado_por) {
        this.creado_por = creado_por;
    }


    public Date getcreacion() {
        return creacion;
    }

    public void setcreacion(Date creacion) {
        this.creacion = creacion;
    }


    public Boolean getactivo() {
        return activo;
    }

    public void setactivo(Boolean activo) {
        this.activo = activo;
    }


    
    public Date getfecha_ini() {
        return fecha_ini;
    }

    public void setfecha_ini(Date fecha_ini) {
        this.fecha_ini = fecha_ini;
    }


    public Date getfecha_fin() {
        return fecha_fin;
    }

    public void setfecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }    


    public Integer getid_banner() {
        return id_banner;
    }

    public void setid_banner(Integer id_banner) {
        this.id_banner = id_banner;
    }


    public Integer getid_linea() {
        return id_linea;
    }

    public void setid_linea(Integer id_linea) {
        this.id_linea = id_linea;
    }


    public String getnom_linea() {
        return nom_linea;
    }

    public void setnom_linea(String nom_linea) {
        this.nom_linea = nom_linea;
    }

   














    @Override
    public int hashCode() {
        int hash = 5;
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
        final CatalogoPuntos other = (CatalogoPuntos) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }




    

   





















    
}
