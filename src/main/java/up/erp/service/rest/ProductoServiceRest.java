/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.service.rest;

import com.upgrade.persistence.model.ecommerce.DirEntrega;
import com.upgrade.persistence.model.ecommerce.ImagenesProducto;
import com.upgrade.persistence.model.ecommerce.LineaEcommerce;
import com.upgrade.persistence.model.ecommerce.VProductoDetalle;
import com.upgrade.persistence.model.ecommerce.VStockPorLlegar;
import com.upgrade.persistence.model.extcs.Linea;
import com.upgrade.persistence.model.extcs.Marca;
import com.upgrade.persistence.model.extcs.Producto;
import com.upgrade.persistence.model.extcs.ProductoDet;
import com.upgrade.persistence.model.legal.Ubigeo;
import org.springframework.web.bind.annotation.*;
import up.erp.service.ProductoService;
import up.erp.service.Services;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author evanl
 */
@RequestMapping("/producto")
@RestController
public class ProductoServiceRest implements ProductoService {

    
    @GetMapping("/getByCodigo")
    @Override
    public Producto getByCodigo(@RequestParam(value = "codigo") String codigo) {
        return Services.getProducto().getByCodigo(codigo);
    }

    @GetMapping("/list")
    @Override
    public List<Producto> list(@RequestParam(value = "soloActivos") boolean soloActivos) {
        return Services.getProducto().list(soloActivos);
    }

    @GetMapping("/listByNombre")
    @Override
    public List<Producto> listByNombre(@RequestParam(value = "nombre")String nombre) {
        return Services.getProducto().listByNombre(nombre);
    }
    
    @GetMapping("/listByLinea")
    @Override
    public List<Producto> listByLinea(@RequestParam(value = "descripcion")String linea) {
        return Services.getProducto().listByLinea(linea);
    }

    @GetMapping("/listTopLineas")
    @Override
    public List<Linea> listTopLineas(@RequestParam(value = "top")int top) throws Exception {
        return Services.getProducto().listTopLineas(top);
    }

    @GetMapping("/listProdPorLinea")
    @Override
    public List<Producto> listProdPorLinea(@RequestParam(value = "codigo")int codigo) {
        return Services.getProducto().listProdPorLinea(codigo);
    }

    @GetMapping("/listMarcasPorLinea")
    @Override
    public List<Marca> listMarcasPorLinea(@RequestParam(value = "codigo")int codigo) {
        return Services.getProducto().listMarcasPorLinea(codigo);
    }

/*    @GetMapping("/productoPorId")
    @Override
    public List<Producto> productoPorId(@RequestParam(value = "codigo")int codigo) {
        return Services.getProducto().productoPorId(codigo);
    }*/

    @GetMapping("/productoDetPorId")
    @Override
    public VProductoDetalle productoDetPorId(@RequestParam(value = "codigo")int codigo) {
        return Services.getProducto().productoDetPorId(codigo);
    }

    @GetMapping("/listProductosDetPorIds")
    @Override
    public List<VProductoDetalle> productosDetPorIds(@RequestParam(value = "codigos")String codigos) {
        return Services.getProducto().productosDetPorIds(codigos);
    }

    @Override
    public BigDecimal precioActualProd(String id, String cantidad) {
        return null;
    }

    @GetMapping("/listProdPorLinea2")
    @Override
    public List<VProductoDetalle> listProdPorLinea2(@RequestParam(value = "codigo")int id) {
        return Services.getProducto().listProdPorLinea2(id);
    }

    @GetMapping("/listDepartamentos")
    @Override
    public List<Ubigeo> listDepartamentos() {
        return Services.getProducto().listDepartamentos();
    }

    @GetMapping("/listProvinciasPorDep")
    @Override
    public List<Ubigeo> listProvinciasPorDep(@RequestParam(value = "coddep")String coddep) {
        return Services.getProducto().listProvinciasPorDep(coddep);
    }
    @GetMapping("/listDistritosPorProv")
    @Override
    public List<Ubigeo> listDistritosPorProv(@RequestParam(value = "coddep")String coddep, @RequestParam(value = "codprov")String codprov) {
        return Services.getProducto().listDistritosPorProv(coddep, codprov);
    }

    @GetMapping("/validarDeliveryDepartamento")
    @Override
    public Boolean validarDeliveryDepartamento(@RequestParam(value = "coddep") String coddep) {
        return Services.getProducto().validarDeliveryDepartamento(coddep);
    }

    @GetMapping("/validarDeliveryProvincia")
    @Override
    public Boolean validarDeliveryProvincia(@RequestParam(value = "codprov") String codprov) {
        return Services.getProducto().validarDeliveryProvincia(codprov);
    }

    @GetMapping("/validarDeliveryDistrito")
    @Override
    public Boolean validarDeliveryDistrito(@RequestParam(value = "coddist") String coddist) {
        return Services.getProducto().validarDeliveryDistrito(coddist);
    }

