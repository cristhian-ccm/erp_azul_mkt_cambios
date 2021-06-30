/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.service;

import com.upgrade.persistence.model.usros.RolPermiso;
import java.util.List;

/**
 *
 * @author Upgrade - PC
 */
public interface RolPermisoService {
    public List<RolPermiso> listByIdRol(String idRol);
    public RolPermiso save(RolPermiso rolPermiso);
}
