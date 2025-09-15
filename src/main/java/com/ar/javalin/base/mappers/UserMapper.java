package com.ar.javalin.base.mappers;

import com.ar.javalin.base.dto.request.UserRequestLogin;
import com.ar.javalin.base.dto.response.UserResponseLoginInfo;
import com.ar.javalin.base.models.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    UserRequestLogin toUserRequestLoginFromUser(User user);
    User toUserFromUserRequestLogin(UserRequestLogin userRequestLogin);
    UserResponseLoginInfo toUserResponseLoginInfoFromUser(User user);
}
