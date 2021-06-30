/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.view.ecom;

import com.upgrade.persistence.model.extcs.Linea;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.contextmenu.SubMenu;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.renderer.NativeButtonRenderer;
import com.vaadin.flow.data.selection.MultiSelect;
import up.erp.view.App;

/**
 *
 * @author Luis Aleman
 */
public abstract class LineasEcomUI extends VerticalLayout {
    
    //-----------------------------------------------------------------------------------------------
    //CPANEL CABECERA
    //-----------------------------------------------------------------------------------------------
    public final Button btnClientes = new Button("Clientes Ecommerce", VaadinIcon.MALE.create());
    public final Button btnSubscriptores = new Button("Subscriptores Ecommerce", VaadinIcon.MALE.create());
    public final Button btnPromociones = new Button("Promociones Ecommerce", VaadinIcon.GIFT.create());
    public final Button btnCupones = new Button("Cupones Ecommerce", VaadinIcon.TICKET.create());
    public final Button btnPuntosUP = new Button("Puntos UP Ecommerce", VaadinIcon.TROPHY.create());
    //-----------------------------------------------------------------------------------------------
    public final Button btnPedidos = new Button("Pedidos Ecommerce", VaadinIcon.CART_O.create());
    //public final Button btnLineas = new Button("Gestión Lineas Ecommerce", VaadinIcon.RECORDS.create());
    public final Button btnProductos = new Button("Productos Ecommerce", VaadinIcon.PACKAGE.create());
    public final Button btnEcomPage = new Button("Página Ecommerce", VaadinIcon.GLOBE_WIRE.create());
    //-----------------------------------------------------------------------------------------------
    public final Button btnSalirCP = new Button("Salir del Panel de Control");
    //-----------------------------------------------------------------------------------------------
    public final HorizontalLayout layCPanelButtons = new HorizontalLayout(btnSubscriptores,btnPromociones,btnCupones,btnPuntosUP);
    //-----------------------------------------------------------------------------------------------
    public final HorizontalLayout layCPanelButtons2 = new HorizontalLayout(btnPedidos,btnProductos,btnEcomPage,btnSalirCP);
    //-----------------------------------------------------------------------------------------------
    //END CABECERA
    //-----------------------------------------------------------------------------------------------
    
    //-----------------------------------------------------------------------------------------------
    //MAIN VIEW
    //-----------------------------------------------------------------------------------------------
    // HEADER
    Label titulo = new Label("LINEAS E-COMMERCE - ERP");
    
    //Iconos
    public final Icon draw = VaadinIcon.MENU.create();

    //MenuBar
    public final MenuBar menuBar = new MenuBar();
    Text selected = new Text("");
    Div message = new Div();

    MenuItem ini = menuBar.addItem(draw);

    SubMenu iniSubMenu = ini.getSubMenu();
    MenuItem begining = iniSubMenu.addItem("Inicio");
    MenuItem closeAcct = iniSubMenu.addItem("Cerrar sesión");
    
    public final Span title = new Span("Bienvenido");
    public final HorizontalLayout head = new HorizontalLayout(titulo);
    public final HorizontalLayout header = new HorizontalLayout(menuBar,title);
    //-----------------------------------------------------------------------------------------------------------
    
    // WORKSPACE
    //-----------------------------------------------------------------------------------------------------------
    //LINEAS ECOMMERCE
    //-----------------------------------------------------------------------------------------------------------
    //MAIN VIEW
    
    Label titulo_linea_ecom = new Label("LINEAS ECOMMERCE");
    public final Button btnLinea_Ecom = new Button("Crear - Editar");
    //public final HorizontalLayout layLinea_Ecom = new HorizontalLayout(titulo_linea_ecom);
    //public final HorizontalLayout layLinea_Ecom2 = new HorizontalLayout(btnLinea_Ecom);
    public final HorizontalLayout layLinea_Ecom = new HorizontalLayout(titulo_linea_ecom,btnLinea_Ecom);
    public final VerticalLayout layLinea_Ecom_T =  new VerticalLayout(layLinea_Ecom);
    //-----------------------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------------------
    //DIALOG LINEAS ECOMMERCE -----------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------------------
    //TITULO GENERAL
    public final Label lbdialogLE_titulo = new Label("LINEAS ECOMMERCE");
    public final HorizontalLayout laydialogLE_titulo  = new HorizontalLayout(lbdialogLE_titulo);
    //-----------------------------------------------------------------------------------------------------------
    
    //LINEAS ECOMMERCE EXISTENTES
    public final Label lbdialogLE_LEExist = new Label("LINEAS ECOMMERCE EXISTENTES");
    public final HorizontalLayout laydialogLE_LEExistTitulo  = new HorizontalLayout(lbdialogLE_LEExist);
    
    //Buscador de Lineas Ecommerce Existentes
    public final ComboBox<String> cmbdialogLE_LEcom = new ComboBox("Linea E-commerce");

    public final TextField txtdialogLE_LEcom = new TextField("Linea Ecommerce");
    public final Button btndialogLE_LEcom = new Button("Buscar");
    public final HorizontalLayout laydialogLE_LEcom = new HorizontalLayout(cmbdialogLE_LEcom,txtdialogLE_LEcom,btndialogLE_LEcom);
    
    //Nombre y Descripcion de la Linea Ecommerce
    public final TextField txtdialogLE_Nombre = new TextField("Nombre");
    public final TextField txtdialogLE_Descripcion = new TextField("Descripcion");
    public final HorizontalLayout laydialogLE_Nombre = new HorizontalLayout(txtdialogLE_Nombre,txtdialogLE_Descripcion);
    
