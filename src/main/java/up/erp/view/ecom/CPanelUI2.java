/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.view.ecom;

import com.upgrade.persistence.model.ecommerce.CartDashboard;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.selection.MultiSelect;
import up.erp.view.App;
import up.erp.view.dashboards.AreaChart;
import up.erp.view.dashboards.BubbleChart;
import up.erp.view.dashboards.CandleStickChart;
import up.erp.view.dashboards.DonutChart;
import up.erp.view.dashboards.GradientRadialBarChart;
import up.erp.view.dashboards.HeatmapChart;
import up.erp.view.dashboards.HorizontalBarChart;
import up.erp.view.dashboards.LineChart;
import up.erp.view.dashboards.MultiRadialBarChart;
import up.erp.view.dashboards.PieChart;
import up.erp.view.dashboards.RadarChart;
import up.erp.view.dashboards.RadialBarChart;
import up.erp.view.dashboards.ScatterChart;
import up.erp.view.dashboards.VerticalBarChart;

/**
 *
 * @author Upgrade - PC
 */
public abstract class CPanelUI2 extends VerticalLayout {

    // -----------------------------------------------------------------------------------------------
    // MAIN VIEW
    // -----------------------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------------
    // HEADER
    // -----------------------------------------------------------------------------------------------
    Label titulo = new Label("PANEL DE CONTROL");

    public final HorizontalLayout head = new HorizontalLayout(titulo);
    // -----------------------------------------------------------------------------------------------

    // -----------------------------------------------------------------------------------------------
    // DASHBOARDS
    // -----------------------------------------------------------------------------------------------
    // DASHBOARDS : CREACION DE DASHBOARDS
    // -----------------------------------------------------------------------------------------------
    public final AreaChart dd_areaChart = new AreaChart();
    public final BubbleChart dd_bubbleChart = new BubbleChart();
    public final CandleStickChart dd_candlestickChart = new CandleStickChart();
    public final DonutChart dd_donutChart = new DonutChart();
    public final GradientRadialBarChart dd_gradientradialbarChart = new GradientRadialBarChart();
    public final HeatmapChart dd_heatmapChart = new HeatmapChart();
    public final HorizontalBarChart dd_horizontalbarChart = new HorizontalBarChart();
    public final LineChart dd_lineChart = new LineChart();
    public final MultiRadialBarChart dd_multiradialbarChart = new MultiRadialBarChart();
    public final PieChart dd_pieChart = new PieChart();
    public final RadarChart dd_radarChart = new RadarChart();
    public final RadialBarChart dd_radialbarChart = new RadialBarChart();
    public final ScatterChart dd_scatterChart = new ScatterChart();
    public final VerticalBarChart dd_verticalChart = new VerticalBarChart();
    // -----------------------------------------------------------------------------------------------
    // DASHBOARD 1: TITULO
    // -----------------------------------------------------------------------------------------------
    public final Label dash1_Titulo = new Label("ECOMMERCE VENTAS VS OTRAS VENTAS UPGRADE");
    public final HorizontalLayout laydash1_Titulo = new HorizontalLayout(dash1_Titulo);
    // -----------------------------------------------------------------------------------------------
    // DASHBOARD 1: SELECT DASHBOARD
    // -----------------------------------------------------------------------------------------------
    public final HorizontalLayout lay_Dash1 = new HorizontalLayout(dd_pieChart);
    // -----------------------------------------------------------------------------------------------
    // DASHBOARD 1: CHANGE DATE DASHBOARD
    // -----------------------------------------------------------------------------------------------
    public final Label dash1_TitFecha = new Label("MODIFICAR FECHA");
    public final HorizontalLayout laydash1_TitFecha = new HorizontalLayout(dash1_TitFecha);
    // -----------------------------------------------------------------------------------------------
    public final DatePicker FechIni_Dash1 = new DatePicker("Fecha Inicio");
    public final DatePicker FechFin_Dash1 = new DatePicker("Fecha Fin");
    public final Button btnGenerate_Dash1 = new Button("Actualizar Dashboard");

