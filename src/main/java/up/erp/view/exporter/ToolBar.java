/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.view.exporter;

import com.upgrade.persistence.model.ecommerce.UsuarioWeb;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.Grid.Column;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.formula.functions.T;
import up.erp.server.Server;
import up.erp.service.Services;

/**
 *
 * @author Luis Aleman
 */
public class ToolBar extends HorizontalLayout{
    
    //-----------------------------------------------------------------------------------------------
    //REPORTEADOR TOOLBAR : MAIN VIEW
    //-----------------------------------------------------------------------------------------------
    //REPORTEADOR TOOLBAR : BOTONES
    //-----------------------------------------------------------------------------------------------
    public final Button btnExcel_generate = new Button("Generar Excel", VaadinIcon.TABLE.create());
    public final Button btnPdf_generate = new Button("Generar PDF", VaadinIcon.FILE.create());
    public final Button btnRefresh = new Button("Actualizar", VaadinIcon.REFRESH.create());
    
    public final HorizontalLayout laydToolbar_Buttons = new HorizontalLayout(btnExcel_generate,btnRefresh);
    //-----------------------------------------------------------------------------------------------
    
    //-----------------------------------------------------------------------------------------------
    //REPORTEADOR TOOLBAR : DIALOG NOMBRE ARCHIVO
    //-----------------------------------------------------------------------------------------------
    public final TextField dlg_txtNombreArchivo = new TextField("Nombre Archivo");
    public final HorizontalLayout dlg_lay_NombreArch = new HorizontalLayout(dlg_txtNombreArchivo);
    //-----------------------------------------------------------------------------------------------
    public final Button dlg_btnExcel_OK = new Button("OK");
    public final Button dlg_btnExcel_Cancel = new Button("Cancelar");
    public final HorizontalLayout dlg_lay_BtnsExcelArch = new HorizontalLayout(dlg_btnExcel_OK,dlg_btnExcel_Cancel);
    //-----------------------------------------------------------------------------------------------
    public final VerticalLayout dlg_ExcelArch_layFinal =  new VerticalLayout(dlg_lay_NombreArch,dlg_lay_BtnsExcelArch);
    
    public final Dialog dialog_ExcelArch = new Dialog(dlg_ExcelArch_layFinal);
    //-----------------------------------------------------------------------------------------------
    //REPORTEADOR TOOLBAR : END DIALOG NOMBRE ARCHIVO
    //-----------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------
    //REPORTEADOR TOOLBAR : NOTIFICATION 
    //-----------------------------------------------------------------------------------------------
    public final Label Toolbar_notf_generateExcel = new Label("El reporte fue generado exitosamente");
    public final Notification Toolbar_notify_generateExcel = new Notification(Toolbar_notf_generateExcel);
    //-----------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------
    //END REPORTEADOR TOOLBAR
    //-----------------------------------------------------------------------------------------------
    
    
    
    //-----------------------------------------------------------------------------------------------
    //REPORTEADOR TOOLBAR : VARIABLES
    //-----------------------------------------------------------------------------------------------
    public ColumnData[] COLUMS = null;
    public int size_Columns = 0;
    public RowData[] ROWS = null;
    public int size_Rows = 0;
    public int size_RowDataContent = 0;
    public String USUARIOID = null;
    public String FOLDERTEMPS = null;
    public String MODULE = null;
    public int count_FolderTemps = 0;
    //-----------------------------------------------------------------------------------------------
    
    
    
    
    //-----------------------------------------------------------------------------------------------
    //INIT MAIN PROCESS
    //-----------------------------------------------------------------------------------------------
    public ToolBar() {
        add(laydToolbar_Buttons);
        initStyles();
        initEvents();
    }
    
