/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.server.serviceimpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.squareup.okhttp.*;
import com.upgrade.persistence.model.cmrlz.NotaPedidoCab;
import com.upgrade.persistence.model.ecommerce.*;
import com.upgrade.persistence.model.extcs.Producto;
import com.upgrade.persistence.model.usros.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import ts.com.service.util.db.server.CRUD;
import up.erp.service.CulqiService;
import up.erp.service.EcommerceService;
import up.erp.service.Services;
import up.erp.service.model.ErrorTokenCulqi;
import up.erp.service.model.ResponseCulqi;
import up.erp.service.util.SendMail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author evanl
 */
@Service
public class CulqiServiceImpl implements CulqiService {

    @Autowired
    private JavaMailSender javaMailSender;

    /*KEYS DESARROLLO*/
//    private final String keyPrivate = "sk_test_cFEpkzKYMeD8o1f4";
//    private final String keyPublic = "pk_test_qaMfb4gloG7KXo5E";

    /*KEYS PRODUCCIÓN*/
    private final String keyPrivate = "sk_live_VdQ554pd9t6eKBzg";
    private final String keyPublic = "pk_live_sP1qklRtG8bIOhF0";
 
    @Override
    public ResponseCulqiModel realizarCompra(PostCheckoutModel postCheckoutModel){
        SendMail mailUtil = new SendMail(javaMailSender);
        String mail = "";
        Producto productoDelivery = getServicioDelivery();
        ProductoEcModel ecModelProdDelivery = new ProductoEcModel();
        ResponseCulqiModel responseCompra = new ResponseCulqiModel();
        NotaPedidoCab ordenVenta = new NotaPedidoCab();
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        if(postCheckoutModel.getMetodoEntrega().compareTo("delivery") == 0){
            ecModelProdDelivery.setId(productoDelivery.getId().toString());
            ecModelProdDelivery.setCantidad("1");
            ecModelProdDelivery.setPventa(new BigDecimal(postCheckoutModel.getPrecioDelivery()));
            ecModelProdDelivery.setTotal(new BigDecimal(postCheckoutModel.getPrecioDelivery()));
        }
        if(postCheckoutModel.getMetodoPago().compareTo("tarjeta") == 0){
            if (validarPrecio(postCheckoutModel.getProductoEcModelList(), postCheckoutModel.getPrecioProductos())) {
                responseCompra.setMenssage("Precios OK");
                if (validarStock(postCheckoutModel.getProductoEcModelList())) {
                    if(postCheckoutModel.getMetodoEntrega().compareTo("recojo") != 0) {
                        postCheckoutModel.getProductoEcModelList().add(ecModelProdDelivery);
                    }
                    String jsonTarjeta = null;
                    try {
                        jsonTarjeta = ow.writeValueAsString(postCheckoutModel.getTarjetaCulqiModel());
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                        responseCompra.setStatus("error");
                        responseCompra.setMenssage("Error al procesar su compra, si el error persiste por favor comunicarse al (054) - 201476");
                        return responseCompra;
                    }
                    try {
                        ordenVenta = Services.getOrdenVenta().saveFromEcommerce(postCheckoutModel);
                    } catch (Exception e) {
                        e.printStackTrace();
                        responseCompra.setStatus("error");
                        responseCompra.setMenssage("Error al generar su orden de venta, si el error persiste por favor comunicarse al (054) - 201476");
                        return responseCompra;
                    }
                    ResponseCulqi responseTokenTarjeta = null;
                    try {
                        responseTokenTarjeta = crearToken(jsonTarjeta);
                    } catch (IOException e) {
                        e.printStackTrace();
                        ordenVenta.anulada = true;
                        ordenVenta.observaciones = "Exception: " + e.getMessage();
                        ordenVenta.estado_actual = "A";
                        try {
                            Services.getOrdenVenta().updateNotaPedido(ordenVenta);
                        } catch (Exception exception) {
                            exception.printStackTrace();
                            responseCompra.setStatus("error");
                            responseCompra.setMenssage("Error al generar su orden de venta, si el error persiste por favor comunicarse al (054) - 201476");
                            return responseCompra;
                        }
                        responseCompra.setStatus("error");
                        responseCompra.setMenssage("Error al generar su orden de venta, si el error persiste por favor comunicarse al (054) - 201476");

                        return responseCompra;
                    }

                    if (responseTokenTarjeta.getType().compareTo("Success") == 0) {
                        TokenCulqiModel tokenCulqiModel = null;
                        try {
                            tokenCulqiModel = objectMapper.readValue(responseTokenTarjeta.getJsonObj(), TokenCulqiModel.class);
                        } catch (JsonProcessingException e) {
                            e.printStackTrace();
                            responseCompra.setStatus("error");
                            responseCompra.setMenssage("Error al generar su orden de venta, si el error persiste por favor comunicarse al (054) - 201476");
                            return responseCompra;
                        }
                        CargoCulqiModel cargo = new CargoCulqiModel();
                        cargo.setAmount((new BigDecimal(postCheckoutModel.getPrecioVentaTotal()).multiply(new BigDecimal(100)).toBigInteger().toString()));
                        cargo.setCurrency_code("PEN");
                        cargo.setEmail(postCheckoutModel.getTarjetaCulqiModel().getEmail());
                        cargo.setSource_id(tokenCulqiModel.getId());

                        String jsonCargo = null;
                        try {
                            jsonCargo = ow.writeValueAsString(cargo);
                        } catch (JsonProcessingException e) {
                            e.printStackTrace();
                            responseCompra.setStatus("error");
                            responseCompra.setMenssage("Error al procesar su compra, si el error persiste por favor comunicarse al (054) - 201476");
                            return responseCompra;
                        }
                        ResponseCulqi responseCargo = null;
                        try {
                            responseCargo = crearCargo(jsonCargo);
                        } catch (IOException e) {
                            ordenVenta.anulada = true;
                            ordenVenta.observaciones = "Exception: " + e.getMessage();
                            ordenVenta.estado_actual = "A";
                            try {
                                Services.getOrdenVenta().updateNotaPedido(ordenVenta);
                            } catch (Exception exception) {
                                exception.printStackTrace();
                                responseCompra.setStatus("error");
                                responseCompra.setMenssage("Error al generar su orden de venta, si el error persiste por favor comunicarse al (054) - 201476");
                                return responseCompra;
                            }
                            responseCompra.setStatus("error");
                            responseCompra.setMenssage("Error al generar su orden de venta, si el error persiste por favor comunicarse al (054) - 201476");

                            return responseCompra;
                        }

                        if (responseCargo.getType().compareTo("Success") == 0) {
                            TokenCulqiModel tokenCulqiModel2 = null;
                            try {
                                tokenCulqiModel2 = objectMapper.readValue(responseCargo.getJsonObj(), TokenCulqiModel.class);
                            } catch (JsonProcessingException e) {
                                e.printStackTrace();
                                responseCompra.setStatus("error");
                                responseCompra.setMenssage("Error al procesar su compra, si el error persiste por favor comunicarse al (054) - 201476");
                                return responseCompra;
                            }
                            mailUtil.ordenCompra(postCheckoutModel.getComprobanteModel().getNombre(), ordenVenta.numero + "", postCheckoutModel.getTarjetaCulqiModel().getEmail());
                            ordenVenta.token_tarjeta = tokenCulqiModel.getId();
                            ordenVenta.token_cargo = tokenCulqiModel2.getId();
                            try {
                                Services.getOrdenVenta().updateNotaPedido(ordenVenta);
                            } catch (Exception e) {
                                e.printStackTrace();
                                responseCompra.setStatus("error");
                                responseCompra.setMenssage("Error al generar su orden de venta, si el error persiste por favor comunicarse al (054) - 201476");
                                return responseCompra;
                            }

                            if(postCheckoutModel.getCupon() != null)
                                saveUsuCupon(postCheckoutModel.getUsuariow_id(), postCheckoutModel.getCupon().getId());

                            responseCompra.setStatus("success");
                            responseCompra.setMenssage("Su compra está siendo procesada, su orden de venta es: " + ordenVenta.numero + "\n" +
                                    "Si tiene algun inconveniente no dude en consultar por nuestros diferentes canales o llamarnos al (054) - 201476" + "\n \n" +
                                    "¡Estamos a su servicio!, regrese pronto.");
                        } else {
                            ErrorTokenCulqi errorCargoCulqi = null;
                            try {
                                errorCargoCulqi = objectMapper.readValue(responseCargo.getJsonObj(), ErrorTokenCulqi.class);
                            } catch (JsonProcessingException e) {
                                e.printStackTrace();
                                responseCompra.setStatus("error");
                                responseCompra.setMenssage("Error al procesar su compra, si el error persiste por favor comunicarse al (054) - 201476");
                                return responseCompra;
                            }
                            ordenVenta.anulada = true;
                            ordenVenta.observaciones = "Culqi: " + errorCargoCulqi.getUser_message();
                            ordenVenta.estado_actual = "A";
                            try {
                                Services.getOrdenVenta().updateNotaPedido(ordenVenta);
                            } catch (Exception e) {
                                e.printStackTrace();
                                responseCompra.setStatus("error");
                                responseCompra.setMenssage("Error al generar su orden de venta, si el error persiste por favor comunicarse al (054) - 201476");
                                return responseCompra;
                            }
                            responseCompra.setStatus("error");
                            responseCompra.setMenssage(errorCargoCulqi.getUser_message());
                        }
                        return responseCompra;
                    } else {
                        ErrorTokenCulqi errorTokenCulqi = null;
                        try {
                            errorTokenCulqi = objectMapper.readValue(responseTokenTarjeta.getJsonObj(), ErrorTokenCulqi.class);
                        } catch (JsonProcessingException e) {
                            e.printStackTrace();
                            ordenVenta.anulada = true;
                            ordenVenta.observaciones = "JSONException: " +  e.getMessage();
                            ordenVenta.estado_actual = "A";
                            responseCompra.setStatus("error");
                            responseCompra.setMenssage("Error al procesar su compra, si el error persiste por favor comunicarse al (054) - 201476");
                            return responseCompra;
                        }
                        ordenVenta.anulada = true;
                        ordenVenta.observaciones = "Culqi: " + errorTokenCulqi.getUser_message();
                        ordenVenta.estado_actual = "A";
                        try {
                            Services.getOrdenVenta().updateNotaPedido(ordenVenta);
                        } catch (Exception e) {
                            e.printStackTrace();
                            ordenVenta.anulada = true;
                            ordenVenta.observaciones = "JSONException: " +  e.getMessage();
                            ordenVenta.estado_actual = "A";
                            responseCompra.setStatus("error");
                            responseCompra.setMenssage("Error al generar su orden de venta, si el error persiste por favor comunicarse al (054) - 201476");
                            return responseCompra;
                        }
                        responseCompra.setStatus("error");
                        responseCompra.setMenssage(errorTokenCulqi.getUser_message());
                    }
                } else {
                    responseCompra.setStatus("error");
                    responseCompra.setMenssage("Error al procesar su compra, puede que al momento de procesar su compra uno de sus productos haya quedado sin stock, por lo que te pedimos que vuelvas al producto y ver si aún está disponible.");
                    return responseCompra;
                }
            } else {
                responseCompra.setStatus("error");
                responseCompra.setMenssage("Por favor verifique nuevamente si los productos están en stock, puede que ya no se encuentren en stock o se hayan modificado los precios");
            }
        }
        if(postCheckoutModel.getMetodoPago().compareTo("deposito") == 0) {
            if (validarPrecio(postCheckoutModel.getProductoEcModelList(), postCheckoutModel.getPrecioProductos())){
                if (validarStock(postCheckoutModel.getProductoEcModelList())){
                    if(postCheckoutModel.getMetodoEntrega().compareTo("recojo") != 0) {
                        postCheckoutModel.getProductoEcModelList().add(ecModelProdDelivery);
                    }
                    try {
                        ordenVenta = Services.getOrdenVenta().saveFromEcommerce(postCheckoutModel);
                        ordenVenta.aprobada = false;
                        ordenVenta.observaciones = "Pre orden por confirmar";
                        try {
                            Services.getOrdenVenta().updateNotaPedido(ordenVenta);
                            if(postCheckoutModel.getTarjetaCulqiModel().getEmail().compareTo("") ==0){
                                mail = getMailUsuario(postCheckoutModel.getUsuariow_id());
                                mailUtil.compraDeposito(postCheckoutModel.getComprobanteModel().getNombre(), ordenVenta.numero + "", mail, new BigDecimal(postCheckoutModel.getPrecioVentaTotal()));
                            } else {
                                mailUtil.compraDeposito(postCheckoutModel.getComprobanteModel().getNombre(), ordenVenta.numero + "", postCheckoutModel.getTarjetaCulqiModel().getEmail(), new BigDecimal(postCheckoutModel.getPrecioVentaTotal()));
                            }

                            if(postCheckoutModel.getCupon() != null)
                                saveUsuCupon(postCheckoutModel.getUsuariow_id(), postCheckoutModel.getCupon().getId());

                            responseCompra.setStatus("success");
                            responseCompra.setMenssage("Su compra está siendo procesada, su orden de venta es: " + ordenVenta.numero + "\n" +
                                    "<p><strong>Te enviamos un mail con los pasos para poder completar tu compra.</strong></p>" +
                                    "<p>Si no encuentras el mail revisa tu correo no deseado o tu carpeta de Spam.</p>" +
                                    " <p>Si tiene algun inconveniente no dude en consultar por nuestros diferentes canales o llamarnos al (054) - 201476 " +
                                    "                                    ¡Estamos a su servicio!, regrese pronto.</p>");

                        } catch (Exception exception) {
                            exception.printStackTrace();
                            responseCompra.setStatus("error");
                            responseCompra.setMenssage("Error al generar su orden de venta, si el error persiste por favor comunicarse al (054) - 201476");
                            return responseCompra;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        responseCompra.setStatus("error");
                        responseCompra.setMenssage("Error al generar su orden de venta, si el error persiste por favor comunicarse al (054) - 201476");
                        return responseCompra;
                    }
                } else {
                    responseCompra.setStatus("error");
                    responseCompra.setMenssage("Error al procesar su compra, puede que al momento de procesar su compra uno de sus productos haya quedado sin stock, por lo que te pedimos que vuelvas al producto y ver si aún está disponible.");
                    return responseCompra;
                }
            } else {
                responseCompra.setStatus("error");
                responseCompra.setMenssage("Por favor verifique nuevamente si los productos están en stock, puede que ya no se encuentren en stock o se hayan modificado los precios");
            }
        }

        return responseCompra;


    }

    public Producto getServicioDelivery() {
        List<Producto> list = new ArrayList<>();

        try {
            list = CRUD.list(Producto.class, "where codigo = 'SERDELIVERYECOM'");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list.get(0);
    }
    public String getMailUsuario(Integer id) {
        List<UsuarioWeb> list = new ArrayList<>();

        try {
            list = CRUD.list(UsuarioWeb.class, "where id = " + id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list.get(0).getEmail();
    }

    private void saveUsuCupon(Integer idUsuario, Integer idCupon){
        UsuariosCupones usuariosCupones = new UsuariosCupones();
        //----------------------- Cambios - Luis -------------------------------
        Cupones cupon = new Cupones();
        String cupon_id = String.valueOf(idCupon);
        
        UsuarioWeb usu_web = new UsuarioWeb();
        String usuweb_id = String.valueOf(idUsuario);
        
        cupon = Services.getCuponService().find_Cupon_ById(cupon_id);
        usu_web = Services.getUsuarioWeb().find_UsuWeb_byId(usuweb_id);
        //----------------------------------------------------------------------
        System.out.println(cupon.toString());
        usuariosCupones.setCupon(cupon);
        usuariosCupones.setUsuariow(usu_web);
        usuariosCupones.setUtilizado(true);
        try {
            CRUD.save(usuariosCupones);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private ResponseCulqi crearToken(String tarjetaJson) throws IOException {
        OkHttpClient client = new OkHttpClient();
        ResponseCulqi responseCulqi = new ResponseCulqi();
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        // put your json here
        RequestBody body = RequestBody.create(JSON, tarjetaJson);
        Request request = new Request.Builder()
                .url("https://secure.culqi.com/v2/tokens")
                .addHeader("Content-type", "application/json")
                .addHeader("Authorization", "Bearer " + keyPublic)
                .post(body)
                .build();
        Response response = null;
            response = client.newCall(request).execute();
            String resStr = response.body().string();
            System.out.println(resStr);
            if(response.code() == 201){
                responseCulqi.setType("Success");
                responseCulqi.setJsonObj(resStr);
            } else {
                responseCulqi.setType("Error");
                responseCulqi.setJsonObj(resStr);
            }
            return responseCulqi;

//        return execHttpRequest(request);

        //tkn_test_h3sBvRfbApSHcQRw

        // form parameters
      /*  RequestBody formBody = new FormBody.Builder()
                .add("card_number", "4111111111111111")
                .add("cvv", "123")
                .add("expiration_month", "09")
                .add("expiration_year", "2025")
                .add("email", "richard@piedpiper.com")
                .build();

        Request request = new Request.Builder()
                .url("https://secure.culqi.com/v2/tokens")
                .addHeader("Content-type", "application/json")
                .addHeader("Authorization", "Bearer pk_test_116193ba3f543f68")
                .post(formBody)
                .build();*/

     /*   try (Response response = httpClient.newCall(request).execute()) {

            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            // Get response body
            System.out.println(response.body().string());
            return response;
        }*/
    }

    private ResponseCulqi crearCargo(String cargoCulqiModel) throws IOException {
        ResponseCulqi responseCulqiC = new ResponseCulqi();
        OkHttpClient client = new OkHttpClient();
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        // put your json here
        RequestBody body = RequestBody.create(JSON, cargoCulqiModel);
        Request request = new Request.Builder()
                .url(" https://api.culqi.com/v2/charges")
                .addHeader("Content-type", "application/json")
                .addHeader("Authorization", "Bearer " + keyPrivate)
                .post(body)
                .build();
        Response response = null;
            response = client.newCall(request).execute();
            String resCargo = response.body().string();
            System.out.println(resCargo);
            if(response.code() == 201){
                responseCulqiC.setType("Success");
                responseCulqiC.setJsonObj(resCargo);
            } else {
                responseCulqiC.setType("Error");
                responseCulqiC.setJsonObj(resCargo);
            }
            return responseCulqiC;
    }

    private Boolean validarPrecio(List<ProductoEcModel> listProducts, String precioVentaFi){
        System.out.println("PRECIO VENTA INI");
        System.out.println(precioVentaFi);
        System.out.println("PRECIO VENTA FIN");
        BigDecimal precioActual = new BigDecimal(0);
        for(int i= 0; i <listProducts.size(); i++){
            precioActual =  precioActual.add( Services.getProducto().precioActualProd(listProducts.get(i).getId(), listProducts.get(i).getCantidad()));
        }
        System.out.println(precioVentaFi);
        System.out.println(precioActual);
        if(precioActual.compareTo(new BigDecimal(precioVentaFi)) == 0)
            return true;
        else
            return false;
    }

    private Boolean validarStock(List<ProductoEcModel> listProducts){
        BigDecimal precioActual = new BigDecimal(0);
        for(int i= 0; i <listProducts.size(); i++){
            if(Services.getProducto().validarStockParaVenta(listProducts.get(i).getId(), Integer.parseInt(listProducts.get(i).getCantidad())))
                break;
            else
                return false;
        }
        return true;
    }

    private Response execHttpRequest(Request req){
        OkHttpClient client = new OkHttpClient();
        Response response = null;
        try {
            response = client.newCall(req).execute();
            System.out.println(response.code());
            String resStr = response.body().string();
            System.out.println("RESPONSE");
            System.out.println(resStr);
            return response;
        } catch (IOException e) {
            System.out.println("IOException");
            e.printStackTrace();
            return null;
        }
    }

    void sendEmail(String nombre, String nOrden, String email) {

        System.out.println("Sending Email...");
     /*   SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("cesar.palo@upgrade.com.pe", "c.alxndr.pl@gmail.com","alejandro2833@hotmail.com");

        msg.setSubject("Su compra está siendo procesada");
        msg.setText("Hello World \n Spring Boot Email");

        javaMailSender.send(msg);*/


        try {

            MimeMessage message = javaMailSender.createMimeMessage();

            message.setSubject("Su compra está siendo procesada");
            MimeMessageHelper helper;
            helper = new MimeMessageHelper(message, true);
            helper.setFrom("cesar.palo@upgrade.com.pe");
//            helper.setTo(new String[]{"c.alxndr.pl@gmail.com", "alejandro2833@hotmail.com", "cesar.palo@upgrade.com.pe", "julio.serrano@upgrade.com.pe", "luis.aleman@upgrade.com.pe", "evander.torres@upgrade.com.pe"});
            helper.setTo(email);

            helper.setText("" +
                    "<table cellpadding=\"5\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                    "    <tbody><tr style=\"border-color:transparent\">\n" +
                    "        <td align=\"center\" style=\"border-collapse:collapse;border-color:transparent\">\n" +
                    "            <table cellpadding=\"0\" cellspacing=\"0\" width=\"600px\" border=\"0\" bgcolor=\"#FFFFFF\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5\">\n" +
                    "                <tbody>\n" +
                    "                <tr style=\"border-color:transparent\">\n" +
                    "                    <td border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;border-color:transparent\">\n" +
                    "                        <table cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;width:100%\" border=\"0\" width=\"100%\">\n" +
                    "                            <tbody><tr style=\"border-color:transparent\">\n" +
                    "                                <th width=\"600\" style=\"border-color:transparent;font-weight:400;text-align:left;vertical-align:top\" cellpadding=\"0\" cellspacing=\"0\" align=\"left\" valign=\"top\">\n" +
                    "                                    <table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;background-color:#fff\" bgcolor=\"#FFFFFF\">\n" +
                    "                                        <tbody><tr style=\"border-color:transparent\">\n" +
                    "                                            <td cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;border-color:transparent\">\n" +
                    "                                                <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;background-color:#fff\" bgcolor=\"#FFFFFF\">\n" +
                    "                                                    <tbody>\n" +
                    "                                                    <tr  style=\"border-color:transparent\">\n" +
                    "                                                        <td style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\">\n" +
                    "                                                        </td>\n" +
                    "                                                        <td  width=\"520\" style=\"border-collapse:collapse;border-color:transparent;vertical-align:top; background: #193d84\" valign=\"top\">\n" +
                    "                                                            <div  style=\"color:#444;font-family:Arial;Helvetica Neue;,Helvetica,sans-serif;font-size:14px;line-height:1.5;display:block;height:40;width:100%\" height=\"40\" width=\"100%\">\n" +
                    "                                                                <img border=\"0\" width=\"250\" height=\"auto\" align=\"left\" alt=\"test-logo\" src=\"https://www.upgrade.com.pe/Principal/img/LogoBlanco.png\" style=\"text-decoration:none;border:0;height:auto;line-height:100%;outline:0;margin:0;display:block\">\n" +
                    "                                                            </div>\n" +
                    "                                                        </td>\n" +
                    "                                                        <td style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\"></td>\n" +
                    "                                                    </tr>\n" +
                    "                                                    <tr style=\"border-color:transparent\">\n" +
                    "                                                        <td colspan=\"3\" width=\"100%\" height=\"15\" style=\"border-collapse:collapse;border-color:transparent\"></td>\n" +
                    "                                                    </tr>\n" +
                    "                                                    </tbody>\n" +
                    "                                                </table>\n" +
                    "                                            </td>\n" +
                    "                                        </tr>\n" +
                    "                                        </tbody>\n" +
                    "                                    </table>\n" +
                    "                                    <table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;background-color:#fff\" bgcolor=\"#FFFFFF\">\n" +
                    "                                        <tbody><tr style=\"border-color:transparent\">\n" +
                    "                                            <td cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;border-color:transparent\">\n" +
                    "                                                <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;background-color:#fff;font-weight:normal;margin:0\" bgcolor=\"#FFFFFF\">\n" +
                    "                                                    <tbody><tr style=\"border-color:transparent\">\n" +
                    "                                                        <td colspan=\"3\" width=\"100%\" height=\"15\" style=\"border-collapse:collapse;border-color:transparent\"></td>\n" +
                    "                                                    </tr>\n" +
                    "                                                    <tr style=\"border-color:transparent\">\n" +
                    "                                                        <td style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\"></td>\n" +
                    "                                                        <td width=\"520\" style=\"border-collapse:collapse;border-color:transparent;vertical-align:top\" valign=\"top\">\n" +
                    "                                                            <p style=\"font-size:inherit;line-height:1.5;margin:0 0 10px;color:inherit;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-weight:normal;padding:0\">\n" +
                    "                                                                <span style=\"font-size:14px\"><strong>Hola " + nombre +"</strong></span>\n" +
                    "                                                            </p>\n" +
                    "                                                            <p style=\"font-size:inherit;line-height:1.5;margin:0 0 10px;color:inherit;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-weight:normal;padding:0\">\n" +
                    "                                                                <span style=\"font-size:24px\"><strong>Tu numero de orden es № " + nOrden + "</strong></span>\n" +
                    "                                                            </p>\n" +
                    "                                                        </td>\n" +
                    "                                                        <td style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\"></td>\n" +
                    "                                                    </tr>\n" +
                    "                                                    <tr style=\"border-color:transparent\">\n" +
                    "                                                        <td colspan=\"3\" width=\"100%\" height=\"20\" style=\"border-collapse:collapse;border-color:transparent\"></td>\n" +
                    "                                                    </tr>\n" +
                    "                                                    </tbody>\n" +
                    "                                                </table>\n" +
                    "                                            </td>\n" +
                    "                                        </tr>\n" +
                    "                                        </tbody>\n" +
                    "                                    </table>\n" +
                    "\n" +
                    "                                    <table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;background-color:#fff\" bgcolor=\"#FFFFFF\">\n" +
                    "                                        <tbody><tr style=\"border-color:transparent\">\n" +
                    "                                            <td cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;border-color:transparent\">\n" +
                    "                                                <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;background-color:#fff;font-weight:normal;margin:0\" bgcolor=\"#FFFFFF\">\n" +
                    "                                                    <tbody><tr style=\"border-color:transparent\">\n" +
                    "                                                        <td colspan=\"3\" width=\"100%\" height=\"15\" style=\"border-collapse:collapse;border-color:transparent\"></td>\n" +
                    "                                                    </tr>\n" +
                    "                                                    <tr style=\"border-color:transparent\">\n" +
                    "                                                        <td style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\"></td>\n" +
                    "                                                        <td width=\"520\" style=\"border-collapse:collapse;border-color:transparent;vertical-align:top\" valign=\"top\">\n" +
                    "                                                            <p style=\"font-size:14PX;line-height:1.5;margin:0 0 10px;color:inherit;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-weight:normal;padding:0\">\n" +
                    "                                                                <span style=\"font-size:14px\">Tu orden está siendo procesada, recuerda que puedes comunicarte con nosotros al <strong>(054) 201476</strong> o apersonarte a nuestra sede principal ubicada en\n" +
                    "                                                                <strong>Urb.Magisterial II B-4, José Abelardo Quiñones </strong> en los siquientes horarios:</span>\n" +
                    "                                                            </p>\n" +
                    "                                                            <li>De Lunes a Viernes 9:00 am - 7:00 pm</li>\n" +
                    "                                                            <li>Sábados 9:00 am - 1:00 pm</li>\n" +
                    "                                                        </td>\n" +
                    "                                                        <td style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\"></td>\n" +
                    "                                                    </tr>\n" +
                    "                                                    <tr style=\"border-color:transparent\">\n" +
                    "                                                        <td colspan=\"3\" width=\"100%\" height=\"20\" style=\"border-collapse:collapse;border-color:transparent\"></td>\n" +
                    "                                                    </tr>\n" +
                    "                                                    </tbody>\n" +
                    "                                                </table>\n" +
                    "                                            </td>\n" +
                    "                                        </tr>\n" +
                    "                                        </tbody>\n" +
                    "                                    </table>\n" +
                    "                                </th>\n" +
                    "                            </tr>\n" +
                    "                            </tbody></table>\n" +
                    "                    </td>\n" +
                    "                </tr>\n" +
                    "                <tr style=\"border-color:transparent\">\n" +
                    "                    <td border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;border-color:transparent\">\n" +
                    "                        <table cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;width:100%\" border=\"0\" width=\"100%\">\n" +
                    "                            <tbody><tr style=\"border-color:transparent\">\n" +
                    "                                <th width=\"600\" style=\"border-color:transparent;font-weight:400;text-align:left;vertical-align:top\" cellpadding=\"0\" cellspacing=\"0\" class=\"m_-4400337760845399296tc\" align=\"left\" valign=\"top\">\n" +
                    "                                    <table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;background-color:#fff\" bgcolor=\"#FFFFFF\">\n" +
                    "                                        <tbody><tr style=\"border-color:transparent\">\n" +
                    "                                            <td cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;border-color:transparent\">\n" +
                    "                                                <div class=\"m_-4400337760845399296block-divider\" style=\"color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;background-color:#fff;padding-bottom:30px;padding-left:40px;padding-right:40px;padding-top:20px\" bgcolor=\"#FFFFFF\">\n" +
                    "                                                    <hr id=\"m_-4400337760845399296iout_block_10_element_0\" style=\"margin:0;border-bottom:0;border-left:0;border-right:0;border-top-color:#e3e3e3;border-top-style:solid;border-top-width:1px\"></div>\n" +
                    "                                            </td>\n" +
                    "                                        </tr>\n" +
                    "                                        </tbody></table>\n" +
                    "                                </th>\n" +
                    "                            </tr>\n" +
                    "                            </tbody></table>\n" +
                    "                    </td>\n" +
                    "                </tr>\n" +
                    "                <tr style=\"border-color:transparent\">\n" +
                    "                    <td border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;border-color:transparent\">\n" +
                    "                        <table cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;width:100%\" border=\"0\" width=\"100%\">\n" +
                    "                            <tbody><tr style=\"border-color:transparent\">\n" +
                    "                                <th width=\"300\" style=\"border-color:transparent;font-weight:400;text-align:left;vertical-align:top\" cellpadding=\"0\" cellspacing=\"0\" align=\"left\" valign=\"top\">\n" +
                    "                                    <table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;background-color:#fff\" bgcolor=\"#FFFFFF\">\n" +
                    "                                        <tbody><tr style=\"border-color:transparent\">\n" +
                    "                                            <td cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;border-color:transparent\">\n" +
                    "                                                <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;background-color:#fff;font-weight:normal;height:108px;margin:0\" bgcolor=\"#FFFFFF\" height=\"108\">\n" +
                    "                                                    <tbody><tr style=\"border-color:transparent\">\n" +
                    "                                                        <td class=\"m_-4400337760845399296expander\" colspan=\"3\" width=\"100%\" height=\"15\" style=\"border-collapse:collapse;border-color:transparent\"></td>\n" +
                    "                                                    </tr>\n" +
                    "                                                    <tr  style=\"border-color:transparent\">\n" +
                    "                                                        <td style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\"></td>\n" +
                    "                                                        <td width=\"220\" height=\"93\" style=\"border-collapse:collapse;border-color:transparent;vertical-align:top\" valign=\"top\">\n" +
                    "                                                            <p style=\"font-size:inherit;line-height:1.5;margin:0 0 10px;color:inherit;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-weight:normal;padding:0\"><span style=\"color:#888888\">Atención al Cliente:</span></p>\n" +
                    "                                                            <p style=\"font-size:inherit;line-height:1.5;margin:0 0 10px;color:inherit;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-weight:normal;padding:0\"><span style=\"color:#888888\"><span style=\"color:#24c1ff\"><a style=\"text-decoration:none;color:#24c1ff\" target=\"_blank\">(054) 201476</a></span></span></p>\n" +
                    "                                                            <p style=\"font-size:inherit;line-height:1.5;margin:0 0 10px;color:inherit;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-weight:normal;padding:0\"><span style=\"color:#888888\"><span style=\"color:#24c1ff\"><a style=\"text-decoration:none;color:#24c1ff\"  target=\"_blank\">atencion.cliente@upgrade.com.pe</a></span></span></p>\n" +
                    "                                                        </td>\n" +
                    "                                                        <td class=\"m_-4400337760845399296gutter\" style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\"></td>\n" +
                    "                                                    </tr>\n" +
                    "                                                    </tbody></table>\n" +
                    "                                            </td>\n" +
                    "                                        </tr>\n" +
                    "                                        </tbody></table>\n" +
                    "                                </th>\n" +
                    "                                <th width=\"300\" style=\"border-color:transparent;font-weight:400;text-align:left;vertical-align:top\" cellpadding=\"0\" cellspacing=\"0\" class=\"m_-4400337760845399296tc\" align=\"left\" valign=\"top\">\n" +
                    "                                    <table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;background-color:#fff\" bgcolor=\"#FFFFFF\">\n" +
                    "                                        <tbody><tr style=\"border-color:transparent\">\n" +
                    "                                            <td cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;border-color:transparent\">\n" +
                    "                                                <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" id=\"m_-4400337760845399296wout_block_out_block_7\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;background-color:#fff;font-weight:normal;height:46px;margin:0\" bgcolor=\"#FFFFFF\" height=\"46\">\n" +
                    "                                                    <tbody><tr style=\"border-color:transparent\">\n" +
                    "                                                        <td class=\"m_-4400337760845399296expander\" colspan=\"3\" width=\"100%\" height=\"15\" style=\"border-collapse:collapse;border-color:transparent\"></td>\n" +
                    "                                                    </tr>\n" +
                    "                                                    <tr class=\"m_-4400337760845399296content-row\" style=\"border-color:transparent\">\n" +
                    "                                                        <td class=\"m_-4400337760845399296gutter\" style=\"border-collapse:collapse;border-color:transparent;width:20px!important\" width=\"20\" height=\"100%\"></td>\n" +
                    "                                                        <td class=\"m_-4400337760845399296content-cell\" width=\"240\" height=\"31\" style=\"border-collapse:collapse;border-color:transparent;vertical-align:top\" valign=\"top\">\n" +
                    "                                                            <p style=\"font-size:inherit;line-height:1.5;margin:0 0 10px;color:inherit;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-weight:normal;padding:0\"><span style=\"color:#888888\">Visita nuestras redes sociales:</span></p>\n" +
                    "                                                        </td>\n" +
                    "                                                        <td class=\"m_-4400337760845399296gutter\" style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\"></td>\n" +
                    "                                                    </tr>\n" +
                    "                                                    </tbody></table>\n" +
                    "                                            </td>\n" +
                    "                                        </tr>\n" +
                    "                                        </tbody></table>\n" +
                    "                                    <table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;background-color:#fff\" bgcolor=\"#FFFFFF\">\n" +
                    "                                        <tbody><tr style=\"border-color:transparent\">\n" +
                    "                                            <td cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;border-color:transparent\">\n" +
                    "                                                <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;background-color:#fff;height:62px;text-align:left\" bgcolor=\"#FFFFFF\" height=\"62\" align=\"left\">\n" +
                    "                                                    <tbody><tr class=\"m_-4400337760845399296content-row\" style=\"border-color:transparent\">\n" +
                    "                                                        <td class=\"m_-4400337760845399296gutter\" style=\"border-collapse:collapse;border-color:transparent;width:10px!important\" width=\"10\" height=\"100%\"></td>\n" +
                    "                                                        <td class=\"m_-4400337760845399296content-cell\" width=\"275\" height=\"62\" style=\"border-collapse:collapse;border-color:transparent;vertical-align:top\" valign=\"top\">\n" +
                    "                                                            <table class=\"m_-4400337760845399296social\" cellpadding=\"5\" border=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1;border-color:transparent;border-style:none;border-width:0;border:0;border-spacing:0;display:inline-block\">\n" +
                    "                                                                <tbody><tr style=\"border-color:transparent\">\n" +
                    "                                                                    <th class=\"m_-4400337760845399296social_element\" style=\"border-color:transparent;font-family:Arial,sans-serif;font-size:13px;line-height:32px;padding:2px 5px;font-weight:400;text-align:left;border-style:none;border-width:0;border:0\" align=\"left\">\n" +
                    "                                                                        <a style=\"text-decoration:none;color:#24c1ff\"  style=\"text-decoration:none;border:0;height:auto;line-height:100%;outline:0;border-color:transparent;border-style:none;border-width:0;display:block;margin:5px\" vspace=\"5\" hspace=\"5\" title=\"Facebook\" width=\"32\" height=\"auto\">\n" +
                    "                                                                            <img src=\"https://upload.wikimedia.org/wikipedia/commons/thumb/f/fb/Facebook_icon_2013.svg/300px-Facebook_icon_2013.svg.png\" alt=\"Facebook\" height=\"40\" width=\"auto\">\n" +
                    "                                                                        </a>\n" +
                    "                                                                    </th>\n" +
                    "                                                                </tr>\n" +
                    "                                                                </tbody></table>\n" +
                    "                                                        </td>\n" +
                    "                                                        <td class=\"m_-4400337760845399296gutter\" style=\"border-collapse:collapse;border-color:transparent;width:15px!important\" width=\"15\" height=\"100%\"></td>\n" +
                    "                                                    </tr>\n" +
                    "                                                    </tbody></table>\n" +
                    "                                            </td>\n" +
                    "                                        </tr>\n" +
                    "                                        </tbody></table>\n" +
                    "                                </th>\n" +
                    "                            </tr>\n" +
                    "                            </tbody></table>\n" +
                    "                    </td>\n" +
                    "                </tr>\n" +
                    "                </tbody></table>\n" +
                    "            <table width=\"600px\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5\">\n" +
                    "                <tbody><tr style=\"border-color:transparent\">\n" +
                    "                    <td style=\"border-collapse:collapse;border-color:transparent;text-align:center\" align=\"center\">\n" +
                    "                        <div align=\"center\" style=\"color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;padding-bottom:8px;padding-top:8px\">\n" +
                    "                            <p style=\"font-size:11px;line-height:1.5;margin:0;color:#777;font-family:Verdana,Arial,sans-serif\">Enviado a través de</p>\n" +
                    "                            <span>\n" +
                    "                                <a style=\"text-decoration:none;color:#24c1ff\" target=\"_blank\">\n" +
                    "                                    Consultancy Grupo Upgrade\n" +
                    "                                </a>\n" +
                    "                    </td>\n" +
                    "                </tr>\n" +
                    "                </tbody></table>\n" +
                    "        </td>\n" +
                    "    </tr>\n" +
                    "    </tbody>\n" +
                    "</table>", true);
            javaMailSender.send(message);
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }

       /* MimeMessage msg = javaMailSender.createMimeMessage();

        // true = multipart message
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
        helper.setTo("c.alxndr.pl@gmail.com");
        helper.setTo("cesar.palo@upgrade.com.pe");


        helper.setSubject("Su compra está siendo procesada");

        // default = text/plain
        //helper.setText("Check attachment for image!");

        // true = text/html
        helper.setText("<h1>Check attachment for image!</h1>", true);

        //FileSystemResource file = new FileSystemResource(new File("classpath:android.png"));

        //Resource resource = new ClassPathResource("android.png");
        //InputStream input = resource.getInputStream();

        //ResourceUtils.getFile("classpath:android.png");

//        helper.addAttachment("my_photo.png", new ClassPathResource("android.png"));

        javaMailSender.send(msg);*/
        System.out.println("Done");
    }


}
