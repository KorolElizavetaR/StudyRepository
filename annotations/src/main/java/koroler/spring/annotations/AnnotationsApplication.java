package koroler.spring.annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationsApplication {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		MusicPlayer player = context.getBean("musicPlayer", MusicPlayer.class);
		System.out.println(player.PlayMusic());
		context.close();
	}

}
