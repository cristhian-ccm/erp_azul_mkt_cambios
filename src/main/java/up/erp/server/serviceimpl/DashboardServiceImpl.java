/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.server.serviceimpl;

import com.upgrade.persistence.model.ecommerce.CartDashboard;
import com.upgrade.persistence.model.ecommerce.VentasporMesModel;
import java.math.BigDecimal;
import org.springframework.stereotype.Service;
import ts.com.service.util.db.Query;
import up.erp.service.DashboardService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luis Aleman
 */
@Service
public class DashboardServiceImpl implements DashboardService{
    
    //--------------------------------- VENTAS ECOMMERCE / VENTA OTROS ----------------------------------
    @Override
    public List<Integer> get_Function_Ventas(){
        List<Integer> L_Ventas = new ArrayList<>();
        Integer ventas_ecom = 0;
        Integer ventas_otros = 0;
        Query query = new Query();
        String select = "select * from ecommerce.test4('2020-05-24','2020-12-30')";
        query.select.set(select);
        query.where = "";
        query.end = "";
        try {
            Object[][] rs = null; 
            rs = query.initResultSet();
            if (rs != null || rs.length == 0){
                System.out.println("VENTAS ECOMMERCE / OTRAS VENTAS");
                ventas_ecom = (Integer) rs[0][1];
                ventas_otros = (Integer) rs[1][1];
            }
            else {
                ventas_ecom = 0;
                ventas_otros = 0;
            }
        } catch (Exception ex) {
            Logger.getLogger(DashboardServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Ventas Ecommerce : " + ventas_ecom);
        System.out.println("Ventas Otros : " + ventas_otros);
        L_Ventas.add(ventas_ecom);
        L_Ventas.add(ventas_otros);
        return L_Ventas;
    }
    
    
    //--------------------------------- VISITAS INVITADOS / REGISTRADOS ----------------------------------
    
    
    @Override
    public List<Integer> get_count_visits(){
        List<Integer> L_Visits = new ArrayList<>();
        Integer v_invitados = 0;
        Integer v_registrados = 0;
        
        Query query = new Query();
        String select = "SELECT * from ecommerce.count_visits()";
        query.select.set(select);
        query.where = "";
        query.end = "";
        try {
            Object[][] rs = null; 
            rs = query.initResultSet();
            if (rs != null || rs.length == 0){
                System.out.println("VISITAS INVITADOS / REGISTRADOS");
                v_invitados = (Integer) rs[0][1];
                v_registrados = (Integer) rs[1][1];
            }
            else {
                v_invitados = 0;
                v_registrados = 0;
            }
        } catch (Exception ex) {
            Logger.getLogger(DashboardServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Cant. Invitados: " + v_invitados);
        System.out.println("Cant. Registrados: " + v_registrados);
        L_Visits.add(v_invitados);
        L_Visits.add(v_registrados);
        return L_Visits;
    }
    
    //------------------------------- TOTAL VENTAS ECOMMERCE POR FECHAS --------------------------------
    @Override
    public Double get_total_ventas_ecommerce_fechas(){
        Double result = 0.0;
        Query query = new Query();
        String select = "SELECT * from ecommerce.total_ventas_ecommerce_fechas('2020-05-24','2020-12-30')";
        query.select.set(select);
        query.where = "";
        query.end = "";
        try {
            Object[][] rs = null; 
            rs = query.initResultSet();
            if (rs != null || rs.length == 0){
                System.out.println("TOTAL VENTAS ECOMMERCE 2020 (FECHA ACTUAL)");
                result = ((BigDecimal) rs[0][0]).doubleValue();
            }
            else {
                result = 0.0;
            }
        } catch (Exception ex) {
            Logger.getLogger(DashboardServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Total Ventas Ecommerce 2020 : " + result);
        return result;
    }
    
    //------------------------------- VENTAS ECOMMERCE ULTIMOS 6 MESES --------------------------------
    @Override
    public List<VentasporMesModel> get_ventas_last6_month(){
        List<VentasporMesModel> L_Ventas = new ArrayList<>();
        VentasporMesModel venta_mes = new VentasporMesModel();
        Integer mes;
        Integer anio;
        Double total_ventas;
        Query query = new Query();
        String select = "SELECT * from ecommerce.ventas_last6_month()";
        query.select.set(select);
        query.where = "";
        query.end = "";
        try {
            Object[][] rs = null; 
            rs = query.initResultSet();
            if (rs != null || rs.length == 0){
                System.out.println("VENTAS ULTIMOS 6 MESES");
                for (int i = 0; i < rs.length; i++){
                    venta_mes = new VentasporMesModel();
                    mes = (Integer) rs[i][0]; 
                    anio = (Integer) rs[i][1];
                    total_ventas = ((BigDecimal) rs[i][2]).doubleValue();
                    venta_mes.set_Mes(mes);
                    venta_mes.set_Año(anio);
                    venta_mes.set_Total_Ventas(total_ventas);
                    System.out.println("MES N°: " + mes + ", AÑO: " + anio + ", TOTAL VENTAS: " + total_ventas);
                    L_Ventas.add(venta_mes);
                }
            }
            else {
                mes = 0; 
                anio = 0;
                total_ventas = 0.0;
                venta_mes = new VentasporMesModel();
                venta_mes.set_Mes(mes);
                venta_mes.set_Año(anio);
                venta_mes.set_Total_Ventas(total_ventas);
                L_Ventas.add(venta_mes);
            }
        } catch (Exception ex) {
            Logger.getLogger(DashboardServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return L_Ventas;
    }
    
    //-------------------------------------------------------------------------------------------------
    //FILTROS : BUSQUEDAS
    //-------------------------------------------------------------------------------------------------
    //--------------------------------- VENTAS ECOMMERCE / VENTA OTROS ----------------------------------
    @Override
    public List<Integer> get_Ventas_ByFecha(Date fecha_ini, Date fecha_fin){
        List<Integer> L_Ventas = new ArrayList<>();
        Integer ventas_ecom = 0;
        Integer ventas_otros = 0;
        Query query = new Query();
        String select = "select * from ecommerce.test4('"+fecha_ini+"','"+fecha_fin+"')";
        query.select.set(select);
        query.where = "";
        query.end = "";
        try {
            Object[][] rs = null; 
            rs = query.initResultSet();
            if (rs != null || rs.length == 0){
                System.out.println("VENTAS ECOMMERCE / OTRAS VENTAS");
                ventas_ecom = (Integer) rs[0][1];
                ventas_otros = (Integer) rs[1][1];
            }
            else {
                ventas_ecom = 0;
                ventas_otros = 0;
            }
        } catch (Exception ex) {
            Logger.getLogger(DashboardServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Ventas Ecommerce : " + ventas_ecom);
        System.out.println("Ventas Otros : " + ventas_otros);
        L_Ventas.add(ventas_ecom);
        L_Ventas.add(ventas_otros);
        return L_Ventas;
        //return null;
    }
    
    //--------------------------------- VISITAS INVITADOS / REGISTRADOS ----------------------------------
    public List<Integer> get_count_visits_byFecha(Date fecha_ini, Date fecha_fin){
        List<Integer> L_Visits = new ArrayList<>();
        Integer v_invitados = 0;
        Integer v_registrados = 0;
        
        Query query = new Query();
        String select = "SELECT * from ecommerce.count_visits('"+fecha_ini+"','"+fecha_fin+"')";
        query.select.set(select);
        query.where = "";
        query.end = "";
        try {
            Object[][] rs = null; 
            rs = query.initResultSet();
            if (rs != null || rs.length == 0){
                System.out.println("VISITAS INVITADOS / REGISTRADOS");
                v_invitados = (Integer) rs[0][1];
                v_registrados = (Integer) rs[1][1];
            }
            else {
                v_invitados = 0;
                v_registrados = 0;
            }
        } catch (Exception ex) {
            Logger.getLogger(DashboardServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Cant. Invitados: " + v_invitados);
        System.out.println("Cant. Registrados: " + v_registrados);
        L_Visits.add(v_invitados);
        L_Visits.add(v_registrados);
        return L_Visits;
    }
    
    //------------------------------- TOTAL VENTAS ECOMMERCE POR FECHAS --------------------------------
    @Override
    public Double get_TotalVentas_Ecom_ByFecha(Date fecha_ini, Date fecha_fin){
        Double result = 0.0;
        Query query = new Query();
        String select = "SELECT * from ecommerce.total_ventas_ecommerce_fechas('"+fecha_ini+"','"+fecha_fin+"')";
        query.select.set(select);
        query.where = "";
        query.end = "";
        try {
            Object[][] rs = null; 
            rs = query.initResultSet();
            if (rs != null || rs.length == 0){
                System.out.println("TOTAL VENTAS ECOMMERCE 2020 (FECHA ACTUAL)");
                result = ((BigDecimal) rs[0][0]).doubleValue();
            }
            else {
                result = 0.0;
            }
        } catch (Exception ex) {
            Logger.getLogger(DashboardServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Total Ventas Ecommerce 2020 : " + result);
        return result;
    }
    
    //--------------------------- TOTAL CANTIDAD VECES CARRITO SIN COMPRAR -----------------------------
    @Override
    public Integer get_Cantidad_CarritoCompraUsu(){
        Integer resp = 0;
        Query query = new Query();
        String select = "SELECT * from ecommerce.cantidad_carrito_compra_usu()";
        query.select.set(select);
        query.where = "";
        query.end = "";
        try {
            Object[][] rs = null; 
            rs = query.initResultSet();
            if (rs != null || rs.length == 0){
                System.out.println("CANTIDAD TOTAL VECES CARRITO SIN COMPRAR");
                resp = (Integer) rs[0][0];
            }
            else {
                resp = 0;
            }
        } catch (Exception ex) {
            Logger.getLogger(DashboardServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }
    //-------------------------- DETALLE CANTIDAD VECES CARRITO SIN COMPRAR -----------------------------
    @Override
    public List<CartDashboard> get_Usu_CarritoCompra_detalle(){
        List<CartDashboard> L_Cartdetalle= new ArrayList<>();
        CartDashboard cart_det = new CartDashboard();
        Integer id;
        String producto;
        String nombre;
        String apellidos;
        String email;
        String telefono;
        Integer cantidad;
        Query query = new Query();
        String select = "select p.id, p.nombre, u.nombres, u.apellidos, u.email, u.telefono, COALESCE(c.cantidad, 1) cantidad from ecommerce.cart c\n" +
                        "join extcs.productos p on p.id = c.producto_id\n" +
                        "join ecommerce.usuario_web u on u.id = c.usuariow_id\n" +
                        "where c.activo = true and u.email is not null";
        query.select.set(select);
        query.where = "";
        query.end = "";
        try {
            Object[][] rs = null; 
            rs = query.initResultSet();
            if (rs != null || rs.length == 0){
                System.out.println("DETALLE CANTIDAD VECES CARRITO SIN COMPRAR");
                for(int i=0; i < rs.length; i++){
                    id = (Integer) rs[i][0];
                    
                    if(rs[i][1] != null)        {producto = (String) rs[i][1];}
                    else                        {producto = "";}
                    
                    if(rs[i][2] != null)        {nombre = (String) rs[i][2];}
                    else                        {nombre = "";}
                    
                    if(rs[i][3] != null)        {apellidos = (String) rs[i][3];}
                    else                        {apellidos = "";}
                    
                    if(rs[i][4] != null)        {email = (String) rs[i][4];}
                    else                        {email = "";}
                    
                    if(rs[i][5] != null)        {telefono = (String) rs[i][5];}
                    else                        {telefono = "";}
                    
                    if(rs[i][6] != null)        {cantidad = (Integer) rs[i][6];}
                    else                        {cantidad = 0;}
                    
                    cart_det = new CartDashboard();
                    cart_det.setId(id);
                    cart_det.setProducto(producto);
                    cart_det.setNombre(nombre);
                    cart_det.setApellidos(apellidos);
                    cart_det.setEmail(email);
                    cart_det.setTelefono(telefono);
                    cart_det.setCantidad(cantidad);
                    
                    L_Cartdetalle.add(cart_det);
                }
            }
            else {
                cart_det = new CartDashboard();
                L_Cartdetalle.add(cart_det);
            }
        } catch (Exception ex) {
            Logger.getLogger(DashboardServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return L_Cartdetalle;
    }
    //--------------------------------------------------------------------------------------------------
}
