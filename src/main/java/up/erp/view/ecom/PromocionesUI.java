/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.view.ecom;

import com.upgrade.persistence.model.ecommerce.Cupones;
import com.upgrade.persistence.model.ecommerce.Promociones;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.upload.SucceededEvent;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
import com.vaadin.flow.data.selection.MultiSelect;
import up.erp.view.App;

/**
 *
 * @author Luis Aleman
 */
public abstract class PromocionesUI extends VerticalLayout{
    
    //-----------------------------------------------------------------------------------------------
    //CPANEL CABECERA
    //-----------------------------------------------------------------------------------------------
    public final Button btnClientes = new Button("Clientes Ecommerce", VaadinIcon.MALE.create());
    public final Button btnSubscriptores = new Button("Subscriptores Ecommerce", VaadinIcon.MALE.create());
    //public final Button btnPromociones = new Button("Promociones Ecommerce", VaadinIcon.GIFT.create());
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
    public final HorizontalLayout layCPanelButtons = new HorizontalLayout(btnClientes,btnSubscriptores,btnCupones,btnPuntosUP);
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
    public final Label titulo = new Label("PROMOCIONES E-COMMERCE");
    
    public final HorizontalLayout head = new HorizontalLayout(titulo);
    //-----------------------------------------------------------------------------------------------
    // WORKSPACE
    //-----------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------
    // BUSQUEDAS
    //-----------------------------------------------------------------------------------------------
    public final Label titulo_buscar = new Label("BUSQUEDA DE PROMOCIONES");
    public final HorizontalLayout lay_titulo_bus = new HorizontalLayout(titulo_buscar);
    //-----------------------------------------------------------------------------------------------
    //BUSQUEDA PROMOCION - ACTIVO/INACTIVO 
    
    public final Label lbActivo_Inactivo = new Label("Buscar Promocion:");
    public final Button btnFind_Activo = new Button("Activo");
    public final Button btnFind_Inactivo = new Button("Inactivos");
    
    public final HorizontalLayout lay_Find_Act_Inact = new HorizontalLayout(lbActivo_Inactivo,btnFind_Activo,btnFind_Inactivo);
    //----------------------------------------------------------------------------------------------------
    //LAYOUT FINAL
    
    public final VerticalLayout lay_Busquedas =  new VerticalLayout(lay_titulo_bus,lay_Find_Act_Inact);
    //----------------------------------------------------------------------------------------------------
    //----------------------------------------------------------------------------------------------------
    //GRID - BODY
    //----------------------------------------------------------------------------------------------------
    public final Grid<Promociones> grid_Promo = new Grid<>();
    
    public final VerticalLayout layGrid = new VerticalLayout(grid_Promo);
    //----------------------------------------------------------------------------------------------------
    //INFORMATION
    public final Label lbInformation = new Label("*Nota: Seleccione la promoción antes de Ver/Editar");
    
    public final HorizontalLayout layInformation = new HorizontalLayout(lbInformation);
    //----------------------------------------------------------------------------------------------------
    public final Button btnver_prod = new Button("Ver/Editar", VaadinIcon.EYE.create());
    public final HorizontalLayout layBttnVer_Prod = new HorizontalLayout(btnver_prod);
    //-----------------------------------------------------------------------------------------------
    //----------------------------------------------------------------------------------------------------
    //FOOT - BOTONES DE ACCION FINAL
    //----------------------------------------------------------------------------------------------------
    public final Button btnNewPromo = new Button("Nueva Promoción");
    public final Button btnChange_Activo = new Button("Activar Promocion(es)");
    public final Button btnChange_Inactivo = new Button("Desactivar Promocion(es)");
    public final Button btnAsignar_Monto = new Button("Asignar Monto");
    public final Button btnExit = new Button("Salir");
    
    public final HorizontalLayout fButtons = new HorizontalLayout(btnNewPromo,btnChange_Activo,btnChange_Inactivo,btnAsignar_Monto,btnExit);
    //----------------------------------------------------------------------------------------------------
    //NOTIFICACION
    //----------------------------------------------------------------------------------------------------
    public final Label notf_select_exceed = new Label("Más de una promoción ha sido seleccionada. Por favor, seleccione sólo una");
    public final Notification notify_select_exceed = new Notification(notf_select_exceed);
    //----------------------------------------------------------------------------------------------------
    //END MAIN VIEW
    //------------------------------------------------------------------------------------------------
    
    
    
    //------------------------------------------------------------------------------------------------
    //DIALOG PROMOCION EXISTENTE
    //------------------------------------------------------------------------------------------------
    //TITULO GENERAL
    //-----------------------------------------------------------------------------------------------
    public final Label lbPROME_titulo = new Label("EDITAR PROMOCIONES");
    public final HorizontalLayout layTitPROME_titulo  = new HorizontalLayout(lbPROME_titulo);
    //------------------------------------------------------------------------------------------------
    //CUERPO DIALOG
    //----------------------------------------------------------------------------------------------------
    //PROMOCION EXISTENTE: Nombre/Activo/Monto Min/Monto Descu
    //-----------------------------------------------------------------------------------------------
    public final TextField txtPROME_Prefijo = new TextField("Prefijo");
    public final TextField txtPROME_Nombre = new TextField("Titulo Promoción");
    public final Checkbox chckPROME_Activa = new Checkbox("Activar?");
    public final TextField txtPROME_MontoMin = new TextField("Monto Mínimo Producto");
    public final TextField txtPROME_MontoDescu = new TextField("Monto Descuento");
    
