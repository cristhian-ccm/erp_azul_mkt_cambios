/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.view.produccion;

import com.vaadin.flow.component.textfield.TextField;
/**
 *
 * @author Diego-Javier
 */
public class DatosPlantilla implements Cloneable{
    
    private int id;
    private String nombre;
    private String marca;    
    private String modelo;
    private int cantidad;
    
    public DatosPlantilla() {

    }

    public DatosPlantilla(int id, String nombre, String marca, String modelo, int cantidad) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
        this.modelo = modelo;
        this.cantidad = cantidad;

    }
    
    public DatosPlantilla(String nombre, String marca, String modelo, int cantidad) {
        super();
        this.nombre = nombre;
        this.marca = marca;
        this.modelo = modelo;
        this.cantidad = cantidad;

    }
    
    public int getId()
    {
        return this.id;
    }
    
    public String getNombre()
    {
        return this.nombre;
    }
    
    public String getMarca()
    {
        return this.marca;
    }
    
    public String getModelo()
    {
        return this.modelo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
}
 
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


