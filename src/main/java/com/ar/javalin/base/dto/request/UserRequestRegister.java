package com.ar.javalin.base.dto.request;

import com.google.auto.value.AutoValue.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class UserRequestRegister {    
    String username;
    String password;
    String email;
    String telephone;
    String phone;
    String birthdate;
    String country;
}
