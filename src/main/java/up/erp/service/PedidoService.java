/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.service;

import java.util.List;
import com.upgrade.persistence.model.cmrlz.NotaPedidoDet;
import com.upgrade.persistence.model.cmrlz.NotaPedidoCab;
import com.upgrade.persistence.model.ecommerce.DirEntrega;
import com.upgrade.persistence.model.ecommerce.EstadoOrdenVentaModel;
import com.upgrade.persistence.model.ecommerce.EstadosOrdenVenta;
import com.upgrade.persistence.model.ecommerce.NotaPedidoDetModel;
import com.upgrade.persistence.model.ecommerce.NotaPedidoModel;
import com.upgrade.persistence.model.ecommerce.PedidoEcommerce;
import com.upgrade.persistence.model.extcs.Articulo;
import com.upgrade.persistence.model.extcs.Producto;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author Luis Aleman
 */
public interface PedidoService {
    
	//Busquedas
    public NotaPedidoDet getById_Prod(String id_prod);
    public void save_NotaP(NotaPedidoDet nota_ped);
    public void delete_NotaP(NotaPedidoDet nota_ped);
    public void update_NotaP(NotaPedidoDet nota_ped);
    
    //NotaPedidoCab
    public NotaPedidoCab getBy_NumOrden(String num_orden);
    public void save_NotaPed_Cab(NotaPedidoCab nota_ped);
    public void delete_NotaPed_Cab(NotaPedidoCab nota_ped);
    public void update_NotaPed_Cab(NotaPedidoCab nota_ped);
    
    
    public List<NotaPedidoDet> getListByFechas(Date fecha_ini, Date fecha_fin);
    public List<NotaPedidoDet> getListByProd_name(String id_prod,Date fecha_ini, Date fecha_fin);
    
    public List<NotaPedidoCab> getListByFech(Date fecha_ini, Date fecha_fin);
    public List<NotaPedidoCab> getListByProd_cod(String prod_cod,Date fecha_ini, Date fecha_fin);
    
    
    
    //Find Articulo
    public Articulo getById_Prod_Art(String id_prod);
    public List<Articulo> getListById_Prod_Art(String id_prod);
	
    //FrontEnd - Usuario web
    public List<NotaPedidoCab> getPedby_dirEntrega(String dir_entrega_id);
    public List<NotaPedidoModel> getPedidoEcom(String usuario_web_id);
    public List<NotaPedidoDetModel> getDetallesPedido(String id_nota_ped);
    public List<EstadoOrdenVentaModel> getEstadosPedido(String id_nota_ped);
    
    public List<NotaPedidoModel> getPedidoEcom_Panel(String usuario_web_id);
    public List<Producto> getProducto_byPedido(String nota_ped_id);
    
    public List<NotaPedidoDet> getNotaPedidoDet_byNotaPedidoCab(String notaCab_id);
    //-------------------------------------------------------------------------------------
    //Repartidores
    
    //Busquedas
    public NotaPedidoCab getBy_NumOrden_Repartidores(String num_orden);
    
    
    public List<NotaPedidoCab> getListByFech_Repartidores(Date fecha_ini, Date fecha_fin);
    
    public List<NotaPedidoCab> getPedby_dirEntrega_Repartidores(String dir_entrega_id);
    public List<NotaPedidoModel> getPedidoEcom_Panel_Repartidores(String usuario_web_id);
    
    //-------------------------------------------------------------------------------------
    //Almaceneros
    
    public NotaPedidoCab getBy_NumOrden_Almaceneros(String num_orden);
    public List<NotaPedidoCab> getListByFech_Almaceneros(Date fecha_ini, Date fecha_fin);
    public List<NotaPedidoCab> getPedby_dirEntrega_Almaceneros(String dir_entrega_id);
    public List<NotaPedidoModel> getPedidoEcom_Panel_Almaceneros(String usuario_web_id);
    
}
