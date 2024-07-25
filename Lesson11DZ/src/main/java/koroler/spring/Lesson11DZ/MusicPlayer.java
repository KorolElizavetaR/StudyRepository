package koroler.spring.Lesson11DZ;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component ("musicPlayer")
public class MusicPlayer {
	@Autowired
	@Qualifier ("classicalMusic")
	private ClassicalMusic classical;
	@Autowired
	@Qualifier ("metalMusic")
	private MetalMusic metal;
	
	public String PlayMusic(MusicGenre genre)
	{
		int randint = new Random().nextInt(3);
		switch(genre)
		{
		case METAL: return "Playing:" + metal.getSong(randint);
		case CLASSICAL: return "Playing:" + classical.getSong(randint);
		default: return "";
		}
	}

}
