/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.view.dashboards;

import com.github.appreciated.apexcharts.ApexCharts;
import com.github.appreciated.apexcharts.ApexChartsBuilder;
import com.github.appreciated.apexcharts.config.builder.ChartBuilder;
import com.github.appreciated.apexcharts.config.builder.PlotOptionsBuilder;
import com.github.appreciated.apexcharts.config.chart.Type;
import com.github.appreciated.apexcharts.config.plotoptions.builder.RadialBarBuilder;
import com.github.appreciated.apexcharts.config.plotoptions.radialbar.builder.HollowBuilder;
import com.vaadin.flow.component.html.Div;

/**
 *
 * @author Luis Aleman
 */

public class RadialBarChart extends Div {
    public RadialBarChart() {
        ApexCharts radialBarChart = ApexChartsBuilder.get()
                .withChart(ChartBuilder.get()
                        .withType(Type.radialBar)
                        .build())
                .withPlotOptions(PlotOptionsBuilder.get()
                        .withRadialBar(RadialBarBuilder.get()
                                .withHollow(HollowBuilder.get()
                                        .withSize("70%")
                                        .build())
                                .build())
                        .build())
                .withSeries(70.0)
                .withLabels("Cricket")
                .build();
        add(radialBarChart);
        setWidth("100%");
    }
}
