/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.view.produccion;

import com.upgrade.persistence.model.extcs.Articulo;
import com.upgrade.persistence.model.extcs.OrdenDet;
import com.upgrade.persistence.model.extcs.Producto;
import com.upgrade.persistence.model.produccion.PlantillaTransformacion;
import com.upgrade.persistence.model.produccion.Transformacion;
import com.upgrade.persistence.model.produccion.TransformacionDet;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;

/**
 *
 * @author Upgrade - PC
 */
public abstract class TransformacionUI extends VerticalLayout {
    public final HorizontalLayout layTitle = new HorizontalLayout();
    public final Label lblTitle = new Label();
    public final Label dialogTitle = new Label("GENERAR");
    public final Dialog dialogGenerar = new Dialog();
    public final ComboBox<PlantillaTransformacion> cmbPlantillas = new ComboBox();
    public final Button btnDialogGenerar = new Button("Generar y Continuar");
    public final Button btnDialogCerrar = new Button("Cerrar");
    
    public final Dialog dialogVisualizarItems = new Dialog();
    public final Grid<OrdenDet> gridVisualizarItems = new Grid<>();
    public final TextField txtSerieModificar = new TextField();
    public final Button btnDialogVIModificar = new Button("Modificar");
    public final Button btnDialogVICerrar = new Button("Cerrar");
    
    public final ComboBox<Producto> comboProducto = new ComboBox<>();
    
    public final TextField txtNumeroPlantillas = new TextField();
    public final Grid<Transformacion> gridTransformacion = new Grid<>();
    public final Grid<TransformacionDet> gridTransformacionDet = new Grid<>();
    public final Grid<DatosTransformacion> gridItem = new Grid<>();
    
    public final Grid<OrdenDet> gridAllItems = new Grid<>();
    public final Dialog dialogAllItems = new Dialog();
    
    public final TextField codigoProducto = new TextField();
    
    public final Button btnCrearTransformacion = new Button("Crear");

    public final Button btnAgregar = new Button("Agregar",  VaadinIcon.PLUS_CIRCLE.create());
    public final Button btnVisualizarItems = new Button("Visualizar", VaadinIcon.SEARCH.create());
    public final Button btnVisualizarAllItems = new Button("All Items", VaadinIcon.SEARCH.create());
    public final Button btnCerrarTransformacion = new Button("Cerrar Transformación", VaadinIcon.BAN.create());
    
    public final Label lblNombreProducto = new Label();
    public final TextField txtSerieProducto = new TextField();
    public final TextField txtSerieArticuloFinal = new TextField();
    
    public final Notification notificationSuccess= new Notification();
    public final Notification notificationError= new Notification();
    public final Notification notification = new Notification();
    
    public final Label lblCantidad = new Label();

    
    public final TextField txtSerieArticulo = new TextField();
    public final ComboBox<Articulo> cmbArticulos = new ComboBox();
    public final TextField txtTransformacion = new TextField();
    public final Button btnActualizarTransformacion = new Button("Actualizar", VaadinIcon.CHECK_CIRCLE.create());
    
    public TransformacionUI(){
        initStyles();
        initComponentTitulo();
        dialogGenerar();
        initEvents();
        initGrids();
        dialogVisualizarItems();
        dialogAllItems();
        
        /*gridTransformacionDet.addColumn(TransformacionDet::getId).setHeader("Nombre Producto").setFlexGrow(0).setWidth("10em");*/
       
        
        
        add(layTitle);
        //add(new HorizontalLayout(codigoProducto, comboProducto, txtNumeroPlantillas, btnCrearTransformacion));
        add(new HorizontalLayout(codigoProducto, cmbPlantillas, txtNumeroPlantillas, btnCrearTransformacion));
        add(new HorizontalLayout(btnAgregar, btnVisualizarItems, btnVisualizarAllItems, btnCerrarTransformacion));
        add(gridTransformacion, gridTransformacionDet);
       
    }      
    
