package biz.guglielmo.controller;

@io.jooby.annotation.Generated(AuthenticationController.class)
public class AuthenticationController_ implements io.jooby.MvcExtension, io.jooby.MvcFactory<AuthenticationController> {
    protected final java.util.function.Function<io.jooby.Context, AuthenticationController> factory;

    public AuthenticationController_() {
      this(new AuthenticationController());
    }

    public AuthenticationController_(AuthenticationController instance) {
        this(ctx -> instance);
    }

    public AuthenticationController_(java.util.function.Supplier<AuthenticationController> provider) {
        this(ctx -> provider.get());
    }

    public AuthenticationController_(java.util.function.Function<io.jooby.Context, AuthenticationController> factory) {
        this.factory = factory;
    }

    public void install(io.jooby.Jooby app) throws Exception {
      /** See {@link AuthenticationController#getUserById(long) */
      app.get("/api/auth/user/{id}", this::getUserById)
        .setMvcMethod(new io.jooby.Route.MvcMethod(biz.guglielmo.controller.AuthenticationController.class, "getUserById", biz.guglielmo.service.model.user.UserResponse.class, long.class));

      /** See {@link AuthenticationController#login(biz.guglielmo.service.model.login.LoginRequest) */
      app.post("/api/auth/login", this::login)
        .setMvcMethod(new io.jooby.Route.MvcMethod(biz.guglielmo.controller.AuthenticationController.class, "login", biz.guglielmo.service.model.login.LoginResponse.class, biz.guglielmo.service.model.login.LoginRequest.class));
    }

    public biz.guglielmo.service.model.user.UserResponse getUserById(io.jooby.Context ctx) {
      var c = this.factory.apply(ctx);
      return c.getUserById(ctx.path("id").longValue());
    }

    public biz.guglielmo.service.model.login.LoginResponse login(io.jooby.Context ctx) {
      var c = this.factory.apply(ctx);
      return c.login(ctx.body(biz.guglielmo.service.model.login.LoginRequest.class));
    }

    public boolean supports(Class<AuthenticationController> type) {
        return type == AuthenticationController.class;
    }

    public io.jooby.Extension create(java.util.function.Supplier<AuthenticationController> provider) {
        return new AuthenticationController_(provider);
    }
}
