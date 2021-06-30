/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.view.produccion;

import com.upgrade.persistence.model.extcs.Producto;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;

/**
 *
 * @author Diego-Javier
 */
public abstract class PlantillaTransformacionUI extends VerticalLayout{
    
    public final HorizontalLayout layTitle = new HorizontalLayout();
    public final HorizontalLayout layTextArea = new HorizontalLayout();
    //public final TextField txtCodigoProducto = new TextField("Código de Producto");
    
    /*Datos Cabecera*/
    public final HorizontalLayout layDatosCab = new HorizontalLayout();
    public final TextField txtCodigoProductoCab = new TextField();
    public final ComboBox<Producto> comboProductoCab = new ComboBox<>();
    public final Button btnBuscarCab = new Button("Buscar", VaadinIcon.SEARCH.create());
    
    
    public final TextField txtCodigoProducto = new TextField();
    //public final Grid<PlantillaTransformacion> gridProductos = new Grid<>(PlantillaTransformacion.class);
    public final Grid<DatosPlantilla> gridProductos = new Grid<>();
    public final Button btnBuscar = new Button("Buscar ", VaadinIcon.SEARCH.create());
    
    /*Foot Buttons*/
    public final Button btnAgregar = new Button("Agregar", VaadinIcon.PLUS_CIRCLE.create());
    public final Button btnQuitar = new Button("Quitar", VaadinIcon.MINUS_CIRCLE.create());
    public final Button btnCrearPlantilla = new Button("Crear Plantilla", VaadinIcon.CHECK_CIRCLE.create());
    public final Button btnVentanaPrincipal = new Button("Atrás", VaadinIcon.CHEVRON_LEFT.create());
    
    public final ComboBox<Producto> comboProducto = new ComboBox<>();
    public final TextArea textObservaciones = new TextArea("Observaciones");
    public final TextField txtCantidad = new TextField();
    
    /*Componentes Dialog*/
    public final Dialog addItemDialog = new Dialog();
    public final VerticalLayout layVertDialog = new VerticalLayout();
    public final Button btnDialogAdd = new Button("Agregar Item");
    
    public final Button btnDialogAgregar = new Button("Agregar");
    public final Button btnDialogCancelar = new Button("Cancelar");
    
    
    public PlantillaTransformacionUI(){        
        initComponentTitulo();
        initComponentDatosCabecera();
        
        //gridProductos.addColumn(DatosPlantilla::getId).setHeader("Id").setWidth("4px");
        gridProductos.addColumn(DatosPlantilla::getNombre).setHeader("Nombre");
        gridProductos.addColumn(DatosPlantilla::getMarca).setHeader("Marca");
        gridProductos.addColumn(DatosPlantilla::getCantidad).setHeader("Cantidad").setWidth("2em");
        
        //laySelect.addClassName("centered-content");
                
        HorizontalLayout footButtons = new HorizontalLayout();
        footButtons.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        
        //footButtons.add(btnVentanaPrincipal);
        footButtons.add(btnAgregar);
        footButtons.add(btnQuitar);
        footButtons.add(btnCrearPlantilla);
        
        setWidthFull();
        addClassName("centered-content");
        
        btnAgregar.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        btnQuitar.addThemeVariants(ButtonVariant.LUMO_ERROR);
        btnCrearPlantilla.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        
        btnDialogAgregar.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        btnDialogCancelar.addThemeVariants(ButtonVariant.LUMO_ERROR);
        
        //events
        txtCodigoProductoCab.addValueChangeListener(e->onBtnListarPorCodigoCab());
        btnBuscar.addClickListener(e->{
            onBtnListarPorCodigo();
        });
        btnBuscarCab.addClickListener(e->onBtnListarPorCodigoCab());
        
        
        Div content = new Div();
        content.getStyle().set("color","white");
        content.getStyle().set("background","green");
        content.addClassName("my-style");
        content.setText("This component is styled using global styles");

        Notification notificationSuccess = new Notification();
        notificationSuccess.setDuration(3000);
        notificationSuccess.setText("Agregado Satisfactoriamente");
        notificationSuccess.setPosition(Notification.Position.TOP_CENTER);
        notificationSuccess.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
        
        Notification notificationError = new Notification();
        notificationError.setDuration(3000);
        notificationError.setPosition(Notification.Position.TOP_CENTER);
        notificationError.addThemeVariants(NotificationVariant.LUMO_ERROR);
        
        
        btnDialogAgregar.addClickListener(e->
            {
                if(!(comboProducto.isEmpty() || txtCantidad.isEmpty())){
                    
                    notificationSuccess.open(); 
                    onBtnAddProducto();
                    addItemDialog.close();
                    
                    txtCodigoProducto.clear();
                    comboProducto.clear();
                    txtCantidad.clear();
                }
                else
                {
                    notificationError.setText("Existen campos vacios");  
                    
                    notificationError.open();
                }
            }
        );
        
        btnDialogCancelar.addClickListener(e -> 
        {
            addItemDialog.close();
            txtCodigoProducto.clear();
            comboProducto.clear();
            txtCantidad.clear();
        });
        //  Notification.Type.HUMANIZED_MESSAGE);
        
//        btnVentanaPrincipal.addClickListener(
//            e -> {
//                removeAll();
//                add(new PlantillaTransformacionView());}
//        );
        btnAgregar.addClickListener(e -> addItemDialog.open());
        btnQuitar.addClickListener(e -> {
                if (!gridProductos.asSingleSelect().isEmpty()){
                    onBtnDeleteProducto();
                }    
            });
        
        btnCrearPlantilla.addClickListener(e->
            {   
                if(!(comboProductoCab.isEmpty() || textObservaciones.isEmpty()))
                {                
                    notificationSuccess.open();
                    onBtnGuardarPlantilla();            
                }
                else{
                    notificationError.setText("Llene todos los campos");                        
                    notificationError.open();        
                }
            }
        );
 
        componentDialogFormAgregar();
        
        add(layTitle, layDatosCab, layTextArea, gridProductos, footButtons);    
    }
    
