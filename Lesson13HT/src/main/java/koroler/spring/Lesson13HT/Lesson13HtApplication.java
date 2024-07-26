package koroler.spring.Lesson13HT;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Lesson13HtApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigClass.class);
		MusicPlayer player = context.getBean("musicPlayer", MusicPlayer.class);
		System.out.println(player.PlayMusic());
		context.close();
	}

}
