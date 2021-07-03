/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package up.erp.view.ecom;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.contextmenu.SubMenu;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.upload.SucceededEvent;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
import up.erp.view.App;

/**
 *
 * @author Hvt
 */
public abstract class IndexWebNewUI extends VerticalLayout {

    // -----------------------------------------------------------------------------------------------
    // CPANEL CABECERA
    // -----------------------------------------------------------------------------------------------
    public final Button btnClientes = new Button("Clientes Ecommerce", VaadinIcon.MALE.create());
    public final Button btnSubscriptores = new Button("Subscriptores Ecommerce", VaadinIcon.MALE.create());
    public final Button btnPromociones = new Button("Promociones Ecommerce", VaadinIcon.GIFT.create());
    public final Button btnCupones = new Button("Cupones Ecommerce", VaadinIcon.TICKET.create());
    public final Button btnPuntosUP = new Button("Puntos UP Ecommerce", VaadinIcon.TROPHY.create());
    // -----------------------------------------------------------------------------------------------
    public final Button btnPedidos = new Button("Pedidos Ecommerce", VaadinIcon.CART_O.create());
    public final Button btnLineas = new Button("Lineas Ecommerce", VaadinIcon.RECORDS.create());
    public final Button btnProductos = new Button("Productos Ecommerce", VaadinIcon.PACKAGE.create());
    public final Button btnEcomPage = new Button("Página Ecommerce", VaadinIcon.GLOBE_WIRE.create());

    // public final Button btnEcomPage = new Button("Gestión Página Ecommerce",
    // VaadinIcon.GLOBE_WIRE.create());
    // -----------------------------------------------------------------------------------------------
    public final Button btnSalirCP = new Button("Salir del Panel de Control");
    // -----------------------------------------------------------------------------------------------
    public final HorizontalLayout layCPanelButtons = new HorizontalLayout(btnClientes, btnSubscriptores, btnPromociones,
            btnCupones, btnPuntosUP);
    // -----------------------------------------------------------------------------------------------
    public final HorizontalLayout layCPanelButtons2 = new HorizontalLayout(btnPedidos, btnLineas, btnProductos,
            btnEcomPage, btnSalirCP);
    // -----------------------------------------------------------------------------------------------
    // END CABECERA
    // -----------------------------------------------------------------------------------------------

    // -----------------------------------------------------------------------------------------------
    // MAIN VIEW
    // -----------------------------------------------------------------------------------------------
    // HEADER
    // -----------------------------------------------------------------------------------------------
    Label titulo = new Label("INDEX PAGINA E-COMMERCE NEW");
    public final HorizontalLayout head = new HorizontalLayout(titulo);
    // -----------------------------------------------------------------------------------------------
    // WORKSPACE
    // -----------------------------------------------------------------------------------------------
    // SLIDERS GENERAL
    // -----------------------------------------------------------------------------------------------
    public final Label tituloSlider = new Label("SLIDERS");
    public final HorizontalLayout laytituloSlider = new HorizontalLayout(tituloSlider);
    // -----------------------------------------------------------------------------------------------
    // SLIDER NUEVO
    // -----------------------------------------------------------------------------------------------
    public final MemoryBuffer bufferSliderNew = new MemoryBuffer();
    public final Upload uploadSNew = new Upload(bufferSliderNew);
    // -----------------------------------------------------------------------------------------------
    public final Label lbTituloSliderNew = new Label("NUEVO SLIDER");
    public final HorizontalLayout layTSliderNew = new HorizontalLayout(lbTituloSliderNew);
    // -----------------------------------------------------------------------------------------------
    // IMAGEN SLIDER NUEVO

    public final Image imgSN = new Image();
    public final TextField txtSNLink = new TextField("Link/Enlace");
    public final TextField txtSNUpload = new TextField("Url Imagen");
    public final Button btnSNUpload = new Button("Cargar Imagen");
    public final Button btnSNUploadBorrar = new Button("Descartar Imagen");
    public final Checkbox checkSN_Activate = new Checkbox("Activo?");
    public final Button btnSNGuardar = new Button("Guardar Cambios");
    // -----------------------------------------------------------------------------------------------
    public final HorizontalLayout layimgSN = new HorizontalLayout(imgSN);
    public final HorizontalLayout laySNLink = new HorizontalLayout(txtSNLink);
    public final HorizontalLayout laytxtSNUpload = new HorizontalLayout(txtSNUpload);
    public final HorizontalLayout laySNUpload = new HorizontalLayout(uploadSNew, btnSNUploadBorrar);
    public final HorizontalLayout laycheckSN_Activate = new HorizontalLayout(checkSN_Activate, btnSNGuardar);
    public final VerticalLayout laySliderNew = new VerticalLayout(layTSliderNew, layimgSN, laySNLink, laytxtSNUpload,
            laySNUpload, laycheckSN_Activate);
    // -----------------------------------------------------------------------------------------------
    // SLIDER EXISTENTE
    // -----------------------------------------------------------------------------------------------
    public final MemoryBuffer bufferSliderExist = new MemoryBuffer();
    public final Upload uploadSExist = new Upload(bufferSliderExist);
    // -----------------------------------------------------------------------------------------------
    public final Label lbTituloSliderExist = new Label("LISTA DE SLIDERS");
    public final HorizontalLayout layTSliderExist = new HorizontalLayout(lbTituloSliderExist);
    // -----------------------------------------------------------------------------------------------
    // IMAGEN SLIDER EXISTENTE

    public final Image imgSE = new Image();
    public final Button btnSEAnterior = new Button("Anterior");
    public final Button btnSESiguiente = new Button("Siguiente");
    public final TextField txtSELink = new TextField("Link/Enlace");
    public final TextField txtSEUpload = new TextField("Url Imagen");
    public final Button btnSEUpload = new Button("Cargar Imagen");
    public final Button btnSEUploadBorrar = new Button("Descartar Imagen");
    public final Checkbox checkSE_Activate = new Checkbox("Activo?");
    public final Button btnSEGuardar = new Button("Guardar Cambios");
    // -----------------------------------------------------------------------------------------------
    public final HorizontalLayout layimgSE = new HorizontalLayout(btnSEAnterior, imgSE, btnSESiguiente);
    public final HorizontalLayout laySELink = new HorizontalLayout(txtSELink);
    public final HorizontalLayout laytxtSEUpload = new HorizontalLayout(txtSEUpload);
    public final HorizontalLayout laySEUpload = new HorizontalLayout(uploadSExist, btnSEUploadBorrar);
    public final HorizontalLayout laycheckSE_Activate = new HorizontalLayout(checkSE_Activate, btnSEGuardar);
    public final VerticalLayout laySliderExist = new VerticalLayout(layTSliderExist, layimgSE, laySELink,
            laytxtSEUpload, laySEUpload, laycheckSE_Activate);
    // -----------------------------------------------------------------------------------------------
    // SLIDER TOTAL
    // -----------------------------------------------------------------------------------------------
    public final HorizontalLayout laySliders = new HorizontalLayout(laySliderNew, laySliderExist);
    public final VerticalLayout laySliderTotal = new VerticalLayout(laytituloSlider, laySliders);
    // -----------------------------------------------------------------------------------------------

    // NOTIFICATION
    public final Label upd_notf_created = new Label("Slider Creado Correctamente");
    public final Label upd_notf_update = new Label("Slider Actualizado Correctamente");
    public final Label upd_notf_discard = new Label("Slider Descartado");

    public final Notification notify_created = new Notification(upd_notf_created);
    public final Notification notify_update = new Notification(upd_notf_update);
    public final Notification notify_discard = new Notification(upd_notf_discard);
    // -----------------------------------------------------------------------------------------------
    // LINEA
    // -----------------------------------------------------------------------------------------------
    public final MemoryBuffer bufferLinea = new MemoryBuffer();
    public final Upload uploadLinea = new Upload(bufferLinea);
    // -----------------------------------------------------------------------------------------------

    // BANNER - LINEAS - UI

    public final Label tituloLineas = new Label("BANNERS - LINEAS");
    public final HorizontalLayout laytituloLineas = new HorizontalLayout(tituloLineas);

