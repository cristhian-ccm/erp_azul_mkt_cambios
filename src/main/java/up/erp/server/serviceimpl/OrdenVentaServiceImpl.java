/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.server.serviceimpl;

import com.upgrade.persistence.factory.Numbers;
import com.upgrade.persistence.model.FormaPago;
import com.upgrade.persistence.model.Moneda;
import com.upgrade.persistence.model.PreventaTipo;
import com.upgrade.persistence.model.TipoCambio;
import com.upgrade.persistence.model.cmrlz.NotaPedidoCab;
import com.upgrade.persistence.model.cmrlz.NotaPedidoDet;
import com.upgrade.persistence.model.ecommerce.*;
import com.upgrade.persistence.model.extcs.Almacen;
import com.upgrade.persistence.model.extcs.Producto;
import com.upgrade.persistence.model.tcros.Direccion;
import com.upgrade.persistence.model.tcros.Persona;
import com.upgrade.persistence.model.unidad_negocio.UnidadNegocio;

import org.springframework.ui.Model;

import ts.com.service.util.db.server.CRUD;
import up.erp.service.OrdenVentaService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ts.com.service.util.db.Update;
import up.erp.server.Server;
import up.erp.service.Services;

/**
 *
 * @author evanl
 */
public class OrdenVentaServiceImpl implements OrdenVentaService {

