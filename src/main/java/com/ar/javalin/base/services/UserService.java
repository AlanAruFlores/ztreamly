package com.ar.javalin.base.services;

import java.util.Optional;

import com.ar.javalin.base.dto.request.UserRequestLogin;
import com.ar.javalin.base.dto.response.UserResponseLoginInfo;
import com.ar.javalin.base.mappers.UserMapper;
import com.ar.javalin.base.models.User;
import com.ar.javalin.base.persistence.UserRepository;
import com.ar.javalin.base.utils.annotations.ApiService;
import com.google.inject.Inject;
import lombok.extern.slf4j.Slf4j;

@ApiService
@Slf4j
public class UserService {
    
    private final UserRepository userRepository;
    private final UserMapper userMapper;


    @Inject
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
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

    public Optional<UserResponseLoginInfo> login(UserRequestLogin userRequestLogin){
        try{
            log.info("Logging in user: {}", userRequestLogin.getUsername());
            User user = userMapper.toUserFromUserRequestLogin(userRequestLogin);
            Optional<User> result = userRepository.findByUsernameAndPassword(user);
            if(!result.isPresent()){
                log.warn("Invalid username or password for user: {}", userRequestLogin.getUsername());
                return Optional.empty();
            }

            log.info("User logged in successfully: {}", userRequestLogin.getUsername());
            return Optional.of(userMapper.toUserResponseLoginInfoFromUser(result.get()));
        }catch(Exception e){
            log.error("Error logging in user: {}", e.getMessage());
            return Optional.empty();
        }
    }
}
