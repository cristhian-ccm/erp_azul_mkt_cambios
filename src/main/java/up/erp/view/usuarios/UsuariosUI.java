/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.view.usuarios;

import com.upgrade.persistence.model.usros.Permiso;
import com.upgrade.persistence.model.usros.Rol;
import com.upgrade.persistence.model.usros.Usuario;
import com.upgrade.persistence.model.usros.UsuarioRol;
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
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.FlexComponent;






/**
 *
 * @author Diego Javier Quispe
 */
public abstract class UsuariosUI extends VerticalLayout{


    
    public final Button btnOpenDialogGenerarComprobante = new Button("Generar Comprobante", VaadinIcon.FILE_PROCESS.create());
    //public final Button btn = new Button("Generar", VaadinIcon.FILE_PROCESS.create());
    public final Button buscarUsuarios = new Button("Buscar",  VaadinIcon.SEARCH.create());
    public final Button verDetalles = new Button("Ver Detalles");
    public final HorizontalLayout layTitle = new HorizontalLayout();
    public final Grid<Usuario> gridUsuarios = new Grid<>();
    public final Dialog dialogGenerarComprobante = new Dialog();
    
    //public ComboBox<AlmacenFiltro> comboAlmacenes = new ComboBox<>();
    public final TextField buscarBySerie = new TextField();
    public final TextField buscarByNombre = new TextField();
 
    public final Notification notificationError= new Notification();
    public final Notification notificationSuccess= new Notification();
    public final TextArea observaciones = new TextArea();
    
    public final Button btnOpenAddRoles = new Button("Agregar Usuario Roles",  VaadinIcon.SEARCH.create());
    public final Button btnAddRolToUsuario = new Button("",  VaadinIcon.PLUS.create());
    public final Button btnDeleteRolToUsuario = new Button("",  VaadinIcon.PLUS.create());
    public final Dialog dialogAddRoles = new Dialog();
    public final Grid<UsuarioRol> gridUsuarioRoles = new Grid<>();
    
    public final Button btnOpenRoles = new Button("Roles",  VaadinIcon.SEARCH.create());
    public final Button btnOpenPermisos = new Button("Permisos",  VaadinIcon.SEARCH.create());

    public final Button btnAsistencia = new Button("Gestion Asistencia",  VaadinIcon.CLIPBOARD_CHECK.create());

    
    public final Dialog dialogRoles = new Dialog();
    public final Dialog dialogPermisos = new Dialog();
    
    public final ComboBox<Rol> comboRoles = new ComboBox<>();


    ////////////////////////////// USUARIOS GUSTAVO ////////////////////////////

    public final Label tituAsis = new Label("Check-In Asistencia Colaboradores");
    public final HorizontalLayout laytituAsis = new HorizontalLayout(tituAsis);

    public final TextField txtdni = new TextField("DNI : ");
    public final TextField txtNombre = new TextField("Nombre : ");
    public final TextField txtApellido = new TextField("Apellido: ");

    public final Label lbl_PREfecha = new Label("Fecha :");
    public final Label lbl_fecha = new Label("12/11/2020");
    public final HorizontalLayout layfecha = new HorizontalLayout(lbl_PREfecha,lbl_fecha);

    public final Label lbl_PREhora = new Label("Hora :");
    public final Label lbl_hora = new Label("09:05 a m");
    public final HorizontalLayout layhora = new HorizontalLayout(lbl_PREhora,lbl_hora);

    public final VerticalLayout layfechOra = new VerticalLayout(layfecha,layhora);

    public final VerticalLayout layControIZ = new VerticalLayout(txtdni,txtNombre,txtApellido,layfechOra);

    public final Image fotoUsuario = new Image();
    public final HorizontalLayout layImgNewBan = new HorizontalLayout(fotoUsuario);

    public final HorizontalLayout totalCont = new HorizontalLayout(layControIZ,layImgNewBan);
    
    



    /////////////////////////////////////////////////////


    
    public UsuariosUI()
    {
        initComponentTitulo();
        initDialogComponent();
        initButtonsEvents();
        initStyles();
        
        gridUsuarios.addColumn(Usuario::getNombrePersona).setHeader("Nombre").setAutoWidth(true);
        gridUsuarios.addColumn(Usuario::getIdentificadorPersona).setHeader("Identificador").setAutoWidth(true);
        gridUsuarios.addColumn(Usuario::getUsuario).setHeader("Nombre Usuario").setAutoWidth(true);
        
        gridUsuarioRoles.addColumn(UsuarioRol::getRolId).setHeader("Id").setAutoWidth(true);;
        gridUsuarioRoles.addColumn(UsuarioRol::getNombreRol).setHeader("Nombre").setAutoWidth(true);;
        
        add(layTitle);
        add(new HorizontalLayout(buscarByNombre, buscarUsuarios));
        add(gridUsuarios);
        //add(new HorizontalLayout(btnOpenAddRoles, btnOpenRoles, btnOpenPermisos));
        add(new HorizontalLayout(btnOpenAddRoles, btnOpenRoles, btnOpenPermisos,btnAsistencia));

        //add(new HorizontalLayout(fechaDesde, fechaHasta, buscarByNumero, buscarComprobantes));
        
        //add(new HorizontalLayout(verDetalles, btnOpenDialogGenerarComprobante));
    }