    public final HorizontalLayout lay_DateDash1 = new HorizontalLayout(FechIni_Dash1, FechFin_Dash1, btnGenerate_Dash1);
    // -----------------------------------------------------------------------------------------------
    public final VerticalLayout lay_DashBoard1 = new VerticalLayout(laydash1_Titulo, lay_Dash1, laydash1_TitFecha,
            lay_DateDash1);
    // -----------------------------------------------------------------------------------------------
    // DASHBOARD 1: END
    // -----------------------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------------
    // DASHBOARD 2: TITULO
    // -----------------------------------------------------------------------------------------------
    public final Label dash2_Titulo = new Label("ECOMMERCE: VISITANTES VS USUARIOS REGISTRADOS");
    public final HorizontalLayout laydash2_Titulo = new HorizontalLayout(dash2_Titulo);
    // -----------------------------------------------------------------------------------------------
    // DASHBOARD 2: SELECT DASHBOARD
    // -----------------------------------------------------------------------------------------------
    public final HorizontalLayout lay_Dash2 = new HorizontalLayout(dd_donutChart);
    // -----------------------------------------------------------------------------------------------
    // DASHBOARD 2: CHANGE DATE DASHBOARD
    // -----------------------------------------------------------------------------------------------
    public final Label dash2_TitFecha = new Label("MODIFICAR FECHA");
    public final HorizontalLayout laydash2_TitFecha = new HorizontalLayout(dash2_TitFecha);
    // -----------------------------------------------------------------------------------------------
    public final DatePicker FechIni_Dash2 = new DatePicker("Fecha Inicio");
    public final DatePicker FechFin_Dash2 = new DatePicker("Fecha Fin");
    public final Button btnGenerate_Dash2 = new Button("Actualizar Dashboard");

    public final HorizontalLayout lay_DateDash2 = new HorizontalLayout(FechIni_Dash2, FechFin_Dash2, btnGenerate_Dash2);
    // -----------------------------------------------------------------------------------------------
    public final VerticalLayout lay_DashBoard2 = new VerticalLayout(laydash2_Titulo, lay_Dash2, laydash2_TitFecha,
            lay_DateDash2);
    // -----------------------------------------------------------------------------------------------
    // DASHBOARD 2: END
    // -----------------------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------------
    // DASHBOARD 3: TITULO
    // -----------------------------------------------------------------------------------------------
    public final Label dash3_Titulo = new Label("ECOMMERCE: VENTAS ULTIMOS 6 MESES");
    public final HorizontalLayout laydash3_Titulo = new HorizontalLayout(dash3_Titulo);
    // -----------------------------------------------------------------------------------------------
    // DASHBOARD 3: CHANGE DATE DASHBOARD
    // -----------------------------------------------------------------------------------------------
    public final Label dash3_TitFecha = new Label("MODIFICAR FECHA");
    public final HorizontalLayout laydash3_TitFecha = new HorizontalLayout(dash3_TitFecha);
    // -----------------------------------------------------------------------------------------------
    public final DatePicker FechIni_Dash3 = new DatePicker("Fecha Inicio");
    public final DatePicker FechFin_Dash3 = new DatePicker("Fecha Fin");
    public final Button btnGenerate_Dash3 = new Button("Actualizar Cantidad");

    public final HorizontalLayout lay_DateDash3 = new HorizontalLayout(FechIni_Dash3, FechFin_Dash3, btnGenerate_Dash3);
    // -----------------------------------------------------------------------------------------------
    // DASHBOARD 3: TOTAL VENTAS ECOMMERCE
    // -----------------------------------------------------------------------------------------------
    public final Label dash3_EVentasTTit = new Label("TOTAL VENTAS ECOMMERCE: S/.");
    public final Label dash3_EVentasTot = new Label();
    public final HorizontalLayout laydash3_EVentasT = new HorizontalLayout(dash3_EVentasTTit, dash3_EVentasTot);
    // -----------------------------------------------------------------------------------------------
    // DASHBOARD 3: SELECT DASHBOARD
    // -----------------------------------------------------------------------------------------------
    public final HorizontalLayout lay_Dash3 = new HorizontalLayout(dd_lineChart);
    // -----------------------------------------------------------------------------------------------
    public final VerticalLayout lay_DashBoard3 = new VerticalLayout(laydash3_Titulo, laydash3_TitFecha, lay_DateDash3,
            laydash3_EVentasT, lay_Dash3);
    // -----------------------------------------------------------------------------------------------
    // DASHBOARD 3: END
    // -----------------------------------------------------------------------------------------------

