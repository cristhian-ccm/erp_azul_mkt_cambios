/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.view.comprobantes;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 *
 * @author Sol
 */
public class ObjectNubefact implements Serializable {

    public ObjectNubefact() {
        this.Detalle = new ArrayList();
    }

    public String operacion;
    public Integer tipo_de_comprobante;
    public String serie;
    public Integer numero;
    public Integer sunat_transaction;
    public Integer cliente_tipo_de_documento;
    public String cliente_numero_de_documento;
    public String cliente_denominacion;
    public String cliente_direccion;
    public String cliente_email;
    public String cliente_email_1;
    public String cliente_email_2;
    public Date fecha_de_emision;
    public Date fecha_de_vencimiento;
    public Integer moneda;
    public BigDecimal tipo_de_cambio;
    public double porcentaje_de_igv;
    public BigDecimal descuento_global;
    public BigDecimal total_descuento;
    public BigDecimal total_anticipo;
    public BigDecimal total_gravada;
    public BigDecimal total_inafecta;
    public BigDecimal total_exonerada;
    public BigDecimal total_igv;
    public BigDecimal total_gratuita;
    public BigDecimal total_otros_cargos;
    public BigDecimal total;
    public Integer percepcion_tipo;
    public BigDecimal percepcion_base_imponible;
    public BigDecimal total_percepcion;
    public BigDecimal total_incluido_percepcion;
    public Boolean detraccion;
    public String observaciones;
    public Integer documento_que_se_modifica_tipo;
    public String documento_que_se_modifica_serie;
    public Integer documento_que_se_modifica_numero;
    public Integer tipo_de_nota_de_credito;
    public Integer tipo_de_nota_de_debito;
    public Boolean enviar_automaticamente_a_la_sunat;
    public Boolean enviar_automaticamente_al_cliente;
    public String codigo_unico;
    public String condiciones_de_pago;
    public String medio_de_pago;
    public String placa_vehiculo;
    public String orden_compra_servicio;
    public BigDecimal tabla_personalizada_codigo;
    public String formato_de_pdf;     
    public Boolean aceptadaSunat;
    public String sunatDescription;  
    public String enlaceXml;    
    public String enlacePdf;    
    
    public String Error;
    public Integer local;
    public List<Detalle_ObjectNubefact> Detalle;

}
