/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.view.usuarios;

import com.upgrade.persistence.model.tcros.Persona;
import com.upgrade.persistence.model.usros.Permiso;
import com.upgrade.persistence.model.usros.Rol;
import com.upgrade.persistence.model.usros.RolPermiso;
import java.util.List;
import up.erp.service.Services;
import up.erp.view.App;

/**
 *
 * @author Diego Javier Quispe
 */
public class RolesView extends RolesUI {
    
    public App app;
    public Persona persona = Services.getPersona().getOnePersona();
    
    public RolesView(App app) {
        this.app = app;
        loadGridRoles();
    }
    
    public RolesView() {
        loadGridRoles();
    }
    
    @Override
    public void onGetRolPermisos()
    {
        List<RolPermiso> rolPermisos = Services.getRolPermiso().listByIdRol(String.valueOf(gridRoles.asSingleSelect().getValue().getId()));
        gridRolPermisos.setItems(rolPermisos);
        //System.out.println(rolPermisos.size());
        
        List<Permiso> listPermisos = Services.getPermiso().list(false);
        comboPermisos.setItems(listPermisos);
        
    }
    
    @Override
     public void onAddRolPermiso(){
         RolPermiso rolPermiso = new RolPermiso();
         rolPermiso.setRol(gridRoles.asSingleSelect().getValue());
         rolPermiso.setPermiso(comboPermisos.getValue());
         Services.getRolPermiso().save(rolPermiso);
         this.onGetRolPermisos();
     }
     
    @Override
    public void onSaveRol()
    {
        Rol rol = new Rol();
        rol.setNombre(txtNombreRol.getValue());
        rol.setInactivo(Boolean.FALSE);
        Services.getRoles().save(rol);
        loadGridRoles();   
    }
    
    public final void loadGridRoles(){
        List<Rol> listRoles = Services.getRoles().list(false);
        gridRoles.setItems(listRoles);
    }
    
}
