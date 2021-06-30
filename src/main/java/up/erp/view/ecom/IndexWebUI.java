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
 * @author Luis Aleman
 */
public abstract class IndexWebUI extends VerticalLayout {
    
    //CPANEL CABECERA
    public final Button btnClientes = new Button("Gestión Clientes", VaadinIcon.MALE.create());
    public final Button btnPedidos = new Button("Gestión Pedidos", VaadinIcon.CART_O.create());
    public final Button btnLineas = new Button("Gestión Lineas Ecommerce", VaadinIcon.RECORDS.create());
    public final Button btnProductos = new Button("Gestión Productos", VaadinIcon.PACKAGE.create());
    public final Button btnCupones = new Button("Gestión Cupones", VaadinIcon.TICKET.create());
    public final Button btnSalirCP = new Button("Salir del Panel de Control");
    
    public final HorizontalLayout layCPanelButtons = new HorizontalLayout(btnClientes,btnPedidos,btnLineas,btnProductos,btnCupones,btnSalirCP);
    //-----------------------------------------------------------------------------------------------
    // HEADER
    Label titulo = new Label("INDEX PAGINA E-COMMERCE");
    
    //Iconos
    public final Icon draw = VaadinIcon.MENU.create();

    //MenuBar
    public final MenuBar menuBar = new MenuBar();
    Text selected = new Text("");
    Div message = new Div();

    MenuItem ini = menuBar.addItem(draw);

    SubMenu iniSubMenu = ini.getSubMenu();
    MenuItem begining = iniSubMenu.addItem("Inicio");
    MenuItem closeAcct = iniSubMenu.addItem("Cerrar sesión");
    
    public final Span title = new Span("Bienvenido");
    public final HorizontalLayout head = new HorizontalLayout(titulo);
    public final HorizontalLayout header = new HorizontalLayout(menuBar,title);
    //-----------------------------------------------------------------------------------------------
    
    // WORKSPACE
    
    //HEAD BUFFER - UPLOAD
    
    //public final MemoryBuffer buffer = new MemoryBuffer();
    //public final Upload upexample = new Upload(buffer);
    //public final MultiFileMemoryBuffer bufferHead = new MultiFileMemoryBuffer();
    public final MemoryBuffer bufferHead = new MemoryBuffer();
    public final Upload uploadH1 = new Upload(bufferHead);
    //-----------------------------------------------------------------------------------------------
    
    //HEAD UI
    public final Label lbHeader = new Label("Cabecera");
    public final HorizontalLayout layCabecera = new HorizontalLayout(lbHeader);
    public final Label lbBody = new Label("Cuerpo");
    public final HorizontalLayout layCuerpo = new HorizontalLayout(lbBody);
    public final Label lbFoot = new Label("Pie de Pagina");
    public final HorizontalLayout layPie = new HorizontalLayout(lbFoot);
    //-----------------------------------------------------------------------------------------------
    
    //IMAGENES
    
    //IMAGEN 1
    public final Label lbHeadImage1 = new Label("Imagen 1");
    public final Icon upload1H_icon = VaadinIcon.UPLOAD.create();
    public final Icon delete1H_icon = VaadinIcon.CLOSE_CIRCLE_O.create();
    public final TextField txtHUpload1 = new TextField("");
    public final Button btnHUpload1 = new Button("Subir",upload1H_icon);
    public final Button btnHDeleteUp1 = new Button("Subir",delete1H_icon);
    //public final Image imgH1 = new Image("frontend/images/lenovo_1.png","lenovo 1");
    public final Image imgH1 = new Image();
    
    public final HorizontalLayout laylbHImg1 = new HorizontalLayout(lbHeadImage1);
    public final HorizontalLayout layHImg1 = new HorizontalLayout(imgH1);
    public final HorizontalLayout layHTxtImg1 = new HorizontalLayout(txtHUpload1);
    //public final HorizontalLayout layHUpImg1 = new HorizontalLayout(upexample);
    public final HorizontalLayout layHUpImg1 = new HorizontalLayout(uploadH1);
    public final VerticalLayout layHeadImg1 = new VerticalLayout(laylbHImg1,layHImg1,layHTxtImg1,layHUpImg1);
    
    //-----------------------------------------------------------------------------------------------
    
    //GRABAR - HEAD
    public final Icon save_head = VaadinIcon.CLOUD_DOWNLOAD.create();
    public final Button btnHSave = new Button("Grabar Cambios",save_head);
    public final HorizontalLayout layHSave = new HorizontalLayout(btnHSave);
    
    //LAYOUT - HEAD - PAGINA WEB
    public final HorizontalLayout layHeadImges = new HorizontalLayout(layHeadImg1);
    public final VerticalLayout layHeadPage = new VerticalLayout(layCabecera,layHeadImges);
    
    //-----------------------------------------------------------------------------------------------
    //BODY - BUFFERS
    
    //SLIDER
    public final MemoryBuffer bufferSlider1 = new MemoryBuffer();
    public final MemoryBuffer bufferSlider2 = new MemoryBuffer();
    public final MemoryBuffer bufferSlider3 = new MemoryBuffer();
    public final MemoryBuffer bufferSlider4 = new MemoryBuffer();
    
    public final Upload uploadS1 = new Upload(bufferSlider1);
    public final Upload uploadS2 = new Upload(bufferSlider2);
    public final Upload uploadS3 = new Upload(bufferSlider3);
    public final Upload uploadS4 = new Upload(bufferSlider4);
    //-----------------------------------------------------------------------------------------------
    
    //LINEA
    public final MemoryBuffer bufferLinea = new MemoryBuffer();
    public final Upload uploadLinea = new Upload(bufferLinea);
    //-----------------------------------------------------------------------------------------------
    
    //BODY - UI
    
    //SLIDER - UI
    
    public final Label tituloSlider = new Label("SLIDERS");
    public final HorizontalLayout laytituloSlider = new HorizontalLayout(tituloSlider);
    public final Label lbTituloSlider = new Label("Titulo para Slider:");
    public final TextField txtTituloSlider = new TextField("");
    public final HorizontalLayout layTSlider = new HorizontalLayout(lbTituloSlider,txtTituloSlider);
    
    public final Label lbSubtituloSlider = new Label("Subtitulo para Slider:");
    public final TextField txtSubtituloSlider = new TextField("");
    public final HorizontalLayout laySubtSlider = new HorizontalLayout(lbSubtituloSlider,txtSubtituloSlider);
    
    //IMAGEN 1
    public final Label lbBodyImage1 = new Label("SLIDER 1");
    public final Icon upload1B_icon = VaadinIcon.UPLOAD.create();
    public final TextField txtBUpload1 = new TextField("");
    public final Button btnBUpload1 = new Button("Subir Imagen");
    public final Image imgB1 = new Image();
    
    public final HorizontalLayout laylbBImg1 = new HorizontalLayout(lbBodyImage1);
    public final HorizontalLayout layBImg1 = new HorizontalLayout(imgB1);
    public final HorizontalLayout layBTxtImg1 = new HorizontalLayout(txtBUpload1);
    public final HorizontalLayout layBUpImg1 = new HorizontalLayout(uploadS1);
    public final VerticalLayout layBodyImg1 = new VerticalLayout(laylbBImg1,layBImg1,layBTxtImg1,layBUpImg1);
    
    //IMAGEN 2
    public final Label lbBodyImage2 = new Label("SLIDER 2");
    public final Icon upload2B_icon = VaadinIcon.UPLOAD.create();
    public final TextField txtBUpload2 = new TextField("");
    public final Button btnBUpload2 = new Button("Subir Imagen");
    public final Image imgB2 = new Image();
    
    public final HorizontalLayout laylbBImg2 = new HorizontalLayout(lbBodyImage2);
    public final HorizontalLayout layBImg2 = new HorizontalLayout(imgB2);
    public final HorizontalLayout layBTxtImg2 = new HorizontalLayout(txtBUpload2);
    public final HorizontalLayout layBUpImg2 = new HorizontalLayout(uploadS2);
    public final VerticalLayout layBodyImg2 = new VerticalLayout(laylbBImg2,layBImg2,layBTxtImg2,layBUpImg2);
    
