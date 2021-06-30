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

public class DonutChart extends Div {
    
    ApexCharts donutChart;
    
    public DonutChart() {
    }
    
    public void generate_Chart(Double visitantes, Double logueados) {
        //ApexCharts donutChart = ApexChartsBuilder.get()
        this.donutChart = ApexChartsBuilder.get()
                .withChart(ChartBuilder.get().withType(Type.donut).build())
                .withLabels("Usuarios Invitados", "Usuarios Registrados")
                .withLegend(LegendBuilder.get()
                        .withPosition(Position.right)
                        .build())
                .withSeries(visitantes,logueados)
                .withResponsive(ResponsiveBuilder.get()
                        .withBreakpoint(480.0)
                        .withOptions(OptionsBuilder.get()
                                .withLegend(LegendBuilder.get()
                                        .withPosition(Position.bottom)
                                        .build())
                                .build())
                        .build())
                .build();
        add(this.donutChart);
        setWidth("70%");
    }
    
    public void delete_Chart(){
        remove(this.donutChart);
    }
    
    public void make_Muestra() {
        //ApexCharts donutChart = ApexChartsBuilder.get()
        this.donutChart = ApexChartsBuilder.get()
                .withChart(ChartBuilder.get().withType(Type.donut).build())
                .withLegend(LegendBuilder.get()
                        .withPosition(Position.right)
                        .build())
                .withSeries(44.0, 55.0, 41.0, 17.0, 15.0)
                .withResponsive(ResponsiveBuilder.get()
                        .withBreakpoint(480.0)
                        .withOptions(OptionsBuilder.get()
                                .withLegend(LegendBuilder.get()
                                        .withPosition(Position.bottom)
                                        .build())
                                .build())
                        .build())
                .build();
        add(donutChart);
        setWidth("70%");
    }
}
