package koroler.spring.InitDestroy;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InitDestroyApplication {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		MusicPlayer player = context.getBean("musicPlayer", MusicPlayer.class);
		System.out.println(player.playMusic());
		context.close();
	}

}
