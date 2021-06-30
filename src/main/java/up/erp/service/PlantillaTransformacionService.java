/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.service;

import com.upgrade.persistence.model.produccion.PlantillaTransformacion;
import com.upgrade.persistence.model.produccion.PlantillaTransformacionDet;

import java.util.List;

/**
 *
 * @author Diego-Javier
 */
public interface PlantillaTransformacionService {
    
    public PlantillaTransformacion save(PlantillaTransformacion plantillaTransformacion);
    public PlantillaTransformacion update(PlantillaTransformacion plantillaTransformacion);
    
    public List<PlantillaTransformacion> list(boolean soloActivos);
    public List<PlantillaTransformacion> listWithProducto(boolean soloActivos);
    public List<PlantillaTransformacion> listByCodigoProducto(String codigoProduco);
    
    public PlantillaTransformacion save(PlantillaTransformacion cabecera, List<PlantillaTransformacionDet> detalles) throws Exception;
    public PlantillaTransformacion getById(String id);
    public PlantillaTransformacion getByIdWithProducto(String id);
    
    public PlantillaTransformacion getByCodigoProducto(String codigoProducto);
    public PlantillaTransformacion getByIdProducto(String idProducto);
    
    public PlantillaTransformacionDet saveDetalle(PlantillaTransformacionDet plantillaTransformacionDet);
    public PlantillaTransformacionDet delete(PlantillaTransformacionDet plantillaTransformacionDet);
    public PlantillaTransformacionDet getDetalleById(String id);
    public List<PlantillaTransformacionDet> listByIdCabecera(String id);
    public List<PlantillaTransformacionDet> listByIdCabeceraWithProductoWithMarca(String id);
    public Integer getLastRegister();
    
    
}
