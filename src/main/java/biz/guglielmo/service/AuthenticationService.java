package biz.guglielmo.service;

import biz.guglielmo.service.model.login.LoginRequest;
import biz.guglielmo.service.model.login.LoginResponse;

public interface AuthenticationService {
    LoginResponse login(final LoginRequest request);
}
