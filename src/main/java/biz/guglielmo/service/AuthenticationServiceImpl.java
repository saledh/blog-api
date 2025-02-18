package biz.guglielmo.service;

import biz.guglielmo.db.model.UserDto;
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
        String role = request.getRole();

        // TODO
        UserDto user = userService.getUserByEmailAndPwd(email, password);
        long userId = 1; // user.getId();
        int tenantId = 1; // user.getTenant();
        boolean isAdmin = true; // user.isAdmin();
        boolean isEditor = false; // user.isEditor();

        JwtToken inputToken = new JwtToken(userId, tenantId, isAdmin, isEditor);
        String auth = JwtTokenUtil.generateJwtToken(inputToken);

        return new LoginResponse(auth);
    }

    @Override
    public UserResponse getUserById(long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUserById'");
    }

}
