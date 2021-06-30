/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.service;

import com.upgrade.persistence.model.extcs.Articulo;
import java.util.List;

/**
 *
 * @author Upgrade - PC
 */
public interface ArticulosService {
    public Articulo getBySerieWithProducto(String serie);
    public Articulo getBySerieByIdTransformacionWithProducto(String serie, String idTransformacion);
    
    public Articulo getBySerieWithProductoWithAlmacen(String serie);
    public Articulo getById(String id);
    public Articulo save(Articulo articulo);
    public Articulo update(Articulo articulo);
    public Articulo setAlmacenNull(String idArticulo);
    public Articulo setVentaNull(String idVenta);
    public void setVentaIdInOrdenVenta(int idNotaPedido, int idVenta);
    public List<Articulo> listBySerie(String serie);
}
