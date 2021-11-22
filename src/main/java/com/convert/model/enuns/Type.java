package com.convert.model.enuns;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "type")
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
