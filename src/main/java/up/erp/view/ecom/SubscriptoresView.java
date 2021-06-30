/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.view.ecom;

import com.upgrade.persistence.model.ecommerce.Suscripcion;
import java.time.LocalDate;
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
public class SubscriptoresView extends SubscriptoresUI{
    

    //--------------------------------------------------------------------------
    //CPANEL RUTH
    //--------------------------------------------------------------------------
    public App app;
    
    public SubscriptoresView(App app) {
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
    //VARIABLES
    //--------------------------------------------------------------------------
    Suscripcion cast_subscriptor = new Suscripcion();
    List<Suscripcion> list_result = new ArrayList<>();
    List<Suscripcion> list_aux = new ArrayList<>();
    
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
    
    public void enlistar_RegistroWeb(Suscripcion registro_web) {
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
    
    //Convert Date to LocalDate
    public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
	    return dateToConvert.toInstant()
	      .atZone(ZoneId.systemDefault())
	      .toLocalDate();
    }
    
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
    //--------------------------------------------------------------------------
    
    //--------------------------------------------------------------------------
    //Busqueda de Subscriptores
    //--------------------------------------------------------------------------
    @Override
    public void On_find_Fechas(){
        Date fecha_ini = new Date();
        Date fecha_fin = new Date();
        list_result = new ArrayList<>();
        
        fecha_ini = Date.from(FechIni_bus.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        fecha_fin = Date.from(FechFin_bus.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        
        list_result = Services.getUsuarioWeb().find_SubsbyFecha(fecha_ini, fecha_fin);
        
        GridCols = new ArrayList<>();
        grid.setItems(list_result);
        init_ReporterToolbar();  
    }
    //--------------------------------------------------------------------------
    
    //--------------------------------------------------------------------------
    //DIALOG SUBSCRIPCION
    //--------------------------------------------------------------------------
    @Override
    public void on_Open_Subdialog() {
        Set<Suscripcion> set_regweb = grid.getSelectedItems();
        list_aux = convertSetToList(set_regweb);
        if(list_aux.size() == 1 && !list_aux.isEmpty()){
            //Activo
            if(list_aux.get(0).getActivo() == null)     { checkSAct.setValue(Boolean.FALSE);}
            else                                        { checkSAct.setValue(list_aux.get(0).getActivo());}
            
            //Cupon
            if(list_aux.get(0).getCuponNombre() == null) { txtdialog_SubCupon.setValue("");}
            else                                         { txtdialog_SubCupon.setValue(list_aux.get(0).getCuponNombre());}
            
            //Name
            if(list_aux.get(0).getNombre() == null)      { txtdialog_Subname.setValue("");}
            else                                         { txtdialog_Subname.setValue(list_aux.get(0).getNombre());}
            
            //Telef
            if(list_aux.get(0).getTelefono() == null)    { txtdialog_SubTlf.setValue("");}
            else                                         { txtdialog_SubTlf.setValue(list_aux.get(0).getTelefono());}
            
            //FNacimiento
            LocalDate ldate_fnacim;
            if(list_aux.get(0).getFecha_nacimiento() == null)    { txtdatedialog_SubFNacimiento.setValue("");}
            else { 
                //ldate_fnacim = convertDateObject(list_aux.get(0).getFecha_nacimiento());
                //datedialog_SubFNacimiento.setValue(ldate_fnacim);
                //datedialog_SubFNacimiento.setValue(LocalDate.parse(list_aux.get(0).getFecha_nacimiento()));
                
                txtdatedialog_SubFNacimiento.setValue(list_aux.get(0).getFecha_nacimiento());
            }
            
            //Email
            if(list_aux.get(0).getEmail() == null)    { txtdialog_SubEmail.setValue("");}
            else                                      { txtdialog_SubEmail.setValue(list_aux.get(0).getEmail());}
            
            //OPEN DIALOG
            dialogSubscriptor.open();
        }
        else {
            notify_select_exceed.open();
        }
    }


    //--------------------------------------------------------------------------
    //REPORTEADOR
    //--------------------------------------------------------------------------
    public void init_GridCols(){
        GridCols.add("Nombre");
        GridCols.add("Email");
        GridCols.add("Telefono");
        GridCols.add("Fecha Nacimiento");
        GridCols.add("Fecha Subscripción");
        GridCols.add("Cupón Asignado");
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
        String email = "";
        String telefono = "";
        String fechaNacimiento = "";
        Date fechaRegistro = new Date();
        String cupon_cod = "";
        
        int L_gridContent_size = list_result.size();
        Integer objectContent_size = GridCols.size();
        
        Toolbar.set_RowData(L_gridContent_size,objectContent_size);
        for(int i = 0; i < L_gridContent_size; i++){
            nombre = "";
            nombre = list_result.get(i).getNombre();
            System.out.println("Nombre: " + nombre);
            Toolbar.ROWS[i].add(nombre);
            
            email = "";
            email = list_result.get(i).getEmail();
            System.out.println("Email: " + email);
            Toolbar.ROWS[i].add(email);
            
            telefono = "";
            telefono = list_result.get(i).getTelefono();
            System.out.println("Telefono: " + telefono);
            Toolbar.ROWS[i].add(telefono);
            
            fechaNacimiento = "";
            fechaNacimiento = list_result.get(i).getFecha_nacimiento();
            System.out.println("Fecha Nacimiento: " + fechaNacimiento);
            Toolbar.ROWS[i].add(list_result.get(i).getFecha_nacimiento());
            
            fechaRegistro = new Date();
            fechaRegistro = list_result.get(i).getCreacion();
            System.out.println("Fecha Registro: " + fechaRegistro);
            Toolbar.ROWS[i].add(fechaRegistro);
            
            cupon_cod = "";
            cupon_cod = list_result.get(i).getCuponNombre();
            System.out.println("Código Cupon: " + cupon_cod);
            Toolbar.ROWS[i].add(cupon_cod);
        }
            
        Toolbar.set_UsuarioID("_");
        //Toolbar.set_Foldertemps("PruebaReporte");
        Toolbar.set_Module("SUBSCRIPTORESECOM");
        
        //Imprime muestra de Excel
        //Toolbar.print_ColumsExcel();
        //Toolbar.print_RowsExcel();
    }
    //--------------------------------------------------------------------------
    @Override
    public void init_ReporterToolbar2(){
        Toolbar.Generate_Table_default();
        Toolbar.set_UsuarioID("_");
        Toolbar.set_Module("SUBSCRIPTORESECOM");
    }
    //--------------------------------------------------------------------------
    
    
}
    

