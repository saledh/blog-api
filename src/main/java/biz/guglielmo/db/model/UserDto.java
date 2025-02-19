package biz.guglielmo.db.model;

public class UserDto {
    private Long id;
    private Integer tenantId;
    private String email;
    private String password;
    private Integer roleId;

    public UserDto() {

    }

    public UserDto(Long id, Integer tenantId, String email, String password, Integer roleId) {
        this.id = id;
        this.tenantId = tenantId;
        this.email = email;
        this.password = password;
        this.roleId = roleId;
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

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
