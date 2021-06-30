package up.erp.view.ecom;

import com.google.gwt.resources.client.ExternalTextResource;
import com.google.gwt.uibinder.rebind.XMLElement.Location;
import com.google.gwt.user.client.Window;
import com.squareup.okhttp.internal.framed.Variant;
import com.upgrade.persistence.model.ecommerce.BannerOb;
import com.upgrade.persistence.model.ecommerce.ProgramOB;
import com.upgrade.persistence.model.ecommerce.PuntosUp;
import com.upgrade.persistence.model.ecommerce.UsuarioWeb;
import com.upgrade.persistence.model.extcs.Linea;
import com.upgrade.persistence.model.tcros.Persona;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.UI;
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
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.BoxSizing;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.BrowserWindowResizeEvent;
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
import javax.swing.text.StyledEditorKit.BoldAction;

import up.erp.view.App;
import up.erp.view.dashboards.*;
import up.erp.view.exporter.ToolBar;



public abstract class BannerUI extends VerticalLayout{



    String urlNew;

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
    Label titulo = new Label("GESTION DE BANNER");
    
    public final HorizontalLayout head = new HorizontalLayout(titulo);
    //-----------------------------------------------------------------------------------------------
    // WORKSPACE
    //-----------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------
    // BUSQUEDAS
    //-----------------------------------------------------------------------------------------------
    Label titulo_buscar = new Label("");
    public final HorizontalLayout lay_titulo_bus = new HorizontalLayout(titulo_buscar);
    //-----------------------------------------------------------------------------------------------
    public final TextField txtname = new TextField("Ingresar Nombre");
    public final Button btnFind_Activos = new Button("Buscar",VaadinIcon.SEARCH.create());
    public final HorizontalLayout layBtnFind = new HorizontalLayout();
    
    //-----------------------------------------------------------------------------------------------
    public final Button btnFind_NoActivos = new Button("Buscar No Clientes Activos",VaadinIcon.SEARCH.create());
    
    //-----------------------------------------------------------------------------------------------
    public final DatePicker FechIni_bus = new DatePicker("Fecha Inicio");
    public final Button btnFind_Fecha = new Button("Buscar",VaadinIcon.SEARCH.create());
    
    public final HorizontalLayout lay_FindFecha = new HorizontalLayout();
    //-----------------------------------------------------------------------------------------------
    
    //4) Layout
    public final HorizontalLayout primaryBar = new HorizontalLayout(layBtnFind);
    
    public final VerticalLayout lay_Busquedas =  new VerticalLayout(lay_titulo_bus,layBtnFind);
    //-----------------------------------------------------------------------------------------------
    //TABLE - INFORMATION
    //-----------------------------------------------------------------------------------------------
    public final Grid<PuntosUp> grid = new Grid<>();


    public final Grid<BannerOb> gridban = new Grid<>();
    public final Grid<Linea> gridPROG = new Grid<>();
    public final Grid<ProgramOB> gridProgramacion = new Grid<>();


    public final VerticalLayout layGrid = new VerticalLayout(gridban,gridProgramacion);
    
    public final Label lbInformation = new Label("*Nota: Seleccione el usuario antes de Editar");
    public final HorizontalLayout layInformation = new HorizontalLayout();

    
   

    public final Button btnDisminuir_pts = new Button("Disminuir Puntos", VaadinIcon.ARROW_DOWN.create());
    //-----------------------------------------------------------------------------------------------
    public final HorizontalLayout layButtonsGrid = new HorizontalLayout();
    //-----------------------------------------------------------------------------------------------
    //CATALOGO - PDF - SUBIR BANNER FISICO
    //-----------------------------------------------------------------------------------------------

       
    public final MemoryBuffer bufferCatalogo = new MemoryBuffer();
    public final Upload uploadCatalogo = new Upload(bufferCatalogo);
    //-----------------------------------------------------------------------------------------------
    //////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////
  
  
    public final Label lbTit_Catalogo = new Label("AGREGAR NUEVO BANNER");
    public final HorizontalLayout layTit_Catalogo = new HorizontalLayout(lbTit_Catalogo);

    
    public final Image imgNewBan = new Image();
    
    //--
    //-----------------------------------------------------------------------------------------------
    public final Label titulo_NewBan = new Label("ASIGNE UN NOMBRE Y FEHCA Y CARGUE EL NUEVO BANNER");
    public final TextField txtBanName = new TextField("Nombre / Comentario");
    public final TextField txtCatNUrlpdf = new TextField("Link/Enlace");
    public final DatePicker FechFin_bus = new DatePicker("Fecha Fin"); 
    public final Button btnCatUpload = new Button("Subir Banner");
    public final Checkbox checkCat_Activar = new Checkbox("Activar?");
    public final TextField txtUrlRedirec = new TextField("Redireccionar A: ");

    
           //-----------------------------------------------------------------------------------------------
   public final Button btnCatSave = new Button("Guardar Banner",VaadinIcon.HARDDRIVE_O.create());

