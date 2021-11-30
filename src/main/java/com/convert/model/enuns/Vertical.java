package com.convert.model.enuns;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Enum responsible for instantiate
 * a set of Vertical
 * @author Lucas Gomes
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum Vertical {

    SCALE,
    TOP
}
