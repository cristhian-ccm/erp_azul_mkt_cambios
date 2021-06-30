/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.view.ecom;

import com.upgrade.persistence.model.ecommerce.ImagenesProducto;
import com.upgrade.persistence.model.ecommerce.LineaEcommerce;
import com.upgrade.persistence.model.ecommerce.VStockPorLlegar;
import com.upgrade.persistence.model.extcs.Producto;
import com.upgrade.persistence.model.extcs.ProductoDet;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.upload.SucceededEvent;
import com.vaadin.flow.data.selection.MultiSelect;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import up.erp.server.Server;
import up.erp.service.Services;
import up.erp.view.App;

//import ts.com.server.Server;
/**
 *
 * @author Luis Aleman
 */
public class Productos2View extends Productos2UI{
    //--------------------------------------------------------------------------
    //CPANEL RUTH
    //--------------------------------------------------------------------------
    public App app;
    
    public Productos2View(App app) {
        this.app = app;
    }
    //--------------------------------------------------------------------------
    @Override
    public void go_CPanel(){
        this.app.layHeader.removeAll();
        this.app.setContent(new CPanelView(app));
    }
    //--------------------------------------------------------------------------
    @Override
    public void go_Clientes(){
        this.app.layHeader.removeAll();
        this.app.setContent(new ClientesView(app));
    }
    //--------------------------------------------------------------------------
    @Override
    public void go_LineasEcom(){
        this.app.layHeader.removeAll();
        this.app.setContent(new LineasEcomView(app));
    }
    //--------------------------------------------------------------------------
    @Override
    public void go_Pedidos(){
        this.app.layHeader.removeAll();
        this.app.setContent(new PedidosView(app));
    }
    //--------------------------------------------------------------------------
    @Override
    public void go_Index(){
        this.app.layHeader.removeAll();
        this.app.setContent(new IndexWebView(app));
    }
    //--------------------------------------------------------------------------
    @Override
    public void go_Cupones(){
        this.app.layHeader.removeAll();
        this.app.setContent(new CuponesView(app));
    }
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    
    List<Producto> result = new ArrayList<>();
    List<Producto> list_aux = new ArrayList<>();
    List<ImagenesProducto> list_imgProducto = new ArrayList<>();
    Integer iterator_lImgProducto = 0;
    Producto prod_aux = new Producto();
    String codigo = "";
    String path = "";
    String Url_img1 = "";
    Boolean verify_change_Img1 = Boolean.FALSE;
    String Url_img2 = "";
    Boolean verify_change_Img2 = Boolean.FALSE;
    String Url_img3 = "";
    Boolean verify_change_Img3 = Boolean.FALSE;
    Server server = new Server();
    String prod_id = "";
    Integer stock_real = 0;
    Integer stock_paraVenta = 0;
    Integer stock_disponible = 0;
    String Combobox_Item = "";
    //--------------------------------------------------------------------------
    //UTILIDAD
    //--------------------------------------------------------------------------
    Double utilidad = 0.15;
    Producto prod_util = new Producto();
    ProductoDet prod_det = new ProductoDet();
    Double precio_ecommerce;
    //--------------------------------------------------------------------------
    @Override
    public void Comprobar_Utilidad(){
        Double costo;
        Double new_utilidad;
        Boolean resp = Boolean.FALSE;
        if(!txtPrecioEcom.isEmpty()){
            precio_ecommerce = Double.valueOf(txtPrecioEcom.getValue());
            costo = prod_det.getCosto().doubleValue();
            new_utilidad = costo - precio_ecommerce;
            //new_utilidad.subtract(precio_ecommerce);

            if(new_utilidad < utilidad){
                resp = Boolean.FALSE;
                System.out.println("La utilidad es menor a 0.15");
                notify_utilidad_correcta.open();
            }
            else {
                resp = Boolean.TRUE;
                System.out.println("La utilidad es mayor a 0.15");
                notify_utilidad_incorrecta.open();
            }
        }
    }
    //--------------------------------------------------------------------------
    // Generic function to convert set to list 
    public static <T> List<T> convertSetToList(Set<T> set) 
    { 
        // create an empty list 
        List<T> list = new ArrayList<>(); 
  
        // push each element in the set into the list 
        for (T t : set) 
            list.add(t); 
  
        // return the list 
        return list; 
    } 
    
