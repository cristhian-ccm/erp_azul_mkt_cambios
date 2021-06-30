/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.view.ecom;

import com.upgrade.persistence.model.ecommerce.CatalogoPuntosUp;
import com.upgrade.persistence.model.ecommerce.PuntosUp;
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
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
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
import com.vaadin.flow.component.upload.SucceededEvent;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
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
public abstract class PuntosUpUI extends VerticalLayout{
    
    //-----------------------------------------------------------------------------------------------
    //CPANEL CABECERA
    //-----------------------------------------------------------------------------------------------
    public final Button btnClientes = new Button("Clientes Ecommerce", VaadinIcon.MALE.create());
    public final Button btnSubscriptores = new Button("Subscriptores Ecommerce", VaadinIcon.MALE.create());
    public final Button btnPromociones = new Button("Promociones Ecommerce", VaadinIcon.GIFT.create());
    public final Button btnCupones = new Button("Cupones Ecommerce", VaadinIcon.TICKET.create());
    //public final Button btnPuntosUP = new Button("Puntos UP Ecommerce", VaadinIcon.TROPHY.create());
    //-----------------------------------------------------------------------------------------------
    public final Button btnPedidos = new Button("Pedidos Ecommerce", VaadinIcon.CART_O.create());
    public final Button btnLineas = new Button("Lineas Ecommerce", VaadinIcon.RECORDS.create());
    public final Button btnProductos = new Button("Productos Ecommerce", VaadinIcon.PACKAGE.create());
    public final Button btnEcomPage = new Button("Página Ecommerce", VaadinIcon.GLOBE_WIRE.create());
    //-----------------------------------------------------------------------------------------------
    public final Button btnSalirCP = new Button("Salir del Panel de Control");
    //-----------------------------------------------------------------------------------------------
    public final HorizontalLayout layCPanelButtons = new HorizontalLayout(btnClientes,btnSubscriptores,btnPromociones,btnCupones);
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
    Label titulo = new Label("PUNTOS UP E-COMMERCE");    
    public final HorizontalLayout head = new HorizontalLayout(titulo);

    //-----------------------------------------------------------------------------------------------
    // WORKSPACE
    //-----------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------
    // BUSQUEDAS
    //-----------------------------------------------------------------------------------------------
    Label titulo_buscar = new Label("BUSQUEDA DE USUARIOS");
    public final HorizontalLayout lay_titulo_bus = new HorizontalLayout(titulo_buscar);
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
    
    //4) Layout
    public final HorizontalLayout primaryBar = new HorizontalLayout(layBtnFind,lay_FindFecha);
    
    public final VerticalLayout lay_Busquedas =  new VerticalLayout(lay_titulo_bus,layBtnFind,lay_FindFecha);
    //-----------------------------------------------------------------------------------------------
    //TABLE - INFORMATION
    //-----------------------------------------------------------------------------------------------
    public final Grid<PuntosUp> grid = new Grid<>();
    public final VerticalLayout layGrid = new VerticalLayout(grid);
    
    public final Label lbInformation = new Label("*Nota: Seleccione el usuario antes de Editar");
    public final HorizontalLayout layInformation = new HorizontalLayout(lbInformation);
    
    public final Button btnVer_prod = new Button("Ver/Editar", VaadinIcon.EYE.create());
    public final Button btnAgregar_pts = new Button("Agregar Puntos", VaadinIcon.ARROW_UP.create());
    public final Button btnDisminuir_pts = new Button("Disminuir Puntos", VaadinIcon.ARROW_DOWN.create());
    //-----------------------------------------------------------------------------------------------
    public final HorizontalLayout layButtonsGrid = new HorizontalLayout(btnVer_prod,btnAgregar_pts,btnDisminuir_pts);
    //-----------------------------------------------------------------------------------------------
    //CATALOGO - PDF
    //-----------------------------------------------------------------------------------------------
    public final MemoryBuffer bufferCatalogo = new MemoryBuffer();
    public final Upload uploadCatalogo = new Upload(bufferCatalogo);
    
    ///////////////////////////// MODIFICACION DE CATALOGO //////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////
    //----------------------------------------------------------------------------------------------
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------


    public final Label lbTit_Catalogo = new Label("AGREGAR CATALOGO PARA PUNTOS UP");
    public final HorizontalLayout layTit_Catalogo = new HorizontalLayout(lbTit_Catalogo);
    //-----------------------------------------------------------------------------------------------
    
