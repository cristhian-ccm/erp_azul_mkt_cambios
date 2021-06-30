/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.view.carterizacion;

import com.upgrade.persistence.model.tcros.Direccion;
import com.upgrade.persistence.model.tcros.Persona;
import com.upgrade.persistence.model.usros.Rol;
import com.upgrade.persistence.model.usros.Usuario;
import com.upgrade.persistence.model.usros.UsuarioRol;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
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
import java.util.ArrayList;
import up.erp.view.produccion.Mensaje;
/**
 *
 * @author Upgrade - PC
 */
public abstract class CarterizacionesUI extends VerticalLayout{
    
    public final Button btnOpenDialogGenerarComprobante = new Button("Generar Comprobante", VaadinIcon.FILE_PROCESS.create());
    //public final Button btn = new Button("Generar", VaadinIcon.FILE_PROCESS.create());
    
    public final Button verDetalles = new Button("Ver Detalles");
    public final HorizontalLayout layTitle = new HorizontalLayout();
    public final Grid<Direccion> gridClientes = new Grid<>();
    
    //public ComboBox<AlmacenFiltro> comboAlmacenes = new ComboBox<>();
    public final TextField buscarByNombre = new TextField();
    public final Button buscarVendedor = new Button("Buscar",  VaadinIcon.SEARCH.create());
//    public final TextField buscarByNombre = new TextField();
 
    public final Notification notificationError= new Notification();
    public final Notification notificationInfo = new Notification();
    public final Notification notificationSuccess= new Notification();
    public final TextArea observaciones = new TextArea();
    
    
    public final Grid<PersonaCarterizada> gridPersonaCarterizada = new Grid<>();
    
    public final ComboBox<Usuario> comboVendedores = new ComboBox<>();
    
    public final Button btnAddCliente = new Button("",  VaadinIcon.PLUS.create());
    public final Button btnDeleteCliente = new Button("",  VaadinIcon.MINUS.create());
    
    public final Dialog dialogAddCliente = new Dialog();
 
    public final TextField txtPersonaNombre = new TextField();
    public final Button btnBuscarPersonas = new Button("Buscar",  VaadinIcon.SEARCH.create());
    
    public final Button btnCabmiarACartera = new Button("Cambiar de Cartera",  VaadinIcon.PLUS.create());
    
    
    public CarterizacionesUI()
    {
        initComponentTitulo();
        initDialogComponent();
        initButtonsEvents();
        initStyles();
        
        gridClientes.addColumn(Direccion::getId).setHeader("Id").setAutoWidth(true);
        gridClientes.addColumn(Direccion::getNombrePersona).setHeader("Nombre").setAutoWidth(true);
        gridClientes.addColumn(Direccion::getDescripcion).setHeader("Dirección").setAutoWidth(true);
        
        gridPersonaCarterizada.addColumn(PersonaCarterizada::getIdPersona).setHeader("Id").setAutoWidth(true);;
        gridPersonaCarterizada.addColumn(PersonaCarterizada::getNombre).setHeader("Nombre").setAutoWidth(true);;
        gridPersonaCarterizada.addColumn(PersonaCarterizada::getIdentificador).setHeader("Documento").setAutoWidth(true);;
        gridPersonaCarterizada.addColumn(PersonaCarterizada::getNombreCarterizadoPor).setHeader("Carterizado Por").setAutoWidth(true);;
        
        add(layTitle);
        add(new HorizontalLayout(buscarByNombre, buscarVendedor, comboVendedores));
        add(gridClientes);
        add(new HorizontalLayout(btnAddCliente, btnDeleteCliente));
        //add(new HorizontalLayout(fechaDesde, fechaHasta, buscarByNumero, buscarComprobantes));
        
        //add(new HorizontalLayout(verDetalles, btnOpenDialogGenerarComprobante));
    }
    
