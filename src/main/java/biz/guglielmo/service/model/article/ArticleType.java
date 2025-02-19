package biz.guglielmo.service.model.article;

public enum ArticleType {
    INFORMATIVE("IF"),
    TECNICAL("TC"),
    REVIEW("RW");

    public final String code;

    ArticleType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return this.code;
    }
}
