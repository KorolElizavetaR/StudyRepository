package koroler.spring.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component ("musicPlayer")
public class MusicPlayer {
	private Music music;
	
//	@Autowired
//	public MusicPlayer (@Qualifier ("classicalMusic")Music music)
//	{
//		setMusic(music);
//	}
	
	@Autowired
	public void setMusic(@Qualifier ("metalMusic") Music music) {
		this.music = music;
	}
	
	public String PlayMusic()
	{
		return "Playing:" + music.getSong();
	}

}
