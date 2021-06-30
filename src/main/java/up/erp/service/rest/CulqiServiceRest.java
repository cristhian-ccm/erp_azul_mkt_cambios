/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.service.rest;

import com.upgrade.persistence.model.ecommerce.PostCheckoutModel;
import com.upgrade.persistence.model.ecommerce.ResponseCulqiModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import up.erp.service.CulqiService;

/**
 *
 * @author evanl
 */
@RequestMapping("/culqi-secure")
@RestController
public class CulqiServiceRest {

    @Autowired
    private CulqiService culqiService;

    @PostMapping("/realizarCompra")
    public ResponseCulqiModel realizarCompra(@RequestBody PostCheckoutModel postCheckoutModel) {
        System.out.println(postCheckoutModel.toString());
        return culqiService.realizarCompra(postCheckoutModel);
    }
    
    @PostMapping("/actualizarCompra")
    public void save(@RequestBody PostCheckoutModel postCheckoutModel) {
        System.out.println(postCheckoutModel.toString());
    }

   /* @GetMapping("/createToken")
    @Override
    public Object crearToken(){
        return Services.getCulqiService().crearToken();
//        return null;
    }

    @GetMapping("/createCargo")
    @Override
    public String crearCargo() {
        return Services.getCulqiService().crearCargo();
    }

    @GetMapping("/consultarCargo")
    @Override
    public String consultarCargo() {
        return Services.getCulqiService().consultarCargo();
    }*/
}
