/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.server.serviceimpl;

import com.upgrade.persistence.model.ecommerce.EstadosOrdenVenta;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ts.com.service.util.db.server.CRUD;
import up.erp.service.EstadosOrdenVentaService;
/**
 *
 * @author Luis Aleman
 */
public class EstadosOrdenVentaServiceImpl implements EstadosOrdenVentaService{

    
    @Override
    public EstadosOrdenVenta find_ByIdDirEntr(String id_dir_entrega) {
        EstadosOrdenVenta result = new EstadosOrdenVenta();
        try {
            String where = "where a.id = '" + id_dir_entrega + "' limit 1";
            String [] require = {"dir_entrega"};
            List<EstadosOrdenVenta> list = CRUD.list(EstadosOrdenVenta.class,require,where);
            if(!list.isEmpty()){
                result = list.get(0);
            }
        } catch (Exception ex) {
            Logger.getLogger(EstadosOrdenVentaServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public List<EstadosOrdenVenta> findList_ByFecha(Date fecha_ini, Date fecha_fin) {
        List<EstadosOrdenVenta> result = new ArrayList<>();
        try {
            String where = "where a.fecha between '" + fecha_ini + "' and '" + fecha_fin + "' limit 10";
            String [] require = {"dir_entrega"};
            result = CRUD.list(EstadosOrdenVenta.class,require,where);
        } catch (Exception ex) {
            Logger.getLogger(EstadosOrdenVentaServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public void save_Estado_Orden(EstadosOrdenVenta pedido) {
        try {
            CRUD.save(pedido);
        } catch (Exception ex) {
            Logger.getLogger(EstadosOrdenVentaServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    @Override
    public void update_Estado_Orden(EstadosOrdenVenta pedido) {
        try {
            CRUD.update(pedido);
        } catch (Exception ex) {
            Logger.getLogger(EstadosOrdenVentaServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete_Estado_Orden(EstadosOrdenVenta pedido) {
        try {
            CRUD.delete(pedido);
        } catch (Exception ex) {
            Logger.getLogger(EstadosOrdenVentaServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<EstadosOrdenVenta> find_ByNotaPedCab(String nota_ped_cab_id) {
        List<EstadosOrdenVenta> result = new ArrayList<>();
        try {
            String where = "where a.nota_pedido_id = '" + nota_ped_cab_id + "' order by a.id limit 10";
            String [] require = {"dir_entrega","nota_pedido"};
            result = CRUD.list(EstadosOrdenVenta.class,require,where);
        } catch (Exception ex) {
            Logger.getLogger(EstadosOrdenVentaServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
     @Override
    public Integer find_LastId(){
        Integer last_id = 0;
        List<EstadosOrdenVenta> result = new ArrayList<>();
        EstadosOrdenVenta last_state = new EstadosOrdenVenta();
        try {
            String where = "order by id desc limit 1";
            result = CRUD.list(EstadosOrdenVenta.class,where);
            if(!result.isEmpty()){
                last_state = result.get(0);
                last_id = last_state.getId();
            }
        } catch (Exception ex) {
            Logger.getLogger(EstadosOrdenVentaServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return last_id;
    }
    
}
