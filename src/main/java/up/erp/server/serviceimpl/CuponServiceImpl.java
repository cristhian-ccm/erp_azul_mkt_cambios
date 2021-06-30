/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.server.serviceimpl;

import com.upgrade.persistence.model.ecommerce.Cupones;
import com.upgrade.persistence.model.ecommerce.UsuarioWeb;
import com.upgrade.persistence.model.ecommerce.UsuariosCupones;
import java.util.ArrayList;
import java.util.Date;
import ts.com.service.util.db.server.CRUD;
import up.erp.service.CuponService;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Luis Aleman
 */
public class CuponServiceImpl implements CuponService{
    
    //---------------------------------------------------------------------------------------------
    //BUSQUEDAS
    //---------------------------------------------------------------------------------------------
    @Override
    public Cupones find_Cupon_ById(String id_cupon){
        Cupones n_cupon = new Cupones();
        List<Cupones> l_cupones = new ArrayList<>();
        try {
            String where = "where a.activo is true and a.id =" +id_cupon+ " limit 1";
            l_cupones = CRUD.list(Cupones.class,where);
            n_cupon = l_cupones.get(0);
        } catch (Exception ex) {
            Logger.getLogger(CuponServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n_cupon;
    }
    //---------------------------------------------------------------------------------------------
    @Override
    public List<Cupones> find_Cupon_ByName(String nombre_cupon) {
        List<Cupones> l_cupones = new ArrayList<>();
        try {
            String where = "where a.activo is true and a.nombre_cupon ilike '%" +nombre_cupon+ "%' order by id asc limit 1000";
            l_cupones = CRUD.list(Cupones.class,where);
        } catch (Exception ex) {
            Logger.getLogger(CuponServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l_cupones;
    }
    //---------------------------------------------------------------------------------------------
    @Override
    public List<Cupones> find_Cupones_Activos() {
        List<Cupones> l_cupones = new ArrayList<>();
        try {
            String where = "where a.activo is true order by id asc limit 1000";
            l_cupones = CRUD.list(Cupones.class,where);
        } catch (Exception ex) {
            Logger.getLogger(CuponServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l_cupones;
    }
    //---------------------------------------------------------------------------------------------
    @Override
    public List<Cupones> find_Cupones_Inactivos() {
        List<Cupones> l_cupones = new ArrayList<>();
        try {
            String where = "where a.activo is false order by id asc limit 1000";
            l_cupones = CRUD.list(Cupones.class,where);
        } catch (Exception ex) {
            Logger.getLogger(CuponServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l_cupones;
    }
    //---------------------------------------------------------------------------------------------
    //DIALOG CUPON EXISTENTE
    //---------------------------------------------------------------------------------------------
    @Override
    public void Update_Cupon(Cupones cupon){
        try {
            CRUD.update(cupon);
        } catch (Exception ex) {
            Logger.getLogger(CuponServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //---------------------------------------------------------------------------------------------
    @Override
    public void Delete_Cupon(Cupones cupon){
        try {
            CRUD.delete(cupon);
        } catch (Exception ex) {
            Logger.getLogger(CuponServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //---------------------------------------------------------------------------------------------
    //USUARIOS - CUPONES
    //---------------------------------------------------------------------------------------------
    @Override
    public UsuariosCupones find_UsuCupon(String id_usu,String id_cupon){
        UsuariosCupones usucupon = new UsuariosCupones();
        List<UsuariosCupones> L_UsuCupones = new ArrayList<>();
        try {
            String where = "where a.usuariow_id = '"+id_usu+"' and a.cupon_id = '"+id_cupon+"' limit 1";
            String [] require = {"usuariow","cupon"};
            L_UsuCupones = CRUD.list(UsuariosCupones.class,require,where);
            if(!L_UsuCupones.isEmpty()){
                System.out.println("Usuario Econtrado es: " + L_UsuCupones.get(0).getUsuariow().getNombres() +
                                                              L_UsuCupones.get(0).getUsuariow().getApellidos());
                usucupon = new UsuariosCupones();
                usucupon = L_UsuCupones.get(0);
            }
        } catch (Exception ex) {
            Logger.getLogger(CuponServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usucupon;
    }
    //---------------------------------------------------------------------------------------------
    @Override
    public List<UsuariosCupones> find_UsuCupon_ByCupon(String id_cupon){
        List<UsuariosCupones> L_UsuCupones = new ArrayList<>();
        try {
            String where = "where a.cupon_id = "+id_cupon+"";
            String [] require = {"usuariow","cupon"};
            L_UsuCupones = CRUD.list(UsuariosCupones.class,require,where);
            if(!L_UsuCupones.isEmpty()){
                for(int i = 0; i < L_UsuCupones.size(); i++){
                    System.out.println("Usuario Econtrado es: " + L_UsuCupones.get(i).getUsuariow().getNombres() +
                                                                  L_UsuCupones.get(i).getUsuariow().getApellidos());
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(CuponServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return L_UsuCupones;
    }
    //---------------------------------------------------------------------------------------------
    @Override
    public List<UsuarioWeb> find_UsuariosAsignados_ByCupon(String id_cupon){
        List<UsuariosCupones> L_UsuCupones = new ArrayList<>();
        List<UsuarioWeb> L_Usu = new ArrayList<>();
        UsuarioWeb usu_web = new UsuarioWeb();
        try {
            String where = "where a.cupon_id = "+id_cupon+"";
            String [] require = {"usuariow","cupon"};
            L_UsuCupones = CRUD.list(UsuariosCupones.class,require,where);
            if(!L_UsuCupones.isEmpty()){
                for(int i = 0; i < L_UsuCupones.size(); i++){
                    System.out.println("Usuario Econtrado es: " + L_UsuCupones.get(i).getUsuariow().getNombres() +
                                                                  L_UsuCupones.get(i).getUsuariow().getApellidos());
                    usu_web = new UsuarioWeb();
                    usu_web = L_UsuCupones.get(i).getUsuariow();
                    L_Usu.add(usu_web);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(CuponServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return L_Usu;
    }
    //---------------------------------------------------------------------------------------------
    @Override
    public List<UsuarioWeb> find_UsuariosbyFecha(Date fecha_ini, Date fecha_fin){
        List<UsuarioWeb> L_Usu = new ArrayList<>();
        try {
            String where = "where a.activo is true and a.creacion between '"+fecha_ini+"' and '"+fecha_fin+"'";
            L_Usu = CRUD.list(UsuarioWeb.class,where);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioWebServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return L_Usu;
    }
    //---------------------------------------------------------------------------------------------
    @Override
    public void Insert_UsuarioCupon(UsuariosCupones usu_cupon){
        try {
            CRUD.save(usu_cupon);
        } catch (Exception ex) {
            Logger.getLogger(CuponServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //---------------------------------------------------------------------------------------------
    @Override
    public void Update_UsuarioCupon(UsuariosCupones usu_cupon){
        try {
            CRUD.update(usu_cupon);
        } catch (Exception ex) {
            Logger.getLogger(CuponServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //---------------------------------------------------------------------------------------------
    @Override
    public void Delete_UsuarioCupon(UsuariosCupones usu_cupon){
        try {
            CRUD.delete(usu_cupon);
        } catch (Exception ex) {
            Logger.getLogger(CuponServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //---------------------------------------------------------------------------------------------
    //DIALOG NUEVO CUPON
    //---------------------------------------------------------------------------------------------
    @Override
    public void Save_Cupon(Cupones cupon){
        try {
            CRUD.save(cupon);
        } catch (Exception ex) {
            Logger.getLogger(CuponServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //---------------------------------------------------------------------------------------------
    
    
}
