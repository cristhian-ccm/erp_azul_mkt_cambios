package up.erp.service;

import com.upgrade.persistence.model.cmrlz.NotaPedidoCab;
import com.upgrade.persistence.model.fnnzs.Recibo;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Diego Javier Quispe
 */
public interface RecibosService {
    public Recibo getByOrdenVentaId(String id);
    public Recibo getById(String id);
    public Recibo getByIdWithNotaPedido(String id);
    public Recibo setNotaPedidoNullAndAnular(String id);
    public Recibo setNotaPedidoNull(String id);
    public BigDecimal sumRecibosByOrden(String irOrden);
    
    public abstract List<Recibo> listByFechaDesdeHastaOrAndSerieOrAndNumero(LocalDate fechaInicial, LocalDate fechaFinal, String numero);
    public abstract List<Recibo> listByIdOrdenVenta(String numero);
    
}
