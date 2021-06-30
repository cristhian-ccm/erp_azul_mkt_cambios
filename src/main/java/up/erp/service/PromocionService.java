/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.service;

import com.upgrade.persistence.model.ecommerce.Promociones;
import java.util.Date;
import java.util.List;
/**
 *
 * @author Luis Aleman
 */
public interface PromocionService {
    
    //--------------------------------------------------------------------------
    //BUSQUEDAS
    //--------------------------------------------------------------------------
    public Promociones find_Promo_ById(String id_promo);
    public List<Promociones> find_Promo_Activos();
    public List<Promociones> find_Promo_Inactivos();
    
    //--------------------------------------------------------------------------
    //FUNCIONES
    //--------------------------------------------------------------------------
    public void insert_Promo(Promociones promo);
    public void delete_Promo(Promociones promo);
    public void update_Promo(Promociones promo);
    //--------------------------------------------------------------------------
    
}
