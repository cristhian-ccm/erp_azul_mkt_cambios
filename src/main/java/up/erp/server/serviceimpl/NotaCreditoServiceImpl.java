/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.server.serviceimpl;

import com.upgrade.persistence.model.cmrlz.NotaCreDebCap;
import com.upgrade.persistence.model.cmrlz.NotaCreDebDet;
import ts.com.service.util.db.server.CRUD;
import up.erp.service.NotaCreditoService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Upgrade - PC
 */
public class NotaCreditoServiceImpl implements NotaCreditoService{
    
    @Override
    public NotaCreDebCap getLastNumeroByAlmacen(int idAlmacen) {
        NotaCreDebCap result = null;
        try {
            String where = "where almacen_id = '"+idAlmacen+"' order by numero desc limit 1";
            List<NotaCreDebCap> list = CRUD.list(NotaCreDebCap.class,where);
            if(!list.isEmpty()){
                result = list.get(0);
            }    
        } catch (Exception ex) {
            Logger.getLogger(NotaCreditoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    @Override
    public NotaCreDebCap save(NotaCreDebCap notaCredito)
    {
        //PlantillaTransformacion plantilla = new PlantillaTransformacion();
        try {
            //CRUD.save(newPlantilla); 
            CRUD.save(notaCredito);
        } catch (Exception ex) {
            Logger.getLogger(NotaCreditoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return notaCredito;
    }
    
    @Override
    public NotaCreDebDet save(NotaCreDebDet notaCredito)
    {
        //PlantillaTransformacion plantilla = new PlantillaTransformacion();
        try {
            //CRUD.save(newPlantilla); 
            CRUD.save(notaCredito);
        } catch (Exception ex) {
            Logger.getLogger(NotaCreditoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return notaCredito;
    }
    
    @Override
    public List<NotaCreDebCap> listByFecha(LocalDate fechaInicial, LocalDate fechaFinal)
    {
        List<NotaCreDebCap> result = new ArrayList<>();
        try {
            String where = "where fecemision >= '"+fechaInicial+"' and fecemision <= '"+fechaFinal+"'";  
            String[] require = {"documentoTipo"};
            result = CRUD.list(NotaCreDebCap.class, require, where);
        } catch (Exception ex) {
            Logger.getLogger(NotaCreditoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;        
    }
    
      @Override
    public List<NotaCreDebCap> listByFechaDesdeHastaOrAndSerieOrAndNumero(LocalDate fechaInicial, LocalDate fechaFinal, String numero)
    {
        List<NotaCreDebCap> result = new ArrayList<>();
        try {
            String where = "where ";
            Boolean isAnd = false;
            if (fechaInicial != null && fechaFinal != null)
            {
                where += " fecemision >= '"+fechaInicial+"' and fecemision <= '"+fechaFinal+"' "; 
                isAnd = true;
            }
            
            /*if (!serie.isEmpty())
            {
                if (isAnd)
                    where += " and ";
                where += " serie = '"+serie+"'";
                isAnd = true;
            }*/
            
            if (!numero.isEmpty())
            {
                if (isAnd)
                    where += " and ";
                where += " a.numero = '"+numero+"'";
                isAnd = true;
            }
            
            where += " order by fecemision";
            String[] require = {"documentoTipo", "venta", "venta.documentoTipo"};
            result = CRUD.list(NotaCreDebCap.class, require, where);
         } catch (Exception ex) {
            Logger.getLogger(NotaCreditoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;        
    }
    
    @Override
    public NotaCreDebCap getLastNumeroByAlmacenAndFacBol(int idAlmacen, String FacturaBoleta) {
        NotaCreDebCap result = null;
        try {
            String where = "where almacen_id = '"+idAlmacen+"' and serie = '"+FacturaBoleta+"' order by numero desc limit 1";
            List<NotaCreDebCap> list = CRUD.list(NotaCreDebCap.class,where);
            if(!list.isEmpty()){
                result = list.get(0);
            }    
        } catch (Exception ex) {
            Logger.getLogger(NotaCreditoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    @Override
    public NotaCreDebCap getByIdVenta(String idVenta) {
        NotaCreDebCap result = null;
        try {
            String where = "where venta_id = '"+idVenta+"' limit 1";
            List<NotaCreDebCap> list = CRUD.list(NotaCreDebCap.class,where);
            if(!list.isEmpty()){
                result = list.get(0);
            }    
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
