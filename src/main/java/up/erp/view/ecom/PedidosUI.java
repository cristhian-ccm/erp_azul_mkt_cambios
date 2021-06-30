/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.view.ecom;

import com.upgrade.persistence.model.cmrlz.NotaPedidoDet;
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
public abstract class PedidosUI extends VerticalLayout{
    //-----------------------------------------------------------------------------------------------
    //CPANEL CABECERA
    //-----------------------------------------------------------------------------------------------
    public final Button btnClientes = new Button("Clientes Ecommerce", VaadinIcon.MALE.create());
    public final Button btnSubscriptores = new Button("Subscriptores Ecommerce", VaadinIcon.MALE.create());
    public final Button btnPromociones = new Button("Promociones Ecommerce", VaadinIcon.GIFT.create());
    public final Button btnCupones = new Button("Cupones Ecommerce", VaadinIcon.TICKET.create());
    public final Button btnPuntosUP = new Button("Puntos UP Ecommerce", VaadinIcon.TROPHY.create());
    //-----------------------------------------------------------------------------------------------
    public final Button btnLineas = new Button("Lineas Ecommerce", VaadinIcon.RECORDS.create());
    public final Button btnProductos = new Button("Productos Ecommerce", VaadinIcon.PACKAGE.create());
    public final Button btnEcomPage = new Button("Página Ecommerce", VaadinIcon.GLOBE_WIRE.create());
    //-----------------------------------------------------------------------------------------------
    public final Button btnSalirCP = new Button("Salir del Panel de Control");
    //-----------------------------------------------------------------------------------------------
    public final HorizontalLayout layCPanelButtons = new HorizontalLayout(btnSubscriptores,btnPromociones,btnCupones,btnPuntosUP);
    //-----------------------------------------------------------------------------------------------
    public final HorizontalLayout layCPanelButtons2 = new HorizontalLayout(btnLineas,btnProductos,btnEcomPage,btnSalirCP);
    //-----------------------------------------------------------------------------------------------
    //END CABECERA
    //-----------------------------------------------------------------------------------------------
    
    //--------------------------------------------------------------------------------------------------
    //INIT MAIN VIEW
    //--------------------------------------------------------------------------------------------------
    // HEADER
    //--------------------------------------------------------------------------------------------------
    Label titulo = new Label("PEDIDOS DE CLIENTES");
    public final HorizontalLayout head = new HorizontalLayout(titulo);
    //--------------------------------------------------------------------------------------------------
    // WORKSPACE
    //--------------------------------------------------------------------------------------------------    
    Label titulo_buscar = new Label("BUSQUEDA DE PEDIDOS");
    ComboBox<String> comboBoxBusq = new ComboBox<>();
    public final HorizontalLayout lay_titulo_bus = new HorizontalLayout(titulo_buscar);
    //--------------------------------------------------------------------------------------------------
    //Barra de busquedas
    //--------------------------------------------------------------------------------------------------
    public final TextField txtInput_NOrden = new TextField("Numero Orden:");
    public final Button btnFind_Ped_NOrden = new Button("Buscar",VaadinIcon.SEARCH.create());
    
    public final HorizontalLayout lay_NOrden_bus = new HorizontalLayout(txtInput_NOrden,btnFind_Ped_NOrden);
    //-----------------------------------------------------------------------------------------------
    public final TextField txtInput_find = new TextField("Ingrese Usuario");
    
    public final Label lbInput_find2 = new Label("Ingrese Rango de Fechas:");
    public final DatePicker Fecha_ini_DatePicker = new DatePicker();
    public final DatePicker Fecha_fin_DatePicker = new DatePicker();
    //--------------------------------------------------------------------------------------------------
    //3) Botones

    public final Button btnProd_pedido1 = new Button("Buscar",VaadinIcon.SEARCH.create());
    public final Button btnProd_pedido2 = new Button("Buscar",VaadinIcon.SEARCH.create());
    //--------------------------------------------------------------------------------------------------
    //4) Layout
    public final HorizontalLayout primaryBar = new HorizontalLayout(txtInput_find,btnProd_pedido1);
    public final HorizontalLayout primaryBar2 = new HorizontalLayout(lbInput_find2,Fecha_ini_DatePicker,Fecha_fin_DatePicker,btnProd_pedido2);
    
