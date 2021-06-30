/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.service;

import com.upgrade.persistence.model.ecommerce.*;
import com.upgrade.persistence.model.extcs.Almacen;
import com.upgrade.persistence.model.extcs.Linea;

import java.util.Date;
import up.erp.service.model.SaveCart;
import java.util.List;

/**
 *
 * @author evanl
 */
public interface UsuarioWebService {

    ResponseFrontModel crearUsuarioInvitado();
    ResponseFrontModel registrar(UsuarioWeb usuarioWeb);
    ResponseFrontModel registrarConCupon(UsuarioWeb usuarioWeb, Integer cuponId);
    UsuarioWeb registrarFirebase(UsuarioWeb usuarioWeb);
    UsuarioWeb registrarFirebaseCupon(UsuarioWeb usuarioWeb, Integer cuponId);
    boolean validarEmail(String email);
    ResponseFrontModel confirmarEmail(String key);
    ResponseFrontModel validarReestContraseña(String email, String key);
    ResponseFrontModel cambiarPasswEmail(CambiarPassw cambiarPassw);
    UsuarioWeb login(String usuario, String passw);
    UsuarioWeb loginFirebase(String usuario);
    ResponseFrontModel validarEmailActivo(String usuario, String passw);
    ResponseFrontModel resetPassword(String email);
    ResponseFrontModel resetPassword2(String email);
    Integer saveCart(SaveCart saveCart);
    Integer saveWish(SaveCart saveCart);
    ResponseFrontModel changePassword(CambiarPassw cambiarPassw);
    ResponseFrontModel suscribirseConPromo(SuscripcionModel suscripcion, Integer idPromo);
	
    //CPANEL
    public UsuarioWeb find_UsuWeb_byId(String id_usu_web);
    
    public List<UsuarioWeb> find_soloActivos(String nombre);
    public List<UsuarioWeb> find_soloNoActivos(String nombre);
    public List<UsuarioWeb> find_UsubyFechas(Date fecha_ini, Date fecha_fin);
    public List<UsuarioWeb> find_UsuComp(Date fecha_ini, Date fecha_fin);
    public List<UsuarioWeb> find_UsubySucursal(Date fecha_ini, Date fecha_fin,String id_almacen);
    public List<Almacen> get_Almacenes();
    public Almacen find_AlmacenbyName(String almacen_name);
    
    public void save_UsuarioWeb(UsuarioWeb registro_web);
    public void update_UsuarioWeb(UsuarioWeb registro_web);
    public void delete_UsuarioWeb(UsuarioWeb registro_web);
    
    //DASHBOARDS
    public List<Integer> get_Function_Ventas();
    
    
    //SUBSCRIPTORES
    public List<Suscripcion> find_SubsbyFecha(Date fecha_ini, Date fecha_fin);
    
    
    //PUNTOS UP
    public PuntosUp get_PuntosUpbyUserWeb(String usuweb_id);
    public BannerOb get_BannerByID(Integer idban);

    public List<PuntosUp> find_PuntosUPActivos();
    public List<PuntosUp> find_PuntosUPbyFecha(Date fecha_ini, Date fecha_fin);
    public void update_PuntosUP(PuntosUp n_puntosup);
    public void update_Banner(BannerOb banner);
    public void update_Programacion(ProgramOB programacion);

    //CATALOGO PUNTOS UP
    public void insert_CatalogoPtsUP(CatalogoPuntosUp n_catalogo);
    
    public void insert_banner(BannerOb n_catalogo);
    public void insert_Programacion(ProgramOB n_catalogo);


    public void delete_CatalogoPtsUP(CatalogoPuntosUp n_catalogo);
    public void update_CatalogoPtsUP(CatalogoPuntosUp n_catalogo);
    public CatalogoPuntosUp get_CatalogoActivo();
    public List<CatalogoPuntosUp> find_Catalogos();

    public List<BannerOb> find_Banners();

    public List<ProgramOB> find_Programacion();



    public List<Linea> find_Lineas();

    public void delete_Banner(BannerOb banner);
    public void delete_prog(ProgramOB banner);





    
}
