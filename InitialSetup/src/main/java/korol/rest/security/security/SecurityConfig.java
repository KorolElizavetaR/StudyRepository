package korol.rest.security.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;

/*
 *		Security config 
 */

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
	private final JWTAuthFilter jwtAuthFilter;
	private final CustomUserDetailService customUserDetailService;
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
	
	@Bean
	public PasswordEncoder getPasswordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.userDetailsService(customUserDetailService).passwordEncoder(getPasswordEncoder());
	}
}
