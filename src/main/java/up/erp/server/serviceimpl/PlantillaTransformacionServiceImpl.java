/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.server.serviceimpl;

import com.upgrade.persistence.model.produccion.PlantillaTransformacion;
import com.upgrade.persistence.model.produccion.PlantillaTransformacionDet;
import ts.com.service.util.db.Update;
import ts.com.service.util.db.server.CRUD;
import up.erp.service.PlantillaTransformacionService;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego-Javier
 */
public class PlantillaTransformacionServiceImpl implements PlantillaTransformacionService {
    
    @Override
    public PlantillaTransformacion save(PlantillaTransformacion plantilla)
    {
        try {
            CRUD.save(plantilla);
        } catch (Exception ex) {
            Logger.getLogger(PlantillaTransformacionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return plantilla;
    }
    
    
    @Override
    public PlantillaTransformacion update(PlantillaTransformacion plantilla)
    {
        //PlantillaTransformacion plantilla = new PlantillaTransformacion();
        try {
            //CRUD.save(newPlantilla); 
            CRUD.update(plantilla);
        } catch (Exception ex) {
            Logger.getLogger(PlantillaTransformacionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return plantilla;
    }
    
    @Override
    public PlantillaTransformacionDet saveDetalle(PlantillaTransformacionDet plantillaDetalle)
    {
        try {
            CRUD.save(plantillaDetalle);
        } catch (Exception ex) {
            Logger.getLogger(PlantillaTransformacionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return plantillaDetalle;
    }
    
    @Override
    public PlantillaTransformacion save(PlantillaTransformacion cabecera, List<PlantillaTransformacionDet> detalles) throws Exception {
        try {
            Update.beginTransaction();
            CRUD.save(cabecera);
            for(PlantillaTransformacionDet detalle : detalles){
                detalle.plantillaTransformacionId = cabecera;
                CRUD.save(detalle);
            }
            Update.commitTransaction();
        } catch (Exception ex) {
            Update.rollbackTransaction();
            Logger.getLogger(PlantillaTransformacionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return cabecera;
    }
    
    @Override
    public List<PlantillaTransformacion> list(boolean soloActivos)
    {
         List<PlantillaTransformacion> result = new ArrayList<>();
        try {
            String where = soloActivos?"where activo is true ":"";
            result = CRUD.list(PlantillaTransformacion.class,where);
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    @Override
    public List<PlantillaTransformacion> listWithProducto(boolean soloActivos)
    {
         List<PlantillaTransformacion> result = new ArrayList<>();
        try {
            String where = soloActivos?"where activo is true ":"";
            String[] require = {"productoId"};
            result = CRUD.list(PlantillaTransformacion.class, require, where);
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    @Override
    public PlantillaTransformacionDet delete(PlantillaTransformacionDet plantilla)
    {
        try {
            CRUD.delete(plantilla);
        } catch (Exception ex) {
            Logger.getLogger(PlantillaTransformacionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return plantilla;
    }
    
     @Override
    public PlantillaTransformacionDet getDetalleById(String id) {
        PlantillaTransformacionDet result = null;
        try {
            String where = "where id = '"+id+"' limit 1";
            List<PlantillaTransformacionDet> list = CRUD.list(PlantillaTransformacionDet.class,where);
            if(!list.isEmpty()){
                result = list.get(0);
            }    
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    @Override
    public PlantillaTransformacion getById(String id) {
        PlantillaTransformacion result = null;
        try {
            String where = "where id = '"+id+"' limit 1";
            List<PlantillaTransformacion> list = CRUD.list(PlantillaTransformacion.class,where);
            if(!list.isEmpty()){
                result = list.get(0);
            }    
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    @Override
    public PlantillaTransformacion getByIdWithProducto(String id) {
        PlantillaTransformacion result = null;
        try {
            String where = "where a.id = '"+id+"' limit 1";
            String[] require = {"productoId"};
            List<PlantillaTransformacion> list = CRUD.list(PlantillaTransformacion.class, require, where);
            if(!list.isEmpty()){
                result = list.get(0);
            }    
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    @Override
    public PlantillaTransformacion getByCodigoProducto(String codigoProducto) {
        PlantillaTransformacion result = null;
        try {
            String where = "where codigo ilike '%"+codigoProducto+"%' limit 1";
            String[] require = {"productoId"};
            List<PlantillaTransformacion> list = CRUD.list(PlantillaTransformacion.class, require, where);
            if(!list.isEmpty()){
                result = list.get(0);
            }    
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    
    @Override
    public List<PlantillaTransformacion> listByCodigoProducto(String codigoProducto) {
        List<PlantillaTransformacion> result = new ArrayList<>();
        try {
            String where = "where b.codigo ilike '%"+codigoProducto+"%'";
            String[] require = {"productoId"};
            result = CRUD.list(PlantillaTransformacion.class, require, where);
                
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    @Override
    public PlantillaTransformacion getByIdProducto(String idProducto) {
        PlantillaTransformacion result = null;
        try {
            String where = "where b.id = '"+idProducto+"' limit 1";
            String[] require = {"productoId"};
            List<PlantillaTransformacion> list = CRUD.list(PlantillaTransformacion.class, require, where);
            if(!list.isEmpty()){
                result = list.get(0);
            }    
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    @Override
    public List<PlantillaTransformacionDet> listByIdCabecera(String id)
    {
        List<PlantillaTransformacionDet> result = new ArrayList<>();
        try {
            String where = "where plantilla_transformacion_id = '"+id+"'";
            
            result = CRUD.list(PlantillaTransformacionDet.class, where);
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    @Override
    public List<PlantillaTransformacionDet> listByIdCabeceraWithProductoWithMarca(String id)
    {
        List<PlantillaTransformacionDet> result = new ArrayList<>();
        String[] require = {"productoId", "productoId.marca"};
        try {
            String where = "where plantilla_transformacion_id = '"+id+"'";
            
            result = CRUD.list(PlantillaTransformacionDet.class, require, where);
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    @Override
    public Integer getLastRegister()
    {
        Integer result = null;
        try {
            String where = "order by id desc limit 1";
            List<PlantillaTransformacion> list = CRUD.list(PlantillaTransformacion.class, where);
            if(!list.isEmpty())
                result = Integer.valueOf(list.get(0).getNumero());
            else
                result = 0;                
                
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    
}
