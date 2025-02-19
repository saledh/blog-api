package biz.guglielmo;

import biz.guglielmo.config.CorsFilterConfig;
import biz.guglielmo.controller.ArticleController_;
import biz.guglielmo.controller.AuthenticationController_;
import biz.guglielmo.filters.AuthFilter;
import biz.guglielmo.filters.GsonFilter;
import io.jooby.Jooby;
import io.jooby.netty.NettyServer;
import io.jooby.hikari.HikariModule;
import io.jooby.flyway.FlywayModule;
import io.jooby.handler.CorsHandler;
import io.jooby.jackson.*;

public class Main extends Jooby {
    {
        install(new NettyServer());
        install(new HikariModule());
        install(new FlywayModule());
        install(new JacksonModule());

        CorsFilterConfig corsConfig = new CorsFilterConfig();
        use(new CorsHandler(corsConfig.getCors()));

        use(new GsonFilter());
        use(new AuthFilter());

        mvc(new AuthenticationController_());
        mvc(new ArticleController_());

    }

    public static void main(final String[] args) {
        runApp(args, Main::new);
    }
}