    //IMAGEN 3
    public final Label lbBodyImage3 = new Label("SLIDER 3");
    public final Icon upload3B_icon = VaadinIcon.UPLOAD.create();
    public final TextField txtBUpload3 = new TextField("");
    public final Button btnBUpload3 = new Button("Subir Imagen");
    public final Image imgB3 = new Image();
    
    public final HorizontalLayout laylbBImg3 = new HorizontalLayout(lbBodyImage3);
    public final HorizontalLayout layBImg3 = new HorizontalLayout(imgB3);
    public final HorizontalLayout layBTxtImg3 = new HorizontalLayout(txtBUpload3);
    public final HorizontalLayout layBUpImg3 = new HorizontalLayout(uploadS3);
    public final VerticalLayout layBodyImg3 = new VerticalLayout(laylbBImg3,layBImg3,layBTxtImg3,layBUpImg3);
    
    //IMAGEN 4
    public final Label lbBodyImage4 = new Label("SLIDER 4");
    public final Icon upload4B_icon = VaadinIcon.UPLOAD.create();
    public final TextField txtBUpload4 = new TextField("");
    public final Button btnBUpload4 = new Button("Subir",upload4B_icon);
    public final Image imgB4 = new Image();
    
    public final HorizontalLayout laylbBImg4 = new HorizontalLayout(lbBodyImage4);
    public final HorizontalLayout layBImg4 = new HorizontalLayout(imgB4);
    public final HorizontalLayout layBTxtImg4 = new HorizontalLayout(txtBUpload4);
    public final HorizontalLayout layBUpImg4 = new HorizontalLayout(uploadS4);
    public final VerticalLayout layBodyImg4 = new VerticalLayout(laylbBImg4,layBImg4,layBTxtImg4,layBUpImg4);
    //-----------------------------------------------------------------------------------------------
    
    
    //BANNER - LINEAS - UI
    
    public final Label tituloLineas = new Label("BANNERS - LINEAS");
    public final HorizontalLayout laytituloLineas = new HorizontalLayout(tituloLineas);

    //BANNER 1
    public final Label lbLinea1Image = new Label("BANNER 1");
    public final TextField txtTituloLinea1 = new TextField("Titulo");
    public final TextField txtSubtituloLinea1 = new TextField("Subtitulo");
    public final TextField txtLEcom_Linea1 = new TextField("Linea Ecommerce");
    public final TextField txtPos_Linea1 = new TextField("Posicion");
    public final Button btnLUpload1 = new Button("Actualizar");
    public final Image imgL1 = new Image();
    
    public final HorizontalLayout laylbLImg1 = new HorizontalLayout(lbLinea1Image);
    public final HorizontalLayout layTLinea1 = new HorizontalLayout(txtTituloLinea1,txtSubtituloLinea1);
    public final HorizontalLayout layLEcomLinea1 = new HorizontalLayout(txtLEcom_Linea1,txtPos_Linea1);
    public final HorizontalLayout layLImg1 = new HorizontalLayout(imgL1);
    public final HorizontalLayout layBtnLinea1 = new HorizontalLayout(btnLUpload1);
    public final VerticalLayout layLineaImg1 = new VerticalLayout(laylbLImg1,layTLinea1,layLEcomLinea1,layLImg1,layBtnLinea1);
    
    //BANNER 2
    public final Label lbLinea2Image = new Label("BANNER 2");
    public final TextField txtTituloLinea2 = new TextField("Titulo");
    public final TextField txtSubtituloLinea2 = new TextField("Subtitulo");
    public final TextField txtLEcom_Linea2 = new TextField("Linea Ecommerce");
    public final TextField txtPos_Linea2 = new TextField("Posicion");
    public final Button btnLUpload2 = new Button("Actualizar");
    public final Image imgL2 = new Image();
    
    public final HorizontalLayout laylbLImg2 = new HorizontalLayout(lbLinea2Image);
    public final HorizontalLayout layTLinea2 = new HorizontalLayout(txtTituloLinea2,txtSubtituloLinea2);
    public final HorizontalLayout layLEcomLinea2 = new HorizontalLayout(txtLEcom_Linea2,txtPos_Linea2);
    public final HorizontalLayout layLImg2 = new HorizontalLayout(imgL2);
    public final HorizontalLayout layBtnLinea2 = new HorizontalLayout(btnLUpload2);
    public final VerticalLayout layLineaImg2 = new VerticalLayout(laylbLImg2,layTLinea2,layLEcomLinea2,layLImg2,layBtnLinea2);
    
    //BANNER 3
    public final Label lbLinea3Image = new Label("BANNER 3");
    public final TextField txtTituloLinea3 = new TextField("Titulo");
    public final TextField txtSubtituloLinea3 = new TextField("Subtitulo");
    public final TextField txtLEcom_Linea3 = new TextField("Linea Ecommerce");
    public final TextField txtPos_Linea3 = new TextField("Posicion");
    public final Button btnLUpload3 = new Button("Actualizar");
    public final Image imgL3 = new Image();
    
    public final HorizontalLayout laylbLImg3 = new HorizontalLayout(lbLinea3Image);
    public final HorizontalLayout layTLinea3 = new HorizontalLayout(txtTituloLinea3,txtSubtituloLinea3);
    public final HorizontalLayout layLEcomLinea3 = new HorizontalLayout(txtLEcom_Linea3,txtPos_Linea3);
    public final HorizontalLayout layLImg3 = new HorizontalLayout(imgL3);
    public final HorizontalLayout layBtnLinea3 = new HorizontalLayout(btnLUpload3);
    public final VerticalLayout layLineaImg3 = new VerticalLayout(laylbLImg3,layTLinea3,layLEcomLinea3,layLImg3,layBtnLinea3);
    
    //BANNER 4
    public final Label lbLinea4Image = new Label("BANNER 4");
    public final TextField txtTituloLinea4 = new TextField("Titulo");
    public final TextField txtSubtituloLinea4 = new TextField("Subtitulo");
    public final TextField txtLEcom_Linea4 = new TextField("Linea Ecommerce");
    public final TextField txtPos_Linea4 = new TextField("Posicion");
    public final Button btnLUpload4 = new Button("Actualizar");
    public final Image imgL4 = new Image();
    
    public final HorizontalLayout laylbLImg4 = new HorizontalLayout(lbLinea4Image);
    public final HorizontalLayout layTLinea4 = new HorizontalLayout(txtTituloLinea4,txtSubtituloLinea4);
    public final HorizontalLayout layLEcomLinea4 = new HorizontalLayout(txtLEcom_Linea4,txtPos_Linea4);
    public final HorizontalLayout layLImg4 = new HorizontalLayout(imgL4);
    public final HorizontalLayout layBtnLinea4 = new HorizontalLayout(btnLUpload4);
    public final VerticalLayout layLineaImg4 = new VerticalLayout(laylbLImg4,layTLinea4,layLEcomLinea4,layLImg4,layBtnLinea4);
    
    //BANNER 5
    public final Label lbLinea5Image = new Label("BANNER 5");
    public final TextField txtTituloLinea5 = new TextField("Titulo");
    public final TextField txtSubtituloLinea5 = new TextField("Subtitulo");
    public final TextField txtLEcom_Linea5 = new TextField("Linea Ecommerce");
    public final TextField txtPos_Linea5 = new TextField("Posicion");
    public final Button btnLUpload5 = new Button("Actualizar");
    public final Image imgL5 = new Image();
    
