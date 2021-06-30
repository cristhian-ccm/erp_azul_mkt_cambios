/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.view.ecom;

import com.upgrade.persistence.model.ecommerce.Banners;
import com.upgrade.persistence.model.ecommerce.IndexWeb;
import com.upgrade.persistence.model.ecommerce.LineaEcommerce;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.upload.SucceededEvent;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
import up.erp.server.Server;
import up.erp.service.Services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import up.erp.view.App;

//import static sun.net.www.protocol.http.AuthCacheValue.Type.Server;

/**
 *
 * @author Luis Aleman
 */
public class IndexWebView extends IndexWebUI{
    //--------------------------------------------------------------------------
    //CPANEL RUTH
    //--------------------------------------------------------------------------
    public App app;
    
    public IndexWebView(App app) {
        this.app = app;
    }
    
    //--------------------------------------------------------------------------
    @Override
    public void go_CPanel(){
        removeAll();
        this.app.setContent(new CPanelView(app));
    }
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    public PedidosView pedidoView;
    
    @Override
    public void go_Pedidos() {
        this.app.layHeader.removeAll();
        this.app.setContent(new PedidosView(app));
    }
    //--------------------------------------------------------------------------
    @Override
    public void go_Clientes(){
       this.app.layHeader.removeAll();
       this.app.setContent(new ClientesView(app));
    }
    //--------------------------------------------------------------------------
    @Override
    public void go_Productos(){
       this.app.layHeader.removeAll();
       this.app.setContent(new ProductosView(app));
    }
    //--------------------------------------------------------------------------
    @Override
    public void go_LineasEcom(){
       this.app.layHeader.removeAll();
       this.app.setContent(new LineasEcomView(app));
    }
    //--------------------------------------------------------------------------
    @Override
    public void go_Cupones(){
        this.app.layHeader.removeAll();
        this.app.setContent(new CuponesView(app));
    }
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    
    //HEAD
    String path_H = "";
    String Url_img_head = "";
    
    //SLIDERS
    String path_slider1 = "";
    String path_slider2 = "";
    String path_slider3 = "";
    String path_slider4 = "";
    
    String Url_img1_slider = "";
    String Url_img2_slider = "";
    String Url_img3_slider = "";
    String Url_img4_slider = "";
    
    //FOOTER
    String path_F = "";
    String Url_img_foot = "";
    //----------------------------------------------------------------------------------
    //DIALOG LINEA ECOMMERCE
    
    //POSICION
    Integer posicion;
    
    //UPLOAD LINEA
    String path_linea = "";
    String Url_img_linea = "";
        
    //BANNERS ACTIVOS
    List<LineaEcommerce> L_Linea_ecom = new ArrayList<>();
    List<Banners> L_Banners = new ArrayList<>();
    Integer iterator_L_Banners = 0;
    List<Banners> L_Banners_aux = new ArrayList<>();
    String id_banner = "";
    //----------------------------------------------------------------------------------
    @Override
    public void init_Sliders(){
        IndexWeb last_index = new IndexWeb();
        last_index = Services.getIndexWeb().get_LastIndexWeb();
        String Url_slider1 = "";
        String Url_slider2 = "";
        String Url_slider3 = "";
        
        Url_slider1 = last_index.getRutaimg1_slider();
        Url_slider2 = last_index.getRutaimg2_slider();
        Url_slider3 = last_index.getRutaimg3_slider();
        
        if(Url_slider1 != null)  {imgB1.setSrc(Url_slider1);}
        else                     {imgB1.setSrc("");}
        
        if(Url_slider2 != null)  {imgB2.setSrc(Url_slider2);}
        else                     {imgB2.setSrc("");}
        if(Url_slider3 != null)  {imgB3.setSrc(Url_slider3);}
        else                     {imgB3.setSrc("");}
        
    }
    
