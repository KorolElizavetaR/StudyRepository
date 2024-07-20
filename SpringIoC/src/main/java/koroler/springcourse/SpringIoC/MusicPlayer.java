package koroler.springcourse.SpringIoC;

public class MusicPlayer {
	private Music music;
	
	public MusicPlayer (Music music)
	{
		this.music = music;
	}
	
	public String PlayMusic()
	{
		return "Playing:" + music.getSong();
	}
}
