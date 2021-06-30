/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.view.ecom;

import com.upgrade.persistence.model.ecommerce.Promociones;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.upload.SucceededEvent;
import com.vaadin.flow.server.StreamResource;

import org.springframework.http.converter.BufferedImageHttpMessageConverter;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import up.erp.server.Server;
import up.erp.service.Services;
import up.erp.view.App;
/**
 *
 * @author Luis Aleman
 */
public class PromocionesView extends PromocionesUI{
    //---------------------------------------------------------------------------------------------------
    //CPANEL RUTH
    //---------------------------------------------------------------------------------------------------
    public App app;
    
    public PromocionesView(App app) {
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
    public void go_Index(){
        this.app.layHeader.removeAll();
        //this.app.setContent(new IndexWebView(app));
        this.app.setContent(new IndexWeb2View(app));
    }
    //--------------------------------------------------------------------------
    
    //---------------------------------------------------------------------------------------------------
    //VARIABLES
    //---------------------------------------------------------------------------------------------------
    List<Promociones> L_PromoResult = new ArrayList<>();
    List<Promociones> L_PromoAux = new ArrayList<>();
    
    Promociones promo_actual = new Promociones();
    
    String path_ImgPromoE = "";
    String url_ImgPromoE = "";
    String path_ImgPromoN = "";
    String url_ImgPromoN = "";
    
    //----------------------------------------------------------------------------------------------------
    //MAIN VIEW
    //---------------------------------------------------------------------------------------------------
    //FUNCIONES
    //---------------------------------------------------------------------------------------------------
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
    //----------------------------------------------------------------------------------------------------
    //Convert Date to LocalDate
    public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
	    return dateToConvert.toInstant()
	      .atZone(ZoneId.systemDefault())
	      .toLocalDate();
    }
    //----------------------------------------------------------------------------------------------------
    public LocalDate convertDateObject(java.util.Date suspectDate) {

        try {
            // Don't do this if there is the smallest chance 
            // it could be a java.sql.Date!
            return suspectDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        } catch (UnsupportedOperationException e) {
            // BOOM!!
        }

        // do this first:
        java.util.Date safeDate = new Date(suspectDate.getTime());

        return safeDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

    }
    //----------------------------------------------------------------------------------------------------
    //BUSQUEDAS
    //----------------------------------------------------------------------------------------------------
    @Override
    public void On_find_PromoActiva(){
        L_PromoResult = new ArrayList<>();
        L_PromoResult = Services.getPromocionService().find_Promo_Activos();
        
        grid_Promo.setItems(L_PromoResult);
    }
    
    @Override
    public void On_find_PromoInactiva(){
        L_PromoResult = new ArrayList<>();
        L_PromoResult = Services.getPromocionService().find_Promo_Inactivos();
        
        grid_Promo.setItems(L_PromoResult);
    }
    
    //----------------------------------------------------------------------------------------------------
    //----------------------------------------------------------------------------------------------------
    //OTHERS
    //----------------------------------------------------------------------------------------------------
    @Override
    public void On_Click_ActivarPromos(){
        Set<Promociones> set_promo_select = grid_Promo.getSelectedItems();
        L_PromoAux = new ArrayList<>();
        L_PromoAux = convertSetToList(set_promo_select);
        
        Promociones promo_n = new Promociones();
        for(int i = 0; i < L_PromoAux.size(); i++){
            promo_n = new Promociones();
            promo_n = L_PromoAux.get(i);
            if(promo_n.getActivo() == Boolean.FALSE){
                promo_n.setActivo(Boolean.TRUE);
                //Update Promo
                Services.getPromocionService().update_Promo(promo_n);
            }
        }
        grid_Promo.getDataProvider().refreshAll();
    }
    //----------------------------------------------------------------------------------------------------
    @Override
    public void On_Click_DesactivarPromos(){
        Set<Promociones> set_promo_select = grid_Promo.getSelectedItems();
        L_PromoAux = new ArrayList<>();
        L_PromoAux = convertSetToList(set_promo_select);
        
        Promociones promo_n = new Promociones();
        for(int i = 0; i < L_PromoAux.size(); i++){
            promo_n = new Promociones();
            promo_n = L_PromoAux.get(i);
            if(promo_n.getActivo() == Boolean.TRUE){
                promo_n.setActivo(Boolean.FALSE);
                //Update Promo
                Services.getPromocionService().update_Promo(promo_n);
            }
        }
        grid_Promo.getDataProvider().refreshAll();
    }
    //----------------------------------------------------------------------------------------------------
    @Override
    public void On_Click_AsignMonto(){
        //Get Promo selected
        Set<Promociones> set_promo_select = grid_Promo.getSelectedItems();
        L_PromoAux = new ArrayList<>();
        L_PromoAux = convertSetToList(set_promo_select);
        
        txtASIGNM_MontoMin.setValue("");
        txtASIGNM_MontoDescu.setValue("");
                
        dialog_AsignMonto.open();
    }
    //----------------------------------------------------------------------------------------------------
    
