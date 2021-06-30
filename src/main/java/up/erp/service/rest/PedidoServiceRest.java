/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.service.rest;

import com.upgrade.persistence.model.cmrlz.NotaPedidoCab;
import com.upgrade.persistence.model.cmrlz.NotaPedidoDet;
import com.upgrade.persistence.model.ecommerce.EstadoOrdenVentaModel;
import com.upgrade.persistence.model.ecommerce.EstadosOrdenVenta;
import com.upgrade.persistence.model.ecommerce.NotaPedidoDetModel;
import com.upgrade.persistence.model.ecommerce.NotaPedidoModel;
import com.upgrade.persistence.model.extcs.Articulo;
import com.upgrade.persistence.model.extcs.Producto;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import up.erp.service.PedidoService;
import up.erp.service.Services;
/**
 *
 * @author Luis Aleman
 */

@RequestMapping("/tracking")
@RestController
public class PedidoServiceRest implements PedidoService{

    @Override
    public NotaPedidoDet getById_Prod(String id_prod) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<NotaPedidoDet> getListByFechas(Date fecha_ini, Date fecha_fin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<NotaPedidoDet> getListByProd_name(String id_prod, Date fecha_ini, Date fecha_fin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<NotaPedidoCab> getListByFech(Date fecha_ini, Date fecha_fin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<NotaPedidoCab> getListByProd_cod(String prod_cod, Date fecha_ini, Date fecha_fin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save_NotaP(NotaPedidoDet nota_ped) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete_NotaP(NotaPedidoDet nota_ped) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update_NotaP(NotaPedidoDet nota_ped) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Articulo getById_Prod_Art(String id_prod) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Articulo> getListById_Prod_Art(String id_prod) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //FrontEnd - Usuario web
    @GetMapping("/pedidos")
    @Override
    public List<NotaPedidoModel> getPedidoEcom(@RequestParam(value = "id") String usuario_web_id) {
        return Services.getPedido().getPedidoEcom(usuario_web_id);
    }

    @GetMapping("/pedido-detalle")
    @Override
    public List<NotaPedidoDetModel> getDetallesPedido(@RequestParam(value = "idNota") String id_nota_ped) {
        return Services.getPedido().getDetallesPedido(id_nota_ped);
    }

    @GetMapping("/pedido-estados")
    @Override
    public List<EstadoOrdenVentaModel> getEstadosPedido(@RequestParam(value = "idNota") String id_nota_ped) {
        return Services.getPedido().getEstadosPedido(id_nota_ped);
    }

    @Override
    public NotaPedidoCab getBy_NumOrden(String num_orden) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save_NotaPed_Cab(NotaPedidoCab nota_ped) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete_NotaPed_Cab(NotaPedidoCab nota_ped) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update_NotaPed_Cab(NotaPedidoCab nota_ped) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<NotaPedidoModel> getPedidoEcom_Panel(String usuario_web_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<NotaPedidoCab> getPedby_dirEntrega(String dir_entrega_id) {
        return Services.getPedido().getPedby_dirEntrega(dir_entrega_id);
    }

    @Override
    public List<Producto> getProducto_byPedido(String nota_ped_id) {
        return Services.getPedido().getProducto_byPedido(nota_ped_id);
    }

    @Override
    public List<NotaPedidoCab> getListByFech_Repartidores(Date fecha_ini, Date fecha_fin) {
        return Services.getPedido().getListByFech_Repartidores(fecha_ini, fecha_fin);
    }

    @Override
    public List<NotaPedidoCab> getPedby_dirEntrega_Repartidores(String dir_entrega_id) {
        return Services.getPedido().getPedby_dirEntrega_Repartidores(dir_entrega_id);
    }

    @Override
    public List<NotaPedidoModel> getPedidoEcom_Panel_Repartidores(String usuario_web_id) {
        return Services.getPedido().getPedidoEcom_Panel_Repartidores(usuario_web_id);
    }

    @Override
    public NotaPedidoCab getBy_NumOrden_Repartidores(String num_orden) {
        return Services.getPedido().getBy_NumOrden_Repartidores(num_orden);
    }

    @Override
    public List<NotaPedidoDet> getNotaPedidoDet_byNotaPedidoCab(String notaCab_id) {
        return Services.getPedido().getNotaPedidoDet_byNotaPedidoCab(notaCab_id);
    }

    @Override
    public NotaPedidoCab getBy_NumOrden_Almaceneros(String num_orden) {
        return Services.getPedido().getBy_NumOrden_Almaceneros(num_orden);
    }

    @Override
    public List<NotaPedidoCab> getListByFech_Almaceneros(Date fecha_ini, Date fecha_fin) {
        return Services.getPedido().getListByFech_Almaceneros(fecha_ini, fecha_fin);
    }

    @Override
    public List<NotaPedidoCab> getPedby_dirEntrega_Almaceneros(String dir_entrega_id) {
        return Services.getPedido().getPedby_dirEntrega_Almaceneros(dir_entrega_id);
    }

    @Override
    public List<NotaPedidoModel> getPedidoEcom_Panel_Almaceneros(String usuario_web_id) {
        return Services.getPedido().getPedidoEcom_Panel_Almaceneros(usuario_web_id);
    }
    
    
    
    
}