    public final HorizontalLayout layCatalogo_part1 = new HorizontalLayout();
    //-----------------------------------------------------------------------------------------------
    public final TextField txtCatNUrlpdf = new TextField("Url PDF");
    public final Button btnCatUpload = new Button("Subir Catalogo PDF");
    public final Checkbox checkCat_Activar = new Checkbox("Activar?");
    
    public final HorizontalLayout layCatalogo_part2 = new HorizontalLayout(txtCatNUrlpdf,uploadCatalogo,checkCat_Activar);
    //-----------------------------------------------------------------------------------------------
    public final Button btnCatSave = new Button("Guardar Catálogo", VaadinIcon.HARDDRIVE_O.create());
    public final Button btnCatExit = new Button("Salir");    

    
    public final HorizontalLayout layCatalogo_part3 = new HorizontalLayout(btnCatSave,btnCatExit);


    //-----------------------------------------------------------------------------------------------

    //-----------------------------------------------------------------------------------------------
   
    Label tituloCatalogo = new Label("Catalogos Puntos Up");    
    public final HorizontalLayout laytituloCat = new HorizontalLayout(tituloCatalogo);

    public final Button btnVerCatalogo = new Button("Mostrar Catalogos", VaadinIcon.LIST_OL.create());
    public final Button btnAddCatalogo = new Button("Nuevo Catalogo", VaadinIcon.PLUS_CIRCLE.create());
    public final Button btnEditCatalogo = new Button("Ver/Editar/Eliminar", VaadinIcon.EDIT.create());
    //-----------------------------------------------------------------------------------------------
    public final HorizontalLayout laybtnCatalogos = new HorizontalLayout(btnVerCatalogo,btnAddCatalogo,btnEditCatalogo);



    public final Grid<CatalogoPuntosUp> gridCatalogo = new Grid<>();
    public final VerticalLayout layGridCatalogo = new VerticalLayout(gridCatalogo);


///////////////////////////////////// DIALOGO EDITAR CATALOGO/////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////

Label tituloEditCat = new Label("EDITAR CATALOGO");    
public final HorizontalLayout layeditcat = new HorizontalLayout(tituloEditCat);

public final TextField txteditCat_urlpdf = new TextField("Url Catalogo");

public final TextField txteditCat_Activo = new TextField("Estado Activo Actual");

public final ComboBox <String> cmbActivo = new ComboBox<>();

public final Button btnActualizarCat = new Button("Actualizar Catalogo");

public final Button btnEliminarCat = new Button("Eliminar Catalogo");

public final Button btnSalirEditCat = new Button("Salir");

public final VerticalLayout layEditBtns = new VerticalLayout(btnActualizarCat,btnEliminarCat,btnSalirEditCat);

public final VerticalLayout layTotalEditCat = new VerticalLayout(layeditcat,txteditCat_urlpdf,txteditCat_Activo,cmbActivo,layEditBtns);














    //DIALOGO GESTIONARL CATALOGOS
    //-----------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------
   

    public final VerticalLayout layCatalogo = new VerticalLayout(layTit_Catalogo,layCatalogo_part2,layCatalogo_part3);
    public final Dialog dialogoCatalogo = new Dialog(layCatalogo);


