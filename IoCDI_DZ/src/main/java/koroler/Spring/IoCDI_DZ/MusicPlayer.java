package koroler.Spring.IoCDI_DZ;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

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
		this.music.add(mus);
	}
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
