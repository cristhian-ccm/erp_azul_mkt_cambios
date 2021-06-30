/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.service;

import com.upgrade.persistence.model.usros.Permiso;
import java.util.List;

/**
 *
 * @author Diego Javier Quispe
 */
public interface PermisosService {
    public List<Permiso> list(boolean soloActivos);
    public Permiso save(Permiso permiso);
}
