/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.view.produccion;

import com.upgrade.persistence.model.produccion.Transformacion;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.data.renderer.NumberRenderer;
import com.vaadin.flow.data.renderer.TemplateRenderer;
import java.text.NumberFormat;

/**
 *
 * @author Diego-Javier
 */
public abstract class TransformacionesUI extends VerticalLayout{
    
    public final HorizontalLayout layTitle = new HorizontalLayout();
    public final Grid<Transformacion> gridTransformaciones = new Grid<>();
    public final Button btnTransformacion = new Button("Nueva Transformación", VaadinIcon.INSERT.create());
    public final Button btnContinuarTransformacion = new Button("Continuar Transformación", VaadinIcon.HAMMER.create());
    public final Notification notification = new Notification();
    
    public TransformacionesUI(){
        initComponentTitulo();
        initEvents();
        initStyles();
        
        addClassName("centered-content");
        
        gridTransformaciones.addColumn(Transformacion::getId).setHeader("Id").setFlexGrow(0).setWidth("15%");
        gridTransformaciones.addColumn(Transformacion::getNumeroPlantillaTransformacion).setHeader("Nº plantilla").setFlexGrow(0).setWidth("20%");
        gridTransformaciones.addColumn(Transformacion::getNumeroTransformaciones).setHeader("Nº transformaciones").setFlexGrow(0).setWidth("20%");
        gridTransformaciones.addColumn(Transformacion::getTransformacionesRealizadas).setHeader("Nº realizadas").setFlexGrow(0).setWidth("20%");
        
        //gridTransformaciones.addColumn(Transformacion::getEstado).setHeader("Estado");
        
                
        gridTransformaciones.addColumn(new ComponentRenderer<>(item -> {
            Button lblEstado = new Button();
            lblEstado.setDisableOnClick(true);
            if(item.getEstado() == 1){
                lblEstado.setText("Cerrada");
                lblEstado.addClassName("cerrada-" + String.valueOf(item.getEstado()));
            }
            else{
                lblEstado.setText("En proceso");
                lblEstado.addClassName("en_proceso-" + String.valueOf(item.getEstado()));
            }
            //lblEstado.addClassName("style-" + String.valueOf(item.getEstado()));
            return lblEstado;
        })).setHeader("Name");
        
        add(layTitle, gridTransformaciones);
        add(new HorizontalLayout(btnTransformacion, btnContinuarTransformacion));
    }
    
    public final void initEvents()
    {
        btnTransformacion.addClickListener(e->
        {   
            removeAll();
            onOpenTransformacion();
        });
        
         btnContinuarTransformacion.addClickListener(e->
        {   
            if (!gridTransformaciones.asSingleSelect().isEmpty()){  
                //if(gridTransformaciones.asSingleSelect().getValue().getEstado() != 1)
                if(true)
                {
                    removeAll();
                    onContinuarTransformacion();
                }
                else{
                    notification.setText("La transformacion esta cerrada.");
                    notification.open();
                }
            }
            else
            {
                notification.setText("Necesita seleccionar un elemento");
                notification.open();                
            }
           
        });
    }
    
    public final void initComponentTitulo()
    {
        Label lblTitle = new Label("TRANSFORMACIONES");
        lblTitle.setClassName("titulo");
        layTitle.add(lblTitle);
        layTitle.addClassName("centered-content");
    }
    
    public final void initStyles()
    {
        setWidthFull();
        notification.setDuration(3000);
        notification.setPosition(Notification.Position.TOP_CENTER);
        notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
    }
    
    public abstract void onOpenTransformacion();
    public abstract void onContinuarTransformacion();
}
