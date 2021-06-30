package up.erp.server.serviceimpl;


import com.upgrade.persistence.model.Moneda;
import com.upgrade.persistence.model.cmrlz.NotaPedidoCab;
import com.upgrade.persistence.model.cmrlz.NotaPedidoDet;
import com.upgrade.persistence.model.cmrlz.VentaCab;
import com.upgrade.persistence.model.extcs.Almacen;
import com.upgrade.persistence.model.extcs.Producto;
import com.upgrade.persistence.model.lgstc.OrdenCDet;
import com.upgrade.persistence.model.lgstc.SolicitudCompra;
import com.upgrade.persistence.model.tcros.Direccion;
import com.upgrade.persistence.model.tcros.Persona;
import com.upgrade.persistence.model.unidad_negocio.UnidadNegocio;
import ts.com.service.util.db.ObjectDB;
import ts.com.service.util.db.Query;
import ts.com.service.util.db.Update;
import ts.com.service.util.db.server.CRUD;
import up.erp.service.NotaPedidoService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class NotaPedidoServiceImpl implements NotaPedidoService {
    
    @Override
    public void save(NotaPedidoCab cabecera, List<NotaPedidoDet> detalles) throws Exception {
        try {            
            Update.beginTransaction();
            Update update = new Update();
            update.save(cabecera);            
            update = new Update();
            for (NotaPedidoDet item : detalles) {
                item.notaPedido = cabecera;
                CRUD.save(item);
            }  
            Update.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            Update.rollbackTransaction();
            throw new Exception(e.getMessage());
        }
    }
        @Override
    public void update(NotaPedidoCab cabecera) throws Exception {
        Update update = new Update();
        update.update(cabecera);
    }

    @Override
    public void update(NotaPedidoCab cabecera, Direccion direcion) throws Exception {
        try {
            Update.beginTransaction();
            Update update = new Update("id", "vendedor","editado","editadoPor");
            update.update(cabecera);
            if (direcion != null) {
                update = new Update("id", "vendedor","editado","editadoPor");
                update.update(direcion);
            }
            Update.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            Update.rollbackTransaction();
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void updateFormaPago(NotaPedidoCab cabecera) throws Exception {
        try {
            Update.beginTransaction();
            Update update = new Update("id", "formaPago","diasCredito","aprobadoCredito");
            update.update(cabecera);            
            Update.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            Update.rollbackTransaction();
            throw new Exception(e.getMessage());
        }
    }
    
    @Override
    public void anularOrdenVenta(NotaPedidoCab cabecera) throws Exception {
      try {
            Update.beginTransaction();
            Update update = new Update("id", "anulada","observaciones");
            update.update(cabecera);            
            Update.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            Update.rollbackTransaction();
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void grabarCambioProducto(NotaPedidoCab notaPedidoCab, NotaPedidoDet notaPedidoDet) throws Exception {
        try {
            Update.beginTransaction();
            Update update = new Update();
            update.update(notaPedidoDet);
            update = new Update();
            if (notaPedidoCab != null) {                
                notaPedidoCab.aprobada = false;
                update.update(notaPedidoCab);
            }
            Update.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            Update.rollbackTransaction();
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<NotaPedidoCab> getNotaPedidoCabByDireccionCliente(int direccionId) throws Exception {
        Query q = new Query();
        ObjectDB npc = q.getNewObjectDB(NotaPedidoCab.class, "npc");
        q.select.add(npc);
        q.from.add(npc);
        q.where = "where npc.anulada is false and direccion_cliente_id = " + direccionId;
        q.end  = "order by npc.fecha desc";
        Object[][] rs= q.initResultSet();
        List<NotaPedidoCab> list = new ArrayList<>();
        if(rs!=null){
            for(int i = 0; i < rs.length ; i++){
                NotaPedidoCab notaPedido = (NotaPedidoCab)npc.getNewObject(i);
                list.add(notaPedido);
            }
        }        
        return list;
    }

    @Override
    public List<NotaPedidoCab> getListNotasPedidoCab2016() throws Exception {
        Query q = new Query();
        ObjectDB npc = q.getNewObjectDB(NotaPedidoCab.class, "npc");
        q.select.add(npc);
        q.from.add(npc);
        q.where = "where npc.anulada is false "
                + "and npc.fecha>='2016-01-01' and npc.fecha <='2016-12-31'";
        q.end  = "order by npc.fecha asc";
        Object[][] rs= q.initResultSet();
        List<NotaPedidoCab> list = new ArrayList<>();
        if(rs!=null){
            for(int i = 0; i < rs.length ; i++){
                NotaPedidoCab notaPedido = (NotaPedidoCab)npc.getNewObject(i);
                list.add(notaPedido);
            }
        }        
        return list;
    } 

    @Override
    public List<NotaPedidoDet> getProductosVendidosByCliente(int direccionId) throws Exception {
        String filters ="where npc.direccion_cliente_id = "+direccionId +
                        " and npc.anulada is false order by npc.fecha asc";
        String[] required = {
            "notaPedido as npc",
            "notaPedido.venta as ven",
            "notaPedido.venta.documentoTipo as doc",
            "producto as pro"
        };
        return CRUD.list(NotaPedidoDet.class, required, filters);
    }
    
    @Override
    public List<NotaPedidoCab> getListNotasPedidoCabMesCurso(String fechaInicio, String fechaFinal) throws Exception {
        Query q = new Query();
        ObjectDB npc = q.getNewObjectDB(NotaPedidoCab.class, "npc");
        q.select.add(npc);
        q.from.add(npc);
        q.where = "where npc.anulada is false "
                + "and npc.fecha>='" + fechaInicio + "' and npc.fecha <='"+ fechaFinal + "'";
        q.end  = "order by npc.fecha asc";
        Object[][] rs= q.initResultSet();
        List<NotaPedidoCab> list = new ArrayList<>();
        if(rs!=null){
            for(int i = 0; i < rs.length ; i++){
                NotaPedidoCab notaPedido = (NotaPedidoCab)npc.getNewObject(i);
                list.add(notaPedido);
            }
        }        
        return list;
    }

    @Override
    public List<NotaPedidoCab> getTotalSalesByYearSoles(int anio) throws Exception {
        String fechaInicio = anio+"-01-01";
        String fechaFin = anio+"-12-31";
        Query q = new Query();
        ObjectDB npc = q.getNewObjectDB(NotaPedidoCab.class, "npc","total");
        q.select.add(npc);
        q.from.add(npc);
        q.where = "where npc.anulada is false "
                + " and npc.moneda_id = 1"
                + " and npc.fecha >= '" + fechaInicio + "'"
                + " and npc.fecha <= '" + fechaFin + "'";              
        q.end = "order by npc.fecha asc";
        Object[][] rs = q.initResultSet();
        List<NotaPedidoCab> list = new ArrayList<>();
        if (rs != null) {
            for (int i = 0; i < rs.length; i++) {
                NotaPedidoCab notaPedido = (NotaPedidoCab) npc.getNewObject(i);
                list.add(notaPedido);
            }
        }
        return list;
    }

    @Override
    public List<NotaPedidoCab> getTotalSalesByYearDollars(int anio) throws Exception {
        String fechaInicio = anio + "-01-01";
        String fechaFin = anio + "-12-31";
        Query q = new Query();
        ObjectDB npc = q.getNewObjectDB(NotaPedidoCab.class, "npc", "fecha","total");
        q.select.add(npc);
        q.from.add(npc);
        q.where = "where npc.anulada is false "
                + " and npc.moneda_id = 2"
                + " and npc.fecha >= '" + fechaInicio + "'"
                + " and npc.fecha <= '" + fechaFin + "'";
        q.end = "order by npc.fecha asc";
        Object[][] rs = q.initResultSet();
        List<NotaPedidoCab> list = new ArrayList<>();
        if (rs != null) {
            for (int i = 0; i < rs.length; i++) {
                NotaPedidoCab notaPedido = (NotaPedidoCab) npc.getNewObject(i);
                list.add(notaPedido);
            }
        }
        return list;
    }

    @Override
    public List<NotaPedidoCab> getTotalSalesByPOSSoles(int almacen, String fechaInicio, String fechaFinal) throws Exception {
        
        Query q = new Query();
        ObjectDB npc = q.getNewObjectDB(NotaPedidoCab.class, "npc","vendedor","total");
        q.select.add(npc);
        q.from.add(npc);
        q.where = "where npc.anulada is false and npc.almacen_id = " + almacen
                + " and npc.moneda_id = 1"
                + " and npc.fecha >= '" + fechaInicio + "'"
                + " and npc.fecha <= '" + fechaFinal + "'";       
        Object[][] rs = q.initResultSet();
        List<NotaPedidoCab> list = new ArrayList<>();
        if (rs != null) {
            for (int i = 0; i < rs.length; i++) {
                NotaPedidoCab notaPedido = (NotaPedidoCab) npc.getNewObject(i);
                list.add(notaPedido);
            }
        }
        return list;    
    }

    @Override
    public List<NotaPedidoCab> getTotalSalesByPOSDollars(int almacen, String fechaInicio, String fechaFinal) throws Exception {
        Query q = new Query();
        ObjectDB npc = q.getNewObjectDB(NotaPedidoCab.class, "npc","fecha","vendedor","total");
        q.select.add(npc);
        q.from.add(npc);
        q.where = "where npc.anulada is false and npc.almacen_id = " + almacen
                + " and npc.moneda_id = 2"
                + " and npc.fecha >= '" + fechaInicio + "'"
                + " and npc.fecha <= '" + fechaFinal + "'";       
        Object[][] rs = q.initResultSet();
        List<NotaPedidoCab> list = new ArrayList<>();
        if (rs != null) {
            for (int i = 0; i < rs.length; i++) {
                NotaPedidoCab notaPedido = (NotaPedidoCab) npc.getNewObject(i);
                list.add(notaPedido);
            }
        }
        return list;    
    }

    @Override
    public List<NotaPedidoDet> getNotaPedidoDetTopProductos(int almacenId, int top, Date fecIni, Date fecFin) throws Exception {
        /*Query q = new Query();
        q.select.set("select npd.producto_id, sum(npd.cantidad) as cantidad");
        q.from.set("from cmrlz.notas_pedido_det as npd");
        q.join.add("left join cmrlz.notas_pedido_cab as npc on npc.id = npd.nota_pedido_id");
        q.where = "where npc.almacen_id = " + almacenId + " and npc.fecha >='" + fecIni.toString() + "' and npc.fecha <='" + fecFin.toString() + "'";
        q.end = "group by npd.producto_id order by cantidad desc limit " + top;
        Object[][] rs = q.initResultSet();
        List<ProductoDetArticulosModel> list = new ArrayList<>();
        if (rs != null) {
            for (int i = 0; i < rs.length; i++) {
                ProductoDetArticulosModel pdam = new ProductoDetArticulosModel();
                pdam.productoDet = (ProductoDet) pd.getNewObject(i);
                pdam.productoDet.impuesto = (Impuesto) imp.getNewObject(i);
                pdam.productoDet.percepcion = (Percepcion) per.getNewObject(i);
                pdam.productoDet.producto = (Producto) p.getNewObject(i);
                pdam.totalArticulos = ((Long) rs[i][q.index - 1]).intValue();
                pdam.precioSoles = getPrecioSoles(pdam, tipoCambioVenta);
                list.add(pdam);
            }
        }
        return list;*/
return null;
    }

    @Override
    public List<NotaPedidoCab> getTotalSalesByPOSSoles(int almacen, Date fechaInicio, Date fechaFinal) throws Exception {
        Query q = new Query();
        ObjectDB npc = q.getNewObjectDB(NotaPedidoCab.class, "npc", "vendedor", "total");
        q.select.add(npc);
        q.from.add(npc);
        q.where = "where npc.anulada is false and npc.almacen_id = " + almacen
                + " and npc.moneda_id = 1"
                + " and npc.fecha >= '" + fechaInicio + "'"
                + " and npc.fecha <= '" + fechaFinal + "'";
        Object[][] rs = q.initResultSet();
        List<NotaPedidoCab> list = new ArrayList<>();
        if (rs != null) {
            for (int i = 0; i < rs.length; i++) {
                NotaPedidoCab notaPedido = (NotaPedidoCab) npc.getNewObject(i);
                list.add(notaPedido);
            }
        }
        return list;  
    }

    @Override
    public List<NotaPedidoCab> getTotalSalesByPOSDollars(int almacen, Date fechaInicio, Date fechaFinal) throws Exception {
        Query q = new Query();
        ObjectDB npc = q.getNewObjectDB(NotaPedidoCab.class, "npc","fecha","vendedor","total");
        q.select.add(npc);
        q.from.add(npc);
        q.where = "where npc.anulada is false and npc.almacen_id = " + almacen
                + " and npc.moneda_id = 2"
                + " and npc.fecha >= '" + fechaInicio + "'"
                + " and npc.fecha <= '" + fechaFinal + "'";       
        Object[][] rs = q.initResultSet();
        List<NotaPedidoCab> list = new ArrayList<>();
        if (rs != null) {
            for (int i = 0; i < rs.length; i++) {
                NotaPedidoCab notaPedido = (NotaPedidoCab) npc.getNewObject(i);
                list.add(notaPedido);
            }
        }
        return list; 
    }

    @Override
    public List<NotaPedidoDet> getOrdendesPendientesDescarga(int almacenId, Date fechaInicial, Date fechaFinal) throws Exception {
        List<NotaPedidoDet> list = new ArrayList<>();
        String[] required = new String[]{
            "notaPedido as npc",
            "notaPedido.unidadNegocioId as un",
            "notaPedido.direccionCliente as dir",
            "notaPedido.direccionCliente.persona as per",
            "notaPedido.vendedor as ven",
            "notaPedido.almacen as al",
            "producto as pro",
            
        };
        String filter = "where npc.almacen_id = " + almacenId + " and npc.fecha >= '" + fechaInicial + "'"
                + " and npc.fecha <= '" + fechaFinal + "' and npd.entrega_completa is false"
                + " order by npc.numero desc";
        list = CRUD.list(NotaPedidoDet.class, required, filter);
        return list;
    }

    @Override
    public List<NotaPedidoDet> getDetallesOV(int notaPedidoId) throws Exception {
        List<NotaPedidoDet> list = new ArrayList<>();
        String[] required = new String[]{
            "notaPedido as npc",
            "notaPedido.almacen as al",
            "notaPedido.direccionCliente as dir",
            "notaPedido.direccionCliente.persona as cli",
            "producto as p"
        };
        String filter = "where npc.id = " + notaPedidoId + " and npd.entrega_completa is false";
        list = CRUD.list(NotaPedidoDet.class, required, filter);
        return list;
    }

    @Override
    public List<NotaPedidoDet> getDetallesOrdenVentaByNumero(int numOrdenVenta, int almacenId) throws Exception {
        Query q = new Query();
        ObjectDB npdet = q.getNewObjectDB(NotaPedidoDet.class, "npd");
        ObjectDB npcab = q.getNewObjectDB(NotaPedidoCab.class, "npc");
        ObjectDB ven = q.getNewObjectDB(Persona.class, "p", "id", "nombre");
        ObjectDB prod = q.getNewObjectDB(Producto.class, "pro", "id", "codigo", "nombre");
        ObjectDB alm = q.getNewObjectDB(Almacen.class, "al", "id", "nombre");
        ObjectDB moneda = q.getNewObjectDB(Moneda.class, "m", "id");
        q.select.add(npdet).add(npcab).add(ven).add(prod).add(alm).add(moneda);
        q.from.add(npdet);
        q.join.add(npcab, npdet, "notaPedido");
        q.join.add(prod, npdet, "producto");
        q.join.add(ven, npcab, "vendedor");
        q.join.add(alm, npcab, "almacen");
        q.join.add(moneda, npcab, "moneda");        
        q.where = "where npc.numero = " + numOrdenVenta + " and npc.anulada is false and npc.almacen_id = " + almacenId +" and npd.cantidad_entregada = 0 and npc.venta_id is null";
        q.end = " order by npd.id asc";
        Object[][] rs = q.initResultSet();
        List<NotaPedidoDet> list = new ArrayList<>();
        if (rs != null) {
            for (int i = 0; i < rs.length; i++) {
                NotaPedidoDet notaDet = (NotaPedidoDet) npdet.getNewObject(i);
                notaDet.producto = (Producto) prod.getNewObject(i);
                notaDet.notaPedido = (NotaPedidoCab) npcab.getNewObject(i);
                notaDet.notaPedido.vendedor = (Persona) ven.getNewObject(i);
                notaDet.notaPedido.almacen = (Almacen) alm.getNewObject(i);
                notaDet.notaPedido.moneda = (Moneda) moneda.getNewObject(i);
                list.add(notaDet);
            }
        }
        return list; 
    }

    @Override
    public List<NotaPedidoDet> getNotaPedidoDetByAlmacenAndDate(Date fechaInicial, Date fechaFinal, int almacenId) throws Exception {
        Query q = new Query();
        ObjectDB npd = q.getNewObjectDB(NotaPedidoDet.class, "npd", "id", "editadoPor", "notaPedido", "regalo", "producto", "productoCambio", "cantidad", "precioUnitarioProducto", "precioUnitarioNota", "cantidadEntregada", "entregaCompleta", "precioUnitarioVentaReal", "precioUnitarioVenta");
        ObjectDB npc = q.getNewObjectDB(NotaPedidoCab.class, "npc");
        ObjectDB vendedor = q.getNewObjectDB(Persona.class, "v", "id", "nombre");
        ObjectDB almacen = q.getNewObjectDB(Almacen.class, "al", "id", "nombre");
        ObjectDB unidadN = q.getNewObjectDB(UnidadNegocio.class, "un", "id", "nombre");
        ObjectDB direcccion = q.getNewObjectDB(Direccion.class, "dir", "id", "nombre", "persona", "descripcion", "telefono");
        ObjectDB cliente = q.getNewObjectDB(Persona.class, "cli", "id", "nombre", "identificador");
        ObjectDB venta = q.getNewObjectDB(VentaCab.class, "ven");
        ObjectDB moneda = q.getNewObjectDB(Moneda.class, "m", "id", "inactivo", "nombre","simbolo");
        ObjectDB prod = q.getNewObjectDB(Producto.class, "pro", "id", "codigo", "nombre", "regalo", "servicio");
        q.select.add(npd).add(npc).add(vendedor).add(almacen).add(unidadN).add(direcccion).add(cliente).add(venta).add(moneda).add(prod);
        q.from.add(npd);
        q.join.add(npc, npd, "notaPedido");
        q.join.add(prod, npd, "producto");
        q.join.add(vendedor, npc, "vendedor");
        q.join.add(almacen, npc, "almacen");
        q.join.add(unidadN, npc, "unidadNegocioId");
        q.join.add(venta, npc, "venta");
        q.join.add(moneda, npc, "moneda");
        q.join.add(direcccion, npc, "direccionCliente");
        q.join.add(cliente, direcccion, "persona");        
        q.where = "where npc.almacen_id = " + almacenId + " and npc.fecha >= '" + fechaInicial + "'" + " and npc.fecha <= '" + fechaFinal + "'";
        q.end = " order by npc.numero desc";             
        Object[][] rs = q.initResultSet();
        List<NotaPedidoDet> list = new ArrayList<>();
        if (rs != null) {
            for (int i = 0; i < rs.length; i++) {
                NotaPedidoDet notaDet = (NotaPedidoDet) npd.getNewObject(i);
                notaDet.notaPedido = (NotaPedidoCab) npc.getNewObject(i);
                notaDet.producto = (Producto) prod.getNewObject(i);
                notaDet.notaPedido.vendedor = (Persona) vendedor.getNewObject(i);
                notaDet.notaPedido.almacen = (Almacen) almacen.getNewObject(i);
                notaDet.notaPedido.venta = (VentaCab) venta.getNewObject(i);
                notaDet.notaPedido.moneda = (Moneda) moneda.getNewObject(i);
                notaDet.notaPedido.unidadNegocioId = (UnidadNegocio) unidadN.getNewObject(i);
                notaDet.notaPedido.direccionCliente = (Direccion) direcccion.getNewObject(i);
                notaDet.notaPedido.direccionCliente.persona = (Persona) cliente.getNewObject(i);
                list.add(notaDet);
            }
        }
        return list;        
        
    }

    @Override
    public List<NotaPedidoDet> getDetallesByUtilidadOV(int notaPedidoId) throws Exception {
        Query q = new Query();
        ObjectDB npd = q.getNewObjectDB(NotaPedidoDet.class, "npd", "id", "cantidad", "notaPedido", "precioUnitarioVentaReal", "precioUnitarioNota");
        ObjectDB npc = q.getNewObjectDB(NotaPedidoCab.class, "npc", "id");
        q.select.add(npd).add(npc);
        q.from.add(npd);
        q.join.add(npc, npd, "notaPedido");      
        q.where = "where npc.id = " + notaPedidoId;        
        Object[][] rs = q.initResultSet();
        List<NotaPedidoDet> list = new ArrayList<>();
        if (rs != null) {
            for (int i = 0; i < rs.length; i++) {
                NotaPedidoDet notaDet = (NotaPedidoDet) npd.getNewObject(i);
                list.add(notaDet);
            }
        }
        return list; 
    }

    @Override
    public List<NotaPedidoDet> getNotaPedidoDetPendientesDescarga(int almacenId, String nombreCliente, String numero) throws Exception {
        List<NotaPedidoDet> list = new ArrayList<>();
        Query q = new Query();
        ObjectDB npdet = q.getNewObjectDB(NotaPedidoDet.class, "npd","id","notaPedido","producto","cantidad","cantidadEntregada");
        ObjectDB npcab = q.getNewObjectDB(NotaPedidoCab.class, "npc");
        ObjectDB ven = q.getNewObjectDB(Persona.class, "v");
        ObjectDB almacen = q.getNewObjectDB(Almacen.class, "a");
        ObjectDB direccion = q.getNewObjectDB(Direccion.class, "dir","id","persona");
        ObjectDB cliente = q.getNewObjectDB(Persona.class, "cli","id","nombre","identificador");
        ObjectDB prod = q.getNewObjectDB(Producto.class, "p","id","codigo","nombre","servicio");
        ObjectDB solicitud = q.getNewObjectDB(SolicitudCompra.class, "s");
        ObjectDB ordenCDet = q.getNewObjectDB(OrdenCDet.class, "ocd");
        q.select.add(npdet).add(npcab).add(ven).add(almacen).add(direccion).add(cliente).add(prod).add(solicitud).add(ordenCDet);
        q.from.add(npdet);
        q.join.add(npcab, npdet, "notaPedido");
        q.join.add(prod, npdet, "producto"); 
        q.join.add(solicitud, npdet, "solicitudCompra");
        q.join.add(ordenCDet, solicitud, "ordenCompraDet");
        q.join.add(ven, npcab, "vendedor");        
        q.join.add(almacen, npcab, "almacen");
        q.join.add(direccion, npcab, "direccionCliente");
        q.join.add(cliente, direccion, "persona");
        String filter = "where npc.almacen_id = " + almacenId + " and npc.anulada is false and npc.aprobada is true and npc.aprobado_credito is true and npd.entrega_completa is false ";
        if (!nombreCliente.isEmpty()) {
            filter += " and cli.nombre ilike '%" + nombreCliente + "%' or  cli.identificador ilike '%" + nombreCliente + "%' ";
        }
        if (!numero.isEmpty()) {
            filter += " and npc.numero = " + numero;
        }
        q.where = filter;
        q.end = " order by npc.numero desc";
        Object[][] rs = q.initResultSet();
        if (rs != null) {
            for (int i = 0; i < rs.length; i++) {
                NotaPedidoDet notaDet = (NotaPedidoDet) npdet.getNewObject(i);
                notaDet.notaPedido = (NotaPedidoCab) npcab.getNewObject(i);
                notaDet.producto = (Producto) prod.getNewObject(i);
                notaDet.notaPedido.vendedor = (Persona) ven.getNewObject(i);
                notaDet.notaPedido.almacen = (Almacen) almacen.getNewObject(i);
                notaDet.notaPedido.direccionCliente = (Direccion) direccion.getNewObject(i);
                notaDet.notaPedido.direccionCliente.persona = (Persona) cliente.getNewObject(i);
                notaDet.solicitudCompra = (SolicitudCompra) solicitud.getNewObject(i);
                if (notaDet.solicitudCompra != null) {
                    if (notaDet.solicitudCompra.ordenCompraDet != null) {
                        notaDet.solicitudCompra.ordenCompraDet = (OrdenCDet) ordenCDet.getNewObject(i);
                    }
                }
                list.add(notaDet);
            }
        }
        return list;
    }

    @Override
    public List<NotaPedidoDet> getSoloDetallesOV(int notaPedidoId) throws Exception {
        List<NotaPedidoDet> list = new ArrayList<>();
        Query q = new Query();
        ObjectDB npdet = q.getNewObjectDB(NotaPedidoDet.class, "npd","id","notaPedido","producto","cantidad","cantidadEntregada","entregaCompleta");
        ObjectDB prod = q.getNewObjectDB(Producto.class, "p","id","codigo","nombre");
        q.select.add(npdet).add(prod);
        q.from.add(npdet);        
        q.join.add(prod, npdet, "producto");
        q.where = "where npd.nota_pedido_id = " + notaPedidoId + " and npd.entrega_completa is false ";
        q.end = " order by p.nombre asc";
        Object[][] rs = q.initResultSet();
        if (rs != null) {
            for (int i = 0; i < rs.length; i++) {
                NotaPedidoDet notaDet = (NotaPedidoDet) npdet.getNewObject(i);
                notaDet.producto = (Producto) prod.getNewObject(i);
                list.add(notaDet);
            }
        }
        return list;
    }
        
    @Override
    public VentaCab getListVentaCab(Integer id) throws Exception {
       Query q= new Query() ;
       ObjectDB vc= q.getNewObjectDB(VentaCab.class,"vc");
       q.select.add(vc);
       q.from.add(vc);
       q.where = "where vc.id= '"+id + "'";
       q.end= "order by vc.id";
        Object[][] rs = q.initResultSet(); 
        VentaCab npcTemp=(VentaCab)vc.getNewObject(0);
        return npcTemp;
    }
  
}
