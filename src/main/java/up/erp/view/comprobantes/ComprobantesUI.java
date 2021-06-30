/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.view.comprobantes;

import com.upgrade.persistence.model.cmrlz.VentaCab;
import com.upgrade.persistence.model.cmrlz.VentaDet;
import com.upgrade.persistence.model.extcs.Almacen;
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
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.server.StreamResource;
import java.time.LocalDate;
import up.erp.view.produccion.Mensaje;

/**
 *
 * @author Upgrade - PC
 */
public abstract class ComprobantesUI extends VerticalLayout{
    
    public Button abrirGenerarNotaCredito = new Button("Nota de Crédito Total", VaadinIcon.FILE_PROCESS.create());
    public Button abrirGenerarNCParcial = new Button("Nota de Crédito Parcial", VaadinIcon.FILE_PROCESS.create());
    public Button btnGenerarNotaCredito = new Button("Generar", VaadinIcon.FILE_PROCESS.create());
    public Button btnGenerarNCParcial = new Button("Generar Parcial", VaadinIcon.FILE_PROCESS.create());
    
    public Button buscarComprobantes = new Button("Buscar",  VaadinIcon.SEARCH.create());
    public Button verDetalles = new Button("Ver Detalles", VaadinIcon.FILE_TABLE.create());
    public HorizontalLayout layTitle = new HorizontalLayout();
    public final Grid<VentaCab> gridComprobantes = new Grid<>();
    public final Grid<VentaDet> gridDetallesComprobante = new Grid<>();
    public final Grid<VentaDet> gridDetallesNC = new Grid<>();
    public final Grid<VentaDet> gridDetallesGenerar = new Grid<>();
    public final Dialog dialogDetalles = new Dialog();
    public final Dialog dialogGenerarNotaCredito = new Dialog();
    public final Dialog dialogGenerarNCParcial = new Dialog();
    public final Grid<VentaDet> gridDetallesToNC = new Grid<>();
    public DatePicker fechaDesde = new DatePicker();
    public DatePicker fechaHasta = new DatePicker();
    //public ComboBox<AlmacenFiltro> comboAlmacenes = new ComboBox<>();
    public TextField buscarBySerie = new TextField();
    public TextField buscarByNumero = new TextField();
    public DatePicker fechaNotaCredito = new DatePicker();
    public DatePicker fechaNotaCreditoNC = new DatePicker();
    public final Notification notificationError= new Notification();
    public final Notification notificationSuccess=  new Notification();
    public final TextArea observaciones = new TextArea();
    public final TextArea observacionesNC = new TextArea();
    public final TextArea txtMotivo = new TextArea();
    
    public Button btnAnularComprobante = new Button("Anular", VaadinIcon.FILE_PROCESS.create());
    public Button btnReenviarComprobante = new Button("Reenviar", VaadinIcon.FILE_PROCESS.create());
    public Button btnDialogReenviarComprobante = new Button("Reenviar Comprobante", VaadinIcon.CLOUD_UPLOAD_O.create());
    public Button btnDialogAnularComprobante = new Button("Anular Comprobante", VaadinIcon.BAN.create());
    public final Dialog dialogAnularComprobante = new Dialog();
    public final Dialog dialogReenviarComprobante = new Dialog();
    public final ComboBox<Almacen> cmbAlmacen = new ComboBox();
    
