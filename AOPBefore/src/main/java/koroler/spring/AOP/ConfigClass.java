package koroler.spring.AOP;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("koroler.spring.AOP")
@PropertySource("classpath:application.properties")
@ConfigurationPropertiesScan 
@EnableAspectJAutoProxy (proxyTargetClass=true)
public class ConfigClass {
	@Bean
	@Scope ("prototype")
	public Book books()
	{
		return new Book();
	}
	
//	@Bean
//	public BookProperties bookProperties()
//	{
//		return new BookProperties();
//	}
	
	@Bean
	public UniversityLibrary uniLibrary()
	{
		return new UniversityLibrary();
	}
	
//	@Bean
//	public SchoolLibrary schoolLibrary()
//	{
//	return new SchoolLibrary();
//	}
//	
//	@Bean
//	public LoggingAspect logAspect()
//	{
//		return new LoggingAspect();
//	}

}