    public final Dialog dialogoEditCatalogo = new Dialog(layTotalEditCat);




   
    /////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////
    //-----------------------------------------------------------------------------------------------
    public final Button btnExit = new Button("Salir");
    //-----------------------------------------------------------------------------------------------
    public final HorizontalLayout fButtons = new HorizontalLayout(btnExit);
    //-----------------------------------------------------------------------------------------------
    //END MAIN VIEW
    //-----------------------------------------------------------------------------------------------
    
    
    //-----------------------------------------------------------------------------------------------
    //DIALOG PUNTOS-UP
    //-----------------------------------------------------------------------------------------------
    public final Label titulo_dialog = new Label("EDIT PUNTOS-UP");
    public final HorizontalLayout layTitulo_dialog = new HorizontalLayout(titulo_dialog);
    //-----------------------------------------------------------------------------------------------
    public final TextField txtdialog_UsuName = new TextField("Nombre");
    public final HorizontalLayout laydialog_UsuName = new HorizontalLayout(txtdialog_UsuName);
    //-----------------------------------------------------------------------------------------------
    public final EmailField dialog_UsuEmail = new EmailField("Email");
    public final HorizontalLayout laydialog_UsuEmail = new HorizontalLayout(dialog_UsuEmail);
    //-----------------------------------------------------------------------------------------------
    public final TextField txtdialog_UsuTlf = new TextField("Telefono");
    public final HorizontalLayout laydialog_UsuTlf = new HorizontalLayout(txtdialog_UsuTlf);
    //-----------------------------------------------------------------------------------------------
    public final TextField txtdialog_PuntosUp = new TextField("Puntos UP Actuales");
    public final Button btnDisminuirPtsUP = new Button("Disminuir Puntos UP");
    public final TextField txtdialog_NewPuntosUp = new TextField("Puntos UP a modificar");
    public final Button btnIncrementarPtsUP = new Button("Incrementar Puntos UP");
    public final HorizontalLayout laydialog_PuntosUp = new HorizontalLayout(txtdialog_PuntosUp,btnDisminuirPtsUP,
                                                                            txtdialog_NewPuntosUp,btnIncrementarPtsUP);
    //-----------------------------------------------------------------------------------------------
    public final Button btnCancel = new Button("Salir");
    public final HorizontalLayout laydialogBtns = new HorizontalLayout(btnCancel);
    //-----------------------------------------------------------------------------------------------
    //CREATE DIALOG PUNTOS-UP
    //-----------------------------------------------------------------------------------------------
    public final VerticalLayout laydialogClient = new VerticalLayout(layTitulo_dialog,laydialog_UsuName,laydialog_UsuEmail,
                                                                     laydialog_UsuTlf,laydialog_PuntosUp,laydialogBtns);
    public final Dialog dialogClient = new Dialog(laydialogClient);
    //-----------------------------------------------------------------------------------------------
    //NOTIFICATION PUNTOS-UP
    //-----------------------------------------------------------------------------------------------
    public final Label Client_notf_correct = new Label("Puntos UP Actualizados Correctamente");
    public final Notification Client_notify_correct = new Notification(Client_notf_correct);
    
    public final Label notf_select_exceed = new Label("Más de un Cliente ha sido seleccionado. Por favor, seleccione sólo uno");
    public final Notification notify_select_exceed = new Notification(notf_select_exceed);

    public final Label lblmsgErrorSelect = new Label("Seleccione un Catalogo Antes de Editar");
    public final Notification msgErrorSelect = new Notification(lblmsgErrorSelect);

    public final Label Client_notf_eliminado = new Label("CATALOGO ELIMINADO CORRECTAMENTE");
    public final Notification Client_notfy_eliminado = new Notification(Client_notf_eliminado);

    public final Label lblCatCreado = new Label("CATALOGO GUARDADO CORRECTAMENTE");
    public final Notification msgCatCreado = new Notification(lblCatCreado);

    public final Label lblCatActualizado= new Label("CATALOGO ACTUALIZADO CORRECTAMENTE");
    public final Notification msgCatActualizado= new Notification(lblCatActualizado);





    //-----------------------------------------------------------------------------------------------
    //END DIALOG PUNTOS-UP
    //-----------------------------------------------------------------------------------------------
    
    
    
    //-----------------------------------------------------------------------------------------------
    //DIALOG PUNTOS-UP - AUMENTAR
    //-----------------------------------------------------------------------------------------------
    public final Label lbdialog_IncPUP = new Label("INCREMENTAR PUNTOS-UP");
    public final HorizontalLayout laytit_IncPUP = new HorizontalLayout(lbdialog_IncPUP);
    //-----------------------------------------------------------------------------------------------
    public final TextField txtdialog_IncPUP = new TextField("Puntos a Aumentar");
    public final HorizontalLayout laydialog_IncPUP = new HorizontalLayout(txtdialog_IncPUP);
    //-----------------------------------------------------------------------------------------------
    public final Button btndialog_IncPUP = new Button("Incrementar Puntos UP");
    public final Button btndialog_ExitIncPUP = new Button("Salir");
    public final HorizontalLayout laydialog_BtnsIncPUP = new HorizontalLayout(btndialog_IncPUP,btndialog_ExitIncPUP);
    //-----------------------------------------------------------------------------------------------
    //CREATE DIALOG PUNTOS-UP - AUMENTAR
    //-----------------------------------------------------------------------------------------------
    public final VerticalLayout laydialog_TotalIncPUP = new VerticalLayout(laytit_IncPUP,laydialog_IncPUP,laydialog_BtnsIncPUP);
    public final Dialog dialogIncrementPUP = new Dialog(laydialog_TotalIncPUP);
    //-----------------------------------------------------------------------------------------------
  
  
    
