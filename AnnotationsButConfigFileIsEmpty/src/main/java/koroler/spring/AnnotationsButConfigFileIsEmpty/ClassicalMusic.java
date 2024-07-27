package koroler.spring.AnnotationsButConfigFileIsEmpty;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component ("classicalMusic")
public class ClassicalMusic implements Music{
	@Value("${classicalmusic.name}")
	String name;
	
	@Override
	public String getName() {
		return name;
	}

}
