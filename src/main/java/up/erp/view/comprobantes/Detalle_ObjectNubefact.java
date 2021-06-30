/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.view.comprobantes;


import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author Sol
 */
public class Detalle_ObjectNubefact implements Serializable {

    public Detalle_ObjectNubefact() {
    }
    public String unidad_de_medida;
    public String codigo;
    public String descripcion;
    public BigDecimal cantidad;
    public BigDecimal valor_unitario;
    public BigDecimal precio_unitario;
    public BigDecimal descuento;
    public BigDecimal subtotal;
    public Integer tipo_de_igv;
    public BigDecimal igv;
    public BigDecimal total;
    public Boolean anticipo_regularizacion;
    public String anticipo_serie;
    public String anticipo_documento_numero;
    public String codigo_producto_sunat;

}
