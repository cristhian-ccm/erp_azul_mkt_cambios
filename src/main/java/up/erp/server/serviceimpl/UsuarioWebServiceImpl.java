/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.server.serviceimpl;

import ch.qos.logback.classic.pattern.SyslogStartConverter;
import com.upgrade.persistence.model.cmrlz.NotaPedidoCab;
import com.upgrade.persistence.model.ecommerce.*;
import com.upgrade.persistence.model.extcs.Almacen;
import com.upgrade.persistence.model.extcs.Linea;
import com.upgrade.persistence.model.usros.Usuario;
import org.jasypt.digest.PooledStringDigester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import ts.com.service.util.db.Query;
import ts.com.service.util.db.server.CRUD;
import up.erp.service.Services;
import up.erp.service.UsuarioWebService;
import up.erp.service.model.SaveCart;
import up.erp.service.util.SendMail;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.List;
import java.util.Random;
import java.time.LocalDateTime;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import up.erp.server.Server;

/**
 *
 * @author evanl
 */
@Service
public class UsuarioWebServiceImpl implements UsuarioWebService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public ResponseFrontModel crearUsuarioInvitado() {
        ResponseFrontModel response = new ResponseFrontModel();
        UsuarioWeb usu = new UsuarioWeb();
        Query query = new Query();
        String select = "select max(id) + 1 from ecommerce.usuario_web";
        query.select.set(select);
        try {
            Object[][] rs = query.initResultSet();
            if (rs.length == 0) {
                response.setStatus("error");
                response.setMenssage("Error al crear sesión");
                return response;
            }
            UsuarioWeb usuarioWeb = new UsuarioWeb();
            usuarioWeb.setNombres("Invitado " +   rs[0][0]);
            usuarioWeb.setTipo("I");
            usuarioWeb.setCreacion(new Date());
            CRUD.save(usuarioWeb);
            select = "select max(id) from ecommerce.usuario_web";
            query.select.set(select);
            rs = query.initResultSet();
            if (rs.length == 0) {
                response.setStatus("error");
                response.setMenssage("Error al crear sesión");
                return response;
            }
            response.setStatus("success");
            response.setMenssage("Sesión creada");
            response.setUsuario(rs[0][0]+"");
            return response;
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            response.setStatus("error");
            response.setMenssage(ex.toString());
            return response;
        }
    }

    @Override
    public ResponseFrontModel registrar(UsuarioWeb usuarioWeb) {
        ResponseFrontModel response = new ResponseFrontModel();
        SendMail mailUtil = new SendMail(javaMailSender);
        if(!validarEmail(usuarioWeb.email)){
            try {
                String key = generar_key();
                usuarioWeb.setVerificado(false);
                usuarioWeb.setActivo(false);
                usuarioWeb.setTipo("U");
                usuarioWeb.setCreacion(new Date());
                usuarioWeb.setKey_verificar(key);
                usuarioWeb.setPassword(cifrarClave(usuarioWeb.getPassword()));
                CRUD.update(usuarioWeb);
                response.setStatus("success");
                response.setMenssage("Creación exitosa");
                mailUtil.verificarEmail(usuarioWeb.getNombres(), key, usuarioWeb.getEmail());
                return response;
            } catch (Exception ex) {
                Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                response.setStatus("error");
                response.setMenssage(ex.toString());
                return response;
            }
        } else {
            response.setStatus("error");
            response.setMenssage("El email ingresado ya está siendo utilizado");
            return response;
        }
    }

    @Override
    public ResponseFrontModel registrarConCupon(UsuarioWeb usuarioWeb, Integer cuponId) {
        ResponseFrontModel response = new ResponseFrontModel();
        SendMail mailUtil = new SendMail(javaMailSender);
        if(!validarEmail(usuarioWeb.email)){
            try {
                String key = generar_key();
                usuarioWeb.setVerificado(false);
                usuarioWeb.setActivo(false);
                usuarioWeb.setTipo("U");
                usuarioWeb.setCreacion(new Date());
                usuarioWeb.setKey_verificar(key);
                usuarioWeb.setPassword(cifrarClave(usuarioWeb.getPassword()));
                CRUD.update(usuarioWeb);
                response.setStatus("success");
                response.setMenssage("Creación exitosa");

                Cupones cup = Services.getCuponService().find_Cupon_ById(cuponId.toString());
                UsuarioWeb us = Services.getUsuarioWeb().find_UsuWeb_byId(usuarioWeb.getId().toString());

                UsuariosCupones usuCup = new UsuariosCupones();

                usuCup.setUsuariow(us);
                usuCup.setUtilizado(false);
                usuCup.setCupon(cup);
                CRUD.save(usuCup);
                mailUtil.verificarEmail(usuarioWeb.getNombres(), key, usuarioWeb.getEmail());
                return response;
            } catch (Exception ex) {
                Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                response.setStatus("error");
                response.setMenssage(ex.toString());
                return response;
            }
        } else {
            response.setStatus("error");
            response.setMenssage("El email ingresado ya está siendo utilizado");
            return response;
        }
    }

    @Override
    public UsuarioWeb registrarFirebase(UsuarioWeb usuarioWeb) {
        ResponseFrontModel response = new ResponseFrontModel();
        try {
            String key = generar_key();
            usuarioWeb.setVerificado(true);
            usuarioWeb.setActivo(true);
            usuarioWeb.setTipo("U");
            usuarioWeb.setKey_verificar(key);
            usuarioWeb.setPassword(cifrarClave(usuarioWeb.getPassword()));
            CRUD.update(usuarioWeb);
            return usuarioWeb;
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            response.setStatus("error");
            response.setMenssage(ex.toString());
            return null;
        }
    }

    @Override
    public UsuarioWeb registrarFirebaseCupon(UsuarioWeb usuarioWeb, Integer cuponId) {
        ResponseFrontModel response = new ResponseFrontModel();
        try {
            String key = generar_key();
            usuarioWeb.setVerificado(true);
            usuarioWeb.setActivo(true);
            usuarioWeb.setTipo("U");
            usuarioWeb.setKey_verificar(key);
            usuarioWeb.setPassword(cifrarClave(usuarioWeb.getPassword()));
            CRUD.update(usuarioWeb);

            Cupones cup = Services.getCuponService().find_Cupon_ById(cuponId.toString());
            UsuarioWeb us = Services.getUsuarioWeb().find_UsuWeb_byId(usuarioWeb.getId().toString());

            UsuariosCupones usuariosCupones = new UsuariosCupones();
            usuariosCupones.setCupon(cup);
            usuariosCupones.setUtilizado(false);
            usuariosCupones.setUsuariow(us);
            CRUD.save(usuariosCupones);
            return usuarioWeb;
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            response.setStatus("error");
            response.setMenssage(ex.toString());
            return null;
        }
    }

    @Override
    public boolean validarEmail(String email) {
        UsuarioWeb list = new UsuarioWeb();

        Query query = new Query();
        String select = "select id from ecommerce.usuario_web";
        query.select.set(select);
        query.where = "where upper(email) = upper('" + email + "')";
        query.end = "";
        try {
            Object[][] rs = query.initResultSet();
            if (rs.length == 0) {
                return false;
            }
            return true;

        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public ResponseFrontModel confirmarEmail(String key) {
        ResponseFrontModel response = new ResponseFrontModel();

        Query query = new Query();
        String select = "select nombres, email from ecommerce.usuario_web";
        query.select.set(select);
        query.where = "where upper(key_verificar) = upper('" + key + "')";
        query.end = "";
        try {
            Object[][] rs = query.initResultSet();
            if (rs.length == 0) {
                response.setStatus("error");
                response.setMenssage("Hubo un error al confirmar tu correo, valida tus datos");
                return response;
            }
            UsuarioWeb usu =  new UsuarioWeb();
            usu = (UsuarioWeb) CRUD.list(UsuarioWeb.class, (" where key_verificar = '" + key + "'")).get(0);
            usu.setVerificado(true);
            usu.setActivo(true);
            CRUD.update(usu);
            response.setStatus("success");
            response.setMenssage("Hola " + rs[0][0] + " tu correo "+ rs[0][1] +" ha sido verificado");
            return response;

        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.setStatus("error");
        response.setMenssage("Hubo un error al confirmar tu correo, valida tus datos");
        return response;
    }

    @Override
    public ResponseFrontModel validarReestContraseña(String email, String key) {
        ResponseFrontModel response = new ResponseFrontModel();

        Query query = new Query();
        String select = "select nombres, email from ecommerce.usuario_web";
        query.select.set(select);
        query.where = "where key_reset_passw = '" + key + "' and upper(email) = upper( '" + email + "') and key_reset_caduca >= now()";
        query.end = "";
        try {
            Object[][] rs = query.initResultSet();
            if (rs.length == 0) {
                response.setStatus("error");
                response.setMenssage("Hubo un error al reestablecer su contraseña, el link ha caducado. Puede volver a pedir reestablecimiento de contraseña, recuerde que el link de reestablecimiento solo dura 24 horas.");
                return response;
            }
         /*   UsuarioWeb usu =  new UsuarioWeb();
            usu = (UsuarioWeb) CRUD.list(UsuarioWeb.class, (" where upper(email) = upper('" + email + "')")).get(0);
            usu.setKey_reset_passw("");
            usu.setKey_reset_caduca(new Date());
            CRUD.update(usu);*/
            response.setStatus("success");
            response.setMenssage("Validación OK");
            return response;

        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.setStatus("error");
        response.setMenssage("Hubo un error al reestablecer su contraseña, el link ha caducado. Puede volver a pedir reestablecimiento de contraseña, recuerde que el link de reestablecimiento solo dura 24 horas.");
        return response;
    }

    @Override
    public ResponseFrontModel cambiarPasswEmail(CambiarPassw cambiarPassw) {
        ResponseFrontModel response = new ResponseFrontModel();
        List<UsuarioWeb> usuWeb = new ArrayList<>();
        try {
            usuWeb = CRUD.list(UsuarioWeb.class, (" where upper(email) = upper('" + cambiarPassw.getEmail() + "') and activo = true and verificado = true" ));
            if(usuWeb.size() == 0){
                response.setStatus("error");
                response.setMenssage("Usuario no existe");
                return response;
            }

            UsuarioWeb usuReg = usuWeb.get(0);
            usuReg.setPassword(cifrarClave(cambiarPassw.getPasswNuevo()));
            usuReg.setKey_reset_passw("");
            usuReg.setKey_reset_caduca(new Date());
            CRUD.update(usuReg);

            response.setStatus("success");
            response.setMenssage("Su contraseña a sido actualizada.");
            return response;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public UsuarioWeb login(String usuario, String passw) {
        List<UsuarioWeb> usuWeb = new ArrayList<>();
        try {
            usuWeb = CRUD.list(UsuarioWeb.class, (" where upper(email) = upper('" + usuario + "') and activo = true and verificado = true" ));
            if(usuWeb.size() == 0)
                return null;
            UsuarioWeb usuReg = usuWeb.get(0);
            if(validarClave(passw, usuReg.getPassword()))
                return usuWeb.get(0);
            else
                return null;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public UsuarioWeb loginFirebase(String usuario) {
        List<UsuarioWeb> usuWeb = new ArrayList<>();
        try {
            usuWeb = CRUD.list(UsuarioWeb.class, (" where upper(email) = upper('" + usuario + "') and activo = true and verificado = true" ));
            if(usuWeb.size() == 0)
                return null;
            UsuarioWeb usuReg = usuWeb.get(0);
            return usuReg;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public ResponseFrontModel validarEmailActivo(String usuario, String passw) {
        List<UsuarioWeb> usuWeb = new ArrayList<>();
        ResponseFrontModel respose = new ResponseFrontModel();
        try {
            usuWeb = CRUD.list(UsuarioWeb.class, (" where upper(email) = upper('" + usuario + "')" ));
            if(usuWeb.size() == 0){
                respose.setStatus("error");
                respose.setMenssage("Usuario no registrado.");
                return respose;
            }

            UsuarioWeb usuReg = usuWeb.get(0);
            System.out.println(usuReg.toString());
            if(usuReg.getVerificado()){
                respose.setStatus("success");
                respose.setMenssage("Usuario OK.");
            } else {
                respose.setStatus("error");
                respose.setMenssage("Usuario no verificado, por favor revise su correo y verifique su cuenta.");
            }
            return respose;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return respose;
    }

    @Override
    public ResponseFrontModel resetPassword(String email) {
        SendMail mailUtil = new SendMail(javaMailSender);
        ResponseFrontModel respose = new ResponseFrontModel();
        String newPassw = generar_password();
        UsuarioWeb usu =  new UsuarioWeb();
        try{
            usu = (UsuarioWeb) CRUD.list(UsuarioWeb.class, (" where upper(email) = upper('" + email + "')")).get(0);
            usu.setPassword(cifrarClave(newPassw));
            CRUD.update(usu);
            mailUtil.resetPassword(usu.getNombres(), newPassw, usu.getEmail());
            respose.setStatus("success");
            respose.setMenssage("Se ha enviado una nueva contraseña a tu correo: " + email + ".");
            return respose;

        }  catch (Exception e) {
            e.printStackTrace();
            respose.setStatus("error");
            respose.setMenssage("Ocurrió un error al resetear tu contraseña, intenta nuevamente.");
            return respose;
        }
    }

    @Override
    public ResponseFrontModel resetPassword2(String email) {
        SendMail mailUtil = new SendMail(javaMailSender);
        ResponseFrontModel respose = new ResponseFrontModel();
        String key_reset = generar_key();
        UsuarioWeb usu =  new UsuarioWeb();
        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DATE, 1);
        dt = c.getTime();
//        LocalDateTime.from(dt.toInstant()).plusDays(1);
        try{
            usu = (UsuarioWeb) CRUD.list(UsuarioWeb.class, (" where upper(email) = upper('" + email + "')")).get(0);
            usu.setKey_reset_passw(key_reset);
            usu.setKey_reset_caduca(dt);
            CRUD.update(usu);
            mailUtil.resetPassword(usu.getNombres(), key_reset, usu.getEmail());
            respose.setStatus("success");
            respose.setMenssage("Se ha enviado un mail a " + email + " para reestablecer su contraseña.");
            return respose;

        }  catch (Exception e) {
            e.printStackTrace();
            respose.setStatus("error");
            respose.setMenssage("Ocurrió un error al resetear tu contraseña, intenta nuevamente.");
            return respose;
        }
    }

    @Override
    public Integer saveCart(SaveCart saveCart) {
        System.out.println(saveCart.getCods());
        int count = 0;
        String[] cods = saveCart.getCods().split(",");
        for(int i=0; i < cods.length; i++){
            System.out.println(cods[i]);
            Cart cart = new Cart();
            cart.setActivo(true);
            cart.setProducto_id(Integer.parseInt(cods[i]));
            cart.setUsuariow_id(saveCart.getUsuariow_id());
            try {
                CRUD.save(cart);
                count++;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return count;
    }

    @Override
    public Integer saveWish(SaveCart saveFav) {
        System.out.println(saveFav.getCods());
        int count = 0;
        String[] cods = saveFav.getCods().split(",");
        for(int i=0; i < cods.length; i++){
            System.out.println(cods[i]);
            Favoritos fav = new Favoritos();
            fav.setActivo(true);
            fav.setProducto_id(Integer.parseInt(cods[i]));
            fav.setUsuariow_id(saveFav.getUsuariow_id());
            try {
                CRUD.save(fav);
                count++;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return count;
    }

    @Override
    public ResponseFrontModel changePassword(CambiarPassw cambiarPassw) {
        ResponseFrontModel response = new ResponseFrontModel();
        List<UsuarioWeb> usuWeb = new ArrayList<>();
        try {
            usuWeb = CRUD.list(UsuarioWeb.class, (" where id = " + cambiarPassw.getUsuariow_id() + " and activo = true and verificado = true" ));
            if(usuWeb.size() == 0){
                response.setStatus("error");
                response.setMenssage("Usuario no existe");
                return response;
            }

            UsuarioWeb usuReg = usuWeb.get(0);
            if(validarClave(cambiarPassw.getPasswActual(), usuReg.getPassword())){
                usuReg.setPassword(cifrarClave(cambiarPassw.getPasswNuevo()));
                CRUD.update(usuReg);
                response.setStatus("success");
                response.setMenssage("Su contraseña a sido actualizada.");
                return response;

            } else{
                response.setStatus("error");
                response.setMenssage("Contraseña actual no coincide.");
                return response;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public ResponseFrontModel suscribirseConPromo(SuscripcionModel suscripcion, Integer idPromo) {
        System.out.println(suscripcion.toString());
//        System.out.println(new SimpleDateFormat("MM-dd-yyyy").format(suscripcion.getFecha_nacimiento()));
        SendMail mailUtil = new SendMail(javaMailSender);
        Suscripcion newSuscrip = new Suscripcion();
        ResponseFrontModel response = new ResponseFrontModel();
        List<Suscripcion> suscripcions = new ArrayList<>();
        List<Cupones> cuponesList = new ArrayList<>();
        try {
            suscripcions = CRUD.list(Suscripcion.class, (" where email = '" + suscripcion.getEmail() + "'" ));
            if(suscripcions.size() >= 1){
                response.setStatus("error");
                response.setMenssage("El correo ingresado ya está suscrito.");
                return response;
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus("error");
            response.setMenssage(e.getMessage());
            return response;

        }

        newSuscrip.setCreacion(new Date());
        newSuscrip.setActivo(true);
        try {
            Calendar cal = Calendar.getInstance();
            Promocion promo = (Promocion) CRUD.list(Promocion.class, (" where id = " + idPromo + " and activo = true")).get(0);
            Cupones cupones = new Cupones();
            if(promo.getVigencia_cupon()  != null){
                cal.setTime(new Date());
                cal.add(Calendar.DATE, promo.getVigencia_cupon());
                cupones.setFechaFinVigencia(cal.getTime());
            } else {
                cupones.setFechaFinVigencia(promo.getFecha_limite());
            }
           //minus number would decrement the days

            cupones.setActivo(true);
            cupones.setNombreCupon(generarCuponSuscripcion(promo.getPrefijo()));
            cupones.setMonto(promo.getCupon_monto());
            cupones.setFechaIniVigencia(new Date());
            cupones.setCantidad(1);
            cupones.setPrecioMinProd(promo.getMonto_min());
            CRUD.save(cupones);
            //------------------ Insert Cupon Nuevo ----------------------------
            Cupones cupones1db = (Cupones) CRUD.list(Cupones.class, (" where nombre_cupon = '" + cupones.getNombreCupon() + "'" )).get(0);
            newSuscrip.setCupon(cupones1db);
            //------------------------------------------------------------------
            newSuscrip.setEmail(suscripcion.getEmail());
            newSuscrip.setTelefono(suscripcion.getTelefono());
            newSuscrip.setNombre(suscripcion.getNombre());
            LocalDate localDate = LocalDate.parse(suscripcion.getFecha_nacimiento());
            Date fecha = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

//            newSuscrip.setFecha_nacimiento(new Date(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli()));
            newSuscrip.setFecha_nacimiento(suscripcion.getFecha_nacimiento());
            CRUD.save(newSuscrip);
            mailUtil.mailConCuponPorSuscripcion(suscripcion.getNombre(), cupones.getNombreCupon(), suscripcion.getEmail(), cupones.getFecha_fin_vigencia(), cupones.getPrecioMinProd(), cupones.getMonto());
            response.setStatus("success");
            response.setMenssage("Suscripción correcta, revise su email para hacer efectivo su descuento.");
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus("error");
            response.setMenssage(e.getMessage());
            return response;
        }
    }

    private String generarCuponSuscripcion(String prefijo){
        char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".toCharArray();
        StringBuilder sb = new StringBuilder(20);
        Random random = new Random();
        for (int i = 0; i < 7; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        return prefijo + sb.toString();

    }

    private String generar_key(){
        char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890".toCharArray();
        StringBuilder sb = new StringBuilder(20);
        Random random = new Random();
        for (int i = 0; i < 32; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        return sb.toString();
    }

    private String generar_password(){
        char[] chars = "abcdefghijklmnopqrstuvwxyz1234567890".toCharArray();
        StringBuilder sb = new StringBuilder(20);
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        return sb.toString();
    }

    //Function to encrypt password
    private static String cifrarClave(String clave) {
        PooledStringDigester digester = new PooledStringDigester();
        digester.setPoolSize(4);
        digester.setAlgorithm("SHA-1");
        digester.setIterations(50000);
        digester.setSaltSizeBytes(32);

        //String return is hash that I save into db
        return digester.digest(clave);
    }

    //Function to decrypt password
    //clave is old plain that user enter from UI and I want to compare from hash save it into db
    private static boolean validarClave(String clave, String hash) {
        PooledStringDigester digester = new PooledStringDigester();
        digester.setPoolSize(4);
        digester.setAlgorithm("SHA-1");
        digester.setIterations(50000);
        digester.setSaltSizeBytes(32);

        return digester.matches(clave, hash);
    }
    
    //-------------------------------------------------------------------------------------------
    //CPANEL
    //-------------------------------------------------------------------------------------------
    @Override
    public UsuarioWeb find_UsuWeb_byId(String id_usu_web){
        UsuarioWeb usu_web = new UsuarioWeb();
        List<UsuarioWeb> result = new ArrayList<>();
        try {
            String where = "where activo is true and id = "+id_usu_web+" limit 1";
            result = CRUD.list(UsuarioWeb.class,where);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioWebServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(!result.isEmpty()){
            usu_web = new UsuarioWeb();
            usu_web = result.get(0);
        }
        return usu_web;
    }

    






    //-------------------------------------------------------------------------------------------
    @Override
    public List<UsuarioWeb> find_soloActivos(String nombre) {
        List<UsuarioWeb> result = new ArrayList<>();
        try {
            String where = "where activo is true and (nombres ilike '%"+nombre+"%' or apellidos ilike '%"+nombre+"%') limit 1000";
            result = CRUD.list(UsuarioWeb.class,where);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioWebServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    //-------------------------------------------------------------------------------------------
    @Override
    public List<UsuarioWeb> find_soloNoActivos(String nombre) {
        List<UsuarioWeb> result = new ArrayList<>();
        try {
            String where = "where activo is false and (nombres ilike '%"+nombre+"%' or apellidos ilike '%"+nombre+"%') limit 1000";
            result = CRUD.list(UsuarioWeb.class,where);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioWebServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    //-------------------------------------------------------------------------------------------
    @Override
    public List<UsuarioWeb> find_UsubyFechas(Date fecha_ini, Date fecha_fin){
        List<UsuarioWeb> result = new ArrayList<>();
        try {
            String where = "where a.activo is true and a.creacion between '"+fecha_ini+"' and '"+fecha_fin+"'";
            result = CRUD.list(UsuarioWeb.class,where);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioWebServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    //-------------------------------------------------------------------------------------------
    //GET DIR_ENTREGA
    
    
    //-------------------------------------------------------------------------------------------
    //GET NOTAPED_BY_DIRENTREGA
    
    public List<NotaPedidoCab> getPedby_dirEntrega(String dir_entrega_id){
        List<NotaPedidoCab> l_npcab = new ArrayList<>();
        try {
            String where = "where b.id = " + dir_entrega_id + " order by a.fecha desc limit 10";
            String [] require = {"direccion_Ecommerce","cupon","formaPago"};
            l_npcab = CRUD.list(NotaPedidoCab.class,require,where);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioWebServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l_npcab;
    }
    //-------------------------------------------------------------------------------------------
    @Override
    public List<UsuarioWeb> find_UsuComp(Date fecha_ini, Date fecha_fin){
        List<UsuarioWeb> result = new ArrayList<>();
        UsuarioWeb usuweb = new UsuarioWeb();
        
        List<DirEntrega> l_dirEcom = new ArrayList<>();
        DirEntrega dirEcom = new DirEntrega();
        
        List<NotaPedidoCab> l_npcab = new ArrayList<>();
        try {
            String where = "where a.aprobada is true and a.vendedor_id = '"+ Server.VENDEDOR_ECOMMERCE_ID + "' and a.creado between '"+fecha_ini+"' and '"+fecha_fin+"' order by a.id asc limit 1000";
            String [] require = {"direccionCliente","direccion_Ecommerce","direccion_Ecommerce.usuario_web"};
            l_npcab = CRUD.list(NotaPedidoCab.class,require,where);
            if(!l_npcab.isEmpty()){
                for(int i = 0 ; i < l_npcab.size(); i++){
                    dirEcom = new DirEntrega();
                    if(l_npcab.get(i).getDireccion_Ecommerce() != null){
                        dirEcom = l_npcab.get(i).getDireccion_Ecommerce();
                        
                        usuweb = new UsuarioWeb();
                        usuweb = dirEcom.getUsuario_web();
                        result.add(usuweb);
                    }
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(UsuarioWebServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    //-------------------------------------------------------------------------------------------
    @Override
    public List<UsuarioWeb> find_UsubySucursal(Date fecha_ini, Date fecha_fin,String id_almacen){
        List<UsuarioWeb> result = new ArrayList<>();
        UsuarioWeb usuweb = new UsuarioWeb();
        
        List<DirEntrega> l_dirEcom = new ArrayList<>();
        DirEntrega dirEcom = new DirEntrega();
        
        List<NotaPedidoCab> l_npcab = new ArrayList<>();
        try {
            String where = "where a.aprobada is true and a.vendedor_id = '"+ Server.VENDEDOR_ECOMMERCE_ID + "' and a.almacen_id = '" +id_almacen+ "' and a.creado between '"+fecha_ini+"' and '"+fecha_fin+"' order by a.id asc limit 1000";
            String [] require = {"direccionCliente","direccion_Ecommerce","direccion_Ecommerce.usuario_web"};
            l_npcab = CRUD.list(NotaPedidoCab.class,require,where);
            if(!l_npcab.isEmpty()){
                for(int i = 0 ; i < l_npcab.size(); i++){
                    dirEcom = new DirEntrega();
                    if(l_npcab.get(i).getDireccion_Ecommerce() != null){
                        dirEcom = l_npcab.get(i).getDireccion_Ecommerce();
                        
                        usuweb = new UsuarioWeb();
                        usuweb = dirEcom.getUsuario_web();
                        result.add(usuweb);
                    }
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(UsuarioWebServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    //-------------------------------------------------------------------------------------------
    @Override
    public List<Almacen> get_Almacenes(){
        List<Almacen> result = new ArrayList<>();
        try {
            String where = "where a.inactivo is false and a.abreviatura <> '"+"' order by a.id asc limit 1000";
            result = CRUD.list(Almacen.class,where);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioWebServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    //-------------------------------------------------------------------------------------------
    @Override
    public Almacen find_AlmacenbyName(String almacen_name){
        Almacen result = new Almacen();
        List<Almacen> L_Almacen = new ArrayList<>();
        try {
            String where = "where a.abreviatura = '"+almacen_name+"' limit 1";
            L_Almacen = CRUD.list(Almacen.class,where);
            if(!L_Almacen.isEmpty()){
                result = L_Almacen.get(0);
            }
        } catch (Exception ex) {
            Logger.getLogger(UsuarioWebServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    //-------------------------------------------------------------------------------------------
    @Override
    public void save_UsuarioWeb(UsuarioWeb registro_web) {
        try {
            CRUD.save(registro_web);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioWebServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //-------------------------------------------------------------------------------------------
    @Override
    public void update_UsuarioWeb(UsuarioWeb registro_web) {
        try {
            CRUD.update(registro_web);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioWebServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //-------------------------------------------------------------------------------------------
    @Override
    public void delete_UsuarioWeb(UsuarioWeb registro_web) {
        try {
            CRUD.delete(registro_web);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioWebServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //-------------------------------------------------------------------------------------------
    @Override
    public List<Integer> get_Function_Ventas(){
        List<Integer> L_Ventas = new ArrayList<>();
        Integer ventas_ecom = 0;
        Integer ventas_otros = 0;
        Query query = new Query();
        String select = "select * from ecommerce.test4('2020-05-24','2020-08-30')";
        query.select.set(select);
        query.where = "";
        query.end = "";
        try {
            Object[][] rs = null; 
            rs = query.initResultSet();
            if (rs != null || rs.length == 0){
                System.out.println("Obtener Funcion Ventas");
                ventas_ecom = (Integer) rs[0][1];
                ventas_otros = (Integer) rs[1][1];
            }
            else {
                ventas_ecom = 0;
                ventas_otros = 0;
            }
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Ventas Ecommerce : " + ventas_ecom);
        System.out.println("Ventas Otros : " + ventas_otros);
        L_Ventas.add(ventas_ecom);
        L_Ventas.add(ventas_otros);
        return L_Ventas;
    }
    //-------------------------------------------------------------------------------------------
    
    //-------------------------------------------------------------------------------------------
    //SUBSCRIPTORES
    //-------------------------------------------------------------------------------------------
    @Override
    public List<Suscripcion> find_SubsbyFecha(Date fecha_ini, Date fecha_fin){
        List<Suscripcion> result = new ArrayList<>();
        List<UsuarioWeb> find_list = new ArrayList<>();
        try {
            String where = "where a.activo is true and a.creacion between '"+fecha_ini+"' and '"+fecha_fin+"'";
            String [] require = {"usuariow","cupon"};
            result = CRUD.list(Suscripcion.class,require,where);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioWebServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    //-------------------------------------------------------------------------------------------
    //PUNTOS UP
    //-------------------------------------------------------------------------------------------
    @Override
    public PuntosUp get_PuntosUpbyUserWeb(String usuweb_id){
        PuntosUp p_result = new PuntosUp();
        List<PuntosUp> result = new ArrayList<>();
        try {
            String where = "where a.activo is true and a.usuariow_id = '"+ usuweb_id +"' order by a.id desc limit 1";
            String [] require = {"usuariow"};
            result = CRUD.list(PuntosUp.class,require,where);
            if(!result.isEmpty()){
                p_result = new PuntosUp();
                p_result = result.get(0);
            }
        } catch (Exception ex) {
            Logger.getLogger(UsuarioWebServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p_result;
    }




    @Override
    public BannerOb get_BannerByID(Integer idban){
        BannerOb p_result = new BannerOb();
        List<BannerOb> result = new ArrayList<>();
        try {
            String where = "where  a.id = '"+ idban +"' ";
            result = CRUD.list(BannerOb.class,where);
            if(!result.isEmpty()){
                p_result = new BannerOb();
                p_result = result.get(0);
            }
        } catch (Exception ex) {
            Logger.getLogger(UsuarioWebServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p_result;
    }









    //-------------------------------------------------------------------------------------------
    @Override
    public List<PuntosUp> find_PuntosUPActivos(){
        List<PuntosUp> result = new ArrayList<>();
        List<UsuarioWeb> find_usuweb = new ArrayList<>();
        PuntosUp p_result = new PuntosUp();
        try {
            //GET USERWEB
            String where = "where a.activo is true order by a.id desc limit 1000";
            find_usuweb = CRUD.list(UsuarioWeb.class,where);
            
            //GET PUNTOS UP - BY USER WEB
            for(int i = 0; i < find_usuweb.size();i++){
                p_result = new PuntosUp();
                p_result = get_PuntosUpbyUserWeb(String.valueOf(find_usuweb.get(i).getId()));
                result.add(p_result);
            }
        } catch (Exception ex) {
            Logger.getLogger(UsuarioWebServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    //-------------------------------------------------------------------------------------------
    @Override
    public List<PuntosUp> find_PuntosUPbyFecha(Date fecha_ini, Date fecha_fin){
        List<PuntosUp> result = new ArrayList<>();
        List<UsuarioWeb> find_usuweb = new ArrayList<>();
        PuntosUp p_result = new PuntosUp();
        try {
            //GET USERWEB
            String where = "where a.activo is true and a.creacion between '"+fecha_ini+"' and '"+fecha_fin+"'";
            find_usuweb = CRUD.list(UsuarioWeb.class,where);
            //GET PUNTOS UP - BY USER WEB
            for(int i = 0; i < find_usuweb.size();i++){
                p_result = new PuntosUp();
                p_result = get_PuntosUpbyUserWeb(String.valueOf(find_usuweb.get(i).getId()));
                result.add(p_result);
            }
        } catch (Exception ex) {
            Logger.getLogger(UsuarioWebServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    //-------------------------------------------------------------------------------------------
    @Override
    public void update_PuntosUP(PuntosUp n_puntosup){
        try {
            CRUD.update(n_puntosup);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioWebServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update_Banner(BannerOb banner){
        try {
            CRUD.update(banner);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioWebServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Override
    public void update_Programacion(ProgramOB prog){
        try {
            CRUD.update(prog);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioWebServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }







    //-------------------------------------------------------------------------------------------
    //CATALOGO PUNTOS UP
    //-------------------------------------------------------------------------------------------
    @Override
    public void insert_CatalogoPtsUP(CatalogoPuntosUp n_catalogo){
        try {
            CRUD.save(n_catalogo);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioWebServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



    @Override
    public void insert_banner(BannerOb n_catalogo){
        try {
            CRUD.save(n_catalogo);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioWebServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    

    @Override
    public void insert_Programacion(ProgramOB n_catalogo){
        try {
            CRUD.save(n_catalogo);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioWebServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   


    //-------------------------------------------------------------------------------------------
    @Override
    public void delete_CatalogoPtsUP(CatalogoPuntosUp n_catalogo){
        try {
            CRUD.delete(n_catalogo);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioWebServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete_Banner(BannerOb n_catalogo){
        try {
            CRUD.delete(n_catalogo);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioWebServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete_prog(ProgramOB prog){
        try {
            CRUD.delete(prog);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioWebServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



    



    //-------------------------------------------------------------------------------------------
    @Override
    public void update_CatalogoPtsUP(CatalogoPuntosUp n_catalogo){
        try {
            CRUD.update(n_catalogo);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioWebServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //-------------------------------------------------------------------------------------------
    @Override
    public CatalogoPuntosUp get_CatalogoActivo(){
        CatalogoPuntosUp catalogo = new CatalogoPuntosUp();
        List<CatalogoPuntosUp> result = new ArrayList<>();
        try {
            String where = "where a.activo is true order by a.id asc limit 1";
            result = CRUD.list(CatalogoPuntosUp.class,where);
            if(!result.isEmpty()){
                catalogo = new CatalogoPuntosUp();
                catalogo = result.get(0);
            }
        } catch (Exception ex) {
            Logger.getLogger(UsuarioWebServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return catalogo;
    }
    //-------------------------------------------------------------------------------------------
    
    
    @Override
    public List<CatalogoPuntosUp> find_Catalogos(){
        List<CatalogoPuntosUp> result = new ArrayList<>();
        try {
            String where = "order by a.id asc limit 1000";
            result = CRUD.list(CatalogoPuntosUp.class,where);
            if(result == null){
                result = new ArrayList<>();
            }
        } catch (Exception ex) {
            Logger.getLogger(UsuarioWebServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public List<BannerOb> find_Banners(){
        List<BannerOb> result = new ArrayList<>();
        try {
            String where = "order by id";
            result = CRUD.list(BannerOb.class,where);
            if(result == null){
                result = new ArrayList<>();
            }
        } catch (Exception ex) {
            Logger.getLogger(UsuarioWebServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }


    @Override
    public List<ProgramOB> find_Programacion(){
        List<ProgramOB> result = new ArrayList<>();
        try {
            String where = "order by id_linea desc";
            result = CRUD.list(ProgramOB.class,where);
            if(result == null){
                result = new ArrayList<>();
            }
        } catch (Exception ex) {
            Logger.getLogger(UsuarioWebServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    


    



    @Override
    public List<Linea> find_Lineas(){
        List<Linea> result = new ArrayList<>();
        try {
            String where = "order by id";
            result = CRUD.list(Linea.class,where);
            if(result == null){
                result = new ArrayList<>();
            }
        } catch (Exception ex) {
            Logger.getLogger(UsuarioWebServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }








    
    
    
    
    //-------------------------------------------------------------------------------------------
}
