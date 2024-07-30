package koroler.spring.AOP;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

@Aspect
public class LoggingAndSecurityAspect {
	private static Integer booksGet = 0;
	@Pointcut ("execution(* koroler.spring.AOP.Library.getBook(Integer))")
	private void PointcutForGetBook(){}
	
	@Pointcut ("execution(* koroler.spring.AOP.Library.addBook(..))")
	private void PointcutForAddBook(){}
	
	@AfterReturning (pointcut = "execution(* koroler.spring.AOP.Library.getBooks())", returning = "books")
	public void AdviceSmallCase(List<Book> books)
	{
		System.out.println("awdawawdswda");
		for (Book book: books)
		{
			book.setAuthor(book.getAuthor().toLowerCase());
			book.setName(book.getName().toLowerCase());
		}
	}
	
	
	@AfterThrowing ("PointcutForGetBook()")
	public void MyAdvice(JoinPoint jpoint)
	{
		MethodSignature methodSignature = (MethodSignature)jpoint.getSignature();
		System.out.println("methodSignature" + methodSignature);
		if (methodSignature.getName().equals("getBook"))
		{
			Object [] arguments = jpoint.getArgs();
			for (Object object: arguments)
			{
				if (object instanceof Integer)
				{
					System.out.println(object + " is out of a range.");
				}
			}
		}
	}
	
	@Before ("PointcutForAddBook()")
	public void AdviceForGetBook(JoinPoint jpoint)
	{
		List<String> arr = new ArrayList<>();
		Object [] arguments = jpoint.getArgs();
		for (Object object: arguments)
		{
			if (object instanceof String)
			{
				arr.add((String) object);
			}
		}
		System.out.println("\tAttempt to add:" + arr.get(0) + " by " + arr.get(1));
	}
}
