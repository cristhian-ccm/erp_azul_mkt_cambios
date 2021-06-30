/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.view.ecom;

import com.upgrade.persistence.model.ecommerce.Suscripcion;
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
public abstract class SubscriptoresUI extends VerticalLayout{
    
    //-----------------------------------------------------------------------------------------------
    //CPANEL CABECERA
    //-----------------------------------------------------------------------------------------------
    public final Button btnClientes = new Button("Clientes Ecommerce", VaadinIcon.MALE.create());
    //public final Button btnSubscriptores = new Button("Gestión Subscrptores", VaadinIcon.MALE.create());
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
    public final HorizontalLayout layCPanelButtons = new HorizontalLayout(btnClientes,btnPromociones,btnCupones,btnPuntosUP);
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
    Label titulo = new Label("SUBSCRIPTORES E-COMMERCE");
    
    public final HorizontalLayout head = new HorizontalLayout(titulo);
    //-----------------------------------------------------------------------------------------------
    // WORKSPACE
    //-----------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------
    // BUSQUEDAS
    //-----------------------------------------------------------------------------------------------
    Label titulo_buscar = new Label("BUSQUEDA DE SUBSCRIPTORES");
    public final HorizontalLayout lay_titulo_bus = new HorizontalLayout(titulo_buscar);
    //-----------------------------------------------------------------------------------------------
    public final DatePicker FechIni_bus = new DatePicker("Fecha Inicio");
    public final DatePicker FechFin_bus = new DatePicker("Fecha Fin");
    public final Button btnFind_Fecha = new Button("Buscar",VaadinIcon.SEARCH.create());
    
    public final HorizontalLayout lay_FindFecha = new HorizontalLayout(FechIni_bus,FechFin_bus,btnFind_Fecha);
    //-----------------------------------------------------------------------------------------------
    
    public final VerticalLayout lay_Busquedas =  new VerticalLayout(lay_titulo_bus,lay_FindFecha);
    //-----------------------------------------------------------------------------------------------
    //TABLE - INFORMATION
    //-----------------------------------------------------------------------------------------------
    public final Grid<Suscripcion> grid = new Grid<>();
    public final VerticalLayout layGrid = new VerticalLayout(grid);
    
    public final Label lbInformation = new Label("*Nota: Seleccione el subscriptor antes de Editar");
    public final HorizontalLayout layInformation = new HorizontalLayout(lbInformation);
    
    public final Button btnver_prod = new Button("Ver/Editar", VaadinIcon.EYE.create());
    public final HorizontalLayout layBttnVer_Prod = new HorizontalLayout(btnver_prod);
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
    //-----------------------------------------------------------------------------------------------
    //FOOTER
    //-----------------------------------------------------------------------------------------------
    public final Button btnExit = new Button("Salir");
    //-----------------------------------------------------------------------------------------------
    public final HorizontalLayout fButtons = new HorizontalLayout(btnExit);
    //-----------------------------------------------------------------------------------------------
    //NOTIFICATION
    //-----------------------------------------------------------------------------------------------    
    public final Label notf_select_exceed = new Label("Más de un Subscriptor ha sido seleccionado. Por favor, seleccione sólo uno");
    public final Notification notify_select_exceed = new Notification(notf_select_exceed);
    //-----------------------------------------------------------------------------------------------
    //END MAIN VIEW
    //-----------------------------------------------------------------------------------------------
    
    
    //-----------------------------------------------------------------------------------------------
    //DIALOG SUBSCRIPCION
    //-----------------------------------------------------------------------------------------------
    public final Label titulo_dialog = new Label("SUBSCRIPTOR");
    public final HorizontalLayout layTitulo_dialog = new HorizontalLayout(titulo_dialog);
    //-----------------------------------------------------------------------------------------------
    public final Label lbdialog_SubActivo = new Label("Es Subscriptor Activo?");
    public final Checkbox checkSAct = new Checkbox();
    public final HorizontalLayout laydialogSAct = new HorizontalLayout(lbdialog_SubActivo,checkSAct);
    //-----------------------------------------------------------------------------------------------
    public final Label lbInfo_dialog = new Label("Importante: El subscriptor debe estar activo");
    public final HorizontalLayout layInfo_dialog = new HorizontalLayout(lbInfo_dialog);
    //-----------------------------------------------------------------------------------------------
    public final TextField txtdialog_SubCupon = new TextField("Código Cupon");
    public final HorizontalLayout laydialog_SubCupon = new HorizontalLayout(txtdialog_SubCupon);
    //-----------------------------------------------------------------------------------------------
    public final TextField txtdialog_SubTlf = new TextField("Telefono");
    //public final DatePicker datedialog_SubFNacimiento = new DatePicker("Fecha Nacimiento");
    public final TextField txtdatedialog_SubFNacimiento = new TextField("Fecha Nacimiento");
    public final TextField txtdialog_Subname = new TextField("Nombre(s)");
    
