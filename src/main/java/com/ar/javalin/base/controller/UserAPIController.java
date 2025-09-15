package com.ar.javalin.base.controller;

import javax.inject.Inject;

import com.ar.javalin.base.dto.request.UserRequestLogin;
import com.ar.javalin.base.dto.response.JsonResponseDto;
import com.ar.javalin.base.dto.response.UserResponseLoginInfo;
import com.ar.javalin.base.models.User;
import com.truncon.javalin.mvc.api.Controller;
import com.truncon.javalin.mvc.api.HttpPost;
import com.truncon.javalin.mvc.api.JsonResult;
import com.truncon.javalin.mvc.api.FromBody;
import com.truncon.javalin.mvc.api.ActionResult;
import com.truncon.javalin.mvc.api.ContentResult;
import com.ar.javalin.base.services.UserService;

@Controller(prefix = "/api/users")
public class UserAPIController {
    
    private final UserService userService;

    @Inject
    public UserAPIController(UserService userService) {
        this.userService = userService;
    }

    @HttpPost(route = "/register")
    public ActionResult createUser(@FromBody User user) {
        userService.save(user);
        return new ContentResult("User created successfully",200);
    }

    @HttpPost(route = "/login")
    public ActionResult loginUser(@FromBody UserRequestLogin userToLogin){
        UserResponseLoginInfo result = userService.login(userToLogin).get();

        return new JsonResult(
            JsonResponseDto.builder()
            .status(200)
            .message("User logged successfully")
            .data(result)
            .build()
            ,200);

    }
}