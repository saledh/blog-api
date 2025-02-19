package biz.guglielmo.controller;

import biz.guglielmo.service.AuthenticationService;
import biz.guglielmo.service.AuthenticationServiceImpl;
import biz.guglielmo.service.model.login.LoginRequest;
import biz.guglielmo.service.model.login.LoginResponse;
import io.jooby.Jooby;
import io.jooby.annotation.POST;
import io.jooby.annotation.Path;

@Path("/api/auth")
public class AuthenticationController extends Jooby {
    private final AuthenticationService authenticationService;

    public AuthenticationController() {
        this.authenticationService = new AuthenticationServiceImpl();
    }

    @POST("/login")
    public LoginResponse login(LoginRequest request) {
        return authenticationService.login(request);
    }
}
