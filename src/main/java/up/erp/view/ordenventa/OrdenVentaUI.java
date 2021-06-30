/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.view.ordenventa;

import com.upgrade.persistence.model.cmrlz.NotaPedidoCab;
import com.upgrade.persistence.model.extcs.Almacen;
import com.upgrade.persistence.model.fnnzs.Recibo;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import java.time.LocalDate;
import up.erp.view.produccion.Mensaje;

/**
 *
 * @author Diego Javier Quispe
 */
public abstract class OrdenVentaUI extends VerticalLayout{
    
    public Button btnOpenDialogGenerarComprobante = new Button("Generar Comprobante", VaadinIcon.FILE_PROCESS.create());
    public Button btnDialogReenviarComprobante = new Button("Reenviar Comprobante", VaadinIcon.FILE_PROCESS.create());
    public Button btnGenerarComprobante = new Button("Generar", VaadinIcon.FILE_PROCESS.create());
    public Button btnReenviarComprobante = new Button("Reenviar", VaadinIcon.FILE_PROCESS.create());
    public Button buscarComprobantes = new Button("Buscar",  VaadinIcon.SEARCH.create());
    public Button verDetalles = new Button("Ver Detalles");
    public HorizontalLayout layTitle = new HorizontalLayout();
    public final Grid<NotaPedidoCab> gridOrdenesVenta = new Grid<>();
    public final Grid<NotaPedidoCab> gridDetallesComprobante = new Grid<>();
    public final Grid<NotaPedidoCab> gridDetallesGenerar = new Grid<>();
    public final Dialog dialogDetalles = new Dialog();
    public final Dialog dialogGenerarComprobante = new Dialog();
    public final Dialog dialogReenviarComprobante = new Dialog();
    public DatePicker fechaDesde = new DatePicker();
    public DatePicker fechaHasta = new DatePicker();
    //public ComboBox<AlmacenFiltro> comboAlmacenes = new ComboBox<>();
    public TextField buscarBySerie = new TextField();
    public TextField buscarByNumero = new TextField();
    public DatePicker fechaNotaCredito = new DatePicker();
    public final Notification notificationError= new Notification();
    public final Notification notificationSuccess= new Notification();
    public final TextArea observaciones = new TextArea();
    
    public final ComboBox<TipoComprobante> comboTipoComprobante = new ComboBox<>();
    
    public final Dialog dialogCobranzas = new Dialog();
    public final Button btnOpenDialogCobranzas = new Button("Cobranzas", VaadinIcon.COIN_PILES.create());
    public final Button closeDialogCobranzas = new Button("Cerrar");
    public final ComboBox<Almacen> cmbAlmacen = new ComboBox();
    
