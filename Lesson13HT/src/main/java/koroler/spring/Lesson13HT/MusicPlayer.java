package koroler.spring.Lesson13HT;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Value;

public class MusicPlayer {
	private List<Music> music;
	
	@Value("${radiostation.name}")
	String RadiostationName;
	
	public MusicPlayer(ArrayList<Music> music)
	{
		this.music = new ArrayList<>();
		for (Music mus : music)
		{
			this.music.add(mus);
		}
	}
	
	public String PlayMusic()
	{
		return "Playing:" + music.get((new Random()).nextInt(3)).getName() + ". Radio station: " + RadiostationName;
	}

}
