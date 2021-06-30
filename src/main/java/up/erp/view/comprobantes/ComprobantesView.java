/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.view.comprobantes;

import com.upgrade.persistence.model.cmrlz.NotaCreDebCap;
import com.upgrade.persistence.model.cmrlz.NotaCreDebDet;
import com.upgrade.persistence.model.cmrlz.NotaPedidoCab;
import com.upgrade.persistence.model.cmrlz.NotaPedidoDet;
import com.upgrade.persistence.model.cmrlz.VentaCab;
import com.upgrade.persistence.model.cmrlz.VentaDet;
import com.upgrade.persistence.model.extcs.Almacen;
import com.upgrade.persistence.model.sunat.TipoNotaCredito;
import com.upgrade.persistence.model.tcros.Persona;
import com.upgrade.persistence.model.ventas.Detalle_ObjectNubefact;
import com.upgrade.persistence.model.ventas.ObjectNubefact;
import com.vaadin.flow.component.UI;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import up.erp.service.Services;
import up.erp.view.App;
import up.erp.view.produccion.Mensaje;

/**
 *
 * @author Upgrade - PC
 */
public class ComprobantesView extends ComprobantesUI{
    
    public App app;
    public Persona persona = Services.getPersona().getOnePersona();
    
    public ComprobantesView(App app) {
        this.app = app;
        List<Almacen> listAlmacenes = Services.getAlmacen().listByAbreviatura();
        cmbAlmacen.setItems(listAlmacenes);
        cmbAlmacen.setValue(listAlmacenes.get(0));
        
        this.onGetComprobantes();
    }
    
    @Override
    public final void onGetComprobantes()
    {
        //List<VentaCab> comprobantes = Services.getVentasCab().listByFechaDesdeHastaOrAndSerieOrAndNumero(fechaDesde.getValue(), fechaHasta.getValue(), buscarBySerie.getValue(), buscarByNumero.getValue());
        List<VentaCab> comprobantes = Services.getVentasCab().listByFechaDesdeHastaOrAndSerieOrAndNumeroAndAlmacen(fechaDesde.getValue(), fechaHasta.getValue(), String.valueOf(cmbAlmacen.getValue().getId()), buscarBySerie.getValue(), buscarByNumero.getValue());
        
        
        /*if (buscarBySerie.isEmpty())
        {
            comprobantes = Services.getVentasCab().listByFecha(fechaDesde.getValue(), fechaHasta.getValue());
        }
        else
        {
            comprobantes = Services.getVentasCab().listByFechaAndSerie(fechaDesde.getValue(), fechaHasta.getValue(), Integer.valueOf(buscarBySerie.getValue()));
        }*/
        gridComprobantes.setItems(comprobantes);
        
    }
    
    @Override
    public void onGetDetallesComprobante()
    {
        List<VentaDet> listDetalles = Services.getVentasCab().listByIdCabecera(String.valueOf(gridComprobantes.asSingleSelect().getValue().getId()));
        gridDetallesComprobante.setItems(listDetalles);
    }
    
    @Override
    public void onGetDetallesGenerar()
    {
        List<VentaDet> listDetalles = Services.getVentasCab().listByIdCabecera(String.valueOf(gridComprobantes.asSingleSelect().getValue().getId()));
        gridDetallesGenerar.setItems(listDetalles);
    }
    
    @Override
    public void onGetDetallesToNC()
    {
        List<VentaDet> listDetalles = Services.getVentasCab().listByIdCabecera(String.valueOf(gridComprobantes.asSingleSelect().getValue().getId()));
        gridDetallesNC.setItems(listDetalles);
    }
    
