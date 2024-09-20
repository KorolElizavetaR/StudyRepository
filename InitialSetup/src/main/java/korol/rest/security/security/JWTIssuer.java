package korol.rest.security.security;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

@Component
public class JWTIssuer {
	public String issue(long userId, String username, List<String> authorities)
	{
		return JWT.create().
				withSubject(String.valueOf(userId)).
				withExpiresAt(Instant.now().plus(Duration.of(1, ChronoUnit.DAYS))).
				withClaim("un", username).
				withClaim("roles", authorities).
				sign(Algorithm.HMAC256("secret"));
	}
}