    public final HorizontalLayout laylbLImg5 = new HorizontalLayout(lbLinea5Image);
    public final HorizontalLayout layTLinea5 = new HorizontalLayout(txtTituloLinea5,txtSubtituloLinea5);
    public final HorizontalLayout layLEcomLinea5 = new HorizontalLayout(txtLEcom_Linea5,txtPos_Linea5);
    public final HorizontalLayout layLImg5 = new HorizontalLayout(imgL5);
    public final HorizontalLayout layBtnLinea5 = new HorizontalLayout(btnLUpload5);
    public final VerticalLayout layLineaImg5 = new VerticalLayout(laylbLImg5,layTLinea5,layLEcomLinea5,layLImg5,layBtnLinea5);
    
    //BANNER 6
    public final Label lbLinea6Image = new Label("BANNER 6");
    public final TextField txtTituloLinea6 = new TextField("Titulo");
    public final TextField txtSubtituloLinea6 = new TextField("Subtitulo");
    public final TextField txtLEcom_Linea6 = new TextField("Linea Ecommerce");
    public final TextField txtPos_Linea6 = new TextField("Posicion");
    public final Button btnLUpload6 = new Button("Actualizar");
    public final Image imgL6 = new Image();
    
    public final HorizontalLayout laylbLImg6 = new HorizontalLayout(lbLinea6Image);
    public final HorizontalLayout layTLinea6 = new HorizontalLayout(txtTituloLinea6,txtSubtituloLinea6);
    public final HorizontalLayout layLEcomLinea6 = new HorizontalLayout(txtLEcom_Linea6,txtPos_Linea6);
    public final HorizontalLayout layLImg6 = new HorizontalLayout(imgL6);
    public final HorizontalLayout layBtnLinea6 = new HorizontalLayout(btnLUpload6);
    public final VerticalLayout layLineaImg6 = new VerticalLayout(laylbLImg6,layTLinea6,layLEcomLinea6,layLImg6,layBtnLinea6);
    //---------------------------------------------------------------------------------------------------------------------------------
    
    //GRABAR - BODY
    public final Icon save_body = VaadinIcon.CLOUD_DOWNLOAD.create();
    public final Button btnBSave = new Button("Grabar Cambios",save_body);
    public final HorizontalLayout layBSave = new HorizontalLayout(btnBSave);
    
    //LAYOUT - BODY - PAGINA WEB
    public final HorizontalLayout layBodyImages = new HorizontalLayout(layBodyImg1,layBodyImg2,layBodyImg3);
    public final HorizontalLayout layLineaImages = new HorizontalLayout(layLineaImg1,layLineaImg2);
    public final HorizontalLayout layLineaImages2 = new HorizontalLayout(layLineaImg3,layLineaImg4);
    public final HorizontalLayout layLineaImages3 = new HorizontalLayout(layLineaImg5,layLineaImg6);
    
    //public final VerticalLayout layBodyPage = new VerticalLayout(layCuerpo,laytituloSlider,layTSlider,laySubtSlider,layBodyImages,laytituloLineas,layLineaImages);
    public final VerticalLayout layBodyPage = new VerticalLayout(laytituloSlider,layBodyImages);
    public final VerticalLayout layBodyPage2 = new VerticalLayout(laytituloLineas,layLineaImages,layLineaImages2,layLineaImages3);
    //-----------------------------------------------------------------------------------------------
    
    
    //FOOT - BUFFERS
    
    public final MemoryBuffer bufferFoot = new MemoryBuffer();
    public final Upload uploadF1 = new Upload(bufferFoot);
    //-----------------------------------------------------------------------------------------------
    
    //FOOT - UI
    public final Label lbTituloFoot = new Label("Titulo para Footer:");
    public final TextField txtTituloFoot = new TextField("");
    public final HorizontalLayout layTFoot = new HorizontalLayout(lbTituloFoot,txtTituloFoot);
    
    public final Label lbAreaFoot = new Label("Contenido para Foot:");
    public final TextArea txtAreaFoot = new TextArea("");
    public final HorizontalLayout layAFoot = new HorizontalLayout(lbAreaFoot,txtAreaFoot);
    
    //-----------------------------------------------------------------------------------------------
    
    //FOOT IMAGEN
    
    //IMAGEN 1
    public final Label lbFootImage1 = new Label("Imagen 1");
    public final Icon upload1F_icon = VaadinIcon.UPLOAD.create();
    public final TextField txtFUpload1 = new TextField("");
    public final Button btnFUpload1 = new Button("Subir",upload1F_icon);
    public final Image imgF1 = new Image();
    
    public final HorizontalLayout laylbFImg1 = new HorizontalLayout(lbFootImage1);
    public final HorizontalLayout layFImg1 = new HorizontalLayout(imgF1);
    public final HorizontalLayout layFTxtImg1 = new HorizontalLayout(txtFUpload1);
    public final HorizontalLayout layFUpImg1 = new HorizontalLayout(uploadF1);
    public final VerticalLayout layFootImg1 = new VerticalLayout(laylbFImg1,layFImg1,layFTxtImg1,layFUpImg1);
    //-----------------------------------------------------------------------------------------------
    
    //GRABAR - FOOT
    public final Icon save_foot = VaadinIcon.CLOUD_DOWNLOAD.create();
    public final Button btnFSave = new Button("Guardar Cambios");
    public final HorizontalLayout layFSave = new HorizontalLayout(btnFSave);
    
    //LAYOUT - FOOT - PAGINA WEB
    public final HorizontalLayout layFootImges = new HorizontalLayout(layFootImg1);
    //public final VerticalLayout layFootPage = new VerticalLayout(layPie,layTFoot,layAFoot,layFootImges,layFSave);
    public final VerticalLayout layFootPage = new VerticalLayout(layFSave);
    //-----------------------------------------------------------------------------------------------
    
    //NOTIFICATION
    public final Label upd_notf_correct = new Label("Imagen(es) Actualizada(s) Correctamente");
    public final Label upd_notf_incorrect = new Label("Imagen(es) Actualizada(s) Incorrectamente");
    
    public final Notification notify_correct = new Notification(upd_notf_correct);
    //-----------------------------------------------------------------------------------------------
    
    //BOTONES ADICIONALES
    //Iconos
    public final Icon exit = VaadinIcon.EXIT.create();
    public final Button btnExit = new Button("Salir",exit);
    
    public final HorizontalLayout fButtons = new HorizontalLayout(btnExit);
    
    //-----------------------------------------------------------------------------------------------
    //DIALOG BANNER - LINEA ECOMMERCE
    
    //TITULO GENERAL
    public final Label lbdialog_titulo = new Label("INDEX LINEA E-COMMERCE");
    public final HorizontalLayout laydialog_titulo  = new HorizontalLayout(lbdialog_titulo);
    //-----------------------------------------------------------------------------------------------
    
    //NUEVO BANNER
    
    public final Label lbdialog_NImgTit = new Label("NUEVO BANNER");
    public final HorizontalLayout laydialog_NImgTit  = new HorizontalLayout(lbdialog_NImgTit);
    
    //Titulo y subtitulo Imagen
    public final TextField txtdialog_TLEcom = new TextField("Titulo");
    public final TextField txtdialog_SubtLEcom = new TextField("Subitulo");
    public final HorizontalLayout laydialog_TLEcom = new HorizontalLayout(txtdialog_TLEcom,txtdialog_SubtLEcom);
    
    //Linea Ecommerce y Posicion
    public final ComboBox<String> cmbdialog_LEcom = new ComboBox("Linea E-commerce");
    public final TextField txtdialog_LEcom = new TextField("Linea Ecommerce");
    public final TextField txtdialog_PosLEcom = new TextField("Posicion");
    public final HorizontalLayout laydialog_LEcom = new HorizontalLayout(cmbdialog_LEcom,txtdialog_LEcom,txtdialog_PosLEcom);
    
    //Upload
    public final TextField txtdialog_Upload = new TextField("Ruta Imagen");
    public final HorizontalLayout laydialog_TUpEcom = new HorizontalLayout(txtdialog_Upload);
    
    public final Image dialog_img = new Image();
    public final HorizontalLayout laydialog_ImgUpEcom = new HorizontalLayout(dialog_img);
    
