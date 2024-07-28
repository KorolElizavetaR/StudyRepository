package koroler.spring.AOP;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopBeforeApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigClass.class);
		UniversityLibrary ulibrary = context.getBean("uniLibrary", UniversityLibrary.class);
		SchoolLibrary slibrary = context.getBean("schoolLibrary", SchoolLibrary.class);
		context.close();
	}

}
