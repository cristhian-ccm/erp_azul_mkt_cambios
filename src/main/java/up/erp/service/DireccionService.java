/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.service;

import com.upgrade.persistence.model.ecommerce.DirEntrega;
import com.upgrade.persistence.model.ecommerce.PostCheckoutModel;
import com.upgrade.persistence.model.tcros.Direccion;
import java.util.List;

/**
 *
 * @author USER
 */
public interface DireccionService {
    public Direccion getDireccion(int direccionId) throws Exception; 
    public List<Direccion> getDireccionByPersona(int personaId) throws Exception; 
     public List<Direccion> getDireccionByPersonaId(int personaId) throws Exception;
    public List<Direccion> getListDirecciones(int vendedorId) throws Exception;
    public List<Direccion> getListByPersonaRuc(String ruc) throws Exception;
    public List<Direccion> getListByPersonaNombre(String nombre) throws Exception;  
   
    public Direccion getDireccionByIdentificador(PostCheckoutModel model) throws Exception;
    
    //public Direccion getDireccionByUsuarioWeb(int usuarioWebId, PostCheckoutModel model) throws Exception;
    public Direccion getDireccionByDirID(PostCheckoutModel model) throws Exception;

    
    public Direccion createDireccionByUsuarioWeb(PostCheckoutModel model) throws Exception;
    //public Direccion createDireccionByUsuarioWeb(int usuarioWebId, PostCheckoutModel model) throws Exception;
  
    public List<Direccion> listClientesByVendedor(String idPersona);
    public List<Direccion> listDireccionByPersonaWithVendedor(int personaId) throws Exception;
    public Direccion update(Direccion direccion);
}