   public final Button btnSalirNewBan = new Button("Salir",VaadinIcon.SIGN_OUT.create());

   public final HorizontalLayout NewBanBtn= new HorizontalLayout(btnCatSave,btnSalirNewBan);

    
    
    public final VerticalLayout layNewBanControladoresIZ = new VerticalLayout(titulo_NewBan,txtBanName,
    txtCatNUrlpdf,uploadCatalogo,checkCat_Activar,txtUrlRedirec,NewBanBtn);


    public final HorizontalLayout layImgNewBan = new HorizontalLayout(imgNewBan);  


    public final HorizontalLayout layBanContIman = new HorizontalLayout(layNewBanControladoresIZ,layImgNewBan);








///////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////




    public final Button btnVer_prod = new Button("Mostrar Banners", VaadinIcon.LIST_OL.create());
    public final Button btnBan_Add = new Button("Agregar Banner", VaadinIcon.PLUS_CIRCLE.create());
    public final Button btn_VerBan = new Button("Editar Banner", VaadinIcon.EDIT.create());
    public final Button btnAddProgramacion = new Button("Crear Programacion", VaadinIcon.PLUS_CIRCLE_O.create());

    public final Button btnVerProgramacion = new Button("Mostrar Programacion", VaadinIcon.LIST_OL.create());
    public final Button btnEditProgramacion = new Button("Editar Programacion", VaadinIcon.EDIT.create());
    public final Button btnDeleteProgramacion = new Button("Eliminar Programacion", VaadinIcon.BAN.create());


   

    public final HorizontalLayout layCatalogo_ver = new HorizontalLayout(btnVer_prod,btnBan_Add,btn_VerBan,btnAddProgramacion,btnEditProgramacion);
    public final HorizontalLayout layProgramacion = new HorizontalLayout(btnVerProgramacion,btnEditProgramacion,btnDeleteProgramacion);

    //-----------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------
    //FOOTER

    public final VerticalLayout layCatalogo_Total = new VerticalLayout(layCatalogo_ver);





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
    public final Label titulo_dialog = new Label("EDITAR BANNERS");
    public final HorizontalLayout layTitulo_dialog = new HorizontalLayout(titulo_dialog);


    public final Image imgBanner = new Image();
    public final HorizontalLayout laybanner = new HorizontalLayout(imgBanner);


    //-----------------------------------------------------------------------------------------------
    public final TextField txtdialog_UsuName = new TextField("Nombre Comentario");
    public final HorizontalLayout laydialog_UsuName = new HorizontalLayout(txtdialog_UsuName);
    //-----------------------------------------------------------------------------------------------
    public final TextField dialog_UsuEmail = new TextField("Url Banner");
    public final HorizontalLayout laydialog_UsuEmail = new HorizontalLayout(dialog_UsuEmail);

    
    public final TextField urlAdirec = new TextField("Re Direccion A: ");
    public final HorizontalLayout laydRedire = new HorizontalLayout(urlAdirec);

    public final Label linkAseguir = new Label("Clic Aqui Para ir la Direccion");
    public final HorizontalLayout laylinkAseguir = new HorizontalLayout(linkAseguir);


    









    //-----------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------
    public final TextField txtdialog_PuntosUp = new TextField("Estado Activo");
    public final ComboBox <String> cmbActivoBan = new ComboBox<>("Activo");

    public final Button btnDisminuirPtsUP = new Button("Disminuir Puntos UP");
    
    public final Button btnIncrementarPtsUP = new Button("Actualizar Banner");
    public final Button btnInEliminarBanner = new Button("Eliminar Banner");


    public final HorizontalLayout laydialog_PuntosUp = new HorizontalLayout(cmbActivoBan);

    public final HorizontalLayout laydialog_botones = new HorizontalLayout(btnIncrementarPtsUP,btnInEliminarBanner);

                                                                            
    //-----------------------------------------------------------------------------------------------
    public final Button btnCancel = new Button("Salir");
    public final HorizontalLayout laydialogBtns = new HorizontalLayout(btnCancel);
    //-----------------------------------------------------------------------------------------------
    
       
    //-----------------------------------------------------------------------------------------------
    //DIALOG CREAR PROGRAMACION
    //-----------------------------------------------------------------------------------------------
    public final Label titulo_programa = new Label("CREAR PROGRAMACION"); 
    public final HorizontalLayout layTituloPROG = new HorizontalLayout(titulo_programa);
    

    public final Image imgBannerPROG = new Image();
    public final HorizontalLayout layImgPROG = new HorizontalLayout(imgBannerPROG);

