/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.view;

import com.upgrade.persistence.auxiliar.Session;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import ts.com.service.util.db.CConexion;
import up.erp.view.carterizacion.CarterizacionesView;
import up.erp.view.cobranzas.RecibosView;
import up.erp.view.comprobantes.ComprobantesView;
import up.erp.view.comprobantes.NotasCreditosView;
//import up.erp.view.comprobantes.OrdenesVentaView;
import up.erp.view.ecom.CPanelView;
import up.erp.view.ecom.CPanelView2;
import up.erp.view.ecom.RepartidoresView;
import up.erp.view.ordenventa.OrdenVentaView;
import up.erp.view.produccion.PlantillaTransformacionesView;
import up.erp.view.produccion.ReportesTransformacionView;
import up.erp.view.produccion.TransformacionesView;
import up.erp.view.usuarios.PermisosView;
import up.erp.view.usuarios.RolesView;
import up.erp.view.usuarios.UsuariosView;

/**
 *
 * @author Upgrade - PC
 */
/*
 * @Route("")
 * 
 * @PWA(name = "Vaadin up.erp.Application", shortName = "Vaadin App",
 * description = "This is an example Vaadin application.", enableInstallPrompt =
 * false)
 * 
 * @CssImport("./styles/shared-styles.css")
 * 
 * @CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor =
 * "vaadin-text-field")
 */
public class App extends VerticalLayout {

    public final Button btnReportesTransformacion = new Button("Reportes Transformacion",
            VaadinIcon.FILE_TEXT.create());
    public final Button btnPlantillaTrans = new Button("Plantilla de transformacion", VaadinIcon.TREE_TABLE.create());
    public final Button btnTransformacion = new Button("Transformacion", VaadinIcon.AUTOMATION.create());
    public final Button btnComprobantes = new Button("Comprobantes", VaadinIcon.FILE_TABLE.create());
    public final Button btnOrdenesVenta = new Button("Ordenes de Venta", VaadinIcon.FILE_TABLE.create());
    public final Button btnPermisos = new Button("Permisos", VaadinIcon.FILE_TABLE.create());
    public final Button btnRoles = new Button("Roles", VaadinIcon.FILE_TABLE.create());
    public final Button btnUsuarios = new Button("Usuarios", VaadinIcon.FILE_TABLE.create());
    public final Button btnNotasCredito = new Button("Notas de Credito", VaadinIcon.FILE_TABLE.create());
    public final Button btnRecibos = new Button("Recibos", VaadinIcon.FILE_TABLE.create());
    public final Button btnCPanel = new Button("CPanel Ecommerce", VaadinIcon.CLOUD.create());
    public final Button btnRepartidores = new Button("Gestión Repartidores", VaadinIcon.TRUCK.create());
    public final Button btnCarterizacion = new Button("Carterizacion", VaadinIcon.FOLDER_OPEN.create());
    public final Button btnCerrarSesion = new Button("Cerrar Sesión");
    // public final HorizontalLayout layHeader = new HorizontalLayout(btnCPanel,
    // btnPlantillaTrans, btnTransformacion, btnComprobantes, btnNotasCredito,
    // btnRecibos);
    public final HorizontalLayout layHeader = new HorizontalLayout();
    public final HorizontalLayout layContent = new HorizontalLayout();

    // btnPlantillaTrans
    public App() {
        initEvents();
        initStyles();

        /*
         * setPrimarySection(AppLayout.Section.DRAWER); Image img = new
         * Image("https://i.imgur.com/GPpnszs.png", "Vaadin Logo");
         * img.setHeight("44px"); addToNavbar(new DrawerToggle(), img); Tabs tabs = new
         * Tabs(new Tab(btnPlantillaTrans), new Tab("About"));
         * tabs.setOrientation(Tabs.Orientation.VERTICAL); addToDrawer(tabs);
         * 
         * setContent(layContent);
         * 
         * AppLayout ap = new AppLayout();
         */

        Session session = (Session) UI.getCurrent().getSession().getAttribute("session");

        for (int i = 0; i < session.getPermisos().size(); i++) {
            if (session.getPermisos().get(i).getId() == 93)
                layHeader.add(btnPlantillaTrans);

            if (session.getPermisos().get(i).getId() == 95) {
                layHeader.add(btnTransformacion);
                layHeader.add(btnReportesTransformacion);
            }

            if (session.getPermisos().get(i).getId() == 96) {
                layHeader.add(btnOrdenesVenta);
                layHeader.add(btnComprobantes);
            }

            if (session.getPermisos().get(i).getId() == 94)
                layHeader.add(btnNotasCredito);

            if (session.getPermisos().get(i).getId() == 97)
                layHeader.add(btnCPanel);

            if (session.getPermisos().get(i).getId() == 99)
                layHeader.add(btnRepartidores);

            if (session.getPermisos().get(i).getId() == 98)
                layHeader.add(btnRecibos);

            if (session.getPermisos().get(i).getId() == 96) {
                layHeader.add(btnUsuarios);

            }
        }

        layHeader.add(btnCarterizacion);
        layHeader.add(btnCerrarSesion);
        add(layHeader, layContent);

    }

