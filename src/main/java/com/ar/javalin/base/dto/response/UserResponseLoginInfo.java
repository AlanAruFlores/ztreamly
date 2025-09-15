package com.ar.javalin.base.dto.response;

import com.google.auto.value.AutoValue.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class UserResponseLoginInfo {
    Long id;
    String username;
    String email;
    String telephone;
    String phone;
    String birthdate;
    String country;
    String role;
}
