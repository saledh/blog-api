package biz.guglielmo.filters;

import io.jooby.Route.Filter;
import io.jooby.Route.Handler;
import biz.guglielmo.jwt.JwtTokenUtil;
import io.jooby.Value;

public final class AuthFilter implements Filter {

    @Override
    public Handler apply(Handler next) {
        return ctx -> {
            String path = ctx.getRequestPath();

            // Proteggo tutti i path che non siano quello per autenticarsi
            if (!"/api/auth/login".equals(path)) {
                Value value = ctx.header("Authorization");
                if (!value.isPresent()) {
                    throw new RuntimeException("Authorization is mandatory!");
                }

                JwtTokenUtil.getTokenFromBearer(value.value());

                // Se sono qui, il token era valido
            }

            Object response = next.apply(ctx);

            return response;
        };
    }

}
