/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.service;

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

import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author evanl
 */
public interface ProductoService {
    
    Producto getByCodigo(String codigo);
    List<Producto> list(boolean soloActivos);
    List<Producto> listByNombre(String nombre);
    List<Producto> listByLinea(String nombre);
    List<Linea> listTopLineas(int top) throws Exception;
    List<Producto> listProdPorLinea(int cod);
    List<Marca> listMarcasPorLinea(int idLinea);
//    List<Producto> productoPorId(int id);
    VProductoDetalle productoDetPorId(int id);
    List<VProductoDetalle> productosDetPorIds(String ids);
    BigDecimal precioActualProd(String id, String cantidad);
    List<VProductoDetalle> listProdPorLinea2(int id);
    List<Ubigeo> listDepartamentos();
    List<Ubigeo> listProvinciasPorDep(String coddep);
    List<Ubigeo> listDistritosPorProv(String coddep, String codprov);
    Boolean validarDeliveryDepartamento(String coddep);
    Boolean validarDeliveryProvincia(String codprov);
    Boolean validarDeliveryDistrito(String coddist);

    int saveDirEntrega(DirEntrega dir);
    List<VProductoDetalle> listProdSearch(String key);
    Integer getStockReal(String codigo);
    Integer getStockPreVenta(String codigo);
    Boolean validarStockParaVenta(String codigo, Integer cantidad);
    VStockPorLlegar getStockParaVentaPorLlegar(String codigo);
    
    public List<Producto> listByNombre_Ecom(String nombre);
    public List<Producto> listByNombre_NoEcom(String nombre);
    public List<Producto> listAllProd(boolean soloActivos);
    public List<Producto> listAll_Prod_tipo(boolean soloActivos);
    public List<Producto> listAll_Marca(boolean soloActivos);
    public List<Producto> listAll_Unidad(boolean soloActivos);
    public List<Producto> listAll_Linea(boolean soloActivos);
    public void saveProd(Producto prod);
    public void deleteProd(Producto prod);
    public void updateProd(Producto prod);
    
    public Producto update(Producto producto);
    //public Producto getByCodigo(String codigo);
    public Producto getById(String id);
    public Producto getByIdWithMarca(String id);
    public Producto findByNombre(String nombre);
    //public List<Producto> list(boolean soloActivos);
    //public List<Producto> listByNombre(String nombre);
    public List<Producto> listByCodigo(String nombre);
    public List<Producto> listByCodigoOrDescripcion(String nombre);
    
    public List<LineaEcommerce> listLineaEcom();
    public LineaEcommerce get_ByLineaEcom_nombre(String nombre);
    public List<Producto> listProd_ByLineaEcom(String linea);
    public List<Producto> listProd_ByLineaEcom2(String linea);
    
    public ProductoDet get_ProdDet(String id_prod);
    public List<ImagenesProducto> get_ImgProducto(String id_prod);
    public ImagenesProducto get_ImgProducto_byUrl(String id_prod, String url_img);
    public void save_ImgProducto(ImagenesProducto img_prod);
    public void delete_ImgProducto(ImagenesProducto img_prod);
    public void update_ImgProducto(ImagenesProducto img_prod);
    
    //Productos con menor precio por Linea - FRONT
    public List<VProductoDetalle> get_CheapProds_byLinea(String linea_ecommerce);
    
}
