package com.ar.javalin.base.dto.request;


import com.google.auto.value.AutoValue.Builder;

import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class UserRequestLogin {
    String username;
    String password;
}
