/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.view.ecom;

import com.upgrade.persistence.model.extcs.Producto;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.contextmenu.SubMenu;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.Grid.SelectionMode;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.NativeButton;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.orderedlayout.BoxSizing;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.upload.SucceededEvent;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
import com.vaadin.flow.component.upload.receivers.MultiFileMemoryBuffer;
import com.vaadin.flow.data.renderer.NativeButtonRenderer;
import com.vaadin.flow.data.renderer.TemplateRenderer;
import com.vaadin.flow.data.selection.MultiSelect;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
//import javafx.scene.text.Text;
import up.erp.view.App;

/**
 *
 * @author Luis Aleman
 */
public abstract class Productos2UI extends VerticalLayout{
    
    //CPANEL CABECERA
    public final Button btnClientes = new Button("Gestión Clientes", VaadinIcon.MALE.create());
    public final Button btnPedidos = new Button("Gestión Pedidos", VaadinIcon.CART_O.create());
    public final Button btnLineas = new Button("Gestión Lineas Ecommerce", VaadinIcon.RECORDS.create());
    public final Button btnEcomPage = new Button("Gestión Página Ecommerce", VaadinIcon.GLOBE_WIRE.create());
    public final Button btnCupones = new Button("Gestión Cupones", VaadinIcon.TICKET.create());
    public final Button btnSalirCP = new Button("Salir del Panel de Control");
    
    public final HorizontalLayout layCPanelButtons = new HorizontalLayout(btnClientes,btnPedidos,btnLineas,btnEcomPage,btnCupones,btnSalirCP);
    //-----------------------------------------------------------------------------------------------
    //END CPANEL CABECERA
    //-----------------------------------------------------------------------------------------------
    
    
    //-----------------------------------------------------------------------------------------------
    //INIT MAIN VIEW
    //-----------------------------------------------------------------------------------------------
    // HEADER
    //-----------------------------------------------------------------------------------------------
    Label titulo = new Label("PRODUCTOS");
    
    public final HorizontalLayout head = new HorizontalLayout(titulo);
    //-----------------------------------------------------------------------------------------------
    //BUSQUEDAS
    //-----------------------------------------------------------------------------------------------
    Label titulo_buscar = new Label("BUSQUEDA DE PRODUCTOS");
    public final HorizontalLayout lay_titulo_bus = new HorizontalLayout(titulo_buscar);
    //-----------------------------------------------------------------------------------------------
    // Labels && TextFields
    public final Label lbname = new Label("Nombre: ");
    public final Label lbcodigo = new Label("Codigo: ");
    //-----------------------------------------------------------------------------------------------
    public final TextField txtname = new TextField("Ingresar Nombre");
    public final TextField txtcod = new TextField("Ingresar Codigo");
    public final ComboBox<String> cmbLineaBus = new ComboBox("Linea E-commerce");
    public final TextField txtLineaBus = new TextField("Linea E-commerce");
    //-----------------------------------------------------------------------------------------------
    // Botones
    public final Button bFind_cod = new Button("Buscar");
    public final Button bFind_name = new Button("Buscar (Productos Ecommerce)");
    public final Button bFind_name_noecom = new Button("Buscar (Productos No Ecommerce)");
    public final Button bFind_linea = new Button("Buscar");
    
    public final VerticalLayout layFindbtns = new VerticalLayout(bFind_name,bFind_name_noecom);
    //-----------------------------------------------------------------------------------------------
    // Layout
    public final HorizontalLayout layFCod = new HorizontalLayout(txtcod,bFind_cod);
    public final HorizontalLayout layFName = new HorizontalLayout(txtname,bFind_name,bFind_name_noecom);
    public final HorizontalLayout layFLine = new HorizontalLayout(cmbLineaBus,txtLineaBus,bFind_linea);
    public final HorizontalLayout primaryBar = new HorizontalLayout(layFCod);
    public final HorizontalLayout primaryBar2 = new HorizontalLayout(layFName);
    public final HorizontalLayout primaryBar3 = new HorizontalLayout(layFLine);
    public final VerticalLayout lay_Busquedas =  new VerticalLayout(lay_titulo_bus,primaryBar,primaryBar2,primaryBar3);
    //-----------------------------------------------------------------------------------------------
    //TABLE - INFORMATION
    //-----------------------------------------------------------------------------------------------
    //public final Grid<Producto> grid = new Grid<>(Producto.class);
    public final Grid<Producto> grid = new Grid<>();
    //LAYOUT GRID
    public final VerticalLayout layGrid = new VerticalLayout(grid);
    
    //NativeButtonRenderer nat_bt = new NativeButtonRenderer<>("Editar");
    
    public final Label lbInformation = new Label("*Nota: Seleccione el producto antes de Editar");
    public final HorizontalLayout layInformation = new HorizontalLayout(lbInformation);
    
