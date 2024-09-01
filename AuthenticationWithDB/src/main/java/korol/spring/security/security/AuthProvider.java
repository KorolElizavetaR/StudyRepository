//package korol.spring.security.security;
//
//import java.util.Collection;
//import java.util.Collections;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
//import korol.spring.security.services.PersonDetailsService;
//import lombok.RequiredArgsConstructor;
//
//@RequiredArgsConstructor
//@Component
//public class AuthProvider implements AuthenticationProvider{
//	@Autowired
//	private final PersonDetailsService personDetailsServ;
//	
//	@Override
//	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//		String username = authentication.getName();
//		UserDetails personDet = personDetailsServ.loadUserByUsername(username);
//		String password = authentication.getCredentials().toString();
//		if (!password.equals(personDet.getPassword()))
//			throw new BadCredentialsException("Incorrect password");
//		return new UsernamePasswordAuthenticationToken(personDet, password, Collections.emptyList());
//	}
//
//	@Override
//	public boolean supports(Class<?> authentication) {
//		return true;
//	}
//}
