package biz.guglielmo.service.model.article;

public class ArticleLink {
    private final long id;
    private final String title;
    private final String link;

    public ArticleLink(long id, String title, String link) {
        this.id = id;
        this.title = title;
        this.link = link;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }
}
