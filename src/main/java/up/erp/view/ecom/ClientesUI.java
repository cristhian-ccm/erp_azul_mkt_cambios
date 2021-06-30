package up.erp.view.ecom;

import com.upgrade.persistence.model.ecommerce.UsuarioWeb;
import com.upgrade.persistence.model.tcros.Persona;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.contextmenu.SubMenu;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.BoxSizing;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.renderer.NativeButtonRenderer;
import com.vaadin.flow.data.selection.MultiSelect;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;
import java.util.ArrayList;
import java.util.List;
import up.erp.view.App;
import up.erp.view.dashboards.*;
import up.erp.view.exporter.ToolBar;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Luis Aleman
 */
public abstract class ClientesUI extends VerticalLayout{
    
    //-----------------------------------------------------------------------------------------------
    //CPANEL CABECERA
    //-----------------------------------------------------------------------------------------------
    public final Button btnSubscriptores = new Button("Subscriptores Ecommerce", VaadinIcon.MALE.create());
    public final Button btnPromociones = new Button("Promociones Ecommerce", VaadinIcon.GIFT.create());
    public final Button btnCupones = new Button("Cupones Ecommerce", VaadinIcon.TICKET.create());
    public final Button btnPuntosUP = new Button("Puntos UP Ecommerce", VaadinIcon.TROPHY.create());
    //-----------------------------------------------------------------------------------------------
    public final Button btnPedidos = new Button("Pedidos Ecommerce", VaadinIcon.CART_O.create());
    public final Button btnLineas = new Button("Lineas Ecommerce", VaadinIcon.RECORDS.create());
    public final Button btnProductos = new Button("Productos Ecommerce", VaadinIcon.PACKAGE.create());
    public final Button btnEcomPage = new Button("Página Ecommerce", VaadinIcon.GLOBE_WIRE.create());
    //-----------------------------------------------------------------------------------------------
    public final Button btnSalirCP = new Button("Salir del Panel de Control");
    //-----------------------------------------------------------------------------------------------
    public final HorizontalLayout layCPanelButtons = new HorizontalLayout(btnSubscriptores,btnPromociones,btnCupones,btnPuntosUP);
    //-----------------------------------------------------------------------------------------------
    public final HorizontalLayout layCPanelButtons2 = new HorizontalLayout(btnPedidos,btnLineas,btnProductos,btnEcomPage,btnSalirCP);
    //-----------------------------------------------------------------------------------------------
    //END CABECERA
    //-----------------------------------------------------------------------------------------------
    
    
    //-----------------------------------------------------------------------------------------------
    //MAIN VIEW
    //-----------------------------------------------------------------------------------------------
    // HEADER
    //-----------------------------------------------------------------------------------------------
    //Span title = new Span("My application");
    Label titulo = new Label("CLIENTES E-COMMERCE");
    
    public final Span title = new Span("Bienvenido");
    public final HorizontalLayout head = new HorizontalLayout(titulo);
    //-----------------------------------------------------------------------------------------------
    // WORKSPACE
    //-----------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------
    // BUSQUEDAS
    //-----------------------------------------------------------------------------------------------
    public final Label titulo_buscar = new Label("BUSQUEDA DE USUARIOS");
    public final HorizontalLayout lay_titulo_bus = new HorizontalLayout(titulo_buscar);
    //-----------------------------------------------------------------------------------------------
    //BUSQUEDA DE USUARIOS REGISTRADOS
    //-----------------------------------------------------------------------------------------------
    public final Label lb_titUsuariosReg = new Label("USUARIOS REGISTRADOS");
    public final HorizontalLayout lay_lb_titUsuariosReg = new HorizontalLayout(lb_titUsuariosReg);
    //-----------------------------------------------------------------------------------------------
    public final TextField txtname = new TextField("Ingresar Nombre");
    public final Button btnFind_Activos = new Button("Buscar",VaadinIcon.SEARCH.create());
    public final HorizontalLayout layBtnFind = new HorizontalLayout(txtname,btnFind_Activos);
    //-----------------------------------------------------------------------------------------------
    public final Button btnFind_NoActivos = new Button("Buscar No Clientes Activos",VaadinIcon.SEARCH.create());
    
    //-----------------------------------------------------------------------------------------------
    public final DatePicker FechIni_bus = new DatePicker("Fecha Inicio");
    public final DatePicker FechFin_bus = new DatePicker("Fecha Fin");
    public final Button btnFind_Fecha = new Button("Buscar",VaadinIcon.SEARCH.create());
    
