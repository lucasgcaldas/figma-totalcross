package com.convert.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Application {

    private Document document;
    private Integer schemaVersion;
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
