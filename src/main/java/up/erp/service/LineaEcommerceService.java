/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.service;

import com.upgrade.persistence.model.ecommerce.LineaEcomErp;
import com.upgrade.persistence.model.ecommerce.LineaEcommerce;
import com.upgrade.persistence.model.extcs.Linea;
import com.upgrade.persistence.model.extcs.Producto;
import java.util.List;
/**
 *
 * @author Luis Aleman
 */
public interface LineaEcommerceService {
    
    //Linea Ecomerce
    public List<LineaEcommerce> get_AllLineaEcommerce();
    public LineaEcommerce get_LineaEcommerce_byNombre(String linea_ecom);
    //public LineaEcommerce get_LineaEcommerce_byId(String linea_id);
    public void save_LineaEcommerce(LineaEcommerce linea_ecom);
    public void delete_LineaEcommerce(LineaEcommerce linea_ecom);
    public void update_LineaEcommerce(LineaEcommerce linea_ecom);
    
    //Linea ERP
    public List<Linea> get_AllLineaERP();
    public List<Linea> get_LineaERP_byLEcom(String linea_ecom);
    public List<Linea> get_LineaERP_byNombre(String linea_erp);
    public void update_Linea(Linea linea_erp);
    
    
    
    //Linea Ecommerce-ERP
    public void insert_Linea_Ecom_Erp(Integer linea_erp_id, Integer linea_ecom_id);
    public void insert_Linea_Ecom_Erp_obj(LineaEcomErp l_Ecom_ERP);
    public void delete_Linea_Ecom_Erp_obj(LineaEcomErp l_Ecom_ERP);
    public LineaEcomErp get_LineaERPECOM(Integer linea_ecom_id,Integer linea_erp_id);
    public List<LineaEcomErp> get_LineasERPECOM_byLineaEcom(Integer linea_ecom_id);
    public List<LineaEcomErp> get_LineaErp_Ecom_byIdErp(String linea_erp_id);
    
    
}