    public final HorizontalLayout lay_FindFecha = new HorizontalLayout(FechIni_bus,FechFin_bus,btnFind_Fecha);
    //-----------------------------------------------------------------------------------------------
    public final VerticalLayout lay_Busq1 =  new VerticalLayout(lay_lb_titUsuariosReg,layBtnFind,lay_FindFecha);
    //-----------------------------------------------------------------------------------------------
    //BUSQUEDA DE USUARIOS QUE REALIZARON COMPRAS
    //-----------------------------------------------------------------------------------------------
    public final Label lb_titUsuariosComp = new Label("USUARIOS QUE COMPRARON");
    public final HorizontalLayout lay_lb_titUsuariosComp = new HorizontalLayout(lb_titUsuariosComp);
    //-----------------------------------------------------------------------------------------------
    public final DatePicker FechIni_bus2 = new DatePicker("Fecha Inicio");
    public final DatePicker FechFin_bus2 = new DatePicker("Fecha Fin");
    public final Button btnFind_FechaComp = new Button("Buscar",VaadinIcon.SEARCH.create());
    public final ComboBox<String> comboBoxAlmacen = new ComboBox<>("Almacen");
    public final TextField txtAlmacen = new TextField("Almacen Seleccionado");
    
    public final HorizontalLayout lay_FindUsuComp = new HorizontalLayout(FechIni_bus2,FechFin_bus2,btnFind_FechaComp,
                                                                         comboBoxAlmacen,txtAlmacen);
    //-----------------------------------------------------------------------------------------------
    public final VerticalLayout lay_Busq2 =  new VerticalLayout(lay_lb_titUsuariosComp,lay_FindUsuComp);
    //-----------------------------------------------------------------------------------------------
    //LAYOUT FINAL
    //-----------------------------------------------------------------------------------------------
    public final VerticalLayout lay_Busquedas =  new VerticalLayout(lay_titulo_bus,lay_Busq1,lay_Busq2);
    //-----------------------------------------------------------------------------------------------
    //TABLE - INFORMATION
    //-----------------------------------------------------------------------------------------------
    //public final Grid<Persona> grid = new Grid<>(Persona.class);
    public final Grid<UsuarioWeb> grid = new Grid<>();
    public final VerticalLayout layGrid = new VerticalLayout(grid);
    
    public final Label lbInformation = new Label("*Nota: Seleccione el usuario antes de Editar");
    public final HorizontalLayout layInformation = new HorizontalLayout(lbInformation);
    
    //public final Button btnver_prod = new Button("Ver");
    public final Button btnver_prod = new Button("Ver/Editar", VaadinIcon.EYE.create());
    public final HorizontalLayout layBttnVer_Prod = new HorizontalLayout(btnver_prod);
    
    public final Button btnEmail_service = new Button("Email", VaadinIcon.ENVELOPE_OPEN_O.create());
    public final HorizontalLayout layBtnEmail_service = new HorizontalLayout(btnEmail_service);
    
    //-----------------------------------------------------------------------------------------------
    //REPORTEADOR TOOLBAR
    //-----------------------------------------------------------------------------------------------
    //TOOLBAR : DEFINICION VARIABLES
    //-----------------------------------------------------------------------------------------------
    public final ToolBar Toolbar = new ToolBar();
    public final HorizontalLayout laydToolbar = new HorizontalLayout(Toolbar);
    //-----------------------------------------------------------------------------------------------
    //END REPORTEADOR TOOLBAR
    //-----------------------------------------------------------------------------------------------
    
