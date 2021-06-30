/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.server.serviceimpl;

import com.upgrade.persistence.model.ecommerce.Banners;
import com.upgrade.persistence.model.ecommerce.IndexWeb;
import com.upgrade.persistence.model.ecommerce.LineaEcommerce;
import com.upgrade.persistence.model.ecommerce.SliderModel;
import com.upgrade.persistence.model.ecommerce.Sliders;
import java.util.ArrayList;
import ts.com.service.util.db.server.CRUD;
import up.erp.service.IndexWebService;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luis Aleman
 */
public class IndexWebServiceImpl implements IndexWebService {
    //---------------------------------------------------------------------------------------------
    @Override
    public IndexWeb find_Sbylider(String titulo_slider) {
        IndexWeb result = new IndexWeb();
        try {
            String where = "where titulo_slider = '"+titulo_slider+"' limit 1";
            List<IndexWeb> list = CRUD.list(IndexWeb.class,where);
            if(!list.isEmpty()){
                result = list.get(0);
            }    
        } catch (Exception ex) {
            Logger.getLogger(IndexWebServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    //---------------------------------------------------------------------------------------------
    @Override
    public IndexWeb get_LastIndexWeb(){
        IndexWeb last_IndexWeb = new IndexWeb();
        try {
            String where = "order by id desc limit 1";
            List<IndexWeb> list = CRUD.list(IndexWeb.class,where);
            if(!list.isEmpty()){
                last_IndexWeb = list.get(0);
            }    
        } catch (Exception ex) {
            Logger.getLogger(IndexWebServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return last_IndexWeb;
    }
    //---------------------------------------------------------------------------------------------
    @Override
    public void save_IndexWeb(IndexWeb index_web) {
        try {
            CRUD.save(index_web);
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //---------------------------------------------------------------------------------------------
    @Override
    public void update_IndexWeb(IndexWeb index_web) {
        try {
            CRUD.update(index_web);
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //---------------------------------------------------------------------------------------------
    //FRONTEND
    @Override
    public SliderModel Slider() {
        SliderModel sliderm = new SliderModel();
        IndexWeb result = new IndexWeb();
        try {
            String where = "order by id desc limit 1";
            List<IndexWeb> list = CRUD.list(IndexWeb.class,where);
            if(!list.isEmpty()){
                result = new IndexWeb();
                result = list.get(0);
                sliderm = new SliderModel();
                sliderm.setSlider_Url_img1(result.getRutaimg1_slider());
                sliderm.setSlider_Url_img2(result.getRutaimg2_slider());
                sliderm.setSlider_Url_img3(result.getRutaimg3_slider());
            }    
        } catch (Exception ex) {
            Logger.getLogger(IndexWebServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sliderm;
    }
    //---------------------------------------------------------------------------------------------
    @Override
    public List<Banners> get_Banners_Act() {
        List<Banners> list_Banners = new ArrayList<>();
        try {
            String where = "where a.activo is true";
            String [] require = {"linea_ecom"};
            list_Banners = CRUD.list(Banners.class,require,where);
        } catch (Exception ex) {
            Logger.getLogger(IndexWebServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list_Banners;
    }
    //---------------------------------------------------------------------------------------------
    @Override
    public Banners get_Banner_Act(String posicion){
        Banners banner = new Banners();
        LineaEcommerce linea_ecom = new LineaEcommerce();
        try {
            String where = "where a.activo is true and a.posicion = " + posicion + " limit 1";
            String [] require = {"linea_ecom"};
            List<Banners> list_Banners = CRUD.list(Banners.class,require,where);
            if (!list_Banners.isEmpty()){
                banner = new Banners();
                banner = list_Banners.get(0);
                linea_ecom = new LineaEcommerce();
                linea_ecom = list_Banners.get(0).getLinea_ecom();
                banner.setLinea_ecom(linea_ecom);
            }
        } catch (Exception ex) {
            Logger.getLogger(IndexWebServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return banner;
    }
    //---------------------------------------------------------------------------------------------
    @Override
    public Banners get_Banner_byId(String id){
        Banners banner = new Banners();
        LineaEcommerce linea_ecom = new LineaEcommerce();
        try {
            String where = "where a.activo is true and a.id = " + id + " limit 1";
            String [] require = {"linea_ecom"};
            List<Banners> list_Banners = CRUD.list(Banners.class,require,where);
            if (!list_Banners.isEmpty()){
                banner = new Banners();
                banner = list_Banners.get(0);
                linea_ecom = new LineaEcommerce();
                linea_ecom = list_Banners.get(0).getLinea_ecom();
                banner.setLinea_ecom(linea_ecom);
            }
        } catch (Exception ex) {
            Logger.getLogger(IndexWebServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return banner;
    }
    //---------------------------------------------------------------------------------------------
    @Override
    public void save_Banner(Banners banner) {
        try {
            CRUD.save(banner);
        } catch (Exception ex) {
            Logger.getLogger(IndexWebServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //---------------------------------------------------------------------------------------------
    @Override
    public void update_Banner(Banners banner) {
        try {
            CRUD.update(banner);
        } catch (Exception ex) {
            Logger.getLogger(IndexWebServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //---------------------------------------------------------------------------------------------
    @Override
    public void delete_Banner(Banners banner) {
        try {
            CRUD.delete(banner);
        } catch (Exception ex) {
            Logger.getLogger(IndexWebServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //---------------------------------------------------------------------------------------------
    @Override
    public List<Banners> get_ListBanners_byPos(String posicion) {
        List<Banners> list_Banners = new ArrayList<>();
        LineaEcommerce l_ecom = new LineaEcommerce();
        try {
            String where = "where a.posicion = " + posicion + "order by a.id asc";
            String [] require = {"linea_ecom"};
            list_Banners = CRUD.list(Banners.class,require,where);
            if(!list_Banners.isEmpty()){
                for(int i = 0; i < list_Banners.size(); i++){
                    if(list_Banners.get(i).getLinea_ecom() == null){
                        l_ecom = new LineaEcommerce();
                        l_ecom.setNombre("No definida");
                        list_Banners.get(i).setLinea_ecom(l_ecom);
                    }
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(IndexWebServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list_Banners;
    }
    //---------------------------------------------------------------------------------------------
    @Override
    public Boolean is_Banner_Act(String posicion){
        Boolean resp = Boolean.FALSE;
        Banners banner = new Banners();
        try {
            String where = "where a.activo is true and a.posicion = " + posicion;
            List<Banners> list_Banners = CRUD.list(Banners.class,where);
            if (!list_Banners.isEmpty()){
                resp = Boolean.TRUE;
            }
        } catch (Exception ex) {
            Logger.getLogger(IndexWebServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }
    
    //---------------------------------------------------------------------------------------------
    @Override
    public List<Sliders> get_AllSliders(){
        List<Sliders> l_sliders = new ArrayList<>();
        try {
            String where = "order by a.id asc";
            l_sliders = CRUD.list(Sliders.class,where);
        } catch (Exception ex) {
            Logger.getLogger(IndexWebServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l_sliders;
    }
    //---------------------------------------------------------------------------------------------
    @Override
    public List<Sliders> get_Only_Sliders_Activos(){
        List<Sliders> l_sliders = new ArrayList<>();
        try {
            String where = "where a.activo is true order by a.id asc";
            l_sliders = CRUD.list(Sliders.class,where);
        } catch (Exception ex) {
            Logger.getLogger(IndexWebServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l_sliders;
    }
    //---------------------------------------------------------------------------------------------
    @Override
    public Sliders get_Sliderby_UrlImg(String url_img){
        Sliders slider = new Sliders();
        List<Sliders> l_sliders = new ArrayList<>();
        try {
            String where = "where a.url_imagen = '"+ url_img +"' limit 1";
            l_sliders = CRUD.list(Sliders.class,where);
            if(!l_sliders.isEmpty()){
                slider = new Sliders();
                slider = l_sliders.get(0);
            }
        } catch (Exception ex) {
            Logger.getLogger(IndexWebServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return slider;
    }
    //---------------------------------------------------------------------------------------------
    @Override
    public void save_Slider(Sliders slider){
        try {
            CRUD.save(slider);
        } catch (Exception ex) {
            Logger.getLogger(IndexWebServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //---------------------------------------------------------------------------------------------
    @Override
    public void update_Slider(Sliders slider){
        try {
            CRUD.update(slider);
        } catch (Exception ex) {
            Logger.getLogger(IndexWebServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //---------------------------------------------------------------------------------------------
    @Override
    public void delete_Slider(Sliders slider){
        try {
            CRUD.delete(slider);
        } catch (Exception ex) {
            Logger.getLogger(IndexWebServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //---------------------------------------------------------------------------------------------
}
