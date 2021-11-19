package com.convert.model.util;

import com.convert.model.enuns.BlendMode;
import com.convert.model.enuns.Type;
import com.convert.model.util.Color;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Fills {

    private BlendMode blendMode;
    private Type type;
    private Color color;
}
