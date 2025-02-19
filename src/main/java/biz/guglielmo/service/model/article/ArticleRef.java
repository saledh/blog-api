package biz.guglielmo.service.model.article;

public class ArticleRef {
    private final long id;
    private final long citedArticleId;

    public ArticleRef(long id, long citedArticleId) {
        this.id = id;
        this.citedArticleId = citedArticleId;
    }

    public long getId() {
        return id;
    }

    public long getCitedArticleId() {
        return citedArticleId;
    }
}
