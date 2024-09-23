package korol.rest.security.security;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import korol.rest.security.models.UserPrincipal;

public class UserPrincipleAuthToken extends AbstractAuthenticationToken {
	private final UserPrincipal principal;

	public UserPrincipleAuthToken(UserPrincipal principal) {
		super(principal.getAuthorities());
		this.principal = principal;
		setAuthenticated(true);
	}

	@Override
	public Object getCredentials() {
		return null;
	}

	@Override
	public UserPrincipal getPrincipal() {
		return principal;
	}

}
