/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 */
package up.erp.view.produccion;

import com.upgrade.persistence.model.extcs.Articulo;
import com.upgrade.persistence.model.extcs.OrdenCab;
import com.upgrade.persistence.model.extcs.OrdenDet;
import com.upgrade.persistence.model.extcs.Producto;
import com.upgrade.persistence.model.produccion.PlantillaTransformacion;
import com.upgrade.persistence.model.produccion.PlantillaTransformacionDet;
import com.upgrade.persistence.model.produccion.Transformacion;
import com.upgrade.persistence.model.produccion.TransformacionDet;
import com.upgrade.persistence.model.tcros.Persona;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import up.erp.service.Services;
import up.erp.view.App;

/**
 *
 * @author Upgrade - PC
 */
public class TransformacionView extends TransformacionUI {
    
    public App app;
    public Persona persona = Services.getPersona().getOnePersona();
    public Transformacion transformacion;
    public List<DatosTransformacion> listDatosTransformacion = new ArrayList<>(); //Dialog
    public List<Articulo> listDialogArticulo = new ArrayList<>();
    public Articulo finalDialogArticulo = new Articulo();
    public List<TransformacionDet> listDetalle = new ArrayList<>();
    public boolean isNewRegister = true;
    public String serieTemporal;
    public int idTransformacion;
    
    public TransformacionView(App app)
    {
        this.app = app;      
        btnAgregar.setEnabled(false);
    }
    
    public TransformacionView(App app, int idTransformacion)
    {
        this.idTransformacion = idTransformacion;
        this.app = app;
        this.isNewRegister = false;
        btnCrearTransformacion.setEnabled(false);
        
        listDetalle = Services.getTransformacion().listByCabeceraWithProducto(String.valueOf(idTransformacion));        
        this.transformacion = Services.getTransformacion().getByIdWithProducto(String.valueOf(idTransformacion));
        lblNombreProducto.add(this.transformacion.getProducto().getNombre());
        
        onCargarDatosGrids();
    }
    
