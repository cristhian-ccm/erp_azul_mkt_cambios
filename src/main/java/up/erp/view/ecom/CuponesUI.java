/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.view.ecom;

import com.upgrade.persistence.model.cmrlz.NotaPedidoDet;
import com.upgrade.persistence.model.ecommerce.Cupones;
import com.upgrade.persistence.model.ecommerce.PedidoEcommerce;
import com.upgrade.persistence.model.ecommerce.UsuarioWeb;
import com.upgrade.persistence.model.extcs.Producto;
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
import com.vaadin.flow.component.grid.Grid.SelectionMode;
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
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.renderer.NativeButtonRenderer;
import com.vaadin.flow.data.selection.MultiSelect;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import up.erp.view.App;
import up.erp.view.exporter.ToolBar;
/**
 *
 * @author Luis Aleman
 */
public abstract class CuponesUI extends VerticalLayout{
    
    //----------------------------------------------------------------------------------------------------
    //CPANEL CABECERA
    //----------------------------------------------------------------------------------------------------
    public final Button btnClientes = new Button("Clientes Ecommerce", VaadinIcon.MALE.create());
    public final Button btnSubscriptores = new Button("Subscriptores Ecommerce", VaadinIcon.MALE.create());
    public final Button btnPromociones = new Button("Promociones Ecommerce", VaadinIcon.GIFT.create());
    //public final Button btnCupones = new Button("Gestión Cupones", VaadinIcon.TICKET.create());
    public final Button btnPuntosUP = new Button("Puntos UP Ecommerce", VaadinIcon.TROPHY.create());
    //-----------------------------------------------------------------------------------------------
    public final Button btnPedidos = new Button("Pedidos Ecommerce", VaadinIcon.CART_O.create());
    public final Button btnLineas = new Button("Lineas Ecommerce", VaadinIcon.RECORDS.create());
    public final Button btnProductos = new Button("Productos Ecommerce", VaadinIcon.PACKAGE.create());
    public final Button btnEcomPage = new Button("Página Ecommerce", VaadinIcon.GLOBE_WIRE.create());
    //-----------------------------------------------------------------------------------------------
    public final Button btnSalirCP = new Button("Salir del Panel de Control");
    //-----------------------------------------------------------------------------------------------
    
    public final HorizontalLayout layCPanelButtons = new HorizontalLayout(btnClientes,btnSubscriptores,btnPromociones,btnPuntosUP);
    //-----------------------------------------------------------------------------------------------
    public final HorizontalLayout layCPanelButtons2 = new HorizontalLayout(btnPedidos,btnLineas,btnProductos,btnEcomPage,btnSalirCP);
    //----------------------------------------------------------------------------------------------------
    
    //----------------------------------------------------------------------------------------------------
    // HEADER
    //----------------------------------------------------------------------------------------------------
    Label titulo = new Label("CUPONES");
    
    public final HorizontalLayout head = new HorizontalLayout(titulo);
    //----------------------------------------------------------------------------------------------------
    
    //----------------------------------------------------------------------------------------------------
    // WORKSPACE
    //----------------------------------------------------------------------------------------------------
    //----------------------------------------------------------------------------------------------------
    //BUSQUEDAS
    //----------------------------------------------------------------------------------------------------
    Label titulo_buscar = new Label("BUSQUEDA DE CUPONES");
    
    public final HorizontalLayout lay_titulo_bus = new HorizontalLayout(titulo_buscar);
    //----------------------------------------------------------------------------------------------------
    //BUSQUEDA CUPON - NOMBRE/CODIGO
    
    public final TextField txtInput_NameCupon = new TextField("Ingrese Código Cupon");
    public final Button btnFind_NameCupon = new Button("Buscar");
    
    public final HorizontalLayout lay_Find_NameCupon = new HorizontalLayout(txtInput_NameCupon,btnFind_NameCupon);
    //----------------------------------------------------------------------------------------------------
    //BUSQUEDA CUPON - FECHA INICIO/FIN
    
    public final DatePicker FechIni_bus = new DatePicker("Fecha Inicio");
    public final DatePicker FechFin_bus = new DatePicker("Fecha Fin");
    public final Button btnFind_Fecha = new Button("Buscar",VaadinIcon.SEARCH.create());
    
    public final HorizontalLayout lay_FindFecha = new HorizontalLayout(FechIni_bus,FechFin_bus,btnFind_Fecha);
    //-----------------------------------------------------------------------------------------------
    //BUSQUEDA CUPON - ACTIVO - INACTIVO 
    
    public final Label lbActivo_Inactivo = new Label("Buscar Cupones:");
    public final Button btnFind_Activo = new Button("Activos");
    public final Button btnFind_Inactivo = new Button("Inactivos");
    
    public final HorizontalLayout lay_Find_Act_Inact = new HorizontalLayout(lbActivo_Inactivo,btnFind_Activo,btnFind_Inactivo);
    //----------------------------------------------------------------------------------------------------
    //LAYOUT FINALES
    //public final HorizontalLayout lay_Bus = new HorizontalLayout(lay_Find_NameCupon,lay_Find_Act_Inact);
    
    public final VerticalLayout lay_Busquedas =  new VerticalLayout(lay_titulo_bus,lay_Find_NameCupon,lay_FindFecha,lay_Find_Act_Inact);
    //----------------------------------------------------------------------------------------------------
    
    //----------------------------------------------------------------------------------------------------
    //GRID - BODY
    //----------------------------------------------------------------------------------------------------
    public final Grid<Cupones> grid = new Grid<>();
    