    //DIALOG PUNTOS-UP - DISMINUIR
    //-----------------------------------------------------------------------------------------------
    public final Label lbdialog_DisPUP = new Label("DISMINUIR PUNTOS-UP");
    public final HorizontalLayout laytit_DisPUP = new HorizontalLayout(lbdialog_DisPUP);
    //-----------------------------------------------------------------------------------------------
    public final TextField txtdialog_DisPUP = new TextField("Puntos a Disminuir");
    public final HorizontalLayout laydialog_DisPUP = new HorizontalLayout(txtdialog_DisPUP);
    //-----------------------------------------------------------------------------------------------
    public final Button btndialog_DisPUP = new Button("Disminuir Puntos UP");
    public final Button btndialog_ExitDisPUP = new Button("Salir");
    public final HorizontalLayout laydialog_BtnsDisPUP = new HorizontalLayout(btndialog_DisPUP,btndialog_ExitDisPUP);
    //-----------------------------------------------------------------------------------------------
    //CREATE DIALOG PUNTOS-UP - DISMINUIR
    //-----------------------------------------------------------------------------------------------
    public final VerticalLayout laydialog_TotalDisPUP = new VerticalLayout(laytit_DisPUP,laydialog_DisPUP,laydialog_BtnsDisPUP);
    
    public final Dialog dialogDisminuirPUP = new Dialog(laydialog_TotalDisPUP);
    //-----------------------------------------------------------------------------------------------
    //END DIALOG PUNTOS-UP - DISMINUIR
    //-----------------------------------------------------------------------------------------------
    
    
    