    //Orden y Activo de la Linea Ecommerce
    public final TextField txtdialogLE_Orden = new TextField("Orden");
    public final Checkbox dialogLE_CheckActivation = new Checkbox("Está activa?");
    public final HorizontalLayout laydialogLE_Orden = new HorizontalLayout(txtdialogLE_Orden,dialogLE_CheckActivation);
    //Botones Linea Ecommerce Existente
    public final Button btndialogLE_Guardar = new Button("Guardar Cambios");
    public final Button btndialogLE_Delete = new Button("Borrar Linea Ecom");
    public final Button btndialogLE_Cancel = new Button("Salir");
    public final HorizontalLayout laydialogLE_Btns = new HorizontalLayout(btndialogLE_Guardar,btndialogLE_Delete,btndialogLE_Cancel);
    //LAYOUT TOTAL LINEAS ECOMMERCE EXISTENTES
    public final VerticalLayout laydialogLE_LEExist_Total = new VerticalLayout(laydialogLE_LEExistTitulo,laydialogLE_LEcom,
                                                                laydialogLE_Nombre,laydialogLE_Orden,laydialogLE_Btns);
    //-----------------------------------------------------------------------------------------------------------
    //NUEVA LINEA ECOMMERCE
    public final Label lbdialogLE_LENew = new Label("NUEVA LINEA ECOMMERCE");
    public final HorizontalLayout laydialogLE_LENewTitulo  = new HorizontalLayout(lbdialogLE_LENew);
        
    //Nombre y Descripcion de la Linea Ecommerce
    public final TextField txtdialogLE_NombreNew = new TextField("Nombre");
    public final TextField txtdialogLE_DescripcionNew = new TextField("Descripcion");
    public final HorizontalLayout laydialogLE_NombreNew = new HorizontalLayout(txtdialogLE_NombreNew,txtdialogLE_DescripcionNew);
    
    //Orden y Activo de la Linea Ecommerce
    public final TextField txtdialogLE_OrdenNew = new TextField("Orden");
    public final Checkbox dialogLE_CheckActivationNew = new Checkbox("Está activa?");
    public final HorizontalLayout laydialogLE_OrdenNew = new HorizontalLayout(txtdialogLE_OrdenNew,dialogLE_CheckActivationNew);
    
    //Botones Nueva Linea Ecommerce
    public final Button btndialogLE_GuardarNew = new Button("Crear");
    public final Button btndialogLE_CancelNew = new Button("Cancelar");
    public final HorizontalLayout laydialogLE_BtnsNew = new HorizontalLayout(btndialogLE_GuardarNew,btndialogLE_CancelNew);
    
    //LAYOUT TOTAL NUEVA LINEA ECOMMERCE
    public final VerticalLayout laydialogLE_LENew_Total = new VerticalLayout(laydialogLE_LENewTitulo,laydialogLE_NombreNew,
                                                                laydialogLE_OrdenNew,laydialogLE_BtnsNew);
    //-----------------------------------------------------------------------------------------------------------
    //LAYOUTS FINALES
    public final HorizontalLayout laydialogLE_Exist_New = new HorizontalLayout(laydialogLE_LEExist_Total,laydialogLE_LENew_Total);
    
    public final VerticalLayout laydialogLE_Final = new VerticalLayout(laydialogLE_titulo,laydialogLE_Exist_New);
    
    public final Dialog dialog_LineaEcommerce = new Dialog(laydialogLE_Final);
    //-----------------------------------------------------------------------------------------------------------
    //NOTIFICATION DIALOG LINEA ECOMMERCE
    
    public final Label dialogLE_notf_is_Updated = new Label("La Linea Ecommerce ha sido actualizada");
    public final Label dialogLE_notf_is_Deleted = new Label("La Linea Ecommerce ha sido borrada");
    public final Label dialogLE_notf_is_Created = new Label("La Linea Ecommerce ha sido creada");
    
    public final Notification notifyLE_is_Updated = new Notification(dialogLE_notf_is_Updated);
    public final Notification notifyLE_is_Deleted = new Notification(dialogLE_notf_is_Deleted);
    public final Notification notifyLE_is_Created = new Notification(dialogLE_notf_is_Created);
    //-----------------------------------------------------------------------------------------------------------
    //DIALOG LINEAS ECOMMERCE END -------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------------------
    
    //-----------------------------------------------------------------------------------------------------------
    //LINEAS ERP ------------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------------------
    //MAIN VIEW
    
    //Busquedas
    
    Label titulo_buscar = new Label("BUSQUEDA DE LINEAS ERP");
    
    public final HorizontalLayout lay_titulo_bus = new HorizontalLayout(titulo_buscar);
    //-----------------------------------------------------------------------------------------------------------
    //Busqueda 1 : By Linea Ecommerce
    
    ComboBox<String> comboBoxLE_Bus = new ComboBox<>("Linea Ecommerce");
    public final TextField txtLE_Bus = new TextField("Linea Ecommerce");
    public final Button btnLE_Bus = new Button("Buscar");
    
    
    public final HorizontalLayout lay_component_bus = new HorizontalLayout(comboBoxLE_Bus,txtLE_Bus,btnLE_Bus);
    //-----------------------------------------------------------------------------------------------------------
    
    //Busqueda 2 : By Linea ERP
    
    //ComboBox<String> comboBoxLERP_Bus = new ComboBox<>("Linea ERP");
    public final TextField txtLERP_Bus = new TextField("Ingrese Linea ERP");
    public final Button btnLERP_Bus = new Button("Buscar");
    
    public final HorizontalLayout lay_component2_bus = new HorizontalLayout(txtLERP_Bus,btnLERP_Bus);
    //-----------------------------------------------------------------------------------------------------------
    //Layout Busquedas
    
