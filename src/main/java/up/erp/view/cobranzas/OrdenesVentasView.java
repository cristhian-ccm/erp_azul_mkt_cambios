/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.view.cobranzas;

import com.upgrade.persistence.model.cmrlz.NotaPedidoCab;
import com.upgrade.persistence.model.fnnzs.Recibo;
import com.upgrade.persistence.model.tcros.Persona;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import up.erp.service.Services;
import up.erp.view.App;

/**
 *
 * @author Diego Javier Quispe
 */
public class OrdenesVentasView extends OrdenesVentasUI{
    public App app;
    public Persona persona = Services.getPersona().getOnePersona();
    
    public OrdenesVentasView(App app) {
        this.app = app;
    }
    
    @Override
    public void onGetOrdenes()
    {
        //List<NotaPedidoCab> listNotasPedido = Services.getNotaPedido().listByFechaDesdeHastaOrAndSerieOrAndNumero(fechaDesde.getValue(), fechaHasta.getValue(), buscarByNumero.getValue());
        //gridNotasPedido.setItems(listNotasPedido);
        
    }
    
    @Override
    public boolean onExisteRecibo()
    {
        if(Services.getRecibos().getByOrdenVentaId(String.valueOf(gridNotasPedido.asSingleSelect().getValue().getId())) != null)
            return true;
        else
            return false;
    }
    
    @Override
    public boolean onEsReciboActual(){
        Recibo recibo = Services.getRecibos().getByOrdenVentaId(String.valueOf(gridNotasPedido.asSingleSelect().getValue().getId()));
        
        LocalDate now = LocalDate.now();
        Date dateNow = Date.from(now.atStartOfDay(ZoneId.systemDefault()).toInstant());
        //Date date = Calendar.getInstance().getTime();  
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
        String strDate = dateFormat.format(dateNow); 
                
        System.out.println(now+" - "+recibo.getFecha()+" - "+strDate + " - " + (dateNow.compareTo(recibo.getFecha()) == 0));
        return dateNow.compareTo(recibo.getFecha()) == 0;
                
    }
    
}