    //-----------------------------------------------------------------------------------------------
    //INIT MAIN PROCESS
    //-----------------------------------------------------------------------------------------------
    public PuntosUpUI() {
        
        removeAll();
        add(layCPanelButtons,layCPanelButtons2, head, lay_Busquedas, layButtonsGrid, layGrid, layInformation,
        laytituloCat,laybtnCatalogos,layGridCatalogo,fButtons);
        btnFind_Activos.addClickListener(e->On_find_Activos());
        btnFind_NoActivos.addClickListener(e->On_find_NoActivos());
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
        
        btnSubscriptores.setWidthFull();
        btnSubscriptores.getStyle().set("fontSize","80%");
        
        btnPromociones.setWidthFull();
        btnPromociones.getStyle().set("fontSize","80%");
        
        btnCupones.setWidthFull();
        btnCupones.getStyle().set("fontSize","80%");
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

        tituloCatalogo.getStyle().set("fontWeight","bold");
        tituloCatalogo.getStyle().set("fontSize","190%");

        tituloEditCat.getStyle().set("fontWeight","bold");
        tituloEditCat.getStyle().set("fontSize","120%");

        
        head.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        head.setWidthFull();

        laytituloCat.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laytituloCat.setWidthFull();
        


        
        //layBtnFind.getStyle().set("border", "1px solid #9E9E9E");
        //-----------------------------------------------------------------------------------------------
        titulo_buscar.getStyle().set("fontWeight","bold");
        titulo_buscar.getStyle().set("fontSize","150%");
        
        lay_titulo_bus.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        lay_titulo_bus.setWidthFull();
        //-----------------------------------------------------------------------------------------------
        layBtnFind.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        layBtnFind.setAlignItems(FlexComponent.Alignment.BASELINE);
        layBtnFind.setWidthFull();
        
        lay_FindFecha.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        lay_FindFecha.setAlignItems(FlexComponent.Alignment.BASELINE);
        lay_FindFecha.setWidthFull();
        
        //primaryBar.getStyle().set("border", "1px solid #9E9E9E");
        primaryBar.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        primaryBar.setAlignItems(FlexComponent.Alignment.BASELINE);
        primaryBar.setWidthFull();
        
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

        layGridCatalogo.getStyle().set("border", "1px solid #9E9E9E");
        layGridCatalogo.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layGridCatalogo.setAlignItems(FlexComponent.Alignment.CENTER);
        layGridCatalogo.setWidthFull();

        layTit_Catalogo.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layTit_Catalogo.setAlignItems(FlexComponent.Alignment.CENTER);
        layTit_Catalogo.setWidthFull();


        layeditcat.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layeditcat.setAlignItems(FlexComponent.Alignment.CENTER);


        btnEliminarCat.addThemeVariants(ButtonVariant.LUMO_ERROR);
        btnEliminarCat.getStyle().set("fontSize","90%");
        btnEliminarCat.setWidthFull();;
        



        btnActualizarCat.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        btnActualizarCat.getStyle().set("fontSize","90%");
        btnActualizarCat.setWidthFull();


        btnSalirEditCat.addThemeVariants(ButtonVariant.LUMO_ERROR);
        btnSalirEditCat.getStyle().set("fontSize", "90%");
        btnSalirEditCat.setWidth("50%");



        
        //grid.removeAllColumns();
        grid.addColumn(PuntosUp::getNombre_Usuweb).setAutoWidth(true).setSortable(true).setHeader("Nombre");
        grid.addColumn(PuntosUp::getActivo).setAutoWidth(true).setSortable(true).setHeader("Activo");
        grid.addColumn(PuntosUp::getPts_restantes).setAutoWidth(true).setSortable(true).setHeader("PuntosUP Restantes");
        
        grid.setSelectionMode(Grid.SelectionMode.MULTI);
        MultiSelect<Grid<PuntosUp>, PuntosUp> multiSelect = grid.asMultiSelect();



        gridCatalogo.addColumn(CatalogoPuntosUp::getId).setAutoWidth(true).setSortable(true).setHeader("id");
        gridCatalogo.addColumn(CatalogoPuntosUp::getCreacion).setAutoWidth(true).setSortable(true).setHeader("Fecha Creacion");
        gridCatalogo.addColumn(CatalogoPuntosUp::getActivo).setAutoWidth(true).setSortable(true).setHeader("Activo");
        gridCatalogo.addColumn(CatalogoPuntosUp::getUrl_pdf).setAutoWidth(true).setSortable(true).setHeader("Url Catalogo PDF");

        gridCatalogo.setSelectionMode(Grid.SelectionMode.MULTI);

        cmbActivo.setPlaceholder("Cambiar Estado Activo");
        cmbActivo.setWidth("70%");

  

  


        //-----------------------------------------------------------------------------------------------
        btnVer_prod.getStyle().set("fontSize","90%");
        btnAgregar_pts.getStyle().set("fontSize","90%");
        btnDisminuir_pts.getStyle().set("fontSize","90%");

        btnVerCatalogo.getStyle().set("fontSize","90%");
        btnAddCatalogo.getStyle().set("fontSize","90%");
        btnEditCatalogo.getStyle().set("fontSize","90%");



        
        layButtonsGrid.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        layButtonsGrid.setAlignItems(FlexComponent.Alignment.BASELINE);
        layButtonsGrid.setWidthFull();

        laybtnCatalogos.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laybtnCatalogos.setAlignItems(FlexComponent.Alignment.BASELINE);
        laybtnCatalogos.setWidthFull();



        //-----------------------------------------------------------------------------------------------
        //CATALOGO - PDF
        //-----------------------------------------------------------------------------------------------
        uploadCatalogo.setAutoUpload(true);
        uploadCatalogo.setDropAllowed(false);
        uploadCatalogo.setUploadButton(btnCatUpload);
        uploadCatalogo.setMaxFileSize(10000000);
        
        //-----------------------------------------------------------------------------------------------
        lbTit_Catalogo.getStyle().set("fontWeight","bold");
        lbTit_Catalogo.getStyle().set("fontSize","120%"); 
                
      
        //-----------------------------------------------------------------------------------------------
      

        //checkCat_Activate.setWidthFull(); 
        
        
       
        
        layCatalogo_part1.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        layCatalogo_part1.setAlignItems(FlexComponent.Alignment.BASELINE);
        layCatalogo_part1.setWidthFull(); 



        layEditBtns.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layEditBtns.setAlignItems(FlexComponent.Alignment.CENTER);








        //-----------------------------------------------------------------------------------------------
        txtCatNUrlpdf.setWidthFull();
        txteditCat_urlpdf.setWidthFull();
        txteditCat_Activo.setWidthFull();


        txteditCat_Activo.setReadOnly(true);
        

        
        btnCatUpload.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        btnCatUpload.getStyle().set("fontSize","100%");
        
        checkCat_Activar.getStyle().set("fontSize","80%");

        layCatalogo_part2.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        layCatalogo_part2.setAlignItems(FlexComponent.Alignment.BASELINE);
        layCatalogo_part2.setWidthFull(); 
        layCatalogo_part2.setHeight("30%");


        //-----------------------------------------------------------------------------------------------
        btnCatSave.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        btnCatSave.getStyle().set("fontSize","100%");

        btnCatExit.addThemeVariants(ButtonVariant.LUMO_ERROR);
        btnCatExit.getStyle().set("fontSize", "100%");





        layCatalogo_part3.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        layCatalogo_part3.setAlignItems(FlexComponent.Alignment.START);
        layCatalogo_part3.setWidthFull(); 
        //-----------------------------------------------------------------------------------------------
      
        //-----------------------------------------------------------------------------------------------
        //FOOTER
        //-----------------------------------------------------------------------------------------------
        btnExit.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        btnExit.getStyle().set("fontSize","90%");
        
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
        //-----------------------------------------------------------------------------------------------
        txtdialog_UsuName.setWidthFull();
        txtdialog_UsuName.setReadOnly(true);
        
        laydialog_UsuName.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laydialog_UsuName.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialog_UsuName.setWidthFull();
        //-----------------------------------------------------------------------------------------------
        dialog_UsuEmail.setErrorMessage("Por favor ingrese un Email válido");
        dialog_UsuEmail.setWidthFull();
        dialog_UsuEmail.setReadOnly(true);
        dialog_UsuEmail.setWidth("800%");


        dialogoCatalogo.setWidth("50%");
        dialogoCatalogo.setHeight("35%");

        dialogoEditCatalogo.setWidth("25%");
        dialogoEditCatalogo.setHeight("60%");


             
        laydialog_UsuEmail.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laydialog_UsuEmail.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialog_UsuEmail.setWidthFull();
        //-----------------------------------------------------------------------------------------------
        txtdialog_UsuTlf.setWidthFull();
        txtdialog_UsuTlf.setReadOnly(true);
        
        laydialog_UsuTlf.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laydialog_UsuTlf.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialog_UsuTlf.setWidthFull();
        //-----------------------------------------------------------------------------------------------
        txtdialog_PuntosUp.setWidthFull();
        txtdialog_PuntosUp.setReadOnly(true);
        
        btnDisminuirPtsUP.addThemeVariants(ButtonVariant.LUMO_ERROR);
        btnDisminuirPtsUP.getStyle().set("fontSize","90%");
        btnDisminuirPtsUP.setWidthFull();
        
        txtdialog_NewPuntosUp.setWidthFull();
        
        btnIncrementarPtsUP.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        btnIncrementarPtsUP.getStyle().set("fontSize","90%");
        btnIncrementarPtsUP.setWidthFull();
        
        laydialog_PuntosUp.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laydialog_PuntosUp.setAlignItems(FlexComponent.Alignment.BASELINE);
        laydialog_PuntosUp.setWidthFull();
        //-----------------------------------------------------------------------------------------------
        btnCancel.addThemeVariants(ButtonVariant.LUMO_ERROR);
        btnCancel.getStyle().set("fontSize","90%");
        
        laydialogBtns.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laydialogBtns.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialogBtns.setWidthFull();
        //-----------------------------------------------------------------------------------------------
        //-----------------------------------------------------------------------------------------------
        dialogClient.setCloseOnEsc(true);
        dialogClient.setCloseOnOutsideClick(true);
        //-----------------------------------------------------------------------------------------------
        //NOTIFICATION
        //-----------------------------------------------------------------------------------------------
        notf_select_exceed.getStyle().set("fontSize","100%");
        notf_select_exceed.getStyle().set("color", "red");
        
        Client_notify_correct.setDuration(2000);
        Client_notify_correct.setPosition(Notification.Position.MIDDLE);
        
        notify_select_exceed.setDuration(2500);
        notify_select_exceed.setPosition(Notification.Position.MIDDLE); 

        msgErrorSelect.setDuration(2500);
        msgErrorSelect.setPosition(Notification.Position.MIDDLE);
        lblmsgErrorSelect.getStyle().set("fontSize", "115%");
        lblmsgErrorSelect.getStyle().set("color", "red");

        Client_notfy_eliminado.setDuration(3000);
        Client_notfy_eliminado.setPosition(Notification.Position.MIDDLE);

        Client_notf_eliminado.getStyle().set("fontSize","90%");
        Client_notf_eliminado.getStyle().set("fontWeight","bold");
        Client_notf_eliminado.getStyle().set("color", "#e72813");


        msgCatActualizado.setDuration(3000);
        msgCatActualizado.setPosition(Notification.Position.MIDDLE);

        lblCatActualizado.getStyle().set("fontSize","90%");
        lblCatActualizado.getStyle().set("fontWeight","bold");
        lblCatActualizado.getStyle().set("color", "#88ee4e");


        

       
       

        msgCatCreado.setDuration(3000);
        msgCatCreado.setPosition(Notification.Position.MIDDLE);

        lblCatCreado.getStyle().set("fontSize", "90%");
        lblCatCreado.getStyle().set("color", "#88ee4e");
        lblCatCreado.getStyle().set("fontWeight", "bold");




       
      

        //----------------------------------------------------------------------
        
        
        
        //-----------------------------------------------------------------------------------------------
        //DIALOG PUNTOS-UP - AUMENTAR
        //-----------------------------------------------------------------------------------------------
        lbdialog_IncPUP.getStyle().set("fontWeight","bold");
        lbdialog_IncPUP.getStyle().set("fontSize","150%");
        
        laytit_IncPUP.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laytit_IncPUP.setAlignItems(FlexComponent.Alignment.CENTER);
        laytit_IncPUP.setWidthFull();
        //-----------------------------------------------------------------------------------------------
        txtdialog_IncPUP.setWidthFull();
        
        laydialog_IncPUP.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laydialog_IncPUP.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialog_IncPUP.setWidthFull();
        //-----------------------------------------------------------------------------------------------
        btndialog_IncPUP.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        btndialog_IncPUP.getStyle().set("fontSize","90%");
        
        btndialog_ExitIncPUP.addThemeVariants(ButtonVariant.LUMO_ERROR);
        btndialog_ExitIncPUP.getStyle().set("fontSize","90%");
        
        laydialog_BtnsIncPUP.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laydialog_BtnsIncPUP.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialog_BtnsIncPUP.setWidthFull();
        //-----------------------------------------------------------------------------------------------
        //CREATE DIALOG PUNTOS-UP - AUMENTAR
        //-----------------------------------------------------------------------------------------------
        laydialog_TotalIncPUP.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laydialog_TotalIncPUP.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialog_TotalIncPUP.setWidthFull(); 

        dialogIncrementPUP.setCloseOnEsc(true);
        dialogIncrementPUP.setCloseOnOutsideClick(true);
        //-----------------------------------------------------------------------------------------------
        //END DIALOG PUNTOS-UP - AUMENTAR
        //-----------------------------------------------------------------------------------------------
        
        
        
        
        //-----------------------------------------------------------------------------------------------
        //DIALOG PUNTOS-UP - DISMINUIR
        //-----------------------------------------------------------------------------------------------
        lbdialog_DisPUP.getStyle().set("fontWeight","bold");
        lbdialog_DisPUP.getStyle().set("fontSize","150%");
        
        laytit_DisPUP.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laytit_DisPUP.setAlignItems(FlexComponent.Alignment.CENTER);
        laytit_DisPUP.setWidthFull();
        //-----------------------------------------------------------------------------------------------
        txtdialog_DisPUP.setWidthFull();
        
        laydialog_DisPUP.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laydialog_DisPUP.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialog_DisPUP.setWidthFull();
        //-----------------------------------------------------------------------------------------------
        btndialog_DisPUP.addThemeVariants(ButtonVariant.LUMO_ERROR);
        btndialog_DisPUP.getStyle().set("fontSize","90%");
        
        btndialog_ExitDisPUP.addThemeVariants(ButtonVariant.LUMO_ERROR);
        btndialog_ExitDisPUP.getStyle().set("fontSize","90%");
        
        laydialog_BtnsDisPUP.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laydialog_BtnsDisPUP.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialog_BtnsDisPUP.setWidthFull();
        //-----------------------------------------------------------------------------------------------
        //CREATE DIALOG PUNTOS-UP - DISMINUIR
        //-----------------------------------------------------------------------------------------------
        laydialog_TotalDisPUP.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laydialog_TotalDisPUP.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialog_TotalDisPUP.setWidthFull(); 

        dialogDisminuirPUP.setCloseOnEsc(true);
        dialogDisminuirPUP.setCloseOnOutsideClick(true);
        //-----------------------------------------------------------------------------------------------
        //END DIALOG PUNTOS-UP - DISMINUIR
        //-----------------------------------------------------------------------------------------------
        
    }
    
