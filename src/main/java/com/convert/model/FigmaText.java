package com.convert.model;

import com.convert.model.enuns.Characters;
import com.convert.model.enuns.LayoutAlign;
import com.convert.model.enuns.StrokeAlign;
import com.convert.model.util.Strokes;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FigmaText extends Node {

//    private AbsoluteBoundingBox[] absoluteBoundingBox;
//    private Constrains[] constraints;
    private LayoutAlign layoutAlign;
    private Double layoutGrow;
//    private Fills[] fills;
    private Strokes strokes;
    private Double strokeWeight;
    private StrokeAlign strokeAlign;
//    private Effects[] effects;
    private Characters characters;
//    private Style[] style;
    private Integer layoutVersion;
//    private String[] characterStyleOverrides;
//    private String[] styleOverrideTable;

}
