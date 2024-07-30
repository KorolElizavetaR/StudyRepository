package koroler.spring.AspectOrientedProgramming;

import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("koroler.spring.AspectOrientedProgramming")
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
	
	@Bean
	public Library library()
	{
		return new Library();
	}
	
	@Bean
	public MyAspectClass myAspect()
	{
		return new MyAspectClass();
	}
}
