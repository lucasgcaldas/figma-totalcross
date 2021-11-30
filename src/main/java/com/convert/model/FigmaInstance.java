package com.convert.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Class that extends FigmaFrame and
 * is responsible to instantiate
 * a FigmaInstance from Figma API
 * @author Lucas Gomes
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FigmaInstance extends FigmaFrame {

    private Double componentId;
}
