package koroler.spring.AOP;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("koroler.spring.AOP")
@EnableAspectJAutoProxy (proxyTargetClass=true)
public class ConfigClass {
	@Bean
	@Scope ("Prototype")
	public Books books()
	{
		return new Books();
	}
	
	@Bean
	public UniversityLibrary uniLibrary()
	{
	return new UniversityLibrary();
	}
	
	@Bean
	public SchoolLibrary schoolLibrary()
	{
	return new SchoolLibrary();
	}
	
	@Bean
	public LoggingAspect logAspect()
	{
		return new LoggingAspect();
	}

}
