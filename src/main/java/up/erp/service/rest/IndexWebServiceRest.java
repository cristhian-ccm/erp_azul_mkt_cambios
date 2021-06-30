/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.service.rest;

import com.upgrade.persistence.model.ecommerce.Banners;
import com.upgrade.persistence.model.ecommerce.IndexWeb;
import com.upgrade.persistence.model.ecommerce.SliderModel;
import com.upgrade.persistence.model.ecommerce.Sliders;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import up.erp.service.IndexWebService;
import up.erp.service.Services;

/**
 *
 * @author Luis Aleman
 */
@RequestMapping("/index_web")
@RestController
public class IndexWebServiceRest implements IndexWebService{

    @Override
    public IndexWeb find_Sbylider(String titulo_slider) {
        return Services.getIndexWeb().find_Sbylider(titulo_slider);
    }

    @Override
    public void save_IndexWeb(IndexWeb index_web) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update_IndexWeb(IndexWeb index_web) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @GetMapping("/sliders")
    @Override
    public SliderModel Slider() {
        return Services.getIndexWeb().Slider();
    }

    @Override
    public List<Banners> get_Banners_Act() {
        return Services.getIndexWeb().get_Banners_Act();
    }

    @Override
    public Banners get_Banner_Act(String posicion) {
        return Services.getIndexWeb().get_Banner_Act(posicion);
    }

    @Override
    public void save_Banner(Banners banner) {
    }

    @Override
    public void update_Banner(Banners banner) {
    }

    @Override
    public void delete_Banner(Banners banner) {
    }

    @Override
    public IndexWeb get_LastIndexWeb() {
        return Services.getIndexWeb().get_LastIndexWeb();
    }

    @Override
    public Banners get_Banner_byId(String id) {
        return Services.getIndexWeb().get_Banner_byId(id);
    }

    @Override
    public List<Banners> get_ListBanners_byPos(String posicion) {
        return Services.getIndexWeb().get_ListBanners_byPos(posicion);
    }

    @Override
    public Boolean is_Banner_Act(String posicion) {
        return Services.getIndexWeb().is_Banner_Act(posicion);
    }

    @Override
    public List<Sliders> get_AllSliders() {
        return Services.getIndexWeb().get_AllSliders();
    }

    @GetMapping("/sliders-activos")
    @Override
    public List<Sliders> get_Only_Sliders_Activos() {
        return Services.getIndexWeb().get_Only_Sliders_Activos();
    }

    @Override
    public Sliders get_Sliderby_UrlImg(String url_img) {
        return Services.getIndexWeb().get_Sliderby_UrlImg(url_img);
    }

    @Override
    public void save_Slider(Sliders slider) {
        Services.getIndexWeb().save_Slider(slider);
    }

    @Override
    public void update_Slider(Sliders slider) {
        Services.getIndexWeb().update_Slider(slider);
    }

    @Override
    public void delete_Slider(Sliders slider) {
        Services.getIndexWeb().delete_Slider(slider);
    }
    
}
