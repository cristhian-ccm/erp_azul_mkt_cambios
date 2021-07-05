/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.view.ecom;

import java.util.ArrayList;
import java.util.List;

import com.upgrade.persistence.model.extcs.Almacen;
import com.upgrade.persistence.model.tcros.Persona;
import com.upgrade.persistence.model.usros.Permiso;
import com.upgrade.persistence.model.usros.Rol;
import com.upgrade.persistence.model.usros.Usuario;
import com.upgrade.persistence.model.usros.UsuarioRol;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.confirmdialog.ConfirmDialog;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;

import ts.com.service.util.Util;

import com.vaadin.flow.component.orderedlayout.FlexComponent;

/**
 *
 * @author Hvt
 */
public abstract class CaracteristicaUI extends VerticalLayout {

    // -----------------------------------------------------------------------------------------------
    // CPANEL CABECERA
    // -----------------------------------------------------------------------------------------------
    public final Button btnClientes = new Button("Clientes Ecommerce", VaadinIcon.MALE.create());
    public final Button btnSubscriptores = new Button("Subscriptores Ecommerce", VaadinIcon.MALE.create());
    public final Button btnPromociones = new Button("Promociones Ecommerce", VaadinIcon.GIFT.create());
    public final Button btnCupones = new Button("Cupones Ecommerce", VaadinIcon.TICKET.create());
    public final Button btnPuntosUP = new Button("Puntos UP Ecommerce", VaadinIcon.TROPHY.create());
    // -----------------------------------------------------------------------------------------------
    public final Button btnPedidos = new Button("Pedidos Ecommerce", VaadinIcon.CART_O.create());
    public final Button btnLineas = new Button("Lineas Ecommerce", VaadinIcon.RECORDS.create());
    public final Button btnProductos = new Button("Productos Ecommerce", VaadinIcon.PACKAGE.create());
    // public final Button btnEcomPage = new Button("Gestión Página Ecommerce",
    // VaadinIcon.GLOBE_WIRE.create());
    // -----------------------------------------------------------------------------------------------
    public final Button btnSalirCP = new Button("Salir del Panel de Control");
    // -----------------------------------------------------------------------------------------------
    public final HorizontalLayout layCPanelButtons = new HorizontalLayout(btnClientes, btnSubscriptores, btnPromociones,
            btnCupones, btnPuntosUP);
    // -----------------------------------------------------------------------------------------------
    public final HorizontalLayout layCPanelButtons2 = new HorizontalLayout(btnPedidos, btnLineas, btnProductos,
            btnSalirCP);
    // -----------------------------------------------------------------------------------------------
    // END CABECERA
    // -----------------------------------------------------------------------------------------------

    public final List<Persona> personas = new ArrayList<>();
    public final List<Almacen> almacenes = new ArrayList<>();
    public final Util utils = new Util();

    public final Button btnOpenDialogGenerarComprobante = new Button("Generar Comprobante",
            VaadinIcon.FILE_PROCESS.create());
    // public final Button btn = new Button("Generar",
    // VaadinIcon.FILE_PROCESS.create());
    public final Button buscarUsuarios = new Button("Buscar", VaadinIcon.SEARCH.create());
    public final Button verDetalles = new Button("Ver Detalles");
    public final HorizontalLayout layTitle = new HorizontalLayout();
    public final Grid<Usuario> gridUsuarios = new Grid<>();
    public final Dialog dialogGenerarComprobante = new Dialog();

    // public ComboBox<AlmacenFiltro> comboAlmacenes = new ComboBox<>();
    public final TextField buscarBySerie = new TextField();
    public final TextField buscarByNombre = new TextField();

    public final Notification notificationError = new Notification();
    public final Notification notificationSuccess = new Notification();
    public final TextArea observaciones = new TextArea();

    public final Button btnOpenAddRoles = new Button("Agregar Usuario Roles", VaadinIcon.SEARCH.create());
    public final Button btnAddRolToUsuario = new Button("", VaadinIcon.PLUS.create());
    public final Button btnDeleteRolToUsuario = new Button("", VaadinIcon.MINUS.create());
    public final Dialog dialogAddRoles = new Dialog();
    public final Grid<UsuarioRol> gridUsuarioRoles = new Grid<>();

