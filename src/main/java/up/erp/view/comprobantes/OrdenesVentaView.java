/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.view.comprobantes;

import com.upgrade.persistence.model.tcros.Persona;
import up.erp.service.Services;
import up.erp.view.App;

/**
 *
 * @author Upgrade - PC
 */
public class OrdenesVentaView extends OrdenesVentaUI {
    public App app;
    public Persona persona = Services.getPersona().getOnePersona();
    
    public OrdenesVentaView(App app) {
        this.app = app;
    }
}
