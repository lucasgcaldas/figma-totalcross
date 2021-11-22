package com.convert.model;

import com.convert.model.enuns.Characters;
import com.convert.model.enuns.LayoutAlign;
import com.convert.model.enuns.StrokeAlign;
import com.convert.model.util.AbsoluteBoundingBox;
import com.convert.model.util.Strokes;
import com.convert.model.util.Style;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FigmaText extends Node {

    private AbsoluteBoundingBox absoluteBoundingBox;
//    private Constrains[] constraints;
    private LayoutAlign layoutAlign;
    private Double layoutGrow;
//    private Fills[] fills;
//    private Strokes[] strokes;
    private Double strokeWeight;
    private StrokeAlign strokeAlign;
//    private Effects[] effects;
    private String characters;
    private Style style;
    private Integer layoutVersion;
//    private String[] characterStyleOverrides;
//    private String[] styleOverrideTable;

    public String getCharacters() {
        return characters;
    }

    public Style getStyle() {
        return style;
    }

    public AbsoluteBoundingBox getAbsoluteBoundingBox() {
        return absoluteBoundingBox;
    }
}
