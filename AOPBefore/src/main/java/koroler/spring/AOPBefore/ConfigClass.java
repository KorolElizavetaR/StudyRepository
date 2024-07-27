package koroler.spring.AOPBefore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("koroler.spring.AOPBefore")
@EnableAspectJAutoProxy 
public class ConfigClass {
	
	@Bean
	public Library library()
	{
	return new Library();
	}

}
