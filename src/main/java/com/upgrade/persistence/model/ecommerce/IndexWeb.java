/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.ecommerce;

import com.upgrade.persistence.model.tcros.Persona;
import ts.com.service.util.db.client.FieldDB;
import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Luis Aleman
 */
//@TableDB(name	="ecommerce.index_web", sequence="ecommerce.index_web_id_seq")
@TableDB(name="ecommerce.index_web")
public class IndexWeb implements Serializable{
    //Campos
    @FieldDB(value = "id")
    public Integer id;
    
    @FieldDB(value = "creado_por")
    public Persona creadoPor;
    
    @FieldDB(value = "creacion")
    public Date creacion;
    
    //Head
    @FieldDB(value = "rutaimg_head")
    public String rutaimg_head;
    //--------------------------------------------------------------------------
    
    //Slider
    @FieldDB(value = "titulo_slider")
    public String titulo_slider;
    
    @FieldDB(value = "subtitulo_slider")
    public String subtitulo_slider;
    
    //Slider 1
    @FieldDB(value = "rutaimg1_slider")
    public String rutaimg1_slider;
    
    //Slider 2
    @FieldDB(value = "rutaimg2_slider")
    public String rutaimg2_slider;
    
    //Slider 3
    @FieldDB(value = "rutaimg3_slider")
    public String rutaimg3_slider;
    
    /*
    //Slider 4
    @FieldDB(value = "rutaimg4_slider")
    public String rutaimg4_slider;
    */
    //--------------------------------------------------------------------------
    
    //Linea 1
    @FieldDB(value = "titulo_linea1")
    public String titulo_linea1;
    
    @FieldDB(value = "subtitulo_linea1")
    public String subtitulo_linea1;
    
    @FieldDB(value = "rutaimg_linea1")
    public String rutaimg_linea1;
    //--------------------------------------------------------------------------
    
    //Linea 2
    @FieldDB(value = "titulo_linea2")
    public String titulo_linea2;
    
    @FieldDB(value = "subtitulo_linea2")
    public String subtitulo_linea2;
    
    @FieldDB(value = "rutaimg_linea2")
    public String rutaimg_linea2;
    //--------------------------------------------------------------------------
    
    //Linea 3
    @FieldDB(value = "titulo_linea3")
    public String titulo_linea3;
    
    @FieldDB(value = "subtitulo_linea3")
    public String subtitulo_linea3;
    
    @FieldDB(value = "rutaimg_linea3")
    public String rutaimg_linea3;
    //--------------------------------------------------------------------------
    /*
    //Linea 4
    @FieldDB(value = "titulo_linea4")
    public String titulo_linea4;
    
    @FieldDB(value = "subtitulo_linea4")
    public String subtitulo_linea4;
    
    @FieldDB(value = "rutaimg_linea4")
    public String rutaimg_linea4;
    //--------------------------------------------------------------------------
    
    //Linea 5
    @FieldDB(value = "titulo_linea5")
    public String titulo_linea5;
    
    @FieldDB(value = "subtitulo_linea5")
    public String subtitulo_linea5;
    
    @FieldDB(value = "rutaimg_linea5")
    public String rutaimg_linea5;
    //--------------------------------------------------------------------------
    
    //Linea 6
    @FieldDB(value = "titulo_linea6")
    public String titulo_linea6;
    
    @FieldDB(value = "subtitulo_linea6")
    public String subtitulo_linea6;
    
    @FieldDB(value = "rutaimg_linea6")
    public String rutaimg_linea6;
    */
    //--------------------------------------------------------------------------
    
    //Foot 1
    @FieldDB(value = "titulo_foot")
    public String titulo_foot;
    
    @FieldDB(value = "descrip_foot")
    public String descrip_foot;
    
    @FieldDB(value = "rutaimg_foot")
    public String rutaimg_foot;
    //--------------------------------------------------------------------------
    
    //Get's nd Set's
    //Basicos
    public Persona getCreadoPor() {
        return creadoPor;
    }
    public void setCreadoPor(Persona creadoPor) {
        this.creadoPor = creadoPor;
    }
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Date getCreacion() {
        return creacion;
    }
    public void setCreacion(Date creacion) {
        this.creacion = creacion;
    }
    //--------------------------------------------------------------------------
    
    //Head
    public String getRutaimg_head() {
        return rutaimg_head;
    }
    public void setRutaimg_head(String rutaimg_head) {
        this.rutaimg_head = rutaimg_head;
    }
    //--------------------------------------------------------------------------
    
    //Sliders
    public String getTitulo_slider() {
        return titulo_slider;
    }
    public void setTitulo_slider(String titulo_slider) {
        this.titulo_slider = titulo_slider;
    }
    
    public String getSubtitulo_slider() {
        return subtitulo_slider;
    }
    public void setSubtitulo_slider(String subtitulo_slider) {
        this.subtitulo_slider = subtitulo_slider;
    }
    
    public String getRutaimg1_slider() {
        return rutaimg1_slider;
    }
    public void setRutaimg1_slider(String rutaimg1_slider) {
        this.rutaimg1_slider = rutaimg1_slider;
    }
    
    public String getRutaimg2_slider() {
        return rutaimg2_slider;
    }
    public void setRutaimg2_slider(String rutaimg2_slider) {
        this.rutaimg2_slider = rutaimg2_slider;
    }
    
