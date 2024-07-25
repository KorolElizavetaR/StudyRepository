package koroler.Spring.IoCDI_DZ;

import java.util.ArrayList;
import java.util.List;

public class MusicPlayer {
	private List<Music> music;
	private String RadioStationName;
	
	
	public MusicPlayer()
	{
		RadioStationName = null;
		music = null;
	}
	public MusicPlayer(List <Music> music)
	{
		this();
		setMusicList(music);
	}
	public MusicPlayer(List <Music> music, String RadioStationName)
	{
		this(music);
		setRadioStationName(RadioStationName);
	}
	
	public void setMusicList(List <Music> music)
	{
		this.music = new ArrayList<>();
		for (Music mus : music)
		{
			setMusicList(mus);
		}
	}
	public void setMusicList(Music music)
	{
		this.music.add(music);
	}
	
	public Music getMusicListTrack(int index)
	{
		return music.get(index);
	}
	
	public void setRadioStationName(String RadioStationName) {
		this.RadioStationName = RadioStationName;
	}
	
	public String playMusic()
	{
		String str = "";
		for (Music mus : music)
		{
		str += "Playing: " + mus.getName() + "; Radio Station: " + RadioStationName + "\n";
		}
		return str;
	}

}
