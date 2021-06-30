/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.server.serviceimpl;

import com.upgrade.persistence.model.FormaPago;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ts.com.service.util.db.server.CRUD;

/**
 *
 * @author Diego Javier Quispe
 */
public class FormaPagoImpl {
     public FormaPago getById(String id) {
        FormaPago result = null;
        try {
            String where = "where id = '"+id+"' limit 1";
            List<FormaPago> list = CRUD.list(FormaPago.class, where);
            if(!list.isEmpty()){
                result = list.get(0);
            }    
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
