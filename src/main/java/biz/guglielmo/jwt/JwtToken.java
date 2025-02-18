package biz.guglielmo.jwt;

public class JwtToken {
    private final long userId;
    private final int tenantId;
    private final boolean isAdmin;
    private final boolean isEditor;

    public JwtToken(long userId, int tenantId, boolean isAdmin, boolean isEditor) {
        this.userId = userId;
        this.tenantId = tenantId;
        this.isAdmin = isAdmin;
        this.isEditor = isEditor;
    }

    public long getUserId() {
        return userId;
    }

    public int getTenantId() {
        return tenantId;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public boolean isEditor() {
        return isEditor;
    }

}
