package koroler.spring.Lesson13HT;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("koroler.spring.Lesson13HT")
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
	public KPopMusic kpopMusic()
	{
		return new KPopMusic();
	}
	
	@Bean
	public MusicPlayer musicPlayer()
	{
		return new MusicPlayer(new ArrayList<Music>(List.of(classicalMusic(), kpopMusic(), metalMusic())));
	}

}
