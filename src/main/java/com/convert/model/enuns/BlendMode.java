package com.convert.model.enuns;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public enum BlendMode {

    NORMAL,
    PASS_THROUGH
}