    public final Button btnver_prod = new Button("Ver/Editar");
    public final HorizontalLayout layBttnVer_Prod = new HorizontalLayout(btnver_prod);
    //--------------------------------------------------------------------------------------------
    //Iconos
    //descartado
    public final Icon addfile = VaadinIcon.FILE_ADD.create();
    public final Icon edit_ecom = VaadinIcon.EXTERNAL_LINK.create();
    public final Button btnaddfile = new Button("Agregar nuevo Producto",addfile);
    public final Button btnedit_ecom = new Button(edit_ecom);
    
    //Barra de tareas Final
    public final Icon exit = VaadinIcon.EXIT.create();
    public final Icon save = VaadinIcon.CLIPBOARD_CROSS.create();
    public final Icon delete = VaadinIcon.CLOSE_CIRCLE_O.create();
    public final Icon promo = VaadinIcon.GIFT.create();
    public final Icon limite_comp = VaadinIcon.STORAGE.create();

    public final Button btnpromo = new Button("Agregar Promocion",promo);
    public final Button btnlimite_compra = new Button("Agregar Limite de Compra",limite_comp);
    public final Button btnsave = new Button("Agregar a Ecommerce",save);
    public final Button btndelete = new Button("Quitar de Ecommerce",delete);
    public final Button btnExit = new Button("Salir",exit);
    

    //public final HorizontalLayout fButtons = new HorizontalLayout(btnpromo,btnlimite_compra,btnsave,btndelete,btnExit);
    public final HorizontalLayout fButtons = new HorizontalLayout(btnlimite_compra,btnsave,btndelete,btnExit);
    //--------------------------------------------------------------------------------------------
    //END MAIN VIEW
    //--------------------------------------------------------------------------------------------
    
    
    
    
    //--------------------------------------------------------------------------------------------
    //DIALOG - PANEL EDICION E-COMMERCE
    //--------------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------------
    //Titulo
 
    public final Label titulo_dialog = new Label("EDIT PRODUCTO ECOMMERCE");
    //--------------------------------------------------------------------------------------------
    public final HorizontalLayout layTitulo_dialog = new HorizontalLayout(titulo_dialog);
    //--------------------------------------------------------------------------------------------
    //Aviso
    
    public final Label lbInfo_dialog = new Label("Importante: Marcar si el producto será Ecommerce");
    //--------------------------------------------------------------------------------------------
    public final HorizontalLayout layInfo_dialog = new HorizontalLayout(lbInfo_dialog);
    //--------------------------------------------------------------------------------------------
    //Check is Ecommerce
    
    public final Label lbEcomdialog = new Label("Es Ecommerce?");
    public final Checkbox checkEcom = new Checkbox();
    public final HorizontalLayout dialogform1 = new HorizontalLayout(lbEcomdialog,checkEcom);
    //--------------------------------------------------------------------------------------------
    public final Button btnClean_dialog = new Button("Limpiar Formulario");
    //--------------------------------------------------------------------------------------------
    public final HorizontalLayout dialogform1_clean = new HorizontalLayout(btnClean_dialog);
    //--------------------------------------------------------------------------------------------
    public final HorizontalLayout dialogform1_final = new HorizontalLayout(dialogform1,dialogform1_clean);
    //--------------------------------------------------------------------------------------------
    //Nombre Ecommerce | Linea Ecommerce | Precio Ecommerce | Stock Máximo por Usuario
    
    public final TextField txtNameEcom = new TextField("Nombre Ecommerce");
    public final HorizontalLayout dialogform2 = new HorizontalLayout(txtNameEcom);
    public final TextField txtLineaEcom = new TextField("Linea Ecommerce");
    public final ComboBox<String> cmbLineaEcom = new ComboBox("Linea Ecommerce");
    public final TextField txtPrecioEcom = new TextField("Precio Ecommerce");
    public final TextField txtLimiteEcom = new TextField("Stock Máximo por Usuario");
    public final TextField txtStockAct = new TextField("Stock Actual");
    //--------------------------------------------------------------------------------------------
    public final HorizontalLayout dialogform4 = new HorizontalLayout(txtNameEcom,txtPrecioEcom,txtLimiteEcom,txtStockAct);
    //--------------------------------------------------------------------------------------------
    //Descripción E-commerce
    
    public final TextArea txtaDesc_ecom = new TextArea("Descripción E-commerce");
    //--------------------------------------------------------------------------------------------
    public final HorizontalLayout dialogform5 = new HorizontalLayout(txtaDesc_ecom);
    //--------------------------------------------------------------------------------------------
    