    public final VerticalLayout lay_Busquedas =  new VerticalLayout(lay_titulo_bus,lay_NOrden_bus,primaryBar,primaryBar2);
    //--------------------------------------------------------------------------------------------------
    //TABLE - INFORMATION
    
    //public final Grid<NotaPedidoDet> grid = new Grid<>(NotaPedidoDet.class);
    public final Grid<PedidoEcommerce> grid = new Grid<>();
    public final VerticalLayout layGrid = new VerticalLayout(grid);
    
    public final Button btnver_ped = new Button("Ver/Editar", VaadinIcon.EYE.create());
    public final HorizontalLayout layBttnVer_Prod = new HorizontalLayout(btnver_ped);
    
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
    //--------------------------------------------------------------------------------------------------
    
    public final Label lbInformation = new Label("*Nota: Seleccione el pedido antes de Editar");
    public final HorizontalLayout layInformation = new HorizontalLayout(lbInformation);
    //--------------------------------------------------------------------------------------------------
    //FOOT
    //--------------------------------------------------------------------------------------------------
    //Botones de acción final
    //Iconos
    public final Icon exit = VaadinIcon.EXIT.create();
    public final Icon cambiar_Fecha = VaadinIcon.CALENDAR.create();
    public final Icon cambiar_Estado = VaadinIcon.RECYCLE.create();

    public final Button btnCambiar_Fecha = new Button("Cambiar Fecha Entrega",cambiar_Fecha);
    public final Button btnCambiar_Estado = new Button("Cambiar Estado",cambiar_Estado);
    public final Button btnExit = new Button("Salir",exit);
    //--------------------------------------------------------------------------------------------------
    //public final HorizontalLayout fButtons = new HorizontalLayout(btnCambiar_Fecha,btnCambiar_Estado,btnExit);
    public final HorizontalLayout fButtons = new HorizontalLayout(btnExit);
    //--------------------------------------------------------------------------------------------------
    //END MAIN VIEW
    //--------------------------------------------------------------------------------------------------
    
    
    //--------------------------------------------------------------------------------------------------
    //DIALOG PEDIDO
    //--------------------------------------------------------------------------------------------------
    //TITULO
    
    public final Label titulo_dialog = new Label("DETALLES DEL PEDIDO");
    public final HorizontalLayout layTitulo_dialog = new HorizontalLayout(titulo_dialog);
    //--------------------------------------------------------------------------------------------------
    //DATOS GENERALES
    
    public final TextField txtdialog_NOrden = new TextField("Número de Orden");
    public final TextField txtdialog_TipoEntrega = new TextField("Tipo Entrega");
    public final ComboBox<String> comboBoxProds_byPed = new ComboBox<>("Productos");
    public final TextField txtdialog_Prods_byPed = new TextField("Producto");
    
    public final HorizontalLayout laydialog_NOrden = new HorizontalLayout(txtdialog_NOrden,txtdialog_TipoEntrega,comboBoxProds_byPed);
    public final HorizontalLayout laydialog_Prods_byPed = new HorizontalLayout(txtdialog_Prods_byPed);
    //--------------------------------------------------------------------------------------------------
    //DATOS USUARIO
    
    public final Label titdetUsu_dialog = new Label("DATOS DEL USUARIO");
    public final HorizontalLayout layTitdetUsu_dialog = new HorizontalLayout(titdetUsu_dialog);
    //--------------------------------------------------------------------------------------------------
    public final TextField txtdialog_UsuName = new TextField("Nombre Usuario");
    public final HorizontalLayout laydialog_UsuName = new HorizontalLayout(txtdialog_UsuName);
    //--------------------------------------------------------------------------------------------------
    public final TextField txtdialog_UsuEmail = new TextField("Email Usuario");
    public final TextField txtdialog_UsuTelf = new TextField("Telefono Usuario");
    
    public final HorizontalLayout laydialog_UsuEmail = new HorizontalLayout(txtdialog_UsuEmail);
    public final HorizontalLayout laydialog_UsuTelf = new HorizontalLayout(txtdialog_UsuTelf);
    //--------------------------------------------------------------------------------------------------
    public final TextField txtdialog_DirEcom = new TextField("Direccion del Usuario");
    public final TextField txtdialog_RefEcom = new TextField("Referencia");
    
    public final HorizontalLayout laydialog_DirEcom = new HorizontalLayout(txtdialog_DirEcom);
    public final HorizontalLayout laydialog_RefEcom = new HorizontalLayout(txtdialog_RefEcom);
    //--------------------------------------------------------------------------------------------------
    //CAMBIO ESTADO
    
