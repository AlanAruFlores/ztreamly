package com.ar.javalin.base.controller;

import com.ar.javalin.base.models.User;
import com.truncon.javalin.mvc.api.Controller;
import com.truncon.javalin.mvc.api.HttpPost;
import com.truncon.javalin.mvc.api.FromBody;
import com.truncon.javalin.mvc.api.ActionResult;
import com.truncon.javalin.mvc.api.ContentResult;
import com.ar.javalin.base.services.UserService;
import com.google.inject.Inject;

@Controller(prefix = "/api/users")
public class UserAPIController {
    
    private final UserService userService;

    @Inject
    public UserAPIController(UserService userService) {
        this.userService = userService;
    }

    @HttpPost(route = "/")
    public ActionResult createUser(@FromBody User user) {
        userService.save(user);
        return new ContentResult("User created successfully",200);
    }
}