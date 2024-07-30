package koroler.spring.AOP;

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
	
	@Bean
	public Library library()
	{
		return new Library();
	}
	
//	@Bean
//	public AspectClass myAspect()
//	{
//		return new AspectClass();
//	}
	
	@Bean
	public MyAspects aspects()
	{
		return new MyAspects();
	}

}
