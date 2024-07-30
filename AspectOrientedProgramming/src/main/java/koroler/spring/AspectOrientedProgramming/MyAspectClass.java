package koroler.spring.AspectOrientedProgramming;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAspectClass {
	@Before ("execution(* *(..)")
	public void AnnoyingAdvice()
	{
		System.out.println("Annoying Advice!");
	}
	
}
