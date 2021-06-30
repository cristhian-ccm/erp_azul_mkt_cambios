/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.server.serviceimpl;

import com.upgrade.persistence.model.ecommerce.LineaEcomErp;
import com.upgrade.persistence.model.ecommerce.LineaEcommerce;
import com.upgrade.persistence.model.extcs.Linea;
import com.upgrade.persistence.model.extcs.Producto;
import up.erp.service.LineaEcommerceService;

import java.util.ArrayList;
import ts.com.service.util.db.server.CRUD;
import up.erp.service.IndexWebService;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ts.com.service.util.db.Query;
/**
 *
 * @author Luis Aleman
 */
public class LineaEcommerceServiceImpl implements LineaEcommerceService{

    @Override
    public List<LineaEcommerce> get_AllLineaEcommerce() {
        List<LineaEcommerce> list_result = new ArrayList<>();
        try {
            String where = "order by id asc limit 100";
            list_result = CRUD.list(LineaEcommerce.class,where);
        } catch (Exception ex) {
            Logger.getLogger(LineaEcommerceServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list_result;
    }
    
    @Override
    public LineaEcommerce get_LineaEcommerce_byNombre(String linea_ecom){
        LineaEcommerce l_ecom = new LineaEcommerce();
        try {
            String where = "where a.nombre ilike '%"+linea_ecom+"%' or a.descripcion ilike '%"+linea_ecom+"%' limit 1";
            List<LineaEcommerce> list_result = CRUD.list(LineaEcommerce.class,where);
            if(!list_result.isEmpty()){
                l_ecom = new LineaEcommerce();
                l_ecom = list_result.get(0);
            }
        } catch (Exception ex) {
            Logger.getLogger(LineaEcommerceServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l_ecom;
    }
    
    @Override
    public void save_LineaEcommerce(LineaEcommerce linea_ecom){
        try {
            CRUD.save(linea_ecom);
        } catch (Exception ex) {
            Logger.getLogger(LineaEcommerceServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    
    @Override
    public void delete_LineaEcommerce(LineaEcommerce linea_ecom){
        try {
            CRUD.delete(linea_ecom);
        } catch (Exception ex) {
            Logger.getLogger(LineaEcommerceServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    @Override
    public void update_LineaEcommerce(LineaEcommerce linea_ecom){
        try {
            CRUD.update(linea_ecom);
        } catch (Exception ex) {
            Logger.getLogger(LineaEcommerceServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    @Override
    public List<Linea> get_AllLineaERP() {
        List<Linea> list_result = new ArrayList<>();
        try {
            String where = "order by id asc limit 200";
            list_result = CRUD.list(Linea.class,where);
        } catch (Exception ex) {
            Logger.getLogger(LineaEcommerceServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list_result;
    }
    
    @Override
    public List<Linea> get_LineaERP_byLEcom(String linea_ecom){
        List<Linea> list_result = new ArrayList<>();
        try {
            String where = "where b.nombre ilike '%"+linea_ecom+"%' or b.descripcion ilike '%"+linea_ecom+"%'";
            list_result = CRUD.list(Linea.class,where);
        } catch (Exception ex) {
            Logger.getLogger(LineaEcommerceServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list_result;
    }
    
    @Override
    public List<Linea> get_LineaERP_byNombre(String linea_erp){
        List<Linea> list_result = new ArrayList<>();
        try {
            String where = "where a.nombre ilike '%"+linea_erp+"%' or a.descripcion ilike '%"+linea_erp+"%'";
            list_result = CRUD.list(Linea.class,where);
        } catch (Exception ex) {
            Logger.getLogger(LineaEcommerceServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list_result;
    }
    
    @Override
    public void update_Linea(Linea linea_erp){
        try {
            CRUD.update(linea_erp);
        } catch (Exception ex) {
            Logger.getLogger(LineaEcommerceServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    @Override
    public LineaEcomErp get_LineaERPECOM(Integer linea_ecom_id,Integer linea_erp_id){
        LineaEcomErp l_Ecom_Erp = new LineaEcomErp();
        List<LineaEcomErp> list_LERP_LECOM = new ArrayList<>();
        try {
            String where = "where a.linea_ecom_id = "+linea_ecom_id+" and a.linea_erp_id = "+linea_erp_id+" limit 1";
            String [] require = {"linea_ecom","linea_erp"};
            list_LERP_LECOM = CRUD.list(LineaEcomErp.class,require,where);
            if(!list_LERP_LECOM.isEmpty()){
                l_Ecom_Erp = list_LERP_LECOM.get(0);
            }
        } catch (Exception ex) {
            Logger.getLogger(LineaEcommerceServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l_Ecom_Erp;
    }
    
    @Override
    public void insert_Linea_Ecom_Erp(Integer linea_ecom_id,Integer linea_erp_id) {
        Query query = new Query();
        String select = "INSERT INTO ecommerce.linea_ecom_erp(linea_ecom_id,linea_erp_id) VALUES ("+linea_ecom_id+","+linea_erp_id+")";
        query.select.set(select);
        query.where = "";
        query.end = "";
        try {
            //Object[][] rs = query.initResultSet();
            CRUD.execute(select);
        }
        catch (Exception ex) {
            Logger.getLogger(LineaEcommerceServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void insert_Linea_Ecom_Erp_obj(LineaEcomErp l_Ecom_ERP){
        try {
            CRUD.save(l_Ecom_ERP);
        } catch (Exception ex) {
            Logger.getLogger(LineaEcommerceServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    @Override
    public void delete_Linea_Ecom_Erp_obj(LineaEcomErp l_Ecom_ERP){
        try {
            CRUD.delete(l_Ecom_ERP);
        } catch (Exception ex) {
            Logger.getLogger(LineaEcommerceServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    @Override
    public List<LineaEcomErp> get_LineasERPECOM_byLineaEcom(Integer linea_ecom_id){
        List<LineaEcomErp> list_LERP_LECOM = new ArrayList<>();
        LineaEcommerce l_ecom = new LineaEcommerce();
        Linea l_erp = new Linea();
        try {
            String where = "where a.linea_ecom_id = "+linea_ecom_id+"";
            String [] require = {"linea_ecom","linea_erp"};
            list_LERP_LECOM = CRUD.list(LineaEcomErp.class,require,where);
        } catch (Exception ex) {
            Logger.getLogger(LineaEcommerceServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list_LERP_LECOM;
    }

    @Override
    public List<LineaEcomErp> get_LineaErp_Ecom_byIdErp(String linea_erp_id) {
        List<LineaEcomErp> list_LECOM_LERP = new ArrayList<>();
        try {
            String where = "where a.linea_erp_id = "+linea_erp_id+"";
            String [] require = {"linea_ecom","linea_erp"};
            list_LECOM_LERP = CRUD.list(LineaEcomErp.class,require,where);
            if(!list_LECOM_LERP.isEmpty()){
                for(int i = 0; i < list_LECOM_LERP.size(); i++){
                    System.out.println("Linea ERP encontrada es: " + list_LECOM_LERP.get(i).getLinea_erp_Descrip());
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(LineaEcommerceServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list_LECOM_LERP;
    }
    
    
    
}