     public final void initComponentTitulo()
    {
        Label lblTitle = new Label("Carterización de Clientes");
        lblTitle.setClassName("titulo");
        layTitle.add(lblTitle);
        layTitle.addClassName("centered-content");
        //buscarBySerie.setPlaceholder("[Buscar por Serie]");
        buscarByNombre.setPlaceholder("[Buscar por Nombre]");
        
    }
     
         
    public final void initDialogComponent()
    {    
        dialogAddCliente.setWidth("600px");
        FormLayout formPersonas = new FormLayout();  
        formPersonas.setResponsiveSteps(
                   new FormLayout.ResponsiveStep("5em", 1),
                   new FormLayout.ResponsiveStep("10em", 2),
                   new FormLayout.ResponsiveStep("15em", 3));
        //formUsuarioRol.add(comboRoles,2);
       
        formPersonas.add(txtPersonaNombre, 2);
        formPersonas.add(btnBuscarPersonas, 1);
        formPersonas.add(gridPersonaCarterizada,3);
        dialogAddCliente.add(formPersonas);
        dialogAddCliente.add(btnCabmiarACartera);
   
        comboVendedores.setPlaceholder("[Lista de Vendedores]");
        comboVendedores.setWidth("400px");
    
    }
    
     public final void initButtonsEvents()
    {
        buscarVendedor.addClickListener(e->
        {
            onGetUsuariosByNombre();
        });  
        
        comboVendedores.addValueChangeListener(e->
        {
            if(!comboVendedores.isEmpty()){
                Mensaje response = onGetClientesCarterizados();
                if(!response.isTipo()){
                    notificationInfo.setText(response.getMensaje());
                    notificationInfo.open();    
                }
            }
        });  
        
        btnAddCliente.addClickListener(e->{
            if(!comboVendedores.isEmpty()){
                txtPersonaNombre.clear();
                gridPersonaCarterizada.setItems(new ArrayList<>());
                dialogAddCliente.open();}
            else{
                notificationError.setText("Necesita seleccionar primero a un vendedor");
                notificationError.open();     
            }
        });
        
        btnBuscarPersonas.addClickListener(e->{
            onGetPersonas();
        });
        
        btnCabmiarACartera.addClickListener(e->{
            onCambiardeCartera();
        });
        /*btnAddRolToUsuario.addClickListener(e->
        {
            onAddUsuarioRol();
            notificationSuccess.setText("Se agrego satisfactoriamente");
            notificationSuccess.open(); 
            //dialogAddRoles.open();
        });  
        
        
        
        btnOpenAddRoles.addClickListener(e->
        {
            if (!gridUsuarios.asSingleSelect().isEmpty()){  
                onGetUsuariosRoles();
                dialogAddRoles.open();
            }
            else
            {
                notificationError.setText("Necesita seleccionar un elemento");
                notificationError.open();                
            }
        });  */
    }
    
    public final void initStyles()       
    {
        notificationError.setDuration(3000);
        notificationError.setPosition(Notification.Position.TOP_CENTER);
        notificationError.addThemeVariants(NotificationVariant.LUMO_ERROR);
        
        notificationSuccess.setDuration(3000);
        notificationSuccess.setPosition(Notification.Position.TOP_CENTER);
        notificationSuccess.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
        
        notificationInfo.setDuration(3000);
        notificationInfo.setPosition(Notification.Position.TOP_CENTER);
        notificationInfo.addThemeVariants(NotificationVariant.LUMO_CONTRAST);
        
        buscarVendedor.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        btnAddCliente.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        btnDeleteCliente.addThemeVariants(ButtonVariant.LUMO_ERROR); 
        
        txtPersonaNombre.setPlaceholder("[Búsque por Nombre o DNI]");
    }
    
    public abstract void onGetUsuariosByNombre();
    public abstract Mensaje onGetClientesCarterizados();
    public abstract void onGetPersonas();   
    public abstract Mensaje onGetClientesCarterizadosDistinct();
    public abstract void onCambiardeCartera();
    
}