    public final VerticalLayout lay_Busquedas =  new VerticalLayout(lay_titulo_bus,lay_component_bus,lay_component2_bus);
    //-----------------------------------------------------------------------------------------------------------
    //Grid
    
    public final Grid<Linea> grid = new Grid<>();
    public final VerticalLayout layGrid = new VerticalLayout(grid);
    //-----------------------------------------------------------------------------------------------------------
    //Button Ver/Editar
    
    public final Button btnver_prod = new Button("Ver/Editar", VaadinIcon.EYE.create());
    public final HorizontalLayout layBttnVer_Prod = new HorizontalLayout(btnver_prod);
    //-----------------------------------------------------------------------------------------------------------
    //Informacion
    
    public final Label lbInformation = new Label("*Nota: Seleccione el pedido antes de Editar");
    public final HorizontalLayout layInformation = new HorizontalLayout(lbInformation);
    
    //-----------------------------------------------------------------------------------------------------------
    //Footer Buttons
    
    public final Button btnAsignar_LE = new Button("Asignar a Linea Ecommerce");
    public final Button btnExit = new Button("Salir");

    public final HorizontalLayout fButtons = new HorizontalLayout(btnAsignar_LE,btnExit);
    //-----------------------------------------------------------------------------------------------------------
    //END MAIN VIEW ---------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------------------
    
    //-----------------------------------------------------------------------------------------------------------
    //DIALOG LINEAS ERP - UNITARIO ------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------------------
    //TITULO GENERAL
    public final Label lbdialogLERP_titulo = new Label("ASIGNACION LINEA ERP");
    public final HorizontalLayout laydialogLERP_titulo  = new HorizontalLayout(lbdialogLERP_titulo);
    //-----------------------------------------------------------------------------------------------------------
    
    public final TextField txtdialogLERP_nombre = new TextField("Nombre");
    public final TextField txtdialogLERP_descrp = new TextField("Descripcion");
    public final ComboBox<String> comboBoxdialogLERP_LEcom_Asign = new ComboBox<>("Lineas Ecommerce Asignadas");
    public final ComboBox<String> comboBoxdialogLERP_LEcom = new ComboBox<>("Linea Ecommerce");
    public final TextField txtdialogLERP_LEcom = new TextField("Linea Ecommerce");
    
    public final Button btndialogLERP_Asignar = new Button("Asignar");
    public final Button btndialogLERP_Desasignar = new Button("Desasignar");
    public final HorizontalLayout laydialogLERP_Btns  = new HorizontalLayout(btndialogLERP_Asignar,btndialogLERP_Desasignar);
    
    public final HorizontalLayout laydialogLERP_Body  = new HorizontalLayout(txtdialogLERP_nombre,txtdialogLERP_descrp,comboBoxdialogLERP_LEcom_Asign,
                                                        comboBoxdialogLERP_LEcom,txtdialogLERP_LEcom);
    //-----------------------------------------------------------------------------------------------------------
    
    public final Button btndialogLERP_Cerrar = new Button("Cerrar");
    public final HorizontalLayout laydialogLERP_Cerrar  = new HorizontalLayout(btndialogLERP_Cerrar);
    //-----------------------------------------------------------------------------------------------------------
    
    //LAYOUTS FINALES
    
    public final VerticalLayout laydialogLERP_Final = new VerticalLayout(laydialogLERP_titulo,laydialogLERP_Body,laydialogLERP_Btns,laydialogLERP_Cerrar);
    
    public final Dialog dialog_LineaERP = new Dialog(laydialogLERP_Final);
    //-----------------------------------------------------------------------------------------------------------
    //DIALOG LINEAS ERP - UNITARIO END  -------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------------------
    
    //-----------------------------------------------------------------------------------------------------------
    //DIALOG LINEAS ERP - VARIOS --------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------------------
    //TITULO GENERAL
    public final Label lbdialogLERP2_titulo = new Label("ASIGNACION LINEAS ERP");
    public final HorizontalLayout laydialogLERP2_titulo  = new HorizontalLayout(lbdialogLERP2_titulo);
    //-----------------------------------------------------------------------------------------------------------
    
    ComboBox<String> comboBoxdialogLERP2_LEcom = new ComboBox<>("Linea Ecommerce");
    public final TextField txtdialogLERP2_LEcom = new TextField("Linea Ecommerce");
    
    public final HorizontalLayout laydialogLERP2_Body  = new HorizontalLayout(comboBoxdialogLERP2_LEcom,txtdialogLERP2_LEcom);
    //-----------------------------------------------------------------------------------------------------------
    
    public final Button btndialogLERP2_Asignar = new Button("Asignar");
    public final Button btndialogLERP2_Desasignar = new Button("Desasignar");
    
    public final HorizontalLayout laydialogLERP2_Btns  = new HorizontalLayout(btndialogLERP2_Asignar,btndialogLERP2_Desasignar);
    //-----------------------------------------------------------------------------------------------------------
    
    public final Button btndialogLERP2_Cerrar = new Button("Cerrar");
    public final HorizontalLayout laydialogLERP2_Cerrar  = new HorizontalLayout(btndialogLERP2_Cerrar);
    //-----------------------------------------------------------------------------------------------------------
    
    //LAYOUTS FINALES
    
    public final VerticalLayout laydialogLERP2_Final = new VerticalLayout(laydialogLERP2_titulo,laydialogLERP2_Body,laydialogLERP2_Btns,laydialogLERP2_Cerrar);
    
    public final Dialog dialog_LineaERP2 = new Dialog(laydialogLERP2_Final);
    //-----------------------------------------------------------------------------------------------------------
    //DIALOG LINEAS ERP - VARIOS END -----------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------------------
    