    public void enlistar_Prod(Producto prod) {
        list_aux.add(prod);
    }
    
    public void desenlistar_Prod() {
        list_aux.remove(list_aux.size()-1);
    }
    
    public void removeAll_Prod() {
        for(int i=0;i < list_aux.size();i++){
            list_aux.remove(i);
        }
    }
    
    //--------------------------------------------------------------------------
    //Incializa comboBox de Lineas Ecommerce para la busqueda
    @Override
    public void on_Click_ComboBusLinea(){
        List<LineaEcommerce> list_Linea_ecom = new ArrayList<>();
        List<String> list_linea = new ArrayList<>();
        list_Linea_ecom = Services.getProducto().listLineaEcom();
        for (int i = 0; i < list_Linea_ecom.size(); i++){
            list_linea.add(list_Linea_ecom.get(i).getNombre());
        }
        cmbLineaBus.setItems(list_linea);
    }
    
    //Busca productos ecommerce agrupados por una linea en particular
    @Override
    public void On_find_LineaEcom(){
        String linea_bus = txtLineaBus.getValue();
        //Lista Productos Agrupados por la Linea Elegida
        result = Services.getProducto().listProd_ByLineaEcom2(linea_bus);   
        for(int i = 0; i < result.size(); i++){
            prod_id = String.valueOf(result.get(i).getId());
            System.out.println("Id prod #" + (i+1) + ", con valor: " + prod_id);
            stock_real = Services.getProducto().getStockReal(prod_id);
            System.out.println("Stock Real: " + stock_real);
            stock_paraVenta = Services.getProducto().getStockPreVenta(prod_id);
            System.out.println("Stock Para Venta: " + stock_paraVenta);
            VStockPorLlegar StockPorLlegar = new VStockPorLlegar();
            StockPorLlegar = Services.getProducto().getStockParaVentaPorLlegar(prod_id);
            System.out.println("Stock Por Llegar: " + StockPorLlegar.cantidad_por_llegar);
            stock_disponible = 0;
            if(StockPorLlegar.getCantidad_por_llegar() == null){
                if(stock_real >= stock_paraVenta) stock_disponible = stock_real - stock_paraVenta;
                else stock_disponible = 0;
            }
            else {
                stock_disponible = (stock_real + StockPorLlegar.getCantidad_por_llegar()) - stock_paraVenta;
                System.out.println("Stock disponible: " + stock_disponible);
            }
            result.get(i).setStock_ecom(stock_disponible);
        }
        grid.setItems(result);
        grid.getColumns().get(5).setVisible(false);
    }
    
    //Busca productos que si han sido marcados como E-commerce
    @Override
    public void On_find_Prodname() {
        String nombre = txtname.getValue();
        //result = Services.getProducto().listByNombre(nombre);
        result = Services.getProducto().listByNombre_Ecom(nombre);
        for(int i = 0; i < result.size(); i++){
            prod_id = String.valueOf(result.get(i).getId());
            System.out.println("Id prod #" + (i+1) + ", con valor: " + prod_id);
            stock_real = Services.getProducto().getStockReal(prod_id);
            System.out.println("Stock Real: " + stock_real);
            stock_paraVenta = Services.getProducto().getStockPreVenta(prod_id);
            System.out.println("Stock Para Venta: " + stock_paraVenta);
            VStockPorLlegar StockPorLlegar = new VStockPorLlegar();
            StockPorLlegar = Services.getProducto().getStockParaVentaPorLlegar(prod_id);
            System.out.println("Stock Por Llegar: " + StockPorLlegar.cantidad_por_llegar);
            stock_disponible = 0;
            if(StockPorLlegar.getCantidad_por_llegar() == null){
                if(stock_real >= stock_paraVenta) stock_disponible = stock_real - stock_paraVenta;
                else stock_disponible = 0;
            }
            else {
                stock_disponible = (stock_real + StockPorLlegar.getCantidad_por_llegar()) - stock_paraVenta;
                System.out.println("Stock disponible: " + stock_disponible);
            }
            result.get(i).setStock_ecom(stock_disponible);
        }
        grid.setItems(result);
        grid.getColumns().get(5).setVisible(false);
    }
    
