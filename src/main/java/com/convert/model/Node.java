package com.convert.model;

import com.convert.model.enuns.BlendMode;
import com.convert.model.enuns.Type;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = FigmaCanvas.class, name = "CANVAS"),
        @JsonSubTypes.Type(value = FigmaFrame.class, name = "FRAME"),
        @JsonSubTypes.Type(value = FigmaInstance.class, name = "INSTANCE"),
        @JsonSubTypes.Type(value = FigmaText.class, name = "TEXT"),
        @JsonSubTypes.Type(value = Node.class, name = "VECTOR"),
        @JsonSubTypes.Type(value = FigmaFrame.class, name = "RECTANGLE"),
        @JsonSubTypes.Type(value = Node.class, name = "GROUP"),
        @JsonSubTypes.Type(value = Node.class, name = "ELLIPSE"),
        @JsonSubTypes.Type(value = Node.class, name = "COMPONENT"),
}
)
@JsonPropertyOrder("type")
public class Node {

    private String id;
    private String name;
    private String type;
    private Node[] children;
    private BlendMode blendMode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Node[] getChildren() {
        return children;
    }

    public void setChildren(Node[] children) {
        this.children = children;
    }

    public BlendMode getBlendMode() {
        return blendMode;
    }

    public void setBlendMode(BlendMode blendMode) {
        this.blendMode = blendMode;
    }
}
