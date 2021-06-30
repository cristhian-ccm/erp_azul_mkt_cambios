/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.view.ecom;

import com.google.gwt.requestfactory.shared.Service;
import com.upgrade.persistence.model.ecommerce.CatalogoPuntosUp;
import com.upgrade.persistence.model.ecommerce.UsuarioWeb;
import com.upgrade.persistence.model.ecommerce.PuntosUp;
import com.vaadin.flow.component.upload.SucceededEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.poi.ss.formula.functions.T;
import up.erp.server.Server;
import up.erp.service.Services;
import up.erp.view.App;
import up.erp.view.dashboards.*;

/**
 *
 * @author Luis Aleman
 */
@SuppressWarnings("unchecked")
public class PuntosUpView extends PuntosUpUI {
    
    //--------------------------------------------------------------------------
    //CPANEL RUTH
    //--------------------------------------------------------------------------
    public App app;
    
    public PuntosUpView(App app) {
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
    //--------------------------------------------------------------------------
    
    PuntosUp actual_PuntosUp = new PuntosUp();
    List<PuntosUp> list_result = new ArrayList<>();
    List<PuntosUp> list_aux = new ArrayList<>();
    
    List<String> list_emails = new ArrayList<>();
    
    List<String> GridCols = new ArrayList<>();

    List<CatalogoPuntosUp> list_Elim = new ArrayList<>();

    
    List<CatalogoPuntosUp> L_catalogo = new ArrayList<>();
    CatalogoPuntosUp actual_catalogo = new CatalogoPuntosUp();
    Integer iterator_Catalogos = 0;
    
    String Url_catalogo = "";
    
    String path_UploadCatalogo = "";
    String url_UploadCatalogo = "";
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
    
    // Generic function to convert ListT to list 
    public static <T> List<T> convertListT_ToList(List<T> ListT) 
    { 
        // create an empty list 
        List<T> list = new ArrayList<>(); 
  
        // push each element in the set into the list 
        for (T t : ListT) 
            list.add(t); 
  
        // return the list 
        return list; 
    } 
    
    public void enlistar_RegistroWeb(PuntosUp registro_web) {
        list_result.add(registro_web);
    }
    
    public Boolean desenlistar_RegistroWeb(Integer regweb_id) {
        for(int i = 0; i < list_result.size(); i++){
            if(list_result.get(i).getId() == regweb_id){
                list_result.remove(list_result.remove(i));
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }
    
    public void removeAll_RegistroWeb() {
        for(int i=0;i < list_result.size();i++){
            list_result.remove(i);
        }
    }

    //-----------------------------------------------------------------------------------------------
    //BUSQUEDAS
    //-----------------------------------------------------------------------------------------------
    @Override
    public void On_find_Activos(){
        // Consulta a la bd
        String nombre = txtname.getValue();
        list_result = new ArrayList<>();
        list_result = Services.getUsuarioWeb().find_PuntosUPActivos();
        grid.setItems(list_result);
    }
    
    @Override
    public void On_find_NoActivos(){
        
    }
    
    
    @Override
    public void On_find_Fechas(){
        Date fecha_ini = new Date();
        Date fecha_fin = new Date();
        list_result = new ArrayList<>();
        
        fecha_ini = Date.from(FechIni_bus.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        fecha_fin = Date.from(FechFin_bus.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        
        list_result = Services.getUsuarioWeb().find_PuntosUPbyFecha(fecha_ini, fecha_fin);
        
        grid.setItems(list_result); 
    }
    //-----------------------------------------------------------------------------------------------
    
    //-----------------------------------------------------------------------------------------------
    //DIALOGS PUNTOS UP
    //-----------------------------------------------------------------------------------------------
    @Override
    public void on_Open_Clientdialog(){
        list_aux = new ArrayList<>();
        Set<PuntosUp> set_regweb = grid.getSelectedItems();
        list_aux = convertSetToList(set_regweb);
        if(list_aux.size() == 1 && !list_aux.isEmpty()){
            //Nombre
            if(list_aux.get(0).getNombre_Usuweb() == null)  { txtdialog_UsuName.setValue("");}
            else                                            { txtdialog_UsuName.setValue(list_aux.get(0).getNombre_Usuweb());}
            
            //Email
            if(list_aux.get(0).getEmail_Usuweb() == null)  { dialog_UsuEmail.setValue("");}
            else                                           { dialog_UsuEmail.setValue(list_aux.get(0).getEmail_Usuweb());}
            
            //Telefono
            if(list_aux.get(0).getTelf_Usuweb() == null)  { txtdialog_UsuTlf.setValue("");}
            else                                          { txtdialog_UsuTlf.setValue(list_aux.get(0).getTelf_Usuweb());}
            
            //PuntosUP Actuales
            if(list_aux.get(0).getPts_restantes() == null)  { txtdialog_PuntosUp.setValue("");}
            else                                            { txtdialog_PuntosUp.setValue(String.valueOf(list_aux.get(0).getPts_restantes()));}
            
            //OPEN DIALOG
            actual_PuntosUp = new PuntosUp();
            actual_PuntosUp = list_aux.get(0);
            dialogClient.open();
        }
        else {
            notify_select_exceed.open();
        }
    }
    //-----------------------------------------------------------------------------------------------
    @Override
    public void on_Incrementar_PuntosUP(){
        Integer pts_anteriores = 0;
        Integer pts_nuevos = 0;
        Integer pts_resultantes = 0;
        if(!txtdialog_NewPuntosUp.isEmpty()){
            pts_nuevos = Integer.valueOf(txtdialog_NewPuntosUp.getValue());
            pts_anteriores = actual_PuntosUp.getPts_restantes();
            pts_resultantes = pts_nuevos + pts_anteriores;
            
            actual_PuntosUp.setPts_inc(pts_nuevos);
            actual_PuntosUp.setPts_restantes(pts_resultantes);
            
            //UPDATE INCREMENTO DE PUNTOS
            Services.getUsuarioWeb().update_PuntosUP(actual_PuntosUp);
            Client_notify_correct.open();
        }
    }
    //-----------------------------------------------------------------------------------------------
    @Override
    public void on_Disminuir_PuntosUP(){
        Integer pts_anteriores = 0;
        Integer pts_nuevos = 0;
        Integer pts_resultantes = 0;
        if(!txtdialog_NewPuntosUp.isEmpty()){
            pts_nuevos = Integer.valueOf(txtdialog_NewPuntosUp.getValue());
            pts_anteriores = actual_PuntosUp.getPts_restantes();
            pts_resultantes = pts_anteriores - pts_nuevos;
            if(pts_resultantes < 0) {pts_resultantes = 0;}
            
            actual_PuntosUp.setPts_dec(pts_nuevos);
            actual_PuntosUp.setPts_restantes(pts_resultantes);
            
            //UPDATE DECREMENTO DE PUNTOS
            Services.getUsuarioWeb().update_PuntosUP(actual_PuntosUp);
            Client_notify_correct.open();
        }
    }
    //-----------------------------------------------------------------------------------------------
    @Override
    public void on_Open_Incrementdialog(){
        list_aux = new ArrayList<>();
        Set<PuntosUp> set_regweb = grid.getSelectedItems();
        list_aux = convertSetToList(set_regweb);
        
        //OPENING DIALOG
        dialogIncrementPUP.open();
    }
    //-----------------------------------------------------------------------------------------------
    @Override
    public void on_UpdateInc_PuntosUP(){
        PuntosUp n_PuntosUp = new PuntosUp();
        Integer pts_anteriores = 0;
        Integer pts_nuevos = 0;
        Integer pts_resultantes = 0;
        if(!txtdialog_IncPUP.isEmpty()){
            for(int i = 0; i < list_aux.size(); i++){
                n_PuntosUp = new PuntosUp();
                n_PuntosUp = list_aux.get(i);
                
                pts_nuevos = Integer.valueOf(txtdialog_IncPUP.getValue());
                pts_anteriores = n_PuntosUp.getPts_restantes();
                pts_resultantes = pts_nuevos + pts_anteriores;
                
                n_PuntosUp.setPts_inc(pts_nuevos);
                n_PuntosUp.setPts_restantes(pts_resultantes);
                
                //UPDATE INCREMENTO DE PUNTOS
                Services.getUsuarioWeb().update_PuntosUP(n_PuntosUp);
            }
            Client_notify_correct.open();
        }
    }
    //-----------------------------------------------------------------------------------------------
    @Override
    public void on_Open_Disminuirdialog(){
        list_aux = new ArrayList<>();
        Set<PuntosUp> set_regweb = grid.getSelectedItems();
        list_aux = convertSetToList(set_regweb);
        
        //OPENING DIALOG
        dialogDisminuirPUP.open();
    }
    //-----------------------------------------------------------------------------------------------
    @Override
    public void on_UpdateDis_PuntosUP(){
        PuntosUp n_PuntosUp = new PuntosUp();
        Integer pts_anteriores = 0;
        Integer pts_nuevos = 0;
        Integer pts_resultantes = 0;
        if(!txtdialog_DisPUP.isEmpty()){
            for(int i = 0; i < list_aux.size(); i++){
                n_PuntosUp = new PuntosUp();
                n_PuntosUp = list_aux.get(i);
                
                pts_nuevos = Integer.valueOf(txtdialog_DisPUP.getValue());
                pts_anteriores = n_PuntosUp.getPts_restantes();
                pts_resultantes = pts_anteriores - pts_nuevos;
                if(pts_resultantes < 0) {pts_resultantes = 0;}
                
                n_PuntosUp.setPts_dec(pts_nuevos);
                n_PuntosUp.setPts_restantes(pts_resultantes);
                
                //UPDATE INCREMENTO DE PUNTOS
                Services.getUsuarioWeb().update_PuntosUP(n_PuntosUp);
            }
            Client_notify_correct.open();
        }
    }
    //-----------------------------------------------------------------------------------------------
    
    //-----------------------------------------------------------------------------------------------
    //CATALOGO
    //-----------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------
    @Override
    public void init_Catalogos(){
        //GET ALL CATALOGOS
        L_catalogo = new ArrayList<>();
        L_catalogo = Services.getUsuarioWeb().find_Catalogos();
        actual_catalogo = new CatalogoPuntosUp();
        if(L_catalogo.isEmpty()){
            /*txtCatUrlpdf.setValue("");
            checkCat_Activate.setValue(Boolean.FALSE);  */
            txtCatNUrlpdf.setValue("");
            checkCat_Activar.setValue(Boolean.FALSE);
        }
        else {
            actual_catalogo = L_catalogo.get(0);
            iterator_Catalogos = 0;

            Url_catalogo = "";

            Url_catalogo = L_catalogo.get(0).getUrl_pdf();

            Boolean activo = Boolean.FALSE;
            activo =  L_catalogo.get(0).getActivo();

           /*
            //SHOW FIRST
            if(L_catalogo.get(0).getUrl_pdf() == null)  {txtCatUrlpdf.setValue("");}
            else                                        {txtCatUrlpdf.setValue(Url_catalogo);}

            if(L_catalogo.get(0).getActivo() == null)  {checkCat_Activate.setValue(Boolean.FALSE);}
            else                                        {checkCat_Activate.setValue(activo);} 
            */
        } 
    }
    
    //-----------------------------------------------------------------------------------------------
    @Override
    public void on_UploadNewCatalogo(SucceededEvent event){
        path_UploadCatalogo = "";
        try {
            
            //LECTURA
            InputStream is = bufferCatalogo.getInputStream();
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            path_UploadCatalogo = Server.PATH_PDF + event.getFileName();
            
            //ESCRITURA
            File newFile = new File(path_UploadCatalogo);
            OutputStream out = new FileOutputStream(newFile);
            out.write(buffer);
            out.close();
            is.close();
            
            //CARGA PDF
            url_UploadCatalogo = Server.PATH_PDF + event.getFileName();
            txtCatNUrlpdf.setValue(url_UploadCatalogo);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    //-----------------------------------------------------------------------------------------------
    @Override
    public void on_SaveNewCatalogo(){
        CatalogoPuntosUp n_cat = new CatalogoPuntosUp();
        CatalogoPuntosUp active_cat = new CatalogoPuntosUp();
        
        //FECHA CREACION
        //Creacion
        LocalDate actual_date = LocalDate.now();
        Date actual = new Date();
        actual = Date.from(actual_date.atStartOfDay(ZoneId.systemDefault()).toInstant());
        n_cat.setCreacion(actual);
        
        //URL PDF
        if(!txtCatNUrlpdf.isEmpty()){n_cat.setUrl_pdf(txtCatNUrlpdf.getValue());}
        
        //ACTIVO
        if(!checkCat_Activar.isEmpty()){
            n_cat.setActivo(checkCat_Activar.getValue());
            if(n_cat.getActivo() == Boolean.TRUE){
                //GET ACTIVO EXISTENTE
                active_cat = Services.getUsuarioWeb().get_CatalogoActivo();
                active_cat.setActivo(Boolean.FALSE);

                //UPDATE CATALAGO
                Services.getUsuarioWeb().update_CatalogoPtsUP(active_cat);

                //INSERT NEW CATALAGO
                Services.getUsuarioWeb().insert_CatalogoPtsUP(n_cat);
                msgCatCreado.open();
            }
            else {
                //INSERT NEW CATALAGO
                Services.getUsuarioWeb().insert_CatalogoPtsUP(n_cat);
                msgCatCreado.open();
            }
        }
        else {
            n_cat.setActivo(Boolean.FALSE);
            //INSERT NEW CATALAGO
            Services.getUsuarioWeb().insert_CatalogoPtsUP(n_cat);
            msgCatCreado.open();
        }
    }


   





    //-----------------------------------------------------------------------------------------------
    
    @Override
    public void on_Mostrar_Catalogos(){

        L_catalogo=new ArrayList<>();
        L_catalogo=Services.getUsuarioWeb().find_Catalogos();
        gridCatalogo.setItems(L_catalogo);


    }
     




    @Override
    public void on_Open_CatalogoAdd(){
        dialogoCatalogo.open();
    }   
    
    
    @Override
    public void on_ActualizarCatalogo(){

        CatalogoPuntosUp n_cat = new CatalogoPuntosUp();

        list_Elim=new ArrayList<>();        
        Set<CatalogoPuntosUp> setReg= gridCatalogo.getSelectedItems();
        list_Elim=convertSetToList(setReg);



        n_cat.setId(list_Elim.get(0).getId());
        n_cat.setCreado_por(list_Elim.get(0).getCreado_por());
        n_cat.setCreacion(list_Elim.get(0).getCreacion());

        //n_cat.setActivo(Boolean.parseBoolean(txteditCat_Activo.getValue()));
        n_cat.setActivo(Boolean.parseBoolean(cmbActivo.getValue()));


        n_cat.setUrl_pdf(txteditCat_urlpdf.getValue());
        
       
                //UPDATE CATALAGO
                Services.getUsuarioWeb().update_CatalogoPtsUP(n_cat);
                msgCatActualizado.open();  


                       
    }


    @Override
    public void on_EliminarCatalogo(){

        list_Elim=new ArrayList<>();        
        Set<CatalogoPuntosUp> setReg= gridCatalogo.getSelectedItems();
        list_Elim=convertSetToList(setReg);

        CatalogoPuntosUp cat_ob = new CatalogoPuntosUp();
        cat_ob.setId(list_Elim.get(0).getId());
        Services.getUsuarioWeb().delete_CatalogoPtsUP(cat_ob);
        Client_notfy_eliminado.open();  
       
    }



    @Override
    public void on_editar_Catalogo(){

        L_catalogo = new ArrayList<>();
        Set<CatalogoPuntosUp> set_regweb = gridCatalogo.getSelectedItems();
        L_catalogo = convertSetToList(set_regweb);
        cmbActivo.setItems("true","false");



        if(L_catalogo.size() == 1 && !L_catalogo.isEmpty()){

            if(L_catalogo.get(0).getUrl_pdf() == null)  { txteditCat_urlpdf.setValue("");}
            else                                            { txteditCat_urlpdf.setValue(L_catalogo.get(0).getUrl_pdf());}
            
            
            if(L_catalogo.get(0).getActivo() == null)  { txteditCat_Activo.setValue("");}
            else                                           { txteditCat_Activo.setValue(String.valueOf(L_catalogo.get(0).getActivo()));}

          
        
           
                dialogoEditCatalogo.open();
                
        }
        else {
            msgErrorSelect.open();
        }


    }

    






    
    //-----------------------------------------------------------------------------------------------
    @Override
    public void on_BeforeCatalogo(){

        /*


        CatalogoPuntosUp n_cat = new CatalogoPuntosUp();
        n_cat = actual_catalogo;
        Integer list_size = L_catalogo.size();
        String url_pdf = "";
        Boolean activado = Boolean.FALSE;
        
        //GET ANTERIOR
        iterator_Catalogos = iterator_Catalogos - 1;
        
        if(iterator_Catalogos >= 0 && iterator_Catalogos < list_size){ 
            n_cat = L_catalogo.get(iterator_Catalogos);
            
            activado = n_cat.getActivo();
            if(n_cat.getUrl_pdf() != null) {url_pdf = n_cat.getUrl_pdf();}
            
            //FILLING
           checkCat_Activate.setValue(activado);
            txtCatUrlpdf.setValue(url_pdf);
            
            //GET ACTUAL
            actual_catalogo = L_catalogo.get(iterator_Catalogos);
        }
        if(iterator_Catalogos < 0){
            iterator_Catalogos = list_size - 1;
            
            n_cat = L_catalogo.get(iterator_Catalogos);
            
            activado = n_cat.getActivo();
            if(n_cat.getUrl_pdf() != null) {url_pdf = n_cat.getUrl_pdf();}
            
            //FILLING
           checkCat_Activate.setValue(activado);
            txtCatUrlpdf.setValue(url_pdf);
            
            //GET ACTUAL
            actual_catalogo = L_catalogo.get(iterator_Catalogos);
        }

        */
    }
    
    //-----------------------------------------------------------------------------------------------
    @Override
    public void on_AfterCatalogo(){

        /*


        CatalogoPuntosUp n_cat = new CatalogoPuntosUp();
        n_cat = actual_catalogo;
        Integer list_size = L_catalogo.size();
        String url_pdf = "";
        Boolean activado = Boolean.FALSE;
        
        //GET SIGUIENTE
        iterator_Catalogos = iterator_Catalogos + 1;
        if(iterator_Catalogos < list_size){ 
            n_cat = L_catalogo.get(iterator_Catalogos);
            
            activado = n_cat.getActivo();
            if(n_cat.getUrl_pdf() != null) {url_pdf = n_cat.getUrl_pdf();}
            
            //FILLING
            checkCat_Activate.setValue(activado);
            txtCatUrlpdf.setValue(url_pdf);
            
            //GET ACTUAL
            actual_catalogo = L_catalogo.get(iterator_Catalogos);
        }
        if(iterator_Catalogos >= list_size){
            iterator_Catalogos = 0;
            
            n_cat = L_catalogo.get(iterator_Catalogos);
            
            activado = n_cat.getActivo();
            if(n_cat.getUrl_pdf() != null) {url_pdf = n_cat.getUrl_pdf();}
            
            //FILLING
            checkCat_Activate.setValue(activado);
            txtCatUrlpdf.setValue(url_pdf);
            
            //GET ACTUAL
            actual_catalogo = L_catalogo.get(iterator_Catalogos);
        }

        */
    }
    //-----------------------------------------------------------------------------------------------
    
    
}