package com.convert.model;

import com.convert.model.util.Color;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Class that extends Node and is
 * responsible to instantiate
 * a FigmaCanvas from Figma API
 * @author Lucas Gomes
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FigmaCanvas extends Node {

    private Color backgroundColor;
    private String prototypeStartNodeID;
}
