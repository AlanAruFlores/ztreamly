package com.ar.javalin.base.configuration;

import javax.inject.Inject;

import com.ar.javalin.base.models.User;
import com.ar.javalin.base.models.Video;
import com.ar.javalin.base.persistence.UserRepository;
import com.ar.javalin.base.persistence.VideoRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DataInitializerConfiguration {
    
    private final UserRepository userRepository;
    private final VideoRepository videoRepository;

    @Inject
    public DataInitializerConfiguration (UserRepository userRepository, VideoRepository videoRepository) {
        this.userRepository = userRepository;
        this.videoRepository = videoRepository;
    }

    public void initDataConfiguration(){
        try{
            log.info("Initializing Data Configuration");
            initializeDataEntites();
            log.info("Successfully Data Configuration");
        }catch(Exception ex){
            log.error("Error initializing data: {}", ex.getMessage());
        }
    }

    private void initializeDataEntites(){
        User admin = User.builder()
        .username("admin")
        .password("admin123")
        .role("ADMIN")
        .build();

        User user = User.builder()
            .username("user")
            .password("user123")
            .role("USER")
            .picture(null)
            .build();

        userRepository.save(admin);
        userRepository.save(user);

        Video video1 = Video.builder()
            .title("Bienvenido a Streamly")
            .description("Primer video del sistema")
            .build();

        Video video2 = Video.builder()
            .title("Cómo usar la plataforma")
            .description("Tutorial inicial")
            .build();

        videoRepository.save(video1);
        videoRepository.save(video2);
    }

}