    //FUNCION UPLOAD
    private void onUpload(MemoryBuffer mbuffer, String path_slider, String fileName,
            Image image, String url_image, TextField txt) {
        path_slider = ""; 
        try {
            //LECTURA
            InputStream is = mbuffer.getInputStream();
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            path_slider = Server.PATH_IMAGES + fileName;
            
            //ESCRITURA
            File newFile = new File(path_slider);
            OutputStream out = new FileOutputStream(newFile);
            out.write(buffer);
            out.close();
            is.close();
            
            //CARGA IMAGEN
            url_image = Server.URL_IMAGES + fileName;
            txt.setValue(path_slider);
            image.setSrc(url_image);
        
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    //----------------------------------------------------------------------------------
    
    //UPLOAD HEAD
    @Override
    public void on_UploadH(SucceededEvent event) {
        //onUpload(bufferHead,path_H,event.getFileName(),imgH1,Url_img_head,txtHUpload1);
        path_H = "";
        try {
            
            //LECTURA
            InputStream is = bufferHead.getInputStream();
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            path_H = Server.PATH_IMAGES + event.getFileName();
            
            //ESCRITURA
            File newFile = new File(path_H);
            OutputStream out = new FileOutputStream(newFile);
            out.write(buffer);
            out.close();
            is.close();
            
            //CARGA IMAGEN
            Url_img_head = Server.URL_IMAGES + event.getFileName();
            txtHUpload1.setValue(path_H);
            imgH1.setSrc(Url_img_head);
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    //----------------------------------------------------------------------------------
    
    //UPLOAD SLIDER 1
    @Override
    public void on_UploadS1(SucceededEvent event) {
        //onUpload(bufferSlider1,path_slider1,event.getFileName(),imgB1,Url_img1_slider,txtBUpload1);
        path_slider1 = "";
        try {
            
            //LECTURA
            InputStream is = bufferSlider1.getInputStream();
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            path_slider1 = Server.PATH_IMAGES + event.getFileName();
            
            //ESCRITURA
            File newFile = new File(path_slider1);
            OutputStream out = new FileOutputStream(newFile);
            out.write(buffer);
            out.close();
            is.close();
            
            //CARGA IMAGEN
            Url_img1_slider = Server.URL_IMAGES + event.getFileName();
            txtBUpload1.setValue(path_slider1);
            imgB1.setSrc(Url_img1_slider);
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    //UPLOAD SLIDER 2
    @Override
    public void on_UploadS2(SucceededEvent event) {
        //onUpload(bufferSlider2,path_slider2,event.getFileName(),imgB2,Url_img2_slider,txtBUpload2);
        path_slider2 = "";
        try {
            
            //LECTURA
            InputStream is = bufferSlider2.getInputStream();
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            path_slider2 = Server.PATH_IMAGES + event.getFileName();
            
            //ESCRITURA
            File newFile = new File(path_slider2);
            OutputStream out = new FileOutputStream(newFile);
            out.write(buffer);
            out.close();
            is.close();
            
            //CARGA IMAGEN
            Url_img2_slider = Server.URL_IMAGES + event.getFileName();
            txtBUpload2.setValue(path_slider2);
            imgB2.setSrc(Url_img2_slider);
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    //UPLOAD SLIDER 3
    @Override
    public void on_UploadS3(SucceededEvent event) {
        //onUpload(bufferSlider3,path_slider3,event.getFileName(),imgB3,Url_img3_slider,txtBUpload3);
        path_slider3 = "";
        try {
            
            //LECTURA
            InputStream is = bufferSlider3.getInputStream();
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            path_slider3 = Server.PATH_IMAGES + event.getFileName();
            
            //ESCRITURA
            File newFile = new File(path_slider3);
            OutputStream out = new FileOutputStream(newFile);
            out.write(buffer);
            out.close();
            is.close();
            
            //CARGA IMAGEN
            Url_img3_slider = Server.URL_IMAGES + event.getFileName();
            txtBUpload3.setValue(path_slider3);
            imgB3.setSrc(Url_img3_slider);
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    //UPLOAD SLIDER 4
    @Override
    public void on_UploadS4(SucceededEvent event) {
        //onUpload(bufferSlider3,path_slider3,event.getFileName(),imgB3,Url_img3_slider,txtBUpload3);
        path_slider4 = "";
        try {
            
            //LECTURA
            InputStream is = bufferSlider4.getInputStream();
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            path_slider4 = Server.PATH_IMAGES + event.getFileName();
            
            //ESCRITURA
            File newFile = new File(path_slider4);
            OutputStream out = new FileOutputStream(newFile);
            out.write(buffer);
            out.close();
            is.close();
            
            //CARGA IMAGEN
            Url_img4_slider = Server.URL_IMAGES + event.getFileName();
            txtBUpload4.setValue(path_slider4);
            imgB4.setSrc(Url_img4_slider);
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    //----------------------------------------------------------------------------------
    
    //UPLOAD FOOTER
    @Override
    public void on_UploadF(SucceededEvent event) {
        //onUpload(bufferFoot,path_F,event.getFileName(),imgF1,Url_img_foot,txtFUpload1);
        path_F = "";
        try {
            //LECTURA
            InputStream is = bufferFoot.getInputStream();
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            path_F = Server.PATH_IMAGES + event.getFileName();
            //ESCRITURA
            File newFile = new File(path_F);
            OutputStream out = new FileOutputStream(newFile);
            out.write(buffer);
            out.close();
            //CARGA IMAGEN
            Url_img_foot = Server.URL_IMAGES + event.getFileName();
            txtFUpload1.setValue(path_F);
            imgF1.setSrc(Url_img_foot);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    //----------------------------------------------------------------------------------
    
    @Override
    public void on_Grabar() {
        IndexWeb index_web = new IndexWeb();
        if(!txtHUpload1.isEmpty()){
            System.out.println("Ruta Imagen Head: " + Url_img_head);
            index_web.setRutaimg_head(Url_img_head);
        } 
        
        index_web.setTitulo_slider(txtTituloSlider.getValue());
        index_web.setSubtitulo_slider(txtSubtituloSlider.getValue());
        
        if(!txtBUpload1.isEmpty()){
            System.out.println("Ruta Imagen Slider 1: " + Url_img1_slider);
            index_web.setRutaimg1_slider(Url_img1_slider);
        } 
        
        if(!txtBUpload2.isEmpty()){
            System.out.println("Ruta Imagen Slider 2: " + Url_img2_slider);
            index_web.setRutaimg2_slider(Url_img2_slider);
        }  
        
        if(!txtBUpload3.isEmpty()){
            System.out.println("Ruta Imagen Slider 3: " + Url_img3_slider);
            index_web.setRutaimg3_slider(Url_img3_slider);
        } 
        /*
        if(!txtBUpload4.isEmpty()){
            System.out.println("Ruta Imagen Slider 4: " + Url_img4_slider);
            index_web.setRutaimg4_slider(Url_img4_slider);
        }  
        */
        index_web.setTitulo_linea1(txtTituloLinea1.getValue());
        index_web.setSubtitulo_linea1(txtSubtituloLinea1.getValue());
        
        index_web.setTitulo_linea2(txtTituloLinea2.getValue());
        index_web.setSubtitulo_linea2(txtSubtituloLinea2.getValue());

        index_web.setTitulo_linea3(txtTituloLinea3.getValue());
        index_web.setSubtitulo_linea3(txtSubtituloLinea3.getValue());
        
        index_web.setTitulo_foot(txtTituloFoot.getValue());
        index_web.setDescrip_foot(txtAreaFoot.getValue());
        if(!txtFUpload1.isEmpty()){
            index_web.setRutaimg_foot(Url_img_foot);
        } 
        
        Services.getIndexWeb().save_IndexWeb(index_web);
    }
    
    //-----------------------------------------------------------------------------------------------------------
    //DIALOG BANNER - LINEA ECOMMERCE
    
    //NUEVO BANNER
    //UPLOAD LINEA ECOMMERCE
    @Override
    public void on_UploadLinea_Ecom(SucceededEvent event) {
        //onUpload(bufferLinea1,path_linea1,event.getFileName(),imgL1,Url_img_linea1,txtLUpload1);
        path_linea = "";
        try {
            
            //LECTURA
            InputStream is = bufferLinea.getInputStream();
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            path_linea = Server.PATH_IMAGES + event.getFileName();
            
            //ESCRITURA
            File newFile = new File(path_linea);
            OutputStream out = new FileOutputStream(newFile);
            out.write(buffer);
            out.close();
            is.close();
            
            //CARGA IMAGEN
            Url_img_linea = Server.URL_IMAGES + event.getFileName();
            txtdialog_Upload.setValue(path_linea);
            dialog_img.setSrc(Url_img_linea);
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    //-----------------------------------------------------------------------------------------------------------
    
    //OPEN DIALOG
    
    @Override
    public void init_Banners(){
        //BANNER ACTIVO 1
        
        Integer posicion;
        posicion = 1;
        String pos = String.valueOf(posicion);
        Banners banner = new Banners();
        banner = Services.getIndexWeb().get_Banner_Act(pos);
        LineaEcommerce l_ecom = new LineaEcommerce();
        if(banner == null){
            banner = new Banners();
            l_ecom = new LineaEcommerce();
            txtLEcom_Linea1.setValue("No Definida");
            txtTituloLinea1.setValue("");
            txtSubtituloLinea1.setValue("");
            txtPos_Linea1.setValue("");
            imgL1.setSrc("");
        }
        else{
            l_ecom = new LineaEcommerce();
            l_ecom = banner.getLinea_ecom();
            
            if (l_ecom == null) {txtLEcom_Linea1.setValue("No Definida");}
            else                {txtLEcom_Linea1.setValue(l_ecom.getNombre());}
            
            if (banner.getTitulo() == null) {txtTituloLinea1.setValue("");}
            else                            {txtTituloLinea1.setValue(banner.getTitulo());}
            
            if (banner.getSubtitulo() == null)  {txtSubtituloLinea1.setValue("");}
            else                                {txtSubtituloLinea1.setValue(banner.getSubtitulo());}
            
            txtPos_Linea1.setValue(pos);
            
            if (banner.getUrl_image() == null)  {imgL1.setSrc("");}
            else                                {imgL1.setSrc(banner.getUrl_image());}
            
        }
        //----------------------------------------------------------------------
        
        //BANNER ACTIVO 2
        
        posicion = 2;
        pos = String.valueOf(posicion);
        banner = new Banners();
        banner = Services.getIndexWeb().get_Banner_Act(pos);
        l_ecom = new LineaEcommerce();
        if(banner == null){
            banner = new Banners();
            l_ecom = new LineaEcommerce();
            txtLEcom_Linea2.setValue("No Definida");
            txtTituloLinea2.setValue("");
            txtSubtituloLinea2.setValue("");
            txtPos_Linea2.setValue("");
            imgL2.setSrc("");
        }
        else{
            l_ecom = new LineaEcommerce();
            l_ecom = banner.getLinea_ecom();
            
            if (l_ecom == null) {txtLEcom_Linea2.setValue("No Definida");}
            else                {txtLEcom_Linea2.setValue(l_ecom.getNombre());}
            
            if (banner.getTitulo() == null) {txtTituloLinea2.setValue("");}
            else                            {txtTituloLinea2.setValue(banner.getTitulo());}
            
            if (banner.getSubtitulo() == null)  {txtSubtituloLinea2.setValue("");}
            else                                {txtSubtituloLinea2.setValue(banner.getSubtitulo());}
            
            txtPos_Linea2.setValue(pos);
            
            if (banner.getUrl_image() == null)  {imgL2.setSrc("");}
            else                                {imgL2.setSrc(banner.getUrl_image());}
            
        }
        //----------------------------------------------------------------------
        
        //BANNER ACTIVO 3
        
        posicion = 3;
        pos = String.valueOf(posicion);
        banner = new Banners();
        banner = Services.getIndexWeb().get_Banner_Act(pos);
        l_ecom = new LineaEcommerce();
        if(banner == null){
            banner = new Banners();
            l_ecom = new LineaEcommerce();
            txtLEcom_Linea3.setValue("No Definida");
            txtTituloLinea3.setValue("");
            txtSubtituloLinea3.setValue("");
            txtPos_Linea3.setValue("");
            imgL3.setSrc("");
        }
        else{
            l_ecom = new LineaEcommerce();
            l_ecom = banner.getLinea_ecom();
            
            if (l_ecom == null) {txtLEcom_Linea3.setValue("No Definida");}
            else                {txtLEcom_Linea3.setValue(l_ecom.getNombre());}
            
            if (banner.getTitulo() == null) {txtTituloLinea3.setValue("");}
            else                            {txtTituloLinea3.setValue(banner.getTitulo());}
            
            if (banner.getSubtitulo() == null)  {txtSubtituloLinea3.setValue("");}
            else                                {txtSubtituloLinea3.setValue(banner.getSubtitulo());}
            
            txtPos_Linea3.setValue(pos);
            
            if (banner.getUrl_image() == null)  {imgL3.setSrc("");}
            else                                {imgL3.setSrc(banner.getUrl_image());}
            
        }
        //----------------------------------------------------------------------
        
        //BANNER ACTIVO 4
        
        posicion = 4;
        pos = String.valueOf(posicion);
        banner = new Banners();
        banner = Services.getIndexWeb().get_Banner_Act(pos);
        l_ecom = new LineaEcommerce();
        if(banner == null){
            banner = new Banners();
            l_ecom = new LineaEcommerce();
            txtLEcom_Linea4.setValue("No Definida");
            txtTituloLinea4.setValue("");
            txtSubtituloLinea4.setValue("");
            txtPos_Linea4.setValue("");
            imgL4.setSrc("");
        }
        else{
            l_ecom = new LineaEcommerce();
            l_ecom = banner.getLinea_ecom();
            
            if (l_ecom == null) {txtLEcom_Linea4.setValue("No Definida");}
            else                {txtLEcom_Linea4.setValue(l_ecom.getNombre());}
            
            if (banner.getTitulo() == null) {txtTituloLinea4.setValue("");}
            else                            {txtTituloLinea4.setValue(banner.getTitulo());}
            
            if (banner.getSubtitulo() == null)  {txtSubtituloLinea4.setValue("");}
            else                                {txtSubtituloLinea4.setValue(banner.getSubtitulo());}
            
            txtPos_Linea4.setValue(pos);
            
            if (banner.getUrl_image() == null)  {imgL4.setSrc("");}
            else                                {imgL4.setSrc(banner.getUrl_image());}
            
        }
        //----------------------------------------------------------------------
        
        //BANNER ACTIVO 5
        
        posicion = 5;
        pos = String.valueOf(posicion);
        banner = new Banners();
        banner = Services.getIndexWeb().get_Banner_Act(pos);
        l_ecom = new LineaEcommerce();
        if(banner == null){
            banner = new Banners();
            l_ecom = new LineaEcommerce();
            txtLEcom_Linea5.setValue("No Definida");
            txtTituloLinea5.setValue("");
            txtSubtituloLinea5.setValue("");
            txtPos_Linea5.setValue("");
            imgL5.setSrc("");
        }
        else{
            l_ecom = new LineaEcommerce();
            l_ecom = banner.getLinea_ecom();
            
            if (l_ecom == null) {txtLEcom_Linea5.setValue("No Definida");}
            else                {txtLEcom_Linea5.setValue(l_ecom.getNombre());}
            
            if (banner.getTitulo() == null) {txtTituloLinea5.setValue("");}
            else                            {txtTituloLinea5.setValue(banner.getTitulo());}
            
            if (banner.getSubtitulo() == null)  {txtSubtituloLinea5.setValue("");}
            else                                {txtSubtituloLinea5.setValue(banner.getSubtitulo());}
            
            txtPos_Linea5.setValue(pos);
            
            if (banner.getUrl_image() == null)  {imgL5.setSrc("");}
            else                                {imgL5.setSrc(banner.getUrl_image());}
        }
        //----------------------------------------------------------------------
        
        //BANNER ACTIVO 6
        
        posicion = 6;
        pos = String.valueOf(posicion);
        banner = new Banners();
        banner = Services.getIndexWeb().get_Banner_Act(pos);
        l_ecom = new LineaEcommerce();
        if(banner == null){
            banner = new Banners();
            l_ecom = new LineaEcommerce();
            txtLEcom_Linea6.setValue("No Definida");
            txtTituloLinea6.setValue("");
            txtSubtituloLinea6.setValue("");
            txtPos_Linea6.setValue("");
            imgL6.setSrc("");
        }
        else{
            l_ecom = new LineaEcommerce();
            l_ecom = banner.getLinea_ecom();
            
            if (l_ecom == null) {txtLEcom_Linea6.setValue("No Definida");}
            else                {txtLEcom_Linea6.setValue(l_ecom.getNombre());}
            
            if (banner.getTitulo() == null) {txtTituloLinea6.setValue("");}
            else                            {txtTituloLinea6.setValue(banner.getTitulo());}
            
            if (banner.getSubtitulo() == null)  {txtSubtituloLinea6.setValue("");}
            else                                {txtSubtituloLinea6.setValue(banner.getSubtitulo());}
            
            txtPos_Linea6.setValue(pos);
            
            if (banner.getUrl_image() == null)  {imgL6.setSrc("");}
            else                                {imgL6.setSrc(banner.getUrl_image());}
        }
        //----------------------------------------------------------------------
    }
    
    public List<String> get_AllLineaEcommerce(){
        List<LineaEcommerce> list_Linea_ecom = new ArrayList<>();
        List<String> list_linea = new ArrayList<>();
        list_Linea_ecom = Services.getProducto().listLineaEcom();
        for (int i = 0; i < list_Linea_ecom.size(); i++){
            list_linea.add(list_Linea_ecom.get(i).getNombre());
        }
        //cmbLineaEcom.setItems(list_linea);
        return list_linea;
    }
    
    @Override
    public void On_Open_dialog_Banner1(){
        //NUEVO BANNER
        txtdialog_TLEcom.setValue("");
        txtdialog_SubtLEcom.setValue("");
        
        String pos = String.valueOf(1);
        posicion = 1; 
        txtdialog2_TitPos.setValue(pos);
        txtdialog_PosLEcom.setValue(pos);
        
        List<String> list_linea = new ArrayList<>();
        list_linea = get_AllLineaEcommerce();
        cmbdialog_LEcom.setItems(list_linea);
        
        txtdialog_Upload.setValue("");
        txtdialog_Upload.setReadOnly(true);
        dialog_CheckActivation.setValue(Boolean.FALSE);
        
        //BANNER ACTIVO
        L_Banners = new ArrayList<>();
        L_Banners = Services.getIndexWeb().get_ListBanners_byPos(pos);
        Banners banner = new Banners();
        LineaEcommerce l_ecom = new LineaEcommerce(); 
        cmbdialog2_LEcom.setItems(list_linea);
        if(!L_Banners.isEmpty()){
            banner = L_Banners.get(0);
            iterator_L_Banners = 0;
            l_ecom = new LineaEcommerce();
            l_ecom = banner.getLinea_ecom();
            
            id_banner = String.valueOf(banner.getId());
            txtdialog2_LEcom.setValue(l_ecom.getNombre());
            txtdialog2_TLEcom.setValue(banner.getTitulo());
            txtdialog2_SubtLEcom.setValue(banner.getSubtitulo());
            txtdialog2_PosLEcom.setValue(pos);
            dialog2_img.setSrc(banner.getUrl_image());
            dialog2_CheckActivation.setValue(banner.getActivo());
        }
    }
    
    @Override
    public void On_Open_dialog_Banner2(){
        //NUEVO BANNER
        txtdialog_TLEcom.setValue("");
        txtdialog_SubtLEcom.setValue("");
        
        String pos = String.valueOf(2);
        posicion = 2; 
        txtdialog2_TitPos.setValue(pos);
        txtdialog_PosLEcom.setValue(pos);
        
        List<String> list_linea = new ArrayList<>();
        list_linea = get_AllLineaEcommerce();
        cmbdialog_LEcom.setItems(list_linea);
        
        txtdialog_Upload.setValue("");
        txtdialog_Upload.setReadOnly(true);
        dialog_CheckActivation.setValue(Boolean.FALSE);
        
        //BANNER ACTIVO
        L_Banners = new ArrayList<>();
        L_Banners = Services.getIndexWeb().get_ListBanners_byPos(pos);
        Banners banner = new Banners();
        LineaEcommerce l_ecom = new LineaEcommerce(); 
        cmbdialog2_LEcom.setItems(list_linea);
        if(!L_Banners.isEmpty()){
            banner = L_Banners.get(0);
            iterator_L_Banners = 0;
            l_ecom = new LineaEcommerce();
            l_ecom = banner.getLinea_ecom();
            
            id_banner = String.valueOf(banner.getId());
            txtdialog2_LEcom.setValue(l_ecom.getNombre());
            txtdialog2_TLEcom.setValue(banner.getTitulo());
            txtdialog2_SubtLEcom.setValue(banner.getSubtitulo());
            txtdialog2_PosLEcom.setValue(pos);
            dialog2_img.setSrc(banner.getUrl_image());
            dialog2_CheckActivation.setValue(banner.getActivo());
        }
    }
    
    @Override
    public void On_Open_dialog_Banner3(){
        //NUEVO BANNER
        txtdialog_TLEcom.setValue("");
        txtdialog_SubtLEcom.setValue("");
        
        String pos = String.valueOf(3);
        posicion = 3; 
        txtdialog2_TitPos.setValue(pos);
        txtdialog_PosLEcom.setValue(pos);
        
        List<String> list_linea = new ArrayList<>();
        list_linea = get_AllLineaEcommerce();
        cmbdialog_LEcom.setItems(list_linea);
        
        txtdialog_Upload.setValue("");
        txtdialog_Upload.setReadOnly(true);
        dialog_CheckActivation.setValue(Boolean.FALSE);
        
        //BANNER ACTIVO
        L_Banners = new ArrayList<>();
        L_Banners = Services.getIndexWeb().get_ListBanners_byPos(pos);
        Banners banner = new Banners();
        LineaEcommerce l_ecom = new LineaEcommerce(); 
        cmbdialog2_LEcom.setItems(list_linea);
        if(!L_Banners.isEmpty()){
            banner = L_Banners.get(0);
            iterator_L_Banners = 0;
            l_ecom = new LineaEcommerce();
            l_ecom = banner.getLinea_ecom();
            
            id_banner = String.valueOf(banner.getId());
            txtdialog2_LEcom.setValue(l_ecom.getNombre());
            txtdialog2_TLEcom.setValue(banner.getTitulo());
            txtdialog2_SubtLEcom.setValue(banner.getSubtitulo());
            txtdialog2_PosLEcom.setValue(pos);
            dialog2_img.setSrc(banner.getUrl_image());
            dialog2_CheckActivation.setValue(banner.getActivo());
        }
    }
    
    @Override
    public void On_Open_dialog_Banner4(){
        //NUEVO BANNER
        txtdialog_TLEcom.setValue("");
        txtdialog_SubtLEcom.setValue("");
        
        String pos = String.valueOf(4);
        posicion = 4; 
        txtdialog2_TitPos.setValue(pos);
        txtdialog_PosLEcom.setValue(pos);
        
        List<String> list_linea = new ArrayList<>();
        list_linea = get_AllLineaEcommerce();
        cmbdialog_LEcom.setItems(list_linea);
        
        txtdialog_Upload.setValue("");
        txtdialog_Upload.setReadOnly(true);
        dialog_CheckActivation.setValue(Boolean.FALSE);
        
        //BANNER ACTIVO
        L_Banners = new ArrayList<>();
        L_Banners = Services.getIndexWeb().get_ListBanners_byPos(pos);
        Banners banner = new Banners();
        LineaEcommerce l_ecom = new LineaEcommerce(); 
        cmbdialog2_LEcom.setItems(list_linea);
        if(!L_Banners.isEmpty()){
            banner = L_Banners.get(0);
            iterator_L_Banners = 0;
            l_ecom = new LineaEcommerce();
            l_ecom = banner.getLinea_ecom();
            
            id_banner = String.valueOf(banner.getId());
            txtdialog2_LEcom.setValue(l_ecom.getNombre());
            txtdialog2_TLEcom.setValue(banner.getTitulo());
            txtdialog2_SubtLEcom.setValue(banner.getSubtitulo());
            txtdialog2_PosLEcom.setValue(pos);
            dialog2_img.setSrc(banner.getUrl_image());
            dialog2_CheckActivation.setValue(banner.getActivo());
        }
    }
    
    @Override
    public void On_Open_dialog_Banner5(){
        //NUEVO BANNER
        txtdialog_TLEcom.setValue("");
        txtdialog_SubtLEcom.setValue("");
        
        String pos = String.valueOf(5);
        posicion = 5; 
        txtdialog2_TitPos.setValue(pos);
        txtdialog_PosLEcom.setValue(pos);
        
        List<String> list_linea = new ArrayList<>();
        list_linea = get_AllLineaEcommerce();
        cmbdialog_LEcom.setItems(list_linea);
        
        txtdialog_Upload.setValue("");
        txtdialog_Upload.setReadOnly(true);
        dialog_CheckActivation.setValue(Boolean.FALSE);
        
        //BANNER ACTIVO
        L_Banners = new ArrayList<>();
        L_Banners = Services.getIndexWeb().get_ListBanners_byPos(pos);
        Banners banner = new Banners();
        LineaEcommerce l_ecom = new LineaEcommerce(); 
        cmbdialog2_LEcom.setItems(list_linea);
        if(!L_Banners.isEmpty()){
            banner = L_Banners.get(0);
            iterator_L_Banners = 0;
            l_ecom = new LineaEcommerce();
            l_ecom = banner.getLinea_ecom();
            
            id_banner = String.valueOf(banner.getId());
            txtdialog2_LEcom.setValue(l_ecom.getNombre());
            txtdialog2_TLEcom.setValue(banner.getTitulo());
            txtdialog2_SubtLEcom.setValue(banner.getSubtitulo());
            txtdialog2_PosLEcom.setValue(pos);
            dialog2_img.setSrc(banner.getUrl_image());
            dialog2_CheckActivation.setValue(banner.getActivo());
        }
    }
    
    @Override
    public void On_Open_dialog_Banner6(){
        //NUEVO BANNER
        txtdialog_TLEcom.setValue("");
        txtdialog_SubtLEcom.setValue("");
        
        String pos = String.valueOf(6);
        posicion = 6; 
        txtdialog2_TitPos.setValue(pos);
        txtdialog_PosLEcom.setValue(pos);
        
        List<String> list_linea = new ArrayList<>();
        list_linea = get_AllLineaEcommerce();
        cmbdialog_LEcom.setItems(list_linea);
        
        txtdialog_Upload.setValue("");
        txtdialog_Upload.setReadOnly(true);
        dialog_CheckActivation.setValue(Boolean.FALSE);
        
        //BANNER ACTIVO
        L_Banners = new ArrayList<>();
        L_Banners = Services.getIndexWeb().get_ListBanners_byPos(pos);
        Banners banner = new Banners();
        LineaEcommerce l_ecom = new LineaEcommerce(); 
        cmbdialog2_LEcom.setItems(list_linea);
        if(!L_Banners.isEmpty()){
            banner = L_Banners.get(0);
            iterator_L_Banners = 0;
            l_ecom = new LineaEcommerce();
            l_ecom = banner.getLinea_ecom();
            
            id_banner = String.valueOf(banner.getId());
            txtdialog2_LEcom.setValue(l_ecom.getNombre());
            txtdialog2_TLEcom.setValue(banner.getTitulo());
            txtdialog2_SubtLEcom.setValue(banner.getSubtitulo());
            txtdialog2_PosLEcom.setValue(pos);
            dialog2_img.setSrc(banner.getUrl_image());
            dialog2_CheckActivation.setValue(banner.getActivo());
        }
    }
    //-----------------------------------------------------------------------------------------------------------
    
    //OBTIENE LISTA DE LINEA ECOMMERCE ACTIVAS
    public List<LineaEcommerce> solo_LEcom_Act(){
        L_Linea_ecom = new ArrayList<>();
        L_Banners = new ArrayList<>();
        //Obteniendo los Banners activados
        L_Banners = Services.getIndexWeb().get_Banners_Act();
        
        LineaEcommerce linea_Ecom_Act = new LineaEcommerce();
        for(int i=0; i < L_Banners.size(); i++){
            linea_Ecom_Act = L_Banners.get(i).getLinea_ecom();
            if (linea_Ecom_Act == null){
                linea_Ecom_Act = new LineaEcommerce();
            }
            L_Linea_ecom.add(linea_Ecom_Act);
        }
        return L_Linea_ecom;
    }
    
    public Boolean is_Banner_Act(String posicion){
        Boolean resp = Boolean.FALSE;
        Banners banner = new Banners();
        banner = Services.getIndexWeb().get_Banner_Act(posicion);
        if(banner != null){
            resp = Boolean.TRUE;
        }
        return resp;
    }
    
    public Boolean is_Any_Banner_Act(String posicion){
        Boolean resp = Boolean.FALSE;
        //Banners banner = new Banners();
        //banner = Services.getIndexWeb().get_Banner_Act(posicion);
        resp = Services.getIndexWeb().is_Banner_Act(posicion);
        return resp;
    }
    
    //CHECK ACTIVATION
    /*
    @Override
    public void On_Click_CheckActivation(){
        Boolean activado = Boolean.FALSE;
        String posicion_Banner = "";
        posicion_Banner = String.valueOf(posicion);
        activado = is_Banner_Act(posicion_Banner);
        if(activado == Boolean.TRUE){
            System.out.println("El banner está activo?: " + activado);
            dialog_CheckActivation.setValue(Boolean.FALSE);
            notify_is_Activated.open();
        }
        if(activado == Boolean.FALSE){
            System.out.println("El banner está activo?: " + activado);
            dialog_CheckActivation.setValue(Boolean.TRUE);
            notify_is_PosibleActivated.open();
        }
    }
    */
    
    //GUARDAR CAMBIOS
    @Override
    public void On_Click_GuardarCambios(){
        Banners n_banner = new Banners();
        LineaEcommerce l_ecom = new LineaEcommerce();
        String linea_Ecom = "";
        String titulo_Banner = "";
        String subtitulo_Banner = "";
        String posicion_Banner = "";
        String url_img_Banner = "";
        Boolean activo = Boolean.FALSE;
        Boolean b_activo = Boolean.FALSE;
        //-----------------------------------------------------------------------------------------------
        posicion_Banner = String.valueOf(posicion);
        b_activo = Services.getIndexWeb().is_Banner_Act(posicion_Banner);
        //b_activo = is_Any_Banner_Act(posicion_Banner);
        //-----------------------------------------------------------------------------------------------
        if(!txtdialog2_TLEcom.isEmpty()){titulo_Banner = txtdialog2_TLEcom.getValue();}

        if(!txtdialog2_SubtLEcom.isEmpty()){subtitulo_Banner = txtdialog2_SubtLEcom.getValue();}

        posicion_Banner = txtdialog2_PosLEcom.getValue();
        
        if(!txtdialog_Upload.isEmpty()){url_img_Banner = Url_img_linea;}

        linea_Ecom = txtdialog_LEcom.getValue();
        l_ecom = Services.getProducto().get_ByLineaEcom_nombre(linea_Ecom);
        System.out.println("Banner Nuevo - Linea Ecommerce es:" + l_ecom.getNombre());
        activo = dialog_CheckActivation.getValue();
        //-----------------------------------------------------------------------------------------------
        //Ya hay un Banner activo
        if(b_activo == Boolean.TRUE)    {
            if(activo == Boolean.TRUE)  {notify_is_Activated.open();}
            //-------------------------------------------------------------------------------------------
            if(activo == Boolean.FALSE) {
                n_banner = new Banners();
            
                //Inicializando New Banner
                posicion_Banner = String.valueOf(posicion);
                //n_banner = Services.getIndexWeb().get_Banner_Act(posicion_Banner);
                n_banner.setTitulo(titulo_Banner);
                n_banner.setSubtitulo(subtitulo_Banner);
                n_banner.setPosicion(posicion);
                n_banner.setUrl_image(url_img_Banner);
                n_banner.setLinea_ecom(l_ecom);
                n_banner.setActivo(activo);

                //Guardando New Bannner
                Services.getIndexWeb().save_Banner(n_banner);

                notify_is_Guardado_Correct.open();
                select_Refresh_dialog();
            }
            //-----------------------------------------------------------------------------------------------
        }
        
        //No hay ningun Banner activo
        if(b_activo == Boolean.FALSE){
            n_banner = new Banners();
            
            //Inicializando New Banner
            posicion_Banner = String.valueOf(posicion);
            //n_banner = Services.getIndexWeb().get_Banner_Act(posicion_Banner);
            n_banner.setTitulo(titulo_Banner);
            n_banner.setSubtitulo(subtitulo_Banner);
            n_banner.setPosicion(posicion);
            n_banner.setUrl_image(url_img_Banner);
            n_banner.setLinea_ecom(l_ecom);
            n_banner.setActivo(activo);

            //Guardando New Bannner
            Services.getIndexWeb().save_Banner(n_banner);

            notify_is_Guardado_Correct.open();
            select_Refresh_dialog();
        }
    }
    //-----------------------------------------------------------------------------------------------------------
    
    //LINEAS ECOMMERCE ACTIVADAS
            
    @Override
    public void On_Click_BannerAnterior(){
        //Variables
        String linea_Ecom = "";
        String titulo_Banner = "";
        String subtitulo_Banner = "";
        String posicion_Banner = "";
        String url_img_Banner = "";
        Boolean activado = Boolean.FALSE;
        LineaEcommerce l_ecom = new LineaEcommerce();
        Banners ban = new Banners();
        
        //Get Anterior
        iterator_L_Banners = iterator_L_Banners - 1;
        if(iterator_L_Banners >= 0 && iterator_L_Banners < L_Banners.size()){    
            ban = L_Banners.get(iterator_L_Banners);
            id_banner = String.valueOf(ban.getId());
            titulo_Banner = ban.getTitulo();
            subtitulo_Banner = ban.getSubtitulo();
            l_ecom = ban.getLinea_ecom();
            linea_Ecom = l_ecom.getNombre();
            posicion_Banner = String.valueOf(ban.getPosicion());
            url_img_Banner = ban.getUrl_image();
            activado = ban.getActivo();

            txtdialog2_TLEcom.setValue(titulo_Banner);
            txtdialog2_SubtLEcom.setValue(subtitulo_Banner);
            txtdialog2_LEcom.setValue(linea_Ecom);
            txtdialog2_PosLEcom.setValue(posicion_Banner);
            dialog2_img.setSrc(url_img_Banner);
            dialog2_CheckActivation.setValue(activado);
        }
        if(iterator_L_Banners < 0){
            iterator_L_Banners = L_Banners.size() - 1;
            ban = L_Banners.get(iterator_L_Banners);
            id_banner = String.valueOf(ban.getId());
            titulo_Banner = ban.getTitulo();
            subtitulo_Banner = ban.getSubtitulo();
            l_ecom = ban.getLinea_ecom();
            linea_Ecom = l_ecom.getNombre();
            posicion_Banner = String.valueOf(ban.getPosicion());
            url_img_Banner = ban.getUrl_image();
            activado = ban.getActivo();

            txtdialog2_TLEcom.setValue(titulo_Banner);
            txtdialog2_SubtLEcom.setValue(subtitulo_Banner);
            txtdialog2_LEcom.setValue(linea_Ecom);
            txtdialog2_PosLEcom.setValue(posicion_Banner);
            dialog2_img.setSrc(url_img_Banner);
            dialog2_CheckActivation.setValue(activado);
        }
    }
    
    @Override
    public void On_Click_BannerSiguiente(){
        //Variables
        String linea_Ecom = "";
        String titulo_Banner = "";
        String subtitulo_Banner = "";
        String posicion_Banner = "";
        String url_img_Banner = "";
        Boolean activado = Boolean.FALSE;
        LineaEcommerce l_ecom = new LineaEcommerce();
        Banners ban = new Banners();
        
        //Get Siguiente
        iterator_L_Banners = iterator_L_Banners + 1;
        if(iterator_L_Banners < L_Banners.size()){    
            ban = L_Banners.get(iterator_L_Banners);
            id_banner = String.valueOf(ban.getId());
            titulo_Banner = ban.getTitulo();
            subtitulo_Banner = ban.getSubtitulo();
            l_ecom = ban.getLinea_ecom();
            linea_Ecom = l_ecom.getNombre();
            posicion_Banner = String.valueOf(ban.getPosicion());
            url_img_Banner = ban.getUrl_image();
            activado = ban.getActivo();

            txtdialog2_TLEcom.setValue(titulo_Banner);
            txtdialog2_SubtLEcom.setValue(subtitulo_Banner);
            txtdialog2_PosLEcom.setValue(posicion_Banner);
            txtdialog2_LEcom.setValue(linea_Ecom);
            dialog2_img.setSrc(url_img_Banner);
            dialog2_CheckActivation.setValue(activado);
        }
        if(iterator_L_Banners >= L_Banners.size()){
            iterator_L_Banners = 0;
            ban = L_Banners.get(iterator_L_Banners);
            id_banner = String.valueOf(ban.getId());
            titulo_Banner = ban.getTitulo();
            subtitulo_Banner = ban.getSubtitulo();
            l_ecom = ban.getLinea_ecom();
            linea_Ecom = l_ecom.getNombre();
            posicion_Banner = String.valueOf(ban.getPosicion());
            url_img_Banner = ban.getUrl_image();
            activado = ban.getActivo();

            txtdialog2_TLEcom.setValue(titulo_Banner);
            txtdialog2_SubtLEcom.setValue(subtitulo_Banner);
            txtdialog2_LEcom.setValue(linea_Ecom);
            txtdialog2_PosLEcom.setValue(posicion_Banner);
            dialog2_img.setSrc(url_img_Banner);
            dialog2_CheckActivation.setValue(activado);
        }
    }
    
    public void select_Refresh_dialog(){
        switch (posicion) {
          case 1:
            On_Open_dialog_Banner1();
            break;
          case 2:
            On_Open_dialog_Banner2();
            break;
          case 3:
            On_Open_dialog_Banner3();
            break;
          case 4:
            On_Open_dialog_Banner4();
            break;
          case 5:
            On_Open_dialog_Banner5();
            break;
          case 6:
            On_Open_dialog_Banner6();
            break;  
        }
    }
    
    @Override
    public void On_Click_Confirmar_CheckAct(){
        Boolean activado = Boolean.FALSE;
        Boolean banner_activo = Boolean.FALSE;
        String posicion_Banner = "";
        String LE_Banner = "";
        Banners banner = new Banners();
        LineaEcommerce l_ecom = new LineaEcommerce();
        
        posicion_Banner = String.valueOf(posicion);
        activado = dialog2_CheckActivation.getValue();
        banner_activo = is_Any_Banner_Act(posicion_Banner);
    
        banner = L_Banners.get(iterator_L_Banners);
        l_ecom = L_Banners.get(iterator_L_Banners).getLinea_ecom();
        System.out.println("Banner Activo - Linea Ecommerce es:" + l_ecom.getNombre());
        LE_Banner = txtdialog2_LEcom.getValue();
        l_ecom = Services.getProducto().get_ByLineaEcom_nombre(LE_Banner);
        System.out.println("Banner Activo - Linea Ecommerce es:" + l_ecom.getNombre());
        //l_ecom.setNombre(LE_Banner);
        //banner = Services.getIndexWeb().get_Banner_byId(id_banner);
        if(banner_activo == Boolean.FALSE){
            banner.setActivo(activado);
            banner.setLinea_ecom(l_ecom);
            Services.getIndexWeb().update_Banner(banner);
            notify_is_Guardado_Correct.open();
            select_Refresh_dialog();
        }
        if(banner_activo == Boolean.TRUE){    
            if (activado == Boolean.FALSE){
                banner.setActivo(activado);
                banner.setLinea_ecom(l_ecom);
                Services.getIndexWeb().update_Banner(banner);
                notify_is_Guardado_Correct.open();
                select_Refresh_dialog();
            }
            else {notify_is_Activated.open();}
        }
    }
    
    @Override
    public void On_Verify_BannerAct(){
        Boolean banner_activo = Boolean.FALSE;
        String posicion_Banner = "";
        posicion_Banner = String.valueOf(posicion);
        banner_activo = is_Any_Banner_Act(posicion_Banner);
        if(banner_activo == Boolean.FALSE){
            Banners banner = new Banners();
            LineaEcommerce l_ecom = new LineaEcommerce();
            iterator_L_Banners = 0;
            banner = L_Banners.get(iterator_L_Banners);
            l_ecom = L_Banners.get(iterator_L_Banners).getLinea_ecom();
            banner.setActivo(Boolean.TRUE);
            banner.setLinea_ecom(l_ecom);
            Services.getIndexWeb().update_Banner(banner);
            dialog_LineaEcommerce.close();
            refresh_Banners();
        }
        if(banner_activo == Boolean.TRUE){    
            dialog_LineaEcommerce.close();
            refresh_Banners();
        }
    }
    
    @Override
    public void refresh_Banners(){
        init_Banners();
    }
    
}
