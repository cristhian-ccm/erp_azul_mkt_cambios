/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.view.produccion;
import com.upgrade.persistence.model.extcs.OrdenDet;
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
/**
 *
 * @author Upgrade - PC
 */
public abstract class ReportesTransformacionUI extends VerticalLayout {
    
    public final HorizontalLayout layTitle = new HorizontalLayout();
    public final Label lblTitle = new Label();
    public final Label dialogTitle = new Label("GENERAR");
    public final Dialog dialogGenerar = new Dialog();
    //public final ComboBox<PlantillaTransformacion> cmbPlantillas = new ComboBox();
    public final Button btnDialogGenerar = new Button("Generar y Continuar");
    public final Button btnDialogCerrar = new Button("Cerrar");
    
    
    public final Grid<OrdenDet> gridTransformaciones = new Grid<>();
    public final TextField txtSerieModificar = new TextField();
    public final Button btnDialogVIModificar = new Button("Modificar");
    public final Button btnDialogVICerrar = new Button("Cerrar");
    
    //public final ComboBox<Producto> comboProducto = new ComboBox<>();
    
    public final TextField txtNumeroPlantillas = new TextField();
    //public final Grid<Transformacion> gridTransformacion = new Grid<>();
    //public final Grid<TransformacionDet> gridTransformacionDet = new Grid<>();
    public final Grid<OrdenDet> gridItemsTransformacion = new Grid<>();
    public final Dialog dialogDetalles = new Dialog();
    public final TextField codigoProducto = new TextField();
    
    public final Button btnCrearTransformacion = new Button("Crear");

    public final Button btnVerDetTransformacion = new Button("Visualizar",  VaadinIcon.PLUS_CIRCLE.create());
    public final Button btnCerrarTransformacion = new Button("Cerrar Transformación", VaadinIcon.BAN.create());
    
    public final Label lblNombreProducto = new Label();
    public final TextField txtSerieProducto = new TextField();
    public final TextField txtSerieArticuloFinal = new TextField();
    
    public final Notification notificationSuccess= new Notification();
    public final Notification notificationError= new Notification();
    
    public final Label lblCantidad = new Label();

    public final Label nombreProducto = new Label();
    
    public final Button btnProbarMail = new Button("Mail");
    
    public final TextField txtBuscarSerie = new TextField();
    public final Button btnBuscar = new Button("Buscar", VaadinIcon.SEARCH.create());
    
    
    public ReportesTransformacionUI(){
        initComponentTitulo();
        initDialogDetalle();
        initStyles();
        initEvents();
        
        gridTransformaciones.addColumn(OrdenDet::getId).setHeader("Id Orden").setAutoWidth(true).setSortable(true);
        gridTransformaciones.addColumn(OrdenDet::getIdTransformacion).setHeader("Transformacion").setAutoWidth(true).setSortable(true);
        gridTransformaciones.addColumn(OrdenDet::getNombreProductoFinal).setHeader("Nombre").setAutoWidth(true).setSortable(true);
//        gridTrasnsformaciones.addColumn(OrdenDet::getNombreProductoItem).setHeader("Producto I").setAutoWidth(true);
        gridTransformaciones.addColumn(OrdenDet::getArticuloId).setHeader("Id Articulo").setAutoWidth(true).setSortable(true);
        gridTransformaciones.addColumn(OrdenDet::getSerieArticulo).setHeader("Serie").setAutoWidth(true).setSortable(true);
        gridTransformaciones.addColumn(OrdenDet::getAlmacenId).setHeader("Esta en Almacen").setAutoWidth(true).setSortable(true);
        
        gridItemsTransformacion.addColumn(OrdenDet::getId).setHeader("Id Orden").setAutoWidth(true).setSortable(true);
        gridItemsTransformacion.addColumn(OrdenDet::getIdTransformacion).setHeader("Transformacion").setAutoWidth(true).setSortable(true);
//        gridTrasnsformaciones.addColumn(OrdenDet::getNombreProductoItem).setHeader("Producto I").setAutoWidth(true);
        gridItemsTransformacion.addColumn(OrdenDet::getArticuloId).setHeader("Id Articulo").setAutoWidth(true).setSortable(true);
        gridItemsTransformacion.addColumn(OrdenDet::getSerieArticulo).setHeader("Serie").setAutoWidth(true).setSortable(true);
        gridItemsTransformacion.addColumn(OrdenDet::getAlmacenId).setHeader("Esta en Almacen").setAutoWidth(true).setSortable(true);
        
        
        
        add(layTitle);
        add(new HorizontalLayout(txtBuscarSerie, btnBuscar));
        add(gridTransformaciones);
        add(new HorizontalLayout(btnVerDetTransformacion));
    }
    
    public final void initComponentTitulo()
    {      
        lblTitle.add("REPORTES TRANSFORMACIÓN");
        lblTitle.setClassName("titulo");
        layTitle.add(lblTitle);
        layTitle.addClassName("centered-content");
        //txtSerieModificar.setPlaceholder("Ingrese nueva Serie");
    }
    
    public final void initDialogDetalle(){
        dialogDetalles.setWidth("600px");
        FormLayout columnLayout = new FormLayout();  
        columnLayout.setResponsiveSteps(
                   new FormLayout.ResponsiveStep("5em", 1),
                   new FormLayout.ResponsiveStep("10em", 2));
        
        
        Label lblDialogTitle = new Label("Transformación Detalle");
        Label lblProducto = new Label("Producto");
                
        lblDialogTitle.setClassName("titulo");
        nombreProducto.setClassName("subtitulo");
        lblDialogTitle.addClassName("centered-content");
        columnLayout.add(lblDialogTitle,2);
        columnLayout.add(lblProducto,1);
        columnLayout.add(nombreProducto,1);
        columnLayout.add(gridItemsTransformacion,2);
        /*columnLayout.add(fechaNotaCredito,2);
        columnLayout.add(observaciones,2);
        columnLayout.add(btnGenerarNotaCredito,2);*/
        
        dialogDetalles.add(columnLayout);
    }
    
     public final void initStyles()
    {
        notificationError.setDuration(3000);
        notificationError.setPosition(Notification.Position.TOP_CENTER);
        notificationError.addThemeVariants(NotificationVariant.LUMO_ERROR);
        
        txtBuscarSerie.setPlaceholder("[Serie]");
    }
    
    public final void initEvents(){
        btnVerDetTransformacion.addClickListener(e ->{
            
            if (!gridTransformaciones.asSingleSelect().isEmpty()){      
                onLoadDetallesTransformacion();
                nombreProducto.removeAll();
                nombreProducto.add(gridTransformaciones.asSingleSelect().getValue().getNombreProductoFinal());
                dialogDetalles.open();
            }
            else
           {
              notificationError.setText("Necesita seleccionar un elemento");
              notificationError.open();                
           }
           
        });
        
        btnProbarMail.addClickListener(e ->{
            onSendMail();
        });
        
        btnBuscar.addClickListener(e -> {
            onGetTransformaciones();
        });
    }
    
    public abstract void onLoadAlLTransformaciones();
    public abstract void onLoadDetallesTransformacion();
    public abstract void onSendMail();
    public abstract void onGetTransformaciones();
}
