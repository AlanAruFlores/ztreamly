package com.ar.javalin.base.settings;

public interface ApplicationSettings {
    int getPort();
    String getHtmlResourcePath();
    String getCssResourcePath();
    String getJsResourcePath();
    String getImgResourcePath();
    String getFontsResourcePath();
    int getH2Port();
}
