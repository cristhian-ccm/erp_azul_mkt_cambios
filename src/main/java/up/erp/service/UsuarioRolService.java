/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.service;

import com.upgrade.persistence.model.usros.UsuarioRol;
import java.util.List;

/**
 *
 * @author Upgrade - PC
 */
public interface UsuarioRolService {
    public List<UsuarioRol> listByIdUsuario(String idUsuario);
    public UsuarioRol save(UsuarioRol usuarioRol);
    public void delete(UsuarioRol usuarioRol);
}
