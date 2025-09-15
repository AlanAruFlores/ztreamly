package com.ar.javalin.base.dto.response;

import lombok.Builder;

@Builder
public class ErrorResponseDto {
    public Integer code;
    public String message;
}