    public ComprobantesUI()
    {
        initComponentTitulo();
        initDialogComponent();
        initDialogAnular();
        initStyles();
        
        LocalDate now = LocalDate.now();
        fechaDesde.setValue(now);
        fechaHasta.setValue(now);
        fechaNotaCredito.setValue(now);

        gridDetallesNC.setSelectionMode(Grid.SelectionMode.MULTI);        
        
        gridComprobantes.addColumn(VentaCab::getId).setHeader("Id").setAutoWidth(true);
        gridComprobantes.addColumn(VentaCab::getFecha).setHeader("Fecha").setAutoWidth(true);
        gridComprobantes.addColumn(VentaCab::getRazonSocial).setHeader("Razon Social").setAutoWidth(true);
        gridComprobantes.addColumn(VentaCab::getNumeroDocumentoPersona).setHeader("Documento").setAutoWidth(true);;
        gridComprobantes.addColumn(VentaCab::getNombreCortoDocumentoTipo).setHeader("Tipo").setAutoWidth(true);;
        gridComprobantes.addColumn(VentaCab::getSerie).setHeader("Serie").setAutoWidth(true);;
        gridComprobantes.addColumn(VentaCab::getNumero).setHeader("Número").setSortable(true).setAutoWidth(true);;
        gridComprobantes.addColumn(VentaCab::getIdAlmacen).setHeader("Almacen").setAutoWidth(true);;
        gridComprobantes.addColumn(VentaCab::getSubtotal).setHeader("Subtotal");
        gridComprobantes.addColumn(VentaCab::getMontoImpuesto).setHeader("Impuesto").setAutoWidth(true);;
        gridComprobantes.addColumn(VentaCab::getTotal).setHeader("Total").setAutoWidth(true);;
        gridComprobantes.addColumn(new ComponentRenderer<>(item ->  {
                
            Anchor anchor = new Anchor();
            //Anchor anchor = new Anchor("",new Button("", VaadinIcon.FILE_TEXT.create()));
            if(!item.getAnulada() && item.getEnlacePdf() != null){
                anchor.add(new Button("", VaadinIcon.FILE_TEXT.create()));
                anchor.setHref(item.getEnlacePdf());
                anchor.setTarget("_blank");
            }
            else
            {
                if(item.getEnlaceAnuladoPdf() != null){
                     anchor.add(new Button("Baja", VaadinIcon.FILE_TEXT.create()));
                    anchor.setHref(item.getEnlaceAnuladoPdf());
                    anchor.setTarget("_blank");
                }
                else{
                    if(item.getAnulada())
                        anchor.add(new Label("ANULADO"));
                    else
                        anchor.add(new Label("NO ENVIADO"));
                    }
            }
            return anchor;
            
            
        })).setHeader("PDF");
        gridComprobantes.addColumn(new ComponentRenderer<>(item ->  {
            //Anchor anchor = new Anchor("",new Button("", VaadinIcon.FILE_TEXT_O.create()));
            Anchor anchor = new Anchor();
            if(!item.getAnulada() && item.getEnlaceXml() != null){
                anchor.add(new Button("", VaadinIcon.FILE_TEXT.create()));
                anchor.setHref(item.getEnlaceXml());
                anchor.setTarget("_blank");
            }
            else
            {
                if(item.getAnulada())
                    anchor.add(new Label("ANULADO"));
                else
                    anchor.add(new Label("NO ENVIADO"));
                
            }
            return anchor;
        })).setHeader("XML");
        /*gridComprobantes.addColumn(new ComponentRenderer<>(item ->  {
            //Anchor anchor = new Anchor("",new Button("", VaadinIcon.FILE_TEXT_O.create()));
            Anchor anchor = new Anchor(new StreamResource("my-excel.xlsx", Exporter.exportAsExcel(gridComprobantes)), "Download As Excel");
            return anchor;
        })).setHeader("Excel");*/
        
        gridDetallesComprobante.addColumn(VentaDet::getId).setHeader("Id").setAutoWidth(true);
        gridDetallesComprobante.addColumn(VentaDet::getNombreProducto).setHeader("Nombre").setAutoWidth(true);
        gridDetallesComprobante.addColumn(VentaDet::getPrecioVenta).setHeader("Precio Unitatio").setAutoWidth(true);
        gridDetallesComprobante.addColumn(VentaDet::getCantidad).setHeader("Cantidad").setAutoWidth(true);
        gridDetallesComprobante.addColumn(VentaDet::getIgv).setHeader("igv").setAutoWidth(true);
        gridDetallesComprobante.addColumn(VentaDet::getSubtotal).setHeader("Subtotal").setAutoWidth(true);
        gridDetallesComprobante.addColumn(VentaDet::getTotal).setHeader("Total").setAutoWidth(true);
        
        gridDetallesNC.addColumn(VentaDet::getId).setHeader("Id").setAutoWidth(true);
        gridDetallesNC.addColumn(VentaDet::getNombreProducto).setHeader("Nombre").setAutoWidth(true);
        gridDetallesNC.addColumn(VentaDet::getPrecioVenta).setHeader("Precio Unitatio").setAutoWidth(true);
        gridDetallesNC.addColumn(VentaDet::getCantidad).setHeader("Cantidad").setAutoWidth(true);
        gridDetallesNC.addColumn(VentaDet::getIgv).setHeader("igv").setAutoWidth(true);
        gridDetallesNC.addColumn(VentaDet::getSubtotal).setHeader("Subtotal").setAutoWidth(true);
        gridDetallesNC.addColumn(VentaDet::getTotal).setHeader("Total").setAutoWidth(true);
        
        gridDetallesGenerar.addColumn(VentaDet::getId).setHeader("Id");
        gridDetallesGenerar.addColumn(VentaDet::getPrecioVenta).setHeader("Precio Unitatio");
        gridDetallesGenerar.addColumn(VentaDet::getCantidad).setHeader("Cantidad");
        gridDetallesGenerar.addColumn(VentaDet::getIgv).setHeader("igv");
        gridDetallesGenerar.addColumn(VentaDet::getSubtotal).setHeader("Subtotal");
        gridDetallesGenerar.addColumn(VentaDet::getTotal).setHeader("Total");
        
        abrirGenerarNotaCredito.addClickListener(e->
        {
            if (!gridComprobantes.asSingleSelect().isEmpty()){  
                //if(!existeNotaCredito())
                //{
                    dialogGenerarNotaCredito.open();
                    onGetDetallesGenerar();
                //}
                /*else
                {
                    notificationError.setText("EL presente comprobante ya tiene una nota de credito.");
                    notificationError.open();    
                }*/
            }
            else
            {
                notificationError.setText("Necesita seleccionar un elemento");
                notificationError.open();                
            }
           });    
                
        abrirGenerarNCParcial.addClickListener(e->
        {
            if (!gridComprobantes.asSingleSelect().isEmpty()){  
                //if(!existeNotaCredito())
                //{
                    dialogGenerarNCParcial.open();
                    onGetDetallesToNC();
                //}
                /*else
                {
                    notificationError.setText("EL presente comprobante ya tiene una nota de credito.");
                    notificationError.open();    
                }*/
            }
            else
            {
                notificationError.setText("Necesita seleccionar un elemento");
                notificationError.open();                
            }
           });   
        
        btnGenerarNotaCredito.addClickListener(e->
        { 
            if(onValidarFecha())
            {    if(onGenerarNotaCredito())
                {
                    observaciones.clear();
                    dialogGenerarNotaCredito.close();
                    notificationSuccess.setText("Nota de crédito generada satisactoriamente.");
                    notificationSuccess.open();  
                }
                else
                {
                    notificationError.setText("El comprobante fue rechazado por SUNAT");
                    notificationError.open();
                }
            }
            else
            {
                notificationError.setText("La fecha ingresada es posterior a la fecha actual o anterior a la fecha del comprobante.");
                notificationError.open();                
            }
        }); 
        
        btnGenerarNCParcial.addClickListener(e->
        { 
            if(onValidarFecha())
            {   
                Mensaje mensaje = onGenerarNotaCreditoParcial();
                if(mensaje.isTipo())
                {
                    observaciones.clear();
                    dialogGenerarNCParcial.close();
                    notificationSuccess.setText(mensaje.getMensaje());
                    notificationSuccess.open();
                }
                else
                {
                    notificationError.setText(mensaje.getMensaje());
                    notificationError.open();
                }
            }
            else
            {
                notificationError.setText("La fecha ingresada es posterior a la fecha actual o anterior a la fecha del comprobante.");
                notificationError.open();                
            }
        }); 
        
        
        btnDialogAnularComprobante.addClickListener(e->
        {
            if (!gridComprobantes.asSingleSelect().isEmpty()){  
                dialogAnularComprobante.open();
            }
            else
            {
                notificationError.setText("Necesita seleccionar un elemento");
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
        
        btnDialogReenviarComprobante.addClickListener(e->
        {
            if (!gridComprobantes.asSingleSelect().isEmpty()){          
                dialogReenviarComprobante.open();                          
            }
            else
            {
                notificationError.setText("Necesita seleccionar un elemento");
                notificationError.open();                
            }
        }); 
        
        buscarComprobantes.addClickListener(e->
        {   
            if ((!fechaDesde.isEmpty() && !fechaHasta.isEmpty()) || !buscarBySerie.isEmpty() || !buscarByNumero.isEmpty())
                onGetComprobantes();
            else
            {
                notificationError.setText("Necesita ingresar al menos una forma de busqueda");
                notificationError.open();                
            }
        });
        
        btnAnularComprobante.addClickListener(e->{
            if (!gridComprobantes.asSingleSelect().isEmpty()){  
                
                Mensaje mensaje = anularComprobante();
                dialogAnularComprobante.close();
            
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
            }
            else
           {
              notificationError.setText("Necesita seleccionar un elemento");
              notificationError.open();                
           }
        });
        
        verDetalles.addClickListener(e->
            {
                if (!gridComprobantes.asSingleSelect().isEmpty()){  
                    onGetDetallesComprobante();
                    dialogDetalles.open();
                }
                else
                {
                   notificationError.setText("Necesita seleccionar un elemento");
                   notificationError.open();                
                }
             });      
        
        add(layTitle);
        add(new HorizontalLayout(fechaDesde, fechaHasta, cmbAlmacen, buscarBySerie, buscarByNumero, buscarComprobantes));
        add(gridComprobantes);
        add(new HorizontalLayout(verDetalles, btnDialogReenviarComprobante, btnDialogAnularComprobante, abrirGenerarNotaCredito, abrirGenerarNCParcial));
        
    }
    
    public final void initComponentTitulo()
    {
        Label lblTitle = new Label("BOLETAS / FACTURAS");
        lblTitle.setClassName("titulo");
        layTitle.add(lblTitle);
        layTitle.addClassName("centered-content");
        buscarBySerie.setPlaceholder("[Buscar por Serie]");
        buscarByNumero.setPlaceholder("[Buscar por Número]");
        
    }
    
    public final void initDialogComponent()
    {
        dialogDetalles.setWidth("850px");
        dialogDetalles.add(gridDetallesComprobante);
        
        dialogGenerarNotaCredito.setWidth("300px");
        FormLayout columnLayoutNota = new FormLayout();  
        columnLayoutNota.setResponsiveSteps(
                   new FormLayout.ResponsiveStep("5em", 1),
                   new FormLayout.ResponsiveStep("10em", 2));
        
        Label lblTitle = new Label("GENERAR NOTA DE CRÉDITO");
        columnLayoutNota.add(lblTitle,2);
        columnLayoutNota.add(fechaNotaCredito,2);
        columnLayoutNota.add(observaciones,2);
        columnLayoutNota.add(btnGenerarNotaCredito,2);
        dialogGenerarNotaCredito.add(columnLayoutNota);
        
        dialogGenerarNCParcial.setWidth("850");
        FormLayout columnLayoutNC = new FormLayout();  
        columnLayoutNC.setResponsiveSteps(
                   new FormLayout.ResponsiveStep("5em", 1),
                   new FormLayout.ResponsiveStep("10em", 2));
        
        Label lblTitleNC = new Label("GENERAR NOTA DE CRÉDITO PARCIAL");
        columnLayoutNC.add(lblTitleNC,2);
        columnLayoutNC.add(fechaNotaCreditoNC,2);
        columnLayoutNC.add(observacionesNC,2);
        columnLayoutNC.add(gridDetallesNC,2);
        columnLayoutNC.add(btnGenerarNCParcial,2);
        
        dialogGenerarNCParcial.add(columnLayoutNC);
        
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
    
    public final void initDialogAnular(){
        dialogAnularComprobante.setWidth("300px");
        FormLayout columnLayout = new FormLayout();  
        columnLayout.setResponsiveSteps(
                   new FormLayout.ResponsiveStep("5em", 1),
                   new FormLayout.ResponsiveStep("10em", 2));
        
        Label lblTitle = new Label("ANULAR COMPROBANTE");
        columnLayout.add(lblTitle,2);
        
        columnLayout.add(txtMotivo,2);
        columnLayout.add(btnAnularComprobante,2);
        
        dialogAnularComprobante.add(columnLayout);
    }
   
    
    public final void initStyles()
    {
        notificationError.setDuration(3000);
        notificationError.setPosition(Notification.Position.TOP_CENTER);
        notificationError.addThemeVariants(NotificationVariant.LUMO_ERROR);
        
        observaciones.setPlaceholder("Motivo de la Nota de Crédito...");
        notificationSuccess.setDuration(3000);
        notificationSuccess.setPosition(Notification.Position.TOP_CENTER);
        notificationSuccess.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
        
        buscarComprobantes.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        btnDialogReenviarComprobante.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        abrirGenerarNotaCredito.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        abrirGenerarNCParcial.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
    }
    
    public abstract boolean onGenerarNotaCredito();
    public abstract void onGetComprobantes();
    public abstract void onGetDetallesGenerar();
    public abstract void onGetDetallesComprobante();
    public abstract boolean existeNotaCredito();
    public abstract boolean onValidarFecha();
    public abstract Mensaje onReenviarComprobante();
    public abstract Mensaje anularComprobante();
    public abstract void onGetDetallesToNC();
    public abstract Mensaje onGenerarNotaCreditoParcial();
    
}
