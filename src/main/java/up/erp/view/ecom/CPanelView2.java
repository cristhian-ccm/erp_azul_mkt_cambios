/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.view.ecom;

import com.upgrade.persistence.model.ecommerce.CartDashboard;
import com.upgrade.persistence.model.ecommerce.VentasporMesModel;
import com.vaadin.flow.component.html.Anchor;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import up.erp.service.Services;
import up.erp.view.App;

/**
 *
 * @author evanl
 */
public class CPanelView2 extends CPanelUI2 {
    
    //--------------------------------------------------------------------------
    //CPANEL RUTH
    //--------------------------------------------------------------------------
    public App app;
    
    public CPanelView2(App app) {
        this.app = app;
    }
    //--------------------------------------------------------------------------
    public PedidosView pedidoView;
    
    @Override
    public void On_PedidosView() {
        this.app.layHeader.removeAll();
        this.app.setContent(new PedidosView(app));
    }
    //--------------------------------------------------------------------------
    @Override
    public void On_ClientesView(){
       this.app.layHeader.removeAll();
       this.app.setContent(new ClientesView(app));
    }
    //--------------------------------------------------------------------------
    @Override
    public void On_SubscriptoresView(){
        this.app.layHeader.removeAll();
       this.app.setContent(new SubscriptoresView(app));
    }
    //--------------------------------------------------------------------------
    @Override
    public void On_ProductosView(){
       this.app.layHeader.removeAll();
       this.app.setContent(new ProductosView(app));
    }
    //--------------------------------------------------------------------------
    @Override
    public void On_LineasEcommerceView(){
       this.app.layHeader.removeAll();
       this.app.setContent(new LineasEcomView(app));
    }
    //--------------------------------------------------------------------------
    @Override
    public void On_IndexWebView(){
       this.app.layHeader.removeAll();
       //this.app.setContent(new IndexWebView(app));
       this.app.setContent(new IndexWeb2View(app));
    }
    //--------------------------------------------------------------------------
    @Override
    public void On_CuponesView(){
       this.app.layHeader.removeAll();
       this.app.setContent(new CuponesView(app));
    }
    //--------------------------------------------------------------------------
    @Override
    public void On_RepartidoresView(){
       this.app.layHeader.removeAll();
       this.app.setContent(new RepartidoresView(app));
    }
    //--------------------------------------------------------------------------
    @Override
    public void On_PromocionesView(){
       this.app.layHeader.removeAll();
       this.app.setContent(new PromocionesView(app));
    }
    //--------------------------------------------------------------------------
    @Override
    public void On_PuntosUPView(){
        this.app.layHeader.removeAll();
       this.app.setContent(new PuntosUpView(app));
    }

    @Override
    public void On_BtnCrudBan() {
        this.app.layHeader.removeAll();
        this.app.setContent(new BannerView(app));
    }

    //--------------------------------------------------------------------------
    //this.app.setContent(new PlantillaTransformacionesView(this.app));
    
    //public void PedidosView_Construct(PedidosView pedidoView){
      //  this.pedidoView = pedidoView;
    //}
    
