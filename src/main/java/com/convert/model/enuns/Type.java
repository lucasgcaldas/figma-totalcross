package com.convert.model.enuns;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public enum Type {

    DOCUMENT,
    FRAME,
    VECTOR,
    SOLID,
    TEXT,
    DROP_SHADOW,
    SCALE,
    RECTANGLE,
    GROUP,
    ELLIPSE,
    PRESET,
    CANVAS,
    INSTANCE,
    NONE,
    COMPONENT
}
