/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.view.ecom;

import com.upgrade.persistence.model.ecommerce.Banners;
import com.upgrade.persistence.model.ecommerce.IndexWeb;
import com.upgrade.persistence.model.ecommerce.LineaEcommerce;
import com.upgrade.persistence.model.ecommerce.Sliders;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.upload.SucceededEvent;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
import up.erp.server.Server;
import up.erp.service.Services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import up.erp.view.App;

//import static sun.net.www.protocol.http.AuthCacheValue.Type.Server;

/**
 *
 * @author Hvt
 */
public class IndexWebNewView extends IndexWebNewUI {
    // --------------------------------------------------------------------------
    // CPANEL RUTH
    // --------------------------------------------------------------------------
    public App app;

    public IndexWebNewView(App app) {
        this.app = app;
    }

    // --------------------------------------------------------------------------
    @Override
    public void go_CPanel() {
        removeAll();
        // this.app.setContent(new CPanelView(app));
        this.app.setContent(new CPanelView2(app));
    }

    // --------------------------------------------------------------------------
    @Override
    public void go_Clientes() {
        this.app.layHeader.removeAll();
        this.app.setContent(new ClientesView(app));
    }

    // --------------------------------------------------------------------------
    @Override
    public void go_Subscriptores() {
        this.app.layHeader.removeAll();
        this.app.setContent(new SubscriptoresView(app));
    }

    // --------------------------------------------------------------------------
    @Override
    public void go_Promociones() {
        this.app.layHeader.removeAll();
        this.app.setContent(new PromocionesView(app));
    }

    // --------------------------------------------------------------------------
    @Override
    public void go_Cupones() {
        this.app.layHeader.removeAll();
        this.app.setContent(new CuponesView(app));
    }

    // --------------------------------------------------------------------------
    @Override
    public void go_PuntosUP() {
        this.app.layHeader.removeAll();
        this.app.setContent(new PuntosUpView(app));
    }

    // --------------------------------------------------------------------------
    @Override
    public void go_Pedidos() {
        this.app.layHeader.removeAll();
        this.app.setContent(new PedidosView(app));
    }

    // --------------------------------------------------------------------------
    @Override
    public void go_Productos() {
        this.app.layHeader.removeAll();
        this.app.setContent(new ProductosView(app));
    }

    // --------------------------------------------------------------------------
    @Override
    public void go_LineasEcom() {
        this.app.layHeader.removeAll();
        this.app.setContent(new LineasEcomView(app));
    }

    // --------------------------------------------------------------------------
    @Override
    public void go_Index() {
        this.app.layHeader.removeAll();
        // this.app.setContent(new IndexWebView(app));
        this.app.setContent(new IndexWeb2View(app));
    }

    // --------------------------------------------------------------------------
    // --------------------------------------------------------------------------

    // SLIDERS
    String path_sliderNew = "";
    String path_sliderExist = "";

    String Url_img_sliderNew = "";
    String Url_img_sliderExist = "";

    List<Sliders> l_slidersAux = new ArrayList<>();
    List<Sliders> l_slidersE = new ArrayList<>();
    Integer iterator_slidersE = 0;
    // ----------------------------------------------------------------------------------
    // DIALOG LINEA ECOMMERCE

    // POSICION
    Integer posicion;

    // UPLOAD LINEA
    String path_linea = "";
    String Url_img_linea = "";

    // BANNERS ACTIVOS
    List<LineaEcommerce> L_Linea_ecom = new ArrayList<>();
    List<Banners> L_Banners = new ArrayList<>();
    Integer iterator_L_Banners = 0;
    List<Banners> L_Banners_aux = new ArrayList<>();
    String id_banner = "";
    // ----------------------------------------------------------------------------------

    // -----------------------------------------------------------------------------------------------
    // MAIN VIEW
    // -----------------------------------------------------------------------------------------------
    @Override
    public void init_Sliders() {
        iterator_slidersE = 0;
        l_slidersE = new ArrayList<>();
        l_slidersE = Services.getIndexWeb().get_AllSliders();
        l_slidersAux = l_slidersE;
        Sliders sliderE = new Sliders();
        if (!l_slidersE.isEmpty()) {
            sliderE = l_slidersE.get(0);

            // Url Imagen
            if (sliderE.getUrl_imagen() == null || sliderE.getUrl_imagen() == "") {
                imgSE.setSrc("");
            }
            // if(sliderE.getUrl_imagen() != null || sliderE.getUrl_imagen() != "")
            // {imgSE.setSrc(sliderE.getUrl_imagen());}
            else {
                imgSE.setSrc(sliderE.getUrl_imagen());
            }

            // Url Imagen - TextField
            if (sliderE.getUrl_imagen() == null || sliderE.getUrl_imagen() == "") {
                txtSEUpload.setValue("");
            }
            // if(sliderE.getUrl_imagen() != null || sliderE.getUrl_imagen() != "")
            // {txtSEUpload.setValue(sliderE.getUrl_imagen());}
            else {
                txtSEUpload.setValue(sliderE.getUrl_imagen());
            }

            // Url Link
            if (sliderE.getUrl_link() == null || sliderE.getUrl_link() == "") {
                txtSELink.setValue("");
            }
            // if(sliderE.getUrl_link() != null || sliderE.getUrl_link() != "")
            // {txtSELink.setValue(sliderE.getUrl_link());}
            else {
                txtSELink.setValue(sliderE.getUrl_link());
            }

            // Activo
            if (sliderE.getActivo() == null) {
                checkSE_Activate.setValue(Boolean.FALSE);
            }
            // if(sliderE.getActivo() != null)
            // {checkSE_Activate.setValue(sliderE.getActivo());}
            else {
                checkSE_Activate.setValue(sliderE.getActivo());
            }
        } else {
            imgSE.setSrc("");
            txtSEUpload.setValue("");
            txtSELink.setValue("");
            checkSE_Activate.setValue(Boolean.FALSE);
        }
    }