    public final void initEvents()
    {
        btnCrearTransformacion.addClickListener(e->
        {
            if(!codigoProducto.isEmpty() && !txtNumeroPlantillas.isEmpty()){
                onBtnGenerar();
                onCargarDatosGrids();
                /*if(onFindPlantillaTransformacion()){            
                    
                    onBtnGenerar();
                    onCargarDatosGrids();
                }
                else{
                    notificationError.setText("No se encontro una plantilla para el producto seleccionado");
                    notificationError.open();
                }*/
            }
            else{
                notificationError.setText("Debe llenar todos los campos.");
                notificationError.open();
            }
            
        });
        
        btnAgregar.addClickListener(e->{
            dialogGenerar.open();
           // onLoadItem();
        });
        
        btnVisualizarItems.addClickListener(e->{
         if (!gridTransformacionDet.asSingleSelect().isEmpty()){  
                onVisualizarItems();
                dialogVisualizarItems.open();
            }
            else
            {
                notificationError.setText("Necesita seleccionar un elemento");
                notificationError.open();                
            }
          });
        
        
        btnDialogGenerar.addClickListener(e->{
            if(onValidarGeneraryContinuar() && !txtSerieArticuloFinal.getValue().isEmpty()){
                onGenerarYContinuar();
                
                notificationSuccess.open();
                onCleanDialog();
            }
            else{
                notificationError.setText("No se han ingresado todas las series");
                notificationError.open();
            }
        });
        
        btnVisualizarAllItems.addClickListener(e->{
            onLoadAllItems();
            dialogAllItems.open();
        });
        
        btnCerrarTransformacion.addClickListener(e->{
            if(onValidarCerrarTransformacion())
            {
                onCerrarTransformacion();            
                notificationSuccess.setText("Se cerro la transformacion satisfactoriamente.");
                notificationSuccess.open();
            }
            else{
                notificationError.setText("No se han generado todos los articulos.");
                notificationError.open();
                
            }
        });
         
        codigoProducto.addValueChangeListener(e->{
            //onBtnListarPorCodigo();
            onBtnListarPlantillaTransformacion();
        });
        
        txtSerieProducto.addValueChangeListener(e->{
            if(!txtSerieProducto.isEmpty()){
                if(onProductoPerteneceAPlantilla()){
                    Mensaje res = onArticuloDisponible();
                    if(res.isTipo())
                    {
                        onAgregarArticulo();
                        notificationSuccess.setText(res.getMensaje());
                        notificationSuccess.open(); 
                    }
                    else{
                        notificationError.setText(res.getMensaje());
                        notificationError.open(); 
                    }
                    
                }
                else{
                    notificationError.setText("El producto no pertenece a la plantilla");
                    notificationError.open();                    
                }
                
                txtSerieProducto.clear();
            } 
        });
        
         btnDialogVIModificar.addClickListener(e->{
         if (!gridVisualizarItems.asSingleSelect().isEmpty()){  
             if(!txtSerieModificar.isEmpty())
             {      
                if(onArticuloDisponibleModificar())
                {
                    onModificarSerie();
                    notificationSuccess.setText("El articulo fue modificado exitosamente.");
                    notificationSuccess.open(); 
                    dialogVisualizarItems.close();
                    txtSerieModificar.clear();
                    gridVisualizarItems.asSingleSelect().clear();
                }
                else{
                    notificationError.setText("El articulo no se encuentra en almacen o ya fue agregado.");
                    notificationError.open(); 
                }      
                              
             }
             else{
                notificationError.setText("Necesita ingresar una serie.");
                notificationError.open();    
             }
                
            }
            else
            {
                notificationError.setText("Necesita seleccionar un elemento");
                notificationError.open();                
            }
          });
        
        
        btnDialogCerrar.addClickListener(e -> 
        {
            onCleanDialog();
            dialogGenerar.close();
        });
        
        btnDialogVICerrar.addClickListener(e -> 
        {
            txtSerieModificar.clear();
            gridVisualizarItems.asSingleSelect().clear();
            dialogVisualizarItems.close();
        });
        
        txtSerieArticulo.addValueChangeListener(e -> 
        {
            onBuscarArticulos();            
        });
        
        btnActualizarTransformacion.addClickListener(e -> 
        {
            onActualizarSeriePadre();            
        });
        /*cmbPlantillas.addClickListener(e -> {
            onBtnListarPlantillaTransformacion();
        });*/
        
        
    }
    
