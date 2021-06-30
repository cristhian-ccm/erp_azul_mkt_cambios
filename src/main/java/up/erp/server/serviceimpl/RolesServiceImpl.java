package up.erp.server.serviceimpl;

import com.upgrade.persistence.model.usros.Rol;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ts.com.service.util.db.server.CRUD;
import up.erp.service.RolesService;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Diego Javier Quispe
 */
public class RolesServiceImpl implements RolesService{
    
    @Override
    public List<Rol> list(boolean soloActivos)
    {
        List<Rol> result = new ArrayList<>();
        try {
            String where = soloActivos?"where activo is true ":"";
            result = CRUD.list(Rol.class,where);
        } catch (Exception ex) {
            Logger.getLogger(RolesServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
        
    @Override
    public Rol save(Rol rol)
    {
        try {
            //CRUD.save(newPlantilla); 
            CRUD.save(rol);
        } catch (Exception ex) {
            Logger.getLogger(RolesServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rol;
    }
}
