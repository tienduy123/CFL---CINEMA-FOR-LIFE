
package com.GUI.Chart.BarChart;

public class ModelChart {
    String label;
    double[] value;

    public ModelChart() {
    }

    public ModelChart(String label, double[] value) {
        this.label = label;
        this.value = value;
    }
    
    public double getMaxValues() {
        double max = 0;
        for (double v : value) {
            if (v > max) {
                max = v;
            }
        }
        return max;
    }
    
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public double[] getValue() {
        return value;
    }

    public void setValue(double[] value) {
        this.value = value;
    }
    
    
}