    //-----------------------------------------------------------------------------------------------
    //CPANEL RUTAS
    //-----------------------------------------------------------------------------------------------
    public abstract void go_CPanel();
    
    public abstract void go_Clientes();
    public abstract void go_Subscriptores();
    public abstract void go_Promociones();
    public abstract void go_Cupones();
    
    public abstract void go_Pedidos();
    public abstract void go_LineasEcom();
    public abstract void go_Productos();
    public abstract void go_Index();
    //-----------------------------------------------------------------------------------------------
    
    //-----------------------------------------------------------------------------------------------
    //BUSQUEDAS
    //-----------------------------------------------------------------------------------------------
    public abstract void On_find_Activos();
    public abstract void On_find_NoActivos();
    public abstract void On_find_Fechas();
    //-----------------------------------------------------------------------------------------------
    
    //-----------------------------------------------------------------------------------------------
    //DIALOGS PUNTOS UP
    //-----------------------------------------------------------------------------------------------
    public abstract void on_Open_CatalogoAdd();


    public abstract void on_Open_Clientdialog();
    public abstract void on_Incrementar_PuntosUP();
    public abstract void on_Disminuir_PuntosUP();
    //-----------------------------------------------------------------------------------------------
    public abstract void on_Open_Incrementdialog();
    public abstract void on_UpdateInc_PuntosUP();
    //-----------------------------------------------------------------------------------------------
    public abstract void on_Open_Disminuirdialog();
    public abstract void on_UpdateDis_PuntosUP();
    //-----------------------------------------------------------------------------------------------
    
