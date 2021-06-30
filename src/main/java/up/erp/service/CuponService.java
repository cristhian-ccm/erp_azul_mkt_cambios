/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.service;

import com.upgrade.persistence.model.ecommerce.Cupones;
import com.upgrade.persistence.model.ecommerce.UsuarioWeb;
import com.upgrade.persistence.model.ecommerce.UsuariosCupones;
import java.util.Date;
import java.util.List;
/**
 *
 * @author Luis Aleman
 */
public interface CuponService {
    
    //--------------------------------------------------------------------------
    //BUSQUEDAS
    //--------------------------------------------------------------------------
    public Cupones find_Cupon_ById(String id_cupon);
    public List<Cupones> find_Cupon_ByName(String nombre_cupon);
    public List<Cupones> find_Cupones_Activos();
    public List<Cupones> find_Cupones_Inactivos();
    //--------------------------------------------------------------------------
    //DIALOG CUPON EXISTENTE
    //--------------------------------------------------------------------------
    public void Update_Cupon(Cupones cupon);
    public void Delete_Cupon(Cupones cupon);
    //--------------------------------------------------------------------------
    //USUARIOS - CUPONES
    public UsuariosCupones find_UsuCupon(String id_usu,String id_cupon);
    public List<UsuariosCupones> find_UsuCupon_ByCupon(String id_cupon);
    public List<UsuarioWeb> find_UsuariosAsignados_ByCupon(String id_cupon);
    public List<UsuarioWeb> find_UsuariosbyFecha(Date fecha_ini, Date fecha_fin);
    public void Insert_UsuarioCupon(UsuariosCupones usu_cupon);
    public void Update_UsuarioCupon(UsuariosCupones usu_cupon);
    public void Delete_UsuarioCupon(UsuariosCupones usu_cupon);
    //--------------------------------------------------------------------------
    //DIALOG NUEVO CUPON
    //--------------------------------------------------------------------------
    public void Save_Cupon(Cupones cupon);
    //--------------------------------------------------------------------------
    
}
