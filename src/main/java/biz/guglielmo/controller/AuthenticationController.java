package biz.guglielmo.controller;

import biz.guglielmo.db.model.UserDto;
import biz.guglielmo.service.AuthenticationService;
import biz.guglielmo.service.AuthenticationServiceImpl;
import biz.guglielmo.service.model.login.LoginRequest;
import biz.guglielmo.service.model.login.LoginResponse;
import biz.guglielmo.service.model.user.UserResponse;
import io.jooby.annotation.GET;
import io.jooby.annotation.POST;
import io.jooby.annotation.Path;
import io.jooby.annotation.PathParam;

@Path("/api/auth")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    public AuthenticationController() {
        this.authenticationService = new AuthenticationServiceImpl();
    }

    @GET("/user/{id}")
    public UserResponse getUserById(@PathParam long id) {
        return authenticationService.getUserById(id);
    }

    @POST("/login")
    public LoginResponse login(LoginRequest request) {
        return authenticationService.login(request);
    }
}
