/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.view.ecom;

import com.upgrade.persistence.model.cmrlz.NotaPedidoDet;
import com.upgrade.persistence.model.cmrlz.NotaPedidoCab;
import com.upgrade.persistence.model.cmrlz.VentaCab;
import com.upgrade.persistence.model.ecommerce.EstadosOrdenVenta;
import com.upgrade.persistence.model.ecommerce.PedidoEcommerce;
import com.upgrade.persistence.model.ecommerce.DirEntrega;
import com.upgrade.persistence.model.ecommerce.NotaPedidoModel;
import com.upgrade.persistence.model.ecommerce.UsuarioWeb;
import com.upgrade.persistence.model.extcs.Almacen;
import com.upgrade.persistence.model.extcs.Articulo;
import com.upgrade.persistence.model.extcs.Producto;
import com.upgrade.persistence.model.lgstc.SolicitudCompra;
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
import static up.erp.view.ecom.PedidosView.convertSetToList;
/**
 *
 * @author Luis Aleman
 */
public class RepartidoresView extends RepartidoresUI  {
    
    public App app;
    
    public RepartidoresView(App app) {
        this.app = app;
    }
    //--------------------------------------------------------------------------
    
    //-----------------------------------------------------------------------------------------------
    //FUNCIONES
    //-----------------------------------------------------------------------------------------------
    //CPANEL RUTAS
    //-----------------------------------------------------------------------------------------------
    @Override
    public void go_CPanel(){
        this.app.layHeader.removeAll();
        this.app.setContent(new CPanelView2(app));
    }
    //-----------------------------------------------------------------------------------------------
    //BUSQUEDAS
    //-----------------------------------------------------------------------------------------------
    
    //--------------------------------------------------------------------------
    
    //String numero_ped = "";
    Integer pedido_ecom_id = 0;
    Integer numero_ped = 0;
    String usuario_web = "";
    Date fecha_registro;
    Date fecha_entrega;
    String dir_ecom = "";
    String tipo_entr = "";
    String estado = "";
    
    UsuarioWeb usu_aux = new UsuarioWeb();
    List<PedidoEcommerce> list_result = new ArrayList<>();
    List<PedidoEcommerce> list_aux = new ArrayList<>();
    List<NotaPedidoModel> list_npm = new ArrayList<>();
    List<EstadosOrdenVenta> list_estadosV = new ArrayList<>();
    
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
    
    public void enlistar_PedidoEcommerce(PedidoEcommerce registro_web) {
        list_result.add(registro_web);
    }
    