    public final HorizontalLayout layPROMOE_part1 = new HorizontalLayout(txtPROME_Prefijo,txtPROME_Nombre,chckPROME_Activa,
                                                                               txtPROME_MontoMin,txtPROME_MontoDescu);
    //-----------------------------------------------------------------------------------------------
    //PROMOCION EXISTENTE: Fecha Fin Vigencia / N° de dias de vigencia
    //-----------------------------------------------------------------------------------------------
    public final Checkbox chckPROME_CheckFVigencia = new Checkbox("Fecha Fin Vigencia?");
    public final DatePicker datePROMOE_FinVigencia = new DatePicker("Fecha Fin Vigencia");
    public final TextField txtPROME_DiasVigencia = new TextField("Días Vigencia");
    
    public final HorizontalLayout layPROMOE_part2 = new HorizontalLayout(chckPROME_CheckFVigencia,datePROMOE_FinVigencia,txtPROME_DiasVigencia);
    //-----------------------------------------------------------------------------------------------
    //public final Checkbox chckPROME_CheckDVigencia = new Checkbox("Dias Vigencia?");
    //public final TextField txtPROME_DiasVigencia = new TextField("Días Vigencia");
    
    //public final HorizontalLayout layPROMOE_part2_2 = new HorizontalLayout(chckPROME_CheckDVigencia,txtPROME_DiasVigencia);
    //-----------------------------------------------------------------------------------------------
    //PROMOCION EXISTENTE: Cargar Imagen Promoción
    //-----------------------------------------------------------------------------------------------
    public final MemoryBuffer bufferPROMOE = new MemoryBuffer();
    public final Upload uploadPROMOE = new Upload(bufferPROMOE);
    //-----------------------------------------------------------------------------------------------
    public final Label lbtitImgPROMOE = new Label("IMAGEN PROMOCION");
    public final HorizontalLayout layTImgPROMOE = new HorizontalLayout(lbtitImgPROMOE);
    //-----------------------------------------------------------------------------------------------
    //PROMOCION EXISTENTE: Imagen
    //-----------------------------------------------------------------------------------------------
    public final Image imgPROMOE = new Image();
    public final TextField txtUrlPROMOE = new TextField("Url Imagen");
    public final Button btnUploadPROMOE = new Button("Cargar Imagen");
    public final Button btnBorrarPROMOE = new Button("Descartar Imagen");
    //-----------------------------------------------------------------------------------------------
    public final HorizontalLayout layimgPROMOE = new HorizontalLayout(imgPROMOE);
    public final HorizontalLayout layUrlPROMOE = new HorizontalLayout(txtUrlPROMOE);
    public final HorizontalLayout layUploadPROMOE = new HorizontalLayout(uploadPROMOE,btnBorrarPROMOE);
    
    public final VerticalLayout layPROMOE_part3 = new VerticalLayout(layTImgPROMOE,layimgPROMOE,layUrlPROMOE,
                                                                    layUploadPROMOE);
    //-----------------------------------------------------------------------------------------------
    //PROMOCION EXISTENTE: Foot
    //-----------------------------------------------------------------------------------------------
    public final Button btnGuardarPROMOE = new Button("Guardar Cambios");
    public final Button btnEliminarPROMOE = new Button("Eliminar Promocion");
    public final Button btnExitPROMOE = new Button("Cancelar");
    
    public final HorizontalLayout layFootPROMOE = new HorizontalLayout(btnGuardarPROMOE,btnEliminarPROMOE,btnExitPROMOE);
    //-----------------------------------------------------------------------------------------------
    //PROMOCION EXISTENTE: LAYOUT TOTAL
    public final VerticalLayout layTotalPROMOE = new VerticalLayout(layTitPROME_titulo,layPROMOE_part1,layPROMOE_part2,
                                                                    layPROMOE_part3,layFootPROMOE);
    //------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------
    //PROMOCION EXISTENTE: CREACION DIALOG
    public final Dialog dialog_PromoExist = new Dialog(layTotalPROMOE);
    //------------------------------------------------------------------------------------------------
    //PROMOCION EXISTENTE: NOTIFICATION
    //-----------------------------------------------------------------------------------------------
    public final Label notf_UpdatePROMOE = new Label("La promoción ha sido actualizada");
    public final Label notf_DeletePROMOE = new Label("La promoción ha sido eliminada");
    
    public final Notification notifyUpdatePROMOE = new Notification(notf_UpdatePROMOE);
    public final Notification notifyDeletePROMOE = new Notification(notf_DeletePROMOE);
    //------------------------------------------------------------------------------------------------
    //END DIALOG PROMOCION EXISTENTE 
    //------------------------------------------------------------------------------------------------   
    
    
    
    //------------------------------------------------------------------------------------------------
    //DIALOG NUEVA PROMOCION
    //------------------------------------------------------------------------------------------------
    //NUEVA PROMOCION: TITULO GENERAL
    //-----------------------------------------------------------------------------------------------
    public final Label lbPROMN_titulo = new Label("CREAR PROMOCION");
    public final HorizontalLayout layTitPROMN_titulo  = new HorizontalLayout(lbPROMN_titulo);
    //------------------------------------------------------------------------------------------------
    //CUERPO DIALOG
    //----------------------------------------------------------------------------------------------------
    //NUEVA PROMOCION: Nombre/Activo/Monto Min/Monto Descu
    //-----------------------------------------------------------------------------------------------
    public final TextField txtPROMN_Prefijo = new TextField("Prefijo");
    public final TextField txtPROMN_Nombre = new TextField("Titulo Promoción");
    public final Checkbox chckPROMN_Activa = new Checkbox("Activar?");
    public final TextField txtPROMN_MontoMin = new TextField("Monto Mínimo Producto");
    public final TextField txtPROMN_MontoDescu = new TextField("Monto Descuento");
    