    public final Dialog dialogUsuarios = new Dialog();
    public final ComboBox<Rol> comboRoles = new ComboBox<>();

    // CRUD USUARIOS BOTONES
    public final Button btnAgregar = new Button("Agregar Característica", VaadinIcon.PLUS_CIRCLE.create());
    public final Button btnQuitar = new Button("Eliminar Característica", VaadinIcon.MINUS_CIRCLE.create());
    public final Button btnEditar = new Button("Editar Característica", VaadinIcon.EDIT.create());

    public final Dialog dialogConfirmarDelete = new Dialog();
    public final Button btnDelAceptar = new Button("Aceptar");
    public final Button btnDelCancelar = new Button("Cancelar");

    public final Button btnOpenRoles = new Button("Roles", VaadinIcon.SEARCH.create());
    public final Button btnOpenPermisos = new Button("Permisos", VaadinIcon.SEARCH.create());

    public final Dialog dialogRoles = new Dialog();
    public final Dialog dialogPermisos = new Dialog();

    // public final Label lblCrearUsuario = new Label("Crear Usuario");
    // public final HorizontalLayout laydialogUs_titulo = new
    // HorizontalLayout(lblCrearUsuario);

    // public final HorizontalLayout laydialogLE_Exist_New = new
    // HorizontalLayout(laydialogLE_LEExist_Total,laydialogLE_LENew_Total);

    // ----------------------------------------------

    public final Label lbdialogUs_New = new Label("CREAR USUARIO");
    public final HorizontalLayout laydialogUs_NewTitulo = new HorizontalLayout(lbdialogUs_New);

    // Nombre y Descripcion de la Linea Ecommerce
    public final TextField txtdialogLE_UserID = new TextField("Usuario ID");
    // public final TextField txtdialogLE_DescripcionNew = new
    // TextField("Contraseña");
    public final PasswordField txtdialogLE_Pwd = new PasswordField("Contraseña");
    public final HorizontalLayout laydialogLE_NombreNew = new HorizontalLayout(txtdialogLE_UserID, txtdialogLE_Pwd);

    public final ComboBox<String> cmbPersona = new ComboBox<>("Elija una Persona");
    public final HorizontalLayout laydialogCmbPersona = new HorizontalLayout(cmbPersona);

    // Orden y Activo de la Linea Ecommerce
    public final IntegerField txtdialogLE_Caja = new IntegerField("Caja ID");
    public final ComboBox<Almacen> cmbAlmacen = new ComboBox<>("Elija una almacén");
    public final Checkbox dialogLE_CheckActivationNew = new Checkbox("¿Activo?");
    public final Checkbox dialogLE_CheckActivationNew2 = new Checkbox("¿Comisiones?");
    public final HorizontalLayout laydialogLE_OrdenNew = new HorizontalLayout(txtdialogLE_Caja,
            dialogLE_CheckActivationNew, dialogLE_CheckActivationNew2);
    public final HorizontalLayout laydialogLE_OrdenNew2 = new HorizontalLayout(cmbAlmacen, txtdialogLE_Caja);

    // Botones Nueva Linea Ecommerce
    public final Button btndialogLE_GuardarNew = new Button("Crear");
    public final Button btndialogLE_CancelNew = new Button("Cancelar");

    public final HorizontalLayout laydialogLE_BtnsNew = new HorizontalLayout(btndialogLE_GuardarNew,
            btndialogLE_CancelNew);

    // LAYOUT TOTAL NUEVA LINEA ECOMMERCE
    public final VerticalLayout laydialogLE_LENew_Total = new VerticalLayout(laydialogUs_NewTitulo, laydialogCmbPersona,
            laydialogLE_NombreNew, laydialogLE_OrdenNew2, laydialogLE_OrdenNew, laydialogLE_BtnsNew);
    // -----------------------------------------------------------------------------------------------------------
    // LAYOUTS FINALES
    public final HorizontalLayout laydialogLE_Exist_New = new HorizontalLayout(laydialogLE_LENew_Total);
    public final VerticalLayout laydialogUs_Final = new VerticalLayout(laydialogLE_Exist_New);
    public final Dialog dialogCrearUsuario = new Dialog(laydialogUs_Final);

    // ----------------------------------------------

    // DIALOG EDITAR USUARIO
    public final Label lbdialogUs_New2 = new Label("EDITAR USUARIO");
    public final HorizontalLayout laydialogUs_NewTitulo2 = new HorizontalLayout(lbdialogUs_New2);

