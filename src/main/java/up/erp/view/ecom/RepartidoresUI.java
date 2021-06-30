/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.view.ecom;

import com.upgrade.persistence.model.ecommerce.PedidoEcommerce;
import com.upgrade.persistence.model.ecommerce.UsuarioWeb;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.selection.MultiSelect;
import java.time.LocalDate;
import up.erp.view.App;

/**
 *
 * @author Luis Aleman
 */
public abstract class RepartidoresUI extends VerticalLayout{
    
    //-----------------------------------------------------------------------------------------------
    //MAIN VIEW
    //-----------------------------------------------------------------------------------------------
    // HEADER
    //-----------------------------------------------------------------------------------------------
    public final Label titulo = new Label("PEDIDOS E-COMMERCE");
    public final HorizontalLayout head = new HorizontalLayout(titulo);
    //-----------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------
    // WORKSPACE
    //-----------------------------------------------------------------------------------------------
    //BUSQUEDAS
    //-----------------------------------------------------------------------------------------------
    public final Label titulo_buscar = new Label("BUSQUEDA DE PEDIDOS POR ENTREGAR");
    public final HorizontalLayout lay_titulo_bus = new HorizontalLayout(titulo_buscar);
    //-----------------------------------------------------------------------------------------------
    public final TextField txtInput_NOrden = new TextField("Numero Orden:");
    public final Button btnFind_Ped_NOrden = new Button("Buscar");
    
    public final HorizontalLayout lay_NOrden_bus = new HorizontalLayout(txtInput_NOrden,btnFind_Ped_NOrden);
    //-----------------------------------------------------------------------------------------------
    public final Label lb_all_bus = new Label("Buscar más recientes");
    public final Button btnFind_Ped = new Button("Buscar");
    
    public final HorizontalLayout lay_All_bus = new HorizontalLayout(lb_all_bus,btnFind_Ped);
    //-----------------------------------------------------------------------------------------------
    public final DatePicker Fecha_ini_Bus = new DatePicker("Fecha Inicio");
    public final DatePicker Fecha_fin_Bus = new DatePicker("Fecha Fin");
    public final Button btnFind_Ped_Fecha = new Button("Buscar por Fecha");
    
    public final HorizontalLayout lay_Fecha_bus = new HorizontalLayout(Fecha_ini_Bus,Fecha_fin_Bus,btnFind_Ped_Fecha);
    //-----------------------------------------------------------------------------------------------
    public final VerticalLayout lay_Busquedas =  new VerticalLayout(lay_titulo_bus,lay_NOrden_bus,lay_All_bus);
    //-----------------------------------------------------------------------------------------------
    //TABLE - INFORMATION
    //-----------------------------------------------------------------------------------------------
    public final Grid<PedidoEcommerce> grid = new Grid<>();
    public final VerticalLayout layGrid = new VerticalLayout(grid);
    
    public final Label lbInformation = new Label("*Nota: Seleccione el Pedido antes de presionar botón Ver");
    public final HorizontalLayout layInformation = new HorizontalLayout(lbInformation);
    
    public final Button btnver_ped = new Button("Ver/Editar", VaadinIcon.EYE.create());
    public final HorizontalLayout layBttnVer_Prod = new HorizontalLayout(btnver_ped);
    //-----------------------------------------------------------------------------------------------
    //FOOTER
    //-----------------------------------------------------------------------------------------------
    public final Button btnExit = new Button("Salir");
    //-----------------------------------------------------------------------------------------------
    public final HorizontalLayout fButtons = new HorizontalLayout(btnExit);
    //-----------------------------------------------------------------------------------------------
    //END MAIN VIEW
    //-----------------------------------------------------------------------------------------------
    
    
    
    //--------------------------------------------------------------------------------------------------
    //DIALOG PEDIDO
    //--------------------------------------------------------------------------------------------------
    //TITULO
    //--------------------------------------------------------------------------------------------------
    public final Label titulo_dialog = new Label("DETALLES DEL PEDIDO");
    public final HorizontalLayout layTitulo_dialog = new HorizontalLayout(titulo_dialog);
    //--------------------------------------------------------------------------------------------------
    //DATOS GENERALES
    //--------------------------------------------------------------------------------------------------
    public final TextField txtdialog_NOrden = new TextField("Número de Orden");
    public final TextField txtdialog_TipoEntrega = new TextField("Tipo Entrega");
    public final ComboBox<String> comboBoxProds_byPed = new ComboBox<>();
    public final TextField txtdialog_Prods_byPed = new TextField("Producto");
    
