package koroler.spring.InitDestroy;

public class MusicPlayer {
	private Music music;
	private String RadioStationName;
	
	void init()
	{
		System.out.println("Preparing to turn on music player");
	}
	
	void destroy()
	{
		System.out.println("Shutting down");	
	}
	
	public MusicPlayer()
	{
		RadioStationName = null;
		music = null;
	}
	
	public MusicPlayer(Music music)
	{
		this();
		setMusic(music);
	}
	
	public MusicPlayer(Music music, String RadioStationName)
	{
		this(music);
		setRadioStationName(RadioStationName);
	}
	
	public void setMusic(Music music)
	{
		this.music = music;
	}
	
	public void setRadioStationName(String RadioStationName) {
		this.RadioStationName = RadioStationName;
	}
	
	public String playMusic()
	{
		return "Playing: " + music.getName() + "; Radio Station: " + RadioStationName;
	}

}
