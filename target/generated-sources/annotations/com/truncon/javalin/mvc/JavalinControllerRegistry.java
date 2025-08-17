package com.truncon.javalin.mvc;

import com.ar.javalin.base.controller.HomeController;
import com.truncon.javalin.mvc.api.ActionResult;
import com.truncon.javalin.mvc.api.HttpContext;
import com.truncon.javalin.mvc.api.Injector;
import io.javalin.Javalin;
import io.javalin.http.Context;
import jakarta.annotation.Generated;
import java.lang.Exception;
import java.lang.Override;
import java.util.function.Supplier;

@Generated("com.truncon.javalin.mvc.annotations.processing.ControllerProcessor")
public final class JavalinControllerRegistry implements ControllerRegistry {
    private final Supplier<Injector> scopeFactory;

    public JavalinControllerRegistry(Supplier<Injector> scopeFactory) {
        this.scopeFactory = scopeFactory;
    }

    private void httpHandler0(Context ctx) throws Exception {
        HttpContext wrapper = new JavalinHttpContext(ctx);
        HomeController controller = new HomeController();
        ActionResult result = controller.getLoginPage();
        result.execute(wrapper);
    }

    @Override
    public void register(Javalin app) {
        app.get("/", this::httpHandler0);
    }
}
