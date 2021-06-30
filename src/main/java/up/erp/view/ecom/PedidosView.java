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
/**
 *
 * @author Luis Aleman
 */
public class PedidosView extends PedidosUI{
    
    //--------------------------------------------------------------------------
    //CPANEL RUTH
    //--------------------------------------------------------------------------
    public App app;
    
    public PedidosView(App app) {
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
    public void go_Clientes() {
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
    @Override
    public void On_find_NOrdenPed() {
        //VARIABLES
        removeAll_PedidoEcommerce();
        list_result = new ArrayList<>();
        String N_Orden = "";
        NotaPedidoCab npcab = new NotaPedidoCab();
        Boolean check_PedDespachado = Boolean.FALSE;
        PedidoEcommerce ped_actual = new PedidoEcommerce();
        UsuarioWeb usu_web = new UsuarioWeb();
        String n_state = "";
        DirEntrega dir_ecom = new DirEntrega();
        String dir_entr_id = "";
        
        Integer forma_pago = 0;
        String tipo_pago = "";
        
        if(!txtInput_NOrden.isEmpty()){
            N_Orden = txtInput_NOrden.getValue();
            npcab = Services.getPedido().getBy_NumOrden(N_Orden);
            
            //------------------------------------------------------------------
            //Verificar Pedidos Recojo en Tienda con estado D:Despachado
            //------------------------------------------------------------------
            check_PedDespachado = CheckPedidos_FueraAlmacen(npcab);
            if(check_PedDespachado == Boolean.TRUE){
                npcab.setEstado_actual("E");
                Services.getPedido().update_NotaPed_Cab(npcab);
                System.out.println("Pedido N°: " + npcab.getNumero() + ", ha sido actualizado a Estado: Entregado - " + npcab.getEstado_actual());
            }
            //------------------------------------------------------------------
            
            
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
                ped_actual.setAprobada(npcab.getAprobada());
                
                if(npcab.getFormaPago() != null){
                    forma_pago = npcab.getFormaPago().getId();
                    //Forma_pago = 1 : Transferencia / Depósito
                    if( forma_pago == 1 && 
                        npcab.getObservaciones().contentEquals("Pre orden por confirmar") &&
                        npcab.getTokenTarjeta() == null ) {
                        tipo_pago = "Depósito/Tranferencia";
                        ped_actual.setTipo_pago(tipo_pago);
                    }
                    //Forma_pago = 2 : Tarjeta
                    if( npcab.getAprobada() == Boolean.TRUE &&
                        forma_pago == 2 &&
                        npcab.getTokenTarjeta() == null ){
                        tipo_pago = "Tarjeta";
                        ped_actual.setTipo_pago(tipo_pago);
                    }
                }
                else {
                    ped_actual.setTipo_pago("No definida");
                }
                
                list_result.add(ped_actual);
            }
            grid.setItems(ped_actual);
            GridCols = new ArrayList<>();
            init_ReporterToolbar();
        }
    }
    //--------------------------------------------------------------------------
    @Override
    public void On_find_Ped() {
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
        Boolean check_PedDespachado = Boolean.FALSE;
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
        
        Integer forma_pago = 0;
        String tipo_pago = "";
        
        pedido_find = txtInput_find.getValue();
        list_usu_web = Services.getUsuarioWeb().find_soloActivos(pedido_find);
        for (int i = 0; i < list_usu_web.size(); i++){
            usu_web = new UsuarioWeb();
            usu_web = list_usu_web.get(i);
            usu_web_id = String.valueOf(usu_web.getId());
            System.out.println("Usuario id: " + usu_web_id + ", nombre: " + usu_web.getNombres());

            //Busqueda NotaPedido Model
            list_npm = new ArrayList<>();
            list_npm = Services.getPedido().getPedidoEcom_Panel(usu_web_id);
            for (int j = 0; j < list_npm.size(); j++){
                npm = new NotaPedidoModel();
                npm = list_npm.get(j);
                System.out.println("Numero Orden: " + npm.getNum_orden());
                
                //------------------------------------------------------------------
                //Verificar Pedidos Recojo en Tienda con estado D:Despachado
                //------------------------------------------------------------------
                npcab = Services.getPedido().getBy_NumOrden_Repartidores(String.valueOf(npm.getNum_orden()));
                
                check_PedDespachado = CheckPedidos_FueraAlmacen(npcab);
                if(check_PedDespachado == Boolean.TRUE){
                    npcab.setEstado_actual("E");
                    Services.getPedido().update_NotaPed_Cab(npcab);
                    System.out.println("Pedido N°: " + npcab.getNumero() + ", ha sido actualizado a Estado: Entregado - " + npcab.getEstado_actual());
                }
                //------------------------------------------------------------------
                
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
                
                ped_actual.setAprobada(npcab.getAprobada());
                
                if(npcab.getFormaPago() != null){
                    forma_pago = npcab.getFormaPago().getId();
                    //Forma_pago = 1 : Transferencia / Depósito
                    if( forma_pago == 1 && 
                        npcab.getObservaciones().contentEquals("Pre orden por confirmar") &&
                        npcab.getTokenTarjeta() == null) {
                        tipo_pago = "Depósito/Tranferencia";
                        ped_actual.setTipo_pago(tipo_pago);
                    }
                    //Forma_pago = 2 : Tarjeta
                    if( npcab.getAprobada() == Boolean.TRUE &&
                        forma_pago == 2 &&
                        npcab.getTokenTarjeta() == null ){
                        tipo_pago = "Tarjeta";
                        ped_actual.setTipo_pago(tipo_pago);
                    }
                }
                else {
                    ped_actual.setTipo_pago("No definida");
                }
                
                list_result.add(ped_actual);
            }
        }
        grid.setItems(list_result);
        GridCols = new ArrayList<>();
        init_ReporterToolbar();
        //grid.getColumns().get(5).setVisible(false);
    }
    
    @Override
    public void On_find_Ped2() {
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
        Boolean check_PedDespachado = Boolean.FALSE;
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
        
        Integer forma_pago = 0;
        String tipo_pago = "";
        //Producto
        
        Date fecha_ini = Date.from(Fecha_ini_DatePicker.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date fecha_fin = Date.from(Fecha_fin_DatePicker.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        LocalDate actual_date = LocalDate.now();
        ListNotaPed_Cab = Services.getPedido().getListByFech(fecha_ini, fecha_fin);
        for (int i = 0; i < ListNotaPed_Cab.size(); i++){
            npcab = new NotaPedidoCab();
            npcab = ListNotaPed_Cab.get(i);
            
            //------------------------------------------------------------------
            //Verificar Pedidos Recojo en Tienda con estado D:Despachado
            //------------------------------------------------------------------
            check_PedDespachado = CheckPedidos_FueraAlmacen(npcab);
            if(check_PedDespachado == Boolean.TRUE){
                npcab.setEstado_actual("E");
                Services.getPedido().update_NotaPed_Cab(npcab);
                System.out.println("Pedido N°: " + npcab.getNumero() + ", ha sido actualizado a Estado: Entregado - " + npcab.getEstado_actual());
            }
            //------------------------------------------------------------------
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
                
                ped_actual.setAprobada(npcab.getAprobada());
                
                if(npcab.getFormaPago() != null){
                    forma_pago = npcab.getFormaPago().getId();
                    //Forma_pago = 1 : Transferencia / Depósito
                    if( forma_pago == 1 && 
                        npcab.getObservaciones().contentEquals("Pre orden por confirmar") &&
                        npcab.getTokenTarjeta() == null ){
                        tipo_pago = "Depósito/Tranferencia";
                        ped_actual.setTipo_pago(tipo_pago);
                    }
                    //Forma_pago = 2 : Tarjeta
                    if( npcab.getAprobada() == Boolean.TRUE &&
                        forma_pago == 2 &&
                        npcab.getTokenTarjeta() == null ){
                        tipo_pago = "Tarjeta";
                        ped_actual.setTipo_pago(tipo_pago);
                    }
                }
                else {
                    ped_actual.setTipo_pago("No definida");
                }
                
                list_result.add(ped_actual);
                
            }
        }
        grid.setItems(list_result);
        GridCols = new ArrayList<>();
        init_ReporterToolbar();
        //grid.getColumns().get(5).setVisible(false);
    }
    
    //--------------------------------------------------------------------------
    //OTROS
    //--------------------------------------------------------------------------
    public Boolean CheckPedidos_EntregaCompleta(List<NotaPedidoDet> L_NotaPedDet){
        Boolean resp = Boolean.TRUE;
        Boolean entregaCompl_NotaPed = Boolean.FALSE;
        
        for (int i = 0; i < L_NotaPedDet.size(); i++){
            entregaCompl_NotaPed = L_NotaPedDet.get(i).getEntregaCompleta();
            if(entregaCompl_NotaPed == Boolean.FALSE){resp = Boolean.FALSE;}
        }
        System.out.println("Entrega Completa para todos los pedidos es: " + resp);
        return resp;
    }
    
    public Boolean CheckPedidos_FueraAlmacen(NotaPedidoCab npcab){
        Boolean resp = Boolean.FALSE;
        String estado_NotaPed = "";
        String tipoEntrega_NotaPed = "";
        String id_NotaPed = "";
        Boolean entregaCompl_NotaPed = Boolean.FALSE;
        List<NotaPedidoDet> L_NotaPedDet = new ArrayList<>();
        
        if(npcab != null){
            id_NotaPed = String.valueOf(npcab.getId());
            estado_NotaPed = npcab.getEstado_actual();
            tipoEntrega_NotaPed = npcab.getTipo_Entrega();
            L_NotaPedDet = Services.getPedido().getNotaPedidoDet_byNotaPedidoCab(id_NotaPed);
            entregaCompl_NotaPed = CheckPedidos_EntregaCompleta(L_NotaPedDet);
            if(estado_NotaPed.contentEquals("D") && tipoEntrega_NotaPed.contentEquals("recojo") && entregaCompl_NotaPed == Boolean.TRUE){
                System.out.println("Pedido N°: " + npcab.getNumero() + ", Va a cambiar de estado a E:Entregado");
                resp = Boolean.TRUE;
            }
        }
        else {
            resp = Boolean.FALSE;
        }
        return resp;
    }
    
    
    //--------------------------------------------------------------------------
    //DIALOG PEDIDO
    //--------------------------------------------------------------------------
    public void on_Click_ComboEstados(){
        comboBoxEstados.setItems("En Almacén(L)",
                                 "Despachado(D)",
                                 "Entregado(E)",
                                 "Anulado(A)");
    }
    
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
    
    public Boolean Check_Estado(Integer pedido_id, String new_estado, List<EstadosOrdenVenta> list_estados) {
        Boolean resp = Boolean.FALSE;
        Integer id_list = 0;
        String state = "";
        NotaPedidoCab npcab = new NotaPedidoCab();
        if (new_estado.contentEquals("P") || new_estado.contentEquals("L") || new_estado.contentEquals("D") || new_estado.contentEquals("E") || new_estado.contentEquals("A")){
            if (new_estado.contentEquals("A")){
                resp = Boolean.FALSE;
                System.out.println("El estado: " + new_estado + ": Anulado puede modificarse");
                return resp;
            }
            else {
                resp = Boolean.FALSE;
                for (int i = 0; i < list_estados.size(); i++){
                    npcab = new NotaPedidoCab();
                    npcab = list_estados.get(i).getNota_pedido();
                    id_list = npcab.getId();
                    state = list_estados.get(i).getEstado();
                    if(new_estado.contentEquals(state) && pedido_id.equals(id_list)){
                        resp = Boolean.TRUE;
                        System.out.println("El estado: " + new_estado + " ya existe para este pedido");
                    }
                }
            }
            return resp;
        }
        else {
            resp = Boolean.TRUE;
            System.out.println("El estado: " + new_estado + " es incorrecto");
            return resp;
        }
        
    }
    
    @Override
    public void on_Open_Pedidodialog() {
        on_Click_ComboEstados();
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
            if(dir_ecom.getUsuario_web() != null){   
                usu_aux = dir_ecom.getUsuario_web();
                txtdialog_UsuName.setValue(usu_aux.getNombres() + " " + usu_aux.getApellidos());
                txtdialog_UsuTelf.setValue(usu_aux.getTelefono());
                txtdialog_UsuEmail.setValue(usu_aux.getEmail());
            }
            else {
                txtdialog_UsuTelf.setValue("");
                txtdialog_UsuEmail.setValue("");
            }

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
        else {notify_select_exceed.open();}
    }
    
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

    @Override
    public void on_Grabar_Pedido() {
        String new_estado = "";
        if (txtdialog_Estado.getValue() != null){
            new_estado = get_Estado(txtdialog_Estado.getValue());
        }
        else {
            new_estado = list_aux.get(0).getEstado();
        }
        LocalDate actual_date = LocalDate.now();
        Date fecha_actualizacion_estado = Date.from(actual_date.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date fecha_entr = null;
        /*
        if (dialog_Fecha.getValue() != null){
            fecha_entr = Date.from(dialog_Fecha.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        }*/
        
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
        
        Boolean check_state = Check_Estado(nota_ped_id,new_estado, list_estados);
        DirEntrega dir_ecom = new DirEntrega();
        if (check_state == Boolean.FALSE){
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
            grid.getDataProvider().refreshAll();
        }
        else {
            Pedido_notify_incorrect.open();
        }
    }

    //--------------------------------------------------------------------------
    //REPORTEADOR
    //--------------------------------------------------------------------------
    public void init_GridCols(){
        GridCols = new ArrayList<>();
        
        GridCols.add("Número");
        GridCols.add("Usuario");
        GridCols.add("Fecha de Entrega");
        GridCols.add("Fecha Ultima Actualización Estado");
        GridCols.add("Estado");
    }
    //--------------------------------------------------------------------------
    @Override
    public void init_ReporterToolbar(){
        //Cols
        init_GridCols();
        Toolbar.set_ColumnData2(GridCols);
        
        
        //Rows
        Integer numero = 0;
        String usuario_web = "";
        Date fecha_entrega = new Date();
        Date fecha_estado = new Date();
        String estado = "";
        
        int L_gridContent_size = list_result.size();
        Integer objectContent_size = GridCols.size();
        
        Toolbar.set_RowData(L_gridContent_size,objectContent_size);
        for(int i = 0; i < L_gridContent_size; i++){
            numero = 0;
            numero = list_result.get(i).getNumero();
            System.out.println("Numero Orden: " + numero);
            Toolbar.ROWS[i].add(numero);
            
            usuario_web = "";
            usuario_web = list_result.get(i).getUsuario_web();
            System.out.println("Usuario Web: " + usuario_web);
            Toolbar.ROWS[i].add(usuario_web);
            
            fecha_entrega = new Date();
            fecha_entrega = list_result.get(i).getFecha_entrega();
            System.out.println("Fecha Entrega: " + fecha_entrega);
            Toolbar.ROWS[i].add(fecha_entrega);
            
            fecha_estado = new Date();
            fecha_estado = list_result.get(i).getFecha_actual_proceso();
            System.out.println("Fecha Ultima Actualización Estado: " + fecha_estado);
            Toolbar.ROWS[i].add(fecha_estado);
            
            estado = "";
            estado = list_result.get(i).getEstado();
            System.out.println("Estado: " + estado);
            Toolbar.ROWS[i].add(estado);
        }
        
        //Usuario
        Toolbar.set_UsuarioID("_");
        
        //Módulo
        Toolbar.set_Module("PEDIDOSECOM");
    }
    //--------------------------------------------------------------------------
    @Override
    public void init_ReporterToolbar_default(){
        //Cols && Rows
        Toolbar.Generate_Table_default();
        
        //Usuario
        Toolbar.set_UsuarioID("_");
        
        //Módulo
        Toolbar.set_Module("PEDIDOSECOM");
    }
    //--------------------------------------------------------------------------
    
}
