package com.ar.javalin.base;

import com.ar.javalin.base.controller.UserAPIController;
import com.ar.javalin.base.controller.ViewController;
import com.google.inject.AbstractModule;
import com.truncon.javalin.mvc.api.MvcModule;

@MvcModule
public final class RequestModule extends AbstractModule{
    
    @Override
    protected void configure(){
        super.configure();  

        // Bind controllers to the Guice injector
        bind(ViewController.class);
        bind(UserAPIController.class);
    }
}