    //Busca productos que no han sido marcados como E-commerce
    @Override
    public void On_find_NoEcom() {
        String nombre = txtname.getValue();
        result = Services.getProducto().listByNombre_NoEcom(nombre);
        for(int i = 0; i < result.size(); i++){
            prod_id = String.valueOf(result.get(i).getId());
            System.out.println("Id prod #" + (i+1) + ", con valor: " + prod_id);
            stock_real = Services.getProducto().getStockReal(prod_id);
            System.out.println("Stock Real: " + stock_real);
            stock_paraVenta = Services.getProducto().getStockPreVenta(prod_id);
            System.out.println("Stock Para Venta: " + stock_paraVenta);
            VStockPorLlegar StockPorLlegar = new VStockPorLlegar();
            StockPorLlegar = Services.getProducto().getStockParaVentaPorLlegar(prod_id);
            System.out.println("Stock Por Llegar: " + StockPorLlegar.cantidad_por_llegar);
            stock_disponible = 0;
            if(StockPorLlegar.getCantidad_por_llegar() == null){
                if(stock_real >= stock_paraVenta) stock_disponible = stock_real - stock_paraVenta;
                else stock_disponible = 0;
            }
            else {
                stock_disponible = (stock_real + StockPorLlegar.getCantidad_por_llegar()) - stock_paraVenta;
                System.out.println("Stock disponible: " + stock_disponible);
            }
            result.get(i).setStock_ecom(stock_disponible);
        }
        grid.setItems(result);
        grid.getColumns().get(5).setVisible(false);
    }
    
    @Override
    public void On_find_Cod() {
        codigo = txtcod.getValue();
        Producto prod = Services.getProducto().getByCodigo(codigo);
        prod_id = String.valueOf(prod.getId());
        System.out.println("Id prod: " + prod_id);
        VStockPorLlegar StockPorLlegar = new VStockPorLlegar();
        StockPorLlegar = Services.getProducto().getStockParaVentaPorLlegar(prod_id);
        stock_real = Services.getProducto().getStockReal(prod_id);
        stock_paraVenta = Services.getProducto().getStockPreVenta(prod_id);
        stock_disponible = 0;
        if(StockPorLlegar.getCantidad_por_llegar() == null){
            if(stock_real >= stock_paraVenta) stock_disponible = stock_real - stock_paraVenta;
            else stock_disponible = 0;
        }
        else {
            stock_disponible = (stock_real + StockPorLlegar.getCantidad_por_llegar()) - stock_paraVenta;
            System.out.println("Stock disponible: " + stock_disponible);
        }
        prod.setStock_ecom(stock_disponible);
        grid.setItems(prod);
        grid.getColumns().get(5).setVisible(false);
    }

    @Override
    public void On_delete_Prod() {
        Producto prod_delete = new Producto();
        //MultiSelect<Producto> multiSelect = grid.asMultiSelect();
        //Set<Producto> set_prod = multiSelect.getSelectedItems();
        Set<Producto> set_prod = grid.getSelectedItems();
        Iterator<Producto> it = grid.asMultiSelect().getValue().iterator();
        while (it.hasNext()){
            prod_delete = Services.getProducto().getByCodigo(String.valueOf(it.next().getCodigo()));
            prod_delete.setInactivo(Boolean.TRUE);
            prod_delete.setEcommerce(Boolean.FALSE);
            Services.getProducto().updateProd(prod_delete);
            result.remove(grid.asMultiSelect().getValue().iterator().next());
        }
        grid.setItems(result);
        grid.getDataProvider().refreshAll();
    }

