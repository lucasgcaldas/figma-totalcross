package com.convert.model;

import com.convert.model.util.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FigmaFrame extends Node {

    private AbsoluteBoundingBox absoluteBoundingBox;
    private Constraints constraints;
//    private Boolean clipsContent;
//    private Background background;
//    private Fills fills;
//    private Strokes[] strokes;
//    private Double strokeWeight;
//    private StrokeAlign strokeAlign;
    private Color backgroundColor;
//    private Effects[] effects;
//    private Double cornerRadius;
//    private LayoutMode layoutMode;
//    private CounterAxisSizingMode counterAxisSizingMode;
//    private Double itemSpacing;
//    private PrimaryAxisSizingMode primaryAxisSizingMode;
//    private CounterAxisAlignItems counterAxisAlignItems;
//    private PrimaryAxisAlignItems primaryAxisAlignItems;
//    private Double paddingLeft;
//    private Double paddingRight;
//    private Double paddingTop;
//    private Double paddingBottom;

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public AbsoluteBoundingBox getAbsoluteBoundingBox() {
        return absoluteBoundingBox;
    }

    public Constraints getConstrains() {
        return constraints;
    }
}