    // Nombre y Descripcion de la Linea Ecommerce
    public final TextField txtdialogLE_UserID2 = new TextField("Usuario ID");
    // public final TextField txtdialogLE_DescripcionNew = new
    // TextField("Contraseña");
    public final PasswordField txtdialogLE_Pwd2 = new PasswordField("Contraseña");
    public final HorizontalLayout laydialogLE_NombreNew2 = new HorizontalLayout(txtdialogLE_UserID2, txtdialogLE_Pwd2);

    public final ComboBox<String> cmbPersona2 = new ComboBox<>("Elija una Persona");
    public final HorizontalLayout laydialogCmbPersona2 = new HorizontalLayout(cmbPersona2);

    // Orden y Activo de la Linea Ecommerce
    public final IntegerField txtdialogLE_Caja2 = new IntegerField("Caja ID");
    public final ComboBox<Almacen> cmbAlmacen2 = new ComboBox<>("Elija una almacén");
    public final Checkbox dialogLE_CheckActivationNewEdit = new Checkbox("¿Activo?");
    public final Checkbox dialogLE_CheckActivationNewEdit2 = new Checkbox("¿Comisiones?");
    public final HorizontalLayout laydialogLE_OrdenNewEdit = new HorizontalLayout(txtdialogLE_Caja2,
            dialogLE_CheckActivationNewEdit, dialogLE_CheckActivationNewEdit2);
    public final HorizontalLayout laydialogLE_OrdenNewEdit2 = new HorizontalLayout(cmbAlmacen2, txtdialogLE_Caja2);

    // Botones Nueva Linea Ecommerce
    public final Button btndialogLE_GuardarNew2 = new Button("Guardar");
    public final Button btndialogLE_CancelNew2 = new Button("Cancelar");

    public final HorizontalLayout laydialogLE_BtnsNew2 = new HorizontalLayout(btndialogLE_GuardarNew2,
            btndialogLE_CancelNew2);

    // LAYOUT TOTAL NUEVA LINEA ECOMMERCE
    public final VerticalLayout laydialogLE_LENew_Total2 = new VerticalLayout(laydialogUs_NewTitulo2,
            laydialogCmbPersona2, laydialogLE_NombreNew2, laydialogLE_OrdenNewEdit2, laydialogLE_OrdenNewEdit,
            laydialogLE_BtnsNew2);
    // -----------------------------------------------------------------------------------------------------------
    // LAYOUTS FINALES
    public final HorizontalLayout laydialogLE_Exist_New2 = new HorizontalLayout(laydialogLE_LENew_Total2);
    public final VerticalLayout laydialogUs_Final2 = new VerticalLayout(laydialogLE_Exist_New2);
    public final Dialog dialogEditarUsuario = new Dialog(laydialogUs_Final2);

    public final HorizontalLayout layoutBuscarCaracteristica = new HorizontalLayout(buscarByNombre, buscarUsuarios);

    public CaracteristicaUI() {

        initComponentTitulo();
        initDialogComponent();
        initButtonsEvents();
        initStyles();

        gridUsuarios.addColumn(Usuario::getNombrePersona).setHeader("Nombre").setAutoWidth(true);
        gridUsuarios.addColumn(Usuario::getIdentificadorPersona).setHeader("Identificador").setAutoWidth(true);
        gridUsuarios.addColumn(Usuario::getUsuario).setHeader("Nombre Usuario").setAutoWidth(true);

        gridUsuarioRoles.addColumn(UsuarioRol::getRolId).setHeader("Id").setAutoWidth(true);
        gridUsuarioRoles.addColumn(UsuarioRol::getNombreRol).setHeader("Nombre").setAutoWidth(true);

        add(layCPanelButtons);
        add(layCPanelButtons2);

        add(layTitle);
        add(layoutBuscarCaracteristica);
        add(gridUsuarios);
        add(new HorizontalLayout(btnAgregar, btnEditar, btnQuitar));
        // add(new HorizontalLayout(fechaDesde, fechaHasta, buscarByNumero,
        // buscarComprobantes));

        // add(new HorizontalLayout(verDetalles, btnOpenDialogGenerarComprobante));
    }