    public String getRutaimg3_slider() {
        return rutaimg3_slider;
    }
    public void setRutaimg3_slider(String rutaimg3_slider) {
        this.rutaimg3_slider = rutaimg3_slider;
    }
    /*
    public String getRutaimg4_slider() {
        return rutaimg4_slider;
    }
    public void setRutaimg4_slider(String rutaimg4_slider) {
        this.rutaimg4_slider = rutaimg4_slider;
    }
    */
    //--------------------------------------------------------------------------
    
    //LINEA
    
    //Linea 1
    public String getTitulo_linea1() {
        return titulo_linea1;
    }
    public void setTitulo_linea1(String titulo_linea1) {
        this.titulo_linea1 = titulo_linea1;
    }
    
    public String getSubtitulo_linea1() {
        return subtitulo_linea1;
    }
    public void setSubtitulo_linea1(String subtitulo_linea1) {
        this.subtitulo_linea1 = subtitulo_linea1;
    }
    
    public String getRutaimg_linea1() {
        return rutaimg_linea1;
    }
    public void setRutaimg_linea1(String rutaimg_linea1) {
        this.rutaimg_linea1 = rutaimg_linea1;
    }
    //--------------------------------------------------------------------------
    
    //Linea 2
    public String getTitulo_linea2() {
        return titulo_linea2;
    }
    public void setTitulo_linea2(String titulo_linea2) {
        this.titulo_linea2 = titulo_linea2;
    }
    
    public String getSubtitulo_linea2() {
        return subtitulo_linea2;
    }
    public void setSubtitulo_linea2(String subtitulo_linea2) {
        this.subtitulo_linea2 = subtitulo_linea2;
    }
    
    public String getRutaimg_linea2() {
        return rutaimg_linea2;
    }
    public void setRutaimg_linea2(String rutaimg_linea2) {
        this.rutaimg_linea2 = rutaimg_linea2;
    }
    //--------------------------------------------------------------------------
    
    //Linea 3
    public String getTitulo_linea3() {
        return titulo_linea3;
    }
    public void setTitulo_linea3(String titulo_linea3) {
        this.titulo_linea3 = titulo_linea3;
    }
    
    public String getSubtitulo_linea3() {
        return subtitulo_linea3;
    }
    public void setSubtitulo_linea3(String subtitulo_linea3) {
        this.subtitulo_linea3 = subtitulo_linea3;
    }
    
    public String getRutaimg_linea3() {
        return rutaimg_linea3;
    }
    public void setRutaimg_linea3(String rutaimg_linea3) {
        this.rutaimg_linea3 = rutaimg_linea3;
    }
    //--------------------------------------------------------------------------
    /*
    //Linea 4
    public String getTitulo_linea4() {
        return titulo_linea4;
    }
    public void setTitulo_linea4(String titulo_linea4) {
        this.titulo_linea4 = titulo_linea4;
    }
    
    public String getSubtitulo_linea4() {
        return subtitulo_linea4;
    }
    public void setSubtitulo_linea4(String subtitulo_linea4) {
        this.subtitulo_linea4 = subtitulo_linea4;
    }
    
    public String getRutaimg_linea4() {
        return rutaimg_linea4;
    }
    public void setRutaimg_linea4(String rutaimg_linea4) {
        this.rutaimg_linea4 = rutaimg_linea4;
    }
    //--------------------------------------------------------------------------
    
    //Linea 5
    public String getTitulo_linea5() {
        return titulo_linea5;
    }
    public void setTitulo_linea5(String titulo_linea5) {
        this.titulo_linea5 = titulo_linea5;
    }
    
    public String getSubtitulo_linea5() {
        return subtitulo_linea5;
    }
    public void setSubtitulo_linea5(String subtitulo_linea5) {
        this.subtitulo_linea5 = subtitulo_linea5;
    }
    
    public String getRutaimg_linea5() {
        return rutaimg_linea5;
    }
    public void setRutaimg_linea5(String rutaimg_linea5) {
        this.rutaimg_linea5 = rutaimg_linea5;
    }
    //--------------------------------------------------------------------------
     //Linea 6
    public String getTitulo_linea6() {
        return titulo_linea6;
    }
    public void setTitulo_linea6(String titulo_linea6) {
        this.titulo_linea6 = titulo_linea6;
    }
    
    public String getSubtitulo_linea6() {
        return subtitulo_linea6;
    }
    public void setSubtitulo_linea6(String subtitulo_linea6) {
        this.subtitulo_linea6 = subtitulo_linea6;
    }
    
    public String getRutaimg_linea6() {
        return rutaimg_linea6;
    }
    public void setRutaimg_linea6(String rutaimg_linea6) {
        this.rutaimg_linea6 = rutaimg_linea6;
    }
    */
    //--------------------------------------------------------------------------
    
     //FOOT
    public String getTitulo_foot() {
        return titulo_foot;
    }
    public void setTitulo_foot(String titulo_foot) {
        this.titulo_foot = titulo_foot;
    }
    
    public String getDescrip_foot() {
        return descrip_foot;
    }
    public void setDescrip_foot(String descrip_foot) {
        this.descrip_foot = descrip_foot;
    }
    
    public String getRutaimg_foot() {
        return rutaimg_foot;
    }
    public void setRutaimg_foot(String rutaimg_foot) {
        this.rutaimg_foot = rutaimg_foot;
    }
    
    //FUNCTION
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.id);
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
        final IndexWeb other = (IndexWeb) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return titulo_slider;
    }
    
}
