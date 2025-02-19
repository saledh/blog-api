package biz.guglielmo.service.model.article;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class ArticleTypeFactory {
    private static final Map<String, ArticleType> REVERSE_MAP;

    static {
        final ArticleType[] all = ArticleType.values();
        final Map<String, ArticleType> map = new HashMap<>();

        String key;
        for (ArticleType value : all) {
            key = value.getCode();
            map.put(key, value);
        }
        REVERSE_MAP = Collections.unmodifiableMap(map);
    }

    public static ArticleType fromCode(final String code) {
        return REVERSE_MAP.get(code);
    }

    private ArticleTypeFactory() {
    }
}
