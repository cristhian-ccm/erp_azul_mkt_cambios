/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.view.ecom;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import up.erp.view.App;

/**
 *
 * @author Upgrade - PC
 */
public abstract class CPanelUI extends VerticalLayout {
    
    // HEADER
    Label titulo = new Label("PANEL DE CONTROL");
    
    public final HorizontalLayout head = new HorizontalLayout(titulo);
    
    public final Button btnClientes = new Button("Gestión Clientes", VaadinIcon.MALE.create());
    public final Button btnPedidos = new Button("Gestión Pedidos", VaadinIcon.CART_O.create());
    public final Button btnLineas = new Button("Gestión Lineas Ecommerce", VaadinIcon.RECORDS.create());
    public final Button btnProductos = new Button("Gestión Productos", VaadinIcon.PACKAGE.create());
    public final Button btnEcomPage = new Button("Gestión Página Ecommerce", VaadinIcon.GLOBE_WIRE.create());
    public final Button btnCupones = new Button("Gestión Cupones", VaadinIcon.TICKET.create());
    public final Button btnSalirCP = new Button("Salir del Panel de Control");
    public final VerticalLayout layProductos = new VerticalLayout();
    public final VerticalLayout layPanelButtons = new VerticalLayout(btnClientes,btnPedidos,btnLineas,btnProductos,btnEcomPage,btnCupones,btnSalirCP);
    public CPanelUI() {
        removeAll();
        add(head,layProductos, layPanelButtons);
        initStyles();
        initEvents();
    }
    
    private void initStyles() {

        titulo.getStyle().set("fontWeight","bold");
        titulo.getStyle().set("fontSize","300%");
        head.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        head.setWidthFull();
        
        btnClientes.setWidthFull();
        btnPedidos.setWidthFull();
        btnProductos.setWidthFull();
        btnLineas.setWidthFull();
        btnEcomPage.setWidthFull();
        btnCupones.setWidthFull();
        
        btnSalirCP.addThemeVariants(ButtonVariant.LUMO_ERROR);
        //btnSalirCP.getStyle().set("fontSize","90%");
        btnSalirCP.setWidthFull();
    }
    
    //CPANEL Rutas
    public abstract void On_PedidosView();
    public abstract void On_ClientesView();
    public abstract void On_IndexWebView();
    public abstract void On_LineasEcommerceView();
    public abstract void On_ProductosView();
    public abstract void On_CuponesView();
    
    private void initEvents() {
        btnClientes.addClickListener(e->{
            removeAll();
            On_ClientesView();
            //add(new ClientesView());
        });
        btnPedidos.addClickListener(e->{
            removeAll();
            On_PedidosView();
            //add(new PedidosView());
        });
        btnLineas.addClickListener(e->{
            removeAll();
            On_LineasEcommerceView();
            //add(new LineasEcomView());
        });
        btnProductos.addClickListener(e->{
            removeAll();
            On_ProductosView();
            //add(new ProductosView());
        });
        btnEcomPage.addClickListener(e->{
            removeAll();
            On_IndexWebView();
            //add(new IndexWebView());
        });
        btnCupones.addClickListener(e->{
            removeAll();
            On_CuponesView();
            //add(new IndexWebView());
        });
        btnSalirCP.addClickListener(e->{
            removeAll();
            add(new App());
        });
    }
    
}