    public final Label titulo_controladores1 = new Label("SELECCIONE LA LINEA PARA ASIGNAR EL BANNER");
    public final Label titulo_controladores2= new Label("Y ASIGNE UNA FECHA DE INICIO Y FIN "); 


    
    public final DatePicker fehcaPROG_ini = new DatePicker("Fecha Inicio");
    public final DatePicker fechaPROG_fin = new DatePicker("Fecha Fin");
    
    public final HorizontalLayout layFechaPROG = new HorizontalLayout(fehcaPROG_ini,fechaPROG_fin);

    public final ComboBox<String> combo_lineas_prod = new ComboBox("Linea E-commerce");
    public final TextField txtCombo = new TextField("Linea Ecommerce");


    
    public final Button btnGuardarPROG = new Button("Guardar Programacion",VaadinIcon.HARDDRIVE_O.create());
    public final Button btnSalirPROG = new Button("Salir");

    public final HorizontalLayout layButonsPROG = new HorizontalLayout(btnGuardarPROG,btnSalirPROG);





    
    public final VerticalLayout lay_iz_Controles = new VerticalLayout(titulo_controladores1,titulo_controladores2,combo_lineas_prod,txtCombo,layFechaPROG,layButonsPROG);

    public final HorizontalLayout lay_img_fech = new HorizontalLayout(lay_iz_Controles,layImgPROG);






    


    //-----------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------

    //------------------------------EDITAR PROGRAMACION--------------------------------------------

    public final Label titulo_EditPrograma = new Label("EDITAR PROGRAMACION"); 
    public final HorizontalLayout layEditTituloPROG = new HorizontalLayout(titulo_EditPrograma);



    public final Image imgEditProg = new Image();

    public final TextField txtEditProg_linea = new TextField("Linea Ecommerce");
    public final TextField txtEditProg_activo = new TextField("Estado Activo");

    public final ComboBox <String> cmbActivo = new ComboBox<>("Activo");

    
    public final TextField txtEditProg_fechI = new TextField("Fecha Inicio");
    public final TextField txtEditProg_fechF = new TextField("Fecha Fin");
    public final Button btnEditFechaProg = new Button("Editar Fechas");

    public final Label lbInform = new Label("*Nota: Asigne Ambas Fechas para Efectuar Cambios");


    public final HorizontalLayout laytimeEditProg = new HorizontalLayout(txtEditProg_fechI,txtEditProg_fechF);

    public final DatePicker EditProgFechaI = new DatePicker("Fecha Inicio");
    public final DatePicker EditProgFechaF = new DatePicker("Fecha Fin");

    public final HorizontalLayout layEditProgNewFecha = new HorizontalLayout(EditProgFechaI,EditProgFechaF);
    



    public final Button btnGuardarEditPROG = new Button("Actualizar",VaadinIcon.HARDDRIVE_O.create());
    public final Button btnSalirEditPROG = new Button("Salir");

    public final HorizontalLayout layBtnsEditProg = new HorizontalLayout(btnGuardarEditPROG,btnSalirEditPROG);



    public final VerticalLayout LayEditProgIZ = new VerticalLayout(txtEditProg_linea,cmbActivo,laytimeEditProg
    ,btnEditFechaProg,lbInform,layEditProgNewFecha,layBtnsEditProg);

    public final HorizontalLayout layImgEditProg = new HorizontalLayout(imgEditProg);

    public final HorizontalLayout layEditProgTotal= new HorizontalLayout(LayEditProgIZ,layImgEditProg);




    //CREATE DIALOG CREAR PROGRAMACION
    //-----------------------------------------------------------------------------------------------
    
      
        


    public final VerticalLayout layCrearBanner = new VerticalLayout(layTit_Catalogo,layBanContIman);
    public final Dialog dialogAddBan = new Dialog(layCrearBanner);
    


    public final VerticalLayout layCrearPorgramacion = new VerticalLayout(layTituloPROG,lay_img_fech);
    public final Dialog dialogPROG = new Dialog(layCrearPorgramacion);


    public final VerticalLayout layEditarProg = new VerticalLayout(layEditTituloPROG,layEditProgTotal);
    public final Dialog dialogEditProg = new Dialog(layEditarProg);
    //-----------------------------------------------------------------------------------------------
  


                     
    
    //CREATE DIALOG PUNTOS-UP
    //-----------------------------------------------------------------------------------------------
    public final VerticalLayout laydialogClient = new VerticalLayout(layTitulo_dialog,laybanner,laydialog_UsuName,laydialog_UsuEmail,laydRedire,laylinkAseguir,
                                                                     laydialog_PuntosUp,laydialog_botones,laydialogBtns);
    public final Dialog dialogClient = new Dialog(laydialogClient);
    //-----------------------------------------------------------------------------------------------
    //NOTIFICATION PUNTOS-UP
    //-----------------------------------------------------------------------------------------------
    public final Label Client_notf_correct = new Label("BANNER ACTUALIZADO CORRECTAMENTE");
    public final Notification Client_notify_correct = new Notification(Client_notf_correct);

