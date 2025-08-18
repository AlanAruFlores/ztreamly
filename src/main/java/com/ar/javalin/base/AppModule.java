package com.ar.javalin.base;

import com.ar.javalin.base.configuration.DataInitializerConfiguration;
import com.ar.javalin.base.configuration.H2ConsoleConfiguration;
import com.ar.javalin.base.configuration.PersistenceLoadConfigurationProvider;
import com.ar.javalin.base.exceptions.api.ExceptionHandlerContext;
import com.ar.javalin.base.persistence.UserRepository;
import com.ar.javalin.base.persistence.VideoRepository;
import com.ar.javalin.base.settings.AppSettings;
import com.ar.javalin.base.settings.ApplicationSettings;
import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.google.inject.Singleton;
import com.truncon.javalin.mvc.api.Injector;

import jakarta.persistence.EntityManager;

public final class AppModule extends AbstractModule{
    
    @Override
    protected void configure() {
        super.configure();

        //Providers
        bind(Injector.class).toProvider(RequestInjectorProvider.class);
        bind(PersistenceLoadConfigurationProvider.class).in(Scopes.SINGLETON);
        bind(EntityManager.class).toProvider(PersistenceLoadConfigurationProvider.class);


        bind(JavalinFactory.class);
        bind(App.class);
        bind(H2ConsoleConfiguration.class).in(Scopes.SINGLETON);
        bind(ApplicationSettings.class).to(AppSettings.class);
        bind(AppSettings.class).toProvider(AppSettings::newInstance).in(Scopes.SINGLETON);
        bind(DataInitializerConfiguration.class).in(Scopes.SINGLETON);

        //Repositories
        bind(UserRepository.class).in(Singleton.class);
        bind(VideoRepository.class).in(Singleton.class);


        //Exception Handler
        bind(ExceptionHandlerContext.class).toProvider(ExceptionHandlerContext::newInstance).in(Scopes.SINGLETON);
    }

}
