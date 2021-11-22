package com.convert.model;

import com.convert.model.enuns.BlendMode;
import com.convert.model.util.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;

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