    public final VerticalLayout layGrid = new VerticalLayout(grid);
    //----------------------------------------------------------------------------------------------------
    //INFORMATION
    public final Label lbInformation = new Label("*Nota: Seleccione el cupón antes de Editar");
    
    public final HorizontalLayout layInformation = new HorizontalLayout(lbInformation);
    //----------------------------------------------------------------------------------------------------
    public final Button btnver_prod = new Button("Ver/Editar", VaadinIcon.EYE.create());
    public final HorizontalLayout layBttnVer_Prod = new HorizontalLayout(btnver_prod);
    //-----------------------------------------------------------------------------------------------
    
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
    //----------------------------------------------------------------------------------------------------
    //FOOT - BOTONES DE ACCION FINAL
    //----------------------------------------------------------------------------------------------------
    public final Button btnNewCupon = new Button("Nuevo Cupon");
    public final Button btnCambiar_Activo = new Button("Activar Cupon(es)");
    public final Button btnCambiar_Inactivo = new Button("Desactivar Cupon(es)");
    public final Button btnAsignar_Monto = new Button("Asignar Monto");
    public final Button btnExit = new Button("Salir");

    public final HorizontalLayout fButtons = new HorizontalLayout(btnNewCupon,btnCambiar_Activo,btnCambiar_Inactivo,btnAsignar_Monto,btnExit);
    //----------------------------------------------------------------------------------------------------
    //END MAIN VIEW
    //------------------------------------------------------------------------------------------------
    
    //------------------------------------------------------------------------------------------------
    //DIALOG EXISTENTE - EDIT CUPON
    //------------------------------------------------------------------------------------------------
    //TITULO GENERAL
    
    public final Label lbdialogCU_titulo = new Label("EDITAR CUPONES");
    public final HorizontalLayout laydialogCU_titulo  = new HorizontalLayout(lbdialogCU_titulo);
    //------------------------------------------------------------------------------------------------
    //CUERPO DIALOG
    //----------------------------------------------------------------------------------------------------
    //CUPON: Nombre y Activo
    
    public final TextField txtdialogCU_Nombre = new TextField("Nombre Cupon");
    public final Checkbox chckdialogCU_Activate = new Checkbox("Está activo?");
    public final HorizontalLayout laydialogCU_Nombre = new HorizontalLayout(txtdialogCU_Nombre,chckdialogCU_Activate);
    //----------------------------------------------------------------------------------------------------
    //CUPON: Monto y Precio Min Prod
    
    public final TextField txtdialogCU_Monto = new TextField("Monto");
    public final TextField txtdialogCU_PrecioMin = new TextField("Precio Min Prod");
    public final DatePicker datedialogCU_FechaIniVig = new DatePicker("Fecha Inicio Vigencia");
    public final DatePicker datedialogCU_FechaFinVig = new DatePicker("Fecha Fin Vigencia");
    public final TextField txtdialogCU_Cantidad = new TextField("Cantidad");
    public final HorizontalLayout laydialogCU_Monto = new HorizontalLayout(txtdialogCU_Monto,txtdialogCU_PrecioMin,datedialogCU_FechaIniVig,datedialogCU_FechaFinVig,txtdialogCU_Cantidad);
    //----------------------------------------------------------------------------------------------------
    //CUPON: Botones de accion
    
    public final Button btndialogCU_Guardar = new Button("Guardar Cambios");
    public final Button btndialogCU_Delete = new Button("Eliminar Cupon");
    public final Button btndialogCU_Cancel = new Button("Salir");
    public final HorizontalLayout laydialogCU_Btns = new HorizontalLayout(btndialogCU_Guardar,btndialogCU_Delete);
    public final HorizontalLayout laydialogCU_Btns2 = new HorizontalLayout(btndialogCU_Cancel);
    //----------------------------------------------------------------------------------------------------
    //CUPON: GRID USUARIOS
    
    public final TextField txtdialogCU_IdCupon = new TextField("Id Cupon");
    public final Button btndialogCU_BusqUsuAsign = new Button("Usuarios Asignados");
    public final HorizontalLayout laydialogCU_Gridpart1 = new HorizontalLayout(txtdialogCU_IdCupon,btndialogCU_BusqUsuAsign);
    
    
    public final DatePicker datedialogCU_UsuFechaIni = new DatePicker("Fecha Inicio");
    public final DatePicker datedialogCU_UsuFechaFin = new DatePicker("Fecha Fin");
    public final Button btndialogCU_UsuBusq = new Button("Buscar Usuarios");
    public final HorizontalLayout laydialogCU_Gridpart2 = new HorizontalLayout(datedialogCU_UsuFechaIni,datedialogCU_UsuFechaFin,btndialogCU_UsuBusq);
    
   
    public final Grid<UsuarioWeb> grid_usuarios = new Grid<>();
    public final VerticalLayout layGrid_Usu = new VerticalLayout(grid_usuarios);
    
    public final Button btndialogCU_AsignUsu = new Button("Asignar Usuario(s)");
    public final Button btndialogCU_UnasignUsu = new Button("Desasignar Usuario(s)");
    public final HorizontalLayout laydialogCU_Gridpart3 = new HorizontalLayout(btndialogCU_AsignUsu,btndialogCU_UnasignUsu);
    
    public final VerticalLayout laydialogCU_GridAll = new VerticalLayout(laydialogCU_Gridpart1,laydialogCU_Gridpart2,layGrid_Usu,laydialogCU_Gridpart3);

    //----------------------------------------------------------------------------------------------------
    
