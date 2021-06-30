/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.view.cobranzas;

import com.upgrade.persistence.model.cmrlz.NotaPedidoCab;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

/**
 *
 * @author Diego Javier Quispe
 */
public abstract class OrdenesVentasUI  extends VerticalLayout{
    
    public final Button btnEliminarCobranza = new Button("Anular Cobranza", VaadinIcon.FILE_PROCESS.create());
    //public Button btnGenerarNotaCredito = new Button("Generar", VaadinIcon.FILE_PROCESS.create());
    public final Button buscarOrdenes = new Button("Buscar",  VaadinIcon.SEARCH.create());
    //public Button verDetalles = new Button("Ver Detalles");
    public final HorizontalLayout layTitle = new HorizontalLayout();
    public final Grid<NotaPedidoCab> gridNotasPedido = new Grid<>();
    
    public final DatePicker fechaDesde = new DatePicker();
    public final DatePicker fechaHasta = new DatePicker();
    //public ComboBox<AlmacenFiltro> comboAlmacenes = new ComboBox<>();
    
    public final TextField buscarByNumero = new TextField();
    public final DatePicker fechaNotaCredito = new DatePicker();
    public final Notification notificationError= new Notification();
    public final Notification notificationSuccess= new Notification();
    
    public final Label lblAnular = new Label("ANULAR");
    public final Dialog dlogAnularCobranzaDia = new Dialog();
    public final Button btnAnularCobranzaDia = new Button("Anular");
    public final Button btnCerrarDialogCobranzaDia = new Button("Cerrar");    
    
    public final Label lblEliminar = new Label("ANULAR");
    public final Dialog dlogEliminarCobranzaAntigua = new Dialog();
    public final Button btnAnularCobranza = new Button("Anular");
    public final Button btnCerrarDialogCobranza = new Button("Cerrar");
    
    public OrdenesVentasUI(){
        
        initComponentTitulo();
        initStyles();
        initDialogs();
        
        gridNotasPedido.addColumn(NotaPedidoCab::getId).setHeader("Id").setAutoWidth(true);
        gridNotasPedido.addColumn(NotaPedidoCab::getFecha).setHeader("Fecha").setAutoWidth(true);
        gridNotasPedido.addColumn(NotaPedidoCab::getNumero).setHeader("Número").setSortable(true);
        gridNotasPedido.addColumn(NotaPedidoCab::getTotal).setHeader("Total");
        
        buscarOrdenes.addClickListener(e->
        {   
            if ((!fechaDesde.isEmpty() && !fechaHasta.isEmpty()) || !buscarByNumero.isEmpty())
                onGetOrdenes();
            else
            {
                notificationError.setText("Necesita ingresar al menos una forma de búsqueda");
                notificationError.open();                
            }
        });
        
        
                
        btnEliminarCobranza.addClickListener(e->
        {
            if (!gridNotasPedido.asSingleSelect().isEmpty()){  
                
                if(onExisteRecibo()) {
                    if(onEsReciboActual())
                    {
                        dlogAnularCobranzaDia.open();
                    }
                    else
                    {
                        dlogEliminarCobranzaAntigua.open();
                    }
                }
                else{
                    notificationError.setText("El recibo ya se encuentra anulada, o no tiene una nota pedido asociada.");
                    notificationError.open();                
                }
                
            }
            else
            {
                notificationError.setText("Necesita seleccionar un elemento.");
                notificationError.open();                
            }
           });    
        
        
        add(layTitle);
        add(new HorizontalLayout(fechaDesde, fechaHasta, buscarByNumero, buscarOrdenes));
        add(gridNotasPedido);
        add(new HorizontalLayout(btnEliminarCobranza));
        
    }
    
    public final void initComponentTitulo()
    {
        Label lblTitle = new Label("ORDEN DE VENTA");
        lblTitle.setClassName("titulo");
        layTitle.add(lblTitle);
        layTitle.addClassName("centered-content");
        buscarByNumero.setPlaceholder("[Buscar por Número]");
        
    }
    
    public final void initStyles()
    {
        notificationError.setDuration(3000);
        notificationError.setPosition(Notification.Position.TOP_CENTER);
        notificationError.addThemeVariants(NotificationVariant.LUMO_ERROR);
    }
        
    public final void initDialogs()
    {
        //Dialog Anular
        lblAnular.addClassName("titulo");
        dlogAnularCobranzaDia.setWidth("30em");
        dlogAnularCobranzaDia.setHeight("15em");
        
        FormLayout columnAnularLayout = new FormLayout();
        columnAnularLayout.setResponsiveSteps(
                   new FormLayout.ResponsiveStep("10em", 1),
                   new FormLayout.ResponsiveStep("20em", 2));
           
        columnAnularLayout.add(lblAnular, 2);
        columnAnularLayout.add(new Hr(),2);
        columnAnularLayout.add(new Label("¿Está seguro que desea anular la cobranza ?"),2);
        columnAnularLayout.add(new Hr(),2);
        columnAnularLayout.add(btnAnularCobranzaDia, btnCerrarDialogCobranzaDia); 
        dlogAnularCobranzaDia.add(columnAnularLayout);
        
        //Dialog Eliminar
        lblEliminar.addClassName("titulo");
        dlogEliminarCobranzaAntigua.setWidth("30em");
        dlogEliminarCobranzaAntigua.setHeight("15em");
        
        FormLayout columnEliminarLayout = new FormLayout();
        columnAnularLayout.setResponsiveSteps(
                   new FormLayout.ResponsiveStep("10em", 1),
                   new FormLayout.ResponsiveStep("20em", 2));
           
        columnEliminarLayout.add(lblEliminar, 2);
        columnEliminarLayout.add(new Hr(),2);
        columnEliminarLayout.add(new Label("¿La cobranza es de un día anterior al actual, desea eliminarla?"),2);
        columnEliminarLayout.add(new Hr(),2);
        columnEliminarLayout.add(btnAnularCobranza, btnCerrarDialogCobranza); 
        dlogEliminarCobranzaAntigua.add(columnEliminarLayout);
        
    }
    
    public abstract void onGetOrdenes();
    public abstract boolean onExisteRecibo();
    public abstract boolean onEsReciboActual();
    
    
}