    public final Button btndialog_Upload = new Button("Subir Nueva Imagen");
    public final HorizontalLayout laydialog_BUpEcom = new HorizontalLayout(uploadLinea);
    
    //Activar Imagen
    public final Label lbdialog_CheckActivation = new Label("Activar?");
    public final Checkbox dialog_CheckActivation = new Checkbox();
    public final HorizontalLayout laydialog_checkActivation = new HorizontalLayout(lbdialog_CheckActivation,dialog_CheckActivation);
    
    //Botones Nueva Imagen
    public final Button btndialog_Guardar = new Button("Guardar Cambios");
    public final HorizontalLayout laydialog_Btns = new HorizontalLayout(btndialog_Guardar);
    
    //LAYOUT TOTAL NUEVA IMAGEN
    public final VerticalLayout laydialog_NImgTotal = new VerticalLayout(lbdialog_NImgTit,laydialog_TLEcom,laydialog_LEcom,
                                                      laydialog_TUpEcom,laydialog_ImgUpEcom,laydialog_BUpEcom,laydialog_checkActivation,laydialog_Btns);
    //------------------------------------------------------------------------------------------------------
    
    //BANNER ACTIVO
    
    public final TextField txtdialog2_TitPos =  new TextField("");
    public final Label lbdialog2_LineasActTit = new Label("BANCO DE IMAGENES DE BANNERS");
    public final HorizontalLayout laydialog2_LineasActTit  = new HorizontalLayout(lbdialog2_LineasActTit);
    
    //Titulo y subtitulo Imagen
    public final TextField txtdialog2_TLEcom = new TextField("Titulo");
    public final TextField txtdialog2_SubtLEcom = new TextField("Subitulo");
    public final HorizontalLayout laydialog2_TLEcom = new HorizontalLayout(txtdialog2_TLEcom,txtdialog2_SubtLEcom);
    
     //Linea Ecommerce y Posicion
    public final ComboBox<String> cmbdialog2_LEcom = new ComboBox("Linea E-commerce");
    public final TextField txtdialog2_LEcom = new TextField("Linea Ecommerce");
    public final TextField txtdialog2_PosLEcom = new TextField("Posicion");
    public final HorizontalLayout laydialog2_LEcom = new HorizontalLayout(cmbdialog2_LEcom,txtdialog2_LEcom,txtdialog2_PosLEcom);
    
    //Linea Ecommerce y Posicion
    //public final ComboBox<String> cmbdialog2_LEcom = new ComboBox("Linea E-commerce");
    //public final TextField txtdialog2_LEcom = new TextField("Linea Ecommerce");
    //public final TextField txtdialog2_PosLEcom = new TextField("Posicion");
    //public final Button btndialog2_BuscarLE = new Button("Buscar Banner Activo");
    //public final HorizontalLayout laydialog2_LEcom = new HorizontalLayout(txtdialog2_LEcom,txtdialog2_PosLEcom);
    
    //Upload
    public final Image dialog2_img = new Image();
    public final Button btndialog2_BuscarAnterior = new Button("Anterior");
    public final Button btndialog2_BuscarSiguiente = new Button("Siguiente");
    public final HorizontalLayout laydialog2_ImgUpEcom = new HorizontalLayout(btndialog2_BuscarAnterior,dialog2_img,btndialog2_BuscarSiguiente);
    
    //Activado
    public final Label lbdialog2_CheckActivation = new Label("Está Activo?");
    public final Checkbox dialog2_CheckActivation = new Checkbox();
    public final Button btndialog2_Confirm = new Button("Confirmar Cambio");
    public final HorizontalLayout laydialog2_ActConfirm = new HorizontalLayout(lbdialog2_CheckActivation,dialog2_CheckActivation,btndialog2_Confirm);
    
    //LAYOUT TOTAL LINEAS ACTIVAS
    public final VerticalLayout laydialog_LActTotal = new VerticalLayout(laydialog2_LineasActTit,laydialog2_TLEcom,laydialog2_LEcom,
                                                      laydialog2_ImgUpEcom,laydialog2_ActConfirm);
    //------------------------------------------------------------------------------------------------------
    //Salir Pantalla
    public final Button btndialog_Cancel = new Button("Salir Pantalla");
    public final HorizontalLayout laydialog_Salir = new HorizontalLayout(btndialog_Cancel);
    //------------------------------------------------------------------------------------------------------
    
    //LAYOUTS FINALES
    public final HorizontalLayout laydialog_NImg_LAct = new HorizontalLayout(laydialog_NImgTotal,laydialog_LActTotal);
    
    public final VerticalLayout laydialog_Final = new VerticalLayout(laydialog_titulo,laydialog_NImg_LAct,laydialog_Salir);
    
    public final Dialog dialog_LineaEcommerce = new Dialog(laydialog_Final);
    
    //-----------------------------------------------------------------------------------------------
    //NOTIFICATION DIALOG LINEA ECOMMERCE
    public final Label dialog_notf_is_Activated = new Label("El Banner seleccionado ya se encuentra activado para esa posicion, si desea activar este Banner por favor desactivar el activo");
    public final Label dialog_notf_is_NotActivated = new Label("El Banner seleccionado se ha desactivado para esa posicion");
    public final Label dialog_notf_is_PosibleActivated = new Label("El Banner seleccionado si puede activarse para esa posicion");
    public final Label dialog_notf_Guardado_Correct = new Label("El Banner se ha guardado satisfactoriamente");
    
    public final Notification notify_is_Activated = new Notification(dialog_notf_is_Activated);
    public final Notification notify_is_NotActivated = new Notification(dialog_notf_is_NotActivated);
    public final Notification notify_is_PosibleActivated = new Notification(dialog_notf_is_PosibleActivated);
    public final Notification notify_is_Guardado_Correct = new Notification(dialog_notf_Guardado_Correct);
    //-----------------------------------------------------------------------------------------------
    public IndexWebUI() {
   
        //add(head, header, layHeadPage, layBodyPage, layFootPage,fButtons);
        removeAll();
        add(layCPanelButtons,head, layBodyPage, layFootPage, layBodyPage2, fButtons);
        initStyles();
        initEvents();
    }
    