    public final HorizontalLayout layPROMN_part1 = new HorizontalLayout(txtPROMN_Prefijo,txtPROMN_Nombre,chckPROMN_Activa,
                                                                               txtPROMN_MontoMin,txtPROMN_MontoDescu);
    //-----------------------------------------------------------------------------------------------
    //NUEVA PROMOCION: Fecha Fin Vigencia / N° de dias de vigencia
    //-----------------------------------------------------------------------------------------------
    public final Checkbox chckPROMN_CheckFVigencia = new Checkbox("Fecha Fin Vigencia?");
    public final DatePicker datePROMN_FinVigencia = new DatePicker("Fecha Fin Vigencia");
    public final TextField txtPROMN_DiasVigencia = new TextField("Días Vigencia");
    
    public final HorizontalLayout layPROMN_part2 = new HorizontalLayout(chckPROMN_CheckFVigencia,datePROMN_FinVigencia,txtPROMN_DiasVigencia);
    //-----------------------------------------------------------------------------------------------
    //public final Checkbox chckPROMN_CheckDVigencia = new Checkbox("Dias Vigencia?");
    //public final TextField txtPROMN_DiasVigencia = new TextField("Días Vigencia");
    
    //public final HorizontalLayout layPROMN_part2_2 = new HorizontalLayout(chckPROMN_CheckDVigencia,txtPROMN_DiasVigencia);
    //-----------------------------------------------------------------------------------------------
    //NUEVA PROMOCION: Cargar Imagen Promoción
    //-----------------------------------------------------------------------------------------------
    public final MemoryBuffer bufferPROMN = new MemoryBuffer();
    public final Upload uploadPROMN = new Upload(bufferPROMN);
    //-----------------------------------------------------------------------------------------------
    public final Label lbtitImgPROMN = new Label("IMAGEN PROMOCION");
    public final HorizontalLayout layTImgPROMN = new HorizontalLayout(lbtitImgPROMN);
    //-----------------------------------------------------------------------------------------------
    //NUEVA PROMOCION: Imagen
    //-----------------------------------------------------------------------------------------------
    public final Image imgPROMN = new Image();
    public final TextField txtUrlPROMN = new TextField("Url Imagen");
    public final Button btnUploadPROMN = new Button("Cargar Imagen");
    public final Button btnBorrarPROMN = new Button("Descartar Imagen");
    //-----------------------------------------------------------------------------------------------
    public final HorizontalLayout layimgPROMN = new HorizontalLayout(imgPROMN);
    public final HorizontalLayout layUrlPROMN = new HorizontalLayout(txtUrlPROMN);
    public final HorizontalLayout layUploadPROMN = new HorizontalLayout(uploadPROMN,btnBorrarPROMN);
    
    public final VerticalLayout layPROMN_part3 = new VerticalLayout(layTImgPROMN,layimgPROMN,layUrlPROMN,
                                                                    layUploadPROMN);
    //-----------------------------------------------------------------------------------------------
    //NUEVA PROMOCION: Foot
    //-----------------------------------------------------------------------------------------------
    public final Button btnGuardarPROMN = new Button("Guardar Cambios");
    public final Button btnExitPROMN = new Button("Cancelar");
    
    public final HorizontalLayout layFootPROMN = new HorizontalLayout(btnGuardarPROMN,btnExitPROMN);
    //-----------------------------------------------------------------------------------------------
    //NUEVA PROMOCION: LAYOUT TOTAL
    public final VerticalLayout layTotalPROMN = new VerticalLayout(layTitPROMN_titulo,layPROMN_part1,layPROMN_part2,
                                                                   layPROMN_part3,layFootPROMN);
    //------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------
    //NUEVA PROMOCION: CREACION DIALOG
    public final Dialog dialog_PromoNew = new Dialog(layTotalPROMN);
    //------------------------------------------------------------------------------------------------
    //NUEVA PROMOCION: NOTIFICATION
    //-----------------------------------------------------------------------------------------------
    public final Label notf_CreatePROMN = new Label("La promoción ha sido Creada");
    
    public final Notification notifyCreatePROMN = new Notification(notf_CreatePROMN);
    //------------------------------------------------------------------------------------------------
    //END DIALOG NUEVA PROMOCION 
    //------------------------------------------------------------------------------------------------   
    
    
    
    //------------------------------------------------------------------------------------------------
    //DIALOG ASIGNAR MONTO
    //------------------------------------------------------------------------------------------------
    //ASIGNAR MONTO: TITULO GENERAL
    //-----------------------------------------------------------------------------------------------
    public final Label lbASIGNM_titulo = new Label("ASIGNAR MONTO PROMOCIONES");
    public final HorizontalLayout layTitASIGNM_titulo  = new HorizontalLayout(lbPROMN_titulo);
    //------------------------------------------------------------------------------------------------
    //CUERPO DIALOG
    //----------------------------------------------------------------------------------------------------
    //ASIGNAR MONTO: Monto Min/Monto Descu
    //-----------------------------------------------------------------------------------------------
    public final TextField txtASIGNM_MontoMin = new TextField("Monto Mínimo Producto");
    public final TextField txtASIGNM_MontoDescu = new TextField("Monto Descuento");
    
    public final HorizontalLayout layASIGNM_Monto = new HorizontalLayout(txtASIGNM_MontoMin,txtASIGNM_MontoDescu);
    //-----------------------------------------------------------------------------------------------
    //ASIGNAR MONTO: Foot
    //-----------------------------------------------------------------------------------------------
    public final Button btnGuardarASIGNM = new Button("Guardar Cambios");
    public final Button btnExitASIGNM = new Button("Cancelar");
    
