/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.view.ecom;

import com.upgrade.persistence.model.extcs.Almacen;
import com.upgrade.persistence.model.tcros.Persona;
import com.upgrade.persistence.model.usros.Rol;
import com.upgrade.persistence.model.usros.Usuario;
import com.upgrade.persistence.model.usros.UsuarioAlmacen;
import com.upgrade.persistence.model.usros.UsuarioRol;

import java.util.ArrayList;
import java.util.List;
import up.erp.service.Services;
import up.erp.view.App;

/**
 *
 * @author Hvt
 */
public class CaracteristicaView extends CaracteristicaUI {

    public App app;
    public Persona persona = Services.getPersona().getOnePersona();

    public CaracteristicaView(App app) {
        this.app = app;
        List<Usuario> listUsuarios = Services.getUsuarios().list(true);
        gridUsuarios.setItems(listUsuarios);
    }

    // --------------------------------------------------------------------------
    @Override
    public void go_CPanel() {
        removeAll();
        // this.app.setContent(new CPanelView(app));
        this.app.setContent(new CPanelView2(app));
    }

    // --------------------------------------------------------------------------
    @Override
    public void go_Clientes() {
        this.app.layHeader.removeAll();
        this.app.setContent(new ClientesView(app));
    }

    // --------------------------------------------------------------------------
    @Override
    public void go_Subscriptores() {
        this.app.layHeader.removeAll();
        this.app.setContent(new SubscriptoresView(app));
    }

    // --------------------------------------------------------------------------
    @Override
    public void go_Promociones() {
        this.app.layHeader.removeAll();
        this.app.setContent(new PromocionesView(app));
    }

    // --------------------------------------------------------------------------
    @Override
    public void go_Productos() {
        this.app.layHeader.removeAll();
        this.app.setContent(new ProductosView(app));
    }

    // --------------------------------------------------------------------------
    @Override
    public void go_Cupones() {
        this.app.layHeader.removeAll();
        this.app.setContent(new CuponesView(app));
    }

    // --------------------------------------------------------------------------
    @Override
    public void go_PuntosUP() {
        this.app.layHeader.removeAll();
        this.app.setContent(new PuntosUpView(app));
    }

    // --------------------------------------------------------------------------
    @Override
    public void go_Pedidos() {
        this.app.layHeader.removeAll();
        this.app.setContent(new PedidosView(app));
    }

    // --------------------------------------------------------------------------
    @Override
    public void go_LineasEcom() {
        this.app.layHeader.removeAll();
        this.app.setContent(new LineasEcomView(app));
    }

    // --------------------------------------------------------------------------
    @Override
    public void go_Index() {
        this.app.layHeader.removeAll();
        // this.app.setContent(new IndexWebView(app));
        this.app.setContent(new IndexWeb2View(app));
    }

    @Override
    public void onGetUsuariosRoles() {
        List<Rol> listRoles = Services.getRoles().list(false);
        comboRoles.setItems(listRoles);

        List<UsuarioRol> usuarioRoles = Services.getUsuarioRol()
                .listByIdUsuario(String.valueOf(gridUsuarios.asSingleSelect().getValue().getId().getId()));
        gridUsuarioRoles.setItems(usuarioRoles);
    }

    @Override
    public void onAddUsuarioRol() {
        UsuarioRol usuarioRol = new UsuarioRol();
        usuarioRol.setUsuario(gridUsuarios.asSingleSelect().getValue());
        usuarioRol.setRol(comboRoles.getValue());
        Services.getUsuarioRol().save(usuarioRol);
        this.onGetUsuariosRoles();
    }

    public void onDelUsuarioRol() {
        UsuarioRol usuarioRol = gridUsuarioRoles.asSingleSelect().getValue();
        Services.getUsuarioRol().delete(usuarioRol);
    }

    @Override
    public void onGetUsuariosByNombre() {
        List<Usuario> listUsuarios = Services.getUsuarios().listByNombre(buscarByNombre.getValue());
        gridUsuarios.setItems(listUsuarios);
    }

    @Override
    public void on_Open_CrearUsuarioDialog() {
        onGetPersonas();
        onGetAlmacenes();
    }

    @Override
    public void on_Open_EditarUsuarioDialog() {

        onGetPersonasEdit();
        onGetAlmacenesEdit();

        Usuario currUser = gridUsuarios.asSingleSelect().getValue();

        txtdialogLE_UserID2.setValue(currUser.getUsuario());
        cmbPersona2.setValue(currUser.getNombrePersona());
        // txtdialogLE_Caja2.setValue(currUser.getCajaID());
        // cmbAlmacen2.setValue(currUserAlmacen.getAlmacen());
        dialogLE_CheckActivationNewEdit.setValue(!currUser.getInactivo());
        // dialogLE_CheckActivationNewEdit2.setValue(currUser.getIsComision());

    }