    public final void initStyles()
    {
        setWidthFull();
        addClassName("centered-content");
        codigoProducto.setPlaceholder("Codigo Producto");
        //codigoProducto.setLabel("Codigo Producto");
        txtNumeroPlantillas.setPlaceholder("Número Transformaciones");
        txtSerieProducto.setPlaceholder("Coloque Serie Articulo");
        txtSerieArticuloFinal.setPlaceholder("Serie Articulo Final");
        
        cmbPlantillas.setPlaceholder("Plantillas");
        //cmbPlantillas.setLabel("Plantillas");
        
        notificationSuccess.setDuration(3000);
        notificationSuccess.setPosition(Notification.Position.TOP_CENTER);
        notificationSuccess.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
        notificationSuccess.setText("Agregado satisfactoriamente");
        
        notificationError.setDuration(3000);
        notificationError.setPosition(Notification.Position.TOP_CENTER);
        notificationError.addThemeVariants(NotificationVariant.LUMO_ERROR);
        notificationError.setText("El articulo ya fue agregado");
        
        notification.setDuration(5000);
        notification.setPosition(Notification.Position.TOP_CENTER);
        notification.addThemeVariants(NotificationVariant.LUMO_CONTRAST);
        
        btnDialogCerrar.addThemeVariants(ButtonVariant.LUMO_ERROR);
        
    }
    
    public final void initComponentTitulo()
    {      
        lblTitle.add("TRANSFORMACIÓN");
        lblTitle.setClassName("titulo");
        layTitle.add(lblTitle);
        layTitle.addClassName("centered-content");
        txtSerieModificar.setPlaceholder("Ingrese nueva Serie");
    }
    //3497
    public final void dialogGenerar()
    { 
        dialogTitle.addClassName("titulo");
        dialogGenerar.setWidth("40em");
        dialogGenerar.setHeight("35em");
        gridItem.setHeight("15em");
        
        FormLayout columnLayout = new FormLayout();
        
        columnLayout.setResponsiveSteps(
                   new FormLayout.ResponsiveStep("10em", 1),
                   new FormLayout.ResponsiveStep("20em", 2));
           
        columnLayout.add(dialogTitle, 2);
        columnLayout.add(new Hr(),2);
        columnLayout.add(lblNombreProducto,1);
        columnLayout.add(txtSerieArticuloFinal,1);
        columnLayout.add(new Hr(),2);
        columnLayout.add(txtSerieProducto,2);
        columnLayout.add(gridItem, 2);
        columnLayout.add(new Hr(),2);
        columnLayout.add(btnDialogGenerar, btnDialogCerrar); 
        dialogGenerar.add(columnLayout);
        
    }
    
    public final void dialogVisualizarItems()
    {
        Label titulo = new Label("MODIFICAR");
        dialogVisualizarItems.setWidth("30em");
        titulo.addClassName("titulo");
        lblCantidad.addClassName("titulo");
        
        FormLayout columnLayout = new FormLayout();
        columnLayout.setResponsiveSteps(
                   new FormLayout.ResponsiveStep("10em", 1),
                   new FormLayout.ResponsiveStep("20em", 2));
        
        columnLayout.add(titulo, 1);
        columnLayout.add(lblCantidad, 1);
        columnLayout.add(txtSerieModificar, 2);        
        columnLayout.add(gridVisualizarItems, 2);
        columnLayout.add(btnDialogVIModificar, btnDialogVICerrar);
        dialogVisualizarItems.add(columnLayout);
    }
    
    public final void dialogAllItems()
    {
        Label titulo = new Label("Articulos");
        dialogAllItems.setWidth("50em");
        titulo.addClassName("titulo");
        //lblCantidad.addClassName("titulo");
        
        FormLayout itemsLay = new FormLayout();
        itemsLay.setResponsiveSteps(
                   new FormLayout.ResponsiveStep("5em", 1),
                   new FormLayout.ResponsiveStep("20em", 2),
                   new FormLayout.ResponsiveStep("30em", 3),
                   new FormLayout.ResponsiveStep("5em", 5),
                   new FormLayout.ResponsiveStep("40em", 4));
        
        
        itemsLay.add(titulo, 4);
        itemsLay.add(txtSerieArticulo, 1);
        itemsLay.add(cmbArticulos, 2);
        itemsLay.add(txtTransformacion, 1);
        itemsLay.add(gridAllItems, 4);
        itemsLay.add(btnActualizarTransformacion, 1);
        //columnLayout.add(gridVisualizarItems, 2);
        //columnLayout.add(btnDialogVIModificar, btnDialogVICerrar);
        dialogAllItems.add(itemsLay);
    }
    
