package biz.guglielmo.db.model;

public class UserDto {
    private Long id;
    private Integer tenantId;
    private String email;
    private String password;
    private boolean isAdmin;
    private boolean isEditor;

    public UserDto(Long id, Integer tenantId, String email, String password, boolean isAdmin, boolean isEditor) {
        this.id = id;
        this.tenantId = tenantId;
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
        this.isEditor = isEditor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTenantId() {
        return tenantId;
    }

    public void setTenantId(Integer tenantId) {
        this.tenantId = tenantId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public boolean isEditor() {
        return isEditor;
    }

    public void setEditor(boolean isEditor) {
        this.isEditor = isEditor;
    }

}
