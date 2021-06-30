/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.view.ecom;

import com.upgrade.persistence.model.ecommerce.Cupones;
import com.upgrade.persistence.model.ecommerce.UsuarioWeb;
import com.upgrade.persistence.model.ecommerce.UsuariosCupones;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.textfield.TextField;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import up.erp.service.Services;
import up.erp.view.App;
/**
 *
 * @author Luis Aleman
 */
public class CuponesView extends CuponesUI{
    
    //---------------------------------------------------------------------------------------------------
    //CPANEL RUTH
    //---------------------------------------------------------------------------------------------------
    public App app;
    
    public CuponesView(App app) {
        this.app = app;
    }
    //---------------------------------------------------------------------------------------------------
    @Override
    public void go_CPanel(){
        this.app.layHeader.removeAll();
        //this.app.setContent(new CPanelView(app));
        this.app.setContent(new CPanelView2(app));
    }
    //---------------------------------------------------------------------------------------------------
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
    //VARIABLES
    //---------------------------------------------------------------------------------------------------
    List<Cupones> list_cupones_result = new ArrayList<>();
    List<Cupones> list_cupones_aux = new ArrayList<>();
    List<Cupones> list_cupones_aux2 = new ArrayList<>();
    
    Cupones cupon_actual = new Cupones();
    List<UsuarioWeb> L_Usu = new ArrayList<>();
    List<UsuarioWeb> L_Usu_aux = new ArrayList<>();
    