    private void initStyles() {
        
        //CABECERA CPANEL
        btnClientes.setWidthFull();
        btnClientes.getStyle().set("fontSize","80%");
        //------------------------------------------------------------------------------------------------
        btnPedidos.setWidthFull();
        btnPedidos.getStyle().set("fontSize","80%");
        //------------------------------------------------------------------------------------------------
        btnProductos.setWidthFull();
        btnProductos.getStyle().set("fontSize","80%");
        //------------------------------------------------------------------------------------------------
        btnLineas.setWidthFull();
        btnLineas.getStyle().set("fontSize","80%");
        //------------------------------------------------------------------------------------------------
        btnCupones.setWidthFull();
        btnCupones.getStyle().set("fontSize","80%");
        //------------------------------------------------------------------------------------------------ 
        btnSalirCP.addThemeVariants(ButtonVariant.LUMO_ERROR);
        btnSalirCP.getStyle().set("fontSize","80%");
        btnSalirCP.setWidthFull();
        //------------------------------------------------------------------------------------------------
        layCPanelButtons.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        layCPanelButtons.setWidthFull();
        //-----------------------------------------------------------------------------------------------
        
        //HEADER
        titulo.getStyle().set("fontWeight","bold");
        titulo.getStyle().set("fontSize","300%");
        head.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        head.setWidthFull();

        header.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        header.setWidthFull();
        //-----------------------------------------------------------------------------------------------
        
        //WORKSPACE

        //1) HEAD - PAGE
        //TITULO - HEAD
        lbHeader.getStyle().set("fontWeight","bold");
        lbHeader.getStyle().set("fontSize","200%");

        layCabecera.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        layCabecera.setAlignItems(FlexComponent.Alignment.CENTER);
        layCabecera.setWidthFull();
        //-----------------------------------------------------------------------------------------------
        
        //UPLOAD - HEAD

        uploadH1.setAutoUpload(true);
        uploadH1.setDropAllowed(false);
        uploadH1.setUploadButton(btnHUpload1);
        //-----------------------------------------------------------------------------------------------
        
        //IMAGENES - HEAD
        imgH1.setVisible(true);
        imgH1.setEnabled(true);
        imgH1.setHeight("150px");
        imgH1.setWidth("250px");
        //-----------------------------------------------------------------------------------------------

        //UPLOAD - BODY
        
        //SLIDER
        
        uploadS1.setAutoUpload(true);
        uploadS1.setDropAllowed(false);
        uploadS1.setUploadButton(btnBUpload1);
        
        btnBUpload1.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        btnBUpload1.getStyle().set("fontSize","90%");
        //uploadS1.setAcceptedFileTypes("image/jpg","image/jpeg", "image/png", "image/gif");

        uploadS2.setAutoUpload(true);
        uploadS2.setDropAllowed(false);
        uploadS2.setUploadButton(btnBUpload2);
        
        btnBUpload2.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        btnBUpload2.getStyle().set("fontSize","90%");

        uploadS3.setAutoUpload(true);
        uploadS3.setDropAllowed(false);
        uploadS3.setUploadButton(btnBUpload3);
        
        btnBUpload3.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        btnBUpload3.getStyle().set("fontSize","90%");
        
        uploadS4.setAutoUpload(true);
        uploadS4.setDropAllowed(false);
        uploadS4.setUploadButton(btnBUpload4);
        
        btnBUpload4.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        btnBUpload4.getStyle().set("fontSize","90%");
        //-----------------------------------------------------------------------------------------------
        
        //IMAGENES - BODY
        
        //SLIDER 1
        imgB1.setVisible(true);
        imgB1.setEnabled(true);
        imgB1.setHeight("150px");
        imgB1.setWidth("250px");

        //SLIDER 2
        imgB2.setVisible(true);
        imgB2.setEnabled(true);
        imgB2.setHeight("150px");
        imgB2.setWidth("250px");

        //SLIDER 3
        imgB3.setVisible(true);
        imgB3.setEnabled(true);
        imgB3.setHeight("150px");
        imgB3.setWidth("250px");
        
        //SLIDER 4
        imgB4.setVisible(true);
        imgB4.setEnabled(true);
        imgB4.setHeight("150px");
        imgB4.setWidth("250px");
        //-----------------------------------------------------------------------------------------------
        
        //LINEA 1
        imgL1.setVisible(true);
        imgL1.setEnabled(true);
        imgL1.setHeight("150px");
        imgL1.setWidth("250px");
        
        //LINEA 2
        imgL2.setVisible(true);
        imgL2.setEnabled(true);
        imgL2.setHeight("150px");
        imgL2.setWidth("250px");

        //LINEA 3
        imgL3.setVisible(true);
        imgL3.setEnabled(true);
        imgL3.setHeight("150px");
        imgL3.setWidth("250px");
        
        //LINEA 4
        imgL4.setVisible(true);
        imgL4.setEnabled(true);
        imgL4.setHeight("150px");
        imgL4.setWidth("250px");
        
        //LINEA 5
        imgL5.setVisible(true);
        imgL5.setEnabled(true);
        imgL5.setHeight("150px");
        imgL5.setWidth("250px");
        
        //LINEA 6
        imgL6.setVisible(true);
        imgL6.setEnabled(true);
        imgL6.setHeight("150px");
        imgL6.setWidth("250px");
        //-----------------------------------------------------------------------------------------------

        //UPLOAD - FOOT
        uploadF1.setAutoUpload(true);
        uploadF1.setDropAllowed(false);
        uploadF1.setUploadButton(btnFUpload1);
        //-----------------------------------------------------------------------------------------------
        
        //IMAGENES - FOOT
        imgF1.setVisible(true);
        imgF1.setEnabled(true);
        imgF1.setHeight("150px");
        imgF1.setWidth("250px");
        //-----------------------------------------------------------------------------------------------
        
        
        
        //LAYOUTS - HEAD
        
        // IMAGE 1
        laylbHImg1.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laylbHImg1.setAlignItems(FlexComponent.Alignment.CENTER);
        laylbHImg1.setWidthFull();

        layHImg1.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layHImg1.setAlignItems(FlexComponent.Alignment.CENTER);
        layHImg1.setWidthFull();

        layHTxtImg1.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layHTxtImg1.setAlignItems(FlexComponent.Alignment.CENTER);
        layHTxtImg1.setWidthFull();

        layHUpImg1.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layHUpImg1.setAlignItems(FlexComponent.Alignment.CENTER);
        layHUpImg1.setWidthFull();

        layHeadImg1.getStyle().set("border", "1px solid #9E9E9E");
        layHeadImg1.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layHeadImg1.setAlignItems(FlexComponent.Alignment.CENTER);
        layHeadImg1.setWidthFull();
        //-----------------------------------------------------------------------------------------------

        //ALL LAYOUT - HEAD
        layHeadPage.getStyle().set("border", "1px solid #9E9E9E");
        layHeadPage.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layHeadPage.setAlignItems(FlexComponent.Alignment.CENTER);
        layHeadPage.setWidthFull();
        //-----------------------------------------------------------------------------------------------
        
        
        //2) BODY - PAGE
        //TITULO - BODY
        lbBody.getStyle().set("fontWeight","bold");
        lbBody.getStyle().set("fontSize","200%");

        tituloSlider.getStyle().set("fontWeight","bold");
        tituloSlider.getStyle().set("fontSize","150%");

        tituloLineas.getStyle().set("fontWeight","bold");
        tituloLineas.getStyle().set("fontSize","150%");

        layCuerpo.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        layCuerpo.setAlignItems(FlexComponent.Alignment.CENTER);
        layCuerpo.setWidthFull();

        laytituloSlider.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laytituloSlider.setAlignItems(FlexComponent.Alignment.CENTER);
        laytituloSlider.setWidthFull();

        laytituloLineas.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laytituloLineas.setAlignItems(FlexComponent.Alignment.CENTER);
        laytituloLineas.setWidthFull();
        //-----------------------------------------------------------------------------------------------
        
        //LAYOUTS - BODY
        
        //SLIDER - UI
        layTSlider.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layTSlider.setAlignItems(FlexComponent.Alignment.CENTER);
        layTSlider.setWidthFull();

        laySubtSlider.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laySubtSlider.setAlignItems(FlexComponent.Alignment.CENTER);
        laySubtSlider.setWidthFull();
        //-----------------------------------------------------------------------------------------------
        //SLIDER 1
        laylbBImg1.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laylbBImg1.setAlignItems(FlexComponent.Alignment.CENTER);
        laylbBImg1.setWidthFull();

        layBImg1.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layBImg1.setAlignItems(FlexComponent.Alignment.CENTER);
        layBImg1.setWidthFull();

        layBTxtImg1.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layBTxtImg1.setAlignItems(FlexComponent.Alignment.CENTER);
        layBTxtImg1.setWidthFull();

        layBUpImg1.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layBUpImg1.setAlignItems(FlexComponent.Alignment.CENTER);
        layBUpImg1.setWidthFull();

        layBodyImg1.getStyle().set("border", "1px solid #9E9E9E");
        layBodyImg1.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layBodyImg1.setAlignItems(FlexComponent.Alignment.CENTER);
        layBodyImg1.setWidthFull();

        // SLIDER 2
        laylbBImg2.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laylbBImg2.setAlignItems(FlexComponent.Alignment.CENTER);
        laylbBImg2.setWidthFull();

        layBImg2.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layBImg2.setAlignItems(FlexComponent.Alignment.CENTER);
        layBImg2.setWidthFull();

        layBTxtImg2.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layBTxtImg2.setAlignItems(FlexComponent.Alignment.CENTER);
        layBTxtImg2.setWidthFull();

        layBUpImg2.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layBUpImg2.setAlignItems(FlexComponent.Alignment.CENTER);
        layBUpImg2.setWidthFull();

        layBodyImg2.getStyle().set("border", "1px solid #9E9E9E");
        layBodyImg2.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layBodyImg2.setAlignItems(FlexComponent.Alignment.CENTER);
        layBodyImg2.setWidthFull();

        // SLIDER 3
        laylbBImg3.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laylbBImg3.setAlignItems(FlexComponent.Alignment.CENTER);
        laylbBImg3.setWidthFull();

        layBImg3.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layBImg3.setAlignItems(FlexComponent.Alignment.CENTER);
        layBImg3.setWidthFull();

        layBTxtImg3.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layBTxtImg3.setAlignItems(FlexComponent.Alignment.CENTER);
        layBTxtImg3.setWidthFull();

        layBUpImg3.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layBUpImg3.setAlignItems(FlexComponent.Alignment.CENTER);
        layBUpImg3.setWidthFull();

        layBodyImg3.getStyle().set("border", "1px solid #9E9E9E");
        layBodyImg3.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layBodyImg3.setAlignItems(FlexComponent.Alignment.CENTER);
        layBodyImg3.setWidthFull();
        
        // SLIDER 4
        laylbBImg4.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laylbBImg4.setAlignItems(FlexComponent.Alignment.CENTER);
        laylbBImg4.setWidthFull();

        layBImg4.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layBImg4.setAlignItems(FlexComponent.Alignment.CENTER);
        layBImg4.setWidthFull();

        layBTxtImg4.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layBTxtImg4.setAlignItems(FlexComponent.Alignment.CENTER);
        layBTxtImg4.setWidthFull();

        layBUpImg4.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layBUpImg4.setAlignItems(FlexComponent.Alignment.CENTER);
        layBUpImg4.setWidthFull();

        layBodyImg4.getStyle().set("border", "1px solid #9E9E9E");
        layBodyImg4.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layBodyImg4.setAlignItems(FlexComponent.Alignment.CENTER);
        layBodyImg4.setWidthFull();
        //-----------------------------------------------------------------------------------------------

        //LINEAS
        
        // LINEA 1
        
        //Variables
        
        txtTituloLinea1.setReadOnly(true);
        txtTituloLinea1.setWidthFull();
        txtSubtituloLinea1 .setReadOnly(true);
        txtSubtituloLinea1.setWidthFull();
        txtLEcom_Linea1 .setReadOnly(true);
        txtLEcom_Linea1.setWidthFull();
        txtPos_Linea1.setReadOnly(true);
        txtPos_Linea1.setWidthFull();
        btnLUpload1.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        btnLUpload1.getStyle().set("fontSize","90%");
        
        //Layouts
        
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
        //-----------------------------------------------------------------------------------------------
    
        // BANNER 1
        
        //Variables
        
        txtTituloLinea1.setReadOnly(true);
        txtTituloLinea1.getStyle().set("fontWeight","bold");
        txtTituloLinea1.setWidthFull();
        txtSubtituloLinea1.setReadOnly(true);
        txtSubtituloLinea1.setWidthFull();
        txtLEcom_Linea1.setReadOnly(true);
        txtLEcom_Linea1.setWidthFull();
        txtPos_Linea1.setReadOnly(true);
        txtPos_Linea1.setWidthFull();
        btnLUpload1.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        btnLUpload1.getStyle().set("fontSize","90%");
        
        //Layouts
        
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
        //-----------------------------------------------------------------------------------------------
        
        // BANNER 2
        
        //Variables
        
        txtTituloLinea2.setReadOnly(true);
        txtTituloLinea2.getStyle().set("fontWeight","bold");
        txtTituloLinea2.setWidthFull();
        txtSubtituloLinea2.setReadOnly(true);
        txtSubtituloLinea2.setWidthFull();
        txtLEcom_Linea2.setReadOnly(true);
        txtLEcom_Linea2.setWidthFull();
        txtPos_Linea2.setReadOnly(true);
        txtPos_Linea2.setWidthFull();
        btnLUpload2.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        btnLUpload2.getStyle().set("fontSize","90%");
        
        //Layouts
        
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
        //-----------------------------------------------------------------------------------------------
        
        // BANNER 3
        
        //Variables
        
        txtTituloLinea3.setReadOnly(true);
        txtTituloLinea3.getStyle().set("fontWeight","bold");
        txtTituloLinea3.setWidthFull();
        txtSubtituloLinea3.setReadOnly(true);
        txtSubtituloLinea3.setWidthFull();
        txtLEcom_Linea3.setReadOnly(true);
        txtLEcom_Linea3.setWidthFull();
        txtPos_Linea3.setReadOnly(true);
        txtPos_Linea3.setWidthFull();
        btnLUpload3.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        btnLUpload3.getStyle().set("fontSize","90%");
        
        //Layouts
        
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
        //-----------------------------------------------------------------------------------------------
        
        // BANNER 4
        
        //Variables
        
        txtTituloLinea4.setReadOnly(true);
        txtTituloLinea4.getStyle().set("fontWeight","bold");
        txtTituloLinea4.setWidthFull();
        txtSubtituloLinea4.setReadOnly(true);
        txtSubtituloLinea4.setWidthFull();
        txtLEcom_Linea4.setReadOnly(true);
        txtLEcom_Linea4.setWidthFull();
        txtPos_Linea4.setReadOnly(true);
        txtPos_Linea4.setWidthFull();
        btnLUpload4.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        btnLUpload4.getStyle().set("fontSize","90%");
        
        //Layouts
        
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
        //-----------------------------------------------------------------------------------------------

        // BANNER 5
        
        //Variables
        
        txtTituloLinea5.setReadOnly(true);
        txtTituloLinea5.getStyle().set("fontWeight","bold");
        txtTituloLinea5.setWidthFull();
        txtSubtituloLinea5.setReadOnly(true);
        txtSubtituloLinea5.setWidthFull();
        txtLEcom_Linea5.setReadOnly(true);
        txtLEcom_Linea5.setWidthFull();
        txtPos_Linea5.setReadOnly(true);
        txtPos_Linea5.setWidthFull();
        btnLUpload5.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        btnLUpload5.getStyle().set("fontSize","90%");
        
        //Layouts
        
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
        //-----------------------------------------------------------------------------------------------
        
        // BANNER 6
        
        //Variables
        
        txtTituloLinea6.setReadOnly(true);
        txtTituloLinea6.getStyle().set("fontWeight","bold");
        txtTituloLinea6.setWidthFull();
        txtSubtituloLinea6.setReadOnly(true);
        txtSubtituloLinea6.setWidthFull();
        txtLEcom_Linea6.setReadOnly(true);
        txtLEcom_Linea6.setWidthFull();
        txtPos_Linea6.setReadOnly(true);
        txtPos_Linea6.setWidthFull();
        btnLUpload6.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        btnLUpload6.getStyle().set("fontSize","90%");
        
        //Layouts
        
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
        //-----------------------------------------------------------------------------------------------
        
        //LAYOUTS LINEAS
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
        
        //ALL LAYOUT - BODY
        layBodyPage.getStyle().set("border", "1px solid #9E9E9E");
        layBodyPage.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layBodyPage.setAlignItems(FlexComponent.Alignment.CENTER);
        layBodyPage.setWidthFull();
        
        layBodyPage2.getStyle().set("border", "1px solid #9E9E9E");
        layBodyPage2.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layBodyPage2.setAlignItems(FlexComponent.Alignment.CENTER);
        layBodyPage2.setWidthFull();
        
        //-----------------------------------------------------------------------------------------------
        
        //3) FOOT - PAGE
        //TITULO - FOOT
        lbFoot.getStyle().set("fontWeight","bold");
        lbFoot.getStyle().set("fontSize","200%");

        layPie.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        layPie.setAlignItems(FlexComponent.Alignment.CENTER);
        layPie.setWidthFull();

        //LAYOUTS - BODY
        // IMAGE 1
        laylbFImg1.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laylbFImg1.setAlignItems(FlexComponent.Alignment.CENTER);
        laylbFImg1.setWidthFull();

        layFImg1.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layFImg1.setAlignItems(FlexComponent.Alignment.CENTER);
        layFImg1.setWidthFull();

        layFTxtImg1.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layFTxtImg1.setAlignItems(FlexComponent.Alignment.CENTER);
        layFTxtImg1.setWidthFull();

        layFUpImg1.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layFUpImg1.setAlignItems(FlexComponent.Alignment.CENTER);
        layFUpImg1.setWidthFull();

        layFootImg1.getStyle().set("border", "1px solid #9E9E9E");
        layFootImg1.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layFootImg1.setAlignItems(FlexComponent.Alignment.CENTER);
        layFootImg1.setWidthFull();

        //ALL LAYOUT - FOOT
        layFootPage.getStyle().set("border", "1px solid #9E9E9E");
        layFootPage.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layFootPage.setAlignItems(FlexComponent.Alignment.CENTER);
        layFootPage.setWidthFull();

        //LAYOUT GRABAR
        layFSave.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layFSave.setAlignItems(FlexComponent.Alignment.CENTER);
        layFSave.setWidthFull();

        //NOTIFICATION
        notify_correct.setDuration(1000);
        notify_correct.setPosition(Position.MIDDLE);

        //FOOTER
        btnFSave.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        btnFSave.getStyle().set("fontSize","90%");
        
        fButtons.getStyle().set("border", "1px solid #9E9E9E");
        fButtons.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        fButtons.setAlignItems(FlexComponent.Alignment.CENTER);
        fButtons.setWidthFull();
        
        //------------------------------------------------------------------------------------------------
        //DIALOG LINEA ECOMMERCE
    
        //TITULO GENERAL
         
        lbdialog_titulo.getStyle().set("fontWeight","bold");
        lbdialog_titulo.getStyle().set("fontSize","150%");
         
        laydialog_titulo.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laydialog_titulo.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialog_titulo.setWidthFull(); 
        //------------------------------------------------------------------------------------------------
        
        //NUEVO BANNER
    
        lbdialog_NImgTit.getStyle().set("fontWeight","bold");     
        lbdialog_NImgTit.getStyle().set("fontSize","120%");
                
        laydialog_NImgTit.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laydialog_NImgTit.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialog_NImgTit.setWidthFull(); 
    
        //Titulo y subtitulo Imagen
        txtdialog_TLEcom.setWidthFull();
        
        txtdialog_SubtLEcom.setWidthFull();
        
        laydialog_TLEcom.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laydialog_TLEcom.setAlignItems(FlexComponent.Alignment.BASELINE);
        laydialog_TLEcom.setWidthFull();
    
        //Linea Ecommerce y Posicion
        
        cmbdialog_LEcom.setPlaceholder("Elija Linea Ecommerce");
        cmbdialog_LEcom.setWidthFull();
        cmbdialog_LEcom.addValueChangeListener(event->{
            if(!event.getValue().contentEquals("No definida") || event.getValue() != null){
                txtdialog_LEcom.setValue(event.getValue());
            }
            else
                txtdialog_LEcom.setValue("No definida");
        });
        
        txtdialog_LEcom.setReadOnly(true);
        txtdialog_LEcom.setWidthFull();
        txtdialog_LEcom.getStyle().set("fontWeight","bold"); 
        
        txtdialog_PosLEcom.setReadOnly(true);
        txtdialog_PosLEcom.setWidthFull();
        txtdialog_PosLEcom.getStyle().set("fontWeight","bold");
        
        laydialog_LEcom.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laydialog_LEcom.setAlignItems(FlexComponent.Alignment.BASELINE);
        laydialog_LEcom.setWidthFull(); 
    
        //Upload
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
        btndialog_Upload.getStyle().set("fontSize","90%");
        
        uploadLinea.setAutoUpload(true);
        uploadLinea.setDropAllowed(false);
        uploadLinea.setUploadButton(btndialog_Upload);
        
        laydialog_BUpEcom.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laydialog_BUpEcom.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialog_BUpEcom.setWidthFull();
        
        //Activar Imagen 
        dialog_CheckActivation.setValue(Boolean.FALSE);
        /*
        dialog_CheckActivation.addValueChangeListener(event->{
            On_Click_CheckActivation();
        });*/
        
        laydialog_checkActivation.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laydialog_checkActivation.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialog_checkActivation.setWidthFull(); 
    
        //Botones Nueva Imagen
        btndialog_Guardar.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        btndialog_Guardar.getStyle().set("fontSize","90%");
        
        laydialog_Btns.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laydialog_Btns.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialog_Btns.setWidthFull(); 
        //-----------------------------------------------------------------------------------------------
        
        //BANNER ACTIVO
        
        lbdialog2_LineasActTit.getStyle().set("fontWeight","bold");     
        lbdialog2_LineasActTit.getStyle().set("fontSize","120%");
                
        laydialog2_LineasActTit.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laydialog2_LineasActTit.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialog2_LineasActTit.setWidthFull();  
        
        //Titulo y subtitulo Imagen
        txtdialog2_TLEcom.setReadOnly(true);
        txtdialog2_TLEcom.setWidthFull(); 
        txtdialog2_SubtLEcom.setReadOnly(true);
        txtdialog2_SubtLEcom.setWidthFull();
        
        laydialog2_TLEcom.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laydialog2_TLEcom.setAlignItems(FlexComponent.Alignment.BASELINE);
        laydialog2_TLEcom.setWidthFull();  

        //Linea Ecommerce y Posicion
        
        cmbdialog2_LEcom.setPlaceholder("Elija Linea Ecommerce");
        cmbdialog2_LEcom.setWidthFull();
        cmbdialog2_LEcom.addValueChangeListener(event->{
            if(!event.getValue().contentEquals("No definida") || event.getValue() != null){
                txtdialog2_LEcom.setValue(event.getValue());
            }
            else
                txtdialog2_LEcom.setValue("No definida");
        });
        
        txtdialog2_LEcom.setReadOnly(true);
        txtdialog2_LEcom.setWidthFull();
        txtdialog2_LEcom.getStyle().set("fontWeight","bold");
        
        txtdialog2_PosLEcom.setReadOnly(true);
        txtdialog2_PosLEcom.setWidthFull();
        txtdialog2_PosLEcom.getStyle().set("fontWeight","bold");
          
        laydialog2_LEcom.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laydialog2_LEcom.setAlignItems(FlexComponent.Alignment.BASELINE);
        laydialog2_LEcom.setWidthFull(); 
    
        //Upload
        
        btndialog2_BuscarAnterior.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        btndialog2_BuscarAnterior.getStyle().set("fontSize","90%");
        btndialog2_BuscarSiguiente.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        btndialog2_BuscarSiguiente.getStyle().set("fontSize","90%");
        
        dialog2_img.setVisible(true);
        dialog2_img.setEnabled(true);
        dialog2_img.setHeight("150px");
        dialog2_img.setWidth("250px");
        
        laydialog2_ImgUpEcom.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laydialog2_ImgUpEcom.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialog2_ImgUpEcom.setWidthFull();
    
        //Activado
        dialog2_CheckActivation.addAttachListener(event->{
        });
        
        btndialog2_Confirm.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        btndialog2_Confirm.getStyle().set("fontSize","90%"); 
        
        laydialog2_ActConfirm.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laydialog2_ActConfirm.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialog2_ActConfirm.setWidthFull(); 
        //-----------------------------------------------------------------------------------------------
        //Salir Pantalla
        btndialog_Cancel.addThemeVariants(ButtonVariant.LUMO_ERROR);
        btndialog_Cancel.getStyle().set("fontSize","90%");
        
        laydialog_Salir.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        laydialog_Salir.setAlignItems(FlexComponent.Alignment.CENTER);
        laydialog_Salir.setWidthFull();  
    //------------------------------------------------------------------------------------------------------
        //LAYOUTS TOTALES
        
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
        //-----------------------------------------------------------------------------------------------
        
        //DIALOG PROPERTIES
        dialog_LineaEcommerce.setCloseOnEsc(false);
        dialog_LineaEcommerce.setCloseOnOutsideClick(false);
        
        //-----------------------------------------------------------------------------------------------
        //NOTIFICATION DIALOG LINEA ECOMMERCE
        
        //dialog_notf_is_Activated.getStyle().set("fontWeight","bold");
        dialog_notf_is_Activated.getStyle().set("fontSize","90%");
        dialog_notf_is_Activated.getStyle().set("color", "red");
        
        notify_is_Activated.setDuration(3000);
        notify_is_Activated.setPosition(Position.MIDDLE);
        //-----------------------------------------------------------------------------------------------
        
        //dialog_notf_is_NotActivated.getStyle().set("fontWeight","bold");
        dialog_notf_is_NotActivated.getStyle().set("fontSize","90%");
        dialog_notf_is_NotActivated.getStyle().set("color", "green");
        
        notify_is_NotActivated.setDuration(2500);
        notify_is_NotActivated.setPosition(Position.MIDDLE);
        //-----------------------------------------------------------------------------------------------
        //dialog_notf_is_PosibleActivated.getStyle().set("fontWeight","bold");
        dialog_notf_is_PosibleActivated.getStyle().set("fontSize","90%");
        dialog_notf_is_PosibleActivated.getStyle().set("color", "green");
        
        notify_is_PosibleActivated.setDuration(2500);
        notify_is_PosibleActivated.setPosition(Position.MIDDLE);
        //-----------------------------------------------------------------------------------------------
        //dialog_notf_Guardado_Correct.getStyle().set("fontWeight","bold");
        dialog_notf_Guardado_Correct.getStyle().set("fontSize","90%");
        dialog_notf_Guardado_Correct.getStyle().set("color", "green");
        
        notify_is_Guardado_Correct.setDuration(2500);
        notify_is_Guardado_Correct.setPosition(Position.MIDDLE);
        //-----------------------------------------------------------------------------------------------
    }
    
