/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.view.dashboards;

import com.github.appreciated.apexcharts.ApexCharts;
import com.github.appreciated.apexcharts.ApexChartsBuilder;
import com.github.appreciated.apexcharts.config.builder.ChartBuilder;
import com.github.appreciated.apexcharts.config.builder.TitleSubtitleBuilder;
import com.github.appreciated.apexcharts.config.chart.Type;
import com.github.appreciated.apexcharts.helper.Series;
import com.vaadin.flow.component.html.Div;

/**
 *
 * @author Luis Aleman
 */
public class RadarChart extends Div {
    public RadarChart() {
        ApexCharts radarChart = ApexChartsBuilder.get()
                .withChart(ChartBuilder.get()
                        .withType(Type.radar)
                        .build())
                .withSeries(new Series<>("Series 1", 80, 50, 30, 40, 100, 20))
                .withTitle(TitleSubtitleBuilder.get()
                        .withText("Basic Radar Chart")
                        .build())
                .withLabels("January", "February", "March", "April", "May", "June")
                .build();
        add(radarChart);
        setWidth("100%");
    }
}
