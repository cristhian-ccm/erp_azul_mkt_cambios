/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.server.serviceimpl;

import com.upgrade.persistence.model.fnnzs.Recibo;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ts.com.service.util.db.CConexion;
import ts.com.service.util.db.Query;
import ts.com.service.util.db.server.CRUD;
import up.erp.service.RecibosService;

/**
 *
 * @author Diego Javier Quispe
 */
public class RecibosServiceImpl implements RecibosService {
    
    @Override
    public Recibo getByOrdenVentaId(String idOrdenVenta) {
        Recibo result = null;
        try {
            String where = "where nota_pedido_id = '"+idOrdenVenta+"' limit 1";
            List<Recibo> list = CRUD.list(Recibo.class,where);
            if(!list.isEmpty()){
                result = list.get(0);
            }    
        } catch (Exception ex) {
            Logger.getLogger(RecibosServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public Recibo getById(String id) {
        Recibo result = null;
        try {
            String where = "where id = '"+id+"' limit 1";
            List<Recibo> list = CRUD.list(Recibo.class,where);
            if(!list.isEmpty()){
                result = list.get(0);
            }    
        } catch (Exception ex) {
            Logger.getLogger(RecibosServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public Recibo getByIdWithNotaPedido(String id){
        Recibo result = null;
        try {
            String where = "where a.id = '"+id+"' limit 1";
            String[] require = {"notaPedido"};
            List<Recibo> list = CRUD.list(Recibo.class, require, where);
            if(!list.isEmpty()){
                result = list.get(0);
            }    
        } catch (Exception ex) {
            Logger.getLogger(RecibosServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    @Override
    public List<Recibo> listByFechaDesdeHastaOrAndSerieOrAndNumero(LocalDate fechaInicial, LocalDate fechaFinal, String numero)
    {
        List<Recibo> result = new ArrayList<>();
        try {
            String where = "where ";
            Boolean isAnd = false;
            if (fechaInicial != null && fechaFinal != null)
            {
                where += " a.fecha >= '"+fechaInicial+"' and a.fecha <= '"+fechaFinal+"' "; 
                isAnd = true;
            }
            
            if (!numero.isEmpty())
            {
                if (isAnd)
                    where += " and ";
                where += " a.numero = '"+numero+"'";               
            }
            
            where += " order by a.fecha";
           
            
            String[] require = {"notaPedido"};
            //result = CRUD.list(VentaCab.class, require, where);
            result = CRUD.list(Recibo.class, require, where);
        } catch (Exception ex) {
            Logger.getLogger(RecibosServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;        
    }
    
    @Override
    public List<Recibo> listByIdOrdenVenta(String idOrden)
    {
        List<Recibo> result = new ArrayList<>();
        try {
            String where = "where b.id = '"+idOrden+"' order by a.fecha";
            
            String[] require = {"notaPedido"};
            //result = CRUD.list(VentaCab.class, require, where);
            result = CRUD.list(Recibo.class, require, where);
        } catch (Exception ex) {
            Logger.getLogger(RecibosServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;        
    }

    @Override
    public Recibo setNotaPedidoNullAndAnular(String id){
        Recibo result = null;
        try{
            String update = "UPDATE fnnzs.recibos SET nota_pedido_id = NULL, anulada = true WHERE id = '"+id+"'";
            CRUD.execute(update);
        }catch (Exception ex) {
            Logger.getLogger(ArticuloServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;
    }
    
    @Override
    public Recibo setNotaPedidoNull(String id){
        Recibo result = null;
        try{
            String update = "UPDATE fnnzs.recibos SET nota_pedido_id = NULL WHERE id = '"+id+"'";
            CRUD.execute(update);
        }catch (Exception ex) {
            Logger.getLogger(ArticuloServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;
    }
    
    @Override
    public BigDecimal sumRecibosByOrden(String idOrdenVenta){

        Query query = new Query();
        String select = "SELECT SUM(monto) FROM fnnzs.recibos WHERE nota_pedido_id = '"+idOrdenVenta+"'";
        query.select.set(select);
        BigDecimal suma = BigDecimal.ZERO;
        try {
             Object[][] rs = query.initResultSet();
             //System.out.println(rs[0][0]);
             if(rs.length != 0)
                 suma = (BigDecimal)(rs[0][0]);
                         
        } catch (Exception ex) {
            Logger.getLogger(RecibosServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return suma;
            
    }
    
}