    //CPANEL Rutas
    public abstract void go_CPanel();
    public abstract void go_Productos();
    public abstract void go_Pedidos();
    public abstract void go_LineasEcom();
    public abstract void go_Clientes();
    public abstract void go_Cupones();
    
    //FUNCIONES
    public abstract void init_Sliders();
    
    //Uploads
    public abstract void on_UploadH(SucceededEvent event);
    
    public abstract void on_UploadS1(SucceededEvent event);
    public abstract void on_UploadS2(SucceededEvent event);
    public abstract void on_UploadS3(SucceededEvent event);
    public abstract void on_UploadS4(SucceededEvent event);
    
    public abstract void on_UploadF(SucceededEvent event);
    
    public abstract void on_Grabar();
    //-----------------------------------------------------------------------------------------------
    
    //DIALOG LINEA ECOMMERCE
    public abstract void init_Banners();
    
    //Open dialog
    public abstract void On_Open_dialog_Banner1();
    public abstract void On_Open_dialog_Banner2();
    public abstract void On_Open_dialog_Banner3();
    public abstract void On_Open_dialog_Banner4();
    public abstract void On_Open_dialog_Banner5();
    public abstract void On_Open_dialog_Banner6();
    
    //Upload New Image
    public abstract void on_UploadLinea_Ecom(SucceededEvent event);
    
