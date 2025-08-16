package com.ar.javalin.base.utils;

import com.ar.javalin.base.AppModule;
import com.ar.javalin.base.settings.AppSettings;
import com.google.inject.Guice;
import com.google.inject.Injector;
import lombok.experimental.UtilityClass;


@UtilityClass
public final class PathUtilsConstants {

    public static String WEB_RESOURCE_PATH;
    public static String CSS_RESOURCE_PATH;
    public static String JS_RESOURCE_PATH;
    public static String IMG_RESOURCE_PATH;
    public static String FONTS_RESOURCE_PATH;

    static {
        loadResources();
    }

    private static void loadResources(){
        Injector injector = Guice.createInjector(new AppModule());
        AppSettings settings =  injector.getInstance(AppSettings.class);

        WEB_RESOURCE_PATH = settings.getHtmlResourcePath();
        CSS_RESOURCE_PATH = settings.getCssResourcePath();
        JS_RESOURCE_PATH = settings.getJsResourcePath();
        IMG_RESOURCE_PATH = settings.getImgResourcePath();
        FONTS_RESOURCE_PATH = settings.getFontsResourcePath();
    }

}