    private void initStyles() {
        
        //-----------------------------------------------------------------------------------------------
        //REPORTEADOR TOOLBAR
        //-----------------------------------------------------------------------------------------------
        //REPORTEADOR TOOLBAR : BOTONES
        //-----------------------------------------------------------------------------------------------
        btnExcel_generate.getStyle().set("fontSize","90%");  
        btnPdf_generate.getStyle().set("fontSize","90%"); 
        btnRefresh.getStyle().set("fontSize","90%");  
        
        laydToolbar_Buttons.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        laydToolbar_Buttons.setAlignItems(FlexComponent.Alignment.BASELINE);
        laydToolbar_Buttons.setWidthFull();
        //-----------------------------------------------------------------------------------------------
        
        //-----------------------------------------------------------------------------------------------
        //REPORTEADOR TOOLBAR : DIALOG NOMBRE ARCHIVO
        //-----------------------------------------------------------------------------------------------
        dlg_txtNombreArchivo.setWidth("%400");
        
        dlg_lay_NombreArch.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        dlg_lay_NombreArch.setAlignItems(FlexComponent.Alignment.CENTER);
        dlg_lay_NombreArch.setWidthFull(); 
        //-----------------------------------------------------------------------------------------------
        dlg_btnExcel_OK.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        dlg_btnExcel_OK.getStyle().set("fontSize","90%");
        
        dlg_btnExcel_Cancel.addThemeVariants(ButtonVariant.LUMO_ERROR);
        dlg_btnExcel_Cancel.getStyle().set("fontSize","90%"); 
        
        dlg_lay_BtnsExcelArch.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        dlg_lay_BtnsExcelArch.setAlignItems(FlexComponent.Alignment.CENTER);
        dlg_lay_BtnsExcelArch.setWidthFull(); 
        //-----------------------------------------------------------------------------------------------
        dlg_ExcelArch_layFinal.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        dlg_ExcelArch_layFinal.setAlignItems(FlexComponent.Alignment.CENTER);
        dlg_ExcelArch_layFinal.setWidthFull();  

        dialog_ExcelArch.setCloseOnEsc(false);
        dialog_ExcelArch.setCloseOnOutsideClick(false);
        //-----------------------------------------------------------------------------------------------
        //REPORTEADOR TOOLBAR : END DIALOG NOMBRE ARCHIVO
        //-----------------------------------------------------------------------------------------------
        //-----------------------------------------------------------------------------------------------
        //REPORTEADOR TOOLBAR : NOTIFICATION 
        //-----------------------------------------------------------------------------------------------
        Toolbar_notf_generateExcel.getStyle().set("fontSize","90%");
        Toolbar_notf_generateExcel.getStyle().set("color", "green");
                
        Toolbar_notify_generateExcel.setDuration(2000);
        Toolbar_notify_generateExcel.setPosition(Notification.Position.MIDDLE);
        //-----------------------------------------------------------------------------------------------
        //END REPORTEADOR TOOLBAR
        //-----------------------------------------------------------------------------------------------
        
    }
    
    //-----------------------------------------------------------------------------------------------
    //GENERATE REPORT
    //-----------------------------------------------------------------------------------------------
    //EXCEL
    //-----------------------------------------------------------------------------------------------
    public ColumnData[] get_ColumnData(){
        return this.COLUMS;
    }
    
    public void init_ColumnData(int size){
        this.COLUMS =  new ColumnData[size];
        for(int i = 0; i < size; i++){
            this.COLUMS[i] = new ColumnData();
        }
    }
    
    public void set_ColumnData(Grid<T> grid){
        ColumnData[] columns = null;
        ColumnData column = new ColumnData();
        String name_column = "";
        int width_column;
        int size_ColumnData = 0;
        
        List< Column<T> > L_ColsT = new ArrayList<>();
        L_ColsT = grid.getColumns();
        
        size_ColumnData = L_ColsT.size();
        columns = new ColumnData[size_ColumnData];
        init_ColumnData(size_ColumnData);
        
        for(int i = 0; i < L_ColsT.size(); i++){
            column = new ColumnData();
            name_column = L_ColsT.get(i).getKey();
            column.set_Name(name_column);
            this.COLUMS[i] = column;
        }
    }
    
    public void set_ColumnData2(List<String> grid_cols){
        this.COLUMS = null;
        String name_column = "";
        int width_column;
        int size_ColumnData = 0;
        
        size_ColumnData = grid_cols.size();
        this.COLUMS = new ColumnData[size_ColumnData];
        this.size_Columns = size_ColumnData;
        
        init_ColumnData(size_ColumnData);
        for(int i = 0; i < grid_cols.size(); i++){
            name_column = grid_cols.get(i);
            
            this.COLUMS[i] = new ColumnData();
            this.COLUMS[i].set_Name(name_column);
        }        
    }
    
    public void print_ColumsExcel(){
        for(int i = 0; i < this.size_Columns; i++){
            System.out.println("Columna : " + this.COLUMS[i].get_Name());
        }
    }
    //-----------------------------------------------------------------------------------------------
    
    public RowData[] get_RowData(){
        return this.ROWS;
    }
    
    public Data[] get_RowData_Data(int i){
        return this.ROWS[i].data;
    }
    
    public void init_RowData(int size){
        this.ROWS =  new RowData[size];
    }
    
    public void set_RowData(int L_gridContent_size, int size_content){
        this.ROWS = null;
        //init_RowData(L_gridContent_size);
        this.ROWS =  new RowData[L_gridContent_size];
        
        for(int i = 0; i < L_gridContent_size; i++){
            this.ROWS[i] = new RowData(size_content);
        }
        this.size_RowDataContent = size_content;
        this.size_Rows = L_gridContent_size;
    }
    
