package biz.guglielmo.config;

import io.jooby.handler.Cors;

public class CorsFilterConfig {
    private final Cors cors;

    public CorsFilterConfig() {
        this.cors = new Cors()
                .setHeaders("X-Requested-With", "Content-Type", "Accept", "Origin", "Authorization")
                .setMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
    }

    public Cors getCors() {
        return cors;
    }
}
