package com.ar.javalin.base.configuration;

import javax.inject.Inject;

import com.ar.javalin.base.models.User;
import com.ar.javalin.base.models.Video;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class EntityInitalizeConfiguration {

    private EntityManager em;

    @Inject
    public EntityInitalizeConfiguration(EntityManager em) {
        this.em = em;
    }

    public void initEntityConfiguration(){
        try{
            log.info("Initializing Entity Configuration");
            em.getTransaction().begin();
            initCreatingEntities(em);
            em.getTransaction().commit();
            em.close();
            log.info("Succesfully Entity Configuration");
        }catch(Exception ex){
            log.error("Error initializing entities: {}", ex.getMessage());
        }

    }

    private void initCreatingEntities(EntityManager em) {
        em.persist(Video.builder().build());
        em.persist(User.builder().build());
    }
}