    public void print_RowsExcel(){
        for(int i = 0; i < this.size_Rows; i++){
            for(int j = 0; j < this.size_RowDataContent; j++){
                //System.out.println("Fila N°: " + i+1 + "Valor: " + this.ROWS[i].get_Value(j));
                String ref = "";
                ref = this.ROWS[i].data[j].getClass().getTypeName();
                System.out.println("Fila N°: " + i+1 + "Valor: " + this.ROWS[i]);
            }
        }
    }
    
    //-----------------------------------------------------------------------------------------------
    
    public String get_UsuarioID(){
        return this.USUARIOID;
    }
    
    public void set_UsuarioID(String usuario_id){
        this.USUARIOID = usuario_id;
    }
    //-----------------------------------------------------------------------------------------------
    public String get_Module(){
        return this.MODULE;
    }
    
    public void set_Module(String module){
        this.MODULE = module;
    }
    //-----------------------------------------------------------------------------------------------
    public String get_Foldertemps(){
        return this.FOLDERTEMPS;
    }
    
    public void set_Foldertemps(String foldertemps){
        this.FOLDERTEMPS = foldertemps;
    }
    //-----------------------------------------------------------------------------------------------
    public void set_FileNameExcel(){
        String name = "defaultReporte_";
        String count_FT = String.valueOf(this.count_FolderTemps);
        String File_name = "";
        if(!dlg_txtNombreArchivo.isEmpty()){
            name = this.MODULE + dlg_txtNombreArchivo.getValue();
            set_Foldertemps(name);
        }
        else {
            File_name = this.MODULE + name + count_FT;
            set_Foldertemps(File_name);
            this.count_FolderTemps++;
        }
    }
    //-----------------------------------------------------------------------------------------------
    public void Generate_Table_default(){
        //Columnas(Cols)
        this.COLUMS = new ColumnData[4];
        for(int i = 0; i < 4; i++){
            this.COLUMS[i] = new ColumnData();
            this.COLUMS[i].set_Name("Col_Cabecera_" + i+1);
        }        
        
        //Filas(Rows)
        this.ROWS =  new RowData[5];
        for(int i = 0; i < 5; i++){
            this.ROWS[i] = new RowData(4);
            for(int j = 0; j < 4; j++){
                this.ROWS[i].add("Row Value:" + j+1);
            }
        }
    }
    
    //-----------------------------------------------------------------------------------------------
    public void Generate_Excel() throws Exception{
        ColumnData[] columns = this.COLUMS;
        RowData[] rows = this.ROWS;
        String usuario_id = this.USUARIOID;
        String foldertemps = this.FOLDERTEMPS;
        String fileName_Excel = "";
        String url_Excel = "";
        
        fileName_Excel = Services.getReporteService().getExcel(columns, rows, usuario_id, foldertemps);
        url_Excel = Server.URL_IMAGES + fileName_Excel;
        UI.getCurrent().getPage().executeJs("window.open(\"" + url_Excel + "\");");
        dialog_ExcelArch.close();
        Toolbar_notify_generateExcel.open();
    }
    
    //-----------------------------------------------------------------------------------------------
    public void Cancel_Generate_Excel(){
        dialog_ExcelArch.close();
    }
    
    //-----------------------------------------------------------------------------------------------
    //PDF
    //-----------------------------------------------------------------------------------------------
    public void Generate_PDF(){
        
    }
    //-----------------------------------------------------------------------------------------------
    public void on_Refresh(Grid<?> grid){
        grid.getDataProvider().refreshAll();
    }
    //-----------------------------------------------------------------------------------------------
    private void initEvents() {
        //-----------------------------------------------------------------------------------------------
        //REPORTEADOR
        //-----------------------------------------------------------------------------------------------
        btnExcel_generate.addClickListener(e->{ 
            dialog_ExcelArch.open();
        });
        //-----------------------------------------------------------------------------------------------
        dlg_btnExcel_OK.addClickListener(e->{ 
            try {
                set_FileNameExcel();
                Generate_Excel();
            } catch (Exception ex) {
                Logger.getLogger(ToolBar.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        //-----------------------------------------------------------------------------------------------
        dlg_btnExcel_Cancel.addClickListener(e->{ 
            Cancel_Generate_Excel();
        });
        //-----------------------------------------------------------------------------------------------
        btnPdf_generate.addClickListener(e->{ 
            Generate_PDF();
        });
        //-----------------------------------------------------------------------------------------------
    }
    
    
}
