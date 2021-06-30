/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.view.cobranzas;

import com.upgrade.persistence.model.fnnzs.Recibo;
import com.upgrade.persistence.model.tcros.Persona;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import up.erp.service.Services;
import up.erp.view.App;

/**
 *
 * @author Diego Javier Quispe
 */
public class RecibosView extends RecibosUI{
    public App app;
    public Persona persona = Services.getPersona().getOnePersona();
    
    public RecibosView(App app) {
        this.app = app;
    }
    
    @Override
    public void onGetRecibos()
    {
        List<Recibo> listNotasPedido = Services.getRecibos().listByFechaDesdeHastaOrAndSerieOrAndNumero(fechaDesde.getValue(), fechaHasta.getValue(), buscarByNumero.getValue());
        gridNotasPedido.setItems(listNotasPedido);     
    }
    
    @Override
    public boolean onEsReciboActual(){
        Recibo recibo = Services.getRecibos().getById(String.valueOf(gridNotasPedido.asSingleSelect().getValue().getId()));
        
        LocalDate now = LocalDate.now();
        Date dateNow = Date.from(now.atStartOfDay(ZoneId.systemDefault()).toInstant());
        //Date date = Calendar.getInstance().getTime();  
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
        String strDate = dateFormat.format(dateNow); 
                
        //System.out.println(now+" - "+recibo.getFecha()+" - "+strDate + " - " + (dateNow.compareTo(recibo.getFecha()) == 0));
        return dateNow.compareTo(recibo.getFecha()) == 0;
    }
    
    @Override
    public boolean onValidarNotaPedido(){
        
        Recibo recibo = Services.getRecibos().getByIdWithNotaPedido(String.valueOf(gridNotasPedido.asSingleSelect().getValue().getId()));
        
        if (recibo.getNotaPedido() == null || recibo.getAnulada())
            return false;
        else
            return true;
    }
    
    public void onAnularCobranzaDia(){
        Recibo recibo = Services.getRecibos().getByIdWithNotaPedido(String.valueOf(gridNotasPedido.asSingleSelect().getValue().getId()));
        Services.getRecibos().setNotaPedidoNullAndAnular(String.valueOf(recibo.getId()));
    }
    public void onDesenlazarCobranza(){
        Recibo recibo = Services.getRecibos().getByIdWithNotaPedido(String.valueOf(gridNotasPedido.asSingleSelect().getValue().getId()));
        Services.getRecibos().setNotaPedidoNull(String.valueOf(recibo.getId()));
    }
        
    

    
}