    public final Label titCambioEst_dialog = new Label("CAMBIO DE ESTADO DEL PEDIDO");
    public final HorizontalLayout layTitCambioEst_dialog = new HorizontalLayout(titCambioEst_dialog);
    //--------------------------------------------------------------------------------------------------
    public final ComboBox<String> comboBoxEstados = new ComboBox<>();
    public final TextField txtdialog_Estado = new TextField("Ingresar Estado");
    public final HorizontalLayout laydialog_Estado = new HorizontalLayout(comboBoxEstados,txtdialog_Estado);
    //--------------------------------------------------------------------------------------------------
    public final Label lbInfo_dialog = new Label("Estados Permitidos: L (Almacen), D (Despachado), E (Entregado), A (Anulado)");
    public final HorizontalLayout layInfo_dialog = new HorizontalLayout(lbInfo_dialog);
    //--------------------------------------------------------------------------------------------------
    public final Button btnGrabar_dialog = new Button("Grabar Cambios");
    public final Button btnCancel_dialog = new Button("Cancelar");
    public final HorizontalLayout laydialogBtns = new HorizontalLayout(btnGrabar_dialog,btnCancel_dialog);
    //--------------------------------------------------------------------------------------------------
    //CREATE DIALOG PEDIDO
    //--------------------------------------------------------------------------------------------------
    public final VerticalLayout laydialogPedido = new VerticalLayout( layTitulo_dialog,laydialog_NOrden,laydialog_Prods_byPed,
                                                                      layTitdetUsu_dialog,laydialog_UsuName,laydialog_UsuEmail,laydialog_UsuTelf,laydialog_DirEcom,laydialog_RefEcom,
                                                                      layTitCambioEst_dialog,laydialog_Estado,layInfo_dialog,laydialogBtns);
    
    public final Dialog dialogPedido = new Dialog(laydialogPedido);
    //--------------------------------------------------------------------------------------------------
    //NOTIFICATION PEDIDO
    //--------------------------------------------------------------------------------------------------
    public final Label Pedido_notf_correct = new Label("Datos Actualizados Correctamente");
    public final Notification Pedido_notify_correct = new Notification(Pedido_notf_correct);
    public final Label notf_select_exceed = new Label("Más de un Pedido ha sido seleccionado. Por favor, seleccione sólo uno");
    
    public final Label Pedido_notf_incorrect = new Label("No se puede ingresar un Estado existente o incorrecto");
    public final Notification Pedido_notify_incorrect = new Notification(Pedido_notf_incorrect);
    public final Notification notify_select_exceed = new Notification(notf_select_exceed);
    //--------------------------------------------------------------------------------------------------
    //END DIALOG PEDIDO
    //--------------------------------------------------------------------------------------------------
    
    
    