    public final HorizontalLayout layButtonsGrid = new HorizontalLayout(layBttnVer_Prod,laydToolbar);
    //public final HorizontalLayout layButtonsGrid = new HorizontalLayout(layBttnVer_Prod);
    //-----------------------------------------------------------------------------------------------
    //FOOTER
    //-----------------------------------------------------------------------------------------------
    public final Button btnsave = new Button("Agregar a Clientes Activos");
    public final Button btndelete = new Button("Quitar de Clientes Activos");
    public final Button btndashboard = new Button("Estadistica");
    public final Button btnExit = new Button("Salir");
    //-----------------------------------------------------------------------------------------------
    public final HorizontalLayout fButtons = new HorizontalLayout(btnExit);
    //-----------------------------------------------------------------------------------------------
    //END MAIN VIEW
    //-----------------------------------------------------------------------------------------------
    
    
    //-----------------------------------------------------------------------------------------------
    //DIALOG USUARIO
    //-----------------------------------------------------------------------------------------------
    public final Label titulo_dialog = new Label("EDIT USUARIO");
    public final HorizontalLayout layTitulo_dialog = new HorizontalLayout(titulo_dialog);
    //-----------------------------------------------------------------------------------------------
    public final Label lbInfo_dialog = new Label("Importante: El usuario debe estar activo");
    public final HorizontalLayout layInfo_dialog = new HorizontalLayout(lbInfo_dialog);
    //-----------------------------------------------------------------------------------------------
    public final Label lbdialogClientAc = new Label("Es Cliente Activo?");
    public final Checkbox checkCAc = new Checkbox();
    public final HorizontalLayout laydialogCAc = new HorizontalLayout(lbdialogClientAc,checkCAc);
    public final Button btnClean_dialog = new Button("Limpiar Formulario");
    public final HorizontalLayout laydialog_clean = new HorizontalLayout(btnClean_dialog);
    public final HorizontalLayout laydialog_CAcFinal = new HorizontalLayout(laydialogCAc);
    //-----------------------------------------------------------------------------------------------
    public final TextField txtdialog_ClientName = new TextField("Nombre(s)");
    public final HorizontalLayout laydialog_ClientName = new HorizontalLayout(txtdialog_ClientName);
    //-----------------------------------------------------------------------------------------------
    public final TextField txtdialog_ClientApe = new TextField("Apellido(s)");
    public final HorizontalLayout laydialog_ClientApe = new HorizontalLayout(txtdialog_ClientApe);
    //-----------------------------------------------------------------------------------------------
    public final PasswordField Pswdialog_Client = new PasswordField("Password");
    public final HorizontalLayout laydialog_ClientPsw = new HorizontalLayout(Pswdialog_Client);
    //-----------------------------------------------------------------------------------------------
    public final EmailField dialog_ClientEmail = new EmailField("Email");
    public final HorizontalLayout laydialog_ClientEmail = new HorizontalLayout(dialog_ClientEmail);
    //-----------------------------------------------------------------------------------------------
    public final TextField txtdialog_ClientTlf = new TextField("Telefono");
    public final HorizontalLayout laydialog_ClientTlf = new HorizontalLayout(txtdialog_ClientTlf);
    //-----------------------------------------------------------------------------------------------
    public final Button btnClientGrabar = new Button("Grabar Cambios");
    public final Button btnClientCancel = new Button("Salir");
    //public final HorizontalLayout laydialogBtns = new HorizontalLayout(btnClientGrabar,btnClientCancel);
    public final HorizontalLayout laydialogBtns2 = new HorizontalLayout(btnClientCancel);
    //-----------------------------------------------------------------------------------------------
    //CREATE DIALOG USUARIO
    //-----------------------------------------------------------------------------------------------
    public final VerticalLayout laydialogClient = new VerticalLayout(layTitulo_dialog,laydialog_CAcFinal,layInfo_dialog,laydialog_ClientName,
                                                      laydialog_ClientApe,laydialog_ClientEmail,laydialog_ClientTlf,laydialogBtns2);
    public final Dialog dialogClient = new Dialog(laydialogClient);
    //-----------------------------------------------------------------------------------------------
    //NOTIFICATION USUARIO
    //-----------------------------------------------------------------------------------------------
    public final Label Client_notf_correct = new Label("Datos Actualizados Correctamente");
    public final Notification Client_notify_correct = new Notification(Client_notf_correct);
    
