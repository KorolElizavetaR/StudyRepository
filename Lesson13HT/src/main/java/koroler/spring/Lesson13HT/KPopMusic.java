package koroler.spring.Lesson13HT;

import org.springframework.beans.factory.annotation.Value;

public class KPopMusic implements Music{
	@Value("${kpopmusic.name}")
	String name;
	
	@Override
	public String getName() {
		return name;
	}
}