    // BANNER 1
    public final Label lbLinea1Image = new Label("BANNER 1");
    public final TextField txtTituloLinea1 = new TextField("Titulo");
    public final TextField txtSubtituloLinea1 = new TextField("Subtitulo");
    public final TextField txtLEcom_Linea1 = new TextField("Linea Ecommerce");
    public final TextField txtPos_Linea1 = new TextField("Posicion");
    public final Button btnLUpload1 = new Button("Actualizar");
    public final Image imgL1 = new Image();

    public final HorizontalLayout laylbLImg1 = new HorizontalLayout(lbLinea1Image);
    public final HorizontalLayout layTLinea1 = new HorizontalLayout(txtTituloLinea1, txtSubtituloLinea1);
    public final HorizontalLayout layLEcomLinea1 = new HorizontalLayout(txtLEcom_Linea1, txtPos_Linea1);
    public final HorizontalLayout layLImg1 = new HorizontalLayout(imgL1);
    public final HorizontalLayout layBtnLinea1 = new HorizontalLayout(btnLUpload1);
    public final VerticalLayout layLineaImg1 = new VerticalLayout(laylbLImg1, layTLinea1, layLEcomLinea1, layLImg1,
            layBtnLinea1);

    // BANNER 2
    public final Label lbLinea2Image = new Label("BANNER 2");
    public final TextField txtTituloLinea2 = new TextField("Titulo");
    public final TextField txtSubtituloLinea2 = new TextField("Subtitulo");
    public final TextField txtLEcom_Linea2 = new TextField("Linea Ecommerce");
    public final TextField txtPos_Linea2 = new TextField("Posicion");
    public final Button btnLUpload2 = new Button("Actualizar");
    public final Image imgL2 = new Image();

    public final HorizontalLayout laylbLImg2 = new HorizontalLayout(lbLinea2Image);
    public final HorizontalLayout layTLinea2 = new HorizontalLayout(txtTituloLinea2, txtSubtituloLinea2);
    public final HorizontalLayout layLEcomLinea2 = new HorizontalLayout(txtLEcom_Linea2, txtPos_Linea2);
    public final HorizontalLayout layLImg2 = new HorizontalLayout(imgL2);
    public final HorizontalLayout layBtnLinea2 = new HorizontalLayout(btnLUpload2);
    public final VerticalLayout layLineaImg2 = new VerticalLayout(laylbLImg2, layTLinea2, layLEcomLinea2, layLImg2,
            layBtnLinea2);

    // BANNER 3
    public final Label lbLinea3Image = new Label("BANNER 3");
    public final TextField txtTituloLinea3 = new TextField("Titulo");
    public final TextField txtSubtituloLinea3 = new TextField("Subtitulo");
    public final TextField txtLEcom_Linea3 = new TextField("Linea Ecommerce");
    public final TextField txtPos_Linea3 = new TextField("Posicion");
    public final Button btnLUpload3 = new Button("Actualizar");
    public final Image imgL3 = new Image();

    public final HorizontalLayout laylbLImg3 = new HorizontalLayout(lbLinea3Image);
    public final HorizontalLayout layTLinea3 = new HorizontalLayout(txtTituloLinea3, txtSubtituloLinea3);
    public final HorizontalLayout layLEcomLinea3 = new HorizontalLayout(txtLEcom_Linea3, txtPos_Linea3);
    public final HorizontalLayout layLImg3 = new HorizontalLayout(imgL3);
    public final HorizontalLayout layBtnLinea3 = new HorizontalLayout(btnLUpload3);
    public final VerticalLayout layLineaImg3 = new VerticalLayout(laylbLImg3, layTLinea3, layLEcomLinea3, layLImg3,
            layBtnLinea3);

    // BANNER 4
    public final Label lbLinea4Image = new Label("BANNER 4");
    public final TextField txtTituloLinea4 = new TextField("Titulo");
    public final TextField txtSubtituloLinea4 = new TextField("Subtitulo");
    public final TextField txtLEcom_Linea4 = new TextField("Linea Ecommerce");
    public final TextField txtPos_Linea4 = new TextField("Posicion");
    public final Button btnLUpload4 = new Button("Actualizar");
    public final Image imgL4 = new Image();

    public final HorizontalLayout laylbLImg4 = new HorizontalLayout(lbLinea4Image);
    public final HorizontalLayout layTLinea4 = new HorizontalLayout(txtTituloLinea4, txtSubtituloLinea4);
    public final HorizontalLayout layLEcomLinea4 = new HorizontalLayout(txtLEcom_Linea4, txtPos_Linea4);
    public final HorizontalLayout layLImg4 = new HorizontalLayout(imgL4);
    public final HorizontalLayout layBtnLinea4 = new HorizontalLayout(btnLUpload4);
    public final VerticalLayout layLineaImg4 = new VerticalLayout(laylbLImg4, layTLinea4, layLEcomLinea4, layLImg4,
            layBtnLinea4);

    // BANNER 5
    public final Label lbLinea5Image = new Label("BANNER 5");
    public final TextField txtTituloLinea5 = new TextField("Titulo");
    public final TextField txtSubtituloLinea5 = new TextField("Subtitulo");
    public final TextField txtLEcom_Linea5 = new TextField("Linea Ecommerce");
    public final TextField txtPos_Linea5 = new TextField("Posicion");
    public final Button btnLUpload5 = new Button("Actualizar");
    public final Image imgL5 = new Image();

    public final HorizontalLayout laylbLImg5 = new HorizontalLayout(lbLinea5Image);
    public final HorizontalLayout layTLinea5 = new HorizontalLayout(txtTituloLinea5, txtSubtituloLinea5);
    public final HorizontalLayout layLEcomLinea5 = new HorizontalLayout(txtLEcom_Linea5, txtPos_Linea5);
    public final HorizontalLayout layLImg5 = new HorizontalLayout(imgL5);
    public final HorizontalLayout layBtnLinea5 = new HorizontalLayout(btnLUpload5);
    public final VerticalLayout layLineaImg5 = new VerticalLayout(laylbLImg5, layTLinea5, layLEcomLinea5, layLImg5,
            layBtnLinea5);

    // BANNER 6
    public final Label lbLinea6Image = new Label("BANNER 6");
    public final TextField txtTituloLinea6 = new TextField("Titulo");
    public final TextField txtSubtituloLinea6 = new TextField("Subtitulo");
    public final TextField txtLEcom_Linea6 = new TextField("Linea Ecommerce");
    public final TextField txtPos_Linea6 = new TextField("Posicion");
    public final Button btnLUpload6 = new Button("Actualizar");
    public final Image imgL6 = new Image();

    public final HorizontalLayout laylbLImg6 = new HorizontalLayout(lbLinea6Image);
    public final HorizontalLayout layTLinea6 = new HorizontalLayout(txtTituloLinea6, txtSubtituloLinea6);
    public final HorizontalLayout layLEcomLinea6 = new HorizontalLayout(txtLEcom_Linea6, txtPos_Linea6);
    public final HorizontalLayout layLImg6 = new HorizontalLayout(imgL6);
    public final HorizontalLayout layBtnLinea6 = new HorizontalLayout(btnLUpload6);
    public final VerticalLayout layLineaImg6 = new VerticalLayout(laylbLImg6, layTLinea6, layLEcomLinea6, layLImg6,
            layBtnLinea6);
    // -----------------------------------------------------------------------------------------------
    // LINEAS TOTAL
    // -----------------------------------------------------------------------------------------------
    public final HorizontalLayout layLineaImages = new HorizontalLayout(layLineaImg1, layLineaImg2);
    public final HorizontalLayout layLineaImages2 = new HorizontalLayout(layLineaImg3, layLineaImg4);
    public final HorizontalLayout layLineaImages3 = new HorizontalLayout(layLineaImg5, layLineaImg6);

    public final VerticalLayout layLineasTotal = new VerticalLayout(laytituloLineas, layLineaImages, layLineaImages2,
            layLineaImages3);
    // -----------------------------------------------------------------------------------------------
    // LAYOUT FINALES
    // -----------------------------------------------------------------------------------------------

