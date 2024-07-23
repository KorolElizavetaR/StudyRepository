package koroler.springcourse.SpringIoCDI;

public class MusicPlayer {
	private Music music;
	private String RadioStationName;
	
	public MusicPlayer()
	{
		RadioStationName = null;
	}
	
	public MusicPlayer (Music music)
	{
		this();
		setMusic(music);
	}
	
	public MusicPlayer (Music music, String RadioStationName)
	{
		this(music);
		setRadioStationName(RadioStationName);
	}
	
	public void setMusic(Music music) {
		this.music = music;
	}
	
	public String PlayMusic()
	{
		return "Playing:" + music.getSong() +". RadioStationName: " + RadioStationName;
	}

	public void setRadioStationName(String RadioStationName) {
		this.RadioStationName = RadioStationName;
	}

}