    public final HorizontalLayout laydialog_Pedidodats = new HorizontalLayout(txtdialog_NOrden,txtdialog_TipoEntrega);
    public final HorizontalLayout laydialog_Pedidodats2 = new HorizontalLayout(comboBoxProds_byPed,txtdialog_Prods_byPed);
    //--------------------------------------------------------------------------------------------------
    //DATOS USUARIO
    //--------------------------------------------------------------------------------------------------
    public final Label titdetUsu_dialog = new Label("DATOS DEL USUARIO");
    public final HorizontalLayout layTitdetUsu_dialog = new HorizontalLayout(titdetUsu_dialog);
    //--------------------------------------------------------------------------------------------------
    public final TextField txtdialog_DirEcom = new TextField("Direccion del Usuario");
    public final TextField txtdialog_RefEcom = new TextField("Referencia");
    
    public final HorizontalLayout laydialog_DirEcom = new HorizontalLayout(txtdialog_DirEcom);
    public final HorizontalLayout laydialog_RefEcom = new HorizontalLayout(txtdialog_RefEcom);
    //--------------------------------------------------------------------------------------------------
    //REGISTRAR ENTREGA DEL PEDIDO
    //--------------------------------------------------------------------------------------------------
    public final Label titCambioEst_dialog = new Label("REGISTRAR ENTREGA DEL PEDIDO");
    public final HorizontalLayout layTitCambioEst_dialog = new HorizontalLayout(titCambioEst_dialog);
    //--------------------------------------------------------------------------------------------------
    public final Label lbRegistrarEntr_dialog = new Label("Se entregó el pedido?");
    public final Button btnConfirmarEntrega = new Button("Confirmar");
    public final TextField txtdialog_Estado = new TextField("Estado del Pedido");
    public final HorizontalLayout laydialog_RegistrarEntr = new HorizontalLayout(lbRegistrarEntr_dialog,btnConfirmarEntrega,txtdialog_Estado);
    //--------------------------------------------------------------------------------------------------
    public final Button btnSalirdialog = new Button("Salir");
    public final HorizontalLayout laydialog_Salirdialog = new HorizontalLayout(btnSalirdialog);
    //--------------------------------------------------------------------------------------------------
    //CREATE DIALOG PEDIDO
    //--------------------------------------------------------------------------------------------------
    public final VerticalLayout laydialogPedido = new VerticalLayout(   layTitulo_dialog,laydialog_Pedidodats,
                                                                        laydialog_DirEcom,laydialog_RefEcom,
                                                                        layTitCambioEst_dialog,laydialog_RegistrarEntr,
                                                                        laydialog_Salirdialog);
    //--------------------------------------------------------------------------------------------------
    public final Dialog dialogPedido = new Dialog(laydialogPedido);
    //--------------------------------------------------------------------------------------------------
    //NOTIFICATION PEDIDO
    //--------------------------------------------------------------------------------------------------
    public final Label Pedido_notf_correct = new Label("Entrega Registrada Correctamente");
    public final Notification Pedido_notify_correct = new Notification(Pedido_notf_correct);
    
    public final Label notf_select_exceed = new Label("Más de un Pedido ha sido seleccionado. Por favor, seleccione sólo uno");
    public final Notification notify_select_exceed = new Notification(notf_select_exceed);
    //--------------------------------------------------------------------------------------------------
    //END DIALOG PEDIDO
    //--------------------------------------------------------------------------------------------------
    
    //INIT MAIN PROCESS
    //-----------------------------------------------------------------------------------------------
    public RepartidoresUI() {
        add(head, lay_Busquedas, layGrid, layBttnVer_Prod, layInformation, fButtons);
        btnFind_Ped_NOrden.addClickListener(e->On_find_NOrdenPed());
        btnFind_Ped.addClickListener(e->On_find_AllPed());
        btnFind_Ped_Fecha.addClickListener(e->On_find_FechaPed());
        initStyles();
        initEvents();
    }
    
