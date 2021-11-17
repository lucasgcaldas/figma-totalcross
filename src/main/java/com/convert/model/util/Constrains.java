package com.convert.model.util;

import com.convert.model.enuns.Horizontal;
import com.convert.model.enuns.Vertical;

public class Constrains {

    private Vertical vertical;
    private Horizontal horizontal;

    public Constrains(Vertical vertical, Horizontal horizontal) {
        this.vertical = vertical;
        this.horizontal = horizontal;
    }

    public Vertical getVertical() {
        return vertical;
    }

    public void setVertical(Vertical vertical) {
        this.vertical = vertical;
    }

    public Horizontal getHorizontal() {
        return horizontal;
    }

    public void setHorizontal(Horizontal horizontal) {
        this.horizontal = horizontal;
    }
}
