/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.view.ecom;

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
import java.util.Date;
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
public class ProductosView extends ProductosUI{
    //--------------------------------------------------------------------------
    //CPANEL RUTH
    //--------------------------------------------------------------------------
    public App app;
    
    public ProductosView(App app) {
        this.app = app;
    }
    //--------------------------------------------------------------------------
    @Override
    public void go_CPanel(){
        removeAll();
        //this.app.setContent(new CPanelView(app));
        this.app.setContent(new CPanelView2(app));
    }
    //--------------------------------------------------------------------------
    @Override
    public void go_Clientes(){
        this.app.layHeader.removeAll();
        this.app.setContent(new ClientesView(app));
    }
    //--------------------------------------------------------------------------
    @Override
    public void go_Subscriptores(){
        this.app.layHeader.removeAll();
        this.app.setContent(new SubscriptoresView(app));
    }
    //--------------------------------------------------------------------------
    @Override
    public void go_Promociones(){
        this.app.layHeader.removeAll();
        this.app.setContent(new PromocionesView(app));
    }
    //--------------------------------------------------------------------------
    @Override
    public void go_Cupones(){
        this.app.layHeader.removeAll();
        this.app.setContent(new CuponesView(app));
    }
    //--------------------------------------------------------------------------
    @Override
    public void go_PuntosUP(){
        this.app.layHeader.removeAll();
        this.app.setContent(new PuntosUpView(app));
    }
    //--------------------------------------------------------------------------
    @Override
    public void go_Pedidos() {
        this.app.layHeader.removeAll();
        this.app.setContent(new PedidosView(app));
    }
    //--------------------------------------------------------------------------
    @Override
    public void go_LineasEcom(){
        this.app.layHeader.removeAll();
        this.app.setContent(new LineasEcomView(app));
    }
    //--------------------------------------------------------------------------
    @Override
    public void go_Index(){
        this.app.layHeader.removeAll();
        //this.app.setContent(new IndexWebView(app));
        this.app.setContent(new IndexWeb2View(app));
    }
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    List<String> GridCols = new ArrayList<>();
    List<Producto> result = new ArrayList<>();
    List<Producto> list_aux = new ArrayList<>();
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
        Integer stock_added = 0;
        //Lista Productos Agrupados por la Linea Elegida
        result = Services.getProducto().listProd_ByLineaEcom2(linea_bus);   
        for(int i = 0; i < result.size(); i++){
            prod_id = String.valueOf(result.get(i).getId());
            System.out.println("Id prod #" + (i+1) + ", con valor: " + prod_id);
            stock_real = Services.getProducto().getStockReal(prod_id);
            System.out.println("Stock Real: " + stock_real);
            stock_paraVenta = Services.getProducto().getStockPreVenta(prod_id);
            System.out.println("Stock Pre Venta: " + stock_paraVenta);
            VStockPorLlegar StockPorLlegar = new VStockPorLlegar();
            StockPorLlegar = Services.getProducto().getStockParaVentaPorLlegar(prod_id);
            System.out.println("Stock Por Llegar: " + StockPorLlegar.cantidad_por_llegar);
            stock_disponible = 0;
            if(StockPorLlegar.getCantidad_por_llegar() == null){
                if(stock_real >= stock_paraVenta) stock_disponible = stock_real - stock_paraVenta;
                else stock_disponible = 0;
            }
            else {
                stock_added = stock_real + StockPorLlegar.getCantidad_por_llegar();
                if(stock_added >= stock_paraVenta) {stock_disponible = stock_added - stock_paraVenta;}
                else stock_disponible = 0;
                System.out.println("Stock disponible: " + stock_disponible);
            }
            result.get(i).setStock_ecom(stock_disponible);
        }
        grid.setItems(result);
        GridCols = new ArrayList<>();
        init_ReporterToolbar();
        //grid.getColumns().get(5).setVisible(false);
    }
    
    //Busca productos que si han sido marcados como E-commerce
    @Override
    public void On_find_Prodname() {
        String nombre = txtname.getValue();
        Integer stock_added = 0;
        //result = Services.getProducto().listByNombre(nombre);
        result = Services.getProducto().listByNombre_Ecom(nombre);
        for(int i = 0; i < result.size(); i++){
            prod_id = String.valueOf(result.get(i).getId());
            System.out.println("Id prod #" + (i+1) + ", con valor: " + prod_id);
            stock_real = Services.getProducto().getStockReal(prod_id);
            System.out.println("Stock Real: " + stock_real);
            stock_paraVenta = Services.getProducto().getStockPreVenta(prod_id);
            System.out.println("Stock Pre Venta: " + stock_paraVenta);
            VStockPorLlegar StockPorLlegar = new VStockPorLlegar();
            StockPorLlegar = Services.getProducto().getStockParaVentaPorLlegar(prod_id);
            System.out.println("Stock Por Llegar: " + StockPorLlegar.cantidad_por_llegar);
            stock_disponible = 0;
            if(StockPorLlegar.getCantidad_por_llegar() == null){
                if(stock_real >= stock_paraVenta) stock_disponible = stock_real - stock_paraVenta;
                else stock_disponible = 0;
            }
            else {
                stock_added = stock_real + StockPorLlegar.getCantidad_por_llegar();
                if(stock_added >= stock_paraVenta) {stock_disponible = stock_added - stock_paraVenta;}
                else stock_disponible = 0;
                System.out.println("Stock disponible: " + stock_disponible);
            }
            result.get(i).setStock_ecom(stock_disponible);
        }
        grid.setItems(result);
        GridCols = new ArrayList<>();
        init_ReporterToolbar();
        //grid.getColumns().get(5).setVisible(false);
    }
    
    //Busca productos que no han sido marcados como E-commerce
    @Override
    public void On_find_NoEcom() {
        String nombre = txtname.getValue();
        Integer stock_added = 0;
        result = Services.getProducto().listByNombre_NoEcom(nombre);
        for(int i = 0; i < result.size(); i++){
            prod_id = String.valueOf(result.get(i).getId());
            System.out.println("Id prod #" + (i+1) + ", con valor: " + prod_id);
            stock_real = Services.getProducto().getStockReal(prod_id);
            System.out.println("Stock Real: " + stock_real);
            stock_paraVenta = Services.getProducto().getStockPreVenta(prod_id);
            System.out.println("Stock Pre Venta: " + stock_paraVenta);
            VStockPorLlegar StockPorLlegar = new VStockPorLlegar();
            StockPorLlegar = Services.getProducto().getStockParaVentaPorLlegar(prod_id);
            System.out.println("Stock Por Llegar: " + StockPorLlegar.cantidad_por_llegar);
            stock_disponible = 0;
            if(StockPorLlegar.getCantidad_por_llegar() == null){
                if(stock_real >= stock_paraVenta) stock_disponible = stock_real - stock_paraVenta;
                else stock_disponible = 0;
            }
            else {
                stock_added = stock_real + StockPorLlegar.getCantidad_por_llegar();
                if(stock_added >= stock_paraVenta) {stock_disponible = stock_added - stock_paraVenta;}
                else stock_disponible = 0;
                System.out.println("Stock disponible: " + stock_disponible);
            }
            result.get(i).setStock_ecom(stock_disponible);
        }
        grid.setItems(result);
        GridCols = new ArrayList<>();
        init_ReporterToolbar();
        //grid.getColumns().get(5).setVisible(false);
    }
    
    @Override
    public void On_find_Cod() {
        codigo = txtcod.getValue();
        Integer stock_added = 0;
        Producto prod = Services.getProducto().getByCodigo(codigo);
        prod_id = String.valueOf(prod.getId());
        System.out.println("Id prod: " + prod_id);
        VStockPorLlegar StockPorLlegar = new VStockPorLlegar();
        StockPorLlegar = Services.getProducto().getStockParaVentaPorLlegar(prod_id);
        stock_real = Services.getProducto().getStockReal(prod_id);
        System.out.println("Stock Real: " + stock_real);
        if(Services.getProducto().getStockPreVenta(prod_id) == null)
            {stock_paraVenta = 0;}
        else 
            {stock_paraVenta = Services.getProducto().getStockPreVenta(prod_id);}
        System.out.println("Stock Pre Venta: " + stock_paraVenta);
        System.out.println("Stock Por Llegar: " + StockPorLlegar.cantidad_por_llegar);
        stock_disponible = 0;
        if(StockPorLlegar.getCantidad_por_llegar() == null){
            if(stock_real >= stock_paraVenta) stock_disponible = stock_real - stock_paraVenta;
            else stock_disponible = 0;
        }
        else {
            stock_added = stock_real + StockPorLlegar.getCantidad_por_llegar();
            if(stock_added >= stock_paraVenta) {stock_disponible = stock_added - stock_paraVenta;}
            else stock_disponible = 0;
            System.out.println("Stock disponible: " + stock_disponible);
        }
        prod.setStock_ecom(stock_disponible);
        grid.setItems(prod);
        GridCols = new ArrayList<>();
        init_ReporterToolbar();
        //grid.getColumns().get(5).setVisible(false);
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
        GridCols = new ArrayList<>();
        init_ReporterToolbar();
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
    public void on_Upload2(SucceededEvent event) {
        Producto prod = Services.getProducto().getByCodigo(codigo);
        String id_path = String.valueOf(prod.getId());
        path = "";
        try {
            //LECTURA
            InputStream is = buffer2.getInputStream();
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
            Url_img2 = Server.URL_IMAGES + id_path + "_" + event.getFileName();
            txtUpload2.setValue(path);
            img2.setSrc(Url_img2);
            verify_change_Img2 = Boolean.TRUE;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void on_Upload3(SucceededEvent event) {
        Producto prod = Services.getProducto().getByCodigo(codigo);
        String id_path = String.valueOf(prod.getId());
        path = "";
        try {
            //LECTURA
            InputStream is = buffer3.getInputStream();
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
            Url_img3 = Server.URL_IMAGES + id_path + "_" + event.getFileName();
            txtUpload3.setValue(path);
            img3.setSrc(Url_img3);
            verify_change_Img3 = Boolean.TRUE;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    @Override
    public void on_Descartar_img1(){
        txtUpload1.setValue("");
        Url_img1 = "";
        img1.setSrc("");
        verify_change_Img1 = Boolean.TRUE;
    }
    
    @Override
    public void on_Descartar_img2(){
        txtUpload2.setValue("");
        Url_img2 = "";
        img2.setSrc("");
        verify_change_Img2 = Boolean.TRUE;
    }
    
    @Override
    public void on_Descartar_img3(){
        txtUpload3.setValue("");
        Url_img3 = "";
        img3.setSrc("");
        verify_change_Img3 = Boolean.TRUE;
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
        checkPromo.setValue(Boolean.FALSE);
        checkNuevo.setValue(Boolean.FALSE);
        txtNameEcom.setValue("");
        txtLineaEcom.setValue("No definida");
        txtPrecioEcom.setValue("");
        txtLimiteEcom.setValue("");
        txtaDesc_ecom.setValue("");
        txtUpload1.setValue("");
        txtUpload2.setValue("");
        txtUpload3.setValue("");
        img1.setSrc("");
        img2.setSrc("");
        img3.setSrc("");
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
        Producto prod_add = new Producto();
        String prod_cod;
        LineaEcommerce linea_ecom = new LineaEcommerce();
        String limite_ecom;
        Set<Producto> set_prod = grid.getSelectedItems();
        list_aux = new ArrayList<>();
        list_aux = convertSetToList(set_prod);
        
        if(list_aux.size() == 1 && !list_aux.isEmpty()){
        
            prod_cod = list_aux.get(0).getCodigo();
            //prod_cod = grid.getSelectionModel().getFirstSelectedItem().get().getCodigo();
            prod_add = Services.getProducto().getByCodigo(prod_cod);
            System.out.println("El codigo encontrado es: " + prod_add.getCodigo());

            //Utilidad Variables
            prod_util = prod_add;
            prod_det = Services.getProducto().get_ProdDet(String.valueOf(prod_util.getId()));

            //Llenando dialogo Ecommerce
            if(prod_add.getEcommerce() == null) {checkEcom.setValue(Boolean.FALSE);}
            else                                {checkEcom.setValue(prod_add.getEcommerce());}
            if(prod_add.getPromocion() == null) {checkPromo.setValue(Boolean.FALSE);}
            else                                {checkPromo.setValue(prod_add.getPromocion());}
            if(prod_add.getNuevo() == null) {checkNuevo.setValue(Boolean.FALSE);}
            else                                {checkNuevo.setValue(prod_add.getNuevo());}
            
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

            if(prod_add.getEcom_img1_nombre() != null)  
            {img1.setSrc(prod_add.getEcom_img1_nombre());
             Url_img1 = prod_add.getEcom_img1_nombre();
             txtUpload1.setValue(prod_add.getEcom_img1_nombre());
             verify_change_Img1 = Boolean.FALSE;}
            else                                        
            {img1.setSrc("");
             Url_img1 = "";
             txtUpload2.setValue(""); 
             verify_change_Img1 = Boolean.FALSE;}

            if(prod_add.getEcom_img2_nombre() != null)  
            {img2.setSrc(prod_add.getEcom_img2_nombre());
             Url_img2 = prod_add.getEcom_img2_nombre();
             txtUpload2.setValue(prod_add.getEcom_img2_nombre());
             verify_change_Img2 = Boolean.FALSE;}
            else                                        
            {img2.setSrc("");
             Url_img2 = "";
             txtUpload2.setValue("");
             verify_change_Img2 = Boolean.FALSE;}

            if(prod_add.getEcom_img3_nombre() != null)  
            {img3.setSrc(prod_add.getEcom_img3_nombre());
             Url_img3 = prod_add.getEcom_img3_nombre();
             txtUpload3.setValue(prod_add.getEcom_img3_nombre());
             verify_change_Img3 = Boolean.FALSE;}
            else                                        
            {img3.setSrc("");
             Url_img3 = "";
             txtUpload3.setValue("");
             verify_change_Img3 = Boolean.FALSE;}

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
        prod_ecom.setPromocion(checkPromo.getValue());
        prod_ecom.setNuevo(checkNuevo.getValue());
            
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
        //Ecommerce imagen 2
        if(!txtUpload2.isEmpty()) {prod_ecom.setEcom_img2_nombre(Url_img2);}
        else                      {prod_ecom.setEcom_img2_nombre(img_url2);}
        //Ecommerce imagen 3
        if(!txtUpload3.isEmpty()) {prod_ecom.setEcom_img3_nombre(Url_img3);}
        else                      {prod_ecom.setEcom_img3_nombre(img_url3);}
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
    //--------------------------------------------------------------------------
    //REPORTEADOR
    //--------------------------------------------------------------------------
    public void init_GridCols(){
        GridCols = new ArrayList<>();
        
        GridCols.add("Codigo");
        GridCols.add("Nombre");
        GridCols.add("Descripcion Ecommerce");
        GridCols.add("Stock Disponible");
    }
    //--------------------------------------------------------------------------
    @Override
    public void init_ReporterToolbar(){
        //Cols
        init_GridCols();
        Toolbar.set_ColumnData2(GridCols);
        
        
        //Rows
        String codigo = "";
        String nombre = "";
        String descrip_ecom = "";
        Integer stock = 0;
        
        int L_gridContent_size = result.size();
        Integer objectContent_size = GridCols.size();
        
        Toolbar.set_RowData(L_gridContent_size,objectContent_size);
        for(int i = 0; i < L_gridContent_size; i++){
            codigo = "";
            if(result.get(i).getCodigo() != null){codigo = result.get(i).getCodigo();}    
            System.out.println("Codigo: " + codigo);
            Toolbar.ROWS[i].add(codigo);
            
            nombre = "";
            if(result.get(i).getNombre() != null){nombre = result.get(i).getNombre();}
            System.out.println("Nombre: " + nombre);
            Toolbar.ROWS[i].add(nombre);
            
            descrip_ecom = "";
            if(result.get(i).getDescripcion() != null){descrip_ecom = result.get(i).getDescripcion();}
            System.out.println("Descripcion Ecommerce: " + descrip_ecom);
            Toolbar.ROWS[i].add(descrip_ecom);
            
            stock = 0;
            if(result.get(i).getStock_ecom() != null){stock = result.get(i).getStock_ecom();}
            System.out.println("stock: " + stock);
            Toolbar.ROWS[i].add(stock);
        }
        
        //Usuario
        Toolbar.set_UsuarioID("_");
        
        //Módulo
        Toolbar.set_Module("PRODUCTOSECOM");
    }
    //--------------------------------------------------------------------------
    @Override
    public void init_ReporterToolbar_default(){
        //Cols && Rows
        Toolbar.Generate_Table_default();
        
        //Usuario
        Toolbar.set_UsuarioID("_");
        
        //Módulo
        Toolbar.set_Module("PRODUCTOSECOM");
    }
    //--------------------------------------------------------------------------

    
}