    //IMAGEN - SECCION
    //--------------------------------------------------------------------------------------------
    //UPLOAD
    //--------------------------------------------------------------------------------------------
    public final MemoryBuffer buffer1 = new MemoryBuffer();
    public final Upload upload1 = new Upload(buffer1);
    //--------------------------------------------------------------------------------------------
    //IMAGEN - Titulo
    //--------------------------------------------------------------------------------------------
    public final Label lbdialog_TitImg = new Label("BANCO DE IMAGENES DEL PRODUCTO");
    public final HorizontalLayout laydialog_TitImg  = new HorizontalLayout(lbdialog_TitImg);
    //--------------------------------------------------------------------------------------------    
    //IMAGEN - Cuerpo
    //--------------------------------------------------------------------------------------------
    public final Image img1 = new Image(); 
    public final Button btndialog_BuscarAnterior = new Button("Anterior");
    public final Button btndialog_BuscarSiguiente = new Button("Siguiente");
    public final TextField txtUpload1 = new TextField("");
    public final Button btnUpload1 = new Button("Actualizar");
    public final Button btnUpload1Borrar = new Button("Descartar");
    //--------------------------------------------------------------------------------------------
    public final HorizontalLayout lay2dialogimg1 = new HorizontalLayout(btndialog_BuscarAnterior,img1,btndialog_BuscarSiguiente);
    public final HorizontalLayout laydialogUp1 = new HorizontalLayout(upload1,btnUpload1Borrar);
    public final VerticalLayout laydialogimg1 = new VerticalLayout(laydialog_TitImg,lay2dialogimg1,laydialogUp1);
    //--------------------------------------------------------------------------------------------
    
    public final HorizontalLayout layImages = new HorizontalLayout(laydialogimg1);
    //--------------------------------------------------------------------------------------------
    //Botones de accion
    
    public final Icon update = VaadinIcon.CLOUD_DOWNLOAD.create();
    public final Button btngrabar_Ecom = new Button("Grabar Cambios");
    public final Icon cancel = VaadinIcon.CLOSE.create();
    public final Button btncancel_Ecom = new Button("Cancelar");
    public final HorizontalLayout dialogform6 = new HorizontalLayout(btngrabar_Ecom,btncancel_Ecom);
    //--------------------------------------------------------------------------------------------
    //Layout Final
    
    public final VerticalLayout dialogmainform = new VerticalLayout(layTitulo_dialog,dialogform1_final,layInfo_dialog,dialogform4,dialogform5,layImages,
                                                                    dialogform6);
    
    //--------------------------------------------------------------------------------------------
    //CREATE DIALOG
    public final Dialog dialogEcomm = new Dialog(dialogmainform);
    //--------------------------------------------------------------------------------------------
    //Notification
    public final Label upd_notf_correct = new Label("Producto Actualizado Correctamente");
    public final Label upd_notf_incorrect = new Label("No se Actualizó datos del producto");
    public final Label notf_select_exceed = new Label("Más de un Producto ha sido seleccionado. Por favor, seleccione sólo uno");
    
    public final Notification notify_correct = new Notification(upd_notf_correct);
    public final Notification notify_incorrect = new Notification(upd_notf_incorrect);  
    public final Notification notify_select_exceed = new Notification(notf_select_exceed);
    //--------------------------------------------------------------------------------------------
    //Notification Utilidad
    public final Label notf_utilidad_correcta = new Label("La Utilidad está dentro del rango adecuado");
    public final Label notf_utilidad_incorrecta = new Label("La Utilidad está por debajo del valor de 0.15");
    
    public final Notification notify_utilidad_correcta = new Notification(notf_utilidad_correcta);
    public final Notification notify_utilidad_incorrecta = new Notification(notf_utilidad_incorrecta);   
    //--------------------------------------------------------------------------------------------
    //END DIALOG - PANEL EDICION E-COMMERCE
    //--------------------------------------------------------------------------------------------
    
    
    
    //--------------------------------------------------------------------------------------------
    //DIALOG PROMOCION
    //--------------------------------------------------------------------------------------------
    public final Label titulo_dialog_promo = new Label("EDIT PRECIO E-COMMERCE");
    public final HorizontalLayout layTitulo_dialog_promo = new HorizontalLayout(titulo_dialog_promo);
    //--------------------------------------------------------------------------------------------
    public final Label lbPromo = new Label("Colocar valor de Precio Ecommerce:");
    public final TextField txtPromo = new TextField("Ingresar valor de Precio Ecommerce");
    public final HorizontalLayout dialogPromo1 = new HorizontalLayout(txtPromo);
    //--------------------------------------------------------------------------------------------
    public final Button btnPromo = new Button("Aplicar Precio Ecommerce");
    public final Button btnPromoCancel = new Button("Cancelar");
    public final HorizontalLayout dialogPromo2 = new HorizontalLayout(btnPromo,btnPromoCancel);
    //--------------------------------------------------------------------------------------------
    public final VerticalLayout laydialogPromo = new VerticalLayout(layTitulo_dialog_promo,dialogPromo1,dialogPromo2);
    public final Dialog dialogPromoFinal = new Dialog(laydialogPromo);
    //--------------------------------------------------------------------------------------------
    //Notification Promo
    //--------------------------------------------------------------------------------------------
    public final Label promo_notf_correct = new Label("Promocion Aplicada Correctamente");
    public final Notification promo_notify_correct = new Notification(promo_notf_correct);
    //--------------------------------------------------------------------------------------------
    //END DIALOG PROMOCION
    //--------------------------------------------------------------------------------------------
    
    
    