    //-----------------------------------------------------------------------------------------------------------
    //NOTIFICATION DIALOG LINEA ERP
    //-----------------------------------------------------------------------------------------------------------
    public final Label dialogLERP_notf_is_Updated = new Label("La Linea ERP ha sido asignada");
    public final Label dialogLERP_notf_is_Unasign = new Label("La Linea ERP ha sido desasignada");
    public final Label dialogLERP_notf_select_Exceed = new Label("Más de una Linea ERP han sido seleccionadas. Por favor, seleccione sólo una");
    public final Label dialogLERP2_notf_is_Updated = new Label("Las Lineas ERP han sido asignadas");
    public final Label dialogLERP2_notf_is_Unasign = new Label("Las Lineas ERP han sido desasignadas");
    
    public final Notification notifyLERP_is_Updated = new Notification(dialogLERP_notf_is_Updated);
    public final Notification notifyLERP_is_Unasign = new Notification(dialogLERP_notf_is_Unasign);
    public final Notification notifyLERP_select_Exceed = new Notification(dialogLERP_notf_select_Exceed);
    public final Notification notifyLERP2_is_Updated = new Notification(dialogLERP2_notf_is_Updated);
    public final Notification notifyLERP2_is_Unasign = new Notification(dialogLERP2_notf_is_Unasign);
    //-----------------------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------------------
    //MAIN INIT
    public LineasEcomUI() {
   
        removeAll();
        add(layCPanelButtons,layCPanelButtons2,head, layLinea_Ecom_T,lay_Busquedas,layBttnVer_Prod,layGrid,layInformation,fButtons);
        btnLE_Bus.addClickListener(e->On_find_LineaEcom());
        btnLERP_Bus.addClickListener(e->On_find_LineaERP());
        comboBoxLE_Bus.addAttachListener(e->on_Click_ComboBusLineaEcom());
        initStyles();
        initEvents();
    }
    
    //-----------------------------------------------------------------------------------------------------------
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
        
        btnCupones.setWidthFull();
        btnCupones.getStyle().set("fontSize","80%");
        
        btnPuntosUP.setWidthFull();
        btnPuntosUP.getStyle().set("fontSize","80%");
        //------------------------------------------------------------------------------------------------
        btnPedidos.setWidthFull();
        btnPedidos.getStyle().set("fontSize","80%");
                
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
        
        //HEADER
        
        titulo.getStyle().set("fontWeight","bold");
        titulo.getStyle().set("fontSize","300%");
        head.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        head.setWidthFull();

        header.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        header.setWidthFull();
        //-------------------------------------------------------------------------------------------------------
        
        //WORKSPACE
        //-------------------------------------------------------------------------------------------------------
        //LINEAS ECOMMERCE
        //-------------------------------------------------------------------------------------------------------
        //MAIN VIEW
        
        titulo_linea_ecom.getStyle().set("fontWeight","bold");
        titulo_linea_ecom.getStyle().set("fontSize","150%");
        
        //btnLinea_Ecom.addThemeVariants(ButtonVariant.LUMO_CONTRAST);
        btnLinea_Ecom.getStyle().set("fontSize","90%"); 
        
        layLinea_Ecom.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        layLinea_Ecom.setAlignItems(FlexComponent.Alignment.BASELINE);
        layLinea_Ecom.setWidthFull(); 
        /*
        layLinea_Ecom2.setJustifyContentMode(FlexComponent.JustifyContentMode.END);
        layLinea_Ecom2.setAlignItems(FlexComponent.Alignment.CENTER);
        layLinea_Ecom2.setWidthFull();
        */
        layLinea_Ecom_T.getStyle().set("border", "1px solid #9E9E9E");
        layLinea_Ecom_T.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layLinea_Ecom_T.setAlignItems(FlexComponent.Alignment.CENTER);
        layLinea_Ecom_T.setWidthFull();
        //-------------------------------------------------------------------------------------------------------
        
        //DIALOG LINEAS ECOMMERCE
    
        //TITULO GENERAL
        lbdialogLE_titulo.getStyle().set("fontWeight","bold");
        lbdialogLE_titulo.getStyle().set("fontSize","150%");
         
        laydialogLE_titulo.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laydialogLE_titulo.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialogLE_titulo.setWidthFull();  
        //-------------------------------------------------------------------------------------------------------
    
        //LINEAS ECOMMERCE EXISTENTES
        lbdialogLE_LEExist.getStyle().set("fontWeight","bold");     
        lbdialogLE_LEExist.getStyle().set("fontSize","120%");
                
        laydialogLE_LEExistTitulo.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laydialogLE_LEExistTitulo.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialogLE_LEExistTitulo.setWidthFull(); 
    
        //Buscador de Lineas Ecommerce Existentes
        cmbdialogLE_LEcom.setPlaceholder("Elija Linea Ecommerce");
        cmbdialogLE_LEcom.setWidthFull();
        cmbdialogLE_LEcom.addValueChangeListener(event->{
            if(!event.getValue().contentEquals("No definida")){
                txtdialogLE_LEcom.setValue(event.getValue());
            }
            else
                txtdialogLE_LEcom.setValue("No definida");
        });



        
        txtdialogLE_LEcom.setWidthFull();
        txtdialogLE_LEcom.setReadOnly(true);
        
        //btndialogLE_LEcom.addThemeVariants(ButtonVariant.LUMO_CONTRAST);
        btndialogLE_LEcom.getStyle().set("fontSize","90%");
        
        laydialogLE_LEcom.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laydialogLE_LEcom.setAlignItems(FlexComponent.Alignment.BASELINE);
        laydialogLE_LEcom.setWidthFull();  
    
        //Nombre y Descripcion de la Linea Ecommerce
        txtdialogLE_Nombre.setWidthFull();
        
        txtdialogLE_Descripcion.setWidthFull();
        
