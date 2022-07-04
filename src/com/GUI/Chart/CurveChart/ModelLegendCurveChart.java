package com.GUI.Chart.CurveChart;

import java.awt.Color;

public class ModelLegendCurveChart {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColorLight() {
        return colorLight;
    }

    public void setColorLight(Color colorLight) {
        this.colorLight = colorLight;
    }

    public ModelLegendCurveChart(String name, Color color, Color colorLight) {
        this.name = name;
        this.color = color;
        this.colorLight = colorLight;
    }

    public ModelLegendCurveChart() {
    }

    private String name;
    private Color color;
    private Color colorLight;
}
