package koroler.spring.Lesson11DZ;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Lesson11DzApplication {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//Music music = context.getBean("classicalMusic", ClassicalMusic.class);
		//MusicPlayer player = new MusicPlayer(music);
		MusicPlayer player = context.getBean("musicPlayer", MusicPlayer.class);
		System.out.println(player.PlayMusic(MusicGenre.METAL));
		context.close();
	}

}
