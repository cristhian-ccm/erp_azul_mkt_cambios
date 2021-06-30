/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.service.rest;

import com.upgrade.persistence.model.ecommerce.CatalogoPuntos;
import com.upgrade.persistence.model.ecommerce.*;
import com.upgrade.persistence.model.extcs.Marca;
import com.upgrade.persistence.model.extcs.Producto;
import com.upgrade.persistence.model.legal.Ubigeo;
import com.upgrade.persistence.model.tcros.Direccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import up.erp.service.EcommerceService;

import java.util.List;

/**
 *
 * @author evanl
 */
@RequestMapping("/ecommerce")
@RestController
public class EcommerceServiceRest {

    @Autowired
    private EcommerceService ecommerceService;

    @PostMapping("/update-cart")
    public ResponseFrontModel updateCart(@RequestBody CartUpdate carts) {
        return ecommerceService.updateCart(carts);
    }

    @GetMapping("/get-cart")
    public List<VProductoDetalle> getCart(@RequestParam(value = "id") Integer id) {
        return ecommerceService.getCart(id);
    }

    @PostMapping("/save-cart")
    public ResponseFrontModel saveCart(@RequestBody Cart cart) {
        return ecommerceService.saveCart(cart);
    }

    @PostMapping("/save-cart-all")
    public ResponseFrontModel saveCart(@RequestBody List<Cart> carts) {
        return ecommerceService.saveCartAll(carts);
    }

    @PostMapping("/delete-cart")
    public ResponseFrontModel deleteCart(@RequestBody Cart cart) {
        return ecommerceService.deleteCart(cart);
    }

    @PostMapping("/delete-cart-all")
    public ResponseFrontModel deleteCartAll(@RequestBody Cart cart) {
        return ecommerceService.deleteCartAll(cart);
    }

    @PostMapping("/delete-cart-all-compra")
    public List<VProductoDetalle> deleteCartAllCompra(@RequestBody List<VProductoDetalle> productos, @RequestParam(value = "id") Integer id) {
        return ecommerceService.deleteCartAllCompra(productos, id);
    }


    @GetMapping("/get-fav")
    public List<VProductoDetalle> getFav(@RequestParam(value = "id") Integer id) {
        return ecommerceService.getFavoritos(id);
    }

    @PostMapping("/save-fav")
    public ResponseFrontModel saveFav(@RequestBody Favoritos fav) {
        return ecommerceService.saveFavoritos(fav);
    }

    @PostMapping("/delete-fav")
    public ResponseFrontModel deleteFav(@RequestBody Favoritos fav) {
        return ecommerceService.deleteFavoritos(fav);
    }

    @PostMapping("/delete-fav-all")
    public ResponseFrontModel deleteFavAll(@RequestBody Favoritos fav) {
        return ecommerceService.deleteFavoritosAll(fav);
    }

    @GetMapping("/list-lineas-ecommerce")
    public List<LineaEcommerce> lineas_ecommerce() throws Exception {
        return ecommerceService.lineasEcommerce();
    }

    @GetMapping("/productos-por-linea-ecommerce")
    public List<VProductoDetalle> prods_linea_ecom(@RequestParam(value = "codigo") int codigo) {
        return ecommerceService.prodsPorLineaEcom(codigo);
    }

    @GetMapping("/productos-por-linea-ecommerce-top5")
    public List<VProductoDetalle> prods_linea_ecom_top5(@RequestParam(value = "codigo") int codigo) {
        return ecommerceService.prodsPorLineaEcomTop5(codigo);
    }

    @GetMapping("/marcas-por-linea-ecommerce")
    public List<Marca> marcasPorLineaEcom(@RequestParam(value = "codigo") int codigo) {
        return ecommerceService.marcasPorLineaEcom(codigo);
    }

    @GetMapping("/precio-delivery")
    public Ubigeo precioDelivery(@RequestParam(value = "ubigeo") String ubigeo) {
        return ecommerceService.precioDelivery(ubigeo);
    }

    @GetMapping("/banners-ecommerce")
    public List<Banners> bannersEcommerce() {
        return ecommerceService.bannersEcommerce();
    }

    @GetMapping("/all-products-ecommerce")
    public List<VProductoDetalle> allProducts() {
        return ecommerceService.allProducts();
    }

    @GetMapping("/search-products-ecommerce")
    public List<VProductoDetalle> searchProducts( @RequestParam(value = "key") String key) {
        return ecommerceService.searchProducts(key);
    }

    @GetMapping("/all-marcas-ecommerce")
    public List<Marca> allMarcas() {
        return ecommerceService.allMarcas();
    }

    @GetMapping("/validar-cupon")
    public ResponseFrontModel validarCupon(@RequestParam(value = "id") Integer id, @RequestParam(value = "cupon") String cupon) {
        return ecommerceService.validarCupon(id, cupon);
    }

    @GetMapping("/get-servicio-delivery")
    public Producto validarCupon() {
        return ecommerceService.getServicioDelivery();
    }

    @GetMapping("/suscribirse")
    public ResponseFrontModel suscribirse(@RequestParam(value = "id") Integer id, @RequestParam(value = "email") String email) {
        return ecommerceService.suscribirse(id, email);
    }

    @GetMapping("/popup-registro")
    public Promocion popup_registro() {
        return ecommerceService.popup_registro();
    }

    @GetMapping("/puntos-up")
    public Integer puntos_up(@RequestParam(value = "id") Integer id) {
        return ecommerceService.get_puntos_usuario(id);
    }

    @GetMapping("/catalogos-puntos")
    public CatalogoPuntos puntos_up() {
        return ecommerceService.get_catalogo_puntos();
    }

    @GetMapping("/get-banner")
    public ResponseBanner get_banner_activo(@RequestParam(value = "lineaId") Integer lineaId) {
        return ecommerceService.get_banner_activo(lineaId);
    }

    @GetMapping("/get-direcciones")
    public List<ResponseDireccion> get_direcciones(@RequestParam(value = "identificador") String identificador) {
        return ecommerceService.get_direcciones(identificador);
    }
}