    @PostMapping("/saveDirEntrega")
    @Override
    public int saveDirEntrega(@RequestBody DirEntrega dir) {
        return Services.getProducto().saveDirEntrega(dir);
    }

    @GetMapping("/listProdSearch")
    @Override
    public List<VProductoDetalle> listProdSearch(@RequestParam(value = "key") String key) {
        return Services.getProducto().listProdSearch(key);
    }

    @Override
    public Integer getStockReal(String codigo) {
        return Services.getProducto().getStockReal(codigo);
    }

    @Override
    public Integer getStockPreVenta(String codigo) {
        return Services.getProducto().getStockPreVenta(codigo);
    }

    @Override
    public Boolean validarStockParaVenta(String codigo, Integer cantidad) {
        return Services.getProducto().validarStockParaVenta(codigo, cantidad);
    }
    
    @Override
    public VStockPorLlegar getStockParaVentaPorLlegar(String codigo) {
        return Services.getProducto().getStockParaVentaPorLlegar(codigo);
    }
    
    @Override
    public List<Producto> listByNombre_Ecom(String nombre) {
        return Services.getProducto().listByNombre_Ecom(nombre);
    }
    
    @Override
    public List<Producto> listByNombre_NoEcom(String nombre) {
        return Services.getProducto().listByNombre_NoEcom(nombre);
    }

    @Override
    public List<Producto> listAllProd(boolean soloActivos) {
        return Services.getProducto().listAllProd(soloActivos);
    }

    @Override
    public List<Producto> listAll_Prod_tipo(boolean soloActivos) {
        return Services.getProducto().listAll_Prod_tipo(soloActivos);
    }

    @Override
    public List<Producto> listAll_Marca(boolean soloActivos) {
        return Services.getProducto().listAll_Marca(soloActivos);
    }

    @Override
    public List<Producto> listAll_Unidad(boolean soloActivos) {
        return Services.getProducto().listAll_Unidad(soloActivos);
    }

    @Override
    public List<Producto> listAll_Linea(boolean soloActivos) {
        return Services.getProducto().listAll_Linea(soloActivos);
    }

    @Override
    public void saveProd(Producto prod) {
        //return Services.getProducto().saveProd(prod);
    }

    @Override
    public void deleteProd(Producto prod) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateProd(Producto prod) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<Producto> listByCodigoOrDescripcion(String nombre){
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          return Services.getProducto().listByCodigoOrDescripcion(nombre);
    }
    
    //Archivos Temporales  
    @Override
    public Producto update(Producto producto){
        return Services.getProducto().update(producto);
    }

    @Override
    public Producto getById(String id){
        return Services.getProducto().getById(id);
    }
    @Override
    public Producto getByIdWithMarca(String id){
        return Services.getProducto().getById(id);
    }
    @Override
    public Producto findByNombre(String nombre){
        return Services.getProducto().getById(nombre);
    }

    @Override
    public List<Producto> listByCodigo(String nombre){
        return Services.getProducto().listByCodigo(nombre);
    }

    @Override
    public List<LineaEcommerce> listLineaEcom() {
        return Services.getProducto().listLineaEcom();
    }

    @Override
    public LineaEcommerce get_ByLineaEcom_nombre(String nombre) {
        return Services.getProducto().get_ByLineaEcom_nombre(nombre);
    }

    @Override
    public List<Producto> listProd_ByLineaEcom(String linea) {
        return Services.getProducto().listProd_ByLineaEcom(linea);
    }

    @Override
    public ProductoDet get_ProdDet(String id_prod) {
        return Services.getProducto().get_ProdDet(id_prod);
    }

    @Override
    public List<Producto> listProd_ByLineaEcom2(String linea) {
        return Services.getProducto().listProd_ByLineaEcom2(linea);
    }

    @Override
    public List<ImagenesProducto> get_ImgProducto(String id_prod) {
        return Services.getProducto().get_ImgProducto(id_prod);
    }

    @Override
    public ImagenesProducto get_ImgProducto_byUrl(String id_prod, String url_img) {
        return Services.getProducto().get_ImgProducto_byUrl(id_prod, url_img);
    }

    @Override
    public void save_ImgProducto(ImagenesProducto img_prod) {
        Services.getProducto().save_ImgProducto(img_prod);
    }

    @Override
    public void delete_ImgProducto(ImagenesProducto img_prod) {
        Services.getProducto().delete_ImgProducto(img_prod);
    }

    @Override
    public void update_ImgProducto(ImagenesProducto img_prod) {
        Services.getProducto().update_ImgProducto(img_prod);
    }

    @GetMapping("/productos-linea-home")
    @Override
    public List<VProductoDetalle> get_CheapProds_byLinea(@RequestParam(value = "linea") String linea_ecommerce){
        return Services.getProducto().get_CheapProds_byLinea(linea_ecommerce);
    }

    
    
    
}
