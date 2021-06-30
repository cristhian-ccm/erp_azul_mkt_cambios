/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.service;

import com.upgrade.persistence.model.extcs.OrdenCab;
import com.upgrade.persistence.model.extcs.OrdenDet;

import java.util.List;

/**
 *
 * @author Diego-Javier
 */
public interface OrdenService {
    public OrdenCab save(OrdenCab orden);
    public OrdenDet update(OrdenDet orden) ;
    public OrdenDet getById(int id);
    public OrdenCab getByIdTransformacion(int id);
    public List<OrdenDet> listByIdTransformacionAndTipo(int id, char tipo);
    public OrdenCab getByIdTransformacionAndTipo(int id, char tipo);
    public OrdenDet save(OrdenDet orden);
    public Integer getLastRegisterByTipo(char tipo);
    public OrdenDet findByIdArticulo(int idArticulo);
    public OrdenDet findByIdArticuloByTipoCab(int idArticulo, char tipo);
    public abstract List<OrdenDet> listByIdTransformacion(String id);
    public abstract List<OrdenDet> listByIdTransformacionAndIdProducto(String idTransformacion, String idProducto);
    public List<OrdenDet> listArticulosPorTransformacion();
    public List<OrdenDet> listArticulosPorTransformacionAndSerie(String serie);
    public List<OrdenDet> listArticulosByIdPadre(String idArticuloPadre);
    
}