    //-----------------------------------------------------------------------------------------------
    //CATALOGO
    //-----------------------------------------------------------------------------------------------
    public abstract void on_editar_Catalogo();
    public abstract void on_Mostrar_Catalogos();
    public abstract void init_Catalogos();
    public abstract void on_UploadNewCatalogo(SucceededEvent event);
    public abstract void on_SaveNewCatalogo();
    public abstract void on_BeforeCatalogo();
    public abstract void on_AfterCatalogo();
    public abstract void on_EliminarCatalogo();
    public abstract void on_ActualizarCatalogo();


    //-----------------------------------------------------------------------------------------------
    
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
        //DIALOGS PUNTOS UP
        //-----------------------------------------------------------------------------------------------
                
        btnAddCatalogo.addClickListener(e->{ 
            on_Open_CatalogoAdd();
        });        
        btnVer_prod.addClickListener(e->{ 
            on_Open_Clientdialog();
        });
        btnIncrementarPtsUP.addClickListener(e->{ 
            on_Incrementar_PuntosUP();
        });
        btnDisminuirPtsUP.addClickListener(e->{ 
            on_Disminuir_PuntosUP();
        });
        btnCancel.addClickListener(e->{ 
            dialogClient.close();
        });
        //-----------------------------------------------------------------------------------------------
        btnAgregar_pts.addClickListener(e->{ 
            on_Open_Incrementdialog();
        });
        btndialog_IncPUP.addClickListener(e->{ 
            on_UpdateInc_PuntosUP();
        });
        btndialog_ExitIncPUP.addClickListener(e->{ 
            dialogIncrementPUP.close();
        });
        //-----------------------------------------------------------------------------------------------
        btnDisminuir_pts.addClickListener(e->{ 
            on_Open_Disminuirdialog();
        });
        btndialog_DisPUP.addClickListener(e->{ 
            on_UpdateDis_PuntosUP();
        });
        btndialog_ExitDisPUP.addClickListener(e->{ 
            dialogDisminuirPUP.close();
        });
        
        
        
        
        //-----------------------------------------------------------------------------------------------
        //CATALOGO
        //-----------------------------------------------------------------------------------------------
        init_Catalogos();
        uploadCatalogo.addSucceededListener(this::on_UploadNewCatalogo);


