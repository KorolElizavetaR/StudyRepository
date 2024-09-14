package korol.spring.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.annotation.PostConstruct;
import korol.spring.security.services.PersonDetailsService;
import lombok.RequiredArgsConstructor;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
	private final PersonDetailsService persService;

	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.userDetailsService(persService).passwordEncoder(getPasswordEncoder());
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
	{
		// anyRequest().authenticated() - все остальные url требуют аутендефикации  // hasAnyRole("USER", "ADMIN")
		http.authorizeHttpRequests((requests) -> requests.requestMatchers("/admin").hasRole("ADMIN").requestMatchers("/home", "/error", "auth/reg").permitAll().anyRequest().authenticated()). //requestMatcher - дает доступ все к страницам
			formLogin((form) -> form.loginPage("/auth/login").defaultSuccessUrl("/hello", true).failureUrl("/auth/login?error").permitAll()).
			logout((logout) -> logout.permitAll());
		return http.build();
	}
}
