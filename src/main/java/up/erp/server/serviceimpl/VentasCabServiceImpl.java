/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.server.serviceimpl;

import com.upgrade.persistence.model.cmrlz.VentaCab;
import com.upgrade.persistence.model.cmrlz.VentaDet;
import ts.com.service.util.db.server.CRUD;
import up.erp.service.VentasCabService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ts.com.service.util.db.Update;

/**
 *
 * @author Upgrade - PC
 */
public class VentasCabServiceImpl implements VentasCabService {
    
    @Override
    public List<VentaCab> list(boolean soloActivos)
    {
         List<VentaCab> result = new ArrayList<>();
        try {
            String where = soloActivos?" order by a.id desc limit 1":"";
            String[] require = {"moneda", "direccionCliente", "direccionCliente.persona", "documentoTipo", "direccionCliente.persona.documentoIdentidad"};
            result = CRUD.list(VentaCab.class, require, where);
        } catch (Exception ex) {
            Logger.getLogger(VentasCabServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    @Override
    public List<VentaCab> listByFecha(LocalDate fechaInicial, LocalDate fechaFinal)
    {
        List<VentaCab> result = new ArrayList<>();
        try {
            String where = "where fecha >= '"+fechaInicial+"' and fecha <= '"+fechaFinal+"'";  
            String[] require = {"documentoTipo"};
            result = CRUD.list(VentaCab.class, require, where);
        } catch (Exception ex) {
            Logger.getLogger(VentasCabServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;        
    }
    
    @Override
    public List<VentaDet> listByIdCabecera(String id)
    {
        List<VentaDet> result = new ArrayList<>();
        try {
            String where = "where venta_id = '"+id+"'";
            String[] require = {"producto", "producto.unidad"};
            
            result = CRUD.list(VentaDet.class, require, where);
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
     @Override
    public VentaCab getById(String id) {
        VentaCab result = null;
        try {
            String where = "where a.id = '"+id+"' limit 1";
            String[] require = {"moneda", "direccionCliente", "direccionCliente.persona", "documentoTipo", "direccionCliente.persona.documentoIdentidad"};
            List<VentaCab> list = CRUD.list(VentaCab.class, require, where);
            if(!list.isEmpty()){
                result = list.get(0);
            }    
        } catch (Exception ex) {
            Logger.getLogger(VentasCabServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public VentaCab getByOrdenVentaId(String id) {
        VentaCab result = null;
        try {
            String where = "where a.nota_pedido_id = '"+id+"' limit 1";
            String[] require = {"moneda", "direccionCliente", "direccionCliente.persona", "documentoTipo", "direccionCliente.persona.documentoIdentidad"};
            List<VentaCab> list = CRUD.list(VentaCab.class, require, where);
            if(!list.isEmpty()){
                result = list.get(0);
            }    
        } catch (Exception ex) {
            Logger.getLogger(VentasCabServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    @Override
    public VentaCab update(VentaCab venta) 
    {
        //PlantillaTransformacion plantilla = new PlantillaTransformacion();
        try {
            //CRUD.save(newPlantilla); 
            CRUD.update(venta);
        } catch (Exception ex) {
            Logger.getLogger(VentasCabServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return venta;
    }    
    
    @Override
    public List<VentaCab> listByFechaDesdeHastaOrAndSerieOrAndNumero(LocalDate fechaInicial, LocalDate fechaFinal, String serie, String numero)
    {
        List<VentaCab> result = new ArrayList<>();
        try {
            String where = "where ";
            Boolean isAnd = false;
            if (fechaInicial != null && fechaFinal != null)
            {
                where += " fecha >= '"+fechaInicial+"' and fecha <= '"+fechaFinal+"' "; 
                isAnd = true;
            }
            
            if (!serie.isEmpty())
            {
                if (isAnd)
                    where += " and ";
                where += " serie = '"+serie+"'";
                isAnd = true;
            }
            
            if (!numero.isEmpty())
            {
                if (isAnd)
                    where += " and ";
                where += " numero = '"+numero+"'";
                isAnd = true;
            }
            
            where += " order by a.id";
           
            
            String[] require = {"documentoTipo",  "direccionCliente", "direccionCliente.persona"};
            result = CRUD.list(VentaCab.class, require, where);
        } catch (Exception ex) {
            Logger.getLogger(VentasCabServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;        
    }
    
    @Override
    public List<VentaCab> listByFechaDesdeHastaOrAndSerieOrAndNumeroAndAlmacen(LocalDate fechaInicial, LocalDate fechaFinal, String idAlmacen, String serie, String numero)
    {
        List<VentaCab> result = new ArrayList<>();
        try {
            String where = "where ";
            Boolean isAnd = false;
            if (fechaInicial != null && fechaFinal != null)
            {
                where += " fecha >= '"+fechaInicial+"' and fecha <= '"+fechaFinal+"' and a.almacen_id = '"+idAlmacen+"'"; 
                isAnd = true;
            }
            
            if (!serie.isEmpty())
            {
                if (isAnd)
                    where += " and ";
                where += " serie = '"+serie+"'";
                isAnd = true;
            }
            
            if (!numero.isEmpty())
            {
                if (isAnd)
                    where += " and ";
                where += " numero = '"+numero+"'";
                isAnd = true;
            }
            
            where += " order by a.id";
           
            
            String[] require = {"documentoTipo",  "direccionCliente", "direccionCliente.persona"};
            result = CRUD.list(VentaCab.class, require, where);
        } catch (Exception ex) {
            Logger.getLogger(VentasCabServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;        
    }
    
     @Override
    public VentaCab getLastNumeroByAlmacenAndFacBol(int idAlmacen, int idDocumentoTipo) {
        VentaCab result = null;
        try {
            String where = "where almacen_id = '"+idAlmacen+"' and documento_tipo_id = '"+idDocumentoTipo+"' order by numero desc limit 1";
            List<VentaCab> list = CRUD.list(VentaCab.class,where);
            if(!list.isEmpty()){
                result = list.get(0);
            }    
        } catch (Exception ex) {
            Logger.getLogger(VentasCabServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public VentaCab save(VentaCab plantilla)
    {
        try {
            CRUD.save(plantilla);
        } catch (Exception ex) {
            Logger.getLogger(VentasCabServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return plantilla;
    }
    
    public VentaDet saveDetalle(VentaDet plantilla)
    {
        try {
            CRUD.save(plantilla);
        } catch (Exception ex) {
            Logger.getLogger(VentasCabServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return plantilla;
    }
    
    @Override
    public VentaCab save(VentaCab cabecera, List<VentaDet> detalles) throws Exception {
        try {
            Update.beginTransaction();
            CRUD.save(cabecera);
            for(VentaDet detalle : detalles){
                detalle.venta = cabecera;
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