    // -----------------------------------------------------------------------------------------------
    // DASHBOARD 4: TITULO : ECOMMERCE: CANTIDAD COMPRAS INCONCLUSAS - (ITEMS EN
    // CARRITO)
    // -----------------------------------------------------------------------------------------------
    public final Label dash4_Titulo = new Label("ECOMMERCE: CANTIDAD COMPRAS INCONCLUSAS - (ITEMS EN CARRITO)");
    public final HorizontalLayout laydash4_Titulo = new HorizontalLayout(dash4_Titulo);
    // -----------------------------------------------------------------------------------------------
    // DASHBOARD 4: CHANGE DATE DASHBOARD
    // -----------------------------------------------------------------------------------------------
    public final Label dash4_TitFecha = new Label("MODIFICAR FECHA");
    public final HorizontalLayout laydash4_TitFecha = new HorizontalLayout(dash4_TitFecha);
    // -----------------------------------------------------------------------------------------------
    public final DatePicker FechIni_Dash4 = new DatePicker("Fecha Inicio");
    public final DatePicker FechFin_Dash4 = new DatePicker("Fecha Fin");
    public final Button btnGenerate_Dash4 = new Button("Actualizar Cantidad");

    public final HorizontalLayout lay_DateDash4 = new HorizontalLayout(FechIni_Dash4, FechFin_Dash4, btnGenerate_Dash4);
    // -----------------------------------------------------------------------------------------------
    // DASHBOARD 4: TOTAL CANTIDAD VECES CARRITO SIN COMPRAR
    // -----------------------------------------------------------------------------------------------
    public final Label dash4_CartNoShopTit = new Label("CANTIDAD TOTAL COMPRAS INCONCLUSAS:");
    public final Label dash4_CartNoShopTitCant = new Label();
    public final HorizontalLayout laydash4_CartNoShopT = new HorizontalLayout(dash4_CartNoShopTit,
            dash4_CartNoShopTitCant);
    // -----------------------------------------------------------------------------------------------
    // DASHBOARD 4: SELECT DASHBOARD
    // -----------------------------------------------------------------------------------------------
    // public final HorizontalLayout lay_Dash4 = new HorizontalLayout(dd_lineChart);
    public final Grid<CartDashboard> Grid_Dash = new Grid<>();
    public final Button btnver_Detalle = new Button("Ver Detalle", VaadinIcon.EYE.create());
    public final VerticalLayout layGrid = new VerticalLayout(btnver_Detalle, Grid_Dash);
    // -----------------------------------------------------------------------------------------------
    public final VerticalLayout lay_DashBoard4 = new VerticalLayout(laydash4_Titulo, laydash4_CartNoShopT, layGrid);
    // -----------------------------------------------------------------------------------------------
    // DASHBOARD 4: END
    // -----------------------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------------
    // DASHBOARDS: GENERATE - ALL
    // -----------------------------------------------------------------------------------------------
    public final HorizontalLayout lay_Dashboards = new HorizontalLayout(lay_DashBoard1, lay_DashBoard2);
    public final HorizontalLayout lay_Dashboards2 = new HorizontalLayout(lay_DashBoard3);
    public final HorizontalLayout lay_Dashboards3 = new HorizontalLayout(lay_DashBoard4);
    // -----------------------------------------------------------------------------------------------

    // -----------------------------------------------------------------------------------------------
    // GOOGLE ANALYTICS
    // -----------------------------------------------------------------------------------------------
    public final Button btnGoogleAnalytics = new Button("GOOGLE ANALYTICS");
    public final HorizontalLayout lay_GoogleAnalytics = new HorizontalLayout(btnGoogleAnalytics);
    // -----------------------------------------------------------------------------------------------
    // MODULOS - BOTONES
    // -----------------------------------------------------------------------------------------------
    public final Label Modulos_Titulo = new Label("MODULOS ECOMMERCE");
    public final HorizontalLayout layModulos_Titulo = new HorizontalLayout(Modulos_Titulo);