    //-----------------------------------------------------------------------------------------------
    private void initStyles() {
        
        //-----------------------------------------------------------------------------------------------
        //MAIN VIEW
        //-----------------------------------------------------------------------------------------------
        // HEADER
        //-----------------------------------------------------------------------------------------------
        titulo.getStyle().set("fontWeight","bold");
        titulo.getStyle().set("fontSize","150%");
        titulo.getStyle().set("color", "lime");
        
        head.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        head.setWidthFull();
        //-----------------------------------------------------------------------------------------------
        //-----------------------------------------------------------------------------------------------
        // WORKSPACE
        //-----------------------------------------------------------------------------------------------
        //BUSQUEDAS
        //-----------------------------------------------------------------------------------------------
        titulo_buscar.getStyle().set("fontWeight","bold");
        titulo_buscar.getStyle().set("fontSize","80%"); 
        
        lay_titulo_bus.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        lay_titulo_bus.setWidthFull(); 
        //-----------------------------------------------------------------------------------------------
        txtInput_NOrden.getStyle().set("fontSize","70%");  
        btnFind_Ped_NOrden.addThemeVariants(ButtonVariant.LUMO_SMALL);
        btnFind_Ped_NOrden.getStyle().set("fontSize","70%"); 
    
        lay_NOrden_bus.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        lay_NOrden_bus.setAlignItems(FlexComponent.Alignment.BASELINE);
        lay_NOrden_bus.setWidthFull();
        //-----------------------------------------------------------------------------------------------
        lb_all_bus.getStyle().set("fontSize","70%");  
        
        btnFind_Ped.addThemeVariants(ButtonVariant.LUMO_SMALL);
        btnFind_Ped.getStyle().set("fontSize","70%"); 

        lay_All_bus.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        lay_All_bus.setAlignItems(FlexComponent.Alignment.BASELINE);
        lay_All_bus.setWidthFull(); 
        //-----------------------------------------------------------------------------------------------
        LocalDate actual_date = LocalDate.now();
        
        Fecha_ini_Bus.setValue(actual_date); 
        Fecha_fin_Bus.setValue(actual_date);
        
        btnFind_Ped_Fecha.addThemeVariants(ButtonVariant.LUMO_SMALL);
        btnFind_Ped_Fecha.getStyle().set("fontSize","70%"); 

        lay_Fecha_bus.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        lay_Fecha_bus.setAlignItems(FlexComponent.Alignment.BASELINE);
        lay_Fecha_bus.setWidthFull(); 
        //-----------------------------------------------------------------------------------------------
        lay_Busquedas.getStyle().set("border", "1px solid #9E9E9E");
        lay_Busquedas.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        lay_Busquedas.setAlignItems(FlexComponent.Alignment.CENTER);
        lay_Busquedas.setWidthFull();
        //-----------------------------------------------------------------------------------------------
        //TABLE - INFORMATION
        //-----------------------------------------------------------------------------------------------
        //GRID
        //-----------------------------------------------------------------------------------------------
        grid.addColumn(PedidoEcommerce::getNumero).setAutoWidth(true).setSortable(true).setHeader("Número");
        grid.addColumn(PedidoEcommerce::getUsuario_web).setAutoWidth(true).setSortable(true).setHeader("Usuario");
        grid.addColumn(PedidoEcommerce::getFecha_entrega).setAutoWidth(true).setSortable(true).setHeader("Fecha de Entrega"); 
        grid.addColumn(PedidoEcommerce::getEstado).setAutoWidth(true).setSortable(true).setHeader("Estado");
        
        grid.setSelectionMode(Grid.SelectionMode.MULTI);
        MultiSelect<Grid<PedidoEcommerce>, PedidoEcommerce> multiSelect = grid.asMultiSelect();
        
        layGrid.getStyle().set("border", "1px solid #9E9E9E");
        layGrid.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layGrid.setAlignItems(FlexComponent.Alignment.CENTER);
        layGrid.setWidthFull(); 
        //-----------------------------------------------------------------------------------------------
        lbInformation.getStyle().set("color", "red");
        lbInformation.getStyle().set("fontStyle","italic");
        lbInformation.getStyle().set("fontSize","70%");
        
        layInformation.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        layInformation.setAlignItems(FlexComponent.Alignment.CENTER);
        layInformation.setWidthFull();        
        //-----------------------------------------------------------------------------------------------
        //btnver_ped.addThemeVariants(ButtonVariant.LUMO_SMALL);
        btnver_ped.getStyle().set("fontSize","70%");
        
        layBttnVer_Prod.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        layBttnVer_Prod.setAlignItems(FlexComponent.Alignment.CENTER);
        layBttnVer_Prod.setWidthFull();  
        //-----------------------------------------------------------------------------------------------
        //FOOTER
        //-----------------------------------------------------------------------------------------------
        btnExit.addThemeVariants(ButtonVariant.LUMO_ERROR);
        btnExit.getStyle().set("fontSize","70%"); 
        //-----------------------------------------------------------------------------------------------
        fButtons.getStyle().set("border", "1px solid #9E9E9E");
        fButtons.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        fButtons.setAlignItems(FlexComponent.Alignment.CENTER);
        fButtons.setWidthFull(); 
        //-----------------------------------------------------------------------------------------------
        //END MAIN VIEW
        //-----------------------------------------------------------------------------------------------
        
        
        
        
        //--------------------------------------------------------------------------------------------------
        //DIALOG PEDIDO
        //--------------------------------------------------------------------------------------------------
        //TITULO
        //--------------------------------------------------------------------------------------------------
        titulo_dialog.getStyle().set("fontWeight","bold");
        titulo_dialog.getStyle().set("fontSize","100%");
        titulo_dialog.getStyle().set("color", "lime");
        
        layTitulo_dialog.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layTitulo_dialog.setAlignItems(FlexComponent.Alignment.CENTER);
        layTitulo_dialog.setWidthFull();  
        //--------------------------------------------------------------------------------------------------
        //DATOS GENERALES
        //--------------------------------------------------------------------------------------------------
        txtdialog_NOrden.setWidthFull();
        txtdialog_NOrden.setReadOnly(true);
        txtdialog_NOrden.getStyle().set("fontSize","70%");
        //--------------------------------------------------------------------------------------------------
        txtdialog_TipoEntrega.setWidthFull();
        txtdialog_TipoEntrega.setReadOnly(true);
        txtdialog_TipoEntrega.getStyle().set("fontSize","70%");
        //--------------------------------------------------------------------------------------------------
        txtdialog_Prods_byPed.setWidthFull();
        txtdialog_Prods_byPed.setReadOnly(true); 
        txtdialog_Prods_byPed.getStyle().set("fontSize","70%");
        //--------------------------------------------------------------------------------------------------
        comboBoxProds_byPed.setPlaceholder("Productos del Pedido");
        comboBoxProds_byPed.getStyle().set("fontSize","70%");
        
        comboBoxProds_byPed.addValueChangeListener(event->{
            if(!event.getValue().contentEquals("No definido")){
                txtdialog_Prods_byPed.setValue(event.getValue());
            }
            else
                txtdialog_Prods_byPed.setValue("");
        });
        //--------------------------------------------------------------------------------------------------
        laydialog_Pedidodats.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laydialog_Pedidodats.setAlignItems(FlexComponent.Alignment.BASELINE);
        laydialog_Pedidodats.setWidthFull();
        
        laydialog_Pedidodats2.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laydialog_Pedidodats2.setAlignItems(FlexComponent.Alignment.BASELINE);
        laydialog_Pedidodats2.setWidthFull();
        //--------------------------------------------------------------------------------------------------
        //DATOS USUARIO
        //--------------------------------------------------------------------------------------------------
        titdetUsu_dialog.getStyle().set("fontWeight","bold");
        titdetUsu_dialog.getStyle().set("fontSize","80%");
        titdetUsu_dialog.getStyle().set("color", "lime");
        
        layTitdetUsu_dialog.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        layTitdetUsu_dialog.setAlignItems(FlexComponent.Alignment.CENTER);
        layTitdetUsu_dialog.setWidthFull(); 
        //--------------------------------------------------------------------------------------------------
        txtdialog_DirEcom.setWidthFull();
        txtdialog_DirEcom.setReadOnly(true);
        txtdialog_DirEcom.getStyle().set("fontSize","70%");
        
        txtdialog_RefEcom.setWidthFull();
        txtdialog_RefEcom.setReadOnly(true);
        txtdialog_RefEcom.getStyle().set("fontSize","70%");
        
        laydialog_DirEcom.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laydialog_DirEcom.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialog_DirEcom.setWidthFull();
        
        laydialog_RefEcom.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laydialog_RefEcom.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialog_RefEcom.setWidthFull(); 
        //--------------------------------------------------------------------------------------------------
        //REGISTRAR ENTREGA DEL PEDIDO
        //--------------------------------------------------------------------------------------------------
        titCambioEst_dialog.getStyle().set("fontWeight","bold");
        titCambioEst_dialog.getStyle().set("fontSize","80%");
        titCambioEst_dialog.getStyle().set("color", "lime");
        
        layTitCambioEst_dialog.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        layTitCambioEst_dialog.setAlignItems(FlexComponent.Alignment.CENTER);
        layTitCambioEst_dialog.setWidthFull();
        //--------------------------------------------------------------------------------------------------
        lbRegistrarEntr_dialog.getStyle().set("fontWeight","bold");
        lbRegistrarEntr_dialog.setWidthFull();
        lbRegistrarEntr_dialog.getStyle().set("fontSize","70%");
        
        btnConfirmarEntrega.addThemeVariants(ButtonVariant.LUMO_SUCCESS); 
        btnConfirmarEntrega.getStyle().set("fontSize","70%");
        btnConfirmarEntrega.getStyle().set("fontWeight","bold");
        btnConfirmarEntrega.setWidthFull();
        
        txtdialog_Estado.setWidthFull();
        txtdialog_Estado.setReadOnly(true); 
        txtdialog_Estado.getStyle().set("fontSize","70%");
        
        laydialog_RegistrarEntr.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laydialog_RegistrarEntr.setAlignItems(FlexComponent.Alignment.BASELINE);
        laydialog_RegistrarEntr.setWidthFull();
        //--------------------------------------------------------------------------------------------------
        btnSalirdialog.addThemeVariants(ButtonVariant.LUMO_ERROR); 
        btnSalirdialog.getStyle().set("fontSize","70%");
        btnSalirdialog.getStyle().set("fontWeight","bold");
        
        laydialog_Salirdialog.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laydialog_Salirdialog.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialog_Salirdialog.setWidthFull(); 
        //--------------------------------------------------------------------------------------------------
        //CREATE DIALOG PEDIDO
        //--------------------------------------------------------------------------------------------------
        laydialogPedido.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laydialogPedido.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialogPedido.setWidthFull(); 
        //--------------------------------------------------------------------------------------------------
        dialogPedido.setCloseOnEsc(false);
        dialogPedido.setCloseOnOutsideClick(false); 
        //--------------------------------------------------------------------------------------------------
        //NOTIFICATION PEDIDO
        //--------------------------------------------------------------------------------------------------
        Pedido_notf_correct.getStyle().set("fontSize","70%");
        Pedido_notf_correct.getStyle().set("color", "green"); 
        
        Pedido_notify_correct.setDuration(2500);
        Pedido_notify_correct.setPosition(Notification.Position.MIDDLE); 

        notf_select_exceed.getStyle().set("fontSize","70%");
        notf_select_exceed.getStyle().set("color", "red"); 
        
        notify_select_exceed.setDuration(2500);
        notify_select_exceed.setPosition(Notification.Position.MIDDLE);  
        //--------------------------------------------------------------------------------------------------
        //END DIALOG PEDIDO
        //--------------------------------------------------------------------------------------------------
        
        
        
    }
    //-----------------------------------------------------------------------------------------------
    
    
    
