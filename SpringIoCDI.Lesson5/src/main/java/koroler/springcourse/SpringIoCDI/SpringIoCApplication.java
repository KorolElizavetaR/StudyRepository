package koroler.springcourse.SpringIoCDI;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIoCApplication {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		MusicPlayer player = context.getBean("musicPlayer", MusicPlayer.class);
		System.out.println(player.PlayMusic());
		context.close();
	}

}