    //----------------------------------------------------------------------------------------------------
    //DIALOG PROMOCION EXISTENTE 
    //----------------------------------------------------------------------------------------------------
    @Override
    public void On_Open_PromoExist(){
        //Get Promo selected
        Set<Promociones> set_promo_select = grid_Promo.getSelectedItems();
        L_PromoAux = new ArrayList<>();
        L_PromoAux = convertSetToList(set_promo_select);
        
        promo_actual = new Promociones();
        if(L_PromoAux.size() == 1 && !L_PromoAux.isEmpty()){
            if(L_PromoAux.get(0) != null){
                promo_actual = L_PromoAux.get(0);
                //Prefijo
                if(promo_actual.getPrefijo() == null)    txtPROME_Prefijo.setValue("");
                else {
                    System.out.println("Prefijo: " + promo_actual.getPrefijo());
                    txtPROME_Prefijo.setValue(promo_actual.getPrefijo());
                }
                //Titulo Promo
                if(promo_actual.getTitulo() == null)    txtPROME_Nombre.setValue("");
                else {
                    System.out.println("Titulo Promoción: " + promo_actual.getTitulo());
                    txtPROME_Nombre.setValue(promo_actual.getTitulo());
                }
                //Activo
                chckPROME_Activa.setValue(promo_actual.getActivo());
                //Monto Minimo
                if(promo_actual.getMonto_min() == null)    txtPROME_MontoMin.setValue("");
                else {
                    System.out.println("Monto Minimo: " + promo_actual.getMonto_min());
                    txtPROME_MontoMin.setValue(String.valueOf(promo_actual.getMonto_min()));
                }
                //Monto Descuento
                if(promo_actual.getCupon_monto() == null)    txtPROME_MontoDescu.setValue("");
                else {
                    System.out.println("Monto Descuento: " + promo_actual.getCupon_monto());
                    txtPROME_MontoDescu.setValue(String.valueOf(promo_actual.getCupon_monto()));
                }
                //Fecha Vigencia
                LocalDate date_finVigencia;
                if(promo_actual.getFecha_limite() != null){
                    System.out.println("Fecha Vigencia: " + promo_actual.getFecha_limite());
                    date_finVigencia = convertDateObject(promo_actual.getFecha_limite());
                    datePROMOE_FinVigencia.setValue(date_finVigencia);
                }
                //Dias Vigencia
                if(promo_actual.getVigencia_cupon() == null)    txtPROME_DiasVigencia.setValue("");
                else {
                    System.out.println("Días Vigencia: " + promo_actual.getVigencia_cupon());
                    txtPROME_DiasVigencia.setValue(String.valueOf(promo_actual.getVigencia_cupon()));
                }     
                //Imagen Promo
                if(promo_actual.getUrl_img() == null) {
                    imgPROMOE.setSrc("");
                    txtUrlPROMOE.setValue("");
                }
                else {
                    System.out.println("Ulr Imagen: " + promo_actual.getUrl_img());
                    imgPROMOE.setSrc(promo_actual.getUrl_img());
                    txtUrlPROMOE.setValue(promo_actual.getUrl_img());
                }
                
                dialog_PromoExist.open();
            }
            else {
                txtPROME_Nombre.setValue("");
                chckPROME_Activa.setValue(Boolean.FALSE);
                txtPROME_MontoMin.setValue("");
                txtPROME_MontoDescu.setValue("");
                datePROMOE_FinVigencia.setValue(null);
                txtPROME_DiasVigencia.setValue("");
                imgPROMOE.setSrc("");
                txtUrlPROMOE.setValue("");
                
                dialog_PromoExist.open();
            }
        }
        else {
            notify_select_exceed.open();
        }
    }
    //----------------------------------------------------------------------------------------------------
    @Override
    public void On_Upload_ImgPromoExist(SucceededEvent event){
        path_ImgPromoE = "";
        try {
            
            //LECTURA
            InputStream is = bufferPROMOE.getInputStream();
            byte[] buffer = new byte[is.available()];
            is.read(buffer);            
            path_ImgPromoE = Server.PATH_IMAGES + event.getFileName();



                                    
            //ESCRITURA
            File newFile = new File(path_ImgPromoE);
            OutputStream out = new FileOutputStream(newFile);
            out.write(buffer);
            out.close();
            is.close();



            
            //CARGA IMAGEN          
            StreamResource resource = new StreamResource("bannerUpgrade.jpg", () -> new ByteArrayInputStream(buffer));
            url_ImgPromoE = Server.URL_IMAGES + event.getFileName();
            txtUrlPROMOE.setValue(url_ImgPromoE);
            imgPROMOE.setSrc(resource);
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
    //----------------------------------------------------------------------------------------------------
    @Override
    public void On_Discard_ImgPromoExist(){
        path_ImgPromoE = "";
        url_ImgPromoE = "";
        imgPROMOE.setSrc("");
        txtUrlPROMOE.setValue("");
    }
    //----------------------------------------------------------------------------------------------------
    @Override
    public void On_Update_PromoExist(){
        Promociones promo_n = new Promociones();
        promo_n = Services.getPromocionService().find_Promo_ById(String.valueOf(promo_actual.getId()));
        
        if(promo_n.getId() != null){
            //Prefijo
            if(!txtPROME_Prefijo.isEmpty()){
                promo_n.setPrefijo(txtPROME_Prefijo.getValue());
            }
            //Titulo
            if(!txtPROME_Nombre.isEmpty()){
                promo_n.setTitulo(txtPROME_Nombre.getValue());
            }
            //Activa
            if(!chckPROME_Activa.isEmpty()){
                promo_n.setActivo(chckPROME_Activa.getValue());
            }
            //Monto Minimo
            if(!txtPROME_MontoMin.isEmpty()){
                promo_n.setMonto_min(Integer.valueOf(txtPROME_MontoMin.getValue()));
            }
            //Monto Descuento
            if(!txtPROME_MontoDescu.isEmpty()){
                promo_n.setCupon_monto(Integer.valueOf(txtPROME_MontoDescu.getValue()));
            }
            if(chckPROME_CheckFVigencia.getValue() == Boolean.TRUE){
            //Fecha Vigencia
                Date finVigencia = new Date();
                if(!datePROMOE_FinVigencia.isEmpty()){
                    finVigencia = Date.from(datePROMOE_FinVigencia.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
                    promo_n.setFecha_limite(finVigencia);
                    promo_n.setVigencia_cupon(null);
                }
            }
            if(chckPROME_CheckFVigencia.getValue() == Boolean.FALSE){
            //Dias Vigencia
                if(!txtPROME_DiasVigencia.isEmpty()){
                    promo_n.setVigencia_cupon(Integer.valueOf(txtPROME_DiasVigencia.getValue()));
                    promo_n.setFecha_limite(null);
                }
            }
            //Imagen Promo
            if(!txtUrlPROMOE.isEmpty()){
                promo_n.setUrl_img(txtUrlPROMOE.getValue());
            }
            
            //Update
            Services.getPromocionService().update_Promo(promo_n);
            notifyUpdatePROMOE.open();
        }
    }
    //----------------------------------------------------------------------------------------------------
    @Override
    public void On_Delete_PromoExist(){
        Promociones promo_n = new Promociones();
        promo_n = Services.getPromocionService().find_Promo_ById(String.valueOf(promo_actual.getId()));
        if(promo_n.getId() != null){
            //Delete
            Services.getPromocionService().delete_Promo(promo_n);
            notifyDeletePROMOE.open();
        }
    }
    //----------------------------------------------------------------------------------------------------
    //----------------------------------------------------------------------------------------------------
    //DIALOG NUEVA PROMOCION
    //----------------------------------------------------------------------------------------------------
    @Override
    public void On_Open_PromoNew(){
        txtPROMN_Nombre.setValue("");
        chckPROMN_Activa.setValue(Boolean.FALSE);
        txtPROMN_MontoMin.setValue("");
        txtPROMN_MontoDescu.setValue("");
        datePROMN_FinVigencia.setValue(null);
        txtPROMN_DiasVigencia.setValue("");
        imgPROMN.setSrc("");
        txtUrlPROMN.setValue("");
        
        dialog_PromoNew.open();
    }
    //----------------------------------------------------------------------------------------------------
    @Override
    public void On_Upload_ImgPromoNew(SucceededEvent event){
        path_ImgPromoN = "";
        try {
            
            //LECTURA
            InputStream is = bufferPROMN.getInputStream();
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            path_ImgPromoN = Server.PATH_IMAGES + event.getFileName();
            
            //ESCRITURA
            File newFile = new File(path_ImgPromoN);
            OutputStream out = new FileOutputStream(newFile);
            out.write(buffer);
            out.close();
            is.close();
            
            //CARGA IMAGEN
            url_ImgPromoN = Server.URL_IMAGES + event.getFileName();
            txtUrlPROMN.setValue(url_ImgPromoN);
            imgPROMN.setSrc(url_ImgPromoN);
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    //----------------------------------------------------------------------------------------------------
    @Override
    public void On_Discard_ImgPromoNew(){
        path_ImgPromoN = "";
        url_ImgPromoN = "";
        imgPROMN.setSrc("");
        txtUrlPROMN.setValue("");
    }
    //----------------------------------------------------------------------------------------------------
    @Override
    public void On_Create_PromoNew(){
        Promociones promo_n = new Promociones();
        //Creacion
        LocalDate actual_date = LocalDate.now();
        Date actual = new Date();
        actual = Date.from(actual_date.atStartOfDay(ZoneId.systemDefault()).toInstant());
        promo_n.setCreacion(actual);
        
        //Prefijo
        if(!txtPROMN_Prefijo.isEmpty()){
            promo_n.setPrefijo(txtPROMN_Prefijo.getValue());
        }
        //Titulo
        if(!txtPROMN_Nombre.isEmpty()){
            promo_n.setTitulo(txtPROMN_Nombre.getValue());
        }
        //Activa
        if(!chckPROMN_Activa.isEmpty()){
            promo_n.setActivo(chckPROMN_Activa.getValue());
        }
        else{
            promo_n.setActivo(Boolean.FALSE);
        }
        //Monto Minimo
        if(!txtPROMN_MontoMin.isEmpty()){
            promo_n.setMonto_min(Integer.valueOf(txtPROMN_MontoMin.getValue()));
        }
        //Monto Descuento
        if(!txtPROMN_MontoDescu.isEmpty()){
            promo_n.setCupon_monto(Integer.valueOf(txtPROMN_MontoDescu.getValue()));
        }
        //Fecha Vigencia
        Date finVigencia = new Date();
        if(!datePROMN_FinVigencia.isEmpty()){
            finVigencia = Date.from(datePROMN_FinVigencia.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
            promo_n.setFecha_limite(finVigencia);
        }
        //Dias Vigencia
        if(!txtPROMN_DiasVigencia.isEmpty()){
            promo_n.setVigencia_cupon(Integer.valueOf(txtPROMN_DiasVigencia.getValue()));
        }
        //Imagen Promo
        if(!txtUrlPROMN.isEmpty()){
            promo_n.setUrl_img(txtUrlPROMN.getValue());
        }

        //Insert
        Services.getPromocionService().insert_Promo(promo_n);
        notifyCreatePROMN.open();
    }
    //----------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------
    //DIALOG ASIGNAR MONTO
    //------------------------------------------------------------------------------------------------
    @Override
    public void On_Update_AsignMonto(){
         Promociones promo_asign = new Promociones();
        
        for(int i = 0; i < L_PromoAux.size(); i++){
            promo_asign = new Promociones();
            promo_asign = L_PromoAux.get(i);
            if(!txtASIGNM_MontoMin.isEmpty()){
                promo_asign.setMonto_min(Integer.getInteger(txtASIGNM_MontoMin.getValue()));
            }
            if(!txtASIGNM_MontoDescu.isEmpty()){
                promo_asign.setCupon_monto(Integer.getInteger(txtASIGNM_MontoDescu.getValue()));
            }
            Services.getPromocionService().update_Promo(promo_asign);
        }
        notifyAsignarASIGNM.open();
    }
    //------------------------------------------------------------------------------------------------
}
