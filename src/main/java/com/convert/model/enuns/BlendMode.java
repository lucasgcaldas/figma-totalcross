package com.convert.model.enuns;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Enum responsible for instantiate
 * a set of BlendMode
 * @author Lucas Gomes
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum BlendMode {

    NORMAL,
    PASS_THROUGH
}
