/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.server.serviceimpl;

import com.upgrade.persistence.model.extcs.Articulo;
import java.util.ArrayList;
import ts.com.service.util.db.server.CRUD;
import up.erp.service.ArticulosService;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Upgrade - PC
 */
public class ArticuloServiceImpl implements ArticulosService {
    
    @Override
    public Articulo save(Articulo articulo)
    {
        try {
            CRUD.save(articulo);
        } catch (Exception ex) {
            Logger.getLogger(PlantillaTransformacionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return articulo;
    }
    
    @Override
    public Articulo update(Articulo articulo)
    {
        try {
            CRUD.update(articulo);
        } catch (Exception ex) {
            Logger.getLogger(PlantillaTransformacionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return articulo;
    }
    
    
    @Override
    public Articulo getBySerieWithProducto(String serie) {
        Articulo result = null;
        try {
            String where = "where serie ilike '%"+serie+"%' limit 1";
            String[] require = {"producto"};
            List<Articulo> list = CRUD.list(Articulo.class, require, where);
            if(!list.isEmpty()){
                result = list.get(0);
            }    
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    @Override
    public Articulo getBySerieByIdTransformacionWithProducto(String serie, String idTransformacion) {
        Articulo result = null;
        try {
            String where = "left join produccion.transformacion_det as td on td.producto_id = b.id "
                    + " where serie ilike '%"+serie+"' limit 1";
            String[] require = {"producto"};
            List<Articulo> list = CRUD.list(Articulo.class, require, where);
            if(!list.isEmpty()){
                result = list.get(0);
            }    
        } catch (Exception ex) {
            Logger.getLogger(ArticuloServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
     @Override
    public Articulo getBySerieWithProductoWithAlmacen(String serie) {
        Articulo result = null;
        try {
            String where = "where serie ilike '%"+serie+"%' limit 1";
            String[] require = {"producto", "almacen"};
            List<Articulo> list = CRUD.list(Articulo.class, require, where);
            if(!list.isEmpty()){
                result = list.get(0);
            }    
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    @Override
    public Articulo getById(String id) {
        Articulo result = null;
        try {
            String where = "where id = '"+id+"' limit 1";
            List<Articulo> list = CRUD.list(Articulo.class,where);
            if(!list.isEmpty()){
                result = list.get(0);
            }    
        } catch (Exception ex) {
            Logger.getLogger(ArticuloServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    @Override
    public Articulo setAlmacenNull(String idArticulo) {
        Articulo result = null;
        try{
            String update = "UPDATE extcs.articulos SET almacen_id = NULL WHERE id = '"+idArticulo+"'";
            CRUD.execute(update);
        }catch (Exception ex) {
            Logger.getLogger(ArticuloServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;
        
    }
    
           
    //Cambiar a nota de pedido 
    @Override
    public Articulo setVentaNull(String idVenta) {
        Articulo result = null;
        try{
            String update = "UPDATE cmrlz.notas_pedido_cab SET venta_id = NULL WHERE venta_id = '"+idVenta+"'";
            CRUD.execute(update);
        }catch (Exception ex) {
            Logger.getLogger(ArticuloServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;
        
    }
    
    @Override
    public void setVentaIdInOrdenVenta(int idNotaPedido, int idVenta) {
        Articulo result = null;
        try{
            String update = "UPDATE cmrlz.notas_pedido_cab SET venta_id = '"+idVenta+"' WHERE id = '"+idNotaPedido+"'";
            CRUD.execute(update);
        }catch (Exception ex) {
            Logger.getLogger(ArticuloServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //return result;
        
    }
    
    @Override
    public List<Articulo> listBySerie(String serie)
    {
        List<Articulo> result = new ArrayList<>();
        try {
            String where = "where serie ilike '%"+serie+"%'";
            
            result = CRUD.list(Articulo.class, where);
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
}
