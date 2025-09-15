package com.ar.javalin.base.mappers;

import com.ar.javalin.base.dto.request.UserRequestLogin;
import com.ar.javalin.base.dto.request.UserRequestRegister;
import com.ar.javalin.base.dto.response.UserResponseInfo;
import com.ar.javalin.base.models.User;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-14T21:37:09-0300",
    comments = "version: 1.6.0.Beta1, compiler: Eclipse JDT (IDE) 3.43.0.v20250819-1513, environment: Java 21.0.8 (Eclipse Adoptium)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public User toUserFromUserRequestRegister(UserRequestRegister userRequestRegister) {
        if ( userRequestRegister == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.birthdate( userRequestRegister.getBirthdate() );
        user.country( userRequestRegister.getCountry() );
        user.email( userRequestRegister.getEmail() );
        user.password( userRequestRegister.getPassword() );
        user.phone( userRequestRegister.getPhone() );
        user.telephone( userRequestRegister.getTelephone() );
        user.username( userRequestRegister.getUsername() );

        return user.build();
    }

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
    public UserResponseInfo toUserResponseInfoFromUser(User user) {
        if ( user == null ) {
            return null;
        }

        UserResponseInfo userResponseInfo = new UserResponseInfo();

        userResponseInfo.setBirthdate( user.getBirthdate() );
        userResponseInfo.setCountry( user.getCountry() );
        userResponseInfo.setEmail( user.getEmail() );
        userResponseInfo.setId( user.getId() );
        userResponseInfo.setPhone( user.getPhone() );
        userResponseInfo.setRole( user.getRole() );
        userResponseInfo.setTelephone( user.getTelephone() );
        userResponseInfo.setUsername( user.getUsername() );

        return userResponseInfo;
    }
}