    public final HorizontalLayout layFootASIGNM = new HorizontalLayout(btnGuardarASIGNM,btnExitASIGNM);
    //-----------------------------------------------------------------------------------------------
    //ASIGNAR MONTO: LAYOUT TOTAL
    public final VerticalLayout layTotalASIGNM = new VerticalLayout(layTitASIGNM_titulo,layASIGNM_Monto,layFootASIGNM);
    //------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------
    //ASIGNAR MONTO: CREACION DIALOG
    public final Dialog dialog_AsignMonto = new Dialog(layTotalASIGNM);
    //------------------------------------------------------------------------------------------------
    //ASIGNAR MONTO: NOTIFICATION
    //-----------------------------------------------------------------------------------------------
    public final Label notf_AsignarASIGNM = new Label("El monto min y descuento han sido asignados");
    
    public final Notification notifyAsignarASIGNM = new Notification(notf_CreatePROMN);
    //------------------------------------------------------------------------------------------------
    //END DIALOG ASIGNAR MONTO
    //------------------------------------------------------------------------------------------------  
    
    
    
    //------------------------------------------------------------------------------------------------
    //INIT PromocionesUI
    //------------------------------------------------------------------------------------------------
    public PromocionesUI() {
        removeAll();
        addAndExpand(layCPanelButtons,layCPanelButtons2, head, lay_Busquedas, layBttnVer_Prod, layInformation, layGrid,fButtons);
        btnFind_Activo.addClickListener(e->On_find_PromoActiva());
        btnFind_Inactivo.addClickListener(e->On_find_PromoInactiva());
        initStyles();
        initEvents();
        setSizeFull();
    }
    //----------------------------------------------------------------------------------------------------
    