        laydialogLE_Nombre.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laydialogLE_Nombre.setAlignItems(FlexComponent.Alignment.BASELINE);
        laydialogLE_Nombre.setWidthFull(); 
    
        //Orden y Activo de la Linea Ecommerce
        txtdialogLE_Orden.setWidthFull();
        
        dialogLE_CheckActivation.setWidthFull();
                
        laydialogLE_Orden.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laydialogLE_Orden.setAlignItems(FlexComponent.Alignment.BASELINE);
        laydialogLE_Orden.setWidthFull(); 
    
        //Botones Linea Ecommerce Existente
        btndialogLE_Guardar.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        btndialogLE_Guardar.getStyle().set("fontSize","90%");
        
        btndialogLE_Delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        btndialogLE_Delete.getStyle().set("fontSize","90%");
        
        btndialogLE_Cancel.addThemeVariants(ButtonVariant.LUMO_ERROR);
        btndialogLE_Cancel.getStyle().set("fontSize","90%");
        
        laydialogLE_Btns.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laydialogLE_Btns.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialogLE_Btns.setWidthFull(); 
    
        //LAYOUT TOTAL LINEAS ECOMMERCE EXISTENTES
        laydialogLE_LEExist_Total.getStyle().set("border", "1px solid #9E9E9E");
        laydialogLE_LEExist_Total.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laydialogLE_LEExist_Total.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialogLE_LEExist_Total.setWidthFull();
        //-------------------------------------------------------------------------------------------------------
        
        //NUEVA LINEA ECOMMERCE
        lbdialogLE_LENew.getStyle().set("fontWeight","bold");     
        lbdialogLE_LENew.getStyle().set("fontSize","120%");
        
        laydialogLE_LENewTitulo.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laydialogLE_LENewTitulo.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialogLE_LENewTitulo.setWidthFull();
        
        //Nombre y Descripcion de la Linea Ecommerce
        txtdialogLE_NombreNew.setWidthFull();
        
        txtdialogLE_DescripcionNew.setWidthFull();
        
        laydialogLE_NombreNew.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laydialogLE_NombreNew.setAlignItems(FlexComponent.Alignment.BASELINE);
        laydialogLE_NombreNew.setWidthFull(); 
    
        //Orden y Activo de la Linea Ecommerce
        txtdialogLE_OrdenNew.setWidthFull();

        dialogLE_CheckActivationNew.setWidthFull();
 
        laydialogLE_OrdenNew.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laydialogLE_OrdenNew.setAlignItems(FlexComponent.Alignment.BASELINE);
        laydialogLE_OrdenNew.setWidthFull();  
    
        //Botones Nueva Linea Ecommerce
        btndialogLE_GuardarNew.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        btndialogLE_GuardarNew.getStyle().set("fontSize","90%"); 
        
        btndialogLE_CancelNew.addThemeVariants(ButtonVariant.LUMO_ERROR);
        btndialogLE_CancelNew.getStyle().set("fontSize","90%");
        
        laydialogLE_BtnsNew.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laydialogLE_BtnsNew.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialogLE_BtnsNew.setWidthFull(); 
    
        //LAYOUT TOTAL NUEVA LINEA ECOMMERCE
        laydialogLE_LENew_Total.getStyle().set("border", "1px solid #9E9E9E");
        laydialogLE_LENew_Total.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laydialogLE_LENew_Total.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialogLE_LENew_Total.setWidthFull(); 
        //-------------------------------------------------------------------------------------------------------
        
        //LAYOUTS FINALES
        laydialogLE_Exist_New.getStyle().set("border", "1px solid #9E9E9E");
        laydialogLE_Exist_New.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laydialogLE_Exist_New.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialogLE_Exist_New.setWidthFull();
    
        laydialogLE_Final.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laydialogLE_Final.setAlignItems(FlexComponent.Alignment.BASELINE);
        laydialogLE_Final.setWidthFull();
        //-------------------------------------------------------------------------------------------------------
        
        //DIALOG PROPEERTIES
        dialog_LineaEcommerce.setCloseOnEsc(true);
        dialog_LineaEcommerce.setCloseOnOutsideClick(true); 
        
        //-------------------------------------------------------------------------------------------------------
        //NOTIFICATION DIALOG LINEA ECOMMERCE
        
        dialogLE_notf_is_Updated.getStyle().set("fontSize","90%");
        dialogLE_notf_is_Updated.getStyle().set("color", "green");
        
        dialogLE_notf_is_Deleted.getStyle().set("fontSize","90%");
        dialogLE_notf_is_Deleted.getStyle().set("color", "red");
        
        dialogLE_notf_is_Created.getStyle().set("fontSize","90%");
        dialogLE_notf_is_Created.getStyle().set("color", "green");
        
        notifyLE_is_Updated.setDuration(2500);
        notifyLE_is_Updated.setPosition(Notification.Position.MIDDLE);
         
        notifyLE_is_Deleted.setDuration(2500);
        notifyLE_is_Deleted.setPosition(Notification.Position.MIDDLE); 
        
        notifyLE_is_Created.setDuration(2500);
        notifyLE_is_Created.setPosition(Notification.Position.MIDDLE); 
        //-------------------------------------------------------------------------------------------------------
    
        //LINEAS ERP
        //-------------------------------------------------------------------------------------------------------
        
        //MAIN VIEW
    
        //Busqueda 1 : By Linea Ecommerce
        titulo_buscar.getStyle().set("fontWeight","bold");
        titulo_buscar.getStyle().set("fontSize","150%");
        
        lay_titulo_bus.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        lay_titulo_bus.setAlignItems(FlexComponent.Alignment.CENTER);
        lay_titulo_bus.setWidthFull();  
        //-------------------------------------------------------------------------------------------------------
        