    //--------------------------------------------------------------------------------------------------
    //INIT
    //--------------------------------------------------------------------------------------------------
    public PedidosUI() {
        removeAll();
        //add(layCPanelButtons,head,lay_Busquedas, layGrid, layInformation,fButtons);
        addAndExpand(layCPanelButtons,layCPanelButtons2,head,lay_Busquedas, layButtonsGrid, layGrid, layInformation,fButtons);
        btnProd_pedido1.addClickListener(e->On_find_Ped());
        btnProd_pedido2.addClickListener(e->On_find_Ped2());
        btnFind_Ped_NOrden.addClickListener(e->On_find_NOrdenPed());
        initStyles();
        initEvents();
        setSizeFull();
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
        
        
        //-----------------------------------------------------------------------------------------------
        //INIT MAIN VIEW
        //-----------------------------------------------------------------------------------------------
        //HEAD
        //-----------------------------------------------------------------------------------------------
        titulo.getStyle().set("fontWeight","bold");
        titulo.getStyle().set("fontSize","300%");
        head.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        head.setWidthFull();
        
        //
        titulo_buscar.getStyle().set("fontWeight","bold");
        titulo_buscar.getStyle().set("fontSize","150%");
        
        lay_titulo_bus.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        lay_titulo_bus.setWidthFull();
        
        
        comboBoxBusq.setItems("Pedido(s)","Usario(s)");
        comboBoxBusq.setPlaceholder("Elija una opción de búsqueda");
        
        comboBoxBusq.addValueChangeListener(event->{
            if (event.getValue().contentEquals("Pedido(s)")){
                txtInput_find.setEnabled(false);
                txtInput_find.setReadOnly(true);
            } else {
                txtInput_find.setEnabled(true);
                txtInput_find.setReadOnly(false);
            }
        });
        //-----------------------------------------------------------------------------------------------
        //txtInput_NOrden.getStyle().set("fontSize","60%");  
        //btnFind_Ped_NOrden.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        btnFind_Ped_NOrden.getStyle().set("fontSize","90%"); 
    
        lay_NOrden_bus.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        lay_NOrden_bus.setAlignItems(FlexComponent.Alignment.BASELINE);
        lay_NOrden_bus.setWidthFull();
        //-----------------------------------------------------------------------------------------------
        
        //LocalDate now = LocalDate.now();
        Fecha_ini_DatePicker.setLabel("Ingrese Fecha Inicio");
        //Fecha_ini_DatePicker.setValue(now);
        
        LocalDate actual_date = LocalDate.now();
        Fecha_fin_DatePicker.setLabel("Ingrese Fecha Fin");
        Fecha_fin_DatePicker.setValue(actual_date);
        //Fecha_fin_DatePicker.setValue(now);
        
        //btnProd_pedido1.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        btnProd_pedido1.getStyle().set("fontSize","90%"); 
        //btnProd_pedido2.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        btnProd_pedido2.getStyle().set("fontSize","90%"); 
        
        //primaryBar.getStyle().set("border", "1px solid #9E9E9E");
        primaryBar.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        primaryBar.setAlignItems(FlexComponent.Alignment.BASELINE);
        primaryBar.setWidthFull();
        
        primaryBar2.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        primaryBar2.setAlignItems(FlexComponent.Alignment.BASELINE);
        primaryBar2.setWidthFull();
        
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
        
        //-----------------------------------------------------------------------------------------------
        //WORKSPACE
        //-----------------------------------------------------------------------------------------------
        //GRID
        //-----------------------------------------------------------------------------------------------
        layGrid.getStyle().set("border", "1px solid #9E9E9E");
        layGrid.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layGrid.setAlignItems(FlexComponent.Alignment.CENTER);
        layGrid.setWidthFull();
        
        grid.addColumn(PedidoEcommerce::getNumero).setAutoWidth(true).setSortable(true).setHeader("Número");
        grid.addColumn(PedidoEcommerce::getUsuario_web).setAutoWidth(true).setSortable(true).setHeader("Usuario");
        grid.addColumn(PedidoEcommerce::getFecha_entrega).setAutoWidth(true).setSortable(true).setHeader("Fecha de Entrega");
        grid.addColumn(PedidoEcommerce::getFecha_actual_proceso).setAutoWidth(true).setSortable(true).setHeader("Fecha Act. Estado");
        grid.addColumn(PedidoEcommerce::getEstado).setAutoWidth(true).setSortable(true).setHeader("Estado");
        grid.addColumn(PedidoEcommerce::getAprobada).setAutoWidth(true).setSortable(true).setHeader("Aprobada");
        grid.addColumn(PedidoEcommerce::getTipo_pago).setAutoWidth(true).setSortable(true).setHeader("Tipo de Pago");
        
        
        grid.setSelectionMode(Grid.SelectionMode.MULTI);
        
        MultiSelect<Grid<PedidoEcommerce>, PedidoEcommerce> multiSelect = grid.asMultiSelect();
        /*
        grid.addColumn(new NativeButtonRenderer<>("Ver/Editar",item -> {
            grid.setDetailsVisible(item, !grid.isDetailsVisible(item));
            on_Open_Pedidodialog();
            dialogPedido.open();
            //txtdialog_NOrden.setEnabled(false);
            txtdialog_NOrden.setReadOnly(true);
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
        //-----------------------------------------------------------------------------------------------
        //btnver_prod.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        btnver_ped.getStyle().set("fontSize","90%");
        
        layBttnVer_Prod.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        layBttnVer_Prod.setAlignItems(FlexComponent.Alignment.CENTER);
        //layBttnVer_Prod.setWidthFull();
        //-----------------------------------------------------------------------------------------------
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
        //FOOTER
        //-----------------------------------------------------------------------------------------------
        fButtons.getStyle().set("border", "1px solid #9E9E9E");
        fButtons.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        fButtons.setAlignItems(FlexComponent.Alignment.CENTER);
        fButtons.setWidthFull();
        //-----------------------------------------------------------------------------------------------
        //END MAIN VIEW
        //-----------------------------------------------------------------------------------------------
        
        
        
        //-----------------------------------------------------------------------------------------------
        //DIALOG PEDIDO
        //-----------------------------------------------------------------------------------------------
        //TITULO
        //-----------------------------------------------------------------------------------------------
        titulo_dialog.getStyle().set("fontWeight","bold");
        titulo_dialog.getStyle().set("fontSize","150%");
        
        layTitulo_dialog.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layTitulo_dialog.setAlignItems(FlexComponent.Alignment.CENTER);
        layTitulo_dialog.setWidthFull(); 
        //-----------------------------------------------------------------------------------------------
        //DATOS GENERALES
        //-----------------------------------------------------------------------------------------------   
        txtdialog_NOrden.setWidthFull();
        txtdialog_NOrden.setReadOnly(true);
        
        txtdialog_TipoEntrega.setWidthFull();
        txtdialog_TipoEntrega.setReadOnly(true);
        
        laydialog_NOrden.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laydialog_NOrden.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialog_NOrden.setWidthFull();
        //-----------------------------------------------------------------------------------------------
        txtdialog_Prods_byPed.setWidthFull();
        txtdialog_Prods_byPed.setReadOnly(true);
        
        //comboBoxProds_byPed.setWidthFull();
        comboBoxProds_byPed.setPlaceholder("Productos del Pedido");
        
        comboBoxProds_byPed.addValueChangeListener(event->{
            if(!event.getValue().contentEquals("No definido")){
                txtdialog_Prods_byPed.setValue(event.getValue());
            }
            else
                txtdialog_Prods_byPed.setValue("");
        });
        
        laydialog_Prods_byPed.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laydialog_Prods_byPed.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialog_Prods_byPed.setWidthFull();
        //-----------------------------------------------------------------------------------------------
        //DATOS USUARIO
        //-----------------------------------------------------------------------------------------------
        titdetUsu_dialog.getStyle().set("fontWeight","bold");
        titdetUsu_dialog.getStyle().set("fontSize","120%");
        
        layTitdetUsu_dialog.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        layTitdetUsu_dialog.setAlignItems(FlexComponent.Alignment.CENTER);
        layTitdetUsu_dialog.setWidthFull(); 
        //-----------------------------------------------------------------------------------------------
        txtdialog_UsuName.setWidthFull();
        txtdialog_UsuName.setReadOnly(true); 
                
        laydialog_UsuName.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laydialog_UsuName.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialog_UsuName.setWidthFull();
        //-----------------------------------------------------------------------------------------------
        txtdialog_UsuTelf.setWidthFull();
        txtdialog_UsuTelf.setReadOnly(true);
        txtdialog_UsuEmail.setWidthFull();
        txtdialog_UsuEmail.setReadOnly(true);
                
        laydialog_UsuEmail.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laydialog_UsuEmail.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialog_UsuEmail.setWidthFull();
        
        laydialog_UsuTelf.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laydialog_UsuTelf.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialog_UsuTelf.setWidthFull();
        //-----------------------------------------------------------------------------------------------
        txtdialog_DirEcom.setWidthFull();
        txtdialog_DirEcom.setReadOnly(true);
        txtdialog_RefEcom.setWidthFull();
        txtdialog_RefEcom.setReadOnly(true);
        
        laydialog_DirEcom.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laydialog_DirEcom.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialog_DirEcom.setWidthFull();
        
        laydialog_RefEcom.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laydialog_RefEcom.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialog_RefEcom.setWidthFull();
        //-----------------------------------------------------------------------------------------------
        //CAMBIO ESTADO
        //-----------------------------------------------------------------------------------------------
        titCambioEst_dialog.getStyle().set("fontWeight","bold");
        titCambioEst_dialog.getStyle().set("fontSize","120%");
        
        layTitCambioEst_dialog.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        layTitCambioEst_dialog.setAlignItems(FlexComponent.Alignment.CENTER);
        layTitCambioEst_dialog.setWidthFull(); 
        //-----------------------------------------------------------------------------------------------
        txtdialog_Estado.setWidthFull();
        txtdialog_Estado.setReadOnly(true);
        
        comboBoxEstados.setWidthFull();
        comboBoxEstados.setPlaceholder("Elija el Estado");
        
        comboBoxEstados.addValueChangeListener(event->{
            if(!event.getValue().contentEquals("No definido")){
                txtdialog_Estado.setValue(event.getValue());
            }
        });
        
        laydialog_Estado.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laydialog_Estado.setAlignItems(FlexComponent.Alignment.BASELINE);
        laydialog_Estado.setWidthFull();
        
        lbInfo_dialog.getStyle().set("fontWeight","bold");
        lbInfo_dialog.getStyle().set("color", "green");
        lbInfo_dialog.getStyle().set("fontStyle","italic");
        lbInfo_dialog.getStyle().set("fontSize","70%");
        
        //layInformation.getStyle().set("border", "1px solid #9E9E9E");
        layInfo_dialog.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        layInfo_dialog.setAlignItems(FlexComponent.Alignment.CENTER);
        layInfo_dialog.setWidthFull(); 
        
        btnGrabar_dialog.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        btnGrabar_dialog.getStyle().set("fontSize","90%");
        btnCancel_dialog.addThemeVariants(ButtonVariant.LUMO_ERROR);
        btnCancel_dialog.getStyle().set("fontSize","90%");
        
        laydialogBtns.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laydialogBtns.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialogBtns.setWidthFull();
        //-----------------------------------------------------------------------------------------------
        //CREATE DIALOG PEDIDO
        //-----------------------------------------------------------------------------------------------
        dialogPedido.setCloseOnEsc(false);
        dialogPedido.setCloseOnOutsideClick(false);
        //-----------------------------------------------------------------------------------------------
        //NOTIFICATION DIALOG PEDIDO
        //-----------------------------------------------------------------------------------------------
        notf_select_exceed.getStyle().set("fontSize","90%");
        notf_select_exceed.getStyle().set("color", "red");
        
        Pedido_notify_correct.setDuration(2500);
        Pedido_notify_correct.setPosition(Notification.Position.MIDDLE);
        
        Pedido_notify_incorrect.setDuration(2500);
        Pedido_notify_incorrect.setPosition(Notification.Position.MIDDLE);
        
        notify_select_exceed.setDuration(2500);
        notify_select_exceed.setPosition(Notification.Position.MIDDLE); 
        //-----------------------------------------------------------------------------------------------
        //END DIALOG PEDIDO
        //-----------------------------------------------------------------------------------------------
        
        
    }
    
    //CPANEL Rutas
    public abstract void go_CPanel();
    
    public abstract void go_Clientes();
    public abstract void go_Subscriptores();
    public abstract void go_Promociones();
    public abstract void go_Cupones();
    public abstract void go_PuntosUP();
    
    public abstract void go_LineasEcom();
    public abstract void go_Productos();
    public abstract void go_Index();
    
    //Busquedas
    public abstract void On_find_NOrdenPed();
    public abstract void On_find_Ped();
    public abstract void On_find_Ped2();
    
    //Editar datos de Pedido
    public abstract void on_Open_Pedidodialog();
    public abstract void on_Grabar_Pedido();
    
    //
    //public abstract void Init_CheckPedidos_FueraAlmacen();
    //----------------------------------------------------------------------------------------------------
    //REPORTEADOR : TOOLBAR
    //----------------------------------------------------------------------------------------------------
    public abstract void init_ReporterToolbar();
    public abstract void init_ReporterToolbar_default();
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
        btnCupones.addClickListener(e->{
            removeAll();
            go_Cupones();
        });
        btnPuntosUP.addClickListener(e->{
            removeAll();
            go_PuntosUP();
        });
        //-----------------------------------------------------------------------------------------------
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
            //add(new CPanelView());
            go_CPanel();
            //setContent(new CPanelView(this));
        });
        //VER/EDITAR PRODUCTO
        btnver_ped.addClickListener(e->{ 
            on_Open_Pedidodialog();
            //dialogPedido.open();
        });
        //Editar Pedido
        btnGrabar_dialog.addClickListener(e->{ 
            on_Grabar_Pedido();
            dialogPedido.close();
        });
        btnCancel_dialog.addClickListener(e->{ 
            dialogPedido.close();
            grid.getDataProvider().refreshAll();
        });
        
        //------------------------------------------------------------------------------------------------
        //REPORTEADOR : TOOLBAR
        //------------------------------------------------------------------------------------------------
        Toolbar.btnRefresh.addClickListener(e->{ 
            Toolbar.on_Refresh(grid);
        });
        //------------------------------------------------------------------------------------------------
    }
}
