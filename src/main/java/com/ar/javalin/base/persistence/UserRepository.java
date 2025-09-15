package com.ar.javalin.base.persistence;

import java.util.Optional;

import javax.inject.Inject;

import com.ar.javalin.base.models.User;
import com.ar.javalin.base.utils.annotations.ApiRepository;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

@ApiRepository
@Slf4j
public class UserRepository {

    private EntityManager entityManager;

    @Inject
    public UserRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Optional<User> save(User user){
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(user);
            entityManager.getTransaction().commit();
            log.info("Saving user: {}", user.getUsername());
        } catch (Exception e) {
            log.error("Error saving user: {}", e.getMessage());
            return Optional.empty();
        }
        
        return Optional.of(user);
    }

    public Optional<User> findByUsernameAndPassword(User user){
        try {
            User foundUser = entityManager.createQuery("SELECT u FROM User u WHERE u.username = :username AND u.password = :password", User.class)
                .setParameter("username", user.getUsername())
                .setParameter("password", user.getPassword())
                .getSingleResult();
            log.info("User found: {}", user.getUsername());
            return Optional.of(foundUser);
        } catch (Exception e) {
            log.error("Error finding user: {}", e.getMessage());
            return Optional.empty();
        }      
    }
    
} 