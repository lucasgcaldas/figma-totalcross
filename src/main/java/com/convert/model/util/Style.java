package com.convert.model.util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Class responsible for instantiate
 * a Style proprieties
 * @author Lucas Gomes
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Style {

    private String fontFamily;
    private Integer fontSize;

    public String getFontFamily() {
        return fontFamily;
    }

    public Integer getFontSize() {
        return fontSize;
    }
}
