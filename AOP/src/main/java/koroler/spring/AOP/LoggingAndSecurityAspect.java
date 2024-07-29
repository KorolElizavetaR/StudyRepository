package koroler.spring.AOP;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
public class LoggingAndSecurityAspect {
	@Before("execution(public String get*(int))")
	public void beforeGetAdvice()
	{
		System.out.println("beforeGetAdvice!");
	}
}
