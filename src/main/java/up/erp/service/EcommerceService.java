/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.service;

import com.upgrade.persistence.model.ecommerce.CatalogoPuntos;
import com.upgrade.persistence.model.ecommerce.*;
import com.upgrade.persistence.model.extcs.Marca;
import com.upgrade.persistence.model.extcs.Producto;
import com.upgrade.persistence.model.legal.Ubigeo;
import com.upgrade.persistence.model.tcros.Direccion;

import java.util.List;

/**
 *
 * @author evanl
 */
public interface EcommerceService {

    List<VProductoDetalle> getCart(Integer id);
    ResponseFrontModel saveCart(Cart cart);
    ResponseFrontModel saveCartAll(List<Cart> carts);
    ResponseFrontModel deleteCart(Cart cart);
    ResponseFrontModel deleteCartAll(Cart cart);
    ResponseFrontModel updateCart(CartUpdate carts);
    List<VProductoDetalle> deleteCartAllCompra( List<VProductoDetalle> productos, Integer id);

    List<VProductoDetalle> getFavoritos(Integer id);
    ResponseFrontModel saveFavoritos(Favoritos cart);
    ResponseFrontModel deleteFavoritos(Favoritos cart);
    ResponseFrontModel deleteFavoritosAll(Favoritos cart);

    List<LineaEcommerce> lineasEcommerce();
    List<VProductoDetalle> prodsPorLineaEcom(int cod);
    List<VProductoDetalle> prodsPorLineaEcomTop5(int cod);
    List<Marca> marcasPorLineaEcom(int cod);
    List<Banners> bannersEcommerce();
    List<VProductoDetalle> allProducts();
    List<VProductoDetalle> searchProducts(String key);
    List<Marca> allMarcas();
    ResponseFrontModel validarCupon(Integer id, String cupon);
    ResponseFrontModel suscribirse(Integer id, String email);
    Producto getServicioDelivery();

    Ubigeo precioDelivery(String ubigeo);
    Promocion popup_registro();
    Integer get_puntos_usuario(Integer id);
    CatalogoPuntos get_catalogo_puntos();
    ResponseBanner get_banner_activo(Integer lineaId);
    List<ResponseDireccion> get_direcciones(String identificador);

}