    //Tipo 7 Devolucion por item
    @Override
    public Mensaje onGenerarNotaCreditoParcial()
    {
        Mensaje mensaje = new Mensaje();
        
        if(gridDetallesNC.getSelectedItems().isEmpty())
        {    
            mensaje.setMensaje("No se ha seleccionado ningun item");
            mensaje.setTipo(false);
        }
        else{
            TipoNotaCredito tipoNotaCredito = Services.getTipoNotaCredito().getById("7");//AnulacionTotal
            //VentaCab ventaCab = Services.getVentasCab().list(true).get(0);
        
            VentaCab ventaCab = Services.getVentasCab().getById(String.valueOf(gridComprobantes.asSingleSelect().getValue().getId()));        
            
            /*Nubefact Cabecera*/
            ObjectNubefact object = new ObjectNubefact();

            object.local = ventaCab.getAlmacen().getId();
            object.operacion = "generar_comprobante";            
            object.tipo_de_comprobante = 3;//Nota de crédito
            object.serie = getSerieNota(ventaCab.getNombreCortoDocumentoTipo(), String.valueOf(ventaCab.getSerie()));

            NotaCreDebCap notaLast = Services.getNotaCredito().getLastNumeroByAlmacenAndFacBol(ventaCab.getAlmacen().getId(), acronimoBoletaFactura(ventaCab.getNombreCortoDocumentoTipo()));

            object.numero = notaLast==null?1:(notaLast.getNumero()+1);
            object.sunat_transaction = 1;
            object.cliente_tipo_de_documento = Integer.valueOf(String.valueOf(ventaCab.getDireccionCliente().getPersona().getDocumentoIdentidad().getAdditional_account()));//Listo
            
            object.cliente_numero_de_documento = ventaCab.getDireccionCliente().getPersona().getIdentificador();//Listo
            object.cliente_denominacion = ventaCab.getDireccionCliente().getPersona().getNombre();//Listo
            object.cliente_direccion = ventaCab.getDireccionCliente().getDescripcion();//Listo
            object.cliente_email =  ventaCab.getDireccionCliente().getEmail();//Listo
            
            object.fecha_de_emision = Date.from(fechaNotaCredito.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());

            object.moneda = ventaCab.getMoneda().getId();//Listo
            object.porcentaje_de_igv = 18.00;
            
            /*object.total_igv = ventaCab.getMontoImpuesto();//Listo
            object.total_gravada = ventaCab.getSubtotal();//Listo
            object.total = ventaCab.getTotal();//Listo*/
            
            object.detraccion = false;//Listo
            object.enviar_automaticamente_a_la_sunat = true;//Listo
            object.enviar_automaticamente_al_cliente = false;//Listo
            object.tipo_de_nota_de_credito = tipoNotaCredito.getId();//Anulacion Total
            object.documento_que_se_modifica_tipo = ventaCab.getDocumentoTipo().getTipoOse();
            object.documento_que_se_modifica_serie = getSerieModifica(ventaCab.getNombreCortoDocumentoTipo(), String.valueOf(ventaCab.getSerie()));
            object.documento_que_se_modifica_numero = ventaCab.getNumero();

            List<VentaDet> listDetalles = new ArrayList<>();
            gridDetallesNC.getSelectedItems().forEach(
                ventaDet->{
                        listDetalles.add(ventaDet);
                   }
            );
             /*Nubefact Detalles*/

            List<Detalle_ObjectNubefact> detalles = new ArrayList<>();
                
            BigDecimal sumTotal = BigDecimal.ZERO;
            //List<VentaDet> listDetalles = Services.getVentasCab().listByIdCabecera(String.valueOf(ventaCab.getId()));
            for(int i=0; i<listDetalles.size(); i++)
            {
                Detalle_ObjectNubefact detalle = new Detalle_ObjectNubefact();

                detalle.codigo_producto_sunat = listDetalles.get(i).getCod_sunat();//Listo
                detalle.descripcion = listDetalles.get(i).getDescripcion();//Listo
                detalle.unidad_de_medida = "NIU";
                detalle.codigo = listDetalles.get(i).getProducto().getCodigo();
                detalle.cantidad = listDetalles.get(i).getCantidad();//Listo
                detalle.valor_unitario = listDetalles.get(i).getPrecioVenta().divide(BigDecimal.valueOf(1.18), 2, RoundingMode.HALF_UP);
                detalle.precio_unitario = listDetalles.get(i).getPrecioVenta();
                detalle.tipo_de_igv = 1;
                detalle.subtotal = listDetalles.get(i).getSubtotal();
                detalle.total = listDetalles.get(i).getTotal();
                detalle.igv = listDetalles.get(i).getIgv();
                detalle.anticipo_regularizacion = false;//Listo
                detalles.add(detalle);
                
                sumTotal = sumTotal.add(listDetalles.get(i).getTotal());
            }
            
            //object.total_igv = ventaCab.getMontoImpuesto();//Listo
            object.total_gravada = sumTotal.divide(BigDecimal.valueOf(1.18), 2, RoundingMode.HALF_UP);//Listo
            object.total = sumTotal;//Listo
            object.total_igv = object.total.add(object.total_gravada.negate());
            
            /*gridDetallesNC.getSelectedItems().forEach(
                ventaDet->{
                    Detalle_ObjectNubefact detalle = new Detalle_ObjectNubefact();

                    detalle.codigo_producto_sunat = ventaDet.getCod_sunat();//Listo
                    detalle.descripcion = ventaDet.getDescripcion();//Listo
                    detalle.unidad_de_medida = "NIU";
                    detalle.codigo = ventaDet.getProducto().getCodigo();
                    detalle.cantidad = ventaDet.getCantidad();//Listo
                    detalle.valor_unitario = ventaDet.getPrecioVenta().divide(BigDecimal.valueOf(1.18), 2, RoundingMode.HALF_UP);
                    detalle.precio_unitario = ventaDet.getPrecioVenta();
                    detalle.tipo_de_igv = 1;
                    detalle.subtotal = ventaDet.getSubtotal();
                    detalle.total = ventaDet.getTotal();
                    detalle.igv = ventaDet.getIgv();
                    detalle.anticipo_regularizacion = false;//Listo
                    detalles.add(detalle);
                }   
            );*/

            object.Detalle = detalles;

            Nubefact_Comprobantes nubefact = new Nubefact_Comprobantes();

            ObjectNubefact result = nubefact.apiConsume(object);

            /*System.out.println(">>"+result.aceptadaSunat);
            System.out.println(">>"+result.enlacePdf);
            System.out.println(">>"+result.enlaceXml);
            System.out.println(">>"+result.sunatDescription);
            System.out.println(">>"+result.Error);*/

            NotaCreDebCap notaCredito = new NotaCreDebCap();
            notaCredito.setVenta(ventaCab);
            notaCredito.setAnulada(Boolean.FALSE);
            notaCredito.setCreado(new Date(System.currentTimeMillis()));
            //notaCredito.setFecEmision(new Date(System.currentTimeMillis()));
            notaCredito.setFecEmision(Date.from(fechaNotaCreditoNC.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            notaCredito.setCreadoPor(persona);
            notaCredito.setAlmacen(ventaCab.getAlmacen());
            notaCredito.setNumero(notaLast==null?1:(notaLast.getNumero()+1));
            //notaCredito.setNumero(Services.getNotaCredito().getLastNumeroByAlmacenAndFacBol(ventaCab.getAlmacen().getId(), acronimoBoletaFactura(ventaCab.getNombreCortoDocumentoTipo())).getNumero()+1);
            notaCredito.setDocumentoTipo(Services.getDocumentoTipo().getById("7"));
            notaCredito.setCodMotivo(tipoNotaCredito);//Anulacion Total
            //notaCredito.setDesMotivo("Error en la Facturaicion");
            notaCredito.setDesMotivo(observacionesNC.getValue());
            notaCredito.setSumOtrosCargos(BigDecimal.ZERO);
            notaCredito.setMtoOperInafectas(BigDecimal.ZERO);
            notaCredito.setMtoOperexOneradas(BigDecimal.ZERO);
            notaCredito.setMtoISC(BigDecimal.ZERO);
            notaCredito.setMtoOtrosTributos(BigDecimal.ZERO);


            //notaCredito.setFirma(firma);
            notaCredito.setSerie(acronimoBoletaFactura(ventaCab.getNombreCortoDocumentoTipo()));
            
            /*notaCredito.setMtoOperGravadas(ventaCab.getSubtotal());
            notaCredito.setMtoIGV(ventaCab.getMontoImpuesto());
            notaCredito.setMtoImpVenta(ventaCab.getTotal());*/
            
            notaCredito.setMtoOperGravadas(sumTotal.divide(BigDecimal.valueOf(1.18), 2, RoundingMode.HALF_UP));
            notaCredito.setMtoImpVenta(sumTotal);
            notaCredito.setMtoIGV(object.total.add(object.total_gravada.negate()));
            
            /*System.out.println(result.Error);
            System.out.println(result.aceptadaSunat);*/
            if(result.Error != null)
                notaCredito.setObservaciones(result.Error.replace("'",""));
            else
                notaCredito.setObservaciones(result.Error);
            notaCredito.setAceptada_SUNAT(result.aceptadaSunat);
            notaCredito.setEnlacePdfNubefact(result.enlacePdf);
            notaCredito.setEnlaceXmlNubefact(result.enlaceXml);
            notaCredito.setDescripcion(result.sunatDescription);

            notaCredito = Services.getNotaCredito().save(notaCredito);
            
            /*gridDetallesNC.getSelectedItems().forEach(
                ventaDet->{
                
                    NotaCreDebDet notaCreditoDetalle = new NotaCreDebDet();
                    notaCreditoDetalle.setCreadoPor(persona);
                    notaCreditoDetalle.setCreado(new Date(System.currentTimeMillis()));
                    notaCreditoDetalle.setNotaCreDeb(notaCredito);
                    notaCreditoDetalle.setPrecioUnitario(ventaDet.getPrecioUnitarioProducto());
                    notaCreditoDetalle.setPrecioUnitarioVenta(ventaDet.getPrecioUnitarioVenta());
                    notaCreditoDetalle.setPrecioVenta(ventaDet.getPrecioVenta());
                    notaCreditoDetalle.setRegalo(Boolean.FALSE);
                    notaCreditoDetalle.setProducto(ventaDet.getProducto());
                    notaCreditoDetalle.setCantidad(ventaDet.getCantidad());

                    Services.getNotaCredito().save(notaCreditoDetalle);
                }
            );*/
            
            for(int i=0; i<listDetalles.size(); i++)
            {
                NotaCreDebDet notaCreditoDetalle = new NotaCreDebDet();
                notaCreditoDetalle.setCreadoPor(persona);
                notaCreditoDetalle.setCreado(new Date(System.currentTimeMillis()));
                notaCreditoDetalle.setNotaCreDeb(notaCredito);
                notaCreditoDetalle.setPrecioUnitario(listDetalles.get(i).getPrecioUnitarioProducto());
                notaCreditoDetalle.setPrecioUnitarioVenta(listDetalles.get(i).getPrecioUnitarioVenta());
                notaCreditoDetalle.setPrecioVenta(listDetalles.get(i).getPrecioVenta());
                notaCreditoDetalle.setRegalo(Boolean.FALSE);
                notaCreditoDetalle.setProducto(listDetalles.get(i).getProducto());
                notaCreditoDetalle.setCantidad(listDetalles.get(i).getCantidad());

                Services.getNotaCredito().save(notaCreditoDetalle);
            }
            //notaCreditoDetalle

            ventaCab.setAnulada(Boolean.TRUE);
            Services.getArticulo().setVentaNull(String.valueOf(ventaCab.getId()));
            Services.getVentasCab().update(ventaCab);

            if (notaCredito.getSerie().equals("FN"))
            {
                if(notaCredito.getAceptada_SUNAT() != null)
                    mensaje.setTipo(notaCredito.getAceptada_SUNAT());
                else
                    mensaje.setTipo(false);
                mensaje.setMensaje(notaCredito.getObservaciones());
            }
            else{
                /*mensaje.setTipo(true);
                mensaje.setMensaje("Nota de crédito generada satisfacatoriamente");*/
                if(notaCredito.getAceptada_SUNAT() != null)
                    mensaje.setTipo(notaCredito.getAceptada_SUNAT());
                else
                    mensaje.setTipo(false);
                mensaje.setMensaje(notaCredito.getObservaciones());
            }

            
        }
        
        return mensaje;
    }
    
    // Tipo 6 devolución total
    @Override
    public boolean onGenerarNotaCredito()
    {
        
        TipoNotaCredito tipoNotaCredito = Services.getTipoNotaCredito().getById("6");//AnulacionTotal
        //VentaCab ventaCab = Services.getVentasCab().list(true).get(0);
        
        VentaCab ventaCab = Services.getVentasCab().getById(String.valueOf(gridComprobantes.asSingleSelect().getValue().getId()));        
        //System.out.println("-------------------->"+ventaCab.getAlmacen().getId());
        
        /*Nubefact Cabecera*/
        ObjectNubefact object = new ObjectNubefact();
        
        //object.local = 18;
        object.local = ventaCab.getAlmacen().getId();
        object.operacion = "generar_comprobante";
        //object.tipo_de_comprobante = ventaCab.getDocumentoTipo().getId();//Listo
        object.tipo_de_comprobante = 3;//Nota de crédito
        //object.serie = String.valueOf(ventaCab.getSerie());//Listo
        //object.serie = "F018";
        object.serie = getSerieNota(ventaCab.getNombreCortoDocumentoTipo(), String.valueOf(ventaCab.getSerie()));
        
        NotaCreDebCap notaLast = Services.getNotaCredito().getLastNumeroByAlmacenAndFacBol(ventaCab.getAlmacen().getId(), acronimoBoletaFactura(ventaCab.getNombreCortoDocumentoTipo()));
        
        object.numero = notaLast==null?1:(notaLast.getNumero()+1);
        object.sunat_transaction = 1;
        object.cliente_tipo_de_documento = Integer.valueOf(String.valueOf(ventaCab.getDireccionCliente().getPersona().getDocumentoIdentidad().getAdditional_account()));//Listo
        //object.cliente_tipo_de_documento = 1;
        object.cliente_numero_de_documento = ventaCab.getDireccionCliente().getPersona().getIdentificador();//Listo
        object.cliente_denominacion = ventaCab.getDireccionCliente().getPersona().getNombre();//Listo
        object.cliente_direccion = ventaCab.getDireccionCliente().getDescripcion();//Listo
        object.cliente_email =  ventaCab.getDireccionCliente().getEmail();//Listo
        //object.fecha_de_emision = new Date(System.currentTimeMillis());//Listo
        object.fecha_de_emision = Date.from(fechaNotaCredito.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
		
        object.moneda = ventaCab.getMoneda().getId();//Listo
        object.porcentaje_de_igv = 18.00;
        object.total_igv = ventaCab.getMontoImpuesto();//Listo
        object.total_gravada = ventaCab.getSubtotal();//Listo
        object.total = ventaCab.getTotal();//Listo
        object.detraccion = false;//Listo
        object.enviar_automaticamente_a_la_sunat = true;//Listo
        object.enviar_automaticamente_al_cliente = false;//Listo
        object.tipo_de_nota_de_credito = tipoNotaCredito.getId();//Anulacion Total
        object.documento_que_se_modifica_tipo = ventaCab.getDocumentoTipo().getTipoOse();
        object.documento_que_se_modifica_serie = getSerieModifica(ventaCab.getNombreCortoDocumentoTipo(), String.valueOf(ventaCab.getSerie()));
        object.documento_que_se_modifica_numero = ventaCab.getNumero();
        
             
         /*Nubefact Detalles*/
        
        List<Detalle_ObjectNubefact> detalles = new ArrayList<>();
        
        List<VentaDet> listDetalles = Services.getVentasCab().listByIdCabecera(String.valueOf(ventaCab.getId()));
        
        for(int i=0; i<listDetalles.size(); i++)
        {
            Detalle_ObjectNubefact detalle = new Detalle_ObjectNubefact();
            
            detalle.codigo_producto_sunat = listDetalles.get(i).getCod_sunat();//Listo
            detalle.descripcion = listDetalles.get(i).getDescripcion();//Listo
            //detalle.unidad_de_medida = listDetalles.get(i).getProducto().getUnidad().getAbreviatura();//Listo
            detalle.unidad_de_medida = "NIU";
            detalle.codigo = listDetalles.get(i).getProducto().getCodigo();
            detalle.cantidad = listDetalles.get(i).getCantidad();//Listo
            //detalle.precio_unitario = listDetalles.get(i).getPrecioVenta().setScale(2, RoundingMode.UP);
            //detalle.valor_unitario = detalle.precio_unitario.divide(BigDecimal.valueOf(1.18)).setScale(2, RoundingMode.UP);
            
            detalle.valor_unitario = listDetalles.get(i).getPrecioVenta().divide(BigDecimal.valueOf(1.18), 2, RoundingMode.HALF_UP);
            detalle.precio_unitario = listDetalles.get(i).getPrecioVenta();
            //detalle.subtotal = listDetalles.get(i).getPrecioUnitarioVenta().add(listDetalles.get(i).getCantidad());
            detalle.tipo_de_igv = 1;
              
            //detalle.total = detalle.subtotal.multiply(BigDecimal.valueOf(1.18));
            detalle.subtotal = listDetalles.get(i).getSubtotal();
            detalle.total = listDetalles.get(i).getTotal();
            detalle.igv = listDetalles.get(i).getIgv();
            detalle.anticipo_regularizacion = false;//Listo
            
            detalles.add(detalle);
        }
            
        object.Detalle = detalles;
        
        Nubefact_Comprobantes nubefact = new Nubefact_Comprobantes();
        
        ObjectNubefact result = nubefact.apiConsume(object);
        
        /*System.out.println(">>"+result.aceptadaSunat);
        System.out.println(">>"+result.enlacePdf);
        System.out.println(">>"+result.enlaceXml);
        System.out.println(">>"+result.sunatDescription);
        System.out.println(">>"+result.Error);*/
        
        NotaCreDebCap notaCredito = new NotaCreDebCap();
        notaCredito.setVenta(ventaCab);
        notaCredito.setAnulada(Boolean.FALSE);
        notaCredito.setCreado(new Date(System.currentTimeMillis()));
        //notaCredito.setFecEmision(new Date(System.currentTimeMillis()));
        notaCredito.setFecEmision(Date.from(fechaNotaCredito.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        notaCredito.setCreadoPor(persona);
        notaCredito.setAlmacen(ventaCab.getAlmacen());
        notaCredito.setNumero(notaLast==null?1:(notaLast.getNumero()+1));
        //notaCredito.setNumero(Services.getNotaCredito().getLastNumeroByAlmacenAndFacBol(ventaCab.getAlmacen().getId(), acronimoBoletaFactura(ventaCab.getNombreCortoDocumentoTipo())).getNumero()+1);
        notaCredito.setDocumentoTipo(Services.getDocumentoTipo().getById("7"));
        notaCredito.setCodMotivo(tipoNotaCredito);//Anulacion Total
        //notaCredito.setDesMotivo("Error en la Facturaicion");
        notaCredito.setDesMotivo(observaciones.getValue());
        notaCredito.setSumOtrosCargos(BigDecimal.ZERO);
        notaCredito.setMtoOperInafectas(BigDecimal.ZERO);
        notaCredito.setMtoOperexOneradas(BigDecimal.ZERO);
        notaCredito.setMtoISC(BigDecimal.ZERO);
        notaCredito.setMtoOtrosTributos(BigDecimal.ZERO);
        
        
        //notaCredito.setFirma(firma);
        notaCredito.setSerie(acronimoBoletaFactura(ventaCab.getNombreCortoDocumentoTipo()));
        notaCredito.setMtoOperGravadas(ventaCab.getSubtotal());
        notaCredito.setMtoIGV(ventaCab.getMontoImpuesto());
        notaCredito.setMtoImpVenta(ventaCab.getTotal());
        
        notaCredito.setObservaciones(result.Error);
        notaCredito.setAceptada_SUNAT(result.aceptadaSunat);
        notaCredito.setEnlacePdfNubefact(result.enlacePdf);
        notaCredito.setEnlaceXmlNubefact(result.enlaceXml);
        notaCredito.setDescripcion(result.sunatDescription);
        
        notaCredito = Services.getNotaCredito().save(notaCredito);
        
         for(int i=0; i<listDetalles.size(); i++)
        {
            NotaCreDebDet notaCreditoDetalle = new NotaCreDebDet();
            notaCreditoDetalle.setCreadoPor(persona);
            notaCreditoDetalle.setCreado(new Date(System.currentTimeMillis()));
            notaCreditoDetalle.setNotaCreDeb(notaCredito);
            notaCreditoDetalle.setPrecioUnitario(listDetalles.get(i).getPrecioUnitarioProducto());
            notaCreditoDetalle.setPrecioUnitarioVenta(listDetalles.get(i).getPrecioUnitarioVenta());
            notaCreditoDetalle.setPrecioVenta(listDetalles.get(i).getPrecioVenta());
            notaCreditoDetalle.setRegalo(Boolean.FALSE);
            notaCreditoDetalle.setProducto(listDetalles.get(i).getProducto());
            notaCreditoDetalle.setCantidad(listDetalles.get(i).getCantidad());
            
            Services.getNotaCredito().save(notaCreditoDetalle);
        }
        //notaCreditoDetalle
              
        ventaCab.setAnulada(Boolean.TRUE);
        Services.getArticulo().setVentaNull(String.valueOf(ventaCab.getId()));
        Services.getVentasCab().update(ventaCab);
        
        if (notaCredito.getSerie().equals("FN"))
            return notaCredito.getAceptada_SUNAT();
        else
            return true;
    }
    
    @Override
    public Mensaje onReenviarComprobante()
    {
        //SEND TO NUBEFACT API
        NotaPedidoCab notaPedido = Services.getOrdenVenta().getByVentaId(String.valueOf(gridComprobantes.asSingleSelect().getValue().getId()));
        VentaCab ventaCab = Services.getVentasCab().getById(String.valueOf(notaPedido.getVenta().getId()));
        
        ObjectNubefact object = new ObjectNubefact();
        
        object.local = notaPedido.getAlmacen().getId();
        object.operacion = "generar_comprobante";
        String nombreComprobante = "";
        int tipoComprobante;
        if (notaPedido.getDireccionCliente().getPersona().getDocumentoIdentidad().getId() == 4)//FACTURA ELSE OTRO DOCUMENTO
        {   
            object.tipo_de_comprobante = 1;
            tipoComprobante = 1;
            nombreComprobante = "Factura";
        }
        else{
            object.tipo_de_comprobante = 2;
            tipoComprobante = 3;
            nombreComprobante = "Boleta";
        }
       
        //VentaCab lastRegister = Services.getVentasCab().getLastNumeroByAlmacenAndFacBol(gridOrdenesVenta.asSingleSelect().getValue().getAlmacen().getId(), tipoComprobante);
        
        //object.serie = getSerie(comboTipoComprobante.getValue().getNombre(), String.valueOf(lastRegister.getSerie()+1));
        object.serie = getSerie(nombreComprobante, String.valueOf(ventaCab.getSerie()));
        
        object.numero = ventaCab.getNumero();
        object.sunat_transaction = 1;
        object.cliente_tipo_de_documento = Integer.valueOf(String.valueOf(notaPedido.getDireccionCliente().getPersona().getDocumentoIdentidad().getAdditional_account()));//Listo
        object.cliente_numero_de_documento = notaPedido.getDireccionCliente().getPersona().getIdentificador().trim();//Listo
        object.cliente_denominacion = notaPedido.getDireccionCliente().getPersona().getNombre();//Listo
        object.cliente_direccion = notaPedido.getDireccionCliente().getDescripcion();//Listo
        object.cliente_email =  notaPedido.getDireccionCliente().getEmail();//Listo
        //object.fecha_de_emision = new Date(System.currentTimeMillis());
        object.fecha_de_emision = ventaCab.getFecha();
		
        object.moneda = notaPedido.getMoneda().getId();//Listo
        object.porcentaje_de_igv = 18.00;
        object.total = notaPedido.getTotal();//Listo
        //object.total_igv = notaPedido.getTotal().multiply(BigDecimal.valueOf(0.18));//Listo
        //object.total_gravada = object.total.add(object.total_igv.negate());
        object.total_gravada = object.total.divide(BigDecimal.valueOf(1.18), 2, RoundingMode.HALF_UP);
        object.total_igv = object.total.add(object.total_gravada.negate());
        object.detraccion = false;//Listo
        object.enviar_automaticamente_a_la_sunat = true;//Listo
        object.enviar_automaticamente_al_cliente = false;//Listo
        
         /*Nubefact Detalles*/
        
        List<Detalle_ObjectNubefact> detalles = new ArrayList<>();
        
        System.out.println("Serie: "+object.serie);
        System.out.println("TOTAL"+object.total);
        System.out.println("TOTAL IGV: "+object.total_igv);
        System.out.println(object.total_gravada);
        
        //List<VentaDet> listDetalles = Services.getVentasCab().listByIdCabecera(String.valueOf(ventaCab.getId()));
        List<NotaPedidoDet> listNotasPedidoDetalles = Services.getOrdenVenta().listByIdCabecera(notaPedido.getId());
        for(int i=0; i<listNotasPedidoDetalles.size(); i++)
        {
            if (!listNotasPedidoDetalles.get(i).getRegalo())
            {
                Detalle_ObjectNubefact detalle = new Detalle_ObjectNubefact();


                detalle.codigo_producto_sunat = listNotasPedidoDetalles.get(i).getProducto().getCod_sunat();//Listo
                detalle.descripcion = listNotasPedidoDetalles.get(i).getProducto().getNombre();//Listo
                detalle.unidad_de_medida = "NIU";
                detalle.codigo = listNotasPedidoDetalles.get(i).getProducto().getCodigo();
                detalle.cantidad = listNotasPedidoDetalles.get(i).getCantidad();//Listo
                detalle.valor_unitario = listNotasPedidoDetalles.get(i).getPrecioUnitarioVenta().divide(BigDecimal.valueOf(1.18), 2, RoundingMode.HALF_UP);
                detalle.precio_unitario = listNotasPedidoDetalles.get(i).getPrecioUnitarioVenta();
                detalle.total = detalle.precio_unitario.multiply(listNotasPedidoDetalles.get(i).getCantidad());
                detalle.subtotal = detalle.total.divide(BigDecimal.valueOf(1.18), 2, RoundingMode.HALF_UP);
                detalle.igv = detalle.total.add(detalle.subtotal.negate());
                //detalle.igv = detalle.total.multiply(BigDecimal.valueOf(0.18));
                //detalle.subtotal = detalle.total.add(detalle.igv.negate());
                detalle.tipo_de_igv = 1;
                //detalle.subtotal = listNotasPedidoDetalles.get(i).getSubtotal();
                //detalle.total = listNotasPedidoDetalles.get(i).get.getTotal();
                //detalle.igv = listNotasPedidoDetalles.get(i).getIgv();
                detalle.anticipo_regularizacion = false;//Listo
                detalles.add(detalle);

                System.out.println(detalle.cantidad);
                System.out.println(detalle.precio_unitario);
                System.out.println("TOTAL: "+detalle.total);
                System.out.println("IGV: "+detalle.igv);
                System.out.println(detalle.subtotal);
            }
        }
            
        object.Detalle = detalles;
        
        Nubefact_Comprobantes nubefact = new Nubefact_Comprobantes();
        
        ObjectNubefact result = nubefact.apiConsume(object);
        nubefact.apiConsume(object);
        
        System.out.println(">>"+result.aceptadaSunat);
        System.out.println(">>"+result.enlacePdf);
        System.out.println(">>"+result.enlaceXml);
        System.out.println(">>"+result.sunatDescription);
        System.out.println(">>"+result.Error);
        //END NUBEFACT API
              
        ventaCab.setAceptadaSunat(result.aceptadaSunat);
        ventaCab.setEnlacePdf(result.enlacePdf);
        ventaCab.setEnlaceXml(result.enlaceXml);
        ventaCab.setSunatDescription(result.sunatDescription);
        Services.getVentasCab().update(ventaCab);
        
        Mensaje mensaje = new Mensaje();
        
        if(result.aceptadaSunat != null){
                        
            if((result.aceptadaSunat && nombreComprobante.equals("Factura")) || nombreComprobante.equals("Boleta")){
                
                ventaCab.setAnulada(Boolean.FALSE);
                mensaje.setTipo(true);
                mensaje.setMensaje("SE GENERO EN NUBEFACT SATISFACTORIAMENTE");
                UI.getCurrent().getPage().executeJs("window.open(\""+ventaCab.getEnlacePdf()+"\");");
            }
            else{
                ventaCab.setAnulada(Boolean.TRUE);
                mensaje.setTipo(false);
                mensaje.setMensaje(result.Error);
            }
        }
        else{
                ventaCab.setAnulada(Boolean.TRUE);
                mensaje.setTipo(false);
                mensaje.setMensaje(result.Error);
            }
    
         //UI.getCurrent().getPage().executeJs("window.open(\"https://www.nubefact.com/cpe/28342f0a-3155-4161-8295-e88a6f61af07-c3efa051-0462-4219-82ff-c9f1a09a1d5b.pdf\");");
        
        return mensaje;  
    }
    
    @Override
    public Mensaje anularComprobante(){
        VentaCab ventaCab = Services.getVentasCab().getById(String.valueOf(String.valueOf(gridComprobantes.asSingleSelect().getValue().getId())));
        
        ObjectNubefact object = new ObjectNubefact();
        
        object.operacion = "generar_anulacion";
        int tipoComprobante;
        String nombreComprobante = "";
        if (ventaCab.getDireccionCliente().getPersona().getDocumentoIdentidad().getId() == 4)//FACTURA ELSE OTRO DOCUMENTO
        {   
            object.tipo_de_comprobante = 1;
            tipoComprobante = 1;
            nombreComprobante = "Factura";
        }
        else{
            object.tipo_de_comprobante = 2;
            tipoComprobante = 3;
            nombreComprobante = "Boleta";
        }
        object.local = ventaCab.getAlmacen().getId();
        object.serie = getSerie(nombreComprobante, String.valueOf(ventaCab.getSerie()));
        object.numero = ventaCab.getNumero();
        object.motivo = txtMotivo.getValue();
        
        Nubefact_Anulacion nubefact = new Nubefact_Anulacion();

        ObjectNubefact result = nubefact.apiConsume(object);
        nubefact.apiConsume(object);
        
        System.out.println(">>"+result.aceptadaSunat);
        System.out.println(">>"+result.enlacePdf);
        System.out.println(">>"+result.enlaceXml);
        System.out.println(">>"+result.sunatDescription);
        System.out.println(">>"+result.Error);
        
        Mensaje mensaje = new Mensaje();
        
        if(result.aceptadaSunat != null){
                        
            if((result.aceptadaSunat && (nombreComprobante.equals("Factura") || nombreComprobante.equals("Boleta")))){
                
                
                mensaje.setTipo(true);
                mensaje.setMensaje("SE ANULO EL COMPROBANTE SATISFACTORIAMENTE");
                
                ventaCab.setAnulada(Boolean.TRUE);
                ventaCab.setEnlaceAnuladoPdf(result.enlacePdf);
                ventaCab.setEnlaceAnuladoXml(result.enlaceXml);
                Services.getVentasCab().update(ventaCab);
                Services.getArticulo().setVentaNull(String.valueOf(ventaCab.getId()));
                UI.getCurrent().getPage().executeJs("window.open(\""+ventaCab.getEnlacePdf()+"\");");
            }
            else{
                
                mensaje.setTipo(false);
                mensaje.setMensaje(result.Error);
            }
        }
        else{                
                mensaje.setTipo(false);
                mensaje.setMensaje(result.Error);
            }
    
         //UI.getCurrent().getPage().executeJs("window.open(\"https://www.nubefact.com/cpe/28342f0a-3155-4161-8295-e88a6f61af07-c3efa051-0462-4219-82ff-c9f1a09a1d5b.pdf\");");
        
        return mensaje;  
    }
    
    
    @Override
    public boolean existeNotaCredito()
    {
        if(Services.getNotaCredito().getByIdVenta(String.valueOf(gridComprobantes.asSingleSelect().getValue().getId())) != null)
            return true;
        else
            return false;
    }
    
    @Override
    public boolean onValidarFecha()
    {
        if (LocalDate.now().isBefore(fechaNotaCredito.getValue()))
            return false;
        
        VentaCab ventaCab = Services.getVentasCab().getById(String.valueOf(gridComprobantes.asSingleSelect().getValue().getId()));        
        
        
        //if(ventaCab.getFecha().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().isAfter(fechaNotaCredito.getValue()))
        if(ventaCab.getFecha().after(Date.from(fechaNotaCredito.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant())))
            return false;
        
        return true;
    }
    
    public String getSerieModifica(String tipoDocumento, String serie)
    {
        int longitud = 3-serie.length();
        for(int i=0; i<longitud; i++)
        {
            serie = "0"+serie;
        }
        
        if(tipoDocumento.equals("Factura"))
            serie = "F"+serie;
        else
            serie = "B"+serie;
        
        return serie;
    }
    
    public String getSerieNota(String tipoDocumento, String serie)
    {
        int longitud = 2-serie.length();
        for(int i=0; i<longitud; i++)
        {
            serie = "0"+serie;
        }
        
        if(tipoDocumento.equals("Factura"))
            serie = "FN"+serie;
        else
            serie = "BN"+serie;
        
        return serie;
    }
    
    public String getSerie(String tipoDocumento, String serie)
    {
        int longitud = 3-serie.length();
        for(int i=0; i<longitud; i++)
        {
            serie = "0"+serie;
        }
        
        if(tipoDocumento.equals("Factura"))
            serie = "F"+serie;
        else
            serie = "B"+serie;
        
        return serie;
    }
    
    public String acronimoBoletaFactura(String nombreDocumento)
    {
        if(nombreDocumento.equals("Factura"))
           return "FN";
        else
            return "BN";              
    }
}
