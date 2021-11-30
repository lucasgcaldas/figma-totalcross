package com.convert.model.util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Class responsible for instantiate
 * a AbsoluteBoundingBox proprieties
 * @author Lucas Gomes
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AbsoluteBoundingBox {

    private double x;
    private double y;
    private double width;
    private double height;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}
