package biz.guglielmo.service;

import biz.guglielmo.db.model.UserDto;
import biz.guglielmo.service.model.user.UserResponse;

public interface UserService {
    UserResponse getUserByEmailAndPwd(String email, String password);
}
