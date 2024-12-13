package koroler.spring.JavaAnnotationsOnly;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component ("musicPlayer")
public class MusicPlayer {
	private Music music;
	@Value("${radiostation.name}")
	String RadiostationName;
	
	public MusicPlayer(Music music)
	{
		setMusic(music);
	}
	//@Autowired
	//@Qualifier ("metalMusic")
	public void setMusic(Music music) {
		this.music = music;
	}
	
	public String PlayMusic()
	{
		return "Playing:" + music.getName() + ". Radio station: " + RadiostationName;
	}

}
