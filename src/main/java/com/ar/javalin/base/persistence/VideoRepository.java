package com.ar.javalin.base.persistence;

import java.util.Optional;

import javax.inject.Inject;

import com.ar.javalin.base.models.Video;
import com.ar.javalin.base.utils.annotations.ApiRepository;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

@ApiRepository
@Slf4j
public class VideoRepository {
    
    private EntityManager entityManager;

    @Inject
    public VideoRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Optional<Video> save(Video video) {
        try {
            entityManager.persist(video);
            log.info("Saving video: {}", video.getTitle());
        } catch (Exception e) {
            log.error("Error saving video: {}", e.getMessage());
            return Optional.empty();
        }
        
        return Optional.of(video);
    }
}
