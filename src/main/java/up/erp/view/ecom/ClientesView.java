/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.view.ecom;

import com.upgrade.persistence.model.ecommerce.UsuarioWeb;
import com.upgrade.persistence.model.extcs.Almacen;
import com.upgrade.persistence.model.tcros.Persona;
import java.math.BigDecimal;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.poi.ss.formula.functions.T;
import up.erp.service.Services;
import up.erp.view.App;
import up.erp.view.dashboards.*;

/**
 *
 * @author Luis Aleman
 */
@SuppressWarnings("unchecked")
public class ClientesView extends ClientesUI {
    
    //--------------------------------------------------------------------------
    //CPANEL RUTH
    //--------------------------------------------------------------------------
    public App app;
    
    public ClientesView(App app) {
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
    
    UsuarioWeb cast_Usuweb = new UsuarioWeb();
    List<UsuarioWeb> list_result = new ArrayList<>();
    List<UsuarioWeb> list_aux = new ArrayList<>();
    
    List<Almacen> L_Almacenes = new ArrayList<>();
    Almacen almacen_act = new Almacen();
    List<String> L_AlmacenesNames = new ArrayList<>();
    
    List<String> list_emails = new ArrayList<>();
    
    List<String> GridCols = new ArrayList<>();
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
    
    public void enlistar_RegistroWeb(UsuarioWeb registro_web) {
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
    //--------------------------------------------------------------------------
    //Iniciacion ComboBox Almacenes
    @Override
    public void init_Almacenes(){
        L_Almacenes = new ArrayList<>();
        L_AlmacenesNames = new ArrayList<>();
        String almacen = "";
        
        L_Almacenes = Services.getUsuarioWeb().get_Almacenes();
        
        if(!L_Almacenes.isEmpty()){
            for(int i = 0; i < L_Almacenes.size(); i++){
                almacen = L_Almacenes.get(i).getAbreviatura();
                L_AlmacenesNames.add(almacen);
                System.out.println("Almacen N°" + L_Almacenes.get(i).getId() + ", Nombre: " + almacen);
            }
        }
        comboBoxAlmacen.setItems(L_AlmacenesNames);
    }
    //--------------------------------------------------------------------------
    //Busqueda de Clientes
    @Override
    public void On_find_Activos(){
        // Consulta a la bd
        String nombre = txtname.getValue();
        list_result = new ArrayList<>();
        list_result = Services.getUsuarioWeb().find_soloActivos(nombre);
        grid.setItems(list_result);
        
        GridCols = new ArrayList<>();
        init_ReporterToolbar();
        //init_ReporterToolbar2();
        //grid.getColumns().get(4).setVisible(false);
    }
    
    @Override
    public void On_find_NoActivos(){
        // Consulta a la bd
        String nombre = txtname.getValue();
        list_result = new ArrayList<>();
        list_result = Services.getUsuarioWeb().find_soloNoActivos(nombre);
        
        GridCols = new ArrayList<>();
        grid.setItems(list_result);
        init_ReporterToolbar();
        //init_ReporterToolbar2();
        //grid.getColumns().get(4).setVisible(false);
    }
    
    @Override
    public void On_find_Fechas(){
        Date fecha_ini = new Date();
        Date fecha_fin = new Date();
        list_result = new ArrayList<>();
        
        fecha_ini = Date.from(FechIni_bus.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        fecha_fin = Date.from(FechFin_bus.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        
        list_result = Services.getUsuarioWeb().find_UsubyFechas(fecha_ini, fecha_fin);
        
        GridCols = new ArrayList<>();
        grid.setItems(list_result);
        init_ReporterToolbar();  
    }
    
    @Override
    public void On_find_UsuComp(){
        Date fecha_ini = new Date();
        Date fecha_fin = new Date();
        list_result = new ArrayList<>();
        
        fecha_ini = Date.from(FechIni_bus2.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        fecha_fin = Date.from(FechFin_bus2.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        
        list_result = Services.getUsuarioWeb().find_UsuComp(fecha_ini, fecha_fin);
        
        GridCols = new ArrayList<>();
        grid.setItems(list_result);
        init_ReporterToolbar();
        
    }
    
    @Override
    public void On_find_UsuComp_byAlmacen(){
        Date fecha_ini = new Date();
        Date fecha_fin = new Date();
        String id_almacen = "";
        String name_almacen = "";
        Almacen almacen_select = new Almacen();
        
        list_result = new ArrayList<>();
        
        fecha_ini = Date.from(FechIni_bus2.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        fecha_fin = Date.from(FechFin_bus2.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        
        if(!txtAlmacen.isEmpty())   {
            name_almacen = txtAlmacen.getValue();
            almacen_select = Services.getUsuarioWeb().find_AlmacenbyName(name_almacen);
            
            if(almacen_select != null){
                id_almacen = String.valueOf(almacen_select.getId());
                System.out.println("Almacen ID: " + id_almacen);
                list_result = Services.getUsuarioWeb().find_UsubySucursal(fecha_ini,fecha_fin,id_almacen);
            }
        }
        else
        {
            list_result = Services.getUsuarioWeb().find_UsuComp(fecha_ini, fecha_fin);
        }
        
        GridCols = new ArrayList<>();
        grid.setItems(list_result);
        init_ReporterToolbar();
    }
    //--------------------------------------------------------------------------
    
    //Cambio de estado Clientes
    @Override
    public void On_putInactivo_Cli() {
        Set<UsuarioWeb> set_regweb = grid.getSelectedItems();
        //Iterator<RegistroWeb> it = grid.asMultiSelect().getValue().iterator();
        list_aux = convertSetToList(set_regweb);
        Boolean eliminado = Boolean.FALSE;
        for(int i = 0; i < list_aux.size(); i++){
            list_aux.get(i).setActivo(Boolean.FALSE);
            Services.getUsuarioWeb().update_UsuarioWeb(list_aux.get(i));
            eliminado = desenlistar_RegistroWeb(list_aux.get(i).getId());
            if (eliminado != Boolean.TRUE){
                System.out.println("No se elimino Cliente : " + String.valueOf(list_aux.get(i).getId()));
            }
        }
        grid.setItems(list_result);
        grid.getColumns().get(4).setVisible(false);
        grid.getDataProvider().refreshAll();
    }

    @Override
    public void On_putActivo_Cli() {
        Set<UsuarioWeb> set_regweb = grid.getSelectedItems();
        //Iterator<RegistroWeb> it = grid.asMultiSelect().getValue().iterator();
        list_aux = convertSetToList(set_regweb);
        Boolean eliminado = Boolean.FALSE;
        for(int i = 0; i < list_aux.size(); i++){
            list_aux.get(i).setActivo(Boolean.TRUE);
            Services.getUsuarioWeb().update_UsuarioWeb(list_aux.get(i));
            eliminado = desenlistar_RegistroWeb(list_aux.get(i).getId());
            if (eliminado != Boolean.TRUE){
                System.out.println("No se elimino Cliente : " + String.valueOf(list_aux.get(i).getId()));
            }
        }
        grid.setItems(list_result);
        grid.getColumns().get(4).setVisible(false);
        grid.getDataProvider().refreshAll();
    }
    //--------------------------------------------------------------------------
    
    //DIALOG CLIENTE
    @Override
    public void Clean_Clientdialog() {
        checkCAc.setValue(Boolean.FALSE);
        txtdialog_ClientName.setValue("");
        txtdialog_ClientName.setVisible(true);
        txtdialog_ClientApe.setValue("");
        txtdialog_ClientApe.setVisible(true);
        Pswdialog_Client.setValue("");
        Pswdialog_Client.setVisible(true);
        dialog_ClientEmail.setValue("");
        dialog_ClientEmail.setVisible(true);
        txtdialog_ClientTlf.setValue("");
        txtdialog_ClientTlf.setVisible(true);
    }
    
    @Override
    public void on_Open_Clientdialog() {
        //Clean_Clientdialog();
        Set<UsuarioWeb> set_regweb = grid.getSelectedItems();
        list_aux = convertSetToList(set_regweb);
        if(list_aux.size() == 1 && !list_aux.isEmpty()){
            checkCAc.setValue(list_aux.get(0).getActivo());
            txtdialog_ClientName.setValue(list_aux.get(0).getNombres());
            txtdialog_ClientName.setVisible(true);
            txtdialog_ClientApe.setValue(list_aux.get(0).getApellidos());
            txtdialog_ClientApe.setVisible(true);
            Pswdialog_Client.setValue(list_aux.get(0).getPassword());
            Pswdialog_Client.setVisible(true);
            dialog_ClientEmail.setValue(list_aux.get(0).getEmail());
            dialog_ClientEmail.setVisible(true);
            txtdialog_ClientTlf.setValue(list_aux.get(0).getTelefono());
            txtdialog_ClientTlf.setVisible(true);
            dialogClient.open();
        }
        else {
            notify_select_exceed.open();
        }
    }

    @Override
    public void on_Grabar_Client() {
        list_aux.get(0).setActivo(checkCAc.getValue());
        list_aux.get(0).setNombres(txtdialog_ClientName.getValue());
        list_aux.get(0).setApellidos(txtdialog_ClientApe.getValue());
        list_aux.get(0).setPassword(Pswdialog_Client.getValue());
        list_aux.get(0).setEmail(dialog_ClientEmail.getValue());
        list_aux.get(0).setTelefono(txtdialog_ClientTlf.getValue());
        Services.getUsuarioWeb().update_UsuarioWeb(list_aux.get(0));
    }
    
    //--------------------------------------------------------------------------
    //REPORTEADOR
    //--------------------------------------------------------------------------
    public void init_GridCols(){
        GridCols.add("Nombre");
        GridCols.add("Apellidos");
        GridCols.add("Email");
        GridCols.add("Telefono");
        GridCols.add("Fecha");
    }
    //--------------------------------------------------------------------------
    @Override
    public void init_Table_defaultExcel(){
        Toolbar.Generate_Table_default();
    }
    //--------------------------------------------------------------------------
    @Override
    public void init_ReporterToolbar(){
        //Cols
        init_GridCols();
        Toolbar.set_ColumnData2(GridCols);
        
        
        //Rows
        String nombre = "";
        String apellido = "";
        String email = "";
        String telefono = "";
        Date fechaRegistro = new Date();
        
        int L_gridContent_size = list_result.size();
        Integer objectContent_size = GridCols.size();
        
        Toolbar.set_RowData(L_gridContent_size,objectContent_size);
        for(int i = 0; i < L_gridContent_size; i++){
            nombre = "";
            nombre = list_result.get(i).getNombres();
            System.out.println("Nombre: " + nombre);
            Toolbar.ROWS[i].add(nombre);
            
            apellido = "";
            apellido = list_result.get(i).getApellidos();
            System.out.println("Apellido: " + apellido);
            Toolbar.ROWS[i].add(apellido);
            
            email = "";
            email = list_result.get(i).getEmail();
            System.out.println("Email: " + email);
            Toolbar.ROWS[i].add(email);
            
            telefono = "";
            telefono = list_result.get(i).getTelefono();
            System.out.println("Telefono: " + telefono);
            Toolbar.ROWS[i].add(telefono);
            
            fechaRegistro = new Date();
            fechaRegistro = list_result.get(i).getCreacion();
            System.out.println("Fecha Registro: " + fechaRegistro);
            Toolbar.ROWS[i].add(fechaRegistro);
        }
            
        Toolbar.set_UsuarioID("_");
        //Toolbar.set_Foldertemps("PruebaReporte");
        Toolbar.set_Module("USUARIOSECOM");
        
        //Imprime muestra de Excel
        //Toolbar.print_ColumsExcel();
        //Toolbar.print_RowsExcel();
    }
    //--------------------------------------------------------------------------
    @Override
    public void init_ReporterToolbar2(){
        Toolbar.Generate_Table_default();
        Toolbar.set_UsuarioID("_");
        Toolbar.set_Module("USUARIOSECOM");
    }
    //--------------------------------------------------------------------------
    
    
    //--------------------------------------------------------------------------
    //DIALOG EMAIL
    //--------------------------------------------------------------------------
    @Override
    public void on_Open_Emaildialog(){
        list_emails = new ArrayList<>();
        String email = "";
        String destinatarios = "";
        dialog_txtDestinarios.setValue(destinatarios);
        
        if(!list_result.isEmpty()){
            for(int i = 0; i < list_result.size(); i++){
                email = list_result.get(i).getEmail();
                System.out.println("Email: " + email);
                destinatarios = dialog_txtDestinarios.getValue();
                dialog_txtDestinarios.setValue(destinatarios + "; " + email);
                list_emails.add(email);
            }
        }
        
        dialog_txtEmisor.setValue("");
        dialog_txtDescripcion.setValue("");
        
        dialogEMAIL.open();
    }
    //--------------------------------------------------------------------------
    
    
}
    