    public OrdenVentaUI()
    {
        initComponentTitulo();
        initDialogComponent();
        //initDialogCobranzas();
        initStyles();
        
        fechaDesde.setValue(LocalDate.now());
        fechaHasta.setValue(LocalDate.now());
        
        gridOrdenesVenta.addColumn(NotaPedidoCab::getId).setHeader("Id").setAutoWidth(true);
        gridOrdenesVenta.addColumn(NotaPedidoCab::getFecha).setHeader("Fecha").setAutoWidth(true);
        gridOrdenesVenta.addColumn(NotaPedidoCab::getRazonSocial).setHeader("Razon Social").setAutoWidth(true).setSortable(true);
        gridOrdenesVenta.addColumn(NotaPedidoCab::getNumeroDocumentoPersona).setHeader("Documento").setAutoWidth(true);
        //gridComprobantes.addColumn(NotaPedidoCab::getNombreCortoDocumentoTipo).setHeader("Tipo");
        //gridComprobantes.addColumn(NotaPedidoCab::getSerie).setHeader("Serie");
        gridOrdenesVenta.addColumn(NotaPedidoCab::getNumero).setHeader("Número").setSortable(true);
        gridOrdenesVenta.addColumn(NotaPedidoCab::getIdAlmacen).setHeader("Almacen");
        //gridComprobantes.addColumn(NotaPedidoCab::getSubtotal).setHeader("Subtotal");
        //gridComprobantes.addColumn(NotaPedidoCab::getMontoImpuesto).setHeader("Impuesto");
        gridOrdenesVenta.addColumn(NotaPedidoCab::getTotal).setHeader("Total");
        gridOrdenesVenta.addColumn(NotaPedidoCab::getTieneComprobante).setHeader("Comprobante").setAutoWidth(true);
        gridOrdenesVenta.addColumn(NotaPedidoCab::getNombreFormaPago).setHeader("Forma de Pago");
        
        buscarComprobantes.addClickListener(e->
        {
            if ((!fechaDesde.isEmpty() && !fechaHasta.isEmpty()) || !buscarByNumero.isEmpty())
                onGetOrdenesVenta();
            else
            {
                notificationError.setText("Necesita ingresar al menos una forma de busqueda");
                notificationError.open();                
            }
        });
        
        btnOpenDialogGenerarComprobante.addClickListener(e->
        {
            if (!gridOrdenesVenta.asSingleSelect().isEmpty()){  
                if(gridOrdenesVenta.asSingleSelect().getValue().getVenta() == null)
                {
                    Mensaje mensaje = onComprobantePagado();
                    if(mensaje.isTipo()){
                        //notificationSuccess.setText(mensaje.getMensaje());
                        //notificationSuccess.open();
                        onGetTiposComprobante();
                        dialogGenerarComprobante.open();
                    }
                    else{
                        notificationError.setText(mensaje.getMensaje());
                        notificationError.open();
                    }                 
                }
                else{
                    notificationError.setText("La presente Orden de Venta ya tiene un comprobante.");
                    notificationError.open();    
                }
            }
            else
            {
                notificationError.setText("Necesita seleccionar un elemento");
                notificationError.open();                
            }
        });    
        
        btnDialogReenviarComprobante.addClickListener(e->
        {
            if (!gridOrdenesVenta.asSingleSelect().isEmpty()){  
                if(gridOrdenesVenta.asSingleSelect().getValue().getVenta() != null)
                {
                    dialogReenviarComprobante.open();       
                }
                else{
                    notificationError.setText("La Orden de Venta no tiene Comprobante que reenviar.");
                    notificationError.open();    
                }
            }
            else
            {
                notificationError.setText("Necesita seleccionar un elemento");
                notificationError.open();                
            }
        });  
        
        btnOpenDialogCobranzas.addClickListener(e->
        {
            if (!gridOrdenesVenta.asSingleSelect().isEmpty()){  
                
                if(gridOrdenesVenta.asSingleSelect().getValue().getVenta() == null)
                {
                    dialogCobranzas.removeAll();
                    initDialogCobranzas();
                    dialogCobranzas.open();                
                }
                else{
                    notificationError.setText("La presente orden ya tiene un comprobante generado");
                    notificationError.open();  
                }
                
            }
            else
            {
                notificationError.setText("Necesita seleccionar un elemento");
                notificationError.open();   
            }
        });  
        
        closeDialogCobranzas.addClickListener(e->
        {
            dialogCobranzas.removeAll();
            dialogCobranzas.close();
        });
        
        btnGenerarComprobante.addClickListener(e->
        {
            Mensaje mensaje = onGenerarComprobanteUpdate();
            dialogGenerarComprobante.close();
            
            if(mensaje.isTipo()){
                notificationSuccess.setText(mensaje.getMensaje());
                notificationSuccess.open();
            }
            else
            {
                notificationError.setDuration(10000);
                notificationError.setText(mensaje.getMensaje());
                notificationError.open();
            }
        });
        
        btnReenviarComprobante.addClickListener(e->
        {
            Mensaje mensaje = onReenviarComprobante();
            dialogReenviarComprobante.close();
            
            if(mensaje.isTipo()){
                notificationSuccess.setText(mensaje.getMensaje());
                notificationSuccess.open();
            }
            else
            {
                notificationError.setDuration(10000);
                notificationError.setText(mensaje.getMensaje());
                notificationError.open();
            }
        });
        
        verDetalles.addClickListener(e->{
             UI.getCurrent().getPage().executeJs("window.open(\"https://www.nubefact.com/cpe/28342f0a-3155-4161-8295-e88a6f61af07-c3efa051-0462-4219-82ff-c9f1a09a1d5b.pdf\");");
        });
        
    
        add(layTitle);
        add(new HorizontalLayout(fechaDesde, fechaHasta, cmbAlmacen, buscarByNumero, buscarComprobantes));
        add(gridOrdenesVenta);
        //add(new HorizontalLayout(btnDialogReenviarComprobante, btnOpenDialogGenerarComprobante));
        add(new HorizontalLayout(btnOpenDialogCobranzas, btnOpenDialogGenerarComprobante));
    }
    