    // -----------------------------------------------------------------------------------------------
    // FOOT
    // -----------------------------------------------------------------------------------------------
    // BOTONES ADICIONALES
    // Iconos
    public final Icon exit = VaadinIcon.EXIT.create();
    public final Button btnExit = new Button("Salir", exit);

    public final HorizontalLayout fButtons = new HorizontalLayout(btnExit);
    // -----------------------------------------------------------------------------------------------
    // END MAIN VIEW
    // -----------------------------------------------------------------------------------------------

    // -----------------------------------------------------------------------------------------------
    // DIALOG BANNER - LINEA ECOMMERCE
    // -----------------------------------------------------------------------------------------------
    // TITULO GENERAL
    public final Label lbdialog_titulo = new Label("INDEX LINEA E-COMMERCE");
    public final HorizontalLayout laydialog_titulo = new HorizontalLayout(lbdialog_titulo);
    // -----------------------------------------------------------------------------------------------

    // NUEVO BANNER

    public final Label lbdialog_NImgTit = new Label("NUEVO BANNER");
    public final HorizontalLayout laydialog_NImgTit = new HorizontalLayout(lbdialog_NImgTit);

    // Titulo y subtitulo Imagen
    public final TextField txtdialog_TLEcom = new TextField("Titulo");
    public final TextField txtdialog_SubtLEcom = new TextField("Subitulo");
    public final HorizontalLayout laydialog_TLEcom = new HorizontalLayout(txtdialog_TLEcom, txtdialog_SubtLEcom);

    // Linea Ecommerce y Posicion
    public final ComboBox<String> cmbdialog_LEcom = new ComboBox("Linea E-commerce");
    public final TextField txtdialog_LEcom = new TextField("Linea Ecommerce");
    public final TextField txtdialog_PosLEcom = new TextField("Posicion");
    public final HorizontalLayout laydialog_LEcom = new HorizontalLayout(cmbdialog_LEcom, txtdialog_LEcom,
            txtdialog_PosLEcom);

    // Upload
    public final TextField txtdialog_Upload = new TextField("Ruta Imagen");
    public final HorizontalLayout laydialog_TUpEcom = new HorizontalLayout(txtdialog_Upload);

    public final Image dialog_img = new Image();
    public final HorizontalLayout laydialog_ImgUpEcom = new HorizontalLayout(dialog_img);

    public final Button btndialog_Upload = new Button("Subir Nueva Imagen");
    public final HorizontalLayout laydialog_BUpEcom = new HorizontalLayout(uploadLinea);

    // Activar Imagen
    public final Label lbdialog_CheckActivation = new Label("Activar?");
    public final Checkbox dialog_CheckActivation = new Checkbox();
    public final HorizontalLayout laydialog_checkActivation = new HorizontalLayout(lbdialog_CheckActivation,
            dialog_CheckActivation);

    // Botones Nueva Imagen
    public final Button btndialog_Guardar = new Button("Guardar Cambios");
    public final HorizontalLayout laydialog_Btns = new HorizontalLayout(btndialog_Guardar);

    // LAYOUT TOTAL NUEVA IMAGEN
    public final VerticalLayout laydialog_NImgTotal = new VerticalLayout(lbdialog_NImgTit, laydialog_TLEcom,
            laydialog_LEcom, laydialog_TUpEcom, laydialog_ImgUpEcom, laydialog_BUpEcom, laydialog_checkActivation,
            laydialog_Btns);
    // ------------------------------------------------------------------------------------------------------

    // BANNER ACTIVO

    public final TextField txtdialog2_TitPos = new TextField("");
    public final Label lbdialog2_LineasActTit = new Label("BANCO DE IMAGENES DE BANNERS");
    public final HorizontalLayout laydialog2_LineasActTit = new HorizontalLayout(lbdialog2_LineasActTit);

    // Titulo y subtitulo Imagen
    public final TextField txtdialog2_TLEcom = new TextField("Titulo");
    public final TextField txtdialog2_SubtLEcom = new TextField("Subitulo");
    public final HorizontalLayout laydialog2_TLEcom = new HorizontalLayout(txtdialog2_TLEcom, txtdialog2_SubtLEcom);

    // Linea Ecommerce y Posicion
    public final ComboBox<String> cmbdialog2_LEcom = new ComboBox("Linea E-commerce");
    public final TextField txtdialog2_LEcom = new TextField("Linea Ecommerce");
    public final TextField txtdialog2_PosLEcom = new TextField("Posicion");
    public final HorizontalLayout laydialog2_LEcom = new HorizontalLayout(cmbdialog2_LEcom, txtdialog2_LEcom,
            txtdialog2_PosLEcom);

    // Linea Ecommerce y Posicion
    // public final ComboBox<String> cmbdialog2_LEcom = new ComboBox("Linea
    // E-commerce");
    // public final TextField txtdialog2_LEcom = new TextField("Linea Ecommerce");
    // public final TextField txtdialog2_PosLEcom = new TextField("Posicion");
    // public final Button btndialog2_BuscarLE = new Button("Buscar Banner Activo");
    // public final HorizontalLayout laydialog2_LEcom = new
    // HorizontalLayout(txtdialog2_LEcom,txtdialog2_PosLEcom);

    // Upload
    public final Image dialog2_img = new Image();
    public final Button btndialog2_BuscarAnterior = new Button("Anterior");
    public final Button btndialog2_BuscarSiguiente = new Button("Siguiente");
    public final HorizontalLayout laydialog2_ImgUpEcom = new HorizontalLayout(btndialog2_BuscarAnterior, dialog2_img,
            btndialog2_BuscarSiguiente);

    // Activado
    public final Label lbdialog2_CheckActivation = new Label("Está Activo?");
    public final Checkbox dialog2_CheckActivation = new Checkbox();
    public final Button btndialog2_Confirm = new Button("Confirmar Cambio");
    public final HorizontalLayout laydialog2_ActConfirm = new HorizontalLayout(lbdialog2_CheckActivation,
            dialog2_CheckActivation, btndialog2_Confirm);

    // LAYOUT TOTAL LINEAS ACTIVAS
    public final VerticalLayout laydialog_LActTotal = new VerticalLayout(laydialog2_LineasActTit, laydialog2_TLEcom,
            laydialog2_LEcom, laydialog2_ImgUpEcom, laydialog2_ActConfirm);
    // ------------------------------------------------------------------------------------------------------
    // Salir Pantalla
    public final Button btndialog_Cancel = new Button("Salir Pantalla");
    public final HorizontalLayout laydialog_Salir = new HorizontalLayout(btndialog_Cancel);
    // ------------------------------------------------------------------------------------------------------

    // LAYOUTS FINALES
    public final HorizontalLayout laydialog_NImg_LAct = new HorizontalLayout(laydialog_NImgTotal, laydialog_LActTotal);

    public final VerticalLayout laydialog_Final = new VerticalLayout(laydialog_titulo, laydialog_NImg_LAct,
            laydialog_Salir);

    public final Dialog dialog_LineaEcommerce = new Dialog(laydialog_Final);

    // -----------------------------------------------------------------------------------------------
    // NOTIFICATION DIALOG LINEA ECOMMERCE
    public final Label dialog_notf_is_Activated = new Label(
            "El Banner seleccionado ya se encuentra activado para esa posicion, si desea activar este Banner por favor desactivar el activo");
    public final Label dialog_notf_is_NotActivated = new Label(
            "El Banner seleccionado se ha desactivado para esa posicion");
    public final Label dialog_notf_is_PosibleActivated = new Label(
            "El Banner seleccionado si puede activarse para esa posicion");
    public final Label dialog_notf_Guardado_Correct = new Label("El Banner se ha guardado satisfactoriamente");

    public final Notification notify_is_Activated = new Notification(dialog_notf_is_Activated);
    public final Notification notify_is_NotActivated = new Notification(dialog_notf_is_NotActivated);
    public final Notification notify_is_PosibleActivated = new Notification(dialog_notf_is_PosibleActivated);
    public final Notification notify_is_Guardado_Correct = new Notification(dialog_notf_Guardado_Correct);

