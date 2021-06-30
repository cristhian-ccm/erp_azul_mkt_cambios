/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.server.serviceimpl;

import com.upgrade.persistence.model.usros.RolPermiso;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ts.com.service.util.db.server.CRUD;
import up.erp.service.RolPermisoService;

/**
 *
 * @author Upgrade - PC
 */
public class RolPermisoServiceImpl implements RolPermisoService {
    
    @Override
    public List<RolPermiso> listByIdRol(String idRol)
    {
        List<RolPermiso> result = new ArrayList<>();
        try {
            String where = "where rol_id = "+idRol;
            String[] require = {"permiso"};
            result = CRUD.list(RolPermiso.class,require,where);
        } catch (Exception ex) {
            Logger.getLogger(RolesServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    @Override
    public RolPermiso save(RolPermiso rolPermiso)
    {
        //PlantillaTransformacion plantilla = new PlantillaTransformacion();
        try {
            //CRUD.save(newPlantilla); 
            CRUD.save(rolPermiso);
        } catch (Exception ex) {
            Logger.getLogger(RolPermisoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rolPermiso;
    }
}
