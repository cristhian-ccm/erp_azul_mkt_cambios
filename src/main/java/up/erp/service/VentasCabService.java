/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.service;

import com.upgrade.persistence.model.cmrlz.VentaCab;
import com.upgrade.persistence.model.cmrlz.VentaDet;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Upgrade - PC
 */
public interface VentasCabService {
    public abstract List<VentaCab> list(boolean soloActivos);
    public abstract List<VentaDet> listByIdCabecera(String id);
    public abstract VentaCab getById(String id);
    public abstract List<VentaCab> listByFecha(LocalDate fechaInicial, LocalDate fechaFinal);
    public abstract VentaCab update(VentaCab venta);
    public abstract List<VentaCab> listByFechaDesdeHastaOrAndSerieOrAndNumero(LocalDate fechaInicial, LocalDate fechaFinal, String serie, String numero);
    public abstract List<VentaCab> listByFechaDesdeHastaOrAndSerieOrAndNumeroAndAlmacen(LocalDate fechaInicial, LocalDate fechaFinal, String idAlmacen, String serie, String numero);
    public abstract VentaCab getLastNumeroByAlmacenAndFacBol(int idAlmacen, int idDocumentoTipo);
    public abstract VentaCab save(VentaCab id);
    public abstract VentaDet saveDetalle(VentaDet id);
    public abstract VentaCab save(VentaCab cabecera, List<VentaDet> detalles)  throws Exception;
    public abstract VentaCab getByOrdenVentaId(String id);
    
    
}
