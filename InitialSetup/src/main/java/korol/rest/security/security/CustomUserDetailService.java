package korol.rest.security.security;

import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import korol.rest.security.models.User;
import korol.rest.security.models.UserPrincipal;
import korol.rest.security.service.UserService;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
	private final UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.findByUsername(username).orElseThrow();
		return UserPrincipal.builder().
				userId(user.getId()).
				username(username).
				roles(List.of(new SimpleGrantedAuthority(user.getRole()))).
				password(user.getPassword()).
				build();
	}

}
