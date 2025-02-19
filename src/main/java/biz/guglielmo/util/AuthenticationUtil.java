package biz.guglielmo.util;

import biz.guglielmo.jwt.JwtToken;
import biz.guglielmo.jwt.JwtTokenUtil;

public final class AuthenticationUtil {
    public static AuthUser gAuthUser(String jwtToken) {
        JwtToken validJwtToken = JwtTokenUtil.getTokenFromBearer(jwtToken);
        long userId = validJwtToken.getUserId();
        int tenantId = validJwtToken.getTenantId();
        int roleId = validJwtToken.getRoleId();
        return new AuthUser(userId, tenantId, roleId);
    }
}
