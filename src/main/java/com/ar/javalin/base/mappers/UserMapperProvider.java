package com.ar.javalin.base.mappers;

import com.google.inject.Provider;
import org.mapstruct.factory.Mappers;

public class UserMapperProvider implements Provider<UserMapper> {
    
    @Override
    public UserMapper get() {
        return Mappers.getMapper(UserMapper.class);
    }
}
