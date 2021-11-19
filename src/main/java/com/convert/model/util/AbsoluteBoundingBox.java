package com.convert.model.util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AbsoluteBoundingBox {

    private Double x;
    private Double y;
    private Double width;
    private Double height;

}
