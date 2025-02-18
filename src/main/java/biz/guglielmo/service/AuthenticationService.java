package biz.guglielmo.service;

import biz.guglielmo.service.model.login.LoginRequest;
import biz.guglielmo.service.model.login.LoginResponse;
import biz.guglielmo.service.model.user.UserResponse;

public interface AuthenticationService {
    LoginResponse login(final LoginRequest request);
    UserResponse getUserById(long id);
}
