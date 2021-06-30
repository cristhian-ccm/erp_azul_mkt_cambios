/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.view.usuarios;

import com.upgrade.persistence.model.tcros.Persona;
import com.upgrade.persistence.model.usros.Rol;
import com.upgrade.persistence.model.usros.Usuario;
import com.upgrade.persistence.model.usros.UsuarioRol;
import java.util.List;
import up.erp.service.Services;
import up.erp.view.App;

/**
 *
 * @author Diego Javier Quispe
 */
public class UsuariosView extends UsuariosUI {
    
    public App app;
    public Persona persona = Services.getPersona().getOnePersona();
    
    public UsuariosView(App app) {
        this.app = app;
        List<Usuario> listUsuarios = Services.getUsuarios().list(true);
        gridUsuarios.setItems(listUsuarios);
    }
    
    @Override
    public void onGetUsuariosRoles(){
         List<Rol> listRoles = Services.getRoles().list(false);
         comboRoles.setItems(listRoles);
         
        List<UsuarioRol> usuarioRoles = Services.getUsuarioRol().listByIdUsuario(String.valueOf(gridUsuarios.asSingleSelect().getValue().getId().getId()));
        gridUsuarioRoles.setItems(usuarioRoles);
    }
    
    @Override
    public void onAddUsuarioRol(){
        UsuarioRol usuarioRol = new UsuarioRol();
        usuarioRol.setUsuario(gridUsuarios.asSingleSelect().getValue());
        usuarioRol.setRol(comboRoles.getValue());
        Services.getUsuarioRol().save(usuarioRol);
        this.onGetUsuariosRoles();
    }
    
    public void onDelUsuarioRol(){
        UsuarioRol usuarioRol = gridUsuarioRoles.asSingleSelect().getValue();
        Services.getUsuarioRol().delete(usuarioRol);
    }
    
    @Override
    public void onGetUsuariosByNombre()
    {
        List<Usuario> listUsuarios = Services.getUsuarios().listByNombre(buscarByNombre.getValue());
        gridUsuarios.setItems(listUsuarios);
    }
    
}
