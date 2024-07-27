package koroler.spring.AnnotationsButConfigFileIsEmpty;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("koroler.spring.AnnotationsButConfigFileIsEmpty")
@PropertySource("classpath:application.properties")
public class ConfigClass {
	
}