    public final HorizontalLayout laydialog_SubName = new HorizontalLayout(txtdialog_Subname,txtdialog_SubTlf,txtdatedialog_SubFNacimiento);
    //-----------------------------------------------------------------------------------------------
    public final TextField txtdialog_SubEmail = new TextField("Email");
    public final HorizontalLayout laydialog_SubEmail = new HorizontalLayout(txtdialog_SubEmail);
    //-----------------------------------------------------------------------------------------------
    public final Button btnSubtGrabar = new Button("Grabar Cambios");
    public final Button btnSubExit = new Button("Salir");
    public final HorizontalLayout laydialogBtns2 = new HorizontalLayout(btnSubExit);
    //-----------------------------------------------------------------------------------------------
    //CREATE DIALOG SUBSCRIPCION
    //-----------------------------------------------------------------------------------------------
    public final VerticalLayout laydialogSubscriptor = new VerticalLayout(layTitulo_dialog,laydialogSAct,layInfo_dialog,
                                                                          laydialog_SubName,laydialog_SubEmail,laydialogBtns2);
    public final Dialog dialogSubscriptor = new Dialog(laydialogSubscriptor);
    //-----------------------------------------------------------------------------------------------
    //END DIALOG SUBSCRIPCION
    //-----------------------------------------------------------------------------------------------
    
    
    
    
    
    
    //-----------------------------------------------------------------------------------------------
    //INIT MAIN PROCESS
    //-----------------------------------------------------------------------------------------------
    public SubscriptoresUI() {
        
        removeAll();
        add(layCPanelButtons,layCPanelButtons2, head, lay_Busquedas, layButtonsGrid, layGrid, layInformation, fButtons);
        btnFind_Fecha.addClickListener(e->On_find_Fechas());
        initStyles();
        initEvents();
    }
    
    private void initStyles() {
        
        //------------------------------------------------------------------------------------------------
        //CABECERA CPANEL
        //------------------------------------------------------------------------------------------------
        btnClientes.setWidthFull();
        btnClientes.getStyle().set("fontSize","80%");
        
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
        titulo_buscar.getStyle().set("fontWeight","bold");
        titulo_buscar.getStyle().set("fontSize","150%");
        
        lay_titulo_bus.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        lay_titulo_bus.setWidthFull();
        //-----------------------------------------------------------------------------------------------
        lay_FindFecha.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        lay_FindFecha.setAlignItems(FlexComponent.Alignment.BASELINE);
        lay_FindFecha.setWidthFull();
        
        lay_Busquedas.getStyle().set("border", "1px solid #9E9E9E");
        lay_Busquedas.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        lay_Busquedas.setAlignItems(FlexComponent.Alignment.CENTER);
        lay_Busquedas.setWidthFull();
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
        grid.addColumn(Suscripcion::getNombre).setAutoWidth(true).setSortable(true).setHeader("Nombre");
        grid.addColumn(Suscripcion::getFecha_nacimiento).setAutoWidth(true).setSortable(true).setHeader("Fecha Nacimiento");
        grid.addColumn(Suscripcion::getEmail).setAutoWidth(true).setSortable(true).setHeader("Email");
        grid.addColumn(Suscripcion::getTelefono).setAutoWidth(true).setSortable(true).setHeader("Telefono");
        grid.addColumn(Suscripcion::getCuponNombre).setAutoWidth(true).setSortable(true).setHeader("Nombre Cupón");
        
        
        grid.setSelectionMode(Grid.SelectionMode.MULTI);
        MultiSelect<Grid<Suscripcion>, Suscripcion> multiSelect = grid.asMultiSelect();
        //-----------------------------------------------------------------------------------------------
        //btnver_prod.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        btnver_prod.getStyle().set("fontSize","90%");
        
        layBttnVer_Prod.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        layBttnVer_Prod.setAlignItems(FlexComponent.Alignment.CENTER);
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
        //NOTIFICATION
        //-----------------------------------------------------------------------------------------------    
        notf_select_exceed.getStyle().set("fontSize","90%");
        notf_select_exceed.getStyle().set("color", "red");
        
        notify_select_exceed.setDuration(2500);
        notify_select_exceed.setPosition(Notification.Position.MIDDLE); 
        //-----------------------------------------------------------------------------------------------
        
        //-----------------------------------------------------------------------------------------------
        //DIALOG SUBSCRIPCION
        //-----------------------------------------------------------------------------------------------
        titulo_dialog.getStyle().set("fontWeight","bold");
        titulo_dialog.getStyle().set("fontSize","150%");
        
        layTitulo_dialog.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layTitulo_dialog.setAlignItems(FlexComponent.Alignment.CENTER);
        layTitulo_dialog.setWidthFull(); 
        //-----------------------------------------------------------------------------------------------
        checkSAct.setReadOnly(true);
        
        laydialogSAct.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laydialogSAct.setAlignItems(FlexComponent.Alignment.BASELINE);
        laydialogSAct.setWidthFull(); 
        //-----------------------------------------------------------------------------------------------
        lbInfo_dialog.getStyle().set("color", "red");
        lbInfo_dialog.getStyle().set("fontStyle","italic");
        lbInfo_dialog.getStyle().set("fontSize","80%");
        
        layInfo_dialog.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        layInfo_dialog.setAlignItems(FlexComponent.Alignment.CENTER);
        layInfo_dialog.setWidthFull(); 
        //----------------------------------------------------------------------------------------------- 
        txtdialog_SubCupon.setReadOnly(true);
        
        laydialog_SubCupon.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laydialog_SubCupon.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialog_SubCupon.setWidthFull();
        //-----------------------------------------------------------------------------------------------
        txtdialog_SubTlf.setWidthFull();
        txtdialog_SubTlf.setReadOnly(true);
        
        txtdatedialog_SubFNacimiento.setWidthFull();
        txtdatedialog_SubFNacimiento.setReadOnly(true);
        
        //datedialog_SubFNacimiento.setWidthFull();
        //datedialog_SubFNacimiento.setReadOnly(true);
        
        txtdialog_Subname.setWidthFull();
        txtdialog_Subname.setReadOnly(true);
        
        laydialog_SubName.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laydialog_SubName.setAlignItems(FlexComponent.Alignment.BASELINE);
        laydialog_SubName.setWidthFull(); 
        //-----------------------------------------------------------------------------------------------
        txtdialog_SubEmail.setWidthFull();
        txtdialog_SubEmail.setReadOnly(true);
        
        laydialog_SubEmail.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laydialog_SubEmail.setAlignItems(FlexComponent.Alignment.BASELINE);
        laydialog_SubEmail.setWidthFull();  
        //-----------------------------------------------------------------------------------------------
        btnSubExit.addThemeVariants(ButtonVariant.LUMO_ERROR);
        btnSubExit.getStyle().set("fontSize","90%");
        
        laydialogBtns2.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laydialogBtns2.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialogBtns2.setWidthFull(); 
        //-----------------------------------------------------------------------------------------------
        //CREATE DIALOG SUBSCRIPCION
        //-----------------------------------------------------------------------------------------------
        laydialogSubscriptor.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laydialogSubscriptor.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialogSubscriptor.setWidthFull();
                
        dialogSubscriptor.setCloseOnEsc(true);
        dialogSubscriptor.setCloseOnOutsideClick(true);
        //-----------------------------------------------------------------------------------------------
        //END DIALOG SUBSCRIPCION
        //-----------------------------------------------------------------------------------------------
        
        
    }
    
