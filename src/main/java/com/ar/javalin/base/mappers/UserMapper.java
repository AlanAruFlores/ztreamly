package com.ar.javalin.base.mappers;

import com.ar.javalin.base.dto.request.UserRequestLogin;
import com.ar.javalin.base.dto.response.UserResponseInfo;
import com.ar.javalin.base.models.User;
import org.mapstruct.Mapper;
import com.ar.javalin.base.dto.request.UserRequestRegister;

@Mapper
public interface UserMapper {

    User toUserFromUserRequestRegister(UserRequestRegister userRequestRegister);
    UserRequestLogin toUserRequestLoginFromUser(User user);
    User toUserFromUserRequestLogin(UserRequestLogin userRequestLogin);
    UserResponseInfo toUserResponseInfoFromUser(User user);
}
