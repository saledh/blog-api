package biz.guglielmo.service.model.login;

import biz.guglielmo.service.model.user.UserResponse;

public class LoginResponse {
    private final String auth;
    private final UserResponse user;

    public LoginResponse(String auth, UserResponse user) {
        this.auth = auth;
        this.user = user;
    }
}
