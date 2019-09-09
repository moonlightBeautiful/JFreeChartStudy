package com.java1234.c01bar;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.servlet.http.HttpSession;
import java.awt.*;

/**
 * 基本柱状图-水平
 */
public class BarChart2 {

    public static String genBarChart(HttpSession session) throws Exception {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(510, "深圳", "苹果");
        dataset.addValue(320, "深圳", "香蕉");
        dataset.addValue(580, "深圳", "橘子");
        dataset.addValue(390, "深圳", "梨子");

        //设置主题的样式，解决乱码
        StandardChartTheme standardChartTheme = new StandardChartTheme("CN");
        //设置标题字体
        standardChartTheme.setExtraLargeFont(new Font("隶书", Font.BOLD, 20));
        //设置图例的字体
        standardChartTheme.setRegularFont(new Font("宋书", Font.PLAIN, 15));
        //设置轴向的字体
        standardChartTheme.setLargeFont(new Font("宋书", Font.PLAIN, 15));

        ChartFactory.setChartTheme(standardChartTheme);

        JFreeChart chart = ChartFactory.createBarChart3D("水果销售统计图", "水果", "销售", dataset,
                PlotOrientation.HORIZONTAL, true, true, true);
        String fileName = ServletUtilities.saveChartAsPNG(chart, 700, 500, null, session);
        return fileName;
    }
}
