/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.server.serviceimpl;

import com.upgrade.persistence.model.cmrlz.NotaPedidoCab;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ts.com.service.util.db.server.CRUD;
import com.upgrade.persistence.model.cmrlz.NotaPedidoDet;
import com.upgrade.persistence.model.ecommerce.Cupones;
import com.upgrade.persistence.model.ecommerce.DirEntrega;
import com.upgrade.persistence.model.ecommerce.EstadoOrdenVentaModel;
import com.upgrade.persistence.model.ecommerce.EstadosOrdenVenta;
import com.upgrade.persistence.model.ecommerce.NotaPedidoDetModel;
import com.upgrade.persistence.model.ecommerce.NotaPedidoModel;
import com.upgrade.persistence.model.ecommerce.UsuarioWeb;
import com.upgrade.persistence.model.extcs.Articulo;
import com.upgrade.persistence.model.extcs.Producto;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import ts.com.service.util.db.Query;
import up.erp.service.PedidoService;
import up.erp.server.Server;


/**
 *
 * @author Luis Aleman
 */
public class PedidoServiceImpl implements PedidoService {

    @Override
    public NotaPedidoDet getById_Prod(String id_prod) {
        NotaPedidoDet result = null;
        try {
            String where = "where producto_id = '"+id_prod+"' limit 1";
            List<NotaPedidoDet> list = CRUD.list(NotaPedidoDet.class,where);
            if(!list.isEmpty()){
                result = list.get(0);
            }
        } catch (Exception ex) {
            Logger.getLogger(PedidoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    @Override
    public List<NotaPedidoDet> getListByFechas(Date fecha_ini, Date fecha_fin) {
        List<NotaPedidoDet> result = null;
        try {
            //vendedor_id = 39385 (ecommerce)
            String where = "where c.vendedor_id = '"+ Server.VENDEDOR_ECOMMERCE_ID +"' and c.fecha between '" + fecha_ini + "' and '" + fecha_fin + "' limit 10";
            String [] require = {"producto","notaPedido","notaPedido.direccion_Ecommerce"};
            result = CRUD.list(NotaPedidoDet.class,require,where);
        } catch (Exception ex) {
            Logger.getLogger(PedidoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    @Override
    public List<NotaPedidoDet> getListByProd_name(String prod_name,Date fecha_ini, Date fecha_fin) {
        List<NotaPedidoDet> result = null;
        try {
            //vendedor_id = 39385 (ecommerce)
            String where = "where (b.nombre ilike '%"+prod_name+"%' or b.descripcion ilike '%"+prod_name+"%') and c.vendedor_id = '"+ Server.VENDEDOR_ECOMMERCE_ID +"' and c.fecha between '" + fecha_ini + "' and '" + fecha_fin + "' limit 10";
            String [] require = {"producto","notaPedido","notaPedido.direccion_Ecommerce"};
            result = CRUD.list(NotaPedidoDet.class,require,where);
        } catch (Exception ex) {
            Logger.getLogger(PedidoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    /*
    @Override
    public List<NotaPedidoDet> getListById_Prod(String id_prod,Date fecha_ini, Date fecha_fin) {
        List<NotaPedidoDet> result = new ArrayList<>();
        Query query = new Query();
        String select = "select * from cmrlz.notas_pedido_det npd\n"+
                        "left join cmrlz.notas_pedido_cab npc on npd.nota_pedido_id = npc.id";
        query.select.set(select);
        query.where = "where npd.producto_id = '" + id_prod + "' and npc.fecha between '" + fecha_ini + "' and '" + fecha_fin + "' limit 50";
        query.end = "";
        try {
            Object[][] rs = query.initResultSet();
            if (rs.length == 0) {
                return result;
            }
            for (int i = 0; i < rs.length; i++) {
                NotaPedidoDet Nota_ped_det = new NotaPedidoDet();
                Nota_ped_det.setId((Integer) rs[i][0]);
                result.add(Nota_ped_det);
            }

        } catch (Exception ex) {
            Logger.getLogger(PedidoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    */
    
    @Override
    public void save_NotaP(NotaPedidoDet nota_ped) {
        try {
            CRUD.save(nota_ped);
        } catch (Exception ex) {
            Logger.getLogger(PedidoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }

    @Override
    public void delete_NotaP(NotaPedidoDet nota_ped) {
        try {
            CRUD.delete(nota_ped);
        } catch (Exception ex) {
            Logger.getLogger(PedidoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update_NotaP(NotaPedidoDet nota_ped) {
        try {
            CRUD.update(nota_ped);
        } catch (Exception ex) {
            Logger.getLogger(PedidoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Articulo getById_Prod_Art(String id_prod) {
        Articulo art = null;
        try {
            String where = "where producto_id = '"+id_prod+"' limit 1";
            List<Articulo> list = CRUD.list(Articulo.class,where);
            if(!list.isEmpty()){
                art = list.get(0);
            }
        } catch (Exception ex) {
            Logger.getLogger(PedidoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return art;
    }

    @Override
    public List<Articulo> getListById_Prod_Art(String id_prod) {
        List<Articulo> art_list = null;
        try {
            String where = "where producto_id = '"+id_prod+"' limit 5";
            String [] require = {"almacen"};
            art_list = CRUD.list(Articulo.class,require,where);
        } catch (Exception ex) {
            Logger.getLogger(PedidoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return art_list;
    }

    @Override
    public List<NotaPedidoCab> getListByFech(Date fecha_ini, Date fecha_fin) {
        List<NotaPedidoCab> result = new ArrayList<>();
        try {
            //vendedor_id = 39385 (ecommerce)
            //String where = "where a.vendedor_id = '39385' and a.fecha between '" + fecha_ini + "' and '" + fecha_fin + "' limit 10";
            String where = "where a.vendedor_id = '"+ Server.VENDEDOR_ECOMMERCE_ID +"' and a.fecha between '" + fecha_ini + "' and '" + fecha_fin + "' limit 1000";
            //String where = "where a.aprobada is true and a.vendedor_id = '"+ Server.VENDEDOR_ECOMMERCE_ID +"' and a.fecha >= '" + fecha_ini + "' and a.fecha <= '" + fecha_fin + "' limit 1000";
            String [] require = {"direccion_Ecommerce","direccion_Ecommerce.usuario_web","formaPago"};
            result = CRUD.list(NotaPedidoCab.class,require,where);
        } catch (Exception ex) {
            Logger.getLogger(PedidoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public List<NotaPedidoCab> getListByProd_cod(String prod_cod, Date fecha_ini, Date fecha_fin) {
        List<NotaPedidoCab> result = new ArrayList<>();
        try {
            //vendedor_id = 39385 (ecommerce)
            //String where = "where a.vendedor_id = '39385' and a.fecha between '" + fecha_ini + "' and '" + fecha_fin + "' limit 10";
            String where = "where a.aprobada is true and a.vendedor_id = '"+ Server.VENDEDOR_ECOMMERCE_ID +"' and a.fecha between '" + fecha_ini + "' and '" + fecha_fin + "' limit 10";
            String [] require = {"direccion_Ecommerce","formaPago"};
            result = CRUD.list(NotaPedidoCab.class,require,where);
        } catch (Exception ex) {
            Logger.getLogger(PedidoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    @Override
    public List<NotaPedidoModel> getPedidoEcom_Panel(String usuario_web_id) {
        
        List<NotaPedidoModel> list_npm = new ArrayList<>();
        List<NotaPedidoCab> l_npcab = new ArrayList<>();
        NotaPedidoModel npm = new NotaPedidoModel();
        //DirEntrega
        DirEntrega dir_entrega = new DirEntrega();
        String id_dirEntrega = "";
        //Cupon
        Cupones cupon = new Cupones();
        
        try {
            String where = "where a.usuariow_id = " + usuario_web_id + " limit 10";
            String [] require = {"usuario_web"};
            List<DirEntrega> list_dirE= CRUD.list(DirEntrega.class,require,where);
            if(!list_dirE.isEmpty()){
                for(int i=0; i < list_dirE.size();i++){
                    dir_entrega = new DirEntrega();
                    dir_entrega = list_dirE.get(i);
                    id_dirEntrega = String.valueOf(dir_entrega.getId());
                    
                    NotaPedidoCab npcab = new NotaPedidoCab();
                    l_npcab = getPedby_dirEntrega(id_dirEntrega);
                    if(!l_npcab.isEmpty()){
                        for (int j = 0; j < l_npcab.size(); j++){
                            npcab = new NotaPedidoCab();
                            npcab = l_npcab.get(j);
                            cupon = new Cupones();
                            cupon = npcab.getCupon();
                            npm = new NotaPedidoModel();
                            System.out.println("Id: " + npcab.getId());
                            npm.setNota_pedido_id(npcab.getId());
                            npm.setNum_orden(npcab.getNumero());
                            npm.setFecha_ingreso(npcab.getFecha());
                            npm.setFecha_entrega(npcab.getFechaEntrega());
                            npm.setTipo_entrega(npcab.getTipo_Entrega());
                            npm.setEstado(npcab.getEstado_actual());
                            npm.setTotalVenta(npcab.getTotal());
                            if(cupon != null){npm.setCupon(cupon);}
                            list_npm.add(npm);
                        }
                    }
                }
            }
        }
        catch (Exception ex) {
                Logger.getLogger(PedidoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list_npm;
    }
	
    //FrontEnd - Usuario web
    @Override
    public List<NotaPedidoCab> getPedby_dirEntrega(String dir_entrega_id){
        List<NotaPedidoCab> l_npcab = new ArrayList<>();
        try {
            String where = "where b.id = " + dir_entrega_id + " order by a.fecha desc limit 10";
            String [] require = {"direccion_Ecommerce","cupon","formaPago"};
            l_npcab = CRUD.list(NotaPedidoCab.class,require,where);
        } catch (Exception ex) {
                        Logger.getLogger(PedidoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }
        return l_npcab;
    }
    
    @Override
    public List<NotaPedidoModel> getPedidoEcom(String usuario_web_id) {
        
        List<NotaPedidoModel> list_npm = new ArrayList<>();
        List<NotaPedidoCab> l_npcab = new ArrayList<>();
        NotaPedidoModel npm = new NotaPedidoModel();
        //DirEntrega
        DirEntrega dir_entrega = new DirEntrega();
        String id_dirEntrega = "";
        //Cupon
        Cupones cupon = new Cupones();
        
        try {
            String where = "where a.usuariow_id = " + usuario_web_id + " limit 100";
            String [] require = {"usuario_web"};
            List<DirEntrega> list_dirE= CRUD.list(DirEntrega.class,require,where);
            if(!list_dirE.isEmpty()){
                for(int i=0; i < list_dirE.size();i++){
                    dir_entrega = new DirEntrega();
                    dir_entrega = list_dirE.get(i);
                    id_dirEntrega = String.valueOf(dir_entrega.getId());
                    
                    NotaPedidoCab npcab = new NotaPedidoCab();
                    l_npcab = getPedby_dirEntrega(id_dirEntrega);
                    if(!l_npcab.isEmpty()){
                        for (int j = 0; j < l_npcab.size(); j++){
                            npcab = new NotaPedidoCab();
                            npcab = l_npcab.get(j);
                            cupon = new Cupones();
                            cupon = npcab.getCupon();
                            npm = new NotaPedidoModel();
                            System.out.println("Id: " + npcab.getId());
                            npm.setNota_pedido_id(npcab.getId());
                            npm.setNum_orden(npcab.getNumero());
                            npm.setFecha_ingreso(npcab.getFecha());
                            npm.setFecha_entrega(npcab.getFechaEntrega());
                            npm.setTipo_entrega(npcab.getTipo_Entrega());
                            npm.setEstado(npcab.getEstado_actual());
                            npm.setTotalVenta(npcab.getTotal());
                            if(cupon != null){npm.setCupon(cupon);}
                            list_npm.add(npm);
                        }
                    }
                }
            }
        }
        catch (Exception ex) {
                Logger.getLogger(PedidoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list_npm;
    }
    
    @Override
    public List<NotaPedidoDetModel> getDetallesPedido(String id_nota_ped){
        List<NotaPedidoDetModel> list_npd_model = new ArrayList<>();
        NotaPedidoDetModel npd_model = new NotaPedidoDetModel();
        List<NotaPedidoDet> list_npd = new ArrayList<>();
        NotaPedidoDet npd = new NotaPedidoDet();
        BigDecimal Total;
        try {
            String where = "where a.nota_pedido_id = "+ id_nota_ped;
            String [] require = {"producto"};
            list_npd = CRUD.list(NotaPedidoDet.class,require,where);
            for(int i = 0; i < list_npd.size(); i++){
                npd = list_npd.get(i);
                System.out.println("Id: " + npd.getId());
                npd_model = new NotaPedidoDetModel();
                npd_model.setUrl_img(npd.getProducto().getEcom_img1_nombre());
                npd_model.setProd_nombre(npd.getProducto().getNombre());
                npd_model.setPrecio_unitario(npd.getPrecioUnitarioProducto());
                npd_model.setCantidad(npd.getCantidad());
                npd_model.setCodigo(npd.getProducto().getCodigo());
                Total = npd.getCantidad();
                Total.multiply(npd.getPrecioUnitarioVenta());
                npd_model.setTotal(Total);
                list_npd_model.add(npd_model);
            }
        } catch (Exception ex) {
            Logger.getLogger(PedidoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list_npd_model;
    }

    @Override
    public List<EstadoOrdenVentaModel> getEstadosPedido(String id_nota_ped) {
        List<EstadosOrdenVenta> estados = new ArrayList<>();
        List<EstadoOrdenVentaModel> list_estados = new ArrayList<>();
        EstadoOrdenVentaModel state = new EstadoOrdenVentaModel();
        String estado_valor = "";
        try {
            String where = "where a.nota_pedido_id = " + id_nota_ped;
            String [] require = {"dir_entrega"};
            estados = CRUD.list(EstadosOrdenVenta.class,require,where);
            for(int i=0; i < estados.size(); i++){
                state.setFecha_actualizacion(estados.get(i).getFecha_registro());
                estado_valor = estados.get(i).getEstado();
                state.setEstado(estado_valor);
                list_estados.add(state);
            }
        } catch (Exception ex) {
            Logger.getLogger(PedidoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list_estados;
    }

    @Override
    public NotaPedidoCab getBy_NumOrden(String num_orden) {
        NotaPedidoCab result = new NotaPedidoCab();
        try {
            String where = "where numero = "+num_orden+" limit 1";
            String [] require = {"direccion_Ecommerce","direccion_Ecommerce.usuario_web","formaPago"};
            List<NotaPedidoCab> list = CRUD.list(NotaPedidoCab.class,require,where);
            if(!list.isEmpty()){
                result = list.get(0);
            }
        } catch (Exception ex) {
            Logger.getLogger(PedidoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public void save_NotaPed_Cab(NotaPedidoCab nota_ped) {
        try {
            CRUD.save(nota_ped);
        } catch (Exception ex) {
            Logger.getLogger(PedidoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete_NotaPed_Cab(NotaPedidoCab nota_ped) {
        try {
            CRUD.delete(nota_ped);
        } catch (Exception ex) {
            Logger.getLogger(PedidoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update_NotaPed_Cab(NotaPedidoCab nota_ped) {
        try {
            CRUD.update(nota_ped);
        } catch (Exception ex) {
            Logger.getLogger(PedidoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public List<Producto> getProducto_byPedido(String nota_ped_id){
        List<NotaPedidoDet> l_pedido_det = new ArrayList<>();
        List<Producto> l_productos = new ArrayList<>();
        Producto prod_actual = new Producto();
        try {
            String where = "where a.nota_pedido_id = '"+nota_ped_id+"'";
            String [] require = {"producto"};
            l_pedido_det = CRUD.list(NotaPedidoDet.class,require,where);
            if(!l_pedido_det.isEmpty()){
                for(int i = 0; i < l_pedido_det.size(); i++){
                    prod_actual = new Producto();
                    prod_actual.setNombre("Producto No definido");
                    if(l_pedido_det.get(i).getProducto() != null){
                        prod_actual = l_pedido_det.get(i).getProducto();
                        l_productos.add(prod_actual);
                    }
                    else {l_productos.add(prod_actual);}
                System.out.println("Pedido id: " + nota_ped_id + ", Producto: " + prod_actual.getNombre());
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(PedidoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l_productos;
    }
    
    
    //-------------------------------------------------------------------------------------
    @Override
    public List<NotaPedidoDet> getNotaPedidoDet_byNotaPedidoCab(String notaCab_id){
        NotaPedidoDet npDet = new NotaPedidoDet();
        List<NotaPedidoDet> l_pedido_det = new ArrayList<>();
        try {
            String where = "where a.nota_pedido_id = '"+notaCab_id+"'";
            l_pedido_det = CRUD.list(NotaPedidoDet.class,where);
        } catch (Exception ex) {
            Logger.getLogger(PedidoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l_pedido_det;
    }
    
    //-------------------------------------------------------------------------------------
    //Repartidores
    //-------------------------------------------------------------------------------------
    //Busquedas
    //-------------------------------------------------------------------------------------
    @Override
    public NotaPedidoCab getBy_NumOrden_Repartidores(String num_orden){
        NotaPedidoCab result = new NotaPedidoCab();
        try {
            String where = "where numero = "+num_orden+" limit 1";
            String [] require = {"direccion_Ecommerce","direccion_Ecommerce.usuario_web","formaPago"};
            List<NotaPedidoCab> list = CRUD.list(NotaPedidoCab.class,require,where);
            if(!list.isEmpty()){
                result = list.get(0);
            }
        } catch (Exception ex) {
            Logger.getLogger(PedidoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    //-------------------------------------------------------------------------------------
    @Override
    public List<NotaPedidoCab> getListByFech_Repartidores(Date fecha_ini, Date fecha_fin){
        List<NotaPedidoCab> result = new ArrayList<>();;
        try {
            //VENDEDOR_ECOMMERCE_ID = 39385 bd Prueba || VENDEDOR_ECOMMERCE_ID = 40454 bd Produccion
            String where = "where a.estado_actual = 'D' and a.tipo_entrega = 'delivery' and a.aprobada is true and a.vendedor_id = '"+ Server.VENDEDOR_ECOMMERCE_ID +"' and a.fecha between '" + fecha_ini + "' and '" + fecha_fin + "' limit 500";
            String [] require = {"direccion_Ecommerce","direccion_Ecommerce.usuario_web","formaPago"};
            result = CRUD.list(NotaPedidoCab.class,require,where);
        } catch (Exception ex) {
            Logger.getLogger(PedidoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    //-------------------------------------------------------------------------------------
    public List<UsuarioWeb> find_soloActivos_Repartidores(String nombre) {
        List<UsuarioWeb> result = new ArrayList<>();
        try {
            String where = "where activo is true and (nombres ilike '%"+nombre+"%' or apellidos ilike '%"+nombre+"%') limit 1000";
            result = CRUD.list(UsuarioWeb.class,where);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioWebServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    //-------------------------------------------------------------------------------------
    @Override
    public List<NotaPedidoCab> getPedby_dirEntrega_Repartidores(String dir_entrega_id){
        List<NotaPedidoCab> l_npcab = new ArrayList<>();
        try {
            String where = "where a.estado_actual = 'D' and a.tipo_entrega = 'delivery' and b.id = " + dir_entrega_id + " order by a.id desc limit 50";
            String [] require = {"direccion_Ecommerce","cupon","formaPago"};
            l_npcab = CRUD.list(NotaPedidoCab.class,require,where);
        } catch (Exception ex) {
                        Logger.getLogger(PedidoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }
        return l_npcab;
    }
    //-------------------------------------------------------------------------------------
    @Override
    public List<NotaPedidoModel> getPedidoEcom_Panel_Repartidores(String usuario_web_id){
        List<NotaPedidoModel> list_npm = new ArrayList<>();
        List<NotaPedidoCab> l_npcab = new ArrayList<>();
        NotaPedidoModel npm = new NotaPedidoModel();
        //DirEntrega
        DirEntrega dir_entrega = new DirEntrega();
        String id_dirEntrega = "";
        //Cupon
        Cupones cupon = new Cupones();
        
        try {
            String where = "where a.usuariow_id = " + usuario_web_id + " limit 10";
            String [] require = {"usuario_web"};
            List<DirEntrega> list_dirE= CRUD.list(DirEntrega.class,require,where);
            if(!list_dirE.isEmpty()){
                for(int i=0; i < list_dirE.size();i++){
                    dir_entrega = new DirEntrega();
                    dir_entrega = list_dirE.get(i);
                    id_dirEntrega = String.valueOf(dir_entrega.getId());
                    
                    NotaPedidoCab npcab = new NotaPedidoCab();
                    l_npcab = getPedby_dirEntrega_Repartidores(id_dirEntrega);
                    if(!l_npcab.isEmpty()){
                        for (int j = 0; j < l_npcab.size(); j++){
                            npcab = new NotaPedidoCab();
                            npcab = l_npcab.get(j);
                            cupon = new Cupones();
                            cupon = npcab.getCupon();
                            npm = new NotaPedidoModel();
                            System.out.println("Id: " + npcab.getId());
                            npm.setNota_pedido_id(npcab.getId());
                            npm.setNum_orden(npcab.getNumero());
                            npm.setFecha_ingreso(npcab.getFecha());
                            npm.setFecha_entrega(npcab.getFechaEntrega());
                            npm.setTipo_entrega(npcab.getTipo_Entrega());
                            npm.setEstado(npcab.getEstado_actual());
                            npm.setTotalVenta(npcab.getTotal());
                            if(cupon != null){npm.setCupon(cupon);}
                            list_npm.add(npm);
                        }
                    }
                }
            }
        }
        catch (Exception ex) {
                Logger.getLogger(PedidoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list_npm;
    }
    //-------------------------------------------------------------------------------------
    
    
    //-------------------------------------------------------------------------------------
    //Almaceneros
    //-------------------------------------------------------------------------------------
    @Override
    public NotaPedidoCab getBy_NumOrden_Almaceneros(String num_orden){
        NotaPedidoCab result = new NotaPedidoCab();
        try {
            String where = "where numero = "+num_orden+" limit 1";
            String [] require = {"direccion_Ecommerce","direccion_Ecommerce.usuario_web","formaPago"};
            List<NotaPedidoCab> list = CRUD.list(NotaPedidoCab.class,require,where);
            if(!list.isEmpty()){
                result = list.get(0);
            }
        } catch (Exception ex) {
            Logger.getLogger(PedidoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    //-------------------------------------------------------------------------------------
    @Override
    public List<NotaPedidoCab> getListByFech_Almaceneros(Date fecha_ini, Date fecha_fin){
        List<NotaPedidoCab> result = new ArrayList<>();;
        try {
            //VENDEDOR_ECOMMERCE_ID = 39385 bd Prueba || VENDEDOR_ECOMMERCE_ID = 40454 bd Produccion
            String where = "where a.estado_actual = 'A' and a.tipo_entrega = 'delivery' and a.aprobada is true and a.vendedor_id = '"+ Server.VENDEDOR_ECOMMERCE_ID +"' and a.fecha between '" + fecha_ini + "' and '" + fecha_fin + "' limit 500";
            String [] require = {"direccion_Ecommerce","direccion_Ecommerce.usuario_web","formaPago"};
            result = CRUD.list(NotaPedidoCab.class,require,where);
        } catch (Exception ex) {
            Logger.getLogger(PedidoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    //-------------------------------------------------------------------------------------
    public List<UsuarioWeb> find_soloActivos_Almaceneros(String nombre) {
        List<UsuarioWeb> result = new ArrayList<>();
        try {
            String where = "where activo is true and (nombres ilike '%"+nombre+"%' or apellidos ilike '%"+nombre+"%') limit 1000";
            result = CRUD.list(UsuarioWeb.class,where);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioWebServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    //-------------------------------------------------------------------------------------
    @Override
    public List<NotaPedidoCab> getPedby_dirEntrega_Almaceneros(String dir_entrega_id){
        List<NotaPedidoCab> l_npcab = new ArrayList<>();
        try {
            String where = "where a.estado_actual = 'A' and a.tipo_entrega = 'delivery' and b.id = " + dir_entrega_id + " order by a.id desc limit 50";
            String [] require = {"direccion_Ecommerce","cupon","formaPago"};
            l_npcab = CRUD.list(NotaPedidoCab.class,require,where);
        } catch (Exception ex) {
                        Logger.getLogger(PedidoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }
        return l_npcab;
    }
    //-------------------------------------------------------------------------------------
    @Override
    public List<NotaPedidoModel> getPedidoEcom_Panel_Almaceneros(String usuario_web_id){
        List<NotaPedidoModel> list_npm = new ArrayList<>();
        List<NotaPedidoCab> l_npcab = new ArrayList<>();
        NotaPedidoModel npm = new NotaPedidoModel();
        //DirEntrega
        DirEntrega dir_entrega = new DirEntrega();
        String id_dirEntrega = "";
        //Cupon
        Cupones cupon = new Cupones();
        
        try {
            String where = "where a.usuariow_id = " + usuario_web_id + " limit 10";
            String [] require = {"usuario_web"};
            List<DirEntrega> list_dirE= CRUD.list(DirEntrega.class,require,where);
            if(!list_dirE.isEmpty()){
                for(int i=0; i < list_dirE.size();i++){
                    dir_entrega = new DirEntrega();
                    dir_entrega = list_dirE.get(i);
                    id_dirEntrega = String.valueOf(dir_entrega.getId());
                    
                    NotaPedidoCab npcab = new NotaPedidoCab();
                    l_npcab = getPedby_dirEntrega_Almaceneros(id_dirEntrega);
                    if(!l_npcab.isEmpty()){
                        for (int j = 0; j < l_npcab.size(); j++){
                            npcab = new NotaPedidoCab();
                            npcab = l_npcab.get(j);
                            cupon = new Cupones();
                            cupon = npcab.getCupon();
                            npm = new NotaPedidoModel();
                            System.out.println("Id: " + npcab.getId());
                            npm.setNota_pedido_id(npcab.getId());
                            npm.setNum_orden(npcab.getNumero());
                            npm.setFecha_ingreso(npcab.getFecha());
                            npm.setFecha_entrega(npcab.getFechaEntrega());
                            npm.setTipo_entrega(npcab.getTipo_Entrega());
                            npm.setEstado(npcab.getEstado_actual());
                            npm.setTotalVenta(npcab.getTotal());
                            if(cupon != null){npm.setCupon(cupon);}
                            list_npm.add(npm);
                        }
                    }
                }
            }
        }
        catch (Exception ex) {
                Logger.getLogger(PedidoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list_npm;
    }
    //-------------------------------------------------------------------------------------
}