    @Override
    public void on_Upload(SucceededEvent event) {
        Producto prod = Services.getProducto().getByCodigo(codigo);
        String id_path = String.valueOf(prod.getId());
        path = "";
        try {
            //LECTURA
            //InputStream is = buffer1.getInputStream(event.getFileName());
            InputStream is = buffer1.getInputStream();
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            path = Server.PATH_IMAGES + id_path + "_" + event.getFileName();
            
            //ESCRITURA
            File newFile = new File(path);
            OutputStream out = new FileOutputStream(newFile);
            out.write(buffer);
            out.close();
            is.close();
            
            //CARGA IMAGEN
            Url_img1 = Server.URL_IMAGES + id_path + "_" + event.getFileName();
            txtUpload1.setValue(path);
            img1.setSrc(Url_img1);
            verify_change_Img1 = Boolean.TRUE;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    
    @Override
    public void on_Descartar_img1(){
        ImagenesProducto img_prod = new ImagenesProducto();
        String url_img = "";
        String id_prod = "";
        
        if(!txtUpload1.isEmpty()){
            url_img = txtUpload1.getValue();
            id_prod = String.valueOf(prod_util.getId());
            img_prod = Services.getProducto().get_ImgProducto_byUrl(id_prod, url_img);
            if(img_prod.getId() != null) {Services.getProducto().delete_ImgProducto(img_prod);}
            txtUpload1.setValue("");
            Url_img1 = "";
            img1.setSrc("");
            verify_change_Img1 = Boolean.TRUE;
        }
        else {
            txtUpload1.setValue("");
            Url_img1 = "";
            img1.setSrc("");
            verify_change_Img1 = Boolean.TRUE;
        }
    }
    
    @Override
    public void On_add_Prod() {
        Producto prod_add = new Producto();
        Set<Producto> set_prod = grid.getSelectedItems();
        Iterator<Producto> it = grid.asMultiSelect().getValue().iterator();
        while (it.hasNext()){
            prod_add = Services.getProducto().getByCodigo(String.valueOf(it.next().getCodigo()));
            prod_add.setInactivo(Boolean.TRUE);
            prod_add.setEcommerce(Boolean.FALSE);
            Services.getProducto().updateProd(prod_add);
            result.remove(grid.asMultiSelect().getValue().iterator().next());
        }
        grid.setItems(result);
        grid.getDataProvider().refreshAll();
    }
    
    //DIALOG E-COMMERCE
    //@Override
    public void on_Click_ComboLinea(){
        List<LineaEcommerce> list_Linea_ecom = new ArrayList<>();
        List<String> list_linea = new ArrayList<>();
        list_Linea_ecom = Services.getProducto().listLineaEcom();
        for (int i = 0; i < list_Linea_ecom.size(); i++){
            list_linea.add(list_Linea_ecom.get(i).getNombre());
        }
        cmbLineaEcom.setItems(list_linea);
        /*
        cmbLineaEcom.setItems(  list_Linea_ecom.get(0).getNombre(),
                                list_Linea_ecom.get(1).getNombre(),
                                list_Linea_ecom.get(2).getNombre(),
                                list_Linea_ecom.get(3).getNombre(),
                                list_Linea_ecom.get(4).getNombre());
        */
    }
    
    @Override
    public void Clean_Ecomdialog() {
        checkEcom.setValue(Boolean.FALSE);
        txtNameEcom.setValue("");
        txtLineaEcom.setValue("No definida");
        txtPrecioEcom.setValue("");
        txtLimiteEcom.setValue("");
        txtaDesc_ecom.setValue("");
        txtUpload1.setValue("");
        img1.setSrc("");
        Url_img1 = "";
        verify_change_Img1 = Boolean.TRUE;
        Url_img2 = "";
        verify_change_Img1 = Boolean.TRUE;
        Url_img3 = "";
        verify_change_Img1 = Boolean.TRUE;
    }
    
    //CAPTAR PRODUCTOS SELECIONADOS
    @Override
    public void on_Open_Ecomdialog() {
        prod_util = new Producto();
        prod_det = new ProductoDet();
        list_imgProducto = new ArrayList<>();
        Producto prod_add = new Producto();
        String prod_cod;
        LineaEcommerce linea_ecom = new LineaEcommerce();
        String limite_ecom;
        Set<Producto> set_prod = grid.getSelectedItems();
        list_aux = new ArrayList<>();
        list_aux = convertSetToList(set_prod);
        //prod_cod = list_aux.get(0).getCodigo();
        
        if(list_aux.size() == 1 && !list_aux.isEmpty()){
            
            prod_cod = list_aux.get(0).getCodigo();
            //prod_cod = grid.getSelectionModel().getFirstSelectedItem().get().getCodigo();
            prod_add = Services.getProducto().getByCodigo(prod_cod);
            System.out.println("El codigo encontrado es: " + prod_add.getCodigo());

            //Utilidad Variables
            prod_util = prod_add;
            prod_det = Services.getProducto().get_ProdDet(String.valueOf(prod_util.getId()));

            //Imagenes del Producto
            list_imgProducto = Services.getProducto().get_ImgProducto(String.valueOf(prod_util.getId()));
            iterator_lImgProducto = 0;

            //Llenando dialogo Ecommerce
            checkEcom.setValue(prod_add.getEcommerce());
            if(prod_add.getEcommerce_nombre() != null)  {txtNameEcom.setValue(prod_add.getEcommerce_nombre());}
            else                                        {txtNameEcom.setValue("");}

            if(prod_add.getEcommerce_descrip() != null) {txtaDesc_ecom.setValue(prod_add.getEcommerce_descrip());}
            else                                        {txtaDesc_ecom.setValue("");}

            if(prod_add.getEcom_precio() != null)   {txtPrecioEcom.setValue(String.valueOf(prod_add.getEcom_precio()));}
            else                                    {txtPrecioEcom.setValue("");}

            if(prod_add.getEcom_limite() != null){
                limite_ecom = String.valueOf(prod_add.getEcom_limite());
                txtLimiteEcom.setValue(limite_ecom);}
            else    {txtLimiteEcom.setValue("");}

            prod_id = String.valueOf(prod_add.getId());
            VStockPorLlegar StockPorLlegar = new VStockPorLlegar();
            StockPorLlegar = Services.getProducto().getStockParaVentaPorLlegar(prod_id);
            stock_real = Services.getProducto().getStockReal(prod_id);
            stock_paraVenta = Services.getProducto().getStockPreVenta(prod_id);
            stock_disponible = 0;
            if(StockPorLlegar.getCantidad_por_llegar() == null){
                stock_disponible = stock_real - stock_paraVenta;
            }
            else {
                stock_disponible = (stock_real + StockPorLlegar.getCantidad_por_llegar()) - stock_paraVenta;
                System.out.println("Stock disponible: " + stock_disponible);
            }
            txtStockAct.setValue(String.valueOf(stock_disponible));

            if(list_imgProducto != null)  {
                img1.setSrc(list_imgProducto.get(0).getUrl_Imagen());
                Url_img1 = list_imgProducto.get(0).getUrl_Imagen();
                txtUpload1.setValue(list_imgProducto.get(0).getUrl_Imagen());
                verify_change_Img1 = Boolean.FALSE;
            }
            else {
                img1.setSrc("");
                Url_img1 = "";
                txtUpload1.setValue(""); 
                verify_change_Img1 = Boolean.FALSE;
            }

            //Linea Ecommerce
            on_Click_ComboLinea();
            linea_ecom = new LineaEcommerce();
            linea_ecom = prod_add.getLinea_ecom();
            System.out.println("La linea ecommerce es: " + linea_ecom.getNombre());
            txtLineaEcom.setValue(linea_ecom.getNombre());
            
            dialogEcomm.open();
        }
        
        else {
            notify_select_exceed.open();
        }
        
    }
    
    //IMAGEN ANTERIOR PRODUCTO
    @Override
    public void On_Click_ImgProdAnterior(){
        //Variables
        String url_image = "";
        
        //Get Anterior
        iterator_lImgProducto = iterator_lImgProducto - 1;
        if(iterator_lImgProducto >= 0 && iterator_lImgProducto < list_imgProducto.size()){   
            url_image = list_imgProducto.get(iterator_lImgProducto).getUrl_Imagen();
            img1.setSrc(url_image);
            Url_img1 = url_image;
            txtUpload1.setValue(url_image);
            verify_change_Img1 = Boolean.TRUE;
        }
        if(iterator_lImgProducto < 0){
            iterator_lImgProducto = list_imgProducto.size() - 1;
            url_image = list_imgProducto.get(iterator_lImgProducto).getUrl_Imagen();
            img1.setSrc(url_image);
            Url_img1 = url_image;
            txtUpload1.setValue(url_image);
            verify_change_Img1 = Boolean.TRUE;
        }
    }
    
    //IMAGEN SIGUIENTE PRODUCTO
    @Override
    public void On_Click_ImgProdSiguiente(){
        //Variables
        String url_image = "";
        
        //Get Siguiente
        iterator_lImgProducto = iterator_lImgProducto + 1;
        if(iterator_lImgProducto < list_imgProducto.size()){   
            url_image = list_imgProducto.get(iterator_lImgProducto).getUrl_Imagen();
            img1.setSrc(url_image);
            Url_img1 = url_image;
            txtUpload1.setValue(url_image);
            verify_change_Img1 = Boolean.TRUE;
        }
        if(iterator_lImgProducto >= list_imgProducto.size()){
            iterator_lImgProducto = 0;
            url_image = list_imgProducto.get(iterator_lImgProducto).getUrl_Imagen();
            img1.setSrc(url_image);
            Url_img1 = url_image;
            txtUpload1.setValue(url_image);
            verify_change_Img1 = Boolean.TRUE;
        }
    }
    
    //GRABAR DATOS E-COMMERCE
    @Override
    public void on_Grabar_ecom() {
        Producto prod_ecom = new Producto();
        //codigo = list_aux.get(0).getCodigo();
        String img_url1 = null;
        String img_url2 = null;
        String img_url3 = null;
        codigo = grid.getSelectionModel().getFirstSelectedItem().get().getCodigo();
        prod_ecom = Services.getProducto().getByCodigo(codigo);
        prod_ecom.setEcommerce(checkEcom.getValue());
        //Ecommerce Name
        if(!txtNameEcom.isEmpty()){
            prod_ecom.setEcommerce_nombre(txtNameEcom.getValue());
        }
        
        //Ecommerce Linea
        LineaEcommerce linea_ecom = new LineaEcommerce();
        if(!cmbLineaEcom.isEmpty()){
            Combobox_Item = cmbLineaEcom.getValue();
            linea_ecom = Services.getProducto().get_ByLineaEcom_nombre(Combobox_Item);
            prod_ecom.setLinea_ecom(linea_ecom);
        }
        //Ecommerce description
        if(!txtaDesc_ecom.isEmpty()){
            prod_ecom.setEcommerce_descrip(txtaDesc_ecom.getValue());
        }
        //Ecommerce precio
        if(!txtPrecioEcom.isEmpty()){
            System.out.println("El precio ecommerce es: " + txtPrecioEcom.getValue());
            prod_ecom.setEcom_precio(BigDecimal.valueOf(Double.valueOf(txtPrecioEcom.getValue())));
            System.out.println("El precio ecommerce es: " + prod_ecom.getEcom_precio());
        }
        
        //Ecommerce Limite de compra por producto
        if(!txtLimiteEcom.isEmpty()){
            prod_ecom.setEcom_limite(Integer.valueOf(txtLimiteEcom.getValue()));
        }
        
        //Ecommerce imagen 1
        if(!txtUpload1.isEmpty()) {prod_ecom.setEcom_img1_nombre(Url_img1);}
        else                      {prod_ecom.setEcom_img1_nombre(img_url1);}
        Services.getProducto().updateProd(prod_ecom);
        grid.getDataProvider().refreshAll();
    }
    //--------------------------------------------------------------------------

    //DIALOG PROMOCION
    public void Clean_Promodialog() {
        txtPromo.setValue("");
    }
    
    @Override
    public void on_Open_Promodialog() {
        Clean_Promodialog();
        Set<Producto> set_prodselect = grid.getSelectedItems();
        removeAll_Prod();
        list_aux = convertSetToList(set_prodselect);
    }
    
    @Override
    public void on_Grabar_Promo() {
        BigDecimal promo = BigDecimal.valueOf(Integer.getInteger(txtPromo.getValue()));
        for(int i=0; i<list_aux.size(); i++){
            list_aux.get(i).setEcom_precio(promo);
            Services.getProducto().updateProd(list_aux.get(i));
        }
        grid.getDataProvider().refreshAll();
    }
    //--------------------------------------------------------------------------
    
    //DIALOG LIMITE COMPRA
    public void Clean_LimiteCdialog() {
        txtLimiteC.setValue("");
    }
    
    @Override
    public void on_Open_LimiteCdialog() {
        Clean_LimiteCdialog();
        Set<Producto> set_prodselect = grid.getSelectedItems();
        removeAll_Prod();
        list_aux = convertSetToList(set_prodselect);
    }

    @Override
    public void on_Grabar_LimiteC() {
        Integer limiteC = Integer.getInteger(txtLimiteC.getValue());
        for(int i=0; i<list_aux.size(); i++){
            list_aux.get(i).setEcom_limite(limiteC);
            Services.getProducto().updateProd(list_aux.get(i));
        }
        grid.getDataProvider().refreshAll();
    }
    //--------------------------------------------------------------------------
    

    
}
