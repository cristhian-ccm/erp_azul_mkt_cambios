/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.view.produccion;

import com.upgrade.persistence.model.extcs.Producto;
import com.upgrade.persistence.model.produccion.PlantillaTransformacion;
import com.upgrade.persistence.model.produccion.PlantillaTransformacionDet;
import com.upgrade.persistence.model.tcros.Persona;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import up.erp.service.Services;
import up.erp.view.App;

/**
 *
 * @author Diego-Javier
 */
public class PlantillaTransformacionView extends PlantillaTransformacionUI{
    
    public App app;
    public Persona persona = Services.getPersona().getOnePersona();
    public List<DatosPlantilla> listPlantilla = new ArrayList<>();
    public boolean isNewRegister = true;
    public int idCabecera;
    
    public PlantillaTransformacionView(App app) {
        this.app = app;
    }
    
    public PlantillaTransformacionView(App app, int idCabecera)
    {
        this.app = app;
        
        this.isNewRegister = false;
        this.idCabecera = idCabecera;
        
        PlantillaTransformacion cabecera = Services.getPlantillaTransformacion().getByIdWithProducto(String.valueOf(this.idCabecera));
        /*List<Producto> listProductos = new ArrayList<>();
        listProductos.add(cabecera.getProductoId());*/
        comboProductoCab.setItems(cabecera.getProductoId());
        comboProductoCab.setValue(cabecera.getProductoId());
        textObservaciones.setValue(cabecera.getObservacion());
        
        List<PlantillaTransformacionDet> listDetalles = Services.getPlantillaTransformacion().listByIdCabeceraWithProductoWithMarca(String.valueOf(this.idCabecera));
        
        for (int i=0; i<listDetalles.size(); i++)
        {
            DatosPlantilla dato = new DatosPlantilla();
            dato.setId(listDetalles.get(i).getId());
            dato.setCantidad(listDetalles.get(i).getCantidad());
            dato.setMarca(listDetalles.get(i).getProductoId().getMarca().getNombre());
            dato.setNombre(listDetalles.get(i).getProductoId().getNombre());
            listPlantilla.add(dato);
        }
        
        gridProductos.setItems(listPlantilla); 
        
    }

    @Override
    public void onBtnListarPorCodigoCab() {
        List<Producto> listProductos = Services.getProducto().listByCodigoOrDescripcion(txtCodigoProductoCab.getValue());
        comboProductoCab.setItems(listProductos);
    }
    
    @Override
    public void onBtnListarPorCodigo() {
        List<Producto> listProductos = Services.getProducto().listByCodigoOrDescripcion(txtCodigoProducto.getValue());
        comboProducto.setItems(listProductos);
    }
    
    
    @Override
    public void onBtnAddProducto()
    {
        if (isNewRegister)
        {
            Producto producto = Services.getProducto().getByIdWithMarca(String.valueOf(comboProducto.getValue().getId()));
            DatosPlantilla plantilla = new DatosPlantilla(producto.getId(),
                    producto.getNombre(), producto.getMarca().getNombre(), producto.getModelo(), Integer.valueOf(txtCantidad.getValue()));
            listPlantilla.add(plantilla);

            gridProductos.setItems(listPlantilla);             
        }
        else{
            
            Producto producto = Services.getProducto().getByIdWithMarca(String.valueOf(comboProducto.getValue().getId()));
            
            PlantillaTransformacionDet detalle = new PlantillaTransformacionDet();             
                    
            detalle.setActivo(Boolean.TRUE);
            detalle.setProductoId(producto);
            detalle.setPlantillaTransformacionId(Services.getPlantillaTransformacion().getById(String.valueOf(this.idCabecera)));
            detalle.setCreador(persona);
            detalle.setCantidad(Integer.valueOf(txtCantidad.getValue()));
            
            detalle = Services.getPlantillaTransformacion().saveDetalle(detalle);            
            
            DatosPlantilla plantilla = new DatosPlantilla(
                    detalle.getId(), producto.getNombre(), producto.getMarca().getNombre(), producto.getModelo(), Integer.valueOf(txtCantidad.getValue()));
            listPlantilla.add(plantilla);

            gridProductos.setItems(listPlantilla); 
            
        }
        
    }
    
    @Override
    public void onBtnDeleteProducto()
    {
        if(isNewRegister)
        {                        
            listPlantilla.remove(gridProductos.asSingleSelect().getValue()); 
            gridProductos.setItems(listPlantilla);
            
        }
        else
        {
            PlantillaTransformacionDet detalle = Services.getPlantillaTransformacion().getDetalleById(String.valueOf(gridProductos.asSingleSelect().getValue().getId()));
            Services.getPlantillaTransformacion().delete(detalle);
            listPlantilla.remove(gridProductos.asSingleSelect().getValue()); 
            gridProductos.setItems(listPlantilla);
        }
    }    
    
    @Override
    public void onBtnGuardarPlantilla()
    {
        if(isNewRegister)
            guardar();
        else 
            actualizarCabecera();
       
        removeAll();
        //this.app.add(new PlantillaTransformacionesView(this.app));
        this.app.setContent(new PlantillaTransformacionesView(this.app));
    }
    
    @Override
    public String onProbar()
    {
        return String.valueOf(listPlantilla.get(0).getId());
    }
    
    public void guardar(){
        Producto producto = comboProductoCab.getValue();
        
        PlantillaTransformacion cabecera = new PlantillaTransformacion();
        cabecera.setObservacion(textObservaciones.getValue());
        cabecera.setProductoId(producto);
        cabecera.setActivo(Boolean.TRUE);
        cabecera.setCreador(persona);
        cabecera.setNumero(String.valueOf(Integer.valueOf(Services.getPlantillaTransformacion().getLastRegister()+1)));
        //cabecera.setNumero("1");
        
        List<PlantillaTransformacionDet> listDetalle = new ArrayList<>();
        for (int i=0; i<listPlantilla.size(); i++)
        {
            PlantillaTransformacionDet detalle = new PlantillaTransformacionDet(); 
            Producto itemProducto = Services.getProducto().getById(String.valueOf(listPlantilla.get(i).getId()));
                    
            detalle.setActivo(Boolean.TRUE);
            detalle.setProductoId(itemProducto);
            detalle.setCreador(persona);
            detalle.setCantidad(listPlantilla.get(i).getCantidad());
            
            listDetalle.add(detalle);
        }
        
        try {
            Services.getPlantillaTransformacion().save(cabecera, listDetalle);
        } catch (Exception ex) {
            Logger.getLogger(PlantillaTransformacionView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void actualizarCabecera(){
        Producto producto = comboProductoCab.getValue();
        
        PlantillaTransformacion cabecera = Services.getPlantillaTransformacion().getById(String.valueOf(this.idCabecera));
        cabecera.setProductoId(producto);
        cabecera.setObservacion(textObservaciones.getValue());
        Services.getPlantillaTransformacion().update(cabecera);
        
    }
    
    
    
    
}
