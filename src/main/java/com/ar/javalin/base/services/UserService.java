package com.ar.javalin.base.services;

import java.util.Optional;

import com.ar.javalin.base.models.User;
import com.ar.javalin.base.persistence.UserRepository;
import com.ar.javalin.base.utils.annotations.ApiService;
import com.google.inject.Inject;
import lombok.extern.slf4j.Slf4j;

@ApiService
@Slf4j
public class UserService {
    
    private final UserRepository userRepository;

    @Inject
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> save(User user) {
        try{
            log.info("Saving user: {}", user.getUsername());
            return userRepository.save(user);
        }catch(Exception e){
            log.error("Error saving user: {}", e.getMessage());
            return Optional.empty();
        }
    }
}
