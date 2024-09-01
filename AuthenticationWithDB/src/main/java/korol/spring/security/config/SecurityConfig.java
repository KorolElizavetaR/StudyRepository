package korol.spring.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.annotation.PostConstruct;
import korol.spring.security.services.PersonDetailsService;
import lombok.RequiredArgsConstructor;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
	private final PersonDetailsService persService;
	//private final AuthProvider authProvider;

	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		//auth.authenticationProvider(authProvider);
		auth.userDetailsService(persService);
	}
	
	@SuppressWarnings("deprecation")
	@Bean
	public PasswordEncoder getPasswordEncoder()
	{
		return NoOpPasswordEncoder.getInstance();
	}
}
