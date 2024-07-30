package koroler.spring.AspectOrientedProgramming;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@ConfigurationProperties("list")
public class Library {
	private final Integer CAPACITY = 8;
	List<Book> books;
	
	public void setBooks(List<Book> books) {
	this.books = new ArrayList<>();
		for (Book book: books)
		{
			this.books.add(book);
		}
	}
	
	public String getBook(Integer id)
	{
		return books.get(id).getName() + " by " + books.get(id).getAuthor();
	}
	
	public List<Book> getBooks()
	{
		return this.books;
	}
	
	public void getBooks(Boolean bool)
	{
		System.out.println("Library books:");
		for (Book book: books)
		System.out.println(book.getName() + " by " + book.getAuthor());
	}
	
	public Boolean addBook(AnnotationConfigApplicationContext context, String name, String author)
	{
		Book book = context.getBean(("books"), Book.class);
		if (books.size() >= CAPACITY)
		return false;
		book.setName(name);
		book.setAuthor(author);
		this.books.add(book);
		return true;
	}
}
