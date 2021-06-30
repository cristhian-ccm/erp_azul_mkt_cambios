/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.view.ordenventa;

import com.upgrade.persistence.model.cmrlz.NotaPedidoCab;
import com.upgrade.persistence.model.cmrlz.NotaPedidoDet;
import com.upgrade.persistence.model.cmrlz.VentaCab;
import com.upgrade.persistence.model.cmrlz.VentaDet;
import com.upgrade.persistence.model.extcs.Almacen;
import com.upgrade.persistence.model.fnnzs.Recibo;
import com.upgrade.persistence.model.tcros.Persona;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import up.erp.service.Services;
import up.erp.view.App;
import up.erp.view.comprobantes.Nubefact_Comprobantes;
import com.upgrade.persistence.model.ventas.Detalle_ObjectNubefact;
import com.upgrade.persistence.model.ventas.ObjectNubefact;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Anchor;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.logging.Level;
import java.util.logging.Logger;
import up.erp.view.produccion.Mensaje;

/**
 *
 * @author Diego Javier Quispe
 */
public class OrdenVentaView extends OrdenVentaUI {
    
    public App app;
    public Persona persona = Services.getPersona().getOnePersona();
    
    public OrdenVentaView(App app) {
        this.app = app;
        List<Almacen> listAlmacenes = Services.getAlmacen().listByAbreviatura();
        cmbAlmacen.setItems(listAlmacenes);
        cmbAlmacen.setValue(listAlmacenes.get(0));
        this.onGetOrdenesVenta();
    }
    
    @Override
    public void onGetOrdenesVenta()
    {
        //List<NotaPedidoCab> comprobantes = Services.getOrdenVenta().listByFechaDesdeHastaOrAndSerieOrAndNumero(fechaDesde.getValue(), fechaHasta.getValue(), buscarByNumero.getValue());
        List<NotaPedidoCab> comprobantes = Services.getOrdenVenta().listByFechaDesdeHastaOrAndSerieOrAndNumeroAndAlmacen(fechaDesde.getValue(), fechaHasta.getValue(), String.valueOf(cmbAlmacen.getValue().getId()), buscarByNumero.getValue());
//        List<NotaCreDebCap> comprobantes = Services.getNotaCredito().listByFechaDesdeHastaOrAndSerieOrAndNumero(LocalDate.MIN, LocalDate.MIN, numero).listByFecha(fechaDesde.getValue(), fechaHasta.getValue());
        gridOrdenesVenta.setItems(comprobantes);
        
    }   
    
    
    @Override
    public void onGetTiposComprobante()
    {
        List<TipoComprobante> listTipoComprobante = new ArrayList<>();
        TipoComprobante tipoComprobante = new TipoComprobante();
        tipoComprobante.setId(3);
        tipoComprobante.setNombre("Boleta");
        listTipoComprobante.add(tipoComprobante);
        
        tipoComprobante = new TipoComprobante();
        tipoComprobante.setId(1);
        tipoComprobante.setNombre("Factura");
        listTipoComprobante.add(tipoComprobante);
        
        comboTipoComprobante.setItems(listTipoComprobante);
        
    }
    
