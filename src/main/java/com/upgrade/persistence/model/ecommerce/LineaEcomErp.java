/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.ecommerce;

import com.upgrade.persistence.model.extcs.Linea;
import ts.com.service.util.db.client.FieldDB;
import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
/**
 *
 * @author Luis Aleman
 */
@TableDB(name="ecommerce.linea_ecom_erp")
public class LineaEcomErp {
    
    @FieldDB(value = "id")
    public Integer id;
    
    @FieldDB(value = "linea_ecom_id")
    public LineaEcommerce linea_ecom;
    
    @FieldDB(value = "linea_erp_id")
    public Linea linea_erp;
    //--------------------------------------------------------------------------------------------
    public Integer getId() {
        return id;
    }

    public void setId(Integer Id){
        this.id = id;
    }
    //--------------------------------------------------------------------------------------------
    public LineaEcommerce getLinea_ecom() {
        return linea_ecom;
    }

    public void setLinea_ecom(LineaEcommerce linea_ecom){
        this.linea_ecom = linea_ecom;
    }
    
    public String getLinea_ecom_Nombre() {
        return linea_ecom.getNombre();
    }
    
    public String getLinea_ecom_Descrip() {
        return linea_ecom.getDescripcion();
    }
    
    //--------------------------------------------------------------------------------------------
    public Linea getLinea_erp() {
        return linea_erp;
    }

    public void setLinea_erp(Linea linea_erp){
        this.linea_erp = linea_erp;
    }
    
    public String getLinea_erp_Nombre() {
        return linea_erp.getNombre();
    }
    
    public String getLinea_erp_Descrip() {
        return linea_erp.getDescripcion();
    }
    
    //--------------------------------------------------------------------------------------------
}