    //--------------------------------------------------------------------------
    //GOOGLE ANALYTICS:
    //--------------------------------------------------------------------------
    @Override
    public Anchor Go_GoogleAnalytics(){
        Anchor anchor = new Anchor();
        //Anchor anchor = new Anchor("",new Button("", VaadinIcon.FILE_TEXT.create()));    
        anchor.setHref("https://analytics.google.com");
        anchor.setTarget("_blank");
        return anchor;
    }
    //--------------------------------------------------------------------------
    
    
    //--------------------------------------------------------------------------
    //DASHBOARDS:
    //--------------------------------------------------------------------------
    @Override
    public void init_Dashboards(){
        //----------------------------------------------------------------------
        //DASHBOARD 1: ECOMMERCE VENTAS VS OTRAS VENTAS UPGRADE
        //----------------------------------------------------------------------
        Double v_ecommerce = 0.00;
        Double v_otros = 0.00;
        List<Integer> L_Ventas = new ArrayList<>();
        
        L_Ventas = Services.getDashboardService().get_Function_Ventas();
        v_ecommerce = L_Ventas.get(0).doubleValue();
        v_otros = L_Ventas.get(1).doubleValue();
        System.out.println("DASHBOARD 1: Ventas Ecommerce: " + v_ecommerce);
        System.out.println("DASHBOARD 1: Ventas Otros: " + v_otros);

        dd_pieChart.generate_Chart(v_ecommerce,v_otros);
        
        //----------------------------------------------------------------------
        //DASHBOARD 2: ECOMMERCE: VISITANTES VS USUARIOS REGISTRADOS
        //----------------------------------------------------------------------
        Double u_invitados = 0.00;
        Double u_registrados = 0.00;
        List<Integer> L_Visitantes = new ArrayList<>();
        
        L_Visitantes = Services.getDashboardService().get_count_visits();
        u_invitados = L_Visitantes.get(0).doubleValue();
        u_registrados = L_Visitantes.get(1).doubleValue();
        System.out.println("DASHBOARD 2: Usuarios Invitados: " + u_invitados);
        System.out.println("DASHBOARD 2: Usuarios Registrados: " + u_registrados);
        
        dd_donutChart.generate_Chart(u_invitados,u_registrados);
        
        //----------------------------------------------------------------------
        //DASHBOARD 3: ECOMMERCE: TOTAL VENTAS && VENTAS ULTIMOS 6 MESES
        //----------------------------------------------------------------------
        Double total_ventas_Ecom = 0.00;
        String label_total_ventasE = "";
        
        total_ventas_Ecom = Services.getDashboardService().get_total_ventas_ecommerce_fechas();
        System.out.println("DASHBOARD 3: Total Ventas Ecommerce: " + total_ventas_Ecom);
        
        label_total_ventasE = String.valueOf(total_ventas_Ecom);
        dash3_EVentasTot.setText(label_total_ventasE);
        //----------------------------------------------------------------------
        List<VentasporMesModel> L_VentasPorMes = new ArrayList<>();
        
        L_VentasPorMes = Services.getDashboardService().get_ventas_last6_month();
        dd_lineChart.generate_Chart(L_VentasPorMes);
        
        
        //----------------------------------------------------------------------
        //DASHBOARD 4: ECOMMERCE: CANTIDAD COMPRAS INCONCLUSAS - (ITEMS EN CARRITO)
        //----------------------------------------------------------------------
        Integer cantidad_compra_inconclusa = 0;
        List<CartDashboard> L_CartDash = new ArrayList<>();
        
        cantidad_compra_inconclusa = Services.getDashboardService().get_Cantidad_CarritoCompraUsu();
        System.out.println("DASHBOARD 4: Cantidad Total Compras Inconclusas: " + cantidad_compra_inconclusa);
        dash4_CartNoShopTitCant.setText(String.valueOf(cantidad_compra_inconclusa));
        
        L_CartDash = Services.getDashboardService().get_Usu_CarritoCompra_detalle();
        if(!L_CartDash.isEmpty()){
            Grid_Dash.setItems(L_CartDash);
        }
        //----------------------------------------------------------------------
    }
    //--------------------------------------------------------------------------
    @Override
    public void generate_Dashboard1(){
        //----------------------------------------------------------------------
        //DASHBOARD 1: ECOMMERCE VENTAS VS OTRAS VENTAS UPGRADE
        //----------------------------------------------------------------------
        Double v_ecommerce = 0.00;
        Double v_otros = 0.00;
        List<Integer> L_Ventas = new ArrayList<>();
        Date fecha_ini = new Date();
        Date fecha_fin = new Date();
        
        if(!FechIni_Dash1.isEmpty() && !FechFin_Dash1.isEmpty()){
            fecha_ini = Date.from(FechIni_Dash1.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
            fecha_fin = Date.from(FechFin_Dash1.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
            
            //L_Ventas = Services.getDashboardService().get_Function_Ventas();
            L_Ventas = Services.getDashboardService().get_Ventas_ByFecha(fecha_ini, fecha_fin);
            v_ecommerce = L_Ventas.get(0).doubleValue();
            v_otros = L_Ventas.get(1).doubleValue();
            System.out.println("DASHBOARD 1: Ventas Ecommerce: " + v_ecommerce);
            System.out.println("DASHBOARD 1: Ventas Otros: " + v_otros);
            dd_pieChart.delete_Chart();
            dd_pieChart.generate_Chart(v_ecommerce,v_otros);
        }
    }
    //--------------------------------------------------------------------------
    @Override
    public void generate_Dashboard2(){
        //----------------------------------------------------------------------
        //DASHBOARD 2: ECOMMERCE: VISITANTES VS USUARIOS REGISTRADOS
        //----------------------------------------------------------------------
        Double u_invitados = 0.00;
        Double u_registrados = 0.00;
        List<Integer> L_Visitantes = new ArrayList<>();
        Date fecha_ini = new Date();
        Date fecha_fin = new Date();
        
        if(!FechIni_Dash2.isEmpty() && !FechFin_Dash2.isEmpty()){
            fecha_ini = Date.from(FechIni_Dash2.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
            fecha_fin = Date.from(FechFin_Dash2.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
            
            //L_Visitantes = Services.getDashboardService().get_count_visits();
            L_Visitantes = Services.getDashboardService().get_Ventas_ByFecha(fecha_ini, fecha_fin);
            u_invitados = L_Visitantes.get(0).doubleValue();
            u_registrados = L_Visitantes.get(1).doubleValue();
            System.out.println("DASHBOARD 2: Usuarios Invitados: " + u_invitados);
            System.out.println("DASHBOARD 2: Usuarios Registrados: " + u_registrados);
            dd_donutChart.delete_Chart();
            dd_donutChart.generate_Chart(u_invitados,u_registrados);
        }
    }
    
    @Override
    public void generate_Dashboard3_1(){
        //----------------------------------------------------------------------
        //DASHBOARD 3: TOTAL VENTAS ECOMMERCE
        //----------------------------------------------------------------------
        Double total_ventas_Ecom = 0.00;
        String label_total_ventasE = "";
        Date fecha_ini = new Date();
        Date fecha_fin = new Date();
        
        if(!FechIni_Dash3.isEmpty() && !FechFin_Dash3.isEmpty()){
            fecha_ini = Date.from(FechIni_Dash3.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
            fecha_fin = Date.from(FechFin_Dash3.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        
            //total_ventas_Ecom = Services.getDashboardService().get_total_ventas_ecommerce_fechas();
            total_ventas_Ecom = Services.getDashboardService().get_TotalVentas_Ecom_ByFecha(fecha_ini, fecha_fin);
            System.out.println("DASHBOARD 3: Total Ventas Ecommerce: " + total_ventas_Ecom);

            label_total_ventasE = String.valueOf(total_ventas_Ecom);
            dash3_EVentasTot.setText(label_total_ventasE);
        }
        
    }
    
    
}
