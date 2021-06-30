/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.server.serviceimpl;

import com.upgrade.persistence.model.ecommerce.CatalogoPuntos;
import com.upgrade.persistence.model.ecommerce.*;
import com.upgrade.persistence.model.extcs.Almacen;
import com.upgrade.persistence.model.extcs.Marca;
import com.upgrade.persistence.model.extcs.Producto;
import com.upgrade.persistence.model.legal.Ubigeo;
import com.upgrade.persistence.model.tcros.Direccion;
import com.upgrade.persistence.model.tcros.Persona;
import com.upgrade.persistence.model.usros.Usuario;
import org.springframework.stereotype.Service;
import ts.com.service.util.db.Query;
import ts.com.service.util.db.server.CRUD;
import up.erp.service.EcommerceService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import up.erp.service.Services;

/**
 *
 * @author evanl
 */
@Service
public class EcommerceServiceImpl implements EcommerceService {

    @Override
    public List<VProductoDetalle> getCart(Integer id) {
        List<VProductoDetalle> list = new ArrayList<>();

        try {
            list = CRUD.list(VProductoDetalle.class, "where id in ( select producto_id from ecommerce.cart where activo = true and usuariow_id = "+ id +  ")");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public ResponseFrontModel saveCart(Cart cart) {
        ResponseFrontModel response = new ResponseFrontModel();
        List<Cart> list = new ArrayList<>();
            try {
                list = CRUD.list(Cart.class, "where usuariow_id = "+ cart.getUsuariow_id() +  " and producto_id = " + cart.getProducto_id());
                if(list.size() > 0){
                    cart.setId(list.get(0).getId());
                    CRUD.update(cart);
                } else {
                    CRUD.save(cart);
                }
//                CRUD.saveOrUpdate(true, cart);
                response.setStatus("success");
                response.setMenssage("Agregado");
            } catch (Exception e) {
                response.setStatus("error");
                response.setMenssage("Error al agregar al carrito");
                e.printStackTrace();
            }
        return response;
    }

    @Override
    public ResponseFrontModel saveCartAll(List<Cart> carts) {
        ResponseFrontModel response = new ResponseFrontModel();
        int count = 0;
        try {
            for(int i = 0; i < carts.size(); i++){
                carts.get(i).setCreacion(new Date());
                CRUD.save(carts.get(i));
                count++;
            }
            response.setStatus("success");
            response.setMenssage("Agregado " + count + " items");
        } catch (Exception e) {
            response.setStatus("error");
            response.setMenssage("Error al agregar al carrito");
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public ResponseFrontModel deleteCart(Cart cart) {
        ResponseFrontModel response = new ResponseFrontModel();
        try {
//            CRUD.update(cart);
            CRUD.execute("update ecommerce.cart set " +
                    "activo = false " +
                    "where producto_id = " + cart.getProducto_id() + " and usuariow_id = " + cart.getUsuariow_id());
            response.setStatus("success");
            response.setMenssage("Eliminado");
        } catch (Exception e) {
            response.setStatus("error");
            response.setMenssage("Error al eliminar del carrito");
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public ResponseFrontModel deleteCartAll(Cart cart) {
        ResponseFrontModel response = new ResponseFrontModel();
        try {
//            CRUD.update(cart);
            CRUD.execute("update ecommerce.cart set " +
                    "activo = false " +
                    "where activo = true and usuariow_id = " + cart.getUsuariow_id());
            response.setStatus("success");
            response.setMenssage("Eliminado");
        } catch (Exception e) {
            response.setStatus("error");
            response.setMenssage("Error al eliminar del carrito");
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public ResponseFrontModel updateCart(CartUpdate carts) {
        ResponseFrontModel response = new ResponseFrontModel();
        try {
            CRUD.execute("update ecommerce.cart set " +
                    " usuariow_id = "  + carts.getUsuario_new()+
                    " where activo = true and usuariow_id = " + carts.getUsuario_old());

            CRUD.execute("update ecommerce.favoritos set " +
                    " usuariow_id = "  + carts.getUsuario_new()+
                    " where activo = true and usuariow_id = " + carts.getUsuario_old());

            response.setStatus("success");
            response.setMenssage("Actualizado");
        } catch (Exception e) {
            response.setStatus("error");
            response.setMenssage("Error al actualizar del carrito");
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public List<VProductoDetalle> deleteCartAllCompra(List<VProductoDetalle> productos, Integer id) {

        try {
         /*   CRUD.execute("update ecommerce.cart set " +
                    "activo = false " +
                    "where activo = true and usuariow_id = " + id);*/

             CRUD.execute("delete from ecommerce.cart " +
                    "where activo = true and usuariow_id = " + id);

            for(int i = 0; i < productos.size(); i++){
                LogCompras compra = new LogCompras();
                compra.setActivo(true);
                compra.setCreacion(new Date());
                compra.setProducto_id(productos.get(i).getId());
                compra.setUsuariow_id(id);
                compra.setCantidad(productos.get(i).getCartCount());
                CRUD.save(compra);
            }
         return productos;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productos;
    }

    @Override
    public List<VProductoDetalle> getFavoritos(Integer id) {
        List<VProductoDetalle> list = new ArrayList<>();

        try {
            list = CRUD.list(VProductoDetalle.class, "where id in ( select producto_id from ecommerce.favoritos where activo = true and usuariow_id = "+ id +  ")");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public ResponseFrontModel saveFavoritos(Favoritos fav) {
        ResponseFrontModel response = new ResponseFrontModel();
        List<Favoritos> list = new ArrayList<>();
        try {
            list = CRUD.list(Favoritos.class, "where usuariow_id = "+ fav.getUsuariow_id() +  " and producto_id = " + fav.getProducto_id());
            if(list.size() > 0){
                fav.setId(list.get(0).getId());
                CRUD.update(fav);
            } else {
                CRUD.save(fav);
            }
            response.setStatus("success");
            response.setMenssage("Agregado a favoritos");
        } catch (Exception e) {
            response.setStatus("error");
            response.setMenssage("Error al agregar al favorito");
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public ResponseFrontModel deleteFavoritos(Favoritos cart) {
        ResponseFrontModel response = new ResponseFrontModel();
        try {
//            CRUD.update(cart);
            CRUD.execute("update ecommerce.favoritos set " +
                    "activo = false " +
                    "where producto_id = " + cart.getProducto_id() + " and usuariow_id = " + cart.getUsuariow_id());
            response.setStatus("success");
            response.setMenssage("Eliminado de favoritos");
        } catch (Exception e) {
            response.setStatus("error");
            response.setMenssage("Error al eliminar de favoritos");
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public ResponseFrontModel deleteFavoritosAll(Favoritos cart) {
        ResponseFrontModel response = new ResponseFrontModel();
        try {
//            CRUD.update(cart);
            CRUD.execute("update ecommerce.favoritos set " +
                    "activo = false " +
                    "where activo = true and usuariow_id = " + cart.getUsuariow_id());
            response.setStatus("success");
            response.setMenssage("Eliminado favoritos");
        } catch (Exception e) {
            response.setStatus("error");
            response.setMenssage("Error al eliminar favoritos");
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public List<LineaEcommerce> lineasEcommerce() {
        List<LineaEcommerce> list = new ArrayList<>();

        try {
            list = CRUD.list(LineaEcommerce.class, "where activo = true order by orden asc");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<VProductoDetalle> prodsPorLineaEcom(int cod) {

        List<VProductoDetalle> list = new ArrayList<>();

        Query query = new Query();
        String select = "select id, codigo, nombre, descripcion, linea_id, linea, marca_id, marca, pventa, pventa_old, stock, stockreal, stockprev, fecha_llegada, img1, img2, img3, limitcompra, promocion, nuevo from ecommerce.v_producto_detalle";
        query.select.set(select);
        query.where = "where linea_id in( select linea_erp_id from ecommerce.linea_ecom_erp where linea_ecom_id = " + cod + ")";
//        query.where = "where linea_id = " + id ;
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
    public List<VProductoDetalle> prodsPorLineaEcomTop5(int cod) {

        List<VProductoDetalle> list = new ArrayList<>();

        Query query = new Query();
        String select = "select id, codigo, nombre, descripcion, linea_id, linea, marca_id, marca, pventa, pventa_old, stock, stockreal, stockprev, fecha_llegada, img1, img2, img3, " +
                "limitcompra, promocion, nuevo from ecommerce.v_producto_detalle";
        query.select.set(select);
        query.where = "where linea_id in( select linea_erp_id from ecommerce.linea_ecom_erp where linea_ecom_id = " + cod + ")" +
        "order by pventa asc limit 10";
//        query.where = "where linea_id = " + id ;
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
    public List<Marca> marcasPorLineaEcom(int cod) {
        List<Marca> list = new ArrayList<>();

        Query query = new Query();
        String select = "select DISTINCT marca_id, nombre from ecommerce.v_marcas_por_linea";
        query.select.set(select);
        query.where = "where linea_id in( select linea_erp_id from ecommerce.linea_ecom_erp where linea_ecom_id = " + cod + ")";
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
    public List<Banners> bannersEcommerce() {
        List<Banners> list = new ArrayList<>();

        try {
            list = CRUD.list(Banners.class, "where activo = true order by posicion asc");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<VProductoDetalle> allProducts() {
        List<VProductoDetalle> list = new ArrayList<>();

        Query query = new Query();
        String select = "select id, codigo, nombre, descripcion, linea_id, linea, marca_id, marca, pventa, pventa_old, stock, stockreal, stockprev, fecha_llegada, img1, img2, img3, cartcount, limitcompra," +
                "promocion, nuevo from ecommerce.v_producto_detalle";
        query.select.set(select);
        query.where = "";
//        query.where = "where linea_id = " + id ;
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
                prodDet.setCartCount((Integer) rs[i][17]);
                prodDet.setLimitcompra((Integer) rs[i][18]);
                prodDet.setPromocion((Boolean) rs[i][19]);
                prodDet.setNuevo((Boolean) rs[i][20]);

                list.add(prodDet);
            }

        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    @Override
    public List<VProductoDetalle> searchProducts(String key) {
        List<VProductoDetalle> list = new ArrayList<>();

        Query query = new Query();
        String select = "select id, codigo, nombre, descripcion, linea_id, linea, marca_id, marca, pventa, pventa_old, stock, stockreal, stockprev, fecha_llegada, img1, img2, img3, cartcount, limitcompra, promocion, nuevo from ecommerce.v_producto_detalle";
        query.select.set(select);
        query.where = "where search_field ilike '%" + key + "%'";
//        query.where = "where linea_id = " + id ;
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
                prodDet.setCartCount((Integer) rs[i][17]);
                prodDet.setLimitcompra((Integer) rs[i][18]);
                prodDet.setPromocion((Boolean) rs[i][19]);
                prodDet.setNuevo((Boolean) rs[i][20]);

                list.add(prodDet);
            }

        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    @Override
    public List<Marca> allMarcas() {
        List<Marca> list = new ArrayList<>();

        Query query = new Query();
        String select = "select DISTINCT marca_id, nombre from ecommerce.v_marcas_por_linea";
        query.select.set(select);
        query.where = "";
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
    public ResponseFrontModel validarCupon(Integer id, String cupon) {
        ResponseFrontModel response = new ResponseFrontModel();
        List<Cupones> list = new ArrayList<>();
        List<UsuariosCupones> listUsuCupon = new ArrayList<>();
        List<UsuariosCupones> listCantidadCup = new ArrayList<>();

        try {
            list = CRUD.list(Cupones.class, "where activo = true and nombre_cupon = '" + cupon + "'");
            if (list.size() > 0){
                Cupones mCupon = list.get(0);

                listCantidadCup = CRUD.list(UsuariosCupones.class, "where cupon_id = " + mCupon.getId() +" and utilizado = true");

                if(listCantidadCup.size() < mCupon.getCantidad()){
                    listUsuCupon = CRUD.list(UsuariosCupones.class, "where usuariow_id = " + id +" and cupon_id = " + mCupon.getId());
                    if(listUsuCupon.size() > 0){
                        response.setStatus("error");
                        response.setMenssage("Cupón ya fue utilizado.");
                        response.setData(null);
                    } else {
                        response.setStatus("success");
                        response.setMenssage("Cupón Válido");
                        response.setData(list.get(0));
                    }
                } else {
                    response.setStatus("error");
                    response.setMenssage("Lo sentimos, se llegó a la cantidad máxima de uso de este cupón");
                    response.setData(null);
                }

            } else {
                response.setStatus("error");
                response.setMenssage("Cupón Erroneo");
                response.setData(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public ResponseFrontModel suscribirse(Integer id, String email) {
        ResponseFrontModel response = new ResponseFrontModel();

        Suscripcion suscripcion = new Suscripcion();
        
        UsuarioWeb usuweb = new UsuarioWeb();
        String id_usuweb = "";
        
        try {
            //------------------------- Objeto Usuarioweb ----------------------
            id_usuweb = String.valueOf(id);
            usuweb = Services.getUsuarioWeb().find_UsuWeb_byId(id_usuweb);
            suscripcion.setUsuariow(usuweb);
            //------------------------------------------------------------------
            suscripcion.setEmail(email);
            suscripcion.setCreacion(new Date());
            suscripcion.setActivo(true);
            CRUD.save(suscripcion);
            response.setStatus("success");
            response.setMenssage("Gracias por suscribirte, muy pronto estarás recibiendo muchas novedades.");
        } catch (Exception e) {
            response.setStatus("error");
            response.setMenssage("Error al suscribirte");
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public Producto getServicioDelivery() {
        List<Producto> list = new ArrayList<>();

        try {
            list = CRUD.list(Producto.class, "where codigo = 'SERDELIVERYECOM'");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list.get(0);
    }

    @Override
    public Ubigeo precioDelivery(String ubigeo) {
        List<Ubigeo> list = new ArrayList<>();

        try {
            list = CRUD.list(Ubigeo.class, "where codigo = '" + ubigeo + "'");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list.get(0);
    }

    @Override
    public Promocion popup_registro() {
        List<Promocion> list = new ArrayList<>();

        try {
            list = CRUD.list(Promocion.class, "where activo = true limit 1");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list.get(0);
    }

    @Override
    public Integer get_puntos_usuario(Integer id) {
        Query query = new Query();
        String select = "select pts_inc, pts_dec, pts_restantes from ecommerce.puntos_up ";
        query.select.set(select);
        query.where = " where activo = true and usuariow_id =  "+ id +  " order by id desc limit 1";
        query.end = "";
        try {
            Object[][] rs = query.initResultSet();

            if (rs.length == 0) {
                return 0;
            }
            return (Integer) rs[0][2];
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
//        return puntos;
    /*    return list;
        List<PuntosUp> list = new ArrayList<>();
        try {
            list = CRUD.list(PuntosUp.class, requireUsuarioCaja,"where activo = true and usuariow_id = " + id + " order by id desc limit 1");
            System.out.println("PUNTOS UP");
            System.out.println(list.size());
            System.out.println("FIN PUNTOS UP");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(list.size() > 0)
            return list.get(0);
        return null;*/

    }

    @Override
    public CatalogoPuntos get_catalogo_puntos() {
        List<CatalogoPuntos> list = new ArrayList<>();

        try {
            list = CRUD.list(CatalogoPuntos.class, "where activo = true limit 1");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list.get(0);
    }





    @Override
    public ResponseBanner get_banner_activo(Integer lineaId) {
        ResponseBanner rpt = new ResponseBanner();
        Query query = new Query();

        String select = "select b.url_banner, b.url_reDirec, p.fecha_fin  from ecommerce.programbanner p " +
                " join ecommerce.bannertable b on p.id_banner = b.id";

        query.select.set(select);
        query.where = " where p.id_linea = " + lineaId + " and (p.fecha_ini <= now() and p.fecha_fin >= now()) and p.activo = true and b.activo = true";
        if(lineaId == 0)
            query.where = " where p.id_linea is null and (p.fecha_ini <= now() and p.fecha_fin >= now()) and p.activo = true and b.activo = true";
        query.end = "";
        try {
            Object[][] rs = query.initResultSet();

            if (rs == null || rs.length == 0) {
                return null;
            }

            rpt.setUrl_imagen((String) rs[0][0]);
            rpt.setUrl_redirec((String) rs[0][1]);
            rpt.setFecha_fin((Date) rs[0][2]);
            return rpt;
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    




    @Override
    public List<ResponseDireccion> get_direcciones(String identificador) {
        List<ResponseDireccion> list = new ArrayList<>();
        Query query = new Query();
        String select = "   select d.id, d.descripcion as direccion,  p.nombre, p.telefono from tcros.direcciones d" +
                "        join tcros.personas p on d.persona_id = p.id";
        query.select.set(select);
        query.where = "    where p.identificador = '" + identificador + "'";
        query.end = "";
        try {
            Object[][] rs = query.initResultSet();
            if (rs.length == 0) {
                return null;
            }

            for (int i = 0; i < rs.length; i++) {
                ResponseDireccion res = new ResponseDireccion();
                res.setId((Integer) rs[i][0]);
                res.setDireccion((String) rs[i][1]);
                res.setNombre((String) rs[i][2]);
                res.setTelefono((String) rs[i][3]);
                list.add(res);
            }
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
