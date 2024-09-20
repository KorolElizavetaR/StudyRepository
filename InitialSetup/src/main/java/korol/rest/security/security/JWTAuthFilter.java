package korol.rest.security.security;

import java.io.IOException;
import java.util.Optional;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JWTAuthFilter extends OncePerRequestFilter{
	private final JWTDecoder jwtDecoder;
	private final JWTToPrincipalConverter toPrincipal;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		extractTokenFromRequest(request).
			map(str->jwtDecoder.decode(str)).
			map(jwt -> toPrincipal.convert(jwt)).
			map(principal -> new UserPrincipleAuthToken(principal))
			.ifPresent(auth -> SecurityContextHolder.getContext().setAuthentication(auth));
		filterChain.doFilter(request, response);
	}
	
	private Optional<String> extractTokenFromRequest(HttpServletRequest request)
	{
		var	token = request.getHeader("Authorization");
		if (StringUtils.hasText(token)&& token.startsWith("Bearer "))
		{
			return Optional.of(token.substring(7));
		}
		return Optional.empty();
	}
}
