/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.view.comprobantes;

import com.upgrade.persistence.model.ventas.Detalle_ObjectNubefact;
import com.upgrade.persistence.model.ventas.ObjectNubefact;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;



/**
 *
 * @author Upgrade - PC
 */
public class Nubefact_Comprobantes {
    //RUTA para enviar documentos
    //private String RUTA = "https://api.nubefact.com/api/v1/5e7229dd-da85-48a7-9fc8-761af98bfe55"; //Prueba//
    private String RUTA = "https://api.nubefact.com/api/v1/eb7fb82b-27f4-4f7f-a823-aca8d8782b2a"; // Real
    
//TOKEN para enviar documentos    
    private String TOKEN_Rivero = "fbf6add717194cf6af97aa681f3cfa38df715d67a5994434bc89cb95e233f5fe"; //real//
    private String TOKEN_Quiñones = "57468d40286e4f24aa691a698dd97517a15b7f71994d4224a7a1b8add9e9cdd9"; //Real
    private String TOKEN_Cusco = "e68b2f3bc6ea434a9ab6304b4911ea95f725fec2e6f1430eaecba97f1650ae42";//Real
    //private String TOKEN_Quiñones = "873cf6f348f74571a93342d974b01be1418c19abb5174c6594f7261800334d9c"; //Prueba//
    
