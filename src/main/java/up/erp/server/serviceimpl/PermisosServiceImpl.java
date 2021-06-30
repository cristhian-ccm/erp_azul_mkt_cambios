/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.server.serviceimpl;

import com.upgrade.persistence.model.usros.Permiso;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ts.com.service.util.db.server.CRUD;
import up.erp.service.PermisosService;

/**
 *
 * @author Diego Javier Quispe
 */
public class PermisosServiceImpl implements PermisosService{
    
    @Override
    public List<Permiso> list(boolean soloActivos)
    {
         List<Permiso> result = new ArrayList<>();
        try {
            String where = soloActivos?"where activo is true ":"";
            result = CRUD.list(Permiso.class,where);
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    @Override
    public Permiso save(Permiso permiso)
    {
        //PlantillaTransformacion plantilla = new PlantillaTransformacion();
        try {
            //CRUD.save(newPlantilla); 
            CRUD.save(permiso);
        } catch (Exception ex) {
            Logger.getLogger(PermisosServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return permiso;
    }
}