        comboBoxLE_Bus.setPlaceholder("Elija Linea Ecommerce");
        //comboBoxLE_Bus.setWidthFull();
        comboBoxLE_Bus.addValueChangeListener(event->{
            if(!event.getValue().contentEquals("No definida")){
                txtLE_Bus.setValue(event.getValue());
            }
            else
                txtLE_Bus.setValue("No definida");
        });
        
        txtLE_Bus.setWidth("%1000");
        txtLE_Bus.setReadOnly(true);
        
        //btnLE_Bus.addThemeVariants(ButtonVariant.LUMO_CONTRAST);
        btnLE_Bus.getStyle().set("fontSize","90%");
        //btnLE_Bus.setWidthFull();
    
        lay_component_bus.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        lay_component_bus.setAlignItems(FlexComponent.Alignment.BASELINE);
        lay_component_bus.setWidthFull();  
        //-------------------------------------------------------------------------------------------------------
    
        //Busqueda 2 : By Linea ERP
        /*
        comboBoxLERP_Bus.setPlaceholder("Elija Linea Ecommerce");
        comboBoxLERP_Bus.setWidthFull();
        comboBoxLERP_Bus.addValueChangeListener(event->{
            if(!event.getValue().contentEquals("No definida")){
                txtLERP_Bus.setValue(event.getValue());
            }
            else
                txtLERP_Bus.setValue("No definida");
        }); 
        */
        txtLERP_Bus.setWidth("%2000");
        
        //btnLERP_Bus.addThemeVariants(ButtonVariant.LUMO_CONTRAST);
        btnLERP_Bus.getStyle().set("fontSize","90%"); 
        //btnLERP_Bus.setWidthFull();
    
        lay_component2_bus.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        lay_component2_bus.setAlignItems(FlexComponent.Alignment.BASELINE);
        lay_component2_bus.setWidthFull();
        //-------------------------------------------------------------------------------------------------------
        
        lay_Busquedas.getStyle().set("border", "1px solid #9E9E9E");
        lay_Busquedas.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        lay_Busquedas.setAlignItems(FlexComponent.Alignment.CENTER);
        lay_Busquedas.setWidthFull();
        //-------------------------------------------------------------------------------------------------------
        //Grid
        
        grid.addColumn(Linea::getNombre).setAutoWidth(true).setSortable(true).setHeader("Nombre");
        grid.addColumn(Linea::getDescripcion).setAutoWidth(true).setSortable(true).setHeader("Descripcion");
        //grid.addColumn(Linea::getLineaEcom_Nombre).setAutoWidth(true).setSortable(true).setHeader("Linea Ecommerce Asignada");
        
        grid.setSelectionMode(Grid.SelectionMode.MULTI);
        
        MultiSelect<Grid<Linea>, Linea> multiSelect = grid.asMultiSelect();
        
        /*
        grid.addColumn(new NativeButtonRenderer<>("Ver/Editar",item -> {
            grid.setDetailsVisible(item, !grid.isDetailsVisible(item));
            on_Open_LineaERPdialog();
            dialog_LineaERP.open();
        })).addAttachListener(e->{
            multiSelect.addValueChangeListener(event -> {
            if (event.getValue().isEmpty()){
                e.getSource().setVisible(false);
            } 
            else
                e.getSource().setVisible(true);
            });
        });
        */
        
        layGrid.getStyle().set("border", "1px solid #9E9E9E");
        layGrid.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layGrid.setAlignItems(FlexComponent.Alignment.CENTER);
        layGrid.setWidthFull(); 
        //-------------------------------------------------------------------------------------------------------
        //Informacion
    
        //lbInformation.getStyle().set("fontWeight","bold");
        lbInformation.getStyle().set("color", "red");
        lbInformation.getStyle().set("fontStyle","italic");
        lbInformation.getStyle().set("fontSize","90%");
        
        //layInformation.getStyle().set("border", "1px solid #9E9E9E");
        layInformation.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        layInformation.setAlignItems(FlexComponent.Alignment.CENTER);
        layInformation.setWidthFull(); 
        //-------------------------------------------------------------------------------------------------------
        //Button Ver/Editar
        
        //btnver_prod.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        //btnver_prod.getStyle().set("fontSize","90%");
        
        layBttnVer_Prod.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        layBttnVer_Prod.setAlignItems(FlexComponent.Alignment.CENTER);
        layBttnVer_Prod.setWidthFull();
        //-------------------------------------------------------------------------------
        //Footer Buttons
    
        btnAsignar_LE.addThemeVariants(ButtonVariant.LUMO_ICON);
        btnAsignar_LE.getStyle().set("fontSize","90%"); 
        
        btnExit.addThemeVariants(ButtonVariant.LUMO_ERROR);
        btnExit.getStyle().set("fontSize","90%"); 

        fButtons.getStyle().set("border", "1px solid #9E9E9E");
        fButtons.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        fButtons.setAlignItems(FlexComponent.Alignment.CENTER);
        fButtons.setWidthFull(); 
        //-------------------------------------------------------------------------------------------------------
        //END MAIN VIEW -----------------------------------------------------------------------------------------
        //-------------------------------------------------------------------------------------------------------
        

        //-----------------------------------------------------------------------------------------------------------
        //DIALOG LINEAS ERP - UNITARIO ------------------------------------------------------------------------------
        //-----------------------------------------------------------------------------------------------------------
        //TITULO GENERAL
        lbdialogLERP_titulo.getStyle().set("fontWeight","bold");
        lbdialogLERP_titulo.getStyle().set("fontSize","150%");
         
        laydialogLERP_titulo.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laydialogLERP_titulo.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialogLERP_titulo.setWidthFull(); 
        //-----------------------------------------------------------------------------------------------------------

