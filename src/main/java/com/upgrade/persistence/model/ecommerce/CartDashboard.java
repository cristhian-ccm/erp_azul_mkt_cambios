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
public class CartDashboard {
    
    //--------------------------------------------------------------------------
    //VARIABLES 
    //--------------------------------------------------------------------------
    Integer id;
    String producto;
    String nombre;
    String apellidos;
    String email;
    String telefono;
    Integer cantidad;
    //--------------------------------------------------------------------------
    
    //--------------------------------------------------------------------------
    //GETS AND SETS 
    //--------------------------------------------------------------------------
    public Integer getId(){
        return this.id;
    }
    public void setId(Integer id){
        this.id = id;
    }
    
    public String getProducto(){
        return this.producto;
    }
    public void setProducto(String producto){
        this.producto = producto;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getApellidos(){
        return this.apellidos;
    }
    public void setApellidos(String apellidos){
        this.apellidos = apellidos;
    }
    
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getTelefono(){
        return this.telefono;
    }
    public void setTelefono(String telefono){
        this.telefono = telefono;
    }
    
    public Integer getCantidad(){
        return this.cantidad;
    }
    public void setCantidad(Integer cantidad){
        this.cantidad = cantidad;
    }
    //--------------------------------------------------------------------------
    
}
