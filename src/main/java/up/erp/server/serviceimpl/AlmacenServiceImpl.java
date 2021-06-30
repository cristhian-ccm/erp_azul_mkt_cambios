/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.server.serviceimpl;

import com.upgrade.persistence.model.extcs.Almacen;
import java.util.ArrayList;
import ts.com.service.util.db.server.CRUD;
import up.erp.service.AlmacenService;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego-Javier
 */
public class AlmacenServiceImpl implements AlmacenService {
    
    @Override
    public Almacen getById(String id) {
        Almacen result = null;
        try {
            String where = "where id = '"+id+"' limit 1";
            List<Almacen> list = CRUD.list(Almacen.class, where);
            if(!list.isEmpty()){
                result = list.get(0);
            }    
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public List<Almacen> listByAbreviatura()
    {
        
        List<Almacen> result = new ArrayList<>();
        try {
            String where = "where abreviatura != '"+"'";
            result = CRUD.list(Almacen.class,  where);
        } catch (Exception ex) {
            Logger.getLogger(AlmacenServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }            
    
}
