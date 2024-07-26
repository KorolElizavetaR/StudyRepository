package koroler.spring.Lesson13HT;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class ClassicalMusic implements Music{
	@Value("${classicalmusic.name}")
	String name;
	
	@Override
	public String getName() {
		return name;
	}

}
