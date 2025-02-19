package biz.guglielmo.service;

import biz.guglielmo.jwt.JwtToken;
import biz.guglielmo.jwt.JwtTokenUtil;
import biz.guglielmo.service.model.login.LoginRequest;
import biz.guglielmo.service.model.login.LoginResponse;
import biz.guglielmo.service.model.user.UserResponse;

public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;

    public AuthenticationServiceImpl() {
        this.userService = new UserServiceImpl();
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        String email = request.getEmail();
        String password = request.getPassword();

        UserResponse userResponse = userService.getUserByEmailAndPwd(email, password);
        long userId = userResponse.getId();
        int tenantId = userResponse.getTenantId();
        int roleId = userResponse.getRoleId();

        String auth = JwtTokenUtil.generateJwtToken(new JwtToken(userId, tenantId, roleId));

        return new LoginResponse(auth, userResponse);
    }
}
