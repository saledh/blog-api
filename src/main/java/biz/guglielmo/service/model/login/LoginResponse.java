package biz.guglielmo.service.model.login;

public class LoginResponse {
    private final String auth;

    public LoginResponse(String auth) {
        this.auth = auth;
    }

    public String getAuth() {
        return auth;
    }
}
