package com.convert.model;

import com.convert.model.util.AbsoluteBoundingBox;
import com.convert.model.util.Color;
import com.convert.model.util.Constraints;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Class that extends Node and is
 * responsible to instantiate
 * a FigmaFrame from Figma API
 * @author Lucas Gomes
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FigmaFrame extends Node {

    private AbsoluteBoundingBox absoluteBoundingBox;
    private Constraints constraints;
    private Color backgroundColor;

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public AbsoluteBoundingBox getAbsoluteBoundingBox() {
        return absoluteBoundingBox;
    }

    public Constraints getConstraints() {
        return constraints;
    }
}