    @Override
    public BigDecimal getLastTipoCambio() {
        String where = "where moneda_id = 2 orderby fecha desc limit 1";
        TipoCambio tc = null;
        try {
            List<TipoCambio> list = CRUD.list(TipoCambio.class, where);
            tc = list.isEmpty() ? null : list.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tc == null ? BigDecimal.ZERO : tc.venta;
    }

    @Override
    public NotaPedidoCab saveFromEcommerce(PostCheckoutModel model) throws Exception {
        NotaPedidoCab notaPedido = onSave(model);
        return notaPedido;
    }

    @Override
    public NotaPedidoCab updateNotaPedido(NotaPedidoCab cab) throws Exception {
        CRUD.update(cab);
        return cab;
    }
    
    
    @Override
    public NotaPedidoCab getById(String id) {
        NotaPedidoCab result = null;
        try {
            String where = "where a.id = '"+id+"' limit 1";
            String[] require = {"moneda", "direccionCliente", "direccionCliente.persona", "direccionCliente.persona.documentoIdentidad", "formaPago"};
            List<NotaPedidoCab> list = CRUD.list(NotaPedidoCab.class, require, where);
            if(!list.isEmpty()){
                result = list.get(0);
            }    
        } catch (Exception ex) {
            Logger.getLogger(VentasCabServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    @Override
    public NotaPedidoCab getByVentaId(String idVenta) {
        NotaPedidoCab result = null;
        try {
            String where = "where a.venta_id = '"+idVenta+"' limit 1";
            String[] require = {"moneda", "direccionCliente", "direccionCliente.persona", "direccionCliente.persona.documentoIdentidad", "formaPago"};
            List<NotaPedidoCab> list = CRUD.list(NotaPedidoCab.class, require, where);
            if(!list.isEmpty()){
                result = list.get(0);
            }
        } catch (Exception ex) {
            Logger.getLogger(VentasCabServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    private NotaPedidoCab onSave(PostCheckoutModel model) throws Exception {
            int diasCredito = 0;
            PreventaTipo preventaTipo = new PreventaTipo();
            preventaTipo.id = 1;
            Almacen almacen = new Almacen();
            almacen.id = 18;
            try {
                Update.beginTransaction();
                DocPago docPago = new DocPago();
                docPago.setActivo(true);
                docPago.setCreacion(new Date());
                docPago.setNombre(model.getComprobanteModel().getNombre());

               // docPago.setDocumento(model.getComprobanteModel().getTipo().equals("factura") ? model.getComprobanteModel().getRuc() : model.getComprobanteModel().getDni());
                docPago.setDocumento(model.getComprobanteModel().getTipo().equals("factura") ? model.getComprobanteModel().getIdentificador() : model.getComprobanteModel().getIdentificador());
                
                docPago.setDireccion(model.getComprobanteModel().getDireccion());
                docPago.setTelefono(model.getComprobanteModel().getTelefono());
                CRUD.save(docPago);

                int numeroOrdenVenta = getLastNumberOrdenVenta(almacen.id);
                NotaPedidoCab notaPedidoCab = new NotaPedidoCab();
                notaPedidoCab.crea = new Date();

                Persona persona = new Persona();                
                persona.id = model.usuariow_id;

                notaPedidoCab.creado = persona;
                notaPedidoCab.numero = numeroOrdenVenta;
                notaPedidoCab.fecha = new Date();
                notaPedidoCab.doc_pago_id = docPago;
                
           
                
             //Direccion direccion = Services.getDireccion().getDireccionByUsuarioWeb(model.usuariow_id,model);
               Direccion direccion = Services.getDireccion().getDireccionByDirID(model);

                     if(direccion ==null){

                    //direccion = Services.getDireccion().createDireccionByUsuarioWeb(model.usuariow_id,model);
                      direccion = Services.getDireccion().createDireccionByUsuarioWeb(model);



                }


                /*
                     if(direccion ==null){
                    direccion = Services.getDireccion().createDireccionByUsuarioWeb(model.usuariow_id,model);
                }

                */


                notaPedidoCab.direccionCliente = direccion;
                notaPedidoCab.anulada = false;
                notaPedidoCab.esComision = false;
                notaPedidoCab.esGastoOperativo = false;
                notaPedidoCab.vendedor = new Persona();
                notaPedidoCab.vendedor.id = Server.VENDEDOR_ECOMMERCE_ID;
                notaPedidoCab.moneda = new Moneda();
                notaPedidoCab.moneda.id = 1;
                notaPedidoCab.preventaTipo = preventaTipo;
                notaPedidoCab.cerrada = false;
                notaPedidoCab.formaPago = new FormaPago();
                notaPedidoCab.formaPago.id = model.metodoPago.equals("tarjeta")?2:1;
                notaPedidoCab.aprobada = true;
                notaPedidoCab.diasCredito = diasCredito;
                notaPedidoCab.almacen = almacen;
                notaPedidoCab.fechaEntrega = model.fecha_entrega;
                notaPedidoCab.observaciones = "-";
                notaPedidoCab.aprobadoSinAdelanto = false;
                notaPedidoCab.totalMinimo = BigDecimal.ZERO;
                notaPedidoCab.total = new BigDecimal(model.precioVentaTotal);
                notaPedidoCab.utilidadMinima = new BigDecimal("0.18");
                notaPedidoCab.comision = false;//
                notaPedidoCab.comisionMontoUsado = BigDecimal.ZERO;
                notaPedidoCab.totalSinComision = BigDecimal.ZERO;
                notaPedidoCab.almacenEntrega = almacen;
                notaPedidoCab.totalReal = notaPedidoCab.total;
                notaPedidoCab.deComision = false;
                notaPedidoCab.aprobadoCredito = true;
                notaPedidoCab.unidadNegocioId = new UnidadNegocio();
                notaPedidoCab.unidadNegocioId.id = 0;
                notaPedidoCab.comisionTerceros = BigDecimal.ZERO;
                notaPedidoCab.gastosOperativos = BigDecimal.ZERO;
                notaPedidoCab.ordenCompraCliente = "-";
                notaPedidoCab.tipo_entrega = model.metodoEntrega;
                notaPedidoCab.cupon = model.cupon;
                if(model.dirEntrega.id==null){
                    UsuarioWeb uweb = new UsuarioWeb();
                    uweb.id = model.usuariow_id;
                    model.dirEntrega.usuario_web = uweb;
                    CRUD.save(model.dirEntrega);
                }
                notaPedidoCab.direccion_Ecommerce = model.dirEntrega;
                notaPedidoCab.estado_actual = "P";
                CRUD.save(notaPedidoCab);


                //para el primer estado de la orden de venta:
                EstadosOrdenVenta estados = new EstadosOrdenVenta();
                estados.creacion = new Date();
                estados.creado_por = notaPedidoCab.creado.id;
                estados.dir_entrega = notaPedidoCab.direccion_Ecommerce;
                estados.estado = "P";
                estados.fecha_entrega = notaPedidoCab.fechaEntrega;
                estados.fecha_registro = notaPedidoCab.fecha;
                estados.nota_pedido = notaPedidoCab;
                CRUD.save(estados);
                for(ProductoEcModel item : model.productoEcModelList){
                    NotaPedidoDet det = new NotaPedidoDet();
                    det.cantidad = new BigDecimal(item.cantidad);
                    det.cantidadEntregada = BigDecimal.ZERO;
                    det.editadoPor = null;
                    det.entregaCompleta = false;
                    det.exonerado = false;
                    det.notaPedido = notaPedidoCab;
                    BigDecimal pu = Numbers.divide(item.total, det.cantidad, 4);
                    det.precioUnitarioNota = pu;
                    det.precioUnitarioProducto = pu;
                    det.precioUnitarioVenta = pu;
                    det.precioUnitarioVentaReal = pu;
                    det.producto = new Producto();
                    det.producto.id = Integer.parseInt(item.id);
                    det.productoCambio = null;
                    det.regalo = false;
                    det.solicitudCompra = null;
                    CRUD.save(det);
                }
                Update.commitTransaction();
                return notaPedidoCab;
            } catch (Exception ex) {
                Update.rollbackTransaction();
                ex.printStackTrace();
            }
            return null;
    }
     private int getLastNumberOrdenVenta(int almacenId) throws Exception {
        int numero;
        String filter = "where a.almacen_id = " + almacenId
                + " order by a.numero desc limit 1";
        List<NotaPedidoCab> list;
        list = CRUD.list(NotaPedidoCab.class, null, filter);
        numero = list.isEmpty() ? 0 : list.get(0).numero;
        return numero + 1;
    }
     
    @Override
    public List<NotaPedidoCab> listByFechaDesdeHastaOrAndSerieOrAndNumero(LocalDate fechaInicial, LocalDate fechaFinal, String numero)
    {
        List<NotaPedidoCab> result = new ArrayList<>();
        try {
            String where = "where ";
            Boolean isAnd = false;
            if (fechaInicial != null && fechaFinal != null)
            {
                where += " a.fecha >= '"+fechaInicial+"' and a.fecha <= '"+fechaFinal+"' "; 
                isAnd = true;
            }
            
            /*if (!serie.isEmpty())
            {
                if (isAnd)
                    where += " and ";
                where += " serie = '"+serie+"'";
                isAnd = true;
            }*/
            
            if (!numero.isEmpty())
            {
                if (isAnd)
                    where += " and ";
                where += " a.numero = '"+numero+"'";
                isAnd = true;
            }
            
            where += " order by a.fecha";
            String[] require = {"direccionCliente", "direccionCliente.persona", "venta", "venta.documentoTipo", "formaPago"};// "venta", "venta.documentoTipo"};
            result = CRUD.list(NotaPedidoCab.class, require, where);
         } catch (Exception ex) {
            Logger.getLogger(NotaCreditoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;        
    }
    
     @Override
    public List<NotaPedidoCab> listByFechaDesdeHastaOrAndSerieOrAndNumeroAndAlmacen(LocalDate fechaInicial,LocalDate fechaFinal,  String idAlmacen, String numero)
    {
        List<NotaPedidoCab> result = new ArrayList<>();
        try {
            String where = "where ";
            Boolean isAnd = false;
            if (fechaInicial != null && fechaFinal != null)
            {
                where += " a.fecha >= '"+fechaInicial+"' and a.fecha <= '"+fechaFinal+"' and a.almacen_id = '"+idAlmacen+"'"; 
                isAnd = true;
            }
            
            /*if (!serie.isEmpty())
            {
                if (isAnd)
                    where += " and ";
                where += " serie = '"+serie+"'";
                isAnd = true;
            }*/
            
            if (!numero.isEmpty())
            {
                if (isAnd)
                    where += " and ";
                where += " a.numero = '"+numero+"'";
                isAnd = true;
            }
            
            where += " order by a.fecha";
            String[] require = {"direccionCliente", "direccionCliente.persona", "venta", "venta.documentoTipo", "formaPago"};// "venta", "venta.documentoTipo"};
            result = CRUD.list(NotaPedidoCab.class, require, where);
         } catch (Exception ex) {
            Logger.getLogger(NotaCreditoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;        
    }
    
    @Override
    public List<NotaPedidoDet> listByIdCabecera(int idNotaPedidoCab)
    {
        List<NotaPedidoDet> result = new ArrayList<>();
        try {
            String where = "where nota_pedido_id = '"+idNotaPedidoCab+"'";
            String[] require = {"producto", "producto.unidad"};
            
            result = CRUD.list(NotaPedidoDet.class, require, where);
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }    

}
