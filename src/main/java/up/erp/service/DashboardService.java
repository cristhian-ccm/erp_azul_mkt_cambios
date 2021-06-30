/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.service;

import com.upgrade.persistence.model.ecommerce.CartDashboard;
import com.upgrade.persistence.model.ecommerce.VentasporMesModel;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Luis Aleman
 */
public interface DashboardService {
    
    //DASHBOARDS
    public List<Integer> get_Function_Ventas();
    public List<Integer> get_count_visits();
    public Double get_total_ventas_ecommerce_fechas();
    public List<VentasporMesModel> get_ventas_last6_month();
    
    //FILTROS : BUSQUEDAS
    public List<Integer> get_Ventas_ByFecha(Date fecha_ini, Date fecha_fin);
    public List<Integer> get_count_visits_byFecha(Date fecha_ini, Date fecha_fin);
    public Double get_TotalVentas_Ecom_ByFecha(Date fecha_ini, Date fecha_fin);
    
    public Integer get_Cantidad_CarritoCompraUsu();
    public List<CartDashboard> get_Usu_CarritoCompra_detalle();
    //
}
