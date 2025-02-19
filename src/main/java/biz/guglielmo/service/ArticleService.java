package biz.guglielmo.service;

import biz.guglielmo.service.model.article.GetArticleResponse;

public interface ArticleService {
    GetArticleResponse getArticleById(long id);
}
