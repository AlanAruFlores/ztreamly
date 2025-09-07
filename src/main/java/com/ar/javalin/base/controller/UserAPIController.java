package com.ar.javalin.base.controller;

import com.ar.javalin.base.models.User;
import com.truncon.javalin.mvc.api.Controller;
import com.truncon.javalin.mvc.api.HttpPost;
import com.truncon.javalin.mvc.api.FromBody;
import com.truncon.javalin.mvc.api.ActionResult;
import com.truncon.javalin.mvc.api.ContentResult;

@Controller(prefix = "/api/users")
public class UserAPIController {
    
    @HttpPost(route = "/")
    public ActionResult createUser(@FromBody User user) {
        return new ContentResult("User created successfully",200);
    }
}