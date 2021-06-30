/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.view.produccion;

import com.upgrade.persistence.model.extcs.OrdenDet;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import up.erp.service.Services;
import up.erp.service.util.SendMail;
import up.erp.view.App;
import org.springframework.mail.javamail.JavaMailSender;

/**
 *
 * @author Upgrade - PC
 */
public class ReportesTransformacionView  extends ReportesTransformacionUI {
    
    private App app;
    
    @Autowired
    private JavaMailSender javaMailSender;
     
    public ReportesTransformacionView(App app)
    {
        this.app = app;      
        //btnAgregar.setEnabled(false);
        List<OrdenDet> listOrdenes = Services.getOrden().listArticulosPorTransformacion();
        gridTransformaciones.setItems(listOrdenes);
    }
    
    public void onGetTransformaciones(){
        if(txtBuscarSerie.getValue() == null){
            List<OrdenDet> listOrdenes = Services.getOrden().listArticulosPorTransformacion();
            gridTransformaciones.setItems(listOrdenes);
        }
        else{
            List<OrdenDet> listOrdenes = Services.getOrden().listArticulosPorTransformacionAndSerie(txtBuscarSerie.getValue());
            gridTransformaciones.setItems(listOrdenes);
        }
    }
    
    @Override
    public void onLoadAlLTransformaciones()
    {
        
    }
    
    @Override
    public void onLoadDetallesTransformacion(){
        List<OrdenDet> listOrdenes = Services.getOrden().listArticulosByIdPadre(String.valueOf(gridTransformaciones.asSingleSelect().getValue().getArticulo().getId()));
        gridItemsTransformacion.setItems(listOrdenes);
    }
    
    @Override
    public void onSendMail()
    {
        //JavaMailSender javaMailSender = new JavaMailSender();
        SendMail mailUtil = new SendMail(javaMailSender);
        mailUtil.verificarEmail("name", "name", "dijaq08@gmail.com");
    }
}
