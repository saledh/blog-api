package biz.guglielmo.filters;

import com.google.gson.Gson;

import io.jooby.MediaType;
import io.jooby.Route.Filter;
import io.jooby.Route.Handler;

public final class GsonFilter implements Filter {
    private final Gson gson;

    public GsonFilter() {
        this.gson = new Gson();
    }

    @Override
    public Handler apply(Handler next) {
        return ctx -> {
            Object result = next.apply(ctx);
            String json = gson.toJson(result);

            ctx.setDefaultResponseType(MediaType.json);

            return json;
        };
    }

}
