package com.convert.model.enuns;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Enum responsible for instantiate
 * a set of Horizontal
 * @author Lucas Gomes
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum Horizontal {

    SCALE,
    LEFT
}
