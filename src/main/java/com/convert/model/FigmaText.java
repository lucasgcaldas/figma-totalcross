package com.convert.model;

import com.convert.model.enuns.BlendMode;
import com.convert.model.util.AbsoluteBoundingBox;
import com.convert.model.util.Style;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FigmaText extends Node {

    private AbsoluteBoundingBox absoluteBoundingBox;
    private Double layoutGrow;
    private Double strokeWeight;
    private String characters;
    private Style style;
    private Integer layoutVersion;

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
