/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.server.serviceimpl;

import com.upgrade.persistence.model.produccion.Transformacion;
import com.upgrade.persistence.model.produccion.TransformacionDet;
import ts.com.service.util.db.server.CRUD;
import up.erp.service.TransformacionService;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ts.com.service.util.db.Update;

/**
 *
 * @author Diego-Javier
 */
public class TransformacionServiceImpl implements TransformacionService{
    
    @Override
    public List<Transformacion> list(boolean soloActivos)
    {
         List<Transformacion> result = new ArrayList<>();
        try {
            String where = soloActivos?"where activo is true ":"";
            result = CRUD.list(Transformacion.class,where);
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
     @Override
    public List<Transformacion> listWithPlantillaTransformacion(boolean soloActivos)
    {
         List<Transformacion> result = new ArrayList<>();
        try {
            String where = soloActivos?"where a.activo is true order by a.id":"";
            String[] require = {"plantillaTransformacion"};
            result = CRUD.list(Transformacion.class,require, where);
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    @Override
    public List<TransformacionDet> listByCabecera(String id)
    {
        List<TransformacionDet> result = new ArrayList<>();
        try {
            String where = "where transformacion_id = '"+id+"'";
            result = CRUD.list(TransformacionDet.class, where);
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    @Override
    public List<TransformacionDet> listByCabeceraWithProducto(String id)
    {
        List<TransformacionDet> result = new ArrayList<>();
        try {
            String where = "where transformacion_id = '"+id+"' order by a.id";
            String[] require = {"producto"};
            result = CRUD.list(TransformacionDet.class, require, where);
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    @Override
    public Transformacion save(Transformacion transformacion)
    {
        //PlantillaTransformacion plantilla = new PlantillaTransformacion();
        try {
            //CRUD.save(newPlantilla); 
            CRUD.save(transformacion);
        } catch (Exception ex) {
            Logger.getLogger(PlantillaTransformacionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return transformacion;
    }
    
    @Override
    public TransformacionDet save(TransformacionDet transformacion)
    {
        //PlantillaTransformacion plantilla = new PlantillaTransformacion();
        try {
            //CRUD.save(newPlantilla); 
            CRUD.save(transformacion);
        } catch (Exception ex) {
            Logger.getLogger(PlantillaTransformacionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return transformacion;
    }
    
    @Override
    public Transformacion update(Transformacion transformacion)
    {
        //PlantillaTransformacion plantilla = new PlantillaTransformacion();
        try {
            //CRUD.save(newPlantilla); 
            CRUD.update(transformacion);
        } catch (Exception ex) {
            Logger.getLogger(PlantillaTransformacionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return transformacion;
    }
    
    @Override
    public TransformacionDet update(TransformacionDet transformacion)
    {
        //PlantillaTransformacion plantilla = new PlantillaTransformacion();
        try {
            //CRUD.save(newPlantilla); 
            CRUD.update(transformacion);
        } catch (Exception ex) {
            Logger.getLogger(PlantillaTransformacionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return transformacion;
    }
    
    @Override
    public Transformacion getById(String id) {
        Transformacion result = null;
        try {
            String where = "where id = '"+id+"' limit 1";
            List<Transformacion> list = CRUD.list(Transformacion.class,where);
            if(!list.isEmpty()){
                result = list.get(0);
            }    
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    @Override
    public Transformacion getByIdWithProducto(String id) {
        Transformacion result = null;
        try {
            String where = "where a.id = '"+id+"' limit 1";
            String[] require = {"producto"};
            List<Transformacion> list = CRUD.list(Transformacion.class, require, where);
            if(!list.isEmpty()){
                result = list.get(0);
            }    
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    @Override
    public TransformacionDet getByIdWithTransformacionAndProducto(String idTransformacionDet) {
        TransformacionDet result = null;
        try {
            String where = "where a.id = '"+idTransformacionDet+"' limit 1";
            String[] require = {"transformacion", "producto"};
            List<TransformacionDet> list = CRUD.list(TransformacionDet.class, require, where);
            if(!list.isEmpty()){
                result = list.get(0);
            }    
        } catch (Exception ex) {
            Logger.getLogger(TransformacionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    @Override
    public Transformacion save(Transformacion cabecera, List<TransformacionDet> detalles) throws Exception {
        try {
            Update.beginTransaction();
            CRUD.save(cabecera);
            for(TransformacionDet detalle : detalles){
                detalle.setTransformacion(cabecera);
                CRUD.save(detalle);
            }
            Update.commitTransaction();
        } catch (Exception ex) {
            Update.rollbackTransaction();
            Logger.getLogger(PlantillaTransformacionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return cabecera;
    }
}
