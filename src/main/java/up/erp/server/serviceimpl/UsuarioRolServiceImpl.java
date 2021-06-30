/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.server.serviceimpl;

import com.upgrade.persistence.model.usros.UsuarioRol;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ts.com.service.util.db.server.CRUD;
import up.erp.service.UsuarioRolService;

/**
 *
 * @author Upgrade - PC
 */
public class UsuarioRolServiceImpl implements UsuarioRolService {
    
    @Override
    public List<UsuarioRol> listByIdUsuario(String idUsuario)
    {
        List<UsuarioRol> result = new ArrayList<>();
        try {
            String where = "where usuario_id = "+idUsuario;
            String[] require = {"rol"};
            result = CRUD.list(UsuarioRol.class,require,where);
        } catch (Exception ex) {
            Logger.getLogger(RolesServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    @Override
    public UsuarioRol save(UsuarioRol usuarioRol)
    {
        //PlantillaTransformacion plantilla = new PlantillaTransformacion();
        try {
            //CRUD.save(newPlantilla); 
            CRUD.save(usuarioRol);
        } catch (Exception ex) {
            Logger.getLogger(RolPermisoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return usuarioRol;
    }
    
    @Override
    public void delete(UsuarioRol usuarioRol)
    {
        //PlantillaTransformacion plantilla = new PlantillaTransformacion();
        try {
            //CRUD.save(newPlantilla); 
            CRUD.delete(usuarioRol);
        } catch (Exception ex) {
            Logger.getLogger(RolPermisoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //return usuarioRol;
    }
}
