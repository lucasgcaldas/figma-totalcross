package com.convert.model;

import com.convert.model.util.Color;
import com.convert.model.util.FlowStartingPoints;
import com.convert.model.util.PrototypeDevice;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FigmaCanvas extends Node {

    private Color backgroundColor;
    private String prototypeStartNodeID;
    private FlowStartingPoints[] flowStartingPoints;
    private PrototypeDevice prototypeDevice;
}