    //New Image Functions
    //public abstract void On_Click_CheckActivation();
    public abstract void On_Click_GuardarCambios();
    
    //Linea Ecommerce Activadas
    //public abstract void On_Click_CmbsoloAct();
    public abstract void On_Click_BannerAnterior();
    public abstract void On_Click_BannerSiguiente();
    public abstract void On_Click_Confirmar_CheckAct();
    
    //Salir Dialog Banner
    public abstract void On_Verify_BannerAct();
    public abstract void refresh_Banners();
    
    //-----------------------------------------------------------------------------------------------
    
    
    private void initEvents() {
        init_Sliders();
        //-----------------------------------------------------------------------------------------------
        //CABECERA CPANEL
        btnClientes.addClickListener(e->{
            removeAll();
            go_Clientes();
            //add(new ClientesView());
        });
        btnPedidos.addClickListener(e->{
            removeAll();
            go_Pedidos();
            //add(new PedidosView());
        });
        btnLineas.addClickListener(e->{
            removeAll();
            go_LineasEcom();
            //add(new LineasEcomView());
        });
        btnProductos.addClickListener(e->{
            removeAll();
            go_Productos();
            //add(new ProductosView());
        });
        btnCupones.addClickListener(e->{
            removeAll();
            go_Cupones();
            //add(new ProductosView());
        });
        btnSalirCP.addClickListener(e->{
            removeAll();
            add(new App());
        });
        //-----------------------------------------------------------------------------------------------
        //MAIN VIEW
        //Envía al Menu Principal - Panel de Control
        btnExit.addClickListener(e->{
            removeAll();
            go_CPanel();
            //add(new CPanelView());
        });
        //Envía al Menu Principal - Panel de Control
        begining.addClickListener(e->{
            removeAll();
            go_CPanel();
            //add(new CPanelView());
        });
        //Envía al Menu Inicio
        closeAcct.addClickListener(e->{
            removeAll();
            add(new App());
        });
        //Grabar Cambios Foot
        btnFSave.addClickListener(e->{ 
            on_Grabar();
            notify_correct.open();
        });
        
        uploadH1.addSucceededListener(this::on_UploadH);
        
        uploadS1.addSucceededListener(this::on_UploadS1);
        uploadS2.addSucceededListener(this::on_UploadS2);
        uploadS3.addSucceededListener(this::on_UploadS3);
        uploadS4.addSucceededListener(this::on_UploadS4);
        
        /*
        uploadF1.addSucceededListener(this::on_UploadF);
        */
        //-----------------------------------------------------------------------------------------------
        
        //DIALOG LINEA ECOMMERCE
        init_Banners();
        //Open Linea Ecom dialog
        btnLUpload1.addClickListener(e->{ 
            On_Open_dialog_Banner1();
            dialog_LineaEcommerce.open();
        }); 
        btnLUpload2.addClickListener(e->{ 
            On_Open_dialog_Banner2();
            dialog_LineaEcommerce.open();
        });
         btnLUpload3.addClickListener(e->{ 
            On_Open_dialog_Banner3();
            dialog_LineaEcommerce.open();
        }); 
        btnLUpload4.addClickListener(e->{ 
            On_Open_dialog_Banner4();
            dialog_LineaEcommerce.open();
        });
         btnLUpload5.addClickListener(e->{ 
            On_Open_dialog_Banner5();
            dialog_LineaEcommerce.open();
        }); 
        btnLUpload6.addClickListener(e->{ 
            On_Open_dialog_Banner6();
            dialog_LineaEcommerce.open();
        });
        
        //Upload
        uploadLinea.addSucceededListener(this::on_UploadLinea_Ecom);
        
        //Funcionalidad
        btndialog_Guardar.addClickListener(e->{ 
            On_Click_GuardarCambios();
        });
        btndialog_Cancel.addClickListener(e->{ 
            On_Verify_BannerAct();
            //dialog_LineaEcommerce.close();
        });
        
        //Lineas Ecommerce Activadas
        btndialog2_BuscarAnterior.addClickListener(e->{ 
            On_Click_BannerAnterior();
        });
        btndialog2_BuscarSiguiente.addClickListener(e->{ 
            On_Click_BannerSiguiente();
        });
        btndialog2_Confirm.addClickListener(e->{ 
            On_Click_Confirmar_CheckAct();
        });
        
        
    }
    
}
