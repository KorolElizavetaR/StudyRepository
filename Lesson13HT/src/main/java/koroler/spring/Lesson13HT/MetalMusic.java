package koroler.spring.Lesson13HT;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component ("metalMusic")
public class MetalMusic implements Music{
	@Value("${metalmusic.name}")
	String name;

	@Override
	public String getName() {
		return name;
	}

}