    //LAYOUT TOTAL CUPON EXISTENTE
    public final VerticalLayout laydialogCU_Total = new VerticalLayout(laydialogCU_titulo,laydialogCU_Nombre,laydialogCU_Monto,laydialogCU_Btns,laydialogCU_Btns2,laydialogCU_GridAll);
    //------------------------------------------------------------------------------------------------
    //----------------------------------------------------------------------------------------------------
    //CUPON: DIALOG
    public final Dialog dialog_CuponExist = new Dialog(laydialogCU_Total);
    //----------------------------------------------------------------------------------------------------
    //CUPON: NOTIFICATION
    public final Label dialogCU_notf_is_Updated = new Label("El Cupón ha sido actualizado");
    public final Label dialogCU_notf_is_Deleted = new Label("El Cupón ha sido eliminado");
    
    public final Notification notifyCU_is_Updated = new Notification(dialogCU_notf_is_Updated);
    public final Notification notifyCU_is_Deleted = new Notification(dialogCU_notf_is_Deleted);
    //------------------------------------------------------------------------------------------------
    //END DIALOG CUPON EXISTENTE
    //------------------------------------------------------------------------------------------------
    
    
    //------------------------------------------------------------------------------------------------
    //DIALOG NUEVO CUPON - EDIT CUPON
    //------------------------------------------------------------------------------------------------
    //TITULO GENERAL
    
    public final Label lbdialogNCU_titulo = new Label("NUEVO CUPON");
    public final HorizontalLayout laydialogNCU_titulo  = new HorizontalLayout(lbdialogNCU_titulo);
    //------------------------------------------------------------------------------------------------
    //CUERPO DIALOG
    
    //NUEVO CUPON: Nombre y Activo
    public final TextField txtdialogNCU_Nombre = new TextField("Nombre Cupon");
    public final Checkbox chckdialogNCU_Activate = new Checkbox("Está activo?");
    public final HorizontalLayout laydialogNCU_Nombre = new HorizontalLayout(txtdialogNCU_Nombre,chckdialogNCU_Activate);
    
    //NUEVO CUPON: Monto y Precio Min Prod
    public final TextField txtdialogNCU_Monto = new TextField("Monto");
    public final TextField txtdialogNCU_PrecioMin = new TextField("Precio Min Prod");
    public final DatePicker datedialogNCU_FechaIniVig = new DatePicker("Fecha Inicio Vigencia");
    public final DatePicker datedialogNCU_FechaFinVig = new DatePicker("Fecha Fin Vigencia");
    public final TextField txtdialogNCU_Cantidad = new TextField("Cantidad");
    public final HorizontalLayout laydialogNCU_Monto = new HorizontalLayout(txtdialogNCU_Monto,txtdialogNCU_PrecioMin,datedialogNCU_FechaIniVig,datedialogNCU_FechaFinVig,txtdialogNCU_Cantidad);
    
    //NUEVO CUPON: Botones de accion
    public final Button btndialogNCU_Guardar = new Button("Crear Cupon");
    public final Button btndialogNCU_Cancel = new Button("Cancelar");
    public final HorizontalLayout laydialogNCU_Btns = new HorizontalLayout(btndialogNCU_Guardar,btndialogNCU_Cancel);
    
    //LAYOUT TOTAL NUEVO CUPON
    public final VerticalLayout laydialogNCU_Total = new VerticalLayout(lbdialogNCU_titulo,laydialogNCU_Nombre,laydialogNCU_Monto,laydialogNCU_Btns);
    //------------------------------------------------------------------------------------------------
    //----------------------------------------------------------------------------------------------------
    //CUPON: DIALOG
    public final Dialog dialog_NewCupon = new Dialog(laydialogNCU_Total);
    //----------------------------------------------------------------------------------------------------
    //CUPON: NOTIFICATION
    public final Label dialogNCU_notf_is_Created = new Label("El Cupón ha sido creado");
    
    public final Notification notifyNCU_is_Created = new Notification(dialogNCU_notf_is_Created);
    
    public final Label notf_select_exceed = new Label("Más de un Cupón ha sido seleccionado. Por favor, seleccione sólo uno");
    public final Notification notify_select_exceed = new Notification(notf_select_exceed);
    //----------------------------------------------------------------------------------------------------
    //END DIALOG NUEVO CUPON 
    //------------------------------------------------------------------------------------------------
    
    //------------------------------------------------------------------------------------------------
    //DIALOG ASIGNAR MONTO
    //------------------------------------------------------------------------------------------------
    //TITULO GENERAL
    
    public final Label lbdialogAMCU_titulo = new Label("ASIGNAR MONTO");
    public final HorizontalLayout laydialogAMCU_titulo  = new HorizontalLayout(lbdialogAMCU_titulo);
    //------------------------------------------------------------------------------------------------
    //CUERPO DIALOG
    
    //ASIGNAR MONTO: Monto
    public final TextField txtdialogAMCU_Monto = new TextField("Monto de Cupones");
    public final Button btndialogAMCU_AsignarMonto = new Button("Asignar Monto");
    public final HorizontalLayout laydialogAMCU_Asignar = new HorizontalLayout(txtdialogAMCU_Monto,btndialogAMCU_AsignarMonto);
    //------------------------------------------------------------------------------------------------
    //ASIGNAR MONTO: Cancel
    public final Button btndialogAMCU_Cancel = new Button("Cancelar");
    public final HorizontalLayout laydialogAMCU_Cancel = new HorizontalLayout(btndialogAMCU_Cancel);
    //------------------------------------------------------------------------------------------------
    //LAYOUT TOTAL NUEVO CUPON
    public final VerticalLayout laydialogAMCU_Total = new VerticalLayout(laydialogAMCU_titulo,laydialogAMCU_Asignar,laydialogAMCU_Cancel);
    //------------------------------------------------------------------------------------------------
    //----------------------------------------------------------------------------------------------------
    //CUPON: DIALOG
    public final Dialog dialog_AsignMonto = new Dialog(laydialogAMCU_Total);
    //----------------------------------------------------------------------------------------------------
    //CUPON: NOTIFICATION
    public final Label dialogAMCU_notf_is_MontoAsign = new Label("El monto ha sido asignado a los cupones seleccionados");
    