        txtdialogLERP_nombre.setWidthFull();
        txtdialogLERP_nombre.setReadOnly(true);
        
        txtdialogLERP_descrp.setWidthFull();
        txtdialogLERP_descrp.setReadOnly(true);
        
        comboBoxdialogLERP_LEcom_Asign.setWidthFull();
        
        comboBoxdialogLERP_LEcom.setPlaceholder("Elija Linea Ecommerce");
        comboBoxdialogLERP_LEcom.setWidthFull();
        comboBoxdialogLERP_LEcom.addValueChangeListener(event->{
            if(!event.getValue().contentEquals("No definida")){
                txtdialogLERP_LEcom.setValue(event.getValue());
            }
            else
                txtdialogLERP_LEcom.setValue("No definida");
        });
                
        txtdialogLERP_LEcom.setWidthFull();
        txtdialogLERP_LEcom.setReadOnly(true);
        
        btndialogLERP_Asignar.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        btndialogLERP_Asignar.getStyle().set("fontSize","90%"); 
        btndialogLERP_Desasignar.addThemeVariants(ButtonVariant.LUMO_ERROR);
        btndialogLERP_Desasignar.getStyle().set("fontSize","90%"); 
        
        laydialogLERP_Btns.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laydialogLERP_Btns.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialogLERP_Btns.setWidthFull();
        
        laydialogLERP_Body.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laydialogLERP_Body.setAlignItems(FlexComponent.Alignment.BASELINE);
        laydialogLERP_Body.setWidthFull();
        //-----------------------------------------------------------------------------------------------------------

        btndialogLERP_Cerrar.addThemeVariants(ButtonVariant.LUMO_ERROR);
        btndialogLERP_Cerrar.getStyle().set("fontSize","90%");
        
        laydialogLERP_Cerrar.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laydialogLERP_Cerrar.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialogLERP_Cerrar.setWidthFull();  
        //-----------------------------------------------------------------------------------------------------------

        //LAYOUTS FINALES

        laydialogLERP_Final.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laydialogLERP_Final.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialogLERP_Final.setWidthFull(); 

        dialog_LineaERP.setCloseOnEsc(true);
        dialog_LineaERP.setCloseOnOutsideClick(true); 
        //-----------------------------------------------------------------------------------------------------------
        //DIALOG LINEAS ERP - UNITARIO END  -------------------------------------------------------------------------
        //-----------------------------------------------------------------------------------------------------------

        //-----------------------------------------------------------------------------------------------------------
        //DIALOG LINEAS ERP - VARIOS --------------------------------------------------------------------------------
        //-----------------------------------------------------------------------------------------------------------
        //TITULO GENERAL
        lbdialogLERP2_titulo.getStyle().set("fontWeight","bold");
        lbdialogLERP2_titulo.getStyle().set("fontSize","150%");
         
        laydialogLERP2_titulo.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laydialogLERP2_titulo.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialogLERP2_titulo.setWidthFull();  
        //-----------------------------------------------------------------------------------------------------------

        comboBoxdialogLERP2_LEcom.setPlaceholder("Elija Linea Ecommerce");
        comboBoxdialogLERP2_LEcom.setWidthFull();
        comboBoxdialogLERP2_LEcom.addValueChangeListener(event->{
            if(!event.getValue().contentEquals("No definida")){
                txtdialogLERP2_LEcom.setValue(event.getValue());
            }
            else
                txtdialogLERP2_LEcom.setValue("No definida");
        });
        
        txtdialogLERP2_LEcom.setWidthFull();
        txtdialogLERP2_LEcom.setReadOnly(true);
        
        btndialogLERP2_Asignar.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        btndialogLERP2_Asignar.getStyle().set("fontSize","90%");
        btndialogLERP2_Desasignar.addThemeVariants(ButtonVariant.LUMO_ERROR);
        btndialogLERP2_Desasignar.getStyle().set("fontSize","90%"); 

        laydialogLERP2_Body.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laydialogLERP2_Body.setAlignItems(FlexComponent.Alignment.BASELINE);
        laydialogLERP2_Body.setWidthFull();
        
        laydialogLERP2_Btns.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laydialogLERP2_Btns.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialogLERP2_Btns.setWidthFull();
        //-----------------------------------------------------------------------------------------------------------

        btndialogLERP2_Cerrar.addThemeVariants(ButtonVariant.LUMO_ERROR);
        btndialogLERP2_Cerrar.getStyle().set("fontSize","80%");
        
        laydialogLERP2_Cerrar.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laydialogLERP2_Cerrar.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialogLERP2_Cerrar.setWidthFull();  
        //-----------------------------------------------------------------------------------------------------------

        //LAYOUTS FINALES

        laydialogLERP2_Final.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laydialogLERP2_Final.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialogLERP2_Final.setWidthFull(); 

        dialog_LineaERP2.setCloseOnEsc(true);
        dialog_LineaERP2.setCloseOnOutsideClick(true);  
        //-----------------------------------------------------------------------------------------------------------
        //DIALOG LINEAS ERP - VARIOS END -----------------------------------------------------------------------------
        //-----------------------------------------------------------------------------------------------------------

        //-----------------------------------------------------------------------------------------------------------
        //NOTIFICATION DIALOG LINEA ERP
        //-----------------------------------------------------------------------------------------------------------
        dialogLERP_notf_is_Updated.getStyle().set("fontSize","90%");
        dialogLERP_notf_is_Updated.getStyle().set("color", "green");
        dialogLERP_notf_is_Unasign.getStyle().set("fontSize","90%");
        dialogLERP_notf_is_Unasign.getStyle().set("color", "red");
        dialogLERP_notf_select_Exceed.getStyle().set("fontSize","90%");
        dialogLERP_notf_select_Exceed.getStyle().set("color", "red");
        
