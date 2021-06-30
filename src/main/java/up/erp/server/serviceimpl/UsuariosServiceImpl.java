/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.server.serviceimpl;

import com.upgrade.persistence.model.usros.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ts.com.service.util.db.server.CRUD;
import up.erp.service.UsuariosService;

/**
 *
 * @author Diego Javier Quispe
 */
public class UsuariosServiceImpl implements UsuariosService{
    @Override
    public List<Usuario> list(boolean soloActivos)
    {
        List<Usuario> result = new ArrayList<>();
        try {
            String where = soloActivos?"where a.inactivo is false order by b.nombre":"";
            String[] require = {"id"};
            result = CRUD.list(Usuario.class, require, where);
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }    
    
    @Override
    public List<Usuario> listByNombre(String nombre)
    {
        List<Usuario> result = new ArrayList<>();
        try {
            String where = "where a.inactivo is false and b.nombre ilike '%"+nombre+"%' order by b.nombre";
            String[] require = {"id"};
            result = CRUD.list(Usuario.class, require, where);
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }    
}
