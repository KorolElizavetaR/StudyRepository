package korol.rest.security.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain applicationSecurity(HttpSecurity http) throws Exception
	{
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