    // -----------------------------------------------------------------------------------------------
    public IndexWebNewUI() {

        // add(head, header, layHeadPage, layBodyPage, layFootPage,fButtons);
        removeAll();
        add(layCPanelButtons, layCPanelButtons2, head, laySliderTotal, layLineasTotal, fButtons);
        initStyles();
        initEvents();
    }

    private void initStyles() {

        // ------------------------------------------------------------------------------------------------
        // CABECERA CPANEL
        // ------------------------------------------------------------------------------------------------
        btnClientes.setWidthFull();
        btnClientes.getStyle().set("fontSize", "80%");

        btnSubscriptores.setWidthFull();
        btnSubscriptores.getStyle().set("fontSize", "80%");

        btnPromociones.setWidthFull();
        btnPromociones.getStyle().set("fontSize", "80%");

        btnCupones.setWidthFull();
        btnCupones.getStyle().set("fontSize", "80%");

        btnPuntosUP.setWidthFull();
        btnPuntosUP.getStyle().set("fontSize", "80%");
        // ------------------------------------------------------------------------------------------------
        btnPedidos.setWidthFull();
        btnPedidos.getStyle().set("fontSize", "80%");

        btnLineas.setWidthFull();
        btnLineas.getStyle().set("fontSize", "80%");

        btnProductos.setWidthFull();
        btnProductos.getStyle().set("fontSize", "80%");

        btnEcomPage.setWidthFull();
        btnEcomPage.getStyle().set("fontSize", "80%");

        btnSalirCP.addThemeVariants(ButtonVariant.LUMO_ERROR);
        btnSalirCP.getStyle().set("fontSize", "80%");
        btnSalirCP.setWidthFull();
        // ------------------------------------------------------------------------------------------------
        layCPanelButtons.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        layCPanelButtons.setWidthFull();

        layCPanelButtons2.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        layCPanelButtons2.setWidthFull();
        // -----------------------------------------------------------------------------------------------
        // END CABECERA
        // -----------------------------------------------------------------------------------------------

        // ------------------------------------------------------------------------------------------------
        // MAIN VIEW
        // ------------------------------------------------------------------------------------------------
        // HEADER
        titulo.getStyle().set("fontWeight", "bold");
        titulo.getStyle().set("fontSize", "300%");
        head.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        head.setWidthFull();
        // -----------------------------------------------------------------------------------------------
        // WORKSPACE
        // -----------------------------------------------------------------------------------------------
        // SLIDERS GENERAL
        // -----------------------------------------------------------------------------------------------
        tituloSlider.getStyle().set("fontWeight", "bold");
        tituloSlider.getStyle().set("fontSize", "150%");

        laytituloSlider.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laytituloSlider.setWidthFull();
        // -----------------------------------------------------------------------------------------------
        // SLIDER NUEVO
        // -----------------------------------------------------------------------------------------------
        uploadSNew.setAutoUpload(true);
        uploadSNew.setDropAllowed(false);
        uploadSNew.setUploadButton(btnSNUpload);
        // uploadSNew.setMaxFileSize(1030);
        // -----------------------------------------------------------------------------------------------
        lbTituloSliderNew.getStyle().set("fontWeight", "bold");
        lbTituloSliderNew.getStyle().set("fontSize", "130%");

        layTSliderNew.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        layTSliderNew.setAlignItems(FlexComponent.Alignment.CENTER);
        layTSliderNew.setWidthFull();
        // -----------------------------------------------------------------------------------------------
        // IMAGEN SLIDER NUEVO

        imgSN.setVisible(true);
        imgSN.setEnabled(true);
        imgSN.setHeight("200px");
        imgSN.setWidth("350px");

        txtSNLink.setWidthFull();

        txtSNUpload.setWidthFull();
        txtSNUpload.setReadOnly(true);

        btnSNUpload.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        btnSNUpload.getStyle().set("fontSize", "90%");

        btnSNUploadBorrar.addThemeVariants(ButtonVariant.LUMO_ERROR);
        btnSNUploadBorrar.getStyle().set("fontSize", "90%");

        checkSN_Activate.setValue(Boolean.FALSE);
        btnSNGuardar.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        btnSNGuardar.getStyle().set("fontSize", "90%");
        // -----------------------------------------------------------------------------------------------
        layimgSN.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layimgSN.setWidthFull();

        laySNLink.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laySNLink.setWidthFull();

        laytxtSNUpload.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laytxtSNUpload.setWidthFull();

        laySNUpload.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laySNUpload.setWidthFull();

        laycheckSN_Activate.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laycheckSN_Activate.setAlignItems(FlexComponent.Alignment.BASELINE);
        laycheckSN_Activate.setWidthFull();

        laySliderNew.getStyle().set("border", "1px solid #9E9E9E");
        laySliderNew.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laySliderNew.setAlignItems(FlexComponent.Alignment.CENTER);
        laySliderNew.setWidthFull();
        // -----------------------------------------------------------------------------------------------
        // SLIDER EXISTENTE
        // -----------------------------------------------------------------------------------------------
        uploadSExist.setAutoUpload(true);
        uploadSExist.setDropAllowed(false);
        uploadSExist.setUploadButton(btnSEUpload);
        // uploadSExist.setMaxFileSize(1030);
        // -----------------------------------------------------------------------------------------------
        lbTituloSliderExist.getStyle().set("fontWeight", "bold");
        lbTituloSliderExist.getStyle().set("fontSize", "130%");

        layTSliderExist.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        layTSliderExist.setAlignItems(FlexComponent.Alignment.CENTER);
        layTSliderExist.setWidthFull();
        // -----------------------------------------------------------------------------------------------
        // IMAGEN SLIDER EXISTENTE

        imgSE.setVisible(true);
        imgSE.setEnabled(true);
        imgSE.setHeight("200px");
        imgSE.setWidth("350px");

        btnSEAnterior.addThemeVariants(ButtonVariant.LUMO_TERTIARY_INLINE);
        btnSEAnterior.getStyle().set("fontSize", "70%");

        btnSESiguiente.addThemeVariants(ButtonVariant.LUMO_TERTIARY_INLINE);
        btnSESiguiente.getStyle().set("fontSize", "70%");

        txtSELink.setWidthFull();

        txtSEUpload.setWidthFull();
        txtSEUpload.setReadOnly(true);

        btnSEUpload.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        btnSEUpload.getStyle().set("fontSize", "90%");

        btnSEUploadBorrar.addThemeVariants(ButtonVariant.LUMO_ERROR);
        btnSEUploadBorrar.getStyle().set("fontSize", "90%");

        btnSEGuardar.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        btnSEGuardar.getStyle().set("fontSize", "90%");
        // -----------------------------------------------------------------------------------------------
        layimgSE.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layimgSE.setWidthFull();

        laySELink.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laySELink.setWidthFull();

        laytxtSEUpload.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laytxtSEUpload.setWidthFull();

        laySEUpload.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laySEUpload.setWidthFull();

        laycheckSE_Activate.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laycheckSE_Activate.setAlignItems(FlexComponent.Alignment.BASELINE);
        laycheckSE_Activate.setWidthFull();

        laySliderExist.getStyle().set("border", "1px solid #9E9E9E");
        laySliderExist.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laySliderExist.setAlignItems(FlexComponent.Alignment.CENTER);
        laySliderExist.setWidthFull();
        // -----------------------------------------------------------------------------------------------
        // SLIDER TOTAL
        // -----------------------------------------------------------------------------------------------
        laySliders.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laySliders.setAlignItems(FlexComponent.Alignment.CENTER);
        laySliders.setWidthFull();

        laySliderTotal.getStyle().set("border", "1px solid #9E9E9E");
        laySliderTotal.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laySliderTotal.setAlignItems(FlexComponent.Alignment.CENTER);
        laySliderTotal.setWidthFull();
        // -----------------------------------------------------------------------------------------------
        // LINEAS
        // -----------------------------------------------------------------------------------------------
        // LINEA 1
        imgL1.setVisible(true);
        imgL1.setEnabled(true);
        imgL1.setHeight("150px");
        imgL1.setWidth("250px");

        // LINEA 2
        imgL2.setVisible(true);
        imgL2.setEnabled(true);
        imgL2.setHeight("150px");
        imgL2.setWidth("250px");

        // LINEA 3
        imgL3.setVisible(true);
        imgL3.setEnabled(true);
        imgL3.setHeight("150px");
        imgL3.setWidth("250px");

        // LINEA 4
        imgL4.setVisible(true);
        imgL4.setEnabled(true);
        imgL4.setHeight("150px");
        imgL4.setWidth("250px");

        // LINEA 5
        imgL5.setVisible(true);
        imgL5.setEnabled(true);
        imgL5.setHeight("150px");
        imgL5.setWidth("250px");

        // LINEA 6
        imgL6.setVisible(true);
        imgL6.setEnabled(true);
        imgL6.setHeight("150px");
        imgL6.setWidth("250px");
        // -----------------------------------------------------------------------------------------------
        // LINEAS
        tituloLineas.getStyle().set("fontWeight", "bold");
        tituloLineas.getStyle().set("fontSize", "150%");

        laytituloSlider.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laytituloSlider.setAlignItems(FlexComponent.Alignment.CENTER);
        laytituloSlider.setWidthFull();

        laytituloLineas.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laytituloLineas.setAlignItems(FlexComponent.Alignment.CENTER);
        laytituloLineas.setWidthFull();
        // -----------------------------------------------------------------------------------------------
        // LINEAS

        // LINEA 1

        // Variables

        txtTituloLinea1.setReadOnly(true);
        txtTituloLinea1.setWidthFull();
        txtSubtituloLinea1.setReadOnly(true);
        txtSubtituloLinea1.setWidthFull();
        txtLEcom_Linea1.setReadOnly(true);
        txtLEcom_Linea1.setWidthFull();
        txtPos_Linea1.setReadOnly(true);
        txtPos_Linea1.setWidthFull();
        btnLUpload1.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        btnLUpload1.getStyle().set("fontSize", "90%");

        // Layouts

        laylbLImg1.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laylbLImg1.setAlignItems(FlexComponent.Alignment.CENTER);
        laylbLImg1.setWidthFull();

        layTLinea1.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        layTLinea1.setAlignItems(FlexComponent.Alignment.BASELINE);
        layTLinea1.setWidthFull();

        layLEcomLinea1.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        layLEcomLinea1.setAlignItems(FlexComponent.Alignment.BASELINE);
        layLEcomLinea1.setWidthFull();

        layLImg1.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layLImg1.setAlignItems(FlexComponent.Alignment.CENTER);
        layLImg1.setWidthFull();

        layBtnLinea1.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layBtnLinea1.setAlignItems(FlexComponent.Alignment.CENTER);
        layBtnLinea1.setWidthFull();

        layLineaImg1.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layLineaImg1.setAlignItems(FlexComponent.Alignment.CENTER);
        layLineaImg1.setWidthFull();
        // -----------------------------------------------------------------------------------------------

        // BANNER 1

        // Variables

        txtTituloLinea1.setReadOnly(true);
        txtTituloLinea1.getStyle().set("fontWeight", "bold");
        txtTituloLinea1.setWidthFull();
        txtSubtituloLinea1.setReadOnly(true);
        txtSubtituloLinea1.setWidthFull();
        txtLEcom_Linea1.setReadOnly(true);
        txtLEcom_Linea1.setWidthFull();
        txtPos_Linea1.setReadOnly(true);
        txtPos_Linea1.setWidthFull();
        btnLUpload1.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        btnLUpload1.getStyle().set("fontSize", "90%");

        // Layouts

        laylbLImg1.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laylbLImg1.setAlignItems(FlexComponent.Alignment.CENTER);
        laylbLImg1.setWidthFull();

        layTLinea1.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        layTLinea1.setAlignItems(FlexComponent.Alignment.BASELINE);
        layTLinea1.setWidthFull();

        layLEcomLinea1.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        layLEcomLinea1.setAlignItems(FlexComponent.Alignment.BASELINE);
        layLEcomLinea1.setWidthFull();

        layLImg1.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layLImg1.setAlignItems(FlexComponent.Alignment.CENTER);
        layLImg1.setWidthFull();

        layBtnLinea1.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layBtnLinea1.setAlignItems(FlexComponent.Alignment.CENTER);
        layBtnLinea1.setWidthFull();

        layLineaImg1.getStyle().set("border", "1px solid #9E9E9E");
        layLineaImg1.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layLineaImg1.setAlignItems(FlexComponent.Alignment.CENTER);
        layLineaImg1.setWidthFull();
        // -----------------------------------------------------------------------------------------------

        // BANNER 2

        // Variables

        txtTituloLinea2.setReadOnly(true);
        txtTituloLinea2.getStyle().set("fontWeight", "bold");
        txtTituloLinea2.setWidthFull();
        txtSubtituloLinea2.setReadOnly(true);
        txtSubtituloLinea2.setWidthFull();
        txtLEcom_Linea2.setReadOnly(true);
        txtLEcom_Linea2.setWidthFull();
        txtPos_Linea2.setReadOnly(true);
        txtPos_Linea2.setWidthFull();
        btnLUpload2.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        btnLUpload2.getStyle().set("fontSize", "90%");

        // Layouts

        laylbLImg2.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laylbLImg2.setAlignItems(FlexComponent.Alignment.CENTER);
        laylbLImg2.setWidthFull();

        layTLinea2.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        layTLinea2.setAlignItems(FlexComponent.Alignment.BASELINE);
        layTLinea2.setWidthFull();

        layLEcomLinea2.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        layLEcomLinea2.setAlignItems(FlexComponent.Alignment.BASELINE);
        layLEcomLinea2.setWidthFull();

        layLImg2.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layLImg2.setAlignItems(FlexComponent.Alignment.CENTER);
        layLImg2.setWidthFull();

        layBtnLinea2.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layBtnLinea2.setAlignItems(FlexComponent.Alignment.CENTER);
        layBtnLinea2.setWidthFull();

        layLineaImg2.getStyle().set("border", "1px solid #9E9E9E");
        layLineaImg2.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layLineaImg2.setAlignItems(FlexComponent.Alignment.CENTER);
        layLineaImg2.setWidthFull();
        // -----------------------------------------------------------------------------------------------

        // BANNER 3

        // Variables

        txtTituloLinea3.setReadOnly(true);
        txtTituloLinea3.getStyle().set("fontWeight", "bold");
        txtTituloLinea3.setWidthFull();
        txtSubtituloLinea3.setReadOnly(true);
        txtSubtituloLinea3.setWidthFull();
        txtLEcom_Linea3.setReadOnly(true);
        txtLEcom_Linea3.setWidthFull();
        txtPos_Linea3.setReadOnly(true);
        txtPos_Linea3.setWidthFull();
        btnLUpload3.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        btnLUpload3.getStyle().set("fontSize", "90%");

        // Layouts

        laylbLImg3.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laylbLImg3.setAlignItems(FlexComponent.Alignment.CENTER);
        laylbLImg3.setWidthFull();

        layTLinea3.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        layTLinea3.setAlignItems(FlexComponent.Alignment.BASELINE);
        layTLinea3.setWidthFull();

        layLEcomLinea3.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        layLEcomLinea3.setAlignItems(FlexComponent.Alignment.BASELINE);
        layLEcomLinea3.setWidthFull();

        layLImg3.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layLImg3.setAlignItems(FlexComponent.Alignment.CENTER);
        layLImg3.setWidthFull();

        layBtnLinea3.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layBtnLinea3.setAlignItems(FlexComponent.Alignment.CENTER);
        layBtnLinea3.setWidthFull();

        layLineaImg3.getStyle().set("border", "1px solid #9E9E9E");
        layLineaImg3.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layLineaImg3.setAlignItems(FlexComponent.Alignment.CENTER);
        layLineaImg3.setWidthFull();
        // -----------------------------------------------------------------------------------------------

        // BANNER 4

        // Variables

        txtTituloLinea4.setReadOnly(true);
        txtTituloLinea4.getStyle().set("fontWeight", "bold");
        txtTituloLinea4.setWidthFull();
        txtSubtituloLinea4.setReadOnly(true);
        txtSubtituloLinea4.setWidthFull();
        txtLEcom_Linea4.setReadOnly(true);
        txtLEcom_Linea4.setWidthFull();
        txtPos_Linea4.setReadOnly(true);
        txtPos_Linea4.setWidthFull();
        btnLUpload4.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        btnLUpload4.getStyle().set("fontSize", "90%");

        // Layouts

        laylbLImg4.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laylbLImg4.setAlignItems(FlexComponent.Alignment.CENTER);
        laylbLImg4.setWidthFull();

        layTLinea4.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        layTLinea4.setAlignItems(FlexComponent.Alignment.BASELINE);
        layTLinea4.setWidthFull();

        layLEcomLinea4.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        layLEcomLinea4.setAlignItems(FlexComponent.Alignment.BASELINE);
        layLEcomLinea4.setWidthFull();

        layLImg4.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layLImg4.setAlignItems(FlexComponent.Alignment.CENTER);
        layLImg4.setWidthFull();

        layBtnLinea4.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layBtnLinea4.setAlignItems(FlexComponent.Alignment.CENTER);
        layBtnLinea4.setWidthFull();

        layLineaImg4.getStyle().set("border", "1px solid #9E9E9E");
        layLineaImg4.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layLineaImg4.setAlignItems(FlexComponent.Alignment.CENTER);
        layLineaImg4.setWidthFull();
        // -----------------------------------------------------------------------------------------------

        // BANNER 5

        // Variables

        txtTituloLinea5.setReadOnly(true);
        txtTituloLinea5.getStyle().set("fontWeight", "bold");
        txtTituloLinea5.setWidthFull();
        txtSubtituloLinea5.setReadOnly(true);
        txtSubtituloLinea5.setWidthFull();
        txtLEcom_Linea5.setReadOnly(true);
        txtLEcom_Linea5.setWidthFull();
        txtPos_Linea5.setReadOnly(true);
        txtPos_Linea5.setWidthFull();
        btnLUpload5.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        btnLUpload5.getStyle().set("fontSize", "90%");

        // Layouts

        laylbLImg5.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laylbLImg5.setAlignItems(FlexComponent.Alignment.CENTER);
        laylbLImg5.setWidthFull();

        layTLinea5.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        layTLinea5.setAlignItems(FlexComponent.Alignment.BASELINE);
        layTLinea5.setWidthFull();

        layLEcomLinea5.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        layLEcomLinea5.setAlignItems(FlexComponent.Alignment.BASELINE);
        layLEcomLinea5.setWidthFull();

        layLImg5.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layLImg5.setAlignItems(FlexComponent.Alignment.CENTER);
        layLImg5.setWidthFull();

        layBtnLinea5.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layBtnLinea5.setAlignItems(FlexComponent.Alignment.CENTER);
        layBtnLinea5.setWidthFull();

        layLineaImg5.getStyle().set("border", "1px solid #9E9E9E");
        layLineaImg5.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layLineaImg5.setAlignItems(FlexComponent.Alignment.CENTER);
        layLineaImg5.setWidthFull();
        // -----------------------------------------------------------------------------------------------

        // BANNER 6

        // Variables

        txtTituloLinea6.setReadOnly(true);
        txtTituloLinea6.getStyle().set("fontWeight", "bold");
        txtTituloLinea6.setWidthFull();
        txtSubtituloLinea6.setReadOnly(true);
        txtSubtituloLinea6.setWidthFull();
        txtLEcom_Linea6.setReadOnly(true);
        txtLEcom_Linea6.setWidthFull();
        txtPos_Linea6.setReadOnly(true);
        txtPos_Linea6.setWidthFull();
        btnLUpload6.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        btnLUpload6.getStyle().set("fontSize", "90%");

        // Layouts

        laylbLImg6.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laylbLImg6.setAlignItems(FlexComponent.Alignment.CENTER);
        laylbLImg6.setWidthFull();

        layTLinea6.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        layTLinea6.setAlignItems(FlexComponent.Alignment.BASELINE);
        layTLinea6.setWidthFull();

        layLEcomLinea6.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        layLEcomLinea6.setAlignItems(FlexComponent.Alignment.BASELINE);
        layLEcomLinea6.setWidthFull();

        layLImg6.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layLImg6.setAlignItems(FlexComponent.Alignment.CENTER);
        layLImg6.setWidthFull();

        layBtnLinea6.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layBtnLinea6.setAlignItems(FlexComponent.Alignment.CENTER);
        layBtnLinea6.setWidthFull();

        layLineaImg6.getStyle().set("border", "1px solid #9E9E9E");
        layLineaImg6.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layLineaImg6.setAlignItems(FlexComponent.Alignment.CENTER);
        layLineaImg6.setWidthFull();
        // -----------------------------------------------------------------------------------------------

        // LAYOUTS LINEAS
        layLineaImages.getStyle().set("border", "1px solid #9E9E9E");
        layLineaImages.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layLineaImages.setAlignItems(FlexComponent.Alignment.CENTER);
        layLineaImages.setWidthFull();

        layLineaImages2.getStyle().set("border", "1px solid #9E9E9E");
        layLineaImages2.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layLineaImages2.setAlignItems(FlexComponent.Alignment.CENTER);
        layLineaImages2.setWidthFull();

        layLineaImages3.getStyle().set("border", "1px solid #9E9E9E");
        layLineaImages3.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layLineaImages3.setAlignItems(FlexComponent.Alignment.CENTER);
        layLineaImages3.setWidthFull();

        // ALL LAYOUT - BODY

        layLineasTotal.getStyle().set("border", "1px solid #9E9E9E");
        layLineasTotal.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layLineasTotal.setAlignItems(FlexComponent.Alignment.CENTER);
        layLineasTotal.setWidthFull();

        // -----------------------------------------------------------------------------------------------
        // NOTIFICATION
        // -----------------------------------------------------------------------------------------------
        upd_notf_created.getStyle().set("fontSize", "90%");
        upd_notf_created.getStyle().set("color", "green");

        upd_notf_update.getStyle().set("fontSize", "90%");
        upd_notf_update.getStyle().set("color", "green");

        notify_created.setDuration(1500);
        notify_created.setPosition(Position.MIDDLE);

        notify_update.setDuration(1500);
        notify_update.setPosition(Position.MIDDLE);

        upd_notf_discard.getStyle().set("fontSize", "90%");
        upd_notf_discard.getStyle().set("color", "red");

        notify_discard.setDuration(1500);
        notify_discard.setPosition(Position.MIDDLE);
        // -----------------------------------------------------------------------------------------------
        // FOOTER
        // -----------------------------------------------------------------------------------------------
        fButtons.getStyle().set("border", "1px solid #9E9E9E");
        fButtons.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        fButtons.setAlignItems(FlexComponent.Alignment.CENTER);
        fButtons.setWidthFull();
        // ------------------------------------------------------------------------------------------------

        // -----------------------------------------------------------------------------------------------
        // DIALOG LINEA ECOMMERCE
        // -----------------------------------------------------------------------------------------------
        // TITULO GENERAL
        // -----------------------------------------------------------------------------------------------
        lbdialog_titulo.getStyle().set("fontWeight", "bold");
        lbdialog_titulo.getStyle().set("fontSize", "150%");

        laydialog_titulo.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laydialog_titulo.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialog_titulo.setWidthFull();
        // ------------------------------------------------------------------------------------------------
        // NUEVO BANNER
        // -----------------------------------------------------------------------------------------------
        lbdialog_NImgTit.getStyle().set("fontWeight", "bold");
        lbdialog_NImgTit.getStyle().set("fontSize", "120%");

        laydialog_NImgTit.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laydialog_NImgTit.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialog_NImgTit.setWidthFull();

        // Titulo y subtitulo Imagen
        txtdialog_TLEcom.setWidthFull();

        txtdialog_SubtLEcom.setWidthFull();

        laydialog_TLEcom.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laydialog_TLEcom.setAlignItems(FlexComponent.Alignment.BASELINE);
        laydialog_TLEcom.setWidthFull();

        // Linea Ecommerce y Posicion

        cmbdialog_LEcom.setPlaceholder("Elija Linea Ecommerce");
        cmbdialog_LEcom.setWidthFull();
        cmbdialog_LEcom.addValueChangeListener(event -> {
            if (!event.getValue().contentEquals("No definida") || event.getValue() != null) {
                txtdialog_LEcom.setValue(event.getValue());
            } else
                txtdialog_LEcom.setValue("No definida");
        });

        txtdialog_LEcom.setReadOnly(true);
        txtdialog_LEcom.setWidthFull();
        txtdialog_LEcom.getStyle().set("fontWeight", "bold");

        txtdialog_PosLEcom.setReadOnly(true);
        txtdialog_PosLEcom.setWidthFull();
        txtdialog_PosLEcom.getStyle().set("fontWeight", "bold");

        laydialog_LEcom.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laydialog_LEcom.setAlignItems(FlexComponent.Alignment.BASELINE);
        laydialog_LEcom.setWidthFull();

        // Upload
        txtdialog_Upload.setWidthFull();

        laydialog_TUpEcom.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laydialog_TUpEcom.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialog_TUpEcom.setWidthFull();

        dialog_img.setVisible(true);
        dialog_img.setEnabled(true);
        dialog_img.setHeight("150px");
        dialog_img.setWidth("250px");

        laydialog_ImgUpEcom.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laydialog_ImgUpEcom.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialog_ImgUpEcom.setWidthFull();

        btndialog_Upload.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        btndialog_Upload.getStyle().set("fontSize", "90%");

        uploadLinea.setAutoUpload(true);
        uploadLinea.setDropAllowed(false);
        uploadLinea.setUploadButton(btndialog_Upload);
        // uploadLinea.setMaxFileSize(1030);

        laydialog_BUpEcom.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laydialog_BUpEcom.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialog_BUpEcom.setWidthFull();

        // Activar Imagen
        dialog_CheckActivation.setValue(Boolean.FALSE);
        /*
         * dialog_CheckActivation.addValueChangeListener(event->{
         * On_Click_CheckActivation(); });
         */

        laydialog_checkActivation.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laydialog_checkActivation.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialog_checkActivation.setWidthFull();

        // Botones Nueva Imagen
        btndialog_Guardar.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        btndialog_Guardar.getStyle().set("fontSize", "90%");

        laydialog_Btns.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laydialog_Btns.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialog_Btns.setWidthFull();
        // -----------------------------------------------------------------------------------------------
        // BANNER ACTIVO
        // -----------------------------------------------------------------------------------------------
        lbdialog2_LineasActTit.getStyle().set("fontWeight", "bold");
        lbdialog2_LineasActTit.getStyle().set("fontSize", "120%");

        laydialog2_LineasActTit.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laydialog2_LineasActTit.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialog2_LineasActTit.setWidthFull();

        // Titulo y subtitulo Imagen
        // txtdialog2_TLEcom.setReadOnly(true);
        txtdialog2_TLEcom.setWidthFull();
        // txtdialog2_SubtLEcom.setReadOnly(true);
        txtdialog2_SubtLEcom.setWidthFull();

        laydialog2_TLEcom.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laydialog2_TLEcom.setAlignItems(FlexComponent.Alignment.BASELINE);
        laydialog2_TLEcom.setWidthFull();

        // Linea Ecommerce y Posicion

        cmbdialog2_LEcom.setPlaceholder("Elija Linea Ecommerce");
        cmbdialog2_LEcom.setWidthFull();
        cmbdialog2_LEcom.addValueChangeListener(event -> {
            if (!event.getValue().contentEquals("No definida") || event.getValue() != null) {
                txtdialog2_LEcom.setValue(event.getValue());
            } else
                txtdialog2_LEcom.setValue("No definida");
        });

        txtdialog2_LEcom.setReadOnly(true);
        txtdialog2_LEcom.setWidthFull();
        txtdialog2_LEcom.getStyle().set("fontWeight", "bold");

        txtdialog2_PosLEcom.setReadOnly(true);
        txtdialog2_PosLEcom.setWidthFull();
        txtdialog2_PosLEcom.getStyle().set("fontWeight", "bold");

        laydialog2_LEcom.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laydialog2_LEcom.setAlignItems(FlexComponent.Alignment.BASELINE);
        laydialog2_LEcom.setWidthFull();

        // Upload

        btndialog2_BuscarAnterior.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        btndialog2_BuscarAnterior.getStyle().set("fontSize", "90%");
        btndialog2_BuscarSiguiente.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        btndialog2_BuscarSiguiente.getStyle().set("fontSize", "90%");

        dialog2_img.setVisible(true);
        dialog2_img.setEnabled(true);
        dialog2_img.setHeight("150px");
        dialog2_img.setWidth("250px");

        laydialog2_ImgUpEcom.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laydialog2_ImgUpEcom.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialog2_ImgUpEcom.setWidthFull();

        // Activado
        dialog2_CheckActivation.addAttachListener(event -> {
        });

        btndialog2_Confirm.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        btndialog2_Confirm.getStyle().set("fontSize", "90%");

        laydialog2_ActConfirm.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laydialog2_ActConfirm.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialog2_ActConfirm.setWidthFull();
        // -----------------------------------------------------------------------------------------------
        // Salir Pantalla
        btndialog_Cancel.addThemeVariants(ButtonVariant.LUMO_ERROR);
        btndialog_Cancel.getStyle().set("fontSize", "90%");

        laydialog_Salir.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laydialog_Salir.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialog_Salir.setWidthFull();
        // ------------------------------------------------------------------------------------------------------
        // LAYOUTS TOTALES

        laydialog_NImgTotal.getStyle().set("border", "1px solid #9E9E9E");
        laydialog_NImg_LAct.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laydialog_NImg_LAct.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialog_NImg_LAct.setWidthFull();

        laydialog_LActTotal.getStyle().set("border", "1px solid #9E9E9E");
        laydialog_LActTotal.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laydialog_LActTotal.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialog_LActTotal.setWidthFull();

        laydialog_Final.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laydialog_Final.setAlignItems(FlexComponent.Alignment.START);
        laydialog_Final.setWidthFull();
        // -----------------------------------------------------------------------------------------------

        // DIALOG PROPERTIES
        dialog_LineaEcommerce.setCloseOnEsc(false);
        dialog_LineaEcommerce.setCloseOnOutsideClick(false);

        // -----------------------------------------------------------------------------------------------
        // NOTIFICATION DIALOG LINEA ECOMMERCE

        // dialog_notf_is_Activated.getStyle().set("fontWeight","bold");
        dialog_notf_is_Activated.getStyle().set("fontSize", "90%");
        dialog_notf_is_Activated.getStyle().set("color", "red");

        notify_is_Activated.setDuration(3000);
        notify_is_Activated.setPosition(Position.MIDDLE);
        // -----------------------------------------------------------------------------------------------

        // dialog_notf_is_NotActivated.getStyle().set("fontWeight","bold");
        dialog_notf_is_NotActivated.getStyle().set("fontSize", "90%");
        dialog_notf_is_NotActivated.getStyle().set("color", "green");

        notify_is_NotActivated.setDuration(2500);
        notify_is_NotActivated.setPosition(Position.MIDDLE);
        // -----------------------------------------------------------------------------------------------
        // dialog_notf_is_PosibleActivated.getStyle().set("fontWeight","bold");
        dialog_notf_is_PosibleActivated.getStyle().set("fontSize", "90%");
        dialog_notf_is_PosibleActivated.getStyle().set("color", "green");

        notify_is_PosibleActivated.setDuration(2500);
        notify_is_PosibleActivated.setPosition(Position.MIDDLE);
        // -----------------------------------------------------------------------------------------------
        // dialog_notf_Guardado_Correct.getStyle().set("fontWeight","bold");
        dialog_notf_Guardado_Correct.getStyle().set("fontSize", "90%");
        dialog_notf_Guardado_Correct.getStyle().set("color", "green");

        notify_is_Guardado_Correct.setDuration(2500);
        notify_is_Guardado_Correct.setPosition(Position.MIDDLE);
        // -----------------------------------------------------------------------------------------------
    }