    public final void initComponentTitulo() {
        Label lblTitle = new Label("Gestión de Características");
        lblTitle.setClassName("titulo");
        layTitle.add(lblTitle);
        layTitle.addClassName("centered-content");
        buscarBySerie.setPlaceholder("[Buscar por Serie]");
        buscarByNombre.setPlaceholder("[Buscar por nombre de característica]");

    }

    public final void initDialogComponent() {

        dialogAddRoles.setWidth("300px");
        FormLayout columnLayout = new FormLayout();
        columnLayout.setResponsiveSteps(new FormLayout.ResponsiveStep("5em", 1),
                new FormLayout.ResponsiveStep("10em", 2));

        // Label lblTitle = new Label("GENERAR COMPROBANTE");
        // columnLayout.add(lblTitle,2);
        // columnLayout.add(new Label("¿Está seguro que desea generar el
        // comprobante?"),2);
        // columnLayout.add(btnGenerarComprobante,2);

        /*
         * dialogAddRoles.setWidth("400px"); FormLayout formUsuarioRol = new
         * FormLayout(); formUsuarioRol.setResponsiveSteps(new
         * FormLayout.ResponsiveStep("10em", 1), new FormLayout.ResponsiveStep("20em",
         * 2)); formUsuarioRol.add(comboRoles, 2); formUsuarioRol.add(gridUsuarioRoles,
         * 2); formUsuarioRol.add(btnAddRolToUsuario, 1);
         * formUsuarioRol.add(btnDeleteRolToUsuario, 1);
         * dialogAddRoles.add(formUsuarioRol);
         */

        dialogConfirmarDelete.setWidth("300px");
        FormLayout reenviarLayout = new FormLayout();
        reenviarLayout.setResponsiveSteps(new FormLayout.ResponsiveStep("10em", 1),
                new FormLayout.ResponsiveStep("10em", 2));

        reenviarLayout.add(new Label("¿Está seguro que quiere eliminar este usuario?"), 2);
        reenviarLayout.add(btnDelAceptar, btnDelCancelar);

        dialogConfirmarDelete.add(reenviarLayout);

    }

    public final void initDialogRoles() {
        dialogRoles.setWidth("500px");
        // dialogRoles.setCloseOnOutsideClick(false);

        /*
         * dialogRoles.add(closeDialogCobranzas); dialogRoles.add(new
         * ReciboView(String.valueOf(gridOrdenesVenta.asSingleSelect().getValue().getId(
         * ))));
         */
        // dialogRoles.add(new RolesView());
    }

    public final void initDialogPermisos() {
        dialogPermisos.setWidth("500px");
        // dialogPermisos.setCloseOnOutsideClick(false);

        /*
         * dialogPermisos.add(closeDialogCobranzas); dialogPermisos.add(new
         * ReciboView(String.valueOf(gridOrdenesVenta.asSingleSelect().getValue().getId(
         * ))));
         */
        // dialogPermisos.add(new PermisosView());
    }

    public final void initDialogUsuarios() {
        dialogUsuarios.setWidth("500px");
        // dialogUsuarios.add(new PermisosView());

        /*
         * dialogUsuarios.setWidth("400px"); FormLayout formUsuarioPersona = new
         * FormLayout(); formUsuarioPersona.setResponsiveSteps(new
         * FormLayout.ResponsiveStep("10em", 1), new FormLayout.ResponsiveStep("20em",
         * 2)); formUsuarioPersona.add(cmbPersona, 2); //
         * formUsuarioPersona.add(gridUsuarioRoles, 2);
         * formUsuarioPersona.add(btndialogLE_GuardarNew, 1);
         * formUsuarioPersona.add(btndialogLE_CancelNew, 1);
         * dialogCrearUsuario.add(formUsuarioPersona);
         */

    }