    ///////////////////////// open dialogs ///////////////////

    public final VerticalLayout layAsisColaboradores = new VerticalLayout(laytituAsis,totalCont);
    public final Dialog DialogAsis = new Dialog(layAsisColaboradores);



    
    
     public final void initComponentTitulo()
    {
        Label lblTitle = new Label("Lista de Usuarios");
        lblTitle.setClassName("titulo");
        layTitle.add(lblTitle);
        layTitle.addClassName("centered-content");
        buscarBySerie.setPlaceholder("[Buscar por Serie]");
        buscarByNombre.setPlaceholder("[Buscar por Nombre]");
        
    }
     
         
    public final void initDialogComponent()
    {
        
        dialogAddRoles.setWidth("300px");
        FormLayout columnLayout = new FormLayout();  
        columnLayout.setResponsiveSteps(
                   new FormLayout.ResponsiveStep("5em", 1),
                   new FormLayout.ResponsiveStep("10em", 2));
        
        Label lblTitle = new Label("GENERAR COMPROBANTE");
        //columnLayout.add(lblTitle,2);
        //columnLayout.add(new Label("¿Está seguro que desea generar el comprobante?"),2);
        //columnLayout.add(btnGenerarComprobante,2);
        
        
        dialogAddRoles.setWidth("400px");
        FormLayout formUsuarioRol = new FormLayout();  
        formUsuarioRol.setResponsiveSteps(
                   new FormLayout.ResponsiveStep("10em", 1),
                   new FormLayout.ResponsiveStep("20em", 2));
        formUsuarioRol.add(comboRoles,2);
        formUsuarioRol.add(gridUsuarioRoles,2);
        formUsuarioRol.add(btnAddRolToUsuario,1);
        formUsuarioRol.add(btnDeleteRolToUsuario,1);
        dialogAddRoles.add(formUsuarioRol);
        


       






    }
    
    public final void initDialogRoles(){
        dialogRoles.setWidth("500px");
        //dialogRoles.setCloseOnOutsideClick(false);
        
        /*dialogRoles.add(closeDialogCobranzas);
        dialogRoles.add(new ReciboView(String.valueOf(gridOrdenesVenta.asSingleSelect().getValue().getId())));*/
        dialogRoles.add(new RolesView());
    }
    
    public final void initDialogPermisos(){
        dialogPermisos.setWidth("500px");
        //dialogPermisos.setCloseOnOutsideClick(false);
        
        /*dialogPermisos.add(closeDialogCobranzas);
        dialogPermisos.add(new ReciboView(String.valueOf(gridOrdenesVenta.asSingleSelect().getValue().getId())));*/
        dialogPermisos.add(new PermisosView());
    }
    



     public final void initButtonsEvents()
    {
        btnAddRolToUsuario.addClickListener(e->
        {
            onAddUsuarioRol();
            notificationSuccess.setText("Se agrego satisfactoriamente");
            notificationSuccess.open(); 
            //dialogAddRoles.open();
        });  


        btnAsistencia.addClickListener(e->{

            DialogAsis.open();

        });






        
        buscarUsuarios.addClickListener(e->
        {
            onGetUsuariosByNombre();
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
        });  
        
        btnOpenRoles.addClickListener(e->
        {
            dialogRoles.removeAll();
            initDialogRoles();
            dialogRoles.open();
        });  
        
        btnOpenPermisos.addClickListener(e->
        {
            dialogPermisos.removeAll();
            initDialogPermisos();
            dialogPermisos.open();
        });  
        
    }



    

    
    

    



    public final void initStyles()       
    {
        notificationError.setDuration(3000);
        notificationError.setPosition(Notification.Position.TOP_CENTER);
        notificationError.addThemeVariants(NotificationVariant.LUMO_ERROR);
        
        notificationSuccess.setDuration(3000);
        notificationSuccess.setPosition(Notification.Position.TOP_CENTER);
        notificationSuccess.addThemeVariants(NotificationVariant.LUMO_SUCCESS);


        layfechOra.getStyle().set("border", "1px solid #9E9E9E");
        layfechOra.setWidth("30%");


        
        tituAsis.getStyle().set("fontWeight","bold");
        tituAsis.getStyle().set("fontSize","150%");

        laytituAsis.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laytituAsis.setAlignItems(FlexComponent.Alignment.CENTER);
        laytituAsis.setWidthFull(); 


        fotoUsuario.setVisible(true);
        fotoUsuario.setEnabled(true);
        fotoUsuario.setHeight("180px");
        fotoUsuario.setWidth("180px");

        DialogAsis.setHeight("65%");
        DialogAsis.setWidth("65%");

        txtdni.setWidth("88%");
        txtNombre.setWidth("88%");
        txtApellido.setWidth("88%");

        layControIZ.setWidth("88%");
        totalCont.setWidthFull();






    }
        
    public abstract void onGetUsuariosRoles();
    public abstract void onAddUsuarioRol();
    public abstract void onGetUsuariosByNombre();



   
}