    public final void initComponentTitulo()
    {
        Label lblTitle = new Label("GENERAR PLANTILLA DE TRANSFORMACIÓN");
        lblTitle.setClassName("titulo");
        layTitle.add(lblTitle);
        layTitle.addClassName("centered-content");
    }
    
    public final void initComponentDatosCabecera()
    {
        txtCodigoProductoCab.setPlaceholder("Código Producto");
        txtCodigoProductoCab.setRequired(true);
        comboProductoCab.setPlaceholder("[Seleccione un producto]");
        layDatosCab.add(txtCodigoProductoCab, btnBuscarCab, comboProductoCab);
        layDatosCab.addClassName("centered-content");
        
        textObservaciones.setPlaceholder("Escriba aqui detalles sobre la plantilla...");
        textObservaciones.getStyle().set("width", "760px");
        //textObservaciones.getStyle().set("width", "800px");
        layTextArea.add(textObservaciones);
        layTextArea.addClassName("centered-content");        
    }
    
    public final void componentDialogFormAgregar()
    {
        Label lblTitulo = new Label("Agregar");
        lblTitulo.setClassName("titulo");
        txtCantidad.setRequired(true);
        comboProducto.setRequired(true);
        
        addItemDialog.setWidth("30em");
        addItemDialog.setHeight("20em");
        
        FormLayout columnLayout = new FormLayout();
        
        columnLayout.setResponsiveSteps(
                   new FormLayout.ResponsiveStep("10em", 1),
                   new FormLayout.ResponsiveStep("20em", 2),
                   new FormLayout.ResponsiveStep("30em", 3));
        
           //columnLayout.add(firstName, lastName,  nickname, email, website); 
           
           columnLayout.add(lblTitulo, 2);
           columnLayout.add(new Hr(),2);
           columnLayout.add(txtCodigoProducto, 1);
           columnLayout.add(btnBuscar, 1);
           columnLayout.add(comboProducto, 2);
           columnLayout.add(txtCantidad, 2);
           columnLayout.add(new Hr(),2);
           columnLayout.add(btnDialogAgregar, btnDialogCancelar); 
           
           txtCodigoProducto.setPlaceholder("Código Producto");
           comboProducto.setPlaceholder("[Seleccione Producto]");
           txtCantidad.setPlaceholder("Cantidad");
           
           //columnLayout.setColspan(website, 2);
           
           //columnLayout.add(description, 3);
        addItemDialog.add(columnLayout);
    }
    
    public abstract void onBtnListarPorCodigoCab();
    public abstract void onBtnListarPorCodigo();
    public abstract void onBtnAddProducto();
    public abstract void onBtnDeleteProducto();
    public abstract void onBtnGuardarPlantilla();
    public abstract String onProbar();
    
}