    // CPANEL Rutas
    public abstract void go_CPanel();

    public abstract void go_Clientes();

    public abstract void go_Subscriptores();

    public abstract void go_Promociones();

    public abstract void go_Cupones();

    public abstract void go_PuntosUP();

    public abstract void go_Pedidos();

    public abstract void go_LineasEcom();

    public abstract void go_Productos();

    // FUNCIONES
    public abstract void init_Sliders();

    // -----------------------------------------------------------------------------------------------
    // SLIDER NUEVO
    // -----------------------------------------------------------------------------------------------
    // Uploads
    public abstract void on_UploadSNew(SucceededEvent event);

    // Grabar Slider Nuevo
    public abstract void on_Grabar_SliderNew();

    // Descartar Imagen Slider Nuevo
    public abstract void on_Descartar_SliderNew();

    // -----------------------------------------------------------------------------------------------
    // SLIDER EXISTENTE
    // -----------------------------------------------------------------------------------------------
    // Uploads
    public abstract void on_UploadSExist(SucceededEvent event);

    // Actualizar Slider Existente
    public abstract void on_Grabar_SliderExist();

    // Descartar Slider Existente
    public abstract void on_Descartar_SliderExist();

    // Anterior Slider Existente
    public abstract void on_Anterior_SliderExist();