    public final Notification notifyAMCU_is_MontoAsign = new Notification(dialogAMCU_notf_is_MontoAsign);
    //----------------------------------------------------------------------------------------------------
    //END DIALOG ASIGNAR MONTO
    //------------------------------------------------------------------------------------------------
    
    
    //----------------------------------------------------------------------------------------------------
    //INIT CuponesUI
    //----------------------------------------------------------------------------------------------------
    public CuponesUI() {
        removeAll();
        addAndExpand(layCPanelButtons,layCPanelButtons2,head,lay_Busquedas,layButtonsGrid, layGrid,layInformation,fButtons);
        btnFind_NameCupon.addClickListener(e->On_find_NameCupon());
        btnFind_Activo.addClickListener(e->On_find_CuponActivo());
        btnFind_Inactivo.addClickListener(e->On_find_CuponInactivo());
        initStyles();
        initEvents();
        setSizeFull();
    }
    //----------------------------------------------------------------------------------------------------
    
    //----------------------------------------------------------------------------------------------------
    //ESTILOS
    //----------------------------------------------------------------------------------------------------
    private void initStyles() {
        //------------------------------------------------------------------------------------------------
        //CABECERA CPANEL
        //------------------------------------------------------------------------------------------------
        btnClientes.setWidthFull();
        btnClientes.getStyle().set("fontSize","80%");
        
        btnSubscriptores.setWidthFull();
        btnSubscriptores.getStyle().set("fontSize","80%");
        
        btnPromociones.setWidthFull();
        btnPromociones.getStyle().set("fontSize","80%");
        
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
        
        //------------------------------------------------------------------------------------------------
        // HEAD
        //------------------------------------------------------------------------------------------------
        titulo.getStyle().set("fontWeight","bold");
        titulo.getStyle().set("fontSize","300%");
        //------------------------------------------------------------------------------------------------
        head.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        head.setWidthFull();
        //------------------------------------------------------------------------------------------------
        
        //------------------------------------------------------------------------------------------------
        // WORKSPACE
        //------------------------------------------------------------------------------------------------
        //------------------------------------------------------------------------------------------------
        //BUSQUEDAS
        //------------------------------------------------------------------------------------------------
        titulo_buscar.getStyle().set("fontWeight","bold");
        titulo_buscar.getStyle().set("fontSize","150%");
        //------------------------------------------------------------------------------------------------
        lay_titulo_bus.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        lay_titulo_bus.setWidthFull();
        //------------------------------------------------------------------------------------------------
        //BUSQUEDA CUPON - NOMBRE
        //------------------------------------------------------------------------------------------------
        btnFind_NameCupon.addThemeVariants(ButtonVariant.LUMO_SUCCESS); 
        btnFind_NameCupon.getStyle().set("fontSize","90%");
        //------------------------------------------------------------------------------------------------
        //lay_Find_NameCupon.getStyle().set("border", "1px solid #9E9E9E");
        lay_Find_NameCupon.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        lay_Find_NameCupon.setAlignItems(FlexComponent.Alignment.BASELINE);
        lay_Find_NameCupon.setWidthFull();
        //------------------------------------------------------------------------------------------------
        //BUSQUEDA CUPON - FECHA INICIO/FIN
        //------------------------------------------------------------------------------------------------
        btnFind_Fecha.addThemeVariants(ButtonVariant.LUMO_SUCCESS); 
        btnFind_Fecha.getStyle().set("fontSize","90%"); 
        //------------------------------------------------------------------------------------------------
        lay_FindFecha.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        lay_FindFecha.setAlignItems(FlexComponent.Alignment.BASELINE);
        lay_FindFecha.setWidthFull();
        //------------------------------------------------------------------------------------------------
        //BUSQUEDA CUPON - ACTIVO - INACTIVO
        //------------------------------------------------------------------------------------------------
        btnFind_Activo.addThemeVariants(ButtonVariant.LUMO_SUCCESS); 
        btnFind_Activo.getStyle().set("fontSize","90%");
        btnFind_Inactivo.addThemeVariants(ButtonVariant.LUMO_ERROR); 
        btnFind_Inactivo.getStyle().set("fontSize","90%");
        //------------------------------------------------------------------------------------------------
        //lay_Find_Act_Inact.getStyle().set("border", "1px solid #9E9E9E");
        lay_Find_Act_Inact.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        lay_Find_Act_Inact.setAlignItems(FlexComponent.Alignment.BASELINE);
        lay_Find_Act_Inact.setWidthFull();   
        //------------------------------------------------------------------------------------------------
        //LAYOUT FINALES
        //------------------------------------------------------------------------------------------------
        /*
        lay_Bus.getStyle().set("border", "1px solid #9E9E9E");
        lay_Bus.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        lay_Bus.setAlignItems(FlexComponent.Alignment.BASELINE);
        lay_Bus.setWidthFull();
        */
        
        lay_Busquedas.getStyle().set("border", "1px solid #9E9E9E");
        lay_Busquedas.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        lay_Busquedas.setAlignItems(FlexComponent.Alignment.CENTER);
        lay_Busquedas.setWidthFull();   
        //------------------------------------------------------------------------------------------------
        
        //------------------------------------------------------------------------------------------------
        //GRID - BODY
        //------------------------------------------------------------------------------------------------
        grid.addColumn(Cupones::getNombreCupon).setAutoWidth(true).setSortable(true).setHeader("Nombre Cupon");
        grid.addColumn(Cupones::getMonto).setAutoWidth(true).setSortable(true).setHeader("Monto");
        grid.addColumn(Cupones::getActivo).setAutoWidth(true).setSortable(true).setHeader("Activo?");
        grid.addColumn(Cupones::getPrecioMinProd).setAutoWidth(true).setSortable(true).setHeader("Precio Min Prod");
        grid.addColumn(Cupones::getFechaIniVigencia).setAutoWidth(true).setSortable(true).setHeader("Fecha Inicio Vigencia");
        grid.addColumn(Cupones::getFechaFinVigencia).setAutoWidth(true).setSortable(true).setHeader("Fecha Fin Vigencia");
        //------------------------------------------------------------------------------------------------
        grid.setSelectionMode(Grid.SelectionMode.MULTI);
        
        MultiSelect<Grid<Cupones>, Cupones> multiSelect = grid.asMultiSelect();
        //------------------------------------------------------------------------------------------------
        /*
        grid.addColumn(new NativeButtonRenderer<>("Ver/Editar",item -> {
        grid.setDetailsVisible(item, !grid.isDetailsVisible(item));
            On_OpenDialog_CuponExist();
            dialog_CuponExist.open();
        })).addAttachListener(e->{
            multiSelect.addValueChangeListener(event -> {
            if (event.getValue().isEmpty()){
                e.getSource().setVisible(false);
            } 
            else
                e.getSource().setVisible(true);
            });
        });*/
        //------------------------------------------------------------------------------------------------
        layGrid.getStyle().set("border", "1px solid #9E9E9E");
        layGrid.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layGrid.setAlignItems(FlexComponent.Alignment.CENTER);
        layGrid.setWidthFull();
        //------------------------------------------------------------------------------------------------
        //btnver_prod.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        //btnver_prod.getStyle().set("fontSize","90%");
        
        layBttnVer_Prod.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        layBttnVer_Prod.setAlignItems(FlexComponent.Alignment.CENTER);
        //layBttnVer_Prod.setWidthFull();
        //------------------------------------------------------------------------------------------------
        //TOOLBAR
        //------------------------------------------------------------------------------------------------
        laydToolbar.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laydToolbar.setAlignItems(FlexComponent.Alignment.CENTER);
        laydToolbar.setWidthFull();
        
        layButtonsGrid.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        layButtonsGrid.setAlignItems(FlexComponent.Alignment.CENTER);
        layButtonsGrid.setWidthFull();
        //------------------------------------------------------------------------------------------------
        //INFORMATION
        
        //lbInformation.getStyle().set("fontWeight","bold");
        lbInformation.getStyle().set("color", "red");
        lbInformation.getStyle().set("fontStyle","italic");
        lbInformation.getStyle().set("fontSize","80%");
        
        layInformation.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        layInformation.setAlignItems(FlexComponent.Alignment.CENTER);
        layInformation.setWidthFull();
        //------------------------------------------------------------------------------------------------
        
        //------------------------------------------------------------------------------------------------
        //FOOT - BOTONES DE ACCION FINAL
        //------------------------------------------------------------------------------------------------
        //btnNewCupon.addThemeVariants(ButtonVariant.LUMO_ICON); 
        btnNewCupon.getStyle().set("fontSize","90%");
                
        //btnCambiar_Activo.addThemeVariants(ButtonVariant.LUMO_ICON); 
        btnCambiar_Activo.getStyle().set("fontSize","90%");
        
        //btnCambiar_Inactivo.addThemeVariants(ButtonVariant.LUMO_ICON); 
        btnCambiar_Inactivo.getStyle().set("fontSize","90%");
        
        //btnAsignar_Monto.addThemeVariants(ButtonVariant.LUMO_ICON); 
        btnAsignar_Monto.getStyle().set("fontSize","90%"); 
        
        btnExit.addThemeVariants(ButtonVariant.LUMO_ERROR); 
        btnExit.getStyle().set("fontSize","90%");
        //------------------------------------------------------------------------------------------------
        fButtons.getStyle().set("border", "1px solid #9E9E9E");
        fButtons.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        fButtons.setAlignItems(FlexComponent.Alignment.CENTER);
        fButtons.setWidthFull();
        //------------------------------------------------------------------------------------------------
        
        
        //------------------------------------------------------------------------------------------------
        //DIALOG EXISTENTE - EDIT CUPON
        //------------------------------------------------------------------------------------------------
        //TITULO GENERAL
    
        lbdialogCU_titulo.getStyle().set("fontWeight","bold");
        lbdialogCU_titulo.getStyle().set("fontSize","150%"); 
        
        laydialogCU_titulo.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laydialogCU_titulo.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialogCU_titulo.setWidthFull();  
        //------------------------------------------------------------------------------------------------
        //CUERPO DIALOG
    
        //CUPON: Nombre y Activo
        txtdialogCU_Nombre.setWidthFull();
        
        chckdialogCU_Activate.setWidthFull();
        
        laydialogCU_Nombre.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laydialogCU_Nombre.setAlignItems(FlexComponent.Alignment.BASELINE);
        laydialogCU_Nombre.setWidthFull();  
        //------------------------------------------------------------------------------------------------
        //CUPON: Monto y Precio Min Prod
        
        txtdialogCU_Monto.setWidthFull();
                
        txtdialogCU_PrecioMin.setWidthFull();
        
        datedialogCU_FechaIniVig.setWidthFull();
        datedialogCU_FechaFinVig.setWidthFull();
                
        txtdialogCU_Cantidad.setWidthFull();
        
        laydialogCU_Monto.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laydialogCU_Monto.setAlignItems(FlexComponent.Alignment.BASELINE);
        laydialogCU_Monto.setWidthFull(); 
        //------------------------------------------------------------------------------------------------
        //CUPON: Botones de accion
        
        btndialogCU_Guardar.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        btndialogCU_Guardar.getStyle().set("fontSize","90%");
        btndialogCU_Delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        btndialogCU_Delete.getStyle().set("fontSize","90%"); 
        //btndialogCU_Cancel.addThemeVariants(ButtonVariant.LUMO_CONTRAST);
        btndialogCU_Cancel.getStyle().set("fontSize","90%"); 
    
        laydialogCU_Btns.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laydialogCU_Btns.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialogCU_Btns.setWidthFull();  
        
        laydialogCU_Btns2.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laydialogCU_Btns2.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialogCU_Btns2.setWidthFull();  
        //----------------------------------------------------------------------------------------------------
        //CUPON: GRID USUARIOS
        btndialogCU_BusqUsuAsign.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        btndialogCU_BusqUsuAsign.getStyle().set("fontSize","90%"); 
        
        laydialogCU_Gridpart1.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laydialogCU_Gridpart1.setAlignItems(FlexComponent.Alignment.BASELINE);
        laydialogCU_Gridpart1.setWidthFull();   

        btndialogCU_UsuBusq.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        btndialogCU_UsuBusq.getStyle().set("fontSize","90%"); 
        
        laydialogCU_Gridpart2.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laydialogCU_Gridpart2.setAlignItems(FlexComponent.Alignment.BASELINE);
        laydialogCU_Gridpart2.setWidthFull(); 

        grid_usuarios.addColumn(UsuarioWeb::getNombres).setAutoWidth(true).setSortable(true).setHeader("Nombres");
        grid_usuarios.addColumn(UsuarioWeb::getApellidos).setAutoWidth(true).setSortable(true).setHeader("Apellidos");
        grid_usuarios.addColumn(UsuarioWeb::getEmail).setAutoWidth(true).setSortable(true).setHeader("Email");
        grid_usuarios.addColumn(UsuarioWeb::getTelefono).setAutoWidth(true).setSortable(true).setHeader("Telefono"); 
        
        grid_usuarios.setWidth("%1000");
        
        grid_usuarios.setSelectionMode(Grid.SelectionMode.MULTI);
        MultiSelect<Grid<UsuarioWeb>, UsuarioWeb> multiSelect_usu = grid_usuarios.asMultiSelect();
        
        layGrid_Usu.getStyle().set("border", "1px solid #9E9E9E");
        layGrid_Usu.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layGrid_Usu.setAlignItems(FlexComponent.Alignment.CENTER);
        layGrid_Usu.setWidthFull(); 

        btndialogCU_AsignUsu.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        btndialogCU_AsignUsu.getStyle().set("fontSize","90%");  
        btndialogCU_UnasignUsu.addThemeVariants(ButtonVariant.LUMO_ERROR);
        btndialogCU_UnasignUsu.getStyle().set("fontSize","90%"); 
        
        laydialogCU_Gridpart3.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laydialogCU_Gridpart3.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialogCU_Gridpart3.setWidthFull(); 

        laydialogCU_GridAll.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laydialogCU_GridAll.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialogCU_GridAll.setWidthFull();
        //------------------------------------------------------------------------------------------------
        //LAYOUT TOTAL CUPON EXISTENTE
    
        laydialogCU_Total.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laydialogCU_Total.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialogCU_Total.setWidthFull(); 
        //------------------------------------------------------------------------------------------------
        //CUPON: DIALOG
        //------------------------------------------------------------------------------------------------
        dialog_CuponExist.setCloseOnEsc(false);
        dialog_CuponExist.setCloseOnOutsideClick(false);
        //------------------------------------------------------------------------------------------------
        //CUPON: NOTIFICATION
        //------------------------------------------------------------------------------------------------
        dialogCU_notf_is_Updated.getStyle().set("fontSize","90%");
        dialogCU_notf_is_Updated.getStyle().set("color", "green"); 
        dialogCU_notf_is_Deleted.getStyle().set("fontSize","90%");
        dialogCU_notf_is_Deleted.getStyle().set("color", "red"); 
    
        notifyCU_is_Updated.setDuration(2500);
        notifyCU_is_Updated.setPosition(Notification.Position.MIDDLE);
        notifyCU_is_Deleted.setDuration(2500);
        notifyCU_is_Deleted.setPosition(Notification.Position.MIDDLE); 
        //------------------------------------------------------------------------------------------------
        
        
        //------------------------------------------------------------------------------------------------
        //DIALOG NUEVO CUPON - EDIT CUPON
        //------------------------------------------------------------------------------------------------
        //TITULO GENERAL
    
        lbdialogNCU_titulo.getStyle().set("fontWeight","bold");
        lbdialogNCU_titulo.getStyle().set("fontSize","150%"); 
        
        laydialogNCU_titulo.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laydialogNCU_titulo.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialogNCU_titulo.setWidthFull();  
        //------------------------------------------------------------------------------------------------
        //CUERPO DIALOG
    
        //NUEVO CUPON: Nombre y Activo
        txtdialogNCU_Nombre.setWidthFull();
        
        chckdialogNCU_Activate.setWidthFull();
        chckdialogNCU_Activate.setValue(Boolean.FALSE);
                
        laydialogNCU_Nombre.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laydialogNCU_Nombre.setAlignItems(FlexComponent.Alignment.BASELINE);
        laydialogNCU_Nombre.setWidthFull();  
        //------------------------------------------------------------------------------------------------
        //NUEVO CUPON: Monto y Precio Min Prod
        
        txtdialogNCU_Monto.setWidthFull();
                
        txtdialogNCU_PrecioMin.setWidthFull();
        
        datedialogNCU_FechaIniVig.setWidthFull();
        datedialogNCU_FechaFinVig.setWidthFull();
        txtdialogNCU_Cantidad.setWidthFull();
                
        laydialogNCU_Monto.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laydialogNCU_Monto.setAlignItems(FlexComponent.Alignment.BASELINE);
        laydialogNCU_Monto.setWidthFull(); 
        //------------------------------------------------------------------------------------------------
        //NUEVO CUPON: Botones de accion
        
        btndialogNCU_Guardar.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        btndialogNCU_Guardar.getStyle().set("fontSize","90%");
        //btndialogNCU_Cancel.addThemeVariants(ButtonVariant.LUMO_CONTRAST);
        btndialogNCU_Cancel.getStyle().set("fontSize","90%"); 
    
        laydialogNCU_Btns.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laydialogNCU_Btns.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialogNCU_Btns.setWidthFull();    
        //------------------------------------------------------------------------------------------------
        //LAYOUT TOTAL NUEVO CUPON
    
        laydialogNCU_Total.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laydialogNCU_Total.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialogNCU_Total.setWidthFull(); 
        //------------------------------------------------------------------------------------------------
        //NUEVO CUPON: DIALOG
        //------------------------------------------------------------------------------------------------
        dialog_NewCupon.setCloseOnEsc(true);
        dialog_NewCupon.setCloseOnOutsideClick(true);
        //------------------------------------------------------------------------------------------------
        //NUEVO CUPON: NOTIFICATION
        //------------------------------------------------------------------------------------------------
        dialogNCU_notf_is_Created.getStyle().set("fontSize","90%");
        dialogNCU_notf_is_Created.getStyle().set("color", "green");  
    
        notifyNCU_is_Created.setDuration(2500);
        notifyNCU_is_Created.setPosition(Notification.Position.MIDDLE);
        
        notf_select_exceed.getStyle().set("fontSize","90%");
        notf_select_exceed.getStyle().set("color", "red");
        
        notify_select_exceed.setDuration(2500);
        notify_select_exceed.setPosition(Notification.Position.MIDDLE); 
        //------------------------------------------------------------------------------------------------
        
        //------------------------------------------------------------------------------------------------
        //DIALOG ASIGNAR MONTO
        //------------------------------------------------------------------------------------------------
        //TITULO GENERAL

        lbdialogAMCU_titulo.getStyle().set("fontWeight","bold");
        lbdialogAMCU_titulo.getStyle().set("fontSize","150%"); 
        
        laydialogAMCU_titulo.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laydialogAMCU_titulo.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialogAMCU_titulo.setWidthFull();  
        //------------------------------------------------------------------------------------------------
        //CUERPO DIALOG

        //ASIGNAR MONTO: Monto
        txtdialogAMCU_Monto.setWidthFull(); 
        
        btndialogAMCU_AsignarMonto.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        btndialogAMCU_AsignarMonto.getStyle().set("fontSize","90%"); 
        btndialogAMCU_AsignarMonto.setWidthFull();
        
        laydialogAMCU_Asignar.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laydialogAMCU_Asignar.setAlignItems(FlexComponent.Alignment.BASELINE);
        laydialogAMCU_Asignar.setWidthFull(); 
        //------------------------------------------------------------------------------------------------
        //ASIGNAR MONTO: Cancel
        btndialogAMCU_Cancel.addThemeVariants(ButtonVariant.LUMO_ERROR);
        btndialogAMCU_Cancel.getStyle().set("fontSize","90%");
        btndialogAMCU_Cancel.setWidthFull();
        
        laydialogAMCU_Cancel.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laydialogAMCU_Cancel.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialogAMCU_Cancel.setWidthFull();  
        //------------------------------------------------------------------------------------------------
        //LAYOUT TOTAL NUEVO CUPON
        laydialogAMCU_Total.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laydialogAMCU_Total.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialogAMCU_Total.setWidthFull();
        //------------------------------------------------------------------------------------------------
        //----------------------------------------------------------------------------------------------------
        //CUPON: DIALOG
        dialog_AsignMonto.setCloseOnEsc(false);
        dialog_AsignMonto.setCloseOnOutsideClick(false);
        //----------------------------------------------------------------------------------------------------
        //CUPON: NOTIFICATION
        dialogAMCU_notf_is_MontoAsign.getStyle().set("fontSize","90%");
        dialogAMCU_notf_is_MontoAsign.getStyle().set("color", "green");  
    
        notifyAMCU_is_MontoAsign.setDuration(2500);
        notifyAMCU_is_MontoAsign.setPosition(Notification.Position.MIDDLE); 
        //----------------------------------------------------------------------------------------------------
        //END DIALOG ASIGNAR MONTO
        //------------------------------------------------------------------------------------------------
    }
    
