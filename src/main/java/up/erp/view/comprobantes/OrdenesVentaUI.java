/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.view.comprobantes;

import com.upgrade.persistence.model.cmrlz.NotaPedidoCab;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;

/**
 *
 * @author Upgrade - PC
 */
public abstract class OrdenesVentaUI extends VerticalLayout{
    
    public Button abrirGenerarNotaCredito = new Button("Generar Nota de Crédito", VaadinIcon.FILE_PROCESS.create());
    public Button btnGenerarNotaCredito = new Button("Generar", VaadinIcon.FILE_PROCESS.create());
    public Button buscarComprobantes = new Button("Buscar",  VaadinIcon.SEARCH.create());
    public Button verDetalles = new Button("Ver Detalles");
    public HorizontalLayout layTitle = new HorizontalLayout();
    public final Grid<NotaPedidoCab> gridComprobantes = new Grid<>();
    /*public final Grid<VentaDet> gridDetallesComprobante = new Grid<>();
    public final Grid<VentaDet> gridDetallesGenerar = new Grid<>();*/
    public final Dialog dialogDetalles = new Dialog();
    public final Dialog dialogGenerarNotaCredito = new Dialog();
    public DatePicker fechaDesde = new DatePicker();
    public DatePicker fechaHasta = new DatePicker();
    //public ComboBox<AlmacenFiltro> comboAlmacenes = new ComboBox<>();
    public TextField buscarBySerie = new TextField();
    public TextField buscarByNumero = new TextField();
    public DatePicker fechaNotaCredito = new DatePicker();
    public final Notification notificationError= new Notification();
    public final Notification notificationSuccess= new Notification();
    public final TextArea observaciones = new TextArea();
    
    public OrdenesVentaUI()
    {
        initComponentTitulo();
        add(layTitle);
        add(new HorizontalLayout(fechaDesde, fechaHasta, buscarBySerie, buscarByNumero, buscarComprobantes));
        add(gridComprobantes);
        add(new HorizontalLayout(verDetalles, abrirGenerarNotaCredito));
    }
    
    public final void initComponentTitulo()
    {
        Label lblTitle = new Label("Ordeness de Venta");
        lblTitle.setClassName("titulo");
        layTitle.add(lblTitle);
        layTitle.addClassName("centered-content");
        buscarBySerie.setPlaceholder("[Buscar por Serie]");
        buscarByNumero.setPlaceholder("[Buscar por Número]");
        
    }
    
}
