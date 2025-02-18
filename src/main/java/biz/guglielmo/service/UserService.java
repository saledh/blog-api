package biz.guglielmo.service;

import biz.guglielmo.db.model.UserDto;

public interface UserService {
    UserDto getUserByEmailAndPwd(String email, String password);
}
