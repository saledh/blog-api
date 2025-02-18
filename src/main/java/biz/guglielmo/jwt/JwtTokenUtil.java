package biz.guglielmo.jwt;

import java.security.Key;
import java.util.Calendar;
import java.util.Date;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import io.jooby.Environment;
import io.jooby.EnvironmentOptions;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.JwtParserBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

public final class JwtTokenUtil {
    private static final String TENANT_ID = "tenantId";
    private static final String BLOG_ADMIN = "blogAdmin";
    private static final String BLOG_EDITOR = "blogEditor";

    public static String generateJwtToken(final JwtToken token) {
        if (token == null) {
            throw new IllegalArgumentException("token is mandatory!");
        }
        Environment env = Environment.loadEnvironment(new EnvironmentOptions());
        Config conf = env.getConfig();
        final String base64Secret = conf.getString("jwt.secret");
        int timeToLiveInMinutes = conf.getInt("jwt.timeToLive");
        final String issuer = conf.getString("jwt.issuer");

        byte[] keyBytes = Decoders.BASE64.decode(base64Secret);
        Key key = Keys.hmacShaKeyFor(keyBytes);

        final Calendar calendar = Calendar.getInstance();

        calendar.add(Calendar.MINUTE, -1);
        final Date iat = calendar.getTime();

        calendar.add(Calendar.MINUTE, timeToLiveInMinutes);
        final Date expire = calendar.getTime();

        JwtBuilder builder = Jwts.builder()
                .issuer(issuer)
                .subject(Long.toString(token.getUserId()))
                .claim(TENANT_ID, Integer.toString(token.getTenantId()))
                .issuedAt(iat)
                .expiration(expire)
                .signWith(key, SignatureAlgorithm.HS256);

        if (token.isAdmin()) {
            builder.claim(BLOG_ADMIN, "true");
        } else if (token.isEditor()) {
            builder.claim(BLOG_EDITOR, "true");
        }

        final String jwtToken = builder.compact();
        return jwtToken;
    }

    public static JwtToken decodeJwtToken(final String token) {
        Config conf = ConfigFactory.load();
        final String base64Secret = conf.getString("jwt.secret");

        byte[] keyBytes = Decoders.BASE64.decode(base64Secret);

        JwtParserBuilder builder = Jwts.parser();
        JwtParser parser = builder.setSigningKey(keyBytes)
                .build();

        final Jws<Claims> result;

        try {
            result = parser.parseClaimsJws(token);
        } catch (MalformedJwtException ex) {
            System.out.println("Token is not a valid JWT string!");
            return null;
        }

        final Claims body = result.getBody();

        boolean exceptionFlag = false;

        Date iat = null;
        Date exp = null;

        try {
            iat = body.get("iat", Date.class);
            exp = body.get("exp", Date.class);
        } catch (RuntimeException ex) {
            throw new JwtException("JWT token has invalid iat or exp");
        }

        if (exceptionFlag || iat == null || exp == null) {
            System.out.println("JWT token has invalid iat or exp");
            throw new JwtException("JWT token has invalid iat or exp");
        }

        if (iat.after(new Date())) {
            System.out.println("JWT token has a future iat");
            throw new JwtException("JWT token has a future iat");
        }

        long userId = getSubject(body, token);
        int tenantId = getTenantId(body, token);
        boolean isAdmin = body.containsKey(BLOG_ADMIN) && "true".equals(body.get(BLOG_ADMIN));
        boolean isEditor = body.containsKey(BLOG_ADMIN) && "true".equals(body.get(BLOG_EDITOR));

        return new JwtToken(userId, tenantId, isAdmin, isEditor);
    }

    private static long getSubject(final Claims body, final String token) {
        String sub = body.getSubject();

        try {
            return Long.parseLong(sub);
        } catch (RuntimeException ex) {
            throw new JwtException("JWT token has invalid sub");
        }
    }

    private static int getTenantId(final Claims body, final String token) {
        String tenantId = body.get(TENANT_ID, String.class);

        try {
            return Integer.parseInt(tenantId);
        } catch (RuntimeException ex) {
            throw new JwtException("JWT token has invalid tenantId");
        }
    }
}
