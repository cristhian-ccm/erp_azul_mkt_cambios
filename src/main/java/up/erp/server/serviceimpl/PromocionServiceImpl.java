/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.server.serviceimpl;

import com.upgrade.persistence.model.ecommerce.Promociones;
import java.util.ArrayList;
import java.util.Date;
import ts.com.service.util.db.server.CRUD;
import up.erp.service.CuponService;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import up.erp.service.PromocionService;

/**
 * 
 *
 * @author Luis Aleman
 */
public class PromocionServiceImpl implements PromocionService{
    
    //--------------------------------------------------------------------------
    //BUSQUEDAS
    //--------------------------------------------------------------------------
    @Override
    public Promociones find_Promo_ById(String id_promo){
        Promociones promo = new Promociones();
        List<Promociones> L_PromoResult = new ArrayList<>();
        try {
            String where = "where a.id =" +id_promo+ " limit 1";
            L_PromoResult = CRUD.list(Promociones.class,where);
            promo = L_PromoResult.get(0);
        } catch (Exception ex) {
            Logger.getLogger(PromocionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return promo;
    }
    
    @Override
    public List<Promociones> find_Promo_Activos(){
        List<Promociones> L_PromoResult = new ArrayList<>();
        try {
            String where = "where a.activo is true order by id asc limit 1000";
            L_PromoResult = CRUD.list(Promociones.class,where);
            for(int i = 0; i < L_PromoResult.size(); i++){
                System.out.println("Promo: " + L_PromoResult.get(i).getTitulo());
            }
        } catch (Exception ex) {
            Logger.getLogger(PromocionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return L_PromoResult;
    }
    
    @Override
    public List<Promociones> find_Promo_Inactivos(){
        List<Promociones> L_PromoResult = new ArrayList<>();
        try {
            String where = "where a.activo is false order by id asc limit 1000";
            L_PromoResult = CRUD.list(Promociones.class,where);
            for(int i = 0; i < L_PromoResult.size(); i++){
                System.out.println("Promo: " + L_PromoResult.get(i).getTitulo());
            }
        } catch (Exception ex) {
            Logger.getLogger(PromocionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return L_PromoResult;
    }
    
    //--------------------------------------------------------------------------
    //FUNCIONES
    //--------------------------------------------------------------------------
    @Override
    public void insert_Promo(Promociones promo){
        try {
            CRUD.save(promo);
        } catch (Exception ex) {
            Logger.getLogger(PromocionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void delete_Promo(Promociones promo){
        try {
            CRUD.delete(promo);
        } catch (Exception ex) {
            Logger.getLogger(PromocionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void update_Promo(Promociones promo){
        try {
            CRUD.update(promo);
        } catch (Exception ex) {
            Logger.getLogger(PromocionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //--------------------------------------------------------------------------
    
    
}