    //----------------------------------------------------------------------------------------------------
    //STYLES
    //----------------------------------------------------------------------------------------------------
    private void initStyles() {
        //------------------------------------------------------------------------------------------------
        //CABECERA CPANEL
        //------------------------------------------------------------------------------------------------
        btnClientes.setWidthFull();
        btnClientes.getStyle().set("fontSize","80%");
        
        btnSubscriptores.setWidthFull();
        btnSubscriptores.getStyle().set("fontSize","80%");
        
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
        
        //------------------------------------------------------------------------------------------------
        // HEAD
        //------------------------------------------------------------------------------------------------
        titulo.getStyle().set("fontWeight","bold");
        titulo.getStyle().set("fontSize","300%");
        //------------------------------------------------------------------------------------------------
        head.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        head.setWidthFull();
        //-----------------------------------------------------------------------------------------------
        //-----------------------------------------------------------------------------------------------
        // WORKSPACE
        //-----------------------------------------------------------------------------------------------
        //-----------------------------------------------------------------------------------------------
        // BUSQUEDAS
        //-----------------------------------------------------------------------------------------------
        titulo_buscar.getStyle().set("fontWeight","bold");
        titulo_buscar.getStyle().set("fontSize","150%");
        
        lay_titulo_bus.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        lay_titulo_bus.setWidthFull(); 
        //-----------------------------------------------------------------------------------------------
        //BUSQUEDA PROMOCION - ACTIVO/INACTIVO 

        btnFind_Activo.addThemeVariants(ButtonVariant.LUMO_SUCCESS); 
        btnFind_Activo.getStyle().set("fontSize","90%");
        
        btnFind_Inactivo.addThemeVariants(ButtonVariant.LUMO_ERROR); 
        btnFind_Inactivo.getStyle().set("fontSize","90%");

        lay_Find_Act_Inact.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        lay_Find_Act_Inact.setAlignItems(FlexComponent.Alignment.BASELINE);
        lay_Find_Act_Inact.setWidthFull();
        //----------------------------------------------------------------------------------------------------
        //LAYOUT FINAL

        lay_Busquedas.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        lay_Busquedas.setAlignItems(FlexComponent.Alignment.CENTER);
        lay_Busquedas.setWidthFull(); 
        //----------------------------------------------------------------------------------------------------
        //----------------------------------------------------------------------------------------------------
        //GRID - BODY
        //----------------------------------------------------------------------------------------------------
        grid_Promo.addColumn(Promociones::getTitulo).setAutoWidth(true).setSortable(true).setHeader("Titulo Promoción");
        grid_Promo.addColumn(Promociones::getActivo).setAutoWidth(true).setSortable(true).setHeader("Activada?");
        grid_Promo.addColumn(Promociones::getUrl_img).setAutoWidth(true).setSortable(true).setHeader("Url Imagen");
        //grid_Promo.addColumn(Promociones::getCupon).setAutoWidth(true).setSortable(true).setHeader("Cupon");
        grid_Promo.addColumn(Promociones::getMonto_min).setAutoWidth(true).setSortable(true).setHeader("Monto Mínimo");
        grid_Promo.addColumn(Promociones::getCupon_monto).setAutoWidth(true).setSortable(true).setHeader("Cupon Monto");
        //------------------------------------------------------------------------------------------------
        grid_Promo.setSelectionMode(Grid.SelectionMode.MULTI);
        
        MultiSelect<Grid<Promociones>, Promociones> multiSelect = grid_Promo.asMultiSelect();
        //------------------------------------------------------------------------------------------------
        layGrid.getStyle().set("border", "1px solid #9E9E9E");
        layGrid.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layGrid.setAlignItems(FlexComponent.Alignment.CENTER);
        layGrid.setWidthFull();
        //----------------------------------------------------------------------------------------------------
        //INFORMATION
        lbInformation.getStyle().set("color", "red");
        lbInformation.getStyle().set("fontStyle","italic");
        lbInformation.getStyle().set("fontSize","80%");
        
        layInformation.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        layInformation.setAlignItems(FlexComponent.Alignment.CENTER);
        layInformation.setWidthFull();
        //----------------------------------------------------------------------------------------------------
        btnver_prod.getStyle().set("fontSize","90%");
        
        layBttnVer_Prod.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        layBttnVer_Prod.setAlignItems(FlexComponent.Alignment.CENTER);
        //-----------------------------------------------------------------------------------------------
        //----------------------------------------------------------------------------------------------------
        //FOOT - BOTONES DE ACCION FINAL
        //----------------------------------------------------------------------------------------------------
        btnNewPromo.getStyle().set("fontSize","90%");
        btnChange_Activo.getStyle().set("fontSize","90%");
        btnChange_Inactivo.getStyle().set("fontSize","90%");
        btnAsignar_Monto.getStyle().set("fontSize","90%");
        btnExit.getStyle().set("fontSize","90%");
        btnExit.addThemeVariants(ButtonVariant.LUMO_ERROR); 
        
        fButtons.getStyle().set("border", "1px solid #9E9E9E");
        fButtons.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        fButtons.setAlignItems(FlexComponent.Alignment.CENTER);
        fButtons.setWidthFull();
        //----------------------------------------------------------------------------------------------------
        //NOTIFICACION
        //----------------------------------------------------------------------------------------------------
        notf_select_exceed.getStyle().set("fontSize","90%");
        notf_select_exceed.getStyle().set("color", "red");
        
        notify_select_exceed.setDuration(2500);
        notify_select_exceed.setPosition(Notification.Position.MIDDLE);
        //----------------------------------------------------------------------------------------------------
        //END MAIN VIEW
        //----------------------------------------------------------------------------------------------------
        
        
        //------------------------------------------------------------------------------------------------
        //DIALOG PROMOCION EXISTENTE
        //------------------------------------------------------------------------------------------------
        //TITULO GENERAL
        //-----------------------------------------------------------------------------------------------
        lbPROME_titulo.getStyle().set("fontWeight","bold");
        lbPROME_titulo.getStyle().set("fontSize","150%"); 
        
        layTitPROME_titulo.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layTitPROME_titulo.setAlignItems(FlexComponent.Alignment.CENTER);
        layTitPROME_titulo.setWidthFull();
        //------------------------------------------------------------------------------------------------
        //CUERPO DIALOG
        //----------------------------------------------------------------------------------------------------
        //PROMOCION EXISTENTE: Nombre/Activo/Monto Min/Monto Descu
        //-----------------------------------------------------------------------------------------------
        txtPROME_Prefijo.setWidthFull();
        txtPROME_Prefijo.addValueChangeListener(event->{
            if(!event.getValue().isEmpty()){
                txtPROME_Nombre.setValue(txtPROME_Nombre.getValue() + txtPROME_Prefijo.getValue());
            }
        });
        txtPROME_Nombre.setWidthFull();
        chckPROME_Activa.setWidthFull();
        txtPROME_MontoMin.setWidthFull();
        txtPROME_MontoDescu.setWidthFull();

        layPROMOE_part1.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        layPROMOE_part1.setAlignItems(FlexComponent.Alignment.BASELINE);
        layPROMOE_part1.setWidthFull();
        //-----------------------------------------------------------------------------------------------
        //PROMOCION EXISTENTE: Fecha Fin Vigencia / N° de dias de vigencia
        //-----------------------------------------------------------------------------------------------
        //chckPROME_CheckFVigencia.setWidthFull();
        chckPROME_CheckFVigencia.addValueChangeListener(event->{
            if(event.getValue().booleanValue() == Boolean.TRUE){
                txtPROME_DiasVigencia.setReadOnly(true);
                datePROMOE_FinVigencia.setReadOnly(false);
            }
            if(event.getValue().booleanValue() == Boolean.FALSE){
                datePROMOE_FinVigencia.setReadOnly(true);
                txtPROME_DiasVigencia.setReadOnly(false);
            }
        });
        //datePROMOE_FinVigencia.setWidthFull();
        //txtPROME_DiasVigencia.setWidthFull(); 

        layPROMOE_part2.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        layPROMOE_part2.setAlignItems(FlexComponent.Alignment.BASELINE);
        layPROMOE_part2.setWidthFull();
        
        //-----------------------------------------------------------------------------------------------
        //PROMOCION EXISTENTE: Cargar Imagen Promoción
        //-----------------------------------------------------------------------------------------------
        uploadPROMOE.setAutoUpload(true);
        uploadPROMOE.setDropAllowed(false);
        uploadPROMOE.setUploadButton(btnUploadPROMOE);
        //-----------------------------------------------------------------------------------------------
        lbtitImgPROMOE.getStyle().set("fontWeight","bold");
        lbtitImgPROMOE.getStyle().set("fontSize","130%"); 
                
        layTImgPROMOE.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        layTImgPROMOE.setAlignItems(FlexComponent.Alignment.CENTER);
        layTImgPROMOE.setWidthFull();
        //-----------------------------------------------------------------------------------------------
        //PROMOCION EXISTENTE: Imagen
        //-----------------------------------------------------------------------------------------------
        imgPROMOE.setVisible(true);
        imgPROMOE.setEnabled(true);
        imgPROMOE.setHeight("200px");
        imgPROMOE.setWidth("350px");
        
        txtUrlPROMOE.setWidthFull();
        
        btnUploadPROMOE.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        btnUploadPROMOE.getStyle().set("fontSize","90%");
        
        btnBorrarPROMOE.addThemeVariants(ButtonVariant.LUMO_ERROR);
        btnBorrarPROMOE.getStyle().set("fontSize","90%"); 
        //-----------------------------------------------------------------------------------------------
        layimgPROMOE.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layimgPROMOE.setAlignItems(FlexComponent.Alignment.BASELINE);
        layimgPROMOE.setWidthFull(); 
        
        layUrlPROMOE.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layUrlPROMOE.setAlignItems(FlexComponent.Alignment.BASELINE);
        layUrlPROMOE.setWidthFull(); 
        
        layUploadPROMOE.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layUploadPROMOE.setAlignItems(FlexComponent.Alignment.BASELINE);
        layUploadPROMOE.setWidthFull();  

        layPROMOE_part3.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layPROMOE_part3.setAlignItems(FlexComponent.Alignment.CENTER);
        layPROMOE_part3.setWidthFull();
        //-----------------------------------------------------------------------------------------------
        //PROMOCION EXISTENTE: Foot
        //-----------------------------------------------------------------------------------------------
        btnGuardarPROMOE.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        btnGuardarPROMOE.getStyle().set("fontSize","90%");
        
        btnEliminarPROMOE.addThemeVariants(ButtonVariant.LUMO_ERROR);
        btnEliminarPROMOE.getStyle().set("fontSize","90%");
        
        btnExitPROMOE.getStyle().set("fontSize","90%"); 

        layFootPROMOE.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layFootPROMOE.setAlignItems(FlexComponent.Alignment.CENTER);
        layFootPROMOE.setWidthFull(); 
        //-----------------------------------------------------------------------------------------------
        //PROMOCION EXISTENTE: LAYOUT TOTAL
        //-----------------------------------------------------------------------------------------------
        layTotalPROMOE.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layTotalPROMOE.setAlignItems(FlexComponent.Alignment.CENTER);
        layTotalPROMOE.setWidthFull();  
        //------------------------------------------------------------------------------------------------
        //------------------------------------------------------------------------------------------------
        //PROMOCION EXISTENTE: CREACION DIALOG
        //------------------------------------------------------------------------------------------------
        dialog_PromoExist.setCloseOnEsc(true);
        dialog_PromoExist.setCloseOnOutsideClick(true);
        //------------------------------------------------------------------------------------------------
        //PROMOCION EXISTENTE: NOTIFICATION
        //-----------------------------------------------------------------------------------------------
        notf_UpdatePROMOE.getStyle().set("fontSize","90%");
        notf_UpdatePROMOE.getStyle().set("color", "green");
        notf_DeletePROMOE.getStyle().set("fontSize","90%");
        notf_DeletePROMOE.getStyle().set("color", "red");
        
        
        notifyUpdatePROMOE.setDuration(2500);
        notifyUpdatePROMOE.setPosition(Notification.Position.MIDDLE);
        notifyDeletePROMOE.setDuration(2500);
        notifyDeletePROMOE.setPosition(Notification.Position.MIDDLE); 
        //------------------------------------------------------------------------------------------------
        //END DIALOG PROMOCION EXISTENTE 
        //------------------------------------------------------------------------------------------------
        
        
        
        //------------------------------------------------------------------------------------------------
        //DIALOG NUEVA PROMOCION
        //------------------------------------------------------------------------------------------------
        //NUEVA PROMOCION: TITULO GENERAL
        //-----------------------------------------------------------------------------------------------
        lbPROMN_titulo.getStyle().set("fontWeight","bold");
        lbPROMN_titulo.getStyle().set("fontSize","150%"); 
        
        layTitPROMN_titulo.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layTitPROMN_titulo.setAlignItems(FlexComponent.Alignment.CENTER);
        layTitPROMN_titulo.setWidthFull();
        //------------------------------------------------------------------------------------------------
        //CUERPO DIALOG
        //----------------------------------------------------------------------------------------------------
        //NUEVA PROMOCION: Nombre/Activo/Monto Min/Monto Descu
        //-----------------------------------------------------------------------------------------------
        txtPROMN_Prefijo.setWidthFull();
        txtPROMN_Prefijo.addValueChangeListener(event->{
            if(!event.getValue().isEmpty()){
                txtPROMN_Nombre.setValue(txtPROMN_Nombre.getValue() + txtPROMN_Prefijo.getValue());
            }
        });
        txtPROMN_Nombre.setWidthFull();
        chckPROMN_Activa.setWidthFull();
        txtPROMN_MontoMin.setWidthFull();
        txtPROMN_MontoDescu.setWidthFull();

        layPROMN_part1.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        layPROMN_part1.setAlignItems(FlexComponent.Alignment.BASELINE);
        layPROMN_part1.setWidthFull();
        //-----------------------------------------------------------------------------------------------
        //NUEVA PROMOCION: Fecha Fin Vigencia / N° de dias de vigencia
        //-----------------------------------------------------------------------------------------------
        //chckPROMN_CheckFVigencia.setWidthFull();
        chckPROMN_CheckFVigencia.addValueChangeListener(event->{
            if(event.getValue().booleanValue() == Boolean.TRUE){
                txtPROMN_DiasVigencia.setReadOnly(true);
                datePROMN_FinVigencia.setReadOnly(false);
            }
            if(event.getValue().booleanValue() == Boolean.FALSE){
                datePROMN_FinVigencia.setReadOnly(true);
                txtPROMN_DiasVigencia.setReadOnly(false);
            }
        });
        
        //datePROMN_FinVigencia.setWidthFull();
        //txtPROMN_DiasVigencia.setWidthFull(); 

        layPROMN_part2.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        layPROMN_part2.setAlignItems(FlexComponent.Alignment.BASELINE);
        layPROMN_part2.setWidthFull();
        
        //-----------------------------------------------------------------------------------------------
        //NUEVA PROMOCION: Cargar Imagen Promoción
        //-----------------------------------------------------------------------------------------------
        uploadPROMN.setAutoUpload(true);
        uploadPROMN.setDropAllowed(false);
        uploadPROMN.setUploadButton(btnUploadPROMN);
        //-----------------------------------------------------------------------------------------------
        lbtitImgPROMN.getStyle().set("fontWeight","bold");
        lbtitImgPROMN.getStyle().set("fontSize","130%"); 
                
        layTImgPROMN.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        layTImgPROMN.setAlignItems(FlexComponent.Alignment.CENTER);
        layTImgPROMN.setWidthFull();
        //-----------------------------------------------------------------------------------------------
        //NUEVA PROMOCION: Imagen
        //-----------------------------------------------------------------------------------------------
        imgPROMN.setVisible(true);
        imgPROMN.setEnabled(true);
        imgPROMN.setHeight("200px");
        imgPROMN.setWidth("350px"); 
        
        txtUrlPROMN.setWidthFull();
        
        btnUploadPROMN.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        btnUploadPROMN.getStyle().set("fontSize","90%");
        
        btnBorrarPROMN.addThemeVariants(ButtonVariant.LUMO_ERROR);
        btnBorrarPROMN.getStyle().set("fontSize","90%"); 
        //-----------------------------------------------------------------------------------------------
        layimgPROMN.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layimgPROMN.setAlignItems(FlexComponent.Alignment.BASELINE);
        layimgPROMN.setWidthFull(); 
        
        layUrlPROMN.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layUrlPROMN.setAlignItems(FlexComponent.Alignment.BASELINE);
        layUrlPROMN.setWidthFull(); 
        
        layUploadPROMN.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layUploadPROMN.setAlignItems(FlexComponent.Alignment.BASELINE);
        layUploadPROMN.setWidthFull();  

        layPROMN_part3.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layPROMN_part3.setAlignItems(FlexComponent.Alignment.CENTER);
        layPROMN_part3.setWidthFull();
        //-----------------------------------------------------------------------------------------------
        //NUEVA PROMOCION: Foot
        //-----------------------------------------------------------------------------------------------
        btnGuardarPROMN.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        btnGuardarPROMN.getStyle().set("fontSize","90%");
        
        btnExitPROMN.addThemeVariants(ButtonVariant.LUMO_ERROR);
        btnExitPROMN.getStyle().set("fontSize","90%"); 

        layFootPROMN.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layFootPROMN.setAlignItems(FlexComponent.Alignment.CENTER);
        layFootPROMN.setWidthFull(); 
        //-----------------------------------------------------------------------------------------------
        //NUEVA PROMOCION: LAYOUT TOTAL
        //-----------------------------------------------------------------------------------------------
        layTotalPROMN.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layTotalPROMN.setAlignItems(FlexComponent.Alignment.CENTER);
        layTotalPROMN.setWidthFull();  
        //------------------------------------------------------------------------------------------------
        //------------------------------------------------------------------------------------------------
        //NUEVA PROMOCION: CREACION DIALOG
        //------------------------------------------------------------------------------------------------
        dialog_PromoNew.setCloseOnEsc(true);
        dialog_PromoNew.setCloseOnOutsideClick(true);
        //------------------------------------------------------------------------------------------------
        //NUEVA PROMOCION: NOTIFICATION
        //-----------------------------------------------------------------------------------------------
        notf_CreatePROMN.getStyle().set("fontSize","90%");
        notf_CreatePROMN.getStyle().set("color", "green");
        
        notifyCreatePROMN.setDuration(2500);
        notifyCreatePROMN.setPosition(Notification.Position.MIDDLE); 
        //------------------------------------------------------------------------------------------------
        //END DIALOG NUEVA PROMOCION
        //------------------------------------------------------------------------------------------------
        
        
        
        
        //------------------------------------------------------------------------------------------------
        //DIALOG ASIGNAR MONTO
        //------------------------------------------------------------------------------------------------
        //ASIGNAR MONTO: TITULO GENERAL
        //-----------------------------------------------------------------------------------------------
        lbASIGNM_titulo.getStyle().set("fontWeight","bold");
        lbASIGNM_titulo.getStyle().set("fontSize","150%"); 
        
        layTitASIGNM_titulo.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layTitASIGNM_titulo.setAlignItems(FlexComponent.Alignment.CENTER);
        layTitASIGNM_titulo.setWidthFull();
        //------------------------------------------------------------------------------------------------
        //CUERPO DIALOG
        //----------------------------------------------------------------------------------------------------
        //ASIGNAR MONTO: Monto Min/Monto Descu
        //-----------------------------------------------------------------------------------------------
        txtASIGNM_MontoMin.setWidthFull();
        txtASIGNM_MontoDescu.setWidthFull();

        layASIGNM_Monto.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        layASIGNM_Monto.setAlignItems(FlexComponent.Alignment.BASELINE);
        layASIGNM_Monto.setWidthFull(); 
        //-----------------------------------------------------------------------------------------------
        //ASIGNAR MONTO: Foot
        //-----------------------------------------------------------------------------------------------
        btnGuardarASIGNM.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        btnGuardarASIGNM.getStyle().set("fontSize","90%");
        
        btnExitASIGNM.addThemeVariants(ButtonVariant.LUMO_ERROR);
        btnExitASIGNM.getStyle().set("fontSize","90%"); 

        layFootASIGNM.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layFootASIGNM.setAlignItems(FlexComponent.Alignment.CENTER);
        layFootASIGNM.setWidthFull();
        //-----------------------------------------------------------------------------------------------
        //ASIGNAR MONTO: LAYOUT TOTAL
        layTotalASIGNM.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layTotalASIGNM.setAlignItems(FlexComponent.Alignment.CENTER);
        layTotalASIGNM.setWidthFull(); 
        //------------------------------------------------------------------------------------------------
        //------------------------------------------------------------------------------------------------
        //ASIGNAR MONTO: CREACION DIALOG
        dialog_AsignMonto.setCloseOnEsc(true);
        dialog_AsignMonto.setCloseOnOutsideClick(true); 
        //------------------------------------------------------------------------------------------------
        //ASIGNAR MONTO: NOTIFICATION
        //-----------------------------------------------------------------------------------------------
        notf_AsignarASIGNM.getStyle().set("fontSize","90%");
        notf_AsignarASIGNM.getStyle().set("color", "green");
        
        notifyAsignarASIGNM.setDuration(2500);
        notifyAsignarASIGNM.setPosition(Notification.Position.MIDDLE);
        //------------------------------------------------------------------------------------------------
        //END DIALOG ASIGNAR MONTO
        //------------------------------------------------------------------------------------------------
    }
    
    
    //----------------------------------------------------------------------------------------------------
    //FUNCIONES
    //----------------------------------------------------------------------------------------------------
    //CPANEL RUTAS
    //----------------------------------------------------------------------------------------------------
    public abstract void go_CPanel();
    
