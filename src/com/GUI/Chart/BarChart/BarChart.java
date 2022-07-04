
package com.GUI.Chart.BarChart;

import com.GUI.Chart.BlankChart.BlankPlotChart;
import com.GUI.Chart.BlankChart.BlankPlotChatRender;
import com.GUI.Chart.BlankChart.SeriesSize;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public class BarChart extends javax.swing.JPanel {
    
    private List<ModelLegend> legends =new ArrayList<>();
    private List<ModelChart> models = new ArrayList<>();
    private final int seriesSize = 40;
    private final int seriesSpace = 6;
    
    public BarChart() {
        initComponents();
        blankPlotChart.setBlankPlotChatRender(new BlankPlotChatRender() {
            @Override
            public String getLabelText(int index) {
                return models.get(index).getLabel();
            }

            @Override
            public void renderSeries(BlankPlotChart chart, Graphics2D g2, SeriesSize size, int index) {
                double totalSeriesWidth = (seriesSize+legends.size()) + (seriesSpace*(legends.size()-1));
                double x = (size.getWidth() -totalSeriesWidth)/2;
                for (int i = 0; i < legends.size(); i++) {
                    ModelLegend legend = legends.get(i);
                    g2.setColor(legend.getColor());
                    double seriesValues = chart.getSeriesValuesOf(models.get(index).getValue()[i], size.getHeight());
                    g2.fillRect((int) (size.getX()+x), (int)(size.getY()+size.getHeight()-seriesValues), seriesSize , (int) seriesValues);
                    x+= seriesSpace + seriesSize;
                }
               }
        });
    }
    public void removeLegend(){
        if(legends.size()>0){
            legends.removeAll(legends);
        }
    }
    public void removeData(){
        if(models.size()>0){
            models.removeAll(models);
        }
    }
    public void addLegend(String name, Color color){
        ModelLegend data = new ModelLegend(name,color);
        legends.add(data);
        panelLegend.add(new LegendItem(data));
        panelLegend.repaint();
        panelLegend.revalidate();
    }
    
    public void addData(ModelChart data){
        models.add(data);
        blankPlotChart.setLabelCount(models.size());
        double max = data.getMaxValues();
        if (max>blankPlotChart.getMaxValues()) {
            blankPlotChart.setMaxValues(max);
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelLegend = new javax.swing.JPanel();
        blankPlotChart = new com.GUI.Chart.BlankChart.BlankPlotChart();

        setBackground(new java.awt.Color(255, 255, 255));

        panelLegend.setBackground(new java.awt.Color(255, 255, 255));
        panelLegend.setOpaque(false);
        panelLegend.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelLegend, javax.swing.GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE)
            .addComponent(blankPlotChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(blankPlotChart, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(panelLegend, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.GUI.Chart.BlankChart.BlankPlotChart blankPlotChart;
    private javax.swing.JPanel panelLegend;
    // End of variables declaration//GEN-END:variables
}
