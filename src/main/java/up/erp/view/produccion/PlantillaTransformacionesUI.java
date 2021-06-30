/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.view.produccion;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;


/**
 *
 * @author Upgrade - PC
 */
//@Route("")
//@PWA(name = "Project Base for Vaadin", shortName = "Project Base", enableInstallPrompt = false)
//@CssImport("./styles/shared-styles.css")
//@CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
public abstract class PlantillaTransformacionesUI extends VerticalLayout{
    
    HorizontalLayout layTitle = new HorizontalLayout();
    HorizontalLayout layFootButtons = new HorizontalLayout();
    public final Grid<PlantTransformacion> gridPlantillas = new Grid<>();
    public final Notification notification = new Notification();
    
    public PlantillaTransformacionesUI()
    {   
        initComponentTitulo();
        initStyles();
        
        gridPlantillas.addColumn(PlantTransformacion::getId).setHeader("Id").setFlexGrow(0).setWidth("10em");
        gridPlantillas.addColumn(PlantTransformacion::getNumero).setHeader("Numero Plantilla").setFlexGrow(0).setWidth("20em");
        gridPlantillas.addColumn(PlantTransformacion::getNombre).setHeader("Producto Plantilla");
               

        Button btnCrearPT = new Button("Crear Plantilla de Transformación", VaadinIcon.INSERT.create());
        btnCrearPT.addClickListener(e->{
            removeAll();
            onBtnOpenCrearPlantillaTransformacion();
            
        });
        
        Button btnActualizarPT = new Button("Actualizar Plantilla de Transformación", VaadinIcon.HAMMER.create());
        btnActualizarPT.addClickListener(e->{
            if (!gridPlantillas.asSingleSelect().isEmpty()){                
                removeAll();
                onBtnOpenActualizarPlantillaTransformacion();
            }
            else
            {
                notification.open();
            }
            
        });
        
        Button btnCrearTransformacion = new Button("Realizar Transformacion", VaadinIcon.HAMMER.create());
        btnCrearTransformacion.addClickListener(e->{
            if (!gridPlantillas.asSingleSelect().isEmpty()){                
                removeAll();
                onBtnOpenCrearTransformacion();
            }
            else
            {
                notification.open();
            }
            
        });
        
        layFootButtons.add(btnCrearPT, btnActualizarPT);
        add(layTitle, gridPlantillas, layFootButtons);
    }
    
    public final void initComponentTitulo()
    {
        Label lblTitle = new Label("PLANTILLAS DE TRANSFORMACIÓN");
        lblTitle.setClassName("titulo");
        layTitle.add(lblTitle);
        layTitle.addClassName("centered-content");
    }
    
    public void dialogSuccess()
    {
        
        Dialog dialogSuccess = new Dialog();
        Label txtDialog = new Label("Agregado Satisfactoriamente");
        dialogSuccess.add(txtDialog);               
    }
     
    public void initStyles()
    {        
        setWidthFull();
        notification.setText("Necesita seleccionar un elemento");
        notification.setDuration(3000);
        notification.setPosition(Notification.Position.TOP_CENTER);
        notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
        
    }
    
    public abstract void onBtnOpenCrearPlantillaTransformacion();
    public abstract void onBtnOpenActualizarPlantillaTransformacion();
    public abstract void onBtnOpenCrearTransformacion();
    public abstract String onProbar();
    //public  abstract void onBtnGuardarProducto();
    
    /*Image logo = new Image("frontend/lenovo_1.jpg", "logo");
    logo.setHeight("100%");
    logo.setWidth("100%");
    Dialog dialogo = new Dialog();
    dialogo.setHeight("400px");
    dialogo.setWidth("400px");
    dialogo.add(logo);
    dialogo.open();*/

}