    //--------------------------------------------------------------------------------------------
    //DIALOG LIMITE COMPRA
    //--------------------------------------------------------------------------------------------
    public final Label titulo_dialog_lcompra = new Label("EDIT Stock MAXIMO POR USUARIO E-COMMERCE");
    public final HorizontalLayout layTitulo_dialog_lcompra = new HorizontalLayout(titulo_dialog_lcompra);
    //--------------------------------------------------------------------------------------------
    public final Label lbLimiteC = new Label("Colocar valor de Stock Máximo:");
    public final TextField txtLimiteC = new TextField("Stock Máximo por Usuario");
    public final HorizontalLayout dialogLimiteC1 = new HorizontalLayout(txtLimiteC);
    //--------------------------------------------------------------------------------------------
    public final Button btnLimiteC = new Button("Aplicar Stock Máximo por Usuario");
    public final Button btnLimiteCCancel = new Button("Cancelar");
    public final HorizontalLayout dialogLimiteC2 = new HorizontalLayout(btnLimiteC,btnLimiteCCancel);
    //--------------------------------------------------------------------------------------------
    public final VerticalLayout laydialogLimiteC = new VerticalLayout(layTitulo_dialog_lcompra,dialogLimiteC1,dialogLimiteC2);
    public final Dialog dialogLimiteCFinal = new Dialog(laydialogLimiteC);
    //--------------------------------------------------------------------------------------------
    //Notification Limite de Compra
    public final Label limiteC_notf_correct = new Label("Limite de Compra Aplicada Correctamente");
    public final Notification limiteC_notify_correct = new Notification(limiteC_notf_correct);
    //--------------------------------------------------------------------------------------------
    //END DIALOG LIMITE COMPRA
    //--------------------------------------------------------------------------------------------
    
    
    
    
    //--------------------------------------------------------------------------------------------
    public Productos2UI() {
   
        removeAll();
        add(layCPanelButtons, head, lay_Busquedas, layGrid, layInformation,layBttnVer_Prod, fButtons);
        bFind_name.addClickListener(e->On_find_Prodname());
        bFind_name_noecom.addClickListener(e->On_find_NoEcom());
        bFind_cod.addClickListener(e->On_find_Cod());
        btnsave.addClickListener(e->On_add_Prod());
        btndelete.addClickListener(e->On_delete_Prod());
        btngrabar_Ecom.addClickListener(e->on_Grabar_ecom());
        cmbLineaBus.addAttachListener(e->on_Click_ComboBusLinea());
        bFind_linea.addClickListener(e->On_find_LineaEcom());
        
        //addClassName("centered-content");
        
        initStyles();
        initEvents();
    }
    
