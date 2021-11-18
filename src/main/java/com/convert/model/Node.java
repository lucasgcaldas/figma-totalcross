package com.convert.model;

import com.convert.model.enuns.BlendMode;
import com.convert.model.enuns.Type;

public class Node {

    private String id;
    private String name;
    private String type;
    private Node[] children;
    private BlendMode blendMode;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public Node[] getChildren() {
        return children;
    }

    public BlendMode getBlendMode() {
        return blendMode;
    }
}