    private void initConection() {

        // ----------------------------------------------------------------------
        // OLD
        // ----------------------------------------------------------------------
        // CConexion.strUrl = "jdbc:postgresql://190.117.78.108:9090/upgrade2db";
        // CConexion.strUrl = "jdbc:postgresql://190.117.78.108:9090/upgradedb";
        // ----------------------------------------------------------------------
        // NEW
        // ----------------------------------------------------------------------
        // CConexion.strUrl = "jdbc:postgresql://190.119.207.218:9090/upgrade2db";
        // CConexion.strUrl = "jdbc:postgresql://190.119.207.218:9090/upgradedb";
        CConexion.strUrl = "jdbc:postgresql://190.119.207.218:9090/bk_up5";

        // ----------------------------------------------------------------------
        CConexion.strDriver = "org.postgresql.Driver";
        CConexion.strUsr = "postgres";
        CConexion.strPwd = "rednavedb2015";
    }

    private void initEvents() {

        btnReportesTransformacion.addClickListener(e -> {
            setContent(new ReportesTransformacionView(this));
        });

        btnPlantillaTrans.addClickListener(e -> {
            setContent(new PlantillaTransformacionesView(this));
        });

        btnTransformacion.addClickListener(e -> {
            setContent(new TransformacionesView(this));
        });

        btnCPanel.addClickListener(e -> {
            layHeader.removeAll();
            // setContent(new CPanelView(this));
            setContent(new CPanelView2(this));
        });

        btnRepartidores.addClickListener(e -> {
            layHeader.removeAll();
            setContent(new RepartidoresView(this));
        });

        btnComprobantes.addClickListener(e -> {
            setContent(new ComprobantesView(this));
        });

        btnNotasCredito.addClickListener(e -> {
            setContent(new NotasCreditosView(this));
        });

        btnRecibos.addClickListener(e -> {
            setContent(new RecibosView(this));
        });

        btnOrdenesVenta.addClickListener(e -> {
            setContent(new OrdenVentaView(this));
        });

        btnPermisos.addClickListener(e -> {

            setContent(new PermisosView(this));
        });

        btnRoles.addClickListener(e -> {
            setContent(new RolesView(this));
        });

        btnUsuarios.addClickListener(e -> {
            setContent(new UsuariosView(this));
        });

        btnCarterizacion.addClickListener(e -> {
            setContent(new CarterizacionesView(this));
        });

        btnCerrarSesion.addClickListener(e -> {
            UI.getCurrent().getSession().close();
        });

    }

    private void initStyles() {
        btnCPanel.setWidthFull();
        btnRepartidores.setWidthFull();
        btnPlantillaTrans.setWidthFull();
        btnTransformacion.setWidthFull();
        layHeader.setWidthFull();
        layContent.setWidthFull();
        btnComprobantes.setWidthFull();
        btnNotasCredito.setWidthFull();
        btnRecibos.setWidthFull();
        btnCerrarSesion.setWidthFull();
        btnOrdenesVenta.setWidthFull();
        btnReportesTransformacion.setWidthFull();
        // btnPermisos.setWidthFull();
        // btnPermisos.setWidthFull();

        btnPermisos.setWidthFull();
        btnRoles.setWidthFull();
        btnUsuarios.setWidthFull();

        btnCerrarSesion.addThemeVariants(ButtonVariant.LUMO_ERROR);
        btnPermisos.setWidthFull();
        btnRoles.setWidthFull();
        btnUsuarios.setWidthFull();
        btnCarterizacion.setWidthFull();

        // layContent.setWidth("1200px");
        // layContent.addClassName("centered-content");
    }

    public void setContent(Component component) {
        this.layContent.removeAll();
        this.layContent.add(component);
    }

    // public PlantillaTransformacionUI() {
    // List<Person> people = Arrays.asList(
    // new Person("Nicolaus Copernicus", 1543),
    // new Person("Galileo Galilei", 1564),
    // new Person("Johannes Kepler", 1571));
    //
    // // Create a grid bound to the list
    // Grid<Person> grid = new Grid<>();
    // grid.setItems(people);
    // grid.addColumn(Person::getName).setHeader("Name");
    // grid.addColumn(Person::getYearOfBirth)
    // .setHeader("Year of birth");
    // }
}
