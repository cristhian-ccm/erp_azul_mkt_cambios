/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.view.usuarios;

import com.upgrade.persistence.model.tcros.Persona;
import com.upgrade.persistence.model.usros.Permiso;
import java.util.List;
import up.erp.view.App;
import up.erp.service.Services;

/**
 *
 * @author Diego Javier Quispe
 */
public class PermisosView extends PermisosUI {
    
    public App app;
    public Persona persona = Services.getPersona().getOnePersona();
    
    public PermisosView(App app) {
        this.app = app;
        loadGridPermisos();
        
    }
    
    public PermisosView() {
        loadGridPermisos();
    }
    
    @Override
    public void onSavePermiso()
    {
        Permiso permiso = new Permiso();
        permiso.setAccion(txtNombrePermiso.getValue());
        permiso.setInactivo(Boolean.FALSE);
        Services.getPermiso().save(permiso);
        loadGridPermisos();
        
    }
    
    public final void loadGridPermisos()
    {
        List<Permiso> listPermisos = Services.getPermiso().list(false);
        gridPermisos.setItems(listPermisos);
    }
    
}
