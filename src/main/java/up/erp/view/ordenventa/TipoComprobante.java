/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.view.ordenventa;

/**
 *
 * @author Diego Javier Quispe
 */
public class TipoComprobante {
    
    private int id;
    private String nombre;
    
    public TipoComprobante(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
        @Override
    public String toString() {
        return nombre;
    }
}
