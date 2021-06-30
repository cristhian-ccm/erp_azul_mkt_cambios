/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.view.dashboards;

import com.github.appreciated.apexcharts.ApexCharts;
import com.github.appreciated.apexcharts.ApexChartsBuilder;
import com.github.appreciated.apexcharts.config.builder.ChartBuilder;
import com.github.appreciated.apexcharts.config.builder.GridBuilder;
import com.github.appreciated.apexcharts.config.builder.StrokeBuilder;
import com.github.appreciated.apexcharts.config.builder.TitleSubtitleBuilder;
import com.github.appreciated.apexcharts.config.builder.XAxisBuilder;
import com.github.appreciated.apexcharts.config.chart.Type;
import com.github.appreciated.apexcharts.config.chart.builder.ZoomBuilder;
import com.github.appreciated.apexcharts.config.grid.builder.RowBuilder;
import com.github.appreciated.apexcharts.config.stroke.Curve;
import com.github.appreciated.apexcharts.config.subtitle.Align;
import com.github.appreciated.apexcharts.helper.Series;
import com.upgrade.persistence.model.ecommerce.VentasporMesModel;
import com.vaadin.flow.component.html.Div;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luis Aleman
 */

public class LineChart extends Div {
    public LineChart() {
    }
    
    public String get_Mes_ByVenta(int mes){
        String result = "";
        switch (mes) {
            case 1:
                result = "Ene";
                break;
            case 2:
                result = "Feb";
                break;
            case 3:
                result = "Mar";
                break;    
            case 4:
                result = "Abr";
                break;
            case 5:
                result = "May";
                break;
            case 6:
                result = "Jun";
                break;
            case 7:
                result = "Jul";
                break;
            case 8:
                result = "Ago";
                break;
            case 9:
                result = "Sep";
                break;    
            case 10:
                result = "Oct";
                break;
            case 11:
                result = "Nov";
                break;
            case 12:
                result = "Dic";
                break;
        }
        return result;
    }
    
    public List<String> get_Mes_Año_toList(List<VentasporMesModel> L_Ventas){
        List<String> L_MesAnio = new ArrayList<>();
        String mes = "";
        String anio = "";
        String mes_anio_concat = "";
        for(int i = 0; i < L_Ventas.size(); i++){
            mes = "";
            anio = "";
            mes_anio_concat = "";
            
            mes = get_Mes_ByVenta(L_Ventas.get(i).get_Mes());
            System.out.println("Mes: " + mes);
            anio = String.valueOf(L_Ventas.get(i).get_Año());
            System.out.println("Año: " + anio);
            mes_anio_concat = mes + anio;
            System.out.println("Mes_Año: " + mes_anio_concat);
            L_MesAnio.add(mes_anio_concat);
        }
        return L_MesAnio;
    }
    
