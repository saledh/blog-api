package biz.guglielmo.util;

public class AuthUser {
    private final long userId;
    private final int tenantId;
    private final int roleId;

    public AuthUser(long userId, int tenantId, int roleId) {
        this.userId = userId;
        this.tenantId = tenantId;
        this.roleId = roleId;
    }

    public long getUserId() {
        return userId;
    }

    public int getTenantId() {
        return tenantId;
    }

    public int getRoleId() {
        return roleId;
    }
}
