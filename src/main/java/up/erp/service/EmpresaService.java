/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.service;

import com.upgrade.persistence.model.emprs.Empresa;

/**
 *
 * @author Diego Javier Quispe
 */
public interface EmpresaService {
    public Empresa getById(int id);
}
