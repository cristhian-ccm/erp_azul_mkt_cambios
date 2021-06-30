/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.server.serviceimpl;

import com.upgrade.persistence.model.extcs.Marca;
import ts.com.service.util.db.server.CRUD;
import up.erp.service.MarcaService;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luis Aleman
 */
public class MarcaServiceImpl implements MarcaService {
    
    @Override
    public Marca getByCodigo(String codigo) {
        Marca result = null;
        try {
            String where = "where codigo = '"+codigo+"' limit 1";
            String[] require = {"productoTipo","creadoPor"};
            List<Marca> list = CRUD.list(Marca.class,require,where);
            if(!list.isEmpty()){
                result = list.get(0);
            }
        } catch (Exception ex) {
            Logger.getLogger(MarcaServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public List<Marca> listByNombre(String nombre) {
        List<Marca> result = new ArrayList<>();
        try {
            String where = "where nombre ilike '%"+nombre+"%' or descripcion ilike '%"+nombre+"%'";
            result = CRUD.list(Marca.class,where);
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
