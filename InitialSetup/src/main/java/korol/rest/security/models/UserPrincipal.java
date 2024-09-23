package korol.rest.security.models;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Builder;
import lombok.Getter;

/*
 * 		Basic class that extends from UserDetails - Security Model. 
 * 		Probably would be good to make a model and pass it here
 */

@Getter 
@Builder
public class UserPrincipal implements UserDetails{
	private final long userId;
	private final String username;
	private final String password;
	private final  Collection<? extends GrantedAuthority> roles;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

}