    public Boolean desenlistar_PedidoEcommerce(Integer ped_ecom_id) {
        for(int i = 0; i < list_result.size(); i++){
            if(list_result.get(i).getPedido_ecom_id() == ped_ecom_id){
                list_result.remove(list_result.remove(i));
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }
    
    public void removeAll_PedidoEcommerce() {
        for(int i=list_result.size()-1 ;i == 0; i--){
            list_result.remove(i);
        }
    }
    //--------------------------------------------------------------------------
    public String convert_Estado(String new_estado){
        String estado_convert = "";
        switch (new_estado) {
          case "P":
            estado_convert = "Pedido";
            break;
          case "L":
            estado_convert = "En Almacén";
            break;
          case "D":
            estado_convert = "Despachado";
            break;
          case "E":
            estado_convert = "Entregado";
            break;
          case "A":
            estado_convert = "Anulado";
            break;
          default:
            estado_convert = "No definido";
            break;  
        }
        return estado_convert;
    }
    //--------------------------------------------------------------------------
    public String get_Estado(String new_estado){
        String estado_convert = "";
        switch (new_estado) {
          case "Pedido(P)":
            estado_convert = "P";
            break;
          case "En Almacén(L)":
            estado_convert = "L";
            break;
          case "Despachado(D)":
            estado_convert = "D";
            break;
          case "Entregado(E)":
            estado_convert = "E";
            break;
          case "Anulado(A)":
            estado_convert = "A";
            break;
          default:
            estado_convert = "No definido";
            break;  
        }
        return estado_convert;
    }
    //--------------------------------------------------------------------------
    @Override
    public void On_find_NOrdenPed(){
        //VARIABLES
        removeAll_PedidoEcommerce();
        list_result = new ArrayList<>();
        String N_Orden = "";
        NotaPedidoCab npcab = new NotaPedidoCab();
        PedidoEcommerce ped_actual = new PedidoEcommerce();
        UsuarioWeb usu_web = new UsuarioWeb();
        String n_state = "";
        DirEntrega dir_ecom = new DirEntrega();
        String dir_entr_id = "";
        
        if(!txtInput_NOrden.isEmpty()){
            N_Orden = txtInput_NOrden.getValue();
            npcab = Services.getPedido().getBy_NumOrden_Repartidores(N_Orden);
            
            dir_ecom = new DirEntrega();
            dir_ecom = npcab.getDireccion_Ecommerce();
            usu_web = new UsuarioWeb();
            if(npcab.getDireccion_Ecommerce() == null || dir_ecom.getUsuario_web() == null){
                System.out.println("Numero Orden: " + npcab.getNumero() + ", No tiene usuario web Registrado");
            }
            else {    
                usu_web = dir_ecom.getUsuario_web();
                ped_actual = new PedidoEcommerce();
                ped_actual.setNumero(npcab.getNumero());
                ped_actual.setUsuario_web(usu_web.getNombres() + " " + usu_web.getApellidos());
                ped_actual.setFecha_actual_proceso(npcab.getFecha());
                ped_actual.setFecha_entrega(npcab.getFechaEntrega());
                if (dir_ecom.getDireccion() != null){
                    ped_actual.setDireccion_Ecommerce(dir_ecom.getDireccion());
                }
                else {
                    ped_actual.setDireccion_Ecommerce("No definida");
                }        
                if(npcab.getTipo_Entrega() != null){
                    ped_actual.setTipo_entrega(npcab.getTipo_Entrega());
                }
                else {
                    ped_actual.setTipo_entrega("No definida");
                }
                n_state = convert_Estado(npcab.getEstado_actual());
                ped_actual.setEstado(n_state);
                list_result.add(ped_actual);
            }
            grid.setItems(ped_actual);
        }
    }
    //--------------------------------------------------------------------------
    @Override
    public void On_find_AllPed(){
        //VARIABLES
        removeAll_PedidoEcommerce();
        list_result = new ArrayList<>();
        
        List<UsuarioWeb> list_usu_web = new ArrayList<>();
        UsuarioWeb usu_web = new UsuarioWeb();
        String usu_web_id = "";
        String pedido_find = "";
        PedidoEcommerce ped_actual = new PedidoEcommerce();
        
        //NotaPedidoCab
        List<NotaPedidoCab> ListNotaPed_Cab = new ArrayList<>();
        NotaPedidoCab npcab = new NotaPedidoCab();
        List<NotaPedidoModel> list_npm = new ArrayList<>();
        NotaPedidoModel npm = new NotaPedidoModel();
        String notaPed_cab_id;
        Date fecha_crea;
        Date fecha_entr;
        Date fecha_actual_proc;
        Boolean anulada = Boolean.FALSE;
        //DirEntrega Ecommerce
        DirEntrega dir_ecom = new DirEntrega();
        String dir_entr_id = "";
        //EstadosOrdenVenta
        List<EstadosOrdenVenta> estado_orden = new ArrayList<>();
        
        pedido_find = "";
        list_usu_web = Services.getUsuarioWeb().find_soloActivos(pedido_find);
        for (int i = 0; i < list_usu_web.size(); i++){
            usu_web = new UsuarioWeb();
            usu_web = list_usu_web.get(i);
            usu_web_id = String.valueOf(usu_web.getId());
            System.out.println("Usuario id: " + usu_web_id + ", nombre: " + usu_web.getNombres());

            //Busqueda NotaPedido Model
            list_npm = new ArrayList<>();
            list_npm = Services.getPedido().getPedidoEcom_Panel_Repartidores(usu_web_id);
            for (int j = 0; j < list_npm.size(); j++){
                npm = new NotaPedidoModel();
                npm = list_npm.get(j);
                System.out.println("Numero Orden: " + npm.getNum_orden());
                ped_actual = new PedidoEcommerce();
                ped_actual.setNumero(npm.getNum_orden());
                ped_actual.setUsuario_web(usu_web.getNombres() + " " +  usu_web.getApellidos());
                ped_actual.setFecha_actual_proceso(npm.getFecha_ingreso());
                ped_actual.setFecha_entrega(npm.getFecha_entrega());
                if(npm.getTipo_entrega() != null){
                    ped_actual.setTipo_entrega(npm.getTipo_entrega());
                }
                else {
                    ped_actual.setTipo_entrega("No definida");}
                ped_actual.setEstado(npm.getEstado());
                list_result.add(ped_actual);
            }
        }
        grid.setItems(list_result);
    }
    //--------------------------------------------------------------------------
    @Override
    public void On_find_FechaPed(){
        //VARIABLES
        removeAll_PedidoEcommerce();
        list_result = new ArrayList<>();
        
        List<UsuarioWeb> list_usu_web = new ArrayList<>();
        UsuarioWeb usu_web = new UsuarioWeb();
        String usu_web_id = "";
        String pedido_find = "";
        String n_state = "";
        PedidoEcommerce ped_actual = new PedidoEcommerce();
        
        //NotaPedidoCab
        List<NotaPedidoCab> ListNotaPed_Cab = new ArrayList<>();
        NotaPedidoCab npcab = new NotaPedidoCab();
        List<NotaPedidoModel> list_npm = new ArrayList<>();
        NotaPedidoModel npm = new NotaPedidoModel();
        String notaPed_cab_id;
        Date fecha_crea;
        Date fecha_entr;
        Date fecha_actual_proc;
        Boolean anulada = Boolean.FALSE;
        //DirEntrega Ecommerce
        DirEntrega dir_ecom = new DirEntrega();
        String dir_entr_id = "";
        //EstadosOrdenVenta
        List<EstadosOrdenVenta> estado_orden = new ArrayList<>();
        //Producto
        
        Date fecha_ini = Date.from(Fecha_ini_Bus.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date fecha_fin = Date.from(Fecha_fin_Bus.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        LocalDate actual_date = LocalDate.now();
        ListNotaPed_Cab = Services.getPedido().getListByFech_Repartidores(fecha_ini, fecha_fin);
        for (int i = 0; i < ListNotaPed_Cab.size(); i++){
            npcab = new NotaPedidoCab();
            npcab = ListNotaPed_Cab.get(i);
            dir_ecom = new DirEntrega();
            dir_ecom = npcab.getDireccion_Ecommerce();
            usu_web = new UsuarioWeb();
            if(npcab.getDireccion_Ecommerce() == null || dir_ecom.getUsuario_web() == null){
                System.out.println("Numero Orden: " + npcab.getNumero() + ", No tiene usuario web Registrado");
            }
            else {    
                usu_web = dir_ecom.getUsuario_web();
                ped_actual = new PedidoEcommerce();
                ped_actual.setNumero(npcab.getNumero());
                ped_actual.setUsuario_web(usu_web.getNombres() + " " + usu_web.getApellidos());
                ped_actual.setFecha_actual_proceso(npcab.getFecha());
                ped_actual.setFecha_entrega(npcab.getFechaEntrega());
                if (dir_ecom.getDireccion() != null){
                    ped_actual.setDireccion_Ecommerce(dir_ecom.getDireccion());
                }
                else {
                    ped_actual.setDireccion_Ecommerce("No definida");}        

                if(npcab.getTipo_Entrega() != null){
                    ped_actual.setTipo_entrega(npcab.getTipo_Entrega());
                }
                else {
                    ped_actual.setTipo_entrega("No definida");}
                n_state = convert_Estado(npcab.getEstado_actual());
                ped_actual.setEstado(n_state);
                list_result.add(ped_actual);
                
            }
        }
        grid.setItems(list_result);
    }
    //-----------------------------------------------------------------------------------------------
    //REPARTIDOR DIALOG
    //-----------------------------------------------------------------------------------------------
    public void Fill_ComboProds_byPed(String nota_ped_id){
        List<Producto> L_Prods_byPed = new ArrayList<>();
        List<String> L_Prods_Combo = new ArrayList<>();
        L_Prods_byPed = Services.getPedido().getProducto_byPedido(nota_ped_id);
        if(!L_Prods_byPed.isEmpty()){
            for(int i = 0; i < L_Prods_byPed.size(); i++){
                L_Prods_Combo.add(L_Prods_byPed.get(i).getNombre());
            }
            comboBoxProds_byPed.setItems(L_Prods_Combo);
        }
        txtdialog_Prods_byPed.setValue("");
    }
    //-----------------------------------------------------------------------------------------------
    @Override
    public void on_Open_Repartidor_dialog(){
        NotaPedidoCab npcab = new NotaPedidoCab();
        DirEntrega dir_ecom = new DirEntrega();
        String num_orden = "";
        String nota_ped_id = "";
        Set<PedidoEcommerce> set_pedidos = grid.getSelectedItems();
        list_aux = convertSetToList(set_pedidos);
        
        if(list_aux.size() == 1 && !list_aux.isEmpty()){
            num_orden = String.valueOf(list_aux.get(0).getNumero());
            System.out.println("El num_orden (list_select) encontrado es: " + num_orden);

            //NotaPedidoCab
            npcab = Services.getPedido().getBy_NumOrden(num_orden);
            System.out.println("El num_orden (npcab) encontrado es: " + npcab.getNumero());

            //Llenando Dialog Pedido
            txtdialog_NOrden.setValue(String.valueOf(npcab.getNumero()));
            nota_ped_id = String.valueOf(npcab.getId());
            Fill_ComboProds_byPed(nota_ped_id);

            dir_ecom = npcab.getDireccion_Ecommerce();

            usu_aux = new UsuarioWeb();
            
            if (npcab.getDireccion_Ecommerce().getDireccion() != null){
                txtdialog_DirEcom.setValue(dir_ecom.getDireccion());
                txtdialog_RefEcom.setValue(dir_ecom.getReferencia());
            }
            else {
                txtdialog_DirEcom.setValue("No definida");}

            if(list_aux.get(0).getTipo_entrega() != null){
                txtdialog_TipoEntrega.setValue(list_aux.get(0).getTipo_entrega());}
            else {
                txtdialog_TipoEntrega.setValue("No definida");}
            txtdialog_Estado.setValue(list_aux.get(0).getEstado());
            dialogPedido.open();
        }
        else { notify_select_exceed.open(); }
    }
    //-----------------------------------------------------------------------------------------------
    @Override
    public void confirmar_Entrega_dialog(){
        String new_estado = "E"; //Entregado
        LocalDate actual_date = LocalDate.now();
        Date fecha_actualizacion_estado = Date.from(actual_date.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date fecha_entr = null;
        
        //ACTUALIZACION DATOS
        
        //NOTA PEDIDO CAB
        String numero_orden = String.valueOf(list_aux.get(0).getNumero());
        NotaPedidoCab npcab = new NotaPedidoCab();
        npcab = Services.getPedido().getBy_NumOrden(numero_orden);
        Integer nota_ped_id = npcab.getId();
        npcab.setEstado_actual(new_estado);
        
        //ESTADOS ORDEN VENTA
        String nota_ped_cab_id = String.valueOf(npcab.getId());
        EstadosOrdenVenta estado = new EstadosOrdenVenta();
        List<EstadosOrdenVenta> list_estados = new ArrayList<>();
        Integer last_state_id = 0;
        list_estados = Services.getEstadosOrdenVenta().find_ByNotaPedCab(nota_ped_cab_id);
        
        DirEntrega dir_ecom = new DirEntrega();
        
        estado = new EstadosOrdenVenta();
        estado.setFecha_registro(fecha_actualizacion_estado);
        estado.setFecha_entrega(npcab.getFechaEntrega());
        estado.setEstado(new_estado);
        dir_ecom = list_estados.get(0).getDirEntrega();
        estado.setDirEntrega(dir_ecom);
        estado.setNota_pedido(npcab);
        Services.getPedido().update_NotaPed_Cab(npcab);
        Services.getEstadosOrdenVenta().save_Estado_Orden(estado);
        Pedido_notify_correct.open();
        txtdialog_Estado.setValue(list_aux.get(0).getEstado());
        grid.getDataProvider().refreshAll();
    }
    
    
    //-----------------------------------------------------------------------------------------------
    
}
