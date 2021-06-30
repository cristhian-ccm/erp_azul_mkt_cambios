/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.view.produccion;

import com.upgrade.persistence.model.produccion.Transformacion;
import java.util.List;
import up.erp.service.Services;
import up.erp.view.App;

/**
 *
 * @author Diego-Javier
 */
public class TransformacionesView extends TransformacionesUI{
    
    public App app;
    
    public TransformacionesView(App app){
        
        this.app = app;
        List<Transformacion> listTransformacion = Services.getTransformacion().listWithPlantillaTransformacion(true);
        gridTransformaciones.setItems(listTransformacion);
    }
    
    @Override
    public void onOpenTransformacion()
    {
        this.app.setContent(new TransformacionView(this.app));
        //this.app.add(new TransformacionView(this.app));
    }
    
    @Override
    public void onContinuarTransformacion()
    {
        this.app.setContent(new TransformacionView(this.app, gridTransformaciones.asSingleSelect().getValue().getId()));
        //this.app.add(new TransformacionView(this.app, gridTransformaciones.asSingleSelect().getValue().getId()));
    }
}
