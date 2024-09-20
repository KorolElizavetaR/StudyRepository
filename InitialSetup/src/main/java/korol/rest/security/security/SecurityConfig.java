package korol.rest.security.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
	private final JWTAuthFilter jwtAuthFilter;
	@Bean
	public SecurityFilterChain applicationSecurity(HttpSecurity http) throws Exception
	{
		http.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
		http.
			cors(cors -> cors.disable()).
			csrf(csrf -> csrf.disable()).
			sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)).
			formLogin(form -> form.disable()).
			securityMatcher("/**").
			authorizeHttpRequests(registry -> registry.requestMatchers("/", "/auth/login").permitAll().anyRequest().authenticated());
		return http.build();
	}
}