    // -----------------------------------------------------------------------------------------------
    private void onUpload(MemoryBuffer mbuffer, String path_slider, String fileName, Image image, String url_image,
            TextField txt) {
        path_slider = "";
        try {
            // LECTURA
            InputStream is = mbuffer.getInputStream();
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            path_slider = Server.PATH_IMAGES + fileName;

            // ESCRITURA
            File newFile = new File(path_slider);
            OutputStream out = new FileOutputStream(newFile);
            out.write(buffer);
            out.close();
            is.close();

            // CARGA IMAGEN
            url_image = Server.URL_IMAGES + fileName;
            txt.setValue(path_slider);
            image.setSrc(url_image);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    // -----------------------------------------------------------------------------------------------
    // SLIDER NUEVO
    // -----------------------------------------------------------------------------------------------

    // UPLOAD
    @Override
    public void on_UploadSNew(SucceededEvent event) {
        // onUpload(bufferHead,path_H,event.getFileName(),imgH1,Url_img_head,txtHUpload1);
        path_sliderNew = "";
        try {

            // LECTURA
            InputStream is = bufferSliderNew.getInputStream();
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            path_sliderNew = Server.PATH_IMAGES + event.getFileName();
            System.out.println("Upload Nuevo slider: Path Imagen: " + path_sliderNew);

            // ESCRITURA
            File newFile = new File(path_sliderNew);
            OutputStream out = new FileOutputStream(newFile);
            out.write(buffer);
            out.close();
            is.close();

            // CARGA IMAGEN
            Url_img_sliderNew = Server.URL_IMAGES + event.getFileName();
            txtSNUpload.setValue(Url_img_sliderNew);
            imgSN.setSrc(Url_img_sliderNew);
            System.out.println("Upload Nuevo slider: Url Imagen: " + Url_img_sliderNew);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // -----------------------------------------------------------------------------------------------
    @Override
    public void on_Grabar_SliderNew() {
        Sliders sliderN = new Sliders();
        // --------------------------------------------------------------------------
        if (!txtSNUpload.isEmpty()) {
            System.out.println("Url Imagen Nuevo Slider: " + Url_img_sliderNew);
            System.out.println("Url Imagen Nuevo Slider: " + txtSNUpload.getValue());
            sliderN.setUrl_imagen(txtSNUpload.getValue());
        }
        // --------------------------------------------------------------------------
        if (!txtSNLink.isEmpty()) {
            System.out.println("Url Link Nuevo Slider: " + txtSNLink.getValue());
            sliderN.setUrl_link(txtSNLink.getValue());
        }
        // --------------------------------------------------------------------------
        System.out.println("Nuevo Slider Activo?: " + checkSN_Activate.getValue());
        sliderN.setActivo(checkSN_Activate.getValue());
        // --------------------------------------------------------------------------
        Services.getIndexWeb().save_Slider(sliderN);
        notify_created.open();
        init_Sliders();
    }

    // -----------------------------------------------------------------------------------------------
    @Override
    public void on_Descartar_SliderNew() {
        imgSN.setSrc("");
        txtSNUpload.setValue("");
        txtSNLink.setValue("");
        checkSN_Activate.setValue(Boolean.FALSE);
        notify_discard.open();
    }
    // -----------------------------------------------------------------------------------------------

    // -----------------------------------------------------------------------------------------------
    // SLIDER EXISTENTE
    // -----------------------------------------------------------------------------------------------
    // UPLOAD
    @Override
    public void on_UploadSExist(SucceededEvent event) {
        // onUpload(bufferSlider1,path_slider1,event.getFileName(),imgB1,Url_img1_slider,txtBUpload1);
        path_sliderExist = "";
        try {

            // LECTURA
            InputStream is = bufferSliderExist.getInputStream();
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            path_sliderExist = Server.PATH_IMAGES + event.getFileName();

            // ESCRITURA
            File newFile = new File(path_sliderExist);
            OutputStream out = new FileOutputStream(newFile);
            out.write(buffer);
            out.close();
            is.close();

            // CARGA IMAGEN
            Url_img_sliderExist = Server.URL_IMAGES + event.getFileName();
            txtSEUpload.setValue(Url_img_sliderExist);
            imgSE.setSrc(Url_img_sliderExist);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // -----------------------------------------------------------------------------------------------
    @Override
    public void on_Grabar_SliderExist() {
        Sliders sliderE = new Sliders();
        sliderE = l_slidersE.get(iterator_slidersE);
        String url_img = sliderE.getUrl_imagen();
        // sliderE = Services.getIndexWeb().get_Sliderby_UrlImg(url_img);
        // --------------------------------------------------------------------------
        if (!txtSEUpload.isEmpty()) {
            System.out.println("Url Imagen Slider Existente: " + Url_img_sliderExist);
            System.out.println("Url Imagen Slider Existente: " + txtSEUpload.getValue());
            sliderE.setUrl_imagen(txtSEUpload.getValue());
        }
        // --------------------------------------------------------------------------
        if (!txtSELink.isEmpty()) {
            System.out.println("Url Link Slider Existente: " + txtSELink.getValue());
            sliderE.setUrl_link(txtSELink.getValue());
        }
        // --------------------------------------------------------------------------
        System.out.println("Slider Existente Activo?: " + checkSE_Activate.getValue());
        sliderE.setActivo(checkSE_Activate.getValue());
        // --------------------------------------------------------------------------
        Services.getIndexWeb().update_Slider(sliderE);
        notify_update.open();
        init_Sliders();
    }

    // -----------------------------------------------------------------------------------------------
    @Override
    public void on_Descartar_SliderExist() {
        Sliders sliderE = new Sliders();
        sliderE = l_slidersE.get(iterator_slidersE);
        Services.getIndexWeb().delete_Slider(sliderE);
        init_Sliders();
        notify_discard.open();
    }

    // -----------------------------------------------------------------------------------------------
    @Override
    public void on_Anterior_SliderExist() {
        // Variables
        l_slidersE = Services.getIndexWeb().get_AllSliders();
        l_slidersAux = l_slidersE;
        String url_img_Slider = "";
        String url_link_Slider = "";
        Boolean activado = Boolean.FALSE;
        Sliders sliderE = new Sliders();
        Integer list_size = 0;
        list_size = l_slidersE.size();
        System.out.println("Size List_Sliders : " + list_size);
        // ----------------------------------------------------------------------
        // Get Anterior
        iterator_slidersE = iterator_slidersE - 1;
        System.out.println("Iterator : " + iterator_slidersE);
        if (iterator_slidersE >= 0 && iterator_slidersE < list_size) {
            sliderE = l_slidersE.get(iterator_slidersE);
            System.out.println("Id Slider : " + sliderE.getId());
            // ------------------------------------------------------------------
            if (sliderE.getUrl_imagen() == null) {
                url_img_Slider = "";
            } else {
                url_img_Slider = sliderE.getUrl_imagen();
            }
            // ------------------------------------------------------------------
            if (sliderE.getUrl_link() == null) {
                url_link_Slider = "";
            } else {
                url_link_Slider = sliderE.getUrl_link();
            }
            // ------------------------------------------------------------------
            activado = sliderE.getActivo();
            // ------------------------------------------------------------------
            imgSE.setSrc(url_img_Slider);
            txtSEUpload.setValue(url_img_Slider);
            txtSELink.setValue(url_link_Slider);
            checkSE_Activate.setValue(activado);
        }
        // ----------------------------------------------------------------------
        if (iterator_slidersE < 0) {
            iterator_slidersE = list_size - 1;
            sliderE = l_slidersE.get(iterator_slidersE);
            System.out.println("Id Slider : " + sliderE.getId());
            // ------------------------------------------------------------------
            if (sliderE.getUrl_imagen() == null) {
                url_img_Slider = "";
            } else {
                url_img_Slider = sliderE.getUrl_imagen();
            }
            // ------------------------------------------------------------------
            if (sliderE.getUrl_link() == null) {
                url_link_Slider = "";
            } else {
                url_link_Slider = sliderE.getUrl_link();
            }
            // ------------------------------------------------------------------
            activado = sliderE.getActivo();
            // ------------------------------------------------------------------
            imgSE.setSrc(url_img_Slider);
            txtSEUpload.setValue(url_img_Slider);
            txtSELink.setValue(url_link_Slider);
            checkSE_Activate.setValue(activado);
        }
        // ----------------------------------------------------------------------
    }

    // -----------------------------------------------------------------------------------------------
    @Override
    public void on_Siguiente_SliderExist() {
        // Variables
        l_slidersE = Services.getIndexWeb().get_AllSliders();
        l_slidersAux = l_slidersE;
        String url_img_Slider = "";
        String url_link_Slider = "";
        Boolean activado = Boolean.FALSE;
        Sliders sliderE = new Sliders();
        Integer list_size = 0;
        list_size = l_slidersE.size();
        System.out.println("Size List_Sliders : " + list_size);
        // ----------------------------------------------------------------------
        // Get Siguiente
        iterator_slidersE = iterator_slidersE + 1;
        if (iterator_slidersE < list_size) {
            sliderE = l_slidersE.get(iterator_slidersE);
            System.out.println("Id Slider : " + sliderE.getId());
            // ------------------------------------------------------------------
            if (sliderE.getUrl_imagen() == null) {
                url_img_Slider = "";
            } else {
                url_img_Slider = sliderE.getUrl_imagen();
            }
            // ------------------------------------------------------------------
            if (sliderE.getUrl_link() == null) {
                url_link_Slider = "";
            } else {
                url_link_Slider = sliderE.getUrl_link();
            }
            // ------------------------------------------------------------------
            activado = sliderE.getActivo();
            // ------------------------------------------------------------------
            // ------------------------------------------------------------------
            imgSE.setSrc(url_img_Slider);
            txtSEUpload.setValue(url_img_Slider);
            txtSELink.setValue(url_link_Slider);
            checkSE_Activate.setValue(activado);
        }
        // ----------------------------------------------------------------------
        if (iterator_slidersE >= list_size) {
            iterator_slidersE = 0;
            sliderE = l_slidersE.get(iterator_slidersE);
            System.out.println("Id Slider : " + sliderE.getId());
            // ------------------------------------------------------------------
            if (sliderE.getUrl_imagen() == null) {
                url_img_Slider = "";
            } else {
                url_img_Slider = sliderE.getUrl_imagen();
            }
            // ------------------------------------------------------------------
            if (sliderE.getUrl_link() == null) {
                url_link_Slider = "";
            } else {
                url_link_Slider = sliderE.getUrl_link();
            }
            // ------------------------------------------------------------------
            activado = sliderE.getActivo();
            // ------------------------------------------------------------------
            imgSE.setSrc(url_img_Slider);
            txtSEUpload.setValue(url_img_Slider);
            txtSELink.setValue(url_link_Slider);
            checkSE_Activate.setValue(activado);
        }
        // ----------------------------------------------------------------------
    }
    // -----------------------------------------------------------------------------------------------

    // -----------------------------------------------------------------------------------------------
    // DIALOG BANNER - LINEA ECOMMERCE
    // -----------------------------------------------------------------------------------------------
    // NUEVO BANNER
    // UPLOAD LINEA ECOMMERCE
    @Override
    public void on_UploadLinea_Ecom(SucceededEvent event) {
        // onUpload(bufferLinea1,path_linea1,event.getFileName(),imgL1,Url_img_linea1,txtLUpload1);
        path_linea = "";
        try {

            // LECTURA
            InputStream is = bufferLinea.getInputStream();
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            path_linea = Server.PATH_IMAGES + event.getFileName();
            System.out.println("Upload Nuevo banner: Path Imagen: " + path_linea);
            // ESCRITURA
            File newFile = new File(path_linea);
            OutputStream out = new FileOutputStream(newFile);
            out.write(buffer);
            out.close();
            is.close();

            // CARGA IMAGEN
            Url_img_linea = Server.URL_IMAGES + event.getFileName();
            txtdialog_Upload.setValue(Url_img_linea);
            dialog_img.setSrc(Url_img_linea);
            System.out.println("Upload Nuevo Banner: Url Imagen: " + Url_img_linea);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    // -----------------------------------------------------------------------------------------------------------

    // OPEN DIALOG

    @Override
    public void init_Banners() {
        // BANNER ACTIVO 1

        Integer posicion;
        posicion = 1;
        String pos = String.valueOf(posicion);
        Banners banner = new Banners();
        banner = Services.getIndexWeb().get_Banner_Act(pos);
        LineaEcommerce l_ecom = new LineaEcommerce();
        if (banner == null) {
            banner = new Banners();
            l_ecom = new LineaEcommerce();
            txtLEcom_Linea1.setValue("No Definida");
            txtTituloLinea1.setValue("");
            txtSubtituloLinea1.setValue("");
            txtPos_Linea1.setValue("");
            imgL1.setSrc("");
        } else {
            l_ecom = new LineaEcommerce();
            l_ecom = banner.getLinea_ecom();

            if (l_ecom == null) {
                txtLEcom_Linea1.setValue("No Definida");
            } else {
                txtLEcom_Linea1.setValue(l_ecom.getNombre());
            }

            if (banner.getTitulo() == null) {
                txtTituloLinea1.setValue("");
            } else {
                txtTituloLinea1.setValue(banner.getTitulo());
            }

            if (banner.getSubtitulo() == null) {
                txtSubtituloLinea1.setValue("");
            } else {
                txtSubtituloLinea1.setValue(banner.getSubtitulo());
            }

            txtPos_Linea1.setValue(pos);

            if (banner.getUrl_image() == null) {
                imgL1.setSrc("");
            } else {
                imgL1.setSrc(banner.getUrl_image());
            }

        }
        // ----------------------------------------------------------------------

        // BANNER ACTIVO 2

        posicion = 2;
        pos = String.valueOf(posicion);
        banner = new Banners();
        banner = Services.getIndexWeb().get_Banner_Act(pos);
        l_ecom = new LineaEcommerce();
        if (banner == null) {
            banner = new Banners();
            l_ecom = new LineaEcommerce();
            txtLEcom_Linea2.setValue("No Definida");
            txtTituloLinea2.setValue("");
            txtSubtituloLinea2.setValue("");
            txtPos_Linea2.setValue("");
            imgL2.setSrc("");
        } else {
            l_ecom = new LineaEcommerce();
            l_ecom = banner.getLinea_ecom();

            if (l_ecom == null) {
                txtLEcom_Linea2.setValue("No Definida");
            } else {
                txtLEcom_Linea2.setValue(l_ecom.getNombre());
            }

            if (banner.getTitulo() == null) {
                txtTituloLinea2.setValue("");
            } else {
                txtTituloLinea2.setValue(banner.getTitulo());
            }

            if (banner.getSubtitulo() == null) {
                txtSubtituloLinea2.setValue("");
            } else {
                txtSubtituloLinea2.setValue(banner.getSubtitulo());
            }

            txtPos_Linea2.setValue(pos);

            if (banner.getUrl_image() == null) {
                imgL2.setSrc("");
            } else {
                imgL2.setSrc(banner.getUrl_image());
            }

        }
        // ----------------------------------------------------------------------

        // BANNER ACTIVO 3

        posicion = 3;
        pos = String.valueOf(posicion);
        banner = new Banners();
        banner = Services.getIndexWeb().get_Banner_Act(pos);
        l_ecom = new LineaEcommerce();
        if (banner == null) {
            banner = new Banners();
            l_ecom = new LineaEcommerce();
            txtLEcom_Linea3.setValue("No Definida");
            txtTituloLinea3.setValue("");
            txtSubtituloLinea3.setValue("");
            txtPos_Linea3.setValue("");
            imgL3.setSrc("");
        } else {
            l_ecom = new LineaEcommerce();
            l_ecom = banner.getLinea_ecom();

            if (l_ecom == null) {
                txtLEcom_Linea3.setValue("No Definida");
            } else {
                txtLEcom_Linea3.setValue(l_ecom.getNombre());
            }

            if (banner.getTitulo() == null) {
                txtTituloLinea3.setValue("");
            } else {
                txtTituloLinea3.setValue(banner.getTitulo());
            }

            if (banner.getSubtitulo() == null) {
                txtSubtituloLinea3.setValue("");
            } else {
                txtSubtituloLinea3.setValue(banner.getSubtitulo());
            }

            txtPos_Linea3.setValue(pos);

            if (banner.getUrl_image() == null) {
                imgL3.setSrc("");
            } else {
                imgL3.setSrc(banner.getUrl_image());
            }

        }
        // ----------------------------------------------------------------------

        // BANNER ACTIVO 4

        posicion = 4;
        pos = String.valueOf(posicion);
        banner = new Banners();
        banner = Services.getIndexWeb().get_Banner_Act(pos);
        l_ecom = new LineaEcommerce();
        if (banner == null) {
            banner = new Banners();
            l_ecom = new LineaEcommerce();
            txtLEcom_Linea4.setValue("No Definida");
            txtTituloLinea4.setValue("");
            txtSubtituloLinea4.setValue("");
            txtPos_Linea4.setValue("");
            imgL4.setSrc("");
        } else {
            l_ecom = new LineaEcommerce();
            l_ecom = banner.getLinea_ecom();

            if (l_ecom == null) {
                txtLEcom_Linea4.setValue("No Definida");
            } else {
                txtLEcom_Linea4.setValue(l_ecom.getNombre());
            }

            if (banner.getTitulo() == null) {
                txtTituloLinea4.setValue("");
            } else {
                txtTituloLinea4.setValue(banner.getTitulo());
            }

            if (banner.getSubtitulo() == null) {
                txtSubtituloLinea4.setValue("");
            } else {
                txtSubtituloLinea4.setValue(banner.getSubtitulo());
            }

            txtPos_Linea4.setValue(pos);

            if (banner.getUrl_image() == null) {
                imgL4.setSrc("");
            } else {
                imgL4.setSrc(banner.getUrl_image());
            }

        }
        // ----------------------------------------------------------------------

        // BANNER ACTIVO 5

        posicion = 5;
        pos = String.valueOf(posicion);
        banner = new Banners();
        banner = Services.getIndexWeb().get_Banner_Act(pos);
        l_ecom = new LineaEcommerce();
        if (banner == null) {
            banner = new Banners();
            l_ecom = new LineaEcommerce();
            txtLEcom_Linea5.setValue("No Definida");
            txtTituloLinea5.setValue("");
            txtSubtituloLinea5.setValue("");
            txtPos_Linea5.setValue("");
            imgL5.setSrc("");
        } else {
            l_ecom = new LineaEcommerce();
            l_ecom = banner.getLinea_ecom();

            if (l_ecom == null) {
                txtLEcom_Linea5.setValue("No Definida");
            } else {
                txtLEcom_Linea5.setValue(l_ecom.getNombre());
            }

            if (banner.getTitulo() == null) {
                txtTituloLinea5.setValue("");
            } else {
                txtTituloLinea5.setValue(banner.getTitulo());
            }

            if (banner.getSubtitulo() == null) {
                txtSubtituloLinea5.setValue("");
            } else {
                txtSubtituloLinea5.setValue(banner.getSubtitulo());
            }

            txtPos_Linea5.setValue(pos);

            if (banner.getUrl_image() == null) {
                imgL5.setSrc("");
            } else {
                imgL5.setSrc(banner.getUrl_image());
            }
        }
        // ----------------------------------------------------------------------

        // BANNER ACTIVO 6

        posicion = 6;
        pos = String.valueOf(posicion);
        banner = new Banners();
        banner = Services.getIndexWeb().get_Banner_Act(pos);
        l_ecom = new LineaEcommerce();
        if (banner == null) {
            banner = new Banners();
            l_ecom = new LineaEcommerce();
            txtLEcom_Linea6.setValue("No Definida");
            txtTituloLinea6.setValue("");
            txtSubtituloLinea6.setValue("");
            txtPos_Linea6.setValue("");
            imgL6.setSrc("");
        } else {
            l_ecom = new LineaEcommerce();
            l_ecom = banner.getLinea_ecom();

            if (l_ecom == null) {
                txtLEcom_Linea6.setValue("No Definida");
            } else {
                txtLEcom_Linea6.setValue(l_ecom.getNombre());
            }

            if (banner.getTitulo() == null) {
                txtTituloLinea6.setValue("");
            } else {
                txtTituloLinea6.setValue(banner.getTitulo());
            }

            if (banner.getSubtitulo() == null) {
                txtSubtituloLinea6.setValue("");
            } else {
                txtSubtituloLinea6.setValue(banner.getSubtitulo());
            }

            txtPos_Linea6.setValue(pos);

            if (banner.getUrl_image() == null) {
                imgL6.setSrc("");
            } else {
                imgL6.setSrc(banner.getUrl_image());
            }
        }
        // ----------------------------------------------------------------------
    }

    public List<String> get_AllLineaEcommerce() {
        List<LineaEcommerce> list_Linea_ecom = new ArrayList<>();
        List<String> list_linea = new ArrayList<>();
        list_Linea_ecom = Services.getProducto().listLineaEcom();
        for (int i = 0; i < list_Linea_ecom.size(); i++) {
            list_linea.add(list_Linea_ecom.get(i).getNombre());
        }
        // cmbLineaEcom.setItems(list_linea);
        return list_linea;
    }

    @Override
    public void On_Open_dialog_Banner1() {
        // NUEVO BANNER
        txtdialog_TLEcom.setValue("");
        txtdialog_SubtLEcom.setValue("");

        String pos = String.valueOf(1);
        posicion = 1;
        txtdialog2_TitPos.setValue(pos);
        txtdialog_PosLEcom.setValue(pos);

        List<String> list_linea = new ArrayList<>();
        list_linea = get_AllLineaEcommerce();
        cmbdialog_LEcom.setItems(list_linea);

        txtdialog_Upload.setValue("");
        txtdialog_Upload.setReadOnly(true);
        dialog_CheckActivation.setValue(Boolean.FALSE);

        // BANNER ACTIVO
        L_Banners = new ArrayList<>();
        L_Banners = Services.getIndexWeb().get_ListBanners_byPos(pos);
        Banners banner = new Banners();
        LineaEcommerce l_ecom = new LineaEcommerce();
        cmbdialog2_LEcom.setItems(list_linea);
        if (!L_Banners.isEmpty()) {
            banner = L_Banners.get(0);
            iterator_L_Banners = 0;
            l_ecom = new LineaEcommerce();
            l_ecom = banner.getLinea_ecom();

            id_banner = String.valueOf(banner.getId());
            txtdialog2_LEcom.setValue(l_ecom.getNombre());
            txtdialog2_TLEcom.setValue(banner.getTitulo());
            txtdialog2_SubtLEcom.setValue(banner.getSubtitulo());
            txtdialog2_PosLEcom.setValue(pos);
            dialog2_img.setSrc(banner.getUrl_image());
            dialog2_CheckActivation.setValue(banner.getActivo());
        }
    }

    @Override
    public void On_Open_dialog_Banner2() {
        // NUEVO BANNER
        txtdialog_TLEcom.setValue("");
        txtdialog_SubtLEcom.setValue("");

        String pos = String.valueOf(2);
        posicion = 2;
        txtdialog2_TitPos.setValue(pos);
        txtdialog_PosLEcom.setValue(pos);

        List<String> list_linea = new ArrayList<>();
        list_linea = get_AllLineaEcommerce();
        cmbdialog_LEcom.setItems(list_linea);

        txtdialog_Upload.setValue("");
        txtdialog_Upload.setReadOnly(true);
        dialog_CheckActivation.setValue(Boolean.FALSE);

        // BANNER ACTIVO
        L_Banners = new ArrayList<>();
        L_Banners = Services.getIndexWeb().get_ListBanners_byPos(pos);
        Banners banner = new Banners();
        LineaEcommerce l_ecom = new LineaEcommerce();
        cmbdialog2_LEcom.setItems(list_linea);
        if (!L_Banners.isEmpty()) {
            banner = L_Banners.get(0);
            iterator_L_Banners = 0;
            l_ecom = new LineaEcommerce();
            l_ecom = banner.getLinea_ecom();

            id_banner = String.valueOf(banner.getId());
            txtdialog2_LEcom.setValue(l_ecom.getNombre());
            txtdialog2_TLEcom.setValue(banner.getTitulo());
            txtdialog2_SubtLEcom.setValue(banner.getSubtitulo());
            txtdialog2_PosLEcom.setValue(pos);
            dialog2_img.setSrc(banner.getUrl_image());
            dialog2_CheckActivation.setValue(banner.getActivo());
        }
    }

    @Override
    public void On_Open_dialog_Banner3() {
        // NUEVO BANNER
        txtdialog_TLEcom.setValue("");
        txtdialog_SubtLEcom.setValue("");

        String pos = String.valueOf(3);
        posicion = 3;
        txtdialog2_TitPos.setValue(pos);
        txtdialog_PosLEcom.setValue(pos);

        List<String> list_linea = new ArrayList<>();
        list_linea = get_AllLineaEcommerce();
        cmbdialog_LEcom.setItems(list_linea);

        txtdialog_Upload.setValue("");
        txtdialog_Upload.setReadOnly(true);
        dialog_CheckActivation.setValue(Boolean.FALSE);

        // BANNER ACTIVO
        L_Banners = new ArrayList<>();
        L_Banners = Services.getIndexWeb().get_ListBanners_byPos(pos);
        Banners banner = new Banners();
        LineaEcommerce l_ecom = new LineaEcommerce();
        cmbdialog2_LEcom.setItems(list_linea);
        if (!L_Banners.isEmpty()) {
            banner = L_Banners.get(0);
            iterator_L_Banners = 0;
            l_ecom = new LineaEcommerce();
            l_ecom = banner.getLinea_ecom();

            id_banner = String.valueOf(banner.getId());
            txtdialog2_LEcom.setValue(l_ecom.getNombre());
            txtdialog2_TLEcom.setValue(banner.getTitulo());
            txtdialog2_SubtLEcom.setValue(banner.getSubtitulo());
            txtdialog2_PosLEcom.setValue(pos);
            dialog2_img.setSrc(banner.getUrl_image());
            dialog2_CheckActivation.setValue(banner.getActivo());
        }
    }

    @Override
    public void On_Open_dialog_Banner4() {
        // NUEVO BANNER
        txtdialog_TLEcom.setValue("");
        txtdialog_SubtLEcom.setValue("");

        String pos = String.valueOf(4);
        posicion = 4;
        txtdialog2_TitPos.setValue(pos);
        txtdialog_PosLEcom.setValue(pos);

        List<String> list_linea = new ArrayList<>();
        list_linea = get_AllLineaEcommerce();
        cmbdialog_LEcom.setItems(list_linea);

        txtdialog_Upload.setValue("");
        txtdialog_Upload.setReadOnly(true);
        dialog_CheckActivation.setValue(Boolean.FALSE);

        // BANNER ACTIVO
        L_Banners = new ArrayList<>();
        L_Banners = Services.getIndexWeb().get_ListBanners_byPos(pos);
        Banners banner = new Banners();
        LineaEcommerce l_ecom = new LineaEcommerce();
        cmbdialog2_LEcom.setItems(list_linea);
        if (!L_Banners.isEmpty()) {
            banner = L_Banners.get(0);
            iterator_L_Banners = 0;
            l_ecom = new LineaEcommerce();
            l_ecom = banner.getLinea_ecom();

            id_banner = String.valueOf(banner.getId());
            txtdialog2_LEcom.setValue(l_ecom.getNombre());
            txtdialog2_TLEcom.setValue(banner.getTitulo());
            txtdialog2_SubtLEcom.setValue(banner.getSubtitulo());
            txtdialog2_PosLEcom.setValue(pos);
            dialog2_img.setSrc(banner.getUrl_image());
            dialog2_CheckActivation.setValue(banner.getActivo());
        }
    }

    @Override
    public void On_Open_dialog_Banner5() {
        // NUEVO BANNER
        txtdialog_TLEcom.setValue("");
        txtdialog_SubtLEcom.setValue("");

        String pos = String.valueOf(5);
        posicion = 5;
        txtdialog2_TitPos.setValue(pos);
        txtdialog_PosLEcom.setValue(pos);

        List<String> list_linea = new ArrayList<>();
        list_linea = get_AllLineaEcommerce();
        cmbdialog_LEcom.setItems(list_linea);

        txtdialog_Upload.setValue("");
        txtdialog_Upload.setReadOnly(true);
        dialog_CheckActivation.setValue(Boolean.FALSE);

        // BANNER ACTIVO
        L_Banners = new ArrayList<>();
        L_Banners = Services.getIndexWeb().get_ListBanners_byPos(pos);
        Banners banner = new Banners();
        LineaEcommerce l_ecom = new LineaEcommerce();
        cmbdialog2_LEcom.setItems(list_linea);
        if (!L_Banners.isEmpty()) {
            banner = L_Banners.get(0);
            iterator_L_Banners = 0;
            l_ecom = new LineaEcommerce();
            l_ecom = banner.getLinea_ecom();

            id_banner = String.valueOf(banner.getId());
            txtdialog2_LEcom.setValue(l_ecom.getNombre());
            txtdialog2_TLEcom.setValue(banner.getTitulo());
            txtdialog2_SubtLEcom.setValue(banner.getSubtitulo());
            txtdialog2_PosLEcom.setValue(pos);
            dialog2_img.setSrc(banner.getUrl_image());
            dialog2_CheckActivation.setValue(banner.getActivo());
        }
    }

    @Override
    public void On_Open_dialog_Banner6() {
        // NUEVO BANNER
        txtdialog_TLEcom.setValue("");
        txtdialog_SubtLEcom.setValue("");

        String pos = String.valueOf(6);
        posicion = 6;
        txtdialog2_TitPos.setValue(pos);
        txtdialog_PosLEcom.setValue(pos);

        List<String> list_linea = new ArrayList<>();
        list_linea = get_AllLineaEcommerce();
        cmbdialog_LEcom.setItems(list_linea);

        txtdialog_Upload.setValue("");
        txtdialog_Upload.setReadOnly(true);
        dialog_CheckActivation.setValue(Boolean.FALSE);

        // BANNER ACTIVO
        L_Banners = new ArrayList<>();
        L_Banners = Services.getIndexWeb().get_ListBanners_byPos(pos);
        Banners banner = new Banners();
        LineaEcommerce l_ecom = new LineaEcommerce();
        cmbdialog2_LEcom.setItems(list_linea);
        if (!L_Banners.isEmpty()) {
            banner = L_Banners.get(0);
            iterator_L_Banners = 0;
            l_ecom = new LineaEcommerce();
            l_ecom = banner.getLinea_ecom();

            id_banner = String.valueOf(banner.getId());
            txtdialog2_LEcom.setValue(l_ecom.getNombre());
            txtdialog2_TLEcom.setValue(banner.getTitulo());
            txtdialog2_SubtLEcom.setValue(banner.getSubtitulo());
            txtdialog2_PosLEcom.setValue(pos);
            dialog2_img.setSrc(banner.getUrl_image());
            dialog2_CheckActivation.setValue(banner.getActivo());
        }
    }
    // -----------------------------------------------------------------------------------------------------------

    // OBTIENE LISTA DE LINEA ECOMMERCE ACTIVAS
    public List<LineaEcommerce> solo_LEcom_Act() {
        L_Linea_ecom = new ArrayList<>();
        L_Banners = new ArrayList<>();
        // Obteniendo los Banners activados
        L_Banners = Services.getIndexWeb().get_Banners_Act();

        LineaEcommerce linea_Ecom_Act = new LineaEcommerce();
        for (int i = 0; i < L_Banners.size(); i++) {
            linea_Ecom_Act = L_Banners.get(i).getLinea_ecom();
            if (linea_Ecom_Act == null) {
                linea_Ecom_Act = new LineaEcommerce();
            }
            L_Linea_ecom.add(linea_Ecom_Act);
        }
        return L_Linea_ecom;
    }

    public Boolean is_Banner_Act(String posicion) {
        Boolean resp = Boolean.FALSE;
        Banners banner = new Banners();
        banner = Services.getIndexWeb().get_Banner_Act(posicion);
        if (banner != null) {
            resp = Boolean.TRUE;
        }
        return resp;
    }

    public Boolean is_Any_Banner_Act(String posicion) {
        Boolean resp = Boolean.FALSE;
        // Banners banner = new Banners();
        // banner = Services.getIndexWeb().get_Banner_Act(posicion);
        resp = Services.getIndexWeb().is_Banner_Act(posicion);
        return resp;
    }

    // CHECK ACTIVATION
    /*
     * @Override public void On_Click_CheckActivation(){ Boolean activado =
     * Boolean.FALSE; String posicion_Banner = ""; posicion_Banner =
     * String.valueOf(posicion); activado = is_Banner_Act(posicion_Banner);
     * if(activado == Boolean.TRUE){ System.out.println("El banner está activo?: " +
     * activado); dialog_CheckActivation.setValue(Boolean.FALSE);
     * notify_is_Activated.open(); } if(activado == Boolean.FALSE){
     * System.out.println("El banner está activo?: " + activado);
     * dialog_CheckActivation.setValue(Boolean.TRUE);
     * notify_is_PosibleActivated.open(); } }
     */

    // GUARDAR CAMBIOS
    @Override
    public void On_Click_GuardarCambios() {
        Banners n_banner = new Banners();
        LineaEcommerce l_ecom = new LineaEcommerce();
        String linea_Ecom = "";
        String titulo_Banner = "";
        String subtitulo_Banner = "";
        String posicion_Banner = "";
        String url_img_Banner = "";
        Boolean activo = Boolean.FALSE;
        Boolean b_activo = Boolean.FALSE;
        // -----------------------------------------------------------------------------------------------
        posicion_Banner = String.valueOf(posicion);
        b_activo = Services.getIndexWeb().is_Banner_Act(posicion_Banner);
        // b_activo = is_Any_Banner_Act(posicion_Banner);
        // -----------------------------------------------------------------------------------------------
        if (!txtdialog_TLEcom.isEmpty()) {
            titulo_Banner = txtdialog_TLEcom.getValue();
        }

        if (!txtdialog_SubtLEcom.isEmpty()) {
            subtitulo_Banner = txtdialog_SubtLEcom.getValue();
        }

        posicion_Banner = txtdialog_PosLEcom.getValue();

        if (!txtdialog_Upload.isEmpty()) {
            url_img_Banner = Url_img_linea;
        }

        linea_Ecom = txtdialog_LEcom.getValue();
        l_ecom = Services.getProducto().get_ByLineaEcom_nombre(linea_Ecom);
        System.out.println("Banner Nuevo - Linea Ecommerce es:" + l_ecom.getNombre());
        activo = dialog_CheckActivation.getValue();
        // -----------------------------------------------------------------------------------------------
        // Ya hay un Banner activo
        if (b_activo == Boolean.TRUE) {
            if (activo == Boolean.TRUE) {
                notify_is_Activated.open();
            }
            // -------------------------------------------------------------------------------------------
            if (activo == Boolean.FALSE) {
                n_banner = new Banners();

                // Inicializando New Banner
                posicion_Banner = String.valueOf(posicion);
                // n_banner = Services.getIndexWeb().get_Banner_Act(posicion_Banner);
                n_banner.setTitulo(titulo_Banner);
                n_banner.setSubtitulo(subtitulo_Banner);
                n_banner.setPosicion(posicion);
                n_banner.setUrl_image(url_img_Banner);
                n_banner.setLinea_ecom(l_ecom);
                n_banner.setActivo(activo);

                // Guardando New Bannner
                Services.getIndexWeb().save_Banner(n_banner);

                notify_is_Guardado_Correct.open();
                select_Refresh_dialog();
            }
            // -----------------------------------------------------------------------------------------------
        }

        // No hay ningun Banner activo
        if (b_activo == Boolean.FALSE) {
            n_banner = new Banners();

            // Inicializando New Banner
            posicion_Banner = String.valueOf(posicion);
            // n_banner = Services.getIndexWeb().get_Banner_Act(posicion_Banner);
            n_banner.setTitulo(titulo_Banner);
            n_banner.setSubtitulo(subtitulo_Banner);
            n_banner.setPosicion(posicion);
            n_banner.setUrl_image(url_img_Banner);
            n_banner.setLinea_ecom(l_ecom);
            n_banner.setActivo(activo);

            // Guardando New Bannner
            Services.getIndexWeb().save_Banner(n_banner);

            notify_is_Guardado_Correct.open();
            select_Refresh_dialog();
        }
    }
    // -----------------------------------------------------------------------------------------------------------

    // LINEAS ECOMMERCE ACTIVADAS

    @Override
    public void On_Click_BannerAnterior() {
        // Variables
        String linea_Ecom = "";
        String titulo_Banner = "";
        String subtitulo_Banner = "";
        String posicion_Banner = "";
        String url_img_Banner = "";
        Boolean activado = Boolean.FALSE;
        LineaEcommerce l_ecom = new LineaEcommerce();
        Banners ban = new Banners();

        // Get Anterior
        iterator_L_Banners = iterator_L_Banners - 1;
        if (iterator_L_Banners >= 0 && iterator_L_Banners < L_Banners.size()) {
            ban = L_Banners.get(iterator_L_Banners);
            id_banner = String.valueOf(ban.getId());
            titulo_Banner = ban.getTitulo();
            subtitulo_Banner = ban.getSubtitulo();
            l_ecom = ban.getLinea_ecom();
            linea_Ecom = l_ecom.getNombre();
            posicion_Banner = String.valueOf(ban.getPosicion());
            url_img_Banner = ban.getUrl_image();
            activado = ban.getActivo();

            txtdialog2_TLEcom.setValue(titulo_Banner);
            txtdialog2_SubtLEcom.setValue(subtitulo_Banner);
            txtdialog2_LEcom.setValue(linea_Ecom);
            txtdialog2_PosLEcom.setValue(posicion_Banner);
            dialog2_img.setSrc(url_img_Banner);
            dialog2_CheckActivation.setValue(activado);
        }
        if (iterator_L_Banners < 0) {
            iterator_L_Banners = L_Banners.size() - 1;
            ban = L_Banners.get(iterator_L_Banners);
            id_banner = String.valueOf(ban.getId());
            titulo_Banner = ban.getTitulo();
            subtitulo_Banner = ban.getSubtitulo();
            l_ecom = ban.getLinea_ecom();
            linea_Ecom = l_ecom.getNombre();
            posicion_Banner = String.valueOf(ban.getPosicion());
            url_img_Banner = ban.getUrl_image();
            activado = ban.getActivo();

            txtdialog2_TLEcom.setValue(titulo_Banner);
            txtdialog2_SubtLEcom.setValue(subtitulo_Banner);
            txtdialog2_LEcom.setValue(linea_Ecom);
            txtdialog2_PosLEcom.setValue(posicion_Banner);
            dialog2_img.setSrc(url_img_Banner);
            dialog2_CheckActivation.setValue(activado);
        }
    }

    @Override
    public void On_Click_BannerSiguiente() {
        // Variables
        String linea_Ecom = "";
        String titulo_Banner = "";
        String subtitulo_Banner = "";
        String posicion_Banner = "";
        String url_img_Banner = "";
        Boolean activado = Boolean.FALSE;
        LineaEcommerce l_ecom = new LineaEcommerce();
        Banners ban = new Banners();

        // Get Siguiente
        iterator_L_Banners = iterator_L_Banners + 1;
        if (iterator_L_Banners < L_Banners.size()) {
            ban = L_Banners.get(iterator_L_Banners);
            id_banner = String.valueOf(ban.getId());
            titulo_Banner = ban.getTitulo();
            subtitulo_Banner = ban.getSubtitulo();
            l_ecom = ban.getLinea_ecom();
            linea_Ecom = l_ecom.getNombre();
            posicion_Banner = String.valueOf(ban.getPosicion());
            url_img_Banner = ban.getUrl_image();
            activado = ban.getActivo();

            txtdialog2_TLEcom.setValue(titulo_Banner);
            txtdialog2_SubtLEcom.setValue(subtitulo_Banner);
            txtdialog2_PosLEcom.setValue(posicion_Banner);
            txtdialog2_LEcom.setValue(linea_Ecom);
            dialog2_img.setSrc(url_img_Banner);
            dialog2_CheckActivation.setValue(activado);
        }
        if (iterator_L_Banners >= L_Banners.size()) {
            iterator_L_Banners = 0;
            ban = L_Banners.get(iterator_L_Banners);
            id_banner = String.valueOf(ban.getId());
            titulo_Banner = ban.getTitulo();
            subtitulo_Banner = ban.getSubtitulo();
            l_ecom = ban.getLinea_ecom();
            linea_Ecom = l_ecom.getNombre();
            posicion_Banner = String.valueOf(ban.getPosicion());
            url_img_Banner = ban.getUrl_image();
            activado = ban.getActivo();

            txtdialog2_TLEcom.setValue(titulo_Banner);
            txtdialog2_SubtLEcom.setValue(subtitulo_Banner);
            txtdialog2_LEcom.setValue(linea_Ecom);
            txtdialog2_PosLEcom.setValue(posicion_Banner);
            dialog2_img.setSrc(url_img_Banner);
            dialog2_CheckActivation.setValue(activado);
        }
    }

    public void select_Refresh_dialog() {
        switch (posicion) {
            case 1:
                On_Open_dialog_Banner1();
                break;
            case 2:
                On_Open_dialog_Banner2();
                break;
            case 3:
                On_Open_dialog_Banner3();
                break;
            case 4:
                On_Open_dialog_Banner4();
                break;
            case 5:
                On_Open_dialog_Banner5();
                break;
            case 6:
                On_Open_dialog_Banner6();
                break;
        }
    }

    @Override
    public void On_Click_Confirmar_CheckAct() {
        Boolean activado = Boolean.FALSE;
        Boolean banner_activo = Boolean.FALSE;
        String titulo_Banner = "";
        String subtitulo_Banner = "";
        String posicion_Banner = "";
        String LE_Banner = "";
        Banners banner = new Banners();
        LineaEcommerce l_ecom = new LineaEcommerce();

        if (!txtdialog2_TLEcom.isEmpty()) {
            titulo_Banner = txtdialog2_TLEcom.getValue();
        }

        if (!txtdialog2_SubtLEcom.isEmpty()) {
            subtitulo_Banner = txtdialog2_SubtLEcom.getValue();
        }

        posicion_Banner = String.valueOf(posicion);
        activado = dialog2_CheckActivation.getValue();
        banner_activo = is_Any_Banner_Act(posicion_Banner);

        banner = L_Banners.get(iterator_L_Banners);
        l_ecom = L_Banners.get(iterator_L_Banners).getLinea_ecom();
        System.out.println("Banner Activo - Linea Ecommerce es:" + l_ecom.getNombre());
        LE_Banner = txtdialog2_LEcom.getValue();
        l_ecom = Services.getProducto().get_ByLineaEcom_nombre(LE_Banner);
        System.out.println("Banner Activo - Linea Ecommerce es:" + l_ecom.getNombre());
        // l_ecom.setNombre(LE_Banner);
        // banner = Services.getIndexWeb().get_Banner_byId(id_banner);
        if (banner_activo == Boolean.FALSE) {
            banner.setTitulo(titulo_Banner);
            banner.setSubtitulo(subtitulo_Banner);
            banner.setActivo(activado);
            banner.setLinea_ecom(l_ecom);
            Services.getIndexWeb().update_Banner(banner);
            notify_is_Guardado_Correct.open();
            select_Refresh_dialog();
        }
        if (banner_activo == Boolean.TRUE) {
            if (activado == Boolean.FALSE) {
                banner.setTitulo(titulo_Banner);
                banner.setSubtitulo(subtitulo_Banner);
                banner.setActivo(activado);
                banner.setLinea_ecom(l_ecom);
                Services.getIndexWeb().update_Banner(banner);
                notify_is_Guardado_Correct.open();
                select_Refresh_dialog();
            } else {
                banner.setTitulo(titulo_Banner);
                banner.setSubtitulo(subtitulo_Banner);
                banner.setLinea_ecom(l_ecom);
                Services.getIndexWeb().update_Banner(banner);
                notify_is_Activated.open();
            }
        }
    }

    @Override
    public void On_Verify_BannerAct() {
        Boolean banner_activo = Boolean.FALSE;
        String posicion_Banner = "";
        posicion_Banner = String.valueOf(posicion);
        banner_activo = is_Any_Banner_Act(posicion_Banner);
        if (banner_activo == Boolean.FALSE) {
            Banners banner = new Banners();
            LineaEcommerce l_ecom = new LineaEcommerce();
            iterator_L_Banners = 0;
            banner = L_Banners.get(iterator_L_Banners);
            l_ecom = L_Banners.get(iterator_L_Banners).getLinea_ecom();
            banner.setActivo(Boolean.TRUE);
            banner.setLinea_ecom(l_ecom);
            Services.getIndexWeb().update_Banner(banner);
            dialog_LineaEcommerce.close();
            refresh_Banners();
        }
        if (banner_activo == Boolean.TRUE) {
            dialog_LineaEcommerce.close();
            refresh_Banners();
        }
    }

    @Override
    public void refresh_Banners() {
        init_Banners();
    }

}
