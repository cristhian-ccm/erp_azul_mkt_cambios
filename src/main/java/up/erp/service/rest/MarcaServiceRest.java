/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.service.rest;

import com.upgrade.persistence.model.extcs.Marca;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import up.erp.service.MarcaService;
import up.erp.service.Services;

import java.util.List;

/**
 *
 * @author Luis Aleman
 */
@RequestMapping("/marca")
@RestController
public class MarcaServiceRest implements MarcaService {
    @GetMapping("/getByCodigo")
    @Override
    public Marca getByCodigo(@RequestParam(value = "codigo") String codigo) {
        return Services.getMarca().getByCodigo(codigo);
    }

    @GetMapping("/listByNombre")
    @Override
    public List<Marca> listByNombre(@RequestParam(value = "nombre")String nombre) {
        return Services.getMarca().listByNombre(nombre);
    }
}
