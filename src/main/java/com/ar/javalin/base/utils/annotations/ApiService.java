package com.ar.javalin.base.utils.annotations;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.truncon.javalin.mvc.api.MvcComponent;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@MvcComponent
public @interface ApiService {
    
}