    public final void initGrids()
    {
        gridTransformacion.addColumn(Transformacion::getId).setHeader("Id").setFlexGrow(0).setWidth("10%");
        gridTransformacion.addColumn(Transformacion::getNombreProducto).setHeader("Nombre Producto").setFlexGrow(0).setWidth("45%");
        gridTransformacion.addColumn(Transformacion::getCantidadIndividual).setHeader("N° Individual").setFlexGrow(0).setWidth("15%");
        gridTransformacion.addColumn(Transformacion::getNumeroTransformaciones).setHeader("N° Total").setFlexGrow(0).setWidth("15%");
        gridTransformacion.addColumn(Transformacion::getTransformacionesRealizadas).setHeader("N° Realizadas").setFlexGrow(0).setWidth("15%");
        gridTransformacion.setHeight("100px");
        
        gridTransformacionDet.addColumn(TransformacionDet::getId).setHeader("Id").setFlexGrow(0).setWidth("10%");
        gridTransformacionDet.addColumn(TransformacionDet::getNombreProducto).setHeader("Nombre Producto").setFlexGrow(0).setWidth("45%");
        gridTransformacionDet.addColumn(TransformacionDet::getCantidadIndividual).setHeader("N° Individual").setFlexGrow(0).setWidth("15%");
        gridTransformacionDet.addColumn(TransformacionDet::getNumeroTransformaciones).setHeader("N° Total").setFlexGrow(0).setWidth("15%");
        gridTransformacionDet.addColumn(TransformacionDet::getTransformacionesRealizadas).setHeader("N° Realizadas").setFlexGrow(0).setWidth("15%");
        
        gridVisualizarItems.addColumn(OrdenDet::getArticuloId).setHeader("Id Articulo").setAutoWidth(true);
        gridVisualizarItems.addColumn(OrdenDet::getSerieArticulo).setHeader("Series").setAutoWidth(true);
        gridVisualizarItems.addColumn(OrdenDet::getAlmacenId).setHeader("Esta en Almacen").setAutoWidth(true);
                
        gridItem.addColumn(DatosTransformacion::getNombreProducto).setHeader("Nombre").setFlexGrow(0).setWidth("70%");
        gridItem.addColumn(DatosTransformacion::getSerieArticulo).setHeader("Serie Articulo").setFlexGrow(0).setWidth("30%");
        
        gridAllItems.addColumn(OrdenDet::getId).setHeader("Orden Id").setAutoWidth(true);
        gridAllItems.addColumn(OrdenDet::getArticuloId).setHeader("Articulo Id").setAutoWidth(true);
        gridAllItems.addColumn(OrdenDet::getSerieArticulo).setHeader("Serie Articulo").setAutoWidth(true);
        gridAllItems.addColumn(OrdenDet::getSerieArticuloPadre).setHeader("Serie Padre").setAutoWidth(true);
        
    }
    
    /*Options generals*/
    public abstract void onBtnGenerar();
    public abstract void onCargarDatosGrids();
    public abstract boolean onFindPlantillaTransformacion();
    public abstract void onBtnListarPlantillaTransformacion();
    public abstract void onCerrarTransformacion();
    public abstract void onBtnListarPorCodigo();
    public abstract void onVisualizarItems();
    public abstract boolean onArticuloDisponibleModificar();
    public abstract void onModificarSerie();
    
    /*Opciones Modal*/
    public abstract void onAgregarArticulo();
    public abstract void onLoadDialog();
    public abstract boolean onEstaAgregado();
    public abstract void onGenerarYContinuar();
    public abstract boolean onValidarGeneraryContinuar();
    public abstract String onGetCodigoArticulo();
    public abstract boolean onProductoPerteneceAPlantilla();
    public abstract Mensaje onArticuloDisponible();
    
    public abstract void onCleanDialog();
    public abstract boolean onValidarCerrarTransformacion();
    
    public abstract void onLoadAllItems();
    
    public abstract void onBuscarArticulos();
    
    public abstract void onActualizarSeriePadre();
    
}
