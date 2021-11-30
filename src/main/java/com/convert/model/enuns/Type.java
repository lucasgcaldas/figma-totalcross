package com.convert.model.enuns;

import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * Enum responsible for instantiate
 * a set of Type
 * @author Lucas Gomes
 */
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
