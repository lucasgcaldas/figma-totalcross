package com.convert.model;

import com.convert.model.enuns.BlendMode;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FigmaInstance extends FigmaFrame {

    private Double componentId;
}