    List<String> GridCols = new ArrayList<>();
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
    //---------------------------------------------------------------------------------------------------
    @Override
    public void On_find_NameCupon(){
        String cupon_nombre = "";
        cupon_nombre = txtInput_NameCupon.getValue();
        
        list_cupones_result = new ArrayList<>();
        list_cupones_result = Services.getCuponService().find_Cupon_ByName(cupon_nombre);
        grid.setItems(list_cupones_result);
        GridCols = new ArrayList<>();
        init_ReporterToolbar();
        //grid.getColumns().get(5).setVisible(false);
    }
    //---------------------------------------------------------------------------------------------------
    @Override
    public void On_find_CuponActivo(){
        list_cupones_result = new ArrayList<>();
        list_cupones_result = Services.getCuponService().find_Cupones_Activos();
        grid.setItems(list_cupones_result);
        GridCols = new ArrayList<>();
        init_ReporterToolbar();
        //grid.getColumns().get(5).setVisible(false);
    }
    //---------------------------------------------------------------------------------------------------
    @Override
    public void On_find_CuponInactivo(){
        list_cupones_result = new ArrayList<>();
        list_cupones_result = Services.getCuponService().find_Cupones_Inactivos();
        grid.setItems(list_cupones_result);
        GridCols = new ArrayList<>();
        init_ReporterToolbar();
        //grid.getColumns().get(5).setVisible(false);
    }
    //---------------------------------------------------------------------------------------------------
    //MAIN VIEW
    //---------------------------------------------------------------------------------------------------
    @Override
    public void On_Click_ActivarCupones() {
        //Get Cupon selected
        Set<Cupones> set_cupon_select = grid.getSelectedItems();
        list_cupones_aux2 = new ArrayList<>();
        list_cupones_aux2 = convertSetToList(set_cupon_select);
        
        //Change Activos/Inactivos
        Cupones cupon_act = new Cupones();
        for(int i = 0; i < list_cupones_aux2.size();i++){
            cupon_act = new Cupones();
            cupon_act = list_cupones_aux2.get(i);
            if(cupon_act.getActivo() == Boolean.FALSE) {
                cupon_act.setActivo(Boolean.TRUE);
                //Update Cupon
                Services.getCuponService().Update_Cupon(cupon_act);
            }
        }
        grid.getDataProvider().refreshAll();
    }
    //---------------------------------------------------------------------------------------------------
    @Override
    public void On_Click_DesactivarCupones() {
        //Get Cupon selected
        Set<Cupones> set_cupon_select = grid.getSelectedItems();
        list_cupones_aux2 = new ArrayList<>();
        list_cupones_aux2 = convertSetToList(set_cupon_select);
        
        //Change Activos/Inactivos
        Cupones cupon_act = new Cupones();
        for(int i = 0; i < list_cupones_aux2.size();i++){
            cupon_act = new Cupones();
            cupon_act = list_cupones_aux2.get(i);
            if(cupon_act.getActivo() == Boolean.TRUE) {
                cupon_act.setActivo(Boolean.FALSE);
                //Update Cupon
                Services.getCuponService().Update_Cupon(cupon_act);
            } 
        }
        grid.getDataProvider().refreshAll();
    }
    //---------------------------------------------------------------------------------------------------
    //DIALOG CUPON EXISTENTE
    //---------------------------------------------------------------------------------------------------
    @Override
    public void On_OpenDialog_CuponExist() {
        //Get Cupon selected
        Set<Cupones> set_cupon_select = grid.getSelectedItems();
        list_cupones_aux = new ArrayList<>();
        list_cupones_aux = convertSetToList(set_cupon_select);
        
        Cupones cupon_s = new Cupones();
        //cupon_s = grid.getSelectionModel().getFirstSelectedItem().get();
        if(list_cupones_aux.size() == 1 && !list_cupones_aux.isEmpty()){
            if(list_cupones_aux.get(0) != null){
                cupon_s = list_cupones_aux.get(0);
                //------------------------------------------------------------------------
                if(cupon_s.getNombreCupon() == null)    txtdialogCU_Nombre.setValue("");
                else {
                    System.out.println("Nombre Cupon : " + cupon_s.getNombreCupon());
                    txtdialogCU_Nombre.setValue(cupon_s.getNombreCupon());
                }
                //------------------------------------------------------------------------
                if(cupon_s.getActivo() == null)         chckdialogCU_Activate.setValue(Boolean.FALSE);
                else {
                    System.out.println("Cupon Activo? : " + cupon_s.getActivo());
                    chckdialogCU_Activate.setValue(cupon_s.getActivo());
                }
                //------------------------------------------------------------------------
                if(cupon_s.getMonto() == null)          txtdialogCU_Monto.setValue("");
                else {
                    System.out.println("Monto Cupon : " + String.valueOf(cupon_s.getMonto()));
                    txtdialogCU_Monto.setValue(String.valueOf(cupon_s.getMonto()));
                }
                //------------------------------------------------------------------------
                if(cupon_s.getPrecioMinProd() == null)  txtdialogCU_PrecioMin.setValue("");
                else {
                    System.out.println("Precio Min Prod : " + String.valueOf(cupon_s.getPrecioMinProd()));
                    txtdialogCU_PrecioMin.setValue(String.valueOf(cupon_s.getPrecioMinProd()));
                }
                //------------------------------------------------------------------------
                LocalDate ldate_ini;
                if(cupon_s.getFechaIniVigencia() == null)  datedialogCU_FechaIniVig.setValue(null);
                else {
                    System.out.println("Fecha Inicio Vigencia : " + String.valueOf(cupon_s.getFechaIniVigencia()));
                    //ldate = convertToLocalDateViaInstant(cupon_s.getFechaVigencia());
                    ldate_ini = convertDateObject(cupon_s.getFechaIniVigencia());
                    datedialogCU_FechaIniVig.setValue(ldate_ini);
                }
                //------------------------------------------------------------------------
                LocalDate ldate_fin;
                if(cupon_s.getFechaFinVigencia() == null)  datedialogCU_FechaFinVig.setValue(null);
                else {
                    System.out.println("Fecha Fin Vigencia : " + String.valueOf(cupon_s.getFechaFinVigencia()));
                    //ldate = convertToLocalDateViaInstant(cupon_s.getFechaVigencia());
                    ldate_fin = convertDateObject(cupon_s.getFechaFinVigencia());
                    datedialogCU_FechaFinVig.setValue(ldate_fin);
                }
                //------------------------------------------------------------------------
                if(cupon_s.getCantidad() == null)          txtdialogCU_Cantidad.setValue("");
                else {
                    System.out.println("Cantidad de Cupones: " + String.valueOf(cupon_s.getCantidad()));
                    txtdialogCU_Cantidad.setValue(String.valueOf(cupon_s.getCantidad()));
                }        
                //------------------------------------------------------------------------
                if(cupon_s.getId() == null)    txtdialogCU_IdCupon.setValue("");
                else {
                    System.out.println("Id Cupon : " + cupon_s.getId());
                    txtdialogCU_IdCupon.setValue(String.valueOf(cupon_s.getId()));
                }
                //------------------------------------------------------------------------
                dialog_CuponExist.open();
                cupon_actual = new Cupones();
                cupon_actual = list_cupones_aux.get(0);
            }
            else {
                txtdialogCU_Nombre.setValue("");
                chckdialogCU_Activate.setValue(Boolean.FALSE);
                txtdialogCU_Monto.setValue("");
                txtdialogCU_PrecioMin.setValue("");
                dialog_CuponExist.open();
            }
        }
        else {
            notify_select_exceed.open();
        }
    }
    //---------------------------------------------------------------------------------------------------
    @Override
    public void On_Update_CuponExist() {
        Integer monto_cupon = 0;
        Integer precio_min = 0;
        Integer cantidad = 0;
        Cupones cupon_s = new Cupones();
        cupon_s = list_cupones_aux.get(0);
        //----------------------------------------------------------------------
        //Get Values
        //----------------------------------------------------------------------
        if(!txtdialogCU_Nombre.isEmpty()) cupon_s.setNombreCupon(txtdialogCU_Nombre.getValue());
        cupon_s.setActivo(chckdialogCU_Activate.getValue());
        //----------------------------------------------------------------------
        if(!txtdialogCU_Monto.isEmpty()) {
            monto_cupon = Integer.valueOf(txtdialogCU_Monto.getValue());
            System.out.println("Monto Cupon: " + monto_cupon);
            cupon_s.setMonto(monto_cupon);
        }
        //----------------------------------------------------------------------
        if(!txtdialogCU_PrecioMin.isEmpty()) {
            precio_min = Integer.valueOf(txtdialogCU_PrecioMin.getValue());
            System.out.println("Precio Min Prod: " + precio_min);
            cupon_s.setPrecioMinProd(precio_min);
        }
        //----------------------------------------------------------------------
        Date fecha_ini_vigencia = new Date();
        if(!datedialogCU_FechaIniVig.isEmpty()){
            fecha_ini_vigencia = Date.from(datedialogCU_FechaIniVig.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
            System.out.println("Fecha Ini Vigencia : " + fecha_ini_vigencia);
            cupon_s.setFechaIniVigencia(fecha_ini_vigencia);
        }
        //----------------------------------------------------------------------
        Date fecha_fin_vigencia = new Date();
        if(!datedialogCU_FechaFinVig.isEmpty()){
            fecha_fin_vigencia = Date.from(datedialogCU_FechaFinVig.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
            System.out.println("Fecha Fin Vigencia : " + fecha_fin_vigencia);
            cupon_s.setFechaFinVigencia(fecha_fin_vigencia);
        }
        //----------------------------------------------------------------------
        if(!txtdialogCU_Cantidad.isEmpty()) {
            cantidad = Integer.valueOf(txtdialogCU_Cantidad.getValue());
            System.out.println("Cantidad: " + cantidad);
            cupon_s.setCantidad(cantidad);
        }
        //----------------------------------------------------------------------
        //Update Cupon
        //----------------------------------------------------------------------
        Services.getCuponService().Update_Cupon(cupon_s);
        notifyCU_is_Updated.open();
    }   
    //---------------------------------------------------------------------------------------------------
    @Override
    public void On_Delete_CuponExist() {
        Cupones cupon_s = new Cupones();
        cupon_s = list_cupones_aux.get(0);
        
        //Delete Cupon
        Services.getCuponService().Delete_Cupon(cupon_s);
        notifyCU_is_Deleted.open();
    }
    //---------------------------------------------------------------------------------------------------
    @Override
    public void On_UsuariosAsignados(){
        String id_cupon = "";
        id_cupon = String.valueOf(cupon_actual.getId());
        L_Usu = new ArrayList<>();
        
        L_Usu = Services.getCuponService().find_UsuariosAsignados_ByCupon(id_cupon);
        grid_usuarios.setItems(L_Usu);
    }
    //---------------------------------------------------------------------------------------------------
    @Override
    public void On_FindUsuarios(){
        Date fecha_ini = new Date();
        Date fecha_fin = new Date();
        L_Usu = new ArrayList<>();
        
        fecha_ini = Date.from(datedialogCU_UsuFechaIni.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        fecha_fin = Date.from(datedialogCU_UsuFechaFin.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        
        L_Usu = Services.getCuponService().find_UsuariosbyFecha(fecha_ini, fecha_fin);
        
        grid_usuarios.setItems(L_Usu); 
    }
    //---------------------------------------------------------------------------------------------------
    @Override
    public void On_AsignarUsu(){
        UsuariosCupones usu_cupon = new UsuariosCupones();
        UsuarioWeb usuweb = new UsuarioWeb();
        Boolean utilizado = Boolean.FALSE;
        
        Set<UsuarioWeb> set_usu_select = grid_usuarios.getSelectedItems();
        L_Usu_aux = new ArrayList<>();
        L_Usu_aux = convertSetToList(set_usu_select);
        
        if(!L_Usu_aux.isEmpty()){
            for(int i = 0; i < L_Usu_aux.size(); i++){
                usu_cupon = new UsuariosCupones();
                usuweb = new UsuarioWeb();
                
                usuweb = L_Usu_aux.get(i);
                usu_cupon.setUsuariow(usuweb);
                usu_cupon.setCupon(cupon_actual);
                usu_cupon.setUtilizado(utilizado);
                Services.getCuponService().Insert_UsuarioCupon(usu_cupon);
                System.out.println("Usuario: " + usuweb.getNombres() + " " + usuweb.getApellidos());
                System.out.println("Cupon: " + cupon_actual.getNombreCupon() + ", Asignados");
            }
        }
    }
    //---------------------------------------------------------------------------------------------------
    @Override
    public void On_DesasignarUsu(){
        UsuariosCupones usu_cupon = new UsuariosCupones();
        UsuarioWeb usuweb = new UsuarioWeb();
        Boolean utilizado = Boolean.FALSE;
        String id_usuariow = "";
        String id_cupon = "";
        
        Set<UsuarioWeb> set_usu_select = grid_usuarios.getSelectedItems();
        L_Usu_aux = new ArrayList<>();
        L_Usu_aux = convertSetToList(set_usu_select);
        
        if(!L_Usu_aux.isEmpty()){
            for(int i = 0; i < L_Usu_aux.size(); i++){
                usu_cupon = new UsuariosCupones();
                usuweb = new UsuarioWeb();
                
                usuweb = L_Usu_aux.get(i);
                id_usuariow = String.valueOf(usuweb.getId());
                id_cupon = String.valueOf(cupon_actual.getId());
                
                usu_cupon = Services.getCuponService().find_UsuCupon(id_usuariow, id_cupon);
                System.out.println("Usuario: " + usuweb.getNombres() + " " + usuweb.getApellidos());
                System.out.println("Cupon: " + cupon_actual.getNombreCupon() + ", Desasignados");
                
                Services.getCuponService().Delete_UsuarioCupon(usu_cupon);
            }
        }
    }
    //---------------------------------------------------------------------------------------------------
    //DIALOG NUEVO CUPON
    //---------------------------------------------------------------------------------------------------
    @Override
    public void On_OpenDialog_NewCupon() {
        txtdialogNCU_Nombre.setValue("");
        chckdialogNCU_Activate.setValue(Boolean.FALSE);
        txtdialogNCU_Monto.setValue("");
        txtdialogNCU_PrecioMin.setValue("");
        txtdialogNCU_Cantidad.setValue("");
    }
    //---------------------------------------------------------------------------------------------------
    @Override
    public void On_Save_NewCupon() {
        Cupones cupon_s = new Cupones();
        //----------------------------------------------------------------------
        //Get Values
        //----------------------------------------------------------------------
        if(!txtdialogNCU_Nombre.isEmpty()) cupon_s.setNombreCupon(txtdialogNCU_Nombre.getValue());
        //----------------------------------------------------------------------
        cupon_s.setActivo(chckdialogNCU_Activate.getValue());
        //----------------------------------------------------------------------
        if(!txtdialogNCU_Monto.isEmpty()) cupon_s.setMonto(Integer.valueOf(txtdialogNCU_Monto.getValue()));
        //----------------------------------------------------------------------
        if(!txtdialogNCU_PrecioMin.isEmpty()) cupon_s.setPrecioMinProd(Integer.valueOf(txtdialogNCU_PrecioMin.getValue()));
        //----------------------------------------------------------------------
        Date fecha_ini_vigencia = new Date();
        if(!datedialogNCU_FechaIniVig.isEmpty()){
            fecha_ini_vigencia = Date.from(datedialogNCU_FechaIniVig.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
            cupon_s.setFechaIniVigencia(fecha_ini_vigencia);
        }
        //----------------------------------------------------------------------
        Date fecha_fin_vigencia = new Date();
        if(!datedialogNCU_FechaFinVig.isEmpty()){
            fecha_fin_vigencia = Date.from(datedialogNCU_FechaFinVig.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
            cupon_s.setFechaFinVigencia(fecha_fin_vigencia);
        }
        //----------------------------------------------------------------------
        if(!txtdialogNCU_Cantidad.isEmpty()) cupon_s.setCantidad(Integer.valueOf(txtdialogNCU_Cantidad.getValue()));
        //----------------------------------------------------------------------
        //Save Cupon
        Services.getCuponService().Save_Cupon(cupon_s);
        notifyNCU_is_Created.open();
    }
    //---------------------------------------------------------------------------------------------------
    //DIALOG ASIGNAR MONTO
    //---------------------------------------------------------------------------------------------------
    @Override
    public void On_Click_AsignMonto() {
        //Get Cupon selected
        Set<Cupones> set_cupon_select = grid.getSelectedItems();
        list_cupones_aux2 = new ArrayList<>();
        list_cupones_aux2 = convertSetToList(set_cupon_select);
        
        //Clean TextMonto
        txtdialogAMCU_Monto.setValue("");
    }
    //---------------------------------------------------------------------------------------------------
    @Override
    public void On_Asign_Monto(){
        Cupones cupon_monto = new Cupones();
        Integer n_monto = 0;
        if(!txtdialogAMCU_Monto.isEmpty()){
            n_monto = Integer.valueOf(txtdialogAMCU_Monto.getValue());
            for(int i = 0; i < list_cupones_aux2.size();i++){
                cupon_monto = new Cupones();
                cupon_monto = list_cupones_aux2.get(i);
                cupon_monto.setMonto(n_monto);
                //Update Cupon
                Services.getCuponService().Update_Cupon(cupon_monto);
                notifyAMCU_is_MontoAsign.open();
            }
        }
    }
    //---------------------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //REPORTEADOR
    //--------------------------------------------------------------------------
    public void init_GridCols(){
        GridCols = new ArrayList<>();
        
        GridCols.add("Nombre Cupon");
        GridCols.add("Monto");
        GridCols.add("Activo?");
        GridCols.add("Precio Min Producto");
        GridCols.add("Fecha Max Vigencia");
    }
    //--------------------------------------------------------------------------
    @Override
    public void init_ReporterToolbar(){
        //Cols
        init_GridCols();
        Toolbar.set_ColumnData2(GridCols);
        
        
        //Rows
        String nombre = "";
        Integer monto = 0;
        Boolean activo = Boolean.FALSE;
        Integer precioMin = 0;
        Date fechaIniVigencia = new Date();
        Date fechaFinVigencia = new Date();
        
        int L_gridContent_size = list_cupones_result.size();
        Integer objectContent_size = GridCols.size();
        
        Toolbar.set_RowData(L_gridContent_size,objectContent_size);
        for(int i = 0; i < L_gridContent_size; i++){
            nombre = "";
            nombre = list_cupones_result.get(i).getNombreCupon();
            System.out.println("Nombre Cupon: " + nombre);
            Toolbar.ROWS[i].add(nombre);
            
            monto = 0;
            monto = list_cupones_result.get(i).getMonto();
            System.out.println("Monto: " + monto);
            Toolbar.ROWS[i].add(monto);
            
            activo = Boolean.FALSE;
            activo = list_cupones_result.get(i).getActivo();
            System.out.println("Activo?: " + activo);
            Toolbar.ROWS[i].add(activo);
            
            precioMin = 0;
            precioMin = list_cupones_result.get(i).getPrecioMinProd();
            System.out.println("Precio Min Producto: " + precioMin);
            Toolbar.ROWS[i].add(precioMin);
            
            fechaIniVigencia = new Date();
            fechaIniVigencia = list_cupones_result.get(i).getFechaIniVigencia();
            System.out.println("Fecha Inicio Vigencia: " + fechaIniVigencia);
            Toolbar.ROWS[i].add(fechaIniVigencia);
            
            fechaFinVigencia = new Date();
            fechaFinVigencia = list_cupones_result.get(i).getFechaFinVigencia();
            System.out.println("Fecha Fin Vigencia: " + fechaFinVigencia);
            Toolbar.ROWS[i].add(fechaFinVigencia);
        }
        
        //Usuario
        Toolbar.set_UsuarioID("_");
        
        //Módulo
        Toolbar.set_Module("CUPONESECOM");
    }
    //--------------------------------------------------------------------------
    @Override
    public void init_ReporterToolbar_default(){
        //Cols && Rows
        Toolbar.Generate_Table_default();
        
        //Usuario
        Toolbar.set_UsuarioID("_");
        
        //Módulo
        Toolbar.set_Module("CUPONESECOM");
    }
    //--------------------------------------------------------------------------
}