    public abstract void go_Clientes();
    public abstract void go_Subscriptores();
    public abstract void go_Cupones();
    public abstract void go_PuntosUP();
    
    public abstract void go_Pedidos();
    public abstract void go_LineasEcom();
    public abstract void go_Productos();
    public abstract void go_Index();
    
    //----------------------------------------------------------------------------------------------------
    //BUSQUEDAS
    //----------------------------------------------------------------------------------------------------
    public abstract void On_find_PromoActiva();
    public abstract void On_find_PromoInactiva();
    
    //----------------------------------------------------------------------------------------------------
    //MAIN VIEW
    //----------------------------------------------------------------------------------------------------
    public abstract void On_Click_ActivarPromos();
    public abstract void On_Click_DesactivarPromos();
    public abstract void On_Click_AsignMonto();
    //----------------------------------------------------------------------------------------------------
    
    //----------------------------------------------------------------------------------------------------
    //DIALOG PROMOCION EXISTENTE 
    //----------------------------------------------------------------------------------------------------
    public abstract void On_Open_PromoExist();
    public abstract void On_Upload_ImgPromoExist(SucceededEvent event);
    public abstract void On_Discard_ImgPromoExist();
    public abstract void On_Update_PromoExist();
    public abstract void On_Delete_PromoExist();
    //----------------------------------------------------------------------------------------------------
    
    
    //----------------------------------------------------------------------------------------------------
    //DIALOG NUEVA PROMOCION
    //----------------------------------------------------------------------------------------------------
    public abstract void On_Open_PromoNew();
    public abstract void On_Upload_ImgPromoNew(SucceededEvent event);
    public abstract void On_Discard_ImgPromoNew();
    public abstract void On_Create_PromoNew();
    //----------------------------------------------------------------------------------------------------
    
    
    
