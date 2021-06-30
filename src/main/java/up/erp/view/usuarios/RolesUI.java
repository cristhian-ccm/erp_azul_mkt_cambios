/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.view.usuarios;

import com.upgrade.persistence.model.usros.Permiso;
import com.upgrade.persistence.model.usros.Rol;
import com.upgrade.persistence.model.usros.RolPermiso;
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

/**
 *
 * @author Diego Javier Quispe
 */
public abstract class RolesUI extends VerticalLayout{
    
    public Button btnOpenDialogGenerarComprobante = new Button("Generar Comprobante", VaadinIcon.FILE_PROCESS.create());
    public Button btnGenerarComprobante = new Button("Generar", VaadinIcon.FILE_PROCESS.create());
    public Button buscarComprobantes = new Button("Buscar",  VaadinIcon.SEARCH.create());
    public Button btnOpenAddRol = new Button("Agregar Rol",  VaadinIcon.SEARCH.create());
    public Button btnGenerarRol = new Button("Agregar",  VaadinIcon.SEARCH.create());
    public final TextField txtNombreRol = new TextField();
    
    public Button btnOpenAddPermisos = new Button("Agregar Rol Permisos ",  VaadinIcon.SEARCH.create());
    public Button btnAddPermisoToRol = new Button("",  VaadinIcon.PLUS.create());
    
    public Button verDetalles = new Button("Ver Detalles");
    public HorizontalLayout layTitle = new HorizontalLayout();
    public final Grid<Rol> gridRoles = new Grid<>();
    public final Grid<RolPermiso> gridRolPermisos = new Grid<>();
    
    public final Dialog dialogAddRol = new Dialog();
    public final Dialog dialogAddPermisos = new Dialog();
    
    public final Notification notificationError= new Notification();
    public final Notification notificationSuccess= new Notification();
    
    public final ComboBox<Permiso> comboPermisos = new ComboBox<>();

    
    public RolesUI()
    {
        initComponentTitulo();
        initDialogComponent();
        initStyles();
        initButtonsEvents();
        initGrids();
        
        gridRoles.addColumn(Rol::getId).setHeader("Id").setAutoWidth(true);
        gridRoles.addColumn(Rol::getNombre).setHeader("Nombre").setAutoWidth(true);
        
        add(layTitle);
        //add(new HorizontalLayout(fechaDesde, fechaHasta, buscarByNumero, buscarComprobantes));
        add(gridRoles);
        add(new HorizontalLayout(btnOpenAddRol, btnOpenAddPermisos));
        //add(new HorizontalLayout(verDetalles, btnOpenDialogGenerarComprobante));
    }
    
     public final void initComponentTitulo()
    {
        Label lblTitle = new Label("Lista de Roles");
        lblTitle.setClassName("titulo");
        layTitle.add(lblTitle);
        layTitle.addClassName("centered-content");
        
    }
     
    public final void initButtonsEvents()
    {
        btnOpenAddRol.addClickListener(e->
        {
            dialogAddRol.open();
        });  
        
        btnAddPermisoToRol.addClickListener(e->
        {
            onAddRolPermiso();
            notificationSuccess.setText("Se registro satisfactoriamente");
            notificationSuccess.open();    
        });  
        
        btnOpenAddPermisos.addClickListener(e->
        {
            if (!gridRoles.asSingleSelect().isEmpty()){  
                onGetRolPermisos();
                dialogAddPermisos.open();
            }
            else
            {
                notificationError.setText("Necesita seleccionar un elemento");
                notificationError.open();                
            }
        });  
        
         btnGenerarRol.addClickListener(e->
        {
            onSaveRol();
            notificationSuccess.setText("Se registro satisfactoriamente");
            notificationSuccess.open();    
            dialogAddRol.close();
            txtNombreRol.clear();
        }); 
    }
         
    public final void initDialogComponent()
    {
        dialogAddRol.setWidth("300px");
        FormLayout formLayoutRol = new FormLayout();  
        formLayoutRol.setResponsiveSteps(
                   new FormLayout.ResponsiveStep("5em", 1),
                   new FormLayout.ResponsiveStep("10em", 2));
        formLayoutRol.add(txtNombreRol, 2);
        formLayoutRol.add(btnGenerarRol, 2);
        dialogAddRol.add(formLayoutRol);
        
        dialogAddPermisos.setWidth("400px");
        FormLayout formLayoutRolPermisos = new FormLayout();  
        formLayoutRolPermisos.setResponsiveSteps(
                   new FormLayout.ResponsiveStep("5em", 1),
                   new FormLayout.ResponsiveStep("10em", 2),
                   new FormLayout.ResponsiveStep("15em", 3));
        formLayoutRolPermisos.add(comboPermisos,2);
        formLayoutRolPermisos.add(btnAddPermisoToRol,1);
        formLayoutRolPermisos.add(gridRolPermisos,3);
        dialogAddPermisos.add(formLayoutRolPermisos);
        
       
    
    }
    
       public final void initGrids()        
    {
        gridRolPermisos.addColumn(RolPermiso::getPermisoId).setHeader("Id").setAutoWidth(true);;
        gridRolPermisos.addColumn(RolPermiso::getNombrePermiso).setHeader("Accion").setAutoWidth(true);;
    }
    
        public final void initStyles()       
    {
        notificationError.setDuration(3000);
        notificationError.setPosition(Notification.Position.TOP_CENTER);
        notificationError.addThemeVariants(NotificationVariant.LUMO_ERROR);
        
        notificationSuccess.setDuration(3000);
        notificationSuccess.setPosition(Notification.Position.TOP_CENTER);
        notificationSuccess.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
    }
        
    public abstract void onGetRolPermisos();
    public abstract void onAddRolPermiso();
    public abstract void onSaveRol();
   
}
