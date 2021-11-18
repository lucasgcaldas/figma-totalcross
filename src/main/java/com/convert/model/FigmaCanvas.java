package com.convert.model;

import com.convert.model.enuns.Type;
import com.convert.model.util.Color;
import com.convert.model.util.FlowStartingPoints;
import com.convert.model.util.PrototypeDevice;

public class FigmaCanvas {

    private String id;
    private String name;
    private String type;
    private FigmaFrame[] children;
    private Color backgroundColor;
    private String prototypeStartNodeID;
    private FlowStartingPoints flowStartingPoints;
    private PrototypeDevice prototypeDevice;
}
