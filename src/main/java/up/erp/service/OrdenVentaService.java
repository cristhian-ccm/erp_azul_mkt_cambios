/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.service;
import com.upgrade.persistence.model.cmrlz.NotaPedidoCab;
import com.upgrade.persistence.model.cmrlz.NotaPedidoDet;
import com.upgrade.persistence.model.ecommerce.PostCheckoutModel;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author evanl
 */
public interface OrdenVentaService {
    
    public BigDecimal getLastTipoCambio();
    public NotaPedidoCab saveFromEcommerce(PostCheckoutModel model) throws Exception ;
    public NotaPedidoCab updateNotaPedido(NotaPedidoCab cab) throws Exception ;
    public List<NotaPedidoCab> listByFechaDesdeHastaOrAndSerieOrAndNumero(LocalDate fechaInicial, LocalDate fechaFinal, String numero);
    public List<NotaPedidoCab> listByFechaDesdeHastaOrAndSerieOrAndNumeroAndAlmacen(LocalDate fechaInicial, LocalDate fechaFinal, String idAlmacen, String numero);
    public List<NotaPedidoDet> listByIdCabecera(int idNotaPedidoCab);
    public NotaPedidoCab getById(String id);
    public NotaPedidoCab getByVentaId(String idVenta);
}
