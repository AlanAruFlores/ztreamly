package com.truncon.javalin.mvc;

import com.ar.javalin.base.controller.UserAPIController;
import com.ar.javalin.base.controller.ViewController;
import com.truncon.javalin.mvc.api.ActionResult;
import com.truncon.javalin.mvc.api.HttpContext;
import com.truncon.javalin.mvc.api.HttpRequest;
import com.truncon.javalin.mvc.api.Injector;
import io.javalin.Javalin;
import io.javalin.http.Context;
import jakarta.annotation.Generated;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Override;
import java.util.function.Supplier;

@Generated("com.truncon.javalin.mvc.annotations.processing.ControllerProcessor")
public final class JavalinControllerRegistry implements ControllerRegistry {
    private final Supplier<Injector> scopeFactory;

    public JavalinControllerRegistry(Supplier<Injector> scopeFactory) {
        this.scopeFactory = scopeFactory;
    }

    private static <T> T toJson(HttpContext context, Class<T> type) {
        try {
            HttpRequest request = context.getRequest();
            return request.getBodyFromJson(type);
        } catch (Exception exception) {
            return null;
        }
    }

    private void httpHandler0(Context ctx) throws Exception {
        Injector injector = scopeFactory.get();
        HttpContext wrapper = new JavalinHttpContext(ctx);
        UserAPIController controller = injector.getInstance(UserAPIController.class);
        ActionResult result = controller.createUser(toJson(wrapper, com.ar.javalin.base.models.User.class));
        result.execute(wrapper);
    }

    private void httpHandler1(Context ctx) throws Exception {
        Injector injector = scopeFactory.get();
        HttpContext wrapper = new JavalinHttpContext(ctx);
        UserAPIController controller = injector.getInstance(UserAPIController.class);
        ActionResult result = controller.loginUser(toJson(wrapper, com.ar.javalin.base.dto.request.UserRequestLogin.class));
        result.execute(wrapper);
    }

    private void httpHandler2(Context ctx) throws Exception {
        HttpContext wrapper = new JavalinHttpContext(ctx);
        ViewController controller = new ViewController();
        ActionResult result = controller.getHomePage();
        result.execute(wrapper);
    }

    private void httpHandler3(Context ctx) throws Exception {
        HttpContext wrapper = new JavalinHttpContext(ctx);
        ViewController controller = new ViewController();
        ActionResult result = controller.getLoginPage();
        result.execute(wrapper);
    }

    private void httpHandler4(Context ctx) throws Exception {
        HttpContext wrapper = new JavalinHttpContext(ctx);
        ViewController controller = new ViewController();
        ActionResult result = controller.getRegisterPage();
        result.execute(wrapper);
    }

    @Override
    public void register(Javalin app) {
        app.post("/api/users/register", this::httpHandler0);
        app.post("/api/users/login", this::httpHandler1);
        app.get("/", this::httpHandler2);
        app.get("/login", this::httpHandler3);
        app.get("/register", this::httpHandler4);
    }
}