    @Override
    public Mensaje onGenerarComprobanteUpdate()
    {
        //SEND TO NUBEFACT API
        NotaPedidoCab notaPedido = Services.getOrdenVenta().getById(String.valueOf(gridOrdenesVenta.asSingleSelect().getValue().getId()));
     
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
       
        VentaCab lastRegister = Services.getVentasCab().getLastNumeroByAlmacenAndFacBol(gridOrdenesVenta.asSingleSelect().getValue().getAlmacen().getId(), tipoComprobante);
        
        //object.serie = getSerie(comboTipoComprobante.getValue().getNombre(), String.valueOf(lastRegister.getSerie()+1));
        object.serie = getSerie(nombreComprobante, String.valueOf(lastRegister.getSerie()));
        
        object.numero = lastRegister.getNumero()+1;
        object.sunat_transaction = 1;
        object.cliente_tipo_de_documento = Integer.valueOf(String.valueOf(notaPedido.getDireccionCliente().getPersona().getDocumentoIdentidad().getAdditional_account()));//Listo
        object.cliente_numero_de_documento = notaPedido.getDireccionCliente().getPersona().getIdentificador();//Listo
        object.cliente_denominacion = notaPedido.getDireccionCliente().getPersona().getNombre();//Listo
        object.cliente_direccion = notaPedido.getDireccionCliente().getDescripcion();//Listo
        object.cliente_email =  notaPedido.getDireccionCliente().getEmail();//Listo
        object.fecha_de_emision = new Date(System.currentTimeMillis());
		
        object.moneda = notaPedido.getMoneda().getId();//Listo
        object.porcentaje_de_igv = 18.00;
        object.total = notaPedido.getTotal();//Listo
        //object.total_igv = notaPedido.getTotal().multiply(BigDecimal.valueOf(0.18));//Listo
        //object.total_gravada = object.total.add(object.total_igv.negate());
        object.total_gravada = object.total.divide(BigDecimal.valueOf(1.18), 2, RoundingMode.HALF_UP);;
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
        List<NotaPedidoDet> listNotasPedidoDetalles = Services.getOrdenVenta().listByIdCabecera(gridOrdenesVenta.asSingleSelect().getValue().getId());
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
        
        String numeroDocumet = "asda";
        System.out.println(">>"+result.aceptadaSunat);
        System.out.println(">>"+result.enlacePdf);
        System.out.println(">>"+result.enlaceXml);
        System.out.println(">>"+result.sunatDescription);
        System.out.println(">>"+result.Error);
        //END NUBEFACT API
        
        Mensaje mensaje = new Mensaje();
        
        //GENERAR SOLO SI NUBEFACT ACEPTA
        VentaCab ventaCab = new VentaCab();
        
        ventaCab.setAlmacen(gridOrdenesVenta.asSingleSelect().getValue().getAlmacen());     
        //ventaCab.setDocumentoTipo(Services.getDocumentoTipo().getById(String.valueOf(comboTipoComprobante.getValue().getId())));
        ventaCab.setDocumentoTipo(Services.getDocumentoTipo().getById(String.valueOf(tipoComprobante)));
        if(ventaCab.getAlmacen().getId() == 18){
          ventaCab.setSerie(14);  
        }
        else{
            if(ventaCab.getAlmacen().getId() == 3){
                ventaCab.setSerie(14);  
            }
            else
                ventaCab.setSerie(1);  

        }

        ventaCab.setNumero(lastRegister.getNumero()+1);
        ventaCab.setDireccionCliente(gridOrdenesVenta.asSingleSelect().getValue().getDireccionCliente());
        ventaCab.setVendedor(gridOrdenesVenta.asSingleSelect().getValue().getVendedor());
        ventaCab.setMoneda(gridOrdenesVenta.asSingleSelect().getValue().getMoneda());
        ventaCab.setObservaciones(gridOrdenesVenta.asSingleSelect().getValue().getObservaciones());

        ventaCab.setTotal(gridOrdenesVenta.asSingleSelect().getValue().getTotal());
        ventaCab.setSubtotal(gridOrdenesVenta.asSingleSelect().getValue().getTotal().multiply(BigDecimal.valueOf(0.18)));
        ventaCab.setMontoImpuesto(ventaCab.getTotal().add(ventaCab.getSubtotal().negate()));
        ventaCab.setDiasCredito(gridOrdenesVenta.asSingleSelect().getValue().getDiasCredito());
        ventaCab.setMontoCobrar(gridOrdenesVenta.asSingleSelect().getValue().getTotal());
        //ventaCab.setEmpresa(1);
        ventaCab.setEmpresa(Services.getEmpresa().getById(1));
        ventaCab.setCreadoPor(1);
        ventaCab.setImpuesto(Services.getImpuesto().getById(2));//IGV
        ventaCab.setFormaPago(Services.getFormaPago().getById(notaPedido.getFormaPago().getId()));
        ventaCab.setFecha(new Date(System.currentTimeMillis()));
        ventaCab.setOrdenCompraCliente("");
        ventaCab.setDescuento(BigDecimal.ZERO);
        ventaCab.setAnulada(Boolean.FALSE);
        
        ventaCab.setAceptadaSunat(result.aceptadaSunat);
        ventaCab.setEnlacePdf(result.enlacePdf);
        ventaCab.setEnlaceXml(result.enlaceXml);
        ventaCab.setSunatDescription(result.sunatDescription);
        
        //ventaCab.setObservaciones(nombreComprobante);
        
        /* System.out.println(">>"+result.aceptadaSunat);
        System.out.println(">>"+result.enlacePdf);
        System.out.println(">>"+result.enlaceXml);
        System.out.println(">>"+result.sunatDescription);
        System.out.println(">>"+result.Error);*/
        //new Date(System.currentTimeMillis()
        //ventaCab = Services.getVentasCab().save(ventaCab);

        List<VentaDet> detallesVenta = new ArrayList<>();
        //List<NotaPedidoDet> listNotasPedidoDetalles = Services.getOrdenVenta().listByIdCabecera(gridOrdenesVenta.asSingleSelect().getValue().getId());
        for(int i=0; i<listNotasPedidoDetalles.size(); i++)
        {
            VentaDet detalle = new VentaDet();
            //detalle.setIgv(BigDecimal.valueOf(0.18));
            detalle.setCantidad(listNotasPedidoDetalles.get(i).getCantidad());
            detalle.setCod_sunat(listNotasPedidoDetalles.get(i).getProducto().getCod_sunat());
            detalle.setDescripcion(listNotasPedidoDetalles.get(i).getProducto().getNombre());
            detalle.setExonerado(Boolean.FALSE);
            detalle.setPrecioUnitarioProducto(listNotasPedidoDetalles.get(i).getPrecioUnitarioProducto());
            detalle.setPrecioUnitarioVenta(listNotasPedidoDetalles.get(i).getPrecioUnitarioVentaReal());
            detalle.setPrecioVenta(listNotasPedidoDetalles.get(i).getPrecioUnitarioVenta());
            detalle.setProducto(listNotasPedidoDetalles.get(i).getProducto());
            detalle.setRegalo(listNotasPedidoDetalles.get(i).getRegalo());
            detalle.setTipo_de_igv(1);
            detalle.setTotal(detalle.getPrecioVenta());
            detalle.setIgv(detalle.getPrecioVenta().multiply(BigDecimal.valueOf(0.18)));
            detalle.setSubtotal(detalle.getTotal().add(detalle.getIgv().negate()));
            detalle.setUnidad_de_medida("NIU");
            detalle.setUtilidad(BigDecimal.valueOf(0.18));
            //detalle.setVenta(ventaCab);
            detalle.setCreado(1);
            detallesVenta.add(detalle);
            //Services.getVentasCab().saveDetalle(detalle);
        }
        
        
        /*if(result.aceptadaSunat != null){
                        
            if((result.aceptadaSunat && nombreComprobante.equals("Factura")) || nombreComprobante.equals("Boleta")){
                
                ventaCab.setAnulada(Boolean.FALSE);
                mensaje.setTipo(true);
                mensaje.setMensaje("SE GENERO EL COMPROBANTE SATISFACTORIAMENTE");
                UI.getCurrent().getPage().executeJs("window.open(\""+ventaCab.getEnlacePdf()+"\");");
            }
            else{
                ventaCab.setAnulada(Boolean.TRUE);
                mensaje.setTipo(false);
                mensaje.setMensaje(result.Error);
            }
        }
        else{
                //ventaCab.setAnulada(Boolean.TRUE);
                mensaje.setTipo(false);
                mensaje.setMensaje(result.Error);
            }*/
        
        try {
            ventaCab = Services.getVentasCab().save(ventaCab, detallesVenta);
            //if(!ventaCab.getAnulada())
            Services.getArticulo().setVentaIdInOrdenVenta(notaPedido.getId(), ventaCab.getId());
        } catch (Exception ex) {
            Logger.getLogger(OrdenVentaView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
         //UI.getCurrent().getPage().executeJs("window.open(\"https://www.nubefact.com/cpe/28342f0a-3155-4161-8295-e88a6f61af07-c3efa051-0462-4219-82ff-c9f1a09a1d5b.pdf\");");
        
        return mensaje;  
         
    }
    
    
    @Override
    public Mensaje onReenviarComprobante()
    {
        //SEND TO NUBEFACT API
        NotaPedidoCab notaPedido = Services.getOrdenVenta().getById(String.valueOf(gridOrdenesVenta.asSingleSelect().getValue().getId()));
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
        object.cliente_numero_de_documento = notaPedido.getDireccionCliente().getPersona().getIdentificador();//Listo
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
        List<NotaPedidoDet> listNotasPedidoDetalles = Services.getOrdenVenta().listByIdCabecera(gridOrdenesVenta.asSingleSelect().getValue().getId());
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
        
    @Override
    public Mensaje onComprobantePagado()
    {
        Mensaje mensaje = new Mensaje();
        NotaPedidoCab notaPedido = Services.getOrdenVenta().getById(String.valueOf(gridOrdenesVenta.asSingleSelect().getValue().getId()));
        
        if(notaPedido.getFormaPago().getEfectivo())
        {
            BigDecimal totalPago = Services.getRecibos().sumRecibosByOrden(String.valueOf(notaPedido.getId()));
            if(notaPedido.getTotal().equals(totalPago))
            {
                mensaje.setTipo(true);
                mensaje.setMensaje("La orden esta pagada");                                
            }
            else{
                mensaje.setTipo(false);
                mensaje.setMensaje("La orden aun no ha sido pagada");                                
            }
            
        }
        else{
            if (notaPedido.getAprobadoCredito())
            {
                mensaje.setTipo(true);
                mensaje.setMensaje("El credito esta aprobado");
            }
            else{
                mensaje.setTipo(false);
                mensaje.setMensaje("EL credito no esta aprobado");
            }
        }
        return mensaje;
    }     
    
    @Override
    public Anchor onLoadComprobante()
    {
        Anchor anchor = new Anchor();
        //Anchor anchor = new Anchor("",new Button("", VaadinIcon.FILE_TEXT.create()));    
        anchor.setHref("https://www.nubefact.com/cpe/28342f0a-3155-4161-8295-e88a6f61af07-c3efa051-0462-4219-82ff-c9f1a09a1d5b.pdf");
        anchor.setTarget("_blank");
        return anchor;
    }
            
}