    //----------------------------------------------------------------------------------------------------
    //FUNCIONES
    //----------------------------------------------------------------------------------------------------
    //CPANEL Rutas
    public abstract void go_CPanel();
    
    public abstract void go_Clientes();    
    public abstract void go_Subscriptores();
    public abstract void go_Promociones();
    public abstract void go_PuntosUP();
    
    public abstract void go_Pedidos();
    public abstract void go_LineasEcom();
    public abstract void go_Productos();
    public abstract void go_Index();
    
    //Busquedas
    public abstract void On_find_NameCupon();
    public abstract void On_find_CuponActivo();
    public abstract void On_find_CuponInactivo();
    
    //Main View
    public abstract void On_Click_ActivarCupones();
    public abstract void On_Click_DesactivarCupones();
    public abstract void On_Click_AsignMonto();
    //----------------------------------------------------------------------------------------------------
    //DIALOG CUPON EXISTENTE
    //----------------------------------------------------------------------------------------------------
    public abstract void On_OpenDialog_CuponExist();
    public abstract void On_Update_CuponExist();
    public abstract void On_Delete_CuponExist();
    //----------------------------------------------------------------------------------------------------
    public abstract void On_UsuariosAsignados();
    public abstract void On_FindUsuarios();
    public abstract void On_AsignarUsu();
    public abstract void On_DesasignarUsu();
    //----------------------------------------------------------------------------------------------------
    //DIALOG NUEVO CUPON
    //----------------------------------------------------------------------------------------------------
    public abstract void On_OpenDialog_NewCupon();
    public abstract void On_Save_NewCupon();
    //----------------------------------------------------------------------------------------------------
    //DIALOG NUEVO CUPON
    //----------------------------------------------------------------------------------------------------
    public abstract void On_Asign_Monto();
    
