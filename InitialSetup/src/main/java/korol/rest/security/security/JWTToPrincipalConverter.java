package korol.rest.security.security;

import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.auth0.jwt.interfaces.DecodedJWT;

import korol.rest.security.models.UserPrincipal;

@Component
public class JWTToPrincipalConverter {
	
	public UserPrincipal convert(DecodedJWT jwt)
	{
		return UserPrincipal.builder().
				userId(Long.valueOf(jwt.getSubject())).
				username(jwt.getClaim("un").asString()).
				roles(exctractAuthoritiesFromClaim(jwt)).
				build();
	}

	private List <SimpleGrantedAuthority> exctractAuthoritiesFromClaim(DecodedJWT jwt)
	{
		var claim = jwt.getClaim("roles");
		if (claim.isNull() || claim.isMissing()) return List.of();
		return claim.asList(SimpleGrantedAuthority.class);
	}
}
