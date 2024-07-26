package koroler.spring.annotations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component ("metalMusic")
public class MetalMusic implements Music{
	String name;
	
	public MetalMusic(@Value("${metalmusic.name}") String name)
	{
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

}