    public ObjectNubefact apiConsume(ObjectNubefact objectNubefact) {
        try {            

            HttpClient cliente = new DefaultHttpClient();
            
            HttpPost post = new HttpPost(RUTA);
            
            if(objectNubefact.local == 18 ){
                post.addHeader("Authorization", "Token token=" + TOKEN_Quiñones); // Cabecera del token
            }
            if(objectNubefact.local == 1 ){
                post.addHeader("Authorization", "Token token=" + TOKEN_Rivero); // Cabecera del token
            }
            if(objectNubefact.local == 3 ){
                post.addHeader("Authorization", "Token token=" + TOKEN_Cusco); // Cabecera del token
            }
            
            
            //post.addHeader("Authorization", "Token token=" + TOKEN); // Cabecera del token
            post.addHeader("Content-Type", "application/json"); // Cabecera del Content-Type
            
            JSONObject objetoCabecera = new JSONObject(); // Instancear el  segundario
            objetoCabecera.put("operacion", objectNubefact.operacion);
            objetoCabecera.put("tipo_de_comprobante", objectNubefact.tipo_de_comprobante.toString());
            objetoCabecera.put("serie", objectNubefact.serie);
            objetoCabecera.put("numero", objectNubefact.numero);
            objetoCabecera.put("motivo", objectNubefact.motivo);
            objetoCabecera.put("sunat_transaction", objectNubefact.sunat_transaction);
            objetoCabecera.put("cliente_tipo_de_documento", objectNubefact.cliente_tipo_de_documento);
            objetoCabecera.put("cliente_numero_de_documento", objectNubefact.cliente_numero_de_documento);
            objetoCabecera.put("cliente_denominacion", objectNubefact.cliente_denominacion);
            objetoCabecera.put("cliente_direccion", objectNubefact.cliente_direccion);
            
            if (objectNubefact.cliente_email != null) {
                objetoCabecera.put("cliente_email", objectNubefact.cliente_email);
            }
            if (objectNubefact.cliente_email_1 != null) {
                objetoCabecera.put("cliente_email_1", objectNubefact.cliente_email_1);
            }
            if (objectNubefact.cliente_email_2 != null) {
                objetoCabecera.put("cliente_email_2", objectNubefact.cliente_email_2);
            }

            SimpleDateFormat parseador = new SimpleDateFormat("dd-MM-yyyy");
            String fecha = parseador.format(objectNubefact.fecha_de_emision);
            objetoCabecera.put("fecha_de_emision", fecha);
            if (objectNubefact.fecha_de_vencimiento != null) {
                objetoCabecera.put("fecha_de_vencimiento", objectNubefact.fecha_de_vencimiento);
            }
            objetoCabecera.put("moneda", objectNubefact.moneda);
            if (objectNubefact.tipo_de_cambio != null) {
                objetoCabecera.put("tipo_de_cambio", objectNubefact.tipo_de_cambio);
            }
            objetoCabecera.put("porcentaje_de_igv", objectNubefact.porcentaje_de_igv);
            if (objectNubefact.descuento_global != null) {
                objetoCabecera.put("descuento_global", objectNubefact.descuento_global);
            }
            if (objectNubefact.total_descuento != null) {
                objetoCabecera.put("total_descuento", objectNubefact.total_descuento);
            }
            if (objectNubefact.total_anticipo != null) {
                objetoCabecera.put("total_anticipo", objectNubefact.total_anticipo);
            }
            if (objectNubefact.total_gravada != null) {
                objetoCabecera.put("total_gravada", objectNubefact.total_gravada);
            }
            if (objectNubefact.total_inafecta != null) {
                objetoCabecera.put("total_inafecta", objectNubefact.total_inafecta);
            }
            if (objectNubefact.total_exonerada != null) {
                objetoCabecera.put("total_exonerada", objectNubefact.total_exonerada);
            }
            if (objectNubefact.total_igv != null) {
                objetoCabecera.put("total_igv", objectNubefact.total_igv);
            }
            if (objectNubefact.total_gratuita != null) {
                objetoCabecera.put("total_gratuita", objectNubefact.total_gratuita);
            }
            if (objectNubefact.total_otros_cargos != null) {
                objetoCabecera.put("total_otros_cargos", objectNubefact.total_otros_cargos);
            }
            objetoCabecera.put("total", objectNubefact.total);
            if (objectNubefact.percepcion_tipo != null) {
                objetoCabecera.put("percepcion_tipo", objectNubefact.percepcion_tipo);
            }
            if (objectNubefact.percepcion_base_imponible != null) {
                objetoCabecera.put("percepcion_base_imponible", objectNubefact.percepcion_base_imponible);
            }
            if (objectNubefact.total_percepcion != null) {
                objetoCabecera.put("total_percepcion", objectNubefact.total_percepcion);
            }
            if (objectNubefact.total_incluido_percepcion != null) {
                objetoCabecera.put("total_incluido_percepcion", objectNubefact.total_incluido_percepcion);
            }
            if (objectNubefact.detraccion != null) {
                objetoCabecera.put("detraccion", objectNubefact.detraccion);
            }
            if (objectNubefact.observaciones != null) {
                objetoCabecera.put("observaciones", objectNubefact.observaciones);
            }
            if (objectNubefact.documento_que_se_modifica_tipo != null) {
                objetoCabecera.put("documento_que_se_modifica_tipo", objectNubefact.documento_que_se_modifica_tipo);
            }
            if (objectNubefact.documento_que_se_modifica_serie != null) {
                objetoCabecera.put("documento_que_se_modifica_serie", objectNubefact.documento_que_se_modifica_serie);
            }
            if (objectNubefact.documento_que_se_modifica_numero != null) {
                objetoCabecera.put("documento_que_se_modifica_numero", objectNubefact.documento_que_se_modifica_numero);
            }
            if (objectNubefact.tipo_de_nota_de_credito != null) {
                objetoCabecera.put("tipo_de_nota_de_credito", objectNubefact.tipo_de_nota_de_credito);
            }
            if (objectNubefact.tipo_de_nota_de_debito != null) {
                objetoCabecera.put("tipo_de_nota_de_debito", objectNubefact.tipo_de_nota_de_debito);
            }
            objetoCabecera.put("enviar_automaticamente_a_la_sunat", objectNubefact.enviar_automaticamente_a_la_sunat);
            objetoCabecera.put("enviar_automaticamente_al_cliente", objectNubefact.enviar_automaticamente_al_cliente);
            if (objectNubefact.codigo_unico != null) {
                objetoCabecera.put("codigo_unico", objectNubefact.codigo_unico);
            }
            if (objectNubefact.condiciones_de_pago != null) {
                objetoCabecera.put("condiciones_de_pago", objectNubefact.condiciones_de_pago);
            }
            if (objectNubefact.medio_de_pago != null) {
                objetoCabecera.put("medio_de_pago", objectNubefact.medio_de_pago);
            }
            if (objectNubefact.placa_vehiculo != null) {
                objetoCabecera.put("placa_vehiculo", objectNubefact.placa_vehiculo);
            }
            if (objectNubefact.orden_compra_servicio != null) {
                objetoCabecera.put("orden_compra_servicio", objectNubefact.orden_compra_servicio);
            }
            if (objectNubefact.tabla_personalizada_codigo != null) {
                objetoCabecera.put("tabla_personalizada_codigo", objectNubefact.tabla_personalizada_codigo);
            }
            if (objectNubefact.formato_de_pdf != null) {
                objetoCabecera.put("formato_de_pdf", objectNubefact.formato_de_pdf);
            }
            
            JSONArray lista = new JSONArray();

            for (Detalle_ObjectNubefact item : objectNubefact.Detalle) {
                JSONObject detalle_linea = new JSONObject();

                detalle_linea.put("unidad_de_medida", item.unidad_de_medida);
                //if(item.codigo!= null) detalle_linea.put("codigo", item.codigo);
                detalle_linea.put("descripcion", item.descripcion);
                detalle_linea.put("cantidad", item.cantidad);
                detalle_linea.put("valor_unitario", item.valor_unitario);
                detalle_linea.put("precio_unitario", item.precio_unitario);
                if (item.descuento != null) {
                    detalle_linea.put("descuento", item.descuento);
                }
                detalle_linea.put("subtotal", item.subtotal);
                detalle_linea.put("tipo_de_igv", item.tipo_de_igv);
                detalle_linea.put("igv", item.igv);
                detalle_linea.put("total", item.total);
                if (item.anticipo_regularizacion != null) {
                    detalle_linea.put("anticipo_regularizacion", item.anticipo_regularizacion);
                }
                if (item.anticipo_serie != null) {
                    detalle_linea.put("anticipo_serie", item.anticipo_serie);
                }
                if (item.anticipo_documento_numero != null) {
                    detalle_linea.put("anticipo_documento_numero", item.anticipo_documento_numero);
                }
                detalle_linea.put("codigo_producto_sunat", item.codigo_producto_sunat);

                lista.add(detalle_linea);
            }

            objetoCabecera.put("items", lista);
            System.out.println(objetoCabecera);
            
            System.out.println(objetoCabecera);
            /*
##############################################
#### PASO 3: ENVIAR EL ARCHIVO A NUBEFACT ####

             */
            StringEntity parametros = new StringEntity(objetoCabecera.toString(), "UTF-8");
            post.setEntity(parametros);
            HttpResponse response = cliente.execute(post);
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String linea = "";
            if ((linea = rd.readLine()) != null) {
                
                //
                JSONParser parsearRsptaJson = new JSONParser();
                
                JSONObject json_rspta = (JSONObject) parsearRsptaJson.parse(linea);

                /*
#########################################################
#### PASO 4: LEER RESPUESTA DE NUBEFACT ####

                 */
                if (json_rspta.get("errors") != null) {
                    //System.out.println("Error => " + json_rspta.get("errors"));
                    objectNubefact.Error = "Error => " + json_rspta.get("errors");
                } else {

                    //JSONParser parsearRsptaDetalleOK = new JSONParser();
                    //JSONObject json_rspta_ok = (JSONObject) parsearRsptaDetalleOK.parse(json_rspta.get("invoice").toString());                  
                    //Guardar la respuesta en Base de Datos
                    objectNubefact.aceptadaSunat = (Boolean) json_rspta.get("aceptada_por_sunat");
                    objectNubefact.sunatDescription = (String) json_rspta.get("sunat_description");
                    objectNubefact.enlaceXml = (String) json_rspta.get("enlace_del_xml");
                    objectNubefact.enlacePdf = (String) json_rspta.get("enlace_del_pdf");

                }
            }
            return  objectNubefact;
        } catch (UnsupportedEncodingException ex1) {
            System.err.println("Error UnsupportedEncodingException: " + ex1.getMessage());
        } catch (IOException ex2) {
            System.err.println("Error IOException: " + ex2.getMessage());
        } catch (Exception ex3) {
            System.err.println("Exepction: " + ex3.getMessage());
        }
        return null;
    }
  
}