    public final Label lbl_Notf_ProgActualizado = new Label("PROGRAMACION ACTUALIZADA CORRECTAMENTE");
    public final Notification Notf_ProgActualizado = new Notification(lbl_Notf_ProgActualizado);

    public final Label Client_notf_eliminado = new Label("BANNER ELIMINADO CORRECTAMENTE");
    public final Notification Client_notfy_eliminado = new Notification(Client_notf_eliminado);


    public final Label lbl_Notf_ProgEliminada = new Label("PROGRAMACION ELIMINADA CORRECTAMENTE");
    public final Notification Notf_ProgEliminada = new Notification(lbl_Notf_ProgEliminada);


    
    public final Label notf_select_exceed = new Label("Más de un Cliente ha sido seleccionado. Por favor, seleccione sólo uno");
    public final Notification notify_select_exceed = new Notification(notf_select_exceed);


    public final Label lblmsgErrorSelect = new Label("Seleccione un Elemento Antes de Editar");
    public final Notification msgErrorSelect = new Notification(lblmsgErrorSelect);


    public final Label Client_notf_BanGuardado = new Label("BANNER GUARDADO CORRECTAMENTE");
    public final Notification Client_notfy_BanGuardado = new Notification(Client_notf_BanGuardado);

    //-----------------------------------------------------------------------------------------------
    // DIALOG ALERTA CREAR PROGRAMACION
    //-----------------------------------------------------------------------------------------------
    
