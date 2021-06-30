/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.service;

import com.upgrade.persistence.model.extcs.Marca;

import java.util.List;

/**
 *
 * @author Luis Aleman
 */
public interface MarcaService {
    
    public Marca getByCodigo(String codigo);
    //public List<Producto> list(boolean soloActivos);
    public List<Marca> listByNombre(String nombre);
}