    //------------------------------------------------------------------------------------------------
    //DIALOG ASIGNAR MONTO
    //------------------------------------------------------------------------------------------------
    public abstract void On_Update_AsignMonto();
    //------------------------------------------------------------------------------------------------
    
    
    //----------------------------------------------------------------------------------------------------
    //EVENTS
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
        
        //------------------------------------------------------------------------------------------------
        //MAIN VIEW
        //------------------------------------------------------------------------------------------------
        //------------------------------------------------------------------------------------------------
        //FOOT - FINAL BUTTONS
        //------------------------------------------------------------------------------------------------
        //FOOT - Activar Promociones
        btnChange_Activo.addClickListener(e->{
            On_Click_ActivarPromos();
        });
        //FOOT - Desactivar Promociones
        btnChange_Inactivo.addClickListener(e->{
            On_Click_DesactivarPromos();
        });
        //FOOT - Asignar Monto Promociones
        btnAsignar_Monto.addClickListener(e->{
            On_Click_AsignMonto();
        });
        //FOOT - Exit
        btnExit.addClickListener(e->{
            removeAll();
            go_CPanel();
        });
        //------------------------------------------------------------------------------------------------
        
        //------------------------------------------------------------------------------------------------
        //DIALOG PROMOCION EXISTENTE 
        //------------------------------------------------------------------------------------------------
        btnver_prod.addClickListener(e->{
            On_Open_PromoExist();
        });
        
