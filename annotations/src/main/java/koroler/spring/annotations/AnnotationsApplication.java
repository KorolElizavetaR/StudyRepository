package koroler.spring.annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationsApplication {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//Music music = context.getBean("classicalMusic", ClassicalMusic.class);
		//MusicPlayer player = new MusicPlayer(music);
		MusicPlayer player = context.getBean("musicPlayer", MusicPlayer.class);
		System.out.println(player.PlayMusic());
		context.close();
	}

}
