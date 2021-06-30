/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.view.ecom;

import com.upgrade.persistence.model.ecommerce.LineaEcomErp;
import com.upgrade.persistence.model.ecommerce.LineaEcommerce;
import com.upgrade.persistence.model.extcs.Linea;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import up.erp.service.Services;
import up.erp.view.App;

/**
 *
 * @author Luis Aleman
 */
public class LineasEcomView extends LineasEcomUI{
    
    //--------------------------------------------------------------------------
    //CPANEL RUTH
    //--------------------------------------------------------------------------
    public App app;
    
    public LineasEcomView(App app) {
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
    public void go_Productos(){
        this.app.layHeader.removeAll();
        this.app.setContent(new ProductosView(app));
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
    
    List<Linea> list_LERP_result = new ArrayList<>();
    List<Linea> list_LERP_aux = new ArrayList<>();
    List<LineaEcommerce> list_LECOM_result = new ArrayList<>();
    List<LineaEcommerce> list_LECOM_aux = new ArrayList<>();
    List<LineaEcomErp> l_linea_ecom_erp = new ArrayList<>();
    List<LineaEcomErp> l_linea_ecom_erp_aux = new ArrayList<>();
    //----------------------------------------------------------------------------------------------------------
    
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
    
    //----------------------------------------------------------------------------------------------------------
    public List<String> AllLineaEcom(){
        List<LineaEcommerce> list_Linea_ecom = new ArrayList<>();
        List<String> list_linea = new ArrayList<>();
        list_Linea_ecom = Services.getLineaEcommerce().get_AllLineaEcommerce();
        list_LECOM_result = list_Linea_ecom;
        for (int i = 0; i < list_Linea_ecom.size(); i++){
            list_linea.add(list_Linea_ecom.get(i).getNombre());
        }
        return list_linea;
    }
    
    @Override
    public void on_Click_ComboBusLineaEcom(){
        List<String> list_linea = new ArrayList<>();
        list_linea = AllLineaEcom();
        comboBoxLE_Bus.setItems(list_linea);
    }
    
    @Override
    public void On_find_LineaEcom() {
        String linea_ecom_name = "";
        Integer linea_ecom_id;
        list_LERP_result = new ArrayList<>();
        linea_ecom_name = txtLE_Bus.getValue();
        LineaEcommerce l_ecom = new LineaEcommerce();
        l_ecom = Services.getLineaEcommerce().get_LineaEcommerce_byNombre(linea_ecom_name);
        linea_ecom_id = l_ecom.getId();
        l_linea_ecom_erp = new ArrayList<>();
        l_linea_ecom_erp = Services.getLineaEcommerce().get_LineasERPECOM_byLineaEcom(linea_ecom_id);
        if(l_linea_ecom_erp != null){
            for(int i = 0; i < l_linea_ecom_erp.size();i++){
                System.out.println("Linea ERP encontrada es: " + l_linea_ecom_erp.get(i).getLinea_erp().getNombre());
                list_LERP_result.add(l_linea_ecom_erp.get(i).getLinea_erp());
            }
            grid.setItems(list_LERP_result);
            //grid.getColumns().get(2).setVisible(false);
        }
    }
    
    //----------------------------------------------------------------------------------------------------------
    
    @Override
    public void On_find_LineaERP() {
        String linea_erp_name = "";
        linea_erp_name = txtLERP_Bus.getValue();
        list_LERP_result = new ArrayList<>();
        list_LERP_result = Services.getLineaEcommerce().get_LineaERP_byNombre(linea_erp_name);
        grid.setItems(list_LERP_result);
        //grid.getColumns().get(2).setVisible(false);
    }
    
    //----------------------------------------------------------------------------------------------------------
    @Override
    public void on_Open_LineaEcomdialog(){
        List<String> list_linea = new ArrayList<>();
        list_linea = AllLineaEcom();
        cmbdialogLE_LEcom.setItems(list_linea);
        txtdialogLE_Nombre.setValue("");
        txtdialogLE_Descripcion.setValue("");
        txtdialogLE_Orden.setValue("");
        dialogLE_CheckActivation.setValue(Boolean.FALSE);
    }

    @Override
    public void on_find_LineaEcom_byName() {
        String linea_ecom_name = "";
        linea_ecom_name = txtdialogLE_LEcom.getValue();
        LineaEcommerce l_ecom = new LineaEcommerce();
        l_ecom = Services.getLineaEcommerce().get_LineaEcommerce_byNombre(linea_ecom_name);
        txtdialogLE_Nombre.setValue(l_ecom.getNombre());
        txtdialogLE_Descripcion.setValue(l_ecom.getDescripcion());
        txtdialogLE_Orden.setValue(String.valueOf(l_ecom.getOrden()));
        dialogLE_CheckActivation.setValue(l_ecom.getActivo());

    }

    @Override
    public void on_Crear_LineaEcom() {
        LineaEcommerce l_ecom = new LineaEcommerce();
        if(!txtdialogLE_NombreNew.isEmpty())   l_ecom.setNombre(txtdialogLE_NombreNew.getValue());
        if(!txtdialogLE_DescripcionNew.isEmpty())   l_ecom.setDescripcion(txtdialogLE_DescripcionNew.getValue());
        if(!txtdialogLE_OrdenNew.isEmpty())   l_ecom.setOrden(Integer.getInteger(txtdialogLE_OrdenNew.getValue()));
        if(!dialogLE_CheckActivationNew.isEmpty())   l_ecom.setActivo(dialogLE_CheckActivationNew.getValue());
        Services.getLineaEcommerce().save_LineaEcommerce(l_ecom);
    }

    @Override
    public void on_Actualizar_LineaEcom() {
        String linea_ecom_name = "";
        linea_ecom_name = txtdialogLE_LEcom.getValue();
        LineaEcommerce l_ecom = new LineaEcommerce();
        l_ecom = Services.getLineaEcommerce().get_LineaEcommerce_byNombre(linea_ecom_name);
        if(!txtdialogLE_Nombre.isEmpty())   l_ecom.setNombre(txtdialogLE_Nombre.getValue());
        if(!txtdialogLE_Descripcion.isEmpty())   l_ecom.setDescripcion(txtdialogLE_Descripcion.getValue());
        if(!txtdialogLE_Orden.isEmpty())   l_ecom.setOrden(Integer.getInteger(txtdialogLE_Orden.getValue()));
        if(!dialogLE_CheckActivation.isEmpty())   l_ecom.setActivo(dialogLE_CheckActivation.getValue());
        Services.getLineaEcommerce().update_LineaEcommerce(l_ecom);
    }

    @Override
    public void on_Borrar_LineaEcom() {
        String linea_ecom_name = "";
        linea_ecom_name = txtdialogLE_LEcom.getValue();
        LineaEcommerce l_ecom = new LineaEcommerce();
        l_ecom = Services.getLineaEcommerce().get_LineaEcommerce_byNombre(linea_ecom_name);
        Services.getLineaEcommerce().delete_LineaEcommerce(l_ecom);
    }

    public List<String> on_Charge_LineaEcom_ofLERP(Integer l_erp_id){
        l_linea_ecom_erp_aux = new ArrayList<>();
        String linea_erp_id = "";
        linea_erp_id = String.valueOf(l_erp_id);
        l_linea_ecom_erp_aux = Services.getLineaEcommerce().get_LineaErp_Ecom_byIdErp(linea_erp_id);
        List<String> list_linea_ecom = new ArrayList<>();
        for(int i = 0; i < l_linea_ecom_erp_aux.size();i++){
                list_linea_ecom.add(l_linea_ecom_erp_aux.get(i).getLinea_ecom_Nombre());
        }
        return list_linea_ecom;
    }
    
    @Override
    public void on_Open_LineaERPdialog() {
        //Llenar ComboBox LineaEcommerce
        List<String> list_linea = new ArrayList<>();
        list_linea = AllLineaEcom();
        comboBoxdialogLERP_LEcom.setItems(list_linea);
        
        //Get Linea selected
        Set<Linea> set_lineasERP = grid.getSelectedItems();
        list_LERP_aux = new ArrayList<>();
        list_LERP_aux = convertSetToList(set_lineasERP);
        Linea linea_ERP = new Linea();
        LineaEcommerce linea_ECOM = new LineaEcommerce();
        if(list_LERP_aux.size() == 1 && !list_LERP_aux.isEmpty()){
            linea_ERP = list_LERP_aux.get(0);
            //Llenar campos Linea ERP Existente
            if(!linea_ERP.getNombre().contentEquals(""))    txtdialogLERP_nombre.setValue(linea_ERP.getNombre());
            if(!linea_ERP.getDescripcion().contentEquals(""))    txtdialogLERP_descrp.setValue(linea_ERP.getDescripcion());

            //Llenar ComboBox de LineaEcommerce Asignadas
            List<String> list_linea_ecom = new ArrayList<>();
            list_linea_ecom = on_Charge_LineaEcom_ofLERP(linea_ERP.getId());
            comboBoxdialogLERP_LEcom_Asign.setItems(list_linea_ecom);
            dialog_LineaERP.open();
        }
        else {
            notifyLERP_select_Exceed.open();
        }
    }
    
    @Override
    public void on_Asignar_LineaERP() {
        Linea linea_ERP = new Linea();
        LineaEcommerce linea_ECOM = new LineaEcommerce();
        linea_ERP = list_LERP_aux.get(0);
        String linea_ecom_name = "";
        linea_ecom_name = txtdialogLERP_LEcom.getValue();
        linea_ECOM = Services.getLineaEcommerce().get_LineaEcommerce_byNombre(linea_ecom_name);
        
        LineaEcomErp l_Ecom_Erp = new LineaEcomErp();
        l_Ecom_Erp.setLinea_ecom(linea_ECOM);
        l_Ecom_Erp.setLinea_erp(linea_ERP);
        //Services.getLineaEcommerce().update_Linea(linea_ERP);
        //Services.getLineaEcommerce().insert_Linea_Ecom_Erp(linea_ECOM.getId(),linea_ERP.getId());
        Services.getLineaEcommerce().insert_Linea_Ecom_Erp_obj(l_Ecom_Erp);
    }
    
    @Override
    public void on_Desasignar_LineaERP(){
        Linea linea_ERP = new Linea();
        LineaEcommerce linea_ECOM = new LineaEcommerce();
        linea_ERP = list_LERP_aux.get(0);
        String linea_ecom_name = "";
        linea_ecom_name = txtdialogLERP_LEcom.getValue();
        linea_ECOM = Services.getLineaEcommerce().get_LineaEcommerce_byNombre(linea_ecom_name);
        
        LineaEcomErp l_Ecom_Erp = new LineaEcomErp();
        l_Ecom_Erp = Services.getLineaEcommerce().get_LineaERPECOM(linea_ECOM.getId(),linea_ERP.getId());
        Services.getLineaEcommerce().delete_Linea_Ecom_Erp_obj(l_Ecom_Erp);
    }

    @Override
    public void on_Open_LineaERP2dialog() {
        //Llenar ComboBox LineaEcommerce
        List<String> list_linea = new ArrayList<>();
        list_linea = AllLineaEcom();
        comboBoxdialogLERP2_LEcom.setItems(list_linea);
        
        //Get Lineas selected
        Set<Linea> set_lineasERP = grid.getSelectedItems();
        list_LERP_aux = new ArrayList<>();
        list_LERP_aux = convertSetToList(set_lineasERP);
        
    }

    @Override
    public void on_Asignar_LineasERP() {
        String linea_ecom_name = "";
        linea_ecom_name = txtdialogLERP2_LEcom.getValue();
        LineaEcommerce linea_ECOM = new LineaEcommerce();
        Linea linea_ERP = new Linea();
        linea_ECOM = Services.getLineaEcommerce().get_LineaEcommerce_byNombre(linea_ecom_name);
        for(int i = 0; i < list_LERP_aux.size(); i++){
            linea_ERP = new Linea();
            linea_ERP = list_LERP_aux.get(i);
            //Services.getLineaEcommerce().update_Linea(linea_ERP);
            //Services.getLineaEcommerce().insert_Linea_Ecom_Erp(linea_ECOM.getId(),linea_ECOM.getId());
            
            LineaEcomErp l_Ecom_Erp = new LineaEcomErp();
            l_Ecom_Erp.setLinea_ecom(linea_ECOM);
            l_Ecom_Erp.setLinea_erp(linea_ERP);
            Services.getLineaEcommerce().insert_Linea_Ecom_Erp_obj(l_Ecom_Erp);
        }
    }
    
    @Override
    public void on_Desasignar_LineasERP(){
        String linea_ecom_name = "";
        linea_ecom_name = txtdialogLERP2_LEcom.getValue();
        LineaEcommerce linea_ECOM = new LineaEcommerce();
        Linea linea_ERP = new Linea();
        linea_ECOM = Services.getLineaEcommerce().get_LineaEcommerce_byNombre(linea_ecom_name);
        for(int i = 0; i < list_LERP_aux.size(); i++){
            linea_ERP = new Linea();
            linea_ERP = list_LERP_aux.get(i);
            //Services.getLineaEcommerce().update_Linea(linea_ERP);
            //Services.getLineaEcommerce().insert_Linea_Ecom_Erp(linea_ECOM.getId(),linea_ECOM.getId());
            
            LineaEcomErp l_Ecom_Erp = new LineaEcomErp();
            l_Ecom_Erp = Services.getLineaEcommerce().get_LineaERPECOM(linea_ECOM.getId(),linea_ERP.getId());
            Services.getLineaEcommerce().delete_Linea_Ecom_Erp_obj(l_Ecom_Erp);
        }
    }
    
}
