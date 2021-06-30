/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.service;

import com.upgrade.persistence.model.extcs.Almacen;
import java.util.List;

/**
 *
 * @author Diego-Javier
 */
public interface AlmacenService {
    public Almacen getById(String id);
    public List<Almacen> listByAbreviatura();
}
