/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.service;

import com.upgrade.persistence.model.cmrlz.NotaCreDebCap;
import com.upgrade.persistence.model.cmrlz.NotaCreDebDet;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Upgrade - PC
 */
public interface NotaCreditoService {
    public NotaCreDebCap getLastNumeroByAlmacen(int idAlmacen);
    public NotaCreDebCap save(NotaCreDebCap notaCredito);
    public NotaCreDebDet save(NotaCreDebDet notaCredito);
    public List<NotaCreDebCap> listByFecha(LocalDate fechaInicial, LocalDate fechaFinal);
    public NotaCreDebCap getByIdVenta(String idVenta);
    public NotaCreDebCap getLastNumeroByAlmacenAndFacBol(int idAlmacen, String FacturaBoleta);
    public List<NotaCreDebCap> listByFechaDesdeHastaOrAndSerieOrAndNumero(LocalDate fechaInicial, LocalDate fechaFinal, String numero);
}
