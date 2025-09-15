package com.ar.javalin.base.dto.response;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class JsonResponseDto<T> {
    Integer status;
    String message;
    T data;
}