    private void initStyles() {
        
        //CABECERA CPANEL
        btnClientes.setWidthFull();
        btnClientes.getStyle().set("fontSize","80%");
        //------------------------------------------------------------------------------------------------
        btnPedidos.setWidthFull();
        btnPedidos.getStyle().set("fontSize","80%");
        //------------------------------------------------------------------------------------------------
        btnEcomPage.setWidthFull();
        btnEcomPage.getStyle().set("fontSize","80%");
        //------------------------------------------------------------------------------------------------
        btnLineas.setWidthFull();
        btnLineas.getStyle().set("fontSize","80%");
        //------------------------------------------------------------------------------------------------
        btnCupones.setWidthFull();
        btnCupones.getStyle().set("fontSize","80%");
        //------------------------------------------------------------------------------------------------
        btnSalirCP.addThemeVariants(ButtonVariant.LUMO_ERROR);
        btnSalirCP.getStyle().set("fontSize","80%");
        btnSalirCP.setWidthFull();
        //------------------------------------------------------------------------------------------------
        layCPanelButtons.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        layCPanelButtons.setWidthFull();
        //-----------------------------------------------------------------------------------------------
        
        //HEADER
        titulo.getStyle().set("fontWeight","bold");
        titulo.getStyle().set("fontSize","300%");
        head.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        head.setWidthFull();
        
        //WORKPLACE
        titulo_buscar.getStyle().set("fontWeight","bold");
        titulo_buscar.getStyle().set("fontSize","150%");
        
        lay_titulo_bus.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        lay_titulo_bus.setWidthFull();
        
        //MAIN VIEW SETTINGS
        
        cmbLineaBus.addValueChangeListener(event->{
            if(!event.getValue().contentEquals("No definida")){
                txtLineaBus.setValue(event.getValue());
            }
            else
                txtLineaBus.setValue("No definida");
        });
        
        bFind_cod.getStyle().set("color", "green");
        bFind_cod.getStyle().set("fontSize","90%");
        bFind_name.getStyle().set("color", "green");
        bFind_name.getStyle().set("fontSize","90%");
        bFind_name_noecom.getStyle().set("color", "red");
        bFind_name_noecom.getStyle().set("fontSize","90%");
        
        layFCod.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        layFCod.setAlignItems(FlexComponent.Alignment.BASELINE);
        layFCod.setWidthFull();
        
        layFName.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        layFName.setAlignItems(FlexComponent.Alignment.BASELINE);
        layFName.setWidthFull();
        
        layFLine.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        layFLine.setAlignItems(FlexComponent.Alignment.BASELINE);
        layFLine.setWidthFull();
        
        //primaryBar.getStyle().set("border", "1px solid #9E9E9E");
        primaryBar.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        primaryBar.setAlignItems(FlexComponent.Alignment.CENTER);
        primaryBar.setWidthFull();
        
        primaryBar2.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        primaryBar2.setAlignItems(FlexComponent.Alignment.CENTER);
        primaryBar2.setWidthFull();
        
        primaryBar3.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        primaryBar3.setAlignItems(FlexComponent.Alignment.CENTER);
        primaryBar3.setWidthFull();
        
        lay_Busquedas.getStyle().set("border", "1px solid #9E9E9E");
        lay_Busquedas.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        lay_Busquedas.setAlignItems(FlexComponent.Alignment.CENTER);
        lay_Busquedas.setWidthFull();
        
        lbInformation.getStyle().set("fontWeight","bold");
        lbInformation.getStyle().set("color", "red");
        lbInformation.getStyle().set("fontStyle","italic");
        lbInformation.getStyle().set("fontSize","90%");
        
        //layInformation.getStyle().set("border", "1px solid #9E9E9E");
        layInformation.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        layInformation.setAlignItems(FlexComponent.Alignment.CENTER);
        layInformation.setWidthFull();
        //-------------------------------------------------------------------------------
        //GRID
        layGrid.getStyle().set("border", "1px solid #9E9E9E");
        layGrid.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layGrid.setAlignItems(FlexComponent.Alignment.CENTER);
        layGrid.setWidthFull();
        
        grid.setSelectionMode(SelectionMode.MULTI);
        
        grid.addColumn(Producto::getCodigo).setAutoWidth(true).setSortable(true).setHeader("Codigo");
        grid.addColumn(Producto::getNombre).setAutoWidth(true).setSortable(true).setHeader("Nombre");
        grid.addColumn(Producto::getEcommerce_descrip).setAutoWidth(true).setSortable(true).setHeader("Descripcion Ecommerce");
        grid.addColumn(Producto::getStock_ecom).setAutoWidth(true).setSortable(true).setHeader("Stock Disponible");
        grid.addColumn(Producto::hasPromo).setAutoWidth(true).setSortable(true).setHeader("Precio Ecom?");
        
        MultiSelect<Grid<Producto>, Producto> multiSelect = grid.asMultiSelect();
        
        /*
        grid.addColumn(new NativeButtonRenderer<>("Editar Ecom",item -> {
            grid.setDetailsVisible(item, !grid.isDetailsVisible(item));
            on_Open_Ecomdialog();
            dialogEcomm.open();
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
        //-------------------------------------------------------------------------------
        btnver_prod.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        btnver_prod.getStyle().set("fontSize","90%");
        
        layBttnVer_Prod.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        layBttnVer_Prod.setAlignItems(FlexComponent.Alignment.CENTER);
        layBttnVer_Prod.setWidthFull();
        //-------------------------------------------------------------------------------
        //FOOTER
        fButtons.getStyle().set("border", "1px solid #9E9E9E");
        fButtons.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        fButtons.setAlignItems(FlexComponent.Alignment.CENTER);
        fButtons.setWidthFull();
        //-------------------------------------------------------------------------------
        
        //-------------------------------------------------------------------------------
        //DIALOG UPLOAD
        lbInfo_dialog.getStyle().set("color", "red");
        lbInfo_dialog.getStyle().set("fontStyle","italic");
        lbInfo_dialog.getStyle().set("fontSize","70%");
        
        //layInformation.getStyle().set("border", "1px solid #9E9E9E");
        layInfo_dialog.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        layInfo_dialog.setAlignItems(FlexComponent.Alignment.CENTER);
        layInfo_dialog.setWidthFull(); 
        
        btnUpload1.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        btnUpload1.getStyle().set("fontSize","90%");
        btnUpload1Borrar.addThemeVariants(ButtonVariant.LUMO_ERROR);
        btnUpload1Borrar.getStyle().set("fontSize","90%");
        
        btndialog_BuscarAnterior.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        btndialog_BuscarAnterior.getStyle().set("fontSize","70%");
        btndialog_BuscarSiguiente.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        btndialog_BuscarSiguiente.getStyle().set("fontSize","70%");
        
        btngrabar_Ecom.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        btngrabar_Ecom.getStyle().set("fontSize","90%");
        btncancel_Ecom.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        btncancel_Ecom.getStyle().set("fontSize","90%");
        
        //UPLOAD
        upload1.setAutoUpload(true);
        upload1.setDropAllowed(false);
        upload1.setUploadButton(btnUpload1);
        
        //-------------------------------------------------------------------------------
        //IMAGENES
        img1.setVisible(true);
        img1.setEnabled(true);
        img1.setHeight("100px");
        img1.setWidth("100px");
        
        //-------------------------------------------------------------------------------
        //DIALOG SETTINGS
        //cmbLineaEcom.setItems("Pedido(s)","Usario(s)");
        txtLineaEcom.setReadOnly(true);
        
        cmbLineaEcom.setPlaceholder("Elija Linea Ecommerce");
        
        cmbLineaEcom.addValueChangeListener(event->{
            if(!event.getValue().contentEquals("No definida")){
                txtLineaEcom.setValue(event.getValue());
            }
        });
        
        
        titulo_dialog.getStyle().set("fontWeight","bold");
        titulo_dialog.getStyle().set("fontSize","150%");
        
        layTitulo_dialog.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layTitulo_dialog.setAlignItems(FlexComponent.Alignment.CENTER);
        layTitulo_dialog.setWidthFull(); 
        
        dialogEcomm.setCloseOnEsc(true);
        dialogEcomm.setCloseOnOutsideClick(true);
        
        dialogmainform.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        dialogmainform.setAlignItems(FlexComponent.Alignment.CENTER);
        dialogmainform.setWidthFull();
        
        dialogform1.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        dialogform1.setAlignItems(FlexComponent.Alignment.CENTER);
        dialogform1.setWidthFull();
        
        dialogform1_clean.setJustifyContentMode(FlexComponent.JustifyContentMode.END);
        dialogform1_clean.setAlignItems(FlexComponent.Alignment.CENTER);
        dialogform1_clean.setWidthFull();
        
        dialogform1_final.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        dialogform1_final.setAlignItems(FlexComponent.Alignment.CENTER);
        dialogform1_final.setWidthFull();
        
        dialogform2.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        dialogform2.setAlignItems(FlexComponent.Alignment.CENTER);
        dialogform2.setWidthFull();
        /*
        dialogform3.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        dialogform3.setAlignItems(FlexComponent.Alignment.CENTER);
        dialogform3.setWidthFull();*/
        //-------------------------------------------------------------------------------
        //UPLOAD LAYOUTS
        laydialogUp1.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laydialogUp1.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialogUp1.setWidthFull();
        //-------------------------------------------------------------------------------
        //IMAGES LAYOUTS
        laydialogimg1.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laydialogimg1.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialogimg1.setWidthFull();
        
        layImages.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layImages.setAlignItems(FlexComponent.Alignment.CENTER);
        layImages.setWidthFull();
        //-------------------------------------------------------------------------------
        
        dialogform4.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        dialogform4.setAlignItems(FlexComponent.Alignment.CENTER);
        dialogform4.setWidthFull();
        
        txtNameEcom.setWidthFull();
        
        txtPrecioEcom.setWidthFull();
        txtPrecioEcom.addValueChangeListener(event->{ Comprobar_Utilidad(); });
        
        txtaDesc_ecom.setWidthFull();
        
        txtLimiteEcom.setWidthFull();
        
        txtStockAct.setWidthFull();
        txtStockAct.setReadOnly(true);
        
        dialogform5.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        dialogform5.setAlignItems(FlexComponent.Alignment.CENTER);
        dialogform5.setWidthFull();
        
        dialogform6.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        dialogform6.setAlignItems(FlexComponent.Alignment.CENTER);
        dialogform6.setWidthFull();
        //-------------------------------------------------------------------------------
        //NOTIFICATION
        notf_select_exceed.getStyle().set("fontSize","90%");
        notf_select_exceed.getStyle().set("color", "red");
        
        notify_correct.setDuration(2500);
        notify_correct.setPosition(Position.MIDDLE);
        
        notify_incorrect.setDuration(2500);
        notify_incorrect.setPosition(Position.MIDDLE);
        
        notify_select_exceed.setDuration(2500);
        notify_select_exceed.setPosition(Position.MIDDLE); 
        //-------------------------------------------------------------------------------
        //NOTIFICATION UTILIDAD
        
        notf_utilidad_correcta.getStyle().set("fontSize","90%");
        notf_utilidad_correcta.getStyle().set("color", "green"); 
        notf_utilidad_incorrecta.getStyle().set("fontSize","90%");
        notf_utilidad_incorrecta.getStyle().set("color", "red"); 
                
        notify_utilidad_correcta.setDuration(1000);
        notify_utilidad_correcta.setPosition(Position.MIDDLE); 
        notify_utilidad_incorrecta.setDuration(1000);
        notify_utilidad_incorrecta.setPosition(Position.MIDDLE); 
        
        //lbDescriptionPanel.setSizeFull();
        //lbDescriptionPanel.getStyle().set("fontWeight","italic");
        //-------------------------------------------------------------------------------
        //DIALOG PROMOCION
        titulo_dialog_promo.getStyle().set("fontWeight","bold");
        titulo_dialog_promo.getStyle().set("fontSize","150%");
        
        layTitulo_dialog_promo.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layTitulo_dialog_promo.setAlignItems(FlexComponent.Alignment.CENTER);
        layTitulo_dialog_promo.setWidthFull(); 
        
        txtPromo.setWidthFull();
        
        dialogPromo1.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        dialogPromo1.setWidthFull();
        
        btnPromo.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        btnPromo.getStyle().set("fontSize","90%");
        btnPromoCancel.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        btnPromoCancel.getStyle().set("fontSize","90%");
                
        dialogPromo2.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        dialogPromo2.setWidthFull();
        
        laydialogPromo.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laydialogPromo.setWidthFull();
        
        dialogPromoFinal.setCloseOnEsc(true);
        dialogPromoFinal.setCloseOnOutsideClick(true);
        
        //NOTIFICATION PROMO
        promo_notify_correct.setDuration(1000);
        promo_notify_correct.setPosition(Position.MIDDLE);
        //-------------------------------------------------------------------------------
        //DIALOG LIMITE COMPRA
        titulo_dialog_lcompra.getStyle().set("fontWeight","bold");
        titulo_dialog_lcompra.getStyle().set("fontSize","150%");
        
        layTitulo_dialog_lcompra.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layTitulo_dialog_lcompra.setAlignItems(FlexComponent.Alignment.CENTER);
        layTitulo_dialog_lcompra.setWidthFull(); 
        
        txtLimiteC.setWidthFull();
        
        dialogLimiteC1.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        dialogLimiteC1.setWidthFull();
        
        btnLimiteC.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        btnLimiteC.getStyle().set("fontSize","90%");
        btnLimiteCCancel.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        btnLimiteCCancel.getStyle().set("fontSize","90%");
        
        dialogLimiteC2.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        dialogLimiteC2.setWidthFull();
        
        laydialogLimiteC.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laydialogLimiteC.setWidthFull();
        
        dialogLimiteCFinal.setCloseOnEsc(true);
        dialogLimiteCFinal.setCloseOnOutsideClick(true);
        
        //NOTIFICATION LIMITE COMPRA
        limiteC_notify_correct.setDuration(1000);
        limiteC_notify_correct.setPosition(Position.MIDDLE);
        //-------------------------------------------------------------------------------
        
    }
    