    public final void initButtonsEvents() {

        // -----------------------------------------------------------------------------------------------
        // CPANEL CABECERA
        // -----------------------------------------------------------------------------------------------
        btnClientes.addClickListener(e -> {
            removeAll();
            go_Clientes();
        });
        btnSubscriptores.addClickListener(e -> {
            removeAll();
            go_Subscriptores();
        });
        btnPromociones.addClickListener(e -> {
            removeAll();
            go_Promociones();
        });
        btnCupones.addClickListener(e -> {
            removeAll();
            go_Cupones();
        });
        btnPuntosUP.addClickListener(e -> {
            removeAll();
            go_PuntosUP();
        });
        btnProductos.addClickListener(e -> {
            removeAll();
            go_Productos();
        });
        // -----------------------------------------------------------------------------------------------
        btnPedidos.addClickListener(e -> {
            removeAll();
            go_Pedidos();
        });
        btnLineas.addClickListener(e -> {
            removeAll();
            go_LineasEcom();
        });
        /*
         * btnEcomPage.addClickListener(e -> { removeAll(); go_Index(); });
         */
        btnSalirCP.addClickListener(e -> {
            removeAll();
            // add(new App());
            go_CPanel();
        });
        // -----------------------------------------------------------------------------------------------

        // Envía al Menu Principal - Panel de Control
        /*
         * btnExit.addClickListener(e -> { removeAll(); go_CPanel(); // add(new
         * CPanelView()); }); // Envía al Menu Principal - Panel de Control
         * begining.addClickListener(e -> { removeAll(); go_CPanel(); // add(new
         * CPanelView()); }); // Envía al Menu Inicio closeAcct.addClickListener(e -> {
         * removeAll(); add(new App()); });
         */
        // btnedit_ecom.addClickListener(e-> dialogEcomm.open());
        /*
         * btnedit_ecom.addClickListener(e->{ on_Open_Ecomdialog(); dialogEcomm.open();
         * });
         */

        btnAddRolToUsuario.addClickListener(e -> {
            onAddUsuarioRol();
            notificationSuccess.setText("Se agrego satisfactoriamente");
            notificationSuccess.open();
            // dialogAddRoles.open();
        });

        buscarUsuarios.addClickListener(e -> {
            onGetUsuariosByNombre();
        });

        btnOpenAddRoles.addClickListener(e -> {
            if (!gridUsuarios.asSingleSelect().isEmpty()) {
                onGetUsuariosRoles();
                dialogAddRoles.open();
            } else {
                notificationError.setText("Necesita seleccionar un elemento");
                notificationError.open();
            }
        });

        btnOpenRoles.addClickListener(e -> {
            dialogRoles.removeAll();
            initDialogRoles();
            dialogRoles.open();
        });

        btnOpenPermisos.addClickListener(e -> {
            dialogPermisos.removeAll();
            initDialogPermisos();
            dialogPermisos.open();
        });

        btndialogLE_GuardarNew.addClickListener(e -> {
            onAddUsuario();
            dialogCrearUsuario.close();
            notificationSuccess.setText("Se agrego satisfactoriamente");
            notificationSuccess.open();
        });

        btndialogLE_CancelNew.addClickListener(e -> {
            dialogCrearUsuario.close();
        });

        // USUARIOS ACTIONS
        btnAgregar.addClickListener(e -> {
            on_Open_CrearUsuarioDialog();
            dialogCrearUsuario.open();
        });

        btnEditar.addClickListener(e -> {

            if (!gridUsuarios.asSingleSelect().isEmpty()) {
                on_Open_EditarUsuarioDialog();
                dialogEditarUsuario.open();
            } else {
                notificationError.setText("Necesita seleccionar un usuario de la lista");
                notificationError.open();
            }

        });

        btndialogLE_GuardarNew2.addClickListener(e -> {
            // dialogCrearUsuario.open();
            if (onEditUsuario()) {
                dialogEditarUsuario.close();
                notificationSuccess.setText("Se actualizo el usuario satisfactoriamente");
                notificationSuccess.open();
            } else {
                notificationError.setText("Error al actualizar el usuario");
                notificationError.open();
            }

        });

        btnQuitar.addClickListener(e -> {
            if (!gridUsuarios.asSingleSelect().isEmpty()) {
                dialogConfirmarDelete.open();
            } else {
                notificationError.setText("Necesita seleccionar un usuario de la lista");
                notificationError.open();
            }
        });

        btnDelAceptar.addClickListener(e -> {
            onDeleteUsuario();
            dialogConfirmarDelete.close();
            notificationSuccess.setText("Se eliminó satisfactoriamente");
            notificationSuccess.open();
        });

        btnDelCancelar.addClickListener(e -> {
            dialogConfirmarDelete.close();
        });

    }

