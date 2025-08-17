package com.ar.javalin.base.configuration;

import com.ar.javalin.base.utils.annotations.Profile;
import com.google.inject.Provider;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lombok.extern.slf4j.Slf4j;
import org.reflections.Reflections;

import java.util.Set;

@Slf4j
public final class PersistenceLoadConfigurationProvider implements Provider<EntityManager>{
    
    private EntityManagerFactory emf;

    public void load() {
        String activeProfile = System.getenv("PROFILE") != null ? System.getenv("PROFILE") : "dev";
        Reflections reflections = new Reflections("com.ar.javalin.base.configuration");

        Set<Class<? extends PersistenceConfiguration>> configs = reflections.getSubTypesOf(PersistenceConfiguration.class);

        for (Class<? extends PersistenceConfiguration> configClass : configs) {
            Profile profile = configClass.getAnnotation(Profile.class);
            if (profile != null && profile.value().equals(activeProfile)) {
                try {
                    log.info("Loading persistence to profile: {}", activeProfile);
                    PersistenceConfiguration configInstance = configClass.getDeclaredConstructor().newInstance();
                    emf = configInstance.configure();
                    log.info("Persistence loaded successfully");
                } catch (Exception e) {
                    log.error("Error to load the persistence: {}", e.getMessage());
                }
            }
        }
    }
    
    @Override
    public EntityManager get() {
        if (emf == null) {
            load();
        }
        return emf.createEntityManager();
    }
}