    public final Button btnClientes = new Button("CLIENTES ECOMMERCE", VaadinIcon.MALE.create());
    public final Button btnSubscriptores = new Button("SUBSCRIPTORES ECOMMERCE", VaadinIcon.MALE.create());
    public final Button btnPedidos = new Button("PEDIDOS ECOMMERCE", VaadinIcon.CART_O.create());
    public final Button btnLineas = new Button("LINEAS ECOMMERCE", VaadinIcon.RECORDS.create());
    public final Button btnProductos = new Button("PRODUCTOS ECOMMERCE", VaadinIcon.PACKAGE.create());
    public final Button btnCaracteristicas = new Button("CARACTERISTICAS PRODUCTOS", VaadinIcon.PACKAGE.create());
    public final Button btnEcomPage = new Button("PAGINA ECOMMERCE - INDEX", VaadinIcon.GLOBE_WIRE.create());
    public final Button btnCupones = new Button("CUPONES ECOMMERCE", VaadinIcon.TICKET.create());
    public final Button btnRepartidores = new Button("REPARTIDORES ECOMMERCE", VaadinIcon.TRUCK.create());
    public final Button btnPromociones = new Button("PROMOCIONES ECOMMERCE", VaadinIcon.GIFT.create());
    public final Button btnPuntosUP = new Button("PUNTOS UP ECOMMERCE", VaadinIcon.TROPHY.create());
    public final Button btnCrudBan = new Button("AGREGAR BANNER", VaadinIcon.CALENDAR_O.create());
    public final Button btnSalirCP = new Button("SALIR DEL PANEL");
    public final VerticalLayout layProductos = new VerticalLayout();

    public final VerticalLayout layPanelButtons = new VerticalLayout(btnClientes, btnSubscriptores, btnPedidos,
            btnLineas, btnProductos, btnCaracteristicas, btnEcomPage, btnCupones, btnPromociones, btnPuntosUP,
            btnCrudBan, btnSalirCP);
    // -----------------------------------------------------------------------------------------------

    // -----------------------------------------------------------------------------------------------
    // END MAIN VIEW
    // -----------------------------------------------------------------------------------------------

    public CPanelUI2() {
        removeAll();
        // add(head,layProductos, layPanelButtons);
        add(head, lay_Dashboards, lay_Dashboards2, lay_Dashboards3, lay_GoogleAnalytics, layModulos_Titulo,
                layPanelButtons);
        initStyles();
        initEvents();
    }