    //----------------------------------------------------------------------------------------------------
    //REPORTEADOR : TOOLBAR
    //----------------------------------------------------------------------------------------------------
    public abstract void init_ReporterToolbar();
    public abstract void init_ReporterToolbar_default();
    //----------------------------------------------------------------------------------------------------
    
    //----------------------------------------------------------------------------------------------------
    //EVENTOS
    //----------------------------------------------------------------------------------------------------
    private void initEvents() {
        //-----------------------------------------------------------------------------------------------
        //CPANEL CABECERA
        //-----------------------------------------------------------------------------------------------
        btnClientes.addClickListener(e->{
            removeAll();
            go_Clientes();
        });
        btnSubscriptores.addClickListener(e->{
            removeAll();
            go_Subscriptores();
        });
        btnPromociones.addClickListener(e->{
            removeAll();
            go_Promociones();
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
        //VER/EDITAR PRODUCTO
        btnver_prod.addClickListener(e->{ 
            On_OpenDialog_CuponExist();
            //dialog_CuponExist.open();
        });
        //------------------------------------------------------------------------------------------------
        //FOOT - FINAL BUTTONS
        //------------------------------------------------------------------------------------------------
        //FOOT - Nuevo Cupon
        btnNewCupon.addClickListener(e->{
            On_OpenDialog_NewCupon();
            dialog_NewCupon.open();
        });
        //FOOT - Activar Cupones
        btnCambiar_Activo.addClickListener(e->{
            On_Click_ActivarCupones();
        });
        //FOOT - Desactivar Cupones
        btnCambiar_Inactivo.addClickListener(e->{
            On_Click_DesactivarCupones();
        });
        //FOOT - Asignar Monto
        btnAsignar_Monto.addClickListener(e->{
            On_Click_AsignMonto();
            dialog_AsignMonto.open();
        });
        //FOOT - Exit
        btnExit.addClickListener(e->{
            removeAll();
            go_CPanel();
        });
        //------------------------------------------------------------------------------------------------
        //DIALOG CUPON EXISTENTE
        //------------------------------------------------------------------------------------------------
        btndialogCU_Guardar.addClickListener(e->{
            On_Update_CuponExist();
        }); 
        btndialogCU_Delete.addClickListener(e->{
            On_Delete_CuponExist();
        }); 
        btndialogCU_Cancel.addClickListener(e->{
            dialog_CuponExist.close();
            grid.getDataProvider().refreshAll();
        }); 
        //------------------------------------------------------------------------------------------------
        btndialogCU_BusqUsuAsign.addClickListener(e->{
            On_UsuariosAsignados();
        });
        btndialogCU_UsuBusq.addClickListener(e->{
            On_FindUsuarios();
        });
        btndialogCU_AsignUsu.addClickListener(e->{
            On_AsignarUsu();
        });
        btndialogCU_UnasignUsu.addClickListener(e->{
            On_DesasignarUsu();
        });
        //------------------------------------------------------------------------------------------------
        //------------------------------------------------------------------------------------------------
        //DIALOG NUEVO CUPON
        //------------------------------------------------------------------------------------------------
        btndialogNCU_Guardar.addClickListener(e->{
            On_Save_NewCupon();
        }); 
        btndialogNCU_Cancel.addClickListener(e->{
            dialog_NewCupon.close();
        }); 
        //------------------------------------------------------------------------------------------------
        //DIALOG ASIGNAR MONTO
        //------------------------------------------------------------------------------------------------
        btndialogAMCU_AsignarMonto.addClickListener(e->{
            On_Asign_Monto();
        }); 
        btndialogAMCU_Cancel.addClickListener(e->{
            dialog_AsignMonto.close();
            grid.getDataProvider().refreshAll();
        });
        //------------------------------------------------------------------------------------------------
        //------------------------------------------------------------------------------------------------
        //REPORTEADOR : TOOLBAR
        //------------------------------------------------------------------------------------------------
        Toolbar.btnRefresh.addClickListener(e->{ 
            Toolbar.on_Refresh(grid);
        });
        //------------------------------------------------------------------------------------------------
    }
    
    //----------------------------------------------------------------------------------------------------

}
