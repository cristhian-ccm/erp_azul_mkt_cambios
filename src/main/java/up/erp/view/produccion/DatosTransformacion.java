/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.view.produccion;

/**
 *
 * @author Upgrade - PC
 */
public class DatosTransformacion {
 
    private int productoId;
    private String nombreProducto;
    private String serieArticulo;
    private int cantidad;
    
            
    public DatosTransformacion()
    {}

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getSerieArticulo() {
        return serieArticulo;
    }

    public void setSerieArticulo(String serieArticulo) {
        this.serieArticulo = serieArticulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
    

}
