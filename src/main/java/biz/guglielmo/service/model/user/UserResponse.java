package biz.guglielmo.service.model.user;

public class UserResponse {
    private final long id;
    private final int tenantId;
    private final String email;
    private final Integer roleId;

    public UserResponse(long id, int tenantId, String email, Integer roleId) {
        this.id = id;
        this.tenantId = tenantId;
        this.email = email;
        this.roleId = roleId;
    }

    public long getId() {
        return id;
    }

    public int getTenantId() {
        return tenantId;
    }

    public String getEmail() {
        return email;
    }

    public Integer getRoleId() {
        return roleId;
    }

}