    public final void initStyles() {

        // ------------------------------------------------------------------------------------------------
        // CABECERA CPANEL
        // ------------------------------------------------------------------------------------------------
        btnClientes.setWidthFull();
        btnClientes.getStyle().set("fontSize", "80%");

        btnSubscriptores.setWidthFull();
        btnSubscriptores.getStyle().set("fontSize", "80%");

        btnPromociones.setWidthFull();
        btnPromociones.getStyle().set("fontSize", "80%");

        btnProductos.setWidthFull();
        btnProductos.getStyle().set("fontSize", "80%");

        btnCupones.setWidthFull();
        btnCupones.getStyle().set("fontSize", "80%");

        btnPuntosUP.setWidthFull();
        btnPuntosUP.getStyle().set("fontSize", "80%");
        // ------------------------------------------------------------------------------------------------
        btnPedidos.setWidthFull();
        btnPedidos.getStyle().set("fontSize", "80%");

        buscarByNombre.getStyle().set("width", "250px");
        buscarUsuarios.setWidth("150px");

        layoutBuscarCaracteristica.getStyle().set("width", "400px");

        btnLineas.setWidthFull();
        btnLineas.getStyle().set("fontSize", "80%");

        // btnEcomPage.setWidthFull();
        // btnEcomPage.getStyle().set("fontSize", "80%");

        btnSalirCP.addThemeVariants(ButtonVariant.LUMO_ERROR);
        btnSalirCP.getStyle().set("fontSize", "80%");
        btnSalirCP.setWidthFull();

        layCPanelButtons.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        layCPanelButtons.setWidthFull();

        layCPanelButtons2.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        layCPanelButtons2.setWidthFull();

        notificationError.setDuration(3000);
        notificationError.setPosition(Notification.Position.TOP_CENTER);
        notificationError.addThemeVariants(NotificationVariant.LUMO_ERROR);

        notificationSuccess.setDuration(3000);
        notificationSuccess.setPosition(Notification.Position.TOP_CENTER);
        notificationSuccess.addThemeVariants(NotificationVariant.LUMO_SUCCESS);

        btnAgregar.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        btnQuitar.addThemeVariants(ButtonVariant.LUMO_ERROR);
        btnEditar.addThemeVariants(ButtonVariant.MATERIAL_CONTAINED);

        laydialogLE_Exist_New.getStyle().set("border", "1px solid #9E9E9E");

        laydialogUs_Final.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laydialogUs_Final.setAlignItems(FlexComponent.Alignment.BASELINE);
        laydialogUs_Final.setWidthFull();

        laydialogCmbPersona.getStyle().set("width", "300px");
        cmbPersona.getStyle().set("width", "300px");

        laydialogUs_NewTitulo.addClassName("centered-content");
        laydialogUs_NewTitulo.addClassName("titulo-bc");
        laydialogLE_BtnsNew.addClassName("centered-content");

        laydialogCmbPersona2.getStyle().set("width", "300px");
        cmbPersona2.getStyle().set("width", "300px");

        laydialogUs_NewTitulo2.addClassName("centered-content");
        laydialogUs_NewTitulo2.addClassName("titulo-bc");
        laydialogLE_BtnsNew2.addClassName("centered-content");

        laydialogUs_Final2.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laydialogUs_Final2.setAlignItems(FlexComponent.Alignment.BASELINE);
        laydialogUs_Final2.setWidthFull();

    }

    // CPANEL Rutas
    public abstract void go_CPanel();

    public abstract void go_Clientes();

    public abstract void go_Subscriptores();

    public abstract void go_Promociones();

    public abstract void go_Productos();

    public abstract void go_Cupones();

    public abstract void go_PuntosUP();

    public abstract void go_Pedidos();

    public abstract void go_LineasEcom();

    public abstract void go_Index();

    // ---------------------------------------------

    public abstract void onGetUsuariosRoles();

    public abstract void onAddUsuarioRol();

    public abstract void onGetUsuariosByNombre();

    public abstract void on_Open_CrearUsuarioDialog();

    public abstract void on_Open_EditarUsuarioDialog();

    public abstract void onGetPersonas();

    public abstract void onAddUsuario();

    public abstract Boolean onEditUsuario();

    public abstract void onDeleteUsuario();

    public abstract void onGetAlmacenes();

    public abstract void onGetAlmacenesEdit();

    public abstract void onGetPersonasEdit();

}
