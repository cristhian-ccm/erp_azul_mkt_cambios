/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.service.rest;

import com.upgrade.persistence.model.cmrlz.NotaPedidoCab;
import com.upgrade.persistence.model.cmrlz.NotaPedidoDet;
import com.upgrade.persistence.model.ecommerce.PostCheckoutModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import up.erp.service.OrdenVentaService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author evanl
 */
@RequestMapping("/ordenventa")
@RestController
public class OrdenVentaServiceRest implements OrdenVentaService {


    @RequestMapping("/getLastTipoCambio")
    @Override
    public BigDecimal getLastTipoCambio() {
        return null;
    }

    @Override
    public NotaPedidoCab saveFromEcommerce(PostCheckoutModel model) {
        return null;
    }

    @Override
    public NotaPedidoCab updateNotaPedido(NotaPedidoCab cab) throws Exception {
        return null;
    }

    public NotaPedidoCab getById(String id) {
        return null;
    }
    
    public List<NotaPedidoCab> listByFechaDesdeHastaOrAndSerieOrAndNumero(LocalDate fechaInicial, LocalDate fechaFinal, String numero){
        return null;
    }
    
    public List<NotaPedidoCab> listByFechaDesdeHastaOrAndSerieOrAndNumeroAndAlmacen(LocalDate fechaInicial, LocalDate fechaFinal, String idAlmacen, String numero){
        return null;
    }
    
    public List<NotaPedidoDet> listByIdCabecera(int idNotaPedidoCab){
        return null;
    }
    
     public NotaPedidoCab getByVentaId(String idVenta){
        return null;
    }

}