        btnSalirEditCat.addClickListener(e->{

            dialogoEditCatalogo.close();
            txteditCat_Activo.setValue("");
            btnActualizarCat.setEnabled(true);
            btnEliminarCat.setEnabled(true);
                        

            
        });



        btnEliminarCat.addClickListener(e->{
            on_EliminarCatalogo();
            on_Mostrar_Catalogos();
            dialogoEditCatalogo.close();
        });


        btnActualizarCat.addClickListener(e->{

            on_ActualizarCatalogo();
            on_Mostrar_Catalogos();

            btnActualizarCat.setEnabled(false);
            btnEliminarCat.setEnabled(false);


            
        });
         
        btnEditCatalogo.addClickListener(e->{ 

            on_editar_Catalogo();
            
            
        });       

        

        btnCatExit.addClickListener(e->{ 
            dialogoCatalogo.close();
            



        });
        btnVerCatalogo.addClickListener(e->{ 
            on_Mostrar_Catalogos();
            dialogClient.setCloseOnEsc(false);
            dialogClient.setCloseOnOutsideClick(false);
        });




        
        btnCatSave.addClickListener(e->{ 
            on_SaveNewCatalogo();
            on_Mostrar_Catalogos();
            dialogoCatalogo.close();

        });

       

        
     
        //-----------------------------------------------------------------------------------------------
    }

}


