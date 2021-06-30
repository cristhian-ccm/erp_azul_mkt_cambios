    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.ecommerce;

/**
 *
 * @author Luis Aleman
 */
public class VentasporMesModel {
    
    //--------------------------------------------------------------------------
    //VARIABLES
    //--------------------------------------------------------------------------
    public Integer mes;
    public Integer anio;
    public Double total_ventas;
    //--------------------------------------------------------------------------
    
    
    
    //--------------------------------------------------------------------------
    //GETS AND SETS
    //--------------------------------------------------------------------------
    public Integer get_Mes(){
        return mes;
    }
    
    public void set_Mes(Integer mes){
        this.mes = mes;
    }
    //--------------------------------------------------------------------------
    public Integer get_Año(){
        return anio;
    }
    
    public void set_Año(Integer anio){
        this.anio = anio;
    }
    //--------------------------------------------------------------------------
    public Double get_Total_Ventas(){
        return total_ventas;
    }
    
    public void set_Total_Ventas(Double total_ventas){
        this.total_ventas = total_ventas;
    }
    //--------------------------------------------------------------------------
}
