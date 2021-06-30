/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.view.comprobantes;

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
public class Nubefact_Anulacion {
    //RUTA para enviar documentos
    //private String RUTA = "https://api.nubefact.com/api/v1/5e7229dd-da85-48a7-9fc8-761af98bfe55"; //Prueba//
    private String RUTA = "https://api.nubefact.com/api/v1/eb7fb82b-27f4-4f7f-a823-aca8d8782b2a"; // Real
    
//TOKEN para enviar documentos    
    private String TOKEN_Rivero = "fbf6add717194cf6af97aa681f3cfa38df715d67a5994434bc89cb95e233f5fe"; //real//
    private String TOKEN_Quiñones = "57468d40286e4f24aa691a698dd97517a15b7f71994d4224a7a1b8add9e9cdd9"; //Real
    private String TOKEN_Cusco = "e68b2f3bc6ea434a9ab6304b4911ea95f725fec2e6f1430eaecba97f1650ae42";//Real
    //private String TOKEN_Quiñones = "873cf6f348f74571a93342d974b01be1418c19abb5174c6594f7261800334d9c"; //Prueba//
    
    public com.upgrade.persistence.model.ventas.ObjectNubefact apiConsume(com.upgrade.persistence.model.ventas.ObjectNubefact objectNubefact) {
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
           
            System.out.println(objetoCabecera);


            
            StringEntity parametros = new StringEntity(objetoCabecera.toString(), "UTF-8");
            post.setEntity(parametros);
            HttpResponse response = cliente.execute(post);
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String linea = "";
            if ((linea = rd.readLine()) != null) {
                
                //
                JSONParser parsearRsptaJson = new JSONParser();
                
                JSONObject json_rspta = (JSONObject) parsearRsptaJson.parse(linea);


                if (json_rspta.get("errors") != null) {
                    
                    objectNubefact.Error = "Error => " + json_rspta.get("errors");
                } else {

                   
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