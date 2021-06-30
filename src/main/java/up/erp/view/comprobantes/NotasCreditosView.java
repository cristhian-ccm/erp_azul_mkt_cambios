/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.view.comprobantes;

import com.upgrade.persistence.model.cmrlz.NotaCreDebCap;
import java.util.List;
import up.erp.service.Services;
import up.erp.view.App;

/**
 *
 * @author Upgrade - PC
 */
public class NotasCreditosView extends NotasCreditosUI{
    public App app;
    
    
    public NotasCreditosView(App app) {
        this.app = app;
    }
    
    @Override
    public void onGetNotas()
    {
        List<NotaCreDebCap> comprobantes = Services.getNotaCredito().listByFechaDesdeHastaOrAndSerieOrAndNumero(fechaDesde.getValue(), fechaHasta.getValue(), buscarByNumero.getValue());
//        List<NotaCreDebCap> comprobantes = Services.getNotaCredito().listByFechaDesdeHastaOrAndSerieOrAndNumero(LocalDate.MIN, LocalDate.MIN, numero).listByFecha(fechaDesde.getValue(), fechaHasta.getValue());
        gridNotasCredito.setItems(comprobantes);
        
    }
    
    /*@Override
    public void onGetComprobantes()
    {
        List<VentaCab> comprobantes = Services.getVentasCab().listByFecha(fechaDesde.getValue(), fechaHasta.getValue());
        gridComprobantes.setItems(comprobantes);
        
    }*/
}
