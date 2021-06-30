/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.view.dashboards;

import com.github.appreciated.apexcharts.ApexCharts;
import com.github.appreciated.apexcharts.ApexChartsBuilder;
import com.github.appreciated.apexcharts.config.builder.ChartBuilder;
import com.github.appreciated.apexcharts.config.chart.Type;
import com.vaadin.flow.component.html.Div;

/**
 *
 * @author Luis Aleman
 */

public class MultiRadialBarChart extends Div {
    public MultiRadialBarChart() {
        ApexCharts multiRadialBarChart = ApexChartsBuilder.get()
                .withChart(ChartBuilder.get()
                        .withType(Type.radialBar)
                        .build())
                .withSeries(44.0, 55.0, 67.0, 83.0)
                .withLabels("Apples", "Oranges", "Bananas", "Berries")
                .build();
        add(multiRadialBarChart);
        setWidth("100%");
    }
}