    public final Label Client_notf_NewProg = new Label("Programacion creada Exitosamente");
    public final Notification Client_notfy_NewProg = new Notification(Client_notf_NewProg);
    
    
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
    //END DIALOG PUNTOS-UP - AUMENTAR
    //-----------------------------------------------------------------------------------------------
    
    
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
    public BannerUI() {
        
        removeAll();
        add(layCPanelButtons,layCPanelButtons2, head, lay_Busquedas, layButtonsGrid, layCatalogo_Total,layProgramacion,layGrid, layInformation,fButtons);
        btnFind_Activos.addClickListener(e->On_find_Activos());
        btnFind_NoActivos.addClickListener(e->On_find_NoActivos());
        btnFind_Fecha.addClickListener(e->On_find_Fechas());
        initStyles();
        initEvents();
        gridProgramacion.setVisible(false);
        
        btn_VerBan.setEnabled(false);
        btnAddProgramacion.setEnabled(false);
        btnEditProgramacion.setEnabled(false);
        btnDeleteProgramacion.setEnabled(false); 
        
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
        head.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        head.setWidthFull();
        
        //ESTILOS DE LOS LAYOUTS !!!!! 
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
        
        lay_Busquedas.getStyle().set("border", "0px solid #9E9E9E");
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

        gridban.addColumn(BannerOb::getId).setAutoWidth(true).setSortable(true).setHeader("id");
        gridban.addColumn(BannerOb::getnombreComent).setAutoWidth(true).setSortable(true).setHeader("Nombre");
        gridban.addColumn(BannerOb::getUrl_banner).setAutoWidth(true).setSortable(true).setHeader("url");
        gridban.addColumn(BannerOb::getActivo).setAutoWidth(true).setSortable(true).setHeader("Activo");
        gridban.addColumn(BannerOb::geturl_reDirec).setAutoWidth(true).setSortable(true).setHeader("Url Redireccion");

        gridban.setSelectionMode(Grid.SelectionMode.MULTI);
        MultiSelect<Grid<BannerOb>, BannerOb> multiSelect=gridban.asMultiSelect();
        
        gridProgramacion.addColumn(ProgramOB::getnom_linea).setAutoWidth(true).setSortable(true).setHeader("Linea Ecommerce");
        gridProgramacion.addColumn(ProgramOB::getactivo).setAutoWidth(true).setSortable(true).setHeader("Activo");
        gridProgramacion.addColumn(ProgramOB::getfecha_ini).setAutoWidth(true).setSortable(true).setHeader("Inicio");
        gridProgramacion.addColumn(ProgramOB::getfecha_fin).setAutoWidth(true).setSortable(true).setHeader("fin");
        
        



        gridProgramacion.setSelectionMode(Grid.SelectionMode.MULTI);


        



                
        
        grid.addColumn(PuntosUp::getNombre_Usuweb).setAutoWidth(true).setSortable(true).setHeader("Nombre");
        grid.addColumn(PuntosUp::getActivo).setAutoWidth(true).setSortable(true).setHeader("Activo");
        grid.addColumn(PuntosUp::getPts_restantes).setAutoWidth(true).setSortable(true).setHeader("PuntosUP Restantes");
        


        
        //-----------------------------------------------------------------------------------------------
        btnVer_prod.getStyle().set("fontSize","90%");

        btnBan_Add.getStyle().set("fontSize","90%");

        btn_VerBan.getStyle().set("fontSize","90%");

        btnAddProgramacion.getStyle().set("fontSize","90%");
        btnAddProgramacion.addThemeVariants(ButtonVariant.LUMO_ERROR);

        btnVerProgramacion.getStyle().set("fontSize","90%");
        btnVerProgramacion.addThemeVariants(ButtonVariant.LUMO_ERROR);

        btnEditProgramacion.getStyle().set("fontSize","90%");
        btnEditProgramacion.addThemeVariants(ButtonVariant.LUMO_ERROR);

        btnDeleteProgramacion.getStyle().set("fontSize","90%");
        btnDeleteProgramacion.addThemeVariants(ButtonVariant.LUMO_ERROR);

        cmbActivo.setWidth("70%");
        cmbActivoBan.setWidthFull();

                
        
        layButtonsGrid.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        layButtonsGrid.setAlignItems(FlexComponent.Alignment.BASELINE);
        layButtonsGrid.setWidthFull();
        //-----------------------------------------------------------------------------------------------
        //CATALOGO - PDF
        //-----------------------------------------------------------------------------------------------
        uploadCatalogo.setAutoUpload(true);
        uploadCatalogo.setDropAllowed(false);
        uploadCatalogo.setUploadButton(btnCatUpload);
        //-----------------------------------------------------------------------------------------------
        lbTit_Catalogo.getStyle().set("fontWeight","bold");
        lbTit_Catalogo.getStyle().set("fontSize","120%"); 
                
     
        //-----------------------------------------------------------------------------------------------
       
        
       

        //checkCat_Activate.setWidthFull(); 
       
      
        //-----------------------------------------------------------------------------------------------
        txtCatNUrlpdf.setWidth("88%");
        txtBanName.setWidth("88%");
        txtUrlRedirec.setWidth("88%");

       
        
        btnCatUpload.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        btnCatUpload.getStyle().set("fontSize","120%");
        
        checkCat_Activar.getStyle().set("fontSize","80%");

      
        //-----------------------------------------------------------------------------------------------
        
        

     

        layButonsPROG.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        layButonsPROG.setAlignItems(FlexComponent.Alignment.START);
        layButonsPROG.setWidthFull(); 

        

        layCatalogo_ver.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        layCatalogo_ver.setAlignItems(FlexComponent.Alignment.START);
        layCatalogo_ver.setWidthFull();

        layProgramacion.getStyle().set("border", "1px solid #9E9E9E");
        layProgramacion.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        layProgramacion.setAlignItems(FlexComponent.Alignment.START);
        layProgramacion.setWidthFull();



        //-----------------------------------------------------------------------------------------------
        layCatalogo_Total.getStyle().set("border", "1px solid #9E9E9E");
        layCatalogo_Total.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layCatalogo_Total.setAlignItems(FlexComponent.Alignment.CENTER);
        layCatalogo_Total.setWidthFull(); 

       
             
        

        
       




        


        

      
        

        

        
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

        titulo_programa.getStyle().set("fontWeight","bold");
        titulo_programa.getStyle().set("fontSize","150%");

        titulo_EditPrograma.getStyle().set("fontWeight","bold");
        titulo_EditPrograma.getStyle().set("fontSize","150%");

        

        titulo_controladores2.getStyle().set("fontWeight","bold");
        titulo_controladores2.getStyle().set("fontSize","110%");

        titulo_controladores1.getStyle().set("fontWeight","bold");
        titulo_controladores1.getStyle().set("fontSize","110%");

        titulo_NewBan.getStyle().set("fontWeight","bold");
        titulo_NewBan.getStyle().set("fontSize","110%");
        titulo_NewBan.setHeight("25%");
        
        titulo_NewBan.setWidthFull();



        

        



        

        combo_lineas_prod.setWidth("100%");
        txtCombo.setWidth("50%");


        combo_lineas_prod.setPlaceholder("Elija Linea Ecommerce");
        combo_lineas_prod.setWidthFull();

        combo_lineas_prod.addValueChangeListener(event->{
            if(!event.getValue().contentEquals("No definida")){
                txtCombo.setValue(event.getValue());
            }
            else
            txtCombo.setValue("No definida");
        });
        
        layTitulo_dialog.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layTitulo_dialog.setAlignItems(FlexComponent.Alignment.CENTER);
        layTitulo_dialog.setWidthFull(); 

        titulo_controladores2.setHeight("25%");
        

        layTituloPROG.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layTituloPROG.setAlignItems(FlexComponent.Alignment.CENTER);
        layTituloPROG.setWidthFull(); 

        layEditTituloPROG.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layEditTituloPROG.setAlignItems(FlexComponent.Alignment.CENTER);
        layEditTituloPROG.setWidthFull(); 


        txtEditProg_linea.setWidth("80%");
        txtEditProg_activo.setWidth("80%");

        txtEditProg_fechI.setWidth("30%");
        txtEditProg_fechF.setWidth("30%");

        txtEditProg_linea.setReadOnly(true);
        txtEditProg_fechI.setReadOnly(true);
        txtEditProg_fechF.setReadOnly(true);



        
        layBtnsEditProg.setJustifyContentMode(FlexComponent.JustifyContentMode.END);


        

        

        layTit_Catalogo.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layTit_Catalogo.setAlignItems(FlexComponent.Alignment.CENTER);
        layTit_Catalogo.setWidthFull();
        //-----------------------------------------------------------------------------------------------
        txtdialog_UsuName.setWidthFull();
        txtdialog_UsuName.setReadOnly(true);



        imgBanner.setVisible(true);
        imgBanner.setEnabled(true);
        imgBanner.setHeight("200px");
        imgBanner.setWidth("350px");

        imgBannerPROG.setVisible(true);
        imgBannerPROG.setEnabled(true);
        imgBannerPROG.setHeight("300px");
        imgBannerPROG.setWidth("525px");

        imgEditProg.setVisible(true);
        imgEditProg.setEnabled(true);
        imgEditProg.setHeight("270PX");
        imgEditProg.setWidth("473px");


        

        imgNewBan.setVisible(true);
        imgNewBan.setEnabled(true);
        imgNewBan.setHeight("300px");
        imgNewBan.setWidth("525px");

        
      

        
        laydialog_UsuName.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laydialog_UsuName.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialog_UsuName.setWidthFull();
        //-----------------------------------------------------------------------------------------------
        dialog_UsuEmail.setErrorMessage("Por favor ingrese un Email válido");
        dialog_UsuEmail.setWidthFull();
        dialog_UsuEmail.setReadOnly(false);
        dialog_UsuEmail.setWidth("800%");


        urlAdirec.setErrorMessage("Por favor ingrese un Email válido");
        urlAdirec.setWidthFull();
        urlAdirec.setReadOnly(false);
        urlAdirec.setWidth("800%");
             
        laydialog_UsuEmail.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laydialog_UsuEmail.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialog_UsuEmail.setWidthFull();

        laydRedire.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laydRedire.setAlignItems(FlexComponent.Alignment.CENTER);
        laydRedire.setWidthFull();


        lbInform.getStyle().set("color", "red");
        lbInform.getStyle().set("fontStyle","italic");
        lbInform.getStyle().set("fontSize","100%");



        
        //-----------------------------------------------------------------------------------------------
        
        
    
        //-----------------------------------------------------------------------------------------------
        txtdialog_PuntosUp.setWidthFull();
        txtdialog_PuntosUp.setReadOnly(true);
        
        btnDisminuirPtsUP.addThemeVariants(ButtonVariant.LUMO_ERROR);
        btnDisminuirPtsUP.getStyle().set("fontSize","90%");
        btnDisminuirPtsUP.setWidthFull();
        
        
        btnIncrementarPtsUP.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        btnIncrementarPtsUP.getStyle().set("fontSize","90%");
        btnIncrementarPtsUP.setWidthFull();

        btnInEliminarBanner.addThemeVariants(ButtonVariant.LUMO_ERROR);
        btnInEliminarBanner.getStyle().set("fontSize","90%");
        btnInEliminarBanner.setWidthFull();
        

        

        
        laydialog_PuntosUp.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laydialog_PuntosUp.setAlignItems(FlexComponent.Alignment.BASELINE);
        laydialog_PuntosUp.setWidthFull();

        laydialog_botones.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laydialog_botones.setAlignItems(FlexComponent.Alignment.BASELINE);
        laydialog_botones.setWidthFull();
        
        layBtnsEditProg.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        layBtnsEditProg.setAlignItems(FlexComponent.Alignment.BASELINE);
        layBtnsEditProg.setWidthFull();



        //-----------------------------------------------------------------------------------------------
        
        btnCancel.addThemeVariants(ButtonVariant.LUMO_ERROR);
        btnCancel.getStyle().set("fontSize","90%"); 
        

        btnCatSave.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        btnCatSave.getStyle().set("fontSize","120%");

        btnSalirNewBan.addThemeVariants(ButtonVariant.LUMO_ERROR);
        btnSalirNewBan.getStyle().set("fontSize","120%");

        btnGuardarPROG.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        btnGuardarPROG.getStyle().set("fontSize","120%");

        btnSalirPROG.addThemeVariants(ButtonVariant.LUMO_ERROR);
        btnSalirPROG.getStyle().set("fontSize","120%");


       

        btnGuardarEditPROG.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        btnGuardarEditPROG.getStyle().set("fontSize","90%");
        btnGuardarEditPROG.setWidthFull();

        btnSalirEditPROG.addThemeVariants(ButtonVariant.LUMO_ERROR);
        btnSalirEditPROG.getStyle().set("fontSize","90%");
        btnSalirEditPROG.setWidthFull();






        laydialogBtns.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laydialogBtns.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialogBtns.setWidthFull();
        //-----------------------------------------------------------------------------------------------
        //-----------------------------------------------------------------------------------------------
        dialogClient.setCloseOnEsc(true);
        dialogClient.setCloseOnOutsideClick(true);



        dialogEditProg.setHeight("70%");
        dialogEditProg.setWidth("70%");

        dialogEditProg.setCloseOnEsc(false);
        dialogEditProg.setCloseOnOutsideClick(false);





        //-----------------------------------------------------------------------------------------------
        //NOTIFICATION
        //-----------------------------------------------------------------------------------------------
        notf_select_exceed.getStyle().set("fontSize","90%");
        notf_select_exceed.getStyle().set("color", "red");


        Client_notf_BanGuardado.getStyle().set("fontSize", "120%");
        Client_notf_BanGuardado.getStyle().set("color", "#88ee4e");
        Client_notf_BanGuardado.getStyle().set("fontWeight", "bold");
        
        Client_notf_NewProg.getStyle().set("fontSize", "120%");
        Client_notf_NewProg.getStyle().set("color", "#88ee4e");
        Client_notf_NewProg.getStyle().set("fontWeight", "bold");

        Client_notf_eliminado.getStyle().set("fontSize", "120%");
        Client_notf_eliminado.getStyle().set("color", "#e72813");
        Client_notf_eliminado.getStyle().set("fontWeight", "bold");

        lbl_Notf_ProgEliminada.getStyle().set("fontSize", "100%");
        lbl_Notf_ProgEliminada.getStyle().set("color", "#e72813");
        lbl_Notf_ProgEliminada.getStyle().set("fontWeight", "bold");





        Client_notf_correct.getStyle().set("fontSize", "100%");
        Client_notf_correct.getStyle().set("color", "green");
        Client_notf_correct.getStyle().set("fontWeight", "bold");

        lbl_Notf_ProgActualizado.getStyle().set("fontSize", "90%");
        lbl_Notf_ProgActualizado.getStyle().set("color", "green");
        lbl_Notf_ProgActualizado.getStyle().set("fontWeight", "bold");


        
        Client_notify_correct.setDuration(3000);
        Client_notify_correct.setPosition(Notification.Position.MIDDLE);

        Notf_ProgActualizado.setDuration(3000);
        Notf_ProgActualizado.setPosition(Notification.Position.MIDDLE);

        Client_notfy_BanGuardado.setDuration(3000);
        Client_notfy_BanGuardado.setPosition(Notification.Position.MIDDLE);

        Client_notfy_eliminado.setDuration(3000);
        Client_notfy_eliminado.setPosition(Notification.Position.MIDDLE);

        Notf_ProgEliminada.setDuration(3000);
        Notf_ProgEliminada.setPosition(Notification.Position.MIDDLE);
        
        Client_notfy_NewProg.setDuration(3000);
        Client_notfy_NewProg.setPosition(Notification.Position.MIDDLE);
        
        notify_select_exceed.setDuration(2500);
        notify_select_exceed.setPosition(Notification.Position.MIDDLE); 


        msgErrorSelect.setDuration(2500);
        msgErrorSelect.setPosition(Notification.Position.MIDDLE);
        lblmsgErrorSelect.getStyle().set("fontSize", "115%");
        lblmsgErrorSelect.getStyle().set("color", "red");


        linkAseguir.getStyle().set("color","red");
        linkAseguir.getStyle().set("Weight","underline");


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
    public abstract void on_ViewBanners();
    public abstract void on_ViewProgramacion();
    public abstract void on_Open_Clientdialog();
    public abstract void on_Open_EditProgramacion(); 
    public abstract void on_CrearProgramacion();
    public abstract void on_ActualizarBanner();
    public abstract void on_ActualizarProgram();


    public abstract void on_Eliminar_Banner();
    public abstract void on_Disminuir_PuntosUP();

    //-----------------------------------------------------------------------------------------------
    public abstract void on_Open_Incrementdialog();
    public abstract void on_UpdateInc_PuntosUP();
    public abstract void on_Open_CreacionProgramaUSELINEAS();
    //-----------------------------------------------------------------------------------------------
    public abstract void on_Open_Disminuirdialog();
    public abstract void on_UpdateDis_PuntosUP();
    //-----------------------------------------------------------------------------------------------
    
    //-----------------------------------------------------------------------------------------------
    //CATALOGO
    //-----------------------------------------------------------------------------------------------
    public abstract void init_Catalogos();
    public abstract void on_UploadNewCatalogo(SucceededEvent event);

    public abstract void on_Upload_Banner(SucceededEvent event);

    public abstract void on_SaveChangesCatalogo();
    public abstract void on_SaveNewBANNER();
    public abstract void on_SaveNewPROG();
    public abstract void on_BeforeCatalogo();
    public abstract void on_AfterCatalogo();
    public abstract void On_Delete_Banner();
    public abstract void on_Eliminar_Programacion();
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
     
     ////////////////////////////////////////////////////////////
        //-----------------------------------------------------------------------------------------------
        btnVer_prod.addClickListener(e->{ 
            gridProgramacion.setVisible(false);
            gridban.setVisible(true);
            
            on_ViewBanners();
            btnEditProgramacion.setEnabled(false);
            btnBan_Add.setEnabled(true);
            btn_VerBan.setEnabled(true);
            btnAddProgramacion.setEnabled(true); 
            btnDeleteProgramacion.setEnabled(false);

        });


        btnVerProgramacion.addClickListener(e-> {

            gridban.setVisible(false);
            gridProgramacion.setVisible(true);
            
            on_ViewProgramacion();
            btnEditProgramacion.setEnabled(true);
            btnBan_Add.setEnabled(false);
            btn_VerBan.setEnabled(false);
            btnAddProgramacion.setEnabled(false);
            btnDeleteProgramacion.setEnabled(true);
            

        });




       btnBan_Add.addClickListener(e-> {
           
        dialogAddBan.open();
        on_SaveChangesCatalogo();
             

       });


       btnEditProgramacion.addClickListener(e-> {           

              
        on_Open_EditProgramacion();
        

       });

       btnDeleteProgramacion.addClickListener(e-> {

        on_Eliminar_Programacion();
        on_ViewProgramacion();

       });

       btnEditFechaProg.addClickListener(e-> {
        EditProgFechaI.setVisible(true);
        EditProgFechaF.setVisible(true);
        lbInform.setVisible(true);        


        txtEditProg_fechI.setEnabled(false);
        txtEditProg_fechF.setEnabled(false);
        btnEditFechaProg.setEnabled(false); 
               
       });

       
        


//////////////////////////////////////////////////////////
        /////////////////////////////////////////////////
        btnIncrementarPtsUP.addClickListener(e->{ 
            on_ActualizarBanner();
            on_ViewBanners();

            
            dialogClient.close();

        });

        btnInEliminarBanner.addClickListener(e->{ 
            on_Eliminar_Banner();
            on_ViewBanners();
            dialogClient.close();
            
        });

        btnCancel.addClickListener(e->{ 
            dialogClient.close();
            btnIncrementarPtsUP.setEnabled(true);
            btnInEliminarBanner.setEnabled(true);

            
        });

        btnGuardarEditPROG.addClickListener(e-> {

            on_ActualizarProgram();
            on_ViewProgramacion();
            dialogEditProg.close();

        });

        

        btnSalirPROG.addClickListener(e->{ 
            dialogPROG.close();
        });

        


        //-----------------------------------------------------------------------------------------------
        btn_VerBan.addClickListener(e->{ 
            on_Open_Clientdialog();
            dialogClient.setCloseOnOutsideClick(false);
            dialogClient.setCloseOnEsc(false);
        });

        btnAddProgramacion.addClickListener(e-> {

            on_CrearProgramacion();
            on_Open_CreacionProgramaUSELINEAS();          


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
        uploadCatalogo.addSucceededListener(this::on_Upload_Banner);

        btnGuardarPROG.addClickListener(e->{
            on_SaveNewPROG();
            on_ViewBanners();
            dialogPROG.close();
        });

        
        btnCatSave.addClickListener(e->{ 
            on_SaveNewBANNER();
            on_ViewBanners();
            dialogAddBan.close(); 

        });



        laylinkAseguir.addClickListener(e-> {
            
            UI.getCurrent().getPage().executeJavaScript("window.open('"+ urlAdirec.getValue() +"');");
           
        });





        btnSalirNewBan.addClickListener(e->{ 

           dialogAddBan.close();
        });

        btnSalirEditPROG.addClickListener(e->{
            
            txtEditProg_fechI.setEnabled(true);
            txtEditProg_fechF.setEnabled(true);
            btnEditFechaProg.setEnabled(true); 
            dialogEditProg.close();

        });

       
        
        
       
        //-----------------------------------------------------------------------------------------------
    }



    }













    