    private void initStyles() {

        // -----------------------------------------------------------------------------------------------
        // MAIN VIEW
        // -----------------------------------------------------------------------------------------------
        // -----------------------------------------------------------------------------------------------
        // HEADER
        // -----------------------------------------------------------------------------------------------
        titulo.getStyle().set("fontWeight", "bold");
        titulo.getStyle().set("fontSize", "300%");

        head.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        head.setWidthFull();
        // -----------------------------------------------------------------------------------------------

        // -----------------------------------------------------------------------------------------------
        // DASHBOARDS
        // -----------------------------------------------------------------------------------------------
        // -----------------------------------------------------------------------------------------------
        // DASHBOARD 1: TITULO -
        // -----------------------------------------------------------------------------------------------
        dash1_Titulo.getStyle().set("fontWeight", "bold");
        dash1_Titulo.getStyle().set("fontSize", "140%");

        laydash1_Titulo.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laydash1_Titulo.setWidthFull();
        // -----------------------------------------------------------------------------------------------
        // DASHBOARD 1: SELECT DASHBOARD
        // -----------------------------------------------------------------------------------------------
        lay_Dash1.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        lay_Dash1.setWidthFull();
        // -----------------------------------------------------------------------------------------------
        // -----------------------------------------------------------------------------------------------
        // DASHBOARD 1: CHANGE DATE DASHBOARD
        // -----------------------------------------------------------------------------------------------
        dash1_TitFecha.getStyle().set("fontWeight", "bold");
        dash1_TitFecha.getStyle().set("fontSize", "110%");

        laydash1_TitFecha.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laydash1_TitFecha.setAlignItems(FlexComponent.Alignment.CENTER);
        laydash1_TitFecha.setWidthFull();
        // -----------------------------------------------------------------------------------------------
        // FechIni_Dash1.setWidthFull();
        // FechFin_Dash1.setWidthFull();
        btnGenerate_Dash1.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        btnGenerate_Dash1.getStyle().set("fontSize", "90%");
        // btnGenerate_Dash1.setWidthFull();

        lay_DateDash1.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        lay_DateDash1.setAlignItems(FlexComponent.Alignment.BASELINE);
        lay_DateDash1.setWidthFull();
        // -----------------------------------------------------------------------------------------------
        lay_DashBoard1.getStyle().set("border", "1px solid #9E9E9E");
        lay_DashBoard1.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        lay_DashBoard1.setAlignItems(FlexComponent.Alignment.BASELINE);
        lay_DashBoard1.setWidthFull();
        // -----------------------------------------------------------------------------------------------
        // DASHBOARD 1: END
        // -----------------------------------------------------------------------------------------------
        // -----------------------------------------------------------------------------------------------
        // DASHBOARD 2: TITULO
        // -----------------------------------------------------------------------------------------------
        dash2_Titulo.getStyle().set("fontWeight", "bold");
        dash2_Titulo.getStyle().set("fontSize", "140%");

        laydash2_Titulo.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laydash2_Titulo.setWidthFull();
        // -----------------------------------------------------------------------------------------------
        // DASHBOARD 2: SELECT DASHBOARD
        // -----------------------------------------------------------------------------------------------
        lay_Dash2.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        lay_Dash2.setWidthFull();
        // -----------------------------------------------------------------------------------------------
        // DASHBOARD 2: CHANGE DATE DASHBOARD
        // -----------------------------------------------------------------------------------------------
        dash2_TitFecha.getStyle().set("fontWeight", "bold");
        dash2_TitFecha.getStyle().set("fontSize", "110%");

        laydash2_TitFecha.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laydash2_TitFecha.setAlignItems(FlexComponent.Alignment.CENTER);
        laydash2_TitFecha.setWidthFull();
        // -----------------------------------------------------------------------------------------------
        // FechIni_Dash2.setWidthFull();
        // FechFin_Dash2.setWidthFull();
        btnGenerate_Dash2.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        btnGenerate_Dash2.getStyle().set("fontSize", "90%");
        // btnGenerate_Dash2.setWidthFull();

        lay_DateDash2.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        lay_DateDash2.setAlignItems(FlexComponent.Alignment.BASELINE);
        lay_DateDash2.setWidthFull();
        // -----------------------------------------------------------------------------------------------
        lay_DashBoard2.getStyle().set("border", "1px solid #9E9E9E");
        lay_DashBoard2.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        lay_DashBoard2.setAlignItems(FlexComponent.Alignment.BASELINE);
        lay_DashBoard2.setWidthFull();
        // -----------------------------------------------------------------------------------------------
        // DASHBOARD 2: END
        // -----------------------------------------------------------------------------------------------
        // -----------------------------------------------------------------------------------------------
        // DASHBOARD 3: TITULO
        // -----------------------------------------------------------------------------------------------
        dash3_Titulo.getStyle().set("fontWeight", "bold");
        dash3_Titulo.getStyle().set("fontSize", "140%");

        laydash3_Titulo.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laydash3_Titulo.setWidthFull();
        // -----------------------------------------------------------------------------------------------
        // DASHBOARD 3: CHANGE DATE DASHBOARD
        // -----------------------------------------------------------------------------------------------
        dash3_TitFecha.getStyle().set("fontWeight", "bold");
        dash3_TitFecha.getStyle().set("fontSize", "110%");

        laydash3_TitFecha.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laydash3_TitFecha.setAlignItems(FlexComponent.Alignment.CENTER);
        laydash3_TitFecha.setWidthFull();
        // -----------------------------------------------------------------------------------------------
        // FechIni_Dash3.setWidthFull();
        // FechFin_Dash3.setWidthFull();
        btnGenerate_Dash3.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        btnGenerate_Dash3.getStyle().set("fontSize", "90%");
        // btnGenerate_Dash3.setWidthFull();

        lay_DateDash3.getStyle().set("border", "1px solid #9E9E9E");
        lay_DateDash3.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        lay_DateDash3.setAlignItems(FlexComponent.Alignment.BASELINE);
        lay_DateDash3.setWidthFull();
        // -----------------------------------------------------------------------------------------------
        // DASHBOARD 3: TOTAL VENTAS ECOMMERCE
        // -----------------------------------------------------------------------------------------------
        dash3_EVentasTTit.getStyle().set("fontWeight", "bold");
        dash3_EVentasTTit.getStyle().set("fontSize", "130%");

        dash3_EVentasTot.getStyle().set("fontWeight", "bold");
        dash3_EVentasTot.getStyle().set("color", "green");
        dash3_EVentasTot.getStyle().set("fontSize", "130%");

        laydash3_EVentasT.getStyle().set("border", "1px solid #9E9E9E");
        laydash3_EVentasT.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laydash3_EVentasT.setAlignItems(FlexComponent.Alignment.BASELINE);
        laydash3_EVentasT.setWidthFull();
        // -----------------------------------------------------------------------------------------------
        // DASHBOARD 3: SELECT DASHBOARD
        // -----------------------------------------------------------------------------------------------
        lay_Dash3.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        lay_Dash3.setWidthFull();
        // -----------------------------------------------------------------------------------------------
        lay_DashBoard3.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        lay_DashBoard3.setWidthFull();
        // -----------------------------------------------------------------------------------------------
        // DASHBOARD 3: END
        // -----------------------------------------------------------------------------------------------
        // -----------------------------------------------------------------------------------------------
        // DASHBOARD 4: TITULO
        // -----------------------------------------------------------------------------------------------
        dash4_Titulo.getStyle().set("fontWeight", "bold");
        dash4_Titulo.getStyle().set("fontSize", "140%");

        laydash4_Titulo.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laydash4_Titulo.setWidthFull();
        // -----------------------------------------------------------------------------------------------
        // DASHBOARD 4: CHANGE DATE DASHBOARD
        // -----------------------------------------------------------------------------------------------
        dash4_TitFecha.getStyle().set("fontWeight", "bold");
        dash4_TitFecha.getStyle().set("fontSize", "110%");

        laydash4_TitFecha.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laydash4_TitFecha.setAlignItems(FlexComponent.Alignment.CENTER);
        laydash4_TitFecha.setWidthFull();
        // -----------------------------------------------------------------------------------------------
        // FechIni_Dash4
        // FechFin_Dash4
        btnGenerate_Dash4.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        btnGenerate_Dash4.getStyle().set("fontSize", "90%");
        // btnGenerate_Dash3.setWidthFull();

        lay_DateDash4.getStyle().set("border", "1px solid #9E9E9E");
        lay_DateDash4.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        lay_DateDash4.setAlignItems(FlexComponent.Alignment.BASELINE);
        lay_DateDash4.setWidthFull();
        // -----------------------------------------------------------------------------------------------
        // DASHBOARD 4: TOTAL CANTIDAD VECES CARRITO SIN COMPRAR
        // -----------------------------------------------------------------------------------------------
        dash4_CartNoShopTit.getStyle().set("fontWeight", "bold");
        dash4_CartNoShopTit.getStyle().set("fontSize", "130%");

        dash4_CartNoShopTitCant.getStyle().set("fontWeight", "bold");
        dash4_CartNoShopTitCant.getStyle().set("color", "green");
        dash4_CartNoShopTitCant.getStyle().set("fontSize", "130%");

        laydash4_CartNoShopT.getStyle().set("border", "1px solid #9E9E9E");
        laydash4_CartNoShopT.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laydash4_CartNoShopT.setAlignItems(FlexComponent.Alignment.BASELINE);
        laydash4_CartNoShopT.setWidthFull();
        // -----------------------------------------------------------------------------------------------
        // DASHBOARD 4: SELECT DASHBOARD
        // -----------------------------------------------------------------------------------------------
        // public final HorizontalLayout lay_Dash4 = new HorizontalLayout(dd_lineChart);

        Grid_Dash.addColumn(CartDashboard::getProducto).setAutoWidth(true).setSortable(true).setHeader("Producto");
        Grid_Dash.addColumn(CartDashboard::getNombre).setAutoWidth(true).setSortable(true).setHeader("Nombre");
        Grid_Dash.addColumn(CartDashboard::getApellidos).setAutoWidth(true).setSortable(true).setHeader("Apellidos");
        Grid_Dash.addColumn(CartDashboard::getEmail).setAutoWidth(true).setSortable(true).setHeader("Email");
        Grid_Dash.addColumn(CartDashboard::getTelefono).setAutoWidth(true).setSortable(true).setHeader("Telefono");
        Grid_Dash.addColumn(CartDashboard::getCantidad).setAutoWidth(true).setSortable(true).setHeader("Cantidad");

        Grid_Dash.setVisible(false);
        Grid_Dash.setSelectionMode(Grid.SelectionMode.MULTI);

        MultiSelect<Grid<CartDashboard>, CartDashboard> multiSelect = Grid_Dash.asMultiSelect();
        // btnver_Detalle.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        btnver_Detalle.getStyle().set("fontSize", "90%");

        layGrid.getStyle().set("border", "1px solid #9E9E9E");
        layGrid.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layGrid.setAlignItems(FlexComponent.Alignment.CENTER);
        layGrid.setWidthFull();
        // -----------------------------------------------------------------------------------------------
        lay_DashBoard4.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        lay_DashBoard4.setWidthFull();
        // -----------------------------------------------------------------------------------------------
        // DASHBOARD 4: END
        // -----------------------------------------------------------------------------------------------
        // DASHBOARDS: GENERATE - ALL
        // -----------------------------------------------------------------------------------------------
        lay_Dashboards.getStyle().set("border", "1px solid #9E9E9E");
        lay_Dashboards.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        lay_Dashboards.setAlignItems(FlexComponent.Alignment.BASELINE);
        lay_Dashboards.setWidthFull();

        lay_Dashboards2.getStyle().set("border", "1px solid #9E9E9E");
        lay_Dashboards2.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        lay_Dashboards2.setWidthFull();

        lay_Dashboards3.getStyle().set("border", "1px solid #9E9E9E");
        lay_Dashboards3.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        lay_Dashboards3.setWidthFull();
        // -----------------------------------------------------------------------------------------------

        // -----------------------------------------------------------------------------------------------
        // GOOGLE ANALYTICS
        // -----------------------------------------------------------------------------------------------
        btnGoogleAnalytics.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        btnGoogleAnalytics.getStyle().set("fontSize", "80%");

        lay_GoogleAnalytics.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        lay_GoogleAnalytics.setWidthFull();
        // -----------------------------------------------------------------------------------------------
        // -----------------------------------------------------------------------------------------------
        // MODULOS - BOTONES
        // -----------------------------------------------------------------------------------------------
        Modulos_Titulo.getStyle().set("fontWeight", "bold");
        Modulos_Titulo.getStyle().set("fontSize", "180%");

        layModulos_Titulo.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layModulos_Titulo.setWidthFull();
        // -----------------------------------------------------------------------------------------------

        btnClientes.setWidthFull();
        btnSubscriptores.setWidthFull();
        btnPedidos.setWidthFull();
        btnProductos.setWidthFull();
        btnCaracteristicas.setWidthFull();
        btnLineas.setWidthFull();
        btnEcomPage.setWidthFull();
        btnCupones.setWidthFull();
        btnRepartidores.setWidthFull();
        btnPromociones.setWidthFull();
        btnPuntosUP.setWidthFull();
        btnCrudBan.setWidthFull();
        // -----------------------------------------------------------------------------------------------
        btnSalirCP.addThemeVariants(ButtonVariant.LUMO_ERROR);
        // btnSalirCP.getStyle().set("fontSize","90%");
        btnSalirCP.setWidthFull();
        // -----------------------------------------------------------------------------------------------
        // END MAIN VIEW
        // -----------------------------------------------------------------------------------------------
    }

