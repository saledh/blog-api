package biz.guglielmo.service.model.user;

public class UserResponse {
    private final long id;
    private final int tenantId;
    private final String email;
    private final boolean isAdmin;
    private final boolean isEditor;

    public UserResponse(long id, int tenantId, String email, boolean isAdmin, boolean isEditor) {
        this.id = id;
        this.tenantId = tenantId;
        this.email = email;
        this.isAdmin = isAdmin;
        this.isEditor = isEditor;
    }
}