    @Override
    public void onBtnGenerar()
    {
        /*Crear Transformacion*/
        Transformacion transformacion = new Transformacion();
        PlantillaTransformacion plantTransformacion = Services.getPlantillaTransformacion().getByIdWithProducto(String.valueOf(cmbPlantillas.getValue().getId()));
        transformacion.setPlantillaTransformacion(plantTransformacion);
        transformacion.setNumeroTransformaciones(Integer.valueOf(txtNumeroPlantillas.getValue()));
        transformacion.setTransformacionesRealizadas(0);
        transformacion.setEstado(0);
        transformacion.setActivo(Boolean.TRUE);
        transformacion.setCreador(persona);
        transformacion.setProducto(plantTransformacion.getProductoId());
        transformacion.setCantidadIndividual(1);
        
        //transformacion = Services.getTransformacion().save(transformacion);
        
        //System.out.println(plantTransformacion.getProductoId() +" - "+cmbPlantillas.getValue().getId());
        
        List<PlantillaTransformacionDet> listDetallePT = Services.getPlantillaTransformacion().listByIdCabecera(String.valueOf(plantTransformacion.getId()));
        
        List<TransformacionDet> listDetalles = new ArrayList<>();
        for (int i=0; i<listDetallePT.size(); i++)
        {
            TransformacionDet transformacionDet = new TransformacionDet(); 
            transformacionDet.setTransformacion(transformacion);
            transformacionDet.setEstado(0);
            transformacionDet.setCantidadIndividual(listDetallePT.get(i).getCantidad());
            transformacionDet.setProducto(listDetallePT.get(i).getProductoId());
            transformacionDet.setNumeroTransformaciones(listDetallePT.get(i).getCantidad()*Integer.valueOf(txtNumeroPlantillas.getValue()));
            transformacionDet.setTransformacionesRealizadas(0);
            transformacionDet.setActivo(Boolean.TRUE);
            transformacionDet.setCreador(persona);
            
            //Services.getTransformacion().save(transformacionDet);
            listDetalles.add(transformacionDet);
        }
        
        try {
            Services.getTransformacion().save(transformacion, listDetalles);
        } catch (Exception ex) {
            Logger.getLogger(TransformacionView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.transformacion = transformacion;
        lblNombreProducto.add(this.transformacion.getProducto().getNombre());
        
        btnCrearTransformacion.setEnabled(false);
        btnAgregar.setEnabled(true);
        
        /*Crear ordenes de entrada y salida*/
        OrdenCab orden_E = new OrdenCab();
        orden_E.setCreadoPor(persona);
        orden_E.setTransformacion(this.transformacion);
        orden_E.setAnulada(false);
        orden_E.setNumero(Services.getOrden().getLastRegisterByTipo('E')+1);
        orden_E.setAlmacen(Services.getAlmacen().getById("18"));
        orden_E.setFecha(new Date(System.currentTimeMillis()));
        orden_E.setTipo('E');
        Services.getOrden().save(orden_E);
        
        OrdenCab orden_S = new OrdenCab();
        orden_S.setCreadoPor(persona);
        orden_S.setTransformacion(this.transformacion);
        orden_S.setAnulada(false);
        orden_S.setNumero(Services.getOrden().getLastRegisterByTipo('S')+1);
        orden_S.setAlmacen(Services.getAlmacen().getById("18"));
        orden_S.setFecha(new Date(System.currentTimeMillis()));
        orden_S.setTipo('S');
        Services.getOrden().save(orden_S);
        
    }
    
    @Override
    public void onCargarDatosGrids()
    {
        gridTransformacion.setItems(transformacion);
        
        listDetalle = Services.getTransformacion().listByCabeceraWithProducto(String.valueOf(transformacion.getId()));
        gridTransformacionDet.setItems(listDetalle);
        
        onLoadDialog();
    }
    
    //valueChange
    
    @Override
    public void onLoadDialog()
    {        
        listDetalle = Services.getTransformacion().listByCabeceraWithProducto(String.valueOf(transformacion.getId()));
        
        for (int i=0; i<listDetalle.size(); i++)
        {
            for (int j=0; j<listDetalle.get(i).getCantidadIndividual(); j++)
            {
                DatosTransformacion datosTransformacion = new DatosTransformacion();
                datosTransformacion.setNombreProducto(listDetalle.get(i).getNombreProducto());
                datosTransformacion.setProductoId(listDetalle.get(i).getProducto().getId());
                //datosTransformacion.setSerieArticulo(null);
                //datosTransformacion.setCantidad(0);
                listDatosTransformacion.add(datosTransformacion);
            }
           
        }    
        
        gridItem.setItems(listDatosTransformacion);
           
    }
    
    /*Este metodo valida si el producto al que pertenece el articulo se encuentra 
    presente en la plantilla abierta de lo contrario devuelve false*/
    @Override
    public boolean onProductoPerteneceAPlantilla()
    {
        
        //Articulo articulo = Services.getArticulo().getBySerieWithProducto(txtSerieProducto.getValue());
        Articulo articulo = Services.getArticulo().getBySerieByIdTransformacionWithProducto(txtSerieProducto.getValue(), String.valueOf(transformacion.getId()));
        this.serieTemporal = articulo.getSerie();
        
        for (int i=0; i<listDatosTransformacion.size(); i++){
            System.out.println(listDatosTransformacion.get(i).getProductoId()+" - "+ articulo.getProducto().getId());
            if (listDatosTransformacion.get(i).getProductoId() == articulo.getProducto().getId())
            {
                return true;
            }
        }
        
        return false;
    }
    
    @Override
    public void onModificarSerie()
    {
        Articulo articulo = Services.getArticulo().getBySerieWithProducto(this.serieTemporal);
        OrdenDet ordenDet = Services.getOrden().getById(gridVisualizarItems.asSingleSelect().getValue().getId());
        ordenDet.setArticulo(articulo);
        Services.getOrden().update(ordenDet);
    }
    
    @Override
    public boolean onArticuloDisponibleModificar()
    {
        Articulo articulo = Services.getArticulo().getBySerieByIdTransformacionWithProducto(txtSerieModificar.getValue(), String.valueOf(transformacion.getId()));
        this.serieTemporal = articulo.getSerie();  
        
        //Articulo articulo = Services.getArticulo().getBySerieWithProductoWithAlmacen(txtSerieProducto.getValue());
        articulo = Services.getArticulo().getBySerieWithProductoWithAlmacen(this.serieTemporal);   
        //OrdenDet orden = Services.getOrden().findByIdArticuloByTipoCab(articulo.getId(), 'S');
       
        if(articulo.getAlmacen() == null)
            return false;
        
        if(Services.getOrden().findByIdArticuloByTipoCab(articulo.getId(), 'S') != null)
            return false;
        
        return true;
    }
    
    /*@Override
    public boolean onAgregarArticulo()
    {
        boolean perteneceProducto = false;
        
        Articulo articulo = Services.getArticulo().getBySerieWithProducto(txtSerieProducto.getValue());
        
        for (int i=0; i<listDatosTransformacion.size(); i++)
        {
            if ((listDatosTransformacion.get(i).getProductoId() == articulo.getProducto().getId()) && (listDatosTransformacion.get(i).getSerieArticulo() == null))
            {
                listDatosTransformacion.get(i).setCantidad(1);
                listDatosTransformacion.get(i).setSerieArticulo(articulo.getSerie());
                perteneceProducto = true;
                break;
            }
        }
        
        if(perteneceProducto)
        {   
            listDialogArticulo.add(articulo);
            gridItem.setItems(listDatosTransformacion);
        }
        
        return perteneceProducto;
    }*/
    
    @Override
    public void onAgregarArticulo()
    {
        //Articulo articulo = Services.getArticulo().getBySerieWithProducto(txtSerieProducto.getValue());
        Articulo articulo = Services.getArticulo().getBySerieWithProducto(this.serieTemporal);
        
        System.out.println(articulo.getSerie() +" - "+txtSerieProducto.getValue());
        for (int i=0; i<listDatosTransformacion.size(); i++)
        {
            if ((listDatosTransformacion.get(i).getProductoId() == articulo.getProducto().getId()) && (listDatosTransformacion.get(i).getSerieArticulo() == null))
            {
                listDatosTransformacion.get(i).setCantidad(1);
                listDatosTransformacion.get(i).setSerieArticulo(articulo.getSerie());
                break;
            }
        }

        listDialogArticulo.add(articulo);
        gridItem.setItems(listDatosTransformacion);
        
    }
    
    @Override
    public boolean onEstaAgregado()
    {
        Articulo articulo = Services.getArticulo().getBySerieWithProducto(txtSerieProducto.getValue());
        return listDialogArticulo.contains(articulo);
    }
    
    @Override
    public void onGenerarYContinuar()
    {
        /*Generar las ordenes de venta*/
        this.transformacion.setTransformacionesRealizadas(this.transformacion.getTransformacionesRealizadas()+this.transformacion.getCantidadIndividual());
        this.transformacion = Services.getTransformacion().update(transformacion);
        gridTransformacion.setItems(transformacion);
        
        for (int i=0; i<listDetalle.size(); i++)
        {
            TransformacionDet transformacionDet = listDetalle.get(i);
            transformacionDet.setTransformacionesRealizadas(transformacionDet.getTransformacionesRealizadas()+transformacionDet.getCantidadIndividual());
            Services.getTransformacion().update(transformacionDet);            
        }
        
        listDetalle = Services.getTransformacion().listByCabeceraWithProducto(String.valueOf(transformacion.getId()));
        
        gridTransformacion.setItems(transformacion);
        gridTransformacionDet.setItems(listDetalle);
        
                
        /*Generar Articulo*/
        Articulo articuloEntrada = new Articulo();
        articuloEntrada.setSerie(txtSerieArticuloFinal.getValue());
        articuloEntrada.setInactivo(false);
        articuloEntrada.setCreado(persona);
        articuloEntrada.setVolumen(BigDecimal.ONE);
        articuloEntrada.setProducto(this.transformacion.getProducto());
        articuloEntrada = Services.getArticulo().save(articuloEntrada);
        
        /*Generar ordenes detalle*/
        OrdenCab ordenSalida = Services.getOrden().getByIdTransformacionAndTipo(transformacion.getId(), 'S');
        OrdenCab ordenEntrada = Services.getOrden().getByIdTransformacionAndTipo(transformacion.getId(), 'E');
        
        OrdenDet ordenDet = new OrdenDet();
        
        /*Detalle orden entrada*/
        ordenDet.setArticulo(articuloEntrada);
        ordenDet.setCantidad(BigDecimal.valueOf(1));
        ordenDet.setOrdenCab(ordenEntrada);
        Services.getOrden().save(ordenDet);
        
        /*Detalle orden salida*/
        for(int i=0; i<listDialogArticulo.size(); i++)
        {
            ordenDet = new OrdenDet();
            ordenDet.setArticulo(Services.getArticulo().getById(String.valueOf(listDialogArticulo.get(i).getId())));
            ordenDet.setCantidad(BigDecimal.valueOf(1));
            ordenDet.setOrdenCab(ordenSalida);
            ordenDet.setArticulo_padre(articuloEntrada);
            Services.getOrden().save(ordenDet);
        }    
        
        listDialogArticulo.clear();
        
    }
    
    @Override
    public String onGetCodigoArticulo(){
        Articulo articulo = Services.getArticulo().getBySerieWithProducto(txtSerieProducto.getValue());
        return articulo.getSerie();
    }
    
    @Override
    public boolean onFindPlantillaTransformacion()
    {
        if(Services.getPlantillaTransformacion().getByIdProducto(String.valueOf(comboProducto.getValue().getId())) != null){
            return true;
        }
        else
            return false;
    }
    
    @Override
    public void onBtnListarPlantillaTransformacion()
    {
        cmbPlantillas.setItems(Services.getPlantillaTransformacion().listByCodigoProducto(codigoProducto.getValue()));
    }
    
    /*Si el articulo no se encuentra en almacen return false
    Si el articulo se encuentra en una orden return false*/
    @Override
    public Mensaje onArticuloDisponible()
    {
        Mensaje mensaje = new Mensaje();
        //Articulo articulo = Services.getArticulo().getBySerieWithProductoWithAlmacen(txtSerieProducto.getValue());
        Articulo articulo = Services.getArticulo().getBySerieWithProductoWithAlmacen(this.serieTemporal);
        
        OrdenDet orden = Services.getOrden().findByIdArticuloByTipoCab(articulo.getId(), 'S');
        System.out.println((articulo.getAlmacen() == null)+" - "+(orden != null)+" - "+listDialogArticulo.contains(articulo));
        if(articulo.getAlmacen() == null)
        {
            mensaje.setTipo(false);
            mensaje.setMensaje("El Articulo no se encuentra en almacen.");
        }
        else{
            if(Services.getOrden().findByIdArticuloByTipoCab(articulo.getId(), 'S') != null)
            {    
                mensaje.setTipo(false);
                mensaje.setMensaje("El articulo ya se encuentra en una transformacion.");
            }
            else
            {
                System.out.println(listDialogArticulo.contains(articulo)+" - "+ isArticuloConProductoInList(articulo));
                if(listDialogArticulo.contains(articulo) || isArticuloConProductoInList(articulo))
                {   
                    mensaje.setTipo(false);            
                    mensaje.setMensaje("El articulo o producto ya fue agregado a la presente vista.");
                }
                else{
                    mensaje.setTipo(true);
                    mensaje.setMensaje("Se agrego satisfactoriamente.");
                }
            }
        }
        
        return mensaje;
    }

//Se pretende saber si los articulos agregados a una lista se repiten en producto    
    
    public boolean isArticuloConProductoInList(Articulo articulo)
    {
        for (int i=0; i<listDatosTransformacion.size(); i++)
        {
            if(((listDatosTransformacion.get(i).getProductoId() == articulo.getProducto().getId()) && (listDatosTransformacion.get(i).getSerieArticulo() == null)))
            {
                System.out.println(i+"-"+listDatosTransformacion.get(i).getSerieArticulo());
                return false;
            }
        }
        /*for(int i=0; i<listDialogArticulo.size(); i++)
        {
            if(listDialogArticulo.get(i).getProducto().getId().equals(articulo.getProducto().getId()))
                return true;
        }*/
        
        return true;
    }
    
    @Override
    public boolean onValidarGeneraryContinuar()
    {
        boolean itemsCompletos = true;
        for (int i=0; i<listDatosTransformacion.size(); i++)
        {
            if (listDatosTransformacion.get(i).getSerieArticulo() == null)
                itemsCompletos = false;
        }
        
        return itemsCompletos;
    }
    
    @Override
    public void onCerrarTransformacion()
    {
        List<OrdenDet> listOrdenesSalida = Services.getOrden().listByIdTransformacionAndTipo(transformacion.getId(), 'S');
        List<OrdenDet> listOrdenesEntrada = Services.getOrden().listByIdTransformacionAndTipo(transformacion.getId(), 'E');
        OrdenCab orden = Services.getOrden().getByIdTransformacionAndTipo(transformacion.getId(), 'E');
        
        for(int i=0; i<listOrdenesSalida.size(); i++)
        {
            Articulo articulo = listOrdenesSalida.get(i).getArticulo();
            articulo.setAlmacen(null);
            Services.getArticulo().setAlmacenNull(String.valueOf(articulo.getId()));
        }
        
        for(int i=0; i<listOrdenesEntrada.size(); i++)
        {
            Articulo articulo = listOrdenesEntrada.get(i).getArticulo();
            articulo.setAlmacen(orden.getAlmacen());
            Services.getArticulo().update(articulo);
        }
        
        transformacion.setEstado(1);
        Services.getTransformacion().update(transformacion);
        
        removeAll();
        //this.app.add(new TransformacionesView(this.app));
        this.app.setContent(new TransformacionesView(this.app));
    }
    
    @Override
    public void onCleanDialog(){
        txtSerieArticuloFinal.clear();
        
        for (int i=0; i<listDatosTransformacion.size(); i++)
        {
            listDatosTransformacion.get(i).setSerieArticulo(null);
        }
        gridItem.setItems(listDatosTransformacion);
    }
    
    @Override
    public void onBtnListarPorCodigo() {
        List<Producto> listProductos = Services.getProducto().listByCodigo(codigoProducto.getValue());
        comboProducto.setItems(listProductos);
    }
    
    @Override
    public boolean onValidarCerrarTransformacion()
    {
        System.out.println(transformacion.getNumeroTransformaciones() + " - "+transformacion.getTransformacionesRealizadas());
        return transformacion.getNumeroTransformaciones().equals(transformacion.getTransformacionesRealizadas());
    }
    
    @Override
    public void onVisualizarItems()
    {
        
        TransformacionDet transformacionDet = Services.getTransformacion().getByIdWithTransformacionAndProducto(String.valueOf(gridTransformacionDet.asSingleSelect().getValue().getId()));
        List<OrdenDet> listOrdenes = Services.getOrden().listByIdTransformacionAndIdProducto(String.valueOf(transformacionDet.getTransformacion().getId()), String.valueOf(transformacionDet.getProducto().getId()));
        gridVisualizarItems.setItems(listOrdenes);
        
        lblCantidad.setText(String.valueOf(listOrdenes.size()));
        
    }
    
    
    @Override
    public void onLoadAllItems()
    {
        List<OrdenDet> listOrdenes = Services.getOrden().listByIdTransformacion(String.valueOf(this.idTransformacion));
        gridAllItems.setItems(listOrdenes);
    }
    
    @Override
    public void onBuscarArticulos(){
        List<Articulo> listArticulos = Services.getArticulo().listBySerie(txtSerieArticulo.getValue());
        cmbArticulos.setItems(listArticulos);     
    }
    
    @Override
    public void onActualizarSeriePadre()      
    {
        int items = 7;
        
        List<OrdenDet> listOrdenes = Services.getOrden().listByIdTransformacion(String.valueOf(this.idTransformacion));
        
        for(int i=0; i<items; i++)
        {
             OrdenDet orden = listOrdenes.get(i+items*Integer.valueOf(txtTransformacion.getValue()));
             orden.setArticulo_padre(cmbArticulos.getValue());
             Services.getOrden().update(orden);
        }
        listOrdenes = Services.getOrden().listByIdTransformacion(String.valueOf(this.idTransformacion));
        gridAllItems.setItems(listOrdenes);
    }
}
