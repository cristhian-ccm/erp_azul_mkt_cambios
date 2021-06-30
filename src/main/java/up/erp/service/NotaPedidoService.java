/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.service;

import com.upgrade.persistence.model.cmrlz.NotaPedidoCab;
import com.upgrade.persistence.model.cmrlz.NotaPedidoDet;
import com.upgrade.persistence.model.cmrlz.VentaCab;
import com.upgrade.persistence.model.tcros.Direccion;

import java.util.Date;
import java.util.List;

/**
 *
 * @author evander
 */
public interface NotaPedidoService {    
    
    public void save(NotaPedidoCab cabecera, List<NotaPedidoDet> detalles) throws Exception;
    public void update(NotaPedidoCab cabecera) throws Exception;
    public void update(NotaPedidoCab cabecera, Direccion direcion) throws Exception;
    public void updateFormaPago(NotaPedidoCab cabecera) throws Exception;
    public void anularOrdenVenta(NotaPedidoCab cabecera) throws Exception;
    public void grabarCambioProducto(NotaPedidoCab notaPedidoCab, NotaPedidoDet notaPedidoDet) throws Exception;
    public List<NotaPedidoDet> getDetallesOV(int notaPedidoId) throws Exception;
    public List<NotaPedidoDet> getSoloDetallesOV(int notaPedidoId) throws Exception;//Usado en Descargas Siples
    public List<NotaPedidoDet> getDetallesByUtilidadOV(int notaPedidoId) throws Exception;
    public List<NotaPedidoDet> getDetallesOrdenVentaByNumero(int numOrdenVenta, int almacenId) throws Exception;
    public List<NotaPedidoDet> getNotaPedidoDetByAlmacenAndDate(Date fechaInicial, Date fechaFinal, int almacenId) throws Exception;
    public List<NotaPedidoDet> getNotaPedidoDetPendientesDescarga(int almacenId, String nombreCliente, String numero) throws Exception;//Usado en Almacen-Ordenes Pendientes de Descarga
    public List<NotaPedidoDet> getProductosVendidosByCliente(int direccionId) throws Exception;
    public List<NotaPedidoDet> getNotaPedidoDetTopProductos(int almacenId, int top, Date fecIni, Date fecFin) throws Exception;
    public List<NotaPedidoDet> getOrdendesPendientesDescarga(int almacenId, Date fechaInicial, Date fechaFinal) throws Exception;

    public List<NotaPedidoCab> getNotaPedidoCabByDireccionCliente(int direccionId) throws Exception;
    public List<NotaPedidoCab> getTotalSalesByYearSoles(int anio) throws Exception;//Usado en Perfil de vendedores
    public List<NotaPedidoCab> getTotalSalesByYearDollars(int anio) throws Exception;//Usado en Perfil de vendedores
    public List<NotaPedidoCab> getTotalSalesByPOSSoles(int almacen, String fechaInicio, String fechaFinal) throws Exception;//Usado en Perfil de vendedores
    public List<NotaPedidoCab> getTotalSalesByPOSDollars(int almacen, String fechaInicio, String fechaFinal) throws Exception;//Usado en Perfil de vendedores
    public List<NotaPedidoCab> getTotalSalesByPOSSoles(int almacen, Date fechaInicio, Date fechaFinal) throws Exception;//Usado en Perfil de vendedores
    public List<NotaPedidoCab> getTotalSalesByPOSDollars(int almacen, Date fechaInicio, Date fechaFinal) throws Exception;//Usado en Perfil de vendedores
    public List<NotaPedidoCab> getListNotasPedidoCab2016() throws Exception;
    public List<NotaPedidoCab> getListNotasPedidoCabMesCurso(String fechaInicio, String fechaFinal) throws Exception;
    public VentaCab getListVentaCab(Integer id) throws Exception;
    }