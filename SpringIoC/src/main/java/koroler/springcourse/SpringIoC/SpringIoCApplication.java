package koroler.springcourse.SpringIoC;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIoCApplication {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Music music = context.getBean("musicBean", Music.class);
		MusicPlayer player = new MusicPlayer(music);
		System.out.println(player.PlayMusic());
		context.close();
	}

}
