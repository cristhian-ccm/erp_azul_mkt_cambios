/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.view.ecom;

import up.erp.view.App;

/**
 *
 * @author evanl
 */
public class CPanelView extends CPanelUI {
    
    //--------------------------------------------------------------------------
    //CPANEL RUTH
    //--------------------------------------------------------------------------
    public App app;
    
    public CPanelView(App app) {
        this.app = app;
    }
    //--------------------------------------------------------------------------
    public PedidosView pedidoView;
    
    @Override
    public void On_PedidosView() {
        this.app.layHeader.removeAll();
        this.app.setContent(new PedidosView(app));
    }
    //--------------------------------------------------------------------------
    @Override
    public void On_ClientesView(){
       this.app.layHeader.removeAll();
       this.app.setContent(new ClientesView(app));
    }
    //--------------------------------------------------------------------------
    @Override
    public void On_ProductosView(){
       this.app.layHeader.removeAll();
       this.app.setContent(new ProductosView(app));
    }
    //--------------------------------------------------------------------------
    @Override
    public void On_LineasEcommerceView(){
       this.app.layHeader.removeAll();
       this.app.setContent(new LineasEcomView(app));
    }
    //--------------------------------------------------------------------------
    @Override
    public void On_IndexWebView(){
       this.app.layHeader.removeAll();
       //this.app.setContent(new IndexWebView(app));
       this.app.setContent(new IndexWeb2View(app));
    }
    //--------------------------------------------------------------------------
    @Override
    public void On_CuponesView(){
       this.app.layHeader.removeAll();
       this.app.setContent(new CuponesView(app));
    }
    //--------------------------------------------------------------------------
    
    //this.app.setContent(new PlantillaTransformacionesView(this.app));
    
    //public void PedidosView_Construct(PedidosView pedidoView){
      //  this.pedidoView = pedidoView;
    //}
    

    
    
}
