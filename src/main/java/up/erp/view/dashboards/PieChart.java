/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.view.dashboards;

import com.github.appreciated.apexcharts.ApexCharts;
import com.github.appreciated.apexcharts.ApexChartsBuilder;
import com.github.appreciated.apexcharts.config.builder.ChartBuilder;
import com.github.appreciated.apexcharts.config.builder.LegendBuilder;
import com.github.appreciated.apexcharts.config.builder.ResponsiveBuilder;
import com.github.appreciated.apexcharts.config.chart.Type;
import com.github.appreciated.apexcharts.config.legend.Position;
import com.github.appreciated.apexcharts.config.responsive.builder.OptionsBuilder;
import com.vaadin.flow.component.html.Div;

/**
 *
 * @author Luis Aleman
 */

public class PieChart extends Div {
    
    public ApexCharts pieChart;
    
    public PieChart() {
        
    }
        
    public void generate_Chart(Double v_ecommerce, Double v_upgrade) {
        this.pieChart = ApexChartsBuilder.get()
        //ApexCharts pieChart = ApexChartsBuilder.get()
                .withChart(ChartBuilder.get().withType(Type.pie).build())
                .withLabels("Ventas ecommerce", "Ventas Upgrade")
                .withLegend(LegendBuilder.get()
                        .withPosition(Position.right)
                        .build())
                .withSeries(v_ecommerce, v_upgrade)
                .withResponsive(ResponsiveBuilder.get()
                        .withBreakpoint(480.0)
                        .withOptions(OptionsBuilder.get()
                                .withLegend(LegendBuilder.get()
                                        .withPosition(Position.bottom)
                                        .build())
                                .build())
                        .build())
                .build();
        add(this.pieChart);
        setWidth("70%");
    }
    
    public void delete_Chart(){
        remove(this.pieChart);
    }
    
    public void make_Muestra() {
        //ApexCharts pieChart = ApexChartsBuilder.get()
        this.pieChart = ApexChartsBuilder.get()
                .withChart(ChartBuilder.get().withType(Type.pie).build())
                .withLabels("Team A", "Team B", "Team C", "Team D", "Team E")
                .withLegend(LegendBuilder.get()
                        .withPosition(Position.right)
                        .build())
                .withSeries(44.0, 55.0, 13.0, 43.0, 22.0)
                .withResponsive(ResponsiveBuilder.get()
                        .withBreakpoint(480.0)
                        .withOptions(OptionsBuilder.get()
                                .withLegend(LegendBuilder.get()
                                        .withPosition(Position.bottom)
                                        .build())
                                .build())
                        .build())
                .build();
        add(this.pieChart);
        setWidth("70%");
    }
}
