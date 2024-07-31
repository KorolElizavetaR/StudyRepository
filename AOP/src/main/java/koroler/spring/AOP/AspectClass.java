package koroler.spring.AOP;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

@Aspect
public class AspectClass {
	@Pointcut ("execution(* koroler.spring.AOP.Library.getBook(Integer))")
	private void PointcutForGetBook(){}
	
	@Pointcut ("execution(* koroler.spring.AOP.Library.add*(..))")
	private void PointcutForAddBook(){}

	@Pointcut ("execution(* koroler.spring.AOP.Library.getBooks())")
	private void PointcutForGetBooks(){}
	
	@Before ("execution(* koroler.spring.AOP.Library.*(..))")
	public void AnnoyingAdvice(List<Book> books)
	{
		System.out.println("Annoying Advice!");
	}
	
	@AfterReturning (pointcut = "PointcutForGetBooks()", returning = "books")
	public void AdviceSmallCase(List<Book> books)
	{
		for (Book book: books)
		{
			book.setAuthor(book.getAuthor().toLowerCase());
			book.setName(book.getName().toLowerCase());
		}
	}
	
//	@AfterThrowing (pointcut = "PointcutForGetBook()", throwing = "exc")
//	public void MyAdvice(JoinPoint jpoint, Throwable exc)
//	{
//		MethodSignature methodSignature = (MethodSignature)jpoint.getSignature();
//		System.out.println("methodSignature" + methodSignature);
//		if (methodSignature.getName().equals("getBook"))
//		{
//			Object [] arguments = jpoint.getArgs();
//			for (Object object: arguments)
//			{
//				if (object instanceof Integer)
//				{
//					System.out.println(exc);
//				}
//			}
//		}
//	}
	
//	@Before ("PointcutForAddBook()")
//	public void AdviceForGetBook(JoinPoint jpoint)
//	{
//		List<String> arr = new ArrayList<>();
//		Object [] arguments = jpoint.getArgs();
//		for (Object object: arguments)
//		{
//			if (object instanceof String)
//			{
//				arr.add((String) object);
//			}
//		}
//		System.out.println("\tAttempt to add:" + arr.get(0) + " by " + arr.get(1));
//	}
	
	@Around ("PointcutForAddBook()")
	public Object AdviceForAddBook(ProceedingJoinPoint jpoint) throws Throwable // JoinPoint joinpoint
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
		
		Object AddBookRes = jpoint.proceed();
		if ((Boolean) AddBookRes) System.out.println("\tBook succesfully added.");
		else System.out.println("\tLibrary is overloaded.");
		return AddBookRes;
	}
	
	@Around ("PointcutForGetBook()")
	public Object AroundAdviceForGetBook(ProceedingJoinPoint jpoint) throws Exception // JoinPoint joinpoint
	{
		Object[] objArr = jpoint.getArgs();
		Integer indexInteger = (Integer) objArr[0];//вообще так делать по-пидорски, в AdviceForAddBook лучше
		System.out.println("\tAttempt to get book...");
		
		Object GetBookRes = null;
		try
		{
			GetBookRes = jpoint.proceed();
			GetBookRes += (": #"+ indexInteger);
		}
		catch(Exception ex)
		{
			System.out.println(indexInteger + " is out of bounds. " + ex);
			//return "Book with index " + indexInteger + " is not in the DB.";
			throw ex;
		} 
		catch (Throwable e) {
			e.printStackTrace();
		}
		return GetBookRes;
	}
}
