/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.server.serviceimpl;

import com.upgrade.persistence.model.extcs.OrdenCab;
import com.upgrade.persistence.model.extcs.OrdenDet;
import ts.com.service.util.db.server.CRUD;
import up.erp.service.OrdenService;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego-Javier
 */
public class OrdenServiceImpl implements OrdenService{
   
    @Override
    public OrdenCab save(OrdenCab orden)
    {
        try {
            //CRUD.save(newPlantilla); 
            CRUD.save(orden);
        } catch (Exception ex) {
            Logger.getLogger(OrdenServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return orden;
    }
    
    @Override
    public OrdenDet save(OrdenDet orden)
    {
        try {
            //CRUD.save(newPlantilla); 
            CRUD.save(orden);
        } catch (Exception ex) {
            Logger.getLogger(OrdenServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return orden;
    }
    
    @Override
    public OrdenCab getByIdTransformacionAndTipo(int id, char tipo) {
        OrdenCab result = null;
        try {
            String where = "where transformacion_id = '"+id+"' and tipo = '"+tipo+"' limit 1";
            List<OrdenCab> list = CRUD.list(OrdenCab.class,where);
            if(!list.isEmpty()){
                result = list.get(0);
            }    
        } catch (Exception ex) {
            Logger.getLogger(OrdenServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    @Override
    public List<OrdenDet> listByIdTransformacionAndTipo(int id, char tipo) {
        
        List<OrdenDet> result = new ArrayList<>();
        try {
            String where = "where transformacion_id = '"+id+"' and tipo = '"+tipo+"'";
            String[] require = {"ordenCab", "articulo", "articulo.almacen"};
            result = CRUD.list(OrdenDet.class, require, where);
        } catch (Exception ex) {
            Logger.getLogger(OrdenServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    @Override
    public OrdenCab getByIdTransformacion(int id) {
        OrdenCab result = null;
        try {
            String where = "where transformacion_id = '"+id+"' limit 1";
            List<OrdenCab> list = CRUD.list(OrdenCab.class,where);
            if(!list.isEmpty()){
                result = list.get(0);
            }    
        } catch (Exception ex) {
            Logger.getLogger(OrdenServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
     @Override
    public OrdenDet getById(int id) {
        OrdenDet result = null;
        try {
            String where = "where id = '"+id+"' limit 1";
            List<OrdenDet> list = CRUD.list(OrdenDet.class,where);
            if(!list.isEmpty()){
                result = list.get(0);
            }    
        } catch (Exception ex) {
            Logger.getLogger(OrdenServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    @Override
    public Integer getLastRegisterByTipo(char tipo)
    {
        Integer result = null;
        try {
            String where = "where tipo = '"+tipo+"' order by numero desc limit 1";
            List<OrdenCab> list = CRUD.list(OrdenCab.class, where);
            if(!list.isEmpty())
                result = Integer.valueOf(list.get(0).getNumero());
            else
                result = 0;                
                
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    @Override
    public OrdenDet findByIdArticulo(int idArticulo)
    {
        OrdenDet result = null;
        try {
            String where = "where articulo_id = '"+idArticulo+"'";
            String[] require = {"articulo", "ordenCab"};
            List<OrdenDet> list = CRUD.list(OrdenDet.class, require, where);
            if(!list.isEmpty())
                result = list.get(0);      
                
        } catch (Exception ex) {
            Logger.getLogger(OrdenServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    @Override
    public OrdenDet findByIdArticuloByTipoCab(int idArticulo, char tipo)
    {
        OrdenDet result = null;
        try {
            String where = "where articulo_id = '"+idArticulo+"' and c.tipo = '"+tipo+"'";
            String[] require = {"articulo", "ordenCab"};
            List<OrdenDet> list = CRUD.list(OrdenDet.class, require, where);
            if(!list.isEmpty())
                result = list.get(0);      
                
        } catch (Exception ex) {
            Logger.getLogger(OrdenServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
      @Override
    public List<OrdenDet> listByIdTransformacion(String id)
    {
        List<OrdenDet> result = new ArrayList<>();
        try {
            String where = "where b.transformacion_id = '"+id+"' and b.tipo = 'S' order by a.id";
            String[] require = {"ordenCab", "articulo", "articulo_padre"};
            
            result = CRUD.list(OrdenDet.class, require, where);
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    @Override
    public List<OrdenDet> listByIdTransformacionAndIdProducto (String idTransformacion, String idProducto)
    {
        List<OrdenDet> result = new ArrayList<>();
        try {
            String where = "where b.transformacion_id = '"+idTransformacion+"' and c.producto_id = '"+idProducto+"'";
            String[] require = {"ordenCab", "articulo"};
            
            result = CRUD.list(OrdenDet.class, require, where);
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    @Override
    public List<OrdenDet> listArticulosPorTransformacion()
    {
        List<OrdenDet> result = new ArrayList<>();
        try {
            String where = "where b.transformacion_id is not null and articulo_padre_id is null and b.tipo = 'E' order by a.id";
            String[] require = {"ordenCab", "articulo", "articulo.producto", "ordenCab.transformacion", "ordenCab.transformacion.producto"};
            
            result = CRUD.list(OrdenDet.class, require, where);
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    @Override
    public List<OrdenDet> listArticulosPorTransformacionAndSerie(String serie)
    {
        List<OrdenDet> result = new ArrayList<>();
        try {
            String where = "where b.transformacion_id is not null and articulo_padre_id is null and b.tipo = 'E' and c.serie ilike '%"+serie+"%' order by a.id";
            String[] require = {"ordenCab", "articulo", "articulo.producto", "ordenCab.transformacion", "ordenCab.transformacion.producto"};
            
            result = CRUD.list(OrdenDet.class, require, where);
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    @Override
    public List<OrdenDet> listArticulosByIdPadre(String idArticuloPadre)
    {
        List<OrdenDet> result = new ArrayList<>();
        try {
            String where = "where articulo_padre_id = "+idArticuloPadre+" order by a.id";
            String[] require = {"ordenCab", "articulo", "articulo.producto", "ordenCab.transformacion", "ordenCab.transformacion.producto"};
            
            result = CRUD.list(OrdenDet.class, require, where);
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    
    @Override
    public OrdenDet update(OrdenDet orden)
    {
        //PlantillaTransformacion plantilla = new PlantillaTransformacion();
        try {
            //CRUD.save(newPlantilla); 
            CRUD.update(orden);
        } catch (Exception ex) {
            Logger.getLogger(OrdenServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return orden;
    }
    
    
}
