/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.view.comprobantes;

import com.upgrade.persistence.model.cmrlz.NotaCreDebCap;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import java.time.LocalDate;
import sun.awt.image.ImageWatched.Link;

/**
 *
 * @author Upgrade - PC
 */
public abstract class NotasCreditosUI extends VerticalLayout{
    
    public final Button buscarNotas = new Button("Buscar");
    public final Button verDetalles = new Button("Ver Detalles");
    public final HorizontalLayout layTitle = new HorizontalLayout();
    public final Grid<NotaCreDebCap> gridNotasCredito = new Grid<>();
    public final TextField buscarByNumero = new TextField();
    //public final Grid<VentaDet> gridDetallesComprobante = new Grid<>();
    public final Dialog dialogDetalles = new Dialog();
    public final DatePicker fechaDesde = new DatePicker();
    public final DatePicker fechaHasta = new DatePicker();
    public final Notification notificationError= new Notification();
    
    public NotasCreditosUI(){
        initComponentTitulo();
        initStyles();
        
        //LocalDate now = LocalDate.now();
        //fechaDesde.setValue(now);
        //fechaHasta.setValue(now);
        
        gridNotasCredito.addColumn(NotaCreDebCap::getId).setHeader("Id").setAutoWidth(true);
        gridNotasCredito.addColumn(NotaCreDebCap::getSerie).setHeader("Serie").setAutoWidth(true);
        gridNotasCredito.addColumn(NotaCreDebCap::getNumero).setHeader("Numero").setSortable(true).setAutoWidth(true);
        gridNotasCredito.addColumn(NotaCreDebCap::getNumeroVentaAfecta).setHeader("N° F/B Afectada").setAutoWidth(true);
        gridNotasCredito.addColumn(NotaCreDebCap::getMtoOperGravadas).setHeader("Subtotal").setAutoWidth(true);
        gridNotasCredito.addColumn(NotaCreDebCap::getMtoIGV).setHeader("Impuesto").setAutoWidth(true);
        gridNotasCredito.addColumn(NotaCreDebCap::getMtoImpVenta).setHeader("Total").setAutoWidth(true);
        gridNotasCredito.addColumn(NotaCreDebCap::getAceptadoSunatStr).setHeader("Aceptado SUNAT").setAutoWidth(true);
        gridNotasCredito.addColumn(NotaCreDebCap::getObservaciones).setHeader("Observaciones").setAutoWidth(true);
        gridNotasCredito.addColumn(new ComponentRenderer<>(item ->  {
            Anchor anchor = new Anchor("",new Button("", VaadinIcon.FILE_TEXT.create()));
            if(item.getEnlacePdfNubefact() != null)
                anchor.setHref(item.getEnlacePdfNubefact());
            else
                anchor.add(new Label("ERROR"));
            return anchor;
        })).setHeader("PDF");
        gridNotasCredito.addColumn(new ComponentRenderer<>(item ->  {
            Anchor anchor = new Anchor("",new Button("", VaadinIcon.FILE_TEXT_O.create()));
            if(item.getEnlaceXmlNubefact() != null)
                anchor.setHref(item.getEnlaceXmlNubefact());
            else
                anchor.add(new Label("ERROR"));
            return anchor;
        })).setHeader("XML");

        
        buscarNotas.addClickListener(e->
        {
            if ((!fechaDesde.isEmpty() && !fechaHasta.isEmpty()) || !buscarByNumero.isEmpty())
                onGetNotas();
            else
            {
                notificationError.setText("Necesita ingresar al menos una forma de busqueda");
                notificationError.open();                
            }
        });
        
        add(layTitle);
        add(new HorizontalLayout(fechaDesde, fechaHasta, buscarByNumero, buscarNotas));
        add(gridNotasCredito);
  

    }
    
    public final void initComponentTitulo()
    {
        Label lblTitle = new Label("NOTAS DE CRÉDITO");
        lblTitle.setClassName("titulo");
        layTitle.add(lblTitle);
        layTitle.addClassName("centered-content");
    }
    
    public final void initStyles()       
    {
        notificationError.setDuration(3000);
        notificationError.setPosition(Notification.Position.TOP_CENTER);
        notificationError.addThemeVariants(NotificationVariant.LUMO_ERROR);
        buscarByNumero.setPlaceholder("[Buscar por número]");
    }
    
    public abstract void onGetNotas();
    
}