    public void generate_Chart(List<VentasporMesModel> L_Ventas) {
        //Variables
        List<String> L_MesAnio = new ArrayList<>();
        List<Double> L_TotalVentas = new ArrayList<>();
        String mes_1,mes_2,mes_3,mes_4,mes_5,mes_6;
        Double v_total1,v_total2,v_total3,v_total4,v_total5,v_total6;
        Integer size_control = 0;
        Integer iterator = 0;
        
        //Get Mes_Año List (Ultimos 6 meses)
        L_MesAnio = get_Mes_Año_toList(L_Ventas);
        
        //Get Total_Ventas (Ultimos 6 meses)
        for(int i = 0; i < L_Ventas.size(); i++){
            L_TotalVentas.add(L_Ventas.get(i).get_Total_Ventas());
        }
        
        //Llenando variables para Dashboard
        size_control = 1;
        iterator = 0;
        
        v_total1 = 0.01;
        v_total2 = 0.01;
        v_total3 = 0.01;
        v_total4 = 0.01;
        v_total5 = 0.01;
        v_total6 = 0.01;
        
        mes_1 = "_";
        mes_2 = "_";
        mes_3 = "_";
        mes_4 = "_";
        mes_5 = "_";
        mes_6 = "_";
        
        //---------------------------------------------------------------------- 
        //Mes 1
        if(size_control <= L_Ventas.size()){
            mes_1 = L_MesAnio.get(iterator);
            v_total1 = L_TotalVentas.get(iterator);
            size_control++;
            iterator++;
            System.out.println("DASHBOARD AREACHART: Mes/Año: " + mes_1 + ", Total Ventas: " + v_total1);
        }
        //---------------------------------------------------------------------- 
        //Mes 2
        if(size_control <= L_Ventas.size()){
            mes_2 = L_MesAnio.get(iterator);
            v_total2 = L_TotalVentas.get(iterator);
            size_control++;
            iterator++;
            System.out.println("DASHBOARD AREACHART: Mes/Año: " + mes_2 + ", Total Ventas: " + v_total2);
        }
        //----------------------------------------------------------------------
        //Mes 3
        if(size_control <= L_Ventas.size()){
            mes_3 = L_MesAnio.get(iterator);
            v_total3 = L_TotalVentas.get(iterator);
            size_control++;
            iterator++;
            System.out.println("DASHBOARD AREACHART: Mes/Año: " + mes_4 + ", Total Ventas: " + v_total3);
        }
        //----------------------------------------------------------------------
        //Mes 4
        if(size_control <= L_Ventas.size()){
            mes_4 = L_MesAnio.get(iterator);
            v_total4 = L_TotalVentas.get(iterator);
            size_control++;
            iterator++;
            System.out.println("DASHBOARD AREACHART: Mes/Año: " + mes_4 + ", Total Ventas: " + v_total4);
        }
        //----------------------------------------------------------------------
        //Mes 5
        if(size_control <= L_Ventas.size()){
            mes_5 = L_MesAnio.get(iterator);
            v_total5 = L_TotalVentas.get(iterator);
            size_control++;
            iterator++;
            System.out.println("DASHBOARD AREACHART: Mes/Año: " + mes_5 + ", Total Ventas: " + v_total5);
        }
        //----------------------------------------------------------------------                    
        //Mes 6
        if(size_control <= L_Ventas.size()){
            mes_6 = L_MesAnio.get(iterator);
            v_total6 = L_TotalVentas.get(iterator);
            size_control++;
            iterator++;
            System.out.println("DASHBOARD AREACHART: Mes/Año: " + mes_6 + ", Total Ventas: " + v_total6);
        }
        //----------------------------------------------------------------------
        
        System.out.println("DASHBOARD AREACHART: GENERANDO DASHBOARD");
        //Generar Dashboard
        
        
        ApexCharts lineChart = ApexChartsBuilder.get()
                .withChart(ChartBuilder.get()
                        .withType(Type.line)
                        .withZoom(ZoomBuilder.get()
                                .withEnabled(false)
                                .build())
                        .build())
                .withStroke(StrokeBuilder.get()
                        .withCurve(Curve.straight)
                        .build())
                .withTitle(TitleSubtitleBuilder.get()
                        .withText("VENTAS ECOMMERCE ULTIMOS 6 MESES")
                        .withAlign(Align.left)
                        .build())
                .withGrid(GridBuilder.get()
                        .withRow(RowBuilder.get()
                                .withColors("#f3f3f3", "transparent")
                                .withOpacity(0.5).build()
                        ).build())
                .withXaxis(XAxisBuilder.get()
                        //.withCategories(mes_1, mes_2, mes_3, mes_4, mes_5, mes_6)
                        .withCategories(mes_6, mes_5, mes_4, mes_3, mes_2, mes_1)
                        .build())
                //.withSeries(new Series<>("Total Ventas", v_total1, v_total2, v_total3, v_total4, v_total5, v_total6))
                .withSeries(new Series<>("Total Ventas", v_total6, v_total5, v_total4, v_total3, v_total2, v_total1))
                .build();
        add(lineChart);
        setWidth("60%");
        
        System.out.println("DASHBOARD AREACHART: FIN - GENERANDO DASHBOARD");
    }
    
    public void make_Muestra() {
        ApexCharts lineChart = ApexChartsBuilder.get()
                .withChart(ChartBuilder.get()
                        .withType(Type.line)
                        .withZoom(ZoomBuilder.get()
                                .withEnabled(false)
                                .build())
                        .build())
                .withStroke(StrokeBuilder.get()
                        .withCurve(Curve.straight)
                        .build())
                .withTitle(TitleSubtitleBuilder.get()
                        .withText("Product Trends by Month")
                        .withAlign(Align.left)
                        .build())
                .withGrid(GridBuilder.get()
                        .withRow(RowBuilder.get()
                                .withColors("#f3f3f3", "transparent")
                                .withOpacity(0.5).build()
                        ).build())
                .withXaxis(XAxisBuilder.get()
                        .withCategories("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep")
                        .build())
                .withSeries(new Series<>("Desktops", 10.0, 41.0, 35.0, 51.0, 49.0, 62.0, 69.0, 91.0, 148.0))
                .build();
        add(lineChart);
        setWidth("70%");
    }
}
