package biz.guglielmo.service.model.article;

import java.util.List;

public class GetArticleResponse {
    long id;
    long userId;
    String title;
    String content;
    ArticleType type;
    String imageUrl;
    String code;
    Integer rating;
    List<ArticleLink> articleLinksList;
    List<ArticleRef> articleRefssList;

    public GetArticleResponse() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ArticleType getType() {
        return type;
    }

    public void setType(ArticleType type) {
        this.type = type;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public List<ArticleLink> getArticleLinksList() {
        return articleLinksList;
    }

    public void setArticleLinksList(List<ArticleLink> articleLinksList) {
        this.articleLinksList = articleLinksList;
    }

    public List<ArticleRef> getArticleRefssList() {
        return articleRefssList;
    }

    public void setArticleRefssList(List<ArticleRef> articleRefssList) {
        this.articleRefssList = articleRefssList;
    }

}
