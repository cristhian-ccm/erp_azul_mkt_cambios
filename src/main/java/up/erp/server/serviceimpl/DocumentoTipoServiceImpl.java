/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.server.serviceimpl;

import com.upgrade.persistence.model.DocumentoTipo;
import ts.com.service.util.db.server.CRUD;
import up.erp.service.DocumentoTipoService;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Upgrade - PC
 */
public class DocumentoTipoServiceImpl implements DocumentoTipoService{
    
    @Override
    public DocumentoTipo getById(String id) {
        DocumentoTipo result = null;
        try {
            String where = "where id = '"+id+"' limit 1";
            List<DocumentoTipo> list = CRUD.list(DocumentoTipo.class,where);
            if(!list.isEmpty()){
                result = list.get(0);
            }    
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