    // -----------------------------------------------------------------------------------------------
    // CPANEL Rutas
    // -----------------------------------------------------------------------------------------------
    public abstract void On_PedidosView();

    public abstract void On_ClientesView();

    public abstract void On_SubscriptoresView();

    public abstract void On_IndexWebView();

    public abstract void On_LineasEcommerceView();

    public abstract void On_ProductosView();

    public abstract void On_CaracteristicasView();

    public abstract void On_CuponesView();

    public abstract void On_RepartidoresView();

    public abstract void On_PromocionesView();

    public abstract void On_PuntosUPView();

    public abstract void On_BtnCrudBan();

    // -----------------------------------------------------------------------------------------------
    // GOOGLE ANALYTICS:
    // -----------------------------------------------------------------------------------------------
    public abstract Anchor Go_GoogleAnalytics();

    // -----------------------------------------------------------------------------------------------
    // DASHBOARDS:
    // -----------------------------------------------------------------------------------------------
    public abstract void init_Dashboards();

    public abstract void generate_Dashboard1();

    public abstract void generate_Dashboard2();

    public abstract void generate_Dashboard3_1();
    // -----------------------------------------------------------------------------------------------

    private void initEvents() {

        init_Dashboards();
        // -----------------------------------------------------------------------------------------------
        // CPANEL Rutas
        // -----------------------------------------------------------------------------------------------
        btnClientes.addClickListener(e -> {
            removeAll();
            On_ClientesView();
            // add(new ClientesView());
        });
        btnSubscriptores.addClickListener(e -> {
            removeAll();
            On_SubscriptoresView();
            // add(new PedidosView());
        });
        btnPedidos.addClickListener(e -> {
            removeAll();
            On_PedidosView();
            // add(new PedidosView());
        });
        btnLineas.addClickListener(e -> {
            removeAll();
            On_LineasEcommerceView();
            // add(new LineasEcomView());
        });
        btnProductos.addClickListener(e -> {
            removeAll();
            On_ProductosView();
            // add(new ProductosView());
        });
        btnCaracteristicas.addClickListener(e -> {
            removeAll();
            // On_ProductosView();
            On_CaracteristicasView();
            // add(new ProductosView());
        });
        btnEcomPage.addClickListener(e -> {
            removeAll();
            On_IndexWebView();
            // add(new IndexWebView());
        });
        btnCupones.addClickListener(e -> {
            removeAll();
            On_CuponesView();
            // add(new IndexWebView());
        });
        btnRepartidores.addClickListener(e -> {
            removeAll();
            On_RepartidoresView();
        });
        btnPromociones.addClickListener(e -> {
            removeAll();
            On_PromocionesView();
        });
        btnPuntosUP.addClickListener(e -> {
            removeAll();
            On_PuntosUPView();
            // add(new PedidosView());
        });
        btnSalirCP.addClickListener(e -> {
            removeAll();
            add(new App());
        });

        btnCrudBan.addClickListener(e -> {
            removeAll();
            On_BtnCrudBan();

        });

        // -----------------------------------------------------------------------------------------------
        // DASHBOARDS:
        // -----------------------------------------------------------------------------------------------
        btnGenerate_Dash1.addClickListener(e -> {
            generate_Dashboard1();
        });
        // -----------------------------------------------------------------------------------------------
        btnGenerate_Dash2.addClickListener(e -> {
            generate_Dashboard2();
        });
        // -----------------------------------------------------------------------------------------------
        btnGenerate_Dash3.addClickListener(e -> {
            generate_Dashboard3_1();
        });

        btnver_Detalle.addClickListener(e -> {
            if (Grid_Dash.isVisible() == Boolean.FALSE) {
                Grid_Dash.setVisible(true);
            } else {
                Grid_Dash.setVisible(false);
            }
        });
        // -----------------------------------------------------------------------------------------------
        // GOOGLE ANALYTICS:
        // -----------------------------------------------------------------------------------------------
        btnGoogleAnalytics.addClickListener(e -> {
            // Go_GoogleAnalytics();
            UI.getCurrent().getPage().executeJs("window.open(\"https://analytics.google.com\");");
        });

    }

}
