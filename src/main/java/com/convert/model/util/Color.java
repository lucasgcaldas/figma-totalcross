package com.convert.model.util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Color {

    private Double r;
    private Double g;
    private Double b;
    private Double a;

    public int getR() {
        if (r > 0.9){
            return 255;
        } else if (r > 0.85 && r < 0.9){
            return 221;
        }else if (r > 0.5 && r < 0.85){
            return 128;
        } else if (r > 0.1 && r < 0.2) {
            return 28;
        }
        return 0;
    }

    public int getG() {
        if (g > 0.9){
            return 255;
        } else if (g > 0.85 && g < 0.9){
            return 221;
        }else if (g > 0.5 && g < 0.85){
            return 128;
        } else if (g > 0.1 && g < 0.2) {
            return 28;
        }
        return 0;
    }

    public int getB() {
        if (b > 0.9){
            return 255;
        } else if (b > 0.85 && b < 0.9){
            return 221;
        }else if (b > 0.5 && b < 0.85){
            return 128;
        } else if (b > 0.1 && b < 0.2) {
            return 28;
        }
        return 0;
    }

    public Double getA() {
        return a;
    }
}
