package koroler.Spring.IoCDI_DZ;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IoCdiDzApplication {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		MusicPlayer player = context.getBean("musicPlayer", MusicPlayer.class);
		System.out.println(player.playMusic());
		context.close();
	}

}