    public final Label notf_select_exceed = new Label("Más de un Cliente ha sido seleccionado. Por favor, seleccione sólo uno");
    public final Notification notify_select_exceed = new Notification(notf_select_exceed);
    //-----------------------------------------------------------------------------------------------
    //END DIALOG USUARIO
    //-----------------------------------------------------------------------------------------------
    
    
    
    
    //-----------------------------------------------------------------------------------------------
    //DIALOG EMAIL
    //-----------------------------------------------------------------------------------------------
    public final Label dialog_titEmail = new Label("SERVICIO DE EMAIL");
    public final HorizontalLayout laydialog_titEmail = new HorizontalLayout(dialog_titEmail);
    //-----------------------------------------------------------------------------------------------
    //EMISOR
    //-----------------------------------------------------------------------------------------------
    public final TextField dialog_txtEmisor = new TextField("Emisor");
    public final HorizontalLayout laydialog_txtEmisor = new HorizontalLayout(dialog_txtEmisor);
    //-----------------------------------------------------------------------------------------------
    //DESTINATARIOS
    //-----------------------------------------------------------------------------------------------
    public final TextArea dialog_txtDestinarios = new TextArea("Destinarios");
    public final HorizontalLayout laydialog_txtDestinarios = new HorizontalLayout(dialog_txtDestinarios);
    //-----------------------------------------------------------------------------------------------
    //DESCRIPCION EMAIL
    //-----------------------------------------------------------------------------------------------
    public final Label dialog_infoDescrip = new Label("Copiar y pegar el HTML con el contenido del email");
    public final HorizontalLayout laydialog_infoDescrip = new HorizontalLayout(dialog_infoDescrip);
    
    public final TextArea dialog_txtDescripcion = new TextArea("Descripción Email");
    public final HorizontalLayout laydialog_txtDescripcion = new HorizontalLayout(dialog_txtDescripcion);
    //-----------------------------------------------------------------------------------------------
    //CONFIRMAR EMAIL
    //-----------------------------------------------------------------------------------------------
    public final Button dialog_btnConfirmar = new Button("Confirmar Email");
    public final Button dialog_btnSalir = new Button("Salir");
    public final HorizontalLayout laydialog_Btns = new HorizontalLayout(dialog_btnConfirmar,dialog_btnSalir);
    //-----------------------------------------------------------------------------------------------
    //CREATE DIALOG EMAIL
    //-----------------------------------------------------------------------------------------------
    public final VerticalLayout laydialogEMAIL = new VerticalLayout(laydialog_titEmail,laydialog_txtEmisor,laydialog_txtDestinarios,
                                                                    laydialog_infoDescrip,laydialog_txtDescripcion,laydialog_Btns);
    
    public final Dialog dialogEMAIL = new Dialog(laydialogEMAIL);
    //-----------------------------------------------------------------------------------------------
    
    
    //-----------------------------------------------------------------------------------------------
    //INIT MAIN PROCESS
    //-----------------------------------------------------------------------------------------------
    public ClientesUI() {
        
        removeAll();
        add(layCPanelButtons,layCPanelButtons2, head, lay_Busquedas, layButtonsGrid, layGrid, layInformation, fButtons);
        btnFind_Activos.addClickListener(e->On_find_Activos());
        btnFind_NoActivos.addClickListener(e->On_find_NoActivos());
        btnFind_Fecha.addClickListener(e->On_find_Fechas());
        //btnFind_FechaComp.addClickListener(e->On_find_UsuComp());
        btnFind_FechaComp.addClickListener(e->On_find_UsuComp_byAlmacen());
        btndelete.addClickListener(e->On_putInactivo_Cli());
        btnsave.addClickListener(e->On_putActivo_Cli());
        initStyles();
        initEvents();
    }
    
