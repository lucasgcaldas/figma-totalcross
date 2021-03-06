package com.convert.model;

import com.convert.model.enuns.Type;

/**
 * Class responsible to instantiate
 * a Document from Figma API
 * @author Lucas Gomes
 */
public class Document {

    private String id;
    private String name;
    private Type type;
    private Node[] children;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public Node[] getChildren() {
        return children;
    }
}
