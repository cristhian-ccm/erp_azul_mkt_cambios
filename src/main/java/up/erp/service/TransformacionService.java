/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.service;

import com.upgrade.persistence.model.produccion.Transformacion;
import com.upgrade.persistence.model.produccion.TransformacionDet;
import java.util.List;

/**
 *
 * @author Diego-Javier
 */
public interface TransformacionService {
    
    public List<Transformacion> list(boolean soloActivos);
    public List<Transformacion> listWithPlantillaTransformacion(boolean soloActivos);
    public Transformacion save(Transformacion transformacion);
    public TransformacionDet save(TransformacionDet transformacionDet);
    public Transformacion update(Transformacion transformacion);
    public TransformacionDet update(TransformacionDet transformacionDet);
    public List<TransformacionDet> listByCabecera(String id);
    public List<TransformacionDet> listByCabeceraWithProducto(String id);
    public Transformacion getById(String id);
    public Transformacion getByIdWithProducto(String id);
    public TransformacionDet getByIdWithTransformacionAndProducto(String idTransformacionDet);//Extraer idTransformacion e Id Producto
    public Transformacion save(Transformacion cabecera, List<TransformacionDet> detalles) throws Exception;
    
    
}