    private void initStyles() {
        
        //------------------------------------------------------------------------------------------------
        //CABECERA CPANEL
        //------------------------------------------------------------------------------------------------
        btnSubscriptores.setWidthFull();
        btnSubscriptores.getStyle().set("fontSize","80%");
        
        btnPromociones.setWidthFull();
        btnPromociones.getStyle().set("fontSize","80%");
        
        btnCupones.setWidthFull();
        btnCupones.getStyle().set("fontSize","80%");
        
        btnPuntosUP.setWidthFull();
        btnPuntosUP.getStyle().set("fontSize","80%");
        //------------------------------------------------------------------------------------------------
        btnPedidos.setWidthFull();
        btnPedidos.getStyle().set("fontSize","80%");
        
        btnLineas.setWidthFull();
        btnLineas.getStyle().set("fontSize","80%");
                
        btnProductos.setWidthFull();
        btnProductos.getStyle().set("fontSize","80%");
        
        btnEcomPage.setWidthFull();
        btnEcomPage.getStyle().set("fontSize","80%");
        
        btnSalirCP.addThemeVariants(ButtonVariant.LUMO_ERROR);
        btnSalirCP.getStyle().set("fontSize","80%");
        btnSalirCP.setWidthFull();
        //------------------------------------------------------------------------------------------------
        layCPanelButtons.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        layCPanelButtons.setWidthFull();
        
        layCPanelButtons2.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        layCPanelButtons2.setWidthFull();
        //-----------------------------------------------------------------------------------------------
        //END CABECERA
        //-----------------------------------------------------------------------------------------------
        
        //HEAD
        titulo.getStyle().set("fontWeight","bold");
        titulo.getStyle().set("fontSize","300%");
        head.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        head.setWidthFull();
        
        //layBtnFind.getStyle().set("border", "1px solid #9E9E9E");
        //-----------------------------------------------------------------------------------------------
        // BUSQUEDAS
        //-----------------------------------------------------------------------------------------------
        titulo_buscar.getStyle().set("fontWeight","bold");
        titulo_buscar.getStyle().set("fontSize","150%");
        
        lay_titulo_bus.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        lay_titulo_bus.setWidthFull();
        //-----------------------------------------------------------------------------------------------
        //BUSQUEDA DE USUARIOS REGISTRADOS
        //-----------------------------------------------------------------------------------------------
        lb_titUsuariosReg.getStyle().set("fontWeight","bold");
        lb_titUsuariosReg.getStyle().set("fontSize","120%");
        
        lay_lb_titUsuariosReg.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        lay_lb_titUsuariosReg.setWidthFull(); 
        //-----------------------------------------------------------------------------------------------
        //txtname 
        //btnFind_Activos
                
        layBtnFind.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        layBtnFind.setAlignItems(FlexComponent.Alignment.BASELINE);
        layBtnFind.setWidthFull(); 
        //-----------------------------------------------------------------------------------------------
        //FechIni_bus
        //FechFin_bus 
        //btnFind_Fecha

        lay_FindFecha.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        lay_FindFecha.setAlignItems(FlexComponent.Alignment.BASELINE);
        lay_FindFecha.setWidthFull();
        //-----------------------------------------------------------------------------------------------
        lay_Busq1.getStyle().set("border", "1px solid #9E9E9E");
        lay_Busq1.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        lay_Busq1.setAlignItems(FlexComponent.Alignment.CENTER);
        lay_Busq1.setWidthFull(); 
        //-----------------------------------------------------------------------------------------------
        //BUSQUEDA DE USUARIOS QUE REALIZARON COMPRAS
        //-----------------------------------------------------------------------------------------------
        lb_titUsuariosComp.getStyle().set("fontWeight","bold");
        lb_titUsuariosComp.getStyle().set("fontSize","120%");
        
        lay_lb_titUsuariosComp.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        lay_lb_titUsuariosComp.setWidthFull();  
        //-----------------------------------------------------------------------------------------------
        //FechIni_bus2
        //FechFin_bus2 
        //btnFind_FechaComp 
        
        comboBoxAlmacen.setPlaceholder("Elija el Almacen a filtrar"); 
        comboBoxAlmacen.addValueChangeListener(event->{
            if(!event.getValue().contentEquals("No definido")){
                txtAlmacen.setValue(event.getValue());
            }
        });
        //txtAlmacen

        lay_FindUsuComp.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        lay_FindUsuComp.setAlignItems(FlexComponent.Alignment.BASELINE);
        lay_FindUsuComp.setWidthFull(); 
        //-----------------------------------------------------------------------------------------------
        lay_Busq2.getStyle().set("border", "1px solid #9E9E9E");
        lay_Busq2.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        lay_Busq2.setAlignItems(FlexComponent.Alignment.CENTER);
        lay_Busq2.setWidthFull(); 
        //-----------------------------------------------------------------------------------------------
        //LAYOUT FINAL
        //-----------------------------------------------------------------------------------------------
        lay_Busquedas.getStyle().set("border", "1px solid #9E9E9E");
        lay_Busquedas.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        lay_Busquedas.setAlignItems(FlexComponent.Alignment.CENTER);
        lay_Busquedas.setWidthFull();  
        //-----------------------------------------------------------------------------------------------
        //-----------------------------------------------------------------------------------------------
        //lbInformation.getStyle().set("fontWeight","bold");
        lbInformation.getStyle().set("color", "red");
        lbInformation.getStyle().set("fontStyle","italic");
        lbInformation.getStyle().set("fontSize","80%");
        
        //layInformation.getStyle().set("border", "1px solid #9E9E9E");
        layInformation.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        layInformation.setAlignItems(FlexComponent.Alignment.CENTER);
        layInformation.setWidthFull();
        
        //WORKSPACE
        //GRID
        layGrid.getStyle().set("border", "1px solid #9E9E9E");
        layGrid.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layGrid.setAlignItems(FlexComponent.Alignment.CENTER);
        layGrid.setWidthFull();
        
        //grid.removeAllColumns();
        grid.addColumn(UsuarioWeb::getNombres).setAutoWidth(true).setSortable(true).setHeader("Nombre");
        grid.addColumn(UsuarioWeb::getApellidos).setAutoWidth(true).setSortable(true).setHeader("Apellidos");
        grid.addColumn(UsuarioWeb::getEmail).setAutoWidth(true).setSortable(true).setHeader("Email");
        grid.addColumn(UsuarioWeb::getTelefono).setAutoWidth(true).setSortable(true).setHeader("Telefono");
        
        grid.setSelectionMode(Grid.SelectionMode.MULTI);
        MultiSelect<Grid<UsuarioWeb>, UsuarioWeb> multiSelect = grid.asMultiSelect();
        /*
        grid.addColumn(new NativeButtonRenderer<>("Editar",item -> {
            grid.setDetailsVisible(item, !grid.isDetailsVisible(item));
            on_Open_Clientdialog();
            dialogClient.open();
        })).addAttachListener(e->{
            multiSelect.addValueChangeListener(event -> {
            if (event.getValue().isEmpty()){
                e.getSource().setVisible(false);
            } 
            else
                e.getSource().setVisible(true);
            });
        });*/
        //-----------------------------------------------------------------------------------------------
        //btnver_prod.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        btnver_prod.getStyle().set("fontSize","90%");
        
        layBttnVer_Prod.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        layBttnVer_Prod.setAlignItems(FlexComponent.Alignment.CENTER);
        //layBttnVer_Prod.setWidthFull();
        btnEmail_service.getStyle().set("fontSize","90%");
                
        layBtnEmail_service.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        layBtnEmail_service.setAlignItems(FlexComponent.Alignment.CENTER);
        //------------------------------------------------------------------------------------------------
        //TOOLBAR
        //------------------------------------------------------------------------------------------------
        laydToolbar.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laydToolbar.setAlignItems(FlexComponent.Alignment.CENTER);
        laydToolbar.setWidthFull();
        
        layButtonsGrid.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        layButtonsGrid.setAlignItems(FlexComponent.Alignment.CENTER);
        layButtonsGrid.setWidthFull();
        //-----------------------------------------------------------------------------------------------
        //FOOTER
        //-----------------------------------------------------------------------------------------------
        fButtons.getStyle().set("border", "1px solid #9E9E9E");
        fButtons.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        fButtons.setAlignItems(FlexComponent.Alignment.CENTER);
        fButtons.setWidthFull();
        //----------------------------------------------------------------------
        
        //-----------------------------------------------------------------------------------------------
        //DIALOG CLIENT
        //-----------------------------------------------------------------------------------------------
        titulo_dialog.getStyle().set("fontWeight","bold");
        titulo_dialog.getStyle().set("fontSize","150%");
        
        layTitulo_dialog.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layTitulo_dialog.setAlignItems(FlexComponent.Alignment.CENTER);
        layTitulo_dialog.setWidthFull(); 
        
        lbInfo_dialog.getStyle().set("color", "red");
        lbInfo_dialog.getStyle().set("fontStyle","italic");
        lbInfo_dialog.getStyle().set("fontSize","80%");
        
        //layInformation.getStyle().set("border", "1px solid #9E9E9E");
        layInfo_dialog.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        layInfo_dialog.setAlignItems(FlexComponent.Alignment.CENTER);
        layInfo_dialog.setWidthFull(); 
        
        checkCAc.setReadOnly(true);
        
        laydialogCAc.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laydialogCAc.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialogCAc.setWidthFull();
        
        laydialog_clean.setJustifyContentMode(FlexComponent.JustifyContentMode.END);
        laydialog_clean.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialog_clean.setWidthFull();
        
        laydialog_CAcFinal.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laydialog_CAcFinal.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialog_CAcFinal.setWidthFull();
        
        
        txtdialog_ClientName.setWidthFull();
        txtdialog_ClientName.setReadOnly(true);
        
        laydialog_ClientName.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laydialog_ClientName.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialog_ClientName.setWidthFull();
        
        txtdialog_ClientApe.setWidthFull();
        txtdialog_ClientApe.setReadOnly(true);
        
        laydialog_ClientApe.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laydialog_ClientApe.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialog_ClientApe.setWidthFull();
        
        Pswdialog_Client.setPlaceholder("Ingresar Password");
        Pswdialog_Client.setWidthFull();
        Pswdialog_Client.setReadOnly(true);
        
        laydialog_ClientPsw.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laydialog_ClientPsw.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialog_ClientPsw.setWidthFull();
        
        dialog_ClientEmail.setErrorMessage("Por favor ingrese un Email válido");
        dialog_ClientEmail.setWidthFull();
        dialog_ClientEmail.setReadOnly(true);
        dialog_ClientEmail.setWidth("500%");
             
        laydialog_ClientEmail.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laydialog_ClientEmail.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialog_ClientEmail.setWidthFull();
        
        txtdialog_ClientTlf.setWidthFull();
        txtdialog_ClientTlf.setReadOnly(true);
        
        laydialog_ClientTlf.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laydialog_ClientTlf.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialog_ClientTlf.setWidthFull();
        
        laydialogBtns2.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laydialogBtns2.setWidthFull();
        
        btnClientGrabar.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        btnClientGrabar.getStyle().set("fontSize","90%");
        btnClientCancel.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        btnClientCancel.getStyle().set("fontSize","90%");
                
        dialogClient.setCloseOnEsc(true);
        dialogClient.setCloseOnOutsideClick(true);
        //-----------------------------------------------------------------------------------------------
        //NOTIFICATION
        //-----------------------------------------------------------------------------------------------
        notf_select_exceed.getStyle().set("fontSize","90%");
        notf_select_exceed.getStyle().set("color", "red");
        
        Client_notify_correct.setDuration(2000);
        Client_notify_correct.setPosition(Notification.Position.MIDDLE);
        
        notify_select_exceed.setDuration(2500);
        notify_select_exceed.setPosition(Notification.Position.MIDDLE); 
        //----------------------------------------------------------------------
        
        
        
        //-----------------------------------------------------------------------------------------------
        //DIALOG EMAIL
        //-----------------------------------------------------------------------------------------------
        dialog_titEmail.getStyle().set("fontWeight","bold");
        dialog_titEmail.getStyle().set("fontSize","150%");
        
        laydialog_titEmail.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laydialog_titEmail.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialog_titEmail.setWidthFull();
        //-----------------------------------------------------------------------------------------------
        //EMISOR
        //-----------------------------------------------------------------------------------------------
        dialog_txtEmisor.setWidthFull();
        
        laydialog_txtEmisor.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laydialog_txtEmisor.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialog_txtEmisor.setWidthFull();
        //-----------------------------------------------------------------------------------------------
        //DESTINATARIOS
        //-----------------------------------------------------------------------------------------------
        dialog_txtDestinarios.setWidth("%1000"); 
                
        laydialog_txtDestinarios.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laydialog_txtDestinarios.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialog_txtDestinarios.setWidthFull(); 
        //-----------------------------------------------------------------------------------------------
        //DESCRIPCION EMAIL
        //-----------------------------------------------------------------------------------------------
        dialog_infoDescrip.setWidthFull();
        dialog_infoDescrip.getStyle().set("fontSize","90%");
        dialog_infoDescrip.getStyle().set("color", "red");
                
        laydialog_infoDescrip.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laydialog_infoDescrip.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialog_infoDescrip.setWidthFull(); 

        dialog_txtDescripcion.setWidthFull();
        
        laydialog_txtDescripcion.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laydialog_txtDescripcion.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialog_txtDescripcion.setWidthFull();  
        //-----------------------------------------------------------------------------------------------
        //CONFIRMAR EMAIL
        //-----------------------------------------------------------------------------------------------
        dialog_btnConfirmar.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        dialog_btnConfirmar.getStyle().set("fontSize","90%");
        
        dialog_btnSalir.addThemeVariants(ButtonVariant.LUMO_ERROR);
        dialog_btnSalir.getStyle().set("fontSize","90%"); 
                
        laydialog_Btns.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laydialog_Btns.setAlignItems(FlexComponent.Alignment.BASELINE);
        laydialog_Btns.setWidthFull();
        //-----------------------------------------------------------------------------------------------
        //CREATE DIALOG EMAIL
        //-----------------------------------------------------------------------------------------------
        laydialogEMAIL.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laydialogEMAIL.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialogEMAIL.setWidthFull();

        dialogEMAIL.setCloseOnEsc(true);
        dialogEMAIL.setCloseOnOutsideClick(true);
        //-----------------------------------------------------------------------------------------------
        
    }
    
