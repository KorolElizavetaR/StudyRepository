package koroler.spring.JavaAnnotationsOnly;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("koroler.spring.JavaAnnotationsOnly")
@PropertySource("classpath:application.properties")
public class ConfigClass {
	@Bean
	public MetalMusic metalMusic()
	{
		return new MetalMusic();
	}
	
	@Bean
	public ClassicalMusic classicalMusic()
	{
		return new ClassicalMusic();
	}
	
	@Bean
	public MusicPlayer musicPlayer()
	{
		return new MusicPlayer();
	}

}