    //-----------------------------------------------------------------------------------------------
    //CPANEL Rutas
    //-----------------------------------------------------------------------------------------------
    public abstract void go_CPanel();
    
    public abstract void go_Clientes();
    public abstract void go_Promociones();
    public abstract void go_Cupones();
    public abstract void go_PuntosUP();
    
    public abstract void go_Pedidos();
    public abstract void go_LineasEcom();
    public abstract void go_Productos();
    public abstract void go_Index();
    
    //-----------------------------------------------------------------------------------------------
    //Busquedas
    //-----------------------------------------------------------------------------------------------
    public abstract void On_find_Fechas();
    
    //-----------------------------------------------------------------------------------------------
    //DIALOG SUBSCRIPCION
    //-----------------------------------------------------------------------------------------------
    public abstract void on_Open_Subdialog();
    //-----------------------------------------------------------------------------------------------
    
    
    //-----------------------------------------------------------------------------------------------
    //Reporteador
    //-----------------------------------------------------------------------------------------------
    public abstract void init_Table_defaultExcel();
    public abstract void init_ReporterToolbar();
    public abstract void init_ReporterToolbar2();
    //-----------------------------------------------------------------------------------------------
    
    private void initEvents() {
        //-----------------------------------------------------------------------------------------------
        //CPANEL CABECERA
        //-----------------------------------------------------------------------------------------------
        btnClientes.addClickListener(e->{
            removeAll();
            go_Clientes();
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
            on_Open_Subdialog();
        });
        //-----------------------------------------------------------------------------------------------
        //REPORTEADOR
        //-----------------------------------------------------------------------------------------------
        Toolbar.btnRefresh.addClickListener(e->{ 
            Toolbar.on_Refresh(grid);
        });
        //-----------------------------------------------------------------------------------------------
        //DIALOG SUBSCRIPCION
        //-----------------------------------------------------------------------------------------------
        //-----------------------------------------------------------------------------------------------
        btnSubExit.addClickListener(e->{ 
            dialogSubscriptor.close();
        });
        //-----------------------------------------------------------------------------------------------
    }

}
