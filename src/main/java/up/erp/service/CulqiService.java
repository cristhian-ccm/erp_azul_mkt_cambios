/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.service;

import com.upgrade.persistence.model.ecommerce.PostCheckoutModel;
import com.upgrade.persistence.model.ecommerce.ResponseCulqiModel;

/**
 *
 * @author evanl
 */
public interface CulqiService {

    ResponseCulqiModel realizarCompra(PostCheckoutModel postCheckoutModel);
    /*Object crearToken();

    String crearCargo();

    String consultarCargo();*/
}
