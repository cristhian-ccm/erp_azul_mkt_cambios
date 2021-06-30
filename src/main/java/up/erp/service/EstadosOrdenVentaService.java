/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.service;

import java.util.List;
import com.upgrade.persistence.model.ecommerce.EstadosOrdenVenta;
import java.util.Date;
/**
 *
 * @author Luis Aleman
 */
public interface EstadosOrdenVentaService {
    
    //Busqueda por dir_entrega
    public EstadosOrdenVenta find_ByIdDirEntr(String id_dir_entrega);
    
    //Busqueda por nota_pedido_cab
    public List<EstadosOrdenVenta> find_ByNotaPedCab(String nota_ped_cab_id);
    
    //Busqueda por fecha
    public List<EstadosOrdenVenta> findList_ByFecha(Date fecha_ini, Date fecha_fin);
    
    public Integer find_LastId();
    
    public void save_Estado_Orden(EstadosOrdenVenta pedido);
    public void update_Estado_Orden(EstadosOrdenVenta pedido);
    public void delete_Estado_Orden(EstadosOrdenVenta pedido);
    
}
