/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.view.usuarios;


import com.upgrade.persistence.model.cmrlz.NotaPedidoCab;
import com.upgrade.persistence.model.usros.Permiso;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import up.erp.view.produccion.Mensaje;
/**
 *
 * @author Diego Javier Quispe
 */
public abstract class PermisosUI extends VerticalLayout{
    
    public Button btnOpenDialogGenerarComprobante = new Button("Generar Comprobante", VaadinIcon.FILE_PROCESS.create());
    public Button btnGenerarPermiso = new Button("Generar", VaadinIcon.FILE_PROCESS.create());
    public Button buscarComprobantes = new Button("Buscar",  VaadinIcon.SEARCH.create());
    public Button verDetalles = new Button("Ver Detalles");
    public HorizontalLayout layTitle = new HorizontalLayout();
    public final Grid<Permiso> gridPermisos = new Grid<>();
    public final Dialog dialogGenerarPermiso = new Dialog();
    public final TextField txtNombrePermiso = new TextField();
    
    public Button btnOpenDialogPermiso = new Button("Crear Permiso", VaadinIcon.FILE_PROCESS.create());

    //public ComboBox<AlmacenFiltro> comboAlmacenes = new ComboBox<>();
   
    public final Notification notificationError= new Notification();
    public final Notification notificationSuccess= new Notification();
    public final TextArea observaciones = new TextArea();
    
    public PermisosUI()
    {
        initComponentTitulo();
        initDialogComponent();
        initStyles();
        initEvents();
        
        gridPermisos.addColumn(Permiso::getId).setHeader("Id").setAutoWidth(true);
        gridPermisos.addColumn(Permiso::getAccion).setHeader("Accion").setAutoWidth(true);
        
        add(layTitle);
        //add(new HorizontalLayout(fechaDesde, fechaHasta, buscarByNumero, buscarComprobantes));
        add(gridPermisos);
        add(new HorizontalLayout(btnOpenDialogPermiso));
        //add(new HorizontalLayout(verDetalles, btnOpenDialogGenerarComprobante));
    }
    
     public final void initComponentTitulo()
    {
        Label lblTitle = new Label("Lista de Permisos");
        lblTitle.setClassName("titulo");
        layTitle.add(lblTitle);
        layTitle.addClassName("centered-content");
    }
     
     public final void initEvents()
    {
         btnOpenDialogPermiso.addClickListener(e->
        {
            dialogGenerarPermiso.open();
        }); 
         
         btnGenerarPermiso.addClickListener(e->
        {
            onSavePermiso();
            notificationSuccess.setText("Se registro satisfactoriamente");
            notificationSuccess.open();    
            dialogGenerarPermiso.close();
            txtNombrePermiso.clear();
        }); 
    }
         
    public final void initDialogComponent()
    {
        
        dialogGenerarPermiso.setWidth("300px");
        FormLayout columnLayout = new FormLayout();  
        columnLayout.setResponsiveSteps(
                   new FormLayout.ResponsiveStep("5em", 1),
                   new FormLayout.ResponsiveStep("10em", 2));
        
        Label lblTitle = new Label("GENERAR PERMISO");
        columnLayout.add(lblTitle,2);
        columnLayout.add(txtNombrePermiso, 2);
        columnLayout.add(btnGenerarPermiso, 2);
        
        dialogGenerarPermiso.add(columnLayout);
    
    }
    
    public final void initGrids()        
    {
        
    }
    
        public final void initStyles()       
    {
        notificationError.setDuration(3000);
        notificationError.setPosition(Notification.Position.TOP_CENTER);
        notificationError.addThemeVariants(NotificationVariant.LUMO_ERROR);
        
        notificationSuccess.setDuration(3000);
        notificationSuccess.setPosition(Notification.Position.TOP_CENTER);
        notificationSuccess.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
        txtNombrePermiso.setPlaceholder("Nombre Permiso");
    }
        
    public abstract void onSavePermiso();
   
}