    @Override
    public void onGetPersonas() {

        // List<Persona> listPersonas = Services.getPersona().list(true);
        List<String> listStrPersonas = new ArrayList<>();

        /*
         * listPersonas.forEach(p -> { listStrPersonas.add(p.nombre); personas.add(p);
         * });
         */

        cmbPersona.setItems(listStrPersonas);

    }

    @Override
    public void onAddUsuario() {

        Usuario newUser = new Usuario();
        Almacen userAlmacen = cmbAlmacen.getValue();

        UsuarioAlmacen newUserAlmacen = new UsuarioAlmacen();
        Persona curPerson = Services.getPersona().getByname(cmbPersona.getValue());

        if (curPerson != null) {
            newUser.setId(curPerson);
            newUser.setUsuario(txtdialogLE_UserID.getValue());
            newUser.setClave(utils.encrypt(txtdialogLE_Pwd.getValue()));
            newUser.setInactivo(!dialogLE_CheckActivationNew.getValue());
            // newUser.setCajaID(txtdialogLE_Caja.getValue());
            // newUser.setIsComision(dialogLE_CheckActivationNew2.getValue());
            // Services.getUsuarios().save(newUser);

            newUserAlmacen.setUsuario(newUser);
            newUserAlmacen.setAlmacen(userAlmacen);
            // Services.getUsuarioAlmacen().save(newUserAlmacen);

        } else {
            System.out.println("ERROR PERSONA NO EXISTE");
        }

    }

    @Override
    public void onGetPersonasEdit() {

        // List<Persona> listPersonas = Services.getPersona().list(true);
        List<String> listStrPersonas = new ArrayList<>();

        /*
         * listPersonas.forEach(p -> { listStrPersonas.add(p.nombre); personas.add(p);
         * });
         */

        cmbPersona2.setItems(listStrPersonas);

    }

    @Override
    public void onGetAlmacenes() {

        List<Almacen> listAlmacenes = Services.getAlmacen().listByAbreviatura();
        cmbAlmacen.setItems(listAlmacenes);

    }

    @Override
    public void onGetAlmacenesEdit() {

        List<Almacen> listAlmacenes = Services.getAlmacen().listByAbreviatura();
        cmbAlmacen2.setItems(listAlmacenes);

    }

    @Override
    public Boolean onEditUsuario() {

        Usuario editUser = gridUsuarios.asSingleSelect().getValue();
        // UsuarioAlmacen editUserAlmacen =
        // Services.getUsuarioAlmacen().getByUser(editUser);
        // UsuarioAlmacen editUserAlmacen = new UsuarioAlmacen();

        Persona curPerson = Services.getPersona().getByname(cmbPersona2.getValue());

        if (curPerson != null) {
            if (!txtdialogLE_UserID2.isEmpty()) {
                editUser.setUsuario(txtdialogLE_UserID2.getValue());
            }

            if (!txtdialogLE_Pwd2.isEmpty()) {
                editUser.setClave(utils.encrypt(txtdialogLE_Pwd2.getValue()));
            }

            /*
             * if (!txtdialogLE_Caja2.isEmpty()) {
             * editUser.setCajaID(txtdialogLE_Caja2.getValue()); }
             * 
             * editUser.setInactivo(!dialogLE_CheckActivationNewEdit.getValue());
             * editUser.setIsComision(dialogLE_CheckActivationNewEdit2.getValue());
             * Services.getUsuarios().update(editUser);
             * 
             * if (!cmbAlmacen2.isEmpty()) {
             * 
             * if (editUserAlmacen.getUsuario() == null && editUserAlmacen.getAlmacen() ==
             * null) { UsuarioAlmacen newUA = new UsuarioAlmacen();
             * newUA.setUsuario(editUser); newUA.setAlmacen(cmbAlmacen2.getValue());
             * 
             * Services.getUsuarioAlmacen().save(newUA); } else {
             * editUserAlmacen.setUsuario(editUser);
             * editUserAlmacen.setAlmacen(cmbAlmacen2.getValue());
             * 
             * Services.getUsuarioAlmacen().update(editUserAlmacen); } }
             */

            return true;

        } else {
            System.out.println("ERROR PERSONA NO EXISTE");
            return false;
        }

    }

    @Override
    public void onDeleteUsuario() {

        Usuario userDel = gridUsuarios.asSingleSelect().getValue();
        // Services.getUsuarios().delete(userDel);

    }

}
