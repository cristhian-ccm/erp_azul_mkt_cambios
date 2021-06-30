/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.view.produccion;

import com.upgrade.persistence.model.produccion.PlantillaTransformacion;
import java.util.ArrayList;
import java.util.List;
import up.erp.service.Services;
import up.erp.view.App;

/**
 *
 * @author Upgrade - PC
 */
public class PlantillaTransformacionesView extends PlantillaTransformacionesUI{
    
    public App app;
    
    public PlantillaTransformacionesView(App app)
    {
        this.app = app;
        List<PlantillaTransformacion> listPlantillaTransformacion = Services.getPlantillaTransformacion().listWithProducto(true);
        List<PlantTransformacion> listTransformacion = new ArrayList<>();
        for (int i=0; i<listPlantillaTransformacion.size(); i++)
        {
            PlantTransformacion plantilla = new PlantTransformacion();
            plantilla.setId(listPlantillaTransformacion.get(i).getId());
            plantilla.setNumero(listPlantillaTransformacion.get(i).getNumero());
            plantilla.setNombre(listPlantillaTransformacion.get(i).getProductoId().getNombre());
            listTransformacion.add(plantilla);
        }
        
        gridPlantillas.setItems(listTransformacion);
    }
    
    @Override
    public void onBtnOpenCrearPlantillaTransformacion()
    {
        this.app.setContent(new PlantillaTransformacionView(this.app));
        //this.app.add(new PlantillaTransformacionView(this.app));
    }
    
    @Override
    public void onBtnOpenActualizarPlantillaTransformacion()
    {
        add(new PlantillaTransformacionView(this.app, gridPlantillas.asSingleSelect().getValue().getId()));
        
    }
    
    @Override
    public void onBtnOpenCrearTransformacion()
    {
        //add(new TransformacionView(this.app, gridPlantillas.asSingleSelect().getValue().getId()));
    }
    
    @Override
    public String onProbar()
    {
        return String.valueOf(Services.getPlantillaTransformacion().getLastRegister());
    }
    
    
}
