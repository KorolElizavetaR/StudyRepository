package koroler.spring.annotations;

import org.springframework.stereotype.Component;

@Component ("metalMusic")
public class MetalMusic implements Music{

	@Override
	public String getSong() {
		return "Metallica: Master of Puppets";
	}

}
