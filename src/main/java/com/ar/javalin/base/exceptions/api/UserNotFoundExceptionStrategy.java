package com.ar.javalin.base.exceptions.api;

import com.ar.javalin.base.dto.response.ErrorResponseDto;
import com.ar.javalin.base.exceptions.api.exceptions.UserNotFoundException;
import io.javalin.http.Context;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserNotFoundExceptionStrategy implements ExceptionHandlerStrategy<UserNotFoundException> {
    
    @Override
    public void handle(UserNotFoundException exception, Context ctx) {
        // Log the exception or perform any other necessary actions
        log.error("NotFoundException occurred: " + exception.getMessage());
        

        ctx.status(404).json(
            ErrorResponseDto.builder()
            .code(404)
            .message(exception.getMessage())
            .build()
        );
    }
}