    // Siguiente Slider Existente
    public abstract void on_Siguiente_SliderExist();
    // -----------------------------------------------------------------------------------------------

    // -----------------------------------------------------------------------------------------------
    // DIALOG LINEA ECOMMERCE
    // -----------------------------------------------------------------------------------------------
    public abstract void init_Banners();

    // Open dialog
    public abstract void On_Open_dialog_Banner1();

    public abstract void On_Open_dialog_Banner2();

    public abstract void On_Open_dialog_Banner3();

    public abstract void On_Open_dialog_Banner4();

    public abstract void On_Open_dialog_Banner5();

    public abstract void On_Open_dialog_Banner6();

    public abstract void go_Index();

    // Upload New Image
    public abstract void on_UploadLinea_Ecom(SucceededEvent event);

    // New Image Functions
    // public abstract void On_Click_CheckActivation();
    public abstract void On_Click_GuardarCambios();

    // Linea Ecommerce Activadas
    // public abstract void On_Click_CmbsoloAct();
    public abstract void On_Click_BannerAnterior();

    public abstract void On_Click_BannerSiguiente();

    public abstract void On_Click_Confirmar_CheckAct();

    // Salir Dialog Banner
    public abstract void On_Verify_BannerAct();

    public abstract void refresh_Banners();

