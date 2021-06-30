package up.erp.view.ecom;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.google.gwt.requestfactory.shared.Service;
import com.upgrade.persistence.model.ecommerce.BannerOb;
import com.upgrade.persistence.model.ecommerce.CatalogoPuntosUp;
import com.upgrade.persistence.model.ecommerce.LineaEcommerce;
import com.upgrade.persistence.model.ecommerce.ProgramOB;
import com.upgrade.persistence.model.ecommerce.UsuarioWeb;
import com.upgrade.persistence.model.extcs.Linea;
import com.upgrade.persistence.model.ecommerce.PuntosUp;
import com.vaadin.flow.component.upload.SucceededEvent;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.server.StreamResource;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.formula.functions.Now;
import org.apache.poi.ss.formula.functions.T;
import up.erp.server.Server;
import up.erp.service.Services;
import up.erp.view.App;
import up.erp.view.dashboards.*;

import java.text.DateFormat;
import java.util.GregorianCalendar;

@SuppressWarnings("unchecked")
public class BannerView extends BannerUI {

    public App app;

    public BannerView(App app) {
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

    BannerOb actual_Baner = new BannerOb();
    PuntosUp actual_PuntosUp = new PuntosUp();
    BannerOb actual_banner = new BannerOb();
    ProgramOB actual_prog = new ProgramOB();

    List<BannerOb> list_auxban = new ArrayList<>();
    List<BannerOb> list_auxban2 = new ArrayList<>();
    List<BannerOb> list_auxban3 = new ArrayList<>();

    List<ProgramOB> list_auxProg = new ArrayList<>();
    List<ProgramOB> list_auxProg2 = new ArrayList<>();
    List<ProgramOB> list_auxProg3 = new ArrayList<>();

    List<BannerOb> list_auxbanPROG = new ArrayList<>();

    List<PuntosUp> list_result = new ArrayList<>();
    List<PuntosUp> list_aux = new ArrayList<>();
    List<BannerOb> list_catalogo = new ArrayList<>();

    List<ProgramOB> list_programacion = new ArrayList<>();

    List<Linea> list_lineas = new ArrayList<>();

    List<String> list_emails = new ArrayList<>();

    List<String> GridCols = new ArrayList<>();

    List<CatalogoPuntosUp> L_catalogo = new ArrayList<>();
    CatalogoPuntosUp actual_catalogo = new CatalogoPuntosUp();
    Integer iterator_Catalogos = 0;

    String Url_catalogo = "";

    String path_UploadCatalogo = "";
    String url_UploadCatalogo = "";
    String url_ImagenDefecto = "";

    // --------------------------------------------------------------------------

    // Generic function to convert set to list
    public static <T> List<T> convertSetToList(Set<T> set) {
        // create an empty list
        List<T> list = new ArrayList<>();

        // push each element in the set into the list
        for (T t : set)
            list.add(t);

        // return the list
        return list;
    }

    // Generic function to convert ListT to list
    public static <T> List<T> convertListT_ToList(List<T> ListT) {
        // create an empty list
        List<T> list = new ArrayList<>();

        // push each element in the set into the list
        for (T t : ListT)
            list.add(t);

        // return the list
        return list;
    }

    public void enlistar_RegistroWeb(PuntosUp registro_web) {
        list_result.add(registro_web);
    }

    public Boolean desenlistar_RegistroWeb(Integer regweb_id) {
        for (int i = 0; i < list_result.size(); i++) {
            if (list_result.get(i).getId() == regweb_id) {
                list_result.remove(list_result.remove(i));
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    public void removeAll_RegistroWeb() {
        for (int i = 0; i < list_result.size(); i++) {
            list_result.remove(i);
        }
    }

    // -----------------------------------------------------------------------------------------------
    // BUSQUEDAS
    // -----------------------------------------------------------------------------------------------
    @Override
    public void On_find_Activos() {
        // Consulta a la bd
        String nombre = txtname.getValue();
        list_result = new ArrayList<>();
        list_result = Services.getUsuarioWeb().find_PuntosUPActivos();
        grid.setItems(list_result);
    }

    @Override
    public void On_find_NoActivos() {

    }

    @Override
    public void On_find_Fechas() {
        Date fecha_ini = new Date();
        Date fecha_fin = new Date();
        list_result = new ArrayList<>();

        fecha_ini = Date.from(FechIni_bus.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        fecha_fin = Date.from(FechFin_bus.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());

        list_result = Services.getUsuarioWeb().find_PuntosUPbyFecha(fecha_ini, fecha_fin);

        grid.setItems(list_result);
    }
    // -----------------------------------------------------------------------------------------------

    // -----------------------------------------------------------------------------------------------
    // DIALOGS PUNTOS UP
    // -----------------------------------------------------------------------------------------------

    @Override
    public void on_Open_EditProgramacion() {
        list_auxProg = new ArrayList<>();
        Set<ProgramOB> set_regweb = gridProgramacion.getSelectedItems();
        list_auxProg = convertSetToList(set_regweb);

        if (list_auxProg.size() == 1 && !list_auxProg.isEmpty()) {

            // SE BUSCA DIRECCION URL DE BANNER Y SE LE ASIGNA A LA IMG LA RESPECTIVA IMAGEN
            Integer banID = list_auxProg.get(0).getid_banner();
            BannerOb ban = new BannerOb();
            ban = Services.getUsuarioWeb().get_BannerByID(banID);

            String urlBan = ban.getUrl_banner();

            imgEditProg.setSrc(urlBan);

            Integer lineaID = list_auxProg.get(0).getid_linea();
            String linea = "";

            List<String> list_linea = new ArrayList<>();
            list_linea = AllLineaEcom();

            for (int i = 0; i < list_linea.size(); i++) {

                if (lineaID == null) {
                    linea = "HOME";
                    break;

                } else {
                    if (lineaID == i) {
                        linea = list_linea.get(i);
                    }
                }
            }

            // Nombre
            try {

                path_UploadCatalogo = "";
                // path_UploadCatalogo =list_auxProg.get(0).getUrl_banner();

                imgBanner.setSrc(path_UploadCatalogo);

            } catch (Exception ex) {
                ex.printStackTrace();
            }

            txtEditProg_linea.setValue("");
            txtEditProg_linea.setValue(linea);

            cmbActivo.setPlaceholder(String.valueOf(list_auxProg.get(0).getactivo()));

            txtEditProg_fechI.setValue("");
            txtEditProg_fechI.setValue(String.valueOf(list_auxProg.get(0).getfecha_ini()));

            txtEditProg_fechF.setValue("");
            txtEditProg_fechF.setValue(String.valueOf(list_auxProg.get(0).getfecha_fin()));

            EditProgFechaI.setVisible(false);
            EditProgFechaF.setVisible(false);
            lbInform.setVisible(false);
            cmbActivo.setItems("true", "false");
            dialogEditProg.open();

        } else {
            msgErrorSelect.open();
        }
    }

    @Override
    public void on_ActualizarProgram() {
        String ant_nom;
        // Date ant_hora = new Date();

        list_auxProg2 = new ArrayList<>();
        Set<ProgramOB> set_regweb = gridProgramacion.getSelectedItems();
        list_auxProg2 = convertSetToList(set_regweb);

        actual_prog.setId(list_auxProg2.get(0).getId());

        actual_prog.setcreacion(list_auxProg2.get(0).getcreacion());

        actual_prog.setactivo(Boolean.parseBoolean(cmbActivo.getValue()));

        actual_prog.setid_banner(list_auxProg2.get(0).getid_banner());

        actual_prog.setid_linea(list_auxProg2.get(0).getid_linea());
        actual_prog.setnom_linea(list_auxProg2.get(0).getnom_linea());

        if (!EditProgFechaI.isEmpty()) {
            if (EditProgFechaF.isEmpty()) {

                actual_prog.setfecha_ini(list_auxProg2.get(0).getfecha_ini());
                actual_prog.setfecha_fin(list_auxProg2.get(0).getfecha_fin());

            } else {

                Date fechaI = new Date();
                Date fechaF = new Date();
                fechaI = Date.from(EditProgFechaI.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
                fechaF = Date.from(EditProgFechaF.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());

                actual_prog.setfecha_ini(fechaI);
                actual_prog.setfecha_fin(fechaF);

            }
        } else {

            actual_prog.setfecha_ini(list_auxProg2.get(0).getfecha_ini());
            actual_prog.setfecha_fin(list_auxProg2.get(0).getfecha_fin());

        }

        // UPDATE INCREMENTO DE PUNTOS
        Services.getUsuarioWeb().update_Programacion(actual_prog);
        Notf_ProgActualizado.open();

    }

    @Override
    public void on_Eliminar_Programacion() {

        list_auxProg3 = new ArrayList<>();
        Set<ProgramOB> set_regweb = gridProgramacion.getSelectedItems();
        list_auxProg3 = convertSetToList(set_regweb);

        if (list_auxProg.size() == 1 && !list_auxProg.isEmpty()) {

            ProgramOB promo_n = new ProgramOB();

            promo_n.setId(list_auxProg3.get(0).getId());
            Services.getUsuarioWeb().delete_prog(promo_n);
            Notf_ProgEliminada.open();
        } else {
            msgErrorSelect.open();

        }

    }

    @Override
    public void on_Open_Clientdialog() {

        list_auxban = new ArrayList<>();
        Set<BannerOb> set_regweb = gridban.getSelectedItems();
        list_auxban = convertSetToList(set_regweb);

        if (list_auxban.size() == 1 && !list_auxban.isEmpty()) {

            // Nombre
            try {

                path_UploadCatalogo = "";
                path_UploadCatalogo = list_auxban.get(0).getUrl_banner();

                /*
                 * // LOCAL///
                 * 
                 * File newFile = new File(path_UploadCatalogo); InputStream in = new
                 * FileInputStream(newFile); byte[] buffer = new byte[in.available()];
                 * in.read(buffer); in.close();
                 * 
                 * StreamResource resource = new StreamResource("bannerUpgrade.jpg", () -> new
                 * ByteArrayInputStream(buffer)); imgBanner.setSrc(resource); ////////////
                 */

                /// SERVER///

                imgBanner.setSrc(path_UploadCatalogo);

                ////////////

            } catch (Exception ex) {
                ex.printStackTrace();
            }

            if (list_auxban.get(0).getnombreComent() == null) {
                txtdialog_UsuName.setValue("");
            } else {
                txtdialog_UsuName.setValue(list_auxban.get(0).getnombreComent());
            }

            // Email
            if (list_auxban.get(0).getUrl_banner() == null) {
                dialog_UsuEmail.setValue("");
            } else {
                dialog_UsuEmail.setValue(list_auxban.get(0).getUrl_banner());
            }

            // Telefono
            /*
             * //PuntosUP Actuales if(list_auxban.get(0).getActivo() == null) {
             * txtdialog_PuntosUp.setValue("");} else {
             * txtdialog_PuntosUp.setValue(String.valueOf(list_auxban.get(0).getActivo()));}
             * 
             * 
             */
            if (list_auxban.get(0).geturl_reDirec() == null) {
                urlAdirec.setValue("");
            } else {
                urlAdirec.setValue(String.valueOf(list_auxban.get(0).geturl_reDirec()));
            }

            cmbActivoBan.setPlaceholder(String.valueOf(list_auxban.get(0).getActivo()));
            cmbActivoBan.setItems("true", "false");

            // OPEN DIALOG
            actual_banner = new BannerOb();
            actual_banner = list_auxban.get(0);
            dialogClient.open();
        } else {
            msgErrorSelect.open();
        }
    }

    @Override
    public void on_CrearProgramacion() {

        list_auxban3 = new ArrayList<>();
        Set<BannerOb> set_regweb = gridban.getSelectedItems();
        list_auxban3 = convertSetToList(set_regweb);

        if (list_auxban3.size() == 1 && !list_auxban3.isEmpty()) {

            // Nombre
            try {

                path_UploadCatalogo = "";
                path_UploadCatalogo = list_auxban3.get(0).getUrl_banner();

                /*
                 * /////// LOCAL /////
                 * 
                 * 
                 * File newFile = new File(path_UploadCatalogo); InputStream in = new
                 * FileInputStream(newFile); byte[] buffer = new byte[in.available()];
                 * in.read(buffer); in.close(); StreamResource resource = new
                 * StreamResource("bannerUpgrade.jpg", () -> new ByteArrayInputStream(buffer));
                 * 
                 * 
                 * imgBannerPROG.setSrc(resource);
                 * 
                 * //////////////////////////
                 */

                /// SERVER ///

                imgBannerPROG.setSrc(path_UploadCatalogo);

                //////////////

            } catch (Exception ex) {
                ex.printStackTrace();
            }

            // OPEN DIALOG
            actual_banner = new BannerOb();
            actual_banner = list_auxban3.get(0);
            dialogPROG.open();
        } else {
            msgErrorSelect.open();
        }

    }
    // -----------------------------------------------------------------------------------------------

    @Override
    public void on_ActualizarBanner() {
        String ant_nom;
        // Date ant_hora = new Date();

        list_auxban2 = new ArrayList<>();
        Set<BannerOb> set_regweb = gridban.getSelectedItems();
        list_auxban2 = convertSetToList(set_regweb);

        if (!txtdialog_UsuName.isEmpty()) {

            actual_Baner.setId(list_auxban2.get(0).getId());

            ant_nom = txtdialog_UsuName.getValue();
            actual_Baner.setnombreComent(ant_nom);

            ant_nom = dialog_UsuEmail.getValue();
            actual_Baner.setUrl_banner(ant_nom);

            ant_nom = urlAdirec.getValue();
            actual_Baner.seturl_reDirec(ant_nom);

            actual_Baner.setActivo(Boolean.parseBoolean(cmbActivoBan.getValue()));

            // UPDATE INCREMENTO DE PUNTOS
            Services.getUsuarioWeb().update_Banner(actual_Baner);
            Client_notify_correct.open();
        }
    }

    // -----------------------------------------------------------------------------------------------
    @Override
    public void on_Disminuir_PuntosUP() {

    }

    // -----------------------------------------------------------------------------------------------
    @Override

    public void on_Open_Incrementdialog() {
        list_aux = new ArrayList<>();
        Set<PuntosUp> set_regweb = grid.getSelectedItems();
        list_aux = convertSetToList(set_regweb);

        // OPENING DIALOG
        dialogIncrementPUP.open();
    }

    // -----------------------------------------------------------------------------------------------
    @Override
    public void on_UpdateInc_PuntosUP() {
        PuntosUp n_PuntosUp = new PuntosUp();
        Integer pts_anteriores = 0;
        Integer pts_nuevos = 0;
        Integer pts_resultantes = 0;
        if (!txtdialog_IncPUP.isEmpty()) {
            for (int i = 0; i < list_aux.size(); i++) {
                n_PuntosUp = new PuntosUp();
                n_PuntosUp = list_aux.get(i);

                pts_nuevos = Integer.valueOf(txtdialog_IncPUP.getValue());
                pts_anteriores = n_PuntosUp.getPts_restantes();
                pts_resultantes = pts_nuevos + pts_anteriores;

                n_PuntosUp.setPts_inc(pts_nuevos);
                n_PuntosUp.setPts_restantes(pts_resultantes);

                // UPDATE INCREMENTO DE PUNTOS
                Services.getUsuarioWeb().update_PuntosUP(n_PuntosUp);
            }
            Client_notify_correct.open();
        }
    }

    // -----------------------------------------------------------------------------------------------
    @Override
    public void on_Open_Disminuirdialog() {
        list_aux = new ArrayList<>();
        Set<PuntosUp> set_regweb = grid.getSelectedItems();
        list_aux = convertSetToList(set_regweb);

        // OPENING DIALOG
        dialogDisminuirPUP.open();
    }

    // -----------------------------------------------------------------------------------------------
    @Override
    public void on_UpdateDis_PuntosUP() {
        PuntosUp n_PuntosUp = new PuntosUp();
        Integer pts_anteriores = 0;
        Integer pts_nuevos = 0;
        Integer pts_resultantes = 0;
        if (!txtdialog_DisPUP.isEmpty()) {
            for (int i = 0; i < list_aux.size(); i++) {
                n_PuntosUp = new PuntosUp();
                n_PuntosUp = list_aux.get(i);

                pts_nuevos = Integer.valueOf(txtdialog_DisPUP.getValue());
                pts_anteriores = n_PuntosUp.getPts_restantes();
                pts_resultantes = pts_anteriores - pts_nuevos;
                if (pts_resultantes < 0) {
                    pts_resultantes = 0;
                }

                n_PuntosUp.setPts_dec(pts_nuevos);
                n_PuntosUp.setPts_restantes(pts_resultantes);

                // UPDATE INCREMENTO DE PUNTOS
                Services.getUsuarioWeb().update_PuntosUP(n_PuntosUp);
            }
            Client_notify_correct.open();
        }
    }
    // -----------------------------------------------------------------------------------------------

    // -----------------------------------------------------------------------------------------------
    // CATALOGO
    // -----------------------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------------
    @Override
    public void init_Catalogos() {
        // GET ALL CATALOGOS
        L_catalogo = new ArrayList<>();
        L_catalogo = Services.getUsuarioWeb().find_Catalogos();
        actual_catalogo = new CatalogoPuntosUp();
        if (L_catalogo.isEmpty()) {

            txtCatNUrlpdf.setValue("");
            checkCat_Activar.setValue(Boolean.FALSE);
        } else {
            actual_catalogo = L_catalogo.get(0);
            iterator_Catalogos = 0;

            Url_catalogo = "";

            Url_catalogo = "https://www.imagenes/compu.jpg";

            Boolean activo = Boolean.FALSE;
            activo = L_catalogo.get(0).getActivo();

            // SHOW FIRST
            if (L_catalogo.get(0).getUrl_pdf() == null) {
            } else {
            }

            if (L_catalogo.get(0).getActivo() == null) {
            }
        }
    }

    @Override
    public void on_UploadNewCatalogo(SucceededEvent event) {

    }

    @Override
    public void on_Eliminar_Banner() {

        list_auxban2 = new ArrayList<>();
        Set<BannerOb> set_regweb = gridban.getSelectedItems();
        list_auxban2 = convertSetToList(set_regweb);

        BannerOb promo_n = new BannerOb();

        promo_n.setId(list_auxban2.get(0).getId());
        Services.getUsuarioWeb().delete_Banner(promo_n);
        Client_notfy_eliminado.open();

    }

    @Override
    public void on_ViewBanners() {

        list_catalogo = new ArrayList<>();
        list_catalogo = Services.getUsuarioWeb().find_Banners();
        gridban.setItems(list_catalogo);

        list_lineas = new ArrayList<>();
        list_lineas = Services.getUsuarioWeb().find_Lineas();
        gridPROG.setItems(list_lineas);

    }

    @Override
    public void on_ViewProgramacion() {

        list_programacion = new ArrayList<>();
        list_programacion = Services.getUsuarioWeb().find_Programacion();
        gridProgramacion.setItems(list_programacion);

    }

    // -----------------------------------------------------------------------------------------------
    @Override
    public void on_Upload_Banner(SucceededEvent event) {
        path_UploadCatalogo = "";
        try {

            // LECTURA
            InputStream is = bufferCatalogo.getInputStream();
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            path_UploadCatalogo = Server.PATH_PROMO + event.getFileName();

            // ESCRITURA
            File newFile = new File(path_UploadCatalogo);
            OutputStream out = new FileOutputStream(newFile);
            out.write(buffer);
            out.close();
            is.close();

            StreamResource resource = new StreamResource("bannerUpgrade.jpg", () -> new ByteArrayInputStream(buffer));
            imgNewBan.setSrc(resource);

            // CARGA PDF
            // StreamResource resource = new StreamResource("bannerUpgrade.jpg", () -> new
            // ByteArrayInputStream(buffer));
            url_UploadCatalogo = Server.PATH_VIEW + event.getFileName();
            txtCatNUrlpdf.setValue(url_UploadCatalogo);
            // imgBanner.setSrc(resource);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // -----------------------------------------------------------------------------------------------
    @Override
    public void on_SaveNewBANNER() {
        BannerOb n_cat = new BannerOb();
        BannerOb active_cat = new BannerOb();

        Date fecha_ini = new Date();
        Date fecha_fin = new Date();

        // FECHA CREACION
        // Creacion

        // URL PDF
        if (!txtCatNUrlpdf.isEmpty()) {
            n_cat.setUrl_banner(txtCatNUrlpdf.getValue());
            n_cat.setnombreComent(txtBanName.getValue());
            n_cat.seturl_reDirec(txtUrlRedirec.getValue());

        }

        // ACTIVO
        if (!checkCat_Activar.isEmpty()) {
            n_cat.setActivo(checkCat_Activar.getValue());

            if (n_cat.getActivo() == Boolean.TRUE) {
                // GET ACTIVO EXISTENTE

                // INSERT NEW CATALAGO
                Services.getUsuarioWeb().insert_banner(n_cat);
                Client_notfy_BanGuardado.open();

            } else {
                // INSERT NEW CATALAGO
                Services.getUsuarioWeb().insert_banner(n_cat);
                Client_notfy_BanGuardado.open();
            }
        } else {
            n_cat.setActivo(Boolean.FALSE);
            // INSERT NEW CATALAGO
            Services.getUsuarioWeb().insert_banner(n_cat);
            Client_notfy_BanGuardado.open();
        }

        txtBanName.setValue("");
        txtCatNUrlpdf.setValue("");
        FechFin_bus.clear();

    }

    @Override
    public void on_SaveNewPROG() {

        ProgramOB n_cat = new ProgramOB();

        Date fecha_ini = new Date();
        Date fecha_fin = new Date();

        /////// CREA VARIABLE DATE A LA CUAL LE ASIGNAMOS LA FEHCA ACTUAL SIN TIEMPO
        LocalDate actual_date = LocalDate.now();
        Date actual = new Date();
        actual = Date.from(actual_date.atStartOfDay(ZoneId.systemDefault()).toInstant());

        /////// CREA UN ARRAYLIST Y LE ASIGNAMOS EL VALOR QUE FUE SELECCIONADO EN EL
        /////// GRID ACTUAL PARA
        // LUEGO MANEJARLO Y HACER GET DE SUS ATRIBUTOS

        list_auxbanPROG = new ArrayList<>();
        Set<BannerOb> set_regweb = gridban.getSelectedItems();
        list_auxbanPROG = convertSetToList(set_regweb);

        /////// CREA UN OBJETO DE TIPO LINEAECOMMERCE PARA HACER UN QUERY POR NOMBRE QUE
        /////// SE
        // ENCUENTRA EN UN TEXTBOX

        String linea_ecom_name = "";
        linea_ecom_name = txtCombo.getValue();
        LineaEcommerce linea_ecom = new LineaEcommerce();
        linea_ecom = Services.getLineaEcommerce().get_LineaEcommerce_byNombre(linea_ecom_name);

        // ASIGNAMOS LOS ATRIBUTOS AL OBJETO PROGRAMOB PARA LUEGO ENVIARLO COMO OBJETO
        // PARA SER GUARDADO EN LA BASE DE DATOS

        n_cat.setcreado_por("");
        n_cat.setcreacion(actual);
        n_cat.setactivo(Boolean.TRUE);

        fecha_ini = Date.from(fehcaPROG_ini.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        n_cat.setfecha_ini(fecha_ini);

        fecha_fin = Date.from(fechaPROG_fin.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        n_cat.setfecha_fin(fecha_fin);

        n_cat.setid_banner(list_auxbanPROG.get(0).getId());
        n_cat.setid_linea(linea_ecom.getId());

        n_cat.setnom_linea(txtCombo.getValue());

        // INSERT NEW CATALAGO
        Services.getUsuarioWeb().insert_Programacion(n_cat);
        Client_notfy_NewProg.open();

    }

    @Override
    public void on_BeforeCatalogo() {

    }

    @Override
    public void on_Open_CreacionProgramaUSELINEAS() {
        List<String> list_linea = new ArrayList<>();
        list_linea = AllLineaEcom();
        combo_lineas_prod.setItems(list_linea);
    }

    public List<String> AllLineaEcom() {
        List<LineaEcommerce> list_Linea_ecom = new ArrayList<>();
        List<String> list_linea = new ArrayList<>();
        list_Linea_ecom = Services.getLineaEcommerce().get_AllLineaEcommerce();

        list_linea.add("HOME");

        for (int i = 0; i < list_Linea_ecom.size(); i++) {
            list_linea.add(list_Linea_ecom.get(i).getNombre());
        }
        return list_linea;
    }

    // -----------------------------------------------------------------------------------------------
    @Override
    public void on_SaveChangesCatalogo() {

        // C:\Gustavo\ecommerce\images

        try {

            url_ImagenDefecto = Server.PATH_DEFIMG;
            File newFile = new File(url_ImagenDefecto);
            InputStream in = new FileInputStream(newFile);
            byte[] buffer = new byte[in.available()];
            in.read(buffer);
            in.close();

            StreamResource resource = new StreamResource("bannerUpgrade.jpg", () -> new ByteArrayInputStream(buffer));
            imgNewBan.setSrc(resource);

        } catch (Exception e) {
        }

    }

    // -----------------------------------------------------------------------------------------------
    @Override
    public void on_AfterCatalogo() {

    }

    @Override
    public void On_Delete_Banner() {

    }
    // -----------------------------------------------------------------------------------------------

}
