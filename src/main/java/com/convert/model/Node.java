package com.convert.model;

import com.convert.model.enuns.BlendMode;
import com.fasterxml.jackson.annotation.*;

/**
 * Class that extends Node and is
 * responsible to create a figma
 * node by Type
 * @author Lucas Gomes
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "type",
        visible = true
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
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Node {

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("type")
    private String type;
    @JsonProperty("children")
    private Node[] children;
    @JsonProperty("blendMode")
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