    //CPANEL Rutas
    public abstract void go_CPanel();
    
    public abstract void go_Subscriptores();
    public abstract void go_Promociones();
    public abstract void go_Cupones();
    public abstract void go_PuntosUP();
    
    public abstract void go_Pedidos();
    public abstract void go_LineasEcom();
    public abstract void go_Productos();
    public abstract void go_Index();
    
    //Init ComboBox Almacenes
    public abstract void init_Almacenes();
    
    //Busquedas
    public abstract void On_find_Activos();
    public abstract void On_find_NoActivos();
    public abstract void On_find_Fechas();
    public abstract void On_find_UsuComp();
    public abstract void On_find_UsuComp_byAlmacen();
    
    //Cambio de estado Clientes
    public abstract void On_putInactivo_Cli();
    public abstract void On_putActivo_Cli();
    
    
    //Editar Cliente
    public abstract void Clean_Clientdialog();
    public abstract void on_Open_Clientdialog();
    public abstract void on_Grabar_Client();
    
    //Reporteador
    public abstract void init_Table_defaultExcel();
    public abstract void init_ReporterToolbar();
    public abstract void init_ReporterToolbar2();
    
    //Email
    public abstract void on_Open_Emaildialog();
    
    private void initEvents() {
        init_Almacenes();
        //-----------------------------------------------------------------------------------------------
        //CPANEL CABECERA
        //-----------------------------------------------------------------------------------------------
        btnSubscriptores.addClickListener(e->{
            removeAll();
            go_Subscriptores();
        });
        btnPromociones.addClickListener(e->{
            removeAll();
            go_Promociones();
        });
        btnCupones.addClickListener(e->{
            removeAll();
            go_Cupones();
        });
        btnPuntosUP.addClickListener(e->{
            removeAll();
            go_PuntosUP();
        });
        //-----------------------------------------------------------------------------------------------
        btnPedidos.addClickListener(e->{
            removeAll();
            go_Pedidos();
        });
        btnLineas.addClickListener(e->{
            removeAll();
            go_LineasEcom();
        });
        btnProductos.addClickListener(e->{
            removeAll();
            go_Productos();
        });
        btnEcomPage.addClickListener(e->{
            removeAll();
            go_Index();
        });
        btnSalirCP.addClickListener(e->{
            removeAll();
            //add(new App());
            go_CPanel();
        });
        //-----------------------------------------------------------------------------------------------
        
        //Envía al Menu Principal - Panel de Control
        btnExit.addClickListener(e->{
            removeAll();
            go_CPanel();
            //add(new CPanelView());
        });
        //-----------------------------------------------------------------------------------------------
        //VER/EDITAR CLIENTE
        //-----------------------------------------------------------------------------------------------
        btnver_prod.addClickListener(e->{ 
            on_Open_Clientdialog();
        });
        //-----------------------------------------------------------------------------------------------
        //REPORTEADOR
        //-----------------------------------------------------------------------------------------------
        Toolbar.btnRefresh.addClickListener(e->{ 
            Toolbar.on_Refresh(grid);
        });
        //-----------------------------------------------------------------------------------------------
        //DIALOG CLIENT
        //-----------------------------------------------------------------------------------------------
        btnClientGrabar.addClickListener(e->{ 
            on_Grabar_Client();
            dialogClient.close();
            Client_notify_correct.open();
        });
        //-----------------------------------------------------------------------------------------------
        btnClientCancel.addClickListener(e->{ 
            dialogClient.close();
        });
        //-----------------------------------------------------------------------------------------------
        btnClean_dialog.addClickListener(e-> Clean_Clientdialog());
        //-----------------------------------------------------------------------------------------------
        
        //-----------------------------------------------------------------------------------------------
        //DIALOG EMAIL
        //-----------------------------------------------------------------------------------------------
        btnEmail_service.addClickListener(e->{ 
            on_Open_Emaildialog();
        });
        //-----------------------------------------------------------------------------------------------
        dialog_btnSalir.addClickListener(e->{ 
            dialogEMAIL.close();
        });
        //-----------------------------------------------------------------------------------------------
    }

}
