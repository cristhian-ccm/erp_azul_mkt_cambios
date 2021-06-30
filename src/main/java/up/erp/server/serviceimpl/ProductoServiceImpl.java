/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.server.serviceimpl;

import com.upgrade.persistence.model.ecommerce.DirEntrega;
import com.upgrade.persistence.model.ecommerce.ImagenesProducto;
import com.upgrade.persistence.model.ecommerce.LineaEcomErp;
import com.upgrade.persistence.model.ecommerce.LineaEcommerce;
import com.upgrade.persistence.model.ecommerce.VProductoDetalle;
import com.upgrade.persistence.model.ecommerce.VStockPorLlegar;
import com.upgrade.persistence.model.extcs.Linea;
import com.upgrade.persistence.model.extcs.Marca;
import com.upgrade.persistence.model.extcs.Producto;
import com.upgrade.persistence.model.extcs.ProductoDet;
import com.upgrade.persistence.model.legal.Ubigeo;
import org.springframework.stereotype.Component;
import ts.com.service.util.db.Query;
import ts.com.service.util.db.server.CRUD;
import up.erp.service.ProductoService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author evanl
 */
@Component
public class ProductoServiceImpl implements ProductoService {
    

    @Override
    public List<Producto> list(boolean soloActivos) {
        List<Producto> result = new ArrayList<>();
        try {
            String where = soloActivos?"where inactivo is false ":"";
            result = CRUD.list(Producto.class,where);
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public List<Producto> listByNombre(String nombre) {
        List<Producto> result = new ArrayList<>();
        try {
            String where = "where nombre ilike '%"+nombre+"%' or descripcion ilike '%"+nombre+"%'";
            result = CRUD.list(Producto.class,where);
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public List<Producto> listByLinea(String linea){
        List<Producto> result = new ArrayList<>();
        try {
            String where = "where descripcion ilike '%"+linea+"%'";
            result = CRUD.list(Producto.class,where);
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    /* Retorna top lineas ultimos 3 meses */
    @Override
    public List<Linea> listTopLineas(int top) throws Exception {
        List<Linea> list = new ArrayList<>();
        Query query = new Query();
        String select = "select id, nombre, descripcion from extcs.lineas";
        query.select.set(select);
        query.where = "where id in (\n" +
                "    select linea_id\n" +
                "    from (\n" +
                "             select prod.linea_id, count(prod.linea_id) cantidad\n" +
                "             from cmrlz.notas_pedido_det notdet\n" +
                "                      join extcs.productos prod on prod.id = notdet.producto_id\n" +
                "                      left join extcs.lineas lin on lin.id = prod.linea_id\n" +
                "             where prod.regalo != true\n" +
                "               and prod.inactivo != true\n" +
                "               and lin.inactivo != true\n" +
                "               and prod.ecommerce = true\n" +
                "             group by prod.linea_id\n" +
                "             order by 2 desc\n" +
                "             limit \n" + top +
                "         ) as toplineas\n" +
                ")";
        query.end = "";

        Object[][] rs = query.initResultSet();

        if (rs.length == 0) {
            return list;
        }

        for (int i = 0; i < rs.length; i++) {
            Linea linea = new Linea();
            linea.setId((Integer) rs[i][0]);
            linea.setNombre((String) rs[i][1]);
            linea.setDescripcion((String) rs[i][2]);
            list.add(linea);
        }

        return list;
    }

    @Override
    public List<Producto> listProdPorLinea(int cod) {
        List<Producto> list = new ArrayList<>();

        Query query = new Query();
        String select = "select id, codigo, nombre, descripcion, modelo, linea_id, marca_id from ecommerce.v_productos_por_linea";
        query.select.set(select);
        query.where = "where linea_id = " + cod;
        query.end = "";
        try {
            Object[][] rs = query.initResultSet();

            if (rs.length == 0) {
                return list;
            }

            for (int i = 0; i < rs.length; i++) {
                Producto producto = new Producto();
                Linea linea = new Linea();
                Marca marca = new Marca();
                producto.setId((Integer) rs[i][0]);
                producto.setCodigo((String) rs[i][1]);
                producto.setNombre((String) rs[i][2]);
                producto.setDescripcion((String) rs[i][3]);
                producto.setModelo((String) rs[i][4]);
                linea.setId((Integer) rs[i][5]);
                producto.setLinea(linea);
                marca.setId((Integer) rs[i][6]);
                producto.setMarca(marca);
                list.add(producto);
            }
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    @Override
    public List<Marca> listMarcasPorLinea(int idLinea) {
        List<Marca> list = new ArrayList<>();

        Query query = new Query();
        String select = "select marca_id, nombre from ecommerce.v_marcas_por_linea";
        query.select.set(select);
        query.where = "where linea_id = " + idLinea;
        query.end = "";
        try {
            Object[][] rs = query.initResultSet();

            if (rs.length == 0) {
                return list;
            }

            for (int i = 0; i < rs.length; i++) {
                Marca marca = new Marca();
                marca.setId((Integer) rs[i][0]);
                marca.setNombre((String) rs[i][1]);
                list.add(marca);
            }
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }


    @Override
    public VProductoDetalle productoDetPorId(int id) {

        VProductoDetalle prodDet = new VProductoDetalle();

        Query query = new Query();
        String select = "select id, codigo, nombre, descripcion, linea, marca, pventa, pventa_old, stock, stockreal, stockprev, fecha_llegada, img1, img2, img3, limitcompra, promocion, nuevo from ecommerce.v_producto_detalle";
        query.select.set(select);
        query.where = "where id = " + id ;
        query.end = "";
        try {
            Object[][] rs = query.initResultSet();
            if (rs.length == 0) {
                return prodDet;
            }

            prodDet.setId((Integer) rs[0][0]);
            prodDet.setCodigo((String) rs[0][1]);
            prodDet.setNombre((String) rs[0][2]);
            prodDet.setDescripcion((String) rs[0][3]);
            prodDet.setLinea((String) rs[0][4]);
            prodDet.setMarca((String) rs[0][5]);
            prodDet.setPventa((BigDecimal) rs[0][6]);
            prodDet.setPventa_old((BigDecimal) rs[0][7]);
            prodDet.setStock(((Integer) rs[0][8]));
            prodDet.setStockreal(((Integer) rs[0][9]));
            prodDet.setStockprev(((Integer) rs[0][10]));
            prodDet.setFecha_llegada(((Date) rs[0][11]));
            prodDet.setImg1((String) rs[0][12]);
            prodDet.setImg2((String) rs[0][13]);
            prodDet.setImg3((String) rs[0][14]);
            prodDet.setLimitcompra((Integer) rs[0][15]);
            prodDet.setPromocion((Boolean) rs[0][16]);
            prodDet.setNuevo((Boolean) rs[0][17]);

        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return prodDet;
    }

    @Override
    public List<VProductoDetalle> productosDetPorIds(String ids) {
        List<VProductoDetalle> plist = new ArrayList<>();

        Query query = new Query();
        String select = "select id, codigo, nombre, descripcion, linea, marca, pventa, pventa_old, stock, img1, img2, img3, limitcompra, promocion, nuevo from ecommerce.v_producto_detalle";
        query.select.set(select);
        query.where = "where id IN (" + ids + ")";
        query.end = "";
        try {
            Object[][] rs = query.initResultSet();
            if (rs.length == 0) {
                return plist;
            }
            for (int i = 0; i < rs.length; i++) {
                VProductoDetalle prodDet = new VProductoDetalle();
                prodDet.setId((Integer) rs[i][0]);
                prodDet.setCodigo((String) rs[i][1]);
                prodDet.setNombre((String) rs[i][2]);
                prodDet.setDescripcion((String) rs[i][3]);
                prodDet.setLinea((String) rs[i][4]);
                prodDet.setMarca((String) rs[i][5]);
                prodDet.setPventa((BigDecimal) rs[i][6]);
                prodDet.setPventa_old((BigDecimal) rs[i][7]);
                prodDet.setStock((Integer) rs[i][8]);
                prodDet.setImg1((String) rs[i][9]);
                prodDet.setImg2((String) rs[i][10]);
                prodDet.setImg3((String) rs[i][11]);
                prodDet.setLimitcompra((Integer) rs[i][12]);
                prodDet.setCartCount(1);
                prodDet.setPromocion((Boolean) rs[i][13]);
                prodDet.setNuevo((Boolean) rs[i][14]);
                plist.add(prodDet);
            }

        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return plist;
    }

    @Override
    public BigDecimal precioActualProd(String id, String cantidad) {

        BigDecimal precioProd = new BigDecimal(0);
        Query query = new Query();
        String select = "select pventa * " + cantidad +" from ecommerce.v_producto_detalle";
        query.select.set(select);
        query.where = "where id = " + id;
        query.end = "";
        try {
            Object[][] rs = query.initResultSet();
            if (rs.length == 0) {
                return precioProd;
            }
            System.out.println( rs[0][0]);
            precioProd = (BigDecimal) rs[0][0];
            return precioProd;
//            return precioProd.multiply(new BigDecimal(100));

        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
return precioProd;
//        return precioProd.multiply(new BigDecimal(100));
    }

    @Override
    public List<VProductoDetalle> listProdPorLinea2(int id) {

        List<VProductoDetalle> list = new ArrayList<>();

        Query query = new Query();
        String select = "select id, codigo, nombre, descripcion, linea_id, linea, marca_id, marca, pventa, pventa_old, stock, stockreal, stockprev, fecha_llegada, img1, img2, img3, limitcompra, promocion, nuevo from ecommerce.v_producto_detalle";
        query.select.set(select);
        query.where = "where linea_id = " + id ;
        query.end = "";
        try {
            Object[][] rs = query.initResultSet();
            if (rs.length == 0) {
                return list;
            }

            for (int i = 0; i < rs.length; i++) {
                VProductoDetalle prodDet = new VProductoDetalle();
                prodDet.setId((Integer) rs[i][0]);
                prodDet.setCodigo((String) rs[i][1]);
                prodDet.setNombre((String) rs[i][2]);
                prodDet.setDescripcion((String) rs[i][3]);
                prodDet.setLinea_id((Integer) rs[i][4]);
                prodDet.setLinea((String) rs[i][5]);
                prodDet.setMarca_id((Integer) rs[i][6]);
                prodDet.setMarca((String) rs[i][7]);
                prodDet.setPventa((BigDecimal) rs[i][8]);
                prodDet.setPventa_old((BigDecimal) rs[i][9]);
                prodDet.setStock(((Integer) rs[i][10]));
                prodDet.setStockreal(((Integer) rs[i][11]));
                prodDet.setStockprev(((Integer) rs[i][12]));
                prodDet.setFecha_llegada(((Date) rs[i][13]));
                prodDet.setImg1(((String) rs[i][14]));
                prodDet.setImg2(((String) rs[i][15]));
                prodDet.setImg3(((String) rs[i][16]));
                prodDet.setLimitcompra((Integer) rs[i][17]);
                prodDet.setPromocion((Boolean) rs[i][18]);
                prodDet.setNuevo((Boolean) rs[i][19]);

                list.add(prodDet);
            }

        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    @Override
    public List<Ubigeo> listDepartamentos() {
        List<Ubigeo> list = new ArrayList<>();
        Query query = new Query();
        String select = "SELECT codigo, nombre, coddpto from ecommerce.v_departamentos";
        query.select.set(select);

        try {
            Object[][] rs = query.initResultSet();
            if (rs.length == 0) {
                return list;
            }

            for (int i = 0; i < rs.length; i++) {
                Ubigeo ubigeo = new Ubigeo();
                ubigeo.setCodigo((String) rs[i][0]);
                ubigeo.setNombre((String) rs[i][1]);
                ubigeo.setDepartamento((String) rs[i][2]);
                list.add(ubigeo);
            }

        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }
    @Override
    public Boolean validarDeliveryDepartamento(String cod) {

        Query query = new Query();
        String select = "SELECT codigo, nombre, coddpto from ecommerce.v_departamentos where coddpto = '" + cod + "' and activo_delivery = true";
        query.select.set(select);
        try {
            Object[][] rs = query.initResultSet();
            if (rs.length == 0) {
                return false;
            }
            return true;
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public Boolean validarDeliveryProvincia(String codprov) {
        Query query = new Query();
        String select = "SELECT codigo, nombre, coddpto from ecommerce.v_provincias";
        query.select.set(select);
        query.where = " where codprov = '" + codprov + "' and activo_delivery = true" ;
        try {
            Object[][] rs = query.initResultSet();
            if (rs.length == 0) {
                return false;
            }
            return true;
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public Boolean validarDeliveryDistrito(String coddist) {
        Query query = new Query();
        String select = "SELECT codigo, nombre, coddpto from ecommerce.v_distritos";
        query.select.set(select);
        query.where = " where coddist = '" + coddist + "' and activo_delivery = true" ;
        try {
            Object[][] rs = query.initResultSet();
            if (rs.length == 0) {
                return false;
            }
            return true;
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public List<Ubigeo> listProvinciasPorDep(String coddep) {
        List<Ubigeo> list = new ArrayList<>();
        Query query = new Query();
        String select = "SELECT codigo, coddpto, codprov, nombre from ecommerce.v_provincias";
        query.select.set(select);
        query.where = "where coddpto = '" + coddep + "'";
        query.end = "";
        try {
            Object[][] rs = query.initResultSet();
            if (rs.length == 0) {
                return list;
            }

            for (int i = 0; i < rs.length; i++) {
                Ubigeo ubigeo = new Ubigeo();
                ubigeo.setCodigo((String) rs[i][0]);
                ubigeo.setDepartamento((String) rs[i][1]);
                ubigeo.setProvincia((String) rs[i][2]);
                ubigeo.setNombre((String) rs[i][3]);
                list.add(ubigeo);
            }

        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    @Override
    public List<Ubigeo> listDistritosPorProv(String coddep, String codprov) {
        List<Ubigeo> list = new ArrayList<>();
        Query query = new Query();
        String select = "SELECT codigo, coddpto, codprov, coddist, nombre from ecommerce.v_distritos";
        query.select.set(select);
        query.where = "where coddpto = '" + coddep + "' and codprov ='" + codprov + "'";
        query.end = "";
        try {
            Object[][] rs = query.initResultSet();
            if (rs.length == 0) {
                return list;
            }

            for (int i = 0; i < rs.length; i++) {
                Ubigeo ubigeo = new Ubigeo();
                ubigeo.setCodigo((String) rs[i][0]);
                ubigeo.setDepartamento((String) rs[i][1]);
                ubigeo.setProvincia((String) rs[i][2]);
                ubigeo.setDistrito((String) rs[i][3]);
                ubigeo.setNombre((String) rs[i][4]);
                list.add(ubigeo);
            }

        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    @Override
    public int saveDirEntrega(DirEntrega dir) {
        Date date = new Date();
        dir.setCreado_por(0);
        dir.setActivo(true);
        dir.setCreacion(date);
        System.out.println(dir.toString());
        try {
            CRUD.save(dir);
            return 1;
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public List<VProductoDetalle> listProdSearch(String key) {
        List<VProductoDetalle> list = new ArrayList<>();

        Query query = new Query();
        String select = "select id, nombre from ecommerce.v_producto_detalle";
        query.select.set(select);
        query.where = "where search_field ilike '%" + key + "%'";
        query.end = "";
        try {
            Object[][] rs = query.initResultSet();
            if (rs.length == 0) {
                return list;
            }
            for (int i = 0; i < rs.length; i++) {
                VProductoDetalle prodDet = new VProductoDetalle();
                prodDet.setId((Integer) rs[i][0]);
                prodDet.setNombre((String) rs[i][1]);
                list.add(prodDet);
            }

        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }
    
    //-----------------------------------------STOCK REAL-----------------------------------------------
    /*
    @Override
    public Integer getStockReal(String codigo) {
//        Producto prod = getByCodigo(codigo);
//        Integer prod_id = prod.getId();
        int almacen_min = 1;
        int almacen_max = 18;
        Integer StockReal = 0;
        Query query = new Query();
        String select = "select COUNT(producto_id) from extcs.articulos";
        query.select.set(select);
        query.where = "where producto_id = " + codigo + " and almacen_id between " + almacen_min + " and " + almacen_max ;
        query.end = "";
        try {
            Object[][] rs = query.initResultSet();
            if (rs.length == 0) {
                return StockReal;
            }
            /*
            for (int i = 0; i < rs.length; i++) {
                StockReal = (Integer) rs[i][0]; 
            }
            *//*
             StockReal = ((Long) rs[0][0]).intValue();
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return StockReal;
    }*/
    
    @Override
    public Integer getStockReal(String codigo) {
        int almacen_min = 1;
        int almacen_max = 100;
        Integer StockReal = 0;
        Query query = new Query();
        String select = "select COUNT(ar.producto_id) from extcs.articulos ar";
        query.select.set(select);
        //query.where = "where ar.producto_id = " + codigo + "  and ar.inactivo is false and al.id between " + almacen_min + " and " + almacen_max ;
        query.where = "where ar.producto_id = '" + codigo + "' and ar.almacen_id in (1,2,3,7,10,18)";
        query.end = "";
        try {
            Object[][] rs = null; 
            rs = query.initResultSet();
            if (rs != null || rs.length == 0){
                StockReal = ((Long) rs[0][0]).intValue();
            }
            else {
                StockReal = 0;
            }
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return StockReal;
    }
    
    
    //--------------------------------------STOCK PREVENTA-----------------------------------------------
    
    /*
    @Override
    public Integer getStockPreVenta(String codigo) {
        Integer cantidad = 0;
        BigDecimal cant;
        Integer cantidad_entregada = 0;
        BigDecimal cant_entreg;
        Integer StockPreVenta = 0;
        //Consulta Cantidad
        Query query = new Query();
        String select = "select sum(cantidad),sum(cantidad_entregada) from cmrlz.notas_pedido_det";
        query.select.set(select);
        query.where = "where producto_id = " + codigo;
        query.end = "";
        try {
            Object[][] rs = query.initResultSet();
            //Object[][] rs2 = query2.initResultSet();
            if (rs.length == 0){
                return StockPreVenta;
            }
            //cantidad = ((Long) rs[0][0]).intValue();
            //cantidad_entregada = ((Long) rs[0][1]).intValue();
            cant = (BigDecimal) rs[0][0];
            cantidad = Integer.valueOf(cant.intValue());
            System.out.println("STOCK PREVENTA SERVICE");
            System.out.println("Cantidad: " + cantidad);
            cant_entreg = (BigDecimal) rs[0][1];
            cantidad_entregada = Integer.valueOf(cant_entreg.intValue());
            System.out.println("Cantidad Entregada: " + cantidad_entregada);
            //Calculando StockPreVenta
            if (cantidad >= cantidad_entregada)
                StockPreVenta = cantidad - cantidad_entregada;
            else
                StockPreVenta = 0;
            System.out.println("Result: " + StockPreVenta);
            System.out.println("STOCK PREVENTA SERVICE - END");
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return StockPreVenta;
    }
    */
    
    @Override
    public Integer getStockPreVenta(String codigo) {
        Integer cantidad = 0;
        BigDecimal cant;
        Integer cantidad_entregada = 0;
        BigDecimal cant_entreg;
        Integer StockPreVenta = 0;
        //Consulta Cantidad
        Query query = new Query();
        String select = "select sum(npd.cantidad),sum(npd.cantidad_entregada) from cmrlz.notas_pedido_det npd \n" +
                        "left join cmrlz.notas_pedido_cab npc on npd.nota_pedido_id = npc.id";
        query.select.set(select);
        //query.where = "where npd.producto_id = '" + codigo + "' and npd.entrega_completa is false and \n" +
        //              "npc.anulada is false and npc.almacen_id is not NULL and npc.almacen_id between 1 and  100";
        query.where = "where npd.producto_id = '" + codigo + "' and npd.entrega_completa is false and \n" +
                      "npc.anulada is false and npc.almacen_id is not NULL and npc.almacen_id in (1,2,3,10,18)";
        query.end = "";
        try {
            Object[][] rs = null; 
            rs = query.initResultSet();
            if (rs[0][0] != null || rs[0][1] != null){
                System.out.println("STOCK PREVENTA SERVICE");
                if(rs[0][0] != null){
                    cant = (BigDecimal) rs[0][0];
                    cantidad = Integer.valueOf(cant.intValue());
                    System.out.println("Cantidad: " + cantidad);
                }
                else {
                    cantidad = 0;
                }
                if(rs[0][1] != null){
                    cant_entreg = (BigDecimal) rs[0][1];
                    cantidad_entregada = Integer.valueOf(cant_entreg.intValue());
                    System.out.println("Cantidad Entregada: " + cantidad_entregada);
                }
                else {
                    cantidad_entregada = 0;
                }
                //Calculando StockPreVenta
                if (cantidad >= cantidad_entregada) {StockPreVenta = cantidad - cantidad_entregada;}
                else                                {StockPreVenta = 0;}
                System.out.println("Result: " + StockPreVenta);
                System.out.println("STOCK PREVENTA SERVICE - END");
            }
            else {
                StockPreVenta = 0;
            }
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return StockPreVenta;
    }
    
    //----------------------------VALIDACION STOCK DISPONIBLE--------------------------------------------
    
    @Override
    public Boolean validarStockParaVenta(String codigo, Integer cantidad) {
        //Get Values
        Integer StockReal = getStockReal(codigo);
        System.out.println("StockReal:" + StockReal);
        Integer StockPreVenta = getStockPreVenta(codigo);
        System.out.println("StockPreVenta:" + StockPreVenta);
        VStockPorLlegar StockPorLlegar = new VStockPorLlegar();
        StockPorLlegar = getStockParaVentaPorLlegar(codigo);
        System.out.println("StockPorLlegar:" + StockPorLlegar.getCantidad_por_llegar());
        
        //Calculate StockDisponible
        Integer StockDisponible = 0;
        Integer StockAdded = 0;
        
        //Añadir StockPorLlegar a StockAdded
        if(StockPorLlegar.getCantidad_por_llegar() == null) {
            StockAdded = StockReal + 0;
        }
        else {
            StockAdded = StockReal + StockPorLlegar.getCantidad_por_llegar();
        }
        
        //Restar StockPreVenta
        if(StockAdded >= StockPreVenta)  {
            StockDisponible = StockAdded - StockPreVenta;
        }
        else {
            StockDisponible = 0;
        }
        
        
        //Validacion
        Boolean result = false;
        if(StockDisponible >= cantidad){
            result = Boolean.TRUE;
        }
        else {
            result = Boolean.FALSE;
        }
        return result;
    }
    
    //------------------------------------STOCK POR LLEGAR----------------------------------------------
    
    @Override
    public VStockPorLlegar getStockParaVentaPorLlegar(String codigo) {
        VStockPorLlegar StockPorLlegar = new VStockPorLlegar();
        Date date = new Date();
        Integer cantidad = 0;
        BigDecimal cant;
        //StockPorLlegar.cantidad_por_llegar = 0;
        //StockPorLlegar.fecha_llegada = date;
        
        //Consulta Cantidad StockPorLlegar
        Query query = new Query();
        String select = "select ocd.producto_id,max(oc.fecha_llegada),sum(ocd.cantidad) from lgstc.orden_compra as oc\n"+
                        "left join lgstc.orden_compra_det as ocd on oc.id = ocd.orden_compra_id";
        
        query.select.set(select);
        query.where = "where ocd.producto_id = '" + codigo + "' and oc.aprobada is true and oc.fecha_llegada + 1 >= current_date\n" +
                      "group by ocd.producto_id";
        query.end = "";
        try {
            Object[][] rs = null; 
            rs = query.initResultSet();
            if (rs != null){
                //Calculando StockPreVenta
                StockPorLlegar = new VStockPorLlegar();
                date = (Date) rs[0][1];
                StockPorLlegar.setFecha_llegada(date);
                //cantidad = ((Long) rs[0][1]).intValue();
                cant = (BigDecimal) rs[0][2];
                cantidad = Integer.valueOf(cant.intValue());
                StockPorLlegar.setCantidad_por_llegar(cantidad);
            }
            else {
                StockPorLlegar = new VStockPorLlegar();
                date = new Date();
                cantidad = 0;
                StockPorLlegar.setFecha_llegada(date);
                StockPorLlegar.setCantidad_por_llegar(cantidad);
            }
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return StockPorLlegar;
    }
    
    //Productos Ecommerce
    @Override
    public Producto getByCodigo(String codigo) {
        Producto result = new Producto();
        LineaEcommerce linea_ecom = new LineaEcommerce();
        try {
            String where = "where a.codigo = '"+codigo+"' limit 1";
            String[] require = {"linea_ecom"};
            List<Producto> list = CRUD.list(Producto.class,require,where);
            if(!list.isEmpty()){
                result = list.get(0);
                if(result.getLinea_ecom() == null){
                    linea_ecom = new LineaEcommerce();
                    linea_ecom.setNombre("No definida");
                    result.setLinea_ecom(linea_ecom);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    @Override
    public List<Producto> listByNombre_Ecom(String nombre) {
        List<Producto> result = new ArrayList<>();
        LineaEcommerce linea_ecom = new LineaEcommerce();
        try {
            String where = "where (a.inactivo is false and a.ecommerce is true) and (a.nombre ilike '%"+nombre+"%' or a.descripcion ilike '%"+nombre+"%') limit 1000";
            String [] require = {"linea_ecom"};
            result = CRUD.list(Producto.class,require,where);
            for (int i=0; i < result.size(); i++){
                if(result.get(i).getLinea_ecom() == null){
                    linea_ecom = new LineaEcommerce();
                    linea_ecom.setNombre("No definida");
                    result.get(i).setLinea_ecom(linea_ecom);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    //Productos No-Ecommerce
    @Override
    public List<Producto> listByNombre_NoEcom(String nombre) {
        List<Producto> result = new ArrayList<>();
        LineaEcommerce linea_ecom = new LineaEcommerce();
        try {
            String where = "where (a.inactivo is false and a.ecommerce is false) and (a.nombre ilike '%"+nombre+"%' or a.descripcion ilike '%"+nombre+"%') limit 1000";
            String [] require = {"linea_ecom"};
            result = CRUD.list(Producto.class,require,where);
            for (int i=0; i < result.size(); i++){
                if(result.get(i).getLinea_ecom() == null){
                    linea_ecom = new LineaEcommerce();
                    linea_ecom.setNombre("No definida");
                    result.get(i).setLinea_ecom(linea_ecom);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    @Override
    public void saveProd(Producto prod) {
        try {
            CRUD.save(prod);
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteProd(Producto prod) {
        try {
            CRUD.delete(prod);
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateProd(Producto prod) {
        try {
            CRUD.update(prod);
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Producto> listAllProd(boolean soloActivos) {
        List<Producto> result = new ArrayList<>();
        try {
            String where = soloActivos?"where inactivo is false ":" limit 10";
            //String [] require = {"nombre"};
            result = CRUD.list(Producto.class,where);
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public List<Producto> listAll_Prod_tipo(boolean soloActivos) {
        List<Producto> result = new ArrayList<>();
        try {
            String where = soloActivos?"where inactivo is false ":" limit 10";
            String [] require = {"productoTipo"};
            result = CRUD.list(Producto.class,require,where);
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public List<Producto> listAll_Marca(boolean soloActivos) {
        List<Producto> result = new ArrayList<>();
        try {
            String where = soloActivos?"where inactivo is false ":" limit 10";
            String [] require = {"marca"};
            result = CRUD.list(Producto.class,require,where);
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public List<Producto> listAll_Unidad(boolean soloActivos) {
        List<Producto> result = new ArrayList<>();
        try {
            String where = soloActivos?"where inactivo is false ":" limit 10";
            String [] require = {"unidad"};
            result = CRUD.list(Producto.class,require,where);
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public List<Producto> listAll_Linea(boolean soloActivos) {
        List<Producto> result = new ArrayList<>();
        try {
            String where = soloActivos?"where inactivo is false ":" limit 10";
            String [] require = {"linea"};
            result = CRUD.list(Producto.class,require,where);
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    @Override
    public Producto update(Producto producto)
    {
        //PlantillaTransformacion plantilla = new PlantillaTransformacion();
        try {
            //CRUD.save(newPlantilla); 
            CRUD.update(producto);
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return producto;
    }

    @Override
    public Producto getById(String id) {
        Producto result = null;
        try {
            String where = "where id = '"+id+"' limit 1";
            List<Producto> list = CRUD.list(Producto.class,where);
            if(!list.isEmpty()){
                result = list.get(0);
            }    
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    
    @Override
    public Producto getByIdWithMarca(String id) {
        Producto result = null;
        try {
            String where = "where a.id = '"+id+"' limit 1";
            String[] require = {"marca"};
            List<Producto> list = CRUD.list(Producto.class,require,where);
            if(!list.isEmpty()){
                result = list.get(0);
            }    
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    @Override
    public List<Producto> listByCodigo(String codigo) {
        List<Producto> result = new ArrayList<>();
        try {
            String where = "where (a.inactivo is false and a.ecommerce is true) and a.codigo ilike '%"+codigo+"%' or a.descripcion ilike '%"+codigo+"%' limit 1000";
            result = CRUD.list(Producto.class,where);
            
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
      @Override
    public List<Producto> listByCodigoOrDescripcion(String codigo) {
        List<Producto> result = new ArrayList<>();
        try {
            String where = "where (a.inactivo is false) and a.codigo ilike '%"+codigo+"%' or a.descripcion ilike '%"+codigo+"%' limit 1000";
            result = CRUD.list(Producto.class,where);
            
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    @Override
    public Producto findByNombre(String nombre){
        Producto result = new Producto();
        LineaEcommerce linea_ecom = new LineaEcommerce();
        try {
            String where = "where (a.inactivo is false and a.ecommerce is true) and a.nombre ilike '%"+nombre+"%' limit 1";
            String [] require = {"linea_ecom"};
            //result = CRUD.list(Producto.class,require,where);
            List<Producto> list = CRUD.list(Producto.class,require,where);
            if(!list.isEmpty()){
                result = list.get(0);
                if(result.getLinea_ecom() == null){
                    linea_ecom = new LineaEcommerce();
                    linea_ecom.setNombre("No definida");
                    result.setLinea_ecom(linea_ecom);
                }
            }    
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public List<LineaEcommerce> listLineaEcom() {
        List<LineaEcommerce> list_result = new ArrayList<>();
        try {
            String where = "order by id asc limit 100";
            list_result = CRUD.list(LineaEcommerce.class,where);
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list_result;
    }

    @Override
    public LineaEcommerce get_ByLineaEcom_nombre(String nombre) {
        LineaEcommerce linea_ecom = new LineaEcommerce();
        try {
            String where = "where nombre ilike '%"+nombre+"%' or descripcion ilike '%"+nombre+"%' limit 1";
            List<LineaEcommerce> list = CRUD.list(LineaEcommerce.class,where);
            if(!list.isEmpty()){
                linea_ecom = list.get(0);
            }    
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return linea_ecom;
    }

    @Override
    public List<Producto> listProd_ByLineaEcom(String linea) {
        List<Producto> result = new ArrayList<>();
        String linea_ecom_id = "";
        LineaEcommerce linea_ecom = new LineaEcommerce();
        
        //Encuentra LineaEcommerce id
        linea_ecom = get_ByLineaEcom_nombre(linea);
        linea_ecom_id = String.valueOf(linea_ecom.getId());
        
        //Busca Productos agrupados en esa Linea Ecommerce
        try {
            String where = "where (a.inactivo is false and a.ecommerce is true) and a.linea_ecom_id = "+linea_ecom_id+" limit 1000";
            String [] require = {"linea_ecom"};
            result = CRUD.list(Producto.class,require,where);
            for (int i=0; i < result.size(); i++){
                if(result.get(i).getLinea_ecom() == null){
                    linea_ecom = new LineaEcommerce();
                    linea_ecom.setNombre("No definida");
                    result.get(i).setLinea_ecom(linea_ecom);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    //----------------------------------------------------------------------------------------------
    public List<Linea> get_LineaERP_byLEcom(String linea_ecom){
        List<Linea> list_result = new ArrayList<>();
        try {
            String where = "where b.nombre ilike '%"+linea_ecom+"%' or b.descripcion ilike '%"+linea_ecom+"%'";
            list_result = CRUD.list(Linea.class,where);
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list_result;
    }
    //----------------------------------------------------------------------------------------------
    public List<LineaEcomErp> get_LineasERPECOM_byLineaEcom(Integer linea_ecom_id){
        List<LineaEcomErp> list_LERP_LECOM = new ArrayList<>();
        LineaEcommerce l_ecom = new LineaEcommerce();
        Linea l_erp = new Linea();
        try {
            String where = "where a.linea_ecom_id = "+linea_ecom_id+"";
            String [] require = {"linea_ecom","linea_erp"};
            list_LERP_LECOM = CRUD.list(LineaEcomErp.class,require,where);
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list_LERP_LECOM;
    }
    //----------------------------------------------------------------------------------------------
    @Override
    public List<Producto> listProd_ByLineaEcom2(String linea) {
        List<Producto> result = new ArrayList<>();
        List<Producto> final_list = new ArrayList<>();
        List<LineaEcomErp> list_lineaERP = new ArrayList<>();
        String linea_ecom_id = "";
        LineaEcommerce linea_ecom = new LineaEcommerce();
        Integer lineaERP_id;
        
        //Encuentra LineaEcommerce id
        linea_ecom = get_ByLineaEcom_nombre(linea);
        linea_ecom_id = String.valueOf(linea_ecom.getId());
        
        //Encuentra Lineas ERP asociadas a una Linea Ecommerce
        list_lineaERP = get_LineasERPECOM_byLineaEcom(linea_ecom.getId());
        
        //Busca Productos agrupados en esa Lineas ERP
        final_list = new ArrayList<>();
        for(int i = 0; i < list_lineaERP.size(); i++){
            try {
                //Get id Linea ERP
                lineaERP_id = list_lineaERP.get(i).linea_erp.getId();
                String where = "where (a.inactivo is false and a.ecommerce is true) and a.linea_id = "+lineaERP_id+" limit 1000";
                String [] require = {"linea_ecom"};
                result = CRUD.list(Producto.class,require,where);
                if(result != null){
                    for (int j=0; j < result.size(); j++){
                        if(result.get(j).getLinea_ecom() == null){
                            linea_ecom = new LineaEcommerce();
                            linea_ecom.setNombre("No definida");
                            result.get(j).setLinea_ecom(linea_ecom);
                        }
                        final_list.add(result.get(j));
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return final_list;
    }
    //----------------------------------------------------------------------------------------------
    @Override
    public ProductoDet get_ProdDet(String id_prod){
        ProductoDet prod_det = new ProductoDet();
        try {
            String where = "where a.inactivo is false and a.producto_id = '"+id_prod+"' limit 1";
            List<ProductoDet> result = CRUD.list(ProductoDet.class,where);
            if(!result.isEmpty())
                prod_det = new ProductoDet();
                prod_det = result.get(0);
        }
        catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return prod_det;
    }    
    //----------------------------------------------------------------------------------------------
    @Override
    public List<ImagenesProducto> get_ImgProducto(String id_prod){
        List<ImagenesProducto> list_imgProducto = new ArrayList<>();
        try {
            String where = "where a.producto_id = '"+id_prod+"'";
            String [] require = {"producto"};
            list_imgProducto = CRUD.list(ImagenesProducto.class,require,where);
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list_imgProducto;
    }
    //----------------------------------------------------------------------------------------------
    @Override
    public void save_ImgProducto(ImagenesProducto img_prod){
        try {
            CRUD.save(img_prod);
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //----------------------------------------------------------------------------------------------
    @Override
    public void delete_ImgProducto(ImagenesProducto img_prod){
        try {
            CRUD.delete(img_prod);
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //----------------------------------------------------------------------------------------------
    @Override
    public void update_ImgProducto(ImagenesProducto img_prod){
        try {
            CRUD.update(img_prod);
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //----------------------------------------------------------------------------------------------
    @Override
    public ImagenesProducto get_ImgProducto_byUrl(String id_prod, String url_img){
        ImagenesProducto img_prod = new ImagenesProducto();
        List<ImagenesProducto> list_imgProducto = new ArrayList<>();
        try {
            String where = "where a.producto_id = '"+id_prod+"' and a.url_imagen = '"+url_img+"' limit 1";
            String [] require = {"producto"};
            list_imgProducto = CRUD.list(ImagenesProducto.class,require,where);
            if(!list_imgProducto.isEmpty()){
                img_prod = new ImagenesProducto();
                img_prod = list_imgProducto.get(0);
            }
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return img_prod;
    }
    
    //---------------------------------------------FRONT----------------------------------------------
    public void quickSort(int arr[], int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
    }
    //-----------------------------------------------------------------------------------------------
    private int partition(int arr[], int begin, int end) {
        int pivot = arr[end];
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        int swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;

        return i+1;
    }
    //-----------------------------------------------------------------------------------------------
    
    public VProductoDetalle get_MenorPrecio(List<VProductoDetalle> L_Input){
        VProductoDetalle vprod_det = new VProductoDetalle();
        vprod_det = L_Input.get(0);
        Double pventa_min = L_Input.get(0).getPventa().doubleValue();
        Double pventa_act;
        for(int i = 0; i < L_Input.size(); i++){
            pventa_act = L_Input.get(i).getPventa().doubleValue();
            if(pventa_min < pventa_act){
                pventa_min = pventa_act;
                vprod_det = L_Input.get(i);
            }
        }
        return vprod_det;
    }
    
    public List<VProductoDetalle> delete_fromList(VProductoDetalle Input, List<VProductoDetalle> L_Input){
        List<VProductoDetalle> L_Output = new ArrayList<>();
        VProductoDetalle vprod_det = new VProductoDetalle();
        for(int i = 0; i < L_Input.size(); i++){
            vprod_det = new VProductoDetalle();
            vprod_det = L_Input.get(i);
            if(Input.getId() != L_Input.get(i).getId())
                L_Output.add(vprod_det);
        }
        return L_Output;
    }
    
    public List<VProductoDetalle> order_List_by_MenorVenta(List<VProductoDetalle> L_Input){
        List<VProductoDetalle> L_Output = new ArrayList<>();
        List<VProductoDetalle> L_NInput = new ArrayList<>();
        Integer limite = 4;
        Integer it = 0;
        VProductoDetalle vprod_det = new VProductoDetalle();
        
        L_NInput = L_Input;
        
        while(it >= limite){
            //get Producto de menor Precio
            vprod_det = new VProductoDetalle();
            vprod_det = get_MenorPrecio(L_NInput);
            System.out.println("Producto : " + vprod_det.getNombre() + ", Precio: " + vprod_det.getPventa().doubleValue());
            L_Output.add(vprod_det);
            
            //Actualizando Lista de Productos - descartando la encontrada
            L_NInput = delete_fromList(vprod_det,L_NInput);
            
            it++;
        }
        return L_Output;
    }
    //-----------------------------------------------------------------------------------------------
    
    @Override
    public List<VProductoDetalle> get_CheapProds_byLinea(String linea_ecommerce){
        List<VProductoDetalle> L_Prods = new ArrayList<>();
        List<VProductoDetalle> L_Result = new ArrayList<>();
        List<VProductoDetalle> L_Resp = new ArrayList<>();
        VProductoDetalle vprod_det = new VProductoDetalle(); 
        List<Linea> L_LineaERP = new ArrayList<>();
        
        //Obtiene la lista de lineas ERP relacionadas a esa Linea Ecommerce
        L_LineaERP = get_LineaERP_byLEcom(linea_ecommerce);
        String linea_ERP_id = "";
        
        //Obtiene la lista de productos con menor precio de todas las lineas ERP
        System.out.println("List Productos menor Precio por Linea Ecommerce");
        for(int i = 0; i < L_LineaERP.size(); i++){
            linea_ERP_id = String.valueOf(L_LineaERP.get(i).getId());
            System.out.println("Linea ERP Id: " + linea_ERP_id);
            try {
                String where = "where a.linea_id = "+linea_ERP_id+" order by a.pventa asc limit 4";
                L_Prods = CRUD.list(VProductoDetalle.class,where);
                for (int j = 0; j < L_Prods.size(); j++){
                    System.out.println("Producto: " + L_Prods.get(i).getNombre() + " ,Precio: " + L_Prods.get(i).getPventa());
                    vprod_det = new VProductoDetalle(); 
                    vprod_det = L_Prods.get(i);
                    L_Result.add(vprod_det);
                } 
            } catch (Exception ex) {
                Logger.getLogger(LineaEcommerceServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
        if(L_Result.size() > 4){
            L_Resp = order_List_by_MenorVenta(L_Result);
            return L_Resp;
        }
        else { return L_Result; }
        
    }
    //-----------------------------------------------------------------------------------------------
}