    //-----------------------------------------------------------------------------------------------
    //CPANEL Rutas
    //-----------------------------------------------------------------------------------------------
    public abstract void go_CPanel();
    public abstract void go_Pedidos();
    public abstract void go_Index();
    public abstract void go_LineasEcom();
    public abstract void go_Clientes();
    public abstract void go_Cupones();
    
    //-----------------------------------------------------------------------------------------------
    //MAIN VIEW
    //-----------------------------------------------------------------------------------------------
    //Busquedas
    public abstract void On_find_Prodname();
    public abstract void On_find_Cod();
    public abstract void On_find_NoEcom();
    public abstract void on_Click_ComboBusLinea();
    public abstract void On_find_LineaEcom();
    //-----------------------------------------------------------------------------------------------
    //Agregar/Retirar productos de E-commerce
    public abstract void On_add_Prod();
    public abstract void On_delete_Prod();
    //-----------------------------------------------------------------------------------------------
    //Otros
    //public abstract void on_enlistar_Prod(Producto prod);
    //public abstract void on_desenlistar_Prod();
    
    
    //-----------------------------------------------------------------------------------------------
    //DIALOG EDIT ECOMMERCE PRODUCT
    //-----------------------------------------------------------------------------------------------
    //Upload de Imagenes y Actualizar datos de cada producto E-commerce
    public abstract void on_Upload(SucceededEvent event);
    public abstract void on_Descartar_img1();
    //-----------------------------------------------------------------------------------------------
    //Editar dialogo Ecommerce
    public abstract void Clean_Ecomdialog();
    public abstract void on_Open_Ecomdialog();
    public abstract void on_Grabar_ecom();
    public abstract void On_Click_ImgProdAnterior();
    public abstract void On_Click_ImgProdSiguiente();
    //-----------------------------------------------------------------------------------------------
    //Utilidad
    public abstract void Comprobar_Utilidad();
    //-----------------------------------------------------------------------------------------------
    
    
    //-----------------------------------------------------------------------------------------------
    //DIALOG PROMOCION
    //-----------------------------------------------------------------------------------------------
    //Aplicar Promocion a un grupo de Productos
    public abstract void on_Open_Promodialog();
    public abstract void on_Grabar_Promo();
    //-----------------------------------------------------------------------------------------------
    
    
    