        dialogLERP2_notf_is_Updated.getStyle().set("fontSize","90%");
        dialogLERP2_notf_is_Updated.getStyle().set("color", "green");
        dialogLERP2_notf_is_Unasign.getStyle().set("fontSize","90%");
        dialogLERP2_notf_is_Unasign.getStyle().set("color", "red");
        
        
        notifyLERP_select_Exceed.setDuration(2500);
        notifyLERP_select_Exceed.setPosition(Notification.Position.MIDDLE);
        notifyLERP_is_Updated.setDuration(2500);
        notifyLERP_is_Updated.setPosition(Notification.Position.MIDDLE);
        notifyLERP_is_Unasign.setDuration(2500);
        notifyLERP_is_Unasign.setPosition(Notification.Position.MIDDLE);
        
        notifyLERP2_is_Updated.setDuration(2500);
        notifyLERP2_is_Updated.setPosition(Notification.Position.MIDDLE);
        notifyLERP2_is_Unasign.setDuration(2500);
        notifyLERP2_is_Unasign.setPosition(Notification.Position.MIDDLE);
        //-----------------------------------------------------------------------------------------------------------
    }
    //-----------------------------------------------------------------------------------------------------------
    
    //CPANEL Rutas
    public abstract void go_CPanel();
    
    public abstract void go_Clientes();
    public abstract void go_Subscriptores();
    public abstract void go_Promociones();
    public abstract void go_Cupones();
    public abstract void go_PuntosUP();
    
    public abstract void go_Pedidos();
    public abstract void go_Productos();
    public abstract void go_Index();
    
    //FUNCTIONS
    //Busquedas
    public abstract void on_Click_ComboBusLineaEcom();
    public abstract void On_find_LineaEcom();
    public abstract void On_find_LineaERP();
    
    //Dialog Linea Ecommerce
    public abstract void on_Open_LineaEcomdialog();
    public abstract void on_find_LineaEcom_byName();
    public abstract void on_Crear_LineaEcom();
    public abstract void on_Actualizar_LineaEcom();
    public abstract void on_Borrar_LineaEcom();
    
    //Dialog Linea ERP
    public abstract void on_Open_LineaERPdialog();
    public abstract void on_Asignar_LineaERP();
    public abstract void on_Desasignar_LineaERP();
    
    //Dialog Lineas ERP
    public abstract void on_Open_LineaERP2dialog();
    public abstract void on_Asignar_LineasERP();
    public abstract void on_Desasignar_LineasERP();
    
    
    //-----------------------------------------------------------------------------------------------------------
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
        //MENU
        
        //Envía al Menu Principal - Panel de Control
        btnExit.addClickListener(e->{
            removeAll();
            go_CPanel();
            //add(new CPanelView());
        });
        //Envía al Menu Principal - Panel de Control
        begining.addClickListener(e->{
            removeAll();
            go_CPanel();
            //add(new CPanelView());
        });
        //Envía al Menu Inicio
        closeAcct.addClickListener(e->{
            removeAll();
            add(new App());
        });
        //VER/EDITAR PRODUCTO
        btnver_prod.addClickListener(e->{ 
            on_Open_LineaERPdialog();
            //dialog_LineaERP.open();
        });
        //----------------------------------------------------------------------------------------------------
       

        //Dialog Linea Ecommerce
        //Abrir dialogo
        btnLinea_Ecom.addClickListener(e->{ 
            on_Open_LineaEcomdialog();
            dialog_LineaEcommerce.open();
        });
        
        //Lineas Ecommerce Existentes
        btndialogLE_LEcom.addClickListener(e->{ 
            on_find_LineaEcom_byName();
        });
        btndialogLE_Guardar.addClickListener(e->{ 
            on_Actualizar_LineaEcom();
            notifyLE_is_Updated.open();
        });
        btndialogLE_Delete.addClickListener(e->{ 
            on_Borrar_LineaEcom();
            notifyLE_is_Deleted.open();
        });
        btndialogLE_Cancel.addClickListener(e->{ 
            dialog_LineaEcommerce.close();
        });
        //----------------------------------------------------------------------------------------------------
        //Nueva Linea Ecommerce
        btndialogLE_GuardarNew.addClickListener(e->{ 
            on_Crear_LineaEcom();
            notifyLE_is_Created.open();
        });
        btndialogLE_CancelNew.addClickListener(e->{ 
            dialog_LineaEcommerce.close();
        });
        //----------------------------------------------------------------------------------------------------
        //Dialog Linea ERP
        btndialogLERP_Asignar.addClickListener(e->{ 
            on_Asignar_LineaERP();
            notifyLERP_is_Updated.open();
        });
        btndialogLERP_Desasignar.addClickListener(e->{ 
            on_Desasignar_LineaERP();
            notifyLERP_is_Unasign.open();
        });
        btndialogLERP_Cerrar.addClickListener(e->{ 
            dialog_LineaERP.close();
        });
        //----------------------------------------------------------------------------------------------------
        //Dialog Lineas ERP
        btnAsignar_LE.addClickListener(e->{ 
            on_Open_LineaERP2dialog();
            dialog_LineaERP2.open();
        });
        btndialogLERP2_Asignar.addClickListener(e->{ 
            on_Asignar_LineasERP();
            notifyLERP2_is_Updated.open();
        });
        btndialogLERP2_Desasignar.addClickListener(e->{ 
            on_Desasignar_LineasERP();
            notifyLERP2_is_Unasign.open();
        });
        btndialogLERP2_Cerrar.addClickListener(e->{ 
            dialog_LineaERP2.close();
        });
        //----------------------------------------------------------------------------------------------------
    }
    //-----------------------------------------------------------------------------------------------------------
}
