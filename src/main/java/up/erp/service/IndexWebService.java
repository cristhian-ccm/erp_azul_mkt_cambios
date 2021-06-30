/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.service;

import com.upgrade.persistence.model.ecommerce.Banners;
import com.upgrade.persistence.model.ecommerce.IndexWeb;
import com.upgrade.persistence.model.ecommerce.LineaEcommerce;
import com.upgrade.persistence.model.ecommerce.SliderModel;
import com.upgrade.persistence.model.ecommerce.Sliders;
import java.util.List;

/**
 *
 * @author Luis Aleman
 */
public interface IndexWebService {
    
    public IndexWeb find_Sbylider(String titulo_slider);
    public IndexWeb get_LastIndexWeb();
    public void save_IndexWeb(IndexWeb index_web);
    public void update_IndexWeb(IndexWeb index_web);
    
    //FRONTEND
    public SliderModel Slider();
    public List<Banners> get_Banners_Act();
    public Banners get_Banner_Act(String posicion);
    public Banners get_Banner_byId(String id);
    
    public List<Banners> get_ListBanners_byPos(String posicion);
    
    //CPANEL
    
    public List<Sliders> get_AllSliders();
    public List<Sliders> get_Only_Sliders_Activos();
    public Sliders get_Sliderby_UrlImg(String url_img);
    
    public void save_Slider(Sliders slider);
    public void update_Slider(Sliders slider);
    public void delete_Slider(Sliders slider);
    
    public Boolean is_Banner_Act(String posicion);
    
    public void save_Banner(Banners banner);
    public void update_Banner(Banners banner);
    public void delete_Banner(Banners banner);
    
}
