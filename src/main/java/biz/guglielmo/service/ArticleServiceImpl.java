package biz.guglielmo.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.typesafe.config.Config;

import biz.guglielmo.service.model.article.ArticleTypeFactory;
import biz.guglielmo.service.model.article.GetArticleResponse;
import io.jooby.Environment;
import io.jooby.EnvironmentOptions;

public class ArticleServiceImpl implements ArticleService {

    @Override
    public GetArticleResponse getArticleById(long id) {
        Environment env = Environment.loadEnvironment(new EnvironmentOptions());
        Config conf = env.getConfig();
        final String dbUrl = conf.getString("db.url");
        final String dbUser = conf.getString("db.user");
        final String dbPassword = conf.getString("db.password");

        GetArticleResponse response = new GetArticleResponse();

        String query = String.format("select * from ARTICLE where ID = %d", id);

        try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
                PreparedStatement statement = connection.prepareStatement(query);
                ResultSet rs = statement.executeQuery();) {

            if (rs.next()) {
                long articleId = rs.getLong("id");
                long userId = rs.getLong("user_id");
                String title = rs.getString("title");
                String content = rs.getString("content");
                String type = rs.getString("type");
                String imageUrl = rs.getString("image_url");
                String code = rs.getString("code");
                Integer rating = rs.getInt("rating");

                response.setId(articleId);
                response.setUserId(userId);
                response.setTitle(title);
                response.setContent(content);
                response.setType(ArticleTypeFactory.fromCode(type));
                response.setImageUrl(imageUrl);
                response.setCode(code);
                response.setRating(rating);

                // TODO: leggere anche i riferimenti e i link
                // TODO: aggiungere alla response anche i riferimenti e i link
            }

            return response;
        } catch (SQLException exception) {
            // TODO: loggare eccezione
            // TODO: rilanciare eccezione custom
            System.out.println("Eccezione SQL in ArticleService.getArticleById()");
            throw new RuntimeException(exception);
        }
    }

}