     public final void initComponentTitulo()
    {
        Label lblTitle = new Label("Ordenes de Venta");
        lblTitle.setClassName("titulo");
        layTitle.add(lblTitle);
        layTitle.addClassName("centered-content");
        buscarBySerie.setPlaceholder("[Buscar por Serie]");
        buscarByNumero.setPlaceholder("[Buscar por Número]");  
    }
     
    public final void initDialogCobranzas(){
        dialogCobranzas.setWidth("900px");
        dialogCobranzas.setCloseOnOutsideClick(false);
        dialogCobranzas.add(closeDialogCobranzas);
        dialogCobranzas.add(new ReciboView(String.valueOf(gridOrdenesVenta.asSingleSelect().getValue().getId())));
    }
         
    public final void initDialogComponent()
    {
        dialogDetalles.setWidth("850px");
        
        dialogGenerarComprobante.setWidth("300px");
        FormLayout columnLayout = new FormLayout();  
        columnLayout.setResponsiveSteps(
                   new FormLayout.ResponsiveStep("5em", 1),
                   new FormLayout.ResponsiveStep("10em", 2));
        
        Label lblTitle = new Label("GENERAR COMPROBANTE");
        columnLayout.add(new Label("¿Está seguro que desea generar el comprobante?"),2);
        columnLayout.add(btnGenerarComprobante,2);
        
        dialogGenerarComprobante.add(columnLayout);
        
        dialogReenviarComprobante.setWidth("300px");
        FormLayout reenviarLayout = new FormLayout();  
        reenviarLayout.setResponsiveSteps(
                   new FormLayout.ResponsiveStep("5em", 1),
                   new FormLayout.ResponsiveStep("10em", 2));
        
        //Label lblTitle = new Label("GENERAR COMPROBANTE");
        reenviarLayout.add(new Label("¿Está seguro que desea reenviar el comprobante asociado a la presente orden?"),2);
        reenviarLayout.add(btnReenviarComprobante,2);
        
        dialogReenviarComprobante.add(reenviarLayout);
    
    }
    
        public final void initStyles()       
    {
        notificationError.setDuration(3000);
        notificationError.setPosition(Notification.Position.TOP_CENTER);
        notificationError.addThemeVariants(NotificationVariant.LUMO_ERROR);
        buscarByNumero.setPlaceholder("[Buscar por número]");
        
        notificationSuccess.setDuration(3000);
        notificationSuccess.setPosition(Notification.Position.TOP_CENTER);
        notificationSuccess.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
        
        buscarComprobantes.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        btnOpenDialogGenerarComprobante.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        btnOpenDialogCobranzas.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        
        closeDialogCobranzas.addThemeVariants(ButtonVariant.LUMO_ERROR);
    }
     
    public abstract void onGetOrdenesVenta();
    public abstract void onGetTiposComprobante();
    public abstract Mensaje onReenviarComprobante();
    public abstract Mensaje onGenerarComprobanteUpdate();
    public abstract Mensaje onComprobantePagado();
    public abstract Anchor onLoadComprobante();
    
}