        uploadPROMOE.addSucceededListener(this::On_Upload_ImgPromoExist);

        btnBorrarPROMOE.addClickListener(e->{
            On_Discard_ImgPromoExist();
        });
        btnGuardarPROMOE.addClickListener(e->{
            On_Update_PromoExist();
        }); 
        btnEliminarPROMOE.addClickListener(e->{
            On_Delete_PromoExist();
        }); 
        btnExitPROMOE.addClickListener(e->{
            dialog_PromoExist.close();
        });
        //------------------------------------------------------------------------------------------------
        
        //------------------------------------------------------------------------------------------------
        //DIALOG NUEVA PROMOCION
        //------------------------------------------------------------------------------------------------
        btnNewPromo.addClickListener(e->{
            On_Open_PromoNew();
        });
        uploadPROMN.addSucceededListener(this::On_Upload_ImgPromoNew);
        btnBorrarPROMN.addClickListener(e->{
            On_Discard_ImgPromoNew();
        });
        btnGuardarPROMN.addClickListener(e->{
            On_Create_PromoNew();
        }); 
        btnExitPROMN.addClickListener(e->{
            dialog_PromoNew.close();
        });
        //------------------------------------------------------------------------------------------------
        
        
        //------------------------------------------------------------------------------------------------
        //DIALOG ASIGNAR MONTO
        //------------------------------------------------------------------------------------------------
        btnGuardarPROMN.addClickListener(e->{
            On_Update_AsignMonto();
        });
        
        btnExitPROMN.addClickListener(e->{
            dialog_AsignMonto.close();
        });
        //------------------------------------------------------------------------------------------------
        
    }
    
}
