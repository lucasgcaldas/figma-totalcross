package com.convert.model.util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Color {

    private Double r;
    private Double g;
    private Double b;
    private Double a;
}
