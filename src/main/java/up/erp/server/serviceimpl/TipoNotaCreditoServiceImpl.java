/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.server.serviceimpl;

import com.upgrade.persistence.model.sunat.TipoNotaCredito;
import ts.com.service.util.db.server.CRUD;
import up.erp.service.TipoNotaCreditoService;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Upgrade - PC
 */
public class TipoNotaCreditoServiceImpl implements TipoNotaCreditoService{
    @Override
    public TipoNotaCredito getById(String id) {
        TipoNotaCredito result = null;
        try {
            String where = "where id = '"+id+"' limit 1";
            List<TipoNotaCredito> list = CRUD.list(TipoNotaCredito.class,where);
            if(!list.isEmpty()){
                result = list.get(0);
            }    
        } catch (Exception ex) {
            Logger.getLogger(TipoNotaCreditoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
