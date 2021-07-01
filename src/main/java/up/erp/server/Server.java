/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.server;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;

import up.erp.view.exporter.BigDecimalData;
import up.erp.view.exporter.BooleanData;
import up.erp.view.exporter.Data;
import up.erp.view.exporter.DateData;
import up.erp.view.exporter.DoubleData;
import up.erp.view.exporter.FloatData;
import up.erp.view.exporter.IntegerData;
import up.erp.view.exporter.StringData;

/**
 *
 * @author Hvt
 */
public class Server {

    // ----------------------------------------------------------------------------------------------------
    // LOCAL

    public static String PATH_WEBAPPS = "C:/Users/Upgrade - PC/Desktop/prueba_java/Otros/ERP_MKT_CHANGES/"; // public
                                                                                                            // static
                                                                                                            // String
    /*
     * PATH_WEBAPPS =
     * "C:/Users/Luis Aleman/Documents/2020/Upgrade 2020/ecommerce/erp/up_erp3_vsb/src/main/resources/META-INF/resources/"
     * ; public static String PATH_IMAGES = PATH_WEBAPPS + "ecommerce/images/";
     * public static String PATH_PDF = PATH_WEBAPPS + "ecommerce/pdf/"; public
     * static String PATH_DEFIMG = PATH_WEBAPPS + "ecommerce/images/default.jpg";
     * public static String PATH_PROMO = PATH_WEBAPPS + "ecommerce/promos/"; public
     * static String PATH_REPORTS = PATH_WEBAPPS + "ecommerce/reportes/";
     * 
     */

    // SERVER
    // public static String PATH_WEBAPPS = "/opt/tomcat8/webapps/";
    public static String PATH_IMAGES = PATH_WEBAPPS + "images/ecommerce/";
    public static String PATH_REPORTS = PATH_WEBAPPS + "images/ecommerce/reportes/";
    public static String PATH_PDF = PATH_WEBAPPS + "ecommerce/pdf/";
    public static String PATH_PROMO = PATH_WEBAPPS + "images/ecommerce/promos/";

    // ----------------------------------------------------------------------------------------------------

    // LOCAL
    public static String URL_SERVER = "C:/Users/Upgrade - PC/Desktop/prueba_java/Otros/ERP_MKT_CHANGES/";
    // public static String URL_SERVER = "http://localhost:8080/";
    // public static String URL_IMAGES = URL_SERVER + "ecommerce/promos/";
    // public static String URL_REPORTS = URL_SERVER + "ecommerce/reportes/";

    // SERVER - HTTP
    // public static String URL_SERVER = "http://190.117.78.108:8088/";
    // public static String URL_IMAGES = URL_SERVER + "images/ecommerce/";

    // SERVER - HTPPS
    // ----------------------------------------------------------------------------------------------------
    // OLD PATH
    // ----------------------------------------------------------------------------------------------------
    // public static String URL_SERVER = "https://190.117.78.108:8443/";
    // public static String URL_IMAGES = URL_SERVER + "images/ecommerce/";
    // ----------------------------------------------------------------------------------------------------

    // NEW PATH SERVER
    // ----------------------------------------------------------------------------------------------------

    // ----SERVER
    // public static String URL_SERVER = "https://190.119.207.218:8443/";
    public static String URL_IMAGES = URL_SERVER + "images/ecommerce/";
    public static String URL_REPORTS = URL_SERVER + "images/ecommerce/reportes/";
    public static String PATH_VIEW = URL_SERVER + "images/ecommerce/promos/";
    public static String PATH_DEFIMG = URL_SERVER + "images/ecommerce/promos/default.jpg";

    // ----------------------------------------------------------------------------------------------------

    // Vendedor Ecommerce Id Upgrade2db
    // public static Integer VENDEDOR_ECOMMERCE_ID = 39385;

    // Vendedor Ecommerce Id Upgradedb
    public static Integer VENDEDOR_ECOMMERCE_ID = 40454;

    // ----------------------------------------------------------------------------------------------------

    public static String INIT_FILE;
    public static String APP_NAME;

    public static XSSFCellStyle CELL_STYLE;
    // private static PrintSocketClient printSocketClient;
    public static HttpClient HTTP_CLIENT;

    // ----------------------------------------------------------------------------------------------------
    public String getPATH_WEBAPPS() {
        return PATH_WEBAPPS;
    }

    // ----------------------------------------------------------------------------------------------------
    public String getPATH_IMAGES() {
        return PATH_IMAGES;
    }

    // ----------------------------------------------------------------------------------------------------
    public static int getCellWidth(int width) {
        return width * (35);
    }

    // ----------------------------------------------------------------------------------------------------
    public static void setCellValueByRowData(Cell cell, Data value) {

        if (value instanceof BigDecimalData) {
            Double dValue = ((BigDecimalData) value).get_Value().doubleValue();
            cell.setCellValue((Double) dValue);
        }

        if (value instanceof BooleanData) {
            cell.setCellValue(((BooleanData) value).get_Value());
        }
        if (value instanceof DateData) {
            cell.setCellValue(((DateData) value).value);
            if (CELL_STYLE != null) {
                cell.setCellStyle(CELL_STYLE);
            }
        }
        if (value instanceof DoubleData) {
            cell.setCellValue(((DoubleData) value).get_Value());
        }
        if (value instanceof StringData) {
            cell.setCellValue(((StringData) value).get_Value());
        }
        if (value instanceof IntegerData) {
            cell.setCellValue(((IntegerData) value).get_Value());
        }
        if (value instanceof FloatData) {
            cell.setCellValue(((FloatData) value).get_Value());
        }

    }

    // ----------------------------------------------------------------------------------------------------
    public static void setCellValue(Cell cell, Object value) {

        if (value instanceof BigDecimal) {
            Double dValue = ((BigDecimal) value).doubleValue();
            cell.setCellValue((Double) dValue);
        }

        if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        }
        if (value instanceof Calendar) {
            cell.setCellValue((Calendar) value);
        }
        if (value instanceof Date) {
            cell.setCellValue((Date) value);
            if (CELL_STYLE != null) {
                cell.setCellStyle(CELL_STYLE);
            }
        }
        if (value instanceof Double) {
            cell.setCellValue((Double) value);
        }
        if (value instanceof RichTextString) {
            cell.setCellValue((RichTextString) value);
        }
        if (value instanceof String) {
            cell.setCellValue((String) value);
        }
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        }
        if (value instanceof Float) {
            cell.setCellValue((Float) value);
        }
    }
    // ----------------------------------------------------------------------------------------------------

}
