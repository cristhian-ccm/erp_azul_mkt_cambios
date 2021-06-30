package up.erp.server.serviceimpl;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFDataFormat;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import up.erp.server.Server;
import up.erp.service.ReporteService;
import up.erp.view.exporter.ColumnData;
import up.erp.view.exporter.Data;
import up.erp.view.exporter.RowData;



@SuppressWarnings({ "serial", "deprecation" })
@WebServlet("/eva/ReporteService")
public class ReporteServiceImpl extends RemoteServiceServlet implements ReporteService {

	private XSSFWorkbook workbook;

	@Override
	public String getExcel(ColumnData[] columns, RowData[] rows, String usuarioId, String folderTemps)
			throws Exception {
                //System.out.println("Reporte Service");
		workbook = new XSSFWorkbook();
		
		//	font header
		 XSSFFont font = workbook.createFont();
		    font.setFontHeightInPoints((short)12);
		    font.setFontName("Arial");
		    font.setColor(IndexedColors.WHITE.getIndex());
		    font.setBold(true);
		    font.setItalic(false);
		//	font rows
		 XSSFFont fontCont = workbook.createFont();
		    fontCont.setFontHeightInPoints((short)8);
		    fontCont.setFontName("Arial");
		    fontCont.setColor(IndexedColors.AUTOMATIC.getIndex());
		    fontCont.setBold(false);
		    fontCont.setItalic(false);
		    
		
		XSSFDataFormat df = workbook.createDataFormat();
		XSSFCellStyle styleHeader = workbook.createCellStyle();
		XSSFCellStyle stylecont = workbook.createCellStyle();
		
		//style header
		//styleHeader.setFillBackgroundColor(IndexedColors.BLUE.getIndex());
		styleHeader.setFillPattern(XSSFCellStyle.ALIGN_CENTER);
		styleHeader.setAlignment(XSSFCellStyle.ALIGN_CENTER);
		styleHeader.setFont(font);
		
		// STYLE DATE
		Server.CELL_STYLE = workbook.createCellStyle();
		Server.CELL_STYLE.setDataFormat(df.getFormat("yyyy-MM-dd"));
		Server.CELL_STYLE.setFont(fontCont);
		Server.CELL_STYLE.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
		Server.CELL_STYLE.setAlignment(XSSFCellStyle.ALIGN_CENTER);
		
        //style rows
        stylecont.setFont(fontCont);
        stylecont.setWrapText(true);
        stylecont.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
		stylecont.setAlignment(XSSFCellStyle.ALIGN_CENTER);

        
		XSSFSheet sheet = workbook.createSheet();

		// columns
		Row rowCols = sheet.createRow(0);
                //System.out.println("Colums size: " + columns.length);
		for (int i = 0; i < columns.length; i++) {
                        //System.out.println("ColumnData value: " + columns[i].get_Name());
			ColumnData column = columns[i];
			Cell cell = rowCols.createCell(i);
			cell.setCellStyle(styleHeader);
			Server.setCellValue(cell, column.name);
			sheet.setColumnWidth(i, Server.getCellWidth(column.width+40));
		}
		
		// rows
                //System.out.println("Rows size: " + rows.length);
		for (int i = 0; i < rows.length; i++) {
			Row row = sheet.createRow(i + 1);
			Data[] rowData = rows[i].data;
			for (int j = 0; j < rowData.length; j++) {
                                //System.out.println("RowData value: " + rowData[j]);
                                Data cellData = rowData[j];
				Cell cell = row.createCell(j);
				cell.setCellStyle(stylecont);
				Server.setCellValueByRowData(cell, cellData);
			}
		}


		/*String fileName = folderTemps + "/" + usuarioId + ".xlsx";
                
		String filePath = Server.PATH_WEBAPPS + "/" + fileName;*/
		

		//String fileName = folderTemps + "_" + usuarioId + ".xlsx";
                String fileName = folderTemps + "_" + usuarioId + ".csv";
		//String filePath = Server.PATH_WEBAPPS + "/" + fileName;
		String filePath = Server.PATH_IMAGES + fileName;

		/*String fileName = folderTemps + "_" + usuarioId + ".xlsx";
		//String filePath = Server.PATH_WEBAPPS + "/" + fileName;
		String filePath = Server.PATH_IMAGES + fileName;*/
                //String filePath = Server.PATH_REPORTS + fileName;
                
		try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
			workbook.write(outputStream);
			// workbook.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new Exception(ex.getMessage());
		}
		return fileName;
	}

}