    // -----------------------------------------------------------------------------------------------

    private void initEvents() {
        init_Sliders();
        // -----------------------------------------------------------------------------------------------
        // CPANEL CABECERA
        // -----------------------------------------------------------------------------------------------
        btnClientes.addClickListener(e -> {
            removeAll();
            go_Clientes();
        });
        btnSubscriptores.addClickListener(e -> {
            removeAll();
            go_Subscriptores();
        });
        btnPromociones.addClickListener(e -> {
            removeAll();
            go_Promociones();
        });
        btnCupones.addClickListener(e -> {
            removeAll();
            go_Cupones();
        });
        btnPuntosUP.addClickListener(e -> {
            removeAll();
            go_PuntosUP();
        });
        // -----------------------------------------------------------------------------------------------
        btnPedidos.addClickListener(e -> {
            removeAll();
            go_Pedidos();
        });
        btnLineas.addClickListener(e -> {
            removeAll();
            go_LineasEcom();
        });
        btnProductos.addClickListener(e -> {
            removeAll();
            go_Productos();
        });
        btnEcomPage.addClickListener(e -> {
            removeAll();
            go_Index();
        });
        btnSalirCP.addClickListener(e -> {
            removeAll();
            // add(new App());
            go_CPanel();
        });
        // -----------------------------------------------------------------------------------------------
        // MAIN VIEW
        // -----------------------------------------------------------------------------------------------
        // Envía al Menu Principal - Panel de Control
        btnExit.addClickListener(e -> {
            removeAll();
            go_CPanel();
            // add(new CPanelView());
        });
        // -----------------------------------------------------------------------------------------------
        // SLIDER NUEVO
        // -----------------------------------------------------------------------------------------------
        // Upload
        uploadSNew.addSucceededListener(this::on_UploadSNew);
        // -----------------------------------------------------------------------------------------------
        // Grabar Slider Nuevo
        btnSNGuardar.addClickListener(e -> {
            on_Grabar_SliderNew();
            // notify_correct.open();
        });
        // -----------------------------------------------------------------------------------------------
        // Descartar Imagen Slider Nuevo
        btnSNUploadBorrar.addClickListener(e -> {
            on_Descartar_SliderNew();
        });
        // -----------------------------------------------------------------------------------------------
        // -----------------------------------------------------------------------------------------------
        // SLIDER EXISTENTE
        // -----------------------------------------------------------------------------------------------
        // Uploads
        uploadSExist.addSucceededListener(this::on_UploadSExist);
        // -----------------------------------------------------------------------------------------------
        // Actualizar Slider Existente
        btnSEGuardar.addClickListener(e -> {
            on_Grabar_SliderExist();
            // notify_correct.open();
        });
        // -----------------------------------------------------------------------------------------------
        // Descartar Slider Existente
        btnSEUploadBorrar.addClickListener(e -> {
            on_Descartar_SliderExist();
        });
        // -----------------------------------------------------------------------------------------------
        // Anterior Slider Existente
        btnSEAnterior.addClickListener(e -> {
            on_Anterior_SliderExist();
        });
        // -----------------------------------------------------------------------------------------------
        // Siguiente Slider Existente
        btnSESiguiente.addClickListener(e -> {
            on_Siguiente_SliderExist();
        });
        // -----------------------------------------------------------------------------------------------

        // -----------------------------------------------------------------------------------------------
        // DIALOG LINEA ECOMMERCE
        // -----------------------------------------------------------------------------------------------
        init_Banners();
        // -----------------------------------------------------------------------------------------------
        // Open Linea Ecom dialog
        btnLUpload1.addClickListener(e -> {
            On_Open_dialog_Banner1();
            dialog_LineaEcommerce.open();
        });
        // -----------------------------------------------------------------------------------------------
        btnLUpload2.addClickListener(e -> {
            On_Open_dialog_Banner2();
            dialog_LineaEcommerce.open();
        });
        // -----------------------------------------------------------------------------------------------
        btnLUpload3.addClickListener(e -> {
            On_Open_dialog_Banner3();
            dialog_LineaEcommerce.open();
        });
        // -----------------------------------------------------------------------------------------------
        btnLUpload4.addClickListener(e -> {
            On_Open_dialog_Banner4();
            dialog_LineaEcommerce.open();
        });
        // -----------------------------------------------------------------------------------------------
        btnLUpload5.addClickListener(e -> {
            On_Open_dialog_Banner5();
            dialog_LineaEcommerce.open();
        });
        // -----------------------------------------------------------------------------------------------
        btnLUpload6.addClickListener(e -> {
            On_Open_dialog_Banner6();
            dialog_LineaEcommerce.open();
        });
        // -----------------------------------------------------------------------------------------------
        // Upload
        uploadLinea.addSucceededListener(this::on_UploadLinea_Ecom);
        // -----------------------------------------------------------------------------------------------
        // Funcionalidad
        btndialog_Guardar.addClickListener(e -> {
            On_Click_GuardarCambios();
        });
        btndialog_Cancel.addClickListener(e -> {
            On_Verify_BannerAct();
            // dialog_LineaEcommerce.close();
        });
        // -----------------------------------------------------------------------------------------------
        // Lineas Ecommerce Activadas
        btndialog2_BuscarAnterior.addClickListener(e -> {
            On_Click_BannerAnterior();
        });
        btndialog2_BuscarSiguiente.addClickListener(e -> {
            On_Click_BannerSiguiente();
        });
        btndialog2_Confirm.addClickListener(e -> {
            On_Click_Confirmar_CheckAct();
        });
        // -----------------------------------------------------------------------------------------------

    }

}
