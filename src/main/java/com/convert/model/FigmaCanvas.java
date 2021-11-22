package com.convert.model;

import com.convert.model.util.Color;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FigmaCanvas extends Node {

    private Color backgroundColor;
    private String prototypeStartNodeID;
}
