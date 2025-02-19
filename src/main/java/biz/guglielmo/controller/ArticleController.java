package biz.guglielmo.controller;

import biz.guglielmo.jwt.JwtToken;
import biz.guglielmo.jwt.JwtTokenUtil;
import biz.guglielmo.service.ArticleService;
import biz.guglielmo.service.ArticleServiceImpl;
import biz.guglielmo.service.model.article.GetArticleResponse;
import biz.guglielmo.util.AuthUser;
import biz.guglielmo.util.AuthenticationUtil;
import io.jooby.annotation.DELETE;
import io.jooby.annotation.GET;
import io.jooby.annotation.HeaderParam;
import io.jooby.annotation.POST;
import io.jooby.annotation.PUT;
import io.jooby.annotation.Path;
import io.jooby.annotation.PathParam;

@Path("/article")
public class ArticleController {
    private final ArticleService articleService;

    public ArticleController() {
        this.articleService = new ArticleServiceImpl();
    }

    @GET("/{id}")
    public GetArticleResponse getArticle(@PathParam Long id) {
        return articleService.getArticleById(id);
    }

    @POST
    public void createArticle(@HeaderParam("Authorization") String authorization) {
        AuthUser user = AuthenticationUtil.gAuthUser(authorization);

    }

    @PUT
    public void updateArticle(@HeaderParam("Authorization") String authorization) {

    }

    @DELETE
    public void deleteArticle(@HeaderParam("Authorization") String authorization) {

    }
}
