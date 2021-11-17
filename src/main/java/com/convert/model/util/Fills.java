package com.convert.model.util;

import com.convert.model.enuns.BlendMode;
import com.convert.model.enuns.Type;
import com.convert.model.util.Color;

public class Fills {

    private BlendMode blendMode;
    private Type type;
    private Color color;

    public Fills(BlendMode blendMode, Type type, Color color) {
        this.blendMode = blendMode;
        this.type = type;
        this.color = color;
    }

    public BlendMode getBlendMode() {
        return blendMode;
    }

    public void setBlendMode(BlendMode blendMode) {
        this.blendMode = blendMode;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
