package com.ar.javalin.base.mappers;

import com.ar.javalin.base.dto.request.UserRequestLogin;
import com.ar.javalin.base.dto.response.UserResponseLoginInfo;
import com.ar.javalin.base.models.User;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-14T21:08:55-0300",
    comments = "version: 1.6.0.Beta1, compiler: Eclipse JDT (IDE) 3.43.0.v20250819-1513, environment: Java 21.0.8 (Eclipse Adoptium)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public UserRequestLogin toUserRequestLoginFromUser(User user) {
        if ( user == null ) {
            return null;
        }

        UserRequestLogin userRequestLogin = new UserRequestLogin();

        userRequestLogin.setPassword( user.getPassword() );
        userRequestLogin.setUsername( user.getUsername() );

        return userRequestLogin;
    }

    @Override
    public User toUserFromUserRequestLogin(UserRequestLogin userRequestLogin) {
        if ( userRequestLogin == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.password( userRequestLogin.getPassword() );
        user.username( userRequestLogin.getUsername() );

        return user.build();
    }

    @Override
    public UserResponseLoginInfo toUserResponseLoginInfoFromUser(User user) {
        if ( user == null ) {
            return null;
        }

        UserResponseLoginInfo userResponseLoginInfo = new UserResponseLoginInfo();

        userResponseLoginInfo.setBirthdate( user.getBirthdate() );
        userResponseLoginInfo.setCountry( user.getCountry() );
        userResponseLoginInfo.setEmail( user.getEmail() );
        userResponseLoginInfo.setId( user.getId() );
        userResponseLoginInfo.setPhone( user.getPhone() );
        userResponseLoginInfo.setRole( user.getRole() );
        userResponseLoginInfo.setTelephone( user.getTelephone() );
        userResponseLoginInfo.setUsername( user.getUsername() );

        return userResponseLoginInfo;
    }
}