    //-----------------------------------------------------------------------------------------------
    //DIALOG LIMITE COMPRA
    //-----------------------------------------------------------------------------------------------
    //Aplicar Limite de compras a un grupo de Productos
    public abstract void on_Open_LimiteCdialog();
    public abstract void on_Grabar_LimiteC();
    //-----------------------------------------------------------------------------------------------
    
    private void initEvents() {
        //-----------------------------------------------------------------------------------------------
        //CABECERA CPANEL
        //-----------------------------------------------------------------------------------------------
        btnClientes.addClickListener(e->{
            removeAll();
            go_Clientes();
        });
        btnPedidos.addClickListener(e->{
            removeAll();
            go_Pedidos();
        });
        btnLineas.addClickListener(e->{
            removeAll();
            go_LineasEcom();
        });
        btnEcomPage.addClickListener(e->{
            removeAll();
            go_Index();
        });
        btnCupones.addClickListener(e->{
            removeAll();
            go_Cupones();
        });
        btnSalirCP.addClickListener(e->{
            removeAll();
            add(new App());
        });
        //-----------------------------------------------------------------------------------------------
        
        //-----------------------------------------------------------------------------------------------
        //MAIN VIEW
        //-----------------------------------------------------------------------------------------------
        //Envía al Menu Principal - Panel de Control
        btnExit.addClickListener(e->{
            removeAll();
            go_CPanel();
        });
        //VER/EDITAR PRODUCTO
        btnver_prod.addClickListener(e->{ 
            on_Open_Ecomdialog();
            //dialogEcomm.open();
        });
        //-----------------------------------------------------------------------------------------------
        
        //-----------------------------------------------------------------------------------------------
        //DIALOG EDIT ECOMMERCE PRODUCT
        //-----------------------------------------------------------------------------------------------
        //Grabar Cambios - Actualizar Producto
        btngrabar_Ecom.addClickListener(e->{ 
            dialogEcomm.close();
            notify_correct.open();
        });
        //Cancelar / Salir dialogo
        btncancel_Ecom.addClickListener(e->{ 
            dialogEcomm.close();
            notify_incorrect.open();
        });
        //Imagen Anterior
        btndialog_BuscarAnterior.addClickListener(e->{ 

        });
        //Imagen Siguiente
        btndialog_BuscarSiguiente.addClickListener(e->{ 

        });
        //Upload Imagen
        upload1.addSucceededListener(this::on_Upload);
        //Descartar Imagen
        btnUpload1Borrar.addClickListener(e-> on_Descartar_img1());
        //-----------------------------------------------------------------------------------------------
        
        //-----------------------------------------------------------------------------------------------
        //DIALOG PROMOCION
        //-----------------------------------------------------------------------------------------------
        btnpromo.addClickListener(e->{ 
            on_Open_Promodialog();
            dialogPromoFinal.open();
        });
        btnPromo.addClickListener(e->{ 
            on_Grabar_Promo();
            promo_notify_correct.open();
        });
        btnPromoCancel.addClickListener(e-> dialogPromoFinal.close());
        //-----------------------------------------------------------------------------------------------
        
        //-----------------------------------------------------------------------------------------------
        //DIALOG LIMITE COMPRA
        //-----------------------------------------------------------------------------------------------
        btnlimite_compra.addClickListener(e->{ 
            on_Open_LimiteCdialog();
            dialogLimiteCFinal.open();
        });
        btnLimiteC.addClickListener(e->{ 
            on_Grabar_LimiteC();
            limiteC_notify_correct.open();
        });
        btnLimiteCCancel.addClickListener(e-> dialogLimiteCFinal.close());
        btnClean_dialog.addClickListener(e-> Clean_Ecomdialog());
        //-----------------------------------------------------------------------------------------------
    }
}
