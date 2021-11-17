package com.convert.model.util;

public class Color {

    private Double r;
    private Double g;
    private Double b;
    private Double a;

    public Color(Double r, Double g, Double b, Double a) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;
    }

    public Double getR() {
        return r;
    }

    public void setR(Double r) {
        this.r = r;
    }

    public Double getG() {
        return g;
    }

    public void setG(Double g) {
        this.g = g;
    }

    public Double getB() {
        return b;
    }

    public void setB(Double b) {
        this.b = b;
    }

    public Double getA() {
        return a;
    }

    public void setA(Double a) {
        this.a = a;
    }
}
