package koroler.spring.AOPBefore;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopBeforeApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigClass.class);
		Library library = context.getBean("library", Library.class);
		System.out.println(library.getBook());
		context.close();
	}

}
