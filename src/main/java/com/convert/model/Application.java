package com.convert.model;

public class Application {

    private Document document;
//    private Components[] components;
//    private String[] componentSets;
    private Integer schemaVersion;
//    private Style[] styles;
    private String name;
    private String lastModified;
    private String thumbnailUrl;
    private String version;
    private String role;
    private String editorType;

    public Document getDocument() {
        return document;
    }

    public Integer getSchemaVersion() {
        return schemaVersion;
    }

    public String getName() {
        return name;
    }

    public String getLastModified() {
        return lastModified;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public String getVersion() {
        return version;
    }

    public String getRole() {
        return role;
    }

    public String getEditorType() {
        return editorType;
    }
}