    //-----------------------------------------------------------------------------------------------
    //FUNCIONES
    //-----------------------------------------------------------------------------------------------
    //CPANEL RUTAS
    public abstract void go_CPanel();
    //-----------------------------------------------------------------------------------------------
    //BUSQUEDAS
    //-----------------------------------------------------------------------------------------------
    public abstract void On_find_NOrdenPed();
    public abstract void On_find_AllPed();
    public abstract void On_find_FechaPed();
    //-----------------------------------------------------------------------------------------------
    //REPARTIDOR DIALOG
    //-----------------------------------------------------------------------------------------------
    public abstract void on_Open_Repartidor_dialog();
    public abstract void confirmar_Entrega_dialog();
    //-----------------------------------------------------------------------------------------------
    
    
    //-----------------------------------------------------------------------------------------------
    private void initEvents() {
    //-----------------------------------------------------------------------------------------------
    //CPANEL
    //-----------------------------------------------------------------------------------------------
    //VER/EDITAR PEDIDO
        btnver_ped.addClickListener(e->{ 
            on_Open_Repartidor_dialog();
        });
    //-----------------------------------------------------------------------------------------------
    //SALIR A CPANEL
        btnExit.addClickListener(e->{
            removeAll();
            add(new App());
        });
    //-----------------------------------------------------------------------------------------------
    //REPARTIDOR DIALOG
    //-----------------------------------------------------------------------------------------------    
    //CONFIRMAR ENTREGA
        btnConfirmarEntrega.addClickListener(e->{
            confirmar_Entrega_dialog();
        });
    //-----------------------------------------------------------------------------------------------
    //CERRAR DIALOG    
        btnSalirdialog.addClickListener(e->{
            dialogPedido.close();
        });
    }
    //-----------------------------------------------------------------------------------------------
}
